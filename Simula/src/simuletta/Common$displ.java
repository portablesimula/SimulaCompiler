// JavaLine 1 <== SourceLine 725
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$displ extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=725, lastLine=744, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common$descr p$d;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 726
    Linkage$ old=null;
    // JavaLine 13 <== SourceLine 728
    Common$descr inspect$728$7=null;
    // JavaLine 15 <== SourceLine 730
    Common$symbolbox inspect$730$8=null;
    // JavaLine 17 <== SourceLine 736
    Linkage$ inspect$736$9=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$displ setPar(Object param) {
        //Util.BREAK("CALL Common$displ.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public Common$displ(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Common$displ(RTObject$ SL$,Common$descr sp$d) {
        super(SL$);
        // Parameter assignment to locals
        this.p$d = sp$d;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$displ STM$() {
        // JavaLine 46 <== SourceLine 727
        if(VALUE$((((Common)(CUR$.SL$)).module_trace$1>(1)))) {
            sysout().outtext(new TXT$(" >>> Into display: "));
        }
        ;
        // JavaLine 51 <== SourceLine 728
        {
            // BEGIN INSPECTION 
            inspect$728$7=p$d;
            if(inspect$728$7!=null) // INSPECT inspect$728$7
            // JavaLine 56 <== SourceLine 729
            {
                if(VALUE$((((Common)(CUR$.SL$)).module_trace$1>(1)))) {
                    new Common$prt(((Common)(CUR$.SL$)),((Common$descr)inspect$728$7),20);
                }
                ;
                // JavaLine 62 <== SourceLine 730
                {
                    // BEGIN INSPECTION 
                    inspect$730$8=inspect$728$7.symb$2;
                    if(inspect$730$8!=null) // INSPECT inspect$730$8
                    // JavaLine 67 <== SourceLine 731
                    {
                        old=inspect$730$8.curmeaning;
                        ;
                        inspect$730$8.curmeaning=((Common$descr)inspect$728$7);
                        ;
                    }
                }
                ;
                // JavaLine 76 <== SourceLine 733
                if(VALUE$((!(inspect$728$7.global$2)))) {
                    // JavaLine 78 <== SourceLine 734
                    new Common$displnotice(((Common)(CUR$.SL$)),((Common$descr)inspect$728$7),((Common$descr)(old))).STM$().into(((Common)(CUR$.SL$)).redeclset$1);
                }
                ;
                // JavaLine 82 <== SourceLine 736
                {
                    // BEGIN INSPECTION 
                    inspect$736$9=old;
                    //INSPECT inspect$736$9
                    if(inspect$736$9 instanceof Common$descr) // WHEN Common$descr DO 
                    // JavaLine 88 <== SourceLine 737
                    if(VALUE$((((Common$descr)(inspect$736$9)).global$2&&(p$d.global$2)))) {
                        // JavaLine 90 <== SourceLine 739
                        new Common$ERROR(((Common)(CUR$.SL$)),CONC(new TXT$("Illegal re-declaration of "),((Common$descr)(inspect$736$9)).symb$2.symbol));
                    }
                    else if(inspect$736$9 instanceof Common$mnemonic) // WHEN Common$mnemonic DO 
                    // JavaLine 94 <== SourceLine 741
                    new Common$ERROR(((Common)(CUR$.SL$)),CONC(new TXT$("Mnemonic re-declaration: "),inspect$728$7.symb$2.symbol));
                }
                ;
            }
        }
        ;
        // JavaLine 101 <== SourceLine 743
        if(VALUE$((((Common)(CUR$.SL$)).module_trace$1>(1)))) {
            sysout().outimage();
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure displ",1,725,11,726,13,728,15,730,17,736,46,727,51,728,56,729,62,730,67,731,76,733,78,734,82,736,88,737,90,739,94,741,101,743,108,744);
} // End of Procedure
