package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testFrontcompare$frontcompare1 extends PROC$ {
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public TXT$ p$string;
    public TXT$ p$config;
    public simtst130$simtst130$PBLK16$testFrontcompare$frontcompare1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 2: p$string=(TXT$)objectValue(param); break;
                case 1: p$config=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testFrontcompare$frontcompare1(RTObject$ SL$) {
        super(SL$,2);
    }
    public simtst130$simtst130$PBLK16$testFrontcompare$frontcompare1(RTObject$ SL$,TXT$ sp$string,TXT$ sp$config) {
        super(SL$);
        this.p$string = sp$string;
        this.p$config = sp$config;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testFrontcompare$frontcompare1 STM$() {
        if(VALUE$((Math.addExact(Math.subtractExact(TXT$.length(p$string),TXT$.pos(p$string)),1)>=(TXT$.length(p$config))))) {
            RESULT$=TXTREL$EQ(TXT$.sub(p$string,TXT$.pos(p$string),TXT$.length(p$config)),p$config);
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure frontcompare1",1,467,33,468,35,469,40,469);
}
