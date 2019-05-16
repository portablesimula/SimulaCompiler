package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 16:39:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr01$ExceptionHandler extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$ErrorText;
    private int $npar=0; // Number of actual parameters transmitted.
    public simerr01$ExceptionHandler setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$ErrorText=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simerr01$ExceptionHandler(RTObject$ SL$)
    { super(SL$); }
    public simerr01$ExceptionHandler(RTObject$ SL$,TXT$ sp$ErrorText) {
        super(SL$);
        this.p$ErrorText = sp$ErrorText;
        BBLK();
        STM$();
    }
    public simerr01$ExceptionHandler STM$() {
        new simerr01$trace(((simerr01)(CUR$.SL$)),CONC(new TXT$("ExceptionHandler got error: "),p$ErrorText));
        if(VALUE$(((simerr01)(CUR$.SL$)).found_error)) {
            sysout().outtext(CONC(new TXT$("GOT ERROR(S) IN"),((simerr01)(CUR$.SL$)).CASE$));
        } else
        sysout().outtext(CONC(new TXT$("--- NO ERRORS FOUND IN"),((simerr01)(CUR$.SL$)).CASE$));
        if(VALUE$(((simerr01)(CUR$.SL$)).verbose)) {
            {
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("--- END SIMULA"),((simerr01)(CUR$.SL$)).CASE$));
                sysout().outimage();
            }
        }
        terminate_program();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr01.sim","Procedure ExceptionHandler",1,29,29,31,31,32,33,34,37,36,39,37,42,38,44,39,48,41,52,42);
}
