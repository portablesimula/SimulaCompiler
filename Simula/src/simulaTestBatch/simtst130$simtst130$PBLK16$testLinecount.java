package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testLinecount extends PROC$ {
    public simtst130$simtst130$PBLK16$testLinecount(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testLinecount STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("BEGIN TEST linecount --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        new simtst130$simtst130$PBLK16$testLinecount$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).pf$1,(-(1)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).pf$1=new printfile$(CTX$,new TXT$("simtst130-TEMP")).STM$();
        ;
        new simtst130$simtst130$PBLK16$testLinecount$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).pf$1,(-(2)));
        ;
        ((simtst130$PBLK16)(CUR$.SL$)).pf$1.open(ENVIRONMENT$.blanks(80));
        ;
        new simtst130$simtst130$PBLK16$testLinecount$test((CUR$),((simtst130$PBLK16)(CUR$.SL$)).pf$1,sysout().linesperpage(0));
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$),CONC(new TXT$("ENDOF TEST linecount --------------------------------------------------- nFailed="),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$.SL$)).nFailed)));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testLinecount",1,741,13,763,16,764,19,765,22,766,25,767,28,768,31,769,36,771);
}
