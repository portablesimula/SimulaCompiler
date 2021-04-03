// JavaLine 1 <== SourceLine 33
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:45 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class OuptFile$outinst extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=33, lastLine=39, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 35
    Common inspect$35$20=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public OuptFile$outinst setPar(Object param) {
        //Util.BREAK("CALL OuptFile$outinst.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public OuptFile$outinst(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public OuptFile$outinst(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public OuptFile$outinst STM$() {
        // JavaLine 40 <== SourceLine 34
        if(VALUE$((((OuptFile)(CUR$.SL$)).output_trace$3>(0)))) {
            // JavaLine 42 <== SourceLine 35
            {
                // BEGIN INSPECTION 
                inspect$35$20=((OuptFile)(CUR$.SL$)).p3$comn;
                if(inspect$35$20!=null) // INSPECT inspect$35$20
                // JavaLine 47 <== SourceLine 36
                {
                    new OuptFile$TRC(((OuptFile)(CUR$.SL$)),copy(new TXT$("Outinstr")),new Common$edSymbol(inspect$35$20,p$i).RESULT$);
                    ;
                }
            }
        }
        ;
        // JavaLine 55 <== SourceLine 38
        ((OuptFile)(CUR$.SL$)).outbyte(p$i);
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("OUPTFILE.sim","Procedure outinst",1,33,11,35,40,34,42,35,47,36,55,38,60,39);
} // End of Procedure
