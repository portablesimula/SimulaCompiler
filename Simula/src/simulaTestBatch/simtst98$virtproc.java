package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Apr 13 09:06:30 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst98$virtproc extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$line;
    public TXT$ p$t;
    public TXT$ p$where;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst98$virtproc setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$line=intValue(param); break;
                case 1: p$t=(TXT$)objectValue(param); break;
                case 2: p$where=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst98$virtproc(RTObject$ SL$)
    { super(SL$); }
    public simtst98$virtproc(RTObject$ SL$,int sp$line,TXT$ sp$t,TXT$ sp$where) {
        super(SL$);
        this.p$line = sp$line;
        this.p$t = sp$t;
        this.p$where = sp$where;
        BBLK();
        STM$();
    }
    public simtst98$virtproc STM$() {
        if(VALUE$((TXTREL$NE(p$t,new TXT$("global"))|(((simtst98)(CUR$.SL$)).trace)))) {
            {
                if(VALUE$(TXTREL$NE(p$t,new TXT$("global")))) {
                    {
                        ((simtst98)(CUR$.SL$)).errorFound=true;
                        sysout().outtext(((simtst98)(CUR$.SL$)).programpoint);
                        sysout().outtext(new TXT$("- error in implementation of visibility (scope) rules: "));
                        sysout().outimage();
                    }
                }
                sysout().outtext(new TXT$("- l."));
                sysout().outint(p$line,4);
                sysout().outtext(new TXT$(" - global procedure seen from within class"));
                if(VALUE$(TXTREL$NE(p$t,new TXT$("global")))) {
                    sysout().outtext(new TXT$(" should have been invis."));
                }
                sysout().outimage();
                sysout().outtext(new TXT$("   Called from within "));
                sysout().outtext(p$where);
                sysout().outimage();
                sysout().outtext(new TXT$("   with parameter "));
                sysout().outtext(p$t);
                sysout().outimage();
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst98.sim","Procedure virtproc",1,47,35,48,37,49,42,50,44,52,49,54,52,55,54,56,56,57,59,58,61,59,64,60,66,61,74,62);
}
