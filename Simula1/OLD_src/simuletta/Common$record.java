// JavaLine 1 <== SourceLine 596
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Common$record extends Common$descr {
    // ClassDeclaration: Kind=Class, BlockLevel=2, PrefixLevel=3, firstLine=596, lastLine=601, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 597
    public boolean used_as_type$3=false;
    public boolean dynamic$3=false;
    public boolean indefinite$3=false;
    public boolean packed$3=false;
    // JavaLine 15 <== SourceLine 598
    public Common$symbolbox prefbox$3=null;
    // JavaLine 17 <== SourceLine 600
    public Head$ atrset$3=null;
    public Head$ variantset$3=null;
    // Normal Constructor
    public Common$record(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
    }
    // Class Statements
    public Common$record STM$() {
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // Class descr: Code before inner
        // JavaLine 31 <== SourceLine 584
        global$2=(((Common)(CUR$.SL$)).rutlev$1==(0));
        ;
        // JavaLine 34 <== SourceLine 601
        // Class record: Code before inner
        // Class record: Code after inner
        // Class descr: Code after inner
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Class record",1,596,10,597,15,598,17,600,31,584,34,601,40,601);
} // End of Class
