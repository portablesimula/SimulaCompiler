// JavaLine 1 ==> SourceLine 44
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Mar 17 18:18:55 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst102$p$simtst102$PBLK42$Car extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=4, PrefixLevel=3, firstLine=44, lastLine=54, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public TXT$ p3$pname;
    // Declare locals as attributes
    // Normal Constructor
    public simtst102$p$simtst102$PBLK42$Car(RTObject$ staticLink,TXT$ sp3$pname) {
        super(staticLink);
        // Parameter assignment to locals
        this.p3$pname = sp3$pname;
        // Declaration Code
        TRACE_BEGIN_DCL$("Car",44);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("Car",44,inner);
                // JavaLine 24 ==> SourceLine 46
                new simtst102$trace(((simtst102)(CUR$.SL$.SL$.SL$)),46,CONC(p3$pname,new TXT$(" is initiating")));
                // JavaLine 26 ==> SourceLine 47
                while(true) {
                    // JavaLine 28 ==> SourceLine 49
                    {
                        TRACE_BEGIN_STM$("CompoundStatement49",49);
                        new simtst102$trace(((simtst102)(CUR$.SL$.SL$.SL$)),49,CONC(p3$pname,new TXT$(" is active 1")));
                        // JavaLine 32 ==> SourceLine 50
                        ((simtst102$PBLK42)(CUR$.SL$)).hold(((double)(4)));
                        // JavaLine 34 ==> SourceLine 51
                        new simtst102$trace(((simtst102)(CUR$.SL$.SL$.SL$)),51,CONC(p3$pname,new TXT$(" is active 2")));
                        // JavaLine 36 ==> SourceLine 52
                        GOTO$(((simtst102)(CUR$.SL$.SL$.SL$)).EXIT_LABEL); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement49",52);
                    }
                       if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                }
                // JavaLine 42 ==> SourceLine 46
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Car",46);
                }
                TRACE_END_STM$("Car",46);
            }
        };
    } // End of Constructor
    // Class Statements
    public simtst102$p$simtst102$PBLK42$Car STM$() { return((simtst102$p$simtst102$PBLK42$Car)CODE$.EXEC$()); }
    public simtst102$p$simtst102$PBLK42$Car START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst102.sim","Class Car",1,44,24,46,26,47,28,49,32,50,34,51,36,52,42,46,53,54);
}
