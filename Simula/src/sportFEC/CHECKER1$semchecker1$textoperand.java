// JavaLine 1 ==> SourceLine 690
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$textoperand extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=0, firstLine=690, lastLine=702, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public CHECKER1$semchecker1$exp p$actual;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 691
    public CHECKER1$semchecker1$textoperand next=null;
    // Normal Constructor
    public CHECKER1$semchecker1$textoperand(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$actual) {
        super(staticLink);
        // Parameter assignment to locals
        this.p$actual = sp$actual;
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("textoperand",693);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("textoperand",693,inner);
                // JavaLine 26 ==> SourceLine 696
                if((p$actual.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN))) {
                    new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p$actual)));
                }
                // JavaLine 30 ==> SourceLine 697
                if((p$actual.type!=(((CHECKER1)(CUR$.SL$.SL$)).ITEXT))) {
                    // JavaLine 32 ==> SourceLine 698
                    {
                        TRACE_BEGIN_STM$("CompoundStatement698",698);
                        if((p$actual.type!=(((CHECKER1)(CUR$.SL$.SL$)).IELSE))) {
                            new ERRMSG$error0(((CHECKER1)(CUR$.SL$.SL$)),155);
                        }
                        // JavaLine 38 ==> SourceLine 699
                        p$actual=((CHECKER1$semchecker1)(CUR$.SL$)).dummytxtop.p$actual;
                        TRACE_END_STM$("CompoundStatement698",699);
                    }
                }
                // JavaLine 43 ==> SourceLine 696
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("textoperand",696);
                }
                TRACE_END_STM$("textoperand",696);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$textoperand STM$() { return((CHECKER1$semchecker1$textoperand)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$textoperand START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class textoperand",1,690,12,691,26,696,30,697,32,698,38,699,43,696,55,702);
}
