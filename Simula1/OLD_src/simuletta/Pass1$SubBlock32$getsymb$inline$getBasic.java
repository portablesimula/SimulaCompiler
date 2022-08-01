// JavaLine 1 <== SourceLine 175
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$getsymb$inline$getBasic extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=5, firstLine=175, lastLine=202, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 176
    TXT$ id=null;
    int n=0;
    // Normal Constructor
    public Pass1$SubBlock32$getsymb$inline$getBasic(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass1$SubBlock32$getsymb$inline$getBasic STM$() {
        // JavaLine 23 <== SourceLine 177
        ((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol=0;
        ;
        ((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).curval=null;
        ;
        // JavaLine 28 <== SourceLine 178
        ((Pass1$SubBlock32$getsymb$inline)(CUR$.SL$)).ch=loadChar(((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).inim$1,((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1);
        ;
        ((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1=Math.addExact(((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1,1);
        ;
        // JavaLine 33 <== SourceLine 179
        while((((Pass1$SubBlock32$getsymb$inline)(CUR$.SL$)).ch==(((char)32)))) {
            // JavaLine 35 <== SourceLine 180
            {
                ((Pass1$SubBlock32$getsymb$inline)(CUR$.SL$)).ch=loadChar(((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).inim$1,((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1);
                ;
                ((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1=Math.addExact(((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1,1);
                ;
            }
        }
        ;
        // JavaLine 44 <== SourceLine 181
        id=TXT$.sub(((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).inim$1,((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1,Math.addExact(Math.subtractExact(((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).imlen$1,((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1),3));
        ;
        // JavaLine 47 <== SourceLine 182
        n=1;
        ;
        // JavaLine 50 <== SourceLine 183
        if(VALUE$(letter(((Pass1$SubBlock32$getsymb$inline)(CUR$.SL$)).ch))) {
            // JavaLine 52 <== SourceLine 184
            {
                while((letter(loadChar(((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).inim$1,((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1))|(digit(loadChar(((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).inim$1,((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1))))) {
                    // JavaLine 55 <== SourceLine 187
                    {
                        n=Math.addExact(n,1);
                        ;
                        ((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1=Math.addExact(((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1,1);
                        ;
                    }
                }
                ;
                // JavaLine 64 <== SourceLine 188
                ((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1;
                ;
                // JavaLine 67 <== SourceLine 189
                ((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).curval=lowcase(copy(copy(TXT$.sub(id,1,n))));
                ;
            }
        } else
        // JavaLine 72 <== SourceLine 191
        if(VALUE$(digit(((Pass1$SubBlock32$getsymb$inline)(CUR$.SL$)).ch))) {
            // JavaLine 74 <== SourceLine 192
            {
                while(digit(loadChar(((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).inim$1,((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1))) {
                    // JavaLine 77 <== SourceLine 194
                    {
                        n=Math.addExact(n,1);
                        ;
                        ((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1=Math.addExact(((Pass1$SubBlock32$getsymb)(CUR$.SL$.SL$)).impos$1,1);
                        ;
                    }
                }
                ;
                // JavaLine 86 <== SourceLine 195
                ((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1;
                ;
                // JavaLine 89 <== SourceLine 196
                ((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).curval=copy(copy(TXT$.sub(id,1,n)));
                ;
            }
        } else
        // JavaLine 94 <== SourceLine 200
        {
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure getBasic",1,175,10,176,23,177,28,178,33,179,35,180,44,181,47,182,50,183,52,184,55,187,64,188,67,189,72,191,74,192,77,194,86,195,89,196,94,200,100,202);
} // End of Procedure
