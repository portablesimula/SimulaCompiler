package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$failed extends PROC$ {
    public TXT$ p$mess;
    public simtst130$simtst130$PBLK16$failed setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$mess=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$failed(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst130$simtst130$PBLK16$failed(RTObject$ SL$,TXT$ sp$mess) {
        super(SL$);
        this.p$mess = sp$mess;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$failed STM$() {
        new SimulaTest$err((CUR$.SL$.SL$),p$mess);
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure failed",1,35,28,36,33,37);
}
