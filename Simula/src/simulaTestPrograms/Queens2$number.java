package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:26:23 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Queens2$number extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$i;
    public int p$j;
    public int p$k;
    public int p$l;
    private int $npar=0; // Number of actual parameters transmitted.
    public Queens2$number setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$i=intValue(param); break;
                case 1: p$j=intValue(param); break;
                case 2: p$k=intValue(param); break;
                case 3: p$l=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public Queens2$number(RTObject$ SL$)
    { super(SL$); }
    public Queens2$number(RTObject$ SL$,int sp$i,int sp$j,int sp$k,int sp$l) {
        super(SL$);
        this.p$i = sp$i;
        this.p$j = sp$j;
        this.p$k = sp$k;
        this.p$l = sp$l;
        BBLK();
        STM$();
    }
    public Queens2$number STM$() {
        RESULT$=((((((p$i*(8))+(p$j))*(8))+(p$k))*(8))+(p$l));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Queens2.sim","Procedure number",1,49,40,50,44,50);
}
