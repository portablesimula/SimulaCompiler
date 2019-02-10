// JavaLine 1 ==> SourceLine 2465
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$parameter$CompoundStatement2340$CompoundStatement2419$CompoundStatement2440$SubBlock2465 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=4, firstLine=2465, lastLine=2488, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    COMMON$quantity actqty=null;
    COMMON$quantity cquant=null;
    // Normal Constructor
    public CHECKER1$semchecker1$parameter$CompoundStatement2340$CompoundStatement2419$CompoundStatement2440$SubBlock2465(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock2465",2465);
    } // End of Constructor
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock2465",2465);
        // JavaLine 22 ==> SourceLine 2466
        actqty=((CHECKER1$semchecker1$parameter)(CUR$.SL$)).p$actual.qual;
        cquant=((CHECKER1$semchecker1$parameter)(CUR$.SL$)).p1$formal.prefqual;
        // JavaLine 25 ==> SourceLine 2467
        if(VALUE$((actqty!=(cquant)))) {
            // JavaLine 27 ==> SourceLine 2468
            {
                TRACE_BEGIN_STM$("CompoundStatement2468",2468);
                if(VALUE$((actqty!=(null)))) {
                    // JavaLine 31 ==> SourceLine 2469
                    {
                        TRACE_BEGIN_STM$("CompoundStatement2469",2469);
                        if(VALUE$((cquant!=(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).textclass)))) {
                            // JavaLine 35 ==> SourceLine 2471
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2471",2471);
                                if(VALUE$(new BUILDER1$precheck0$subclass(((CHECKER1$semchecker1)(CUR$.SL$.SL$)),cquant,actqty).RESULT$)) {
                                    // JavaLine 39 ==> SourceLine 2472
                                    ((CHECKER1$semchecker1$parameter)(CUR$.SL$)).implqua=(((CHECKER1)(CUR$.SL$.SL$.SL$)).QuaCheck&((((CHECKER1$semchecker1)(CUR$.SL$.SL$)).ftype==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IREF))));
                                } else
                                // JavaLine 42 ==> SourceLine 2473
                                if(VALUE$(new BUILDER1$precheck0$subclass(((CHECKER1$semchecker1)(CUR$.SL$.SL$)),actqty,cquant).RESULT$)) {
                                    // JavaLine 44 ==> SourceLine 2474
                                    ((CHECKER1$semchecker1$parameter)(CUR$.SL$)).implqua=false;
                                } else
                                // JavaLine 47 ==> SourceLine 2476
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement2476",2476);
                                    if(VALUE$(((((CHECKER1$semchecker1)(CUR$.SL$.SL$)).ftype==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IPTR))||((((((((CHECKER1)(CUR$.SL$.SL$.SL$)).SportOK&&(IS$(actqty,COMMON$extquantity.class)))&&(IS$(cquant,COMMON$extquantity.class)))&&((actqty.symb==(cquant.symb))))&&((((COMMON$extbrecord)(actqty.descr)).checklo==(((COMMON$extbrecord)(cquant.descr)).checklo))))&&((((COMMON$extbrecord)(actqty.descr)).checkhi==(((COMMON$extbrecord)(cquant.descr)).checkhi)))))))) {
                                        // JavaLine 51 ==> SourceLine 2485
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement2485",2485);
                                            new CHECKER1$semchecker1$argument$errARG(((CHECKER1$semchecker1$parameter)(CUR$.SL$)),-427);
                                            ((CHECKER1$semchecker1$parameter)(CUR$.SL$)).implqua=false;
                                            TRACE_END_STM$("CompoundStatement2485",2485);
                                        }
                                    } else
                                    // JavaLine 59 ==> SourceLine 2486
                                    new CHECKER1$semchecker1$argument$errARG(((CHECKER1$semchecker1$parameter)(CUR$.SL$)),427);
                                    TRACE_END_STM$("CompoundStatement2476",2486);
                                }
                                TRACE_END_STM$("CompoundStatement2471",2486);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement2469",2486);
                    }
                }
                TRACE_END_STM$("CompoundStatement2468",2486);
            }
        }
        TRACE_END_STM$("SubBlock2465",2486);
        EBLK();
        return(null);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","SubBlock SubBlock2465",1,2465,22,2466,25,2467,27,2468,31,2469,35,2471,39,2472,42,2473,44,2474,47,2476,51,2485,59,2486,75,2488);
}
