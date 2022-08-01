/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.byteCodeEngineering;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import simula.compiler.SimulaCompiler;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Based on the 'ASM' Java bytecode manipulation and analysis framework. 
 * Main page: https://asm.ow2.io/index.html
 * Wikipedia: https://en.wikipedia.org/wiki/ObjectWeb_ASM
 * 
 * @author Øystein Myhre Andersen
 *
 */
public final class ByteCodeEngineering {
	private static final boolean LIST_ASM_CODE=false;
	private static final boolean DEBUG=false;
	
	public ByteCodeEngineering() {
	}

    public void doRepairSingleByteCode(String classFileName) {
    	InputStream inputStream=null;
        try {
        	File file=new File(classFileName);
        	String fileName=file.getName();
            //Util.BREAK("ByteCodeEngineering.doRepairByteCode: Load "+classFileName);
            if(Option.TRACE_REPAIRING) Util.println("ByteCodeEngineering.doRepairSingleByteCode: Load "+classFileName);
            if(LIST_ASM_CODE) SimulaCompiler.doListClassFile(classFileName);
			inputStream=new FileInputStream(classFileName);
			ClassReader classReader = new ClassReader(inputStream);
			ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
			// classVisitor forwards all events to classWriter
			ClassVisitor classVisitor = new SimClassVisitor(fileName,classWriter);
			classReader.accept(classVisitor, 0); // ClassReader will call methods in classWriter
			if(DEBUG) Util.println("ByteCodeEngineering.doRepairSingleByteCode: AFTER  classReader.accept(classVisitor, 0);");

			// Dump the class to <classFileName>
            if(Option.TRACE_REPAIRING) Util.println("ByteCodeEngineering.doRepairSingleByteCode: Dump "+classFileName);
			byte[] b2 = classWriter.toByteArray(); // b2 represents the repaired version of the input class
            dumpToFile(b2,classFileName);
            if(LIST_ASM_CODE) SimulaCompiler.doListClassFile(classFileName);
        } catch (Exception e) {
        	Util.println("ByteCodeEngineering FAILED for "+classFileName);
        	Util.error("ByteCodeEngineering FAILED for "+classFileName+", Exception="+e.getClass().getSimpleName()+", msg="+e.getMessage());
        	Util.INTERNAL_ERROR("ByteCodeEngineering.doRepairSingleByteCode FAILED: ", e);
        	Util.BREAK("CONTINUE ?");
        	//System.exit(0);
        } finally {
        	if(inputStream!=null)
				try { inputStream.close(); } catch (IOException e) { e.printStackTrace(); }
        }
    }
    
    private void dumpToFile(byte[] bytes,String classFileName) {
		if(DEBUG) Util.println("ByteCodeEngineering.dumpToFile: "+classFileName);
    	try {
    		OutputStream outputStream=new FileOutputStream(classFileName);
    		BufferedOutputStream out = new BufferedOutputStream(outputStream);
    		out.write(bytes,0,bytes.length);
    		out.flush();
    		out.close();
    	} catch (Exception ex) {
    		// again, catch any exceptions and...
    		// ...write to the debug console
    		System.err.println(ex.getMessage());
    	}

    }

}
