// JavaLine 1 ==> SourceLine 42
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Mar 17 18:18:55 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst102$PBLK42 extends Simulation$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=3, firstLine=42, lastLine=62, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    simtst102$p$simtst102$PBLK42$Car car1=null;
    // Normal Constructor
    public simtst102$PBLK42(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("simtst102$PBLK42",46);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("simtst102$PBLK42",46,inner);
                // JavaLine 24 ==> SourceLine 56
                new simtst102$trace(((simtst102)(CUR$.SL$.SL$)),56,new TXT$("START SIMULATION"));
                // JavaLine 26 ==> SourceLine 57
                car1=new simtst102$p$simtst102$PBLK42$Car(((simtst102$PBLK42)CUR$),new TXT$("Bil 1")).START();
                // JavaLine 28 ==> SourceLine 58
                new simtst102$trace(((simtst102)(CUR$.SL$.SL$)),58,CONC(car1.p3$pname,new TXT$(" is scheduled for 4.0")));
                // JavaLine 30 ==> SourceLine 59
                ((simtst102$PBLK42)CUR$).ActivateAt(false,car1,4.0f,false);
                // JavaLine 32 ==> SourceLine 60
                hold(((double)(12)));
                TRACE_END_STM$("simtst102$PBLK42",60);
            }
        };
    } // End of Constructor
    public static PROGINFO$ INFO$=new PROGINFO$("simtst102.sim","PrefixedBlock simtst102$PBLK42",1,42,24,56,26,57,28,58,30,59,32,60,37,62);
}
