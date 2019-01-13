// JavaLine 1 ==> SourceLine 1806
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:25 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$casestat$recover extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1806, lastLine=1823, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$casestat$recover(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("recover",1806);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$casestat$recover STM$() {
        TRACE_BEGIN_STM$("recover",1806);
        // JavaLine 26 ==> SourceLine 1807
        RESULT$=false;
        // JavaLine 28 ==> SourceLine 1808
        if((((PARSER$grammer$casestat)(CUR$.SL$)).errorno==(1))) {
            // JavaLine 30 ==> SourceLine 1809
            {
                TRACE_BEGIN_STM$("CompoundStatement1809",1809);
                ((PARSER$grammer$casestat)(CUR$.SL$)).rp=((char)1);
                TRACE_END_STM$("CompoundStatement1809",1809);
            }
        } else
        // JavaLine 37 ==> SourceLine 1811
        if((((PARSER$grammer$casestat)(CUR$.SL$)).errorno==(2))) {
            // JavaLine 39 ==> SourceLine 1812
            {
                TRACE_BEGIN_STM$("CompoundStatement1812",1812);
                new PARSER$grammer$casestat$L2output(((PARSER$grammer$casestat)(CUR$.SL$)),((PARSER)(CUR$.SL$.SL$.SL$)).ICPRF);
                TRACE_END_STM$("CompoundStatement1812",1812);
            }
        } else
        // JavaLine 46 ==> SourceLine 1814
        if((((PARSER$grammer$casestat)(CUR$.SL$)).errorno==(3))) {
            // JavaLine 48 ==> SourceLine 1817
            {
                TRACE_BEGIN_STM$("CompoundStatement1817",1817);
                TRACE_END_STM$("CompoundStatement1817",1817);
            }
        } else
        // JavaLine 54 ==> SourceLine 1819
        {
            TRACE_BEGIN_STM$("CompoundStatement1819",1819);
            new PARSER$grammer$casestat$L2output(((PARSER$grammer$casestat)(CUR$.SL$)),((PARSER)(CUR$.SL$.SL$.SL$)).ICSPC);
            TRACE_END_STM$("CompoundStatement1819",1819);
        }
        // JavaLine 60 ==> SourceLine 1821
        ((PARSER$grammer$casestat)(CUR$.SL$)).errorno=0;
        TRACE_END_STM$("recover",1821);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure recover",1,1806,26,1807,28,1808,30,1809,37,1811,39,1812,46,1814,48,1817,54,1819,60,1821,65,1823);
}
