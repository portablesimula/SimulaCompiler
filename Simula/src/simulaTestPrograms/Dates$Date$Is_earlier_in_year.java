package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:34:06 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Is_earlier_in_year extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public Dates$Date p$Dx;
    private int $npar=0; // Number of actual parameters transmitted.
    public Dates$Date$Is_earlier_in_year setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$Dx=(Dates$Date)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public Dates$Date$Is_earlier_in_year(RTObject$ SL$)
    { super(SL$); }
    public Dates$Date$Is_earlier_in_year(RTObject$ SL$,Dates$Date sp$Dx) {
        super(SL$);
        this.p$Dx = sp$Dx;
        BBLK();
        STM$();
    }
    public Dates$Date$Is_earlier_in_year STM$() {
        if(VALUE$((((Dates$Date)(CUR$.SL$)).p$M==(p$Dx.p$M)))) {
            {
                RESULT$=(((Dates$Date)(CUR$.SL$)).p$D<(p$Dx.p$D));
            }
        } else
        RESULT$=(((Dates$Date)(CUR$.SL$)).p$M<(p$Dx.p$M));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure Is_earlier_in_year",1,160,31,163,33,164,38,165,42,166);
}
