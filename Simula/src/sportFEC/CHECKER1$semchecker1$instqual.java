// JavaLine 1 ==> SourceLine 568
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$instqual extends CHECKER1$semchecker1$operation {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=2, firstLine=568, lastLine=611, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 601
    final LABQNT$ QERR=new LABQNT$(this,2,1); // Local Label #1=QERR
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 572
    public COMMON$quantity L3opq=null;
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$instqual$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$instqual(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch,CHECKER1$semchecker1$exp sp1$left,CHECKER1$semchecker1$exp sp1$right) {
        super(staticLink,sp$pred,sp$ch,sp1$left,sp1$right);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("instqual",581);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("instqual",581,inner);
                CHECKER1$semchecker1$instqual THIS$=(CHECKER1$semchecker1$instqual)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 31 ==> SourceLine 586
                        if((p1$right.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN))) {
                            new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p1$right)));
                        }
                        // JavaLine 35 ==> SourceLine 587
                        cl=((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl;
                        type=p1$right.type;
                        // JavaLine 38 ==> SourceLine 588
                        if((type!=(((CHECKER1)(CUR$.SL$.SL$)).IREF))) {
                            // JavaLine 40 ==> SourceLine 589
                            {
                                TRACE_BEGIN_STM$("CompoundStatement589",589);
                                if(((type!=(((CHECKER1)(CUR$.SL$.SL$)).IELSE))&((type!=(((CHECKER1)(CUR$.SL$.SL$)).IPTR))))) {
                                    // JavaLine 44 ==> SourceLine 590
                                    new ERRMSG$error1id(((CHECKER1)(CUR$.SL$.SL$)),313,((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb);
                                }
                                TRACE_END_STM$("CompoundStatement589",590);
                            }
                        }
                        // JavaLine 50 ==> SourceLine 591
                        qual=new CHECKER1$semchecker1$qualification(((CHECKER1$semchecker1)(CUR$.SL$))).RESULT$;
                        // JavaLine 52 ==> SourceLine 592
                        if((p1$right.qual!=(null))) {
                            // JavaLine 54 ==> SourceLine 593
                            {
                                TRACE_BEGIN_STM$("CompoundStatement593",593);
                                if((qual.kind==(((CHECKER1)(CUR$.SL$.SL$)).K_class))) {
                                    // JavaLine 58 ==> SourceLine 594
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement594",594);
                                        if((p1$right.qual==(qual))) {
                                            // JavaLine 62 ==> SourceLine 595
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement595",595);
                                                if(((CHECKER1)(CUR$.SL$.SL$)).GiveNotes) {
                                                    new ERRMSG$note1id(((CHECKER1)(CUR$.SL$.SL$)),395,((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb);
                                                }
                                                TRACE_END_STM$("CompoundStatement595",595);
                                            }
                                        } else
                                        // JavaLine 71 ==> SourceLine 597
                                        if(new BUILDER1$precheck0$subclass(((CHECKER1$semchecker1)(CUR$.SL$)),p1$right.qual,qual).RESULT$) {
                                        } else
                                        // JavaLine 74 ==> SourceLine 598
                                        if(new BUILDER1$precheck0$subclass(((CHECKER1$semchecker1)(CUR$.SL$)),qual,p1$right.qual).RESULT$) {
                                            // JavaLine 76 ==> SourceLine 599
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement599",599);
                                                if((((CHECKER1)(CUR$.SL$.SL$)).NoneCheck||(((CHECKER1)(CUR$.SL$.SL$)).QuaCheck))) {
                                                    L3opq=qual;
                                                }
                                                TRACE_END_STM$("CompoundStatement599",599);
                                            }
                                        } else
                                        // JavaLine 85 ==> SourceLine 601
                                        LABEL$(1); // QERR
                                        new ERRMSG$error2quants(((CHECKER1)(CUR$.SL$.SL$)),402,qual,p1$right.qual);
                                        TRACE_END_STM$("CompoundStatement594",601);
                                    }
                                } else
                                // JavaLine 91 ==> SourceLine 603
                                if((qual.kind==(((CHECKER1)(CUR$.SL$.SL$)).K_record))) {
                                    // JavaLine 93 ==> SourceLine 604
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement604",604);
                                        if((p1$right.qual.kind==(((CHECKER1)(CUR$.SL$.SL$)).K_record))) {
                                            // JavaLine 97 ==> SourceLine 605
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement605",605);
                                                if((!(new BUILDER1$precheck0$subclass(((CHECKER1$semchecker1)(CUR$.SL$)),p1$right.qual,qual).RESULT$))) {
                                                    // JavaLine 101 ==> SourceLine 606
                                                    new ERRMSG$error1id(((CHECKER1)(CUR$.SL$.SL$)),-241,((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb);
                                                }
                                                TRACE_END_STM$("CompoundStatement605",606);
                                            }
                                        } else
                                        // JavaLine 107 ==> SourceLine 607
                                        GOTO$(QERR); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement604",607);
                                    }
                                } else
                                // JavaLine 112 ==> SourceLine 609
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement609",609);
                                    qual=p1$right.qual;
                                    new ERRMSG$error1id(((CHECKER1)(CUR$.SL$.SL$)),335,((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb);
                                    TRACE_END_STM$("CompoundStatement609",609);
                                }
                                TRACE_END_STM$("CompoundStatement593",609);
                            }
                        }
                        // JavaLine 122 ==> SourceLine 586
                        if(inner!=null) {
                            inner.STM$();
                            TRACE_BEGIN_STM_AFTER_INNER$("instqual",586);
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
                TRACE_END_STM$("instqual",586);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$instqual STM$() { return((CHECKER1$semchecker1$instqual)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$instqual START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class instqual",1,568,11,601,14,572,31,586,35,587,38,588,40,589,44,590,50,591,52,592,54,593,58,594,62,595,71,597,74,598,76,599,85,601,91,603,93,604,97,605,101,606,107,607,112,609,122,586,146,611);
}
