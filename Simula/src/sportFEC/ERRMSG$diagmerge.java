package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:37 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$diagmerge extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$n;
    final LABQNT$ CONCAT=new LABQNT$(this,1,"CONCAT");
    final LABQNT$ EX=new LABQNT$(this,2,"EX");
    TXT$ result=null;
    TXT$ t=null;
    TXT$ t2=null;
    int i=0;
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$diagmerge setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$n=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public ERRMSG$diagmerge(RTObject$ SL$)
    { super(SL$); }
    public ERRMSG$diagmerge(RTObject$ SL$,int sp$n) {
        super(SL$);
        this.p$n = sp$n;
        BBLK();
        STM$();
    }
    public ERRMSG$diagmerge STM$() {
        ERRMSG$diagmerge THIS$=(ERRMSG$diagmerge)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                RESULT$=t=new ERRMSG$errmsg(((ERRMSG)(CUR$.SL$)),p$n).RESULT$;
                if(VALUE$(TRF_NE(((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]],null))) {
                    {
                        while(TRF_NE(((ERRMSG)(CUR$.SL$)).diag.Elt[i-((ERRMSG)(CUR$.SL$)).diag.LB[0]],null)) {
                            {
                                if(VALUE$(((loadChar(((ERRMSG)(CUR$.SL$)).diag.Elt[i-((ERRMSG)(CUR$.SL$)).diag.LB[0]],0)==('_'))&&((loadChar(((ERRMSG)(CUR$.SL$)).diag.Elt[i-((ERRMSG)(CUR$.SL$)).diag.LB[0]],1)==('_')))))) {
                                    {
                                        if(VALUE$((p$n==(337)))) {
                                            {
                                                RESULT$=new ERRMSG$errmsg(((ERRMSG)(CUR$.SL$)),168).RESULT$;
                                                GOTO$(EX);
                                            }
                                        }
                                        if(VALUE$((p$n==(427)))) {
                                            {
                                                RESULT$=new ERRMSG$errmsg(((ERRMSG)(CUR$.SL$)),358).RESULT$;
                                                GOTO$(EX);
                                            }
                                        }
                                        if(VALUE$((p$n==(426)))) {
                                            {
                                                RESULT$=new ERRMSG$errmsg(((ERRMSG)(CUR$.SL$)),234).RESULT$;
                                                GOTO$(EX);
                                            }
                                        }
                                        ((ERRMSG)(CUR$.SL$)).diag.Elt[i-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=new TXT$("ACTIVATE");
                                    }
                                }
                                while(TXT$.more(t)) {
                                    if(VALUE$((TXT$.getchar(t)==('?')))) {
                                        {
                                            t2=TXT$.sub(t,1,(TXT$.pos(t)-(2)));
                                            t=TXT$.sub(t,TXT$.pos(t),((TXT$.length(t)-(TXT$.pos(t)))+(1)));
                                            GOTO$(CONCAT);
                                        }
                                    }
                                }
                                t2=t;
                                t=null;
                                LABEL$(1,"CONCAT");
                                result=CONC(CONC(result,t2),((ERRMSG)(CUR$.SL$)).diag.Elt[i-((ERRMSG)(CUR$.SL$)).diag.LB[0]]);
                                ((ERRMSG)(CUR$.SL$)).diag.Elt[i-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=null;
                                i=(i+(1));
                            }
                        }
                        RESULT$=CONC(result,t);
                    }
                }
                LABEL$(2,"EX");
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    CUR$.STATE$=OperationalState.terminated;
                    throw(q);
                }
                JTX$=q.index; continue LOOP$;
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure diagmerge",1,91,11,115,13,120,15,92,44,93,46,94,48,95,51,96,54,99,57,100,63,101,65,102,71,103,73,104,79,105,83,107,85,108,87,109,90,110,92,111,97,113,100,115,103,116,108,118,112,120,127,120);
}
