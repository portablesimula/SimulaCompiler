// JavaLine 1 <== SourceLine 45
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:46 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InptFile$innumber extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=45, lastLine=50, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 46
    Common inspect$46$36=null;
    // Normal Constructor
    public InptFile$innumber(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public InptFile$innumber STM$() {
        {
            // BEGIN INSPECTION 
            inspect$46$36=((InptFile)(CUR$.SL$)).p3$comn;
            if(inspect$46$36!=null) // INSPECT inspect$46$36
            // JavaLine 29 <== SourceLine 50
            new InptFile$innumber$SubBlock47((CUR$)).STM$();
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("INPTFILE.sim","Procedure innumber",1,45,13,46,29,50,34,50);
} // End of Procedure
