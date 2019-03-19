// JavaLine 1 ==> SourceLine 133
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon Mar 18 11:16:18 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst106$simtst106$PBLK76$town$find extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=133, lastLine=136, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public simtst106$simtst106$PBLK76$town RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public TXT$ p$code;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst106$simtst106$PBLK76$town$find setPar(Object param) {
        //Util.BREAK("CALL simtst106$simtst106$PBLK76$town$find.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$code=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public simtst106$simtst106$PBLK76$town$find(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public simtst106$simtst106$PBLK76$town$find(RTObject$ SL$,TXT$ sp$code) {
        super(SL$);
        // Parameter assignment to locals
        this.p$code = sp$code;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("find",133);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst106$simtst106$PBLK76$town$find STM$() {
        TRACE_BEGIN_STM$("find",133);
        // JavaLine 44 ==> SourceLine 134
        if(VALUE$(TXTREL$EQ(p$code,((simtst106$simtst106$PBLK76$town)(CUR$.SL$)).p2$nam_))) {
            RESULT$=((simtst106$simtst106$PBLK76$town)(CUR$.SL$));
        } else
        // JavaLine 48 ==> SourceLine 135
        if(VALUE$((((simtst106$simtst106$PBLK76$town)(CUR$.SL$)).suc()==(null)))) {
            RESULT$=new simtst106$simtst106$PBLK76$town(((simtst106$PBLK76)(CUR$.SL$.SL$)),copy(p$code)).STM$();
        } else
        // JavaLine 52 ==> SourceLine 136
        RESULT$=new simtst106$simtst106$PBLK76$town$find(((simtst106$simtst106$PBLK76$town)(((simtst106$simtst106$PBLK76$town)(CUR$.SL$)).suc())),p$code).RESULT$;
        TRACE_END_STM$("find",136);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst106.sim","Procedure find",1,133,44,134,48,135,52,136,57,136);
}
