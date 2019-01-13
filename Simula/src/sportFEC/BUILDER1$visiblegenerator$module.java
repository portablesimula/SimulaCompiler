// JavaLine 1 ==> SourceLine 114
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:31 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class BUILDER1$visiblegenerator$module extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=0, firstLine=114, lastLine=120, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$rtsmoduleid;
    public TXT$ p$checkcode;
    public int p$numoftags;
    public int p$basetag;
    // Declare locals as attributes
    // Normal Constructor
    public BUILDER1$visiblegenerator$module(RTObject$ staticLink,TXT$ sp$rtsmoduleid,TXT$ sp$checkcode,int sp$numoftags,int sp$basetag) {
        super(staticLink);
        // Parameter assignment to locals
        this.p$rtsmoduleid = sp$rtsmoduleid;
        this.p$checkcode = sp$checkcode;
        this.p$numoftags = sp$numoftags;
        this.p$basetag = sp$basetag;
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("module",114);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("module",114,inner);
                // JavaLine 30 ==> SourceLine 120
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("module",120);
                }
                TRACE_END_STM$("module",120);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public BUILDER1$visiblegenerator$module STM$() { return((BUILDER1$visiblegenerator$module)CODE$.EXEC$()); }
    public BUILDER1$visiblegenerator$module START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Class module",1,114,30,120,42,120);
}
