package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$AbortCompilation extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public ERRMSG$AbortCompilation(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public ERRMSG$AbortCompilation STM$() {
        ((ERRMSG)(CUR$.SL$)).termstatus='6';
        new ERRMSG$printDiag(((ERRMSG)(CUR$.SL$)),(((((ERRMSG)(CUR$.SL$)).numerrfound>(((ERRMSG)(CUR$.SL$)).maxerrno$1)))?(new TXT$("*** COMPILATION STOPPED: Too many errors ***")):((((((ERRMSG)(CUR$.SL$)).numerrfound==(0)))?(new TXT$("*** COMPILATION ABORTED ***")):(new TXT$("*** COMPILATION CANNOT CONTINUE ***"))))));
        rts_utility(1,0);
        ((ERRMSG)(CUR$.SL$)).ENDCOMP$0().CPF();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure AbortCompilation",1,988,14,991,16,996,18,997,20,999,24,1000);
}
