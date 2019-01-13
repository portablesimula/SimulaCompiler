// JavaLine 1 ==> SourceLine 665
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:25 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class PARSER$grammer$statement extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=0, firstLine=665, lastLine=715, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 669
    public boolean recovered=false;
    // JavaLine 13 ==> SourceLine 670
    public boolean isblocklike=false;
    // JavaLine 15 ==> SourceLine 673
    public char stmtreq=0;
    public char stmttype=0;
    // JavaLine 18 ==> SourceLine 692
    public char blockstatus=0;
    // JavaLine 20 ==> SourceLine 709
    public char rp=0;
    // JavaLine 22 ==> SourceLine 710
    public int errorno=0;
    // JavaLine 24 ==> SourceLine 711
    public PARSER$grammer$statement caller=null;
    public PARSER$grammer$statement next=null;
    public PRCQNT$ recover$0() { throw new RuntimeException("No Virtual Match"); }
    public PRCQNT$ recoversetting$0() { return(new PRCQNT$(this,PARSER$grammer$statement$recoversetting.class)); }
    // Normal Constructor
    public PARSER$grammer$statement(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("statement",713);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("statement",713,inner);
                // JavaLine 40 ==> SourceLine 715
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("statement",715);
                }
                TRACE_END_STM$("statement",715);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public PARSER$grammer$statement STM$() { return((PARSER$grammer$statement)CODE$.EXEC$()); }
    public PARSER$grammer$statement START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Class statement",1,665,11,669,13,670,15,673,18,692,20,709,22,710,24,711,40,715,52,715);
}
