/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import simula.compiler.utilities.Global;

/**
 * The Class ENVIRONMENT.
 * <p>
 * The purpose of the environmental class is to encapsulate all constants,
 * procedures and classes which are accessible to all source modules. It
 * contains procedures for mathematical functions, text generation, random
 * drawing, etc.
 * <p>
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
// public final class ENVIRONMENT$ {
public class ENVIRONMENT$ extends RTObject$ {
	static long START_TIME = System.currentTimeMillis();
	static char CURRENTLOWTEN = '&';
	static char CURRENTDECIMALMARK = '.';
	public final double maxlongreal = Double.MAX_VALUE;
	public final double minlongreal = -maxlongreal;// Double.MIN_VALUE;
	public final float maxreal = Float.MAX_VALUE;
	public final float minreal = -maxreal;// Float.MIN_VALUE;
	public final int maxrank = 256; // Character.???;
	public final int maxint = Integer.MAX_VALUE;
	public final int minint = Integer.MIN_VALUE;

	/**
	 * The value of "simulaid" is an implementation defined string of the following
	 * general format:
	 * 
	 * <pre>
	 *     <simid>!!!<siteid>!!!<OS>!!!<CPU>!!!<user>!!!<job>!!!<acc>!!!<prog>
	 * 
	 *   <simid>:   Identification of the SIMULA system (name, version etc.)
	 *   <siteid>:  Identification of the installation (e.g. organisation name)
	 *   <OS>:      Operating system identification (name, version, etc.)
	 *   <CPU>:     Host system identification (manufacturer, name, number, etc.)
	 *   <user>:    User identification
	 *   <job>:     Job identification (session number)
	 *   <acc>:     Account identification
	 *   <prog>:    Identification of the executing task or program
	 * </pre>
	 */
	public final String simid = "Portable "+Global.simulaReleaseID;
	public final String siteid = "";
	public final String OS = "";
	public final String CPU = "";
	public final String user = "";
	public final String job = "";
	public final String acc = "";
	public final String prog = "";
	public final String simulaIdent = simid + "!!!" + siteid + "!!!" + OS + "!!!" + CPU + "!!!" + user + "!!!" + job
			+ "!!!" + acc + "!!!" + prog;

	public TXT$ simulaid() {
		return (new TXT$(simulaIdent));
	}

	// Constructor
	public ENVIRONMENT$(final RTObject$ staticLink) {
		super(staticLink);
	}

	// ************************************************************
	// *** object IS classIdentifier
	// ************************************************************
	public boolean IS$(final Object obj,final Class<?> cls) {
		return((obj == null)?false:(obj.getClass() == cls));
	}

	// *****************************************
	// *** Basic operations ***
	// *****************************************

	/**
	 * <pre>
	 * integer procedure mod(i,j);   integer i,j;
	 * begin integer res;
	 *    res := i - (i//j)*j;
	 *    mod := if res = 0 then 0
	 *      else if sign(res) <> sign(j) then res+j
	 *      else res
	 * end mod;
	 * </pre>
	 * <p>
	 * The result is the mathematical modulo value of the parameters.
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public int mod(final int i,final int j) {
		int res = i % j;
		if (res == 0)
			return (0);
		if (res * j < 0)
			return (res + j);
		return (res);
	}

	/**
	 * <pre>
	 * integer procedure rem(i,j);   integer i,j;
	 *                   rem := i - (i//j)*j;
	 * </pre>
	 * <p>
	 * The result is the remainder of an integer division.
	 * 
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public int rem(final int i,final int j) {
		return (i % j);
	}

	/**
	 * <pre>
	 * <type of e> procedure abs(e); <type> e;
	 *       abs := if e >= 0 then e else -e;
	 * </pre>
	 * 
	 * The result is the absolute value of the parameter.
	 * 
	 * @param e
	 * @return
	 */
	public int abs(final int e) {
		return (Math.abs(e));
	}

	public float abs(final float e) {
		return (Math.abs(e));
	}

	public double abs(final double e) {
		return (Math.abs(e));
	}

	/**
	 * <pre>
	 * integer procedure sign(e);    e;
	 *     sign := if e > 0 then  1
	 *        else if e < 0 then -1 else 0;
	 * </pre>
	 * 
	 * The result is zero if the parameter is zero, one if the parameter is
	 * positive, and minus one otherwise.
	 * 
	 * @param e
	 * @return
	 */
	public int sign(final double e) {
		return ((e > 0) ? (1) : ((e < 0) ? -1 : 0));
	}

	/**
	 * <pre>
	 * integer procedure entier(r); <real-type> r;
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
	 * @param d
	 * @return
	 */
	public int entier(final double d) {
		int j = (int) d;
		return ((((float) j) > d) ? (j - 1) : (j));
	}

	/**
	 * Integer Power: b ** x
	 * 
	 * @param b
	 * @param x
	 * @return
	 */
	public int IPOW$(final int b,int x) {
		// RT.println("IPOW("+b+','+x+')');
		if (x == 0) {
			if (b == 0)
				throw new RuntimeException("Exponentiation: " + b + " ** " + x + "  Result is undefined.");
			return (1); // any ** 0 ==> 1
		} else if (x < 0)
			throw new RuntimeException("Exponentiation: " + b + " ** " + x + "  Result is undefined.");
		else if (b == 0)
			return (0); // 0 ** non_zero ==> 0
		int v = b;
		while ((--x) > 0)
			v = v * b;
		return (v);
	}
	
	public int IPOW$EXACT(final int b,int x) {
		//RT.println("IPOW$EXACT("+b+','+x+')');
		if (x == 0) {
			if (b == 0)
				throw new RuntimeException("Exponentiation: " + b + " ** " + x + "  Result is undefined.");
			return (1); // any ** 0 ==> 1
		} else if (x < 0)
			throw new RuntimeException("Exponentiation: " + b + " ** " + x + "  Result is undefined.");
		else if (b == 0)
			return (0); // 0 ** non_zero ==> 0
		int v = b;
		while ((--x) > 0) {
//			v = v * b;
			//RT.println("IPOW$EXACT: x="+x+", v="+v);
		    v = Math.multiplyExact(v,b);
		}
		return (v);
	}

	/**
	 * Overloaded versions of 'addepsilon'.
	 * 
	 * <pre>
	 * <type of e> procedure addepsilon(e);   <real-type> e;
	 *     addepsilon := e + ... ; ! see below;
	 * </pre>
	 * <p>
	 * The result type is that of the parameter. The result is the value of the
	 * parameter incremented (addepsilon) or decremented (subepsilon) by the
	 * smallest positive value, such that the result is not equal to the parameter
	 * within the precision of the implementation. Thus, for all positive values of
	 * "eps",
	 * 
	 * <pre>
	 * E - eps &lt;= subepsilon(E) &lt; E &lt; addepsilon(E) &lt;= E + eps
	 * </pre>
	 * 
	 * @param x
	 * @return
	 */
	public float addepsilon(final float x) {
		return (Math.nextUp(x));
	}

	public double addepsilon(final double x) {
		return (Math.nextUp(x));
	}

	/**
	 * Overloaded versions of 'subepsilon'.
	 * 
	 * <pre>
	 * <type of e> procedure subepsilon(e);   <real-type> e;
	 *     subepsilon := e - ... ; ! see below;
	 * </pre>
	 * <p>
	 * The result type is that of the parameter. The result is the value of the
	 * parameter incremented (addepsilon) or decremented (subepsilon) by the
	 * smallest positive value, such that the result is not equal to the parameter
	 * within the precision of the implementation. Thus, for all positive values of
	 * "eps",
	 * 
	 * <pre>
	 * E - eps &lt;= subepsilon(E) &lt; E &lt; addepsilon(E) &lt;= E + eps
	 * </pre>
	 * 
	 * @param x
	 * @return
	 */
	public float subepsilon(final float x) {
		return (Math.nextDown(x));
	}

	public double subepsilon(final double x) {
		return (Math.nextDown(x));
	}

	/**
	 * <pre>
	 * character procedure char(i);  integer i;
	 *    char := ... ;
	 * </pre>
	 * 
	 * The result is the character obtained by converting the parameter according to
	 * the implementation-defined coding of characters. The parameter must be in the
	 * range 0..maxrank.
	 * 
	 * @param i
	 * @return
	 */
	public char Char(final int i) {
		return ((char) i);
	}
	public char char$(final int i) {
		return ((char) i);
	}

	/**
	 * <pre>
	 * character procedure isochar(i);  integer i;
	 *    isochar := ... ;
	 * </pre>
	 * 
	 * The result is the character obtained by converting the parameter according to
	 * the ISO 2022 standard character code. The parameter must be in the range
	 * 0..255.
	 * 
	 * @param n
	 * @return
	 */
	public char isochar(final int n) {
		return ((char) n);
	}

	/**
	 * <pre>
	 * integer procedure rank(c);  character c;
	 *    rank := ... ;
	 * </pre>
	 * 
	 * The result is the integer obtained by converting the parameter according to
	 * the implementation-defined character code.
	 * 
	 * @param c
	 * @return
	 */
	public int rank(final char c) {
		return ((int) c);
	}

	/**
	 * <pre>
	 * integer procedure isorank(c);  character c;
	 *    isorank := ... ;
	 * </pre>
	 * 
	 * The result is the integer obtained by converting the parameter according to
	 * the ISO 2022 standard character code.
	 * 
	 * @param c
	 * @return
	 */
	public int isorank(final char c) {
		return ((int) c);
	}

	/**
	 * <pre>
	 * Boolean procedure digit(c);  character c;
	 *    digit := ... ;
	 * </pre>
	 * 
	 * The result is true if the parameter is a decimal digit.
	 * 
	 * @param c
	 * @return
	 */
	public boolean digit(final char c) {
		return (Character.isDigit(c));
	}

	/**
	 * <pre>
	 * Boolean procedure letter(c);  character c;
	 *    letter := ... ;
	 * </pre>
	 * 
	 * The result is true if the parameter is a letter of the English alphabet ('a'
	 * ... 'z', 'A' ... 'Z').
	 * 
	 * @param c
	 * @return
	 */
	public boolean letter(final char c) {
		return (Character.isLetter(c));
	}

	/**
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
	 * (i.e. ISO code<32), DEL (ISO code 127), and all characters with ISO code
	 * greater than 127.
	 * 
	 * @param c
	 * @return
	 */
	public char lowten(final char c) {
		if (illegalLowten(c))
			throw new RuntimeException("Illegal LOWTEN Character: " + c + "  Code=" + (int) c);
		char lowten = CURRENTLOWTEN;
		// CURRENTLOWTEN = c;
		CURRENTLOWTEN = Character.toUpperCase(c);
		return (lowten);
	}

	private boolean illegalLowten(final char c) {
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
	 * <pre>
	 * character procedure decimalmark(c);   character c;
	 *    if c <> '.' and then c <> ','
	 *    then error("..." ! Decimalmark error ;)
	 *    else begin
	 *            decimalmark:= CURRENTDECIMALMARK;
	 *            CURRENTDECIMALMARK:= c
	 * end decimalmark;
	 * </pre>
	 * 
	 * Changes the value of the decimal point character used by the text (de)editing
	 * procedures (cf. 8.7 and 8.8). See the TXT$ methods: getreal, getfrac, putfix,
	 * putreal and putfrac. The previous value is returned. The only legal parameter
	 * values are dot and comma.
	 * 
	 * @param c
	 * @return
	 */
	public char decimalmark(final char c) {
		char decimalmark = 0;
		if (c != '.' && c != ',') {
			throw new RuntimeException("Decimalmark error: "+c);
		} else {
			decimalmark = CURRENTDECIMALMARK;
			CURRENTDECIMALMARK = c;
		}
		return (decimalmark);
	}

	/**
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
	 * @param t
	 * @return
	 */
	public TXT$ upcase(TXT$ t) {
		if (t == null) t = NOTEXT;
		TXT$.setpos(t, 1);
		while (TXT$.more(t)) {
			char c = TXT$.getchar(t);
			TXT$.setpos(t, TXT$.pos(t) - 1);
			TXT$.putchar(t, Character.toUpperCase(c));
		}
		TXT$.setpos(t, 1);
		return (t);
	}

	/**
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
	 * @param t
	 * @return
	 */
	public TXT$ lowcase(TXT$ t) {
		if (t == null) t = NOTEXT;
		TXT$.setpos(t, 1);
		while (TXT$.more(t)) {
			char c = TXT$.getchar(t);
			TXT$.setpos(t, TXT$.pos(t) - 1);
			TXT$.putchar(t, Character.toLowerCase(c));
		}
		TXT$.setpos(t, 1);
		return (t);
	}

	// *****************************************
	// *** Mathematical functions ***
	// *****************************************

	public double sqrt(final double r) {
		return (Math.sqrt(r));
	}

	public double sin(final double r) {
		return (Math.sin(r));
	}

	public double cos(final double r) {
		return (Math.cos(r));
	}

	public double tan(final double r) {
		return (Math.tan(r));
	}

	public double cotan(final double r) {
		return (1.0 / Math.tan(r));
	}

	public double arcsin(final double r) {
		return (Math.asin(r));
	}

	public double arccos(final double r) {
		return (Math.acos(r));
	}

	public double arctan(final double r) {
		return (Math.atan(r));
	}

	public double arctan2(final double y,final double x) {
		return (Math.atan2(y, x));
	}

	public double sinh(final double r) {
		return (Math.sinh(r));
	}

	public double cosh(final double r) {
		return (Math.cosh(r));
	}

	public double tanh(final double r) {
		return (Math.tanh(r));
	}

	public double ln(final double r) {
		return (Math.log(r));
	}

	public double log10(final double r) {
		return (Math.log10(r));
	}

	public double exp(final double r) {
		return (Math.exp(r));
	}

	// *****************************************
	// *** Extremum functions ***
	// *****************************************

	/**
	 * <pre>
	 * <type> procedure max(i1,i2); <type> i1; <type> i2;
	 * </pre>
	 * 
	 * The value is the greater of the two parameter values. Legal parameter types
	 * are text, character, real type and integer type.
	 * <p>
	 * The type of the result conforms to the rules of 3.3.1. in Simula Standard.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public double max(final double x,final double y) {
		return (Math.max(x, y));
	}

	public float max(final float x,final float y) {
		return (Math.max(x, y));
	}

	public int max(final int x,final int y) {
		return (Math.max(x, y));
	}

	public char max(final char x,final char y) {
		return ((char) Math.max((int) x, (int) y));
	}

	public TXT$ max(final TXT$ x,final TXT$ y) {
		return (TXTREL$LT(x, y) ? y : x);
	}

	/**
	 * <pre>
	 * <type> procedure min(i1,i2); <type> i1; <type> i2;
	 * </pre>
	 * 
	 * The value is the lesser of the two parameter values. Legal parameter types
	 * are text, character, real type and integer type.
	 * <p>
	 * The type of the result conforms to the rules of 3.3.1. in Simula Standard.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public double min(final double x,final double y) {
		return (Math.min(x, y));
	}

	public float min(final float x,final float y) {
		return (Math.min(x, y));
	}

	public int min(final int x,final int y) {
		return (Math.min(x, y));
	}

	public char min(final char x,final char y) {
		return ((char) Math.min((int) x, (int) y));
	}

	public TXT$ min(final TXT$ x,final TXT$ y) {
		return (TXTREL$LT(x, y) ? x : y);
	}

	// *****************************************
	// *** Error control ***
	// *****************************************

	/**
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
	 * @param msg
	 */
	public void error(final TXT$ msg) {
		throw new RuntimeException(msg.edText());
	}

	// *****************************************
	// *** Array quantities ***
	// *****************************************

	/**
	 * <pre>
	 *  integer procedure lowerbound(a,i);
	 *                <type> array a; integer i;
	 * 
	 *   UPPERBOUND   integer procedure upperbound(a,i);
	 *                <type> array a; integer i;
	 * </pre>
	 * 
	 * The procedure "lowerbound" returns the lower bound of the dimension of the
	 * given array corresponding to the given index. The first dimension has index
	 * one, the next two, etc. An index less than one or greater than the number of
	 * dimensions of the given array constitutes a run time error.
	 * 
	 * @param a
	 * @param i
	 * @return
	 */
	public int lowerbound(final ARRAY$<?> a,final int i) {
		try {
			return (a.LB[i - 1]);
		} catch (RuntimeException e) {
			throw new RuntimeException("Wrong number of dimensions", e);
		}
	}

	/**
	 * <pre>
	 *  integer procedure lowerbound(a,i);
	 *                <type> array a; integer i;
	 * 
	 *   UPPERBOUND   integer procedure upperbound(a,i);
	 *                <type> array a; integer i;
	 * </pre>
	 * 
	 * The procedure "upperbound" returns the upper bound of the dimension of the
	 * given array corresponding to the given index. The first dimension has index
	 * one, the next two, etc. An index less than one or greater than the number of
	 * dimensions of the given array constitutes a run time error.
	 * 
	 * @param a
	 * @param i
	 * @return
	 */
	public int upperbound(final ARRAY$<?> a,final int i) {
		try {
			return (a.UB[i - 1]);
		} catch (RuntimeException e) {
			throw new RuntimeException("Wrong number of dimensions", e);
		}
	}

	// *********************************************************************
	// *** Random drawing ***
	// *********************************************************************

	// **********************************************************************
	// *** Basic Drawing - Implementation using default Java-Seed.
	// **********************************************************************
	static final Random random = new Random();

//	private double basicDRAW(NAME$<Integer> U) {
//		return (random.nextDouble());
//	}
	
	// **********************************************************************
	// *** Random drawing: Procedure draw
	// **********************************************************************
	/**
	 * <pre>
	 *  Boolean procedure draw (a,U);
	 *                name U; long real a; integer U;
	 * </pre>
	 * 
	 * The value is true with the probability a, false with the probability 1 - a.
	 * It is always true if a >= 1 and always false if a <= 0.
	 * <p>
	 * NOTE: The name specified parameter 'U' is not used. Instead, the default seed
	 * in the Java Library is used.
	 * 
	 * @param a
	 * @param U
	 * @return
	 */
//	public boolean draw(float a, NAME$<Integer> U) {
//	public boolean draw(final float a,final int U) {
	public boolean draw(final double a,final int U) {
		boolean val;
		if (a >= 1.0) val = true;
		else if (a <= 0.0) val = false;
//		else val = a >= basicDRAW(U);
		else val = a >= random.nextDouble();
		return (val);
	}

	// **********************************************************************
	// *** Random drawing: Procedure randint
	// **********************************************************************
	/**
	 * <pre>
	 *  integer procedure randint (a,b,U);
	 *		          name U; integer a,b,U;
	 * </pre>
	 * 
	 * The value is one of the integers a, a+1, ..., b-1, b with equal probability.
	 * If b < a, the call constitutes an error.
	 * <p>
	 * NOTE: The name specified parameter 'U' is not used. Instead, the default seed
	 * in the Java Library is used.
	 * 
	 * @param a
	 * @param b
	 * @param U
	 * @return
	 */
//	public int randint(int a, int b, NAME$<Integer> U) {
	public int randint(final int a,final int b,final int U) {
		if (b < a) throw new RuntimeException("Randint(a,b,u):  b < a");
//		int val = entier(basicDRAW(U) * ((b - a + 1))) + a;
		int val = entier(random.nextDouble() * ((b - a + 1))) + a;
		return (val);
	}

	// **********************************************************************
	// *** Random drawing: Procedure uniform
	// **********************************************************************
	/**
	 * <pre>
	 * long real procedure uniform (a,b,U);
	 *          name U; long real a,b; integer U;
	 * </pre>
	 * 
	 * The value is uniformly distributed in the interval a <= u < b. If b < a, the
	 * call constitutes an error.
	 * <p>
	 * NOTE: The name specified parameter 'U' is not used. Instead, the default seed
	 * in the Java Library is used.
	 *
	 * @param a
	 * @param b
	 * @param U
	 * @return
	 */
//	public double uniform(double a, double b, NAME$<Integer> U) {
	public double uniform(final double a,final double b,final int U) {
		if (b < a) throw new RuntimeException("Uniform(a,b,u): b < a");
//		double val = a + ((b - a) * basicDRAW(U));
		double val = a + ((b - a) * random.nextDouble());
		return (val);
	}

	// **********************************************************************
	// *** Random drawing: Procedure normal
	// **********************************************************************
	/**
	 * <pre>
	 * long real procedure normal (a,b,U);
	 *         name U; long real a,b; integer U;
	 * </pre>
	 * 
	 * The value is normally distributed with mean a and standard deviation b. An
	 * approximation formula may be used for the normal distribution function.
	 * <p>
	 * NOTE: The name specified parameter 'U' is not used. Instead, the default seed
	 * in the Java Library is used.
	 * 
	 * @param a
	 * @param b
	 * @param U
	 * @return
	 */
//	public double normal(double a, double b, NAME$<Integer> U) {
	public double normal(final double a,final double b,final int U) {
		double t, p, q, v, x;
		boolean z;
		if (b < 0.0) throw new RuntimeException("Normal(a,b,u):  b <= 0.");
//		v = basicDRAW();
		v = random.nextDouble();
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
		double val = a + ((z) ? x : -x);
		return (val);
	}

	// **********************************************************************
	// *** Random drawing: Procedure negexp
	// **********************************************************************
	/**
	 * <pre>
	 * long real procedure negexp (a,U);
	 *          name U; long real a; integer U;
	 * </pre>
	 * 
	 * The value is a drawing from the negative exponential distribution with mean
	 * 1/a, defined by -ln(u)/a, where u is a basic drawing. This is the same as a
	 * random "waiting time" in a Poisson distributed arrival pattern with expected
	 * number of arrivals per time unit equal to a. If a is non-positive, a runtime
	 * error occurs.
	 * <p>
	 * NOTE: The name specified parameter 'U' is not used. Instead, the default seed
	 * in the Java Library is used.
	 * 
	 * @param a
	 * @param U
	 * @return
	 */
//	public double negexp(double a, NAME$<Integer> U) {
	public double negexp(final double a,final int U) {
		if (a <= 0.0) throw new RuntimeException("Negexp(a,u): a <= 0");
//		double v = basicDRAW(U);
		double v = random.nextDouble();
		double val = -Math.log(v) / a;
		return (val);
	}

	// **********************************************************************
	// *** Random drawing: Procedure Poisson
	// **********************************************************************
	/**
	 * <pre>
	 * integer procedure Poisson (a,U);
	 *          name U; long real a; integer U;
	 * </pre>
	 * 
	 * The value is a drawing from the Poisson distribution with parameter a. It is
	 * obtained by n+1 basic drawings, u(i), where n is the function value. n is
	 * defined as the smallest non-negative integer for which
	 * <p>
	 * u(0) * u(1) * ... * u(n) < e**(-a)
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
	 * <p>
	 * NOTE: The name specified parameter 'U' is not used. Instead, the default seed
	 * in the Java Library is used.
	 * 
	 * @param a
	 * @param U
	 * @return
	 */
//	public int Poisson(double a, NAME$<Integer> U) {
	public int Poisson(final double a,final int U) {
		int val;
		double acc, xpa, sqa;
		if (a <= 0.0)
			val = 0;
		else if (a > 20.0) {
			// entier(normal(a,sqrt(a),U) + 0.5)
			sqa = Math.sqrt(a);
			val = entier(normal(a, sqa, U) + 0.5);
		} else {
			acc = 1.0;
			val = 0;
			xpa = Math.exp(-a);
			do {
//				acc = acc * basicDRAW();
				acc = acc * random.nextDouble();
				val = val + 1;
			} while (acc >= xpa);
			val = val - 1;
		}
		return (val);
	}

	// **********************************************************************
	// *** Random drawing: Procedure Erlang
	// **********************************************************************
	/**
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
	 * <p>
	 * NOTE: The name specified parameter 'U' is not used. Instead, the default seed
	 * in the Java Library is used.
	 * 
	 * @param a
	 * @param b
	 * @param U
	 * @return
	 */
//	public double Erlang(double a, double b, NAME$<Integer> U) {
	public double Erlang(final double a,final double b,final int U) {
		int c;
		double val, bc, ab, z, v;
		if (a <= 0.0 || b <= 0.0)
			throw new RuntimeException("Erlang(a,b,u):  a <= 0  or  b <= 0");
		val = 0;
		c = entier(b);
		bc = b - c;
		ab = a * b;
		while ((c--) > 0) {
//			v = basicDRAW(U);
			v = random.nextDouble();
			z = Math.log(v);
			val = val - (z / ab);
		}
		if (bc > 0.0) {
//			v = basicDRAW(U);
			v = random.nextDouble();
			z = Math.log(v);
			val = val - ((bc * z) / ab);
		}
		return (val);
	}

	// **********************************************************************
	// *** Random drawing: Procedure discrete
	// **********************************************************************
	/**
	 * <pre>
	 *  integer procedure discrete (A,U);
	           name U; <real-type> array A; integer U;
	 * </pre>
	 * 
	 * The one-dimensional array A, augmented by the element 1 to the right, is
	 * interpreted as a step function of the subscript, defining a discrete
	 * (cumulative) distribution function.
	 * <p>
	 * The function value satisfies
	 * <p>
	 * lowerbound(A,1) <= discrete(A,U) <= upperbound(A,1)+1.
	 * <p>
	 * It is defined as the smallest i such that A(i) > u, where u is a basic
	 * drawing and A(upperbound(A,1)+1) = 1.
	 * <p>
	 * NOTE: The name specified parameter 'U' is not used. Instead, the default seed
	 * in the Java Library is used.
	 *
	 * @param A
	 * @param U
	 * @return
	 */
//	public int discrete(ARRAY$<double[]> A, NAME$<Integer> U) {
	public int discrete(final ARRAY$<double[]> A,final int U) {
		int result, j, nelt;
		double v;
		int lb = A.LB[0];
		int ub = A.UB[0];
//		v = basicDRAW(U);
		v = random.nextDouble();
		nelt = ub - lb + 1;
		result = ub + 1;
		j = 0;
		do {
			if (A.Elt[j] > v) {
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
	 * <pre>
	 *  long real procedure linear (A,B,U);
	 *       name U; <real-type> array A,B; integer U;
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
	 * l. draw a uniform <0,1> random number, u.
	 * <p>
	 * 2. determine the lowest value of i, for which
	 * <p>
	 * A(i-1) <= u <= A(i)
	 * <p>
	 * 3. compute D = A(i) - A(i-1)
	 * <p>
	 * 4. if D = 0: linear = B(i-1) if D <> 0: linear = B(i-1) + (B(i) -
	 * B(i-1))*(u-A(i-1))/D
	 * <p>
	 * NOTE: The name specified parameter 'U' is not used. Instead, the default seed
	 * in the Java Library is used.
	 * 
	 * @param A
	 * @param B
	 * @param U
	 * @return
	 */
//	public double linear(ARRAY$<double[]> A, ARRAY$<double[]> B, NAME$<Integer> U) {
	public double linear(final ARRAY$<double[]> A,final ARRAY$<double[]> B,final int U) {
		int i, nelt;
		double val, a_val, a_lag, a_dif, b_val, b_lag, v;

		int lb = A.LB[0];
		int ub = A.UB[0];

		nelt = ub - lb + 1;
		if (nelt != (B.UB[0] - B.LB[0] + 1))
			throw new RuntimeException("Linear(A,B,U): The number of elements in A and B are different.");
//		v = basicDRAW(U);
		v = random.nextDouble();
		i = 0;
		while (A.Elt[i] < v)
			i = i + 1;
		if (i == 0) {
			if (v == 0.0 && A.Elt[i] == 0.0)
				i = 1;
			else
				throw new RuntimeException("Linear(A,B,U): The array a does not satisfy the stated assumptions.");
		} else if (i >= nelt)
			throw new RuntimeException("Linear(A,B,U): The array a does not satisfy the stated assumptions.");

		a_val = A.Elt[i];
		a_lag = A.Elt[i - 1];
		a_dif = a_val - a_lag;
		if (a_dif == 0.0)
			val = B.Elt[i - 1];
		else {
			b_val = B.Elt[i];
			b_lag = B.Elt[i - 1];
			val = (((b_val - b_lag) / a_dif) * (v - a_lag)) + b_lag;
		}
		return (val);
	}

	// **********************************************************************
	// *** Utility: Procedure histd
	// **********************************************************************
	/**
	 * <pre>
	 * integer procedure histd (A,U);
	 *          name U; <real-type> array A; integer U;
	 * </pre>
	 * 
	 * The value is an integer in the range (lsb,usb), where lsb and usb are the
	 * lower and upper subscript bounds of the one-dimensional array A. The latter
	 * is interpreted as a histogram defining the relative frequencies of the
	 * values.
	 * <p>
	 * NOTE: The name specified parameter 'U' is not used. Instead, the default seed
	 * in the Java Library is used.
	 * 
	 * @param A
	 * @param U
	 * @return
	 */
//	public int histd(ARRAY$<float[]> A, NAME$<Integer> U) {
	public int histd(final ARRAY$<float[]> A,final int U) {
		int result = 0;
		int j; // Array index.
		int nelt; // Number of array elements.
		double sum; // Sum of all array element values.
		double wsum; // Weighted sum of all array element values.
		double tmp; // Temporary variabel.

		int lb = A.LB[0];
		int ub = A.UB[0];
		nelt = ub - lb + 1;
		j = 0;
		sum = 0.0;
		do {
			tmp = A.Elt[j];
			if (tmp < 0.0)
				throw new RuntimeException("Histd(a,u):  An element of the array a is negative");
			sum = sum + tmp;
			j = j + 1;
		} while (j < nelt);
//		wsum = sum * basicDRAW(U); // Make 0 <= wsum < sum
		wsum = sum * random.nextDouble(); // Make 0 <= wsum < sum
		j = 0;
		sum = 0.0;
		do {
			sum = sum + A.Elt[j];
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
	 * <pre>
	 * text procedure datetime;   datetime :- Copy("...");
	 * </pre>
	 * 
	 * The value is a text frame containing the current date and time in the form
	 * YYYY-MM-DD HH:MM:SS.sss.... The number of decimals in the field for seconds
	 * is implementation-defined.
	 * 
	 * @return
	 */
	public TXT$ datetime() {
		DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		String datim = LocalDateTime.now().format(form);
		return (new TXT$(datim));
	}

	/**
	 * <pre>
	 * long real procedure cputime;
	 * </pre>
	 * 
	 * The value is the number of processor seconds spent by the calling program.
	 * 
	 * @return
	 */
	public double cputime() {
		double cputime = System.currentTimeMillis() - START_TIME;
		return (cputime / 1000);
	}

	/**
	 * <pre>
	 * long real procedure clocktime;
	 * </pre>
	 * 
	 * @return The value is the number of seconds since midnight.
	 */
	public double clocktime() {
		LocalTime localTime = LocalTime.now();
		int hour = localTime.getHour();
		int minute = localTime.getMinute();
		int second = localTime.getSecond();
		// RT.println("ClockTime: Hour="+hour+", Minute="+minute+",
		// Second="+second);
		double time = ((hour * 60) + minute) * 60 + second;
		return (time);
	}

	// *****************************************
	// *** Miscellaneous utilities ***
	// *****************************************

	/**
	 * <pre>
	 * procedure histo(A,B,c,d);
	          real array A,B; real c,d;
	 * </pre>
	 * 
	 * Procedure statement "histo(A,B,c,d)" updates a histogram defined by the
	 * one-dimensional arrays A and B according to the observation c with the weight
	 * d. A(lba+i) is increased by d, where i is the smallest integer such that c <=
	 * B(lbb+i) and lba and lbb are the lower bounds of A and B respectively. If the
	 * length of A is not one greater than that of B the effect is
	 * implementation-defined. The last element of A corresponds to those
	 * observations which are greater than all elements of B.
	 * 
	 * @param A
	 * @param B
	 * @param c
	 * @param d
	 */
	public void histo(final ARRAY$<?> A,final ARRAY$<?> B,final float c,final float d) {
		if(A.nDim()!=1) 
			throw new RuntimeException("histo(A,B,c,d) - A is not one-dimensional");
		if(B.nDim()!=1) 
			throw new RuntimeException("histo(A,B,c,d) - B is not one-dimensional");
		int nelt = B.UB[0] - B.LB[0] + 1;
		if (nelt >= (A.UB[0] - A.LB[0] + 1))
			throw new RuntimeException("histo(A,B,c,d) - A'length <= B'length");
		try {
			@SuppressWarnings("unchecked")
			ARRAY$<float[]> AA=(ARRAY$<float[]>)A;
			@SuppressWarnings("unchecked")
			ARRAY$<float[]> BB=(ARRAY$<float[]>)B;
			int i=0;
			EX: do {
				if (BB.Elt[i] >= c)
					break EX;
				i = i + 1;
			} while (i < nelt);
			AA.Elt[i] = AA.Elt[i] + d;
		} catch(Exception e) { 	
			throw new RuntimeException("histo(A,B,c,d) - Internal Error",e);
		}
	}

	// **********************************************************************
	// *** Additional Standard Procedures
	// **********************************************************************
	

	// **********************************************************************
	// *** Random drawing: Procedure setSeed
	// **********************************************************************
	public void setSeed(final long seed) {
		random.setSeed(seed);
	}


	// **********************************************************************
	// *** Utility: Procedure waitSomeTime
	// **********************************************************************
	public void waitSomeTime(final int millies) {
		// RT.println("ENVIRONMENT.waitSomeTime: sleep="+millies);
		try {
			Thread.sleep(millies);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// RT.println("ENVIRONMENT.waitSomeTime: awake="+millies);
	}


	// **********************************************************************
	// *** Additional S-Port'like Procedures
	// **********************************************************************
	public static PRCQNT$ EXCEPTION_HANDLER=null;
    public void DEFEXCEPTION(final PRCQNT$ EXCEPTION_HANDLER) {
    	//System.out.println("ENVIRONMENT.DEFEXCEPTION: EXCEPTION_HANDLER="+EXCEPTION_HANDLER);
    	ENVIRONMENT$.EXCEPTION_HANDLER=EXCEPTION_HANDLER;
    }

    public int hash(final TXT$ t) {
    	RT.NOT_IMPLEMENTED("hash"); // TODO: Implement it
    	return(0);
    }
   
    public char loadChar(final TXT$ t,final int i) {
    	RT.NOT_IMPLEMENTED("loadChar"); // TODO: Implement it
    	return(' ');
    }
    
    public void storeChar(final char c,final TXT$ t,final int i) {
    	RT.NOT_IMPLEMENTED("storeChar"); // TODO: Implement it
    }
    
    public TXT$ getTextInfo(final int i) {
    	RT.NOT_IMPLEMENTED("getTextInfo"); // TODO: Implement it
    	return(null);
    }
    
    public void giveTextInfo(final int i,final TXT$ t) {
    	RT.NOT_IMPLEMENTED("giveTextInfo"); // TODO: Implement it
    }
    
    public int getIntInfo(final int i) {
    	RT.NOT_IMPLEMENTED("getIntInfo"); // TODO: Implement it
    	return(0);
    }
    
    public void giveIntInfo(final int i,final int val) {
    	RT.NOT_IMPLEMENTED("giveIntInfo"); // TODO: Implement it
    }
    
    public void rts_utility(final int index,final int level) {
    	RT.NOT_IMPLEMENTED("giveIntInfo"); // TODO: Implement it
    }



}
