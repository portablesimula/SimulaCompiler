package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 17:16:56 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr04$ExceptionHandler extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$ErrorText;
    private int $npar=0; // Number of actual parameters transmitted.
    public simerr04$ExceptionHandler setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$ErrorText=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simerr04$ExceptionHandler(RTObject$ SL$)
    { super(SL$); }
    public simerr04$ExceptionHandler(RTObject$ SL$,TXT$ sp$ErrorText) {
        super(SL$);
        this.p$ErrorText = sp$ErrorText;
        BBLK();
        STM$();
    }
    public simerr04$ExceptionHandler STM$() {
        new simerr04$trace(((simerr04)(CUR$.SL$)),CONC(new TXT$("ExceptionHandler got error: "),p$ErrorText));
        if(VALUE$(((simerr04)(CUR$.SL$)).found_error)) {
            sysout().outtext(CONC(new TXT$("GOT ERROR(S) IN"),((simerr04)(CUR$.SL$)).CASE$));
        } else
        sysout().outtext(CONC(new TXT$("--- NO ERRORS FOUND IN"),((simerr04)(CUR$.SL$)).CASE$));
        if(VALUE$(((simerr04)(CUR$.SL$)).verbose)) {
            {
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("--- END SIMULA"),((simerr04)(CUR$.SL$)).CASE$));
                sysout().outimage();
            }
        }
        terminate_program();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr04.sim","Procedure ExceptionHandler",1,30,29,32,31,33,33,35,37,37,39,38,42,39,44,40,48,42,52,43);
}
