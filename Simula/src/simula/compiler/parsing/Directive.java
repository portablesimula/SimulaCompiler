package simula.compiler.parsing;

import java.io.File;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * Utility class Directive.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/parsing/Directive.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public class Directive {
	/**
	 * Default constructor.
	 */
	Directive() {
	}

	/**
	 * Treat a directive line.
	 * 
	 * @param scanner the scanner
	 * @param id      the directive identifier
	 * @param arg     the directive argument
	 */
	static void treatDirectiveLine(final SimulaScanner scanner, final String id, final String arg) {
		if (id.equalsIgnoreCase("OPTION"))
			Directive.setOption();
		else if (id.equalsIgnoreCase("INSERT"))
			Directive.insert(scanner, arg);
		else if (id.equalsIgnoreCase("SPORT"))
			Directive.setSport(arg);
		else if (id.equalsIgnoreCase("TITLE"))
			Directive.setTitle(arg);
		else if (id.equalsIgnoreCase("PAGE"))
			Directive.page();
		else if (id.equalsIgnoreCase("KEEP_JAVA"))
			Directive.setKeepJava(arg);
		else if (id.equalsIgnoreCase("EOF"))
			Directive.eof(scanner);
		else
			Util.warning("Unknown Compiler Directive: " + id + ' ' + arg);
	}

	/**
	 * %INSERT file-name
	 * <p>
	 * Will cause the compiler to include the indicated file at this place in the
	 * source input stream. INSERT may occur in the included file. In contrast to
	 * COPY, the included lines are not counted (they will all be numbered with the
	 * line number of the line containing the outermost INSERT). Furthermore, if the
	 * source is being listed, listing is turned off during the inclusion and turned
	 * on again when reading continues after this directive.
	 * 
	 * @param scanner the SimulaScanner
	 * @param fileName the file to insert
	 */
	private static void insert(final SimulaScanner scanner, final String fileName) {
		Util.warning("%INSERT " + fileName);
		File file = new File(fileName);
		if (file.exists() && file.canRead()) {
			scanner.insert(file);
		} else
			Util.error("Can't open " + fileName + " for reading");
	}

	/**
	 * %PAGE
	 * <p>
	 * Will cause the compiler to change to a new page in the listing file. If the
	 * page heading (as defined by %TITLE, see below) is non-empty, it will be
	 * printed on top of the new page.
	 */
	private static void page() {
		// Ignored in this implementation
	}

	/**
	 * %OPTION name value
	 * <p>
	 * Will set compiler switch 'name' to the value 'value'. The facility is
	 * intended for compiler maitenance, and is not explained further.
	 */
	private static void setOption() {
		Util.warning("NOT IMPLEMENTED: Compiler Directive: %OPTION");
	}

	/**
	 * %SPORT ON / OFF
	 * <p>
	 * Enables/disables special S-Port Simula features, such as inclusion of the
	 * S-Port Library.
	 * <p>
	 * The initial value is ON.
	 * 
	 * @param onoff the on/off string
	 */
	private static void setSport(final String onoff) {
		// Ignored in this implementation
	}

	/**
	 * %EOF
	 * 
	 * @param scanner the SimulaScanner
	 */
	private static void eof(final SimulaScanner scanner) {
		scanner.sourceFileReader.forceEOF();
	}

	/**
	 * %TITLE title-string
	 * 
	 * @param title title string
	 */
	private static void setTitle(final String title) {
		// Ignored in this implementation
	}

	/**
	 * %KEEP_JAVA directory-string
	 * 
	 * @param dir directory-string
	 */
	private static void setKeepJava(final String dir) {
		if (dir != null)
			Option.keepJava = new File(dir);
		else
			Util.warning("Missing directory in KEEP_JAVA directive");
	}

}
