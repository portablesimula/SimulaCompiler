package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:40:57 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HexDump$PrtHex extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$i;
    public int p$n;
    TXT$ t=null;
    int h=0;
    private int $npar=0; // Number of actual parameters transmitted.
    public HexDump$PrtHex setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$i=intValue(param); break;
                case 1: p$n=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HexDump$PrtHex(RTObject$ SL$)
    { super(SL$); }
    public HexDump$PrtHex(RTObject$ SL$,int sp$i,int sp$n) {
        super(SL$);
        this.p$i = sp$i;
        this.p$n = sp$n;
        BBLK();
        STM$();
    }
    public HexDump$PrtHex STM$() {
        t=blanks(p$n);
        while((p$n>(0))) {
            {
                h=(mod(p$i,16)+(48));
                p$i=(p$i/(16));
                if(VALUE$((h>(57)))) {
                    h=(h+(7));
                }
                TXT$.setpos(t,p$n);
                TXT$.putchar(t,char$(h));
                p$n=(p$n-(1));
            }
        }
        sysout().outtext(t);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HexDump.sim","Procedure PrtHex",1,31,10,32,36,33,38,34,45,35,51,36,55,37);
}
