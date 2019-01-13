// JavaLine 1 ==> SourceLine 613
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$localobject extends CHECKER1$semchecker1$operation {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=2, firstLine=613, lastLine=654, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 654
    final LABQNT$ EXIT=new LABQNT$(this,2,1); // Local Label #1=EXIT
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 616
    public COMMON$quantity L3opq=null;
    // JavaLine 16 ==> SourceLine 635
    public COMMON$quantity inspect$634$90=null;
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$localobject$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$localobject(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch,CHECKER1$semchecker1$exp sp1$left,CHECKER1$semchecker1$exp sp1$right) {
        super(staticLink,sp$pred,sp$ch,sp1$left,sp1$right);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("localobject",635);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("localobject",635,inner);
                CHECKER1$semchecker1$localobject THIS$=(CHECKER1$semchecker1$localobject)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 33 ==> SourceLine 626
                        cl=((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl;
                        // JavaLine 35 ==> SourceLine 627
                        type=((CHECKER1)(CUR$.SL$.SL$)).IREF;
                        // JavaLine 37 ==> SourceLine 628
                        qual=new BUILDER1$meaningof(((CHECKER1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb).RESULT$;
                        // JavaLine 39 ==> SourceLine 629
                        if((qual==(null))) {
                            qual=new ERRMSG$newnotseen(((CHECKER1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb).RESULT$;
                        }
                        // JavaLine 43 ==> SourceLine 631
                        if((qual.kind!=(((CHECKER1)(CUR$.SL$.SL$)).K_class))) {
                            // JavaLine 45 ==> SourceLine 632
                            {
                                TRACE_BEGIN_STM$("CompoundStatement632",632);
                                new ERRMSG$error1qlin(((CHECKER1)(CUR$.SL$.SL$)),328,qual);
                                qual=null;
                                TRACE_END_STM$("CompoundStatement632",632);
                            }
                        } else
                        // JavaLine 53 ==> SourceLine 634
                        {
                            TRACE_BEGIN_STM$("CompoundStatement634",634);
                            {
                                // BEGIN INSPECTION 
                                inspect$634$90=new BUILDER1$precheck0$getClass(((CHECKER1$semchecker1)(CUR$.SL$)),qual,char$((rank(qual.encl.blev)+(1)))).RESULT$;
                                if(inspect$634$90!=null) //INSPECT inspect$634$90
                                // JavaLine 60 ==> SourceLine 637
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement637",637);
                                    if(((CHECKER1$semchecker1)(CUR$.SL$)).inarraybound) {
                                        // JavaLine 64 ==> SourceLine 638
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement638",638);
                                            if((inspect$634$90.descr.blev==(((CHECKER1)(CUR$.SL$.SL$)).cblev))) {
                                                // JavaLine 68 ==> SourceLine 639
                                                new ERRMSG$error1id(((CHECKER1)(CUR$.SL$.SL$)),314,((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb);
                                            }
                                            TRACE_END_STM$("CompoundStatement638",639);
                                        }
                                    }
                                    // JavaLine 74 ==> SourceLine 640
                                    L3opq=((CHECKER1)(CUR$.SL$.SL$)).display.Elt[rank(inspect$634$90.descr.blev)-((CHECKER1)(CUR$.SL$.SL$)).display.LB[0]].declquant;
                                    // JavaLine 76 ==> SourceLine 641
                                    while((L3opq.kind==(((CHECKER1)(CUR$.SL$.SL$)).K_labbl))) {
                                        L3opq=L3opq.prefqual;
                                    }
                                    // JavaLine 80 ==> SourceLine 644
                                    if((L3opq.kind==(((CHECKER1)(CUR$.SL$.SL$)).K_prefbl))) {
                                        // JavaLine 82 ==> SourceLine 645
                                        new ERRMSG$error1id(((CHECKER1)(CUR$.SL$.SL$)),315,((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb);
                                    } else
                                    if((L3opq.kind==(((CHECKER1)(CUR$.SL$.SL$)).K_class))) {
                                        L3opq.descr.thisused=true;
                                    }
                                    // JavaLine 88 ==> SourceLine 646
                                    L3opq=((COMMON$quantity)inspect$634$90);
                                    TRACE_END_STM$("CompoundStatement637",646);
                                }
                                else // OTHERWISE 
                                // JavaLine 93 ==> SourceLine 649
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement649",649);
                                    new ERRMSG$error1id(((CHECKER1)(CUR$.SL$.SL$)),311,((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb);
                                    L3opq=qual;
                                    TRACE_END_STM$("CompoundStatement649",649);
                                }
                            }
                            TRACE_END_STM$("CompoundStatement634",649);
                        }
                        // JavaLine 103 ==> SourceLine 654
                        LABEL$(1); // EXIT
                        // JavaLine 105 ==> SourceLine 626
                        if(inner!=null) {
                            inner.STM$();
                            TRACE_BEGIN_STM_AFTER_INNER$("localobject",626);
                        }
                        break LOOP$;
                    }
                    catch(LABQNT$ q) {
                        CUR$=THIS$;
                        if(q.SL$!=CUR$ || q.prefixLevel!=2) {
                            CUR$.STATE$=OperationalState.terminated;
                            if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                            throw(q);
                        }
                        if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                        JTX$=q.index; continue LOOP$; // EG. GOTO Lx
                    }
                }
                TRACE_END_STM$("localobject",626);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$localobject STM$() { return((CHECKER1$semchecker1$localobject)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$localobject START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class localobject",1,613,11,654,14,616,16,635,33,626,35,627,37,628,39,629,43,631,45,632,53,634,60,637,64,638,68,639,74,640,76,641,80,644,82,645,88,646,93,649,103,654,105,626,129,654);
}
