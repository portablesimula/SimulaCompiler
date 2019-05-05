package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat May 04 12:34:15 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst105$FIELD extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$w;
    int pos=0;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst105$FIELD setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$w=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst105$FIELD(RTObject$ SL$)
    { super(SL$); }
    public simtst105$FIELD(RTObject$ SL$,int sp$w) {
        super(SL$);
        this.p$w = sp$w;
        BBLK();
        STM$();
    }
    public simtst105$FIELD STM$() {
        pos=TXT$.pos(((simtst105)(CUR$.SL$)).result);
        RESULT$=TXT$.sub(((simtst105)(CUR$.SL$)).result,pos,p$w);
        TXT$.setpos(((simtst105)(CUR$.SL$)).result,(pos+(p$w)));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst105.sim","Procedure FIELD",1,23,11,24,34,25,36,26,40,27);
}
