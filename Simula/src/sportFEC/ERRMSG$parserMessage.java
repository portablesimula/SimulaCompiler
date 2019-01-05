// JavaLine 1 ==> SourceLine 208
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:43:34 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$parserMessage extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=208, lastLine=211, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$errpos;
    public int p$n1;
    public int p$n2;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$parserMessage setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$parserMessage.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$errpos=intValue(param); break;
                case 1: p$n1=intValue(param); break;
                case 2: p$n2=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public ERRMSG$parserMessage(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$parserMessage(RTObject$ SL$,int sp$errpos,int sp$n1,int sp$n2) {
        super(SL$);
        // Parameter assignment to locals
        this.p$errpos = sp$errpos;
        this.p$n1 = sp$n1;
        this.p$n2 = sp$n2;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("parserMessage",208);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$parserMessage STM$() {
        TRACE_BEGIN_STM$("parserMessage",208);
        // JavaLine 47 ==> SourceLine 209
        if((p$n2!=(0))) {
            // JavaLine 49 ==> SourceLine 210
            {
                TRACE_BEGIN_STM$("CompoundStatement210",210);
                ((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=new ERRMSG$errmsg(((ERRMSG)(CUR$.SL$)),p$n2).RESULT$;
                ((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=CONC(new TXT$(" - "),((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]]);
                TRACE_END_STM$("CompoundStatement210",210);
            }
        }
        // JavaLine 57 ==> SourceLine 211
        new ERRMSG$outP1message(((ERRMSG)(CUR$.SL$)),p$errpos,p$n1,((char)2));
        TRACE_END_STM$("parserMessage",211);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure parserMessage",1,208,47,209,49,210,57,211,62,211);
}
