// JavaLine 1 ==> SourceLine 245
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$boolop extends CHECKER1$semchecker1$operation {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=2, firstLine=245, lastLine=267, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    // Declare parameters as attributes
    // Declare locals as attributes
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$boolop$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$boolop(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch,CHECKER1$semchecker1$exp sp1$left,CHECKER1$semchecker1$exp sp1$right) {
        super(staticLink,sp$pred,sp$ch,sp1$left,sp1$right);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("boolop",255);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("boolop",255,inner);
                // JavaLine 22 ==> SourceLine 260
                if(VALUE$((p1$left.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN)))) {
                    new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p1$left)));
                }
                // JavaLine 26 ==> SourceLine 261
                if(VALUE$((p1$left.type!=(((CHECKER1)(CUR$.SL$.SL$)).IBOOL)))) {
                    new ERRMSG$error2xx(((CHECKER1)(CUR$.SL$.SL$)),429,p1$left.type,p$ch);
                }
                // JavaLine 30 ==> SourceLine 263
                if(VALUE$((p1$right.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN)))) {
                    new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p1$right)));
                }
                // JavaLine 34 ==> SourceLine 264
                cl=((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl;
                // JavaLine 36 ==> SourceLine 265
                if(VALUE$((p1$right.type!=(((CHECKER1)(CUR$.SL$.SL$)).IBOOL)))) {
                    new ERRMSG$error2xx(((CHECKER1)(CUR$.SL$.SL$)),430,p1$right.type,p$ch);
                }
                // JavaLine 40 ==> SourceLine 266
                type=((CHECKER1)(CUR$.SL$.SL$)).IBOOL;
                // JavaLine 42 ==> SourceLine 260
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("boolop",260);
                }
                TRACE_END_STM$("boolop",260);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$boolop STM$() { return((CHECKER1$semchecker1$boolop)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$boolop START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class boolop",1,245,22,260,26,261,30,263,34,264,36,265,40,266,42,260,53,267);
}
