package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544$getCharacter extends PROC$ {
    public char RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544$getCharacter(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544$getCharacter STM$() {
        if(VALUE$(TXT$.more(((simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544)(CUR$.SL$)).t))) {
            RESULT$=((simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544)(CUR$.SL$)).window=TXT$.getchar(((simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544)(CUR$.SL$)).t);
        } else
        GOTO$(((simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544)(CUR$.SL$)).LABEL$out);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure getCharacter",1,525,15,526,17,527,23,527);
}
