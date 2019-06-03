package simulaTestBatch;
// Simula-1.0 Compiled at Sat Jun 01 10:25:22 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst04$$test extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$msg;
    public TXT$ p$result;
    public TXT$ p$expected;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst04$$test setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                case 1: p$result=(TXT$)objectValue(param); break;
                case 2: p$expected=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst04$$test(RTObject$ SL$)
    { super(SL$); }
    public simtst04$$test(RTObject$ SL$,TXT$ sp$msg,TXT$ sp$result,TXT$ sp$expected) {
        super(SL$);
        this.p$msg = sp$msg;
        this.p$result = sp$result;
        this.p$expected = sp$expected;
        BBLK();
        STM$();
    }
    public simtst04$$test STM$() {
        if(VALUE$(TXTREL$NE(p$result,p$expected))) {
            {
                sysout().outtext(new TXT$("*** error :  In "));
                sysout().outtext(p$msg);
                sysout().outimage();
                sysout().outtext(new TXT$(" - the following result is wrong: "));
                sysout().outchar('"');
                sysout().outtext(((simtst04$)(CUR$.SL$)).txt);
                sysout().outchar('"');
                sysout().outimage();
                sysout().outtext(new TXT$(" -               expected result: "));
                sysout().outchar('"');
                sysout().outtext(p$expected);
                sysout().outchar('"');
                sysout().outimage();
                ((simtst04$)(CUR$.SL$)).found_error=Math.addExact(((simtst04$)(CUR$.SL$)).found_error,1);
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst04.sim","Procedure test",1,44,35,46,37,48,41,49,43,50,45,51,49,52,51,53,53,54,57,55,59,56,65,58);
}
