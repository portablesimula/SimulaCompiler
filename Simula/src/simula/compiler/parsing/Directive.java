package simula.compiler.parsing;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

public class Directive {

	public static void treatDirectiveLine(SimulaScanner scanner,String id,String arg) {
		if (id.equalsIgnoreCase("OPTION"))				Directive.setOption();
		else if (id.equalsIgnoreCase("INSERT"))			Directive.insert(scanner,arg);
		else if (id.equalsIgnoreCase("SPORT"))      	Directive.setSport(arg);
		else if (id.equalsIgnoreCase("STANDARDCLASS"))	Directive.setStandardClass();
		else if (id.equalsIgnoreCase("TITLE"))			Directive.setTitle(arg);
		else if (id.equalsIgnoreCase("PAGE"))			Directive.page();
		else if (id.equalsIgnoreCase("KEEP_JAVA"))		Directive.setKeepJava(arg);
		else Util.warning("Unknown Compiler Directive: " + id+' '+arg);
	}
	
    /**
     * %INSERT file-name
     * <p>
     * Will cause the compiler to include the indicated file at this place in the
     * source input stream. INSERT may occur in the included file.
     * In contrast to COPY, the included lines are not counted (they will all be
     * numbered with the line number of the line containing the outermost INSERT).
	 * Furthermore, if the source is being listed, listing is turned off during 
	 * the inclusion and turned on again when reading continues after this directive. 
	 */
	public static void insert(SimulaScanner scanner,String fileName) {
//		CHECK("C:/GitHub/SimulaCompiler/Simula/src/testing/bin/");
//		CHECK("C:/GitHub/SimulaCompiler/Simula/src/testing/FEC/SYMTABLE.DEF");
//		CHECK("C:/GitHub/SimulaCompiler/Simula/src/testing/FEC/");
//		CHECK("C:/GitHub/SimulaCompiler/Simula/src/testing/");
//		CHECK(fileName);
		File file=new File(fileName);
		if(file.exists() && file.canRead()) {
		    try { scanner.insert(new FileReader(file));
		    } catch(IOException e) { e.printStackTrace(); }
		} else Util.error("Can't open "+fileName+" for reading");
	}
//	private static void CHECK(String fileName) {
//		File file=new File(fileName);
//		System.out.println("Directive.insert: file="+file);
//		System.out.println("Directive.insert: file.exists()="+file.exists());
//		System.out.println("Directive.insert: file.canRead()="+file.canRead());
//	}

	/**
	 * %PAGE
	 * <p>
	 * Will cause the compiler to change to a new page in the listing file. If the
	 * page heading (as defined by %TITLE, see below) is non-empty, it will be
	 * printed on top of the new page.
	 */
	public static void page() {
//		Util.warning("NOT IMPLEMENTED: Compiler Directive: %PAGE");
	}
  
    /**
     * %OPTION  name  value
     * <p>
     * Will set compiler switch 'name' to the value 'value'.
     * The facility is intended for compiler maitenance,
     * and is not explained further.
     */
    public static void setOption() {
    	Util.warning("NOT IMPLEMENTED: Compiler Directive: %OPTION");
    }
    
    /**
     * %SPORT ON / OFF
     * <p>
     * Enables/disables special S-Port Simula features, such as inclusion of the S-Port Library.
     * <p>
     * The initial value is ON.
     */
    public static void setSport(String onoff) {
    	Option.sport=(onoff.equalsIgnoreCase("ON"));
    	Util.warning("Compiler Directive: %SPORT sets Option.sport="+Option.sport);
    }
    
    /**
     * %STANDARDCLASS
     * <p>
     * Used to compile 'standard classes' to indicate simplified block structure.
     * In addition all 'procedures' will be treated as Java Methods.
     * <p>
     * The initial value is false.
     * See BlockDeclaration.java
     */
    public static void setStandardClass() {
    	Util.warning("Compiler Directive: %STANDARDCLASS sets Option.standardClass=true");
    	Option.standardClass=true;
    }

	/**
	 * %TITLE title-string
	 */
    public static void setTitle(String title) {
//		Global.currentTitle = title;
//		Util.warning("NOT IMPLEMENTED: Compiler Directive: %TITLE");
	}

    /**
     * %KEEP_JAVA directory-string
     */
    public static void setKeepJava(String dir) {
    	if(dir!=null) Option.keepJava=dir;
    	else Util.warning("Missing directory in KEEP_JAVA directive");	
    	Util.BREAK("KEEP_JAVA: "+Option.keepJava);
    }

}
