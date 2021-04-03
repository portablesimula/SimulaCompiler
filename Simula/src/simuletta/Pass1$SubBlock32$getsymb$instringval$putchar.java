// JavaLine 1 <== SourceLine 123
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$getsymb$instringval$putchar extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=5, firstLine=123, lastLine=130, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Pass1$SubBlock32$getsymb$instringval$putchar(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass1$SubBlock32$getsymb$instringval$putchar STM$() {
        // JavaLine 20 <== SourceLine 124
        if(VALUE$((((Pass1$SubBlock32$getsymb$instringval)(CUR$.SL$)).storepos==(((Pass1$SubBlock32$getsymb$instringval)(CUR$.SL$)).storelength)))) {
            // JavaLine 22 <== SourceLine 125
            {
                ((Pass1$SubBlock32$getsymb$instringval)(CUR$.SL$)).result=CONC(((Pass1$SubBlock32$getsymb$instringval)(CUR$.SL$)).result,blanks(10));
                ;
                // JavaLine 26 <== SourceLine 126
                ((Pass1$SubBlock32$getsymb$instringval)(CUR$.SL$)).storelength=Math.addExact(((Pass1$SubBlock32$getsymb$instringval)(CUR$.SL$)).storelength,10);
                ;
            }
        }
        ;
        // JavaLine 32 <== SourceLine 128
        storeChar(((Pass1$SubBlock32$getsymb$instringval)(CUR$.SL$)).ch,((Pass1$SubBlock32$getsymb$instringval)(CUR$.SL$)).result,((Pass1$SubBlock32$getsymb$instringval)(CUR$.SL$)).storepos);
        ;
        // JavaLine 35 <== SourceLine 129
        ((Pass1$SubBlock32$getsymb$instringval)(CUR$.SL$)).storepos=Math.addExact(((Pass1$SubBlock32$getsymb$instringval)(CUR$.SL$)).storepos,1);
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure putchar",1,123,20,124,22,125,26,126,32,128,35,129,40,130);
} // End of Procedure
