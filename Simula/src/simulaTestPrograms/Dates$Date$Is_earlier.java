package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Apr 30 13:19:49 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Is_earlier extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public Dates$Date p$Dx;
    private int $npar=0; // Number of actual parameters transmitted.
    public Dates$Date$Is_earlier setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$Dx=(Dates$Date)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public Dates$Date$Is_earlier(RTObject$ SL$)
    { super(SL$); }
    public Dates$Date$Is_earlier(RTObject$ SL$,Dates$Date sp$Dx) {
        super(SL$);
        this.p$Dx = sp$Dx;
        BBLK();
        STM$();
    }
    public Dates$Date$Is_earlier STM$() {
        if(VALUE$((((Dates$Date)(CUR$.SL$)).p$Y==(p$Dx.p$Y)))) {
            {
                if(VALUE$((((Dates$Date)(CUR$.SL$)).p$M==(p$Dx.p$M)))) {
                    {
                        RESULT$=(((Dates$Date)(CUR$.SL$)).p$D<(p$Dx.p$D));
                    }
                } else
                RESULT$=(((Dates$Date)(CUR$.SL$)).p$M<(p$Dx.p$M));
            }
        } else
        RESULT$=(((Dates$Date)(CUR$.SL$)).p$Y<(p$Dx.p$Y));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure Is_earlier",1,149,31,152,33,153,36,154,41,155,45,156,49,157);
}
