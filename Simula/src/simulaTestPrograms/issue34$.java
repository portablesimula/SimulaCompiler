// JavaLine 1 <== SourceLine 1
package simulaTestPrograms;
// Simula-1.0 Compiled at Thu Nov 14 12:43:14 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue34$ extends BASICIO$ {
    // SubBlock: Kind=SimulaProgram, BlockLevel=1, firstLine=1, lastLine=16, hasLocalClasses=false, System=false
    // Declare locals as attributes
    final TXT$ t=(TXT$)(new TXT$("abracadabra"));
    // JavaLine 10 <== SourceLine 2
    TXT$ u=null;
    // Normal Constructor
    public issue34$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("issue34$");
        // Declaration Code
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        // JavaLine 21 <== SourceLine 5
        TXT$.putint(u,6);
        // JavaLine 23 <== SourceLine 15
        ASGTXT$(u,null);
        EBLK();
        return(this);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new issue34$(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("issue34.sim","SimulaProgram issue34$",1,1,10,2,21,5,23,15,33,16);
} // End of SubBlock
