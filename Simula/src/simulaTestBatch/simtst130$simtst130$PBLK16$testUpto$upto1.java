package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testUpto$upto1 extends PROC$ {
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public TXT$ p$t;
    public int p$i;
    public simtst130$simtst130$PBLK16$testUpto$upto1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 2: p$t=(TXT$)objectValue(param); break;
                case 1: p$i=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testUpto$upto1(RTObject$ SL$) {
        super(SL$,2);
    }
    public simtst130$simtst130$PBLK16$testUpto$upto1(RTObject$ SL$,TXT$ sp$t,int sp$i) {
        super(SL$);
        this.p$t = sp$t;
        this.p$i = sp$i;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testUpto$upto1 STM$() {
        if(VALUE$((p$i>(0)))) {
            RESULT$=(((p$i>(TXT$.length(p$t))))?(p$t):(TXT$.sub(p$t,1,Math.subtractExact(p$i,1))));
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure upto1",1,1174,33,1175,39,1175);
}
