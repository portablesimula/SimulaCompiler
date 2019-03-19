// JavaLine 1 ==> SourceLine 90
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon Mar 18 11:16:18 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst106$simtst106$PBLK76$car$send extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=90, lastLine=93, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public Link$ p$c;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst106$simtst106$PBLK76$car$send setPar(Object param) {
        //Util.BREAK("CALL simtst106$simtst106$PBLK76$car$send.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$c=(Link$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public simtst106$simtst106$PBLK76$car$send(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public simtst106$simtst106$PBLK76$car$send(RTObject$ SL$,Link$ sp$c) {
        super(SL$);
        // Parameter assignment to locals
        this.p$c = sp$c;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("send",90);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst106$simtst106$PBLK76$car$send STM$() {
        TRACE_BEGIN_STM$("send",90);
        if(VALUE$(IS$(p$c,simtst106$simtst106$PBLK76$car.class))) {
            // JavaLine 42 ==> SourceLine 91
            {
                TRACE_BEGIN_STM$("CompoundStatement91",91);
                new simtst106$simtst106$PBLK76$townpoint$put(((simtst106$simtst106$PBLK76$townpoint)(((simtst106$simtst106$PBLK76$car)(CUR$.SL$)).been.first())),((simtst106$simtst106$PBLK76$car)(p$c)).been);
                // JavaLine 46 ==> SourceLine 92
                ((simtst106$PBLK76)(CUR$.SL$.SL$)).ActivateDirect(false,((Process$)(p$c)));
                TRACE_END_STM$("CompoundStatement91",92);
            }
        }
        TRACE_END_STM$("send",92);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst106.sim","Procedure send",1,90,42,91,46,92,54,93);
}
