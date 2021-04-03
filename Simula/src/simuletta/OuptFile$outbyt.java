// JavaLine 1 <== SourceLine 41
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:45 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class OuptFile$outbyt extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=41, lastLine=45, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 42
    Common inspect$42$21=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public OuptFile$outbyt setPar(Object param) {
        //Util.BREAK("CALL OuptFile$outbyt.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public OuptFile$outbyt(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public OuptFile$outbyt(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public OuptFile$outbyt STM$() {
        {
            // BEGIN INSPECTION 
            inspect$42$21=((OuptFile)(CUR$.SL$)).p3$comn;
            if(inspect$42$21!=null) // INSPECT inspect$42$21
            // JavaLine 44 <== SourceLine 43
            {
                if(VALUE$((((OuptFile)(CUR$.SL$)).output_trace$3>(0)))) {
                    new OuptFile$TRC(((OuptFile)(CUR$.SL$)),copy(new TXT$("Outbyt")),new Common$leftint(inspect$42$21,p$i).RESULT$);
                }
                ;
                // JavaLine 50 <== SourceLine 44
                ((OuptFile)(CUR$.SL$)).outbyte(p$i);
                ;
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("OUPTFILE.sim","Procedure outbyt",1,41,11,42,44,43,50,44,57,45);
} // End of Procedure
