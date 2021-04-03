// JavaLine 1 <== SourceLine 1877
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 17:46:07 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$grammar$SubBlock1877 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=4, firstLine=1877, lastLine=1882, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Link$ x=null;
    Link$ y=null;
    // Normal Constructor
    public Pass1$SubBlock32$grammar$SubBlock1877(RTObject$ staticLink) {
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
            // JavaLine 23 <== SourceLine 1879
            {
                y=x.suc();
                ;
                // JavaLine 27 <== SourceLine 1880
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
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","SubBlock SubBlock1877",1,1877,23,1879,27,1880,38,1882);
} // End of SubBlock
