// JavaLine 1 <== SourceLine 50
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$sourceElt$close extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=50, lastLine=56, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Pass1$SubBlock32$sourceElt$close(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass1$SubBlock32$sourceElt$close STM$() {
        // JavaLine 20 <== SourceLine 52
        if(VALUE$((((Pass1$SubBlock32$sourceElt)(CUR$.SL$)).inptf!=(sysin())))) {
            ((Pass1$SubBlock32$sourceElt)(CUR$.SL$)).inptf.close();
        }
        ;
        // JavaLine 25 <== SourceLine 53
        ((Pass1$SubBlock32)(CUR$.SL$.SL$)).cursource=((Pass1$SubBlock32$sourceElt)(CUR$.SL$)).prev;
        ;
        // JavaLine 28 <== SourceLine 54
        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).inserted!=(0)))) {
            ((Pass1$SubBlock32)(CUR$.SL$.SL$)).inserted=Math.subtractExact(((Pass1$SubBlock32)(CUR$.SL$.SL$)).inserted,1);
        }
        ;
        // JavaLine 33 <== SourceLine 55
        if(VALUE$((((Pass1$SubBlock32$sourceElt)(CUR$.SL$)).prev!=(null)))) {
            ((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.curline$1=((Pass1$SubBlock32$sourceElt)(CUR$.SL$)).prev.linenr;
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure close",1,50,20,52,25,53,28,54,33,55,40,56);
} // End of Procedure
