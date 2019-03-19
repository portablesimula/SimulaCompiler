package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri Mar 15 09:50:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class issue12$A extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=8, lastLine=18, hasLocalClasses=true, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 ==> SourceLine 16
    public issue12$A$B rB=null;
    // Normal Constructor
    public issue12$A(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("A",16);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("A",16,inner);
                // JavaLine 23 ==> SourceLine 17
                rB=new issue12$A$B(((issue12$A)CUR$)).STM$();
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("A",17);
                }
                TRACE_END_STM$("A",17);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public issue12$A STM$() { return((issue12$A)CODE$.EXEC$()); }
    public issue12$A START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("issue12.sim","Class A",10,16,23,17,36,18);
}
