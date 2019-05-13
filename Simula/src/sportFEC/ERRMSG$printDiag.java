package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:37 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$printDiag extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$t;
    PrintFile$ inspect$54$6=null;
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$printDiag setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$t=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public ERRMSG$printDiag(RTObject$ SL$)
    { super(SL$); }
    public ERRMSG$printDiag(RTObject$ SL$,TXT$ sp$t) {
        super(SL$);
        this.p$t = sp$t;
        BBLK();
        STM$();
    }
    public ERRMSG$printDiag STM$() {
        if(VALUE$(TRF_NE(p$t,null))) {
            {
                sysout().outtext(p$t);
                sysout().outimage();
                if(VALUE$((((ERRMSG)(CUR$.SL$)).listfile!=(sysout())))) {
                    {
                        inspect$54$6=((ERRMSG)(CUR$.SL$)).listfile;
                        if(inspect$54$6!=null)
                        {
                            inspect$54$6.outtext(p$t);
                            inspect$54$6.outimage();
                        }
                    }
                }
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure printDiag",1,51,9,54,31,52,33,53,37,54,42,55,53,57);
}
