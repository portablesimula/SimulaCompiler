/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

import org.apache.bcel.classfile.JavaClass;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * 
 * @author Øystein Myhre Andersen
 *
 */
public class SimulaCompiler {
	String inputFileName;

	public SimulaCompiler(String inputFileName) {
		Global.initiate();
		this.inputFileName = inputFileName;
		if (!inputFileName.toLowerCase().endsWith(".sim"))
			Util.error("Illegal File Name: " + inputFileName);

		File inputFile = new File(inputFileName);
		
		// Create Output File Path
		String name = inputFile.getName();
		Global.sourceName = name.substring(0, name.length() - 4);
		Global.sourceFileDir=inputFile.getParent()+"/";
		
		Util.TRACE("Source File:     "+inputFileName);
		
		if(Option.outputDir==null)
		     Global.outputDir=Global.sourceFileDir;	
		else Global.outputDir=Option.outputDir;
		
//		Global.simulaRtsPath=   "C:/WorkSpaces/SimulaCompiler/Simula/bin/";         // AD'HOC
//		String userDir=System.getProperty("user.dir");
//		Global.inlineRtsPath=userDir+"/bin/";         // AD'HOC

		// Create Temp .java-Files Directory:
		String main=Global.sourceName;
		if(Option.keepJava==null)
		{ String tmpJavaDirName=System.getProperty("java.io.tmpdir")+main+"Java";
		  File tmpJavaDir=new File(tmpJavaDirName);
		  tmpJavaDir.mkdirs();
		  tmpJavaDir.deleteOnExit();
		  Global.tempJavaFileDir=tmpJavaDir.toString()+'/';
		} else Global.tempJavaFileDir=Option.keepJava+'/';
		
		// Create Temp .class-Files Directory:
		String tmpClassDirName=System.getProperty("java.io.tmpdir")+main+"Classes";
		File tmpClassDir=new File(tmpClassDirName);
		tmpClassDir.mkdirs();
		tmpClassDir.deleteOnExit();
		Global.tempClassFileDir=tmpClassDir.toString()+'/';

		if(Option.verbose)
		{ Util.TRACE("SourceFile Name: "+Global.sourceName);
		  Util.TRACE("SourceFile Dir:  "+Global.sourceFileDir);
		  Util.TRACE("TempDir .Java:   "+Global.tempJavaFileDir);
		  Util.TRACE("TempDir .Class:  "+Global.tempClassFileDir);
		  Util.TRACE("SimulaRtsLib:    "+Global.simulaRtsLib);
		  Util.TRACE("OutputDir:       "+Global.outputDir);
		}
		// https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
//		Util.TRACE("SYSTEM: SIMULA_HOME="+System.getenv("SIMULA_HOME"));
//		Util.TRACE("SYSTEM: SIMULA_HOME="+Global.SIMULA_HOME);
		Util.TRACE("SYSTEM: java.home="+System.getProperty("java.home"));
		Util.TRACE("SYSTEM: java.class.path="+System.getProperty("java.class.path"));
		Util.TRACE("SYSTEM: path.separator="+System.getProperty("path.separator"));
		Util.TRACE("SYSTEM: User working directory="+System.getProperty("user.dir"));
		Util.TRACE("SYSTEM: User home directory="+System.getProperty("user.home"));
	}

	public void doCompile() {
		try {
			Global.javaModules=new Vector<JavaModule>();
			
			Parser.open(inputFileName);
			ProgramModule program = new ProgramModule();
//			createTempFiles(program);
			if (Option.verbose) {
				Util.BREAK("*** END Parsing, resulting Program: "+program);
				//if (program != null) program.print("", ";");
			}
			
			if (Option.verbose)	Util.BREAK("*** BEGIN Semantic Checker");
			program.doChecking();
			if (Option.verbose) {
				Util.BREAK("*** END Semantic Checker: "+program);
				if (Option.TRACE_CHECKER_OUTPUT && program != null) program.print("", ";");
			}

			if (Option.verbose) Util.BREAK("*** BEGIN Generate .java Output Code"); 
			program.doJavaCoding("");
			if (Option.verbose)
			{ Util.BREAK("*** END Generate .java Output Code");
			    for(JavaModule module:Global.javaModules)
			      	Util.LIST(module.javaOutputFileName);
			}
			
			if (Option.verbose) Util.BREAK("*** BEGIN Possible Generate AttributeFile");
			AttributeFile.write(program);
			
			// ***************************************************************
			// *** CALL JAVAC COMPILER
			// ***************************************************************
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			if(compiler!=null) callJavaSystemCompiler(compiler);
			else callJavacCompiler();
			
			if(Option.TRACE_JAVAC_OUTPUT)
			{ for(JavaModule module:Global.javaModules)
			  {	String classFile=module.getClassOutputFileName();
			    JavaClass javaClass=ClassFileUtilities.load(classFile);
			    ClassFileUtilities.list(module.javaOutputFileName,javaClass);
			  }
			}

			// ***************************************************************
			// *** CRERATE .jar FILE  INLINE
			// ***************************************************************
			String jarFile=createJarFile(program);
			if(Option.TRACE_JARING) listJarFile(jarFile);
			
			// ***************************************************************
			// *** EXECUTE .jar FILE
			// ***************************************************************
			// java -jar C:/WorkSpaces/SimulaCompiler/Simula/bin/adHoc00.jar
			if(!program.isExecutable() || Option.noexec) { if(Option.verbose) Util.TRACE("No Execution of .jar File: "+jarFile); }
			else
			{ if(Option.verbose) Util.TRACE("Execute .jar File");
			  String opt="";
			  if(Global.simulaRtsLib!=null) opt=opt+"-classpath "+Global.simulaRtsLib;
			  //Util.BREAK("SimulaCompiler.doCompile: EXECUTE opt="+opt);
			  String cmd="java "+opt+" -jar "+jarFile;
			  //Util.BREAK("SimulaCompiler.doCompile: EXECUTE cmd="+cmd);
			  int exitValue3=execute(cmd);
			  if (Option.verbose)
			     Util.TRACE("*** END Execute .jar File. Exit value="+exitValue3);
			}

		} catch (IOException e) {
			System.out.println("Compiler Error: "+e);
			e.printStackTrace();
		}
	}
	
	// ***************************************************************
	// *** CALL JAVA SYSTEM COMPILER
	// ***************************************************************
	private void callJavaSystemCompiler(JavaCompiler compiler) throws IOException
	{ if(Option.verbose) Util.TRACE("Call Java Compiler");
	  Vector<String> arguments=new Vector<String>();
	  if(Option.TRACE_JAVAC) {  arguments.add("-version"); arguments.add("-verbose"); }
//	  arguments.add("-classpath"); arguments.add(Global.simulaRtsPath);
	  arguments.add("-classpath"); arguments.add(Global.simulaRtsLib);
	  arguments.add("-d"); arguments.add(Global.tempClassFileDir); // Specifies output directory.
	  if(Option.nowarn) arguments.add("-nowarn");
	  //arguments.add("-Xlint:unchecked");
      for(JavaModule module:Global.javaModules) arguments.add(module.javaOutputFileName); // Add .jave Files
	  
	  // java.home=C:\Program Files\Java\jre1.8.0_161
	  if(Option.TRACE_JAVAC) Util.BREAK("Compiler="+compiler);
	  if(compiler==null) Util.FATAL_ERROR("SimulaCompiler.callJavaSystemCompiler: ToolProvider.getSystemJavaCompiler() returns null");
	  int nArg=arguments.size();
	  String[] args=new String[nArg];
			  arguments.toArray(args);
			  
	  if(Option.TRACE_JAVAC) { for(int i=0;i<args.length;i++) Util.BREAK("Compiler'args["+i+"]="+args[i]); }

	  int exitValue = compiler.run(null, null, null, args);
	  if (Option.verbose)
	  { Util.TRACE("*** END Generate .class Output Code. Exit value="+exitValue);
	    for(JavaModule module:Global.javaModules) Util.LIST(module.getClassOutputFileName());
	  }
	}
	
	// ***************************************************************
	// *** CALL JAVAC COMPILER
	//
	// https://docs.oracle.com/javase/7/docs/technotes/tools/windows/javac.html
	// https://docs.oracle.com/javase/10/tools/tools-and-command-reference.htm
	// ***************************************************************
	private void callJavacCompiler() throws IOException
	{ if(Option.verbose) Util.TRACE("Call Java Compiler");
	  StringBuilder source=new StringBuilder();;
      for(JavaModule module:Global.javaModules) source.append(' ').append(module.javaOutputFileName);
      if(Option.verbose) Util.BREAK("SimulaCompiler.doCompile: source="+source);
	  String javac=Global.javaDir+"javac.exe";
	
	  //String classPath=" -classpath "+Global.tempClassFileDir;
//	  String classPath=" -classpath "+Global.simulaRtsPath;
	  String classPath=" -classpath "+Global.simulaRtsLib;
	  
	  // *** TODO: Hvis tempClassFileDir ikke finnes - CREATE !
	  String classOutputDir=" -d "+Global.tempClassFileDir; 
	
	  if(Option.TRACE_JAVAC)
	  { Util.BREAK("SimulaCompiler.doCompile JAVAC: classPath="+classPath);
	    Util.BREAK("SimulaCompiler.doCompile JAVAC: source="+source);
	    Util.BREAK("SimulaCompiler.doCompile JAVAC: classOutputDir="+classOutputDir);
	  }
	  String opt=(Option.TRACE_JAVAC)?" -verbose":"";
	  //opt=opt+" -Xlint:unchecked";
	  opt=opt+classOutputDir;
	  String command=javac+opt+classPath+source;
	  int exitValue=execute(command);
	  
	  if (Option.verbose)
	  { Util.TRACE("*** END Generate .class Output Code. Exit value="+exitValue);
	    for(JavaModule module:Global.javaModules) Util.LIST(module.getClassOutputFileName());
	  }
	}

	
	// ***************************************************************
	// *** CREATE .jar FILE
	// ***************************************************************
	public String createJarFile(ProgramModule program) throws IOException
//	public String createJarFile() throws IOException
	{ if(Option.verbose) Util.BREAK("*** BEGIN Create .jar File");
	  //String main=program.getIdentifier();
	  String main=Global.sourceName;
	  String jarFile=Global.outputDir+main+".jar ";
	  Manifest manifest=new Manifest();
	  String mainEntry=Global.packetName+'/'+main;
	  mainEntry=mainEntry.replace('/', '.');
	  if(Option.verbose) Util.TRACE("Output "+jarFile+" MANIFEST'mainEntry="+mainEntry);
	  manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
	  String relativeAttributeFileName=program.getRelativeAttributeFileName();
	  if(relativeAttributeFileName!=null) manifest.getMainAttributes().putValue("SIMULA-INFO",relativeAttributeFileName);
	  else manifest.getMainAttributes().put(Attributes.Name.MAIN_CLASS,mainEntry);
	  JarOutputStream target = new JarOutputStream(new FileOutputStream(jarFile), manifest);
	  add(target,new File(Global.tempClassFileDir+Global.packetName),Global.tempClassFileDir.length());
	  if(Option.INCLUDE_RUNTIME_SYSTEM_IN_JAR)
	  { add(target,new File(Global.simulaRtsLib+"simula/runtime"),Global.simulaRtsLib.length());
	    add(target,new File(Global.simulaRtsLib+"simula/compiler/utilities/Util.class"),Global.simulaRtsLib.length());
	    add(target,new File(Global.simulaRtsLib+"simula/compiler/utilities/Option.class"),Global.simulaRtsLib.length());
	  }
	  target.close();
	  if(Option.verbose) Util.BREAK("*** END Create .jar File: "+jarFile);
	  return(jarFile);
	}

	private void add(JarOutputStream target,File source,int pathSize ) throws IOException
	{ BufferedInputStream inpt=null;
	  try
	  { if(source.isDirectory())
	    { String name = source.getPath().replace("\\", "/");
	      if(!name.isEmpty())
	      { if (!name.endsWith("/")) name += "/";
	        JarEntry entry = new JarEntry(name.substring(pathSize));
	        entry.setTime(source.lastModified());
	        target.putNextEntry(entry);
	        target.closeEntry();
	      }
	      for(File nestedFile:source.listFiles())
	          add(target,nestedFile,pathSize);
	      return;
	    }
        String entryName=source.getPath().replace("\\", "/");
	    JarEntry entry = new JarEntry(entryName.substring(pathSize));
	    entry.setTime(source.lastModified());
	    target.putNextEntry(entry);
	    inpt = new BufferedInputStream(new FileInputStream(source));
	    byte[] buffer=new byte[1024];
	    while(true)
	    { int count=inpt.read(buffer);
	      if(count == -1) break; // EOF
	      target.write(buffer,0,count);
	    }
	    target.closeEntry();
	  } finally { if(inpt!=null) inpt.close(); }
	}
	
	// ***************************************************************
	// *** LIST .jar FILE
	// ***************************************************************
	// jar -tvf C:/WorkSpaces/SimulaCompiler/Simula/bin/adHoc00.jar : <
	private void listJarFile(String jarFile) throws IOException
	{ if(Option.TRACE_JARING) Util.BREAK("List .jar File: "+jarFile);
	  String jar=Global.javaDir+"jar.exe";
	  if(Option.TRACE_JARING) execute(jar+" -tvf "+jarFile);
	}
	
	// ***************************************************************
	// *** EXECUTE OS COMMAND
	// ***************************************************************
	private int execute(String command) throws IOException
	{	Runtime runtime = Runtime.getRuntime();
	    if(Option.TRACE_JAVAC) Util.BREAK("SimulaCompiler.doCompile: EXECUTE command="+command);
	    String cmd=command.trim()+'\n';
		Process process = runtime.exec(cmd);
		//try
		{ InputStream err=process.getErrorStream();
		  InputStream inp=process.getInputStream();
		  while(process.isAlive())
		  { while(err.available()>0) System.err.append((char)err.read());
		    while(inp.available()>0) System.out.append((char)inp.read());
			
		  }
		  // process.waitFor();
		} //catch(InterruptedException e) { e.printStackTrace(); }
		return(process.exitValue());
	}

}
