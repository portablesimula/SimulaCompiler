// JavaLine 1 ==> SourceLine 69
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:31 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class BUILDER1$casedescr extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=69, lastLine=77, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$ndests;
    public int p$lb;
    public int p$ub;
    public BUILDER1$casedescr p$prev;
    public char p$type;
    // Declare locals as attributes
    // JavaLine 16 ==> SourceLine 74
    public int tag=0;
    public int jumptag=0;
    // JavaLine 19 ==> SourceLine 75
    public int errortag=0;
    // JavaLine 21 ==> SourceLine 76
    public BUILDER1$indexelt firstelt=null;
    // Normal Constructor
    public BUILDER1$casedescr(RTObject$ staticLink,int sp$ndests,int sp$lb,int sp$ub,BUILDER1$casedescr sp$prev,char sp$type) {
        super(staticLink);
        // Parameter assignment to locals
        this.p$ndests = sp$ndests;
        this.p$lb = sp$lb;
        this.p$ub = sp$ub;
        this.p$prev = sp$prev;
        this.p$type = sp$type;
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("casedescr",76);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("casedescr",76,inner);
                // JavaLine 39 ==> SourceLine 77
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("casedescr",77);
                }
                TRACE_END_STM$("casedescr",77);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public BUILDER1$casedescr STM$() { return((BUILDER1$casedescr)CODE$.EXEC$()); }
    public BUILDER1$casedescr START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Class casedescr",1,69,16,74,19,75,21,76,39,77,51,77);
}
