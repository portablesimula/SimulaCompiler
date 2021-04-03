// JavaLine 1 <== SourceLine 37
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:46 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InptFile$in2byt extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=37, lastLine=43, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 38
    Common inspect$38$35=null;
    // Normal Constructor
    public InptFile$in2byt(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public InptFile$in2byt STM$() {
        {
            // BEGIN INSPECTION 
            inspect$38$35=((InptFile)(CUR$.SL$)).p3$comn;
            if(inspect$38$35!=null) // INSPECT inspect$38$35
            // JavaLine 29 <== SourceLine 43
            new InptFile$in2byt$SubBlock39((CUR$)).STM$();
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("INPTFILE.sim","Procedure in2byt",1,37,13,38,29,43,34,43);
} // End of Procedure
