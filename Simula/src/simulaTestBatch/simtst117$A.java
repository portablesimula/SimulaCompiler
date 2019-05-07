package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 12:03:18 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst117$A extends CLASS$ {
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    public TXT$ p$id;
    public simtst117$A(RTObject$ staticLink,TXT$ sp$id) {
        super(staticLink);
        this.p$id = sp$id;
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("A",8);
    }
    public simtst117$A STM$() {
        new simtst117$Print(((simtst117)(CUR$.SL$)),CONC(CONC(new TXT$("Event A("),p$id),new TXT$(")-1: Just Before First Detach")));
        detach();
        new simtst117$Print(((simtst117)(CUR$.SL$)),CONC(CONC(new TXT$("Event A("),p$id),new TXT$(")-2: Just Before Second Detach")));
        detach();
        if(VALUE$((((simtst117)(CUR$.SL$)).y!=(null)))) {
            {
                new simtst117$Print(((simtst117)(CUR$.SL$)),CONC(CONC(new TXT$("Event A("),p$id),new TXT$(")-3: Just Before Resume(y)")));
                resume(((simtst117)(CUR$.SL$)).y);
            }
        }
        new simtst117$Print(((simtst117)(CUR$.SL$)),CONC(CONC(new TXT$("Event A("),p$id),new TXT$(")-4: Just Before Final-END")));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst117.sim","Class A",1,8,17,9,19,10,21,11,23,12,25,13,27,15,30,16,34,18,36,9,39,19);
}
