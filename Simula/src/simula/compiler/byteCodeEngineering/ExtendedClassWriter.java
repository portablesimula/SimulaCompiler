/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.byteCodeEngineering;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Util;

/**
 * Extended ClassWriter.
 * <p>
 * This class is introduced to compensate for a weakness in ASM ( https://asm.ow2.io/ ).
 * <p>
 * ClassWriter.getCommonSuperClass does not work because Global.tempClassFileDir is not present in java.class.path
 * <p>
 * Instead we use the information we have about all generated .class files to find common superclass of two types.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/byteCodeEngineering/ExtendedClassWriter.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public class ExtendedClassWriter extends ClassWriter {
	/**
	 * DEBUG on/off
	 */
	private static final boolean DEBUG = false;

	/**
	 * Create a new ExtendedClassWriter.
	 * 
	 * @param classReader the {@link ClassReader} used to read the original class.
	 * @param flags       option flags that can be used to modify the default
	 *                    behavior of this class.
	 */
	public ExtendedClassWriter(ClassReader classReader, int flags) {
		super(classReader, flags);
	}

	@Override
	protected String getCommonSuperClass(final String type1, final String type2) {
		// Called from: ClassWriter.getCommonSuperClass
		if (DEBUG)
			System.out.println("ExtendedClassWriter.getCommonSuperType: type1=" + type1 + ", type2=" + type2);
		try {
			String superType = null;
			JavaClassInfo info1 = getClassInfo(type1);
			if (DEBUG)
				System.out.println("ExtendedClassWriter.getCommonSuperType: info1=" + info1);
			JavaClassInfo info2 = getClassInfo(type2);
			if (DEBUG)
				System.out.println("ExtendedClassWriter.getCommonSuperType: info2=" + info2);
			if (info1.isSuperTypeOf(info2))
				superType = type1;
			else if (info2.isSuperTypeOf(info1))
				superType = type2;
			if (DEBUG)
				System.out.println(
						"ExtendedClassWriter.getCommonSuperType: " + type1 + ", " + type2 + " ==> " + superType);
			return (superType);
		} catch (Exception e) {
			e.printStackTrace();
			JavaClassInfo.printJavaClassMap("");
			if (DEBUG)
				System.out.println("ExtendedClassWriter.getCommonSuperType: type1=" + type1 + ", type2=" + type2);
			throw new RuntimeException("Unable to find CommonSuperType: " + type1 + ", " + type2);
		}
	}

	/**
	 * Get class info
	 * @param type the type
	 * @return the resulting JavaClassInfo
	 */
	private static JavaClassInfo getClassInfo(String type) {
		int n = type.lastIndexOf('/');
		String dir = type.substring(0, n);
		Util.ASSERT(dir.equals(Global.packetName), " dir=" + dir + ", Global.packetName=" + Global.packetName);
		type = type.substring(n + 1);
		if (DEBUG)
			System.out.println("ExtendedClassWriter.getClassInfo: javaClassInfo.get(" + type + ")");
		return (JavaClassInfo.get(type));
	}

}
