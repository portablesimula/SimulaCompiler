package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import jjava.lang.classfile.ClassModel;
import jjava.lang.classfile.Classfile;
import jjava.lang.classfile.MethodModel;
import jjava.lang.classfile.constantpool.Utf8Entry;

//import org.glavo.classfile.ClassModel;
//import org.glavo.classfile.Classfile;
//import org.glavo.classfile.MethodModel;
//import org.glavo.classfile.constantpool.Utf8Entry;

public class Test {
	public static void main(String[] args) {
		try {
			doTesting();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void doTesting() throws IOException {
		String name="C:/GitHub/SimulaCompiler/ClassFile/bin/test/Test.class";
		FileInputStream inpt=new FileInputStream(name);
		byte[] bytes=inpt.readAllBytes();
		inpt.close();
//		ClassModel classModel = Classfile.of().parse(bytes);
		ClassModel classModel = Classfile.parse(bytes);
		List<MethodModel> methods=classModel.methods();
		for(MethodModel methodModel:methods) {
			Utf8Entry methodName=methodModel.methodName(); //	Returns the name of this method.
			System.out.println("Test.doTesting: methodName="+methodName);
			if(methodName.equalsString("_STM")) {
				
			}
		}
	}
}
