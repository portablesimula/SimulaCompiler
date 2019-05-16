package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 20:18:00 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr05$ExceptionHandler extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$ErrorText;
    private int $npar=0; // Number of actual parameters transmitted.
    public simerr05$ExceptionHandler setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$ErrorText=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simerr05$ExceptionHandler(RTObject$ SL$)
    { super(SL$); }
    public simerr05$ExceptionHandler(RTObject$ SL$,TXT$ sp$ErrorText) {
        super(SL$);
        this.p$ErrorText = sp$ErrorText;
        BBLK();
        STM$();
    }
    public simerr05$ExceptionHandler STM$() {
        new simerr05$trace(((simerr05)(CUR$.SL$)),CONC(new TXT$("ExceptionHandler got error: "),p$ErrorText));
        if(VALUE$(((simerr05)(CUR$.SL$)).found_error)) {
            sysout().outtext(CONC(new TXT$("GOT ERROR(S) IN"),((simerr05)(CUR$.SL$)).CASE$));
        } else
        sysout().outtext(CONC(new TXT$("--- NO ERRORS FOUND IN"),((simerr05)(CUR$.SL$)).CASE$));
        if(VALUE$(((simerr05)(CUR$.SL$)).verbose)) {
            {
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("--- END SIMULA"),((simerr05)(CUR$.SL$)).CASE$));
                sysout().outimage();
            }
        }
        terminate_program();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr05.sim","Procedure ExceptionHandler",1,33,29,35,31,36,33,38,37,40,39,41,42,42,44,43,48,45,52,46);
}
