package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 17:11:35 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr03$ExceptionHandler extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$ErrorText;
    private int $npar=0; // Number of actual parameters transmitted.
    public simerr03$ExceptionHandler setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$ErrorText=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simerr03$ExceptionHandler(RTObject$ SL$)
    { super(SL$); }
    public simerr03$ExceptionHandler(RTObject$ SL$,TXT$ sp$ErrorText) {
        super(SL$);
        this.p$ErrorText = sp$ErrorText;
        BBLK();
        STM$();
    }
    public simerr03$ExceptionHandler STM$() {
        new simerr03$trace(((simerr03)(CUR$.SL$)),CONC(new TXT$("ExceptionHandler got error: "),p$ErrorText));
        if(VALUE$(((simerr03)(CUR$.SL$)).found_error)) {
            sysout().outtext(CONC(new TXT$("GOT ERROR(S) IN"),((simerr03)(CUR$.SL$)).CASE$));
        } else
        sysout().outtext(CONC(new TXT$("--- NO ERRORS FOUND IN"),((simerr03)(CUR$.SL$)).CASE$));
        if(VALUE$(((simerr03)(CUR$.SL$)).verbose)) {
            {
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("--- END SIMULA"),((simerr03)(CUR$.SL$)).CASE$));
                sysout().outimage();
            }
        }
        terminate_program();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr03.sim","Procedure ExceptionHandler",1,32,29,34,31,35,33,37,37,39,39,40,42,41,44,42,48,44,52,45);
}
