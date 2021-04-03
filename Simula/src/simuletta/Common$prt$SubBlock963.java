// JavaLine 1 <== SourceLine 963
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:26:02 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock963 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=963, lastLine=969, hasLocalClasses=false, System=false
    // Declare locals as attributes
    int i=0;
    // Normal Constructor
    public Common$prt$SubBlock963(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 18 <== SourceLine 964
        sysout().outtext(CONC(new TXT$("field("),((Common)(CUR$.SL$.SL$)).symtab.Elt[((Common$offset_const)(((Common$prt)(CUR$.SL$)).inspect$793$16)).of$4-((Common)(CUR$.SL$.SL$)).symtab.LB[0]].symbol));
        ;
        for(i=1;i<=((Common$offset_const)(((Common$prt)(CUR$.SL$)).inspect$793$16)).ndot$4;i++) {
            // JavaLine 22 <== SourceLine 966
            sysout().outtext(CONC(new TXT$("."),((Common)(CUR$.SL$.SL$)).symtab.Elt[((Common$offset_const)(((Common$prt)(CUR$.SL$)).inspect$793$16)).q.Elt[i-((Common$offset_const)(((Common$prt)(CUR$.SL$)).inspect$793$16)).q.LB[0]]-((Common)(CUR$.SL$.SL$)).symtab.LB[0]].symbol));
        }
        ;
        // JavaLine 26 <== SourceLine 967
        sysout().outchar(')');
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock963",1,963,18,964,22,966,26,967,31,969);
} // End of SubBlock
