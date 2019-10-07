package simula.compiler.byteCodeEngineering;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.InstructionAdapter;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Util;

public class SimClassVisitor extends ClassVisitor {
	public static final int ASM_Release=Opcodes.ASM7;
	private static final boolean DEBUG=false;
	private String classFileName;
	
	public SimClassVisitor(String classFileName) {
		super(ASM_Release);
		this.classFileName=classFileName;
	}
	
	public SimClassVisitor(String classFileName,ClassVisitor classVisitor) {
		super(ASM_Release,classVisitor);
		this.classFileName=classFileName;
	}

	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
		if(DEBUG) Util.println(name + " extends " + superName + " {");
//		'version' is the class version. The minor version is stored in the 16 most significant bits,
//		          and the major version in the 16 least significant bits.
		if(DEBUG) Util.BREAK("SimClassVisitor.visit: version="+version);
		if(Global.MODIFY_CLASS_VERSION) version=Global.classFileVersion;
		cv.visit(version,access,name,signature,superName,interfaces);
	}

	
	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
		// 'access' is the method's access flags (see {@link Opcodes}).
		// This parameter also indicates if the method is synthetic and/or deprecated.
		if(DEBUG) Util.println(" " + name + desc);
		if(DEBUG) Util.println(" " + name + desc);
		if(DEBUG) Util.println("Name=" + name + ", Descr=" + desc);
		if(name.equalsIgnoreCase("STM$")) {
			if(DEBUG) Util.println("SimClassVisitor.visitMethod");
			MethodVisitor methodVisitor = cv.visitMethod(access,name,desc,signature,exceptions);
			MethodVisitor methodVisitor2=new RepairSTM_MethodVisitor(classFileName, access, name, desc, methodVisitor);
			return(new InstructionAdapter(methodVisitor2));
		}
		return(cv.visitMethod(access,name,desc,signature,exceptions));
	}

}
