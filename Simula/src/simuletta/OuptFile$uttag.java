// JavaLine 1 <== SourceLine 59
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:45 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class OuptFile$uttag extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=59, lastLine=64, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$t;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 60
    Common inspect$60$24=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public OuptFile$uttag setPar(Object param) {
        //Util.BREAK("CALL OuptFile$uttag.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$t=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public OuptFile$uttag(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public OuptFile$uttag(RTObject$ SL$,int sp$t) {
        super(SL$);
        // Parameter assignment to locals
        this.p$t = sp$t;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public OuptFile$uttag STM$() {
        {
            // BEGIN INSPECTION 
            inspect$60$24=((OuptFile)(CUR$.SL$)).p3$comn;
            if(inspect$60$24!=null) // INSPECT inspect$60$24
            // JavaLine 44 <== SourceLine 61
            {
                if(VALUE$((p$t==(0)))) {
                    new Common$WARNING(inspect$60$24,new TXT$("UTTAG = ZERO???"));
                }
                ;
                // JavaLine 50 <== SourceLine 62
                if(VALUE$((((OuptFile)(CUR$.SL$)).output_trace$3>(0)))) {
                    new OuptFile$TRC(((OuptFile)(CUR$.SL$)),copy(new TXT$("Uttag")),new Common$TagName(inspect$60$24,p$t).RESULT$);
                }
                ;
                // JavaLine 55 <== SourceLine 63
                ((OuptFile)(CUR$.SL$)).out2byte(p$t);
                ;
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("OUPTFILE.sim","Procedure uttag",1,59,11,60,44,61,50,62,55,63,62,64);
} // End of Procedure
