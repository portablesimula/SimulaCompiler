// JavaLine 1 ==> SourceLine 1702
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:42 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$newIdent extends CHECKER1$semchecker1$identifier {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=2, firstLine=1702, lastLine=1709, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$newIdent(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch) {
        super(staticLink,sp$pred,sp$ch);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("newIdent",1702);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("newIdent",1702,inner);
                // JavaLine 21 ==> SourceLine 1704
                ctype=((CHECKER1)(CUR$.SL$.SL$)).IIDN;
                // JavaLine 23 ==> SourceLine 1705
                qual=meaning=new CHECKER1$semchecker1$qualification(((CHECKER1$semchecker1)(CUR$.SL$))).RESULT$;
                // JavaLine 25 ==> SourceLine 1706
                type=((CHECKER1)(CUR$.SL$.SL$)).IREF;
                kind=((CHECKER1)(CUR$.SL$.SL$)).K_class;
                // JavaLine 28 ==> SourceLine 1707
                if((qual.kind!=(((CHECKER1)(CUR$.SL$.SL$)).K_class))) {
                    // JavaLine 30 ==> SourceLine 1708
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1708",1708);
                        type=((CHECKER1)(CUR$.SL$.SL$)).IELSE;
                        new ERRMSG$error1id(((CHECKER1)(CUR$.SL$.SL$)),335,((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb);
                        TRACE_END_STM$("CompoundStatement1708",1708);
                    }
                }
                // JavaLine 38 ==> SourceLine 1704
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("newIdent",1704);
                }
                TRACE_END_STM$("newIdent",1704);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$newIdent STM$() { return((CHECKER1$semchecker1$newIdent)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$newIdent START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class newIdent",1,1702,21,1704,23,1705,25,1706,28,1707,30,1708,38,1704,49,1709);
}
