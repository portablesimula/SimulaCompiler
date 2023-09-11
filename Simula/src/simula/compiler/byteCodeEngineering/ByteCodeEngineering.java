/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.byteCodeEngineering;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.util.CheckClassAdapter;

import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Based on the 'ASM' Java bytecode manipulation and analysis framework. 
 * <p>
 * Main page: https://asm.ow2.io/index.html
 * <p>
 * Wikipedia: https://en.wikipedia.org/wiki/ObjectWeb_ASM
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/byteCodeEngineering/ByteCodeEngineering.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class ByteCodeEngineering {
	/**
	 * List ASM code on/off
	 */
	private static final boolean LIST_ASM_CODE = false;
	/**
	 * DEBUG on/off
	 */
	private static final boolean DEBUG = false;

	/**
	 * Create a new ByteCodeEngineering.
	 */
	public ByteCodeEngineering() {
	}

	/**
	 * Repair a single .class file.
	 * 
	 * @param classFileName the .class file name
	 */
	public void doRepairSingleByteCode(String classFileName) {
		InputStream inputStream = null;
		try {
			File file = new File(classFileName);
			String fileName = file.getName();
			if (Option.TRACE_REPAIRING)
				Util.println("ByteCodeEngineering.doRepairSingleByteCode: Load " + classFileName);
			if (LIST_ASM_CODE)
				Util.doListClassFile(classFileName);
			inputStream = new FileInputStream(classFileName);
			ClassReader classReader = new ClassReader(inputStream);
			ClassWriter classWriter = new ExtendedClassWriter(classReader, ClassWriter.COMPUTE_FRAMES);
			// classVisitor forwards all events to classWriter
			ClassVisitor classVisitor;
			if (DEBUG) {
				classWriter = new ExtendedClassWriter(classReader, ClassWriter.COMPUTE_FRAMES);
				classVisitor = new CheckClassAdapter(new SimClassVisitor(fileName, classWriter), true);
			} else
				classVisitor = new SimClassVisitor(fileName, classWriter);
			classReader.accept(classVisitor, 0); // ClassReader will call methods in classWriter
			if (DEBUG)
				Util.println("ByteCodeEngineering.doRepairSingleByteCode: AFTER  classReader.accept(classVisitor, 0);");
			// Dump the class to <classFileName>
			if (Option.TRACE_REPAIRING)
				Util.println("ByteCodeEngineering.doRepairSingleByteCode: Dump " + classFileName);
			byte[] b2 = classWriter.toByteArray(); // b2 represents the repaired version of the input class
			dumpToFile(b2, classFileName);
			if (LIST_ASM_CODE)
				Util.doListClassFile(classFileName);
		} catch (Exception e) {
			Util.println("ByteCodeEngineering FAILED for " + classFileName);
			e.printStackTrace();
			Util.warning("ByteCodeEngineering FAILED for " + classFileName + ", Exception="
					+ e.getClass().getSimpleName() + ", msg=" + e.getMessage());
		} finally {
			if (inputStream != null)
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	/**
	 * Dump bytes to the given class file
	 * @param bytes the bytes
	 * @param classFileName the class file
	 */
	private void dumpToFile(byte[] bytes, String classFileName) {
		if (DEBUG)
			Util.println("ByteCodeEngineering.dumpToFile: " + classFileName);
		try {
			OutputStream outputStream = new FileOutputStream(classFileName);
			BufferedOutputStream out = new BufferedOutputStream(outputStream);
			out.write(bytes, 0, bytes.length);
			out.flush();
			out.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}

	}

}
