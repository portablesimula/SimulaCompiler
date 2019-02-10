// JavaLine 1 ==> SourceLine 5
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri Feb 08 21:46:43 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class A$P extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=5, lastLine=10, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 10
    final LABQNT$ N=new LABQNT$(this,0,1); // Local Label #1=N
    // Declare locals as attributes
    // Normal Constructor
    public A$P(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("P",10);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public A$P STM$() {
        TRACE_BEGIN_STM$("P",10);
        A$P THIS$=(A$P)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 30 ==> SourceLine 7
                if(VALUE$((((A)(CUR$.SL$)).i<(44)))) {
                    GOTO$(N); // GOTO EVALUATED LABEL
                }
                // JavaLine 34 ==> SourceLine 8
                ((A)(CUR$.SL$)).i=65;
                // JavaLine 36 ==> SourceLine 10
                LABEL$(1,"N");
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
        TRACE_END_STM$("P",10);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc00.sim","Procedure P",1,5,11,10,30,7,34,8,36,10,54,10);
}
