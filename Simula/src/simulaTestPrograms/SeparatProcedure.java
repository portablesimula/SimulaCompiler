package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:19:06 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SeparatProcedure extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$i;
    SeparatProcedure$A x=null;
    int n=0;
    private int $npar=0; // Number of actual parameters transmitted.
    public SeparatProcedure setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$i=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public SeparatProcedure(RTObject$ SL$)
    { super(SL$); }
    public SeparatProcedure(RTObject$ SL$,int sp$i) {
        super(SL$);
        this.p$i = sp$i;
        BBLK();
        STM$();
    }
    public SeparatProcedure STM$() {
        x=new SeparatProcedure$A(((SeparatProcedure)CUR$)).STM$();
        new SeparatProcedure$A$proc1(x);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("PrecompiledProcedure.sim","Procedure SeparatProcedure",1,2,9,4,11,5,33,13,35,14,39,15);
}
