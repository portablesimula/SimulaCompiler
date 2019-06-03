package simulaTestBatch;
// Simula-1.0 Compiled at Sun Jun 02 12:51:11 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst41$$teller extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public simtst41$$teller(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst41$$teller STM$() {
        RESULT$=((simtst41$)(CUR$.SL$)).i=Math.addExact(((simtst41$)(CUR$.SL$)).i,1);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst41.sim","Procedure teller",1,19,16,20,20,20);
}
