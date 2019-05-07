package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 05 12:42:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst112$B extends simtst112$A {
    public int prefixLevel() { return(1); }
    final LABQNT$ L=new LABQNT$(this,1,"L");
    public final TXT$ ident$1=(TXT$)(new TXT$("CLASS B"));
    public PRCQNT$ goto_L$0() { return(new PRCQNT$(this,simtst112$B$goto_L.class)); }
    public simtst112$B(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("B",43);
    }
    public simtst112$B STM$() {
        simtst112$B THIS$=(simtst112$B)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                new simtst112$trace(((simtst112)(CUR$.SL$)),new TXT$("In A before inner"));
                ((simtst112$A)CUR$).goto_L$0().CPF();
                new simtst112$trace(((simtst112)(CUR$.SL$)),new TXT$("In B before inner"));
                LABEL$(1,"L");
                new simtst112$trace(((simtst112)(CUR$.SL$)),new TXT$("In B At Label L - OK"));
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst112.sim","Class B",1,37,8,47,10,39,22,31,24,32,26,46,28,47,31,49,33,34,35,49,49,50);
}
