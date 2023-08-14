/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import simula.runtime.RTS_COMMON.Option;

/**
 * System class ENVIRONMENT.
 * <p>
 * The purpose of the environmental class is to encapsulate all constants,
 * procedures and classes which are accessible to all source modules. It
 * contains procedures for mathematical functions, text generation, random
 * drawing, etc.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_ENVIRONMENT.java"><b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class RTS_ENVIRONMENT extends RTS_RTObject {
	/**
	 * The Simula release identification.
	 * <p>
	 * NOTE: When updating release id, change version in setup.SimulaExtractor and simula.Global
	 */
	static final String simulaReleaseID = "Simula-2.0";

	/**
	 * The start time from System.currentTimeMillis
	 */
	static long _STARTTIME = System.currentTimeMillis();
	
	/**
	 * The current lowten character.
	 */
	static char CURRENTLOWTEN = '&';
	
	/**
	 * The current decimal mark character.
	 */
	static char CURRENTDECIMALMARK = '.';
	
	/**
	 * A constant holding the maximum value a long real can have.
	 */
	public final static double maxlongreal = Double.MAX_VALUE;

	/**
	 * A constant holding the minimum value a long real can have.
	 */
	public final static double minlongreal = -maxlongreal;// Double.MIN_VALUE;
	
	/**
	 * A constant holding the maximum value a real can have.
	 */
	public final static float maxreal = Float.MAX_VALUE;
	
	/**
	 * A constant holding the minimum value a real can have.
	 */
	public final static float minreal = -maxreal;// Float.MIN_VALUE;
	
	/**
	 * A constant holding the maximum value an integer can have.
	 */
	public final static int maxint = Integer.MAX_VALUE;
	
	/**
	 * A constant holding the minimum value an integer can have.
	 */
	public final static int minint = Integer.MIN_VALUE;

	// Constructor
	/**
	 * Normal Constructor
	 * @param staticLink static link
	 */
	public RTS_ENVIRONMENT(final RTS_RTObject staticLink) {
		super(staticLink);
	}


	/**
	 * Simula identification String.
	 * <p>
	 * The value of "simulaid" is an implementation defined string of the following
	 * general format:
	 * 
	 * <pre>
	 *     &lt;simid>!!!&lt;siteid>!!!&lt;OS>!!!&lt;CPU>!!!&lt;user>!!!&lt;job>!!!&lt;acc>!!!&lt;prog>
	 * 
	 *         &lt;simid>:   Identification of the SIMULA system (name, version etc.)
	 *         &lt;siteid>:  Identification of the installation (e.g. organisation name)
	 *         &lt;OS>:      Operating system identification (name, version, etc.)
	 *         &lt;CPU>:     Host system identification (manufacturer, name, number, etc.)
	 *         &lt;user>:    User identification
	 *         &lt;job>:     Job identification (session number)
	 *         &lt;acc>:     Account identification
	 *         &lt;prog>:    Identification of the executing task or program
	 * </pre>
	 * 
	 * @return Simula identification String.
	 */
	public static RTS_TXT simulaid() {
		String simid = "Portable " + simulaReleaseID;
		String OS = System.getProperty("os.name");
		String CPU = System.getProperty("os.arch");
		String user = System.getProperty("user.name");
		user=new String(user.getBytes(), StandardCharsets.US_ASCII);
		String job = RTS_COMMON.progamIdent;
		String acc = user;
		String prog = RTS_COMMON.progamIdent;
		String siteid=OS+'.'+user;
		
		String simulaIdent = simid + "!!!" + siteid + "!!!" + OS + "!!!" + CPU + "!!!" + user + "!!!" + job + "!!!" + acc + "!!!" + prog;
		return (new RTS_TXT(simulaIdent));
	}

	// ************************************************************
	// *** object IS classIdentifier
	// ************************************************************
	
	/**
	 * Object relation: IS.
	 * <pre>
	 *       simple-object-expression is class-identifier
	 * </pre>
	 * 
	 * @param obj object reference
	 * @param cls class reference
	 * @return true: relation holds
	 */
	public static boolean _IS(final Object obj, final Class<?> cls) {
		return ((obj == null) ? false : (obj.getClass() == cls));
	}

	// *****************************************
	// *** Basic operations ***
	// *****************************************

	/**
	 * Standard Procedure mod.
	 * <pre>
	 * integer procedure mod(i,j);   integer i,j;
	 * begin integer res;
	 *    res := i - (i//j)*j;
	 *    mod := if res = 0 then 0
	 *      else if sign(res) ne sign(j) then res+j
	 *      else res
	 * end mod;
	 * </pre>
	 * <p>
	 * The result is the mathematical modulo value of the parameters.
	 * 
	 * @param i argument i
	 * @param j argument j
	 * @return the resulting mod
	 */
	public static int mod(final int i, final int j) {
		int res = i % j;
		if (res == 0)
			return (0);
		if (res * j < 0)
			return (res + j);
		return (res);
	}

	/**
	 * Standard Procedure rem.
	 * <pre>
	 * integer procedure rem(i,j);   integer i,j;
	 *                   rem := i - (i//j)*j;
	 * </pre>
	 * <p>
	 * The result is the remainder of an integer division.
	 * 
	 * 
	 * @param i argument i
	 * @param j argument j
	 * @return the resulting rem
	 */
	public static int rem(final int i, final int j) {
		return (i % j);
	}

	/**
	 * Standard Procedure abs.
	 * <pre>
	 * &lt;type of e> procedure abs(e); &lt;type> e;
	 *       abs := if e >= 0 then e else -e;
	 * </pre>
	 * 
	 * The result is the absolute value of the parameter.
	 * 
	 * @param e the argument
	 * @return the resulting abs value
	 */
	public static int abs(final int e) {
		return (Math.abs(e));
	}

	/**
	 * Standard Procedure abs.
	 * See {@link RTS_ENVIRONMENT#abs(int)}
	 * @param e the argument
	 * @return the resulting abs value
	 */
	public static float abs(final float e) {
		return (Math.abs(e));
	}

	/**
	 * Standard Procedure abs.
	 * See {@link RTS_ENVIRONMENT#abs(int)}
	 * @param e the argument
	 * @return the resulting abs value
	 */
	public static double abs(final double e) {
		return (Math.abs(e));
	}

	/**
	 * Standard Procedure sign.
	 * <pre>
	 * integer procedure sign(e);    e;
	 *     sign := if e > 0 then  1
	 *        else if e &lt; 0 then -1 else 0;
	 * </pre>
	 * 
	 * The result is zero if the parameter is zero, one if the parameter is
	 * positive, and minus one otherwise.
	 * 
	 * @param e the argument e
	 * @return resulting sign code
	 */
	public static int sign(final double e) {
		return ((e > 0) ? (1) : ((e < 0) ? -1 : 0));
	}

	/**
	 * Standard Procedure entier.
	 * <pre>
	 * integer procedure entier(r); &lt;real-type> r;
	 * begin integer j;
	 *       j := r;             ! implied conversion of "r" to integer ;
	 *       entier:= if j > r   ! implied conversion of "j" to real ;
	 *                then j-1 else j
	 * end entier;
	 * </pre>
	 * 
	 * The result is the integer "floor" of a real type item, the value always being
	 * less than or equal to the parameter. Thus, entier(1.8) returns the value 1,
	 * while entier(-1.8) returns -2.
	 * 
	 * @param d argument d
	 * @return the resulting entier
	 */
	public static int entier(final double d) {
		int j = (int) d;
		return ((((float) j) > d) ? (j - 1) : (j));
	}

	/**
	 * Integer Power: b ** x
	 * @param b argument b
	 * @param x argument x
	 * @return b ** x
	 */
	public static int _IPOW(final int b, int x) {
		if (x == 0) {
			if (b == 0)
				throw new RTS_SimulaRuntimeError("Exponentiation: " + b + " ** " + x + "  Result is undefined.");
			return (1); // any ** 0 ==> 1
		} else if (x < 0)
			throw new RTS_SimulaRuntimeError("Exponentiation: " + b + " ** " + x + "  Result is undefined.");
		else if (b == 0)
			return (0); // 0 ** non_zero ==> 0

		long res = (long) Math.pow((double) b, (double) x);
		if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
			throw new RTS_SimulaRuntimeError("Arithmetic overflow: " + b + " ** " + x + " ==> " + res
					+ " which is outside integer value range[" + Integer.MIN_VALUE + ':' + Integer.MAX_VALUE + ']');
		return ((int) res);
	}

	/**
	 * Standard Procedure addepsilon.
	 * 
	 * <pre>
	 * &lt;type of e> procedure addepsilon(e);   &lt;real-type> e;
	 *     addepsilon := e + ... ; ! see below;
	 * </pre>
	 * <p>
	 * The result type is that of the parameter. The result is the value of the
	 * parameter incremented by the
	 * smallest positive value, such that the result is not equal to the parameter
	 * within the precision of the implementation.
	 * <p>
	 * Thus, for all positive values of "eps",
	 * <pre>
	 *       E - eps &lt;= subepsilon(E) &lt; E &lt; addepsilon(E) &lt;= E + eps
	 * </pre>
	 * 
	 * @param x float argument
	 * @return the argument incremented by the smallest possible value
	 */
	public static float addepsilon(final float x) {
		return (Math.nextUp(x));
	}

	/**
	 * Standard Procedure addepsilon.
	 * See {@link RTS_ENVIRONMENT#addepsilon(float)}
	 * @param x double argument
	 * @return the argument incremented by the smallest possible value
	 */
	public static double addepsilon(final double x) {
		return (Math.nextUp(x));
	}

	/**
	 * Standard Procedure subepsilon.
	 * 
	 * <pre>
	 * &lt;type of e> procedure subepsilon(e);   &lt;real-type> e;
	 *     subepsilon := e - ... ; ! see below;
	 * </pre>
	 * <p>
	 * The result type is that of the parameter. The result is the value of the
	 * parameter decremented by the
	 * smallest positive value, such that the result is not equal to the parameter
	 * within the precision of the implementation.
	 * <p>
	 * Thus, for all positive values of "eps",
	 * <pre>
	 *       E - eps &lt;= subepsilon(E) &lt; E &lt; addepsilon(E) &lt;= E + eps
	 * </pre>
	 * 
	 * @param x float argument
	 * @return the argument decremented by the smallest possible value
	 */
	public static float subepsilon(final float x) {
		return (Math.nextDown(x));
	}

	/**
	 * Standard Procedure subepsilon.
	 * See {@link RTS_ENVIRONMENT#subepsilon(float)}
	 * @param x double argument
	 * @return the argument decremented by the smallest possible value
	 */
	public static double subepsilon(final double x) {
		return (Math.nextDown(x));
	}

	/**
	 * Standard Procedure char.
	 * <pre>
	 * character procedure char(i);  integer i;
	 *    char := ... ;
	 * </pre>
	 * 
	 * The result is the character obtained by converting the parameter according to
	 * the implementation-defined coding of characters. The parameter must be in the
	 * range 0..maxrank.
	 * 
	 * @param i an integer agrgument
	 * @return the casted value: (char) i
	 */
	public static char Char(final int i) {
		return ((char) i);
	}

	/**
	 * Standard Procedure char.
	 * See {@link RTS_ENVIRONMENT#Char(int)}
	 * 
	 * @param i an integer agrgument
	 * @return the casted value: (char) i
	 */
	public static char _char(final int i) {
		return ((char) i);
	}

	/**
	 * Standard Procedure isochar.
	 * <pre>
	 * character procedure isochar(i);  integer i;
	 *    isochar := ... ;
	 * </pre>
	 * 
	 * The result is the character obtained by converting the parameter according to
	 * the ISO 2022 standard character code. The parameter must be in the range
	 * 0..255.
	 * 
	 * @param i an integer agrgument
	 * @return the casted value: (char) i
	 */
	public static char isochar(final int i) {
		return ((char) i);
	}

	/**
	 * Standard Procedure rank.
	 * <pre>
	 * integer procedure rank(c);  character c;
	 *    rank := ... ;
	 * </pre>
	 * 
	 * The result is the integer obtained by converting the parameter according to
	 * the implementation-defined character code.
	 * 
	 * @param c the argument
	 * @return resulting rank
	 */
	public static int rank(final char c) {
		return ((int) c);
	}

	/**
	 * Standard Procedure isorank.
	 * <pre>
	 * integer procedure isorank(c);  character c;
	 *    isorank := ... ;
	 * </pre>
	 * 
	 * The result is the integer obtained by converting the parameter according to
	 * the ISO 2022 standard character code.
	 * 
	 * @param c the argument
	 * @return resulting isorank
	 */
	public static int isorank(final char c) {
		return ((int) c);
	}

	/**
	 * Standard Procedure digit.
	 * <pre>
	 * Boolean procedure digit(c);  character c;
	 *    digit := ... ;
	 * </pre>
	 * 
	 * The result is true if the parameter is a decimal digit.
	 * 
	 * @param c the argument
	 * @return true: c is a digit
	 */
	public static boolean digit(final char c) {
		return (Character.isDigit(c));
	}

	/**
	 * Standard Procedure letter.
	 * <pre>
	 * Boolean procedure letter(c);  character c;
	 *    letter := ... ;
	 * </pre>
	 * 
	 * The result is true if the parameter is a letter of the English alphabet ('a' ... 'z', 'A' ... 'Z').
	 * 
	 * @param c the argument
	 * @return true: c is a letter
	 */
	public static boolean letter(final char c) {
		return (Character.isLetter(c));
	}

	/**
	 * Standard Procedure lowten.
	 * <pre>
	 * character procedure lowten(c);  character c;
	 *                   if ... ! c is illegal as lowten;
	 *                   then  error("..." ! Lowten error ;)
	 *                   else begin
	 *                      lowten:= CURRENTLOWTEN; CURRENTLOWTEN:= c
	 *                    end lowten;
	 * </pre>
	 * 
	 * Changes the value of the current lowten character to that of the parameter.
	 * The previous value is returned. Illegal parameters are
	 * <p>
	 * digits, plus ("+"), minus ("-"), dot ("."), comma (","), control characters
	 * (i.e. ISO code&lt;32), DEL (ISO code 127), and all characters with ISO code
	 * greater than 127.
	 * 
	 * @param c the new lowten character
	 * @return the previous lowten character
	 */
	public static char lowten(final char c) {
		if (illegalLowten(c))
			throw new RTS_SimulaRuntimeError("Illegal LOWTEN Character: " + c + "  Code=" + (int) c);
		char lowten = CURRENTLOWTEN;
		CURRENTLOWTEN = Character.toUpperCase(c);
		return (lowten);
	}

	/**
	 * Check if the given character is illegal as lowten.
	 * @param c the given character
	 * @return true if the given character is illegal as lowten.
	 */
	private static boolean illegalLowten(final char c) {
		if (c <= 32)
			return (true); // SPACE is also Illegal in this implementation
		if (c >= 127)
			return (true);
		switch (c) {
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
		case '+':
		case '-':
		case '.':
		case ',':
			return (true);
		}
		return (false);
	}

	/**
	 * Standard Procedure decimalmark.
	 * <pre>
	 * character procedure decimalmark(c);   character c;
	 *    if c ne '.' and then c ne ','
	 *    then error("..." ! Decimalmark error ;)
	 *    else begin
	 *            decimalmark:= CURRENTDECIMALMARK;
	 *            CURRENTDECIMALMARK:= c
	 * end decimalmark;
	 * </pre>
	 * 
	 * Changes the value of the decimal point character used by the text (de)editing
	 * procedures (cf. 8.7 and 8.8). See the _TXT methods: getreal, getfrac, putfix,
	 * putreal and putfrac. The previous value is returned. The only legal parameter
	 * values are dot and comma.
	 * 
	 * @param c the new decimalmark character
	 * @return the previous decimalmark character
	 */
	public static char decimalmark(final char c) {
		char decimalmark = 0;
		if (c != '.' && c != ',') {
			throw new RTS_SimulaRuntimeError("Decimalmark error: " + c);
		} else {
			decimalmark = CURRENTDECIMALMARK;
			CURRENTDECIMALMARK = c;
		}
		return (decimalmark);
	}

	/**
	 * Standard Procedure uppercase.
	 * <pre>
	 * text procedure upcase(t);   text t;
	 *    begin  t.setpos(1); upcase:- t;  ... end;
	 * </pre>
	 * 
	 * Convert the letters in the text parameter to their upper case representation.
	 * Only letters of the English alphabet are converted.
	 * <p>
	 * The result is a reference to the parameter.
	 * 
	 * @param t the argument text
	 * @return same text with upper case letters
	 */
	public static RTS_TXT upcase(RTS_TXT t) {
		if (t == null)
			t = NOTEXT;
		String s = t.edText().toUpperCase();
		return (_ASGTXT(t, new RTS_TXT(s)));
	}

	/**
	 * Standard Procedure lowcase.
	 * <pre>
	 * text procedure lowcase(t); text t;
	 *                begin  t.setpos(1); lowcase:- t; ... end;
	 * </pre>
	 * 
	 * Convert the letters in the text parameter to their lower case representation.
	 * Only letters of the English alphabet are converted.
	 * <p>
	 * The result is a reference to the parameter.
	 * 
	 * @param t the argument text
	 * @return same text with lower case letters
	 */
	public static RTS_TXT lowcase(RTS_TXT t) {
		if (t == null)
			t = NOTEXT;
		String s = t.edText().toLowerCase();
		return (_ASGTXT(t, new RTS_TXT(s)));
	}

	// *****************************************
	// *** Mathematical functions ***
	// *****************************************

	/**
	 * Standard Procedure sqrt.
	 * @param r the parameter r
	 * @return Math.sqrt(r)
	 */
	public static double sqrt(final double r) {
		return (Math.sqrt(r));
	}

	/**
	 * Standard Procedure sin.
	 * @param r the parameter r
	 * @return Math.sin(r)
	 */
	public static double sin(final double r) {
		return (Math.sin(r));
	}

	/**
	 * Standard Procedure cos.
	 * @param r the parameter r
	 * @return Math.cos(r)
	 */
	public static double cos(final double r) {
		return (Math.cos(r));
	}

	/**
	 * Standard Procedure tan.
	 * @param r the parameter r
	 * @return Math.tan(r)
	 */
	public static double tan(final double r) {
		return (Math.tan(r));
	}

	/**
	 * Standard Procedure cotan.
	 * @param r the parameter r
	 * @return 1.0 / Math.tan(r)
	 */
	public static double cotan(final double r) {
		return (1.0 / Math.tan(r));
	}

	/**
	 * Standard Procedure arcsin.
	 * @param r the parameter r
	 * @return Math.asin(r)
	 */
	public static double arcsin(final double r) {
		return (Math.asin(r));
	}

	/**
	 * Standard Procedure arccos.
	 * @param r the parameter r
	 * @return Math.acos(r)
	 */
	public static double arccos(final double r) {
		return (Math.acos(r));
	}

	/**
	 * Standard Procedure arctan.
	 * @param r the parameter r
	 * @return Math.atan(r)
	 */
	public static double arctan(final double r) {
		return (Math.atan(r));
	}

	/**
	 * Standard Procedure arctan2.
	 * @param x the parameter x
	 * @param y the parameter y
	 * @return Math.atan2(x,y)
	 */
	public static double arctan2(final double y, final double x) {
		return (Math.atan2(y, x));
	}

	/**
	 * Standard Procedure sinh.
	 * @param r the parameter r
	 * @return Math.sinh(r)
	 */
	public static double sinh(final double r) {
		return (Math.sinh(r));
	}

	/**
	 * Standard Procedure cosh.
	 * @param r the parameter r
	 * @return Math.cosh(r)
	 */
	public static double cosh(final double r) {
		return (Math.cosh(r));
	}

	/**
	 * Standard Procedure tanh.
	 * @param r the parameter r
	 * @return Math.tanh(r)
	 */
	public static double tanh(final double r) {
		return (Math.tanh(r));
	}

	/**
	 * Standard Procedure ln.
	 * @param r the parameter r
	 * @return Math.log(r)
	 */
	public static double ln(final double r) {
		return (Math.log(r));
	}

	/**
	 * Standard Procedure log10.
	 * @param r the parameter r
	 * @return Math.log10(r)
	 */
	public static double log10(final double r) {
		return (Math.log10(r));
	}

	/**
	 * Standard Procedure exp.
	 * @param r the parameter r
	 * @return Math.exp(r)
	 */
	public static double exp(final double r) {
		return (Math.exp(r));
	}

	// *****************************************
	// *** Extremum functions ***
	// *****************************************

	/**
	 * Standard Procedure max.
	 * <pre>
	 *  &lt;type> procedure max(i1,i2); &lt;type> i1; &lt;type> i2;
	 * </pre>
	 * 
	 * The value is the greater of the two parameter values. Legal parameter types
	 * are text, character, real type and integer type.
	 * <p>
	 * The type of the result conforms to the rules of 3.3.1. in Simula Standard.
	 * 
	 * @param x the parameter x
	 * @param y the parameter y
	 * @return the greater of the two parameter values
	 */
	public static double max(final double x, final double y) {
		return (Math.max(x, y));
	}

	/**
	 * Standard Procedure max.
	 * See {@link RTS_ENVIRONMENT#max(double,double)}
	 * @param x the parameter x
	 * @param y the parameter y
	 * @return the greater of the two parameter values
	 */
	public static float max(final float x, final float y) {
		return (Math.max(x, y));
	}

	/**
	 * Standard Procedure max.
	 * See {@link RTS_ENVIRONMENT#max(double,double)}
	 * @param x the parameter x
	 * @param y the parameter y
	 * @return the greater of the two parameter values
	 */
	public static int max(final int x, final int y) {
		return (Math.max(x, y));
	}

	/**
	 * Standard Procedure max.
	 * See {@link RTS_ENVIRONMENT#max(double,double)}
	 * @param x the parameter x
	 * @param y the parameter y
	 * @return the greater of the two parameter values
	 */
	public static char max(final char x, final char y) {
		return ((char) Math.max((int) x, (int) y));
	}

	/**
	 * Standard Procedure max.
	 * See {@link RTS_ENVIRONMENT#max(double,double)}
	 * @param x the parameter x
	 * @param y the parameter y
	 * @return the greater of the two parameter values
	 */
	public static RTS_TXT max(final RTS_TXT x, final RTS_TXT y) {
		return (_TXTREL_LT(x, y) ? y : x);
	}

	/**
	 * Standard Procedure min.
	 * <pre>
	 * &lt;type> procedure min(i1,i2); &lt;type> i1;  &lt;type> i2;
	 * </pre>
	 * 
	 * The value is the lesser of the two parameter values. Legal parameter types
	 * are text, character, real type and integer type.
	 * <p>
	 * The type of the result conforms to the rules of 3.3.1. in Simula Standard.
	 * 
	 * @param x the parameter x
	 * @param y the parameter y
	 * @return the lesser of the two parameter values
	 */
	public static double min(final double x, final double y) {
		return (Math.min(x, y));
	}

	/**
	 * Standard Procedure min.
	 * See {@link RTS_ENVIRONMENT#min(double,double)}
	 * @param x the parameter x
	 * @param y the parameter y
	 * @return the lesser of the two parameter values
	 */
	public static float min(final float x, final float y) {
		return (Math.min(x, y));
	}

	/**
	 * Standard Procedure min.
	 * See {@link RTS_ENVIRONMENT#min(double,double)}
	 * @param x the parameter x
	 * @param y the parameter y
	 * @return the lesser of the two parameter values
	 */
	public static int min(final int x, final int y) {
		return (Math.min(x, y));
	}

	/**
	 * Standard Procedure min.
	 * See {@link RTS_ENVIRONMENT#min(double,double)}
	 * @param x the parameter x
	 * @param y the parameter y
	 * @return the lesser of the two parameter values
	 */
	public static char min(final char x, final char y) {
		return ((char) Math.min((int) x, (int) y));
	}

	/**
	 * Standard Procedure min.
	 * See {@link RTS_ENVIRONMENT#min(double,double)}
	 * @param x the parameter x
	 * @param y the parameter y
	 * @return the lesser of the two parameter values
	 */
	public static RTS_TXT min(final RTS_TXT x, final RTS_TXT y) {
		return (_TXTREL_LT(x, y) ? x : y);
	}

	// *****************************************
	// *** Error control ***
	// *****************************************

	/**
	 * Standard Procedure error.
	 * <pre>
	 * procedure error(t);   text t;
	 *    begin ... display text "t" and stop program...
	 *    end error;
	 * </pre>
	 * 
	 * The procedure "error" stops the execution of the program as if a runtime
	 * error has occurred and presents the contents of the text parameter on the
	 * diagnostic channel (normally the controlling terminal).
	 * 
	 * @param msg error message text
	 */
	public static void error(final RTS_TXT msg) {
		throw new RTS_SimulaRuntimeError(msg.edText());
	}

	// *****************************************
	// *** Array quantities ***
	// *****************************************

	/**
	 * Standard Procedure lowerbound.
	 * <pre>
	 *  integer procedure lowerbound(a,i);
	 *          &lt;type> array a; integer i;
	 * </pre>
	 * 
	 * The procedure "lowerbound" returns the lower bound of the dimension of the
	 * given array corresponding to the given index. The first dimension has index
	 * one, the next two, etc. An index less than one or greater than the number of
	 * dimensions of the given array constitutes a run time error.
	 * 
	 * @param a _ARRAY reference
	 * @param i bounds index
	 * @return the lower bound
	 */
	public static int lowerbound(final RTS_ARRAY a, final int i) {
		try {
			return (a.lowerBound(i - 1));
		} catch (RTS_SimulaRuntimeError e) {
			throw new RTS_SimulaRuntimeError("Wrong number of dimensions", e);
		}
	}

	/**
	 * Standard Procedure upperbound.
	 * <pre>
	 *  integer procedure upperbound(a,i);
	 *          &lt;type> array a; integer i;
	 * </pre>
	 * 
	 * The procedure "upperbound" returns the upper bound of the dimension of the
	 * given array corresponding to the given index. The first dimension has index
	 * one, the next two, etc. An index less than one or greater than the number of
	 * dimensions of the given array constitutes a run time error.
	 * 
	 * @param a _ARRAY reference
	 * @param i bounds index
	 * @return the upper bound
	 */
	public static int upperbound(final RTS_ARRAY a, final int i) {
		try {
			return (a.upperBound(i - 1));
		} catch (RTS_SimulaRuntimeError e) {
			throw new RTS_SimulaRuntimeError("Wrong number of dimensions", e);
		}
	}

	// *********************************************************************
	// *** Random drawing ***
	// *********************************************************************

	// **********************************************************************
	// *** Random drawing: Procedure draw
	// **********************************************************************
	/**
	 * Random drawing: Procedure draw.
	 * <pre>
	 *  Boolean procedure draw (a,U);
	 *                name U; long real a; integer U;
	 * 
	 * The value is true with the probability a, false with the probability 1 - a.
	 * It is always true if a >= 1 and always false if a &lt;= 0.
	 * </pre>
	 * 
	 * @param a The long real parameter a
	 * @param U The pseudo random number (seed) by name.
	 * @return Returns the next pseudorandom with the probability a
	 */
	public static boolean draw(final double a, final RTS_NAME<Integer> U) {
		boolean res;
		if (a >= 1.0)
			res = true;
		else if (a <= 0.0)
			res = false;
		else
			res = a >= RTS_RandomDrawing.basicDRAW(U);
		return (res);
	}

	// **********************************************************************
	// *** Random drawing: Procedure randint
	// **********************************************************************
	/**
	 * Random drawing: randint distribution
	 * <pre>
	 *  integer procedure randint (a,b,U);
	 *		          name U; integer a,b,U;
	 * </pre>
	 * 
	 * The value is one of the integers a, a+1, ..., b-1, b with equal probability.
	 * If b &lt; a, the call constitutes an error.
	 *
	 * @param a The integer parameter a
	 * @param b The integer parameter b
	 * @param U The pseudo random number (seed) by name.
	 * @return Returns the next pseudorandom, according to the randint distribution
	 */
	public static int randint(final int a, final int b, final RTS_NAME<Integer> U) {
		if (b < a)
			throw new RTS_SimulaRuntimeError("Randint(a,b,u):  b < a");
		return (entier(RTS_RandomDrawing.basicDRAW(U) * ((b - a + 1))) + a);
	}

	// **********************************************************************
	// *** Random drawing: Procedure uniform
	// **********************************************************************
	/**
	 * Random drawing: uniform distribution
	 * <pre>
	 * long real procedure uniform (a,b,U);
	 *          name U; long real a,b; integer U;
	 * </pre>
	 * 
	 * The value is uniformly distributed in the interval a &lt;= u &lt; b. If b &lt; a, the
	 * call constitutes an error.
	 * 
	 * @param a The long real parameter a
	 * @param b The long real parameter b
	 * @param U The pseudo random number (seed) by name.
	 * @return Returns the next pseudorandom, according to the uniform distribution
	 */
	public static double uniform(final double a, final double b, final RTS_NAME<Integer> U) {
		if (b < a)
			throw new RTS_SimulaRuntimeError("Uniform(a,b,u): b < a");
		return (a + ((b - a) * RTS_RandomDrawing.basicDRAW(U)));
	}

	// **********************************************************************
	// *** Random drawing: Procedure normal
	// **********************************************************************
	/**
	 * Random drawing: normal distribution.
	 * <pre>
	 * long real procedure normal (a,b,U);
	 *         name U; long real a,b; integer U;
	 * </pre>
	 * 
	 * The value is normally distributed with mean a and standard deviation b. An
	 * approximation formula may be used for the normal distribution function.
	 * 
	 * @param a The long real parameter a
	 * @param b The long real parameter b
	 * @param U The pseudo random number (seed) by name.
	 * @return Returns the next pseudorandom, according to the negexp distribution
	 */
	public static double normal(final double a, final double b, final RTS_NAME<Integer> U) {
		double t, p, q, v, x;
		boolean z;
		if (b < 0.0)
			throw new RTS_SimulaRuntimeError("Normal(a,b,u):  b <= 0.");
		v = RTS_RandomDrawing.basicDRAW(U);
		if (v > 0.5) {
			z = true;
			v = 1.0f - v;
		} else
			z = false;
		t = Math.log(v); // log is natural logarithm (base e) in Java
		t = Math.sqrt(-t - t);
		p = 2.515517f + (t * (0.802853f + (t * 0.010328f)));
		q = 1.0f + (t * (1.432788f + (t * (0.189269f + (t * 0.001308f)))));
		x = b * (t - (p / q));
		double res = a + ((z) ? x : -x);
		return (res);
	}

	// **********************************************************************
	// *** Random drawing: Procedure negexp
	// **********************************************************************
	/**
	 * Random drawing: negexp distribution.
	 * <pre>
	 * long real procedure negexp (a,U);
	 *          name U; long real a; integer U;
	 * </pre>
	 * 
	 * The value is a drawing from the negative exponential distribution with mean
	 * 1/a, defined by -ln(u)/a, where u is a basic drawing. This is the same as a
	 * random "waiting time" in a Poisson distributed arrival pattern with expected
	 * number of arrivals per time unit equal to a.
	 * <p>
	 * If a is non-positive, a runtime error occurs.
	 * 
	 * @param a The long real parameter a
	 * @param U The pseudo random number (seed) by name.
	 * @return Returns the next pseudorandom, according to the negexp distribution
	 */
	public static double negexp(final double a, final RTS_NAME<Integer> U) {
		if (a <= 0.0)
			throw new RTS_SimulaRuntimeError("Negexp(a,u): a <= 0");
		return (-Math.log(RTS_RandomDrawing.basicDRAW(U)) / a);
	}

	// **********************************************************************
	// *** Random drawing: Procedure Poisson
	// **********************************************************************
	/**
	 * Random drawing: Poisson distribution.
	 * <pre>
	 * integer procedure Poisson (a,U);
	 *          name U; long real a; integer U;
	 * </pre>
	 * 
	 * The value is a drawing from the Poisson distribution with parameter a. It is
	 * obtained by n+1 basic drawings, u(i), where n is the function value. n is
	 * defined as the smallest non-negative integer for which
	 * <p>
	 * u(0) * u(1) * ... * u(n) &lt; e**(-a)
	 * <p>
	 * The validity of the formula follows from the equivalent condition
	 * <p>
	 * -ln(u(0)) - ln(u(1)) - ... - ln(u(n)) > 1
	 * <p>
	 * where the left hand side is seen to be a sum of "waiting times" drawn from
	 * the corresponding negative exponential distribution.
	 * <p>
	 * When the parameter a is greater than some implementation-defined value, for
	 * instance 20.0, the value may be approximated by entier(normal(a,sqrt(a),U) +
	 * 0.5) or, when this is negative, by zero.
	 * 
	 * @param a The long real parameter a
	 * @param U The pseudo random number (seed) by name.
	 * @return Returns the next pseudorandom, according to the Poisson distribution
	 */
	public static int Poisson(double a, final RTS_NAME<Integer> U) {
		int res;
		if (a <= 0.0)
			res = 0;
		else if (a > 20.0) {
			// entier(normal(a,sqrt(a),U) + 0.5)
			double sqa = Math.sqrt(a);
			res = entier(normal(a, sqa, U) + 0.5);
		} else {
			double acc = 1.0;
			res = 0;
			double xpa = Math.exp(-a);
			do {
				acc = acc * RTS_RandomDrawing.basicDRAW(U);
				res = res + 1;
			} while (acc >= xpa);
			res = res - 1;
		}
		return (res);
	}

	// **********************************************************************
	// *** Random drawing: Procedure Erlang
	// **********************************************************************
	/**
	 * Random drawing: Erlang distribution.
	 * <pre>
	 * long real procedure Erlang (a,b,U);
	 *          name U; long real a,b; integer U;
	 * </pre>
	 * 
	 * The value is a drawing from the Erlang distribution with mean 1/a and
	 * standard deviation 1/(a*sqrt(b)). It is defined by b basic drawings u(i), if
	 * b is an integer value,
	 * <p>
	 * - ( ln(u(1)) + ln(u(2)) + ... + ln(u(b)) ) / (a*b)
	 * <p>
	 * and by c+1 basic drawings u(i) otherwise, where c is equal to entier(b),
	 * <p>
	 * - ( ln(u(1)) + ... + ln(u(c)) + (b-c)*ln(u(c+1)) ) / (a*b)
	 * <p>
	 * Both a and b must be greater than zero.
	 * <p>
	 * The last formula represents an approximation.
	 *
	 * @param a The long real parameter a
	 * @param b The long real parameter b
	 * @param U The pseudo random number (seed) by name.
	 * @return Returns the next pseudorandom, according to the Erlang distribution
	 */
	public static double Erlang(final double a, final double b, final RTS_NAME<Integer> U) {
		double res;
		if (a <= 0.0 || b <= 0.0)
			throw new RTS_SimulaRuntimeError("Erlang(a,b,u):  a <= 0  or  b <= 0");
		res = 0;
		int c = entier(b);
		double bc = b - c;
		double ab = a * b;
		while ((c--) > 0) {
			double v = RTS_RandomDrawing.basicDRAW(U);
			double z = Math.log(v);
			res = res - (z / ab);
		}
		if (bc > 0.0) {
			double v = RTS_RandomDrawing.basicDRAW(U);
			double z = Math.log(v);
			res = res - ((bc * z) / ab);
		}
		return (res);
	}

	// **********************************************************************
	// *** Random drawing: Procedure discrete
	// **********************************************************************
	/**
	 * Random drawing: discrete distribution.
	 * <pre>
	 *  integer procedure discrete (A,U);
	           name U; &lt;real-type> array A; integer U;
	 * </pre>
	 * 
	 * The one-dimensional array A, augmented by the element 1 to the right, is
	 * interpreted as a step function of the subscript, defining a discrete
	 * (cumulative) distribution function.
	 * <p>
	 * The function value satisfies
	 * <p>
	 * lowerbound(A,1) &lt;= discrete(A,U) &lt;= upperbound(A,1)+1.
	 * <p>
	 * It is defined as the smallest i such that A(i) > u, where u is a basic
	 * drawing and A(upperbound(A,1)+1) = 1.
	 * 
	 * @param A a real-type array
	 * @param U The pseudo random number (seed) by name.
	 * @return Returns the next pseudorandom, discrete distributed according to the array A
	 */
	public static int discrete(final RTS_REALTYPE_ARRAY A, final RTS_NAME<Integer> U) {
		int result;
		int lb = A.lowerBound(0);
		int ub = A.upperBound(0);
		double v = RTS_RandomDrawing.basicDRAW(U);
		int nelt = ub - lb + 1;
		result = ub + 1;
		int j = 0;
		do {
			if (A.getRealTypeELEMENT(j) > v) {
				result = lb + j;
				nelt = 0;
			}
			j = j + 1;
		} while (j < nelt);
		return (result);
	}

	// **********************************************************************
	// *** Random drawing: Procedure linear
	// **********************************************************************
	/**
	 * Random drawing: linear distribution.
	 * <pre>
	 *  long real procedure linear (A,B,U);
	 *       name U; &lt;real-type> array A,B; integer U;
	 * </pre>
	 * 
	 * The value is a drawing from a (cumulative) distribution function F, which is
	 * obtained by linear interpolation in a non-equidistant table defined by A and
	 * B, such that A(i) = F(B(i)).
	 * <p>
	 * It is assumed that A and B are one-dimensional arrays of the same length,
	 * that the first and last elements of A are equal to 0 and 1 respectively and
	 * that A(i) >= A(j) and B(i) > B(j) for i>j. If any of these conditions are not
	 * satisfied, the effect is implementation-defined.
	 * <p>
	 * The steps in the function evaluation are:
	 * <p>
	 * l. draw a uniform &lt;0,1> random number, u.
	 * <p>
	 * 2. determine the lowest value of i, for which
	 * <p>
	 * A(i-1) &lt;= u &lt;= A(i)
	 * <p>
	 * 3. compute D = A(i) - A(i-1)
	 * <p>
	 * 4. if D = 0: linear = B(i-1) if D ne 0: linear = B(i-1) + (B(i) -
	 * B(i-1))*(u-A(i-1))/D
	 * 
	 * @param A a real-type array
	 * @param B a real-type array
	 * @param U The pseudo random number (seed) by name.
	 * @return Returns the next pseudorandom, lineary distributed according to the arrays A and B
	 */
	public static double linear(final RTS_REALTYPE_ARRAY A, final RTS_REALTYPE_ARRAY B, final RTS_NAME<Integer> U) {
		double res;
		int nelt = A.SIZE;
		if (nelt != B.SIZE)
			throw new RTS_SimulaRuntimeError("Linear(A,B,U): The number of elements in A and B are different.");
		double v = RTS_RandomDrawing.basicDRAW(U);
		int i = 0;
		while (A.getRealTypeELEMENT(i) < v)
			i = i + 1;
		if (i == 0) {
			if (v == 0.0 && A.getRealTypeELEMENT(i) == 0.0)
				i = 1;
			else
				throw new RTS_SimulaRuntimeError("Linear(A,B,U): The array a does not satisfy the stated assumptions.");
		} else if (i >= nelt)
			throw new RTS_SimulaRuntimeError("Linear(A,B,U): The array a does not satisfy the stated assumptions.");

		double a_val = A.getRealTypeELEMENT(i);
		double a_lag = A.getRealTypeELEMENT(i - 1);
		double a_dif = a_val - a_lag;
		if (a_dif == 0.0)
			res = B.getRealTypeELEMENT(i - 1);
		else {
			double b_val = B.getRealTypeELEMENT(i);
			double b_lag = B.getRealTypeELEMENT(i - 1);
			res = (((b_val - b_lag) / a_dif) * (v - a_lag)) + b_lag;
		}
		return (res);
	}

	// **********************************************************************
	// *** Utility: Procedure histd
	// **********************************************************************
	/**
	 * Utility: Procedure histd.
	 * <pre>
	 * integer procedure histd (A,U);
	 *          name U; &lt;real-type> array A; integer U;
	 * </pre>
	 * 
	 * The value is an integer in the range (lsb,usb), where lsb and usb are the
	 * lower and upper subscript bounds of the one-dimensional array A. The latter
	 * is interpreted as a histogram defining the relative frequencies of the
	 * values.
	 * 
	 * @param A a real-type array
	 * @param U The pseudo random number (seed) by name.
	 * @return Returns the next pseudorandom, distributed according to the array A
	 */
	public static int histd(final RTS_REALTYPE_ARRAY A, final RTS_NAME<Integer> U) {
		int result = 0;
		int j; // Array index.
		int nelt; // Number of array elements.
		double sum; // Sum of all array element values.
		double wsum; // Weighted sum of all array element values.
		double tmp; // Temporary variabel.

		int lb = A.lowerBound(0);
		nelt = A.SIZE;
		j = 0;
		sum = 0.0;
		do {
			tmp = A.getRealTypeELEMENT(j);
			if (tmp < 0.0)
				throw new RTS_SimulaRuntimeError("Histd(a,u):  An element of the array a is negative");
			sum = sum + tmp;
			j = j + 1;
		} while (j < nelt);
		wsum = sum * RTS_RandomDrawing.basicDRAW(U); // Make 0 <= wsum < sum
		j = 0;
		sum = 0.0;
		do {
			sum = sum + A.getRealTypeELEMENT(j);
			if (sum >= wsum) {
				result = lb + j;
				nelt = 0;
			} // We will do this once and only once.
			j = j + 1;
		} while (j < nelt);
		return (result);
	}

	// *****************************************
	// *** Calendar and timing utilities ***
	// *****************************************
	/**
	 * Standard Procedure datetime.
	 * <pre>
	 * text procedure datetime;   datetime :- Copy("...");
	 * </pre>
	 * 
	 * The value is a text frame containing the current date and time in the form
	 * YYYY-MM-DD HH:MM:SS.sss.... The number of decimals in the field for seconds
	 * is implementation-defined.
	 * 
	 * @return a formated text
	 */
	public static RTS_TXT datetime() {
		DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		String datim = LocalDateTime.now().format(form);
		return (new RTS_TXT(datim));
	}

	/**
	 * Standard Procedure cputime.
	 * <pre>
	 * long real procedure cputime;
	 * </pre>
	 * 
	 * The value is the number of processor seconds spent by the calling program.
	 * 
	 * @return seconds since start of program
	 */
	public static double cputime() {
		double cputime = System.currentTimeMillis() - _STARTTIME;
		return (cputime / 1000);
	}

	/**
	 * Standard Procedure clocktime.
	 * <pre>
	 * long real procedure clocktime;
	 * </pre>
	 * 
	 * @return The value is the number of seconds since midnight.
	 */
	public static double clocktime() {
		LocalTime localTime = LocalTime.now();
		int hour = localTime.getHour();
		int minute = localTime.getMinute();
		int second = localTime.getSecond();
		double time = ((hour * 60) + minute) * 60 + second;
		return (time);
	}

	// *****************************************
	// *** Miscellaneous utilities ***
	// *****************************************

	/**
	 * Standard Procedure histo.
	 * <pre>
	 * procedure histo(A,B,c,d);
	          real array A,B; real c,d;
	 * </pre>
	 * 
	 * Procedure statement "histo(A,B,c,d)" updates a histogram defined by the
	 * one-dimensional arrays A and B according to the observation c with the weight
	 * d. A(lba+i) is increased by d, where i is the smallest integer such that c &lt;=
	 * B(lbb+i) and lba and lbb are the lower bounds of A and B respectively. If the
	 * length of A is not one greater than that of B the effect is
	 * implementation-defined. The last element of A corresponds to those
	 * observations which are greater than all elements of B.
	 * 
	 * @param A real array a
	 * @param B real array b
	 * @param c real value c
	 * @param d real value d
	 */
	public static void histo(final RTS_REAL_ARRAY A, final RTS_REAL_ARRAY B, final float c, final float d) {
		if (A.nDim() != 1)
			throw new RTS_SimulaRuntimeError("histo(A,B,c,d) - A is not one-dimensional");
		if (B.nDim() != 1)
			throw new RTS_SimulaRuntimeError("histo(A,B,c,d) - B is not one-dimensional");
		int nelt = B.SIZE;
		if (nelt >= A.SIZE)
			throw new RTS_SimulaRuntimeError("histo(A,B,c,d) - A'length <= B'length");
		int i = 0;
		EX: do {
			if (B.ELTS[i] >= c)
				break EX;
			i = i + 1;
		} while (i < nelt);
		A.ELTS[i] = A.ELTS[i] + d;
	}

	// **********************************************************************
	// *** Additional Standard Procedures
	// **********************************************************************

	// **********************************************************************
	// *** Editing: Text Procedure edit, edfix, edtime
	// **********************************************************************

	/**
	 * Extended Standard procedure edit.
	 * @param n the argument
	 * @return the edited text
	 */
	public static RTS_TXT edit(final boolean n) {
		return (new RTS_TXT("" + n));
	}

	/**
	 * Extended Standard procedure edit.
	 * @param n the argument
	 * @return the edited text
	 */
	public static RTS_TXT edit(final char n) {
		return (new RTS_TXT("" + n));
	}

	/**
	 * Extended Standard procedure edit.
	 * @param n the argument
	 * @return the edited text
	 */
	public static RTS_TXT edit(final long n) {
		return (new RTS_TXT(("" + n)));
	}

	/**
	 * Extended Standard procedure edit.
	 * @param n the argument
	 * @return the edited text
	 */
	public static RTS_TXT edit(final float n) {
		return (new RTS_TXT(("" + n).replace('E', '&')));
	}

	/**
	 * Extended Standard procedure edit.
	 * @param n the argument
	 * @return the edited text
	 */
	public static RTS_TXT edit(final double n) {
		return (new RTS_TXT(("" + n).replace("E", "&&")));
	}

	/**
	 * Extended Standard procedure edit.
	 * @param r the real argument
	 * @param n number of digits after decimal sign
	 * @return the edited text
	 */
	public static RTS_TXT edfix(final double r, final int n) {
		RTS_TXT T = blanks(n + 10);
		RTS_TXT.putfix(T, r, n);
		String S = T.edText().trim();
		return (new RTS_TXT(S));
	}
	
	/**
	 * Edit simulated time.
	 * @param hours simulated time 
	 * @return the edited text
	 */
	public static RTS_TXT edtime(double hours) {
		return(new RTS_TXT(LocalTime.ofSecondOfDay((long) (hours*60*60)).toString()));
	}


	// **********************************************************************
	// *** Utility: Procedure waitSomeTime
	// **********************************************************************
	
	/**
	 * Extended Standard procedure waitSomeTime.
	 * @param millies wait time in millisecods
	 */
	public static void waitSomeTime(final int millies) {
		try {
			Thread.sleep(millies);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// **********************************************************************
	// *** Utility: Procedure printThreadList
	// **********************************************************************
	/**
	 * Extended Standard procedure printThreadList.
	 * @param withStackTrace true: if stacktrace is wanted
	 */
	public static void printThreadList(final boolean withStackTrace) {
		RTS_COMMON.printThreadList(withStackTrace);
	}

	// **********************************************************************
	// *** Utility: Procedure printStaticChain
	// **********************************************************************
	
	/**
	 * Extended Standard procedure printStaticChain.
	 * <p>
	 * See {@link RTS_ENVIRONMENT#DEFEXCEPTION(RTS_PRCQNT)}
	 */
	public static void printStaticChain() {
		RTS_COMMON.printStaticChain(RTS_RTObject._CUR);
	}

	// **********************************************************************
	// *** Additional S-Port'like Procedures
	// **********************************************************************

	/**
	 * The registered EXCEPTION_HANDLER or null.
	 */
	public static RTS_PRCQNT EXCEPTION_HANDLER = null;

	/**
	 * S-PORT Extension Procedure hash.
	 * <p>
	 * Register an EXCEPTION_HANDLER to be used by the runtime system when a runtime error occur.
	 * @param EXCEPTION_HANDLER the argument
	 */
	public static void DEFEXCEPTION(final RTS_PRCQNT EXCEPTION_HANDLER) {
		RTS_ENVIRONMENT.EXCEPTION_HANDLER = EXCEPTION_HANDLER;
	}

	/**
	 * S-PORT Extension Procedure hash.
	 * @param txt the argument
	 * @return resulting hash value
	 */
	public static int hash(final RTS_TXT txt) {
		if (txt == null || RTS_TXT.length(txt) == 0)
			return (0);
		String s = txt.edText();
		String tstrip = s.trim();
		if (tstrip.length() == 0)
			return (0);
		int a = tstrip.charAt(0);
		if (tstrip.length() > 3) {
			a = a + 8 * tstrip.charAt(1);
			a = a + 64 * rank(tstrip.charAt(2));
		}
		a = a + 512 * tstrip.charAt(tstrip.length() - 1) + s.length();
		return (a & 255);
	}

	/**
	 * S-PORT Extension Procedure loadChar.
	 * <p>
	 * Load a character from a text.
	 * 
	 * @param t a text reference
	 * @param p the text position in which the character is stored 
	 * @return the character at position p
	 */
	public static char loadChar(final RTS_TXT t, final int p) {
		// Returns the character at position p+1 (NB).
		// I.e. characters are counted from zero
		// c=t.char[p];
		RTS_TEXTOBJ obj = t.OBJ;
		char c = obj.MAIN[t.START + p];
		return (c);
	}

	/**
	 * S-PORT Extension Procedure storeChar.
	 * <p>
	 * Store character into a text.
	 * 
	 * @param c a character
	 * @param t a text reference
	 * @param p the text position in which the character is stored 
	 */
	public static void storeChar(final char c, final RTS_TXT t, final int p) {
		// Deposit c at position p+1 (NB).
		// I.e. characters are counted from zero
		// t.char[p]=c;
		RTS_TEXTOBJ obj = t.OBJ;
		obj.MAIN[t.START + p] = c;
	}

	/**
	 * S-PORT Extension Procedure getTextInfo.
	 * <pre>
	 * The routine getTextInfo is defined to get all information from the
	 * environment to the front-end that must be given as a text.
	 * 
	 * The parameter index is an integer that specifies what information we request.
	 * The result will be a string which is filled into result. The export parameter
	 * filled gives the number of characters in the string.
	 * 
	 * Index: Interpretation:
	 * 
	 * 1 What is the name of the source input file? Result will give the name.
	 * 
	 * 2 What is the name of the listing file? Result will give the file name. If no
	 * such output is to be produced, then the string will be empty.
	 * 
	 * 3 What is the name of the file for separate output of diagnostics messages?
	 * Result will give the file name. If no such output is to be produced, then the
	 * string will be empty.
	 * 
	 * 4 What is the name of the file for storing the normal (byte packed) S-code?
	 * Result will give the file name. If no such output is to be produced, then the
	 * string will be empty.
	 * 
	 * 5 What is the name of the file for storing decimally coded S-code? Result
	 * will give the file name. If no such output is to be produced, then the string
	 * will be empty.
	 * 
	 * 6 What is the name of the file for storing textually coded S-code? Result
	 * will give the file name. If no such output is to be produced, then the string
	 * will be empty.
	 * 
	 * 7 What is the name of the scratch file to be used for storing the
	 * intermediate code between the passes in the front-end? Result will give the
	 * name of the file.
	 * 
	 * 8 What is the name of the scratch file to be used for storing the declaration
	 * structures between the passes in the front-end? Result will give the name of
	 * the file.
	 * 
	 * 9 Reserved for further scratch file requests. Result will give the name of
	 * the file.
	 * 
	 * 10 Reserved for further scratch file requests. Result will give the name of
	 * the file.
	 * 
	 * 11 What is the name of the attribute file for the current compilation? This
	 * will only be necessary for a separate compilation. This file will be used as
	 * the front-end's attribute file. (Cf. section 4.6) Result will give the name
	 * of the file.
	 * 
	 * 12 What is the name of the attribute file for an external declaration? Before
	 * this request is issued, the environment will have received the identifier and
	 * the external identifier for the external declaration through the routine
	 * give_textinfo described below. (Cf. section 4.6) Result will give the name of
	 * the file.
	 * 
	 * 13 What is the environment part of the program head? (See below) Result will
	 * give the text string.
	 * 
	 * 14 What is the module identifier to be used for the current compilation? (Cf.
	 * section 4.6) This call will only be made for a separate compilation. Result
	 * will give the text string.
	 * 
	 * 15 What is the check code to be used for the current compilation? (Cf.
	 * section 4.6) This call will only be made for a separate compilation. Result
	 * will give the text string. If the empty string is delivered then the
	 * date_and_time string identifying this compilation will be used.
	 * 
	 * 16 What is the system debugging option string? The default answer here should
	 * be the empty string.
	 * 
	 * 17 Not used.
	 * 
	 * 18 Not used.
	 * 
	 * 19 What is the file name of the attribute file for the predefined classes and
	 * procedures (the class PREDEF)?
	 * 
	 * 20 What is the file name for the attribute file for the class SIMSET?
	 * 
	 * 21 What is the file name for the attribute file for the class SIMULATION?
	 * 
	 * 22 What is the file name of a file containing seldom used information for the
	 * front end compiler, such as extended error messages.
	 * 
	 * 23 What is the file name of a file containing seldom used information for the
	 * run time system, such as extended error messages.
	 * 
	 * 24 What is the identification string of the current execution? The answer
	 * should be as defined for procedure "simulaid" in the SIMULA Standard, section
	 * 9.6. If the answer is the empty string, RTS will fill out the first field
	 * (SIMULA system name) with an identification of the current S-port release,
	 * and leave the remainding fields empty (i.e. the release info will be
	 * terminated by 21 exclamation marks).
	 * 
     * A short comment is necessary on the program head string.
     * According to the definition an S-program should start with the
     * keyword program followed by a string. This string is used to identify the compilation.
     * The string will be given according to the following syntax:
     * "&lt; a >'&lt; b >'&lt; c >"
     * The three parts of the string are:
     * &lt; a > This is the date and time of compilation given through the result from a call on
     * the routine date_and_time.
     * &lt; b > This is an identifiaction of the front-end compiler chosen by itself to identify
     * the version of the compiler.
     * &lt; c > This is an identification of the S-code compiler supplied to the front-end
     * compiler when get_textinfo is called with index 13 (see page 15).
	 *
	 * </pre>
	 * 
	 * @param index case index
	 * @return requested text info
	 */
	public static RTS_TXT getTextInfo(final int index) {
		switch (index) {
		case 1:
			String sourceFileName = RTS_COMMON.SPORT_Option.getSourceFileName();
			return (new RTS_TXT(sourceFileName));
		case 2:
			String listingFileName = RTS_COMMON.SPORT_Option.ListingFileName;
			if (listingFileName == null)
				return (null); // no Listing
			return (new RTS_TXT(listingFileName)); // listname i.e. Listing File Name
		case 4:
			String sCodeFileName = RTS_COMMON.SPORT_Option.getSCodeFileName();
			return (new RTS_TXT(sCodeFileName));
		case 7:
			String scratchFileName = RTS_COMMON.SPORT_Option.getScratchFileName();
			return (new RTS_TXT(scratchFileName)); // FileName for intermediate code
		case 11:
			String attributeOutputFileName = RTS_COMMON.SPORT_Option.getAttributeOutputFileName();
			return (new RTS_TXT(attributeOutputFileName)); // AttributeInputFileName
		case 12:
			String attributeFileName = RTS_COMMON.SPORT_Option.getExternalAttributeFileName();
			return (new RTS_TXT(attributeFileName));
		case 13: // What is the environment part of the program head?
			return (new RTS_TXT("/JAVA"));
		case 14: // Module identifier to be used for the current separate compilation?
			return (new RTS_TXT(RTS_COMMON.SPORT_Option.currentModuleID));
		case 15: // Module check code to be used for the current separate compilation?
			String checkCode = "abracadab";
			return (new RTS_TXT(checkCode));
		case 16:
			return (new RTS_TXT(RTS_COMMON.SPORT_Option.Selectors)); // options and selectors
		case 19:
			return (new RTS_TXT(RTS_COMMON.SPORT_Option.PredefFileName)); // Name of attribute file for the predefined classes etc.												// procedures (the class PREDEF)?
		case 22:
			return (new RTS_TXT(RTS_COMMON.SPORT_Option.XmessageFileName)); // Name of a file containing seldom used information
																  // for the front end compiler, such as extended error messages.
		case 25:
			File file = new File(RTS_COMMON.SPORT_Option.getSourceFileName());
			String ModuleIdent = file.getName();
			ModuleIdent = ModuleIdent.substring(0, ModuleIdent.length() - 4).toLowerCase();
			return (new RTS_TXT(ModuleIdent)); // Modid par of source file name in lower case
		default:
			NOT_IMPLEMENTED("getTextInfo: " + index);
		}
		return (null);
	}

	/**
	 * S-PORT Extension Procedure getIntInfo.
	 * <pre>
     * The routine get_intinfo is defined to get all information from the environment that
     * can be coded as an integer.
     * 
     * The parameter index is an integer specifying what information is requested. The
     * result will be an integer whose interpretation gives the specified information. The
     * result is given for each value of index as follows:
     * Index: Interpretation:
     * 1 NOT USED
     * 
     * 2 Is a source listing wanted?
     * Result: 0 - No.
     * >0 - Yes. The listing will be a copy of the source text, where each line is prefixed by
     * its number.
     * 
     * 3 *) Should begin/end counters be included in the source listing?
     * Result=0 means no, otherwise yes.
     * 
     * 4 What is the maximum number of error messages to be given?
     * Result will be the number of messages.
     * 
     * 5 Should warning messages be suppressed?
     * Result=0 means no, otherwise yes.
     * 
     * 6 Should a cross-reference listing be produced?
     * Result=0 means no, otherwise yes.
     * 
     * 7 *) What is the image length for the listing file?
     * Result will be the number of characters in the image.
     * 
     * *) These calls are only made after get_textinfo(2) (asking for name of the listing file)
     * is called, and only if listing is wanted.
     * 
     * 
     * 8 What is the line length of the source file?
     * Result will be the number of characters in the image. 
     * 
     * 9 Should test for none be ommitted at remote access?
     * Result=0 means no, otherwise yes.
     * 
     * 10 Should checking of indices be ommitted at array access?
     * Result: 0 - Complete checking of array indices
     * 1 - Partial checking of indices
     * 2 - No checking will be done.
     * 
     * 11 What is the level of information wanted from the symbolic dump routine?
     * Result: 0 - The symbolic dump module is not to be included
     * 1 - The symbolic dump routine is included
     * 2 - Individual instances of an object shall carry a count for identification
     * 3 - Objects shall carry information of all identifier names.
     * 
     * 12 Should inclusion be made for production of a dynamic profile of the program
     * execution?
     * Result=0 means no inclusion, otherwise assignment counts are to be included
     * 
     * 13 Should inclusion be made for full tracing of control flow at run-time?
     * Result=0 means no inclusion, otherwise full inclusion.
     * 
     * 14 Should inclusion be made for interactive debugging of the program?
     * Result=0 means no inclusion, otherwise full inclusion.
     * 
     * 15 What is the level of debug information wanted in case of a run time error?
     * Result: 0 - no debugging information is wanted
     * 1 - a diagnostic message and the source program line number where the error
     * occurred are wanted
     * 2 - in addition to the above the static link and the dynamic link at the point of error
     * are wanted
     * 3 - in addition to the above the sequencing sets of all SIMULATION blocks and the
     * local sequence controls of all scheduled processes are wanted
     * 4 - in addition to the above the local sequence controls of all non-terminated objects
     * are wanted
     * 5 - in addition to the above all referable datastructures are wanted.
     * 
     * 16 Is tracing of control flow wanted?
     * Result: 0 - no tracing is wanted
     * >0 - the number of messages wanted is given
     * &lt;0 - tracing messages are printed to a buffer of size -(result), and only listed in case
     * of a run-time error
     * 
     * 17 Is tracing of data flow wanted?
     * Result: 0 - no tracing is wanted
     * >0 - the number of messages wanted is given
     * &lt;0 - tracing messages are printed to a buffer of size -(result), and only listed in case
     * of a run-time error
     * Comment: If both control and data flow tracing are specified, they will go to the same
     * destination.
     * 
     * 18 What is the maximum amount of time (cpu-time) to be used for the execution?
     * Result will give the time, specified in 1/100 sec.
     * 
     * 19 Should the symbolic debugger SIMOB be entered prior to the execution of the
     * program, and at program termination? An answer greater than zero will give this
     * effect.
     * 
     * 20 What is the significant linelength of the source file image?
     * 
     * 21 What is the maximum index to setobj, getobj, and access instructions allowed in
     * this implementation. A response of 0 will give the limit 255.
     * 
     * 22 Mode of separate compilation ?
     * 0: normal separate compilation
     * 1: recompilation.
     * 
     * 23 Amount of pass information from FEC on listing or message file ?
     * 0: No information.
     * 1: Minimum.
     * 2: Medium.
     * 3: Maximum.
     * 
     * 24 How many work areas may be requested (see chapter 5)?
     * 
     * 30 What is the level of data information which must be produced at compile-time, in
     * order to observe the execution at run-time?
     * Result: 0 - minimal information for error reporting.
     * 1 - information at the module and block level, but no information about the attributes.
     * 2 - complete information generated, including information about all attributes.
     * SIMOB can always be used for observation, but the available information will
     * depend on this response.
     * 
     * 31 Should inclusion be made at compile-time for statement execution counts?
     * Result: 0 - no, statement execution counts not wanted
     * 1 - yes, statement execution counts wanted
     * 
     * 32 Should inclusion be made at compile-time for processor usage measurements?
     * Result: 0 - no, measuring of processor usage not wanted
     * 1 - yes, measuring of processor usage wanted
     * 
     * 33 Is interaction with the user possible in the current execution?
     * Result: 0 - no, this is not an interactive execution
     * 1 - yes, this is an interactive execution
     * Note that SIMOB uses this.
     * 
     * 34 Should inclusion for the possibility of statement start exceptions be made at
     * compile-time by the S-Code Compiler?
     * Result: 0 - no, no start of statement exceptions will ever occur
     * 1 - yes, start of statement exceptions may occur
     * 
     * 35 Should inclusion be made at compile-time for storage usage measurements?
     * Result: 0 - no, measuring of storage usage not wanted
     * 1 - yes, measuring of storage usage wanted
     * 
     * 36 What is the maximum number of identifiers allowed in this program compilation.
     * Result will be the number allowed.
     * 
     * 37 What is the maximum number of constants allowed for this compilation. Result
     * will define the number.
     * 
     * 38 What is the maximum number of textual blocks allowed for this compilation.
     * Result will define the number.
     * 
     * 39 What is the maximum number of block levels allowed for this compilation. Result
     * will define the number.
     * 
     * 40 What is the maximum source depth allowed for this compilation. Result will
     * define the maximum.
     * 
     * 41 What is the maximum dynamic depth in this program compilation. Result will
     * define the maximum.
     * 
     * 42 What is the maximum number of parameters in a procedure call for this
     * compilation. Result will define the maximum.
     * 
     * 43-127 As defined in the current Release Description.
     * If the environment returns a value of zero for any of these indices, some default value
     * will be chosen by the system.
     * 
     * </pre>
	 * 
	 * @param index case index
	 * @return requested integer info
	 */
	public static int getIntInfo(final int index) {
		// _RT.println("getIntInfo: index="+index);
		switch (index) {
		case 1:
			return (RTS_COMMON.SPORT_Option.GenerateScode);
		case 4:
			return (RTS_COMMON.SPORT_Option.MaxErrors); // maxerrno
		case 5:
			return (RTS_COMMON.SPORT_Option.GiveNotes); // GiveNotes
		case 7:
			return (260); // Image length for the listing file
		case 9: // NONE CHECK? Result=0 means no, otherwise yes.
			return (1);
		case 10: // ARRAY BOUNDS CHECK ? Result: 0 - Complete checking,
				 //   1 - Partial checking, 2 - No checking will be done.
			return (0);
		case 16:
			return (RTS_COMMON.SPORT_Option.TraceLevel); // Image length for the listing file
		case 22:
			return (RTS_COMMON.SPORT_Option.Recompilation); // recomp
		case 30:
			return (RTS_COMMON.SPORT_Option.SimobLevel); // simob_level
		default:
			NOT_IMPLEMENTED("getIntInfo: " + index);
		}
		return (0);
	}

	/**
	 * S-PORT Extension Procedure giveIntInfo.
	 * <pre>
     * The routine give intinfo is defined to submit information from the front-end compiler
     * or the run-time system to the environment. This information is gathered from the
     * source input under compilation.
     *
     * The parameter index is an integer that specifies what information follows. Info will
     * be an integer carrying the following interpretation:
     *
     * Index: Interpretation:
     *   1   A call with this index is done immediately before the termination of each pass, and
     *       the value of info signals the situation after this pass, by the following coding:
     *          0 - No user errors found. Go on with next pass.
     *          1 - User errors are found, but go on with next pass.
     *          2 - Reserved for fututre use, continuation is possible.
     *          3 - No user errors found, but because of options etc. (e.g. that S-code should not be
     *              produced), the next pass should not be started.
     *          4 - User errors found, therefore do not start next pass.
     *          5 - Too many or too difficult user errors encountered. Therefore the current pass is
     *              terminated, and the next pass should not be started.
     *          6 - An internal error in the compiler has occurred. Therefore the current pass is
     *              terminated, and the next pass should not be started.
     *            
     *   2   Info is the highest tag used in the S-code for this program.
     *   3   Info is the number of source lines in the Simula program being compiled.
     *   4   Info is the number of errors for this compilation.
     *   5   Info is the number of warnings for this compilation.
     *   6   Garbage collection information. Info=0 signals the start of a garbage collection, ENDOF hash:
     *       Info=1 signals termination of g.c. (see 5.2).
     * </pre>
	 * @param index case index
	 * @param info the integer info
	 */
	public static void giveIntInfo(final int index, final int info) {
		StringBuilder sb = new StringBuilder();
		switch (index) {
		case 1 -> {
			sb.append("End of pass " + (PASS_NO++) + ": ");
			switch (info) {
			case 0 -> sb.append("No user errors found. Go on with next pass.");
			case 1 -> sb.append("User errors are found, but go on with next pass.");
			case 2 -> sb.append("Reserved for fututre use, continuation is possible.");
			case 3 -> sb.append("No user errors found, but because of options etc. the next pass should not be started.");
			case 4 -> sb.append("User errors found, therefore do not start next pass.");
			case 5 -> sb.append("Too many or too difficult user errors encountered. Compiler should terminate.");
			case 6 -> sb.append("An internal error in the compiler has occurred. Compiler should terminate.");
			}
		}
		case 2 -> sb.append("Max tag=" + info);
		case 3 -> sb.append("nSourceLines=" + info);
		case 4 -> sb.append("nErrors=" + info);
		case 5 -> sb.append("nWarnings=" + info);
		}
		if (Option.VERBOSE)
			RTS_COMMON.println(sb.toString());
	}
	
	/**
	 * The S-port FEC pass number.
	 */
	private static int PASS_NO = 1;

	/**
	 * S-PORT Extension Procedure giveTextInfo.
	 * <pre>
     * The routine give_textinfo is defined to submit information from the front-end
     * compiler or the run-time system to the environment. This information is gathered
     * from the source input under compilation.
     * 
     * The parameter index is an integer that specifies what information follows. Info will
     * be the string reference with the specific information as follows:
     * 
     * Index: Interpretation:
     *   1  The string info is the identifier of a class or procedure being separately compiled.
     *   2  The string info is the identifier given in an external declaration that is being processed.
     *   3  The string info is the external identification given in an external declaration that is being processed.
     * 
	 * E.g: When compiling:
	 * 
	 * class SubSep; begin external class MainSeparat="some file"; ... end;
	 * 
	 * Index:	Interpretation:
	 *   1		currentModuleID: SubSep
	 *   2		extIdent: MainSeparate
	 *   3		extFile: "some file"
	 * 
	 * </pre>
	 * 
	 * @param index case index
	 * @param info text info
	 */
	public static void giveTextInfo(final int index, final RTS_TXT info) {
		String infoString = ((info == null) ? null : info.edText());
		switch (index) {
		case 1:
			RTS_COMMON.SPORT_Option.currentModuleID = infoString;
			break; // got predefmodule when compiling PREDEF.DEF
		case 2:
			RTS_COMMON.SPORT_Option.extIdent = infoString;
			break;
		case 3:
			RTS_COMMON.SPORT_Option.extFile = infoString;
			break;
		case 4:
			RTS_COMMON.SPORT_Option.SPORT_SysInsertDirName = infoString;
			break;
		default:
			NOT_IMPLEMENTED("giveTextInfo");
		}
	}

	/**
	 * S-PORT Extension Procedure rts_utility.
	 * <p>
	 * Register Error or Warning given
	 * @param index case index
	 * @param level not used
	 */
	public static void rts_utility(final int index, final int level) {
		if (Option.VERBOSE)
			RTS_COMMON.println("rts_utility: index=" + index + ", level=" + level + "  Error or Warning given");
		switch (index) {
		case 0:
			return; // Note
		case 1:
			break; // return; // Warning
		case 2:
			break;// return; // Error
		case 3:
			break;// return; // COMMON Error
		case 4:
			break;// return; // Abort
		case 5: // newTag check-point with Stack trace
			if (Option.VERBOSE)
				RTS_COMMON.println("rts_utility: index=5: newTag should be changed to newTTag(ident)");
			break;
		default:
			NOT_IMPLEMENTED("rts_utility: index=" + index + ", level=" + level);
		}
		printStaticChain();
		try {
			Thread.sleep(10);
		} catch (Exception e) {
		}
		Thread.dumpStack();
		try {
			Thread.sleep(10);
		} catch (Exception e) {
		}
		// System.exit(-1);
	}

	/**
	 * Internal error NOT IMPLEMENTED
	 * @param s explanation
	 */
	private static void NOT_IMPLEMENTED(final String s) {
		RTS_COMMON.IERR("*** NOT IMPLEMENTED: " + s);
	}

}
