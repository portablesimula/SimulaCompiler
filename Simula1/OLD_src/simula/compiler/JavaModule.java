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

import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.editor.RTOption;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class JavaModule {
	private JavaModule enclosingJavaModule;
	public final BlockDeclaration blockDeclaration;
	private final Writer writer;
	final File javaOutputFile;
	private final Vector<Integer> lineMap=new Vector<Integer>();
	public Vector<CodeLine> saveCode; // Used during coding
	
	public JavaModule(final BlockDeclaration blockDeclaration) {
		this.blockDeclaration = blockDeclaration;
		Global.javaModules.add(this);
		enclosingJavaModule = Global.currentJavaModule;
		Global.currentJavaModule = this;
		javaOutputFile = new File(Global.tempJavaFileDir,blockDeclaration.getJavaIdentifier()+".java");
		try {
			javaOutputFile.getParentFile().mkdirs();
			if (Option.verbose)	Util.TRACE("Output: " + javaOutputFile.getCanonicalPath());
			writer = new OutputStreamWriter(new FileOutputStream(javaOutputFile), Global.CHARSET$);
			JavaModule.code("package " + Global.packetName + ";");
			JavaModule.code("// " + Global.simulaReleaseID + " Compiled at " + new Date());
			JavaModule.code("import simula.runtime.*;");
		} catch (IOException e) {
			throw new RuntimeException("Writing .java output failed", e);
		}
	}

	public String getClassOutputFileName() {
		return (Global.tempClassFileDir + Global.packetName + '/' + blockDeclaration.getJavaIdentifier() + ".class");
	}
		 
	public void closeJavaOutput() {
		try { writer.flush(); writer.close();
		} catch (IOException e) {
			throw new RuntimeException("Writing .java output failed", e);
		}
		Global.currentJavaModule = enclosingJavaModule;
		enclosingJavaModule = null;
	}	

	
	public static void debug(final String line) {
		if (RTOption.DEBUGGING)	code(line);
	}

	public static void code(final String line) {
		Global.currentJavaModule.write(Global.sourceLineNumber, line);
	}

	public static void code(final String line,final String comment) {
		if (!RTOption.DEBUGGING) code(line);
		else code(line + " // " + comment);
	}

	public static void code(final CodeLine c) {
		Global.currentJavaModule.write(c.sourceLineNumber, c.codeLine);
	}

	private int currentJavaLineNumber=0;
	
	private static int prevLineNumber=0;
	private int indent;
	private void write(final int sourceLineNumber,final String line) {
		Util.ASSERT(sourceLineNumber>0,"Invariant");
		if(saveCode!=null) {
			CodeLine codeLine=new CodeLine(sourceLineNumber,line);
			saveCode.add(codeLine);
		} else
		try { currentJavaLineNumber++;
			  if(prevLineNumber!=sourceLineNumber) {
				  String s0=edIndent()+"// JavaLine "+currentJavaLineNumber+" <== SourceLine "+sourceLineNumber;
				  appendLine(currentJavaLineNumber,sourceLineNumber);
				  if(Option.TRACE_CODING) Util.println("CODE "+sourceLineNumber+": "+s0);
				  currentJavaLineNumber++;
				  if(RTOption.DEBUGGING) writer.write(s0+'\n');
			  }
			  if(line.startsWith("}")) indent--;
			  String s=edIndent()+line;
			  if(line.endsWith("{")) indent++;
			  if(Option.TRACE_CODING) Util.println("CODE "+sourceLineNumber+": "+s);
			  Util.ASSERT(writer!=null,"Can't Output Code - writer==null"); 
			  writer.write(s+'\n');
		} catch (IOException e) {
//			Util.INTERNAL_ERROR("Error Writing File: "+javaOutputFileName,e);
			Util.INTERNAL_ERROR("Error Writing File: "+javaOutputFile,e);
		}
		prevLineNumber=sourceLineNumber;
	}
	
	private String edIndent() {
		int i=indent; String s="";
		while((i--)>0) s=s+"    ";
		return(s);  
	}

	public void appendLine(final int javaLine,final int simulaLine) {
	    lineMap.add(javaLine); lineMap.addElement(simulaLine);
	}
	  
	public void codeProgramInfo() {
		appendLine(currentJavaLineNumber,blockDeclaration.lastLineNumber);
		// public static PROGINFO$ INFO$=new PROGINFO$("file.sim","MainProgram",1,4,12,5,14,12,32,14,37,16);
		StringBuilder s=new StringBuilder();
		s.append(edIndent()+"public static PROGINFO$ INFO$=new PROGINFO$(\"");
		s.append(Global.sourceFileName);
		s.append("\",\"");
		s.append(blockDeclaration.declarationKind+" "+blockDeclaration.identifier);
		s.append('"');
		for(Integer i:lineMap) { s.append(','); s.append(""+i); }
		s.append(");");
		writeCode(s.toString());
	}
	
	private void writeCode(String s) {
		if(Option.TRACE_CODING) Util.println("CODE "+Global.sourceLineNumber+": "+s);
		Util.ASSERT(writer!=null,"Can't Output Code - writer==null"); 
		try { writer.write(s.toString()+'\n');
		} catch (IOException e) {
			Util.INTERNAL_ERROR("Error Writing File: "+javaOutputFile,e);
		}
		
	}
	
	public String toString() {
		return ("JavaModule " + blockDeclaration + ", javaOutputFile=" + javaOutputFile);
	}

}
