// JavaLine 1 ==> SourceLine 280
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:49 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER2$semchecker$caseexp extends CHECKER1$semchecker1$exp {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=1, firstLine=280, lastLine=323, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    public int p1$lb;
    public int p1$ub;
    public char p1$casetype;
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 283
    public ARRAY$<boolean[]>seen=null;
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER2$semchecker$caseexp$emit.class)); }
    // Normal Constructor
    public CHECKER2$semchecker$caseexp(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch,int sp1$lb,int sp1$ub,char sp1$casetype) {
        super(staticLink,sp$pred,sp$ch);
        // Parameter assignment to locals
        this.p1$lb = sp1$lb;
        this.p1$ub = sp1$ub;
        this.p1$casetype = sp1$casetype;
        // Declaration Code
        TRACE_BEGIN_DCL$("caseexp",314);
        // JavaLine 26 ==> SourceLine 283
        int[] seen$LB=new int[1]; int[] seen$UB=new int[1];
        seen$LB[0]=0; seen$UB[0]=p1$ub-(p1$lb);
        BOUND_CHECK$(seen$LB[0],seen$UB[0]);
        seen=new ARRAY$<boolean[]>(new boolean[seen$UB[0]-seen$LB[0]+1],seen$LB,seen$UB);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("caseexp",283,inner);
                // JavaLine 35 ==> SourceLine 318
                if(((p1$ub-(p1$lb))>=(32768))) {
                    // JavaLine 37 ==> SourceLine 319
                    {
                        TRACE_BEGIN_STM$("CompoundStatement319",319);
                        new ERRMSG$error0(((CHECKER2)(CUR$.SL$.SL$)),440);
                        p1$ub=(p1$lb+(32767));
                        type=((CHECKER2)(CUR$.SL$.SL$)).IELSE;
                        TRACE_END_STM$("CompoundStatement319",319);
                    }
                }
                // JavaLine 46 ==> SourceLine 320
                ((CHECKER2)(CUR$.SL$.SL$)).curcase=new BUILDER1$casedescr(((CHECKER2)(CUR$.SL$.SL$)),((p1$ub-(p1$lb))+(1)),p1$lb,p1$ub,((CHECKER2)(CUR$.SL$.SL$)).curcase,p1$casetype).STM$();
                // JavaLine 48 ==> SourceLine 321
                ((CHECKER2$semchecker)(CUR$.SL$)).opc=((CHECKER2)(CUR$.SL$.SL$)).ICASE;
                call(((CHECKER2)(CUR$.SL$.SL$)).coder);
                // JavaLine 51 ==> SourceLine 318
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("caseexp",318);
                }
                TRACE_END_STM$("caseexp",318);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER2$semchecker$caseexp STM$() { return((CHECKER2$semchecker$caseexp)CODE$.EXEC$()); }
    public CHECKER2$semchecker$caseexp START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER2.DEF","Class caseexp",1,280,14,283,26,283,35,318,37,319,46,320,48,321,51,318,62,323);
}
