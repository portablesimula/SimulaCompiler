/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.engineering.asmtool;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Vector;

import org.openjdk.asmtools.jdis.uEscWriter;

import simula.compiler.utilities.Util;

/**
 * Based on the OpenJDK 'AsmTools' set of (Java class file) assembler/disassemblers:
 * Main page: https://wiki.openjdk.java.net/display/CodeTools/asmtools
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class AsmToolEngineering {
	private static final boolean LIST_REPAIRED_INSTRUCTION_LIST=true;//false;
	private static final boolean LIST_ASM_CODE=true;//false;
	private static final boolean LIST_REPAIRED_ASM_CODE=true;//false;
	private static final boolean TRACE_REPAIRING=true;//false;
	
	private static final boolean SKIP_DEASM=false;
	private static final boolean DONT_UPDATE_JASM_FILE=false;
	
	private Vector<String> asmLabels; // USE_OpenJDK_ASMTOOLS
	
	public AsmToolEngineering() {
	}

	public void doRepairSingleByteCode(String classFileName) {
    	Vector<String> lines=new Vector<String>();
    	LineNumberReader lineReader=null;
        try {
            //System.out.println("ByteCodeEngineering.doRepairByteCode: Load Class-File "+classFileName);
            Util.BREAK("ByteCodeEngineering.doRepairByteCode: Load "+classFileName);
            String jasmFileName=classFileName.replace(".class", ".jasm");
            Util.BREAK("ByteCodeEngineering.doRepairByteCode: jdisFileName="+jasmFileName);
            if(TRACE_REPAIRING) System.out.println("ByteCodeEngineering.doRepairAsmCode: Load "+classFileName);
            File jasmFile=new File(jasmFileName);
            jasmFile.getParentFile().mkdirs();
    		if(!SKIP_DEASM) runJavaDisassembler(classFileName,jasmFileName); // Jdis
    		
    		InputStream inputStream=new FileInputStream(jasmFileName);
    		Reader reader=new InputStreamReader(inputStream);
    		lineReader=new LineNumberReader(reader);
    		
            if(TRACE_REPAIRING) System.out.println("*** ByteCodeEngineering: PASS 1 - FIND AND TREAT ALL LABELS IN "+classFileName+" ***");
        	asmLabels=new Vector<String>();
    		LOOP: while(true) {
    			String line=lineReader.readLine();
				System.out.println("READ: "+lineReader.getLineNumber()+": "+line);

    			if(line==null) break LOOP;
    			if(line.contains("LABEL$"))	checkLABEL(line,lines);
    			else if(!line.startsWith("%%")) lines.add(line);
    		}
            lineReader.close();
            if(asmLabels.size()==0) {
                if(TRACE_REPAIRING) System.out.println("*** ByteCodeEngineering: NO LABEL FOUND IN "+classFileName+" ***");
                System.out.println("*** ByteCodeEngineering: NO LABEL FOUND IN "+classFileName+" ***");
            	if(!SKIP_DEASM) return;
            }
            if(TRACE_REPAIRING) System.out.println("*** ByteCodeEngineering: "+asmLabels.size()+" LABEL FOUND IN "+classFileName+" ***");
            System.out.println("*** ByteCodeEngineering: "+asmLabels.size()+" LABEL FOUND IN "+classFileName+" ***");
    		
            if(!SKIP_DEASM) {
            	if(TRACE_REPAIRING) System.out.println("*** ByteCodeEngineering: PASS 2 - FIND AND TREAT JUMPTABLE$ ***");
            	LOOP2:for(int i=0;i<lines.size();i++) {
            		String line=lines.elementAt(i);
            		if(line.contains("JUMPTABLE$")) {
            			checkJUMPTABLE(i,line,lines);
            			break LOOP2;
            		}
            	}
            }
            
            if(LIST_REPAIRED_INSTRUCTION_LIST)
            { System.out.println("*** ByteCodeEngineering: LIST REPAIRED INSTRUCTION LIST ***");
    		  for(int i=0;i<lines.size();i++) {
    				System.out.println("LINE "+i+": "+lines.elementAt(i));
    			}
            }
            
            if(!SKIP_DEASM) {
                if(!DONT_UPDATE_JASM_FILE) {
                	System.out.println("Re-Store intermediate .jasm file: "+jasmFile);
                	Util.BREAK("*** ByteCodeEngineering: Re-Store repaired .jasm file: "+jasmFile);
                	OutputStream outputStream=new FileOutputStream(jasmFile);
                	Writer writer=new OutputStreamWriter(outputStream);
                	for(int i=0;i<lines.size();i++) {
                		writer.write(lines.elementAt(i)+'\n');
                	}
                	writer.flush();
                	writer.close();
                }
            }
                		
    		
//    		if(LIST_ASM_CODE) {
//    			System.out.println("*** ByteCodeEngineering: LIST REGENERATED ASM CODE FROM FILE WRITTEN: "+ouptFileName);
//    			InputStream inputStream=new FileInputStream(ouptFileName);
//    			Reader reader=new InputStreamReader(inputStream);
//    			LineNumberReader lineReader=new LineNumberReader(reader);
//    			LOOP: while(true) {
//    				String line=lineReader.readLine();
//    				System.out.println("CHCK: "+lineReader.getLineNumber()+": "+line);
//    				if(line==null) break LOOP;
//    			}
//    			lineReader.close();
//    		}

            
    		File classFile=new File(classFileName);
            runJavaAssembler(jasmFileName,classFile.getParent());
            
//    		System.out.println("FORCED EXIT");
//    		System.exit(0);
        } catch (Exception e) { e.printStackTrace(); }
        finally {
        	try { if(lineReader!=null) lineReader.close();} catch(IOException e) {}
        }
    }
	
	public static void runJavaDisassembler(String inptFileName,String ouptFileName) {
		// Jdis is a disassembler that accepts a .class file,
		// and prints the plain-text translation of jasm source file to the output.
		// See: https://wiki.openjdk.java.net/display/CodeTools/Chapter+2#Chapter2-Jasm.1
		// JASM Syntax: https://wiki.openjdk.java.net/display/CodeTools/Appendix+A
    	Util.BREAK("*** ByteCodeEngineering.runJavaDisassembler: inptFileName="+inptFileName);
    	Util.BREAK("*** ByteCodeEngineering.runJavaDisassembler: ouptFileName="+ouptFileName);
//		String[] argd= {"-version", "-g", inptFileName};
//		String[] argd= {"-version", inptFileName};
		String[] argd= { inptFileName };
    	File file=new File(ouptFileName);
    	file.getParentFile().mkdirs();
    	boolean result=false;
    	try {
    		OutputStream outputStream=new FileOutputStream(file);
    		BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(outputStream);
    		org.openjdk.asmtools.jdis.Main disassembler
    		= new org.openjdk.asmtools.jdis.Main(new PrintWriter(new uEscWriter(bufferedOutputStream)), "jdis");
            result = disassembler.disasm(argd);
    		bufferedOutputStream.flush();
    		bufferedOutputStream.close();
//        	System.out.println("DONE: TestAsmTools: result="+result); // MYH
//        	System.err.println("DONE: TestAsmTools: result="+result); // MYH
    		
    		if(LIST_ASM_CODE) {
    			System.out.println("*** ByteCodeEngineering: LIST REGENERATED ASM CODE FROM FILE WRITTEN: "+ouptFileName);
    			InputStream inputStream=new FileInputStream(ouptFileName);
    			Reader reader=new InputStreamReader(inputStream);
    			LineNumberReader lineReader=new LineNumberReader(reader);
    			LOOP: while(true) {
    				String line=lineReader.readLine();
    				System.out.println("CHCK: "+lineReader.getLineNumber()+": "+line);
    				if(line==null) break LOOP;
    			}
    			lineReader.close();
    		}

    	} catch(Exception e) { e.printStackTrace(); }
    	Util.BREAK("*** ByteCodeEngineering.runJavaDisassembler: DONE result="+result);
	}
	
	public static void runJavaAssembler(String inptFileName,String ouptFileDir) {
		// Jasm is an assembler that accepts a text file based on the JASM Specification,
		// and produces a .class file for use with a Java Virtual Machine.
		// See: https://wiki.openjdk.java.net/display/CodeTools/Chapter+2#Chapter2-Jasm.1
		// JASM Syntax: https://wiki.openjdk.java.net/display/CodeTools/Appendix+A
		//
		// Options:
		//	-version   	Print jasm tool version
		//	-d destdir	Specifies a directory to place resulting .class files. If a destdir is not provided, the .class file will be written in the current directory.
		//	-g			Add debug information to .class file
		//	-nowrite	Do not write resulting .class files. This option may be used to verify the integrity of your source jasm file
		//	-strict		Consider warnings as errors.
		//	-nowarn		Do not print warnings.
		//	-cv major.minor	Set the operating class file version (by default 45.3).
		//	Note - If the optional class attribute 'version' defines (in source of class) the class file version, then it overrides default class file version set by -cv option.
		//
    	Util.BREAK("*** ByteCodeEngineering.runJavaAssembler: inptFileName="+inptFileName);
    	Util.BREAK("*** ByteCodeEngineering.runJavaAssembler: ouptFileDir="+ouptFileDir);
    	File classDir=new File(ouptFileDir);
    	classDir=classDir.getParentFile(); // TEMP  -  AD'HOC  delete
//		String[] argd= {"-version", "-g", inptFileName};
//		String[] argd= {"-version", "-d", ouptFileDir, "-XdAll", inptFileName};
//		String[] argd= {"-d", classDir.toString(), "-XdAll", inptFileName};
		String[] argd= {"-d", classDir.toString(), inptFileName};
		classDir.mkdirs();
    	boolean result=false;
    	try {
    		org.openjdk.asmtools.jasm.Main assembler
    		= new org.openjdk.asmtools.jasm.Main(System.out, "jasm");
            result = assembler.compile(argd);
        	System.out.println("DONE: JavaAssembler: result="+result+", Input .jasm file read from: "+inptFileName); // MYH
        	System.out.println("DONE: JavaAssembler: result="+result+", Output .class file written in: "+classDir); // MYH
//        	System.err.println("DONE: JavaAssembler: result="+result); // MYH
    	} catch(Exception e) { e.printStackTrace(); }
    	Util.BREAK("*** ByteCodeEngineering.runJavaAssembler: DONE result="+result);
	}

	
	/*
	 * Locate the instruction sequence:
	 * <pre>
	 *    PREV-INSTRUCTION
	 *    ICONST n
	 *    INVOKESTATIC LABEL$
	 *    NEXT-INSTRUCTION
	 * </pre>
	 * Replace it by:
	 * <pre>
	 *    PREV-INSTRUCTION
	 *    LABEL$n: nop
	 *    NEXT-INSTRUCTION
	 * </pre>
	 */
	private void checkLABEL(String line, Vector<String> lines) {
		int n=lines.size();
		String prev=lines.get(n-1);
		//Util.BREAK("ByteCodeEngineering.checkLABEL: GOT LABEL PREV: "+prev);
		//Util.BREAK("ByteCodeEngineering.checkLABEL: GOT LABEL LINE: "+line);
		if(prev.trim().startsWith("iconst_")) {
			lines.add("  // Removed\t"+prev.trim());
			lines.add("  // Removed\t"+line.trim());
			if(TRACE_REPAIRING) {
				System.out.println("*** ByteCodeEngineering: REPAIRING LABEL$ CODE ***");
				for(int i=n-4;i<(n+2);i++) {
					System.out.println("LINE "+i+": "+lines.elementAt(i));
				}
				System.out.println("LINE "+n+": "+line);
			}
			String labelNumber=prev.replace(';', ' ').trim().substring(7);
			//Util.BREAK("ByteCodeEngineering.checkLABEL: LABEL NUMBER: "+labelNumber);
//			System.out.println("REMOVE ? "+(n)+": "+lines.elementAt(n));
//			lines.remove(n);
//			System.out.println("REMOVE ? "+(n)+": "+lines.elementAt(n));
//			lines.remove(n);
			int index=n-1;
			System.out.println("REMOVE? "+(index)+": "+lines.get(index));
			String removed=lines.remove(index);
			System.out.println("REMOVED "+(index)+": "+removed);
			
			String prevPrevline=lines.get(n-2);
			String prevLabel=findPrevLabel(prevPrevline);
			if(prevLabel!=null) {
				asmLabels.add(prevLabel);
			} else {
				String label="LABEL$"+labelNumber;
				asmLabels.add(label);
				// frame_type = ( same | stack1 | stack1_ex | chop1 | chop2 | chop3 | same_ex | append | full ) 
				//lines.add("  "+label+":\tstack_frame_type same; // Inserted");
				lines.add("  "+label+":\tstack_frame_type same_frame_extended; // Inserted");
//				lines.add("  "+label+":\tstack_frame_type stack1; // Inserted");
//				lines.add("  "+label+":\tstack_frame_type stack1_ex; // Inserted");
//				lines.add("  "+label+":\tstack_frame_type chop1; // Inserted");
//				lines.add("  "+label+":\tstack_frame_type chop2; // Inserted");
//				lines.add("  "+label+":\tstack_frame_type chop3; // Inserted");
//				lines.add("  "+label+":\tstack_frame_type same_ex; // Inserted");
//				lines.add("  "+label+":\tstack_frame_type append; // Inserted");
//				lines.add("  "+label+":\tstack_frame_type full; // Inserted");
//				lines.add("  "+label+":\tstack_frame_type XXX"+labelNumber+"; // Inserted");
			}
			if(TRACE_REPAIRING) {
				System.out.println("*** ByteCodeEngineering: REPAIRED LABEL$ CODE ***");
				for(int i=n-4;i<(n+1);i++) {
					System.out.println("LINE "+i+": "+lines.elementAt(i));
				}
			}
			Util.BREAK("ByteCodeEngineering.checkLABEL: DONE LABEL NUMBER: "+labelNumber);
			return;
		}
	}
	
	private String findPrevLabel(String line) {
		System.out.println("ByteCodeEngineering.findPrevLabel: line="+line);
		String[] part = line.split("\\s+");
		for(String s:part) System.out.println("ByteCodeEngineering.findPrevLabel: Split:="+'"'+s+'"');

		//StringTokenizer tokenizer=new StringTokenizer(line," :;",true);
		//String ident=tokenizer.nextToken();
		String part1=part[1];
		System.out.println("ByteCodeEngineering.findPrevLabel: part1="+part1);
		//String delm=tokenizer.nextToken();
		//System.out.println("ByteCodeEngineering.findPrevLabel: delm="+delm);
//		if(delm.equals(":")) {
		if(part1.endsWith(":")) {
			String label=part1.substring(0,part1.length()-1);
			Util.BREAK("ByteCodeEngineering.findPrevLabel: GOT IT "+label);
			return(label);
		} else if(part.length>=4) {
			if(part1.equalsIgnoreCase("invokestatic")
				& part[2].equalsIgnoreCase("Method")
				& part[3].equalsIgnoreCase("JUMPTABLE$:\"(I)V\";")	) {
				Util.BREAK("ByteCodeEngineering.findPrevLabel: GOT JUMPTABLE$");
				return("DEFAULT$");
			}
		}
		Util.BREAK("ByteCodeEngineering.findPrevLabel: NOT FOUND");
		return(null);
	}
	
	/*
	 * Locate the instruction sequence:
	 * <pre>
	 *    PREV-INSTRUCTION
	 *    GETFIELD JTX$
	 *    INVOKESTATIC JUMPTABLE$
	 *    NEXT-INSTRUCTION
	 * </pre>
	 * Replace it by:
	 * <pre>
	 *    PREV-INSTRUCTION
	 *    GETFIELD JTX$
	 *    tableswitch  {
	 *    // Case 0 is fall through
	 *            1: LABEL$1;
	 *            2: LABEL$2;
     *    }  // Default is fall through
	 *    NEXT-INSTRUCTION
	 * </pre>
	 */
	private void checkJUMPTABLE(int index, String line, Vector<String> lines) {
		Util.BREAK("ByteCodeEngineering.checkJUMPTABLE: GOT JUMPTABLE LINE: "+line);
        if(TRACE_REPAIRING) {
        	System.out.println("*** ByteCodeEngineering: REPAIRING JUMPTABLE$ CODE ***");
        	for(int i=index-4;i<(index+4);i++) {
        		System.out.println("LINE "+i+": "+lines.elementAt(i));
        	}
        }
		lines.remove(index);
		lines.insertElementAt("\t\tDEFAULT$:	stack_frame_type same; // Inserted",index);
		lines.insertElementAt("\t\t};  // Default is fall through -- Inserted",index);
//		lines.insertElementAt("\t\t        2: LABEL$2; // Inserted",index);
		for(int i=asmLabels.size();i>0;i--) {	
//			lines.insertElementAt("\t\t        "+i+": LABEL$"+i+"; // Inserted",index);
			lines.insertElementAt("\t\t        "+i+": "+asmLabels.elementAt(i-1)+"; // Inserted",index);
		}
		lines.insertElementAt("\t\t// Case 0 is fall through -- Inserted",index);
		lines.insertElementAt("\t\ttableswitch  { // Inserted",index);
		lines.insertElementAt("  //"+line+" // Removed",index);

        if(TRACE_REPAIRING) {
        	System.out.println("*** ByteCodeEngineering: REPAIRED JUMPTABLE$ CODE ***");
        	for(int i=index-4;i<(index+7+asmLabels.size());i++) {
        		System.out.println("LINE "+i+": "+lines.elementAt(i));
        	}
        }
	}

	
}
