// JavaLine 1 ==> SourceLine 211
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:35 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$normalattrfile$skipList extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=211, lastLine=228, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 224
    final LABQNT$ EXIT=new LABQNT$(this,0,1); // Local Label #1=EXIT
    // Declare locals as attributes
    // Normal Constructor
    public BUILDER2$normalattrfile$skipList(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("skipList",224);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER2$normalattrfile$skipList STM$() {
        TRACE_BEGIN_STM$("skipList",224);
        BUILDER2$normalattrfile$skipList THIS$=(BUILDER2$normalattrfile$skipList)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 30 ==> SourceLine 216
                new COMMON$attrfile$nextKey(((BUILDER2$normalattrfile)(CUR$.SL$)));
                // JavaLine 32 ==> SourceLine 218
                while((((BUILDER2$normalattrfile)(CUR$.SL$)).key<(((BUILDER2$normalattrfile)(CUR$.SL$)).lowKey))) {
                    // JavaLine 34 ==> SourceLine 219
                    {
                        TRACE_BEGIN_STM$("CompoundStatement219",219);
                        new COMMON$attrfile$fetchquant(((BUILDER2$normalattrfile)(CUR$.SL$)));
                        // JavaLine 38 ==> SourceLine 220
                        if((((BUILDER2$normalattrfile)(CUR$.SL$)).key==(((BUILDER2$normalattrfile)(CUR$.SL$)).begList))) {
                            new BUILDER2$normalattrfile$skipList(((BUILDER2$normalattrfile)(CUR$.SL$)));
                        }
                        TRACE_END_STM$("CompoundStatement219",220);
                    }
                }
                // JavaLine 45 ==> SourceLine 224
                LABEL$(1); // EXIT
                if((((BUILDER2$normalattrfile)(CUR$.SL$)).key!=(((BUILDER2$normalattrfile)(CUR$.SL$)).endlist))) {
                    new BUILDER2$normalattrfile$expxerr(((BUILDER2$normalattrfile)(CUR$.SL$)),'E');
                }
                // JavaLine 50 ==> SourceLine 225
                new COMMON$attrfile$nextKey(((BUILDER2$normalattrfile)(CUR$.SL$)));
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
        TRACE_END_STM$("skipList",225);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Procedure skipList",1,211,11,224,30,216,32,218,34,219,38,220,45,224,50,225,68,228);
}
