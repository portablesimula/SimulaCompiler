package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 15:12:53 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class MainSeparat$P extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public float RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public MainSeparat$P(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public MainSeparat$P STM$() {
        new MainSeparat$trace(((MainSeparat)(CUR$.SL$)),new TXT$("In Procedure P"));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ExternalClass1.sim","Procedure P",1,73,16,75,20,76);
}
