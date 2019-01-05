// JavaLine 1 ==> SourceLine 1974
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$expression$exp$parexprecover extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=5, firstLine=1974, lastLine=1988, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$expression$exp$parexprecover(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("parexprecover",1974);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$expression$exp$parexprecover STM$() {
        TRACE_BEGIN_STM$("parexprecover",1974);
        // JavaLine 23 ==> SourceLine 1977
        ((PARSER$grammer)(CUR$.SL$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$.SL$)).ICOMA)-((PARSER$grammer)(CUR$.SL$.SL$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 25 ==> SourceLine 1978
        ((PARSER$grammer)(CUR$.SL$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$.SL$)).IRGPA)-((PARSER$grammer)(CUR$.SL$.SL$.SL$)).recoversymbol.LB[0]]=true;
        // JavaLine 27 ==> SourceLine 1979
        new PARSER$grammer$search(((PARSER$grammer)(CUR$.SL$.SL$.SL$)));
        // JavaLine 29 ==> SourceLine 1980
        ((PARSER$grammer)(CUR$.SL$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$.SL$)).ICOMA)-((PARSER$grammer)(CUR$.SL$.SL$.SL$)).recoversymbol.LB[0]]=false;
        // JavaLine 31 ==> SourceLine 1981
        ((PARSER$grammer)(CUR$.SL$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$.SL$)).IRGPA)-((PARSER$grammer)(CUR$.SL$.SL$.SL$)).recoversymbol.LB[0]]=false;
        // JavaLine 33 ==> SourceLine 1986
        GOTO$((((((PARSER$grammer)(CUR$.SL$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$.SL$)).ICOMA)))?(((PARSER$grammer$expression$exp)(CUR$.SL$)).comarecover):((((((PARSER$grammer)(CUR$.SL$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$.SL$)).IRGPA)))?(((PARSER$grammer$expression$exp)(CUR$.SL$)).rgparecover):(((PARSER$grammer$expression$exp)(CUR$.SL$)).rgpaerror))))); // GOTO EVALUATED LABEL
        TRACE_END_STM$("parexprecover",1986);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure parexprecover",1,1974,23,1977,25,1978,27,1979,29,1980,31,1981,33,1986,38,1988);
}
