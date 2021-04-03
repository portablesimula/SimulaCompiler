// JavaLine 1 <== SourceLine 31
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:46 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InptFile$inbyt$SubBlock31 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=31, lastLine=35, hasLocalClasses=false, System=false
    // Declare locals as attributes
    int b=0;
    // Normal Constructor
    public InptFile$inbyt$SubBlock31(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 18 <== SourceLine 32
        ((InptFile$inbyt)(CUR$.SL$)).RESULT$=b=((InptFile)(CUR$.SL$.SL$)).inbyte();
        ;
        // JavaLine 21 <== SourceLine 33
        if(VALUE$((((InptFile)(CUR$.SL$.SL$)).input_trace$3>(0)))) {
            // JavaLine 23 <== SourceLine 34
            {
                new InptFile$outcode(((InptFile)(CUR$.SL$.SL$)));
                ;
                new InptFile$TRC(((InptFile)(CUR$.SL$.SL$)),new TXT$("Inbyte"),new Common$leftint(((InptFile$inbyt)(CUR$.SL$)).inspect$30$34,b).RESULT$);
                ;
            }
        }
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("INPTFILE.sim","SubBlock SubBlock31",1,31,18,32,21,33,23,34,34,35);
} // End of SubBlock
