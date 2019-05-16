// JavaLine 1 <== SourceLine 18
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 17:22:40 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue17$PBLK18 extends Simulation$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=3, firstLine=18, lastLine=39, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 13 <== SourceLine 37
    final LABQNT$ EXIT_LABEL=new LABQNT$(this,1,"EXIT_LABEL"); // Local Label #1=EXIT_LABEL
    // Declare locals as attributes
    // JavaLine 16 <== SourceLine 18
    issue17$p$issue17$PBLK18$Car car1$2=null;
    // Normal Constructor
    public issue17$PBLK18(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("issue17$PBLK18",22);
    }
    // Class Statements
    public issue17$PBLK18 STM$() {
        TRACE_BEGIN_STM$("issue17$PBLK18",22);
        issue17$PBLK18 THIS$=(issue17$PBLK18)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // Class Simset: Code before inner
                // Class Simulation: Code before inner
                // Class issue17$PBLK18: Code before inner
                // JavaLine 35 <== SourceLine 32
                new issue17$trace(((issue17)(CUR$.SL$.SL$)),copy(new TXT$("START SIMULATION")));
                // JavaLine 37 <== SourceLine 33
                car1$2=((issue17$p$issue17$PBLK18$Car)new issue17$p$issue17$PBLK18$Car(((issue17$PBLK18)CUR$),new TXT$("Bil 1")).START$());
                // JavaLine 39 <== SourceLine 34
                new issue17$trace(((issue17)(CUR$.SL$.SL$)),copy(CONC(car1$2.p3$pname,new TXT$(" is scheduled for 4.0"))));
                // JavaLine 41 <== SourceLine 35
                ((issue17$PBLK18)CUR$).ActivateAt(false,car1$2,4.0f,false);
                // JavaLine 43 <== SourceLine 36
                hold(((double)(12)));
                // JavaLine 45 <== SourceLine 37
                LABEL$(1,"EXIT_LABEL");
                sysout().outtext(new TXT$("At OUT"));
                sysout().outimage();
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("issue17$PBLK18:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("issue17$PBLK18:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("issue17$PBLK18:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("issue17$PBLK18",37);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("issue17.sim","PrefixedBlock issue17$PBLK18",1,18,13,37,16,18,35,32,37,33,39,34,41,35,43,36,45,37,66,39);
} // End of Class
