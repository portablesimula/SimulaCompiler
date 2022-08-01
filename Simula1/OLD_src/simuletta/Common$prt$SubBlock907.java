// JavaLine 1 <== SourceLine 907
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:22:27 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock907 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=907, lastLine=912, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common$expr x=null;
    // Normal Constructor
    public Common$prt$SubBlock907(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        x=((Common$expr)(((Common$repexpr)(((Common$prt)(CUR$.SL$)).inspect$790$16)).p3$exprset.first()));
        ;
        sysout().outchar('(');
        ;
        new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
        ;
        x=((Common$expr)(x.suc()));
        while((x!=(null))) {
            // JavaLine 26 <== SourceLine 909
            {
                sysout().outchar(',');
                ;
                new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
            }
            x=((Common$expr)(x.suc()));
        }
        ;
        // JavaLine 35 <== SourceLine 910
        sysout().outchar(')');
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock907",1,907,26,909,35,910,40,912);
} // End of SubBlock
