package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testHash$test extends PROC$ {
    public TXT$ p$t;
    public int p$n;
    public int p$expectedValue;
    public int res=0;
    public int rs1=0;
    public simtst130$simtst130$PBLK16$testHash$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 3: p$t=(TXT$)objectValue(param); break;
                case 2: p$n=intValue(param); break;
                case 1: p$expectedValue=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testHash$test(RTObject$ SL$) {
        super(SL$,3);
    }
    public simtst130$simtst130$PBLK16$testHash$test(RTObject$ SL$,TXT$ sp$t,int sp$n,int sp$expectedValue) {
        super(SL$);
        this.p$t = sp$t;
        this.p$n = sp$n;
        this.p$expectedValue = sp$expectedValue;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testHash$test STM$() {
        res=simtst130$PBLK16.hash(p$t,p$n);
        ;
        rs1=new simtst130$simtst130$PBLK16$testHash$hash1((CUR$.SL$),p$t,p$n).RESULT$;
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test  hash("),p$t),new TXT$(",")),ENVIRONMENT$.edit(p$n)),new TXT$("), t.pos=")),ENVIRONMENT$.edit(TXT$.pos(p$t))),new TXT$(" ==> '")),ENVIRONMENT$.edit(res)),new TXT$("'   expectedValue=")),ENVIRONMENT$.edit(p$expectedValue)));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("Test hash1("),p$t),new TXT$(",")),ENVIRONMENT$.edit(p$n)),new TXT$("), t.pos=")),ENVIRONMENT$.edit(TXT$.pos(p$t))),new TXT$(" ==> '")),ENVIRONMENT$.edit(rs1)),new TXT$("'   expectedValue=")),ENVIRONMENT$.edit(p$expectedValue)));
        ;
        if(VALUE$((res!=(p$expectedValue)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  hash FAILED: result="),ENVIRONMENT$.edit(res)));
        }
        ;
        if(VALUE$((rs1!=(p$expectedValue)))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$),CONC(new TXT$("Test  hash1 FAILED: result="),ENVIRONMENT$.edit(rs1)));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure test",1,586,10,587,37,588,40,589,43,590,46,591,49,592,54,593,61,594);
}
