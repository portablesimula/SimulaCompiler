package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:36 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$getBox extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public COMMON$symbolbox RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$i;
    private int $npar=0; // Number of actual parameters transmitted.
    public COMMON$getBox setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$i=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public COMMON$getBox(RTObject$ SL$)
    { super(SL$); }
    public COMMON$getBox(RTObject$ SL$,int sp$i) {
        super(SL$);
        this.p$i = sp$i;
        BBLK();
        STM$();
    }
    public COMMON$getBox STM$() {
        RESULT$=((ARRAY$<COMMON$symbolbox[]>)((COMMON)(CUR$.SL$)).symtab.Elt[(p$i/(256))-((COMMON)(CUR$.SL$)).symtab.LB[0]].val).Elt[rem(p$i,256)-((COMMON)(CUR$.SL$)).symtab.Elt[(p$i/(256))-((COMMON)(CUR$.SL$)).symtab.LB[0]].val.LB[0]];
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure getBox",1,126,31,128,35,129);
}
