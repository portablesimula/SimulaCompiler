// JavaLine 1 <== SourceLine 841
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:20:00 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$CompoundStatement837$SubBlock841 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=841, lastLine=848, hasLocalClasses=false, System=false
    // Declare locals as attributes
    boolean b=false;
    // JavaLine 10 <== SourceLine 842
    Common$const$ c=null;
    // Normal Constructor
    public Common$prt$CompoundStatement837$SubBlock841(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 20 <== SourceLine 843
        b=(((Common$quant)(((Common$prt)(CUR$.SL$)).inspect$788$16)).initval$3.cardinal()>(1));
        ;
        c=((Common$const$)(((Common$quant)(((Common$prt)(CUR$.SL$)).inspect$788$16)).initval$3.first()));
        ;
        // JavaLine 25 <== SourceLine 844
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
            // JavaLine 36 <== SourceLine 846
            {
                sysout().outchar(',');
                ;
                new Common$prt(((Common)(CUR$.SL$.SL$)),c,0);
            }
            c=((Common$const$)(c.suc()));
        }
        ;
        // JavaLine 45 <== SourceLine 847
        if(VALUE$(b)) {
            sysout().outchar(')');
        }
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock841",1,841,10,842,20,843,25,844,36,846,45,847,52,848);
} // End of SubBlock
