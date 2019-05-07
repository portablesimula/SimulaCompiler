package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 05 12:42:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst112$C extends simtst112$B {
    public int prefixLevel() { return(2); }
    public simtst112$C(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("C",52);
    }
    public simtst112$C STM$() {
        simtst112$C THIS$=(simtst112$C)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                new simtst112$trace(((simtst112)(CUR$.SL$)),new TXT$("In A before inner"));
                ((simtst112$A)CUR$).goto_L$0().CPF();
                new simtst112$trace(((simtst112)(CUR$.SL$)),new TXT$("In B before inner"));
                LABEL$(1,"L");
                new simtst112$trace(((simtst112)(CUR$.SL$)),new TXT$("In B At Label L - OK"));
                new simtst112$trace(((simtst112)(CUR$.SL$)),new TXT$("In C before inner"));
                new simtst112$trace(((simtst112)(CUR$.SL$)),new TXT$("In C after inner"));
                new simtst112$trace(((simtst112)(CUR$.SL$)),new TXT$("In B after inner"));
                new simtst112$trace(((simtst112)(CUR$.SL$)),new TXT$("In A after inner"));
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    CUR$.STATE$=OperationalState.terminated;
                    throw(q);
                }
                JTX$=q.index; continue LOOP$;
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst112.sim","Class C",1,52,17,31,19,32,21,46,23,47,26,54,28,56,30,49,32,34,34,56,48,57);
}
