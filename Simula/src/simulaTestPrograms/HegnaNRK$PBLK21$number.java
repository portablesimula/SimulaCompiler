package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$number extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public char p$c;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$number setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$c=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$PBLK21$number(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$PBLK21$number(RTObject$ SL$,char sp$c) {
        super(SL$);
        this.p$c = sp$c;
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$number STM$() {
        RESULT$=(('0'<=(p$c))&((p$c<=('9'))));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure number",1,1037,31,1038,35,1038);
}
