// JavaLine 1 <== SourceLine 66
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:45 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class OuptFile$outtag extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=66, lastLine=71, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 67
    Common inspect$67$25=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public OuptFile$outtag setPar(Object param) {
        //Util.BREAK("CALL OuptFile$outtag.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$i=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public OuptFile$outtag(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public OuptFile$outtag(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public OuptFile$outtag STM$() {
        {
            // BEGIN INSPECTION 
            inspect$67$25=((OuptFile)(CUR$.SL$)).p3$comn;
            if(inspect$67$25!=null) // INSPECT inspect$67$25
            // JavaLine 44 <== SourceLine 68
            {
                if(VALUE$((p$i==(0)))) {
                    new Common$WARNING(inspect$67$25,new TXT$("TAG = ZERO"));
                }
                ;
                // JavaLine 50 <== SourceLine 69
                if(VALUE$((((OuptFile)(CUR$.SL$)).output_trace$3>(0)))) {
                    new OuptFile$TRC(((OuptFile)(CUR$.SL$)),copy(new TXT$("Outtag")),new Common$TagName(inspect$67$25,p$i).RESULT$);
                }
                ;
                // JavaLine 55 <== SourceLine 70
                ((OuptFile)(CUR$.SL$)).out2byte(p$i);
                ;
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("OUPTFILE.sim","Procedure outtag",1,66,11,67,44,68,50,69,55,70,62,71);
} // End of Procedure
