package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testGetitem$test extends PROC$ {
    public NAME$<TXT$> p$tt;
    public TXT$ p$expectedValue;
    public int p$expectedPosAfter;
    public TXT$ res=null;
    public TXT$ rs1=null;
    public TXT$ t2=null;
    public int pos=0;
    public simtst130$simtst130$PBLK16$testGetitem$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 3: p$tt=(NAME$<TXT$>)param; break;
                case 2: p$expectedValue=(TXT$)objectValue(param); break;
                case 1: p$expectedPosAfter=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testGetitem$test(RTObject$ SL$) {
        super(SL$,3);
    }
    public simtst130$simtst130$PBLK16$testGetitem$test(RTObject$ SL$,NAME$<TXT$> sp$tt,TXT$ sp$expectedValue,int sp$expectedPosAfter) {
        super(SL$);
        this.p$tt = sp$tt;
        this.p$expectedValue = sp$expectedValue;
        this.p$expectedPosAfter = sp$expectedPosAfter;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testGetitem$test STM$() {
        pos=TXT$.pos(p$tt.get());
        ;
        t2=ENVIRONMENT$.copy(copy(p$tt.get()));
        ;
        TXT$.setpos(t2,pos);
        ;
        res=simtst130$PBLK16.getitem(new NAME$<TXT$>(){ public TXT$ get() { return(p$tt.get()); } public TXT$ put(TXT$ x$) { return(p$tt.put((TXT$)x$)); } });
        ;
        rs1=new simtst130$simtst130$PBLK16$testGetitem$getitem1((CUR$.SL$),new NAME$<TXT$>(){ public TXT$ get() { return(t2); } public TXT$ put(TXT$ x$) { return(t2=(TXT$)x$); } }).RESULT$;
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  getitem("),p$tt.get()),new TXT$("), tt.pos=")),ENVIRONMENT$.edit(TXT$.pos(p$tt.get()))),new TXT$(" ==> '")),res),new TXT$("'   expectedValue=")),p$expectedValue),new TXT$(", expectedPosAfter=")),ENVIRONMENT$.edit(p$expectedPosAfter)));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test getitem1("),t2),new TXT$("), t2.pos=")),ENVIRONMENT$.edit(TXT$.pos(t2))),new TXT$(" ==> '")),rs1),new TXT$("'   expectedValue=")),p$expectedValue),new TXT$(", expectedPosAfter=")),ENVIRONMENT$.edit(p$expectedPosAfter)));
        ;
        if(VALUE$(TXTREL$NE(res,p$expectedValue))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  getitem FAILED: result="),res));
        }
        ;
        if(VALUE$(TXTREL$NE(rs1,p$expectedValue))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  getitem1 FAILED: result="),rs1));
        }
        ;
        if(VALUE$((TXT$.pos(p$tt.get())!=(p$expectedPosAfter)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  getitem FAILED: tt.pos="),ENVIRONMENT$.edit(TXT$.pos(p$tt.get()))));
        }
        ;
        if(VALUE$((TXT$.pos(t2)!=(p$expectedPosAfter)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  getitem1 FAILED: t2.pos="),ENVIRONMENT$.edit(TXT$.pos(t2))));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,546,10,547,39,548,46,549,49,550,52,551,55,552,58,553,63,554,68,555,73,556,80,557);
}
