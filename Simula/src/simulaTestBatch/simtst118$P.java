package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 12:03:20 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst118$P extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public float RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public simtst118$P(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst118$P STM$() {
        sysout().outtext(new TXT$("Event P-1: Just Before First Resume: "));
        sysout().outtext(new TXT$(" x="));
        sysout().outtext((((((simtst118)(CUR$.SL$)).x!=(null)))?(new simtst118$A$id(((simtst118)(CUR$.SL$)).x).RESULT$):(new TXT$("none"))));
        sysout().outtext(new TXT$(" y="));
        sysout().outtext((((((simtst118)(CUR$.SL$)).y!=(null)))?(new simtst118$B$id(((simtst118)(CUR$.SL$)).y).RESULT$):(new TXT$("none"))));
        sysout().outimage();
        if(VALUE$((((simtst118)(CUR$.SL$)).x!=(null)))) {
            {
                new simtst118$Print(((simtst118)(CUR$.SL$)),CONC(new TXT$("Event P-2: Just Before First Resume: "),new simtst118$A$id(((simtst118)(CUR$.SL$)).x).RESULT$));
                resume(((simtst118)(CUR$.SL$)).x);
            }
        }
        new simtst118$Print(((simtst118)(CUR$.SL$)),new TXT$("C"));
        if(VALUE$((((simtst118)(CUR$.SL$)).y!=(null)))) {
            {
                new simtst118$Print(((simtst118)(CUR$.SL$)),CONC(new TXT$("Event P-3: Just Before Second Resume: "),new simtst118$B$id(((simtst118)(CUR$.SL$)).y).RESULT$));
                resume(((simtst118)(CUR$.SL$)).y);
            }
        }
        new simtst118$Print(((simtst118)(CUR$.SL$)),new TXT$("D"));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst118.sim","Procedure P",1,43,16,45,18,46,21,47,24,48,26,50,28,52,31,53,35,55,37,56,39,58,42,59,46,61,50,62);
}
