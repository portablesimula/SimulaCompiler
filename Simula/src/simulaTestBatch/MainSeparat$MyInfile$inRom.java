package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 15:12:53 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class MainSeparat$MyInfile$inRom extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    FILE$ myFile=null;
    public MainSeparat$MyInfile$inRom(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public MainSeparat$MyInfile$inRom STM$() {
        myFile=((FILE$)(((MainSeparat$MyInfile)(CUR$.SL$)).pvirt$4().CPF().setPar(4).setPar(3).ENT$().RESULT$()));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ExternalClass1.sim","Procedure inRom",1,50,10,52,18,53,22,54);
}
