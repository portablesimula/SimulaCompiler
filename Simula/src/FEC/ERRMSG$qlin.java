// JavaLine 1 ==> SourceLine 247
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:51 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$qlin extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=247, lastLine=255, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public COMMON$quantity p$r;
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 248
    TXT$ ltxt=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$qlin setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$qlin.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$r=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public ERRMSG$qlin(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$qlin(RTObject$ SL$,COMMON$quantity sp$r) {
        super(SL$);
        // Parameter assignment to locals
        this.p$r = sp$r;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("qlin",248);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$qlin STM$() {
        TRACE_BEGIN_STM$("qlin",248);
        // JavaLine 46 ==> SourceLine 249
        if((p$r!=(null))) {
            // JavaLine 48 ==> SourceLine 250
            {
                TRACE_BEGIN_STM$("CompoundStatement250",250);
                if((p$r.line>(0))) {
                    // JavaLine 52 ==> SourceLine 251
                    {
                        TRACE_BEGIN_STM$("CompoundStatement251",251);
                        ltxt=new COMMON$leftint(((ERRMSG)(CUR$.SL$)),p$r.line).RESULT$;
                        ltxt=CONC(CONC(new TXT$("(l. "),ltxt),new TXT$(")"));
                        TRACE_END_STM$("CompoundStatement251",251);
                    }
                } else
                // JavaLine 60 ==> SourceLine 252
                ltxt=new TXT$("(ext.)");
                // JavaLine 62 ==> SourceLine 253
                RESULT$=CONC(p$r.symb.symbol,ltxt);
                TRACE_END_STM$("CompoundStatement250",253);
            }
        }
        TRACE_END_STM$("qlin",253);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure qlin",1,247,15,248,46,249,48,250,52,251,60,252,62,253,70,255);
}
