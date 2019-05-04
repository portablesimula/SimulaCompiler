package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat May 04 11:45:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Separat$MyInfile$inRom extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    FILE$ myFile=null;
    public Separat$MyInfile$inRom(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Separat$MyInfile$inRom STM$() {
        myFile=((FILE$)(((Separat$MyInfile)(CUR$.SL$)).pvirt$4().CPF().setPar(4).setPar(3).ENT$().RESULT$()));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ExternalClass1.sim","Procedure inRom",1,31,10,33,18,34,22,35);
}
