// JavaLine 1 <== SourceLine 1
package simulaTestPrograms;
// Simula-1.0 Compiled at Tue Jun 04 10:23:48 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class A extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=1, PrefixLevel=0, firstLine=1, lastLine=3, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 <== SourceLine 3
    final LABQNT$ L=new LABQNT$(this,1,"L"); // Local Label #1=L
    // Declare locals as attributes
    // Normal Constructor
    public A(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("A",3);
    }
    // Class Statements
    public A STM$() {
        TRACE_BEGIN_STM$("A",3);
        A THIS$=(A)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // Class A: Code before inner
                LABEL$(1,"L");
                // Class A: Code after inner
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("A:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("A:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("A:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("A",3);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("issue31.sim","Class A",1,1,11,3,49,3);
} // End of Class
