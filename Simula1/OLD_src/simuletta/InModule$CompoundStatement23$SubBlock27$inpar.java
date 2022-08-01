// JavaLine 1 <== SourceLine 105
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:47 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InModule$CompoundStatement23$SubBlock27$inpar extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=105, lastLine=110, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public Common$quant RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 106
    Common$quant inspect$106$47=null;
    // Normal Constructor
    public InModule$CompoundStatement23$SubBlock27$inpar(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public InModule$CompoundStatement23$SubBlock27$inpar STM$() {
        {
            // BEGIN INSPECTION 
            inspect$106$47=new Common$quant(((InModule)(CUR$.SL$.SL$)).inspect$22$42,new InModule$CompoundStatement23$SubBlock27$intype(((InModule$CompoundStatement23$SubBlock27)(CUR$.SL$))).RESULT$).STM$();
            if(inspect$106$47!=null) // INSPECT inspect$106$47
            // JavaLine 29 <== SourceLine 107
            {
                new InptFile$inident(((InModule)(CUR$.SL$.SL$)).inspect$22$43);
                ;
                inspect$106$47.symb$2=((InModule)(CUR$.SL$.SL$)).inspect$22$42.symtab.Elt[((InModule)(CUR$.SL$.SL$)).inspect$22$42.hash$1-((InModule)(CUR$.SL$.SL$)).inspect$22$42.symtab.LB[0]];
                ;
                // JavaLine 35 <== SourceLine 108
                inspect$106$47.count$3=new InptFile$innumber(((InModule)(CUR$.SL$.SL$)).inspect$22$43).RESULT$;
                ;
                RESULT$=((Common$quant)inspect$106$47);
                ;
                // JavaLine 40 <== SourceLine 109
                if(VALUE$((((InModule)(CUR$.SL$.SL$)).inspect$22$42.module_trace$1>(2)))) {
                    new Common$prt(((InModule)(CUR$.SL$.SL$)).inspect$22$42,((Common$descr)inspect$106$47),20);
                }
                ;
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("INMODULE.sim","Procedure inpar",1,105,13,106,29,107,35,108,40,109,49,110);
} // End of Procedure
