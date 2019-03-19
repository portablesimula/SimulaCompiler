// JavaLine 1 ==> SourceLine 6
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Mar 17 17:53:27 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class GotoSample1 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=6, lastLine=48, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare local labels
    // JavaLine 10 ==> SourceLine 45
    final LABQNT$ EXIT_LABEL=new LABQNT$(this,0,1); // Local Label #1=EXIT_LABEL
    // Declare locals as attributes
    // Normal Constructor
    public GotoSample1(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("GotoSample1");
        // Declaration Code
        TRACE_BEGIN_DCL$("GotoSample1",32);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("GotoSample1",32);
        GotoSample1 THIS$=(GotoSample1)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 28 ==> SourceLine 39
                sysout().outtext(new TXT$("--- START GOTO SAMPLE"));
                sysout().outimage();
                // JavaLine 31 ==> SourceLine 41
                new GotoSample1$p(((GotoSample1)CUR$));
                // JavaLine 33 ==> SourceLine 43
                sysout().outtext(new TXT$("THIS LINE SHOULD NEVER BE EXECUTED"));
                sysout().outimage();
                // JavaLine 36 ==> SourceLine 45
                LABEL$(1,"EXIT_LABEL");
                sysout().outtext(new TXT$("At OUT"));
                sysout().outimage();
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$ || q.prefixLevel!=0) {
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("GotoSample1",45);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new GotoSample1(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("GotoSample1.sim","SimulaProgram GotoSample1",1,6,10,45,28,39,31,41,33,43,36,45,62,48);
}
