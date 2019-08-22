// JavaLine 1 <== SourceLine 4
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Aug 18 11:51:33 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class FormalSwitch$ extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=4, lastLine=15, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 13
    final LABQNT$ L1=new LABQNT$(this,1,"L1"); // Local Label #1=L1
    // JavaLine 11 <== SourceLine 15
    final LABQNT$ L2=new LABQNT$(this,2,"L2"); // Local Label #2=L2
    // Declare locals as attributes
    // Normal Constructor
    public FormalSwitch$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("FormalSwitch$");
        // Declaration Code
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        FormalSwitch$ THIS$=(FormalSwitch$)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 27 <== SourceLine 12
                new FormalSwitch$$callFP(((FormalSwitch$)(CUR$)),new PRCQNT$(((FormalSwitch$)(CUR$)),FormalSwitch$$P.class));
                // JavaLine 29 <== SourceLine 15
                LABEL$(1,"L1");
                LABEL$(2,"L2");
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("FormalSwitch$:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("FormalSwitch$:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("FormalSwitch$:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new FormalSwitch$(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("FormalSwitch.sim","SimulaProgram FormalSwitch$",1,4,9,13,11,15,27,12,29,15,54,15);
} // End of SubBlock
