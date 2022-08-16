package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testInitem$doTestDirectfile$SubBlock669 extends BASICIO$ {
    public TXT$ item=null;
    public simtst130$simtst130$PBLK16$testInitem$doTestDirectfile$SubBlock669(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
    }
    public RTObject$ STM$() {
        item=((simtst130$simtst130$PBLK16$testInitem$doTestDirectfile)(CUR$.SL$)).p$nextitem.get();
        ;
        ((simtst130$PBLK16)(CUR$.SL$.SL$.SL$)).i$1=Math.addExact(((simtst130$PBLK16)(CUR$.SL$.SL$.SL$)).i$1,1);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$.SL$),CONC(CONC(new TXT$("GOT: '"),item),new TXT$("'")));
        ;
        if(VALUE$(TXTREL$NE(item,CONC(new TXT$("item"),ENVIRONMENT$.edit(((simtst130$PBLK16)(CUR$.SL$.SL$.SL$)).i$1))))) {
            new simtst130$simtst130$PBLK16$failed((CUR$.SL$.SL$.SL$),CONC(CONC(CONC(CONC(new TXT$("TestInitem - directfile FAILED for Item "),ENVIRONMENT$.edit(((simtst130$PBLK16)(CUR$.SL$.SL$.SL$)).i$1)),new TXT$(" = '")),item),new TXT$("'")));
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","SubBlock SubBlock669",1,665,13,666,18,667,21,668,28,669);
}
