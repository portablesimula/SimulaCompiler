package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:34:06 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Minus extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public Dates$Date RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$Nx;
    private int $npar=0; // Number of actual parameters transmitted.
    public Dates$Date$Minus setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$Nx=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public Dates$Date$Minus(RTObject$ SL$)
    { super(SL$); }
    public Dates$Date$Minus(RTObject$ SL$,int sp$Nx) {
        super(SL$);
        this.p$Nx = sp$Nx;
        BBLK();
        STM$();
    }
    public Dates$Date$Minus STM$() {
        RESULT$=new Dates$Date$Plus(((Dates$Date)(CUR$.SL$)),(-(p$Nx))).RESULT$;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure Minus",1,51,31,54,35,55);
}
