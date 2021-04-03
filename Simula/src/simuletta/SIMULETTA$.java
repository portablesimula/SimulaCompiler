// JavaLine 1 <== SourceLine 19
package simuletta;
// Simula-1.0 Compiled at Sun Apr 19 14:20:37 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SIMULETTA$ extends BASICIO$ {
    // SubBlock: Kind=SimulaProgram, BlockLevel=1, firstLine=19, lastLine=62, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common inspect$19$0=null;
    // Normal Constructor
    public SIMULETTA$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("SIMULETTA$");
        // Declaration Code
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        {
            // BEGIN INSPECTION 
            inspect$19$0=new Common(((ENVIRONMENT$)CTX$)).STM$();
            if(inspect$19$0!=null) // INSPECT inspect$19$0
            // JavaLine 23 <== SourceLine 57
            new SIMULETTA$$SubBlock20((CUR$)).STM$();
        }
        ;
        // JavaLine 27 <== SourceLine 60
        giveIntInfo(5,0);
        ;
        EBLK();
        return(this);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new SIMULETTA$(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("SIMULETTA.sim","SimulaProgram SIMULETTA$",1,19,23,57,27,60,38,62);
} // End of SubBlock
