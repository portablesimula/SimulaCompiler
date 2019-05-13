package simprog;
// Simula-Beta-0.3 Compiled at Fri May 10 11:44:24 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Is_same extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public Dates$Date p$Dx;
    private int $npar=0; // Number of actual parameters transmitted.
    public Dates$Date$Is_same setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$Dx=(Dates$Date)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public Dates$Date$Is_same(RTObject$ SL$)
    { super(SL$); }
    public Dates$Date$Is_same(RTObject$ SL$,Dates$Date sp$Dx) {
        super(SL$);
        this.p$Dx = sp$Dx;
        BBLK();
        STM$();
    }
    public Dates$Date$Is_same STM$() {
        RESULT$=(((((Dates$Date)(CUR$.SL$)).p$D==(p$Dx.p$D))&((((Dates$Date)(CUR$.SL$)).p$M==(p$Dx.p$M))))&((((Dates$Date)(CUR$.SL$)).p$Y==(p$Dx.p$Y))));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure Is_same",1,142,31,145,35,146);
}
