// JavaLine 1 <== SourceLine 905
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:20:00 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock905 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=905, lastLine=910, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common$expr x=null;
    // Normal Constructor
    public Common$prt$SubBlock905(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        x=((Common$expr)(((Common$repexpr)(((Common$prt)(CUR$.SL$)).inspect$788$16)).p3$exprset.first()));
        ;
        sysout().outchar('(');
        ;
        new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
        ;
        x=((Common$expr)(x.suc()));
        while((x!=(null))) {
            // JavaLine 26 <== SourceLine 907
            {
                sysout().outchar(',');
                ;
                new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
            }
            x=((Common$expr)(x.suc()));
        }
        ;
        // JavaLine 35 <== SourceLine 908
        sysout().outchar(')');
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock905",1,905,26,907,35,908,40,910);
} // End of SubBlock
