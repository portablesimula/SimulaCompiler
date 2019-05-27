// JavaLine 1 <== SourceLine 3
package simulaTestPrograms;
// Simula-1.0 Compiled at Sat May 25 13:14:51 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc01$ extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=3, lastLine=18, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 9
    float rea=0.0f;
    // JavaLine 12 <== SourceLine 10
    TXT$ txt=null;
    // Normal Constructor
    public adHoc01$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("adHoc01$");
        // Declaration Code
        TRACE_BEGIN_DCL$("adHoc01$",10);
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("adHoc01$",10);
        // JavaLine 25 <== SourceLine 12
        txt=blanks(30);
        // JavaLine 27 <== SourceLine 13
        rea=((float)((-(3))));
        // JavaLine 29 <== SourceLine 14
        TXT$.putreal(txt,rea,7);
        // JavaLine 31 <== SourceLine 15
        new adHoc01$$test(((adHoc01$)CUR$),new TXT$("real operation (3)."),txt,new TXT$("                 -3.000000&+00"));
        TRACE_END_STM$("adHoc01$",15);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new adHoc01$(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc01.sim","SimulaProgram adHoc01$",1,3,10,9,12,10,25,12,27,13,29,14,31,15,42,18);
} // End of SubBlock
