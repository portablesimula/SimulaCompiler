// JavaLine 1 ==> SourceLine 562
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$extbinding extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=562, lastLine=578, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$extbinding(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("extbinding",562);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$extbinding STM$() {
        TRACE_BEGIN_STM$("extbinding",562);
        // JavaLine 26 ==> SourceLine 564
        ((PARSER$grammer)(CUR$.SL$)).detach();
        new PARSER$grammer$readtypespec(((PARSER$grammer)(CUR$.SL$)));
        RESULT$=false;
        // JavaLine 30 ==> SourceLine 565
        if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IPROC)))) {
            // JavaLine 32 ==> SourceLine 566
            {
                TRACE_BEGIN_STM$("CompoundStatement566",566);
                if(VALUE$((((PARSER$grammer)(CUR$.SL$)).readtype==(((PARSER)(CUR$.SL$.SL$)).NUL)))) {
                    {
                        TRACE_BEGIN_STM$("CompoundStatement566",566);
                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).INOTY;
                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                        TRACE_END_STM$("CompoundStatement566",566);
                    }
                }
                // JavaLine 43 ==> SourceLine 567
                ((PARSER$grammer)(CUR$.SL$)).detach();
                // JavaLine 45 ==> SourceLine 568
                if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IIDN)))) {
                    // JavaLine 47 ==> SourceLine 569
                    new PARSER$grammer$syntaxerror(((PARSER$grammer)(CUR$.SL$)),185);
                } else
                // JavaLine 50 ==> SourceLine 570
                {
                    TRACE_BEGIN_STM$("CompoundStatement570",570);
                    ((PARSER)(CUR$.SL$.SL$)).opn=((((PARSER$grammer)(CUR$.SL$)).specofvirtual)?(((PARSER)(CUR$.SL$.SL$)).IBREC):(((PARSER)(CUR$.SL$.SL$)).INOTE));
                    // JavaLine 54 ==> SourceLine 571
                    call(((PARSER)(CUR$.SL$.SL$)).coder);
                    // JavaLine 56 ==> SourceLine 572
                    ((PARSER$grammer)(CUR$.SL$)).getopt=false;
                    ((PARSER$grammer)(CUR$.SL$)).cs=((PARSER)(CUR$.SL$.SL$)).opt;
                    // JavaLine 59 ==> SourceLine 573
                    new PARSER$grammer$readprocpar(((PARSER$grammer)(CUR$.SL$)),((PARSER)(CUR$.SL$.SL$)).IPSPC);
                    RESULT$=true;
                    TRACE_END_STM$("CompoundStatement570",573);
                }
                TRACE_END_STM$("CompoundStatement566",573);
            }
        } else
        // JavaLine 67 ==> SourceLine 576
        new PARSER$grammer$syntaxerror(((PARSER$grammer)(CUR$.SL$)),221);
        // JavaLine 69 ==> SourceLine 577
        ((PARSER$grammer)(CUR$.SL$)).readtype=((PARSER)(CUR$.SL$.SL$)).NUL;
        TRACE_END_STM$("extbinding",577);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure extbinding",1,562,26,564,30,565,32,566,43,567,45,568,47,569,50,570,54,571,56,572,59,573,67,576,69,577,74,578);
}
