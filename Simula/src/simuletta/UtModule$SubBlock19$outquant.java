// JavaLine 1 <== SourceLine 121
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:52 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class UtModule$SubBlock19$outquant extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=121, lastLine=126, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common$quant p$q;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 122
    Common$quant inspect$122$122=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public UtModule$SubBlock19$outquant setPar(Object param) {
        //Util.BREAK("CALL UtModule$SubBlock19$outquant.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$q=(Common$quant)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public UtModule$SubBlock19$outquant(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public UtModule$SubBlock19$outquant(RTObject$ SL$,Common$quant sp$q) {
        super(SL$);
        // Parameter assignment to locals
        this.p$q = sp$q;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public UtModule$SubBlock19$outquant STM$() {
        {
            // BEGIN INSPECTION 
            inspect$122$122=p$q;
            if(inspect$122$122!=null) // INSPECT inspect$122$122
            // JavaLine 44 <== SourceLine 123
            {
                new OuptFile$outbyt(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_VAR$1);
                ;
                new UtModule$SubBlock19$outtype(((UtModule$SubBlock19)(CUR$.SL$)),inspect$122$122.p3$type);
                ;
                // JavaLine 50 <== SourceLine 124
                new UtModule$SubBlock19$outXtag(((UtModule$SubBlock19)(CUR$.SL$)),p$q);
                ;
                new OuptFile$outnumber(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,inspect$122$122.count$3);
                ;
                // JavaLine 55 <== SourceLine 125
                if(VALUE$((((UtModule)(CUR$.SL$.SL$)).inspect$17$115.output_trace$3>(0)))) {
                    new OuptFile$outcode(((UtModule)(CUR$.SL$.SL$)).inspect$17$115);
                }
                ;
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("UTMODULE.sim","Procedure outquant",1,121,11,122,44,123,50,124,55,125,64,126);
} // End of Procedure
