// JavaLine 1 ==> SourceLine 2534
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$switchdef$checkplainswitch extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=2534, lastLine=2543, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 2543
    final LABQNT$ E=new LABQNT$(this,0,1); // Local Label #1=E
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 2535
    CHECKER1$semchecker1$switchelement swel=null;
    // Normal Constructor
    public CHECKER1$semchecker1$switchdef$checkplainswitch(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("checkplainswitch",2535);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$switchdef$checkplainswitch STM$() {
        TRACE_BEGIN_STM$("checkplainswitch",2535);
        CHECKER1$semchecker1$switchdef$checkplainswitch THIS$=(CHECKER1$semchecker1$switchdef$checkplainswitch)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 32 ==> SourceLine 2536
                swel=((CHECKER1$semchecker1$switchdef)(CUR$.SL$)).elements;
                // JavaLine 34 ==> SourceLine 2537
                while((swel!=(null))) {
                    // JavaLine 36 ==> SourceLine 2538
                    {
                        TRACE_BEGIN_STM$("CompoundStatement2538",2538);
                        if((swel.blocklevel!=(((CHECKER1$semchecker1$switchdef)(CUR$.SL$)).sw.encl.blev))) {
                            // JavaLine 40 ==> SourceLine 2539
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2539",2539);
                                GOTO$(E); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2539",2539);
                            }
                        }
                        // JavaLine 47 ==> SourceLine 2540
                        swel=swel.next;
                        TRACE_END_STM$("CompoundStatement2538",2540);
                    }
                }
                // JavaLine 52 ==> SourceLine 2542
                ((CHECKER1$semchecker1$switchdef)(CUR$.SL$)).plain=true;
                // JavaLine 54 ==> SourceLine 2543
                LABEL$(1); // E
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
        TRACE_END_STM$("checkplainswitch",2543);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure checkplainswitch",1,2534,11,2543,14,2535,32,2536,34,2537,36,2538,40,2539,47,2540,52,2542,54,2543,72,2543);
}
