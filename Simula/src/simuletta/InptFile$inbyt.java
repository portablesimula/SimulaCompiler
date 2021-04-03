// JavaLine 1 <== SourceLine 29
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:46 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InptFile$inbyt extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=29, lastLine=35, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 30
    Common inspect$30$34=null;
    // Normal Constructor
    public InptFile$inbyt(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public InptFile$inbyt STM$() {
        {
            // BEGIN INSPECTION 
            inspect$30$34=((InptFile)(CUR$.SL$)).p3$comn;
            if(inspect$30$34!=null) // INSPECT inspect$30$34
            // JavaLine 29 <== SourceLine 35
            new InptFile$inbyt$SubBlock31((CUR$)).STM$();
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("INPTFILE.sim","Procedure inbyt",1,29,13,30,29,35,34,35);
} // End of Procedure
