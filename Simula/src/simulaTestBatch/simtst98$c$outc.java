package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Apr 13 09:06:30 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst98$c$outc extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$l;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst98$c$outc setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$l=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst98$c$outc(RTObject$ SL$)
    { super(SL$); }
    public simtst98$c$outc(RTObject$ SL$,int sp$l) {
        super(SL$);
        this.p$l = sp$l;
        BBLK();
        STM$();
    }
    public simtst98$c$outc STM$() {
        new simtst98$outattr(((simtst98)(CUR$.SL$.SL$)),p$l,new TXT$("in c:  i="),((simtst98)(CUR$.SL$.SL$)).i,((simtst98$c)(CUR$.SL$)).ci$2);
        new simtst98$outattr(((simtst98)(CUR$.SL$.SL$)),p$l,new TXT$("       j="),((simtst98$c)(CUR$.SL$)).j,((simtst98$c)(CUR$.SL$)).cj$2);
        new simtst98$outattr(((simtst98)(CUR$.SL$.SL$)),p$l,new TXT$("       k="),((simtst98)(CUR$.SL$.SL$)).k,((simtst98$c)(CUR$.SL$)).ck$2);
        new simtst98$outim(((simtst98)(CUR$.SL$.SL$)));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst98.sim","Procedure outc",1,167,29,168,31,169,33,170,38,171);
}
