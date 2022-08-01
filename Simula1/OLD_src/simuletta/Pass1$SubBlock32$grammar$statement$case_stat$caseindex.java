// JavaLine 1 <== SourceLine 1177
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$grammar$statement$case_stat$caseindex extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=6, firstLine=1177, lastLine=1185, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Pass1$SubBlock32$grammar$statement$case_stat$caseindex(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass1$SubBlock32$grammar$statement$case_stat$caseindex STM$() {
        // JavaLine 23 <== SourceLine 1178
        ((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$.SL$)).detach();
        ;
        // JavaLine 26 <== SourceLine 1179
        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$.SL$.SL$)).inspect$28$62.S_CHARS$1)))) {
            // JavaLine 28 <== SourceLine 1180
            {
                RESULT$=rank(loadChar(((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$.SL$)).curval,0));
            }
        } else
        // JavaLine 33 <== SourceLine 1182
        {
            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1)))) {
                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$.SL$)),1182,((Pass1)(CUR$.SL$.SL$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1);
            }
            ;
            // JavaLine 39 <== SourceLine 1183
            RESULT$=TXT$.getint(((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$.SL$)).curval);
            ;
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure caseindex",1,1177,23,1178,26,1179,28,1180,33,1182,39,1183,46,1185);
} // End of Procedure
