// JavaLine 1 ==> SourceLine 322
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:46:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$readtypespec extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=322, lastLine=345, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$readtypespec(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("readtypespec",322);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$readtypespec STM$() {
        TRACE_BEGIN_STM$("readtypespec",322);
        // JavaLine 23 ==> SourceLine 323
        if((((PARSER$grammer)(CUR$.SL$)).cs<=(((PARSER)(CUR$.SL$.SL$)).ITEXT))) {
            // JavaLine 25 ==> SourceLine 325
            {
                TRACE_BEGIN_STM$("CompoundStatement325",325);
                ((PARSER$grammer)(CUR$.SL$)).readtype=((PARSER$grammer)(CUR$.SL$)).cs;
                // JavaLine 29 ==> SourceLine 326
                if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IREF))) {
                    // JavaLine 31 ==> SourceLine 327
                    {
                        TRACE_BEGIN_STM$("CompoundStatement327",327);
                        ((PARSER$grammer)(CUR$.SL$)).detach();
                        // JavaLine 35 ==> SourceLine 328
                        if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).ILFPA))) {
                            // JavaLine 37 ==> SourceLine 329
                            new PARSER$grammer$ParsWarn(((PARSER$grammer)(CUR$.SL$)),282);
                        } else
                        ((PARSER$grammer)(CUR$.SL$)).detach();
                        // JavaLine 41 ==> SourceLine 330
                        if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IIDN))) {
                            // JavaLine 43 ==> SourceLine 335
                            new PARSER$grammer$readtypespec$CompoundStatement325$CompoundStatement327$SubBlock330(CUR$).STM$();
                        } else
                        // JavaLine 46 ==> SourceLine 335
                        {
                            TRACE_BEGIN_STM$("CompoundStatement335",335);
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IREF;
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            // JavaLine 51 ==> SourceLine 336
                            ((PARSER$grammer)(CUR$.SL$)).getopt=false;
                            ((PARSER$grammer)(CUR$.SL$)).cs=((PARSER)(CUR$.SL$.SL$)).opt;
                            TRACE_END_STM$("CompoundStatement335",336);
                        }
                        // JavaLine 56 ==> SourceLine 338
                        if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IRGPA))) {
                            new PARSER$grammer$ParsWarn(((PARSER$grammer)(CUR$.SL$)),285);
                        }
                        TRACE_END_STM$("CompoundStatement327",338);
                    }
                } else
                // JavaLine 63 ==> SourceLine 340
                {
                    TRACE_BEGIN_STM$("CompoundStatement340",340);
                    ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER$grammer)(CUR$.SL$)).cs;
                    call(((PARSER)(CUR$.SL$.SL$)).coder);
                    TRACE_END_STM$("CompoundStatement340",340);
                }
                // JavaLine 70 ==> SourceLine 341
                ((PARSER$grammer)(CUR$.SL$)).detach();
                TRACE_END_STM$("CompoundStatement325",341);
            }
        } else
        // JavaLine 75 ==> SourceLine 344
        {
            TRACE_BEGIN_STM$("CompoundStatement344",344);
            ((PARSER$grammer)(CUR$.SL$)).readtype=((PARSER)(CUR$.SL$.SL$)).NUL;
            TRACE_END_STM$("CompoundStatement344",344);
        }
        TRACE_END_STM$("readtypespec",344);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure readtypespec",1,322,23,323,25,325,29,326,31,327,35,328,37,329,41,330,43,335,46,335,51,336,56,338,63,340,70,341,75,344,84,345);
}
