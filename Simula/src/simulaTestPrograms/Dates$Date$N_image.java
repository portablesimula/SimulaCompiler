// JavaLine 1 ==> SourceLine 27
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$N_image extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=27, lastLine=35, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$Nx;
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 30
    TXT$ Tx=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public Dates$Date$N_image setPar(Object param) {
        //Util.BREAK("CALL Dates$Date$N_image.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$Nx=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Dates$Date$N_image(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public Dates$Date$N_image(RTObject$ SL$,int sp$Nx) {
        super(SL$);
        // Parameter assignment to locals
        this.p$Nx = sp$Nx;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("N_image",30);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$Date$N_image STM$() {
        TRACE_BEGIN_STM$("N_image",30);
        // JavaLine 46 ==> SourceLine 32
        Tx=blanks(4);
        TXT$.putint(Tx,p$Nx);
        TXT$.setpos(Tx,1);
        // JavaLine 50 ==> SourceLine 33
        while((TXT$.getchar(Tx)==(((char)32)))) {
        }
        // JavaLine 53 ==> SourceLine 34
        RESULT$=TXT$.sub(Tx,(TXT$.pos(Tx)-(1)),(6-(TXT$.pos(Tx))));
        TRACE_END_STM$("N_image",34);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure N_image",1,27,15,30,46,32,50,33,53,34,58,35);
}
