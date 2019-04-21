package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Apr 21 13:18:13 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst86$simtst86$PBLK19$checkEvent extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$n;
    public int p$val;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst86$simtst86$PBLK19$checkEvent setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$n=intValue(param); break;
                case 1: p$val=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst86$simtst86$PBLK19$checkEvent(RTObject$ SL$)
    { super(SL$); }
    public simtst86$simtst86$PBLK19$checkEvent(RTObject$ SL$,int sp$n,int sp$val) {
        super(SL$);
        this.p$n = sp$n;
        this.p$val = sp$val;
        BBLK();
        STM$();
    }
    public simtst86$simtst86$PBLK19$checkEvent STM$() {
        if(VALUE$((((simtst86$PBLK19)(CUR$.SL$)).eventValue==(p$val)))) {
        } else
        {
            sysout().outtext(new TXT$("*** error in test "));
            sysout().outint(p$n,0);
            sysout().outtext(new TXT$(": Simple Test of Separately Compiled Class."));
            sysout().outimage();
            sysout().outtext(new TXT$("            Erroneus values: val = "));
            sysout().outint(((simtst86$PBLK19)(CUR$.SL$)).eventValue,0);
            sysout().outimage();
            sysout().outtext(new TXT$("            --------- Facit: val = "));
            sysout().outint(p$val,0);
            sysout().outimage();
            ((simtst86)(CUR$.SL$.SL$)).found_error=true;
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst86.sim","Procedure checkEvent",31,20,34,23,40,24,44,25,48,26,53,28);
}
