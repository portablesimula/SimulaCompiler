package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat May 04 11:45:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Separat$B$idB extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public Separat$B$idB(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Separat$B$idB STM$() {
        RESULT$=new Separat$edIdent(((Separat)(CUR$.SL$.SL$)),'B',((Separat$B)(CUR$.SL$)).ord$1).RESULT$;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ExternalClass1.sim","Procedure idB",1,49,19,49);
}
