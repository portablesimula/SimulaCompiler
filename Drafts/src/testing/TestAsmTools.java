package testing;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import org.openjdk.asmtools.jdis.uEscWriter;



//  Usage: java -jar asmtools.jar jasm [options] file.jasm...
//  where possible options include:
//     -d destdir   directory to place resulting .class files
//     -g   add debug information
//     -v   add trace information
//     -nowrite     do not write resulting .class files
//     -nowarn   do not print warnings
//     -strict   consider warnings as errors
//     -cv major.minor  set operating class file version (by default 45.3)
//     -version   prints the program version

public class TestAsmTools {
	public static void main(String[] args) {
//		String inptFileName="C:\\GitHub\\SimulaCompiler\\Simula\\bin\\simulaTestPrograms\\Sudoku$PBLK1$SQ$legit.class";
		String inptFileName="C:/GitHub/SimulaCompiler/Simula/bin/simulaTestPrograms/simulaTestPrograms/adHoc00.class";
		String ouptFileName="C:/GitHub/SimulaCompiler/Simula/src/simulaTestPrograms/jdis/Sudoku$PBLK1$SQ$legit.jdis";
//		String ouptClassFileName="C:/GitHub/SimulaCompiler/Simula/src/simulaTestPrograms/jdis/Sudoku$PBLK1$SQ$legit.class";
		String ouptClassFileName="C:/GitHub/SimulaCompiler/Simula/src/simulaTestPrograms/jdis/Sudoku$PBLK1$SQ$legit";
		
		runJavaDisassembler(inptFileName,ouptFileName); // Jdis
		runJavaAssembler(ouptFileName,ouptClassFileName); // Jdis
		//runJavaLowlevelDisassembler(inptFileName,ouptFileName); // Jdec
		
	}
	
	public static void runJavaDisassembler(String inptFileName,String ouptFileName) {
		// Jdis is a disassembler that accepts a .class file,
		// and prints the plain-text translation of jasm source file to the output.
		// See: https://wiki.openjdk.java.net/display/CodeTools/Chapter+2#Chapter2-Jasm.1
		// JASM Syntax: https://wiki.openjdk.java.net/display/CodeTools/Appendix+A
//		String[] argd= {"-version", "-g", inptFileName};
		String[] argd= {"-version", inptFileName};
    	File file=new File(ouptFileName);
    	file.getParentFile().mkdirs();
    	try {
    		OutputStream outputStream=new FileOutputStream(file);
    		BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(outputStream);
    		org.openjdk.asmtools.jdis.Main disassembler
    		= new org.openjdk.asmtools.jdis.Main(new PrintWriter(new uEscWriter(bufferedOutputStream)), "jdis");
            boolean result = disassembler.disasm(argd);
    		bufferedOutputStream.flush();
    		bufferedOutputStream.close();
        	System.out.println("DONE: TestAsmTools: result="+result); // MYH
        	System.err.println("DONE: TestAsmTools: result="+result); // MYH
    	} catch(Exception e) { e.printStackTrace(); }
	}
	
	public static void runJavaAssembler(String inptFileName,String ouptFileDir) {
		// Jasm is an assembler that accepts a text file based on the JASM Specification,
		// and produces a .class file for use with a Java Virtual Machine.
		// See: https://wiki.openjdk.java.net/display/CodeTools/Chapter+2#Chapter2-Jasm.1
		// JASM Syntax: https://wiki.openjdk.java.net/display/CodeTools/Appendix+A
		//
		// Options:
		//	-version   	Print jasm tool version
		//	-d destdir	Specifies a directory to place resulting .class files. If a destdir is not provided, the .class file will be written in the current directory.
		//	-g			Add debug information to .class file
		//	-nowrite	Do not write resulting .class files. This option may be used to verify the integrity of your source jasm file
		//	-strict		Consider warnings as errors.
		//	-nowarn		Do not print warnings.
		//	-cv major.minor	Set the operating class file version (by default 45.3).
		//	Note - If the optional class attribute 'version' defines (in source of class) the class file version, then it overrides default class file version set by -cv option.
		//
//		String[] argd= {"-version", "-g", inptFileName};
		String[] argd= {"-version", "-d", ouptFileDir, "-XdAll", inptFileName};
    	File file=new File(ouptFileDir);
    	file.getParentFile().mkdirs();
    	try {
    		OutputStream outputStream=new FileOutputStream(file);
    		BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(outputStream);
    		org.openjdk.asmtools.jasm.Main assembler
    		= new org.openjdk.asmtools.jasm.Main(new PrintStream(bufferedOutputStream), "jasm");
            boolean result = assembler.compile(argd);
    		bufferedOutputStream.flush();
    		bufferedOutputStream.close();
        	System.out.println("DONE: JavaAssembler: result="+result); // MYH
        	System.err.println("DONE: JavaAssembler: result="+result); // MYH
    	} catch(Exception e) { e.printStackTrace(); }
	}
	
	public static void runJavaLowlevelDisassembler(String inptFileName,String ouptFileName) {
		// Jdec is a low-level disassembler that accepts .class file and prints
		// a plain text of jcod source file to the standard output.
		// See: https://wiki.openjdk.java.net/display/CodeTools/Chapter+2#Chapter2-Jasm.1
		// JCOD Syntax: https://wiki.openjdk.java.net/display/CodeTools/Appendix+B
		String[] argd= {"-version", "-g", inptFileName};
//		String[] argd= {"-version", inptFileName};
    	File file=new File(ouptFileName);
    	file.getParentFile().mkdirs();
    	try {
    		OutputStream outputStream=new FileOutputStream(file);
    		BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(outputStream);
    		org.openjdk.asmtools.jdec.Main disassembler
    		= new org.openjdk.asmtools.jdec.Main(new PrintWriter(new uEscWriter(bufferedOutputStream)), "jdec");
            boolean result = disassembler.decode(argd);
    		bufferedOutputStream.flush();
    		bufferedOutputStream.close();
        	System.out.println("DONE: TestAsmTools: result="+result); // MYH
        	System.err.println("DONE: TestAsmTools: result="+result); // MYH
    	} catch(Exception e) { e.printStackTrace(); }
	}
	
	public static void traceMYH(String msg,String[] args) {
		System.err.println(msg);
		int lng=args.length;
		for(int i=0;i<lng;i++)
    	System.err.println("TestAsmTools, args["+i+"]="+args[i]);
	}
	
	public static void traceMYH(String msg) {
		System.err.println(msg);
	}
}
