package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat May 04 14:52:24 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst111$B extends simtst111$A {
    public int prefixLevel() { return(1); }
    public LABQNT$ L$0() { return(new LABQNT$(this,1,"L")); }
    public final TXT$ ident$1=(TXT$)(new TXT$("CLASS B"));
    public simtst111$B(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("B",40);
    }
    public simtst111$B STM$() {
        simtst111$B THIS$=(simtst111$B)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                new simtst111$trace(((simtst111)(CUR$.SL$)),new TXT$("In A before inner"));
                GOTO$(L$0());
                new simtst111$trace(((simtst111)(CUR$.SL$)),new TXT$("In B before inner"));
                LABEL$(1,"L");
                new simtst111$trace(((simtst111)(CUR$.SL$)),new TXT$("At Label L - OK"));
                new simtst111$trace(((simtst111)(CUR$.SL$)),new TXT$("In B after inner"));
                new simtst111$trace(((simtst111)(CUR$.SL$)),new TXT$("In A after inner"));
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst111.sim","Class B",1,38,8,42,10,40,21,32,23,33,25,41,27,42,30,44,32,35,34,44,48,45);
}
