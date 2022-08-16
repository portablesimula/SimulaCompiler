package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testInitem$createBytefile extends PROC$ {
    public outbytefile$ p$fil;
    public simtst130$simtst130$PBLK16$testInitem$createBytefile setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$fil=(outbytefile$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testInitem$createBytefile(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst130$simtst130$PBLK16$testInitem$createBytefile(RTObject$ SL$,outbytefile$ sp$fil) {
        super(SL$);
        this.p$fil = sp$fil;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testInitem$createBytefile STM$() {
        p$fil.setaccess(new TXT$("anycreate"));
        ;
        p$fil.open();
        ;
        for(((simtst130$PBLK16)(CUR$.SL$.SL$)).i$1=1;((simtst130$PBLK16)(CUR$.SL$.SL$)).i$1<=10;((simtst130$PBLK16)(CUR$.SL$.SL$)).i$1++) {
            p$fil.outtext(CONC(CONC(new TXT$("   "),ENVIRONMENT$.edit(ENVIRONMENT$.char$(Math.addExact(ENVIRONMENT$.rank('A'),((simtst130$PBLK16)(CUR$.SL$.SL$)).i$1)))),new TXT$("   ")));
        }
        ;
        p$fil.close();
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure createBytefile",1,673,28,674,34,675,38,676,43,677);
}
