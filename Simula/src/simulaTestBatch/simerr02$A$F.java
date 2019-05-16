package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 17:00:11 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr02$A$F extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public float RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public float p$x;
    private int $npar=0; // Number of actual parameters transmitted.
    public simerr02$A$F setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$x=floatValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simerr02$A$F(RTObject$ SL$)
    { super(SL$); }
    public simerr02$A$F(RTObject$ SL$,float sp$x) {
        super(SL$);
        this.p$x = sp$x;
        BBLK();
        STM$();
    }
    public simerr02$A$F STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr02.sim","Procedure F",1,51,33,51);
}
