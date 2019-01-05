// JavaLine 1 ==> SourceLine 613
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:46:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$setbasicrecovery extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=613, lastLine=630, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$setbasicrecovery(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("setbasicrecovery",613);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$setbasicrecovery STM$() {
        TRACE_BEGIN_STM$("setbasicrecovery",613);
        // JavaLine 23 ==> SourceLine 615
        ((PARSER$grammer)(CUR$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$)).IEND)-((PARSER$grammer)(CUR$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 25 ==> SourceLine 616
        ((PARSER$grammer)(CUR$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$)).ISMCL)-((PARSER$grammer)(CUR$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 27 ==> SourceLine 617
        ((PARSER$grammer)(CUR$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$)).IBEGI)-((PARSER$grammer)(CUR$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 29 ==> SourceLine 618
        ((PARSER$grammer)(CUR$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$)).IGOTO)-((PARSER$grammer)(CUR$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 31 ==> SourceLine 619
        ((PARSER$grammer)(CUR$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$)).IWHIL)-((PARSER$grammer)(CUR$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 33 ==> SourceLine 621
        ((PARSER$grammer)(CUR$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$)).IINSP)-((PARSER$grammer)(CUR$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 35 ==> SourceLine 622
        ((PARSER$grammer)(CUR$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$)).IFOR)-((PARSER$grammer)(CUR$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 37 ==> SourceLine 623
        ((PARSER$grammer)(CUR$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$)).IINNE)-((PARSER$grammer)(CUR$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 39 ==> SourceLine 624
        ((PARSER$grammer)(CUR$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$)).IACTV)-((PARSER$grammer)(CUR$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 41 ==> SourceLine 625
        ((PARSER$grammer)(CUR$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$)).IREAC)-((PARSER$grammer)(CUR$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 43 ==> SourceLine 626
        ((PARSER$grammer)(CUR$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$)).IEOP)-((PARSER$grammer)(CUR$.SL$)).recoversymbol.LB[0]]=true;
        TRACE_END_STM$("setbasicrecovery",626);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure setbasicrecovery",1,613,23,615,25,616,27,617,29,618,31,619,33,621,35,622,37,623,39,624,41,625,43,626,48,630);
}
