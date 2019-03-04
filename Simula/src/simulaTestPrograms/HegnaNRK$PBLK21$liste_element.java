// JavaLine 1 ==> SourceLine 222
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Mar 04 20:15:38 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class HegnaNRK$PBLK21$liste_element extends Link$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=2, firstLine=222, lastLine=224, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    // Declare parameters as attributes
    public int p2$nr;
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$liste_element(RTObject$ staticLink,int sp2$nr) {
        super(staticLink);
        // Parameter assignment to locals
        this.p2$nr = sp2$nr;
        // Declaration Code
        TRACE_BEGIN_DCL$("liste_element",222);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("liste_element",222,inner);
                // JavaLine 23 ==> SourceLine 224
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("liste_element",224);
                }
                TRACE_END_STM$("liste_element",224);
            }
        };
    } // End of Constructor
    // Class Statements
    public HegnaNRK$PBLK21$liste_element STM$() { return((HegnaNRK$PBLK21$liste_element)CODE$.EXEC$()); }
    public HegnaNRK$PBLK21$liste_element START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Class liste_element",1,222,23,224,34,224);
}
