// JavaLine 1 ==> SourceLine 581
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:26 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$precheck0$protect extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=581, lastLine=601, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$quantity p$q;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 586
    final LABQNT$ REP=new LABQNT$(this,0,1); // Local Label #1=REP
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 584
    COMMON$quantity qz=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$precheck0$protect setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$precheck0$protect.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$q=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER1$precheck0$protect(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$precheck0$protect(RTObject$ SL$,COMMON$quantity sp$q) {
        super(SL$);
        // Parameter assignment to locals
        this.p$q = sp$q;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("protect",584);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$precheck0$protect STM$() {
        TRACE_BEGIN_STM$("protect",584);
        BUILDER1$precheck0$protect THIS$=(BUILDER1$precheck0$protect)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 50 ==> SourceLine 586
                LABEL$(1); // REP
                qz=p$q.descr.fpar;
                // JavaLine 53 ==> SourceLine 587
                while((qz!=(null))) {
                    // JavaLine 55 ==> SourceLine 588
                    {
                        TRACE_BEGIN_STM$("CompoundStatement588",588);
                        if((qz.protect==(((char)1)))) {
                            qz.visible=((char)1);
                        }
                        // JavaLine 61 ==> SourceLine 589
                        qz=((COMMON$quantity)(qz.next));
                        TRACE_END_STM$("CompoundStatement588",589);
                    }
                }
                // JavaLine 66 ==> SourceLine 591
                qz=p$q.descr.favirt;
                // JavaLine 68 ==> SourceLine 592
                while((qz!=(null))) {
                    // JavaLine 70 ==> SourceLine 593
                    {
                        TRACE_BEGIN_STM$("CompoundStatement593",593);
                        if((qz.protect==(((char)1)))) {
                            {
                                TRACE_BEGIN_STM$("CompoundStatement593",593);
                                qz.visible=((char)1);
                                // JavaLine 77 ==> SourceLine 594
                                if((qz.match!=(null))) {
                                    qz.match.visible=((char)1);
                                }
                                TRACE_END_STM$("CompoundStatement593",594);
                            }
                        }
                        // JavaLine 84 ==> SourceLine 596
                        qz=((COMMON$quantity)(qz.next));
                        TRACE_END_STM$("CompoundStatement593",596);
                    }
                }
                // JavaLine 89 ==> SourceLine 599
                if((p$q.plev>(((BUILDER1)(CUR$.SL$.SL$)).one))) {
                    {
                        TRACE_BEGIN_STM$("CompoundStatement599",599);
                        p$q=p$q.prefqual;
                        GOTO$(REP); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement599",599);
                    }
                }
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$ || q.prefixLevel!=0) {
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("protect",599);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure protect",1,581,12,586,15,584,50,586,53,587,55,588,61,589,66,591,68,592,70,593,77,594,84,596,89,599,114,601);
}
