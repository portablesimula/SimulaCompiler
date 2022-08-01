// JavaLine 1 <== SourceLine 843
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:22:27 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$CompoundStatement839$SubBlock843 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=843, lastLine=850, hasLocalClasses=false, System=false
    // Declare locals as attributes
    boolean b=false;
    // JavaLine 10 <== SourceLine 844
    Common$const$ c=null;
    // Normal Constructor
    public Common$prt$CompoundStatement839$SubBlock843(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 20 <== SourceLine 845
        b=(((Common$quant)(((Common$prt)(CUR$.SL$)).inspect$790$16)).initval$3.cardinal()>(1));
        ;
        c=((Common$const$)(((Common$quant)(((Common$prt)(CUR$.SL$)).inspect$790$16)).initval$3.first()));
        ;
        // JavaLine 25 <== SourceLine 846
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
            // JavaLine 36 <== SourceLine 848
            {
                sysout().outchar(',');
                ;
                new Common$prt(((Common)(CUR$.SL$.SL$)),c,0);
            }
            c=((Common$const$)(c.suc()));
        }
        ;
        // JavaLine 45 <== SourceLine 849
        if(VALUE$(b)) {
            sysout().outchar(')');
        }
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock843",1,843,10,844,20,845,25,846,36,848,45,849,52,850);
} // End of SubBlock
