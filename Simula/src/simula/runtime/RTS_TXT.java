/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * The type text.
 * <p>
 * The type text serves to declare or specify a text variable quantity.
 * <p>
 * A text value is a string, i.e. an ordered sequence (possibly empty) of
 * characters. The number of characters is called the "length" of the text
 * value.
 * <p>
 * A text frame is a memory device which contains a nonempty text value. A text
 * frame has a fixed length and can only contain text values of this length. A
 * text frame may be "alterable" or "constant". A constant frame always contains
 * the same text value. An alterable text frame may have its contents modified.
 * The maximum length of a text frame is implementation-defined.
 * <p>
 * A text reference identifies a text frame. The reference is said to possess a
 * value, which is the contents of the identified frame. The special text
 * reference notext identifies "no frame". The value of notext is the empty text
 * value.
 * <p>
 * A text variable is conceptually an instance of a composite structure
 * 
 * <pre>
 *        ref(TEXTOBJ) OBJ; integer START, LENGTH, POS;
 * </pre>
 * <p>
 * It references (and has as its value the contents of) some text frame defined
 * by the three first components. POS identifies the current character. See 3.1.2.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_TXT.java"><b>Source File</b></a>.
 * 
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public final class RTS_TXT {
	/**
	 * Unicode minus sign = 8722 = 0x2212
	 */
	private static final int UNICODE_MINUS_SIGN = 8722; // 0x2212
	/**
	 * The Text object referred.
	 */
	RTS_TEXTOBJ OBJ;
	/**
	 * Start index of OBJ.MAIN[], counting from zero.
	 * <p>
	 * Note this differ from Simula Definition.
	 */
	int START;
	/**
	 * The length of this text.
	 */
	int LENGTH;
	/**
	 * Current index of OBJ.MAIN[], counting from zero.
	 * <p>
	 * Note this differ from Simula Definition.
	 */
	int POS;
	
	
	/**
	 * Create a new _TXT.
	 */
	public RTS_TXT() {
	}

	// Constructor
	/**
	 * Create a new _TXT containing the string s.
	 * @param s initial string value
	 */
	public RTS_TXT(final String s) {
		OBJ = new RTS_TEXTOBJ(s);
		START = 0; // Note: Counting from zero in this implementation
		LENGTH = OBJ.SIZE;
		POS = 0; // Note: Counting from zero in this implementation
	}

	@Override
	public String toString() {
		return ("_TEXT: START=" + START + ", LENGTH=" + LENGTH + ", POS=" + POS + ", OBJ=" + OBJ);
	}

	/**
	 * Utility: Edit text into a String.
	 * @return the resulting String
	 */
	String edText() {
		if (OBJ == null)
			return ("");
		return (OBJ.edText(START, LENGTH));
	}

	/**
	 * Utility: Edit stripped text into a String.
	 * @return the resulting String
	 */
	String edStripedText() {
		if (OBJ == null)
			return ("");
		RTS_TXT stp = RTS_TXT.strip(this);
		if (stp == null)
			return ("");
		return (stp.OBJ.edText(START, stp.LENGTH));
	}

	/**
	 * Utility: Edit text until current pos into a String.
	 * @return the resulting String
	 */
	String edTextToPos() {
		return (OBJ.edText(START, POS));
	}

	/**
	 * Procedure constant.
	 * @param T the argument text reference
	 * @return true if T is constant, otherwise false
	 */
	public static boolean constant(RTS_TXT T) {
		return (T == null || T.OBJ == null || T.OBJ.CONST);
	}

	/**
	 * Procedure start.
	 * @param T the argument text reference
	 * @return the start position of T within T'main frame
	 */
	public static int start(RTS_TXT T) {
		if (T == null)
			return (1);
		return (T.START + 1);
	}

	/**
	 * Procedure length.
	 * 
	 * @param T the argument text reference
	 * @return the length of T
	 */
	public static int length(RTS_TXT T) {
		if (T == null)
			return (0);
		return (T.LENGTH);
	}

	/**
	 * Procedure main.
	 * <p>
	 * "X.main" is a reference to the main frame which contains the frame referenced
	 * by X.
	 * <p>
	 * The following relations are true for any text variable X:
	 * 
	 * <pre>
	 *          X.main.length  >=  X.length
	 *          X.main.main    ==  X.main
	 * </pre>
	 * 
	 * In addition,
	 * 
	 * <pre>
	 *          notext.main    ==  notext
	 *          "ABC".main     =   "ABC" 
	 *         (but "ABC".main =/= "ABC")
	 * </pre>
	 * 
	 * @param T the argument text reference
	 * @return the main frame of T
	 */
	public static RTS_TXT main(RTS_TXT T) {
		if (T == null)
			return (null);
		if (T.OBJ == null)
			return (null);
		RTS_TXT U = new RTS_TXT();
		U.OBJ = T.OBJ;
		U.START = 0; // Note: Counting from zero in this implementation
		U.LENGTH = T.OBJ.SIZE;
		U.POS = 0; // Note: Counting from zero in this implementation
		return (U);
	}

	/**
	 * Procedure pos.
	 * <pre>
	 * 		integer procedure pos; pos := POS;
	 * </pre>
	 * @param T the argument text reference
	 * @return the current POS
	 */
	public static int pos(RTS_TXT T) {
		if (T == null)
			return (1);
		return (T.POS + 1);
	}

	/**
	 * Procedure setpos.
	 * <pre>
	 * 		procedure setpos(i); integer i;
	 * 			POS := if i &lt; 1 or i > LENGTH + 1 then LENGTH + 1 else i;
	 * </pre>
	 * @param T the argument text reference
	 * @param p the new POS
	 */
	public static void setpos(RTS_TXT T, int p) {
		if (T != null)
			T.POS = (p < 1 || p > T.LENGTH + 1) ? T.LENGTH : (p - 1);
	}

	/**
	 * Procedure more.
	 * 
	 * @param T the argument text reference
	 * @return true if T.pos &lt; T.length, otherwise false
	 */
	public static boolean more(RTS_TXT T) {
		if (T == null)
			return (false);
		return (T.POS < T.LENGTH);
	}

	/**
	 * Procedure getchar.
	 * <p>
	 * Get the character at the current POS of T.
	 * POS is then incremented.
	 * 
	 * @param T the argument text reference
	 * @return the character at the current pos
	 * @throws RTS_SimulaRuntimeError if the operation fail
	 */
	public static char getchar(RTS_TXT T) {
		if (T.POS >= T.LENGTH) {
			throw new RTS_SimulaRuntimeError("Getchar: pos >= length  pos=" + T.POS + ", length=" + T.LENGTH);
		} else {
			T.POS++;
			return (T.OBJ.MAIN[T.START + T.POS - 1]);
		}
	}

	/**
	 * Check if it is legal to assign to the given text reference.
	 * @param T the given text reference
	 * @throws RTS_SimulaRuntimeError if assignment is illegal
	 */
	private static void checkAssignable(RTS_TXT T) {
		if (T == null || T.OBJ == null)
			throw new RTS_SimulaRuntimeError("Illegal Text T.put...  T==NOTEXT");
		if (T.OBJ.CONST) {
			throw new RTS_SimulaRuntimeError("Illegal Text T.put...  T is constant, T=" + T);
		}
	}

	/**
	 * Procedure putchar.
	 * <p>
	 * Put the character c into the text T at the current POS.
	 * POS is then incremented.
	 * 
	 * @param T the argument text reference
	 * @param c the argument character
	 * @throws RTS_SimulaRuntimeError if the operation fail
	 */
	public static void putchar(final RTS_TXT T, final char c) {
		checkAssignable(T);
		if (T.POS >= T.LENGTH)
			throw new RTS_SimulaRuntimeError("Putchar outside frame");
		T.OBJ.MAIN[T.START + T.POS] = c;
		T.POS++;
	}

	/**
	 * Procedure sub.
	 * <p>
	 * If legal, "X.sub(i,n)" references that subframe of X whose first character is
	 * character number i of X, and which contains n consecutive characters. The POS
	 * attribute of the expression defines a local numbering of the characters
	 * within the subframe. If n = 0, the expression references notext.
	 * <p>
	 * If legal, the following Boolean expressions are true for any text variable X:
	 * 
	 * <pre>
	 *        X.sub(i,n).sub(j,m) == X.sub(i+j-1,m)
	 * 
	 *        n ne 0  imp  X.main == X.sub(i,n).main
	 * 
	 *        X.main.sub(X.start,X.length) == X
	 * </pre>
	 * 
	 * @param T the argument text reference
	 * @param i first character index
	 * @param n number of charaters
	 * @return the resulting text reference
	 * @throws RTS_SimulaRuntimeError if the operation fail
	 */
	public static RTS_TXT sub(RTS_TXT T, final int i, final int n) {
//		if (i < 0 || n < 0 || i + n > LENGTH + 1)  // NOTE: FEIL I SIMULA STANDARD
		if (i <= 0)
			throw new RTS_SimulaRuntimeError(" ! Sub(i=" + i + ",n=" + n + ") is out of frame, i <= 0");
		if (n < 0)
			throw new RTS_SimulaRuntimeError(" ! Sub(i=" + i + ",n=" + n + ") is out of frame, n < 0");
		if (T == null)
			T = RTS_ENVIRONMENT.NOTEXT;
		if (i + n > T.LENGTH + 1)
			throw new RTS_SimulaRuntimeError(
					" ! Sub(i=" + i + ",n=" + n + ") is out of frame, i + n > LENGTH + 1, LENGTH = " + T.LENGTH);
		else if (n > 0) {
			RTS_TXT U = new RTS_TXT();
			U.OBJ = T.OBJ;
			U.START = T.START + i - 1;
			U.LENGTH = n;
			U.POS = 0; // Note: Counting from zero in this implementation
			return (U);
		}
		return (null);
	}

	/**
	 * Procedure strip.
	 * <p>
	 * The expression "X.strip" is equivalent to "X.sub(1,n)", where n indicates the
	 * position of the last non-blank character in X. If X does not contain any
	 * non-blank character, notext is returned.
	 * <p>
	 * Let X and Y be text variables. Then after the value assignment "X:=Y", if
	 * legal, the relation "X.strip = Y.strip" has the value true, while "X = Y" is
	 * true only if X.length = Y.length.
	 * 
	 * @param T the argument text reference
	 * @return the resulting text reference
	 */
	public static RTS_TXT strip(RTS_TXT T) {
		if (T == null || T.OBJ == null)
			return (null);
		int n = T.LENGTH;
		while (T.OBJ.MAIN[T.START + n - 1] == ' ') {
			n = n - 1;
			if (n == 0)
				return (null);
		}
		RTS_TXT U = new RTS_TXT();
		U.OBJ = T.OBJ;
		U.START = T.START;
		U.LENGTH = n;
		U.POS = 0; // Note: Counting from zero in this implementation
		return (U);
	}

	/**
	 * Scan the input text for an integer item.
	 * <pre>
	 * INTEGER-ITEM = SIGN-PART DIGITS
	 *
	 *    SIGN-PART = BLANKS [ SIGN ] BLANKS
	 *
	 *       SIGN = + | -
	 *
	 *       DIGITS = DIGIT { DIGIT }
	 *
	 *       DIGIT = 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
	 * </pre>
	 * 
	 * @param T the input text
	 * @return the resulting string
	 */
	private static String getIntegerItem(final RTS_TXT T) {
		StringBuilder sb = new StringBuilder();
		char c = 0;
		T.POS = 0;
		while (T.POS < T.LENGTH) { // SKIP BLANKS
			c = T.OBJ.MAIN[T.START + T.POS];
			if (c != ' ')
				break;
			T.POS++;
		}
		if (c == '+' || c == '-') {
			sb.append(c);
			T.POS = T.POS + 1;
			while (T.POS < T.LENGTH) { // SKIP BLANKS
				c = T.OBJ.MAIN[T.START + T.POS];
				if (c != ' ')
					break;
				T.POS++;
			}
		}
		while (T.POS < T.LENGTH) { // KEEP DIGITS
			c = T.OBJ.MAIN[T.START + T.POS];
			if (!Character.isDigit(c))
				break;
			sb.append(c);
			T.POS++;
		}
		return (sb.toString());
	}

	/**
	 * Procedure getint.
	 * <pre>
	 * INTEGER-ITEM = SIGN-PART DIGITS
	 *
	 *    SIGN-PART = BLANKS [ SIGN ] BLANKS
	 *
	 *       SIGN = + | -
	 *
	 *       DIGITS = DIGIT { DIGIT }
	 *
	 *       DIGIT = 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
	 * </pre>
	 * The procedure locates an INTEGER ITEM. The function value is
	 * equal to the corresponding integer.
	 * 
	 * @param T the text reference
	 * @return the resulting real
	 */
	public static int getint(final RTS_TXT T) {
		String item = getIntegerItem(T);
		int res = Integer.parseInt(item);
		return (res);
	}

	/**
	 * Scan the input text for a real item.
	 * <pre>
	 * REAL-ITEM = DECIMAL-ITEM [ EXPONENT ] | SIGN-PART EXPONENT
	 *
	 *    DECIMAL-ITEM = INTEGER-ITEM [ FRACTION ] | SIGN-PART FRACTION
	 *
	 *       INTEGER-ITEM = SIGN-PART DIGITS
	 *
	 *       FRACTION = DECIMAL-MARK DIGITS
	 *
	 *       SIGN-PART = BLANKS [ SIGN ] BLANKS
	 *
	 *    EXPONENT = LOWTEN-CHARACTER INTEGER-ITEM
	 *
	 *          SIGN = + | -
	 *
	 *          DIGITS = DIGIT { DIGIT }
	 *
	 *          DIGIT = 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
	 *
	 *          LOWTEN-CHARACTER = &amp; | ...
	 *
	 *          DECIMAL-MARK = . | ,
	 *
	 *          BLANKS = { BLANK | TAB }
	 * </pre>
	 * 
	 * @param T the input text
	 * @return the resulting string
	 */
	private static String getRealItem(final RTS_TXT T) {
		StringBuilder sb = new StringBuilder();
		char c = 0;
		T.POS = 0;
		while (T.POS < T.LENGTH) { // SKIP BLANKS
			c = T.OBJ.MAIN[T.START + T.POS];
			if (c != ' ')
				break;
			T.POS++;
		}
		if (c == '+' || c == '-') {
			sb.append(c);
			T.POS++;
			while (T.POS < T.LENGTH) { // SKIP BLANKS
				c = T.OBJ.MAIN[T.START + T.POS];
				if (c != ' ')
					break;
				T.POS++;
			}
		}
		while (T.POS < T.LENGTH) { // KEEP DIGITS
			int lastDigPos = T.POS;
			c = T.OBJ.MAIN[T.START + T.POS];
			if (Character.isDigit(c))
				; // OK
			else if (c == RTS_ENVIRONMENT.CURRENTDECIMALMARK)
				c = '.'; // OK
			else if (c == '+')
				; // OK
			else if (c == '-')
				; // OK
			else if (c == RTS_ENVIRONMENT.CURRENTLOWTEN)
				c = 'E'; // OK
			else {
				T.POS = lastDigPos;
				break;
			}
			sb.append(c);
			lastDigPos = T.POS;
			T.POS++;
		}
		return (sb.toString());
	}

	/**
	 * Procedure getreal.
	 * <pre>
	 * REAL-ITEM = DECIMAL-ITEM [ EXPONENT ] | SIGN-PART EXPONENT
	 *
	 *    DECIMAL-ITEM = INTEGER-ITEM [ FRACTION ] | SIGN-PART FRACTION
	 *
	 *       INTEGER-ITEM = SIGN-PART DIGITS
	 *
	 *       FRACTION = DECIMAL-MARK DIGITS
	 *
	 *       SIGN-PART = BLANKS [ SIGN ] BLANKS
	 *
	 *    EXPONENT = LOWTEN-CHARACTER INTEGER-ITEM
	 *
	 *          SIGN = + | -
	 *
	 *          DIGITS = DIGIT { DIGIT }
	 *
	 *          DIGIT = 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
	 *
	 *          LOWTEN-CHARACTER = &amp; | ...
	 *
	 *          DECIMAL-MARK = . | ,
	 *
	 *          BLANKS = { BLANK | TAB }
	 * </pre>
	 * The procedure locates a REAL ITEM. The function value is equal
	 * to or approximates to the corresponding number. An INTEGER ITEM
	 * exceeding a certain implementation-defined range may lose
	 * precision when converted to long real.
	 * 
	 * @param T the text reference
	 * @return the resulting real
	 */
	public static double getreal(final RTS_TXT T) {
		String item = getRealItem(T);
		double res = Double.parseDouble(item);
		return (res);
	}

	/**
	 * Scan the input text for a fraction item.
	 * <pre>
	 * GROUPED-ITEM = SIGN-PART GROUPS [ DECIMAL-MARK GROUPS ]
	 *              | SIGN-PART DECIMAL-MARK GROUPS
	 *
	 * SIGN-PART = BLANKS [ SIGN ] BLANKS
	 *
	 * SIGN = + | -
	 *
	 * GROUPS = DIGITS { BLANK DIGITS } DIGITS = DIGIT { DIGIT }
	 *
	 * DIGIT = 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
	 * </pre>
	 * 
	 * @param T the input text
	 * @return the resulting string
	 */
	private static String getFracItem(final RTS_TXT T) {
		StringBuilder sb = new StringBuilder();
		char c = 0;
		T.POS = 0;
		while (T.POS < T.LENGTH) { // SKIP BLANKS
			c = T.OBJ.MAIN[T.START + T.POS];
			if (c != ' ')
				break;
			T.POS++;
		}
		if (c == '+' || c == '-') {
			sb.append(c);
			T.POS++;
			while (T.POS < T.LENGTH) { // SKIP BLANKS
				c = T.OBJ.MAIN[T.START + T.POS];
				if (c != ' ')
					break;
				T.POS++;
			}
		}
		int lastDigPos = T.POS;
		while (T.POS < T.LENGTH) { // KEEP DIGITS
			c = T.OBJ.MAIN[T.START + T.POS];
			if (Character.isDigit(c)) {
				sb.append(c);
				lastDigPos = T.POS;
			} // OK
			else if (c == RTS_ENVIRONMENT.CURRENTDECIMALMARK)
				; // OK NOTE: THIS WAS WRONG IN PC-SIMULA
			else if (c == ' ')
				; // OK
			else
				break;
			T.POS++;
		}
		T.POS = lastDigPos + 1;
		return (sb.toString());
	}

	/**
	 * Procedure getfrac.
	 * <pre>
	 * GROUPED-ITEM = SIGN-PART GROUPS [ DECIMAL-MARK GROUPS ]
	 *              | SIGN-PART DECIMAL-MARK GROUPS
	 *
	 * SIGN-PART = BLANKS [ SIGN ] BLANKS
	 *
	 * SIGN = + | -
	 *
	 * GROUPS = DIGITS { BLANK DIGITS } DIGITS = DIGIT { DIGIT }
	 *
	 * DIGIT = 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
	 * </pre>
	 * The procedure locates a GROUPED ITEM. The function value is
	 * equal to the resulting integer. The digits of a GROUPED ITEM
	 * may be interspersed with BLANKS and a single DECIMAL MARK which
	 * are ignored by the procedure.
	 * 
	 * @param T the text reference
	 * @return the resulting integer
	 */
	public static int getfrac(final RTS_TXT T) {
		return (Integer.parseInt(getFracItem(T)));
	}

	/**
	 * Put the result of putReal type operation into the text T.
	 * @param T the text reference
	 * @param output the result of putReal
	 */
	private static void putRealResult(final RTS_TXT T, String output) {
		if (RTS_ENVIRONMENT.CURRENTDECIMALMARK != ',')
			output = output.replace(',', RTS_ENVIRONMENT.CURRENTDECIMALMARK);
		putResult(T, output);
	}

	/**
	 * Put the result of put... operation into the text T.
	 * <p>
	 * If the text frame is too short to contain the resulting numeric item, the
	 * text frame into which the number was to be edited is filled with asterisks.
	 * The final value of the position indicator of X is X.length+1.
	 * 
	 * @param T the text reference
	 * @param s the result of put... operation
	 */
	private static void putResult(RTS_TXT T, final String s) {
		checkAssignable(T);
		char[] c = s.toCharArray();
		if (c.length > T.LENGTH) {
			RTS_COMMON.numberOfEditOverflows++;
			for (int j = 0; j < T.LENGTH; j = j + 1)
				T.OBJ.MAIN[T.START + j] = '*';
		} else {
			int m = c.length - 1;
			for (int j = T.LENGTH - 1; j >= 0; j = j - 1) {
				char k = (m >= 0) ? c[m--] : ' ';
				if (Character.toUpperCase(k) == 'E')
					k = RTS_ENVIRONMENT.CURRENTLOWTEN;
				if (k == 160)
					k = ' '; // String formatted with NumberFormat
								// may have non-breaking space
								// (hexa code : A0 and unicode 160).
				T.OBJ.MAIN[T.START + j] = k;
			}
		}
		T.POS = T.LENGTH;
	}

	/**
	 * Procedure putint.
	 * <p>
	 * The value of the parameter is converted to an INTEGER ITEM which designates
	 * an integer equal to that value.
	 * 
	 * @param T the text reference
	 * @param i the integer value to be edited
	 */
	public static void putint(final RTS_TXT T, final int i) {
		putResult(T, "" + i);
	}

	/**
	 * Procedure putfix.
	 * <p>
	 * The resulting numeric item is an INTEGER ITEM if n=0 or a DECIMAL ITEM with a
	 * FRACTION of n digits if n>0. It designates a number equal to the value of r
	 * or an approximation to the value of r, correctly rounded to n decimal places.
	 * If n&lt;0, a run-time error is caused.
	 * 
	 * @param T the text reference
	 * @param r the long real value to be edited
	 * @param n the number of digits after decimal sign
	 */
	public static void putfix(final RTS_TXT T, double r, int n) {
		if (n < 0)
			throw new RTS_SimulaRuntimeError("putfix(r,n) - n < 0");
		if (n == 0) {
			putint(T, (int) (r + 0.5));
			return;
		}
		StringBuilder pattern = new StringBuilder("##0.");
		while ((n--) > 0)
			pattern.append('0');
		DecimalFormat myFormatter = new DecimalFormat(pattern.toString());
		if (r == -0.0)
			r = 0.0; // NOTE: Java har både +0.0 og -0.0
		String output = myFormatter.format(r);
		output = output.replace((char) UNICODE_MINUS_SIGN, '-');
		putRealResult(T, output);
	}

	/**
	 * Procedure putreal.
	 * <p>
	 * The resulting numeric item is a REAL ITEM containing an EXPONENT with a fixed
	 * implementation-defined number of characters. The EXPONENT is preceded by a
	 * SIGN PART if n=0, or by an INTEGER ITEM with one digit if n=1, or if n>1, by
	 * a DECIMAL ITEM with an INTEGER ITEM of 1 digit only, and a fraction of n-1
	 * digits. If n&lt;0 a runtime error is caused.
	 * 
	 * @param T the text reference
	 * @param r the long real value to be edited
	 * @param n the number of digits after decimal sign
	 */
	public static void putreal(final RTS_TXT T, double r, int n) {
		if (n < 0)
			throw new RTS_SimulaRuntimeError("putreal(r,n) - n < 0");
		if (r == -0.0d)
			r = 0.0d;
		StringBuilder pattern = new StringBuilder("0");
		if (n > 1)
			pattern.append('.');
		while ((n--) > 1)
			pattern.append('0');
		pattern.append("E000");
		DecimalFormat myFormatter = new DecimalFormat(pattern.toString());
		myFormatter.setRoundingMode(RoundingMode.HALF_EVEN); // Java Default
		String output = myFormatter.format(r);
		output = output.replace((char) UNICODE_MINUS_SIGN, '-');
		output = addPlussExponent(output);
		putRealResult(T, output);
	}

	/**
	 * Procedure putreal.
	 * <p>
	 * See <b>{@link RTS_TXT#putreal(RTS_TXT,double,int)}</b>
	 * 
	 * @param T the text reference
	 * @param r the real value to be edited
	 * @param n the number of digits after decimal sign
	 */
	public static void putreal(final RTS_TXT T, float r, int n) {
		if (n < 0)
			throw new RTS_SimulaRuntimeError("putreal(r,n) - n < 0");
		if (r == -0.0f)
			r = 0.0f;
		StringBuilder pattern = new StringBuilder("0");
		if (n > 1)
			pattern.append('.');
		while ((n--) > 1)
			pattern.append('0');
		pattern.append("E00");
		DecimalFormat myFormatter = new DecimalFormat(pattern.toString());
		myFormatter.setRoundingMode(RoundingMode.HALF_EVEN); // Java Default
		String output = myFormatter.format(r);
		output = output.replace((char) UNICODE_MINUS_SIGN, '-');
		output = addPlussExponent(output);
		putRealResult(T, output);
	}

	/**
	 * Real Edit Utility: Add plus exponent to the given string 
	 * @param s the given string
	 * @return the resulting string
	 */
	private static String addPlussExponent(String s) {
		s = s.replace((char) UNICODE_MINUS_SIGN, '-');
		String[] part = s.split("E");
		if (part.length == 2) {
			if (!(part[1].startsWith("-")))
				s = part[0] + "E+" + part[1];
		}
		return (s);
	}

	/**
	 * Procedure putfrac.
	 * <p>
	 * The resulting numeric item is a GROUPED ITEM with no DECIMAL MARK if n&lt;=0,
	 * and with a DECIMAL MARK followed by total of n digits if n>0. Each digit
	 * group consists of 3 digits, except possibly the first one, and possibly the
	 * last one following a DECIMAL MARK. The numeric item is an exact
	 * representation of the number i * 10**(-n).
	 * 
	 * @param T the text reference
	 * @param val an integer value
	 * @param n number of digits after a decimal mark
	 */
	public static void putfrac(final RTS_TXT T, final int val, final int n) {
		int v; // Scaled value (abs)
		int d; // Number of digits written
		int r; // Remaining digits in current group
		int p; // Next available position in item
		int c; // Current digit (numerical)
		char[] item = new char[T.LENGTH];

		if (n <= 0)
			r = 3;
		else {
			r = n % 3;
			if (r == 0)
				r = 3;
		}

		v = Math.abs(val);
		d = 0;
		p = item.length - 1;
		try {
			while ((v > 0) || (d < n)) {
				c = v % 10;
				v = v / 10;
				if (r == 0) {
					r = 3;
					if (d != n)
						item[p--] = ' ';
				}
				item[p--] = (char) (c + '0');
				r = r - 1;
				d = d + 1;
				if (d == n)
					item[p--] = RTS_ENVIRONMENT.CURRENTDECIMALMARK;
			}
			if (val < 0)
				item[p--] = '-';
			while (p >= 0)
				item[p--] = ' ';
		} catch (ArrayIndexOutOfBoundsException e) {
			RTS_COMMON.numberOfEditOverflows++;
			for (int i = 0; i < item.length; i++)
				item[i] = '*';
		}
		for (int i = 0; i < item.length; i++)
			T.OBJ.MAIN[T.START + i] = item[i];
	}

}
