// JavaLine 1 ==> SourceLine 3
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 20:35:11 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc00 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=3, lastLine=13, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare local labels
    // JavaLine 10 ==> SourceLine 5
    final LABQNT$ T1=new LABQNT$(this,0,1); // Local Label #1=T1
    // JavaLine 12 ==> SourceLine 8
    final LABQNT$ L2=new LABQNT$(this,0,2); // Local Label #2=L2
    // JavaLine 14 ==> SourceLine 11
    final LABQNT$ L3=new LABQNT$(this,0,3); // Local Label #3=L3
    final LABQNT$ L4=new LABQNT$(this,0,4); // Local Label #4=L4
    // JavaLine 17 ==> SourceLine 12
    final LABQNT$ L5=new LABQNT$(this,0,5); // Local Label #5=L5
    final LABQNT$ EXIT=new LABQNT$(this,0,6); // Local Label #6=EXIT
    // Declare locals as attributes
    // JavaLine 21 ==> SourceLine 3
    int i=0;
    // Normal Constructor
    public adHoc00(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("adHoc00");
        // Declaration Code
        TRACE_BEGIN_DCL$("adHoc00",3);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("adHoc00",3);
        adHoc00 THIS$=(adHoc00)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 38 ==> SourceLine 5
                LABEL$(1,"T1");
                sysout().outtext(new TXT$("AT T1 -- Should GOTO L2"));
                sysout().outimage();
                // JavaLine 42 ==> SourceLine 6
                GOTO$(L2); // GOTO EVALUATED LABEL
                // JavaLine 44 ==> SourceLine 7
                i=78;
                // JavaLine 46 ==> SourceLine 8
                LABEL$(2,"L2");
                sysout().outtext(new TXT$("AT L2 -- Should GOTO EXIT"));
                sysout().outimage();
                // JavaLine 50 ==> SourceLine 9
                GOTO$(EXIT); // GOTO EVALUATED LABEL
                // JavaLine 52 ==> SourceLine 10
                i=(i+(1));
                // JavaLine 54 ==> SourceLine 12
                LABEL$(3,"L3");
                LABEL$(4,"L4");
                LABEL$(5,"L5");
                LABEL$(6,"EXIT");
                sysout().outint(i,0);
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
        TRACE_END_STM$("adHoc00",12);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new adHoc00(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc00.sim","SimulaProgram adHoc00",1,3,10,5,12,8,14,11,17,12,21,3,38,5,42,6,44,7,46,8,50,9,52,10,54,12,82,13);
}
