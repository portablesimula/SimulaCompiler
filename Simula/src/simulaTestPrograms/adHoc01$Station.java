package simulaTestPrograms;
// Simula-1.0 Compiled at Tue May 28 14:08:55 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class adHoc01$Station extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=3, lastLine=7, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public adHoc01$Station(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("Station",3);
    }
    // Class Statements
    public adHoc01$Station STM$() {
        TRACE_BEGIN_STM$("Station",3);
        // JavaLine 21 <== SourceLine 7
        // Class Station: Code before inner
        // Class Station: Code after inner
        TRACE_END_STM$("Station",7);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc01.sim","Class Station",21,7,27,7);
} // End of Class
