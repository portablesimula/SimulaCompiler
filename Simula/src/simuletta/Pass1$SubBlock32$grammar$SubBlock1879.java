// JavaLine 1 <== SourceLine 1879
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 18:09:19 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$grammar$SubBlock1879 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=4, firstLine=1879, lastLine=1884, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Link$ x=null;
    Link$ y=null;
    // Normal Constructor
    public Pass1$SubBlock32$grammar$SubBlock1879(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        y=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$0.TRC_info$1.first();
        ;
        x=y;
        while((x!=(null))) {
            // JavaLine 23 <== SourceLine 1881
            {
                y=x.suc();
                ;
                // JavaLine 27 <== SourceLine 1882
                if(VALUE$(IS$(x,Common$trace_item.class))) {
                    x.into(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$0.TRC_init$1);
                }
                ;
            }
            x=y;
        }
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","SubBlock SubBlock1879",1,1879,23,1881,27,1882,38,1884);
} // End of SubBlock
