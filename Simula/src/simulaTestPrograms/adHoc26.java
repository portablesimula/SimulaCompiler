// JavaLine 1 <== SourceLine 2
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 12 10:13:44 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc26 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=2, lastLine=28, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare local labels
    // JavaLine 10 <== SourceLine 12
    final LABQNT$ T0=new LABQNT$(this,1,"T0"); // Local Label #1=T0
    // JavaLine 12 <== SourceLine 17
    final LABQNT$ T1=new LABQNT$(this,2,"T1"); // Local Label #2=T1
    // JavaLine 14 <== SourceLine 20
    final LABQNT$ T2=new LABQNT$(this,3,"T2"); // Local Label #3=T2
    // JavaLine 16 <== SourceLine 22
    final LABQNT$ L1=new LABQNT$(this,4,"L1"); // Local Label #4=L1
    // JavaLine 18 <== SourceLine 23
    final LABQNT$ L2=new LABQNT$(this,5,"L2"); // Local Label #5=L2
    // JavaLine 20 <== SourceLine 28
    final LABQNT$ L3=new LABQNT$(this,6,"L3"); // Local Label #6=L3
    // Declare locals as attributes
    // JavaLine 23 <== SourceLine 2
    int i=0;
    int j=0;
    // JavaLine 26 <== SourceLine 3
    boolean b=false;
    // Normal Constructor
    public adHoc26(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("adHoc26");
        // Declaration Code
        TRACE_BEGIN_DCL$("adHoc26",6);
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("adHoc26",6);
        adHoc26 THIS$=(adHoc26)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 43 <== SourceLine 8
                i=5;
                // JavaLine 45 <== SourceLine 12
                LABEL$(1,"T0");
                GOTO$(new adHoc26$q(((adHoc26)CUR$),i).RESULT$); // GOTO EVALUATED LABEL
                // JavaLine 48 <== SourceLine 24
                LABEL$(2,"T1");
                LABEL$(3,"T2");
                LABEL$(4,"L1");
                // JavaLine 52 <== SourceLine 22
                if(VALUE$(false)) {
                    // JavaLine 54 <== SourceLine 23
                    {
                        TRACE_BEGIN_STM$("CompoundStatement23",23);
                        LABEL$(5,"L2");
                        sysout().outtext(new TXT$("AT L2"));
                        TRACE_END_STM$("CompoundStatement23",23);
                    }
                }
                // JavaLine 62 <== SourceLine 28
                LABEL$(6,"L3");
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("adHoc26:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("adHoc26:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("adHoc26:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("adHoc26",28);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new adHoc26(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc26.sim","SimulaProgram adHoc26",1,2,10,12,12,17,14,20,16,22,18,23,20,28,23,2,26,3,43,8,45,12,48,24,52,22,54,23,62,28,87,28);
} // End of SubBlock
