// JavaLine 1 ==> SourceLine 682
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:44:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$recognizer$directive$linefield extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=682, lastLine=693, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 14 ==> SourceLine 690
    final LABQNT$ L1=new LABQNT$(this,0,1); // Local Label #1=L1
    // JavaLine 16 ==> SourceLine 693
    final LABQNT$ E=new LABQNT$(this,0,2); // Local Label #2=E
    // Declare locals as attributes
    // JavaLine 19 ==> SourceLine 683
    int i=0;
    // Normal Constructor
    public SCANNER$recognizer$directive$linefield(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("linefield",683);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$recognizer$directive$linefield STM$() {
        TRACE_BEGIN_STM$("linefield",683);
        SCANNER$recognizer$directive$linefield THIS$=(SCANNER$recognizer$directive$linefield)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 37 ==> SourceLine 684
                while((((SCANNER$recognizer)(CUR$.SL$.SL$)).linepos<(((SCANNER$recognizer)(CUR$.SL$.SL$)).linelength))) {
                    // JavaLine 39 ==> SourceLine 685
                    {
                        TRACE_BEGIN_STM$("CompoundStatement685",685);
                        new SCANNER$recognizer$directive$nextChar(((SCANNER$recognizer$directive)(CUR$.SL$)));
                        // JavaLine 43 ==> SourceLine 686
                        if((((SCANNER$recognizer)(CUR$.SL$.SL$)).atom!=(((char)32)))) {
                            GOTO$(L1); // GOTO EVALUATED LABEL
                        }
                        TRACE_END_STM$("CompoundStatement685",686);
                    }
                }
                // JavaLine 50 ==> SourceLine 688
                if(TXTREL$EQ(((SCANNER$recognizer$directive)(CUR$.SL$)).u,new TXT$("select"))) {
                    GOTO$(E); // GOTO EVALUATED LABEL
                }
                // JavaLine 54 ==> SourceLine 689
                GOTO$(((SCANNER$recognizer$directive)(CUR$.SL$)).DIRWARN); // GOTO EVALUATED LABEL
                // JavaLine 56 ==> SourceLine 690
                LABEL$(1); // L1
                i=((SCANNER$recognizer)(CUR$.SL$.SL$)).linepos;
                // JavaLine 59 ==> SourceLine 691
                while(((((SCANNER$recognizer)(CUR$.SL$.SL$)).atom!=(((char)32)))&((((SCANNER$recognizer)(CUR$.SL$.SL$)).atom!=(((SCANNER)(CUR$.SL$.SL$.SL$)).EOL))))) {
                    new SCANNER$recognizer$directive$nextChar(((SCANNER$recognizer$directive)(CUR$.SL$)));
                }
                // JavaLine 63 ==> SourceLine 692
                RESULT$=copy(copy(TXT$.sub(((SCANNER$recognizer)(CUR$.SL$.SL$)).line,i,(((SCANNER$recognizer)(CUR$.SL$.SL$)).linepos-(i)))));
                // JavaLine 65 ==> SourceLine 693
                LABEL$(2); // E
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
        TRACE_END_STM$("linefield",693);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure linefield",1,682,14,690,16,693,19,683,37,684,39,685,43,686,50,688,54,689,56,690,59,691,63,692,65,693,83,693);
}
