// JavaLine 1 <== SourceLine 2
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 17:59:01 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue24 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=2, lastLine=16, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    final int MAX=(int)(100);
    // JavaLine 11 <== SourceLine 3
    int k=0;
    int n=0;
    // Normal Constructor
    public issue24(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("issue24");
        // Declaration Code
        TRACE_BEGIN_DCL$("issue24",3);
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("issue24",3);
        // JavaLine 25 <== SourceLine 5
        n=120;
        // JavaLine 27 <== SourceLine 7
        for(boolean CB$7:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){k=(int)x$; return(x$);};  public Number get(){return((Number)k); }	},new NAME$<Number>() { public Number get(){return(n); }},new NAME$<Number>() { public Number get(){return(n); }},new NAME$<Number>() { public Number get(){return(MAX); }})
           )) { if(!CB$7) continue;
        // JavaLine 31 <== SourceLine 9
        {
            TRACE_BEGIN_STM$("CompoundStatement9",9);
            sysout().outtext(new TXT$("n="));
            sysout().outint(n,0);
            // JavaLine 36 <== SourceLine 10
            sysout().outtext(new TXT$(", k="));
            sysout().outint(k,0);
            sysout().outimage();
            // JavaLine 40 <== SourceLine 11
            if(VALUE$((k>(MAX)))) {
                // JavaLine 42 <== SourceLine 13
                {
                    TRACE_BEGIN_STM$("CompoundStatement13",13);
                    sysout().outtext(new TXT$("ERROR"));
                    sysout().outimage();
                    TRACE_END_STM$("CompoundStatement13",13);
                }
            }
            TRACE_END_STM$("CompoundStatement9",13);
        }
    }
    TRACE_END_STM$("issue24",13);
    EBLK();
    return(null);
} // End of SimulaProgram Statements

public static void main(String[] args) {
    //System.setProperty("file.encoding","UTF-8");
    RT.setRuntimeOptions(args);
    new issue24(CTX$).STM$();
} // End of main
public static PROGINFO$ INFO$=new PROGINFO$("issue24.sim","SimulaProgram issue24",1,2,11,3,25,5,27,7,31,9,36,10,40,11,42,13,62,16);
} // End of SubBlock
