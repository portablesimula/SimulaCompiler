// JavaLine 1 <== SourceLine 66
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:52 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class UtModule$SubBlock19$outXtag extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=66, lastLine=80, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common$descr p$d;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 67
    TXT$ id=null;
    // JavaLine 13 <== SourceLine 68
    Common$descr inspect$68$119=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public UtModule$SubBlock19$outXtag setPar(Object param) {
        //Util.BREAK("CALL UtModule$SubBlock19$outXtag.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$d=(Common$descr)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public UtModule$SubBlock19$outXtag(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public UtModule$SubBlock19$outXtag(RTObject$ SL$,Common$descr sp$d) {
        super(SL$);
        // Parameter assignment to locals
        this.p$d = sp$d;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public UtModule$SubBlock19$outXtag STM$() {
        {
            // BEGIN INSPECTION 
            inspect$68$119=p$d;
            if(inspect$68$119!=null) // INSPECT inspect$68$119
            // JavaLine 46 <== SourceLine 69
            {
                if(VALUE$((inspect$68$119.xtag$2==(0)))) {
                    // JavaLine 49 <== SourceLine 70
                    {
                        new UtModule$SubBlock19$setXtag(((UtModule$SubBlock19)(CUR$.SL$)),inspect$68$119.tag$2);
                        ;
                        inspect$68$119.xtag$2=((UtModule$SubBlock19)(CUR$.SL$)).nx;
                        ;
                    }
                }
                ;
                // JavaLine 58 <== SourceLine 72
                id=inspect$68$119.symb$2.symbol;
                ;
                // JavaLine 61 <== SourceLine 73
                if(VALUE$((((UtModule)(CUR$.SL$.SL$)).inspect$17$115.output_trace$3>(0)))) {
                    // JavaLine 63 <== SourceLine 76
                    new OuptFile$TRC(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,copy(new TXT$("Outxtag")),CONC(CONC(CONC(CONC(CONC(new TXT$("T"),new Common$eddouble(((UtModule)(CUR$.SL$.SL$)).inspect$17$114,inspect$68$119.tag$2).RESULT$),new TXT$("X")),new Common$leftint(((UtModule)(CUR$.SL$.SL$)).inspect$17$114,Math.subtractExact(inspect$68$119.xtag$2,1)).RESULT$),new TXT$(":")),id));
                }
                ;
                // JavaLine 67 <== SourceLine 77
                ((UtModule)(CUR$.SL$.SL$)).inspect$17$115.out2byte(inspect$68$119.xtag$2);
                ;
                // JavaLine 70 <== SourceLine 78
                ((UtModule)(CUR$.SL$.SL$)).inspect$17$115.outbyte(TXT$.length(id));
                ;
                ((UtModule)(CUR$.SL$.SL$)).inspect$17$115.outtext(id);
                ;
            }
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("UTMODULE.sim","Procedure outXtag",1,66,11,67,13,68,46,69,49,70,58,72,61,73,63,76,67,77,70,78,80,80);
} // End of Procedure
