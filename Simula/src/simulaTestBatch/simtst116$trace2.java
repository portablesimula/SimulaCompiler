package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 12:34:49 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst116$trace2 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$msg;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst116$trace2 setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst116$trace2(RTObject$ SL$)
    { super(SL$); }
    public simtst116$trace2(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public simtst116$trace2 STM$() {
        sysout().outtext(p$msg);
        sysout().outimage();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst116.sim","Procedure trace2",1,28,29,30,34,31);
}
