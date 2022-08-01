// JavaLine 1 <== SourceLine 128
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:52 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class UtModule$SubBlock19$outpar extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=128, lastLine=133, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$i;
    public Common$quant p$p;
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 129
    Common$quant inspect$129$123=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public UtModule$SubBlock19$outpar setPar(Object param) {
        //Util.BREAK("CALL UtModule$SubBlock19$outpar.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 2: p$i=intValue(param); break;
                case 1: p$p=(Common$quant)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public UtModule$SubBlock19$outpar(RTObject$ SL$) {
        super(SL$,2); // Expecting 2 parameters
    }
    // Normal Constructor
    public UtModule$SubBlock19$outpar(RTObject$ SL$,int sp$i,Common$quant sp$p) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        this.p$p = sp$p;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public UtModule$SubBlock19$outpar STM$() {
        {
            // BEGIN INSPECTION 
            inspect$129$123=p$p;
            if(inspect$129$123!=null) // INSPECT inspect$129$123
            // JavaLine 47 <== SourceLine 130
            {
                new OuptFile$outbyt(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,p$i);
                ;
                new UtModule$SubBlock19$outtype(((UtModule$SubBlock19)(CUR$.SL$)),inspect$129$123.p3$type);
                ;
                new OuptFile$outstring(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,inspect$129$123.symb$2.symbol);
                ;
                // JavaLine 55 <== SourceLine 131
                new OuptFile$outnumber(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,inspect$129$123.count$3);
                ;
                // JavaLine 58 <== SourceLine 132
                if(VALUE$((((UtModule)(CUR$.SL$.SL$)).inspect$17$115.output_trace$3>(0)))) {
                    new OuptFile$outcode(((UtModule)(CUR$.SL$.SL$)).inspect$17$115);
                }
                ;
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("UTMODULE.sim","Procedure outpar",1,128,12,129,47,130,55,131,58,132,67,133);
} // End of Procedure
