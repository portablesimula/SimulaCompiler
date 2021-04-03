// JavaLine 1 <== SourceLine 66
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:46 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InptFile$inident extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=66, lastLine=71, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 67
    Common inspect$67$37=null;
    // Normal Constructor
    public InptFile$inident(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public InptFile$inident STM$() {
        {
            // BEGIN INSPECTION 
            inspect$67$37=((InptFile)(CUR$.SL$)).p3$comn;
            if(inspect$67$37!=null) // INSPECT inspect$67$37
            // JavaLine 26 <== SourceLine 68
            {
                inspect$67$37.simsymbol$1=new InptFile$instring(((InptFile)(CUR$.SL$))).RESULT$;
                ;
                new Common$DEFIDENT(inspect$67$37);
                ;
                // JavaLine 32 <== SourceLine 69
                if(VALUE$((((InptFile)(CUR$.SL$)).input_trace$3>(0)))) {
                    new InptFile$TRC(((InptFile)(CUR$.SL$)),new TXT$("Inident"),inspect$67$37.simsymbol$1);
                }
                ;
            }
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("INPTFILE.sim","Procedure inident",1,66,10,67,26,68,32,69,42,71);
} // End of Procedure
