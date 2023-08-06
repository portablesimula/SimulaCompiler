/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Vector;

import simula.compiler.byteCodeEngineering.JavaClassInfo;
import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.declaration.ClassDeclaration;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Generated Java class.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/GeneratedJavaClass.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen 
 *
 */
public final class GeneratedJavaClass {
	private GeneratedJavaClass enclosingJavaModule;
	private final Writer writer;
	private final Vector<Integer> lineMap = new Vector<Integer>();
	
	/**
	 * The output file for generated Java code.
	 */
	final File javaOutputFile;

	/**
	 * Given as argument.
	 */
	public final BlockDeclaration blockDeclaration;
	
	/**
	 * Used during coding to save the generated code.
	 */
	public Vector<CodeLine> saveCode;
	
	/**
	 * Signals that ByteCodeEngineering is necessary.
	 */
	public boolean mustDoByteCodeEngineering;

	/**
	 * Create a new GeneratedJavaClass.
	 * @param blockDeclaration argument
	 */
	public GeneratedJavaClass(final BlockDeclaration blockDeclaration) {
		this.blockDeclaration = blockDeclaration;
		Global.generatedJavaClass.add(this);
		enclosingJavaModule = Global.currentJavaModule;
		Global.currentJavaModule = this;
		javaOutputFile = new File(Global.tempJavaFileDir, blockDeclaration.getJavaIdentifier() + ".java");
		try {
			javaOutputFile.getParentFile().mkdirs();
			if (Option.verbose)
				Util.TRACE("Output: " + javaOutputFile.getCanonicalPath());
			writer = new OutputStreamWriter(new FileOutputStream(javaOutputFile), Global._CHARSET);
			GeneratedJavaClass.code("package " + Global.packetName + ";");
			GeneratedJavaClass.code("// " + Global.simulaReleaseID + " Compiled at " + new Date());
			GeneratedJavaClass.code("import simula.runtime.*;");
		} catch (IOException e) {
			throw new RuntimeException("Writing .java output failed", e);
		}

		JavaClassInfo info = new JavaClassInfo();
		info.externalIdent = blockDeclaration.getJavaIdentifier();
		if (blockDeclaration instanceof ClassDeclaration cls)
			info.prefixIdent = cls.prefix;
		JavaClassInfo.put(info.externalIdent, info);
	}

	private String modid() {
		BlockDeclaration blk = Global.currentJavaModule.blockDeclaration;
		return (blk.declarationKind + " " + blk.scopeID());
	}

	/**
	 * Returns the output file for generated Java code.
	 * @return the output file for generated Java code
	 */
	String getClassOutputFileName() {
		return (Global.tempClassFileDir + "/" + Global.packetName + '/' + blockDeclaration.getJavaIdentifier() + ".class");
	}

	/**
	 * Close Java output file.
	 * @throws RuntimeException if writing .java output failed
	 */
	public void closeJavaOutput() {
		try {
			writer.flush();
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException("Writing .java output failed", e);
		}
		Global.currentJavaModule = enclosingJavaModule;
		enclosingJavaModule = null;
	}

	/**
	 * Output a debug code line.
	 * <p>
	 * To optimize, it is safe to drop such lines
	 * 
	 * @param line a debug code line
	 */
	public static void debug(final String line) {
		code(line);
	}

	/**
	 * Output a code line without comment.
	 * 
	 * @param line a code line
	 */
	public static void code(final String line) {
		Global.currentJavaModule.write(Global.sourceLineNumber, line, Global.currentJavaModule.modid());
	}

	/**
	 * Output a code line with comment.
	 * 
	 * @param line a code line
	 * @param comment a comment string
	 */
	public static void code(final String line, final String comment) {
		code(line + " // " + comment);
	}

	/**
	 * Output a code line.
	 * 
	 * @param c a code line
	 */
	public static void code(final CodeLine c) {
		Global.currentJavaModule.write(c.sourceLineNumber, c.codeLine, c.modid);
	}

	private int currentJavaLineNumber = 0;

	private static int prevLineNumber = 0;
	private int indent;

	private void write(final int sourceLineNumber, final String line, final String modid) {
		Util.ASSERT(sourceLineNumber > 0, "Invariant");
		if (saveCode != null) {
			CodeLine codeLine = new CodeLine(modid, sourceLineNumber, line);
			saveCode.add(codeLine);
		} else
			try {
				currentJavaLineNumber++;
				if (prevLineNumber != sourceLineNumber) {
					String s0 = edIndent() + edLineNumberLine(sourceLineNumber, modid);
					appendLine(currentJavaLineNumber, sourceLineNumber);
					if (Option.TRACE_CODING)
						Util.println("CODE " + sourceLineNumber + ": " + s0);
					currentJavaLineNumber++;
					writer.write(s0 + '\n');
				}
				if (line.contains("}")) {
					indent--;
					if (indent < 0)
						indent = 0;
				}
				String s = edIndent() + line;
				if (line.contains("{"))
					indent++;
				if (Option.TRACE_CODING)
					Util.println("CODE " + sourceLineNumber + ": " + s);
				Util.ASSERT(writer != null, "Can't Output Code - writer==null");
				writer.write(s + '\n');
			} catch (IOException e) {
				Util.IERR("Error Writing File: " + javaOutputFile, e);
			}
		prevLineNumber = sourceLineNumber;
	}

	private String edLineNumberLine(final int simulaLine, final String modid) {
		StringBuilder sb = new StringBuilder();
		if (Global.duringSTM_Coding && Option.GNERATE_LINE_CALLS) {
			sb.append("RTS_COMMON._LINE(\"").append(modid).append("\",").append(simulaLine).append("); ");
		}
		sb.append("// JavaLine ").append(currentJavaLineNumber).append(" <== SourceLine ").append(simulaLine);
		return (sb.toString());
	}

	private String edIndent() {
		int i = indent;
		String s = "";
		while ((i--) > 0)
			s = s + "    ";
		return (s);
	}

	private void appendLine(final int javaLine, final int simulaLine) {
		lineMap.add(javaLine);
		lineMap.addElement(simulaLine);
	}

	/**
	 * Output program info. I.e. identifier and lineMap.
	 */
	public void codeProgramInfo() {
		appendLine(currentJavaLineNumber, blockDeclaration.lastLineNumber);
		// public static RTS_PROGINFO _INFO=new
		// RTS_PROGINFO("file.sim","MainProgram",1,4,12,5,14,12,32,14,37,16);
		StringBuilder s = new StringBuilder();
		s.append(edIndent() + "public static RTS_PROGINFO _INFO=new RTS_PROGINFO(\"");
		s.append(Global.sourceFileName);
		s.append("\",\"");
		s.append(blockDeclaration.declarationKind + " " + blockDeclaration.identifier);
		s.append('"');
		for (Integer i : lineMap) {
			s.append(',');
			s.append("" + i);
		}
		s.append(");");
		writeCode(s.toString());
	}

	private void writeCode(String s) {
		if (Option.TRACE_CODING)
			Util.println("CODE " + Global.sourceLineNumber + ": " + s);
		Util.ASSERT(writer != null, "Can't Output Code - writer==null");
		try {
			writer.write(s.toString() + '\n');
		} catch (IOException e) {
			Util.IERR("Error Writing File: " + javaOutputFile, e);
		}

	}

	@Override
	public String toString() {
		return ("JavaModule " + blockDeclaration + ", javaOutputFile=" + javaOutputFile);
	}

}
