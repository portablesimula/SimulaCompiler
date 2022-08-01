// JavaLine 1 <== SourceLine 912
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:46:15 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock912 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=912, lastLine=917, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common$expr x=null;
    // Normal Constructor
    public Common$prt$SubBlock912(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        x=((Common$expr)(((Common$repexpr)(((Common$prt)(CUR$.SL$)).inspect$795$16)).p3$exprset.first()));
        ;
        sysout().outchar('(');
        ;
        new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
        ;
        x=((Common$expr)(x.suc()));
        while((x!=(null))) {
            // JavaLine 26 <== SourceLine 914
            {
                sysout().outchar(',');
                ;
                new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
            }
            x=((Common$expr)(x.suc()));
        }
        ;
        // JavaLine 35 <== SourceLine 915
        sysout().outchar(')');
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock912",1,912,26,914,35,915,40,917);
} // End of SubBlock
