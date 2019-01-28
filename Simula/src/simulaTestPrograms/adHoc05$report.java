// JavaLine 1 ==> SourceLine 8
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Jan 26 19:59:46 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc05$report extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=8, lastLine=12, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$line;
    public TXT$ p$t;
    public boolean p$abort;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public adHoc05$report setPar(Object param) {
        //Util.BREAK("CALL adHoc05$report.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$line=intValue(param); break;
                case 1: p$t=(TXT$)objectValue(param); break;
                case 2: p$abort=(boolean)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public adHoc05$report(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public adHoc05$report(RTObject$ SL$,int sp$line,TXT$ sp$t,boolean sp$abort) {
        super(SL$);
        // Parameter assignment to locals
        this.p$line = sp$line;
        this.p$t = sp$t;
        this.p$abort = sp$abort;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("report",8);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public adHoc05$report STM$() {
        TRACE_BEGIN_STM$("report",8);
        // JavaLine 47 ==> SourceLine 9
        sysout().outimage();
        sysout().outtext(new TXT$("Line "));
        sysout().outint(p$line,0);
        sysout().outtext(new TXT$(": *** report: "));
        sysout().outtext(p$t);
        sysout().outimage();
        // JavaLine 54 ==> SourceLine 10
        ((adHoc05)(CUR$.SL$)).found_error=true;
        // JavaLine 56 ==> SourceLine 11
        if(p$abort) {
            error(new TXT$("Abort requested"));
        }
        TRACE_END_STM$("report",11);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc05.sim","Procedure report",1,8,47,9,54,10,56,11,63,12);
}
