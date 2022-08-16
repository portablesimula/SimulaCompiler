package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testInitem$doTestDirectBytefile extends PROC$ {
    public directbytefile$ p$fil;
    public NAME$<TXT$> p$nextitem;
    public simtst130$simtst130$PBLK16$testInitem$doTestDirectBytefile setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 2: p$fil=(directbytefile$)objectValue(param); break;
                case 1: p$nextitem=(NAME$<TXT$>)param; break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testInitem$doTestDirectBytefile(RTObject$ SL$) {
        super(SL$,2);
    }
    public simtst130$simtst130$PBLK16$testInitem$doTestDirectBytefile(RTObject$ SL$,directbytefile$ sp$fil,NAME$<TXT$> sp$nextitem) {
        super(SL$);
        this.p$fil = sp$fil;
        this.p$nextitem = sp$nextitem;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testInitem$doTestDirectBytefile STM$() {
        p$fil.open();
        ;
        for(((simtst130$PBLK16)(CUR$.SL$.SL$)).i$1=1;((simtst130$PBLK16)(CUR$.SL$.SL$)).i$1<=10;((simtst130$PBLK16)(CUR$.SL$.SL$)).i$1++) {
            new simtst130$simtst130$PBLK16$testInitem$doTestDirectBytefile$SubBlock713((CUR$)).STM$();
        }
        ;
        p$fil.close();
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure doTestDirectBytefile",1,707,31,708,35,713,39,714,44,715);
}
