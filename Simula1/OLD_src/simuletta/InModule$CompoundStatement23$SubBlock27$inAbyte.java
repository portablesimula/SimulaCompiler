// JavaLine 1 <== SourceLine 39
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:47 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InModule$CompoundStatement23$SubBlock27$inAbyte extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=39, lastLine=44, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 40
    int chr=0;
    // JavaLine 15 <== SourceLine 42
    Common inspect$42$45=null;
    // Normal Constructor
    public InModule$CompoundStatement23$SubBlock27$inAbyte(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public InModule$CompoundStatement23$SubBlock27$inAbyte STM$() {
        // JavaLine 27 <== SourceLine 41
        RESULT$=chr=((InModule)(CUR$.SL$.SL$)).inspect$22$43.inbyte();
        ;
        // JavaLine 30 <== SourceLine 42
        if(VALUE$((((InModule)(CUR$.SL$.SL$)).inspect$22$43.input_trace$3>(0)))) {
            {
                // BEGIN INSPECTION 
                inspect$42$45=((InModule)(CUR$.SL$.SL$)).inspect$22$43.p3$comn;
                if(inspect$42$45!=null) // INSPECT inspect$42$45
                // JavaLine 36 <== SourceLine 43
                {
                    new InptFile$outcode(((InModule)(CUR$.SL$.SL$)).inspect$22$43);
                    ;
                    new InptFile$TRC(((InModule)(CUR$.SL$.SL$)).inspect$22$43,new TXT$("Inbyte"),new Common$leftint(inspect$42$45,chr).RESULT$);
                    ;
                }
            }
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("INMODULE.sim","Procedure inAbyte",1,39,13,40,15,42,27,41,30,42,36,43,48,44);
} // End of Procedure
