package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 15:12:53 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class MainSeparat$A$idA extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public MainSeparat$A$idA(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public MainSeparat$A$idA STM$() {
        RESULT$=new MainSeparat$edIdent(((MainSeparat)(CUR$.SL$.SL$)),'A',((MainSeparat$A)(CUR$.SL$)).ord).RESULT$;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ExternalClass1.sim","Procedure idA",1,60,19,60);
}
