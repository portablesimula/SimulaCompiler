// JavaLine 1 <== SourceLine 969
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 17:55:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock969 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=969, lastLine=975, hasLocalClasses=false, System=false
    // Declare locals as attributes
    int i=0;
    // Normal Constructor
    public Common$prt$SubBlock969(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 18 <== SourceLine 970
        sysout().outtext(CONC(new TXT$("field("),new Common$edSymbol(((Common)(CUR$.SL$.SL$)),((Common$offset_const)(((Common$prt)(CUR$.SL$)).inspect$800$16)).of$4).RESULT$));
        ;
        for(i=1;i<=((Common$offset_const)(((Common$prt)(CUR$.SL$)).inspect$800$16)).ndot$4;i++) {
            // JavaLine 22 <== SourceLine 972
            sysout().outtext(CONC(new TXT$("."),new Common$edSymbol(((Common)(CUR$.SL$.SL$)),((Common$offset_const)(((Common$prt)(CUR$.SL$)).inspect$800$16)).q.Elt[i-((Common$offset_const)(((Common$prt)(CUR$.SL$)).inspect$800$16)).q.LB[0]]).RESULT$));
        }
        ;
        // JavaLine 26 <== SourceLine 973
        sysout().outchar(')');
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock969",1,969,18,970,22,972,26,973,31,975);
} // End of SubBlock
