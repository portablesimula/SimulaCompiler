// JavaLine 1 ==> SourceLine 1178
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:41:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$getBrc extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=1178, lastLine=1183, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public COMMON$brecord RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public char p$blnohi;
    public char p$blnolo;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public COMMON$getBrc setPar(Object param) {
        //Util.BREAK("CALL COMMON$getBrc.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$blnohi=(char)objectValue(param); break;
                case 1: p$blnolo=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public COMMON$getBrc(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public COMMON$getBrc(RTObject$ SL$,char sp$blnohi,char sp$blnolo) {
        super(SL$);
        // Parameter assignment to locals
        this.p$blnohi = sp$blnohi;
        this.p$blnolo = sp$blnolo;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("getBrc",1178);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public COMMON$getBrc STM$() {
        TRACE_BEGIN_STM$("getBrc",1178);
        // JavaLine 47 ==> SourceLine 1182
        RESULT$=((ARRAY$<COMMON$brecord[]>)((COMMON)(CUR$.SL$)).brctab.Elt[rank(p$blnohi)-((COMMON)(CUR$.SL$)).brctab.LB[0]].val).Elt[rank(p$blnolo)-((COMMON)(CUR$.SL$)).brctab.Elt[rank(p$blnohi)-((COMMON)(CUR$.SL$)).brctab.LB[0]].val.LB[0]];
        TRACE_END_STM$("getBrc",1182);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure getBrc",1,1178,47,1182,52,1183);
}
