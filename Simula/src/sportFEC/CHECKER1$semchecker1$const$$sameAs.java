// JavaLine 1 ==> SourceLine 1186
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$const$$sameAs extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1186, lastLine=1188, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public CHECKER1$semchecker1$exp p$e;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public CHECKER1$semchecker1$const$$sameAs setPar(Object param) {
        //Util.BREAK("CALL CHECKER1$semchecker1$const$$sameAs.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$e=(CHECKER1$semchecker1$exp)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public CHECKER1$semchecker1$const$$sameAs(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public CHECKER1$semchecker1$const$$sameAs(RTObject$ SL$,CHECKER1$semchecker1$exp sp$e) {
        super(SL$);
        // Parameter assignment to locals
        this.p$e = sp$e;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("sameAs",1186);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$const$$sameAs STM$() {
        TRACE_BEGIN_STM$("sameAs",1186);
        // JavaLine 44 ==> SourceLine 1187
        if((p$e.p$ch==(((CHECKER1)(CUR$.SL$.SL$.SL$)).ICONS))) {
            {
                TRACE_BEGIN_STM$("CompoundStatement1187",1187);
                if((((CHECKER1$semchecker1$const$)(p$e)).ixlo==(((CHECKER1$semchecker1$const$)(CUR$.SL$)).ixlo))) {
                    // JavaLine 49 ==> SourceLine 1188
                    RESULT$=(((CHECKER1$semchecker1$const$)(p$e)).ixhi==(((CHECKER1$semchecker1$const$)(CUR$.SL$)).ixhi));
                }
                TRACE_END_STM$("CompoundStatement1187",1188);
            }
        }
        TRACE_END_STM$("sameAs",1188);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure sameAs",1,1186,44,1187,49,1188,58,1188);
}
