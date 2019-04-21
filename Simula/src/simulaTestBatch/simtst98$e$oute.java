package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Apr 13 09:06:30 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst98$e$oute extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$l;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst98$e$oute setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$l=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst98$e$oute(RTObject$ SL$)
    { super(SL$); }
    public simtst98$e$oute(RTObject$ SL$,int sp$l) {
        super(SL$);
        this.p$l = sp$l;
        BBLK();
        STM$();
    }
    public simtst98$e$oute STM$() {
        new simtst98$outattr(((simtst98)(CUR$.SL$.SL$)),p$l,new TXT$("in e:  i="),((simtst98$e)(CUR$.SL$)).i$1,((simtst98$e)(CUR$.SL$)).di$1);
        new simtst98$outim(((simtst98)(CUR$.SL$.SL$)));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst98.sim","Procedure oute",1,195,29,196,34,196);
}
