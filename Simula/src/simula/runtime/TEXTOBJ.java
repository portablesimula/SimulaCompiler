/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import simula.compiler.utilities.Util;

/**
 * The Text Object.
 * <p>
 * A text object is conceptually an instance of
 * 
 * <pre>
 *    class TEXTOBJ( SIZE, CONST); integer SIZE; boolean CONST;
 *    begin character array MAIN( 1:SIZE ); end;
 * </pre>
 * 
 * Any text value processed by the program is contained within a text frame,
 * i.e. a non-empty segment of the MAIN attribute of some TEXTOBJ instance, or
 * it is empty (i.e. notext). See 2.5.
 * <p>
 * Any non-empty sequence of consecutive elements of the array attribute MAIN
 * constitutes a text frame. More specifically, any text frame is completely
 * identified by the following information:
 * <p>
 * <ul>
 * <li>a reference to the text object containing the frame,</li>
 * <li>the start position of the frame, being an ordinal number less than or
 * equal to SIZE,</li>
 * <li>the length of the frame.</li>
 * </ul>
 * <p>
 * A frame which is completely contained by another frame is called a "subframe"
 * of that frame. The text frame associated with the entire array attribute MAIN
 * is called the "main frame" of the text object. All frames of the text object
 * are subframes of the main frame.
 * <p>
 * Note: A main frame is a subframe of no frame except itself.
 * <p>
 * The frames of a text object are either all constant or all variable, as
 * indicated by the attribute CONST. The value of this attribute remains fixed
 * throughout the lifetime of the text object. A constant main frame always
 * corresponds to a string (see 1.6).
 * <p>
 * The attribute SIZE is always positive and remains fixed throughout the
 * lifetime of a text object.
 * <p>
 * Note: The identifier TEXTOBJ and its three attribute identifiers are not
 * accessible to the user. Instead, properties of a text object are accessible
 * through text variables, using the dot notation.
 * <p>
 * Note: <b>In this implementation the characters in MAIN are indexed 0 through SIZE-1.</b>
 * 
 * 
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class TEXTOBJ extends RTObject$ {
	// Declare parameters as attributes
	public int SIZE;
	public boolean CONST;
	// Declare locals as attributes
	char[] MAIN;

	public String toString() {
		return ("TEXTOBJ: SIZE=" + SIZE + ", CONST=" + CONST + ", MAIN=" + edText(0, SIZE));
	}

	// Utility
	public String edText(int start, int length) {
		StringBuilder s = new StringBuilder();
		for (int i = start; i < (start+length); i++) s.append(MAIN[i]);
		return (s.toString());
	}

	// Constructor
	public TEXTOBJ(int param_SIZE, boolean param_CONST) {
		super(null);
		// Parameter assignment to locals
		SIZE = param_SIZE;
		CONST = param_CONST;
		// Class Body
		MAIN = new char[SIZE];
		fill(' ');
		// Util.BREAK("new "+this);
	}

	// Constructor
	public TEXTOBJ(String s) {
		super(null);
		CONST = true;
		MAIN = s.toCharArray();
		SIZE = MAIN.length;
		// Util.BREAK("new "+this);
	}

	// Utility
	public void fill(char c) {
		// Util.BREAK("TEXTOBJ.fill(" + c + ')' + ", MAIN=" + MAIN.length);
		for (int i = 0; i < SIZE; i++)
			MAIN[i] = c;
	}
}
