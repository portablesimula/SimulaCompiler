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
 * by the three first components. POS identifies the current character. See
 * 3.1.2.
 * 
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public final class TXT$ {
	private static final int UNICODE_MINUS_SIGN=8722; // 0x2212
	TEXTOBJ OBJ;
	int START; // Start index of OBJ.MAIN[], counting from zero.
			   // Note this differ from Simula Definition.
	int LENGTH;
	int POS;   // Current index of OBJ.MAIN[], counting from zero.
			   // Note this differ from Simula Definition.

	// Constructor
	public TXT$() {}

	// Constructor
	public TXT$(final String s) {
		OBJ = new TEXTOBJ(s);
		START = 0; // Note: Counting from zero in this implementation
		LENGTH = OBJ.SIZE;
		POS = 0; // Note: Counting from zero in this implementation
	}

	// Utility
	public String toString() {
		return ("TEXT$: START=" + START + ", LENGTH=" + LENGTH + ", POS="
				+ POS + ", OBJ=" + OBJ);
	}

	// Utility
	public String edText() {
		if(OBJ==null) return("");
		return (OBJ.edText(START, LENGTH));
	}

	// Utility
	public String edStripedText() {
		if(OBJ==null) return("");
		TXT$ stp=TXT$.strip(this);
		if(stp==null) return("");
		return (stp.OBJ.edText(START, stp.LENGTH));
	}

	// Utility
	public String edTextToPos() {
		return (OBJ.edText(START, POS)); 
	}

	public static boolean constant(TXT$ T) {
		return (T==null || T.OBJ == null || T.OBJ.CONST);
	}

	public static int start(TXT$ T) {
		if(T==null) return(1);
		return (T.START + 1);
	}

	public static int length(TXT$ T) {
		if(T==null) return(0);
		return (T.LENGTH);
	}

	/**
	 * "X.main" is a reference to the main frame which contains the frame
	 * referenced by X.
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
	 * @return
	 */
	public static TXT$ main(TXT$ T) {
		if(T==null) return(null);
		if(T.OBJ==null) return(null);
		TXT$ U = new TXT$();
		U.OBJ = T.OBJ;
		U.START = 0; // Note: Counting from zero in this implementation
		U.LENGTH = T.OBJ.SIZE;
		U.POS = 0; // Note: Counting from zero in this implementation
		return (U);
	}

	public static int pos(TXT$ T) {
		if(T==null) return(1);
		return (T.POS + 1);
	}

	public static void setpos(TXT$ T,int i) {
		if (T!=null) T.POS = (i < 1 || i > T.LENGTH + 1) ? T.LENGTH : (i - 1);
	}

	public static boolean more(TXT$ T) {
		if (T==null) return(false);
		return (T.POS < T.LENGTH);
	}

	public static char getchar(TXT$ T) {
		if (T.POS >= T.LENGTH) {
			throw new RuntimeException("Getchar");
		} else {
			T.POS++;
			return (T.OBJ.MAIN[T.START + T.POS - 1]);
		}
	}

	private static void checkAssignable(TXT$ T) {
		if (T==null || T.OBJ == null) throw new RuntimeException("Illegal Text T.put...  T==NOTEXT");
		if(T.OBJ.CONST) throw new RuntimeException("Illegal Text T.put...  T is constant");
	}

	public static void putchar(final TXT$ T,final char c) {
		checkAssignable(T);
		if (T.POS >= T.LENGTH) throw new RuntimeException("Putchar outside frame");
		T.OBJ.MAIN[T.START + T.POS] = c;
		T.POS++;
	}

	/**
	 * If legal, "X.sub(i,n)" references that subframe of X whose first
	 * character is character number i of X, and which contains n consecutive
	 * characters. The POS attribute of the expression defines a local numbering
	 * of the characters within the subframe. If n = 0, the expression
	 * references notext.
	 * <p>
	 * If legal, the following Boolean expressions are true for any text
	 * variable X:
	 * 
	 * <pre>
	 *        X.sub(i,n).sub(j,m) == X.sub(i+j-1,m)
	 * 
	 *        n <> 0  imp  X.main == X.sub(i,n).main
	 * 
	 *        X.main.sub(X.start,X.length) == X
	 * </pre>
	 * 
	 * @param i
	 * @param n
	 * @return
	 */
	public static TXT$ sub(TXT$ T,final int i,final int n) {
//		if (i < 0 || n < 0 || i + n > LENGTH + 1)  // NOTE: FEIL I SIMULA STANDARD
		if (i <= 0)	throw new RuntimeException(" ! Sub(i,n) is out of frame, i <= 0");
		if (n < 0)throw new RuntimeException(" ! Sub(i,n) is out of frame, n < 0");
		if (T==null) T=ENVIRONMENT$.NOTEXT;
		if (i + n > T.LENGTH + 1)
			throw new RuntimeException(" ! Sub(i,n) is out of frame, i + n > LENGTH + 1");
		else if (n > 0) {
			TXT$ U = new TXT$();
			U.OBJ = T.OBJ;
			U.START = T.START + i - 1;
			RT.ASSERT(U.START>=0,"Invariant");
			U.LENGTH = n;
			U.POS = 0; // Note: Counting from zero in this implementation
			return (U);
		}
		return (null);
	}

	/**
	 * The expression "X.strip" is equivalent to "X.sub(1,n)", where n indicates
	 * the position of the last non-blank character in X. If X does not contain
	 * any non-blank character, notext is returned.
	 * <p>
	 * Let X and Y be text variables. Then after the value assignment "X:=Y", if
	 * legal, the relation "X.strip = Y.strip" has the value true, while "X = Y"
	 * is true only if X.length = Y.length.
	 * 
	 * @return
	 */
	public static TXT$ strip(TXT$ T) {
		if(T==null || T.OBJ==null) return (null);
		int n = T.LENGTH;
		while (T.OBJ.MAIN[T.START + n - 1] == ' ') {
			n = n - 1;
			if (n == 0)	return (null);
		}
		TXT$ U = new TXT$();
		U.OBJ = T.OBJ;
		U.START = T.START;
		U.LENGTH = n;
		U.POS = 0; // Note: Counting from zero in this implementation
		return (U);
	}

	/**
	 * INTEGER-ITEM     =  SIGN-PART  DIGITS
	 *
     * SIGN-PART        =  BLANKS  [ SIGN ]  BLANKS
	 *
     * SIGN             =  +  |  -
	 *
     * DIGITS           =  DIGIT  { DIGIT }
	 *
     * DIGIT            =  0  |  1  |  2  |  3  |  4
     *                 |  5  |  6  |  7  |  8  |  9
	 * @return
	 */
	private static String getIntegerItem(final TXT$ T) {
		StringBuilder sb = new StringBuilder();
		char c=0;
		T.POS=0;
		while (T.POS < T.LENGTH) { // SKIP BLANKS
			c = T.OBJ.MAIN[T.START + T.POS];
			if (c != ' ') break;
			T.POS++;
		}
		if(c=='+' || c=='-')
		{ sb.append(c); T.POS = T.POS + 1;
		  while (T.POS < T.LENGTH) { // SKIP BLANKS
			  c = T.OBJ.MAIN[T.START + T.POS];
			  if (c != ' ') break;
			  T.POS++;
		  }
		}
		while (T.POS < T.LENGTH) { // KEEP DIGITS
			c = T.OBJ.MAIN[T.START + T.POS];
			if(!Character.isDigit(c)) break;
			sb.append(c);
			T.POS++;
		}
		return (sb.toString());
	}

	public static int getint(final TXT$ T) {
		// TODO: Complete the implementation according to Simula Standard Definition.
		String item = getIntegerItem(T);
		int res = Integer.parseInt(item);
		return (res);
	}

	/**
	 *  REAL-ITEM        =  DECIMAL-ITEM  [ EXPONENT ]
     *                 |  SIGN-PART  EXPONENT
	 *
     * DECIMAL-ITEM     =  INTEGER-ITEM  [ FRACTION ]
     *                  |  SIGN-PART  FRACTION
	 *
     * INTEGER-ITEM     =  SIGN-PART  DIGITS
	 *
     * FRACTION         =  DECIMAL-MARK  DIGITS
	 *
     * SIGN-PART        =  BLANKS  [ SIGN ]  BLANKS
	 *
     * EXPONENT         =  LOWTEN-CHARACTER  INTEGER-ITEM
	 *
     * SIGN             =  +  |  -
	 *
     * DIGITS           =  DIGIT  { DIGIT }
	 *
     * DIGIT            =  0  |  1  |  2  |  3  |  4
     *                  |  5  |  6  |  7  |  8  |  9
	 *
     * LOWTEN-CHARACTER =  &  |  ...
	 *
     * DECIMAL-MARK     =  .  |  ,
	 *
	 *  BLANKS           =  {  BLANK  |  TAB  }
	 * 
	 * @return
	 */
	private static String getRealItem(final TXT$ T) {
		StringBuilder sb = new StringBuilder();
		char c=0;
		T.POS=0;
		while (T.POS < T.LENGTH) { // SKIP BLANKS
			c = T.OBJ.MAIN[T.START + T.POS];
			if (c != ' ') break;
			T.POS++;
		}
		if(c=='+' || c=='-')
		{ sb.append(c); T.POS++;
		  while (T.POS < T.LENGTH) { // SKIP BLANKS
			  c = T.OBJ.MAIN[T.START + T.POS];
			  if (c != ' ') break;
			  T.POS++;
		  }
		}
		while (T.POS < T.LENGTH) { // KEEP DIGITS
			int lastDigPos=T.POS;
			c = T.OBJ.MAIN[T.START + T.POS];
			if(Character.isDigit(c)); //OK
			else if(c==ENVIRONMENT$.CURRENTDECIMALMARK) c='.'; // OK
			else if(c=='+'); // OK
			else if(c=='-'); // OK
			else if(c==ENVIRONMENT$.CURRENTLOWTEN) c='E'; // OK
			else { T.POS=lastDigPos-1; break; }	
			sb.append(c); lastDigPos=T.POS;
			T.POS++;
		}
		return (sb.toString());
	}

	public static double getreal(final TXT$ T) {
		// TODO: Complete the implementation according to Simula Standard Definition.
		String item = getRealItem(T);
		double res = Double.parseDouble(item);
		return (res);
	}

	/**
	 * GROUPED-ITEM     =  SIGN-PART  GROUPS  [ DECIMAL-MARK  GROUPS ]
     *                 |  SIGN-PART  DECIMAL-MARK  GROUPS
	 *
     * SIGN-PART        =  BLANKS  [ SIGN ]  BLANKS
	 *
     * SIGN             =  +  |  -
	 *
	 * GROUPS           =  DIGITS  { BLANK  DIGITS }
     * DIGITS           =  DIGIT  { DIGIT }
	 *
     * DIGIT            =  0  |  1  |  2  |  3  |  4
     *                 |  5  |  6  |  7  |  8  |  9
	 * @return
	 */
	private static String getFracItem(final TXT$ T) {
		StringBuilder sb = new StringBuilder();
		char c=0; T.POS=0;
		while (T.POS < T.LENGTH) { // SKIP BLANKS
			c = T.OBJ.MAIN[T.START + T.POS];
			if (c != ' ') break;
			T.POS++;
		}
		if(c=='+' || c=='-')
		{ sb.append(c); T.POS++;
		  while (T.POS < T.LENGTH) { // SKIP BLANKS
			  c = T.OBJ.MAIN[T.START + T.POS];
			  if (c != ' ') break;
			  T.POS++;
		  }
		}
		int lastDigPos=T.POS;
		while (T.POS < T.LENGTH) { // KEEP DIGITS
			c = T.OBJ.MAIN[T.START + T.POS];
			if(Character.isDigit(c)) { sb.append(c); lastDigPos=T.POS; } //OK
			else if(c==ENVIRONMENT$.CURRENTDECIMALMARK); // OK  NOTE: THIS WAS WRONG IN PC-SIMULA
			else if(c==' '); // OK
			else break;
			T.POS++;
		}
		T.POS=lastDigPos+1;
		return (sb.toString());
	}

	public static int getfrac(final TXT$ T) {
		return(Integer.parseInt(getFracItem(T)));
	}

    private static void putRealResult(final TXT$ T,String output)
    { if(ENVIRONMENT$.CURRENTDECIMALMARK!=',')
    	 output=output.replace(',',ENVIRONMENT$.CURRENTDECIMALMARK);
      putResult(T,output);
    }
	
	/**
	 * If the text frame is too short to contain the resulting
	 * numeric item, the text frame into which the number was to
	 * be edited is filled with asterisks.
	 * The final value of the position indicator of X is X.length+1.
	 * @param s
	 */
	private static void putResult(TXT$ T,final String s) {
//		if(T==null) T=ENVIRONMENT$.NOTEXT;
		checkAssignable(T);
		char[] c = s.toCharArray();
		if (c.length > T.LENGTH) {
		    RT.numberOfEditOverflows++;
			for (int j = 0; j < T.LENGTH; j = j + 1)
				T.OBJ.MAIN[T.START + j] = '*';
		} else {
			int m=c.length-1;
			for (int j = T.LENGTH-1; j >= 0; j = j - 1) {
				char k = (m>=0) ? c[m--] : ' ';
				if(Character.toUpperCase(k)=='E') k=ENVIRONMENT$.CURRENTLOWTEN;
				if(k==160) k=' '; // String formatted with NumberFormat
				                  // may have non-breaking space
				                  // (hexa code : A0 and unicode 160). 
				T.OBJ.MAIN[T.START + j] = k;
			}
		}
		T.POS = T.LENGTH;
	}

	/**
	 * The value of the parameter is converted to an INTEGER ITEM which
     * designates an integer equal to that value.
     * 
	 * @param i
	 */
	public static void putint(final TXT$ T,final int i) {
		putResult(T,"" + i);
	}

	/**
	 * The resulting numeric item is an INTEGER ITEM if n=0 or a DECIMAL
     * ITEM with a FRACTION of n digits if n>0. It designates a number
     * equal to the value of r or an approximation to the value of r,
     * correctly rounded to n decimal places. If n<0, a run-time error
     * is caused.
     * 
	 * @param r
	 * @param n
	 */
	public static void putfix(final TXT$ T,double r, int n) {
		// TODO: Complete the implementation according to Simula Standard Definition.
		if(n<0) throw new RuntimeException("putfix(r,n) - n < 0");
		if(n==0) { putint(T,(int)(r+0.5)); return; }
		StringBuilder pattern=new StringBuilder("##0.");
		while((n--)>0) pattern.append('0');
		DecimalFormat myFormatter = new DecimalFormat(pattern.toString());
		if(r== -0.0) r=0.0; // NOTE: Java har både +0.0 og -0.0
	    String output = myFormatter.format(r);
	    output=output.replace((char)UNICODE_MINUS_SIGN,'-');
	    putRealResult(T,output);
	}

	/**
	 * The resulting numeric item is a REAL ITEM containing an EXPONENT
     * with a fixed implementation-defined number of characters. The
     * EXPONENT is preceded by a SIGN PART if n=0, or by an INTEGER ITEM
     * with one digit if n=1, or if n>1, by a DECIMAL ITEM with an
     * INTEGER ITEM of 1 digit only, and a fraction of n-1 digits. If
     * n<0 a runtime error is caused.
     * 
	 * @param r
	 * @param n
	 */
	public static void putreal(final TXT$ T,double r,int n) {
		// TODO: Complete the implementation according to Simula Standard Definition.
		if(n<0) throw new RuntimeException("putreal(r,n) - n < 0");
		if(n==0) RT.NOT_IMPLEMENTED("putreal(r,n) - n = 0");
		if(r== -0.0d) r=0.0d;
		
		StringBuilder pattern=new StringBuilder("0");
		if(n>1) pattern.append('.');
		while((n--)>1) pattern.append('0');
		pattern.append("E000");
		DecimalFormat myFormatter = new DecimalFormat(pattern.toString());
		myFormatter.setRoundingMode(RoundingMode.HALF_EVEN); // Java Default
	    String output = myFormatter.format(r);
	    output=output.replace((char)UNICODE_MINUS_SIGN,'-');	    
	    output=addPlussExponent(output);
	    putRealResult(T,output);
	}

	public static void putreal(final TXT$ T,float r, int n) {
		// TODO: Complete the implementation according to Simula Standard Definition.
		if(n<0) throw new RuntimeException("putreal(r,n) - n < 0");
		if(n==0) RT.NOT_IMPLEMENTED("putreal(r,n) - n = 0");
		if(r== -0.0f) r=0.0f;
		StringBuilder pattern=new StringBuilder("0");
		if(n>1) pattern.append('.');
		while((n--)>1) pattern.append('0');
		pattern.append("E00");
		DecimalFormat myFormatter = new DecimalFormat(pattern.toString());
		myFormatter.setRoundingMode(RoundingMode.HALF_EVEN); // Java Default
	    String output = myFormatter.format(r);
	    output=output.replace((char)UNICODE_MINUS_SIGN,'-');
	    output=addPlussExponent(output);
	    putRealResult(T,output);
	}
	
	private static String addPlussExponent(String s) { 
		s=s.replace((char)UNICODE_MINUS_SIGN,'-');
		String[] part=s.split("E");
		if(part.length==2) {
			if(!(part[1].startsWith("-"))) s=part[0]+"E+"+part[1];
		}
		return(s);
	}

	/**
	 * The resulting numeric item is a GROUPED ITEM with no DECIMAL MARK
     * if n<=0, and with a DECIMAL MARK followed by total of n digits if
     * n>0. Each digit group consists of 3 digits, except possibly the
     * first one, and possibly the last one following a DECIMAL MARK. The
     * numeric item is an exact representation of the number i * 10**(-n).
     * 
	 * @param i
	 * @param n
	 */
	public static void putfrac(final TXT$ T,final int val,final int n) {
	    int v; // Scaled value (abs)
	    int d; // Number of digits written
	    int r; // Remaining digits in current group
	    int p; // Next available position in item
	    int c; // Current digit (numerical)
	    char[] item=new char[T.LENGTH];
	    
	    if(n<=0) r=3; else { r=n % 3; if(r==0) r=3; }
	    
	    v=Math.abs(val);
	    d=0; p=item.length-1;
	    try { while( (v>0) || (d<n) ) {
		          c=v % 10; v=v/10;
	              if(r==0) { r=3; if(d!=n) item[p--]=' '; }
	              item[p--]=(char)(c+'0');
	              r=r-1; d=d+1;
	              if(d==n) item[p--]=ENVIRONMENT$.CURRENTDECIMALMARK;
		      } 
	          if(val<0) item[p--]='-';
	          while(p>=0) item[p--]=' ';
	    } catch(ArrayIndexOutOfBoundsException e) {
	    	RT.numberOfEditOverflows++;
	    	for(int i=0;i<item.length;i++) item[i]='*';
	    }
	    for(int i=0;i<item.length;i++) T.OBJ.MAIN[T.START+i]=item[i];
	}
	
}
