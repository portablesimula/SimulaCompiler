package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Apr 13 09:06:30 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst98$b$outb extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$l;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst98$b$outb setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$l=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst98$b$outb(RTObject$ SL$)
    { super(SL$); }
    public simtst98$b$outb(RTObject$ SL$,int sp$l) {
        super(SL$);
        this.p$l = sp$l;
        BBLK();
        STM$();
    }
    public simtst98$b$outb STM$() {
        new simtst98$outattr(((simtst98)(CUR$.SL$.SL$)),p$l,new TXT$("in b:  i="),((simtst98$b)(CUR$.SL$)).i,((simtst98$b)(CUR$.SL$)).bi$1);
        new simtst98$outattr(((simtst98)(CUR$.SL$.SL$)),p$l,new TXT$("       j="),((simtst98$b)(CUR$.SL$)).j,((simtst98$b)(CUR$.SL$)).bj$1);
        new simtst98$outattr(((simtst98)(CUR$.SL$.SL$)),p$l,new TXT$("       k="),((simtst98$b)(CUR$.SL$)).k$1,((simtst98$b)(CUR$.SL$)).bk$1);
        new simtst98$outim(((simtst98)(CUR$.SL$.SL$)));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst98.sim","Procedure outb",1,132,29,133,31,134,33,135,38,136);
}
