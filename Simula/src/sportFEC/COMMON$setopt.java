package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Apr 14 09:36:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$setopt extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public char p$ch;
    public char p$val;
    private int $npar=0; // Number of actual parameters transmitted.
    public COMMON$setopt setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$ch=(char)objectValue(param); break;
                case 1: p$val=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public COMMON$setopt(RTObject$ SL$)
    { super(SL$); }
    public COMMON$setopt(RTObject$ SL$,char sp$ch,char sp$val) {
        super(SL$);
        this.p$ch = sp$ch;
        this.p$val = sp$val;
        BBLK();
        STM$();
    }
    public COMMON$setopt STM$() {
        if(VALUE$((p$ch<(((char)128))))) {
            {
                if(VALUE$((p$ch>('_')))) {
                    p$ch=char$((rank(p$ch)-(32)));
                }
                ((COMMON)(CUR$.SL$)).option.Elt[rank(p$ch)-((COMMON)(CUR$.SL$)).option.LB[0]]=p$val;
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure setopt",1,276,32,277,34,278,39,279,45,280);
}
