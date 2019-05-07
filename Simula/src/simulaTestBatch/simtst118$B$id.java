package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 12:03:20 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst118$B$id extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public simtst118$B$id(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst118$B$id STM$() {
        RESULT$=new simtst118$edIdent(((simtst118)(CUR$.SL$.SL$)),'B',((simtst118$B)(CUR$.SL$)).ord).RESULT$;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst118.sim","Procedure id",1,34,19,34);
}
