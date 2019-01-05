// JavaLine 1 ==> SourceLine 1502
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$forstat$new_elt extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1502, lastLine=1506, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public char p$opn;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 1504
    PARSER$codebuffer inspect$1504$38=null;
    PARSER$codebuffer$elt inspect$1504$39=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public PARSER$grammer$forstat$new_elt setPar(Object param) {
        //Util.BREAK("CALL PARSER$grammer$forstat$new_elt.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$opn=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public PARSER$grammer$forstat$new_elt(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public PARSER$grammer$forstat$new_elt(RTObject$ SL$,char sp$opn) {
        super(SL$);
        // Parameter assignment to locals
        this.p$opn = sp$opn;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("new_elt",1504);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$forstat$new_elt STM$() {
        TRACE_BEGIN_STM$("new_elt",1504);
        {
            // BEGIN INSPECTION 
            inspect$1504$38=((PARSER$grammer$forstat)(CUR$.SL$)).forcoder;
            if(inspect$1504$38!=null) //INSPECT inspect$1504$38
            {
                // BEGIN INSPECTION 
                inspect$1504$39=new PARSER$codebuffer$elt(inspect$1504$38).STM$();
                if(inspect$1504$39!=null) //INSPECT inspect$1504$39
                {
                    TRACE_BEGIN_STM$("CompoundStatement1504",1504);
                    inspect$1504$39.opnn=p$opn;
                    // JavaLine 55 ==> SourceLine 1505
                    inspect$1504$39.next=inspect$1504$38.curelt.next;
                    inspect$1504$38.curelt=inspect$1504$38.curelt.next=((PARSER$codebuffer$elt)inspect$1504$39);
                    TRACE_END_STM$("CompoundStatement1504",1505);
                }
            }
        }
        TRACE_END_STM$("new_elt",1505);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure new_elt",1,1502,12,1504,55,1505,65,1506);
}
