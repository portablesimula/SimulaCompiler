// JavaLine 1 ==> SourceLine 396
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:44:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SCANNER$input extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=396, lastLine=430, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public boolean p$inserted;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 399
    public boolean liston=false;
    // JavaLine 14 ==> SourceLine 400
    public char lexatom=0;
    // JavaLine 16 ==> SourceLine 401
    public int lexpos=0;
    public int lexlen=0;
    // JavaLine 19 ==> SourceLine 402
    public TXT$ lexline=null;
    // JavaLine 21 ==> SourceLine 403
    public int linlen=0;
    // JavaLine 23 ==> SourceLine 404
    public SCANNER$input prev=null;
    // JavaLine 25 ==> SourceLine 405
    public TXT$ t=null;
    public PRCQNT$ close$0() { throw new RuntimeException("No Virtual Match"); }
    // Normal Constructor
    public SCANNER$input(RTObject$ staticLink,boolean sp$inserted) {
        super(staticLink);
        // Parameter assignment to locals
        this.p$inserted = sp$inserted;
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("input",427);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("input",427,inner);
                // JavaLine 40 ==> SourceLine 430
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("input",430);
                }
                TRACE_END_STM$("input",430);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public SCANNER$input STM$() { return((SCANNER$input)CODE$.EXEC$()); }
    public SCANNER$input START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Class input",1,396,12,399,14,400,16,401,19,402,21,403,23,404,25,405,40,430,52,430);
}
