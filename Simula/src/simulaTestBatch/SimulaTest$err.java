package simulaTestBatch;
// Simula-2.0 Compiled at Fri Aug 12 13:52:55 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SimulaTest$err extends PROC$ {
    public TXT$ p$t;
    public SimulaTest$err setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$t=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public SimulaTest$err(RTObject$ SL$) {
        super(SL$,1);
    }
    public SimulaTest$err(RTObject$ SL$,TXT$ sp$t) {
        super(SL$);
        this.p$t = sp$t;
        BBLK();
        STM$();
    }
    public SimulaTest$err STM$() {
        sysout().setpos(1);
        ;
        sysout().outtext(new TXT$("*** error: in test "));
        ;
        sysout().outtext(p$t);
        ;
        sysout().outimage();
        ;
        ((SimulaTest)(CUR$.SL$)).found_error=true;
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("SimulaTest.sim","Procedure err",1,8,28,9,31,10,38,11,43,12);
}
