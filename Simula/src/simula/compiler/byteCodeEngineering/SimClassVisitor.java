/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.byteCodeEngineering;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.InstructionAdapter;

import simula.compiler.utilities.Util;

/**
 * Simula's ClassVisitor.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/byteCodeEngineering/SimClassVisitor.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public class SimClassVisitor extends ClassVisitor {
	private static final boolean DEBUG=false;
	private String classFileName;
	
	/**
	 * Current ASM release.
	 */
	public static final int ASM_Release=Opcodes.ASM7;
	
//	SimClassVisitor(String classFileName) {
//		super(ASM_Release);
//		this.classFileName=classFileName;
//	}
	
	/**
	 * The Simula class visitor.
	 * @param classFileName the class file name
	 * @param classVisitor the class visitor
	 */
	SimClassVisitor(String classFileName,ClassVisitor classVisitor) {
		super(ASM_Release,classVisitor);
		this.classFileName=classFileName;
	}

	@Override
	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
		if(DEBUG) Util.println(name + " extends " + superName + " {");
		// 'version' is the class version. The minor version is stored in the 16 most significant bits,
		//           and the major version in the 16 least significant bits.
		if(DEBUG) Util.println("SimClassVisitor.visit: version="+version);
		// if(Global.MODIFY_CLASS_VERSION) version=Global.classFileVersion;
		cv.visit(version,access,name,signature,superName,interfaces);
	}

	
	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
		// 'access' is the method's access flags (see {@link Opcodes}).
		// This parameter also indicates if the method is synthetic and/or deprecated.
		if(DEBUG) Util.println(" " + name + desc);
		if(DEBUG) Util.println(" " + name + desc);
		if(DEBUG) Util.println("Name=" + name + ", Descr=" + desc);
		if(name.equalsIgnoreCase("_STM")) {
			if(DEBUG) Util.println("SimClassVisitor.visitMethod");
			MethodVisitor methodVisitor = cv.visitMethod(access,name,desc,signature,exceptions);
			MethodVisitor methodVisitor2=new RepairSTM_MethodVisitor(classFileName, access, name, desc, methodVisitor);
			return(new InstructionAdapter(methodVisitor2));
		}
		return(cv.visitMethod(access,name,desc,signature,exceptions));
	}

}
