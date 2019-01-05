// JavaLine 1 ==> SourceLine 208
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:59:08 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class BUILDER1$precheck0 extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=208, lastLine=617, hasLocalClasses=true, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 210
    public COMMON$quantity detachquant=null;
    // JavaLine 13 ==> SourceLine 212
    public char lastblhi=0;
    public char lastbllo=0;
    // JavaLine 16 ==> SourceLine 213
    public char opc=0;
    public char opt=0;
    public char optx=0;
    public char opihi=0;
    public char opilo=0;
    // JavaLine 22 ==> SourceLine 214
    public char lastopc=0;
    // JavaLine 24 ==> SourceLine 215
    public int lowplev=0;
    // JavaLine 26 ==> SourceLine 259
    public char enclLevel=0;
    // JavaLine 28 ==> SourceLine 456
    public BUILDER1$precheck0$ignore curhp=null;
    // Normal Constructor
    public BUILDER1$precheck0(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("precheck0",614);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("precheck0",614,inner);
                // JavaLine 41 ==> SourceLine 617
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("precheck0",617);
                }
                TRACE_END_STM$("precheck0",617);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public BUILDER1$precheck0 STM$() { return((BUILDER1$precheck0)CODE$.EXEC$()); }
    public BUILDER1$precheck0 START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Class precheck0",1,208,11,210,13,212,16,213,22,214,24,215,26,259,28,456,41,617,53,617);
}
