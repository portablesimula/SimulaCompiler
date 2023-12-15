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
import java.util.function.Predicate;

import java.lang.classfile.ClassModel;
import java.lang.classfile.ClassTransform;
import java.lang.classfile.ClassFile;
import java.lang.classfile.MethodModel;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

public class ClassFileTransform {

	/**
	 * Repair a single .class file.
	 * 
	 * @param inputFileName  the input .class file name
	 * @param outputFileName the output .class file name
	 * @throws IOException if an I/O error occurs
	 */
	public static void doRepairSingleByteCode(final String inputFileName, final String outputFileName) throws IOException {
		if (Option.TRACE_REPAIRING)
			Util.TRACE("ClassFileTransform.doRepairSingleByteCode: Input = " + inputFileName);
		if (Option.LIST_INPUT_INSTRUCTION_LIST)
			Util.doListClassFile(inputFileName);
		FileInputStream inpt = new FileInputStream(inputFileName);
		byte[] bytes = inpt.readAllBytes();
		inpt.close();
		if (Option.TRACE_REPAIRING_INPUT)
			Util.TRACE("ClassFileTransform.doRepairSingleByteCode: Input=" + inputFileName);
		Util.IERR("UN-COMMENT FOLLOWING LINES ...");
//		ClassModel classModel = ClassFile.parse(bytes);
		ClassFile cf = ClassFile.of();
		ClassModel classModel = cf.parse(bytes);
		
		Predicate<MethodModel> filter = model -> (model.methodName().equalsString("_STM"));
		ClassTransform transform = ClassTransform.transformingMethodBodies(filter, new SimulaCodeTransform());
		if (transform != null) {
//			byte[] bytes2 = classModel.transform(transform);
			byte[] bytes2 = cf.transform(classModel, transform);
			if (Option.TRACE_REPAIRING_OUTPUT)
				Util.TRACE("ClassFileTransform.doRepairSingleByteCode: Output=" + outputFileName);
			FileOutputStream oupt = new FileOutputStream(outputFileName);
			oupt.write(bytes2);
			oupt.flush();
			oupt.close();
		} else
			Util.IERR("ClassFileTransform.doRepairSingleByteCode: _STM Method not found");
		if (Option.LIST_REPAIRED_INSTRUCTION_LIST)
			Util.doListClassFile(outputFileName);
	}

}
