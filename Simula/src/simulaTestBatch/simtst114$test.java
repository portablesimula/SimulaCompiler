package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 10:27:35 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst114$test extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$key;
    public TXT$ p$msg;
    final LABQNT$ BREAK$=new LABQNT$(this,1,"BREAK$");
    final int lowKey=(int)(0);
    final int hiKey=(int)(5);
    final int case1=(int)(1);
    final int case2=(int)(2);
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst114$test setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$key=intValue(param); break;
                case 1: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst114$test(RTObject$ SL$)
    { super(SL$); }
    public simtst114$test(RTObject$ SL$,int sp$key,TXT$ sp$msg) {
        super(SL$);
        this.p$key = sp$key;
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public simtst114$test STM$() {
        simtst114$test THIS$=(simtst114$test)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                switch(p$key) { // BEGIN SWITCH STATEMENT
                case 1: 
                {
                    new simtst114$trace(((simtst114)(CUR$.SL$)),CONC(p$msg,new TXT$(" selected case 1")));
                    GOTO$(BREAK$);
                }
                case 2: 
                {
                    new simtst114$trace(((simtst114)(CUR$.SL$)),CONC(p$msg,new TXT$(" selected case 2")));
                    GOTO$(BREAK$);
                }
                case 3: 
                {
                    new simtst114$trace(((simtst114)(CUR$.SL$)),CONC(p$msg,new TXT$(" selected case 3")));
                    GOTO$(BREAK$);
                }
                default:
                {
                    new simtst114$trace(((simtst114)(CUR$.SL$)),CONC(p$msg,new TXT$(" selected case NONE")));
                    GOTO$(((simtst114)(CUR$.SL$)).NOMORE);
                }
            } // END SWITCH STATEMENT
            LABEL$(1,"BREAK$");
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
public static PROGINFO$ INFO$=new PROGINFO$("simtst114.sim","Procedure test",1,27,10,56,12,29,14,30,16,31,18,32,46,34,49,37,52,38,56,42,59,43,63,47,66,48,70,52,73,53,77,56,92,56);
}
