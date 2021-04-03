// JavaLine 1 <== SourceLine 164
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$getsymb$inline$percenterr extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=5, firstLine=164, lastLine=173, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 165
    PrintFile$ inspect$165$64=null;
    // Normal Constructor
    public Pass1$SubBlock32$getsymb$inline$percenterr(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass1$SubBlock32$getsymb$inline$percenterr STM$() {
        {
            // BEGIN INSPECTION 
            inspect$165$64=sysout();
            if(inspect$165$64!=null) // INSPECT inspect$165$64
            // JavaLine 26 <== SourceLine 166
            {
                inspect$165$64.outtext(TXT$.strip(((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).inim$1));
                ;
                inspect$165$64.outimage();
                ;
                // JavaLine 32 <== SourceLine 167
                while((((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1!=(0))) {
                    // JavaLine 34 <== SourceLine 168
                    {
                        ((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1=Math.subtractExact(((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1,1);
                        ;
                        inspect$165$64.outchar('=');
                        ;
                    }
                }
                ;
                // JavaLine 43 <== SourceLine 169
                inspect$165$64.outimage();
                ;
            }
        }
        ;
        // JavaLine 49 <== SourceLine 171
        new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Illegal %-directive - ignored"));
        ;
        // JavaLine 52 <== SourceLine 172
        GOTO$(((Pass1$SubBlock32$getsymb$inline)(CUR$.SL$)).NEWL); // GOTO EVALUATED LABEL
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure percenterr",1,164,10,165,26,166,32,167,34,168,43,169,49,171,52,172,57,173);
} // End of Procedure
