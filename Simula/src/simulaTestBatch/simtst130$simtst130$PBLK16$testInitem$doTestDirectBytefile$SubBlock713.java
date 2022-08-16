package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testInitem$doTestDirectBytefile$SubBlock713 extends BASICIO$ {
    public TXT$ item=null;
    public simtst130$simtst130$PBLK16$testInitem$doTestDirectBytefile$SubBlock713(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
    }
    public RTObject$ STM$() {
        item=((simtst130$simtst130$PBLK16$testInitem$doTestDirectBytefile)(CUR$.SL$)).p$nextitem.get();
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$.SL$),CONC(CONC(CONC(new TXT$("GOT: '"),item),new TXT$("'   Endfile=")),ENVIRONMENT$.edit(sysin().endfile())));
        ;
        if(VALUE$(TXTREL$NE(item,ENVIRONMENT$.edit(ENVIRONMENT$.char$(Math.addExact(ENVIRONMENT$.rank('A'),((simtst130$PBLK16)(CUR$.SL$.SL$.SL$)).i$1)))))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$.SL$),CONC(CONC(CONC(CONC(new TXT$("TestInitem - directbytefile FAILED for Item "),ENVIRONMENT$.edit(((simtst130$PBLK16)(CUR$.SL$.SL$.SL$)).i$1)),new TXT$(" = '")),item),new TXT$("'")));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","SubBlock SubBlock713",1,710,15,711,18,712,25,713);
}
