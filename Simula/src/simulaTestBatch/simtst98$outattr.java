package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Apr 13 09:06:30 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst98$outattr extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$line;
    public TXT$ p$t;
    public int p$i;
    public int p$expected;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst98$outattr setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$line=intValue(param); break;
                case 1: p$t=(TXT$)objectValue(param); break;
                case 2: p$i=intValue(param); break;
                case 3: p$expected=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst98$outattr(RTObject$ SL$)
    { super(SL$); }
    public simtst98$outattr(RTObject$ SL$,int sp$line,TXT$ sp$t,int sp$i,int sp$expected) {
        super(SL$);
        this.p$line = sp$line;
        this.p$t = sp$t;
        this.p$i = sp$i;
        this.p$expected = sp$expected;
        BBLK();
        STM$();
    }
    public simtst98$outattr STM$() {
        if(VALUE$(((p$i!=(p$expected))|(((simtst98)(CUR$.SL$)).trace)))) {
            {
                if(VALUE$((p$i!=(p$expected)))) {
                    {
                        sysout().outtext(((simtst98)(CUR$.SL$)).programpoint);
                        sysout().outimage();
                    }
                }
                sysout().outtext(new TXT$("- l."));
                sysout().outint(p$line,4);
                sysout().outtext(new TXT$(": "));
                sysout().outtext(p$t);
                sysout().outint(p$i,3);
                if(VALUE$((p$i!=(p$expected)))) {
                    {
                        ((simtst98)(CUR$.SL$)).errorFound=true;
                        sysout().setpos(57);
                        sysout().outtext(new TXT$(" WRONG! - should be:"));
                        sysout().outint(p$expected,3);
                    }
                }
                sysout().outimage();
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst98.sim","Procedure outattr",1,27,38,29,40,30,43,31,49,32,53,33,56,34,60,35,63,36,67,37,73,38);
}
