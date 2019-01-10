// JavaLine 1 ==> SourceLine 422
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 12:01:21 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER2$semchecker$unstack$caseSingle extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=422, lastLine=443, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER2$semchecker$unstack$caseSingle(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("caseSingle",422);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER2$semchecker$unstack$caseSingle STM$() {
        TRACE_BEGIN_STM$("caseSingle",422);
        // JavaLine 23 ==> SourceLine 425
        if(IS$(((CHECKER2$semchecker)(CUR$.SL$.SL$)).exptop,CHECKER1$semchecker1$arithconst.class)) {
            // JavaLine 25 ==> SourceLine 426
            {
                TRACE_BEGIN_STM$("CompoundStatement426",426);
                ((CHECKER2$semchecker$unstack)(CUR$.SL$)).rhi=new BUILDER1$getSAFEint(((CHECKER2)(CUR$.SL$.SL$.SL$)),((CHECKER1$semchecker1$arithconst)(((CHECKER2$semchecker)(CUR$.SL$.SL$)).exptop)).ixhi,((CHECKER1$semchecker1$arithconst)(((CHECKER2$semchecker)(CUR$.SL$.SL$)).exptop)).ixlo).RESULT$;
                // JavaLine 29 ==> SourceLine 428
                ((CHECKER2$semchecker$unstack)(CUR$.SL$)).lhc=((CHECKER2)(CUR$.SL$.SL$.SL$)).IINTG;
                TRACE_END_STM$("CompoundStatement426",428);
            }
        } else
        // JavaLine 34 ==> SourceLine 431
        if(IS$(((CHECKER2$semchecker)(CUR$.SL$.SL$)).exptop,CHECKER1$semchecker1$charconst.class)) {
            // JavaLine 36 ==> SourceLine 432
            {
                TRACE_BEGIN_STM$("CompoundStatement432",432);
                ((CHECKER2$semchecker$unstack)(CUR$.SL$)).rhi=rank(((CHECKER1$semchecker1$charconst)(((CHECKER2$semchecker)(CUR$.SL$.SL$)).exptop)).ixlo);
                // JavaLine 40 ==> SourceLine 433
                ((CHECKER2$semchecker$unstack)(CUR$.SL$)).lhc=((CHECKER2)(CUR$.SL$.SL$.SL$)).ICHAR;
                TRACE_END_STM$("CompoundStatement432",433);
            }
        } else
        // JavaLine 45 ==> SourceLine 434
        {
            TRACE_BEGIN_STM$("CompoundStatement434",434);
            new ERRMSG$error0(((CHECKER2)(CUR$.SL$.SL$.SL$)),441);
            ((CHECKER2$semchecker$unstack)(CUR$.SL$)).lhc=((CHECKER2)(CUR$.SL$.SL$.SL$)).IELSE;
            TRACE_END_STM$("CompoundStatement434",434);
        }
        // JavaLine 52 ==> SourceLine 442
        new CHECKER1$semchecker1$popExpStack(((CHECKER2$semchecker)(CUR$.SL$.SL$)));
        TRACE_END_STM$("caseSingle",442);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER2.DEF","Procedure caseSingle",1,422,23,425,25,426,29,428,34,431,36,432,40,433,45,434,52,442,57,443);
}
