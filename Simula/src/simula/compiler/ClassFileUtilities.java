package simula.compiler;

import java.io.IOException;

import org.apache.bcel.Constants;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.Code;
import org.apache.bcel.classfile.Constant;
import org.apache.bcel.classfile.ConstantClass;
import org.apache.bcel.classfile.ConstantPool;
import org.apache.bcel.classfile.ConstantUtf8;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;

import simula.compiler.utilities.Util;

public class ClassFileUtilities {

    static boolean code=true;
    static boolean constants=true;
    static boolean verbose=true;
    static boolean classdep=true;
    static boolean nocontents=false;//true;
    
    public static JavaClass load(String fileName)
    { //Util.BREAK("Load: "+fileName);
      JavaClass javaClass=null;
      try 
      { javaClass = new ClassParser(fileName).parse(); } // May throw IOException
	  catch (IOException e)
	  { System.out.println("Error Reading File");
		e.printStackTrace();
	  }
      return(javaClass);
    }

    /**
     * Print the given class on standard output
     */
//    public void list(String name) {
    public static void list(String name,JavaClass javaClass)
    { //Util.BREAK("ClassFileUtilities.list");
      try
      { if(nocontents)
             System.out.println(javaClass.getClassName());
        else System.out.println(javaClass);             // Dump the contents
        if(constants) System.out.println(javaClass.getConstantPool());
        if(code) printCode(javaClass.getMethods(), verbose);
        if(classdep) printClassDependencies(javaClass.getConstantPool());
      } catch(Exception e)
      { System.out.println("Error processing class " + name + " (" + e.getMessage() + ")"); }
    }

    /**
     * Dump the list of classes this class is dependent on
     */
    private static void printClassDependencies(ConstantPool pool) {
        System.out.println("Dependencies:");
        for (String name : getClassDependencies(pool)) {
            System.out.println("\t" + name);
        }
    }

    private static String[] getClassDependencies(ConstantPool pool) {
        String[] tempArray = new String[pool.getLength()];
        int size = 0;
        StringBuilder buf = new StringBuilder();

        for (int idx = 0; idx < pool.getLength(); idx++) {
            Constant c = pool.getConstant(idx);
            if (c != null && c.getTag() == Constants.CONSTANT_Class) {
                ConstantUtf8 c1 = (ConstantUtf8) pool.getConstant(((ConstantClass) c).getNameIndex());
                buf.setLength(0);
                buf.append(c1.getBytes());
                for (int n = 0; n < buf.length(); n++) {
                    if (buf.charAt(n) == '/') {
                        buf.setCharAt(n, '.');
                    }
                }

                tempArray[size++] = buf.toString();
            }
        }

        String[] dependencies = new String[size];
        System.arraycopy(tempArray, 0, dependencies, 0, size);
        return dependencies;
    }

    /**
     * Dump the disassembled code of all methods in the class.
     */
    private static void printCode(Method[] methods, boolean verbose) {
        for (Method method : methods) {
            System.out.println(method);

            Code code = method.getCode();
            if (code != null) {
                System.out.println(code.toString(verbose));
            }
        }
    }

}
