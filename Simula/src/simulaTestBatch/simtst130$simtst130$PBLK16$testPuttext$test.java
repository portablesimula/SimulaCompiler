package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testPuttext$test extends PROC$ {
    public TXT$ p$oldt;
    public TXT$ p$newt;
    public boolean p$expectedValue;
    public int p$expectedPosAfter;
    public boolean res=false;
    public boolean rs1=false;
    public TXT$ old2=null;
    public TXT$ oldtx=null;
    public TXT$ old2x=null;
    public int pos=0;
    public simtst130$simtst130$PBLK16$testPuttext$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 4: p$oldt=(TXT$)objectValue(param); break;
                case 3: p$newt=(TXT$)objectValue(param); break;
                case 2: p$expectedValue=(boolean)objectValue(param); break;
                case 1: p$expectedPosAfter=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testPuttext$test(RTObject$ SL$) {
        super(SL$,4);
    }
    public simtst130$simtst130$PBLK16$testPuttext$test(RTObject$ SL$,TXT$ sp$oldt,TXT$ sp$newt,boolean sp$expectedValue,int sp$expectedPosAfter) {
        super(SL$);
        this.p$oldt = sp$oldt;
        this.p$newt = sp$newt;
        this.p$expectedValue = sp$expectedValue;
        this.p$expectedPosAfter = sp$expectedPosAfter;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testPuttext$test STM$() {
        pos=TXT$.pos(p$oldt);
        ;
        old2=ENVIRONMENT$.copy(copy(p$oldt));
        ;
        TXT$.setpos(old2,pos);
        ;
        oldtx=ENVIRONMENT$.copy(copy(p$oldt));
        ;
        old2x=ENVIRONMENT$.copy(copy(old2));
        ;
        res=simtst130$PBLK16.puttext(new NAME$<TXT$>(){ public TXT$ get() { return(p$oldt); } public TXT$ put(TXT$ x$) { return(p$oldt=(TXT$)x$); } },p$newt);
        ;
        rs1=new simtst130$simtst130$PBLK16$testPuttext$puttext1((CUR$.SL$),new NAME$<TXT$>(){ public TXT$ get() { return(old2); } public TXT$ put(TXT$ x$) { return(old2=(TXT$)x$); } },p$newt).RESULT$;
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  puttext("),oldtx),new TXT$(",")),p$newt),new TXT$(") ==> '")),p$oldt),new TXT$("':")),ENVIRONMENT$.edit(res)),new TXT$("   expectedValue=")),ENVIRONMENT$.edit(p$expectedValue)),new TXT$(", expectedPosAfter=")),ENVIRONMENT$.edit(p$expectedPosAfter)));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test puttext1("),old2x),new TXT$(",")),p$newt),new TXT$(") ==> '")),old2),new TXT$("':")),ENVIRONMENT$.edit(rs1)),new TXT$("   expectedValue=")),ENVIRONMENT$.edit(p$expectedValue)),new TXT$(", expectedPosAfter=")),ENVIRONMENT$.edit(p$expectedPosAfter)));
        ;
        if(VALUE$((res!=(p$expectedValue)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  puttext FAILED: result="),ENVIRONMENT$.edit(res)));
        }
        ;
        if(VALUE$((rs1!=(p$expectedValue)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  puttext1 FAILED: result="),ENVIRONMENT$.edit(rs1)));
        }
        ;
        if(VALUE$((TXT$.pos(p$oldt)!=(p$expectedPosAfter)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  puttext FAILED: oldt.pos="),ENVIRONMENT$.edit(TXT$.pos(p$oldt))));
        }
        ;
        if(VALUE$((TXT$.pos(old2)!=(p$expectedPosAfter)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  puttext1 FAILED: old2.pos="),ENVIRONMENT$.edit(TXT$.pos(old2))));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,826,11,827,44,828,51,829,56,830,59,831,62,832,65,833,68,834,73,835,78,836,83,837,90,838);
}
