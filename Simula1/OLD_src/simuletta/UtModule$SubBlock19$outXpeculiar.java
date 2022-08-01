// JavaLine 1 <== SourceLine 46
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:52 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class UtModule$SubBlock19$outXpeculiar extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=46, lastLine=64, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common$peculiar p$d;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 47
    TXT$ id=null;
    // JavaLine 13 <== SourceLine 48
    Common$peculiar inspect$48$118=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public UtModule$SubBlock19$outXpeculiar setPar(Object param) {
        //Util.BREAK("CALL UtModule$SubBlock19$outXpeculiar.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$d=(Common$peculiar)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public UtModule$SubBlock19$outXpeculiar(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public UtModule$SubBlock19$outXpeculiar(RTObject$ SL$,Common$peculiar sp$d) {
        super(SL$);
        // Parameter assignment to locals
        this.p$d = sp$d;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public UtModule$SubBlock19$outXpeculiar STM$() {
        {
            // BEGIN INSPECTION 
            inspect$48$118=p$d;
            if(inspect$48$118!=null) // INSPECT inspect$48$118
            // JavaLine 46 <== SourceLine 49
            {
                if(VALUE$((inspect$48$118.xtag$2==(0)))) {
                    // JavaLine 49 <== SourceLine 50
                    {
                        new UtModule$SubBlock19$setXtag(((UtModule$SubBlock19)(CUR$.SL$)),inspect$48$118.tag$2);
                        ;
                        inspect$48$118.xtag$2=((UtModule$SubBlock19)(CUR$.SL$)).nx;
                        ;
                        // JavaLine 55 <== SourceLine 51
                        new UtModule$SubBlock19$setXtag(((UtModule$SubBlock19)(CUR$.SL$)),inspect$48$118.body$4);
                        ;
                    }
                }
                ;
                // JavaLine 61 <== SourceLine 53
                id=((((inspect$48$118.p4$kind==(((UtModule)(CUR$.SL$.SL$)).inspect$17$114.S_ROUTINE$1))&&(TRF_NE(inspect$48$118.info$4,null))))?(inspect$48$118.info$4):(inspect$48$118.symb$2.symbol));
                ;
                // JavaLine 64 <== SourceLine 55
                if(VALUE$((((UtModule)(CUR$.SL$.SL$)).inspect$17$115.output_trace$3>(0)))) {
                    // JavaLine 66 <== SourceLine 58
                    new OuptFile$TRC(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,copy(new TXT$("Outxtag")),CONC(CONC(CONC(CONC(CONC(new TXT$("P"),new Common$eddouble(((UtModule)(CUR$.SL$.SL$)).inspect$17$114,inspect$48$118.tag$2).RESULT$),new TXT$("X")),new Common$leftint(((UtModule)(CUR$.SL$.SL$)).inspect$17$114,Math.subtractExact(inspect$48$118.xtag$2,1)).RESULT$),new TXT$(":")),id));
                }
                ;
                // JavaLine 70 <== SourceLine 59
                ((UtModule)(CUR$.SL$.SL$)).inspect$17$115.out2byte(inspect$48$118.xtag$2);
                ;
                // JavaLine 73 <== SourceLine 60
                ((UtModule)(CUR$.SL$.SL$)).inspect$17$115.outbyte(TXT$.length(id));
                ;
                ((UtModule)(CUR$.SL$.SL$)).inspect$17$115.outtext(id);
                ;
                // JavaLine 78 <== SourceLine 61
                ((UtModule)(CUR$.SL$.SL$)).inspect$17$115.out2byte(Math.addExact(inspect$48$118.xtag$2,1));
                ;
                // JavaLine 81 <== SourceLine 62
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
    public static PROGINFO$ INFO$=new PROGINFO$("UTMODULE.sim","Procedure outXpeculiar",1,46,11,47,13,48,46,49,49,50,55,51,61,53,64,55,66,58,70,59,73,60,78,61,81,62,91,64);
} // End of Procedure
