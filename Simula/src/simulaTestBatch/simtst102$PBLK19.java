// JavaLine 1 ==> SourceLine 19
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Mar 17 18:03:32 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst102$PBLK19 extends Simulation$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=3, firstLine=19, lastLine=39, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    simtst102$p$simtst102$PBLK19$Car car1=null;
    // Normal Constructor
    public simtst102$PBLK19(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("simtst102$PBLK19",23);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("simtst102$PBLK19",23,inner);
                // JavaLine 24 ==> SourceLine 33
                new simtst102$trace(((simtst102)(CUR$.SL$.SL$)),copy(new TXT$("START SIMULATION")));
                // JavaLine 26 ==> SourceLine 34
                car1=new simtst102$p$simtst102$PBLK19$Car(((simtst102$PBLK19)CUR$),new TXT$("Bil 1")).START();
                // JavaLine 28 ==> SourceLine 35
                new simtst102$trace(((simtst102)(CUR$.SL$.SL$)),copy(CONC(car1.p3$pname,new TXT$(" is scheduled for 4.0"))));
                // JavaLine 30 ==> SourceLine 36
                ((simtst102$PBLK19)CUR$).ActivateAt(false,car1,4.0f,false);
                // JavaLine 32 ==> SourceLine 37
                hold(((double)(12)));
                TRACE_END_STM$("simtst102$PBLK19",37);
            }
        };
    } // End of Constructor
    public static PROGINFO$ INFO$=new PROGINFO$("simtst102.sim","PrefixedBlock simtst102$PBLK19",1,19,24,33,26,34,28,35,30,36,32,37,37,39);
}
