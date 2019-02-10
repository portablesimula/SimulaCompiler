// JavaLine 1 ==> SourceLine 1706
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$inspectstat$recover extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1706, lastLine=1713, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$inspectstat$recover(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("recover",1706);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$inspectstat$recover STM$() {
        TRACE_BEGIN_STM$("recover",1706);
        // JavaLine 26 ==> SourceLine 1707
        RESULT$=false;
        // JavaLine 28 ==> SourceLine 1708
        if(VALUE$(((((PARSER$grammer$inspectstat)(CUR$.SL$)).errorno==(1))||((((PARSER$grammer$inspectstat)(CUR$.SL$)).errorno==(2)))))) {
            // JavaLine 30 ==> SourceLine 1709
            {
                TRACE_BEGIN_STM$("CompoundStatement1709",1709);
                ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).ICONB;
                call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                TRACE_END_STM$("CompoundStatement1709",1709);
            }
        }
        // JavaLine 38 ==> SourceLine 1710
        ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((((PARSER$grammer$inspectstat)(CUR$.SL$)).iothwsent)?(((PARSER)(CUR$.SL$.SL$.SL$)).IOTHE):(((PARSER)(CUR$.SL$.SL$.SL$)).ICONE));
        call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
        // JavaLine 41 ==> SourceLine 1711
        if(VALUE$(((PARSER$grammer$inspectstat)(CUR$.SL$)).enclgen)) {
            {
                TRACE_BEGIN_STM$("CompoundStatement1711",1711);
                ((PARSER$grammer$inspectstat)(CUR$.SL$)).enclgen=false;
                // JavaLine 46 ==> SourceLine 1712
                ((PARSER$grammer)(CUR$.SL$.SL$)).blockfound=0;
                ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IEND;
                call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                TRACE_END_STM$("CompoundStatement1711",1712);
            }
        }
        TRACE_END_STM$("recover",1712);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure recover",1,1706,26,1707,28,1708,30,1709,38,1710,41,1711,46,1712,56,1713);
}
