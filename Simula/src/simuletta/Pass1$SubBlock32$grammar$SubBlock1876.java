// JavaLine 1 <== SourceLine 1876
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 15:04:59 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$grammar$SubBlock1876 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=4, firstLine=1876, lastLine=1881, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Link$ x=null;
    Link$ y=null;
    // Normal Constructor
    public Pass1$SubBlock32$grammar$SubBlock1876(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        y=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.TRC_info$1.first();
        ;
        x=y;
        while((x!=(null))) {
            // JavaLine 23 <== SourceLine 1878
            {
                y=x.suc();
                ;
                // JavaLine 27 <== SourceLine 1879
                if(VALUE$(IS$(x,Common$trace_item.class))) {
                    x.into(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.TRC_init$1);
                }
                ;
            }
            x=y;
        }
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","SubBlock SubBlock1876",1,1876,23,1878,27,1879,38,1881);
} // End of SubBlock
