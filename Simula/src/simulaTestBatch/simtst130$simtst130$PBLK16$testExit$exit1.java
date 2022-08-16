package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testExit$exit1 extends PROC$ {
    public int p$n;
    public simtst130$simtst130$PBLK16$testExit$exit1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$n=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testExit$exit1(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst130$simtst130$PBLK16$testExit$exit1(RTObject$ SL$,int sp$n) {
        super(SL$);
        this.p$n = sp$n;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testExit$exit1 STM$() {
        if(VALUE$((p$n==(0)))) {
            if(VALUE$((p$n==(1)))) {
                terminate_program();
            }
        }
        ;
        if(VALUE$((p$n==(2)))) {
            simtst130$PBLK16.enterdebug(true);
        } else
        {
            sysout().outtext(new TXT$("Parameter to exit out of range (0,2)"));
            ;
            sysout().outimage();
            ;
            terminate_program();
            ;
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure exit1",1,348,28,350,30,351,36,352,38,353,41,354,47,355,54,357);
}
