// JavaLine 1 ==> SourceLine 103
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$exp extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=0, firstLine=103, lastLine=172, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public CHECKER1$semchecker1$exp p$pred;
    public char p$ch;
    // Declare locals as attributes
    // JavaLine 13 ==> SourceLine 113
    public char type=0;
    // JavaLine 15 ==> SourceLine 114
    public char cl=0;
    // JavaLine 17 ==> SourceLine 115
    public char ctype=0;
    // JavaLine 19 ==> SourceLine 116
    public int issimple=0;
    // JavaLine 21 ==> SourceLine 122
    public char kind=0;
    // JavaLine 23 ==> SourceLine 123
    public COMMON$quantity qual=null;
    // JavaLine 25 ==> SourceLine 124
    public COMMON$quantity meaning=null;
    public PRCQNT$ sameAs$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$exp$sameAs.class)); }
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$exp$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$exp(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch) {
        super(staticLink);
        // Parameter assignment to locals
        this.p$pred = sp$pred;
        this.p$ch = sp$ch;
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("exp",169);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("exp",169,inner);
                // JavaLine 42 ==> SourceLine 172
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("exp",172);
                }
                TRACE_END_STM$("exp",172);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$exp STM$() { return((CHECKER1$semchecker1$exp)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$exp START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class exp",1,103,13,113,15,114,17,115,19,116,21,122,23,123,25,124,42,172,54,172);
}
