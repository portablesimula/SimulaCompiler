package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testChangeAll$test extends PROC$ {
    public TXT$ p$master;
    public TXT$ p$oldt;
    public TXT$ p$newt;
    public TXT$ p$expectedValue;
    public int p$expectedPosAfter;
    public TXT$ prevMaster=null;
    public int p=0;
    public simtst130$simtst130$PBLK16$testChangeAll$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 5: p$master=(TXT$)objectValue(param); break;
                case 4: p$oldt=(TXT$)objectValue(param); break;
                case 3: p$newt=(TXT$)objectValue(param); break;
                case 2: p$expectedValue=(TXT$)objectValue(param); break;
                case 1: p$expectedPosAfter=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testChangeAll$test(RTObject$ SL$) {
        super(SL$,5);
    }
    public simtst130$simtst130$PBLK16$testChangeAll$test(RTObject$ SL$,TXT$ sp$master,TXT$ sp$oldt,TXT$ sp$newt,TXT$ sp$expectedValue,int sp$expectedPosAfter) {
        super(SL$);
        this.p$master = sp$master;
        this.p$oldt = sp$oldt;
        this.p$newt = sp$newt;
        this.p$expectedValue = sp$expectedValue;
        this.p$expectedPosAfter = sp$expectedPosAfter;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testChangeAll$test STM$() {
        prevMaster=ENVIRONMENT$.copy(copy(p$master));
        ;
        p=TXT$.pos(p$master);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  changeAll("),p$master),new TXT$(",")),p$oldt),new TXT$(",")),p$newt),new TXT$(")  ")),new TXT$("   expectedValue=")),p$expectedValue),new TXT$(", expectedPosAfter=")),ENVIRONMENT$.edit(p$expectedPosAfter)));
        ;
        new simtst130$simtst130$PBLK16$testChangeAll$changeAll((CUR$.SL$),new NAME$<TXT$>(){ public TXT$ get() { return(p$master); } public TXT$ put(TXT$ x$) { return(p$master=(TXT$)x$); } },p$oldt,p$newt);
        ;
        if(VALUE$(TXTREL$NE(p$master,p$expectedValue))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  testChangeAll FAILED: master="),p$master));
        }
        ;
        if(VALUE$((TXT$.pos(p$master)!=(p$expectedPosAfter)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  testChangeAll FAILED: master.pos="),ENVIRONMENT$.edit(TXT$.pos(p$master))));
        }
        ;
        TXT$.setpos(p$master,p);
        ;
        new simtst130$simtst130$PBLK16$testChangeAll$changeAll((CUR$.SL$),new NAME$<TXT$>(){ public TXT$ get() { return(p$master); } public TXT$ put(TXT$ x$) { return(p$master=(TXT$)x$); } },p$newt,p$oldt);
        ;
        if(VALUE$(TXTREL$NE(p$master,prevMaster))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(CONC(CONC(new TXT$("Test  testChangeAll FAILED: master="),p$master),new TXT$(", prevMaster=")),prevMaster));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,107,12,109,43,110,48,112,51,113,54,114,59,115,64,116,69,117,76,118);
}
