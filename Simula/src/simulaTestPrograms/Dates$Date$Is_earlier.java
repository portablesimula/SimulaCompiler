// JavaLine 1 ==> SourceLine 149
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Is_earlier extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=149, lastLine=157, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public Dates$Date p$Dx;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public Dates$Date$Is_earlier setPar(Object param) {
        //Util.BREAK("CALL Dates$Date$Is_earlier.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$Dx=(Dates$Date)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Dates$Date$Is_earlier(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public Dates$Date$Is_earlier(RTObject$ SL$,Dates$Date sp$Dx) {
        super(SL$);
        // Parameter assignment to locals
        this.p$Dx = sp$Dx;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Is_earlier",149);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$Date$Is_earlier STM$() {
        TRACE_BEGIN_STM$("Is_earlier",149);
        // JavaLine 44 ==> SourceLine 152
        if(VALUE$((((Dates$Date)(CUR$.SL$)).p$Y==(p$Dx.p$Y)))) {
            // JavaLine 46 ==> SourceLine 153
            {
                TRACE_BEGIN_STM$("CompoundStatement153",153);
                if(VALUE$((((Dates$Date)(CUR$.SL$)).p$M==(p$Dx.p$M)))) {
                    // JavaLine 50 ==> SourceLine 154
                    {
                        TRACE_BEGIN_STM$("CompoundStatement154",154);
                        RESULT$=(((Dates$Date)(CUR$.SL$)).p$D<(p$Dx.p$D));
                        TRACE_END_STM$("CompoundStatement154",154);
                    }
                } else
                // JavaLine 57 ==> SourceLine 155
                RESULT$=(((Dates$Date)(CUR$.SL$)).p$M<(p$Dx.p$M));
                TRACE_END_STM$("CompoundStatement153",155);
            }
        } else
        // JavaLine 62 ==> SourceLine 156
        RESULT$=(((Dates$Date)(CUR$.SL$)).p$Y<(p$Dx.p$Y));
        TRACE_END_STM$("Is_earlier",156);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure Is_earlier",1,149,44,152,46,153,50,154,57,155,62,156,67,157);
}
