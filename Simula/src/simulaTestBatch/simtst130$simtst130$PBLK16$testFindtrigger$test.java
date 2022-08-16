package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testFindtrigger$test extends PROC$ {
    public TXT$ p$master;
    public TXT$ p$triggers;
    public char p$expectedValue;
    public int p$expectedPosAfter;
    public char res=0;
    public char rs1=0;
    public TXT$ mastr2=null;
    public int pos=0;
    public simtst130$simtst130$PBLK16$testFindtrigger$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 4: p$master=(TXT$)objectValue(param); break;
                case 3: p$triggers=(TXT$)objectValue(param); break;
                case 2: p$expectedValue=(char)objectValue(param); break;
                case 1: p$expectedPosAfter=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testFindtrigger$test(RTObject$ SL$) {
        super(SL$,4);
    }
    public simtst130$simtst130$PBLK16$testFindtrigger$test(RTObject$ SL$,TXT$ sp$master,TXT$ sp$triggers,char sp$expectedValue,int sp$expectedPosAfter) {
        super(SL$);
        this.p$master = sp$master;
        this.p$triggers = sp$triggers;
        this.p$expectedValue = sp$expectedValue;
        this.p$expectedPosAfter = sp$expectedPosAfter;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testFindtrigger$test STM$() {
        pos=TXT$.pos(p$master);
        ;
        mastr2=ENVIRONMENT$.copy(copy(p$master));
        ;
        TXT$.setpos(mastr2,pos);
        ;
        res=simtst130$PBLK16.findtrigger(new NAME$<TXT$>(){ public TXT$ get() { return(p$master); } public TXT$ put(TXT$ x$) { return(p$master=(TXT$)x$); } },p$triggers);
        ;
        rs1=new simtst130$simtst130$PBLK16$testFindtrigger$findtrigger1((CUR$.SL$),new NAME$<TXT$>(){ public TXT$ get() { return(mastr2); } public TXT$ put(TXT$ x$) { return(mastr2=(TXT$)x$); } },p$triggers).RESULT$;
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  findtrigger("),p$master),new TXT$(",")),p$triggers),new TXT$(") ==> '")),ENVIRONMENT$.edit(res)),new TXT$("'   expectedValue=")),ENVIRONMENT$.edit(p$expectedValue)),new TXT$(", expectedPosAfter=")),ENVIRONMENT$.edit(p$expectedPosAfter)));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test findtrigger1("),mastr2),new TXT$(",")),p$triggers),new TXT$(") ==> '")),ENVIRONMENT$.edit(rs1)),new TXT$("'   expectedValue=")),ENVIRONMENT$.edit(p$expectedValue)),new TXT$(", expectedPosAfter=")),ENVIRONMENT$.edit(p$expectedPosAfter)));
        ;
        if(VALUE$((res!=(p$expectedValue)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  findtrigger FAILED: result="),ENVIRONMENT$.edit(res)));
        }
        ;
        if(VALUE$((rs1!=(p$expectedValue)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  findtrigger1 FAILED: result="),ENVIRONMENT$.edit(rs1)));
        }
        ;
        if(VALUE$((TXT$.pos(p$master)!=(p$expectedPosAfter)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  findtrigger FAILED: master.pos="),ENVIRONMENT$.edit(TXT$.pos(p$master))));
        }
        ;
        if(VALUE$((TXT$.pos(mastr2)!=(p$expectedPosAfter)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  findtrigger1 FAILED: mastr2.pos="),ENVIRONMENT$.edit(TXT$.pos(mastr2))));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,400,11,401,42,402,49,403,52,404,55,405,58,406,61,407,66,408,71,409,76,410,83,411);
}
