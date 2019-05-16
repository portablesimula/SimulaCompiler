// JavaLine 1 <== SourceLine 6
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 17:59:16 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class _Queens extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=6, lastLine=19, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int i=0;
    // Normal Constructor
    public _Queens(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("_Queens");
        // Declaration Code
        TRACE_BEGIN_DCL$("_Queens",6);
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("_Queens",6);
        sysout().outtext(new TXT$(" A  B  C  D  E  F  G  H"));
        // JavaLine 23 <== SourceLine 7
        for(boolean CB$7:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(3); }},new NAME$<Number>() { public Number get(){return(3); }},new NAME$<Number>() { public Number get(){return(24); }})
           )) { if(!CB$7) continue;
        // JavaLine 27 <== SourceLine 18
        new _Queens$SubBlock8(CUR$).STM$();
    }
    TRACE_END_STM$("_Queens",17);
    EBLK();
    return(null);
} // End of SimulaProgram Statements

public static void main(String[] args) {
    //System.setProperty("file.encoding","UTF-8");
    RT.setRuntimeOptions(args);
    new _Queens(CTX$).STM$();
} // End of main
public static PROGINFO$ INFO$=new PROGINFO$("8Queens.sim","SimulaProgram _Queens",1,6,23,7,27,18,39,19);
} // End of SubBlock
