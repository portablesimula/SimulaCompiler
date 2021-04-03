// JavaLine 1 <== SourceLine 19
package simulaTestPrograms;
// Simula-1.0 Compiled at Fri Apr 10 13:32:11 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class issue38$$getsymb extends FILE$ {
    // ClassDeclaration: Kind=Class, BlockLevel=2, PrefixLevel=2, firstLine=19, lastLine=37, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 20
    public FILE$ prev$2=null;
    // JavaLine 12 <== SourceLine 21
    public InFile$ inpt$2=null;
    // JavaLine 14 <== SourceLine 22
    public char c$2=0;
    public char startpos$2=0;
    public char ampos$2=0;
    public char lng$2=0;
    public int s$2=0;
    public int n$2=0;
    public int v$2=0;
    // JavaLine 22 <== SourceLine 23
    public char impos$2=0;
    public char imlen$2=0;
    // JavaLine 25 <== SourceLine 24
    public TXT$ inim$2=null;
    // JavaLine 27 <== SourceLine 25
    public TXT$ t$2=null;
    public TXT$ id$2=null;
    // JavaLine 30 <== SourceLine 28
    public issue38$$Meaning inspect$27$0$2=null;
    // Normal Constructor
    public issue38$$getsymb(RTObject$ staticLink,TXT$ sFILENAME$) {
        super(staticLink,sFILENAME$);
        // Parameter assignment to locals
        // Declaration Code
    }
    // Class Statements
    public issue38$$getsymb STM$() {
        // Class RTObject: Code before inner
        // Class FILE: Code before inner
        // JavaLine 42 <== SourceLine 27
        // Class getsymb: Code before inner
        {
            // BEGIN INSPECTION 
            inspect$27$0$2=((issue38$)(CUR$.SL$)).curmeaning;
            //INSPECT inspect$27$0
            if(inspect$27$0$2 instanceof issue38$$macro) // WHEN issue38$$macro DO 
            // JavaLine 49 <== SourceLine 29
            {
                if(VALUE$((((issue38$)(CUR$.SL$)).msc!=(null)))) {
                    call(((issue38$)(CUR$.SL$)).msc);
                } else
                // JavaLine 54 <== SourceLine 30
                new issue38$$macro_scan(((issue38$)(CUR$.SL$)),new TXT$("***macro***"),((issue38$$macro)inspect$27$0$2)).STM$();
            }
            else if(inspect$27$0$2 instanceof issue38$$mnemonic) // WHEN issue38$$mnemonic DO 
            // JavaLine 58 <== SourceLine 36
            {
            }
        }
        // JavaLine 62 <== SourceLine 27
        // Class getsymb: Code after inner
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("issue38.sim","Class getsymb",1,19,10,20,12,21,14,22,22,23,25,24,27,25,30,28,42,27,49,29,54,30,58,36,62,27,66,37);
} // End of Class
