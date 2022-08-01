// JavaLine 1 <== SourceLine 59
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:46 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InptFile$inlongstring extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=59, lastLine=64, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 60
    TXT$ t=null;
    // Normal Constructor
    public InptFile$inlongstring(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public InptFile$inlongstring STM$() {
        // JavaLine 25 <== SourceLine 61
        t=blanks(((InptFile)(CUR$.SL$)).in2byte());
        ;
        // JavaLine 28 <== SourceLine 62
        RESULT$=t=((InptFile)(CUR$.SL$)).intext(t);
        ;
        // JavaLine 31 <== SourceLine 63
        if(VALUE$((((InptFile)(CUR$.SL$)).input_trace$3>(0)))) {
            new InptFile$TRC(((InptFile)(CUR$.SL$)),new TXT$("Instring"),CONC(CONC(new TXT$("\""),t),new TXT$("\"")));
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("INPTFILE.sim","Procedure inlongstring",1,59,13,60,25,61,28,62,31,63,38,64);
} // End of Procedure
