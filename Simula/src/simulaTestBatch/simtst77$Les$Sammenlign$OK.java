// JavaLine 1 ==> SourceLine 22
package simulaTestBatch;
// Release-Beta-0.3 Compiled at Sat Jan 05 09:02:04 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst77$Les$Sammenlign$OK extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=22, lastLine=25, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst77$Les$Sammenlign$OK setPar(Object param) {
        //Util.BREAK("CALL simtst77$Les$Sammenlign$OK.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$i=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public simtst77$Les$Sammenlign$OK(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public simtst77$Les$Sammenlign$OK(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("OK",22);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst77$Les$Sammenlign$OK STM$() {
        TRACE_BEGIN_STM$("OK",22);
        // JavaLine 44 ==> SourceLine 23
        RESULT$=((((p$i<=(((simtst77$Les)(CUR$.SL$.SL$)).lnr))&((p$i<=(((simtst77$Les)(CUR$.SL$.SL$)).p$andre.lnr)))))?(TXTREL$EQ(((simtst77$Les)(CUR$.SL$.SL$)).linjer.Elt[p$i-((simtst77$Les)(CUR$.SL$.SL$)).linjer.LB[0]],((ARRAY$<TXT$[]>)((simtst77$Les)(CUR$.SL$.SL$)).p$andre.linjer).Elt[p$i-((simtst77$Les)(CUR$.SL$.SL$)).p$andre.linjer.LB[0]])):(false));
        TRACE_END_STM$("OK",23);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst77.sim","Procedure OK",1,22,44,23,49,25);
}
