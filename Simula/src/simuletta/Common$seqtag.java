// JavaLine 1 <== SourceLine 572
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Common$seqtag extends CLASS$ {
    // ClassDeclaration: Kind=Class, BlockLevel=2, PrefixLevel=0, firstLine=572, lastLine=573, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    public Common$symbolbox p$box;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 573
    public Common$seqtag next=null;
    public Common$descr d=null;
    // Normal Constructor
    public Common$seqtag(RTObject$ staticLink,Common$symbolbox sp$box) {
        super(staticLink);
        // Parameter assignment to locals
        this.p$box = sp$box;
        BBLK(); // Iff no prefix
        // Declaration Code
    }
    // Class Statements
    public Common$seqtag STM$() {
        // Class seqtag: Code before inner
        // Class seqtag: Code after inner
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Class seqtag",1,572,11,573,28,573);
} // End of Class
