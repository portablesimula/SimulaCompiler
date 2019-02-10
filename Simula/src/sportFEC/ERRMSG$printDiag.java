// JavaLine 1 ==> SourceLine 51
package sportFEC;
// Simula-Beta-0.3 Compiled at Fri Feb 08 19:59:19 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$printDiag extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=51, lastLine=57, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$t;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 54
    PrintFile$ inspect$54$0=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$printDiag setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$printDiag.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$t=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public ERRMSG$printDiag(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$printDiag(RTObject$ SL$,TXT$ sp$t) {
        super(SL$);
        // Parameter assignment to locals
        this.p$t = sp$t;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("printDiag",54);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$printDiag STM$() {
        TRACE_BEGIN_STM$("printDiag",54);
        // JavaLine 43 ==> SourceLine 52
        if(VALUE$(TRF_NE(p$t,null))) {
            // JavaLine 45 ==> SourceLine 53
            {
                TRACE_BEGIN_STM$("CompoundStatement53",53);
                sysout().outtext(p$t);
                sysout().outimage();
                // JavaLine 50 ==> SourceLine 54
                if(VALUE$((((ERRMSG)(CUR$.SL$)).listfile!=(sysout())))) {
                    {
                        // BEGIN INSPECTION 
                        inspect$54$0=((ERRMSG)(CUR$.SL$)).listfile;
                        if(inspect$54$0!=null) //INSPECT inspect$54$0
                        // JavaLine 56 ==> SourceLine 55
                        {
                            TRACE_BEGIN_STM$("CompoundStatement55",55);
                            inspect$54$0.outtext(p$t);
                            inspect$54$0.outimage();
                            TRACE_END_STM$("CompoundStatement55",55);
                        }
                    }
                }
                TRACE_END_STM$("CompoundStatement53",55);
            }
        }
        TRACE_END_STM$("printDiag",55);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure printDiag",1,51,12,54,43,52,45,53,50,54,56,55,71,57);
}
