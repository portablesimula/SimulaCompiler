package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testInsinglechar$prompt extends PROC$ {
    public char RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public TXT$ p$mss;
    public boolean p$echo;
    public char c=0;
    public simtst130$simtst130$PBLK16$testInsinglechar$prompt setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 2: p$mss=(TXT$)objectValue(param); break;
                case 1: p$echo=(boolean)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testInsinglechar$prompt(RTObject$ SL$) {
        super(SL$,2);
    }
    public simtst130$simtst130$PBLK16$testInsinglechar$prompt(RTObject$ SL$,TXT$ sp$mss,boolean sp$echo) {
        super(SL$);
        this.p$mss = sp$mss;
        this.p$echo = sp$echo;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testInsinglechar$prompt STM$() {
        sysout().outimage();
        ;
        sysout().outtext(p$mss);
        ;
        sysout().breakoutimage();
        ;
        c=simtst130$PBLK16.insinglechar();
        ;
        if(VALUE$(p$echo)) {
            {
                sysout().outchar(c);
                ;
                sysout().breakoutimage();
                ;
            }
        }
        ;
        RESULT$=c;
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure prompt",1,727,11,728,35,729,42,730,45,731,55,732,60,733);
}
