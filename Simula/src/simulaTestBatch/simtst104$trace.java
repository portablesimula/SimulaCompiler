package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Tue Apr 30 10:26:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst104$trace extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$msg;
    public float p$r;
    public float p$facit;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst104$trace setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                case 1: p$r=floatValue(param); break;
                case 2: p$facit=floatValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst104$trace(RTObject$ SL$)
    { super(SL$); }
    public simtst104$trace(RTObject$ SL$,TXT$ sp$msg,float sp$r,float sp$facit) {
        super(SL$);
        this.p$msg = sp$msg;
        this.p$r = sp$r;
        this.p$facit = sp$facit;
        BBLK();
        STM$();
    }
    public simtst104$trace STM$() {
        if(VALUE$((((simtst104)(CUR$.SL$)).verbose|((p$r!=(p$facit)))))) {
            {
                if(VALUE$((p$r!=(p$facit)))) {
                    {
                        ((simtst104)(CUR$.SL$)).found_error=true;
                        sysout().outtext(new TXT$("ERROR: "));
                    }
                } else
                sysout().outtext(new TXT$("TRACE: "));
                sysout().outtext(CONC(p$msg,new TXT$(", Result=")));
                sysout().outreal(p$r,2,10);
                sysout().outtext(new TXT$("  Facit="));
                sysout().outreal(p$facit,2,10);
                sysout().outimage();
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst104.sim","Procedure trace",1,14,35,16,37,18,40,19,43,20,47,21,49,22,52,23,60,25);
}
