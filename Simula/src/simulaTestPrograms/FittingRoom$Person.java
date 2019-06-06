// JavaLine 1 <== SourceLine 43
package simulaTestPrograms;
// Simula-1.0 Compiled at Thu Jun 06 13:16:49 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class FittingRoom$Person extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=3, firstLine=43, lastLine=53, hasLocalClasses=false, System=false, detachUsed=false
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
        TRACE_BEGIN_DCL$("Person",43);
    }
    // Class Statements
    public FittingRoom$Person STM$() {
        TRACE_BEGIN_STM$("Person",43);
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // Class Process: Code before inner
        // JavaLine 27 <== SourceLine 1
        detach();
        // JavaLine 29 <== SourceLine 44
        // Class Person: Code before inner
        while(true) {
            // JavaLine 32 <== SourceLine 45
            {
                TRACE_BEGIN_STM$("CompoundStatement45",45);
                ((FittingRoom)(CUR$.SL$)).hold(normal(((double)(12)),((double)(4)),((FittingRoom)(CUR$.SL$)).u$2));
                // JavaLine 36 <== SourceLine 46
                new FittingRoom$report(((FittingRoom)(CUR$.SL$)),CONC(p3$pname,new TXT$(" is requesting the fitting room")));
                // JavaLine 38 <== SourceLine 47
                new FittingRoom$FittingRoom$request(((FittingRoom)(CUR$.SL$)).fittingRoom1$2);
                // JavaLine 40 <== SourceLine 48
                new FittingRoom$report(((FittingRoom)(CUR$.SL$)),CONC(p3$pname,new TXT$(" has entered the fitting room")));
                // JavaLine 42 <== SourceLine 49
                ((FittingRoom)(CUR$.SL$)).hold(normal(((double)(3)),((double)(1)),((FittingRoom)(CUR$.SL$)).u$2));
                // JavaLine 44 <== SourceLine 50
                new FittingRoom$FittingRoom$leave(((FittingRoom)(CUR$.SL$)).fittingRoom1$2);
                // JavaLine 46 <== SourceLine 51
                new FittingRoom$report(((FittingRoom)(CUR$.SL$)),CONC(p3$pname,new TXT$(" has left the fitting room")));
                TRACE_END_STM$("CompoundStatement45",51);
            }
            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
        }
        // JavaLine 52 <== SourceLine 44
        // Class Person: Code after inner
        // Class Process: Code after inner
        // JavaLine 55 <== SourceLine 1
        terminate();
        // JavaLine 57 <== SourceLine 44
        TRACE_END_STM$("Person",44);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Class Person",1,43,27,1,29,44,32,45,36,46,38,47,40,48,42,49,44,50,46,51,52,44,55,1,57,44,61,53);
} // End of Class
