// JavaLine 1 ==> SourceLine 68
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Feb 10 12:24:00 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst68$trace extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=68, lastLine=76, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$msg;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst68$trace setPar(Object param) {
        //Util.BREAK("CALL simtst68$trace.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public simtst68$trace(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public simtst68$trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        // Parameter assignment to locals
        this.p$msg = sp$msg;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("trace",68);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst68$trace STM$() {
        TRACE_BEGIN_STM$("trace",68);
        // JavaLine 41 ==> SourceLine 70
        if(VALUE$(((simtst68)(CUR$.SL$)).verbose)) {
            // JavaLine 43 ==> SourceLine 72
            {
                TRACE_BEGIN_STM$("CompoundStatement72",72);
                sysout().outtext(CONC(p$msg,new TXT$(" - C1=")));
                sysout().outchar(((simtst68)(CUR$.SL$)).c1);
                // JavaLine 48 ==> SourceLine 73
                sysout().outtext(new TXT$(", C2="));
                sysout().outchar(((simtst68)(CUR$.SL$)).c2);
                // JavaLine 51 ==> SourceLine 74
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement72",74);
            }
        }
        TRACE_END_STM$("trace",74);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst68.sim","Procedure trace",1,68,41,70,43,72,48,73,51,74,59,76);
}
