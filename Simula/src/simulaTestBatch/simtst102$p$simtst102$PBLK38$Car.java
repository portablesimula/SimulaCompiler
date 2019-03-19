// JavaLine 1 ==> SourceLine 40
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Mar 17 18:20:58 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst102$p$simtst102$PBLK38$Car extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=4, PrefixLevel=3, firstLine=40, lastLine=50, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public TXT$ p3$pname;
    // Declare locals as attributes
    // Normal Constructor
    public simtst102$p$simtst102$PBLK38$Car(RTObject$ staticLink,TXT$ sp3$pname) {
        super(staticLink);
        // Parameter assignment to locals
        this.p3$pname = sp3$pname;
        // Declaration Code
        TRACE_BEGIN_DCL$("Car",40);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("Car",40,inner);
                // JavaLine 24 ==> SourceLine 42
                new simtst102$trace(((simtst102)(CUR$.SL$.SL$.SL$)),42,CONC(p3$pname,new TXT$(" is initiating")));
                // JavaLine 26 ==> SourceLine 43
                while(true) {
                    // JavaLine 28 ==> SourceLine 45
                    {
                        TRACE_BEGIN_STM$("CompoundStatement45",45);
                        new simtst102$trace(((simtst102)(CUR$.SL$.SL$.SL$)),45,CONC(p3$pname,new TXT$(" is active 1")));
                        // JavaLine 32 ==> SourceLine 46
                        ((simtst102$PBLK38)(CUR$.SL$)).hold(((double)(4)));
                        // JavaLine 34 ==> SourceLine 47
                        new simtst102$trace(((simtst102)(CUR$.SL$.SL$.SL$)),47,CONC(p3$pname,new TXT$(" is active 2")));
                        // JavaLine 36 ==> SourceLine 48
                        GOTO$(((simtst102)(CUR$.SL$.SL$.SL$)).EXIT_LABEL); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement45",48);
                    }
                       if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                }
                // JavaLine 42 ==> SourceLine 42
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Car",42);
                }
                TRACE_END_STM$("Car",42);
            }
        };
    } // End of Constructor
    // Class Statements
    public simtst102$p$simtst102$PBLK38$Car STM$() { return((simtst102$p$simtst102$PBLK38$Car)CODE$.EXEC$()); }
    public simtst102$p$simtst102$PBLK38$Car START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst102.sim","Class Car",1,40,24,42,26,43,28,45,32,46,34,47,36,48,42,42,53,50);
}
