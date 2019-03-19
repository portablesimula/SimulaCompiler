// JavaLine 1 ==> SourceLine 19
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Mar 17 18:20:58 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst102$trace extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=19, lastLine=32, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$line;
    public TXT$ p$msg;
    // Declare locals as attributes
    // JavaLine 13 ==> SourceLine 21
    TXT$ case1=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst102$trace setPar(Object param) {
        //Util.BREAK("CALL simtst102$trace.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$line=intValue(param); break;
                case 1: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public simtst102$trace(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public simtst102$trace(RTObject$ SL$,int sp$line,TXT$ sp$msg) {
        super(SL$);
        // Parameter assignment to locals
        this.p$line = sp$line;
        this.p$msg = sp$msg;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("trace",21);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst102$trace STM$() {
        TRACE_BEGIN_STM$("trace",21);
        // JavaLine 46 ==> SourceLine 22
        case1=CONC(CONC(CONC(new TXT$("LINE "),new simtst102$edint(((simtst102)(CUR$.SL$)),p$line).RESULT$),new TXT$(": ")),p$msg);
        // JavaLine 48 ==> SourceLine 23
        if(VALUE$(((simtst102)(CUR$.SL$)).verbose)) {
            {
                TRACE_BEGIN_STM$("CompoundStatement23",23);
                sysout().outtext(case1);
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement23",23);
            }
        }
        // JavaLine 57 ==> SourceLine 24
        if(VALUE$(TXTREL$NE(case1,((simtst102)(CUR$.SL$)).facit.Elt[((simtst102)(CUR$.SL$)).traceCase-((simtst102)(CUR$.SL$)).facit.LB[0]]))) {
            // JavaLine 59 ==> SourceLine 26
            {
                TRACE_BEGIN_STM$("CompoundStatement26",26);
                ((simtst102)(CUR$.SL$)).found_error=true;
                // JavaLine 63 ==> SourceLine 27
                sysout().outtext(new TXT$("ERROR in Trace Case "));
                sysout().outint(((simtst102)(CUR$.SL$)).traceCase,0);
                sysout().outtext(new TXT$(" at line "));
                sysout().outint(p$line,0);
                sysout().outimage();
                // JavaLine 69 ==> SourceLine 28
                sysout().outtext(CONC(new TXT$("Trace Case: "),case1));
                sysout().outimage();
                // JavaLine 72 ==> SourceLine 29
                sysout().outtext(CONC(new TXT$("     Facit: "),((simtst102)(CUR$.SL$)).facit.Elt[((simtst102)(CUR$.SL$)).traceCase-((simtst102)(CUR$.SL$)).facit.LB[0]]));
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement26",29);
            }
        }
        // JavaLine 78 ==> SourceLine 31
        ((simtst102)(CUR$.SL$)).traceCase=(((simtst102)(CUR$.SL$)).traceCase+(1));
        TRACE_END_STM$("trace",31);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst102.sim","Procedure trace",1,19,13,21,46,22,48,23,57,24,59,26,63,27,69,28,72,29,78,31,83,32);
}
