// JavaLine 1 <== SourceLine 857
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$CompoundStatement853$SubBlock857 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=857, lastLine=864, hasLocalClasses=false, System=false
    // Declare locals as attributes
    boolean b=false;
    // JavaLine 10 <== SourceLine 858
    Common$const$ c=null;
    // Normal Constructor
    public Common$prt$CompoundStatement853$SubBlock857(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 20 <== SourceLine 859
        b=(((Common$quant)(((Common$prt)(CUR$.SL$)).inspect$804$16)).initval$3.cardinal()>(1));
        ;
        c=((Common$const$)(((Common$quant)(((Common$prt)(CUR$.SL$)).inspect$804$16)).initval$3.first()));
        ;
        // JavaLine 25 <== SourceLine 860
        sysout().outchar('=');
        ;
        if(VALUE$(b)) {
            sysout().outchar('(');
        }
        ;
        new Common$prt(((Common)(CUR$.SL$.SL$)),c,0);
        ;
        c=((Common$const$)(c.suc()));
        while((c!=(null))) {
            // JavaLine 36 <== SourceLine 862
            {
                sysout().outchar(',');
                ;
                new Common$prt(((Common)(CUR$.SL$.SL$)),c,0);
            }
            c=((Common$const$)(c.suc()));
        }
        ;
        // JavaLine 45 <== SourceLine 863
        if(VALUE$(b)) {
            sysout().outchar(')');
        }
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock857",1,857,10,858,20,859,25,860,36,862,45,863,52,864);
} // End of SubBlock
