// JavaLine 1 <== SourceLine 39
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:46 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InptFile$in2byt$SubBlock39 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=39, lastLine=43, hasLocalClasses=false, System=false
    // Declare locals as attributes
    int b=0;
    // Normal Constructor
    public InptFile$in2byt$SubBlock39(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 18 <== SourceLine 40
        ((InptFile$in2byt)(CUR$.SL$)).RESULT$=b=((InptFile)(CUR$.SL$.SL$)).in2byte();
        ;
        // JavaLine 21 <== SourceLine 41
        if(VALUE$((((InptFile)(CUR$.SL$.SL$)).input_trace$3>(0)))) {
            // JavaLine 23 <== SourceLine 42
            {
                new InptFile$outcode(((InptFile)(CUR$.SL$.SL$)));
                ;
                new InptFile$TRC(((InptFile)(CUR$.SL$.SL$)),new TXT$("In2byte"),new Common$leftint(((InptFile$in2byt)(CUR$.SL$)).inspect$38$35,b).RESULT$);
                ;
            }
        }
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("INPTFILE.sim","SubBlock SubBlock39",1,39,18,40,21,41,23,42,34,43);
} // End of SubBlock
