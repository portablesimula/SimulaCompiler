// JavaLine 1 <== SourceLine 53
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:45 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class OuptFile$outident extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=53, lastLine=57, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 54
    Common inspect$54$23=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public OuptFile$outident setPar(Object param) {
        //Util.BREAK("CALL OuptFile$outident.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public OuptFile$outident(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public OuptFile$outident(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public OuptFile$outident STM$() {
        {
            // BEGIN INSPECTION 
            inspect$54$23=((OuptFile)(CUR$.SL$)).p3$comn;
            if(inspect$54$23!=null) // INSPECT inspect$54$23
            // JavaLine 44 <== SourceLine 55
            {
                if(VALUE$((((OuptFile)(CUR$.SL$)).output_trace$3>(0)))) {
                    new OuptFile$TRC(((OuptFile)(CUR$.SL$)),copy(new TXT$("Outident")),lowcase(copy(copy(inspect$54$23.symtab.Elt[p$i-inspect$54$23.symtab.LB[0]].symbol))));
                }
                ;
                // JavaLine 50 <== SourceLine 56
                ((OuptFile)(CUR$.SL$)).out2byte(p$i);
                ;
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("OUPTFILE.sim","Procedure outident",1,53,11,54,44,55,50,56,57,57);
} // End of Procedure
