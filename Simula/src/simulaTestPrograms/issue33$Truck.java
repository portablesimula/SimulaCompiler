// JavaLine 1 <== SourceLine 6
package simulaTestPrograms;
// Simula-1.0 Compiled at Wed Jun 05 16:10:06 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class issue33$Truck extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=3, firstLine=6, lastLine=10, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 7
    public issue33$Truck inspect$7$0$3=null;
    // Normal Constructor
    public issue33$Truck(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("Truck",7);
    }
    // Class Statements
    public issue33$Truck STM$() {
        TRACE_BEGIN_STM$("Truck",7);
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // Class Process: Code before inner
        // JavaLine 27 <== SourceLine 1
        detach();
        // JavaLine 29 <== SourceLine 7
        // Class Truck: Code before inner
        {
            // BEGIN INSPECTION 
            inspect$7$0$3=((issue33)(CUR$.SL$)).x$2;
            if(inspect$7$0$3!=null) // INSPECT inspect$7$0
            // JavaLine 35 <== SourceLine 8
            {
                TRACE_BEGIN_STM$("CompoundStatement8",8);
                ((issue33$Truck)(CUR$.SL$)).into(((issue33)(CUR$.SL$)).queue$2);
                TRACE_END_STM$("CompoundStatement8",8);
            }
        }
        // JavaLine 42 <== SourceLine 7
        // Class Truck: Code after inner
        // Class Process: Code after inner
        // JavaLine 45 <== SourceLine 1
        terminate();
        // JavaLine 47 <== SourceLine 7
        TRACE_END_STM$("Truck",7);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("issue33.sim","Class Truck",1,6,12,7,27,1,29,7,35,8,42,7,45,1,47,7,51,10);
} // End of Class
