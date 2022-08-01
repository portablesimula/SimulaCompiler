// JavaLine 1 <== SourceLine 970
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:50:34 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock970 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=970, lastLine=976, hasLocalClasses=false, System=false
    // Declare locals as attributes
    int i=0;
    // Normal Constructor
    public Common$prt$SubBlock970(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 18 <== SourceLine 971
        sysout().outtext(CONC(new TXT$("field("),((Common)(CUR$.SL$.SL$)).symtab.Elt[((Common$offset_const)(((Common$prt)(CUR$.SL$)).inspect$800$16)).of$4-((Common)(CUR$.SL$.SL$)).symtab.LB[0]].symbol));
        ;
        for(i=1;i<=((Common$offset_const)(((Common$prt)(CUR$.SL$)).inspect$800$16)).ndot$4;i++) {
            // JavaLine 22 <== SourceLine 973
            sysout().outtext(CONC(new TXT$("."),((Common)(CUR$.SL$.SL$)).symtab.Elt[((Common$offset_const)(((Common$prt)(CUR$.SL$)).inspect$800$16)).q.Elt[i-((Common$offset_const)(((Common$prt)(CUR$.SL$)).inspect$800$16)).q.LB[0]]-((Common)(CUR$.SL$.SL$)).symtab.LB[0]].symbol));
        }
        ;
        // JavaLine 26 <== SourceLine 974
        sysout().outchar(')');
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock970",1,970,18,971,22,973,26,974,31,976);
} // End of SubBlock
