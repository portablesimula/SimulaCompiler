package simulaTestBatch;
// Simula-2.0 Compiled at Tue Jun 14 15:26:58 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst76$$Print extends PROC$ {
    public TXT$ p$t;
    public simtst76$$Print setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$t=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst76$$Print(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst76$$Print(RTObject$ SL$,TXT$ sp$t) {
        super(SL$);
        this.p$t = sp$t;
        BBLK();
        STM$();
    }
    public simtst76$$Print STM$() {
        sysout().outtext(p$t);
        ;
        if(VALUE$(false)) {
            sysout().outimage();
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst76.sim","Procedure Print",1,15,28,16,37,16);
}
