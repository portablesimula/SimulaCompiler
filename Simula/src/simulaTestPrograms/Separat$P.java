package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat May 04 11:45:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Separat$P extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public float RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public Separat$P(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Separat$P STM$() {
        sysout().outtext(new TXT$("Event P-1: Just Before First Resume: "));
        sysout().outtext(new TXT$(" x="));
        sysout().outtext((((((Separat)(CUR$.SL$)).x!=(null)))?(new Separat$A$idA(((Separat)(CUR$.SL$)).x).RESULT$):(new TXT$("none"))));
        sysout().outtext(new TXT$(" y="));
        sysout().outtext((((((Separat)(CUR$.SL$)).y!=(null)))?(new Separat$B$idB(((Separat)(CUR$.SL$)).y).RESULT$):(new TXT$("none"))));
        sysout().outimage();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ExternalClass1.sim","Procedure P",1,54,16,56,18,57,21,58,24,59,28,61);
}
