package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testFetchar$fetchar1 extends PROC$ {
    public char RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public TXT$ p$t;
    public int p$p;
    public simtst130$simtst130$PBLK16$testFetchar$fetchar1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 2: p$t=(TXT$)objectValue(param); break;
                case 1: p$p=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testFetchar$fetchar1(RTObject$ SL$) {
        super(SL$,2);
    }
    public simtst130$simtst130$PBLK16$testFetchar$fetchar1(RTObject$ SL$,TXT$ sp$t,int sp$p) {
        super(SL$);
        this.p$t = sp$t;
        this.p$p = sp$p;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testFetchar$fetchar1 STM$() {
        if(VALUE$(((p$p>(0))&((p$p<=(TXT$.length(p$t))))))) {
            RESULT$=TXT$.getchar(TXT$.sub(p$t,p$p,1));
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure fetchar1",1,363,33,364,39,364);
}