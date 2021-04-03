// JavaLine 1 <== SourceLine 973
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock973 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=973, lastLine=979, hasLocalClasses=false, System=false
    // Declare locals as attributes
    int i=0;
    // Normal Constructor
    public Common$prt$SubBlock973(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 18 <== SourceLine 974
        sysout().outtext(CONC(new TXT$("field("),new Common$edSymbol(((Common)(CUR$.SL$.SL$)),((Common$offset_const)(((Common$prt)(CUR$.SL$)).inspect$804$16)).of$4).RESULT$));
        ;
        for(i=1;i<=((Common$offset_const)(((Common$prt)(CUR$.SL$)).inspect$804$16)).ndot$4;i++) {
            // JavaLine 22 <== SourceLine 976
            sysout().outtext(CONC(new TXT$("."),new Common$edSymbol(((Common)(CUR$.SL$.SL$)),((Common$offset_const)(((Common$prt)(CUR$.SL$)).inspect$804$16)).q.Elt[i-((Common$offset_const)(((Common$prt)(CUR$.SL$)).inspect$804$16)).q.LB[0]]).RESULT$));
        }
        ;
        // JavaLine 26 <== SourceLine 977
        sysout().outchar(')');
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock973",1,973,18,974,22,976,26,977,31,979);
} // End of SubBlock
