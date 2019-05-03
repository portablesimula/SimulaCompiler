package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:08:22 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$L_year extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$Yx;
    private int $npar=0; // Number of actual parameters transmitted.
    public Dates$L_year setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$Yx=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public Dates$L_year(RTObject$ SL$)
    { super(SL$); }
    public Dates$L_year(RTObject$ SL$,int sp$Yx) {
        super(SL$);
        this.p$Yx = sp$Yx;
        BBLK();
        STM$();
    }
    public Dates$L_year STM$() {
        RESULT$=(((mod(p$Yx,4)==(0))&((mod(p$Yx,100)>(0))))|((mod(p$Yx,400)==(0))));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure L_year",1,226,31,229,35,230);
}
