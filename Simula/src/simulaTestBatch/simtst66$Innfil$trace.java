// JavaLine 1 ==> SourceLine 26
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Mar 09 10:18:35 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst66$Innfil$trace extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=26, lastLine=34, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$msg;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst66$Innfil$trace setPar(Object param) {
        //Util.BREAK("CALL simtst66$Innfil$trace.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public simtst66$Innfil$trace(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public simtst66$Innfil$trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        // Parameter assignment to locals
        this.p$msg = sp$msg;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("trace",26);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst66$Innfil$trace STM$() {
        TRACE_BEGIN_STM$("trace",26);
        // JavaLine 41 ==> SourceLine 28
        if(VALUE$(((simtst66)(CUR$.SL$.SL$)).verbose)) {
            // JavaLine 43 ==> SourceLine 30
            {
                TRACE_BEGIN_STM$("CompoundStatement30",30);
                sysout().outtext(CONC(CONC(CONC(p$msg,new TXT$(" - NAVN=")),((simtst66$Innfil)(CUR$.SL$)).p$navn),new TXT$(" - a,lnr=")));
                // JavaLine 47 ==> SourceLine 31
                sysout().outint(((simtst66$Innfil)(CUR$.SL$)).p$a,3);
                sysout().outint(((simtst66$Innfil)(CUR$.SL$)).lnr,3);
                // JavaLine 50 ==> SourceLine 32
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement30",32);
            }
        }
        TRACE_END_STM$("trace",32);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst66.sim","Procedure trace",1,26,41,28,43,30,47,31,50,32,58,34);
}
