// JavaLine 1 <== SourceLine 20
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:46 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InptFile$ininstr extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=20, lastLine=27, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 21
    int instr=0;
    // JavaLine 15 <== SourceLine 25
    Common inspect$25$33=null;
    // Normal Constructor
    public InptFile$ininstr(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public InptFile$ininstr STM$() {
        // JavaLine 27 <== SourceLine 22
        RESULT$=instr=((InptFile)(CUR$.SL$)).inbyte();
        ;
        // JavaLine 30 <== SourceLine 23
        if(VALUE$((((InptFile)(CUR$.SL$)).input_trace$3>(0)))) {
            // JavaLine 32 <== SourceLine 24
            {
                new InptFile$outcode(((InptFile)(CUR$.SL$)));
                ;
                // JavaLine 36 <== SourceLine 25
                {
                    // BEGIN INSPECTION 
                    inspect$25$33=((InptFile)(CUR$.SL$)).p3$comn;
                    if(inspect$25$33!=null) // INSPECT inspect$25$33
                    // JavaLine 41 <== SourceLine 26
                    new InptFile$TRC(((InptFile)(CUR$.SL$)),new TXT$("Ininstr"),new Common$edSymbol(inspect$25$33,instr).RESULT$);
                }
            }
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("INPTFILE.sim","Procedure ininstr",1,20,13,21,15,25,27,22,30,23,32,24,36,25,41,26,49,27);
} // End of Procedure
