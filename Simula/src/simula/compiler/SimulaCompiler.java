/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler;

import java.lang.Runtime;

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
	private File jarFile;
	private String mainEntry;
	
	public SimulaCompiler(final String inputFileName) {
		this(inputFileName,null);
	}
	
	public SimulaCompiler(final String inputFileName,Reader reader) {
		Global.initiate();
		this.inputFileName = inputFileName;
		if(reader==null) {
			try { reader=new InputStreamReader(new FileInputStream(inputFileName),Global.CHARSET$);
			} catch (IOException e) {
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
		Global.sourceName = name.substring(0, name.length() - 4);
		Global.sourceFileDir=inputFile.getParentFile();
		
		if(Option.TRACING) Util.message("Compiling: \""+inputFileName+"\"");
		
		if(Global.outputDir==null) {
		     Global.trySetOutputDir(new File(Global.sourceFileDir,"bin"));
		}

		// Get Temp Directory:
		Global.simulaTempDir=Global.getTempFileDir("simula/");
		//Global.simulaTempDir.deleteOnExit();
		deleteTempFiles(Global.simulaTempDir);

		// Create Temp .java-Files Directory:
		File javatmp=Option.keepJava;
		if(javatmp==null) javatmp=Global.simulaTempDir;
		File tmpJavaDir=new File(javatmp,"src/"+Global.packetName);
		tmpJavaDir.mkdirs();
		Global.tempJavaFileDir=tmpJavaDir;

		// Create Temp .class-Files Directory:
		File tmpClassDir=new File(Global.simulaTempDir,"classes");
		tmpClassDir.mkdirs();
		Global.tempClassFileDir=tmpClassDir;

		File desktop=new File(System.getProperty("user.home"),"Desktop");
		if(Option.verbose) {
			// https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
			Util.message("------------  ENVIRONMENT SUMMARY  ------------");
			Util.message("Simula Properties    "+Global.simulaPropertiesFile);
			Util.message("Simula Home          "+Global.simulaHome);
			Util.message("Simula Home (prev)   "+Global.getProperty("simula.home",null));
			Util.message("Java Home            "+System.getProperty("java.home"));
			Util.message("User Home            "+System.getProperty("user.home"));
			String s=(desktop.exists())?"true ":"false";
			Util.message("Desktop Exists="+s+" "+desktop.toString());
			Util.message("Java Class Path      "+System.getProperty("java.class.path"));
			Util.message("Java Class Version   "+System.getProperty("java.class.version"));
			Util.message("Java Version         "+System.getProperty("java.version"));
//			Util.message("Java VM Version      "+System.getProperty("java.vm.version"));
			Util.message("Java VM Spec Version "+System.getProperty("java.vm.specification.version"));
//			Util.message("Java Spec Version    "+System.getProperty("java.version"));
			Util.message("Java Vendor          "+System.getProperty("java.vendor"));
			Util.message("OS name              "+System.getProperty("os.name"));
			Util.message("OS architecture      "+System.getProperty("os.arch"));
			Util.message("OS version           "+System.getProperty("os.version"));
			Util.message("32/64 bit JVM        "+System.getProperty("sun.arch.data.model"));
			Util.message("file.encoding        "+System.getProperty("file.encoding"));
			Util.message("defaultCharset       "+Charset.defaultCharset());

			// this will list the current system properties
		    //  System.getProperties().list(System.out);

		}
	}
	
	private void list(final File tempClassFileDir) {
		try {
			Util.message("------------  LIST "+tempClassFileDir+"  ------------");
			list("",tempClassFileDir);
		} catch (Exception e) { Util.INTERNAL_ERROR("SimulaCompiler.listFiles FAILED: ", e); e.printStackTrace(); }
	}
	
	private void list(String indent,final File dir) {
		try {
			File[] elt = dir.listFiles();
			if(elt==null || elt.length==0) {
				Util.println("Empty Directory: "+dir);
				return; 
			}
			for (File f : elt) {
				Util.println(indent+"- "+f);
				if(f.isDirectory()) list(indent+"   ",f);
			}
		} catch (Exception e) { Util.INTERNAL_ERROR("SimulaCompiler.listFiles FAILED: ", e);e.printStackTrace(); }
	}
	
	private void deleteTempFiles(final File tmpClass) {
		try { File[] elt = tmpClass.listFiles();
			  if(elt==null) return; 
			  for (File f : elt) {
				  if(Option.DEBUGGING) {
					  if(f.isFile()) Util.println("Delete: "+f);
				  }
				  if(f.isDirectory()) deleteTempFiles(f);
				  f.delete();
			  }
		} catch (Exception e) { Util.INTERNAL_ERROR("SimulaCompiler.deleteFiles FAILED: ", e);	e.printStackTrace(); }
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
			      	Util.LIST(module.javaOutputFile.toString());
			}
			if(Util.nError>0) {
				Util.message("Compiler terminated after "+Util.nError+" errors during code generation");
				return;
			}
			
			if (Option.TRACING) Util.message("BEGIN Possible Generate AttributeFile");
			AttributeFile.write(programModule);
			
			// ***************************************************************
			// *** CALL JAVA COMPILER
			// ***************************************************************
			String classPath=Global.simulaRtsLib.toString();			
			
			if(Option.verbose) fileSummary();
			if(Option.DEBUGGING) {
				Util.message("------------  CLASSPATH DETAILS  ------------");
				Util.message("Java PathSeparator "+System.getProperty("path.separator"));
				Util.message("Java ClassPath     "+System.getProperty("java.class.path"));
			}
			
			File rtsLib=new File(Global.simulaRtsLib,"simula/runtime");
			boolean rtsExist=rtsLib.exists();
			boolean rtsCread=rtsLib.canRead();
			if(!(rtsExist && rtsCread)) {
				Util.popUpError("Unable to access the Runtime System at:"
					     +"\n"+rtsLib
					     +"\nCheck the installation and consider"
					     +"\nto Download it again.\n");
			}
			if(Option.DEBUGGING) {
				Util.message("Simula Runtime System:    \""+rtsLib+"\", exists="+rtsExist+", canRead="+rtsCread);
				String[] list=rtsLib.list(); 
				if(list!=null) {
					Util.message("Simula Runtime System:    \""+rtsLib+"\", exists="+rtsExist+", canRead="+rtsCread+", size="+list.length);
					for(int i=0;i<list.length;i++) {
						Util.message("       "+i+": \""+list[i]+"\"");
					}
				}
			}
			
			String pathSeparator=System.getProperty("path.separator");
			for(File jarFile:Global.externalJarFiles) {
				if(Option.DEBUGGING) {
					boolean exist=jarFile.exists();
					boolean cread=jarFile.canRead();
					Util.message("Precompiled Library:      \""+jarFile+"\", exists="+exist+", canRead="+cread);
					listJarFile(jarFile);
				}
				classPath=classPath+pathSeparator+(jarFile.toString().trim());
			}
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
			if(Option.DEBUGGING) {
				Util.message("Java "+msg+" Compiler returns exit="+exitValue+"\n");
				for (JavaModule module : Global.javaModules)
					Util.LIST(module.getClassOutputFileName());
				list(Global.tempClassFileDir);
			}
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
			File classDir=Global.tempClassFileDir;
			//repairClassFiles(classDir);
			ArrayList<String> files=classFiles(classDir,new ArrayList<String>());
			for(String classFileName:files) {
				new ByteCodeEngineering().doRepairSingleByteCode(classFileName);
			}
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
			if(Option.verbose) printSummary();
			
			
			// ***************************************************************
			// *** EXECUTE .jar FILE
			// ***************************************************************
			if(!programModule.isExecutable() || Option.noExecution) {
				if(Option.TRACING) Util.message("Separate Compilation - No Execution of .jar File: "+jarFile);
			} else {
				if(Option.verbose) Util.message("------------  EXECUTION SUMMARY  ------------");
				if(Option.TRACING) Util.message("Execute .jar File");
				String opt="";
				String arg=RTOption.getRTArguments();
				String cmd="java "+opt+" -jar "+jarFile+arg;
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
		arguments.add("-d"); arguments.add(Global.tempClassFileDir.toString()); // Specifies output directory.
		if (Option.noJavacWarnings)
			arguments.add("-nowarn");
		// arguments.add("-Xlint:unchecked");
		for (JavaModule module : Global.javaModules)
			arguments.add(module.javaOutputFile.toString()); // Add .java Files
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
		}
		int exitValue = compiler.run(in, out, err, args);
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
		for (JavaModule module : Global.javaModules)
			cmd.append(' ').append(module.javaOutputFile.toString()); // Add .java Files
		if(Option.DEBUGGING) {
			Util.message("------------  Call Java Command Line Compiler  ------------");
			Util.message("javac"+cmd);
			list(Global.tempClassFileDir);
		}
		int exitValue = execute("javac"+cmd);
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
		jarFile = new File(Global.outputDir,program.getIdentifier()+".jar");
		jarFile.getParentFile().mkdirs();
		if (!program.isExecutable()) {
			Util.warning("Separate Compiled Module is written to: \"" + jarFile+"\"");
		}
		Manifest manifest = new Manifest();
		mainEntry = Global.packetName + '/' + program.getIdentifier();
		mainEntry = mainEntry.replace('/', '.');
		if (Option.TRACING)
			Util.message("Output " + jarFile + " MANIFEST'mainEntry=\"" + mainEntry+"\"");
		manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
		manifest.getMainAttributes().putValue("Created-By",Global.simulaReleaseID+" (Portable Simula)");
		if(program.isExecutable()) {
			manifest.getMainAttributes().put(Attributes.Name.MAIN_CLASS, mainEntry);
		} else {
			String relativeAttributeFileName = program.getRelativeAttributeFileName();
			if (relativeAttributeFileName != null)
			manifest.getMainAttributes().putValue("SIMULA-INFO", relativeAttributeFileName);
		}
		
		JarOutputStream target = new JarOutputStream(new FileOutputStream(jarFile), manifest);
		add(target, new File(Global.tempClassFileDir,Global.packetName), Global.tempClassFileDir.toString().length());
		add(target, new File(Global.simulaRtsLib,"simula/common"), Global.simulaRtsLib.toString().length());
		if (Global.INCLUDE_RUNTIME_SYSTEM_IN_JAR) {
			add(target, new File(Global.simulaRtsLib,"simula/runtime"), Global.simulaRtsLib.toString().length());
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
					name=name.substring(pathSize);
					if (name.startsWith("/")) name=name.substring(1);
					JarEntry entry = new JarEntry(name);
					entry.setTime(source.lastModified());
					target.putNextEntry(entry);
					target.closeEntry();
				}
				for (File nestedFile : source.listFiles())
					add(target, nestedFile, pathSize);
				return;
			}
			String entryName = source.getPath().replace("\\", "/");
			if (!entryName.endsWith(".jasm")) {
				entryName=entryName.substring(pathSize);
				if (entryName.startsWith("/")) entryName=entryName.substring(1);
				JarEntry entry = new JarEntry(entryName);
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
	// *** FILE SUMMARY
	// ***************************************************************
	private void fileSummary() {
		Util.message("------------  FILE SUMMARY  ------------");
		Util.message("Package Name:    \""+Global.packetName+"\"");
		Util.message("SourceFile Name: \""+Global.sourceName+"\"");
		Util.message("SourceFile Dir:  \""+Global.sourceFileDir+"\"");
		Util.message("CurrentWorkspace \""+Global.currentWorkspace+"\"");
		Util.message("TempDir .java:   \""+Global.tempJavaFileDir+"\"");
		Util.message("TempDir .class:  \""+Global.tempClassFileDir+"\"");
		Util.message("SimulaRtsLib:    \""+Global.simulaRtsLib+"\"");
		Util.message("OutputDir:       \""+Global.outputDir+"\"");
	}
	
	// ***************************************************************
	// *** PRINT SUMMARY
	// ***************************************************************
	private void printSummary() {
		Util.message("------------  COMPILATION SUMMARY  ------------");
		if (!programModule.isExecutable()) {
			Util.message("Separate Compiled "+programModule.module.declarationKind+" is written to: \"" + jarFile+"\"");
			Util.message("Rel Attr.File:   \""+programModule.getRelativeAttributeFileName()+"\"");
		} else {
			Util.message("Resulting File:  \"" + jarFile+"\"");
			Util.message("Main Entry:      \"" + mainEntry+"\"");
		}
		if(Option.DEBUGGING) listJarFile(jarFile);
	}

	// ***************************************************************
	// *** LIST .jar file
	// ***************************************************************
	private static void listJarFile(final File file) {
		Util.message("---------  LIST .jar File: "+file+"  ---------");
		if(!(file.exists() && file.canRead())) {
			Util.error("Can't read .jar file: "+file);	return;
	    }
		JarFile jarFile=null;
	    try { jarFile=new JarFile(file);
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
		}
		if(error.length()>0) Util.error(error.toString());
		return (process.exitValue());
	}

}
