package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testLinecount$linecount1$SubBlock749 extends BASICIO$ {
    public int count=0;
    public simtst130$simtst130$PBLK16$testLinecount$linecount1$SubBlock749(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
    }
    public RTObject$ STM$() {
        count=sysout().linesperpage(0);
        ;
        sysout().linesperpage(count);
        ;
        ((simtst130$simtst130$PBLK16$testLinecount$linecount1)(CUR$.SL$)).RESULT$=count;
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","SubBlock SubBlock749",1,747,17,748,22,749);
}
