package simulaTestBatch;
// Simula-1.0 Compiled at Wed Oct 02 09:47:31 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst123$$A$S1 extends PROC$ {
    public LABQNT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$$SW;
    public simtst123$$A$S1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$$SW=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst123$$A$S1(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst123$$A$S1(RTObject$ SL$,int sp$$SW) {
        super(SL$);
        this.p$$SW = sp$$SW;
        BBLK();
        STM$();
    }
    public simtst123$$A$S1 STM$() {
        switch(p$$SW-1) {
            case 0: RESULT$=((simtst123$$A)(CUR$.SL$)).L1$0(); break;
            case 1: RESULT$=((simtst123$$A)(CUR$.SL$)).L3; break;
            case 2: RESULT$=((simtst123$$A)(CUR$.SL$)).L6; break;
            default: throw new RuntimeException("Illegal switch index: "+p$$SW);
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst123.sim","Procedure S1",1,31,38,0);
}
