// JavaLine 1 <== SourceLine 2
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue May 14 09:42:35 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc00 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=2, lastLine=13, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int i=0;
    int j=0;
    int k=0;
    // Normal Constructor
    public adHoc00(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("adHoc00");
        // Declaration Code
        TRACE_BEGIN_DCL$("adHoc00",2);
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("adHoc00",2);
        // JavaLine 24 <== SourceLine 3
        i=44;
        // JavaLine 26 <== SourceLine 4
        j=8;
        // JavaLine 28 <== SourceLine 5
        k=Math.addExact(i,j);
        // JavaLine 30 <== SourceLine 6
        k=IPOW$EXACT(i,j);
        // JavaLine 32 <== SourceLine 8
        k=IPOW$EXACT(k,k);
        // JavaLine 34 <== SourceLine 9
        k=IPOW$EXACT(k,k);
        // JavaLine 36 <== SourceLine 10
        k=IPOW$EXACT(k,k);
        TRACE_END_STM$("adHoc00",10);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new adHoc00(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc00.sim","SimulaProgram adHoc00",1,2,24,3,26,4,28,5,30,6,32,8,34,9,36,10,47,13);
} // End of SubBlock
