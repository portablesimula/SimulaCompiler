// JavaLine 1 <== SourceLine 46
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Pass1$SubBlock32$sourceElt extends CLASS$ {
    // ClassDeclaration: Kind=Class, BlockLevel=3, PrefixLevel=0, firstLine=46, lastLine=66, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 47
    public Pass1$SubBlock32$sourceElt prev=null;
    // JavaLine 12 <== SourceLine 48
    public InFile$ inptf=null;
    public int linenr=0;
    // Normal Constructor
    public Pass1$SubBlock32$sourceElt(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
    }
    // Class Statements
    public Pass1$SubBlock32$sourceElt STM$() {
        // JavaLine 24 <== SourceLine 58
        // Class sourceElt: Code before inner
        prev=((Pass1$SubBlock32)(CUR$.SL$)).cursource;
        ;
        // JavaLine 28 <== SourceLine 59
        if(VALUE$((prev!=(null)))) {
            prev.linenr=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.curline$1;
        }
        ;
        // JavaLine 33 <== SourceLine 60
        if(VALUE$(TXTREL$EQ(lowcase(copy(copy(((Pass1$SubBlock32)(CUR$.SL$)).source_file))),new TXT$("sysin")))) {
            // JavaLine 35 <== SourceLine 61
            inptf=sysin();
        } else
        // JavaLine 38 <== SourceLine 62
        {
            inptf=new InFile$(((BASICIO$)CTX$),((Pass1$SubBlock32)(CUR$.SL$)).source_file).STM$();
            ;
            // JavaLine 42 <== SourceLine 63
            inptf.open(blanks(256));
        }
        ;
        // JavaLine 46 <== SourceLine 64
        ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.curline$1=0;
        ;
        // JavaLine 49 <== SourceLine 65
        ((Pass1$SubBlock32)(CUR$.SL$)).inserted=Math.addExact(((Pass1$SubBlock32)(CUR$.SL$)).inserted,1);
        ;
        // JavaLine 52 <== SourceLine 58
        // Class sourceElt: Code after inner
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Class sourceElt",1,46,10,47,12,48,24,58,28,59,33,60,35,61,38,62,42,63,46,64,49,65,52,58,56,66);
} // End of Class
