// JavaLine 1 ==> SourceLine 657
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$textconc extends CHECKER1$semchecker1$exp {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=1, firstLine=657, lastLine=688, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 680
    final LABQNT$ NXT=new LABQNT$(this,1,1); // Local Label #1=NXT
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 659
    public int ntext=0;
    // JavaLine 16 ==> SourceLine 660
    public CHECKER1$semchecker1$textoperand first=null;
    public CHECKER1$semchecker1$textoperand last=null;
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$textconc$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$textconc(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch) {
        super(staticLink,sp$pred,sp$ch);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("textconc",684);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("textconc",684,inner);
                CHECKER1$semchecker1$textconc THIS$=(CHECKER1$semchecker1$textconc)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 34 ==> SourceLine 688
                        if(inner!=null) {
                            inner.STM$();
                            TRACE_BEGIN_STM_AFTER_INNER$("textconc",688);
                        }
                        break LOOP$;
                    }
                    catch(LABQNT$ q) {
                        CUR$=THIS$;
                        if(q.SL$!=CUR$ || q.prefixLevel!=1) {
                            CUR$.STATE$=OperationalState.terminated;
                            if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                            throw(q);
                        }
                        if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                        JTX$=q.index; continue LOOP$; // EG. GOTO Lx
                    }
                }
                TRACE_END_STM$("textconc",688);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$textconc STM$() { return((CHECKER1$semchecker1$textconc)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$textconc START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class textconc",1,657,11,680,14,659,16,660,34,688,58,688);
}
