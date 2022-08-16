package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testCheckextension extends PROC$ {
    public simtst130$simtst130$PBLK16$testCheckextension(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testCheckextension STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST checkextension --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        new simtst130$simtst130$PBLK16$testCheckextension$test((CUR$),new TXT$("FileName"),new TXT$(".txt"),new TXT$("FileName.txt"));
        ;
        new simtst130$simtst130$PBLK16$testCheckextension$test((CUR$),new TXT$("FileName.data"),new TXT$(".txt"),new TXT$("FileName.data"));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST checkextension --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testCheckextension",1,128,13,135,16,136,19,137,22,138,27,140);
}
