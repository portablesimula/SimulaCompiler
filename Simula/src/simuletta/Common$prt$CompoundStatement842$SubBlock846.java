// JavaLine 1 <== SourceLine 846
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:26:02 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$CompoundStatement842$SubBlock846 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=846, lastLine=853, hasLocalClasses=false, System=false
    // Declare locals as attributes
    boolean b=false;
    // JavaLine 10 <== SourceLine 847
    Common$const$ c=null;
    // Normal Constructor
    public Common$prt$CompoundStatement842$SubBlock846(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 20 <== SourceLine 848
        b=(((Common$quant)(((Common$prt)(CUR$.SL$)).inspect$793$16)).initval$3.cardinal()>(1));
        ;
        c=((Common$const$)(((Common$quant)(((Common$prt)(CUR$.SL$)).inspect$793$16)).initval$3.first()));
        ;
        // JavaLine 25 <== SourceLine 849
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
            // JavaLine 36 <== SourceLine 851
            {
                sysout().outchar(',');
                ;
                new Common$prt(((Common)(CUR$.SL$.SL$)),c,0);
            }
            c=((Common$const$)(c.suc()));
        }
        ;
        // JavaLine 45 <== SourceLine 852
        if(VALUE$(b)) {
            sysout().outchar(')');
        }
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock846",1,846,10,847,20,848,25,849,36,851,45,852,52,853);
} // End of SubBlock
