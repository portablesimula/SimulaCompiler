package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed May 08 17:45:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Diff extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public Dates$Date p$Dx;
    private int $npar=0; // Number of actual parameters transmitted.
    public Dates$Date$Diff setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$Dx=(Dates$Date)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public Dates$Date$Diff(RTObject$ SL$)
    { super(SL$); }
    public Dates$Date$Diff(RTObject$ SL$,Dates$Date sp$Dx) {
        super(SL$);
        this.p$Dx = sp$Dx;
        BBLK();
        STM$();
    }
    public Dates$Date$Diff STM$() {
        RESULT$=(new Dates$Date$N_days(p$Dx).RESULT$-(new Dates$Date$N_days(((Dates$Date)(CUR$.SL$))).RESULT$));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure Diff",1,64,31,67,35,68);
}
