// JavaLine 1 ==> SourceLine 1712
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$prefIdent extends CHECKER1$semchecker1$identifier {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=2, firstLine=1712, lastLine=1723, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$prefIdent(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch) {
        super(staticLink,sp$pred,sp$ch);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("prefIdent",1712);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("prefIdent",1712,inner);
                // JavaLine 21 ==> SourceLine 1715
                ctype=((CHECKER1)(CUR$.SL$.SL$)).IIDN;
                // JavaLine 23 ==> SourceLine 1716
                meaning=new BUILDER1$meaningof(((CHECKER1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb).RESULT$;
                // JavaLine 25 ==> SourceLine 1717
                if(VALUE$((meaning==(null)))) {
                    meaning=new ERRMSG$newnotseen(((CHECKER1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb).RESULT$;
                }
                // JavaLine 29 ==> SourceLine 1718
                if(VALUE$((meaning.kind!=(((CHECKER1)(CUR$.SL$.SL$)).K_class)))) {
                    // JavaLine 31 ==> SourceLine 1719
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1719",1719);
                        new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$prefIdent)CUR$),333);
                        meaning=null;
                        TRACE_END_STM$("CompoundStatement1719",1719);
                    }
                } else
                // JavaLine 39 ==> SourceLine 1720
                if(VALUE$((meaning.descr.npar>(0)))) {
                    new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$prefIdent)CUR$),352);
                }
                // JavaLine 43 ==> SourceLine 1721
                cl=((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl;
                // JavaLine 45 ==> SourceLine 1715
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("prefIdent",1715);
                }
                TRACE_END_STM$("prefIdent",1715);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$prefIdent STM$() { return((CHECKER1$semchecker1$prefIdent)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$prefIdent START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class prefIdent",1,1712,21,1715,23,1716,25,1717,29,1718,31,1719,39,1720,43,1721,45,1715,56,1723);
}
