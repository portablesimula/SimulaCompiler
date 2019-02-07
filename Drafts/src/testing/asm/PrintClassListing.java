package testing.asm;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.util.Textifier;
import org.objectweb.asm.util.TraceClassVisitor;

public class PrintClassListing {
	static String inptFileName="C:/GitHub/SimulaCompiler/Simula/src/simulaTestPrograms/tmp/simulaTestPrograms/adHoc00.class";

	public static void main(String[] args) {
		TraceClassVisitor traceClassVisitor = new TraceClassVisitor(null, new Textifier(), new PrintWriter(System.out));

		//int	parsingOptions = ClassReader.SKIP_DEBUG;
		int	parsingOptions = 0;

		try {
			InputStream inputStream = new FileInputStream(inptFileName);
			new ClassReader(inputStream).accept(traceClassVisitor, parsingOptions);
		} catch(IOException e) { e.printStackTrace(); }
	}
}
