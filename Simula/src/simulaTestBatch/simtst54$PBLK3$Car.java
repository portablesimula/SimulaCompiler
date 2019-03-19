// JavaLine 1 ==> SourceLine 45
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Wed Mar 13 15:32:33 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst54$PBLK3$Car extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=3, firstLine=45, lastLine=54, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public TXT$ p3$pname;
    // Declare locals as attributes
    // Normal Constructor
    public simtst54$PBLK3$Car(RTObject$ staticLink,TXT$ sp3$pname) {
        super(staticLink);
        // Parameter assignment to locals
        this.p3$pname = sp3$pname;
        // Declaration Code
        TRACE_BEGIN_DCL$("Car",45);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("Car",45,inner);
                // JavaLine 24 ==> SourceLine 47
                new simtst54$PBLK3$report(((simtst54$PBLK3)(CUR$.SL$)),CONC(p3$pname,new TXT$(" is initiating")));
                // JavaLine 26 ==> SourceLine 48
                while(true) {
                    // JavaLine 28 ==> SourceLine 50
                    {
                        TRACE_BEGIN_STM$("CompoundStatement50",50);
                        new simtst54$PBLK3$report(((simtst54$PBLK3)(CUR$.SL$)),CONC(p3$pname,new TXT$(" is active 1")));
                        // JavaLine 32 ==> SourceLine 51
                        ((simtst54$PBLK3)(CUR$.SL$)).hold(((double)(4)));
                        // JavaLine 34 ==> SourceLine 52
                        new simtst54$PBLK3$report(((simtst54$PBLK3)(CUR$.SL$)),CONC(p3$pname,new TXT$(" is active 2")));
                        TRACE_END_STM$("CompoundStatement50",52);
                    }
                       if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                }
                // JavaLine 40 ==> SourceLine 47
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Car",47);
                }
                TRACE_END_STM$("Car",47);
            }
        };
    } // End of Constructor
    // Class Statements
    public simtst54$PBLK3$Car STM$() { return((simtst54$PBLK3$Car)CODE$.EXEC$()); }
    public simtst54$PBLK3$Car START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst54.sim","Class Car",1,45,24,47,26,48,28,50,32,51,34,52,40,47,51,54);
}
