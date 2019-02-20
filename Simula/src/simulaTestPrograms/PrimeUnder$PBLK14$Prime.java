// JavaLine 1 ==> SourceLine 16
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Feb 18 11:18:28 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class PrimeUnder$PBLK14$Prime extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=3, firstLine=16, lastLine=26, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 17
    public int which=0;
    // Normal Constructor
    public PrimeUnder$PBLK14$Prime(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("Prime",17);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("Prime",17,inner);
                // JavaLine 24 ==> SourceLine 18
                ((PrimeUnder$PBLK14)(CUR$.SL$)).acc=(((PrimeUnder$PBLK14)(CUR$.SL$)).acc+(1));
                // JavaLine 26 ==> SourceLine 19
                which=((int)((int)Math.round(((PrimeUnder$PBLK14)(CUR$.SL$)).time())));
                // JavaLine 28 ==> SourceLine 20
                sysout().outint(which,7);
                // JavaLine 30 ==> SourceLine 21
                while(true) {
                    // JavaLine 32 ==> SourceLine 22
                    {
                        TRACE_BEGIN_STM$("CompoundStatement22",22);
                        if(VALUE$((nextev().evtime()>((((PrimeUnder$PBLK14)(CUR$.SL$)).time()+(((double)(1)))))))) {
                            // JavaLine 36 ==> SourceLine 23
                            ((PrimeUnder$PBLK14)(CUR$.SL$)).ActivateDelay(false,new PrimeUnder$PBLK14$Prime(((PrimeUnder$PBLK14)(CUR$.SL$))).START(),1,false);
                        }
                        // JavaLine 39 ==> SourceLine 24
                        ((PrimeUnder$PBLK14)(CUR$.SL$)).hold(((double)(which)));
                        TRACE_END_STM$("CompoundStatement22",24);
                    }
                       if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                }
                // JavaLine 45 ==> SourceLine 18
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Prime",18);
                }
                TRACE_END_STM$("Prime",18);
            }
        };
    } // End of Constructor
    // Class Statements
    public PrimeUnder$PBLK14$Prime STM$() { return((PrimeUnder$PBLK14$Prime)CODE$.EXEC$()); }
    public PrimeUnder$PBLK14$Prime START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("PrimeUnder.sim","Class Prime",1,16,12,17,24,18,26,19,28,20,30,21,32,22,36,23,39,24,45,18,56,26);
}
