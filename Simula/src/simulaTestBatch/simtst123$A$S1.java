package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 13 00:24:06 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst123$A$S1 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public LABQNT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$$SW;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst123$A$S1 setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$$SW=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst123$A$S1(RTObject$ SL$)
    { super(SL$); }
    public simtst123$A$S1(RTObject$ SL$,int sp$$SW) {
        super(SL$);
        this.p$$SW = sp$$SW;
        BBLK();
        STM$();
    }
    public simtst123$A$S1 STM$() {
        switch(p$$SW-1) {
            case 0: RESULT$=((simtst123$A)(CUR$.SL$)).L1$0(); break;
            case 1: RESULT$=((simtst123$A)(CUR$.SL$)).L3; break;
            case 2: RESULT$=((simtst123$A)(CUR$.SL$)).L6; break;
            default: throw new RuntimeException("Illegal switch index: "+p$$SW);
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst123.sim","Procedure S1",1,36,39,0);
}
