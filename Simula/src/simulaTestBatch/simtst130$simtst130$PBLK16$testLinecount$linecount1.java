package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testLinecount$linecount1 extends PROC$ {
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public printfile$ p$pfil;
    public simtst130$simtst130$PBLK16$testLinecount$linecount1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$pfil=(printfile$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testLinecount$linecount1(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst130$simtst130$PBLK16$testLinecount$linecount1(RTObject$ SL$,printfile$ sp$pfil) {
        super(SL$);
        this.p$pfil = sp$pfil;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testLinecount$linecount1 STM$() {
        if(VALUE$((p$pfil==(null)))) {
            RESULT$=(-(1));
        } else
        if(VALUE$((!(p$pfil.isopen())))) {
            RESULT$=(-(2));
        } else
        new simtst130$simtst130$PBLK16$testLinecount$linecount1$SubBlock749((CUR$)).STM$();
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure linecount1",1,742,30,743,34,744,38,749,43,750);
}
