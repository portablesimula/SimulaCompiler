// JavaLine 1 <== SourceLine 98
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:47 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InModule$CompoundStatement23$SubBlock27$inquant extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=98, lastLine=103, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public Common$quant RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 99
    Common$quant inspect$99$46=null;
    // Normal Constructor
    public InModule$CompoundStatement23$SubBlock27$inquant(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public InModule$CompoundStatement23$SubBlock27$inquant STM$() {
        {
            // BEGIN INSPECTION 
            inspect$99$46=new Common$quant(((InModule)(CUR$.SL$.SL$)).inspect$22$42,new InModule$CompoundStatement23$SubBlock27$intype(((InModule$CompoundStatement23$SubBlock27)(CUR$.SL$))).RESULT$).STM$();
            if(inspect$99$46!=null) // INSPECT inspect$99$46
            // JavaLine 29 <== SourceLine 100
            {
                inspect$99$46.tag$2=new InModule$CompoundStatement23$SubBlock27$intag(((InModule$CompoundStatement23$SubBlock27)(CUR$.SL$))).RESULT$;
                ;
                inspect$99$46.symb$2=((InModule)(CUR$.SL$.SL$)).inspect$22$42.symtab.Elt[((InModule)(CUR$.SL$.SL$)).inspect$22$42.hash$1-((InModule)(CUR$.SL$.SL$)).inspect$22$42.symtab.LB[0]];
                ;
                // JavaLine 35 <== SourceLine 101
                inspect$99$46.count$3=new InptFile$innumber(((InModule)(CUR$.SL$.SL$)).inspect$22$43).RESULT$;
                ;
                RESULT$=((Common$quant)inspect$99$46);
                ;
                // JavaLine 40 <== SourceLine 102
                if(VALUE$((((InModule)(CUR$.SL$.SL$)).inspect$22$42.module_trace$1>(2)))) {
                    new Common$prt(((InModule)(CUR$.SL$.SL$)).inspect$22$42,((Common$descr)inspect$99$46),20);
                }
                ;
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("INMODULE.sim","Procedure inquant",1,98,13,99,29,100,35,101,40,102,49,103);
} // End of Procedure
