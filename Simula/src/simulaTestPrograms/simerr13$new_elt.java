// JavaLine 1 <== SourceLine 13
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 17:19:55 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr13$new_elt extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=13, lastLine=20, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public char p$opn;
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 14
    simerr13$Coder inspect$14$0=null;
    // JavaLine 14 <== SourceLine 16
    simerr13$Coder$elt inspect$16$1=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public simerr13$new_elt setPar(Object param) {
        //Util.BREAK("CALL simerr13$new_elt.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public simerr13$new_elt(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public simerr13$new_elt(RTObject$ SL$,char sp$opn) {
        super(SL$);
        // Parameter assignment to locals
        this.p$opn = sp$opn;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("new_elt",16);
        STM$();
    }
    // Procedure Statements
    public simerr13$new_elt STM$() {
        TRACE_BEGIN_STM$("new_elt",16);
        // JavaLine 45 <== SourceLine 14
        {
            // BEGIN INSPECTION 
            inspect$14$0=((simerr13)(CUR$.SL$)).forcoder;
            if(inspect$14$0!=null) // INSPECT inspect$14$0
            // JavaLine 50 <== SourceLine 16
            {
                // BEGIN INSPECTION 
                inspect$16$1=new simerr13$Coder$elt(inspect$14$0).STM$();
                if(inspect$16$1!=null) // INSPECT inspect$16$1
                // JavaLine 55 <== SourceLine 18
                {
                    TRACE_BEGIN_STM$("CompoundStatement18",18);
                    inspect$16$1.x=44;
                    TRACE_END_STM$("CompoundStatement18",18);
                }
            }
        }
        TRACE_END_STM$("new_elt",18);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simerr13.sim","Procedure new_elt",1,13,12,14,14,16,45,14,50,16,55,18,66,20);
} // End of Procedure
