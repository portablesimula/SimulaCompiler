// JavaLine 1 ==> SourceLine 408
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:49 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER2$semchecker$unstack$ReplaceByConst extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=408, lastLine=420, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$val;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 411
    int i=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public CHECKER2$semchecker$unstack$ReplaceByConst setPar(Object param) {
        //Util.BREAK("CALL CHECKER2$semchecker$unstack$ReplaceByConst.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$val=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public CHECKER2$semchecker$unstack$ReplaceByConst(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public CHECKER2$semchecker$unstack$ReplaceByConst(RTObject$ SL$,int sp$val) {
        super(SL$);
        // Parameter assignment to locals
        this.p$val = sp$val;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("ReplaceByConst",411);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER2$semchecker$unstack$ReplaceByConst STM$() {
        TRACE_BEGIN_STM$("ReplaceByConst",411);
        // JavaLine 43 ==> SourceLine 413
        TXT$.putint(((CHECKER2)(CUR$.SL$.SL$.SL$)).leftintbuf,p$val);
        // JavaLine 45 ==> SourceLine 414
        i=11;
        while((loadChar(((CHECKER2)(CUR$.SL$.SL$.SL$)).leftintbuf,i)!=(((char)32)))) {
            i=(i-(1));
        }
        // JavaLine 50 ==> SourceLine 415
        ((CHECKER2)(CUR$.SL$.SL$.SL$)).simsymbol=TXT$.sub(((CHECKER2)(CUR$.SL$.SL$.SL$)).leftintbuf,(i+(2)),(11-(i)));
        new COMMON$DEFCONST(((CHECKER2)(CUR$.SL$.SL$.SL$)));
        // JavaLine 53 ==> SourceLine 416
        ((CHECKER2$semchecker)(CUR$.SL$.SL$)).exptop=new CHECKER1$semchecker1$arithconst(((CHECKER2$semchecker)(CUR$.SL$.SL$)),((CHECKER2$semchecker$unstack)(CUR$.SL$)).sos.p$pred,((CHECKER2)(CUR$.SL$.SL$.SL$)).ICONS).STM$();
        // JavaLine 55 ==> SourceLine 417
        ((CHECKER1$semchecker1$arithconst)(((CHECKER2$semchecker)(CUR$.SL$.SL$)).exptop)).ixhi=((CHECKER2)(CUR$.SL$.SL$.SL$)).hashhi;
        // JavaLine 57 ==> SourceLine 418
        ((CHECKER1$semchecker1$arithconst)(((CHECKER2$semchecker)(CUR$.SL$.SL$)).exptop)).ixlo=((CHECKER2)(CUR$.SL$.SL$.SL$)).hashlo;
        // JavaLine 59 ==> SourceLine 419
        ((CHECKER2$semchecker)(CUR$.SL$.SL$)).exptop.type=((CHECKER2$semchecker)(CUR$.SL$.SL$)).exptop.ctype=((CHECKER2)(CUR$.SL$.SL$.SL$)).IINTG;
        ((CHECKER2$semchecker)(CUR$.SL$.SL$)).exptop.cl=((CHECKER2$semchecker)(CUR$.SL$.SL$)).IEEXPcl;
        TRACE_END_STM$("ReplaceByConst",419);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER2.DEF","Procedure ReplaceByConst",1,408,12,411,43,413,45,414,50,415,53,416,55,417,57,418,59,419,65,420);
}
