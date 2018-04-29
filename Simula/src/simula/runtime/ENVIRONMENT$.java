/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.util.Random;

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
public class ENVIRONMENT$ {
	static long START_TIME = System.currentTimeMillis();
	static char CURRENTLOWTEN = '&';
	static char CURRENTDECIMALMARK = '.';
	public final double maxlongreal=Double.MAX_VALUE;
	public final double minlongreal=Double.MIN_VALUE;
	public final float maxreal=Float.MAX_VALUE;
	public final float minreal=Float.MIN_VALUE;
	public final int maxrank=256; // Character.???;
	public final int maxint=Integer.MAX_VALUE;
	public final int minint=Integer.MIN_VALUE;
    public final static TXT$ NOTEXT=new TXT$();


	/**
	 * The value of "simulaid" is an implementation defined string of the
	 * following general format:
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
	TXT$ simulaid;

	// TODO: Complete the implementation according
	// to Simula Standard Definition.

	// Constructor
	public ENVIRONMENT$() {
		//super(null, null);
	}
	
	// ************************************************************
	// *** object IS classIdentifier - Kan optimaliseres
	// ************************************************************
	public boolean IS$(Object ob1,Object ob2)
	{ if(ob1!=null)
	  { ob1=ob1.getClass();
	    //Util.BREAK("IS$ ob1="+ob1+", Qual="+ob1.getClass().getSimpleName());
	  }
	  //Util.BREAK("IS$ ob2="+ob2+", Qual="+ob2.getClass().getSimpleName());
	  //Util.BREAK("IS$ Result="+((ob1==ob2)?"true":"false"));
	  return(ob1==ob2);
	}
	
	// ****************************************************
	// *** The Abstract Generic Class $NAME<T> supporting
	// *** Name-Parameters in Java Coding.
	// ****************************************************
	public abstract class $NAME<T> {
		public abstract T get();
		public T put(T x) { throw new RuntimeException("Illegal assignment. Name parameter is not a variable"); }
	}
	

	// ************************************************************
	// *** ARRAY OBJECTS
	// ************************************************************
	static final String arrayError="Illegal use of array";

	public class $ARRAY<T>
	{ public T Elt;
	  public int[] LB;
	  public int[] UB;
	  public $ARRAY(T Elt,int[] LB,int[] UB)
	  { this.Elt=Elt; this.LB=LB; this.UB=UB; }
	  public $ARRAY<T> COPY()
	  {	throw new RuntimeException("Array by Value is not implemented");
		// T AA=A.clone();
		// $ARRAY<T> to=new $ARRAY<T>(AA,LB,UB);  // TODO
		// System.arraycopy(A,0,AA,0,A.length);
	  }
	  public String toString()
	  { int nDim=LB.length;
		StringBuilder s=new StringBuilder();
		if(nDim==1)
		{ s.append("$ARRAY(").append(LB[0]).append(':').append(UB[0]).append("), ");
		  int length=UB[0]-LB[0]+1;
		  s.append("LENGTH=").append(length);
		}
		return(s.toString());
	  }
	}

//	void test1()
//	{ int[] Table$LB={6};
//	  int[] Table$UB={56};
//	  $ARRAY<int[]> Table=new $ARRAY<int[]>(new int[51],Table$LB,Table$UB);
//	  int x=45; // Index
//	  int i=Table.Elt[x-Table.LB[1]];  //  i := Table(x); 
//	  Table.Elt[x-Table.LB[1]]=i;      //  Table(x) := i;
//	}
//	
//	void test2()
//	{ $ARRAY<TXT$[][]> TA;
//	  int[] LB = {6,8};
//	  int[] UB = {56,88};
//	  TA=new $ARRAY<TXT$[][]>(new TXT$[51][81],LB,UB);
//	  int x=45; // Index
//	  int y=45; // Index
//	  TXT$ t=TA.Elt[x-TA.LB[1]][y-TA.LB[2]];  //  t :- AI(x,y); 
//	  TA.Elt[x-TA.LB[1]][y-TA.LB[2]]=t;       //  AI(x,y) :- t;
//	}
	

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
	public int mod(int i, int j) {
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
	public int rem(int i, int j) {
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
	public int abs(int e) {
		return (Math.abs(e));
	}

	public float abs(float e) {
		return (Math.abs(e));
	}

	public double abs(double e) {
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
	public int sign(double e) {
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
	 * The result is the integer "floor" of a real type item, the value always
	 * being less than or equal to the parameter. Thus, entier(1.8) returns the
	 * value 1, while entier(-1.8) returns -2.
	 * 
	 * @param d
	 * @return
	 */
	public int entier(double d) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		int j = (int) d;
		return ((((float) j) > d) ? (j - 1) : (j));
	}

	/**
	 * <pre>
	 * <type of e> procedure addepsilon(e);   <real-type> e;
	 *     addepsilon := e + ... ; ! see below;
	 * </pre>
	 * <p>
	 * The result type is that of the parameter. The result is the value of the
	 * parameter incremented (addepsilon) or decremented (subepsilon) by the
	 * smallest positive value, such that the result is not equal to the
	 * parameter within the precision of the implementation. Thus, for all
	 * positive values of "eps",
	 * 
	 * <pre>
	 * E - eps &lt;= subepsilon(E) &lt; E &lt; addepsilon(E) &lt;= E + eps
	 * </pre>
	 * 
	 * @param x
	 * @return
	 */
	public double addepsilon(double x) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
//		double addepsilon = 0.0f;
//		addepsilon = x + 0.0f;
//		return (addepsilon);
		throw new RuntimeException("ENVIRONMENT$ -- addepsilon is not implemented");
	}

	/**
	 * <pre>
	 * <type of e> procedure subepsilon(e);   <real-type> e;
	 *     subepsilon := e - ... ; ! see below;
	 * </pre>
	 * <p>
	 * The result type is that of the parameter. The result is the value of the
	 * parameter incremented (addepsilon) or decremented (subepsilon) by the
	 * smallest positive value, such that the result is not equal to the
	 * parameter within the precision of the implementation. Thus, for all
	 * positive values of "eps",
	 * 
	 * <pre>
	 * E - eps &lt;= subepsilon(E) &lt; E &lt; addepsilon(E) &lt;= E + eps
	 * </pre>
	 * 
	 * @param x
	 * @return
	 */
	public double subepsilon(double x) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
//		double subepsilon = 0.0f;
//		subepsilon = x - 0.0f;
//		return (subepsilon);
		throw new RuntimeException("ENVIRONMENT$ -- subepsilon is not implemented");
	}


	// *****************************************
	// *** Text utilities ***
	// *****************************************

	/**
	 * <pre>
	 * text procedure copy(T); text T;
	 *            if T =/= notext
	 *            then begin text U;
	 *               U.OBJ    :- new TEXTOBJ(T.LENGTH,false);
	 *               U.START  := 1;
	 *               U.LENGTH := T.LENGTH;
	 *               U.POS    := 1;
	 *               U        := T;
	 *               copy     :- U
	 *            end copy;
	 * </pre>
	 * 
	 * "copy(T)", with T =/= notext, references a new alterable main frame which
	 * contains a text value identical to that of T.
	 * 
	 * @param U
	 * @return
	 */
	public TXT$ copy(TXT$ T) {
		if (T == null) return (null);
		TXT$ U = blanks(T.LENGTH);
		ASGTXT$(U,T);
		return (U);
	}
	
	/**
	 * The operator & permits text concatenation. 
	 * @param T1
	 * @param T2
	 * @return
	 */
    public TXT$ CONC (TXT$ T1,TXT$ T2) {
       if(T1==null) T1=NOTEXT;
       if(T2==null) T2=NOTEXT;
       TXT$ U=blanks(T1.length()+T2.length());
       ASGTXT$(U.sub(1,T1.length()),T1);
       ASGTXT$(U.sub(1+T1.length(),T2.length()),T2);
       return(U);
    }


	/**
	 * <pre>
	 * text procedure blanks(n); integer n;
	 *            if        n < 0 then error("..." ! Parm. to blanks < 0;)
	 *            else if   n > 0
	 *            then begin text T;
	 *               T.OBJ    :- new TEXTOBJ(n,false);
	 *               T.START  := 1;
	 *               T.LENGTH := n;
	 *               T.POS    := 1;
	 *               T        := notext;    ! blank-fill, see 4.1.2;
	 *               blanks   :- T
	 *            end blanks;
	 * </pre>
	 * 
	 * "blanks(n)", with n > 0, references a new alterable main frame of length
	 * n, containing only blank characters. "blanks(0)" references notext.
	 * 
	 * @param n
	 * @return
	 */
	public TXT$ blanks(int n) {
		if (n < 0)
			throw new RuntimeException("Parmameter to blanks < 0");
		if (n == 0)
			return (NOTEXT);
		TXT$ textRef = new TXT$();
		TEXTOBJ textObj = new TEXTOBJ(n, false);
		textObj.fill(' ');
		textRef.START = 0; // Note: Counting from zero in this implementation
		textRef.LENGTH = n;
		textRef.POS = 0; // Note: Counting from zero in this implementation
		textRef.OBJ = textObj;
		return (textRef);
	}

	public void ASGSTR$(TXT$ T,String s) {
	    if(T==null) T=NOTEXT;
		int fromLength = 0;
		if (s != null) fromLength = s.length();
		for (int i = 0; i < fromLength; i++)
			T.OBJ.MAIN[T.START+i] = s.charAt(i);
		for (int i = fromLength; i < T.LENGTH; i++)
			T.OBJ.MAIN[T.START+i] = ' ';
	}

	public void ASGTXT$(TXT$ T,TXT$ U) {
	    if(T==null) T=NOTEXT;
	    if(U==null) U=NOTEXT;
		int fromLength = 0;
		if (U != null)
			fromLength = U.LENGTH;
		for (int i = 0; i < fromLength; i++)
			T.OBJ.MAIN[T.START+i] = U.OBJ.MAIN[U.START+i];
		for (int i = fromLength; i < T.LENGTH; i++)
			T.OBJ.MAIN[T.START+i] = ' ';
	}
	
	//**************************************************************
	//*** TXTREL - Text value relations
	//**************************************************************
	public boolean TXTREL$LT(TXT$ left,TXT$ right) { return(TXTREL(left,right,1)); }
	public boolean TXTREL$EQ(TXT$ left,TXT$ right) { return(TXTREL(left,right,2)); }
	public boolean TXTREL$LE(TXT$ left,TXT$ right) { return(TXTREL(left,right,3)); }
	public boolean TXTREL$GT(TXT$ left,TXT$ right) { return(TXTREL(left,right,4)); }
	public boolean TXTREL$NE(TXT$ left,TXT$ right) { return(TXTREL(left,right,5)); }
	public boolean TXTREL$GE(TXT$ left,TXT$ right) { return(TXTREL(left,right,6)); }
	private boolean TXTREL(TXT$ left,TXT$ right,int code)
	{ int i;      // Loop index.
	  int dif;    // Difference between lengths.
	  int lng;    // Length of common parts.
	  if(left==null) left=NOTEXT;
	  if(right==null) right=NOTEXT;
	  //Util.BREAK("ENVIRONMENT.TXTREL("+code+") Left= \""+left.edText()+'"');
	  //Util.BREAK("ENVIRONMENT.TXTREL("+code+") Right=\""+right.edText()+'"');
	  lng=right.LENGTH; dif=lng-left.LENGTH;
	  //Util.BREAK("ENVIRONMENT.TXTREL("+code+") dif="+dif);
	  if(dif!=0)
	  { if(code==2) return(false);
	    if(code==5) return(true);
	    if(dif>0) lng=left.LENGTH;
	  }
	  i=0;
	  while(i<lng)
	  {	int rightChar=right.OBJ.MAIN[right.START+i];     
	    int leftChar=left.OBJ.MAIN[left.START+i];  
	    if(rightChar!=leftChar)
	    {
	  	  //Util.BREAK("ENVIRONMENT.TXTREL("+code+") pos="+i);
	  	  //Util.BREAK("ENVIRONMENT.TXTREL("+code+") leftChar="+(char)leftChar+", code="+leftChar);
	  	  //Util.BREAK("ENVIRONMENT.TXTREL("+code+") rightChar="+(char)rightChar+", code="+rightChar);
	      dif=rightChar-leftChar; break;
	    }
	    i=i + 1;
	  };
	  //Util.BREAK("ENVIRONMENT.TXTREL("+code+") dif="+dif);
	  switch(code)
	  { case 1: return(0 <  dif);
	    case 2: return(0 == dif);
	    case 3: return(0 <= dif);
	    case 4: return(0 >  dif);
	    case 5: return(0 != dif);
	    case 6: return(0 >= dif);
	    default: throw new RuntimeException("Internal Error");
	  }
	}

	//**************************************************************
	//*** TXTREL - Text reference relations. ==  =/=
	//**************************************************************
	public boolean TRF_EQ(TXT$ left,TXT$ right)
	{ //Util.BREAK("TRF_EQ: left="+left);
	  //Util.BREAK("TRF_EQ: right="+right);
	  if(left==null) left=NOTEXT;
	  if(right==null) right=NOTEXT;
	  if(left.LENGTH!=right.LENGTH) return(false);
	  if(left.START!=right.START) return(false);
	  if(left.OBJ!=right.OBJ) return(false);
	  return(true);
	}
	public boolean TRF_NE(TXT$ left,TXT$ right)
	{ return(!TRF_EQ(left,right)); }

	
	
	/**
	 * <pre>
	 * character procedure char(i);  integer i;
	 *    char := ... ;
	 * </pre>
	 * 
	 * The result is the character obtained by converting the parameter
	 * according to the implementation-defined coding of characters. The
	 * parameter must be in the range 0..maxrank.
	 * 
	 * @param i
	 * @return
	 */
	public char Char(int i) {
		return ((char) i);
	}

	/**
	 * <pre>
	 * character procedure isochar(i);  integer i;
	 *    isochar := ... ;
	 * </pre>
	 * 
	 * The result is the character obtained by converting the parameter
	 * according to the ISO 2022 standard character code. The parameter must be
	 * in the range 0..255.
	 * 
	 * @param n
	 * @return
	 */
	public char isochar(int n) {
		return ((char) n);
	}

	/**
	 * <pre>
	 * integer procedure rank(c);  character c;
	 *    rank := ... ;
	 * </pre>
	 * 
	 * The result is the integer obtained by converting the parameter according
	 * to the implementation-defined character code.
	 * 
	 * @param c
	 * @return
	 */
	public int rank(char c) {
		return ((int) c);
	}

	/**
	 * <pre>
	 * integer procedure isorank(c);  character c;
	 *    isorank := ... ;
	 * </pre>
	 * 
	 * The result is the integer obtained by converting the parameter according
	 * to the ISO 2022 standard character code.
	 * 
	 * @param c
	 * @return
	 */
	public int isorank(char c) {
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
	public boolean digit(char c) {
		return (Character.isDigit(c));
	}

	/**
	 * <pre>
	 * Boolean procedure letter(c);  character c;
	 *    letter := ... ;
	 * </pre>
	 * 
	 * The result is true if the parameter is a letter of the English alphabet
	 * ('a' ... 'z', 'A' ... 'Z').
	 * 
	 * @param c
	 * @return
	 */
	public boolean letter(char c) {
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
	 * Changes the value of the current lowten character to that of the
	 * parameter. The previous value is returned. Illegal parameters are
	 * <p>
	 * digits, plus ("+"), minus ("-"), dot ("."), comma (","), control
	 * characters (i.e. ISO code<32), DEL (ISO code 127), and all characters
	 * with ISO code greater than 127.
	 * 
	 * @param c
	 * @return
	 */
	public char lowten(char c) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		char lowten = CURRENTLOWTEN;
		CURRENTLOWTEN = c;
		return (lowten);
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
	 * Changes the value of the decimal point character used by the text
	 * (de)editing procedures (cf. 8.7 and 8.8). The previous value is returned.
	 * The only legal parameter values are dot and comma.
	 * 
	 * @param c
	 * @return
	 */
	public char decimalmark(char c) {
		char decimalmark = 0;
		if (c != '.' && c != ',') {
			throw new RuntimeException("Decimalmark error");
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
	 * Convert the letters in the text parameter to their upper case
	 * representation. Only letters of the English alphabet are converted.
	 * <p>
	 * The result is a reference to the parameter.
	 * 
	 * @param t
	 * @return
	 */
	public TXT$ upcase(TXT$ t) {
		t.setpos(1);
		while (t.more()) {
			char c = t.getchar();
			t.setpos(t.pos() - 1);
			t.putchar(Character.toUpperCase(c));
		}
		t.setpos(1); // TODO: Sjekk dette mot SIMULA Standard.
		return (t);
	}

	/**
	 * <pre>
	 * text procedure lowcase(t); text t;
	 *                begin  t.setpos(1); lowcase:- t; ... end;
	 * </pre>
	 * 
	 * Convert the letters in the text parameter to their lower case
	 * representation. Only letters of the English alphabet are converted.
	 * <p>
	 * The result is a reference to the parameter.
	 * 
	 * @param t
	 * @return
	 */
	public TXT$ lowcase(TXT$ t) {
		t.setpos(1);
		while (t.more()) {
			char c = t.getchar();
			t.setpos(t.pos() - 1);
			t.putchar(Character.toLowerCase(c));
		}
		t.setpos(1); // TODO: Sjekk dette mot SIMULA Standard.
		return (t);
	}

	// *****************************************
	// *** Mathematical functions ***
	// *****************************************

	public double sqrt(double r) {
		return (Math.sqrt(r));
	}

	public double sin(double r) {
		return (Math.sin(r));
	}

	public double cos(double r) {
		return (Math.cos(r));
	}

	public double tan(double r) {
		return (Math.tan(r));
	}

	public double cotan(double r) {
		return (1.0 / Math.tan(r));
	}

	public double arcsin(double r) {
		return (Math.asin(r));
	}

	public double arccos(double r) {
		return (Math.acos(r));
	}

	public double arctan(double r) {
		return (Math.atan(r));
	}

	public double arctan2(double y, double x) {
		return (Math.atan2(y, x));
	}

	public double sinh(double r) {
		return (Math.sinh(r));
	}

	public double cosh(double r) {
		return (Math.cosh(r));
	}

	public double tanh(double r) {
		return (Math.tanh(r));
	}

	public double ln(double r) {
		return (Math.log(r));
	}

	public double log10(double r) {
		return (Math.log10(r));
	}

	public double exp(double r) {
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
	 * The value is the greater of the two parameter values. Legal parameter
	 * types are text, character, real type and integer type.
	 * <p>
	 * The type of the result conforms to the rules of 3.3.1. in Simula
	 * Standard.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public double max(double x, double y) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		return (Math.max(x, y));
	}

	/**
	 * <pre>
	 * <type> procedure min(i1,i2); <type> i1; <type> i2;
	 * </pre>
	 * 
	 * The value is the lesser of the two parameter values. Legal parameter
	 * types are text, character, real type and integer type.
	 * <p>
	 * The type of the result conforms to the rules of 3.3.1. in Simula
	 * Standard.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public double min(double x, double y) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		return (Math.min(x, y));
	}

	// *****************************************
	// *** Environmental enquiries ***
	// *****************************************

	/**
	 * <pre>
	 * integer procedure sourceline;
	 * </pre>
	 * 
	 * The value indicates the line on which the procedure call occurs. The
	 * interpretation of this number is implementation-defined.
	 * 
	 * @return
	 */
	public int sourceline() {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		//return (0);
		throw new RuntimeException("ENVIRONMENT$ -- sourceline is not implemented");
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
	public void error(TXT$ msg) {
		throw new RuntimeException(msg.toString());
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
	 * The procedure "lowerbound" returns the lower bound of the dimension of
	 * the given array corresponding to the given index. The first dimension has
	 * index one, the next two, etc. An index less than one or greater than the
	 * number of dimensions of the given array constitutes a run time error.
	 * 
	 * @param a
	 * @param i
	 * @return
	 */
	public int lowerbound ($ARRAY<?> a,int i) { return(a.LB[i-1]); }
	public int lowerbound(float[] a, int i) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		//return (0);
		throw new RuntimeException("ENVIRONMENT$ -- lowerbound is not implemented");
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
	 * The procedure "upperbound" returns the upper bound of the dimension of
	 * the given array corresponding to the given index. The first dimension has
	 * index one, the next two, etc. An index less than one or greater than the
	 * number of dimensions of the given array constitutes a run time error.
	 * 
	 * @param a
	 * @param i
	 * @return
	 */
    public int upperbound ($ARRAY<?> a,int i) { return(a.UB[i-1]); }
	public int upperbound(float[] a, int i) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		//return (0);
		throw new RuntimeException("ENVIRONMENT$ -- upperbound is not implemented");
	}

	// *****************************************
	// *** Random drawing ***
	// *****************************************

	/**
	 * Random drawing
	 * <p>
	 * All random drawing procedures of SIMULA are based on the technique of
	 * obtaining "basic drawings" from the uniform distribution in the interval
	 * <0,1>.
	 * <p>
	 * Pseudo-random number streams
	 * <p>
	 * A basic drawing replaces the value of a specified integer variable, say
	 * U, by a new value according to an implementation-defined algorithm.
	 * <p>
	 * As an example, the following algorithm may be suitable for binary
	 * computers:
	 * 
	 * <pre>
	 *                    U(i+1) = remainder ((U(i) * 5**(2*p+1)) // 2**n)
	 * </pre>
	 * 
	 * where U(i) is the i'th value of U, n is an integer related to the size of
	 * a computer word and p is a positive integer. It can be proved that, if
	 * U(0) is a positive odd integer, the same is true for all U(i) and the
	 * sequence U(0), U(1), U(2), ... is cyclic with period 2**n-2. (The last
	 * two bits of U remain constant, while the other n-2 take on all possible
	 * combinations). Thus there are two sequences - one in the range (1:2**n-3)
	 * and the other in (3:2**n-1).
	 * <p>
	 * It is a property of this algorithm that any successor to a stream number
	 * U(i), e.g. U(i+m), can be computed using modular arithmetic in log2(m)
	 * steps.
	 * <p>
	 * The real numbers u(i) = U(i) * 2**(-n) are fractions in the range <0,1>.
	 * The sequence u(1), u(2), ... is called a "stream" of pseudo- random
	 * numbers, and u(i) (i = l,2, ...) is the result of the i'th basic drawing
	 * in the stream U. A stream is completely determined by the initial value
	 * U(0) of the corresponding integer variable. Nevertheless, it is a
	 * "good approximation" to a sequence of truly random drawings.
	 * <p>
	 * By reversing the sign of the non-zero initial value U(0) of a stream
	 * variable, the antithetic drawings 1-u(1), 1-u(2), ... should be obtained.
	 * In certain situations it can be proved that means obtained from samples
	 * based on antithetic drawings have a smaller variance than those obtained
	 * from uncorrelated streams. This can be used to reduce the sample size
	 * required to obtain reliable estimates.
	 * 
	 * 
	 * @param U
	 * @return
	 */
//	private static int basicDrawing(int U) {
//		// TODO: Complete the implementation according
//		// to Simula Standard Definition.
//		int n = 3;
//		return (U * 2 ^ (-n));
//	}
	//**********************************************************************
	//*** Basic Drawing - Temporary solution using default Java-Seed.
	//**********************************************************************
	Random random=new Random();
	private double basicDRAW($NAME<Integer> U)
	{ return(random.nextDouble()); }

	//**********************************************************************
	// *** Random drawing: Procedure draw
	//**********************************************************************
	/**
	 * <pre>
	 *  Boolean procedure draw (a,U);
	 *                name U; long real a; integer U;
	 * </pre>
	 * 
	 * The value is true with the probability a, false with the probability 1 - a.
	 * It is always true if a >= 1 and always false if a <= 0.
	 * 
	 * @param a
	 * @param U
	 * @return
	 */
//	public boolean draw(float a, $NAME<Integer> U) {
//		// TODO: Complete the implementation according
//		// to Simula Standard Definition.
//		boolean draw = false;
//		int nextU = basicDrawing(U.get());
//		U.put(nextU);
//		return (draw);
//	}
	public boolean draw(float a, $NAME<Integer> U) {
	// import real a; name(integer) u; export boolean val;
		boolean val;
	    if(a >= 1.0) val= true;
	    else if( a <= 0.0) val= false;
	    else
//	    	val:= if a >= envir_DRAW(u) then true else false;
	    	val= a >= basicDRAW(U);
	    return(val);
	}

	 
	 
	//**********************************************************************
	// *** Random drawing: Procedure randint
	//**********************************************************************
    /**
     * <pre>
     *  integer procedure randint (a,b,U);
     *		          name U; integer a,b,U;
     * </pre>
     * 
     * The value is one of the integers a, a+1, ..., b-1, b with equal
     * probability. If b < a, the call constitutes an error.
     *          
     * @param a
     * @param b
     * @param U
     * @return
     */
	public int randint(int a, int b, $NAME<Integer> U) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
//	 import integer a,b; name(integer) u; export integer val;
	    if(b<a) throw new RuntimeException("Randint(a,b,u):  b < a");
//	       val:=RENTIER(envir_DRAW(u) * ((b-a+1) qua real)) + a;
	    int val=entier(basicDRAW(U) * ((b-a+1))) + a;
	    return(val);
	}

	
	
	
	//**********************************************************************
	// *** Random drawing: Procedure uniform
	//**********************************************************************
    /**
     * <pre>
     * long real procedure uniform (a,b,U);
     *          name U; long real a,b; integer U;
     * </pre>
     * 
     * The value is uniformly distributed in the interval a <= u < b.
     * If b < a, the call constitutes an error.
	 *
     * @param a
     * @param b
     * @param U
     * @return
     */
	public double uniform(double a, double b, $NAME<Integer> U) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
//		 import real a,b; name(integer) u; export real val;
	    if(b<a) throw new RuntimeException("Uniform(a,b,u): b < a");
		double val=a+((b-a)*basicDRAW(U));
		return(val);
	}

	//**********************************************************************
	// *** Random drawing: Procedure normal
	//**********************************************************************
 	/**
 	 * <pre>
 	 * long real procedure normal (a,b,U);
     *         name U; long real a,b; integer U;
 	 * </pre>
 	 * 
 	 * The value is normally distributed with mean a and standard
     * deviation b. An approximation formula may be used for the normal
     * distribution function.
     *
 	 * @param a
 	 * @param b
 	 * @param U
 	 * @return
 	 */
	public double normal(double a, double b, $NAME<Integer> U) {
			// TODO: Complete the implementation according
			// to Simula Standard Definition.
	       double t,p,q,v,x; boolean z;
	       if(b<0.0) throw new RuntimeException("Normal(a,b,u):  b <= 0.");//(ENO_DRW_8);
	       v= basicDRAW(U);
	       if(v>0.5) { z=true; v=1.0f-v; } else z= false;
	       t= Math.log(v); // log is natural logarithm (base e) in Java
	       t= Math.sqrt(-t-t);
	       p= 2.515517f + (t * (0.802853f + (t*0.010328f)));
	       q= 1.0f + (t * (1.432788f + (t * (0.189269f + (t*0.001308f)))));
	       x= b * (t-(p/q));
	       double val= a + ( (z)? x : -x );
	       return(val);
	}

	//**********************************************************************
	// *** Random drawing: Procedure negexp
	//**********************************************************************
	/**
	 * <pre>
	 * long real procedure negexp (a,U);
     *          name U; long real a; integer U;
	 * </pre>
	 * 
	 * The value is a drawing from the negative exponential distribution
     * with mean 1/a, defined by -ln(u)/a, where u is a basic drawing.
     * This is the same as a random "waiting time" in a Poisson
     * distributed arrival pattern with expected number of arrivals per
     * time unit equal to a. If a is non-positive, a runtime error occurs.
     * 
	 * @param a
	 * @param U
	 * @return
	 */
	public double negexp(double a, $NAME<Integer> U) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
	    if(a <= 0.0) throw new RuntimeException("Negexp(a,u): a <= 0");
	    double v=basicDRAW(U);
	    double val= - Math.log(v) / a;
	    return (val);
	}

	//**********************************************************************
	// *** Random drawing: Procedure Poisson
	//**********************************************************************
	/**
	 * <pre>
	 * integer procedure Poisson (a,U);
     *          name U; long real a; integer U;
	 * </pre>
	 * The value is a drawing from the Poisson distribution with
     * parameter a. It is obtained by n+1 basic drawings, u(i), where n
     * is the function value. n is defined as the smallest non-negative
     * integer for which
     * <p>
     *        u(0) * u(1) * ... * u(n)  <  e**(-a)
     * <p>
     * The validity of the formula follows from the equivalent condition
     * <p>
     *      -ln(u(0)) - ln(u(1)) - ... - ln(u(n))  >  1
     * <p>
     * where the left hand side is seen to be a sum of "waiting times"
     * drawn from the corresponding negative exponential distribution.
     * <p>
     * When the parameter a is greater than some implementation-defined
     * value, for instance 20.0, the value may be approximated by
     * entier(normal(a,sqrt(a),U) + 0.5) or, when this is negative, by zero.
	 * 
	 * @param a
	 * @param U
	 * @return
	 */
	public int Poisson(double a, $NAME<Integer> U) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		int val; double acc,xpa,sqa;
		if(a <= 0.0) val=0;
		else if(a > 20.0)
		{ // entier(normal(a,sqrt(a),U) + 0.5)
		  sqa=Math.sqrt(a);
		  val=entier(normal(a,sqa,U)+0.5);
	    } else {
	    	acc=1.0; val=0;
	        xpa=Math.exp(-a);
//		    repeat acc= acc * basicDRAW(U);
//		    while(acc >= xpa) val= val + 1.0;
		    do { acc= acc * basicDRAW(U); val= val+1; }
		    while(acc >= xpa); val=val-1;
	    }
		return (val);
	}

	//**********************************************************************
	// *** Random drawing: Procedure Erlang
	//**********************************************************************
	/**
	 * <pre>
	 * long real procedure Erlang (a,b,U);
     *          name U; long real a,b; integer U;
     * </pre>
     * 
     * The value is a drawing from the Erlang distribution with mean 1/a
     * and standard deviation 1/(a*sqrt(b)). It is defined by b basic
     * drawings u(i), if b is an integer value,
	 * <p>
     *     - ( ln(u(1)) + ln(u(2)) + ... + ln(u(b)) )  /  (a*b)
	 * <p>
     * and by c+1 basic drawings u(i) otherwise, where c is equal to
     * entier(b),
	 * <p>
     *     - ( ln(u(1)) + ... + ln(u(c)) + (b-c)*ln(u(c+1)) ) / (a*b)
	 * <p>
     * Both a and b must be greater than zero.
	 * <p>
     * The last formula represents an approximation.
     *          
	 * @param a
	 * @param b
	 * @param U
	 * @return
	 */
	public double Erlang(double a, double b, $NAME<Integer> U) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		// import real a,b; name(integer) u; export real val;
		int c; double val,bc,ab,z,v;
		if(a <= 0.0 || b <= 0.0) throw
		   new RuntimeException("Erlang(a,b,u):  a <= 0  or  b <= 0");
		val=0; c=entier(b);
		bc= b - c; ab= a * b;
		while((c--) > 0)
		{ v=basicDRAW(U); z=Math.log(v);
		  val= val - (z/ab);
		}
		if(bc > 0.0)
		{ v=basicDRAW(U); z=Math.log(v);
		  val= val - ((bc*z) / ab );
		}
		return(val);
	}

	//**********************************************************************
	// *** Random drawing: Procedure discrete
	//**********************************************************************
	/**
	 * <pre>
     *  integer procedure discrete (A,U);
               name U; <real-type> array A; integer U;
   	 * </pre>
	 * 
	 * The one-dimensional array A, augmented by the element 1 to the
     * right, is interpreted as a step function of the subscript,
     * defining a discrete (cumulative) distribution function.
     * <p>
     * The function value satisfies
     * <p>
     *      lowerbound(A,1) <= discrete(A,U) <= upperbound(A,1)+1.
     * <p>
     * It is defined as the smallest i such that A(i) > u, where u is a
     * basic drawing and A(upperbound(A,1)+1) = 1.
     *
	 * @param A
	 * @param U
	 * @return
	 */
	public int discrete($ARRAY<double[]> A, $NAME<Integer> U) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		int result,j,nelt; double v;
		int lb=A.LB[0]; int ub=A.UB[0];
		v=basicDRAW(U); nelt=ub-lb+1; result=ub+1; j=0;
		do
		{ if( A.Elt[j] > v) { result=lb+j; nelt=0; }
		  j= j + 1;
		} while(j < nelt);
		return (result);
	}

	//**********************************************************************
	// *** Random drawing: Procedure linear
	//**********************************************************************
	/**
	 * <pre>
	 *  long real procedure linear (A,B,U);
     *       name U; <real-type> array A,B; integer U;
     * </pre>
     * 
	 * The value is a drawing from a (cumulative) distribution function F,
     * which is obtained by linear interpolation in a non-equidistant
     * table defined by A and B, such that A(i) = F(B(i)).
     * <p>
     * It is assumed that A and B are one-dimensional arrays of the
     * same length, that the first and last elements of A are equal
     * to 0 and 1 respectively and that A(i) >= A(j) and B(i) > B(j)
     * for i>j. If any of these conditions are not satisfied, the effect
     * is implementation-defined.
     * <p>
     * The steps in the function evaluation are:
     * <p>
     *    l. draw a uniform <0,1> random number, u.
     * <p>
     *    2. determine the lowest value of i, for which
     * <p>
     *            A(i-1) <= u <= A(i)
     * <p>
     *    3. compute D = A(i) - A(i-1)
     * <p>
     *    4. if D = 0:  linear = B(i-1)
     *       if D <> 0: linear = B(i-1) + (B(i) - B(i-1))*(u-A(i-1))/D
     *       
	 * @param A
	 * @param B
	 * @param U
	 * @return
	 */
	public double linear($ARRAY<double[]> A,$ARRAY<double[]> B,$NAME<Integer> U) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		//import ref(rea_arr_1) a,b; name(integer) u; export real val;
		int i,nelt; double val,a_val,a_lag,a_dif,b_val,b_lag,v;

		int lb=A.LB[0]; int ub=A.UB[0];
		
		nelt=ub-lb+1;
		if(nelt!=(B.UB[0]-B.LB[0]+1)) throw new
		   RuntimeException("Linear(A,B,U): The number of elements in A and B are different.");
		v=basicDRAW(U); i= 0;
		while(A.Elt[i] < v) i=i+1;
		if(i == 0)
		{ if(v==0.0 && A.Elt[i]==0.0) i= 1;
		  else throw new
		    RuntimeException("Linear(A,B,U): The array a does not satisfy the stated assumptions.");
		} else if(i >= nelt) throw new
		    RuntimeException("Linear(A,B,U): The array a does not satisfy the stated assumptions.");

		a_val=A.Elt[i]; a_lag=A.Elt[i-1]; a_dif= a_val - a_lag;
		if(a_dif==0.0) val= B.Elt[i-1];
		else
		{ b_val= B.Elt[i]; b_lag=B.Elt[i-1];
		  val= (((b_val-b_lag)/a_dif) * (v-a_lag)) + b_lag;
		}
		return(val);
	}

	//**********************************************************************
	// *** Utility: Procedure histd
	//**********************************************************************
	/**
	 * <pre>
	 * integer procedure histd (A,U);
     *          name U; <real-type> array A; integer U;
	 * </pre>
	 * The value is an integer in the range (lsb,usb), where lsb and
     * usb are the lower and upper subscript bounds of the
     * one-dimensional array A. The latter is interpreted as a
     * histogram defining the relative frequencies of the values.
	 * 
	 * @param A
	 * @param U
	 * @return
	 */
	public int histd($ARRAY<double[]> A, $NAME<Integer> U) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		//import ref(rea_arr_1) a; name(integer) u; export integer i;
		int result=0;
		int j;       //  Array index.
		int nelt;    //  Number of array elements.
		double sum;  //  Sum of all array element values.
		double wsum; //  Weighted sum of all array element values.
		double tmp;  //  Temporary variabel.
		      
		int lb=A.LB[0]; int ub=A.UB[0];
		nelt=ub-lb+1;
		j= 0; sum= 0.0;
		do
		{ tmp=A.Elt[j];
		  if(tmp < 0.0) throw new
		     RuntimeException("Histd(a,u):  An element of the array a is negative");
		  sum= sum + tmp; j= j + 1;
		} while(j < nelt);
		wsum= sum * basicDRAW(U); // Make  0 <= wsum < sum
		j= 0; sum= 0.0;
		do
		{ sum= sum + A.Elt[j];
		  if(sum >= wsum) { result= lb+j; nelt=0; } // We will do this once and only once.
		  j= j + 1;
		} while(j < nelt);
		return (result);
	}

	// *****************************************
	// *** Calendar and timing utilities ***
	// *****************************************

	public TXT$ datetime() {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		TXT$ datetime = null;
		datetime = copy(new TXT$("..."));
		return (datetime);
	}

	/**
	 * <pre>
	 * long real procedure cputime;
	 * </pre>
	 * 
	 * The value is the number of processor seconds spent by the calling
	 * program.
	 * 
	 * @return
	 */
	public double cputime() {
		double cputime = System.currentTimeMillis() - START_TIME;
		return (cputime / 1000);
	}

	public double clocktime() {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		//return (0.0);
		throw new RuntimeException("ENVIRONMENT$ -- clocktime is not implemented");
	}

	// *****************************************
	// *** Miscellaneous utilities ***
	// *****************************************

	public void histo(float[] A, float[] B, float c, float d) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		throw new RuntimeException("ENVIRONMENT$ -- histo is not implemented");

	}

	public void accum($NAME<Float> a,
			$NAME<Float> b, $NAME<Float> c, float d) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		throw new RuntimeException("ENVIRONMENT$ -- accum is not implemented");

	}

}
