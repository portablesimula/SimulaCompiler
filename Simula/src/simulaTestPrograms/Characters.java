// JavaLine 1 ==> SourceLine 3
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Jan 23 17:14:20 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Characters extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=3, lastLine=10, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int i=0;
    // Normal Constructor
    public Characters(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("Characters");
        // Declaration Code
        TRACE_BEGIN_DCL$("Characters",3);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("Characters",3);
        // JavaLine 22 ==> SourceLine 4
        for(boolean CB$4:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(128); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(512); }})
           )) { if(!CB$4) continue;
        // JavaLine 26 ==> SourceLine 6
        {
            TRACE_BEGIN_STM$("CompoundStatement6",6);
            sysout().outtext(new TXT$("   Character #"));
            sysout().outint(i,0);
            // JavaLine 31 ==> SourceLine 7
            sysout().outtext(new TXT$(" = '"));
            sysout().outchar(char$(i));
            sysout().outtext(new TXT$("'"));
            // JavaLine 35 ==> SourceLine 8
            sysout().outimage();
            TRACE_END_STM$("CompoundStatement6",8);
        }
    }
    TRACE_END_STM$("Characters",8);
    EBLK();
    return(null);
} // End of SimulaProgram Statements

public static void main(String[] args) {
    //System.setProperty("file.encoding","UTF-8");
    RT.setRuntimeOptions(args);
    new Characters(CTX$).STM$();
}
public static PROGINFO$ INFO$=new PROGINFO$("Characters.sim","SimulaProgram Characters",1,3,22,4,26,6,31,7,35,8,49,10);
}
