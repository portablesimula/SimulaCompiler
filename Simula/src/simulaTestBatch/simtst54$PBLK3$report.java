// JavaLine 1 ==> SourceLine 34
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Wed Mar 13 15:32:33 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst54$PBLK3$report extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=34, lastLine=43, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$message;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 35
    boolean err=false;
    TXT$ T=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst54$PBLK3$report setPar(Object param) {
        //Util.BREAK("CALL simtst54$PBLK3$report.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$message=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public simtst54$PBLK3$report(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public simtst54$PBLK3$report(RTObject$ SL$,TXT$ sp$message) {
        super(SL$);
        // Parameter assignment to locals
        this.p$message = sp$message;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("report",35);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst54$PBLK3$report STM$() {
        TRACE_BEGIN_STM$("report",35);
        T=blanks(40);
        // JavaLine 45 ==> SourceLine 36
        sysout().outfix(((simtst54$PBLK3)(CUR$.SL$)).time(),2,0);
        sysout().outtext(CONC(new TXT$(": "),p$message));
        // JavaLine 48 ==> SourceLine 37
        ASGTXT$(T,TXT$.strip(sysout().image));
        ASGTXT$(sysout().image,null);
        TXT$.setpos(sysout().image,1);
        // JavaLine 52 ==> SourceLine 38
        err=TXTREL$NE(TXT$.strip(T),((simtst54$PBLK3)(CUR$.SL$)).facit.Elt[((simtst54$PBLK3)(CUR$.SL$)).testCase-((simtst54$PBLK3)(CUR$.SL$)).facit.LB[0]]);
        ((simtst54$PBLK3)(CUR$.SL$)).testCase=(((simtst54$PBLK3)(CUR$.SL$)).testCase+(1));
        // JavaLine 55 ==> SourceLine 39
        if(VALUE$(((simtst54$PBLK3)(CUR$.SL$)).verbose)) {
            // JavaLine 57 ==> SourceLine 40
            {
                TRACE_BEGIN_STM$("CompoundStatement40",40);
                sysout().outtext(T);
                if(VALUE$(err)) {
                    sysout().outtext(new TXT$("  - ERROR"));
                }
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement40",40);
            }
        }
        // JavaLine 68 ==> SourceLine 42
        if(VALUE$(err)) {
            ((simtst54$PBLK3)(CUR$.SL$)).found_error=true;
        }
        TRACE_END_STM$("report",42);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst54.sim","Procedure report",1,34,12,35,45,36,48,37,52,38,55,39,57,40,68,42,75,43);
}
