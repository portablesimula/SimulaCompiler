// JavaLine 1 ==> SourceLine 1223
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:25 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$ifstat$recover extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1223, lastLine=1232, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$ifstat$recover(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("recover",1223);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$ifstat$recover STM$() {
        TRACE_BEGIN_STM$("recover",1223);
        // JavaLine 26 ==> SourceLine 1224
        ((PARSER$grammer$ifstat)(CUR$.SL$)).recovered=RESULT$=true;
        // JavaLine 28 ==> SourceLine 1225
        if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).ITHEN))) {
            ((PARSER$grammer$ifstat)(CUR$.SL$)).rp=((char)3);
        } else
        // JavaLine 32 ==> SourceLine 1226
        if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IELSE))) {
            // JavaLine 34 ==> SourceLine 1227
            {
                TRACE_BEGIN_STM$("CompoundStatement1227",1227);
                ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).ITHSB;
                call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                ((PARSER$grammer$ifstat)(CUR$.SL$)).rp=((char)4);
                TRACE_END_STM$("CompoundStatement1227",1227);
            }
        } else
        // JavaLine 43 ==> SourceLine 1228
        {
            TRACE_BEGIN_STM$("CompoundStatement1228",1228);
            ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).ITHSB;
            call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
            // JavaLine 48 ==> SourceLine 1229
            ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IIFSE;
            call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
            // JavaLine 51 ==> SourceLine 1230
            ((PARSER$grammer$ifstat)(CUR$.SL$)).recovered=RESULT$=false;
            TRACE_END_STM$("CompoundStatement1228",1230);
        }
        TRACE_END_STM$("recover",1230);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure recover",1,1223,26,1224,28,1225,32,1226,34,1227,43,1228,48,1229,51,1230,58,1232);
}
