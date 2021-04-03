// JavaLine 1 <== SourceLine 73
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:46 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InptFile$outcode extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=73, lastLine=78, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 74
    PrintFile$ inspect$74$38=null;
    // Normal Constructor
    public InptFile$outcode(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public InptFile$outcode STM$() {
        if(VALUE$((TXT$.pos(((InptFile)(CUR$.SL$)).TRCBUFF$3)>(1)))) {
            {
                // BEGIN INSPECTION 
                inspect$74$38=sysout();
                if(inspect$74$38!=null) // INSPECT inspect$74$38
                // JavaLine 27 <== SourceLine 75
                {
                    inspect$74$38.outtext(new TXT$("Input:"));
                    ;
                    // JavaLine 31 <== SourceLine 76
                    inspect$74$38.setpos(15);
                    ;
                    inspect$74$38.outtext(TXT$.strip(((InptFile)(CUR$.SL$)).TRCBUFF$3));
                    ;
                    // JavaLine 36 <== SourceLine 77
                    inspect$74$38.outimage();
                    ;
                    ASGTXT$(((InptFile)(CUR$.SL$)).TRCBUFF$3,null);
                    ;
                    TXT$.setpos(((InptFile)(CUR$.SL$)).TRCBUFF$3,1);
                    ;
                }
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("INPTFILE.sim","Procedure outcode",1,73,10,74,27,75,31,76,36,77,48,78);
} // End of Procedure
