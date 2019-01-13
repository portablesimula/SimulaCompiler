// JavaLine 1 ==> SourceLine 494
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:35 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$normalattrfile$puttext extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=494, lastLine=511, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$t;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 511
    final LABQNT$ EX=new LABQNT$(this,0,1); // Local Label #1=EX
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 495
    int tlength=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER2$normalattrfile$puttext setPar(Object param) {
        //Util.BREAK("CALL BUILDER2$normalattrfile$puttext.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$t=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER2$normalattrfile$puttext(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER2$normalattrfile$puttext(RTObject$ SL$,TXT$ sp$t) {
        super(SL$);
        // Parameter assignment to locals
        this.p$t = sp$t;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("puttext",495);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER2$normalattrfile$puttext STM$() {
        TRACE_BEGIN_STM$("puttext",495);
        BUILDER2$normalattrfile$puttext THIS$=(BUILDER2$normalattrfile$puttext)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 50 ==> SourceLine 496
                tlength=TXT$.length(p$t);
                // JavaLine 52 ==> SourceLine 497
                if((tlength==(0))) {
                    // JavaLine 54 ==> SourceLine 498
                    new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),((BUILDER2)(CUR$.SL$.SL$)).NUL);
                } else
                // JavaLine 57 ==> SourceLine 499
                {
                    TRACE_BEGIN_STM$("CompoundStatement499",499);
                    if(((((BUILDER2$normalattrfile)(CUR$.SL$)).p+(tlength))>(((BUILDER2$normalattrfile)(CUR$.SL$)).bufmax))) {
                        // JavaLine 61 ==> SourceLine 500
                        {
                            TRACE_BEGIN_STM$("CompoundStatement500",500);
                            if((tlength>(((BUILDER2$normalattrfile)(CUR$.SL$)).bufmax))) {
                                // JavaLine 65 ==> SourceLine 501
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement501",501);
                                    new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),((BUILDER2$normalattrfile)(CUR$.SL$)).longSwap);
                                    new BUILDER2$normalattrfile$putNumber(((BUILDER2$normalattrfile)(CUR$.SL$)),tlength);
                                    // JavaLine 70 ==> SourceLine 502
                                    new BUILDER2$normalattrfile$swapObuffer(((BUILDER2$normalattrfile)(CUR$.SL$)));
                                    ((BUILDER2$normalattrfile)(CUR$.SL$)).AOF.outtext(p$t);
                                    GOTO$(EX); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement501",502);
                                }
                            }
                            // JavaLine 77 ==> SourceLine 503
                            new BUILDER2$normalattrfile$swapObuffer(((BUILDER2$normalattrfile)(CUR$.SL$)));
                            TRACE_END_STM$("CompoundStatement500",503);
                        }
                    }
                    // JavaLine 82 ==> SourceLine 505
                    if((tlength>=(rank(((BUILDER2$normalattrfile)(CUR$.SL$)).lowKey)))) {
                        // JavaLine 84 ==> SourceLine 506
                        {
                            TRACE_BEGIN_STM$("CompoundStatement506",506);
                            new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),((BUILDER2$normalattrfile)(CUR$.SL$)).longText);
                            // JavaLine 88 ==> SourceLine 507
                            new BUILDER2$normalattrfile$putNumber(((BUILDER2$normalattrfile)(CUR$.SL$)),tlength);
                            TRACE_END_STM$("CompoundStatement506",507);
                        }
                    } else
                    new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),char$(tlength));
                    // JavaLine 94 ==> SourceLine 508
                    ASGTXT$(TXT$.sub(((BUILDER2$normalattrfile)(CUR$.SL$)).attrbuffer,(((BUILDER2$normalattrfile)(CUR$.SL$)).p+(1)),tlength),p$t);
                    ((BUILDER2$normalattrfile)(CUR$.SL$)).p=(((BUILDER2$normalattrfile)(CUR$.SL$)).p+(tlength));
                    TRACE_END_STM$("CompoundStatement499",508);
                }
                // JavaLine 99 ==> SourceLine 511
                LABEL$(1); // EX
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
        TRACE_END_STM$("puttext",511);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Procedure puttext",1,494,12,511,15,495,50,496,52,497,54,498,57,499,61,500,65,501,70,502,77,503,82,505,84,506,88,507,94,508,99,511,117,511);
}
