// JavaLine 1 ==> SourceLine 1000
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:25 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$blockOrComp$recoversetting extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1000, lastLine=1020, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$blockOrComp$recoversetting(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("recoversetting",1000);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$blockOrComp$recoversetting STM$() {
        TRACE_BEGIN_STM$("recoversetting",1000);
        // JavaLine 23 ==> SourceLine 1002
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IARRA)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 25 ==> SourceLine 1003
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IREAL)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 27 ==> SourceLine 1004
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IBOOL)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 29 ==> SourceLine 1005
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IREF)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 31 ==> SourceLine 1006
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).ICHAR)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 33 ==> SourceLine 1007
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).ISHOR)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 35 ==> SourceLine 1008
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IEXTR)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 37 ==> SourceLine 1009
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).ISWIT)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 39 ==> SourceLine 1010
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IINTG)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 41 ==> SourceLine 1011
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).ITEXT)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 43 ==> SourceLine 1012
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).ILONG)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 45 ==> SourceLine 1013
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IPROC)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=true;
        TRACE_END_STM$("recoversetting",1013);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure recoversetting",1,1000,23,1002,25,1003,27,1004,29,1005,31,1006,33,1007,35,1008,37,1009,39,1010,41,1011,43,1012,45,1013,50,1020);
}
