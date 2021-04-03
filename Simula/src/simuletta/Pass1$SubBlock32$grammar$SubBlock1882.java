// JavaLine 1 <== SourceLine 1882
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$grammar$SubBlock1882 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=4, firstLine=1882, lastLine=1887, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Link$ x=null;
    Link$ y=null;
    // Normal Constructor
    public Pass1$SubBlock32$grammar$SubBlock1882(RTObject$ staticLink) {
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
            // JavaLine 23 <== SourceLine 1884
            {
                y=x.suc();
                ;
                // JavaLine 27 <== SourceLine 1885
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
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","SubBlock SubBlock1882",1,1882,23,1884,27,1885,38,1887);
} // End of SubBlock
