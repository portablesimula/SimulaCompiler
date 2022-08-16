package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testCompress$test extends PROC$ {
    public TXT$ p$tin;
    public char p$ch;
    public TXT$ p$expectedValue;
    public TXT$ p$expectedMain;
    public TXT$ tin1=null;
    public TXT$ tin2=null;
    public TXT$ res=null;
    public TXT$ rs1=null;
    public simtst130$simtst130$PBLK16$testCompress$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 4: p$tin=(TXT$)objectValue(param); break;
                case 3: p$ch=(char)objectValue(param); break;
                case 2: p$expectedValue=(TXT$)objectValue(param); break;
                case 1: p$expectedMain=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testCompress$test(RTObject$ SL$) {
        super(SL$,4);
    }
    public simtst130$simtst130$PBLK16$testCompress$test(RTObject$ SL$,TXT$ sp$tin,char sp$ch,TXT$ sp$expectedValue,TXT$ sp$expectedMain) {
        super(SL$);
        this.p$tin = sp$tin;
        this.p$ch = sp$ch;
        this.p$expectedValue = sp$expectedValue;
        this.p$expectedMain = sp$expectedMain;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testCompress$test STM$() {
        tin1=ENVIRONMENT$.copy(copy(p$tin));
        ;
        tin2=ENVIRONMENT$.copy(copy(p$tin));
        ;
        res=simtst130$PBLK16.compress(tin1,p$ch);
        ;
        rs1=new simtst130$simtst130$PBLK16$testCompress$compress1((CUR$.SL$),tin2,p$ch).RESULT$;
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  compress("),p$tin),new TXT$(",")),ENVIRONMENT$.edit(p$ch)),new TXT$(") ==> '")),res),new TXT$("'   expectedValue=")),p$expectedValue),new TXT$(", expectedMain=")),p$expectedMain));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test compress1("),p$tin),new TXT$(",")),ENVIRONMENT$.edit(p$ch)),new TXT$(") ==> '")),rs1),new TXT$("'   expectedValue=")),p$expectedValue),new TXT$(", expectedMain=")),p$expectedMain));
        ;
        if(VALUE$(TXTREL$NE(res,p$expectedValue))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  compress FAILED: result="),res));
        }
        ;
        if(VALUE$(TXTREL$NE(rs1,p$expectedValue))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  compress1 FAILED: result="),rs1));
        }
        ;
        if(VALUE$(TXTREL$NE(TXT$.main(res),p$expectedMain))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  compress FAILED: result.main="),TXT$.main(res)));
        }
        ;
        if(VALUE$(TXTREL$NE(TXT$.main(rs1),p$expectedMain))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  compress1 FAILED: result.main="),TXT$.main(rs1)));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,213,11,214,46,215,49,216,52,217,55,218,58,219,63,220,68,221,73,222,80,223);
}
