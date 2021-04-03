// JavaLine 1 <== SourceLine 965
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:46:15 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock965 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=965, lastLine=971, hasLocalClasses=false, System=false
    // Declare locals as attributes
    int i=0;
    // Normal Constructor
    public Common$prt$SubBlock965(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 18 <== SourceLine 966
        sysout().outtext(CONC(new TXT$("field("),((Common)(CUR$.SL$.SL$)).symtab.Elt[((Common$offset_const)(((Common$prt)(CUR$.SL$)).inspect$795$16)).of$4-((Common)(CUR$.SL$.SL$)).symtab.LB[0]].symbol));
        ;
        for(i=1;i<=((Common$offset_const)(((Common$prt)(CUR$.SL$)).inspect$795$16)).ndot$4;i++) {
            // JavaLine 22 <== SourceLine 968
            sysout().outtext(CONC(new TXT$("."),((Common)(CUR$.SL$.SL$)).symtab.Elt[((Common$offset_const)(((Common$prt)(CUR$.SL$)).inspect$795$16)).q.Elt[i-((Common$offset_const)(((Common$prt)(CUR$.SL$)).inspect$795$16)).q.LB[0]]-((Common)(CUR$.SL$.SL$)).symtab.LB[0]].symbol));
        }
        ;
        // JavaLine 26 <== SourceLine 969
        sysout().outchar(')');
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock965",1,965,18,966,22,968,26,969,31,971);
} // End of SubBlock
