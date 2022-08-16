package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testChange$test extends PROC$ {
    public TXT$ p$master;
    public TXT$ p$oldt;
    public TXT$ p$newt;
    public boolean p$expectedSuccess;
    public TXT$ p$expectedValue;
    public int p$expectedPosAfter;
    public boolean success=false;
    public boolean succes1=false;
    public TXT$ mastr1=null;
    public int p=0;
    public simtst130$simtst130$PBLK16$testChange$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 6: p$master=(TXT$)objectValue(param); break;
                case 5: p$oldt=(TXT$)objectValue(param); break;
                case 4: p$newt=(TXT$)objectValue(param); break;
                case 3: p$expectedSuccess=(boolean)objectValue(param); break;
                case 2: p$expectedValue=(TXT$)objectValue(param); break;
                case 1: p$expectedPosAfter=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testChange$test(RTObject$ SL$) {
        super(SL$,6);
    }
    public simtst130$simtst130$PBLK16$testChange$test(RTObject$ SL$,TXT$ sp$master,TXT$ sp$oldt,TXT$ sp$newt,boolean sp$expectedSuccess,TXT$ sp$expectedValue,int sp$expectedPosAfter) {
        super(SL$);
        this.p$master = sp$master;
        this.p$oldt = sp$oldt;
        this.p$newt = sp$newt;
        this.p$expectedSuccess = sp$expectedSuccess;
        this.p$expectedValue = sp$expectedValue;
        this.p$expectedPosAfter = sp$expectedPosAfter;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testChange$test STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  change("),p$master),new TXT$(",")),p$oldt),new TXT$(",")),p$newt),new TXT$(")  ")),new TXT$("   expectedSuccess=")),ENVIRONMENT$.edit(p$expectedSuccess)),new TXT$(", expectedValue=")),p$expectedValue),new TXT$(", expectedPosAfter=")),ENVIRONMENT$.edit(p$expectedPosAfter)));
        ;
        p=TXT$.pos(p$master);
        ;
        mastr1=ENVIRONMENT$.copy(copy(p$master));
        ;
        TXT$.setpos(mastr1,p);
        ;
        success=simtst130$PBLK16.change(new NAME$<TXT$>(){ public TXT$ get() { return(p$master); } public TXT$ put(TXT$ x$) { return(p$master=(TXT$)x$); } },p$oldt,p$newt);
        ;
        succes1=new simtst130$simtst130$PBLK16$testChange$change1((CUR$.SL$),new NAME$<TXT$>(){ public TXT$ get() { return(mastr1); } public TXT$ put(TXT$ x$) { return(mastr1=(TXT$)x$); } },p$oldt,p$newt).RESULT$;
        ;
        if(VALUE$((success!=(p$expectedSuccess)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  testChange FAILED: expectedSuccess="),ENVIRONMENT$.edit(p$expectedSuccess)));
        }
        ;
        if(VALUE$((succes1!=(p$expectedSuccess)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test testChange1 FAILED: expectedSuccess="),ENVIRONMENT$.edit(p$expectedSuccess)));
        }
        ;
        if(VALUE$(TXTREL$NE(p$master,p$expectedValue))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  testChange FAILED: master="),p$master));
        }
        ;
        if(VALUE$(TXTREL$NE(mastr1,p$expectedValue))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test testChange1 FAILED: mastr1="),mastr1));
        }
        ;
        if(VALUE$((TXT$.pos(p$master)!=(p$expectedPosAfter)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  testChange FAILED: master.pos="),ENVIRONMENT$.edit(TXT$.pos(p$master))));
        }
        ;
        if(VALUE$((TXT$.pos(mastr1)!=(p$expectedPosAfter)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  testChange FAILED: mastr1.pos="),ENVIRONMENT$.edit(TXT$.pos(mastr1))));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,65,13,67,48,69,51,70,58,71,61,72,64,73,69,74,74,75,79,76,84,77,89,78,96,79);
}
