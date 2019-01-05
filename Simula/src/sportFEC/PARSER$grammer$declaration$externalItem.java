// JavaLine 1 ==> SourceLine 813
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:46:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$declaration$externalItem extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=813, lastLine=830, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$declaration$externalItem(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("externalItem",813);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$declaration$externalItem STM$() {
        TRACE_BEGIN_STM$("externalItem",813);
        // JavaLine 23 ==> SourceLine 814
        ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
        // JavaLine 25 ==> SourceLine 815
        if((((PARSER$grammer)(CUR$.SL$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$.SL$)).IIDN))) {
            new PARSER$grammer$declaration$declError(((PARSER$grammer$declaration)(CUR$.SL$)),185);
        }
        // JavaLine 29 ==> SourceLine 816
        ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IEXTR;
        call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
        // JavaLine 32 ==> SourceLine 817
        ((PARSER$grammer)(CUR$.SL$.SL$)).getopt=false;
        ((PARSER$grammer)(CUR$.SL$.SL$)).cs=((PARSER)(CUR$.SL$.SL$.SL$)).opt;
        // JavaLine 35 ==> SourceLine 818
        if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IEQ))) {
            // JavaLine 37 ==> SourceLine 819
            {
                TRACE_BEGIN_STM$("CompoundStatement819",819);
                ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                // JavaLine 41 ==> SourceLine 820
                if(((((PARSER$grammer)(CUR$.SL$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$.SL$)).ICONS))|((((PARSER)(CUR$.SL$.SL$.SL$)).optx!=(((PARSER)(CUR$.SL$.SL$.SL$)).ITEXT))))) {
                    // JavaLine 43 ==> SourceLine 821
                    {
                        TRACE_BEGIN_STM$("CompoundStatement821",821);
                        new PARSER$grammer$skip(((PARSER$grammer)(CUR$.SL$.SL$)),193);
                        GOTO$(((PARSER$grammer$declaration)(CUR$.SL$)).NoSpec); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement821",821);
                    }
                }
                // JavaLine 51 ==> SourceLine 822
                ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IEXNM;
                call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                // JavaLine 54 ==> SourceLine 823
                ((PARSER$grammer)(CUR$.SL$.SL$)).getopt=false;
                ((PARSER$grammer)(CUR$.SL$.SL$)).cs=((PARSER)(CUR$.SL$.SL$.SL$)).opt;
                TRACE_END_STM$("CompoundStatement819",823);
            }
        } else
        // JavaLine 60 ==> SourceLine 827
        {
            TRACE_BEGIN_STM$("CompoundStatement827",827);
            LABEL$(1); // NoSpec
            ((PARSER)(CUR$.SL$.SL$.SL$)).opdhi=((PARSER)(CUR$.SL$.SL$.SL$)).opdlo=((PARSER)(CUR$.SL$.SL$.SL$)).NUL;
            // JavaLine 65 ==> SourceLine 828
            ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IEXNM;
            call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
            TRACE_END_STM$("CompoundStatement827",828);
        }
        TRACE_END_STM$("externalItem",828);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure externalItem",1,813,23,814,25,815,29,816,32,817,35,818,37,819,41,820,43,821,51,822,54,823,60,827,65,828,73,830);
}
