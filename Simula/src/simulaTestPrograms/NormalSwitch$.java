// JavaLine 1 <== SourceLine 3
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Aug 18 14:07:26 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class NormalSwitch$ extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=3, lastLine=9, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 7
    final LABQNT$ L1=new LABQNT$(this,1,"L1"); // Local Label #1=L1
    // JavaLine 11 <== SourceLine 9
    final LABQNT$ L2=new LABQNT$(this,2,"L2"); // Local Label #2=L2
    // Declare locals as attributes
    // Normal Constructor
    public NormalSwitch$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("NormalSwitch$");
        // Declaration Code
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        NormalSwitch$ THIS$=(NormalSwitch$)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 27 <== SourceLine 5
                GOTO$(new NormalSwitch$$S(CUR$,4).RESULT$); // GOTO EVALUATED LABEL
                // JavaLine 29 <== SourceLine 9
                LABEL$(1,"L1");
                LABEL$(2,"L2");
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("NormalSwitch$:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("NormalSwitch$:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("NormalSwitch$:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new NormalSwitch$(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("NormalSwitch.sim","SimulaProgram NormalSwitch$",1,3,9,7,11,9,27,5,29,9,54,9);
} // End of SubBlock
