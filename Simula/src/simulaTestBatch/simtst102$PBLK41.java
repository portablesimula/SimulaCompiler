// JavaLine 1 ==> SourceLine 41
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Mar 17 18:17:08 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst102$PBLK41 extends Simulation$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=3, firstLine=41, lastLine=61, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    simtst102$p$simtst102$PBLK41$Car car1=null;
    // Normal Constructor
    public simtst102$PBLK41(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("simtst102$PBLK41",45);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("simtst102$PBLK41",45,inner);
                // JavaLine 24 ==> SourceLine 55
                new simtst102$trace(((simtst102)(CUR$.SL$.SL$)),55,new TXT$("START SIMULATION"));
                // JavaLine 26 ==> SourceLine 56
                car1=new simtst102$p$simtst102$PBLK41$Car(((simtst102$PBLK41)CUR$),new TXT$("Bil 1")).START();
                // JavaLine 28 ==> SourceLine 57
                new simtst102$trace(((simtst102)(CUR$.SL$.SL$)),57,CONC(car1.p3$pname,new TXT$(" is scheduled for 4.0")));
                // JavaLine 30 ==> SourceLine 58
                ((simtst102$PBLK41)CUR$).ActivateAt(false,car1,4.0f,false);
                // JavaLine 32 ==> SourceLine 59
                hold(((double)(12)));
                TRACE_END_STM$("simtst102$PBLK41",59);
            }
        };
    } // End of Constructor
    public static PROGINFO$ INFO$=new PROGINFO$("simtst102.sim","PrefixedBlock simtst102$PBLK41",1,41,24,55,26,56,28,57,30,58,32,59,37,61);
}
