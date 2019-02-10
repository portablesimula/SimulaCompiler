// JavaLine 1 ==> SourceLine 790
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$declaration$REGSEPCOMP extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=790, lastLine=811, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$declaration$REGSEPCOMP(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("REGSEPCOMP",790);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$declaration$REGSEPCOMP STM$() {
        TRACE_BEGIN_STM$("REGSEPCOMP",790);
        // JavaLine 23 ==> SourceLine 791
        ((PARSER)(CUR$.SL$.SL$.SL$)).separatecomp=true;
        // JavaLine 25 ==> SourceLine 793
        if(VALUE$(IS$(((PARSER)(CUR$.SL$.SL$.SL$)).coder,PARSER$codebuffer.class))) {
            new PARSER$codebuffer$termModul(((PARSER$codebuffer)(((PARSER)(CUR$.SL$.SL$.SL$)).coder)));
        }
        // JavaLine 29 ==> SourceLine 794
        if(VALUE$((((PARSER)(CUR$.SL$.SL$.SL$)).option.Elt[rank('I')-((PARSER)(CUR$.SL$.SL$.SL$)).option.LB[0]]!=(((PARSER)(CUR$.SL$.SL$.SL$)).NUL)))) {
            // JavaLine 31 ==> SourceLine 795
            {
                TRACE_BEGIN_STM$("CompoundStatement795",795);
                ((PARSER)(CUR$.SL$.SL$.SL$)).moduleident=((PARSER)(CUR$.SL$.SL$.SL$)).attrfilename=((((((PARSER)(CUR$.SL$.SL$.SL$)).opdhi==(((PARSER)(CUR$.SL$.SL$.SL$)).NUL))&((((PARSER)(CUR$.SL$.SL$.SL$)).opdlo==(((PARSER)(CUR$.SL$.SL$.SL$)).predefindex)))))?(((PARSER)(CUR$.SL$.SL$.SL$)).predefname):(((TXTREL$EQ(new COMMON$nameof(((PARSER)(CUR$.SL$.SL$.SL$)),((PARSER)(CUR$.SL$.SL$.SL$)).opdhi,((PARSER)(CUR$.SL$.SL$.SL$)).opdlo).RESULT$,new TXT$("simset")))?(((PARSER)(CUR$.SL$.SL$.SL$)).simsetname):(((TXTREL$EQ(new COMMON$nameof(((PARSER)(CUR$.SL$.SL$.SL$)),((PARSER)(CUR$.SL$.SL$.SL$)).opdhi,((PARSER)(CUR$.SL$.SL$.SL$)).opdlo).RESULT$,new TXT$("simulation")))?(((PARSER)(CUR$.SL$.SL$.SL$)).simulaname):(((PARSER)(CUR$.SL$.SL$.SL$)).attrfilename))))));
                // JavaLine 35 ==> SourceLine 800
                ((PARSER)(CUR$.SL$.SL$.SL$)).checkcode=copy(copy(new TXT$("SYS")));
                TRACE_END_STM$("CompoundStatement795",800);
            }
        } else
        // JavaLine 40 ==> SourceLine 802
        {
            TRACE_BEGIN_STM$("CompoundStatement802",802);
            giveTextInfo(1,new COMMON$nameof(((PARSER)(CUR$.SL$.SL$.SL$)),((PARSER)(CUR$.SL$.SL$.SL$)).opdhi,((PARSER)(CUR$.SL$.SL$.SL$)).opdlo).RESULT$);
            // JavaLine 44 ==> SourceLine 803
            ((PARSER)(CUR$.SL$.SL$.SL$)).attrfilename=getTextInfo(11);
            // JavaLine 46 ==> SourceLine 804
            ((PARSER)(CUR$.SL$.SL$.SL$)).moduleident=getTextInfo(14);
            ((PARSER)(CUR$.SL$.SL$.SL$)).checkcode=getTextInfo(15);
            // JavaLine 49 ==> SourceLine 805
            if(VALUE$(TRF_EQ(((PARSER)(CUR$.SL$.SL$.SL$)).checkcode,null))) {
                ((PARSER)(CUR$.SL$.SL$.SL$)).checkcode=((PARSER)(CUR$.SL$.SL$.SL$)).timestamp;
            }
            // JavaLine 53 ==> SourceLine 806
            if(VALUE$(((!(((PARSER)(CUR$.SL$.SL$.SL$)).recomp))&(TXTREL$EQ(((PARSER)(CUR$.SL$.SL$.SL$)).moduleident,null))))) {
                // JavaLine 55 ==> SourceLine 807
                {
                    TRACE_BEGIN_STM$("CompoundStatement807",807);
                    if(VALUE$(((PARSER)(CUR$.SL$.SL$.SL$)).GiveNotes)) {
                        new ERRMSG$note1(((PARSER)(CUR$.SL$.SL$.SL$)),397,((PARSER)(CUR$.SL$.SL$.SL$)).attrfilename);
                    }
                    // JavaLine 61 ==> SourceLine 808
                    ((PARSER)(CUR$.SL$.SL$.SL$)).moduleident=copy(copy(((PARSER)(CUR$.SL$.SL$.SL$)).attrfilename));
                    TRACE_END_STM$("CompoundStatement807",808);
                }
            }
            TRACE_END_STM$("CompoundStatement802",808);
        }
        TRACE_END_STM$("REGSEPCOMP",808);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure REGSEPCOMP",1,790,23,791,25,793,29,794,31,795,35,800,40,802,44,803,46,804,49,805,53,806,55,807,61,808,71,811);
}
