// JavaLine 1 ==> SourceLine 667
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:44:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$recognizer$nextLine extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=667, lastLine=674, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 669
    final LABQNT$ REP=new LABQNT$(this,0,1); // Local Label #1=REP
    // Declare locals as attributes
    SCANNER$input inspect$669$4=null;
    // Normal Constructor
    public SCANNER$recognizer$nextLine(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("nextLine",669);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$recognizer$nextLine STM$() {
        TRACE_BEGIN_STM$("nextLine",669);
        SCANNER$recognizer$nextLine THIS$=(SCANNER$recognizer$nextLine)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 31 ==> SourceLine 670
                LABEL$(1); // REP
                // JavaLine 33 ==> SourceLine 669
                {
                    // BEGIN INSPECTION 
                    inspect$669$4=((SCANNER)(CUR$.SL$.SL$)).cursource;
                    if(inspect$669$4!=null) //INSPECT inspect$669$4
                    // JavaLine 38 ==> SourceLine 670
                    call(((SCANNER$input)inspect$669$4));
                    else // OTHERWISE 
                    ((SCANNER$recognizer)(CUR$.SL$)).detach();
                }
                // JavaLine 43 ==> SourceLine 671
                ((SCANNER$recognizer)(CUR$.SL$)).atom=loadChar(((SCANNER$recognizer)(CUR$.SL$)).line,0);
                ((SCANNER$recognizer)(CUR$.SL$)).linepos=1;
                // JavaLine 46 ==> SourceLine 672
                while((((SCANNER$recognizer)(CUR$.SL$)).atom==('%'))) {
                    // JavaLine 48 ==> SourceLine 673
                    {
                        TRACE_BEGIN_STM$("CompoundStatement673",673);
                        new SCANNER$recognizer$directive(((SCANNER$recognizer)(CUR$.SL$)));
                        if((((SCANNER$recognizer)(CUR$.SL$)).atom==(((SCANNER)(CUR$.SL$.SL$)).EOL))) {
                            GOTO$(REP); // GOTO EVALUATED LABEL
                        }
                        TRACE_END_STM$("CompoundStatement673",673);
                    }
                }
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$ || q.prefixLevel!=0) {
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("nextLine",673);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure nextLine",1,667,11,669,31,670,33,669,38,670,43,671,46,672,48,673,74,674);
}
