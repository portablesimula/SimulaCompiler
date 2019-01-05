// JavaLine 1 ==> SourceLine 44
package simulaTestBatch;
// Release-Beta-0.3 Compiled at Fri Jan 04 18:19:54 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst04$test extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=44, lastLine=58, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$msg;
    public TXT$ p$result;
    public TXT$ p$expected;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst04$test setPar(Object param) {
        //Util.BREAK("CALL simtst04$test.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    // Constructor in case of Formal/Virtual Procedure Call
    public simtst04$test(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public simtst04$test(RTObject$ SL$,TXT$ sp$msg,TXT$ sp$result,TXT$ sp$expected) {
        super(SL$);
        // Parameter assignment to locals
        this.p$msg = sp$msg;
        this.p$result = sp$result;
        this.p$expected = sp$expected;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("test",44);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst04$test STM$() {
        TRACE_BEGIN_STM$("test",44);
        // JavaLine 47 ==> SourceLine 46
        if(TXTREL$NE(p$result,p$expected)) {
            // JavaLine 49 ==> SourceLine 48
            {
                TRACE_BEGIN_STM$("CompoundStatement48",48);
                sysout().outtext(new TXT$("*** error :  In "));
                sysout().outtext(p$msg);
                // JavaLine 54 ==> SourceLine 49
                sysout().outimage();
                // JavaLine 56 ==> SourceLine 50
                sysout().outtext(new TXT$(" - the following result is wrong: "));
                // JavaLine 58 ==> SourceLine 51
                sysout().outchar('"');
                sysout().outtext(((simtst04)(CUR$.SL$)).txt);
                sysout().outchar('"');
                // JavaLine 62 ==> SourceLine 52
                sysout().outimage();
                // JavaLine 64 ==> SourceLine 53
                sysout().outtext(new TXT$(" -               expected result: "));
                // JavaLine 66 ==> SourceLine 54
                sysout().outchar('"');
                sysout().outtext(p$expected);
                sysout().outchar('"');
                // JavaLine 70 ==> SourceLine 55
                sysout().outimage();
                // JavaLine 72 ==> SourceLine 56
                ((simtst04)(CUR$.SL$)).found_error=(((simtst04)(CUR$.SL$)).found_error+(1));
                TRACE_END_STM$("CompoundStatement48",56);
            }
        }
        TRACE_END_STM$("test",56);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst04.sim","Procedure test",1,44,47,46,49,48,54,49,56,50,58,51,62,52,64,53,66,54,70,55,72,56,80,58);
}
