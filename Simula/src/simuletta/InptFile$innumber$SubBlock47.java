// JavaLine 1 <== SourceLine 47
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:46 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InptFile$innumber$SubBlock47 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=47, lastLine=50, hasLocalClasses=false, System=false
    // Declare locals as attributes
    int n=0;
    // Normal Constructor
    public InptFile$innumber$SubBlock47(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 18 <== SourceLine 48
        ((InptFile$innumber)(CUR$.SL$)).RESULT$=n=((InptFile)(CUR$.SL$.SL$)).in2byte();
        ;
        // JavaLine 21 <== SourceLine 49
        if(VALUE$((((InptFile)(CUR$.SL$.SL$)).input_trace$3>(0)))) {
            new InptFile$TRC(((InptFile)(CUR$.SL$.SL$)),new TXT$("Innumber"),new Common$leftint(((InptFile$innumber)(CUR$.SL$)).inspect$46$36,n).RESULT$);
        }
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("INPTFILE.sim","SubBlock SubBlock47",1,47,18,48,21,49,28,50);
} // End of SubBlock
