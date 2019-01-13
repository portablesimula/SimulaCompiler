// JavaLine 1 ==> SourceLine 1268
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:42 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$checkasexp extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=1268, lastLine=1282, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public CHECKER1$semchecker1$identifier p$id;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public CHECKER1$semchecker1$checkasexp setPar(Object param) {
        //Util.BREAK("CALL CHECKER1$semchecker1$checkasexp.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$id=(CHECKER1$semchecker1$identifier)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public CHECKER1$semchecker1$checkasexp(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public CHECKER1$semchecker1$checkasexp(RTObject$ SL$,CHECKER1$semchecker1$identifier sp$id) {
        super(SL$);
        // Parameter assignment to locals
        this.p$id = sp$id;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("checkasexp",1268);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$checkasexp STM$() {
        TRACE_BEGIN_STM$("checkasexp",1268);
        // JavaLine 41 ==> SourceLine 1275
        switch(p$id.kind) { // BEGIN SWITCH STATEMENT
        case 1: 
        case 5: 
        // JavaLine 45 ==> SourceLine 1277
        if((p$id.meaning.descr!=(null))) {
            // JavaLine 47 ==> SourceLine 1278
            {
                TRACE_BEGIN_STM$("CompoundStatement1278",1278);
                if((p$id.meaning.descr.npar>(0))) {
                    new CHECKER1$semchecker1$identifier$identError(p$id,352);
                }
                TRACE_END_STM$("CompoundStatement1278",1278);
            }
        }
        case 2: 
        case 6: 
        case 4: 
        // JavaLine 59 ==> SourceLine 1279
        new CHECKER1$semchecker1$identifier$identError(p$id,353);
    } // END SWITCH STATEMENT
    TRACE_END_STM$("checkasexp",1279);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure checkasexp",1,1268,41,1275,45,1277,47,1278,59,1279,65,1282);
}
