// JavaLine 1 <== SourceLine 619
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Common$peculiar extends Common$profile {
    // ClassDeclaration: Kind=Class, BlockLevel=2, PrefixLevel=4, firstLine=619, lastLine=623, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    public int p4$kind;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 620
    public Head$ local$4=null;
    // JavaLine 13 <== SourceLine 621
    public int body$4=0;
    // JavaLine 15 <== SourceLine 622
    public TXT$ info$4=null;
    // Normal Constructor
    public Common$peculiar(RTObject$ staticLink,int sp4$kind) {
        super(staticLink);
        // Parameter assignment to locals
        this.p4$kind = sp4$kind;
        // Declaration Code
    }
    // Class Statements
    public Common$peculiar STM$() {
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // Class descr: Code before inner
        // JavaLine 29 <== SourceLine 584
        global$2=(((Common)(CUR$.SL$)).rutlev$1==(0));
        ;
        // JavaLine 32 <== SourceLine 622
        // Class profile: Code before inner
        // JavaLine 34 <== SourceLine 623
        // Class peculiar: Code before inner
        // Class peculiar: Code after inner
        // Class profile: Code after inner
        // Class descr: Code after inner
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Class peculiar",1,619,11,620,13,621,15,622,29,584,32,622,34,623,41,623);
} // End of Class
