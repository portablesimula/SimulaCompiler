package simprog;
// Simula-Beta-0.3 Compiled at Fri May 10 11:44:24 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Plus extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public Dates$Date RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$Nx;
    private int $npar=0; // Number of actual parameters transmitted.
    public Dates$Date$Plus setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$Nx=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public Dates$Date$Plus(RTObject$ SL$)
    { super(SL$); }
    public Dates$Date$Plus(RTObject$ SL$,int sp$Nx) {
        super(SL$);
        this.p$Nx = sp$Nx;
        BBLK();
        STM$();
    }
    public Dates$Date$Plus STM$() {
        RESULT$=new Dates$Date(((Dates)(CUR$.SL$.SL$)),(((Dates$Date)(CUR$.SL$)).p$D+(p$Nx)),((Dates$Date)(CUR$.SL$)).p$M,((Dates$Date)(CUR$.SL$)).p$Y).STM$();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure Plus",1,38,31,41,35,42);
}
