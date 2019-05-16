package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 17:00:11 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr02$ExceptionHandler extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$ErrorText;
    private int $npar=0; // Number of actual parameters transmitted.
    public simerr02$ExceptionHandler setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$ErrorText=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simerr02$ExceptionHandler(RTObject$ SL$)
    { super(SL$); }
    public simerr02$ExceptionHandler(RTObject$ SL$,TXT$ sp$ErrorText) {
        super(SL$);
        this.p$ErrorText = sp$ErrorText;
        BBLK();
        STM$();
    }
    public simerr02$ExceptionHandler STM$() {
        new simerr02$trace(((simerr02)(CUR$.SL$)),CONC(new TXT$("ExceptionHandler got error: "),p$ErrorText));
        if(VALUE$(((simerr02)(CUR$.SL$)).found_error)) {
            sysout().outtext(CONC(new TXT$("GOT ERROR(S) IN"),((simerr02)(CUR$.SL$)).CASE$));
        } else
        sysout().outtext(CONC(new TXT$("--- NO ERRORS FOUND IN"),((simerr02)(CUR$.SL$)).CASE$));
        if(VALUE$(((simerr02)(CUR$.SL$)).verbose)) {
            {
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("--- END SIMULA"),((simerr02)(CUR$.SL$)).CASE$));
                sysout().outimage();
            }
        }
        terminate_program();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr02.sim","Procedure ExceptionHandler",1,34,29,36,31,37,33,39,37,41,39,42,42,43,44,44,48,46,52,47);
}
