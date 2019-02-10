// JavaLine 1 ==> SourceLine 369
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$readprocpar$setrecsymb extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=369, lastLine=391, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public boolean p$b;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public PARSER$grammer$readprocpar$setrecsymb setPar(Object param) {
        //Util.BREAK("CALL PARSER$grammer$readprocpar$setrecsymb.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public PARSER$grammer$readprocpar$setrecsymb(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public PARSER$grammer$readprocpar$setrecsymb(RTObject$ SL$,boolean sp$b) {
        super(SL$);
        // Parameter assignment to locals
        this.p$b = sp$b;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("setrecsymb",369);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$readprocpar$setrecsymb STM$() {
        TRACE_BEGIN_STM$("setrecsymb",369);
        // JavaLine 41 ==> SourceLine 373
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IBOOL)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 43 ==> SourceLine 374
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).ICHAR)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 45 ==> SourceLine 375
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).ISHOR)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 47 ==> SourceLine 376
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IINTG)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 49 ==> SourceLine 377
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IREAL)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 51 ==> SourceLine 378
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).ILONG)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 53 ==> SourceLine 379
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IREF)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 55 ==> SourceLine 380
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).ITEXT)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 57 ==> SourceLine 381
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IVALU)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 59 ==> SourceLine 382
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IPROC)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 61 ==> SourceLine 383
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IARRA)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 63 ==> SourceLine 384
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).IEXTR)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 65 ==> SourceLine 385
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).INAME)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 67 ==> SourceLine 386
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).ISWIT)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        // JavaLine 69 ==> SourceLine 387
        ((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$.SL$)).ICOMA)-((PARSER$grammer)(CUR$.SL$.SL$)).recoversymbol.LB[0]]=p$b;
        TRACE_END_STM$("setrecsymb",387);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure setrecsymb",1,369,41,373,43,374,45,375,47,376,49,377,51,378,53,379,55,380,57,381,59,382,61,383,63,384,65,385,67,386,69,387,74,391);
}
