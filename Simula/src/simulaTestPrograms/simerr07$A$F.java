package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:17:09 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr07$A$F extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public float RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public float p$x;
    private int $npar=0; // Number of actual parameters transmitted.
    public simerr07$A$F setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$x=floatValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simerr07$A$F(RTObject$ SL$)
    { super(SL$); }
    public simerr07$A$F(RTObject$ SL$,float sp$x) {
        super(SL$);
        this.p$x = sp$x;
        BBLK();
        STM$();
    }
    public simerr07$A$F STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr07.sim","Procedure F",1,9,33,9);
}
