package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 11:14:52 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue20$P extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$i;
    public LABQNT$ p$l;
    public PRCQNT$ p$q;
    private int $npar=0; // Number of actual parameters transmitted.
    public issue20$P setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$i=intValue(param); break;
                case 1: p$l=(LABQNT$)objectValue(param); break;
                case 2: p$q=procValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public issue20$P(RTObject$ SL$)
    { super(SL$); }
    public issue20$P(RTObject$ SL$,int sp$i,LABQNT$ sp$l,PRCQNT$ sp$q) {
        super(SL$);
        this.p$i = sp$i;
        this.p$l = sp$l;
        this.p$q = sp$q;
        BBLK();
        STM$();
    }
    public issue20$P STM$() {
        p$q.CPF();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("issue20.sim","Procedure P",1,5,35,6,39,6);
}
