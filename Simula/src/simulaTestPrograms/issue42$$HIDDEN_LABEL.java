// JavaLine 1 <== SourceLine 9
package simulaTestPrograms;
// Simula-2.0 Compiled at Fri Sep 10 10:56:34 CEST 2021
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue42$$HIDDEN_LABEL extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=9, lastLine=15, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 10 <== SourceLine 13
    final LABQNT$ LABEL$L=new LABQNT$(this,1,"L"); // Local Label #1=L
    final LABQNT$ LABEL$P=new LABQNT$(this,2,"P"); // Local Label #2=P
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 11
    int L=0;
    // Normal Constructor
    public issue42$$HIDDEN_LABEL(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public issue42$$HIDDEN_LABEL STM$() {
        issue42$$HIDDEN_LABEL THIS$=(issue42$$HIDDEN_LABEL)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 30 <== SourceLine 12
                L=4;
                ;
                // JavaLine 33 <== SourceLine 13
                {
                    {
                        LABEL$(1,"L");
                        LABEL$(2,"P");
                        ;
                    }
                }
                ;
                // JavaLine 42 <== SourceLine 14
                L=5;
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("HIDDEN_LABEL:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("HIDDEN_LABEL:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("HIDDEN_LABEL:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("issue42.sim","Procedure HIDDEN_LABEL",1,9,10,13,14,11,30,12,33,13,42,14,61,15);
} // End of Procedure
