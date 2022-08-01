package simula.compiler.parsing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Hashtable;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

public class Directive {

	public static void treatDirectiveLine(final SimulaScanner scanner,final String id,final String arg) {
		if (id.equalsIgnoreCase("OPTION"))				Directive.setOption();
		else if (id.equalsIgnoreCase("INSERT"))			Directive.insert(scanner,arg);
//		else if (id.equalsIgnoreCase("MACRO"))      	Directive.defineMacro(scanner,id,arg);
		else if (id.equalsIgnoreCase("SPORT"))      	Directive.setSport(arg);
//		else if (id.equalsIgnoreCase("STANDARDCLASS"))	Directive.setStandardClass();
		else if (id.equalsIgnoreCase("TITLE"))			Directive.setTitle(arg);
		else if (id.equalsIgnoreCase("PAGE"))			Directive.page();
		else if (id.equalsIgnoreCase("KEEP_JAVA"))		Directive.setKeepJava(arg);
		else if (id.equalsIgnoreCase("EOF"))			Directive.eof(scanner);
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
	public static void insert(final SimulaScanner scanner,final String fileName) {
		Util.warning("%INSERT "+fileName);
		File file=new File(fileName);
//		System.out.println("file.exists="+file.exists());
//		System.out.println("file.canRead="+file.canRead());
		if(file.exists() && file.canRead()) {
//		    try {
//				Reader reader=new InputStreamReader(new FileInputStream(file),Global.CHARSET$);
//				String simpleName=file.getName();
//				scanner.insert(reader);
//		    } catch(IOException e) { Util.INTERNAL_ERROR("Impossible",e); }
			scanner.insert(file);
		} else Util.error("Can't open "+fileName+" for reading");
	}

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
    public static void setSport(final String onoff) {
    	Option.sport=(onoff.equalsIgnoreCase("ON"));
    	Util.warning("Compiler Directive: %SPORT sets Option.sport="+Option.sport);
    }
    
//    /**
//     * %STANDARDCLASS
//     * <p>
//     * Used to compile 'standard classes' to indicate simplified block structure.
//     * In addition all 'procedures' will be treated as Java Methods.
//     * <p>
//     * The initial value is false.
//     * See BlockDeclaration.java
//     */
//    public static void setStandardClass() {
//    	Util.warning("Compiler Directive: %STANDARDCLASS sets Option.standardClass=true");
//    	Option.standardClass=true;
//    }
    

//    /**
//     * %MACRO ON / OFF
//     * <p>
//%     DefineMacro is activated when %MACRO is recognised. The macro body
//%     is read lien by line, each line is split if the parameter marker
//%     (* /<integer>) is seen (see MacroLine below). The final line of
//%     all macro definitions is the 'EOFline', i.e. a MacroLine
//%     containing "%eof'!7!'". This line will, when the macro is expanded
//%     cause current input (the macro) to be closed.
//%
//%     Note: if %MACRO was conditionally compiled, i.e. preceded by
//%           selector testing (%+/-...), this PREFIX is stripped off
//%           each line if present. The test is a text value compare,
//%           no attempt is made to make any selector test. Thus, the
//%           sequence of multi tests MUST BE THE SAME!!! (this does not
//%           apply to the macro NAME, however).
//	 */
//    public static void defineMacro(final SimulaScanner scanner,final String id,final String arg) {
//    	Util.println("CALL defineMacro: id="+id+", arg="+arg);
//    	String macro="";
//    	String line=scanner.readMacroLine();
//    	while(!line.startsWith("%ENDMACRO")) {
//    		if(!line.startsWith("% ")) macro=macro+" "+line.trim();
//    		line=scanner.readMacroLine();
//    		Util.println("LINE: \""+line+"\"");
//    	}
//    	macro=macro.trim();
//    	Util.println("DEFINE MACRO: "+arg.toUpperCase()+", VALUE="+" \""+macro+"\"");
//    	MacroTab.put(arg.toUpperCase(), macro);
////    	MacroTab.put(macro,arg);
//    	//System.exit(-1);
//    }
//    
//    private static Hashtable<String,String> MacroTab=new Hashtable<String,String>();
//    
//    public static String lookupMacro(String name) {
//    	String res=MacroTab.get(name.toUpperCase()+':');
//    	if(name.equalsIgnoreCase("pushjump")) Util.println("LOOKUP MACRO: "+name+", res="+"\""+res+"\"");
//    	return(res);
//    }

	/**
	 * %EOF
	 */
    public static void eof(final SimulaScanner scanner) {
    	scanner.sourceFileReader.forceEOF();
    }

	/**
	 * %TITLE title-string
	 */
    public static void setTitle(final String title) {
//		Global.currentTitle = title;
//		Util.warning("NOT IMPLEMENTED: Compiler Directive: %TITLE");
	}

    /**
     * %KEEP_JAVA directory-string
     */
    public static void setKeepJava(final String dir) {
    	if(dir!=null) Option.keepJava=new File(dir);
    	else Util.warning("Missing directory in KEEP_JAVA directive");	
    	Util.BREAK("KEEP_JAVA: "+Option.keepJava);
    }

}
