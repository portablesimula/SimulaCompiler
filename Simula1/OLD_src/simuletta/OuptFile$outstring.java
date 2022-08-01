// JavaLine 1 <== SourceLine 100
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:45 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class OuptFile$outstring extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=100, lastLine=105, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public TXT$ p$t;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public OuptFile$outstring setPar(Object param) {
        //Util.BREAK("CALL OuptFile$outstring.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$t=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public OuptFile$outstring(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public OuptFile$outstring(RTObject$ SL$,TXT$ sp$t) {
        super(SL$);
        // Parameter assignment to locals
        this.p$t = sp$t;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public OuptFile$outstring STM$() {
        // JavaLine 38 <== SourceLine 102
        if(VALUE$((((OuptFile)(CUR$.SL$)).output_trace$3>(0)))) {
            // JavaLine 40 <== SourceLine 103
            new OuptFile$TRC(((OuptFile)(CUR$.SL$)),copy(new TXT$("Outstring")),CONC(CONC(new TXT$("\""),p$t),new TXT$("\"")));
        }
        ;
        // JavaLine 44 <== SourceLine 104
        ((OuptFile)(CUR$.SL$)).outbyte(TXT$.length(p$t));
        ;
        ((OuptFile)(CUR$.SL$)).outtext(p$t);
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("OUPTFILE.sim","Procedure outstring",1,100,38,102,40,103,44,104,51,105);
} // End of Procedure
