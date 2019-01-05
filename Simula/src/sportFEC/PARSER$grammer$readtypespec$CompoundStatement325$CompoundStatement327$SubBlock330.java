// JavaLine 1 ==> SourceLine 330
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:46:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$readtypespec$CompoundStatement325$CompoundStatement327$SubBlock330 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=4, firstLine=330, lastLine=335, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    char opdhip=0;
    char opdlop=0;
    // Normal Constructor
    public PARSER$grammer$readtypespec$CompoundStatement325$CompoundStatement327$SubBlock330(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock330",330);
    } // End of Constructor
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock330",330);
        // JavaLine 22 ==> SourceLine 331
        new PARSER$grammer$ParsErr(((PARSER$grammer)(CUR$.SL$.SL$)),185);
        opdhip=((PARSER)(CUR$.SL$.SL$.SL$)).opdhi;
        opdlop=((PARSER)(CUR$.SL$.SL$.SL$)).opdlo;
        // JavaLine 26 ==> SourceLine 332
        ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IREF;
        ((PARSER)(CUR$.SL$.SL$.SL$)).opdhi=((PARSER)(CUR$.SL$.SL$.SL$)).NUL;
        ((PARSER)(CUR$.SL$.SL$.SL$)).opdlo=((PARSER)(CUR$.SL$.SL$.SL$)).errorident;
        // JavaLine 30 ==> SourceLine 333
        call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
        // JavaLine 32 ==> SourceLine 334
        ((PARSER)(CUR$.SL$.SL$.SL$)).opdhi=opdhip;
        ((PARSER)(CUR$.SL$.SL$.SL$)).opdlo=opdlop;
        TRACE_END_STM$("SubBlock330",334);
        EBLK();
        return(null);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","SubBlock SubBlock330",1,330,22,331,26,332,30,333,32,334,38,335);
}
