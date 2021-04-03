// JavaLine 1 <== SourceLine 52
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:46 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InptFile$instring extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=52, lastLine=57, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 53
    TXT$ t=null;
    // Normal Constructor
    public InptFile$instring(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public InptFile$instring STM$() {
        // JavaLine 25 <== SourceLine 54
        t=blanks(((InptFile)(CUR$.SL$)).inbyte());
        ;
        // JavaLine 28 <== SourceLine 55
        RESULT$=t=((InptFile)(CUR$.SL$)).intext(t);
        ;
        // JavaLine 31 <== SourceLine 56
        if(VALUE$((((InptFile)(CUR$.SL$)).input_trace$3>(0)))) {
            new InptFile$TRC(((InptFile)(CUR$.SL$)),new TXT$("Instring"),CONC(CONC(new TXT$("\""),t),new TXT$("\"")));
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("INPTFILE.sim","Procedure instring",1,52,13,53,25,54,28,55,31,56,38,57);
} // End of Procedure
