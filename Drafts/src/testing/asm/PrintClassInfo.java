package testing.asm;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class PrintClassInfo extends ClassVisitor {
	
	public static void main(String[] args) {
		String inptFileName="C:/GitHub/SimulaCompiler/Simula/src/simulaTestPrograms/tmp/simulaTestPrograms/adHoc00.class";
		
		try {
			PrintClassInfo cp = new PrintClassInfo();
		
			InputStream inputStream=new FileInputStream(inptFileName);
			ClassReader cr = new ClassReader(inputStream);
			cr.accept(cp, 0); // ClassReader will call methods in cp

		} catch(IOException e) { e.printStackTrace(); }
	}
	
	
	public PrintClassInfo() {
		super(Opcodes.ASM7);
	}
	
	public PrintClassInfo(ClassVisitor classVisitor) {
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
		System.out.println("Method -- Name=" + name + ", Descriptor=" + desc+", Signature="+signature);
		return null;
	}

	public void visitEnd() {
		System.out.println("}");
	}
}
