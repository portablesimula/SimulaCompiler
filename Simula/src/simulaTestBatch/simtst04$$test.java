package simulaTestBatch;
// Simula-1.0 Compiled at Sat Oct 05 10:25:26 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst04$$test extends PROC$ {
    public TXT$ p$msg;
    public TXT$ p$result;
    public TXT$ p$expected;
    public simtst04$$test setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 3: p$msg=(TXT$)objectValue(param); break;
                case 2: p$result=(TXT$)objectValue(param); break;
                case 1: p$expected=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst04$$test(RTObject$ SL$) {
        super(SL$,3);
    }
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst04.sim","Procedure test",1,44,34,46,36,48,40,49,42,50,44,51,48,52,50,53,52,54,56,55,58,56,64,58);
}
