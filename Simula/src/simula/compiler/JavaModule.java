/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import simula.compiler.declaration.BlockDeclaration;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class JavaModule {
	JavaModule enclosingJavaModule;
	public BlockDeclaration blockDeclaration;
	private Writer writer;
	public String javaOutputFileName;
	
	public JavaModule(BlockDeclaration blockDeclaration)
	{ this.blockDeclaration=blockDeclaration; }

	public String getClassOutputFileName()
	{ return(Global.tempClassFileDir+Global.packetName+'/'+blockDeclaration.getJavaIdentifier()+".class"); }

	public int getNumberOfLabels()
	{ return(blockDeclaration.labelList.size()); }

	
	public void openJavaOutput() 
	{ enclosingJavaModule=Global.currentJavaModule;
	  Global.currentJavaModule=this;
	  javaOutputFileName = Global.tempJavaFileDir + blockDeclaration.getJavaIdentifier() + ".java";
	  
//	  Util.BREAK("JavaModule.openJavaOutput: Suspend "+enclosingJavaModule);
//	  Util.BREAK("JavaModule.openJavaOutput: Open    "+Global.currentJavaModule);
//	  Util.BREAK("JavaModule.openJavaOutput: blockDeclaration.identifier="+blockDeclaration.identifier);
//	  Util.BREAK("JavaModule.openJavaOutput: blockDeclaration.externalIdent="+blockDeclaration.externalIdent);
	  try {
		File outputFile = new File(javaOutputFileName);
		if (Option.verbose) Util.TRACE("Output: " + outputFile.getCanonicalPath());
		writer = new FileWriter(outputFile);
		JavaModule.code("package "+Global.packetName+";"); 
		JavaModule.code("// "+Global.simulaReleaseID+" Compiled at " + new Date());
		
		// Output Dependencies
		JavaModule.code("import simula.runtime.*;");
	  } catch (IOException e) {
		throw new RuntimeException("Writing .java output failed",e);
	  }
	}
		 
	public void closeJavaOutput() {
//		Util.BREAK("JavaModule.closeJavaOutput: Close    "+Global.currentJavaModule);
//		Util.BREAK("JavaModule.closeJavaOutput: Continue "+enclosingJavaModule);
		try {
			writer.flush();
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException("Writing .java output failed", e);
		}
		Global.currentJavaModule = enclosingJavaModule;
		enclosingJavaModule = null;
	}	

	
	public static void code(String line)
	{ Global.currentJavaModule.write(line); }

	private static int prevLineNumber=0;
	private int indent;
	public void write(String line) {
		  Util.ASSERT(Global.sourceLineNumber>0,"Invariant");
		  try {
			  if(prevLineNumber!=Global.sourceLineNumber) {
				  String s0=edIndent()+"// SourceLine "+Global.sourceLineNumber;
				  if(Option.TRACE_CODING) Util.println("CODE "+Global.sourceLineNumber+": "+s0);
				  if(s0!=null) writer.write(s0+'\n');
			  }
			  if(line.startsWith("}")) indent--;
			  String s=edIndent()+line;
			  if(line.endsWith("{")) indent++;
			  if(Option.TRACE_CODING) Util.println("CODE "+Global.sourceLineNumber+": "+s);
			  Util.ASSERT(writer!=null,"Can't Output Code - writer==null"); 
			  writer.write(s+'\n');
		  }
		  catch (IOException e) {
				System.out.println("Error Writing File: "+javaOutputFileName);
				e.printStackTrace();
		  }
		  prevLineNumber=Global.sourceLineNumber;
	  }
	  private String edIndent()
	  { int i=indent; String s="";
		while((i--)>0) s=s+"    ";
		return(s);  
	  }


	
	public String toString()
	{ return("JavaModule "+blockDeclaration+", javaOutputFileName="+javaOutputFileName); }

}
