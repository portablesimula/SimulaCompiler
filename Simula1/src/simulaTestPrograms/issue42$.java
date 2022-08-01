// JavaLine 1 <== SourceLine 3
package simulaTestPrograms;
// Simula-2.0 Compiled at Fri Sep 10 10:56:34 CEST 2021
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue42$ extends BASICIO$ {
    // SubBlock: Kind=SimulaProgram, BlockLevel=1, firstLine=3, lastLine=32, hasLocalClasses=true, System=true
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    // Normal Constructor
    public issue42$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("issue42$");
        // Declaration Code
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        // JavaLine 19 <== SourceLine 28
        new issue42$$trace(((issue42$)(CUR$)),CONC(new TXT$("n=2: result:"),ENVIRONMENT$.edit(new issue42$$GOTO_ERROR(((issue42$)(CUR$)),2).RESULT$)));
        ;
        // JavaLine 22 <== SourceLine 29
        new issue42$$trace(((issue42$)(CUR$)),CONC(new TXT$("n=5: result:"),ENVIRONMENT$.edit(new issue42$$GOTO_ERROR(((issue42$)(CUR$)),5).RESULT$)));
        ;
        // JavaLine 25 <== SourceLine 30
        new issue42$$trace(((issue42$)(CUR$)),CONC(new TXT$("n=6: result:"),ENVIRONMENT$.edit(new issue42$$GOTO_ERROR(((issue42$)(CUR$)),6).RESULT$)));
        ;
        EBLK();
        return(this);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new issue42$(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("issue42.sim","SimulaProgram issue42$",1,3,19,28,22,29,25,30,36,32);
} // End of SubBlock
