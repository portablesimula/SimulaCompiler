package simulaTestBatch;
// Simula-1.0 Compiled at Sat Jun 15 10:11:34 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst54$report extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$message;
    boolean err=false;
    TXT$ T=null;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst54$report setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$message=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst54$report(RTObject$ SL$)
    { super(SL$); }
    public simtst54$report(RTObject$ SL$,TXT$ sp$message) {
        super(SL$);
        this.p$message = sp$message;
        BBLK();
        STM$();
    }
    public simtst54$report STM$() {
        T=blanks(40);
        sysout().outfix(((simtst54)(CUR$.SL$)).time(),2,0);
        sysout().outtext(CONC(new TXT$(": "),p$message));
        ASGTXT$(T,TXT$.strip(sysout().image));
        ASGTXT$(sysout().image,null);
        TXT$.setpos(sysout().image,1);
        err=TXTREL$NE(TXT$.strip(T),((simtst54)(CUR$.SL$)).facit.Elt[((simtst54)(CUR$.SL$)).testCase$2-((simtst54)(CUR$.SL$)).facit.LB[0]]);
        ((simtst54)(CUR$.SL$)).testCase$2=Math.addExact(((simtst54)(CUR$.SL$)).testCase$2,1);
        if(VALUE$(((simtst54)(CUR$.SL$)).verbose$2)) {
            {
                sysout().outtext(T);
                if(VALUE$(err)) {
                    sysout().outtext(new TXT$("  - ERROR"));
                }
                sysout().outimage();
            }
        }
        if(VALUE$(err)) {
            ((simtst54)(CUR$.SL$)).found_error$2=true;
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst54.sim","Procedure report",1,34,9,35,33,36,36,37,40,38,43,39,45,40,54,42,60,43);
}
