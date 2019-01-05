// JavaLine 1 ==> SourceLine 912
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:53 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$recognizer$ISOcode$getDigit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=912, lastLine=917, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public SCANNER$recognizer$ISOcode$getDigit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("getDigit",912);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$recognizer$ISOcode$getDigit STM$() {
        TRACE_BEGIN_STM$("getDigit",912);
        // JavaLine 23 ==> SourceLine 913
        if((((SCANNER$recognizer)(CUR$.SL$.SL$)).InputClass.Elt[rank(((SCANNER$recognizer)(CUR$.SL$.SL$)).atom)-((SCANNER$recognizer)(CUR$.SL$.SL$)).InputClass.LB[0]]==(((SCANNER)(CUR$.SL$.SL$.SL$)).Digit_cl))) {
            // JavaLine 25 ==> SourceLine 914
            {
                TRACE_BEGIN_STM$("CompoundStatement914",914);
                ((SCANNER$recognizer$ISOcode)(CUR$.SL$)).j=(((SCANNER$recognizer$ISOcode)(CUR$.SL$)).j+(1));
                ((SCANNER$recognizer$ISOcode)(CUR$.SL$)).i=(((10*(((SCANNER$recognizer$ISOcode)(CUR$.SL$)).i))+(isorank(((SCANNER$recognizer)(CUR$.SL$.SL$)).atom)))-(48));
                // JavaLine 30 ==> SourceLine 915
                new SCANNER$recognizer$scanahead(((SCANNER$recognizer)(CUR$.SL$.SL$)));
                TRACE_END_STM$("CompoundStatement914",915);
            }
        }
        TRACE_END_STM$("getDigit",915);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure getDigit",1,912,23,913,25,914,30,915,38,917);
}
