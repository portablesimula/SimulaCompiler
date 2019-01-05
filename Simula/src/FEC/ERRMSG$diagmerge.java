// JavaLine 1 ==> SourceLine 91
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:51 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$diagmerge extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=91, lastLine=120, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$n;
    // Declare local labels
    // JavaLine 15 ==> SourceLine 115
    final LABQNT$ CONCAT=new LABQNT$(this,0,1); // Local Label #1=CONCAT
    // JavaLine 17 ==> SourceLine 120
    final LABQNT$ EX=new LABQNT$(this,0,2); // Local Label #2=EX
    // Declare locals as attributes
    // JavaLine 20 ==> SourceLine 92
    TXT$ result=null;
    TXT$ t=null;
    TXT$ t2=null;
    int i=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$diagmerge setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$diagmerge.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$n=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public ERRMSG$diagmerge(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$diagmerge(RTObject$ SL$,int sp$n) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("diagmerge",92);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$diagmerge STM$() {
        TRACE_BEGIN_STM$("diagmerge",92);
        ERRMSG$diagmerge THIS$=(ERRMSG$diagmerge)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 58 ==> SourceLine 93
                RESULT$=t=new ERRMSG$errmsg(((ERRMSG)(CUR$.SL$)),p$n).RESULT$;
                // JavaLine 60 ==> SourceLine 94
                if(TRF_NE(((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]],null)) {
                    // JavaLine 62 ==> SourceLine 95
                    {
                        TRACE_BEGIN_STM$("CompoundStatement95",95);
                        while(TRF_NE(((ERRMSG)(CUR$.SL$)).diag.Elt[i-((ERRMSG)(CUR$.SL$)).diag.LB[0]],null)) {
                            // JavaLine 66 ==> SourceLine 96
                            {
                                TRACE_BEGIN_STM$("CompoundStatement96",96);
                                if(((loadChar(((ERRMSG)(CUR$.SL$)).diag.Elt[i-((ERRMSG)(CUR$.SL$)).diag.LB[0]],0)==('_'))&&((loadChar(((ERRMSG)(CUR$.SL$)).diag.Elt[i-((ERRMSG)(CUR$.SL$)).diag.LB[0]],1)==('_'))))) {
                                    // JavaLine 70 ==> SourceLine 99
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement99",99);
                                        if((p$n==(337))) {
                                            // JavaLine 74 ==> SourceLine 100
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement100",100);
                                                RESULT$=new ERRMSG$errmsg(((ERRMSG)(CUR$.SL$)),168).RESULT$;
                                                GOTO$(EX); // GOTO EVALUATED LABEL
                                                TRACE_END_STM$("CompoundStatement100",100);
                                            }
                                        }
                                        // JavaLine 82 ==> SourceLine 101
                                        if((p$n==(427))) {
                                            // JavaLine 84 ==> SourceLine 102
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement102",102);
                                                RESULT$=new ERRMSG$errmsg(((ERRMSG)(CUR$.SL$)),358).RESULT$;
                                                GOTO$(EX); // GOTO EVALUATED LABEL
                                                TRACE_END_STM$("CompoundStatement102",102);
                                            }
                                        }
                                        // JavaLine 92 ==> SourceLine 103
                                        if((p$n==(426))) {
                                            // JavaLine 94 ==> SourceLine 104
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement104",104);
                                                RESULT$=new ERRMSG$errmsg(((ERRMSG)(CUR$.SL$)),234).RESULT$;
                                                GOTO$(EX); // GOTO EVALUATED LABEL
                                                TRACE_END_STM$("CompoundStatement104",104);
                                            }
                                        }
                                        // JavaLine 102 ==> SourceLine 105
                                        ((ERRMSG)(CUR$.SL$)).diag.Elt[i-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=new TXT$("ACTIVATE");
                                        TRACE_END_STM$("CompoundStatement99",105);
                                    }
                                }
                                // JavaLine 107 ==> SourceLine 107
                                while(TXT$.more(t)) {
                                    // JavaLine 109 ==> SourceLine 108
                                    if((TXT$.getchar(t)==('?'))) {
                                        // JavaLine 111 ==> SourceLine 109
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement109",109);
                                            t2=TXT$.sub(t,1,(TXT$.pos(t)-(2)));
                                            // JavaLine 115 ==> SourceLine 110
                                            t=TXT$.sub(t,TXT$.pos(t),((TXT$.length(t)-(TXT$.pos(t)))+(1)));
                                            // JavaLine 117 ==> SourceLine 111
                                            GOTO$(CONCAT); // GOTO EVALUATED LABEL
                                            TRACE_END_STM$("CompoundStatement109",111);
                                        }
                                    }
                                }
                                // JavaLine 123 ==> SourceLine 113
                                t2=t;
                                t=null;
                                // JavaLine 126 ==> SourceLine 115
                                LABEL$(1); // CONCAT
                                result=CONC(CONC(result,t2),((ERRMSG)(CUR$.SL$)).diag.Elt[i-((ERRMSG)(CUR$.SL$)).diag.LB[0]]);
                                // JavaLine 129 ==> SourceLine 116
                                ((ERRMSG)(CUR$.SL$)).diag.Elt[i-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=null;
                                i=(i+(1));
                                TRACE_END_STM$("CompoundStatement96",116);
                            }
                        }
                        // JavaLine 135 ==> SourceLine 118
                        RESULT$=CONC(result,t);
                        TRACE_END_STM$("CompoundStatement95",118);
                    }
                }
                // JavaLine 140 ==> SourceLine 120
                LABEL$(2); // EX
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
        TRACE_END_STM$("diagmerge",120);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure diagmerge",1,91,15,115,17,120,20,92,58,93,60,94,62,95,66,96,70,99,74,100,82,101,84,102,92,103,94,104,102,105,107,107,109,108,111,109,115,110,117,111,123,113,126,115,129,116,135,118,140,120,158,120);
}
