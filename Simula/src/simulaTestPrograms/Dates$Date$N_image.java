package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Apr 23 08:19:09 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$N_image extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$Nx;
    TXT$ Tx=null;
    private int $npar=0; // Number of actual parameters transmitted.
    public Dates$Date$N_image setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$Nx=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public Dates$Date$N_image(RTObject$ SL$)
    { super(SL$); }
    public Dates$Date$N_image(RTObject$ SL$,int sp$Nx) {
        super(SL$);
        this.p$Nx = sp$Nx;
        BBLK();
        STM$();
    }
    public Dates$Date$N_image STM$() {
        Tx=blanks(4);
        TXT$.putint(Tx,p$Nx);
        TXT$.setpos(Tx,1);
        while((TXT$.getchar(Tx)==(((char)32)))) {
        }
        RESULT$=TXT$.sub(Tx,(TXT$.pos(Tx)-(1)),(6-(TXT$.pos(Tx))));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure N_image",1,27,11,30,33,32,37,33,40,34,44,35);
}
