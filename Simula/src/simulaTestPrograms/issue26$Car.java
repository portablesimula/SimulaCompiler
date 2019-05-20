// JavaLine 1 <== SourceLine 9
package simulaTestPrograms;
// Simula-1.0 Compiled at Mon May 20 10:13:03 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class issue26$Car extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=3, firstLine=9, lastLine=14, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public TXT$ p3$pname;
    // Declare locals as attributes
    // Normal Constructor
    public issue26$Car(RTObject$ staticLink,TXT$ sp3$pname) {
        super(staticLink);
        // Parameter assignment to locals
        this.p3$pname = sp3$pname;
        // Declaration Code
        TRACE_BEGIN_DCL$("Car",9);
    }
    // Class Statements
    public issue26$Car STM$() {
        TRACE_BEGIN_STM$("Car",9);
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // Class Process: Code before inner
        // JavaLine 27 <== SourceLine 1
        detach();
        // JavaLine 29 <== SourceLine 11
        // Class Car: Code before inner
        new issue26$report(((issue26)(CUR$.SL$)),CONC(p3$pname,new TXT$(" is Initiating")));
        // JavaLine 32 <== SourceLine 12
        ((issue26)(CUR$.SL$)).hold(((double)(4)));
        // JavaLine 34 <== SourceLine 13
        new issue26$report(((issue26)(CUR$.SL$)),CONC(p3$pname,new TXT$(" is Terminating")));
        // JavaLine 36 <== SourceLine 11
        // Class Car: Code after inner
        // Class Process: Code after inner
        // JavaLine 39 <== SourceLine 1
        terminate();
        // JavaLine 41 <== SourceLine 11
        TRACE_END_STM$("Car",11);
		RT.println("Process$.STM$: CUR$=" + CUR$.edObjectAttributes());
		RT.println("Process$.STM$: this=" + this.edObjectAttributes());
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("issue26.sim","Class Car",1,9,27,1,29,11,32,12,34,13,36,11,39,1,41,11,45,14);
} // End of Class
