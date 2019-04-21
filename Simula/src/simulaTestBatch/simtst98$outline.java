package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Apr 13 09:06:30 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst98$outline extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$head;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst98$outline setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$head=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst98$outline(RTObject$ SL$)
    { super(SL$); }
    public simtst98$outline(RTObject$ SL$,TXT$ sp$head) {
        super(SL$);
        this.p$head = sp$head;
        BBLK();
        STM$();
    }
    public simtst98$outline STM$() {
        ((simtst98)(CUR$.SL$)).programpoint=p$head;
        if(VALUE$(((simtst98)(CUR$.SL$)).trace)) {
            {
                sysout().outimage();
                sysout().outtext(p$head);
                sysout().outimage();
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst98.sim","Procedure outline",1,42,29,43,31,44,41,45);
}
