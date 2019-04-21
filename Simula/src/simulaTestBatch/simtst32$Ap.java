package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Fri Apr 19 09:17:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst32$Ap extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$i;
    public float p$r;
    public boolean p$bool;
    public char p$ch;
    public simtst32$A p$ra;
    public TXT$ p$t;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst32$Ap setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$i=intValue(param); break;
                case 1: p$r=floatValue(param); break;
                case 2: p$bool=(boolean)objectValue(param); break;
                case 3: p$ch=(char)objectValue(param); break;
                case 4: p$ra=(simtst32$A)objectValue(param); break;
                case 5: p$t=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst32$Ap(RTObject$ SL$)
    { super(SL$); }
    public simtst32$Ap(RTObject$ SL$,int sp$i,float sp$r,boolean sp$bool,char sp$ch,simtst32$A sp$ra,TXT$ sp$t) {
        super(SL$);
        this.p$i = sp$i;
        this.p$r = sp$r;
        this.p$bool = sp$bool;
        this.p$ch = sp$ch;
        this.p$ra = sp$ra;
        this.p$t = sp$t;
        BBLK();
        STM$();
    }
    public simtst32$Ap STM$() {
        ((simtst32)(CUR$.SL$)).gi=p$i;
        ((simtst32)(CUR$.SL$)).gr=p$r;
        ((simtst32)(CUR$.SL$)).gbool=p$bool;
        ((simtst32)(CUR$.SL$)).gch=p$ch;
        ((simtst32)(CUR$.SL$)).gra=p$ra;
        ((simtst32)(CUR$.SL$)).gtext=p$t;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst32.sim","Procedure Ap",1,45,44,53,46,54,48,55,50,56,52,57,54,58,58,59);
}
