// JavaLine 1 ==> SourceLine 986
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$blockOrComp$recover extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=986, lastLine=998, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$blockOrComp$recover(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("recover",986);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$blockOrComp$recover STM$() {
        TRACE_BEGIN_STM$("recover",986);
        // JavaLine 26 ==> SourceLine 987
        if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IEOP))) {
            // JavaLine 28 ==> SourceLine 988
            {
                TRACE_BEGIN_STM$("CompoundStatement988",988);
                if(((((PARSER$grammer$blockOrComp)(CUR$.SL$)).blocktype==(((PARSER$grammer)(CUR$.SL$.SL$)).prefixblock))|(((((PARSER$grammer$blockOrComp)(CUR$.SL$)).blocktype==(((PARSER$grammer)(CUR$.SL$.SL$)).usualblock))&((!(((PARSER$grammer$blockOrComp)(CUR$.SL$)).unlabbody))))))) {
                    // JavaLine 32 ==> SourceLine 990
                    {
                        TRACE_BEGIN_STM$("CompoundStatement990",990);
                        ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IEND;
                        call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                        // JavaLine 37 ==> SourceLine 991
                        ((PARSER$grammer)(CUR$.SL$.SL$)).blockfound=(((PARSER$grammer)(CUR$.SL$.SL$)).blockfound-(1));
                        TRACE_END_STM$("CompoundStatement990",991);
                    }
                }
                TRACE_END_STM$("CompoundStatement988",991);
            }
        } else
        // JavaLine 45 ==> SourceLine 993
        {
            TRACE_BEGIN_STM$("CompoundStatement993",993);
            ((PARSER$grammer$blockOrComp)(CUR$.SL$)).recoverno=(((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).ISMCL)))?(1):((((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IEND)))?(2):(3))));
            // JavaLine 49 ==> SourceLine 995
            if((((PARSER$grammer$blockOrComp)(CUR$.SL$)).recoverno!=(3))) {
                ((PARSER$grammer$blockOrComp)(CUR$.SL$)).recovered=RESULT$=true;
            }
            // JavaLine 53 ==> SourceLine 996
            ((PARSER$grammer$blockOrComp)(CUR$.SL$)).rp=((char)2);
            TRACE_END_STM$("CompoundStatement993",996);
        }
        TRACE_END_STM$("recover",996);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure recover",1,986,26,987,28,988,32,990,37,991,45,993,49,995,53,996,60,998);
}
