// JavaLine 1 ==> SourceLine 6
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 20 11:03:09 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class XQueens extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=6, lastLine=19, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int i=0;
    // Normal Constructor
    public XQueens(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("XQueens");
        // Declaration Code
        TRACE_BEGIN_DCL$("XQueens",6);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("XQueens",6);
        sysout().outtext(new TXT$(" A  B  C  D  E  F  G  H"));
        // JavaLine 23 ==> SourceLine 7
        for(boolean CB$7:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(3); }},new NAME$<Number>() { public Number get(){return(3); }},new NAME$<Number>() { public Number get(){return(24); }})
           )) { if(!CB$7) continue;
        // JavaLine 27 ==> SourceLine 18
        new XQueens$SubBlock8(CUR$).STM$();
    }
    TRACE_END_STM$("XQueens",17);
    EBLK();
    return(null);
} // End of SimulaProgram Statements

public static void main(String[] args) {
    //System.setProperty("file.encoding","UTF-8");
    RT.setRuntimeOptions(args);
    new XQueens(CTX$).STM$();
}
public static PROGINFO$ INFO$=new PROGINFO$("8Queens.sim","SimulaProgram XQueens",1,6,23,7,27,18,39,19);
}
