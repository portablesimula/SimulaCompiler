// JavaLine 1 <== SourceLine 16
package simulaTestPrograms;
// Simula-1.0 Compiled at Fri Apr 10 13:32:11 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class issue38$$macro_scan extends CLASS$ {
    // ClassDeclaration: Kind=Class, BlockLevel=2, PrefixLevel=0, firstLine=16, lastLine=17, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    public TXT$ p$id;
    public issue38$$macro p$mac;
    // Declare locals as attributes
    // Normal Constructor
    public issue38$$macro_scan(RTObject$ staticLink,TXT$ sp$id,issue38$$macro sp$mac) {
        super(staticLink);
        // Parameter assignment to locals
        this.p$id = sp$id;
        this.p$mac = sp$mac;
        BBLK(); // Iff no prefix
        // Declaration Code
    }
    // Class Statements
    public issue38$$macro_scan STM$() {
        // JavaLine 23 <== SourceLine 17
        // Class macro_scan: Code before inner
        // Class macro_scan: Code after inner
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("issue38.sim","Class macro_scan",1,16,23,17,28,17);
} // End of Class
