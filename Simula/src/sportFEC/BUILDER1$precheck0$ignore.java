// JavaLine 1 ==> SourceLine 457
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:51 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class BUILDER1$precheck0$ignore extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=0, firstLine=457, lastLine=461, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$idpack p$hp;
    public COMMON$quantity p$q;
    // Declare locals as attributes
    // JavaLine 13 ==> SourceLine 458
    public BUILDER1$precheck0$ignore prev=null;
    // Normal Constructor
    public BUILDER1$precheck0$ignore(RTObject$ staticLink,COMMON$idpack sp$hp,COMMON$quantity sp$q) {
        super(staticLink);
        // Parameter assignment to locals
        this.p$hp = sp$hp;
        this.p$q = sp$q;
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("ignore",458);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("ignore",458,inner);
                // JavaLine 28 ==> SourceLine 459
                prev=((BUILDER1$precheck0)(CUR$.SL$)).curhp;
                ((BUILDER1$precheck0)(CUR$.SL$)).curhp=((BUILDER1$precheck0$ignore)CUR$);
                // JavaLine 31 ==> SourceLine 460
                p$q.protect=((char)0);
                // JavaLine 33 ==> SourceLine 459
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("ignore",459);
                }
                TRACE_END_STM$("ignore",459);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public BUILDER1$precheck0$ignore STM$() { return((BUILDER1$precheck0$ignore)CODE$.EXEC$()); }
    public BUILDER1$precheck0$ignore START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Class ignore",1,457,13,458,28,459,31,460,33,459,45,461);
}
