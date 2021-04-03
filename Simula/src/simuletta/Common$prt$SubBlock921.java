// JavaLine 1 <== SourceLine 921
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock921 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=921, lastLine=926, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common$expr x=null;
    // Normal Constructor
    public Common$prt$SubBlock921(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        x=((Common$expr)(((Common$repexpr)(((Common$prt)(CUR$.SL$)).inspect$804$16)).p3$exprset.first()));
        ;
        sysout().outchar('(');
        ;
        new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
        ;
        x=((Common$expr)(x.suc()));
        while((x!=(null))) {
            // JavaLine 26 <== SourceLine 923
            {
                sysout().outchar(',');
                ;
                new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
            }
            x=((Common$expr)(x.suc()));
        }
        ;
        // JavaLine 35 <== SourceLine 924
        sysout().outchar(')');
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock921",1,921,26,923,35,924,40,926);
} // End of SubBlock
