package testing.asm;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ClassTest1 extends ClassVisitor {
	
	public static void main(String[] args) {
		String inptFileName="C:/GitHub/SimulaCompiler/Simula/src/simulaTestPrograms/tmp/simulaTestPrograms/adHoc00.class";
		
		try {
			InputStream inputStream=new FileInputStream(inptFileName);
			ClassReader classReader = new ClassReader(inputStream);
			ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
			// classVisitor forwards all events to classWriter
			ClassVisitor classVisitor = new ClassTest1(classWriter);
			classReader.accept(classVisitor, 0); // ClassReader will call methods in classWriter
			System.out.println("ClassTest1: AFTER  classReader.accept(classVisitor, 0);");
			byte[] b2 = classWriter.toByteArray(); // b2 represents the same class as b1
			
		} catch(IOException e) { e.printStackTrace(); }
	}
	
	
	public ClassTest1() {
		super(Opcodes.ASM7);
	}
	
	public ClassTest1(ClassVisitor classVisitor) {
		super(Opcodes.ASM7,classVisitor);
	}

	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
		System.out.println(name + " extends " + superName + " {");
	}

	public void visitSource(String source, String debug) {
	}

	public void visitOuterClass(String owner, String name, String desc) {
	}

	public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
		return null;
	}

	public void visitAttribute(Attribute attr) {
	}

	public void visitInnerClass(String name, String outerName, String innerName, int access) {
	}

	public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
		System.out.println(" " + desc + " " + name);
		return null;
	}

	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
		System.out.println(" " + name + desc);
		System.out.println(" " + name + desc);
		System.out.println("Name=" + name + ", Descr=" + desc);
		if(!name.equalsIgnoreCase("STM$")) return(null);
	    System.out.println("ClassTest1.visitMethod");
	    MethodVisitor methodVisitor = cv.visitMethod(Opcodes.ASM7,name,desc,signature,exceptions);
	    MethodVisitor methodVisitor2=new RepairCodeAdapter("owner", access, name, desc, methodVisitor);

    	//return(new STM$Adapter(methodVisitor));
    	return(new STM$Adapter(methodVisitor2));
	}

	public void visitEnd() {
		System.out.println("}");
	}
}
