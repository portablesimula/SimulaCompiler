package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri Apr 26 11:57:49 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HexDump$Cat extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public TXT$ p$t1;
    public TXT$ p$t2;
    TXT$ t=null;
    private int $npar=0; // Number of actual parameters transmitted.
    public HexDump$Cat setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$t1=(TXT$)objectValue(param); break;
                case 1: p$t2=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HexDump$Cat(RTObject$ SL$)
    { super(SL$); }
    public HexDump$Cat(RTObject$ SL$,TXT$ sp$t1,TXT$ sp$t2) {
        super(SL$);
        this.p$t1 = sp$t1;
        this.p$t2 = sp$t2;
        BBLK();
        STM$();
    }
    public HexDump$Cat STM$() {
        RESULT$=t=blanks((TXT$.length(p$t1)+(TXT$.length(p$t2))));
        ASGTXT$(t,p$t1);
        ASGTXT$(TXT$.sub(t,(TXT$.length(p$t1)+(1)),TXT$.length(p$t2)),p$t2);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HexDump.sim","Procedure Cat",1,29,12,30,37,31,42,32);
}
