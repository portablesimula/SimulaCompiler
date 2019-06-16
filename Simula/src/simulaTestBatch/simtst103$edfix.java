package simulaTestBatch;
// Simula-1.0 Compiled at Sat Jun 15 12:44:15 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst103$edfix extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public float p$r;
    TXT$ t=null;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst103$edfix setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$r=floatValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst103$edfix(RTObject$ SL$)
    { super(SL$); }
    public simtst103$edfix(RTObject$ SL$,float sp$r) {
        super(SL$);
        this.p$r = sp$r;
        BBLK();
        STM$();
    }
    public simtst103$edfix STM$() {
        t=blanks(6);
        TXT$.putfix(t,p$r,2);
        RESULT$=t;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst103.sim","Procedure edfix",1,19,11,20,38,20);
}
