// JavaLine 1 ==> SourceLine 115
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon Mar 18 11:16:18 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst106$simtst106$PBLK76$townpoint$put extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=115, lastLine=118, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public Head$ p$h;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 117
    Link$ inspect$117$1=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst106$simtst106$PBLK76$townpoint$put setPar(Object param) {
        //Util.BREAK("CALL simtst106$simtst106$PBLK76$townpoint$put.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$h=(Head$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public simtst106$simtst106$PBLK76$townpoint$put(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public simtst106$simtst106$PBLK76$townpoint$put(RTObject$ SL$,Head$ sp$h) {
        super(SL$);
        // Parameter assignment to locals
        this.p$h = sp$h;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("put",117);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst106$simtst106$PBLK76$townpoint$put STM$() {
        TRACE_BEGIN_STM$("put",117);
        // JavaLine 43 ==> SourceLine 116
        new simtst106$simtst106$PBLK76$townpoint(((simtst106$PBLK76)(CUR$.SL$.SL$)),((simtst106$simtst106$PBLK76$townpoint)(CUR$.SL$)).p2$t).STM$().into(p$h);
        // JavaLine 45 ==> SourceLine 117
        {
            // BEGIN INSPECTION 
            inspect$117$1=((simtst106$simtst106$PBLK76$townpoint)(CUR$.SL$)).suc();
            //INSPECT inspect$117$1
            if(inspect$117$1 instanceof simtst106$simtst106$PBLK76$townpoint) // WHEN simtst106$simtst106$PBLK76$townpoint DO 
            new simtst106$simtst106$PBLK76$townpoint$put(((simtst106$simtst106$PBLK76$townpoint)(inspect$117$1)),p$h);
        }
        TRACE_END_STM$("put",117);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst106.sim","Procedure put",1,115,12,117,43,116,45,117,56,118);
}
