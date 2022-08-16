package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$trace extends PROC$ {
    public TXT$ p$mess;
    public simtst130$simtst130$PBLK16$trace setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$mess=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$trace(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst130$simtst130$PBLK16$trace(RTObject$ SL$,TXT$ sp$mess) {
        super(SL$);
        this.p$mess = sp$mess;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$trace STM$() {
        if(VALUE$(false)) {
            {
                sysout().outtext(p$mess);
                ;
                sysout().outimage();
                ;
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure trace",1,27,29,28,39,29);
}
