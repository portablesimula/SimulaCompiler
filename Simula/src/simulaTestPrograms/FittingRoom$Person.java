// JavaLine 1 <== SourceLine 44
package simulaTestPrograms;
// Simula-1.0 Compiled at Thu May 23 15:35:48 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class FittingRoom$Person extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=3, firstLine=44, lastLine=54, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public TXT$ p3$pname;
    // Declare locals as attributes
    // Normal Constructor
    public FittingRoom$Person(RTObject$ staticLink,TXT$ sp3$pname) {
        super(staticLink);
        // Parameter assignment to locals
        this.p3$pname = sp3$pname;
        // Declaration Code
        TRACE_BEGIN_DCL$("Person",44);
    }
    // Class Statements
    public FittingRoom$Person STM$() {
        TRACE_BEGIN_STM$("Person",44);
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // Class Process: Code before inner
        // JavaLine 27 <== SourceLine 1
        detach();
        // JavaLine 29 <== SourceLine 45
        // Class Person: Code before inner
        while(true) {
            // JavaLine 32 <== SourceLine 46
            {
                TRACE_BEGIN_STM$("CompoundStatement46",46);
                ((FittingRoom)(CUR$.SL$)).hold(normal(((double)(12)),((double)(4)),((FittingRoom)(CUR$.SL$)).u$2));
                // JavaLine 36 <== SourceLine 47
                new FittingRoom$report(((FittingRoom)(CUR$.SL$)),CONC(p3$pname,new TXT$(" is requesting the fitting room")));
                // JavaLine 38 <== SourceLine 48
                new FittingRoom$FittingRoom$request(((FittingRoom)(CUR$.SL$)).fittingRoom1$2);
                // JavaLine 40 <== SourceLine 49
                new FittingRoom$report(((FittingRoom)(CUR$.SL$)),CONC(p3$pname,new TXT$(" has entered the fitting room")));
                // JavaLine 42 <== SourceLine 50
                ((FittingRoom)(CUR$.SL$)).hold(normal(((double)(3)),((double)(1)),((FittingRoom)(CUR$.SL$)).u$2));
                // JavaLine 44 <== SourceLine 51
                new FittingRoom$FittingRoom$leave(((FittingRoom)(CUR$.SL$)).fittingRoom1$2);
                // JavaLine 46 <== SourceLine 52
                new FittingRoom$report(((FittingRoom)(CUR$.SL$)),CONC(p3$pname,new TXT$(" has left the fitting room")));
                TRACE_END_STM$("CompoundStatement46",52);
            }
            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
        }
        // JavaLine 52 <== SourceLine 45
        // Class Person: Code after inner
        // Class Process: Code after inner
        // JavaLine 55 <== SourceLine 1
        terminate();
        // JavaLine 57 <== SourceLine 45
        TRACE_END_STM$("Person",45);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Class Person",1,44,27,1,29,45,32,46,36,47,38,48,40,49,42,50,44,51,46,52,52,45,55,1,57,45,61,54);
} // End of Class
