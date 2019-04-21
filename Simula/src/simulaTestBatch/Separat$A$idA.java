package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Apr 21 13:18:11 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Separat$A$idA extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public Separat$A$idA(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Separat$A$idA STM$() {
        RESULT$=new Separat$edIdent(((Separat)(CUR$.SL$.SL$)),'A',((Separat$A)(CUR$.SL$)).ord).RESULT$;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Separat.sim","Procedure idA",1,36,19,36);
}
