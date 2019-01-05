// JavaLine 1 ==> SourceLine 1706
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:59:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$prechecker$copyfromto extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=1706, lastLine=1721, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$quantity p$Q;
    public COMMON$quantity p$qnt;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER2$prechecker$copyfromto setPar(Object param) {
        //Util.BREAK("CALL BUILDER2$prechecker$copyfromto.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$Q=(COMMON$quantity)objectValue(param); break;
                case 1: p$qnt=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER2$prechecker$copyfromto(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER2$prechecker$copyfromto(RTObject$ SL$,COMMON$quantity sp$Q,COMMON$quantity sp$qnt) {
        super(SL$);
        // Parameter assignment to locals
        this.p$Q = sp$Q;
        this.p$qnt = sp$qnt;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("copyfromto",1706);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER2$prechecker$copyfromto STM$() {
        TRACE_BEGIN_STM$("copyfromto",1706);
        // JavaLine 44 ==> SourceLine 1709
        p$qnt.symb=p$Q.symb;
        // JavaLine 46 ==> SourceLine 1710
        p$qnt.type=p$Q.type;
        p$qnt.kind=p$Q.kind;
        p$qnt.categ=p$Q.categ;
        // JavaLine 50 ==> SourceLine 1711
        p$qnt.protect=p$Q.protect;
        // JavaLine 52 ==> SourceLine 1712
        p$qnt.special=p$Q.special;
        p$qnt.virtno=p$Q.virtno;
        // JavaLine 55 ==> SourceLine 1713
        p$qnt.dim=p$Q.dim;
        p$qnt.plev=p$Q.plev;
        // JavaLine 58 ==> SourceLine 1715
        if(((p$Q.ftag<(0))&&(IS$(p$qnt,COMMON$extquantity.class)))) {
            // JavaLine 60 ==> SourceLine 1716
            p$qnt.line=p$Q.ftag;
        } else
        // JavaLine 63 ==> SourceLine 1718
        if(((p$Q.line<(0))&&(IS$(p$qnt,COMMON$quantity.class)))) {
            p$qnt.ftag=p$Q.line;
        } else
        // JavaLine 67 ==> SourceLine 1719
        {
            TRACE_BEGIN_STM$("CompoundStatement1719",1719);
            p$qnt.ftag=p$Q.ftag;
            p$qnt.line=p$Q.line;
            TRACE_END_STM$("CompoundStatement1719",1719);
        }
        TRACE_END_STM$("copyfromto",1719);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Procedure copyfromto",1,1706,44,1709,46,1710,50,1711,52,1712,55,1713,58,1715,60,1716,63,1718,67,1719,77,1721);
}
