// JavaLine 1 <== SourceLine 578
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Common$descr extends Link$ {
    // ClassDeclaration: Kind=Class, BlockLevel=2, PrefixLevel=2, firstLine=578, lastLine=585, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 579
    public Common$symbolbox symb$2=null;
    // JavaLine 12 <== SourceLine 580
    public int tag$2=0;
    // JavaLine 14 <== SourceLine 581
    public int xtag$2=0;
    // JavaLine 16 <== SourceLine 582
    public boolean global$2=false;
    public boolean visible$2=false;
    // Normal Constructor
    public Common$descr(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
    }
    // Class Statements
    public Common$descr STM$() {
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // Class descr: Code before inner
        global$2=(((Common)(CUR$.SL$)).rutlev$1==(0));
        ;
        // Class descr: Code after inner
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Class descr",1,578,10,579,12,580,14,581,16,582,35,585);
} // End of Class
