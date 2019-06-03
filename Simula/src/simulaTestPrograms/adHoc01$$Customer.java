package simulaTestPrograms;
// Simula-1.0 Compiled at Tue May 28 14:01:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class adHoc01$$Customer extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=4, lastLine=11, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 5
    public float servicetime=0.0f;
    public float deptime=0.0f;
    public int minqnr=0;
    // Normal Constructor
    public adHoc01$$Customer(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("Customer",8);
    }
    // Class Statements
    public adHoc01$$Customer STM$() {
        TRACE_BEGIN_STM$("Customer",8);
        // JavaLine 25 <== SourceLine 11
        // Class Customer: Code before inner
        // Class Customer: Code after inner
        TRACE_END_STM$("Customer",11);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc01.sim","Class Customer",10,5,25,11,31,11);
} // End of Class
