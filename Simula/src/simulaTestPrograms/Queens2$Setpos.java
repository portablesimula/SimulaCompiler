package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:26:23 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Queens2$Setpos extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$Line;
    public int p$Pos;
    private int $npar=0; // Number of actual parameters transmitted.
    public Queens2$Setpos setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$Line=intValue(param); break;
                case 1: p$Pos=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public Queens2$Setpos(RTObject$ SL$)
    { super(SL$); }
    public Queens2$Setpos(RTObject$ SL$,int sp$Line,int sp$Pos) {
        super(SL$);
        this.p$Line = sp$Line;
        this.p$Pos = sp$Pos;
        BBLK();
        STM$();
    }
    public Queens2$Setpos STM$() {
        if(VALUE$((p$Line<(10)))) {
            {
                TXT$.putint(TXT$.sub(((Queens2)(CUR$.SL$)).OUTPOS,4,1),p$Line);
                ASGSTR$(TXT$.sub(((Queens2)(CUR$.SL$)).OUTPOS,3,1),"0");
            }
        } else
        TXT$.putint(TXT$.sub(((Queens2)(CUR$.SL$)).OUTPOS,3,2),p$Line);
        if(VALUE$((p$Pos<(10)))) {
            {
                TXT$.putint(TXT$.sub(((Queens2)(CUR$.SL$)).OUTPOS,7,1),p$Pos);
                ASGSTR$(TXT$.sub(((Queens2)(CUR$.SL$)).OUTPOS,6,1),"0");
            }
        } else
        TXT$.putint(TXT$.sub(((Queens2)(CUR$.SL$)).OUTPOS,6,2),p$Pos);
        sysout().outtext(((Queens2)(CUR$.SL$)).OUTPOS);
        sysout().breakoutimage();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Queens2.sim","Procedure Setpos",1,5,32,6,34,7,40,8,42,9,44,10,50,11,52,12,57,13);
}
