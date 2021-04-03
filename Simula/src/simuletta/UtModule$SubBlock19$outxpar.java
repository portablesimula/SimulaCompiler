// JavaLine 1 <== SourceLine 135
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:52 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class UtModule$SubBlock19$outxpar extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=135, lastLine=140, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$i;
    public Common$quant p$p;
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 136
    Common$quant inspect$136$124=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public UtModule$SubBlock19$outxpar setPar(Object param) {
        //Util.BREAK("CALL UtModule$SubBlock19$outxpar.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public UtModule$SubBlock19$outxpar(RTObject$ SL$) {
        super(SL$,2); // Expecting 2 parameters
    }
    // Normal Constructor
    public UtModule$SubBlock19$outxpar(RTObject$ SL$,int sp$i,Common$quant sp$p) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        this.p$p = sp$p;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public UtModule$SubBlock19$outxpar STM$() {
        {
            // BEGIN INSPECTION 
            inspect$136$124=p$p;
            if(inspect$136$124!=null) // INSPECT inspect$136$124
            // JavaLine 47 <== SourceLine 137
            {
                new OuptFile$outbyt(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,p$i);
                ;
                new UtModule$SubBlock19$outtype(((UtModule$SubBlock19)(CUR$.SL$)),inspect$136$124.p3$type);
                ;
                new UtModule$SubBlock19$outXtag(((UtModule$SubBlock19)(CUR$.SL$)),((Common$descr)inspect$136$124));
                ;
                // JavaLine 55 <== SourceLine 138
                new OuptFile$outnumber(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,inspect$136$124.count$3);
                ;
                // JavaLine 58 <== SourceLine 139
                if(VALUE$((((UtModule)(CUR$.SL$.SL$)).inspect$17$115.output_trace$3>(0)))) {
                    new OuptFile$outcode(((UtModule)(CUR$.SL$.SL$)).inspect$17$115);
                }
                ;
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("UTMODULE.sim","Procedure outxpar",1,135,12,136,47,137,55,138,58,139,67,140);
} // End of Procedure
