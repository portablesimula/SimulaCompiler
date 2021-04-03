// JavaLine 1 <== SourceLine 910
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:26:02 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock910 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=910, lastLine=915, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common$expr x=null;
    // Normal Constructor
    public Common$prt$SubBlock910(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        x=((Common$expr)(((Common$repexpr)(((Common$prt)(CUR$.SL$)).inspect$793$16)).p3$exprset.first()));
        ;
        sysout().outchar('(');
        ;
        new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
        ;
        x=((Common$expr)(x.suc()));
        while((x!=(null))) {
            // JavaLine 26 <== SourceLine 912
            {
                sysout().outchar(',');
                ;
                new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
            }
            x=((Common$expr)(x.suc()));
        }
        ;
        // JavaLine 35 <== SourceLine 913
        sysout().outchar(')');
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock910",1,910,26,912,35,913,40,915);
} // End of SubBlock
