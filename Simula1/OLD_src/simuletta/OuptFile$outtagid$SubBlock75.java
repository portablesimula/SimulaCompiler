// JavaLine 1 <== SourceLine 75
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:45 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class OuptFile$outtagid$SubBlock75 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=75, lastLine=84, hasLocalClasses=false, System=false
    // Declare locals as attributes
    TXT$ id=null;
    // Normal Constructor
    public OuptFile$outtagid$SubBlock75(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 18 <== SourceLine 76
        if(VALUE$((((OuptFile$outtagid)(CUR$.SL$)).p$i==(0)))) {
            new Common$WARNING(((OuptFile$outtagid)(CUR$.SL$)).inspect$74$26,new TXT$("Illegal output tag: ZERO"));
        }
        ;
        // JavaLine 23 <== SourceLine 77
        id=((OuptFile$outtagid)(CUR$.SL$)).inspect$74$26.tagtab.Elt[((OuptFile$outtagid)(CUR$.SL$)).p$i-((OuptFile$outtagid)(CUR$.SL$)).inspect$74$26.tagtab.LB[0]].symbol;
        ;
        // JavaLine 26 <== SourceLine 78
        if(VALUE$(TRF_EQ(id,null))) {
            // JavaLine 28 <== SourceLine 79
            new OuptFile$outtag(((OuptFile)(CUR$.SL$.SL$)),((OuptFile$outtagid)(CUR$.SL$)).p$i);
        } else
        // JavaLine 31 <== SourceLine 80
        {
            ((OuptFile)(CUR$.SL$.SL$)).out2byte(0);
            ;
            new OuptFile$outtag(((OuptFile)(CUR$.SL$.SL$)),((OuptFile$outtagid)(CUR$.SL$)).p$i);
            ;
            // JavaLine 37 <== SourceLine 81
            id=copy(copy(id));
            ;
            upcase(id);
            ;
            // JavaLine 42 <== SourceLine 82
            ((OuptFile)(CUR$.SL$.SL$)).outbyte(TXT$.length(id));
            ;
            ((OuptFile)(CUR$.SL$.SL$)).outtext(id);
            ;
        }
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("OUPTFILE.sim","SubBlock SubBlock75",1,75,18,76,23,77,26,78,28,79,31,80,37,81,42,82,51,84);
} // End of SubBlock
