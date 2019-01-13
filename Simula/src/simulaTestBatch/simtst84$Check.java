// JavaLine 1 ==> SourceLine 20
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Jan 12 15:34:19 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst84$Check extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=20, lastLine=28, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public boolean p$b1;
    public boolean p$b2;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst84$Check setPar(Object param) {
        //Util.BREAK("CALL simtst84$Check.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$b1=(boolean)objectValue(param); break;
                case 1: p$b2=(boolean)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public simtst84$Check(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public simtst84$Check(RTObject$ SL$,boolean sp$b1,boolean sp$b2) {
        super(SL$);
        // Parameter assignment to locals
        this.p$b1 = sp$b1;
        this.p$b2 = sp$b2;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Check",20);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst84$Check STM$() {
        TRACE_BEGIN_STM$("Check",20);
        // JavaLine 44 ==> SourceLine 26
        if(((p$b1) == (p$b2))) {
        } else
        // JavaLine 47 ==> SourceLine 27
        {
            TRACE_BEGIN_STM$("CompoundStatement27",27);
            sysout().outtext(new TXT$("error"));
            sysout().outimage();
            ((simtst84)(CUR$.SL$)).foundError=true;
            TRACE_END_STM$("CompoundStatement27",27);
        }
        TRACE_END_STM$("Check",27);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst84.sim","Procedure Check",1,20,44,26,47,27,58,28);
}
