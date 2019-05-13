package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:37 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$parserMessage extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$errpos;
    public int p$n1;
    public int p$n2;
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$parserMessage setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$errpos=intValue(param); break;
                case 1: p$n1=intValue(param); break;
                case 2: p$n2=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public ERRMSG$parserMessage(RTObject$ SL$)
    { super(SL$); }
    public ERRMSG$parserMessage(RTObject$ SL$,int sp$errpos,int sp$n1,int sp$n2) {
        super(SL$);
        this.p$errpos = sp$errpos;
        this.p$n1 = sp$n1;
        this.p$n2 = sp$n2;
        BBLK();
        STM$();
    }
    public ERRMSG$parserMessage STM$() {
        if(VALUE$((p$n2!=(0)))) {
            {
                ((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=new ERRMSG$errmsg(((ERRMSG)(CUR$.SL$)),p$n2).RESULT$;
                ((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=CONC(new TXT$(" - "),((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]]);
            }
        }
        new ERRMSG$outP1message(((ERRMSG)(CUR$.SL$)),p$errpos,p$n1,((char)2));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure parserMessage",1,208,35,209,37,210,43,211,47,211);
}
