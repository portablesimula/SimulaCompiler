// JavaLine 1 ==> SourceLine 89
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$codebuffer$terminate extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=89, lastLine=100, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 94
    PARSER$codebuffer$elt inspect$94$34=null;
    // Normal Constructor
    public PARSER$codebuffer$terminate(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("terminate",94);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$codebuffer$terminate STM$() {
        TRACE_BEGIN_STM$("terminate",94);
        // JavaLine 25 ==> SourceLine 90
        ((PARSER)(CUR$.SL$.SL$)).coder=((PARSER$codebuffer)(CUR$.SL$)).prev;
        ((PARSER$codebuffer)(CUR$.SL$)).prev=null;
        // JavaLine 28 ==> SourceLine 91
        ((PARSER$codebuffer)(CUR$.SL$)).curelt=((PARSER$codebuffer)(CUR$.SL$)).firstelt.next;
        ((PARSER$codebuffer)(CUR$.SL$)).firstelt.next=null;
        // JavaLine 31 ==> SourceLine 92
        while((((PARSER$codebuffer)(CUR$.SL$)).curelt!=(null))) {
            // JavaLine 33 ==> SourceLine 94
            {
                // BEGIN INSPECTION 
                inspect$94$34=((PARSER$codebuffer)(CUR$.SL$)).curelt;
                if(inspect$94$34!=null) //INSPECT inspect$94$34
                // JavaLine 38 ==> SourceLine 95
                {
                    TRACE_BEGIN_STM$("CompoundStatement95",95);
                    ((PARSER)(CUR$.SL$.SL$)).opdhi=inspect$94$34.opdhii;
                    ((PARSER)(CUR$.SL$.SL$)).opdlo=inspect$94$34.opdloo;
                    // JavaLine 43 ==> SourceLine 96
                    ((PARSER)(CUR$.SL$.SL$)).optx=inspect$94$34.optxx;
                    ((PARSER)(CUR$.SL$.SL$)).opn=inspect$94$34.opnn;
                    call(((PARSER)(CUR$.SL$.SL$)).coder);
                    // JavaLine 47 ==> SourceLine 97
                    ((PARSER$codebuffer)(CUR$.SL$)).curelt=inspect$94$34.next;
                    TRACE_END_STM$("CompoundStatement95",97);
                }
            }
        }
        // JavaLine 53 ==> SourceLine 99
        ((PARSER$codebuffer)(CUR$.SL$)).curelt=((PARSER$codebuffer)(CUR$.SL$)).firstelt;
        TRACE_END_STM$("terminate",99);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure terminate",1,89,11,94,25,90,28,91,31,92,33,94,38,95,43,96,47,97,53,99,58,100);
}
