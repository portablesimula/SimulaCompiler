package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri Apr 26 11:57:49 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HexDump$PrtChar extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public char RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$n;
    private int $npar=0; // Number of actual parameters transmitted.
    public HexDump$PrtChar setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$n=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HexDump$PrtChar(RTObject$ SL$)
    { super(SL$); }
    public HexDump$PrtChar(RTObject$ SL$,int sp$n) {
        super(SL$);
        this.p$n = sp$n;
        BBLK();
        STM$();
    }
    public HexDump$PrtChar STM$() {
        RESULT$=((((p$n>(31))&((p$n<(128)))))?(char$(p$n)):('.'));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HexDump.sim","Procedure PrtChar",1,45,31,46,35,46);
}
