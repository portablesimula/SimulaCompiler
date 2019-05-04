package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat May 04 11:45:33 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ArrayAsParameter$Proc extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public ARRAY$<?> p$AA;
    int k=0;
    private int $npar=0; // Number of actual parameters transmitted.
    public ArrayAsParameter$Proc setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$AA=arrayValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public ArrayAsParameter$Proc(RTObject$ SL$)
    { super(SL$); }
    public ArrayAsParameter$Proc(RTObject$ SL$,ARRAY$<?> sp$AA) {
        super(SL$);
        this.p$AA = sp$AA;
        BBLK();
        STM$();
    }
    public ArrayAsParameter$Proc STM$() {
        k=((ARRAY$<int[]>)p$AA).Elt[9-p$AA.LB[0]];
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ArrayAsParameter.sim","Procedure Proc",1,17,9,19,31,20,35,21);
}
