// JavaLine 1 <== SourceLine 848
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:46:15 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$CompoundStatement844$SubBlock848 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=848, lastLine=855, hasLocalClasses=false, System=false
    // Declare locals as attributes
    boolean b=false;
    // JavaLine 10 <== SourceLine 849
    Common$const$ c=null;
    // Normal Constructor
    public Common$prt$CompoundStatement844$SubBlock848(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 20 <== SourceLine 850
        b=(((Common$quant)(((Common$prt)(CUR$.SL$)).inspect$795$16)).initval$3.cardinal()>(1));
        ;
        c=((Common$const$)(((Common$quant)(((Common$prt)(CUR$.SL$)).inspect$795$16)).initval$3.first()));
        ;
        // JavaLine 25 <== SourceLine 851
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
            // JavaLine 36 <== SourceLine 853
            {
                sysout().outchar(',');
                ;
                new Common$prt(((Common)(CUR$.SL$.SL$)),c,0);
            }
            c=((Common$const$)(c.suc()));
        }
        ;
        // JavaLine 45 <== SourceLine 854
        if(VALUE$(b)) {
            sysout().outchar(')');
        }
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock848",1,848,10,849,20,850,25,851,36,853,45,854,52,855);
} // End of SubBlock
