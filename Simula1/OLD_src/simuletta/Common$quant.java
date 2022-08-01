// JavaLine 1 <== SourceLine 625
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Common$quant extends Common$descr {
    // ClassDeclaration: Kind=Class, BlockLevel=2, PrefixLevel=3, firstLine=625, lastLine=630, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    public int p3$type;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 626
    public boolean preped$3=false;
    public boolean read_only$3=false;
    // JavaLine 14 <== SourceLine 627
    public int count$3=0;
    // JavaLine 16 <== SourceLine 628
    public Head$ initval$3=null;
    // JavaLine 18 <== SourceLine 629
    public TXT$ sysid$3=null;
    // Normal Constructor
    public Common$quant(RTObject$ staticLink,int sp3$type) {
        super(staticLink);
        // Parameter assignment to locals
        this.p3$type = sp3$type;
        // Declaration Code
    }
    // Class Statements
    public Common$quant STM$() {
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // Class descr: Code before inner
        // JavaLine 32 <== SourceLine 584
        global$2=(((Common)(CUR$.SL$)).rutlev$1==(0));
        ;
        // JavaLine 35 <== SourceLine 630
        // Class quant: Code before inner
        // Class quant: Code after inner
        // Class descr: Code after inner
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Class quant",1,625,11,626,14,627,16,628,18,629,32,584,35,630,41,630);
} // End of Class
