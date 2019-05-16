// JavaLine 1 <== SourceLine 20
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 11:18:13 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class GotoSample2$PBLK20 extends Simulation$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=3, firstLine=20, lastLine=41, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 13 <== SourceLine 39
    final LABQNT$ EXIT_LABEL=new LABQNT$(this,1,"EXIT_LABEL"); // Local Label #1=EXIT_LABEL
    // Declare locals as attributes
    // JavaLine 16 <== SourceLine 20
    GotoSample2$p$GotoSample2$PBLK20$Car car1$2=null;
    // Normal Constructor
    public GotoSample2$PBLK20(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("GotoSample2$PBLK20",24);
    }
    // Class Statements
    public GotoSample2$PBLK20 STM$() {
        TRACE_BEGIN_STM$("GotoSample2$PBLK20",24);
        GotoSample2$PBLK20 THIS$=(GotoSample2$PBLK20)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // Class Simset: Code before inner
                // Class Simulation: Code before inner
                // Class GotoSample2$PBLK20: Code before inner
                // JavaLine 35 <== SourceLine 34
                new GotoSample2$trace(((GotoSample2)(CUR$.SL$.SL$)),copy(new TXT$("START SIMULATION")));
                // JavaLine 37 <== SourceLine 35
                car1$2=((GotoSample2$p$GotoSample2$PBLK20$Car)new GotoSample2$p$GotoSample2$PBLK20$Car(((GotoSample2$PBLK20)CUR$),new TXT$("Bil 1")).START$());
                // JavaLine 39 <== SourceLine 36
                new GotoSample2$trace(((GotoSample2)(CUR$.SL$.SL$)),copy(CONC(car1$2.p3$pname,new TXT$(" is scheduled for 4.0"))));
                // JavaLine 41 <== SourceLine 37
                ((GotoSample2$PBLK20)CUR$).ActivateAt(false,car1$2,4.0f,false);
                // JavaLine 43 <== SourceLine 38
                hold(((double)(12)));
                // JavaLine 45 <== SourceLine 39
                LABEL$(1,"EXIT_LABEL");
                sysout().outtext(new TXT$("At OUT"));
                sysout().outimage();
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("GotoSample2$PBLK20:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("GotoSample2$PBLK20:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("GotoSample2$PBLK20:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("GotoSample2$PBLK20",39);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("GotoSample2.sim","PrefixedBlock GotoSample2$PBLK20",1,20,13,39,16,20,35,34,37,35,39,36,41,37,43,38,45,39,66,41);
} // End of Class
