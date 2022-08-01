// JavaLine 1 <== SourceLine 47
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:47 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InModule$CompoundStatement23$SubBlock27$intag extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=47, lastLine=64, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 48
    int t=0;
    TXT$ s=null;
    // Normal Constructor
    public InModule$CompoundStatement23$SubBlock27$intag(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public InModule$CompoundStatement23$SubBlock27$intag STM$() {
        // JavaLine 26 <== SourceLine 49
        t=Math.addExact(((InModule)(CUR$.SL$.SL$)).inspect$22$43.in2byte(),((InModule)(CUR$.SL$.SL$)).inspect$23$44.bias$2);
        ;
        // JavaLine 29 <== SourceLine 61
        ((InModule)(CUR$.SL$.SL$)).inspect$22$42.simsymbol$1=new InptFile$instring(((InModule)(CUR$.SL$.SL$)).inspect$22$43).RESULT$;
        ;
        new Common$DEFIDENT(((InModule)(CUR$.SL$.SL$)).inspect$22$42);
        ;
        ((InModule)(CUR$.SL$.SL$)).inspect$22$42.tagtab.Elt[t-((InModule)(CUR$.SL$.SL$)).inspect$22$42.tagtab.LB[0]]=((InModule)(CUR$.SL$.SL$)).inspect$22$42.symtab.Elt[((InModule)(CUR$.SL$.SL$)).inspect$22$42.hash$1-((InModule)(CUR$.SL$.SL$)).inspect$22$42.symtab.LB[0]];
        ;
        // JavaLine 36 <== SourceLine 62
        if(VALUE$((((InModule)(CUR$.SL$.SL$)).inspect$22$43.input_trace$3>(0)))) {
            new InptFile$TRC(((InModule)(CUR$.SL$.SL$)).inspect$22$43,new TXT$("Intag "),new Common$TagName(((InModule)(CUR$.SL$.SL$)).inspect$22$42,t).RESULT$);
        }
        ;
        // JavaLine 41 <== SourceLine 63
        RESULT$=t;
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("INMODULE.sim","Procedure intag",1,47,13,48,26,49,29,61,36,62,41,63,46,64);
} // End of Procedure
