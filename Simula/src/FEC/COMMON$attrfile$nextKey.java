// JavaLine 1 ==> SourceLine 1346
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 15:03:20 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$attrfile$nextKey extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=1346, lastLine=1350, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 1347
    final LABQNT$ REP=new LABQNT$(this,0,1); // Local Label #1=REP
    // Declare locals as attributes
    // Normal Constructor
    public COMMON$attrfile$nextKey(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("nextKey",1347);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public COMMON$attrfile$nextKey STM$() {
        TRACE_BEGIN_STM$("nextKey",1347);
        COMMON$attrfile$nextKey THIS$=(COMMON$attrfile$nextKey)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                LABEL$(1); // REP
                ((COMMON$attrfile)(CUR$.SL$)).key=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                // JavaLine 33 ==> SourceLine 1348
                if((((COMMON$attrfile)(CUR$.SL$)).key==(((COMMON$attrfile)(CUR$.SL$)).bufSwap))) {
                    // JavaLine 35 ==> SourceLine 1349
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1349",1349);
                        new COMMON$attrfile$swapIbuffer(((COMMON$attrfile)(CUR$.SL$)));
                        GOTO$(REP); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement1349",1349);
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
        TRACE_END_STM$("nextKey",1349);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure nextKey",1,1346,11,1347,33,1348,35,1349,59,1350);
}
