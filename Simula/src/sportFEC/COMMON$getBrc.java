package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:36 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$getBrc extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public COMMON$brecord RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public char p$blnohi;
    public char p$blnolo;
    private int $npar=0; // Number of actual parameters transmitted.
    public COMMON$getBrc setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$blnohi=(char)objectValue(param); break;
                case 1: p$blnolo=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public COMMON$getBrc(RTObject$ SL$)
    { super(SL$); }
    public COMMON$getBrc(RTObject$ SL$,char sp$blnohi,char sp$blnolo) {
        super(SL$);
        this.p$blnohi = sp$blnohi;
        this.p$blnolo = sp$blnolo;
        BBLK();
        STM$();
    }
    public COMMON$getBrc STM$() {
        RESULT$=((ARRAY$<COMMON$brecord[]>)((COMMON)(CUR$.SL$)).brctab.Elt[rank(p$blnohi)-((COMMON)(CUR$.SL$)).brctab.LB[0]].val).Elt[rank(p$blnolo)-((COMMON)(CUR$.SL$)).brctab.Elt[rank(p$blnohi)-((COMMON)(CUR$.SL$)).brctab.LB[0]].val.LB[0]];
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure getBrc",1,1178,34,1182,38,1183);
}
