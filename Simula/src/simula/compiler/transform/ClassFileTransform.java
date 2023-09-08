/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.transform;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.Predicate;

//import java.lang.classfile.ClassModel;
//import java.lang.classfile.ClassTransform;
//import java.lang.classfile.Classfile;
//import java.lang.classfile.MethodModel;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

public class ClassFileTransform {
	
	/**
	 * Repair a single .class file.
	 * 
	 * @param inputFileName the input .class file name
	 * @param outputFileName the output .class file name
	 * @throws IOException if an I/O error occurs
	 */
	public static void doRepairSingleByteCode(final String inputFileName,final String outputFileName) throws IOException {
		if(Option.TRACE_REPAIRING) Util.TRACE("ClassFileTransform.doRepairSingleByteCode: +++++++++++++++++++++++++++++ Input = "+inputFileName);
		if(Option.LIST_INPUT_INSTRUCTION_LIST) doListClassFile(inputFileName);
		FileInputStream inpt=new FileInputStream(inputFileName);
		byte[] bytes=inpt.readAllBytes(); inpt.close();

        if(Option.TRACE_REPAIRING_INPUT) Util.TRACE("ClassFileTransform.doRepairSingleByteCode: Input="+inputFileName);
        Util.IERR("UN-COMMENT FOLLOWING LINES ...");
//		ClassModel classModel = Classfile.parse(bytes);
//		Predicate<MethodModel> filter = model -> (model.methodName().equalsString("_STM"));
//		ClassTransform transform = ClassTransform.transformingMethodBodies(filter, new SimulaCodeTransform());
//		if(transform != null) {
//			byte[] bytes3=classModel.transform(transform);
//			if(Option.TRACE_REPAIRING_OUTPUT) Util.TRACE("ClassFileTransform.doRepairSingleByteCode: Output="+outputFileName);
//			FileOutputStream oupt=new FileOutputStream(outputFileName);
//			oupt.write(bytes3); oupt.flush(); oupt.close();
//		} else Util.IERR("ClassFileTransform.doRepairSingleByteCode: _STM Method not found");
//		if(Option.LIST_REPAIRED_INSTRUCTION_LIST) doListClassFile(outputFileName);
	}
	
	public static void doListClassFile(final String classFileName) {
		try { execute("javap","-c","-l","-p","-s","-verbose",classFileName);
		} catch (IOException e) { e.printStackTrace(); }
	}

	// ***************************************************************
	// *** EXECUTE OS COMMAND
	// ***************************************************************
	/**
	 * Execute an OS command
	 * @param cmdarray command array
	 * @return exit value
	 * @throws IOException if an I/O error occurs
	 */
	public static int execute(final String... cmdarray) throws IOException {
		Runtime runtime = Runtime.getRuntime();
//		if (Option.verbose) {
			String line="";
			for(int i=0;i<cmdarray.length;i++) line=line+" "+cmdarray[i];
			Util.TRACE("Execute: " + line);
//		}
		Process process = runtime.exec(cmdarray);
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
//				if(Global.console != null) Global.console.write(""+(char) inp.read());
//				else
					System.out.append((char) inp.read());
			}
		}
//		if(error.length()>0) Util.error(error.toString());
		if(error.length()>0) Util.TRACE(error.toString());
		return (process.exitValue());
	}


}
