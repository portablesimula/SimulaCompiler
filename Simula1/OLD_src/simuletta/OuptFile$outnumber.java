// JavaLine 1 <== SourceLine 47
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:45 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class OuptFile$outnumber extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=47, lastLine=51, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$n;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 48
    Common inspect$48$22=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public OuptFile$outnumber setPar(Object param) {
        //Util.BREAK("CALL OuptFile$outnumber.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$n=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public OuptFile$outnumber(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public OuptFile$outnumber(RTObject$ SL$,int sp$n) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public OuptFile$outnumber STM$() {
        {
            // BEGIN INSPECTION 
            inspect$48$22=((OuptFile)(CUR$.SL$)).p3$comn;
            if(inspect$48$22!=null) // INSPECT inspect$48$22
            // JavaLine 44 <== SourceLine 49
            {
                if(VALUE$((((OuptFile)(CUR$.SL$)).output_trace$3>(0)))) {
                    new OuptFile$TRC(((OuptFile)(CUR$.SL$)),copy(new TXT$("Outnumber")),new Common$leftint(inspect$48$22,p$n).RESULT$);
                }
                ;
                // JavaLine 50 <== SourceLine 50
                ((OuptFile)(CUR$.SL$)).out2byte(p$n);
                ;
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("OUPTFILE.sim","Procedure outnumber",1,47,11,48,44,49,50,50,57,51);
} // End of Procedure
