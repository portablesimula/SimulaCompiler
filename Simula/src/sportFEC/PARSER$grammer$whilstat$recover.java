// JavaLine 1 ==> SourceLine 1144
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:25 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$whilstat$recover extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1144, lastLine=1148, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$whilstat$recover(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("recover",1144);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$whilstat$recover STM$() {
        TRACE_BEGIN_STM$("recover",1144);
        // JavaLine 26 ==> SourceLine 1145
        if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IDO))) {
            {
                TRACE_BEGIN_STM$("CompoundStatement1145",1145);
                ((PARSER$grammer$whilstat)(CUR$.SL$)).rp=((char)2);
                ((PARSER$grammer$whilstat)(CUR$.SL$)).recovered=RESULT$=true;
                TRACE_END_STM$("CompoundStatement1145",1145);
            }
        } else
        // JavaLine 35 ==> SourceLine 1146
        {
            TRACE_BEGIN_STM$("CompoundStatement1146",1146);
            ((PARSER$grammer$whilstat)(CUR$.SL$)).recovered=false;
            ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IFALS;
            call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
            // JavaLine 41 ==> SourceLine 1147
            ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IIFSE;
            call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
            TRACE_END_STM$("CompoundStatement1146",1147);
        }
        TRACE_END_STM$("recover",1147);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure recover",1,1144,26,1145,35,1146,41,1147,49,1148);
}
