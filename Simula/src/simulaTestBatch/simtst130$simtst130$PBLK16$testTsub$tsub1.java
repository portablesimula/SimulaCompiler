package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testTsub$tsub1 extends PROC$ {
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public TXT$ p$t;
    public int p$p;
    public int p$l;
    public simtst130$simtst130$PBLK16$testTsub$tsub1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 3: p$t=(TXT$)objectValue(param); break;
                case 2: p$p=intValue(param); break;
                case 1: p$l=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testTsub$tsub1(RTObject$ SL$) {
        super(SL$,3);
    }
    public simtst130$simtst130$PBLK16$testTsub$tsub1(RTObject$ SL$,TXT$ sp$t,int sp$p,int sp$l) {
        super(SL$);
        this.p$t = sp$t;
        this.p$p = sp$p;
        this.p$l = sp$l;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testTsub$tsub1 STM$() {
        if(VALUE$((((p$p>=(1))&((p$l>=(0))))&((Math.addExact(p$p,p$l)<=(Math.addExact(TXT$.length(p$t),1))))))) {
            RESULT$=TXT$.sub(p$t,p$p,p$l);
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure tsub1",1,1098,36,1099,38,1100,43,1100);
}
