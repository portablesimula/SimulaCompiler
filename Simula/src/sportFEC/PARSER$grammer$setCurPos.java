// JavaLine 1 ==> SourceLine 231
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:24 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$setCurPos extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=231, lastLine=237, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 235
    SCANNER$recognizer inspect$235$36=null;
    // Normal Constructor
    public PARSER$grammer$setCurPos(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("setCurPos",235);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$setCurPos STM$() {
        TRACE_BEGIN_STM$("setCurPos",235);
        // JavaLine 25 ==> SourceLine 232
        new SCANNER$setP1line(((PARSER)(CUR$.SL$.SL$)));
        // JavaLine 27 ==> SourceLine 235
        {
            // BEGIN INSPECTION 
            inspect$235$36=((PARSER)(CUR$.SL$.SL$)).lexScanner;
            if(inspect$235$36!=null) //INSPECT inspect$235$36
            ((PARSER$grammer)(CUR$.SL$)).currentPos=((((((((PARSER)(CUR$.SL$.SL$)).optx!=(((PARSER)(CUR$.SL$.SL$)).NUL))&&(inspect$235$36.getopt))&&((inspect$235$36.opdline==(((PARSER)(CUR$.SL$.SL$)).linenr)))))?(inspect$235$36.opdpos):(inspect$235$36.optpos))+(1));
        }
        TRACE_END_STM$("setCurPos",235);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure setCurPos",1,231,11,235,25,232,27,235,37,237);
}
