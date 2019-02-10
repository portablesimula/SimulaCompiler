// JavaLine 1 ==> SourceLine 450
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$readclasspar$setrecsymb extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=450, lastLine=472, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public boolean p$b;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public PARSER$grammer$readclasspar$setrecsymb setPar(Object param) {
        //Util.BREAK("CALL PARSER$grammer$readclasspar$setrecsymb.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$b=(boolean)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public PARSER$grammer$readclasspar$setrecsymb(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public PARSER$grammer$readclasspar$setrecsymb(RTObject$ SL$,boolean sp$b) {
        super(SL$);
        // Parameter assignment to locals
        this.p$b = sp$b;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("setrecsymb",450);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$readclasspar$setrecsymb STM$() {
        TRACE_BEGIN_STM$("setrecsymb",450);
        // JavaLine 41 ==> SourceLine 452
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IBOOL)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 43 ==> SourceLine 453
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).ICHAR)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 45 ==> SourceLine 454
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).ISHOR)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 47 ==> SourceLine 455
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IINTG)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 49 ==> SourceLine 456
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IREAL)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 51 ==> SourceLine 457
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).ILONG)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 53 ==> SourceLine 458
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IREF)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 55 ==> SourceLine 459
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).ITEXT)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 57 ==> SourceLine 460
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IPROC)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 59 ==> SourceLine 461
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IARRA)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 61 ==> SourceLine 462
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IEXTR)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 63 ==> SourceLine 463
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IHIDD)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 65 ==> SourceLine 464
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IPRTC)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 67 ==> SourceLine 465
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).ISWIT)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 69 ==> SourceLine 466
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).ITO)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 71 ==> SourceLine 467
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IVIRT)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        TRACE_END_STM$("setrecsymb",467);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure setrecsymb",1,450,41,452,43,453,45,454,47,455,49,456,51,457,53,458,55,459,57,460,59,461,61,462,63,463,65,464,67,465,69,466,71,467,76,472);
}
