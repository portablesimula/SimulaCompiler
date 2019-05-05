// JavaLine 1 <== SourceLine 16
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:21:08 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class PrimeUnder$PBLK14$Prime extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=3, firstLine=16, lastLine=26, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 17
    public int which$3=0;
    // Normal Constructor
    public PrimeUnder$PBLK14$Prime(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("Prime",17);
    }
    // Class Statements
    public PrimeUnder$PBLK14$Prime STM$() {
        TRACE_BEGIN_STM$("Prime",17);
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // Class Process: Code before inner
        // JavaLine 27 <== SourceLine 1
        detach();
        // JavaLine 29 <== SourceLine 18
        // Class Prime: Code before inner
        ((PrimeUnder$PBLK14)(CUR$.SL$)).acc$2=(((PrimeUnder$PBLK14)(CUR$.SL$)).acc$2+(1));
        // JavaLine 32 <== SourceLine 19
        which$3=((int)((int)Math.round(((PrimeUnder$PBLK14)(CUR$.SL$)).time())));
        // JavaLine 34 <== SourceLine 20
        sysout().outint(which$3,7);
        // JavaLine 36 <== SourceLine 21
        while(true) {
            // JavaLine 38 <== SourceLine 22
            {
                TRACE_BEGIN_STM$("CompoundStatement22",22);
                if(VALUE$((nextev().evtime()>((((PrimeUnder$PBLK14)(CUR$.SL$)).time()+(((double)(1)))))))) {
                    // JavaLine 42 <== SourceLine 23
                    ((PrimeUnder$PBLK14)(CUR$.SL$)).ActivateDelay(false,((PrimeUnder$PBLK14$Prime)new PrimeUnder$PBLK14$Prime(((PrimeUnder$PBLK14)(CUR$.SL$))).START$()),1,false);
                }
                // JavaLine 45 <== SourceLine 24
                ((PrimeUnder$PBLK14)(CUR$.SL$)).hold(((double)(which$3)));
                TRACE_END_STM$("CompoundStatement22",24);
            }
            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
        }
        // JavaLine 51 <== SourceLine 18
        // Class Prime: Code after inner
        // Class Process: Code after inner
        // JavaLine 54 <== SourceLine 1
        terminate();
        // JavaLine 56 <== SourceLine 18
        TRACE_END_STM$("Prime",18);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("PrimeUnder.sim","Class Prime",1,16,12,17,27,1,29,18,32,19,34,20,36,21,38,22,42,23,45,24,51,18,54,1,56,18,60,26);
} // End of Class
