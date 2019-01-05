// JavaLine 1 ==> SourceLine 70
package simulaTestBatch;
// Release-Beta-0.3 Compiled at Sat Jan 05 09:00:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst66$Ok extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=70, lastLine=76, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public simtst66$Innfil p$f1;
    public simtst66$Innfil p$f2;
    public int p$l;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst66$Ok setPar(Object param) {
        //Util.BREAK("CALL simtst66$Ok.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$f1=(simtst66$Innfil)objectValue(param); break;
                case 1: p$f2=(simtst66$Innfil)objectValue(param); break;
                case 2: p$l=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public simtst66$Ok(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public simtst66$Ok(RTObject$ SL$,simtst66$Innfil sp$f1,simtst66$Innfil sp$f2,int sp$l) {
        super(SL$);
        // Parameter assignment to locals
        this.p$f1 = sp$f1;
        this.p$f2 = sp$f2;
        this.p$l = sp$l;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Ok",70);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst66$Ok STM$() {
        TRACE_BEGIN_STM$("Ok",70);
        // JavaLine 50 ==> SourceLine 73
        if(((p$l>(p$f1.lnr))&((p$l>(p$f2.lnr))))) {
            // JavaLine 52 ==> SourceLine 74
            RESULT$=true;
        } else
        // JavaLine 55 ==> SourceLine 76
        RESULT$=(TXTREL$EQ(((ARRAY$<TXT$[]>)p$f1.linjer).Elt[p$l-p$f1.linjer.LB[0]],((ARRAY$<TXT$[]>)p$f2.linjer).Elt[p$l-p$f2.linjer.LB[0]])&(new simtst66$Ok(((simtst66)(CUR$.SL$)),p$f1,p$f2,(p$l+(1))).RESULT$));
        TRACE_END_STM$("Ok",76);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst66.sim","Procedure Ok",1,70,50,73,52,74,55,76,60,76);
}
