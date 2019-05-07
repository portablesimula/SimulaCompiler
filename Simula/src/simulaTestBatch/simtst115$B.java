package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 05 12:01:55 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst115$B extends simtst115$A {
    public int prefixLevel() { return(1); }
    final LABQNT$ L=new LABQNT$(this,2,"L");
    public final TXT$ ident$1=(TXT$)(new TXT$("CLASS B"));
    public PRCQNT$ S$0() { return(new PRCQNT$(this,simtst115$B$S.class)); }
    public simtst115$B(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("B",41);
    }
    public simtst115$B STM$() {
        simtst115$B THIS$=(simtst115$B)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                new simtst115$trace(((simtst115)(CUR$.SL$)),new TXT$("In A before inner"));
                GOTO$(((LABQNT$)(((simtst115$A)CUR$).S$0().CPF().setPar(new NAME$<Integer>(){ public Integer get() { return(2); } }).ENT$().RESULT$())));
                new simtst115$trace(((simtst115)(CUR$.SL$)),new TXT$("In B before inner"));
                LABEL$(2,"L");
                new simtst115$trace(((simtst115)(CUR$.SL$)),new TXT$("At Label L - OK"));
                new simtst115$trace(((simtst115)(CUR$.SL$)),new TXT$("In B after inner"));
                LABEL$(1,"L2");
                new simtst115$trace(((simtst115)(CUR$.SL$)),new TXT$("In A after inner"));
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst115.sim","Class B",1,38,8,43,10,41,22,32,24,33,26,42,28,43,31,45,33,35,36,45,50,46);
}
