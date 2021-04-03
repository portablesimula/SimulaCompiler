// JavaLine 1 <== SourceLine 286
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$defpeculiar extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=286, lastLine=299, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common$peculiar p$d;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 287
    Common$symbolbox symb=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$defpeculiar setPar(Object param) {
        //Util.BREAK("CALL Common$defpeculiar.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public Common$defpeculiar(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Common$defpeculiar(RTObject$ SL$,Common$peculiar sp$d) {
        super(SL$);
        // Parameter assignment to locals
        this.p$d = sp$d;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$defpeculiar STM$() {
        // JavaLine 40 <== SourceLine 288
        if(VALUE$((p$d.xtag$2==(0)))) {
            // JavaLine 42 <== SourceLine 289
            {
                if(VALUE$(p$d.libProc$3)) {
                    // JavaLine 45 <== SourceLine 290
                    {
                        ((Common)(CUR$.SL$)).simsymbol$1=p$d.info$4;
                        ;
                        new Common$DEFCONST(((Common)(CUR$.SL$)));
                        ;
                        symb=((Common)(CUR$.SL$)).symtab.Elt[((Common)(CUR$.SL$)).hash$1-((Common)(CUR$.SL$)).symtab.LB[0]];
                    }
                } else
                // JavaLine 54 <== SourceLine 291
                symb=p$d.symb$2;
                ;
                // JavaLine 57 <== SourceLine 292
                new Common$newtag(((Common)(CUR$.SL$)),symb);
                ;
                p$d.tag$2=((Common)(CUR$.SL$)).ntag$1;
                ;
                // JavaLine 62 <== SourceLine 293
                new Common$newtag(((Common)(CUR$.SL$)),symb);
                ;
                p$d.body$4=((Common)(CUR$.SL$)).ntag$1;
                ;
            }
        } else
        // JavaLine 69 <== SourceLine 296
        {
            p$d.tag$2=p$d.xtag$2;
            ;
            // JavaLine 73 <== SourceLine 297
            p$d.body$4=Math.addExact(p$d.xtag$2,1);
            ;
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure defpeculiar",1,286,11,287,40,288,42,289,45,290,54,291,57,292,62,293,69,296,73,297,80,299);
} // End of Procedure
