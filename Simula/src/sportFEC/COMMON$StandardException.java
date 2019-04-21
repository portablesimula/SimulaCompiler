package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Apr 14 09:36:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$StandardException extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public COMMON$StandardException(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public COMMON$StandardException STM$() {
        DEFEXCEPTION(((COMMON)(CUR$.SL$)).EXCEPTION_HANDLER,new NAME$<Integer>(){ public Integer get() { return(((COMMON)(CUR$.SL$)).EXC_NUMBER); } public Integer put(Integer x$) { return(((COMMON)(CUR$.SL$)).EXC_NUMBER=(int)x$); } });
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure StandardException",1,1568,14,1569,18,1569);
}
