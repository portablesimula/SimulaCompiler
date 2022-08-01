package simulaTestBatch;
// Simula-2.0 Compiled at Fri Sep 03 09:27:42 CEST 2021
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr01$$ExceptionHandler extends PROC$ {
    public TXT$ p$ErrorText;
    public simerr01$$ExceptionHandler setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$ErrorText=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simerr01$$ExceptionHandler(RTObject$ SL$) {
        super(SL$,1);
    }
    public simerr01$$ExceptionHandler(RTObject$ SL$,TXT$ sp$ErrorText) {
        super(SL$);
        this.p$ErrorText = sp$ErrorText;
        BBLK();
        STM$();
    }
    public simerr01$$ExceptionHandler STM$() {
        new simerr01$$trace((CUR$.SL$),CONC(new TXT$("ExceptionHandler got error: "),p$ErrorText));
        ;
        if(VALUE$(((simerr01$)(CUR$.SL$)).found_error)) {
            sysout().outtext(CONC(new TXT$("GOT ERROR(S) IN"),((simerr01$)(CUR$.SL$)).CASE$));
        } else
        sysout().outtext(CONC(new TXT$("--- NO ERRORS FOUND IN"),((simerr01$)(CUR$.SL$)).CASE$));
        ;
        if(VALUE$(((simerr01$)(CUR$.SL$)).verbose)) {
            {
                sysout().outimage();
                ;
                sysout().outtext(CONC(new TXT$("--- END SIMULA"),((simerr01$)(CUR$.SL$)).CASE$));
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        terminate_program();
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr01.sim","Procedure ExceptionHandler",1,29,28,31,31,32,33,34,38,36,40,37,44,38,47,39,53,41,58,42);
}
