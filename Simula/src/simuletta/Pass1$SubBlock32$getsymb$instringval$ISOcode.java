// JavaLine 1 <== SourceLine 106
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$getsymb$instringval$ISOcode extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=5, firstLine=106, lastLine=121, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 107
    int count=0;
    int i=0;
    int j=0;
    boolean digits=false;
    // JavaLine 15 <== SourceLine 108
    int oldpos=0;
    // Normal Constructor
    public Pass1$SubBlock32$getsymb$instringval$ISOcode(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass1$SubBlock32$getsymb$instringval$ISOcode STM$() {
        oldpos=((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1;
        ;
        // JavaLine 29 <== SourceLine 109
        ((Pass1$SubBlock32$getsymb$instringval)(CUR$.SL$)).ch=loadChar(((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).inim$1,((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1);
        ;
        ((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1=Math.addExact(((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1,1);
        ;
        // JavaLine 34 <== SourceLine 110
        while((count<(3))) {
            {
                count=Math.addExact(count,1);
                ;
                // JavaLine 39 <== SourceLine 111
                if(VALUE$(digit(((Pass1$SubBlock32$getsymb$instringval)(CUR$.SL$)).ch))) {
                    // JavaLine 41 <== SourceLine 112
                    {
                        digits=true;
                        ;
                        // JavaLine 45 <== SourceLine 113
                        i=Math.subtractExact(Math.addExact(Math.multiplyExact(10,i),isorank(((Pass1$SubBlock32$getsymb$instringval)(CUR$.SL$)).ch)),isorank('0'));
                        ;
                        // JavaLine 48 <== SourceLine 114
                        ((Pass1$SubBlock32$getsymb$instringval)(CUR$.SL$)).ch=loadChar(((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).inim$1,((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1);
                        ;
                        ((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1=Math.addExact(((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1,1);
                        ;
                    }
                }
                ;
            }
        }
        ;
        // JavaLine 59 <== SourceLine 117
        if(VALUE$(((digits&&((i<(256))))&&((((Pass1$SubBlock32$getsymb$instringval)(CUR$.SL$)).ch==('!')))))) {
            // JavaLine 61 <== SourceLine 118
            ((Pass1$SubBlock32$getsymb$instringval)(CUR$.SL$)).ch=char$(i);
        } else
        // JavaLine 64 <== SourceLine 119
        {
            ((Pass1$SubBlock32$getsymb$instringval)(CUR$.SL$)).ch='!';
            ;
            ((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1=oldpos;
        }
        ;
        // JavaLine 71 <== SourceLine 120
        new Pass1$SubBlock32$getsymb$instringval$putchar(((Pass1$SubBlock32$getsymb$instringval)(CUR$.SL$)));
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure ISOcode",1,106,10,107,15,108,29,109,34,110,39,111,41,112,45,113,48,114,59,117,61,118,64,119,71,120,76,121);
} // End of Procedure
