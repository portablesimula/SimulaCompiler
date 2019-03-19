// JavaLine 1 ==> SourceLine 14
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Mar 17 17:53:27 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class GotoSample1$PBLK14 extends Simulation$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=3, firstLine=14, lastLine=34, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    GotoSample1$p$GotoSample1$PBLK14$Car car1=null;
    // Normal Constructor
    public GotoSample1$PBLK14(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("GotoSample1$PBLK14",18);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("GotoSample1$PBLK14",18,inner);
                // JavaLine 24 ==> SourceLine 28
                new GotoSample1$trace(((GotoSample1)(CUR$.SL$.SL$)),copy(new TXT$("START SIMULATION")));
                // JavaLine 26 ==> SourceLine 29
                car1=new GotoSample1$p$GotoSample1$PBLK14$Car(((GotoSample1$PBLK14)CUR$),new TXT$("Bil 1")).START();
                // JavaLine 28 ==> SourceLine 30
                new GotoSample1$trace(((GotoSample1)(CUR$.SL$.SL$)),copy(CONC(car1.p3$pname,new TXT$(" is scheduled for 4.0"))));
                // JavaLine 30 ==> SourceLine 31
                ((GotoSample1$PBLK14)CUR$).ActivateAt(false,car1,4.0f,false);
                // JavaLine 32 ==> SourceLine 32
                hold(((double)(12)));
                TRACE_END_STM$("GotoSample1$PBLK14",32);
            }
        };
    } // End of Constructor
    public static PROGINFO$ INFO$=new PROGINFO$("GotoSample1.sim","PrefixedBlock GotoSample1$PBLK14",1,14,24,28,26,29,28,30,30,31,32,32,37,34);
}
