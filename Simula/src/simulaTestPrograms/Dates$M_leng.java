package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Apr 23 08:19:09 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$M_leng extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$Mx;
    public int p$Yx;
    private int $npar=0; // Number of actual parameters transmitted.
    public Dates$M_leng setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$Mx=intValue(param); break;
                case 1: p$Yx=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public Dates$M_leng(RTObject$ SL$)
    { super(SL$); }
    public Dates$M_leng(RTObject$ SL$,int sp$Mx,int sp$Yx) {
        super(SL$);
        this.p$Mx = sp$Mx;
        this.p$Yx = sp$Yx;
        BBLK();
        STM$();
    }
    public Dates$M_leng STM$() {
        if(VALUE$((p$Mx==(2)))) {
            RESULT$=((new Dates$L_year(((Dates)(CUR$.SL$)),p$Yx).RESULT$)?(29):(28));
        } else
        RESULT$=((Dates)(CUR$.SL$)).M_tab.Elt[p$Mx-((Dates)(CUR$.SL$)).M_tab.LB[0]];
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure M_leng",1,218,34,221,38,222,42,223);
}
