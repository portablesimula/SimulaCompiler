package simula.compiler.parsing;

import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

public class Directive {

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
