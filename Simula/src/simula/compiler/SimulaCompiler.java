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
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.attribute.FileTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Set;
import java.util.Vector;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import simula.compiler.byteCodeEngineering.ByteCodeEngineering;
import simula.compiler.editor.RTOption;
import simula.compiler.parsing.Parser;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class SimulaCompiler {
	final String inputFileName;
	final Reader reader; // Reader in case of SimulaEditor
	
	private ProgramModule programModule;
	private String jarFileName;
	private String mainEntry;
	
	public SimulaCompiler(final String inputFileName) {
		this(inputFileName,null);
	}
	
	public SimulaCompiler(final String inputFileName,Reader reader) {
		Global.initiate();
		Util.CHECK_FILENAME(inputFileName);
		//Util.BREAK("Compile: "+inputFileName);
		this.inputFileName = inputFileName;
		if(reader==null) {
			try { reader=new InputStreamReader(new FileInputStream(inputFileName),Global.CHARSET$);
			} catch (IOException e) {
				//Util.println("Error Opening File: " + fileName);
				//e.printStackTrace();
				Util.error("can't open " + inputFileName+", reason: "+e);
			}
		}
		this.reader=reader;
		if (!inputFileName.toLowerCase().endsWith(".sim"))
			Util.warning("Simula source file should, by convention be extended by .sim: " + inputFileName);

		File inputFile = new File(inputFileName);
		
		// Create Output File Path
		String name = inputFile.getName();
		Global.sourceFileName=name;
		Util.CHECK_FILENAME(Global.sourceFileName);
		Global.sourceName = name.substring(0, name.length() - 4);
		Global.sourceFileDir=inputFile.getParent()+"/";
		
		if(Option.TRACING) Util.message("Compiling: \""+inputFileName+"\"");
		
		if(Option.outputDir==null)
		     Global.outputDir=Global.sourceFileDir+"bin/";	
		else Global.outputDir=Option.outputDir;
//		Util.message("Option.outputDir:       \""+Option.outputDir+"\"");
//		Util.message("Global.outputDir:       \""+Global.outputDir+"\"");

		// Get Temp Directory:
//		String simtmp=Option.keepJava;
//		if(simtmp==null) simtmp=Global.getTempFileDir("simula/");
		Global.simulaTempDir=Global.getTempFileDir("simula/");
		//Global.simulaTempDir.deleteOnExit();
		deleteTempFiles(Global.simulaTempDir);

		// Create Temp .java-Files Directory:
		String javatmp=Option.keepJava;
		if(javatmp==null) javatmp=Global.simulaTempDir;
		String tmpJavaDirName=javatmp+"/src/"+Global.packetName;
		File tmpJavaDir=new File(tmpJavaDirName);
		tmpJavaDir.mkdirs();
		Global.tempJavaFileDir=tmpJavaDir.toString()+'/';

		// Create Temp .class-Files Directory:
		File tmpClassDir=new File(Global.simulaTempDir+"/classes");
		tmpClassDir.mkdirs();
		Global.tempClassFileDir=tmpClassDir.toString()+'/';

		if(Option.verbose) {
			// https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
			Util.message("------------  ENVIRONMENT SUMMARY  ------------");
			Util.message("Simula Home      "+Global.getProperty("simula.home",null));
			Util.message("Java Home        "+System.getProperty("java.home"));
			Util.message("Java version     "+System.getProperty("java.version"));
			Util.message("Java vendor      "+System.getProperty("java.vendor"));
			Util.message("OS name          "+System.getProperty("os.name"));
			Util.message("OS architecture  "+System.getProperty("os.arch"));
			Util.message("OS version       "+System.getProperty("os.version"));
			Util.message("file.encoding    "+System.getProperty("file.encoding"));
			Util.message("defaultCharset   "+Charset.defaultCharset());
		}
	}
	
	private void list(final String dirName) {
		try {
			Util.message("------------  LIST "+dirName+"  ------------");
			list("",new File(dirName));
		} catch (Exception e) { Util.INTERNAL_ERROR("SimulaCompiler.listFiles FAILED: ", e); e.printStackTrace(); }
	}
	
	private void list(String indent,final File dir) {
		try {
			//Util.println("tmpClass: "+dir);
			File[] elt = dir.listFiles();
			if(elt==null || elt.length==0) {
				Util.println("Empty Directory: "+dir);
				return; 
			}
			Util.println("Elements: "+elt.length);
			for (File f : elt) {
				Util.println(indent+"- "+f);
				if(f.isDirectory()) list(indent+"   ",f);
			}
		} catch (Exception e) { Util.INTERNAL_ERROR("SimulaCompiler.listFiles FAILED: ", e);e.printStackTrace(); }
	}
	
	private void deleteTempFiles(final String dirName) {
		//if(Option.DEBUGGING) Util.message("Clean up Directory: "+dirName);
		try { // Try to Clean Global.simulaTempDir
			  File tmpClass = new File(dirName);
			  // Util.println("tmpClass: "+tmpClass);
			  File[] elt = tmpClass.listFiles();
			  // Util.println("Elements: "+elt);
			  if(elt==null) return; 
			  for (File f : elt) {
				  if(Option.DEBUGGING) {
					  if(f.isFile()) Util.println("Delete: "+f);
				  }
				  if(f.isDirectory()) deleteTempFiles(f.getPath());
				  f.delete();
			  }
		} catch (Exception e) { Util.INTERNAL_ERROR("SimulaCompiler.deleteFiles FAILED: ", e);	e.printStackTrace(); }
		//list(dirName);
	}

	public void doCompile() {
		try {
			Util.nError=0;
			if(!Util.isJavaIdentifier(Global.sourceName)) {
				String sourceName=Global.sourceName; 
				Global.sourceName=Util.makeJavaIdentifier(sourceName);
				Util.warning("The source file name '"+sourceName+"' is not a legal class identifier. Modified to: "+Global.sourceName);
			}
			// ***************************************************************
			// *** Scanning and Parsing
			// ***************************************************************
			Global.javaModules=new Vector<JavaModule>();
			Parser.open(reader);
			programModule = new ProgramModule();
			if (Option.TRACING) {
				Util.message("END Parsing, resulting Program: \""+programModule+"\"");
				if (Option.TRACE_PARSE && programModule != null) programModule.print(0);
			}
			Parser.close(); Global.duringParsing=false;
			if(Util.nError>0) {
				Util.message("Compiler terminated after "+Util.nError+" errors during parsing");
				return;
			}
			// ***************************************************************
			// *** Semantic Checker
			// ***************************************************************
			if (Option.TRACING)	Util.message("BEGIN Semantic Checker");
			//program.print(0);
			programModule.doChecking();
			if (Option.TRACING) {
				Util.message("END Semantic Checker: \""+programModule+"\"");
				if (Option.TRACE_CHECKER_OUTPUT && programModule != null)	programModule.print(0);
			}
			if(Util.nError>0) {
				Util.message("Compiler terminated after "+Util.nError+" errors during semantic checking");
				return;
			}
			// ***************************************************************
			// *** Generate .java intermediate code
			// ***************************************************************
			if (Option.TRACING) Util.message("BEGIN Generate .java Output Code"); 
			programModule.doJavaCoding();
			if (Option.TRACING)	{
				Util.message("END Generate .java Output Code");
			    for(JavaModule module:Global.javaModules)
			      	Util.LIST(module.javaOutputFileName);
			}
			
			if (Option.TRACING) Util.message("BEGIN Possible Generate AttributeFile");
			AttributeFile.write(programModule);
			
			// ***************************************************************
			// *** CALL JAVA COMPILER
			// ***************************************************************
			String classPath=Global.simulaRtsLib;
			if(Option.verbose) {
				Util.message("------------  CLASSPATH DETAILS  ------------");
				File rtsLib=new File(Global.simulaRtsLib+"/simula/runtime");
				boolean exist=rtsLib.exists();
				boolean cread=rtsLib.canRead();
		      	String[] list=rtsLib.list(); 
				Util.message("Simula Runtime System:    \""+rtsLib+"\", exists="+exist+", canRead="+cread+", size="+list.length);
				for(int i=0;i<list.length;i++) {
					Util.message("       "+i+": \""+list[i]+"\"");
				}
			}
			
			for(String jar:Global.externalJarFiles) {
				Util.CHECK_FILENAME(jar);
				File jarFile=new File(jar);
				boolean exist=jarFile.exists();
				boolean cread=jarFile.canRead();
				Util.message("Precompiled Library:      \""+jar+"\", exists="+exist+", canRead="+cread);
				listJarFile(jar);
//				classPath=classPath+";"+jar;
				classPath=classPath+";"+(jar.trim());
			}
			//callJavaCompiler(classPath);
			int exitValue= -1;
			String msg="Commandline";
			if(Global.USE_JAVA_SYSTEM_COMPILER) {
				JavaCompiler compiler= ToolProvider.getSystemJavaCompiler();
				if(compiler!=null) {
					exitValue=callJavaSystemCompiler(compiler,classPath);
					msg="System";
					if(exitValue!=0) {
						Util.error("Java "+msg+" Compiler returns exit="+exitValue+"\n");
						msg="Commandline"; // Try use CommandLine Compiler
						exitValue=callJavacCompiler(classPath);
					}
				}
				else exitValue=callJavacCompiler(classPath);
			} else exitValue=callJavacCompiler(classPath);
			if(exitValue!=0) {
				Util.error("Java "+msg+" Compiler returns exit="+exitValue+"\n");
				Util.message("\nCompiler terminated after error(s) during Java Compilation");
				return;
			}

			// ***************************************************************
			// *** POSSIBLE -- DO BYTE_CODE_ENGINEERING
			// ***************************************************************
			if(Option.TRACE_BYTECODE_OUTPUT) {
				Util.message("------------  LIST ByteCode Before Engineering  ------------");
				for(JavaModule module:Global.javaModules) {
					String classFile=module.getClassOutputFileName();
					doListClassFile(classFile);
				}
			}
			//Util.println("SimulaCompiler.doCompile: BEGIN BYTE CODE REPAIR: "+Global.tempClassFileDir);
			File classDir=new File(Global.tempClassFileDir);
			//repairClassFiles(classDir);
			ArrayList<String> files=classFiles(classDir,new ArrayList<String>());
			for(String classFileName:files) {
				Util.CHECK_FILENAME(classFileName);
				//Util.println("SimulaCompiler.doCompile: Repair: "+classFileName);
				new ByteCodeEngineering().doRepairSingleByteCode(classFileName);
			}

		    //doListClassFile("C:/Users/YSTEIN~1/AppData/Local/Temp/GotoSample6Classes/testing/GotoSample6$B$1.class"); // AD'HOC
			if(Option.TRACE_BYTECODE_OUTPUT) {
				Util.message("------------  LIST ByteCode After Engineering  ------------");
				for(JavaModule module:Global.javaModules) {
					String classFile=module.getClassOutputFileName();
					doListClassFile(classFile);
				}
			}
			

			// ***************************************************************
			// *** CRERATE .jar FILE  INLINE
			// ***************************************************************
			String jarFile=createJarFile(programModule);
//			if(Option.TRACE_JARING)	{
//				Util.println("List .jar File: "+jarFile);
//			    execute("jar.exe -tvf "+jarFile);
//			}
			if(Option.verbose) printSummary();
//			if(Option.DEBUGGING) Util.message("------------  CLEANING UP TEMP FILES  ------------");
//			deleteTempFiles(Global.simulaTempDir);
			
			
			// ***************************************************************
			// *** EXECUTE .jar FILE
			// ***************************************************************
			// java -jar C:/WorkSpaces/SimulaCompiler/Simula/bin/adHoc00.jar

			if(!programModule.isExecutable() || Option.noExecution) {
				if(Option.TRACING) Util.message("Separate Compilation - No Execution of .jar File: "+jarFile);
			} else {
				if(Option.verbose) Util.message("------------  EXECUTION SUMMARY  ------------");
				if(Option.TRACING) Util.message("Execute .jar File");
			
				String opt="";
				//if(Global.simulaRtsLib!=null) opt=opt+"-classpath "+Global.simulaRtsLib;
				//Util.BREAK("SimulaCompiler.doCompile: EXECUTE opt="+opt);
			  
				String arg=RTOption.getRTArguments();
				//Util.BREAK("SimulaCompiler.doCompile: EXECUTE arg="+arg);
			  
				String cmd="java "+opt+" -jar "+jarFile+arg;
			  
				//Util.BREAK("SimulaCompiler.doCompile: EXECUTE cmd="+cmd);
				if (Option.verbose)	Util.message("Execute: "+cmd);
				int exitValue3=execute(cmd);
				if (Option.verbose)	Util.message("END Execute .jar File. Exit value="+exitValue3);
			}
			if(Option.DEBUGGING) Util.message("------------  CLEANING UP TEMP FILES  ------------");
			deleteTempFiles(Global.simulaTempDir);
			
		} catch (IOException e) {
			Util.INTERNAL_ERROR("Compiler Error: ",e);
		}
	}

	
	// ***************************************************************
	// *** CREATE CLASS FILE LIST
	// ***************************************************************
	private ArrayList<String> classFiles(final File folder,final ArrayList<String> files) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				classFiles(fileEntry,files);
			} else {
				String classFileName = fileEntry.getPath();
				Util.CHECK_FILENAME(classFileName);
				//Util.println(classFileName);
				if(classFileName.endsWith(".class")) {
					if(!files.contains(classFileName)) files.add(classFileName);
				}
			}
		}
		return(files);
	}
	
	// ***************************************************************
	// *** CALL JAVA SYSTEM COMPILER
	// ***************************************************************
	private int callJavaSystemCompiler(final JavaCompiler compiler,final String classPath) throws IOException {
		Vector<String> arguments = new Vector<String>();
		if (Option.DEBUGGING) {
			arguments.add("-version");
			//arguments.add("-verbose");
		}
		if (Option.TRACING)	Util.println("SimulaCompiler.callJavaSystemCompiler: classPath=\"" + classPath+"\"");
		arguments.add("-classpath"); arguments.add(classPath);
		arguments.add("-d"); arguments.add(Global.tempClassFileDir); // Specifies output directory.
		if (Option.noJavacWarnings)
			arguments.add("-nowarn");
		// arguments.add("-Xlint:unchecked");
		// arguments.add("-BareTull");
		for (JavaModule module : Global.javaModules)
			arguments.add(module.javaOutputFileName); // Add .java Files
		int nArg = arguments.size();
		String[] args = new String[nArg];
		arguments.toArray(args);
		
		InputStream in=System.in;
		OutputStream out=System.out;
		OutputStream err=System.err;
		if(Global.console!=null) {
			out=Global.console.getOutputStream();
			err=Global.console.getErrorStream();
		}
		if(Option.DEBUGGING) Util.message("------------  Call Java System Compiler  ------------");
		if(Option.DEBUGGING) {
			Util.message("System Compiler supports " + compiler.getSourceVersions());
			for (int i = 0; i < args.length; i++)
				Util.println("Compiler'args[" + i + "]=" + args[i]);
			list(Global.tempClassFileDir);
		}
		int exitValue = compiler.run(in, out, err, args);
//		if(Option.DEBUGGING) {
//			Util.message("System Compiler supports " + compiler.getSourceVersions());
//			for (int i = 0; i < args.length; i++)
//				Util.println("Compiler'args[" + i + "]=" + args[i]);
//			list(Global.tempClassFileDir);
//		}
		if (Option.TRACING) {
			Util.message("END Generate .class Output Code. Exit value=" + exitValue);
			for (JavaModule module : Global.javaModules)
				Util.LIST(module.getClassOutputFileName());
		}
		return(exitValue);
	}
	
	
	// ***************************************************************
	// *** CALL JAVA COMMAND LINE COMPILER
	//
	// https://docs.oracle.com/javase/7/docs/technotes/tools/windows/javac.html
	// https://docs.oracle.com/javase/10/tools/tools-and-command-reference.htm
	// ***************************************************************
	private int callJavacCompiler(final String classPath) throws IOException {
		StringBuilder cmd=new StringBuilder();
		if (Option.DEBUGGING) {
			cmd.append(" -version");
			//cmd.append(" -verbose");
		}
		if (Option.TRACING)	Util.println("SimulaCompiler.callJavacCompiler: classPath=\"" + classPath+"\"");
		cmd.append(" -classpath ").append(classPath);
		cmd.append(" -d ").append(Global.tempClassFileDir); // Specifies output directory.
		if (Option.noJavacWarnings)	cmd.append(" -nowarn");
		// cmd.append(" -Xlint:unchecked");
		
//		cmd.append(" -myeMereTull");
		
		for (JavaModule module : Global.javaModules)
			cmd.append(' ').append(module.javaOutputFileName); // Add .java Files
		int exitValue = execute("javac.exe"+cmd);
		if(Option.DEBUGGING) {
			Util.message("------------  Call Java Command Line Compiler  ------------");
			Util.message("javac.exe"+cmd);
			list(Global.tempClassFileDir);
		}
		if (Option.TRACING) {
			Util.message("END Generate .class Output Code. Exit value=" + exitValue);
			for (JavaModule module : Global.javaModules)
				Util.LIST(module.getClassOutputFileName());
		}
		return(exitValue);
	}
	
	// ***************************************************************
	// *** CREATE .jar FILE
	// ***************************************************************
	private String createJarFile(final ProgramModule program) throws IOException {
		if (Option.TRACING)	Util.message("BEGIN Create .jar File");
		jarFileName = Global.outputDir + program.getIdentifier() + ".jar";

		if (!program.isExecutable()) {
			// Util.BREAK("SimulaCompiler.createJarFile: program="+program);
//			jarFileName = Global.outputDir + program.getIdentifier() + ".jar ";
			Util.warning("Separate Compiled Module is written to: \"" + jarFileName+"\"");
		}
		Util.CHECK_FILENAME(jarFileName);
		File jarFile = new File(jarFileName);
		jarFile.getParentFile().mkdirs();
		Manifest manifest = new Manifest();
		mainEntry = Global.packetName + '/' + program.getIdentifier();
		mainEntry = mainEntry.replace('/', '.');
		Util.CHECK_FILENAME(mainEntry);
		if (Option.TRACING)
			Util.message("Output " + jarFile + " MANIFEST'mainEntry=\"" + mainEntry+"\"");
		manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
		manifest.getMainAttributes().putValue("Created-By",Global.simulaReleaseID+" (Portable Simula)");
		String relativeAttributeFileName = program.getRelativeAttributeFileName();
		Util.CHECK_FILENAME(relativeAttributeFileName);
		if (relativeAttributeFileName != null)
			manifest.getMainAttributes().putValue("SIMULA-INFO", relativeAttributeFileName);
		else
			manifest.getMainAttributes().put(Attributes.Name.MAIN_CLASS, mainEntry);
		JarOutputStream target = new JarOutputStream(new FileOutputStream(jarFile), manifest);
		add(target, new File(Global.tempClassFileDir + Global.packetName), Global.tempClassFileDir.length());
		// // Add External Jar Files
		// for(ExternalJarFile jf:ExternalJarFile.ExternalJarFiles)
		// addExternalJar(target,jf.jarFileName);

		add(target, new File(Global.simulaRtsLib + "simula/common"), Global.simulaRtsLib.length());
		if (Global.INCLUDE_RUNTIME_SYSTEM_IN_JAR) {
			add(target, new File(Global.simulaRtsLib + "simula/runtime"), Global.simulaRtsLib.length());
			// add(target,new File(Global.simulaRtsLib+"simula/compiler/utilities/Util.class"),Global.simulaRtsLib.length());
			// add(target,new File(Global.simulaRtsLib+"simula/compiler/utilities/Option.class"),Global.simulaRtsLib.length());
		}
		target.close();
		if (Option.TRACING)	Util.message("END Create .jar File: " + jarFile);
		return (jarFile.toString());
	}

	private void add(final JarOutputStream target,final File source,final int pathSize) throws IOException {
		BufferedInputStream inpt = null;
		try {
			if (source.isDirectory()) {
				String name = source.getPath().replace("\\", "/");
				if (!name.isEmpty()) {
					if (!name.endsWith("/")) name += "/";
					JarEntry entry = new JarEntry(name.substring(pathSize));
					entry.setTime(source.lastModified());
					target.putNextEntry(entry);
					target.closeEntry();
				}
				for (File nestedFile : source.listFiles())
					add(target, nestedFile, pathSize);
				return;
			}
			String entryName = source.getPath().replace("\\", "/");
			// Util.println("SimulaCompiler.add: "+entryName);
			if (!entryName.endsWith(".jasm")) {
				JarEntry entry = new JarEntry(entryName.substring(pathSize));
				entry.setTime(source.lastModified());
				target.putNextEntry(entry);
				inpt = new BufferedInputStream(new FileInputStream(source));
				byte[] buffer = new byte[1024];
				while (true) {
					int count = inpt.read(buffer);
					if (count == -1) break; // EOF
					target.write(buffer, 0, count);
				}
				target.closeEntry();
			}
		} finally {
			if (inpt != null) inpt.close();
		}
	}
	
	// ***************************************************************
	// *** PRINT SUMMARY
	// ***************************************************************
	private void printSummary() {
		Util.message("------------  COMPILATION SUMMARY  ------------");
		Util.message("Package Name:    \""+Global.packetName+"\"");
		Util.message("SourceFile Name: \""+Global.sourceName+"\"");
		Util.message("SourceFile Dir:  \""+Global.sourceFileDir+"\"");
		Util.message("CurrentWorkspace \""+Global.currentWorkspace+"\"");
		Util.message("TempDir .Java:   \""+Global.tempJavaFileDir+"\"");
		Util.message("TempDir .Class:  \""+Global.tempClassFileDir+"\"");
		Util.message("SimulaRtsLib:    \""+Global.simulaRtsLib+"\"");
		Util.message("OutputDir:       \""+Global.outputDir+"\"");
		
		
		if (!programModule.isExecutable()) {
			Util.message("Separate Compiled "+programModule.module.blockKind+" is written to: \"" + jarFileName+"\"");
			Util.message("Rel Attr.File:   \""+programModule.getRelativeAttributeFileName()+"\"");
		} else {
			Util.message("Resulting File:  \"" + jarFileName+"\"");
			Util.message("Main Entry:      \"" + mainEntry+"\"");
		}
//		list("Global.tempClassFileDir" + '/' + "Global.packetName");
		if(Option.DEBUGGING) listJarFile(jarFileName);
	}

	// ***************************************************************
	// *** LIST .jar file
	// ***************************************************************
	private static void listJarFile(final String jarFileName) {
		Util.message("---------  LIST .jar File: "+jarFileName+"  ---------");
		File file=new File(jarFileName);
		JarFile jarFile=null;
        //Util.message("SimulaCompiler.listJarFile: "+jarFileName);
		if(!(file.exists() && file.canRead())) {
			Util.error("Can't read .jar file: "+file);	return;
	    }
	    //Util.message("SimulaCompiler.listJarFile: "+jarFileName);
	    try { jarFile=new JarFile(jarFileName);
	        //Util.message("SimulaCompiler.listJarFile: "+jarFileName);
		
	        Manifest manifest=jarFile.getManifest();
	        Attributes mainAttributes=manifest.getMainAttributes();
	        Set<Object> keys=mainAttributes.keySet();
	        for(Object key:keys) {
		        String val=mainAttributes.getValue(key.toString());
		        Util.message(key.toString()+"=\""+val+"\"");
	        }
	        
	        Enumeration<JarEntry> entries=jarFile.entries();
	        while(entries.hasMoreElements()) {
	        	JarEntry entry=entries.nextElement();
	        	String size=""+entry.getSize();
	        	while(size.length()<6) size=" "+size;
	        	FileTime fileTime=entry.getLastModifiedTime();
	        	String date = DateTimeFormatter.ofPattern("uuuu-MMM-dd HH:mm:ss", Locale.getDefault())
	        			    .withZone(ZoneId.systemDefault()).format(fileTime.toInstant());
	        	Util.message("Jar-Entry: "+size+"  "+date+"  \""+entry+"\"");
	        }
	        //jarFile.close();
	    } catch(IOException e) {
	    	Util.INTERNAL_ERROR("Caused by:",e);
        } finally {
        	if(jarFile!=null)
				try { jarFile.close(); } catch (IOException e) { e.printStackTrace(); }
	    }
	}
	
	// ***************************************************************
	// *** LIST .class file
	// ***************************************************************
	public static void doListClassFile(final String classFileName) {
		Util.CHECK_FILENAME(classFileName);
		String command = "javap -c -l -p -s -verbose " + classFileName;
		try { execute(command);
		} catch (IOException e) { Util.INTERNAL_ERROR("Impossible",e); }
	}

	// ***************************************************************
	// *** EXECUTE OS COMMAND
	// ***************************************************************
	public static int execute(final String command) throws IOException {
		Runtime runtime = Runtime.getRuntime();
		if (Option.TRACING)	Util.message("Execute: " + command);
		String cmd = command.trim() + '\n';
		Process process = runtime.exec(cmd);
		InputStream err = process.getErrorStream();
		InputStream inp = process.getInputStream();
//		OutputStream out = process.getOutputStream();
		StringBuilder error=new StringBuilder();
		while (process.isAlive()) {
			while (err.available() > 0) {
				char c=(char)err.read();
				System.err.append(c);
				error.append(c);
			}
			while (inp.available() > 0) {
				if(Global.console != null) Global.console.write(""+(char) inp.read());
				else System.out.append((char) inp.read());
			}
//			while (System.in.available() > 0) {
//				int c=System.in.read();
//				System.out.println("Pipe character: c="+(char)c);
//				out.write(c);
//			}
		}
		if(error.length()>0) Util.error(error.toString());
		
//		StringBuilder error=new StringBuilder();
//		StringBuilder output=new StringBuilder();
//		// get the error stream of the process and print it
//		InputStream err = process.getErrorStream();
//		InputStream inp = process.getInputStream();
//		while (process.isAlive()) {
//			while(err.available() > 0) error.append((char)err.read());
//			while(inp.available() > 0) output.append((char)inp.read());
//		}
//		if (Option.TRACING) {
////			if(error.length()>0) Util.message("Error: " + error.toString());
//			if(error.length()>0) Util.error("\""+error.toString()+"\"");
//			if(output.length()>0) Util.message("Output: " + output.toString());
//		} else {
//			if(error.length()>0) System.err.append("Error: " + error.toString());
//			if(output.length()>0) System.out.append(output.toString());			
//		}
		
		return (process.exitValue());
	}

}
