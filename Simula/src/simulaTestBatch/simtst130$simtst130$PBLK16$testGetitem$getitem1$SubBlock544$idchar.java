package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544$idchar extends PROC$ {
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public char p$c;
    public simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544$idchar setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$c=(char)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544$idchar(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544$idchar(RTObject$ SL$,char sp$c) {
        super(SL$);
        this.p$c = sp$c;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544$idchar STM$() {
        RESULT$=(ENVIRONMENT$.letter(p$c)|(ENVIRONMENT$.digit(p$c)));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure idchar",1,529,30,530,34,530);
}
