/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.utilities;

/**
 * <pre>
 * Precedence of Boolean operators
 * The sequence of operations within one expression is generally from left to right, with the following additional rules.
 *
 * According to the syntax given in 3.2 the following rules of precedence hold:

         first:    non-Boolean expressions
         second:   <  <=  =  >=  >  <>  ==  =/=  is  in
         third:    not
         fourth:   and
         fifth:    or
         sixth:    imp
         seventh:  eqv
         eighth:   and then
         nineth:   or else
 * </pre>
 * 
 * 
 * Simula Operator Precedence Table.
 * Operator with lower level is performed first.
 * http://www.cs.bilkent.edu.tr/~guvenir/courses/CS101/op_precedence.html
 * <pre>
 * 14  :=  :-
 * 13  OR_ELSE
 * 12  AND_THEN
 * 11  EQV
 * 10  IMP
 *  9  OR
 *  8  AND
 *  7  NOT
 *  6  < <= > >= = <> ==  =/=  IS  IN
 *  5  + -
 *  4  * / //
 *  3  **
 *  2  unary(+ -) NOT QUA THIS
 *  1  .  Remote access
 * </pre>
 * 
 * <pre>
 * Simula subset of Java Operator Precedence Table
 * Larger number means higher precedence.
 * 
 * Precedence	Operator		Type				Associativity
 * ---------------------------------------------------------------
 *	  15			·		Member selection		Left to Right
 * ---------------------------------------------------------------
 *	  13			+		Unary plus				Right to left
 *					-		Unary minus
 *					!		Unary logical negation
 * ---------------------------------------------------------------
 *	  12			*		Multiplication 
 *					/ 		Division
 *					%		Modulus					Left to right
 * ---------------------------------------------------------------
 *	  11			+		Addition
 *					-		Subtraction				Left to right
 * ---------------------------------------------------------------
 *	   9			<		Relational less than	Left to right
 *					<=		Relational less than or equal
 *					>		Relational greater than
 *					>=		Relational greater than or equal
 *				instanceof	Type comparison (objects only)
 * ---------------------------------------------------------------
 *	   8			==		Relational is equal to	Left to right
 *					!=		Relational is not equal to	
 * ---------------------------------------------------------------
 *	   7			&		Bitwise AND				Left to right
 * ---------------------------------------------------------------
 *	   5			|		Bitwise inclusive OR	Left to right
 * ---------------------------------------------------------------
 *	   4			&&		Logical AND	THEN		Left to right
 * ---------------------------------------------------------------
 *	   3			||		Logical OR ELSE			Left to right
 * ---------------------------------------------------------------
 *	   1			=		Assignment				Right to left
 * ---------------------------------------------------------------
 * </pre>
 * 
 * 
 * <pre>
 * Complete Java Operator Precedence Table
 * Larger number means higher precedence.
 * 
 * Precedence	Operator		Type				Associativity
 * ---------------------------------------------------------------
 *    15			()		Parentheses				Left to Right
 *					[]		Array subscript
 *					·		Member selection		Left to Right
 * ---------------------------------------------------------------
 *    14			++		Unary post-increment	Right to left
 *					--		Unary post-decrement	Right to left
 * ---------------------------------------------------------------
 *	  13			++		Unary pre-increment		Right to left
 *					--		Unary pre-decrement
 *					+		Unary plus
 *					-		Unary minus
 *					!		Unary logical negation
 *					~		Unary bitwise complement
 *				( type )	Unary type cast			Right to left
 * ---------------------------------------------------------------
 *	  12			*		Multiplication 
 *					/ 		Division
 *					%		Modulus					Left to right
 * ---------------------------------------------------------------
 *	  11			+		Addition
 *					-		Subtraction				Left to right
 * ---------------------------------------------------------------
 *	  10			<<		Bitwise left shift		Left to right
 *					>>		Bitwise right shift with sign extension
 *					>>>		Bitwise right shift with zero extension	
 * ---------------------------------------------------------------
 *	   9			<		Relational less than	Left to right
 *					<=		Relational less than or equal
 *					>		Relational greater than
 *					>=		Relational greater than or equal
 *				instanceof	Type comparison (objects only)
 * ---------------------------------------------------------------
 *	   8			==		Relational is equal to	Left to right
 *					!=		Relational is not equal to	
 * ---------------------------------------------------------------
 *	   7			&		Bitwise AND				Left to right
 * ---------------------------------------------------------------
 *	   6			^		Bitwise exclusive OR	Left to right
 * ---------------------------------------------------------------
 *	   5			|		Bitwise inclusive OR	Left to right
 * ---------------------------------------------------------------
 *	   4			&&		Logical AND				Left to right
 * ---------------------------------------------------------------
 *	   3			||		Logical OR				Left to right
 * ---------------------------------------------------------------
 *	   2			? :		Ternary conditional		Right to left
 * ---------------------------------------------------------------
 *	   1			=		Assignment
 *					+=		Addition assignment
 *					-=		Subtraction assignment
 *					*=		Multiplication assignment
 *					/=		Division assignment
 *					%=		Modulus assignment		Right to left
 * ---------------------------------------------------------------
 * </pre>
 * 
 * @author Øystein Myhre Andersen
 *
 */
public class Precedence
{ int level;
  public boolean unary;
  public Precedence(int level) { this.level=level; } 
  public Precedence(int level,boolean unary) { this.level=level; this.unary=unary; } 
  public int getValue() { return(level); }

  public static final Precedence LEVEL6=new Precedence(6);
  public static final Precedence LEVEL5=new Precedence(5);
  public static final Precedence LEVEL4=new Precedence(4);
  public static final Precedence LEVEL3=new Precedence(3);
  public static final Precedence LEVEL2=new Precedence(2);
  public static final Precedence LEVEL1=new Precedence(1);
  
  public static final Precedence LEVEL_ASSIGN=new Precedence(14);   //  :=   :-
  public static final Precedence LEVEL_OR_ELSE=new Precedence(13);  //  OR ELSE   OR_ELSE
  public static final Precedence LEVEL_AND_THEN=new Precedence(12); //  AND THEN  AND_THEN
  public static final Precedence LEVEL_EQV=new Precedence(11);   //  EQV
  public static final Precedence LEVEL_IMP=new Precedence(10);   //  IMP
  public static final Precedence LEVEL_OR=new Precedence(9);     //  OR
  public static final Precedence LEVEL_AND=new Precedence(8);    //  AND
  public static final Precedence LEVEL_NOT=new Precedence(7,true);    //  NOT
  public static final Precedence LEVEL_LT=LEVEL6;     //  <   LT
  public static final Precedence LEVEL_LE=LEVEL6;     //  <=  LE
  public static final Precedence LEVEL_GT=LEVEL6;     //  >   GT
  public static final Precedence LEVEL_GE=LEVEL6;     //  >=  GE
  public static final Precedence LEVEL_EQ=LEVEL6;     //  =   EQ
  public static final Precedence LEVEL_NE=LEVEL6;     //  <>  NE
  public static final Precedence LEVEL_EQR=LEVEL6;    //  ==
  public static final Precedence LEVEL_NER=LEVEL6;    //  =/=
  public static final Precedence LEVEL_IS=LEVEL6;     //  IS
  public static final Precedence LEVEL_IN=LEVEL6;     //  IN
  public static final Precedence LEVEL_ADD=LEVEL5;    //  +
  public static final Precedence LEVEL_SUB=LEVEL5;    //  -
  public static final Precedence LEVEL_MUL=LEVEL4;    //  *
  public static final Precedence LEVEL_DIV=LEVEL4;    //  /
  public static final Precedence LEVEL_INTDIV=LEVEL4; //  //
  public static final Precedence LEVEL_EXP=LEVEL3;    //  **   EXP
  public static final Precedence LEVEL_DOT=LEVEL2;    //  .  DOT   // TODO: Uavklart precedence DOT vs QUA
//  public static final Precedence LEVEL_DOT=LEVEL1;    //  .  DOT
//public static final Precedence LEVEL_POS=LEVEL2;    //  unary +  POS
//public static final Precedence LEVEL_NEG=LEVEL2;    //  unary -  NEG
  public static final Precedence LEVEL_QUA=LEVEL1;    //  QUA
  public static final Precedence LEVEL_THIS=LEVEL1;   //  THIS
  
}