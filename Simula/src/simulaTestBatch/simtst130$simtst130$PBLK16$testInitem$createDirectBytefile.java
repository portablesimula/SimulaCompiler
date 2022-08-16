package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testInitem$createDirectBytefile extends PROC$ {
    public directbytefile$ p$fil;
    public simtst130$simtst130$PBLK16$testInitem$createDirectBytefile setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$fil=(directbytefile$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testInitem$createDirectBytefile(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst130$simtst130$PBLK16$testInitem$createDirectBytefile(RTObject$ SL$,directbytefile$ sp$fil) {
        super(SL$);
        this.p$fil = sp$fil;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testInitem$createDirectBytefile STM$() {
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure createDirectBytefile",1,695,28,696,34,697,38,698,43,699);
}
