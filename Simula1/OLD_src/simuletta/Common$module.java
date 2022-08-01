// JavaLine 1 <== SourceLine 514
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Common$module extends Link$ {
    // ClassDeclaration: Kind=Class, BlockLevel=2, PrefixLevel=2, firstLine=514, lastLine=519, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    public TXT$ p2$modid;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 515
    public int bias$2=0;
    public int ntag$2=0;
    public TXT$ modcode$2=null;
    // JavaLine 15 <== SourceLine 516
    public boolean system$2=false;
    public Head$ dclset$2=null;
    // Normal Constructor
    public Common$module(RTObject$ staticLink,TXT$ sp2$modid) {
        super(staticLink);
        // Parameter assignment to locals
        this.p2$modid = sp2$modid;
        // Declaration Code
    }
    // Class Statements
    public Common$module STM$() {
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // Class module: Code before inner
        dclset$2=new Head$(((Common)(CUR$.SL$))).STM$();
        ;
        ((Common$module)(CUR$)).into(((Common)(CUR$.SL$)).modset$1);
        ;
        // Class module: Code after inner
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Class module",1,514,11,515,15,516,37,519);
} // End of Class
