// JavaLine 1 ==> SourceLine 5
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu Jan 24 17:24:18 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class PrimeUnder$PBLK3$Prime extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=3, firstLine=5, lastLine=15, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 6
    public int which=0;
    // Normal Constructor
    public PrimeUnder$PBLK3$Prime(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("Prime",6);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("Prime",6,inner);
                // JavaLine 24 ==> SourceLine 7
                ((PrimeUnder$PBLK3)(CUR$.SL$)).acc=(((PrimeUnder$PBLK3)(CUR$.SL$)).acc+(1));
                // JavaLine 26 ==> SourceLine 8
                which=((int)((int)Math.round(((PrimeUnder$PBLK3)(CUR$.SL$)).time())));
                // JavaLine 28 ==> SourceLine 9
                sysout().outint(which,7);
                // JavaLine 30 ==> SourceLine 10
                while(true) {
                    // JavaLine 32 ==> SourceLine 11
                    {
                        TRACE_BEGIN_STM$("CompoundStatement11",11);
                        if((nextev().evtime()>((((PrimeUnder$PBLK3)(CUR$.SL$)).time()+(((double)(1))))))) {
                            // JavaLine 36 ==> SourceLine 12
                            ((PrimeUnder$PBLK3)(CUR$.SL$)).ActivateDelay(false,new PrimeUnder$PBLK3$Prime(((PrimeUnder$PBLK3)(CUR$.SL$))).START(),1,false);
                        }
                        // JavaLine 39 ==> SourceLine 13
                        ((PrimeUnder$PBLK3)(CUR$.SL$)).hold(((double)(which)));
                        TRACE_END_STM$("CompoundStatement11",13);
                    }
                       if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                }
                // JavaLine 45 ==> SourceLine 7
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Prime",7);
                }
                TRACE_END_STM$("Prime",7);
            }
        };
    } // End of Constructor
    // Class Statements
    public PrimeUnder$PBLK3$Prime STM$() { return((PrimeUnder$PBLK3$Prime)CODE$.EXEC$()); }
    public PrimeUnder$PBLK3$Prime START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("PrimeUnder.sim","Class Prime",1,5,12,6,24,7,26,8,28,9,30,10,32,11,36,12,39,13,45,7,56,15);
}
