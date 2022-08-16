package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testMaketext$maketext1$SubBlock799 extends BASICIO$ {
    public TXT$ t=null;
    public simtst130$simtst130$PBLK16$testMaketext$maketext1$SubBlock799(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
    }
    public RTObject$ STM$() {
        t=ENVIRONMENT$.blanks(((simtst130$simtst130$PBLK16$testMaketext$maketext1)(CUR$.SL$)).p$n);
        ;
        while(TXT$.more(t)) {
            TXT$.putchar(t,((simtst130$simtst130$PBLK16$testMaketext$maketext1)(CUR$.SL$)).p$ch);
        }
        ;
        TXT$.setpos(t,1);
        ;
        ((simtst130$simtst130$PBLK16$testMaketext$maketext1)(CUR$.SL$)).RESULT$=t;
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","SubBlock SubBlock799",1,796,15,797,20,798,27,799);
}
