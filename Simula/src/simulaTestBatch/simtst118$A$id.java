package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 12:03:20 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst118$A$id extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public simtst118$A$id(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst118$A$id STM$() {
        RESULT$=new simtst118$edIdent(((simtst118)(CUR$.SL$.SL$)),'A',((simtst118$A)(CUR$.SL$)).ord).RESULT$;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst118.sim","Procedure id",1,20,19,20);
}
