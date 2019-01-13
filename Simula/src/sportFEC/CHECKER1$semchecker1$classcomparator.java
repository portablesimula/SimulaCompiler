// JavaLine 1 ==> SourceLine 534
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$classcomparator extends CHECKER1$semchecker1$relation {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=3, firstLine=534, lastLine=566, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 556
    public COMMON$quantity inspect$556$89=null;
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$classcomparator$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$classcomparator(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch,CHECKER1$semchecker1$exp sp1$left,CHECKER1$semchecker1$exp sp1$right) {
        super(staticLink,sp$pred,sp$ch,sp1$left,sp1$right);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("classcomparator",556);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("classcomparator",556,inner);
                // JavaLine 24 ==> SourceLine 550
                if((p1$right.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN))) {
                    new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p1$right)));
                }
                // JavaLine 28 ==> SourceLine 551
                cl=((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl;
                ctype=((CHECKER1)(CUR$.SL$.SL$)).IEQ;
                // JavaLine 31 ==> SourceLine 552
                qual=new CHECKER1$semchecker1$qualification(((CHECKER1$semchecker1)(CUR$.SL$))).RESULT$;
                // JavaLine 33 ==> SourceLine 553
                if((qual.kind!=(((CHECKER1)(CUR$.SL$.SL$)).K_class))) {
                    // JavaLine 35 ==> SourceLine 554
                    new ERRMSG$error1id(((CHECKER1)(CUR$.SL$.SL$)),243,((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb);
                } else
                if((p1$right.type!=(((CHECKER1)(CUR$.SL$.SL$)).IREF))) {
                    {
                        TRACE_BEGIN_STM$("CompoundStatement554",554);
                        if((p1$right.type!=(((CHECKER1)(CUR$.SL$.SL$)).IELSE))) {
                            // JavaLine 42 ==> SourceLine 555
                            new ERRMSG$error0(((CHECKER1)(CUR$.SL$.SL$)),(((p$ch==(((CHECKER1)(CUR$.SL$.SL$)).IIN)))?(153):(154)));
                        }
                        TRACE_END_STM$("CompoundStatement554",555);
                    }
                }
                // JavaLine 48 ==> SourceLine 556
                {
                    // BEGIN INSPECTION 
                    inspect$556$89=p1$right.qual;
                    if(inspect$556$89!=null) //INSPECT inspect$556$89
                    // JavaLine 53 ==> SourceLine 557
                    {
                        TRACE_BEGIN_STM$("CompoundStatement557",557);
                        if((inspect$556$89.kind==(((CHECKER1)(CUR$.SL$.SL$)).K_record))) {
                            // JavaLine 57 ==> SourceLine 558
                            new ERRMSG$error1id(((CHECKER1)(CUR$.SL$.SL$)),243,((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb);
                        } else
                        if(((CHECKER1)(CUR$.SL$.SL$)).GiveNotes) {
                            // JavaLine 61 ==> SourceLine 559
                            {
                                TRACE_BEGIN_STM$("CompoundStatement559",559);
                                if(new BUILDER1$precheck0$subclass(((CHECKER1$semchecker1)(CUR$.SL$)),p1$right.qual,qual).RESULT$) {
                                    // JavaLine 65 ==> SourceLine 560
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement560",560);
                                        if((p$ch==(((CHECKER1)(CUR$.SL$.SL$)).IIN))) {
                                            new ERRMSG$note1id(((CHECKER1)(CUR$.SL$.SL$)),394,((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb);
                                        }
                                        TRACE_END_STM$("CompoundStatement560",560);
                                    }
                                } else
                                // JavaLine 74 ==> SourceLine 562
                                if(new BUILDER1$precheck0$subclass(((CHECKER1$semchecker1)(CUR$.SL$)),qual,p1$right.qual).RESULT$) {
                                } else
                                // JavaLine 77 ==> SourceLine 563
                                new ERRMSG$note1id(((CHECKER1)(CUR$.SL$.SL$)),(((p$ch==(((CHECKER1)(CUR$.SL$.SL$)).IIN)))?(392):(393)),((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb);
                                TRACE_END_STM$("CompoundStatement559",563);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement557",563);
                    }
                }
                // JavaLine 85 ==> SourceLine 565
                type=((CHECKER1)(CUR$.SL$.SL$)).IBOOL;
                // JavaLine 87 ==> SourceLine 550
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("classcomparator",550);
                }
                TRACE_END_STM$("classcomparator",550);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$classcomparator STM$() { return((CHECKER1$semchecker1$classcomparator)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$classcomparator START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class classcomparator",1,534,11,556,24,550,28,551,31,552,33,553,35,554,42,555,48,556,53,557,57,558,61,559,65,560,74,562,77,563,85,565,87,550,98,566);
}
