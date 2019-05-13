package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$COMMONerror extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$EXC_NUMBER;
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$COMMONerror setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$EXC_NUMBER=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public ERRMSG$COMMONerror(RTObject$ SL$)
    { super(SL$); }
    public ERRMSG$COMMONerror(RTObject$ SL$,int sp$EXC_NUMBER) {
        super(SL$);
        this.p$EXC_NUMBER = sp$EXC_NUMBER;
        BBLK();
        STM$();
    }
    public ERRMSG$COMMONerror STM$() {
        if(VALUE$((p$EXC_NUMBER>(0)))) {
            new ERRMSG$fatal0(((ERRMSG)(CUR$.SL$)),p$EXC_NUMBER);
        } else
        {
            p$EXC_NUMBER=(-(p$EXC_NUMBER));
            if(VALUE$((p$EXC_NUMBER==(106)))) {
                {
                    sysout().outtext(new TXT$("*** NO MORE DISK or FILE SPACE ***"));
                }
            } else
            {
                if(VALUE$((p$EXC_NUMBER==(11)))) {
                    {
                        sysout().outtext(new TXT$("*** COMPILATION KILLED"));
                    }
                } else
                {
                    if(VALUE$((((ERRMSG)(CUR$.SL$)).numerrfound==(0)))) {
                        {
                            sysout().outtext(new TXT$("*** INTERNAL ERROR (RTS error #"));
                            sysout().outint(p$EXC_NUMBER,0);
                            sysout().outtext(new TXT$(")"));
                        }
                    } else
                    sysout().outtext(new TXT$("*** Compiler cannot recover, ABORT"));
                    if(VALUE$((((ERRMSG)(CUR$.SL$)).linenr>(0)))) {
                        {
                            sysout().outtext(new TXT$(" at source line "));
                            sysout().outint(((ERRMSG)(CUR$.SL$)).linenr,0);
                        }
                    }
                    sysout().outtext((((((ERRMSG)(CUR$.SL$)).currentpass==('1')))?(new TXT$(" (Pass1) ***")):(new TXT$(" (Pass2) ***"))));
                }
                if(VALUE$(((((ERRMSG)(CUR$.SL$)).listfile!=(null))&&((((ERRMSG)(CUR$.SL$)).listfile!=(sysout())))))) {
                    {
                        ((ERRMSG)(CUR$.SL$)).listfile.outtext(TXT$.strip(sysout().image));
                        ((ERRMSG)(CUR$.SL$)).listfile.outimage();
                    }
                }
            }
            sysout().outimage();
            rts_utility(1,0);
            ((ERRMSG)(CUR$.SL$)).ENDCOMP$0().CPF();
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure COMMONerror",1,213,29,215,31,216,36,217,38,219,43,222,46,223,51,226,54,227,57,228,62,230,64,231,66,232,72,235,75,237,77,238,84,241,86,242,88,243,93,244);
}
