package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:36 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$attrfile$wrongLayout extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public COMMON$attrfile$wrongLayout(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public COMMON$attrfile$wrongLayout STM$() {
        ((COMMON)(CUR$.SL$.SL$)).diag.Elt[0-((COMMON)(CUR$.SL$.SL$)).diag.LB[0]]=((COMMON$attrfile)(CUR$.SL$)).CURF.filename();
        ((COMMON)(CUR$.SL$.SL$)).COMMONerror$0().CPF().setPar(308).ENT$();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure wrongLayout",1,1255,14,1256,19,1256);
}
