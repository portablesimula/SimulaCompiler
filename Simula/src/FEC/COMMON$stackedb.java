package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 15:03:20 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$stackedb extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=1164, lastLine=1171, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public char p$oldblev;
    public char p$oldrtblev;
    public int p$oldconnests;
    public char p$oldinsp;
    public COMMON$stackedb p$prev;
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 1171
    public COMMON$stackedi redeclChain=null;
    // Normal Constructor
    public COMMON$stackedb(RTObject$ staticLink,char sp$oldblev,char sp$oldrtblev,int sp$oldconnests,char sp$oldinsp,COMMON$stackedb sp$prev) {
        super(staticLink);
        // Parameter assignment to locals
        this.p$oldblev = sp$oldblev;
        this.p$oldrtblev = sp$oldrtblev;
        this.p$oldconnests = sp$oldconnests;
        this.p$oldinsp = sp$oldinsp;
        this.p$prev = sp$prev;
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("stackedb",1171);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("stackedb",1171,inner);
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("stackedb",1171);
                }
                TRACE_END_STM$("stackedb",1171);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public COMMON$stackedb STM$() { return((COMMON$stackedb)CODE$.EXEC$()); }
    public COMMON$stackedb START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class stackedb",15,1171,44,1171);
}
