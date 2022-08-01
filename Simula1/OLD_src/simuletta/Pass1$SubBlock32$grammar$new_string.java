// JavaLine 1 <== SourceLine 1817
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$grammar$new_string extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=1817, lastLine=1843, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public Common$structured_const RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public Head$ p$declset;
    public TXT$ p$t;
    public Common$symbolbox p$cbox;
    // Declare locals as attributes
    // JavaLine 16 <== SourceLine 1820
    Common$structured_const s=null;
    Common$quant q=null;
    // JavaLine 19 <== SourceLine 1821
    Common$const$ v=null;
    TXT$ t1=null;
    // JavaLine 22 <== SourceLine 1823
    Common$quant inspect$1823$111=null;
    // JavaLine 24 <== SourceLine 1833
    Common$structured_const inspect$1833$112=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass1$SubBlock32$grammar$new_string setPar(Object param) {
        //Util.BREAK("CALL Pass1$SubBlock32$grammar$new_string.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 3: p$declset=(Head$)objectValue(param); break;
                case 2: p$t=(TXT$)objectValue(param); break;
                case 1: p$cbox=(Common$symbolbox)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass1$SubBlock32$grammar$new_string(RTObject$ SL$) {
        super(SL$,3); // Expecting 3 parameters
    }
    // Normal Constructor
    public Pass1$SubBlock32$grammar$new_string(RTObject$ SL$,Head$ sp$declset,TXT$ sp$t,Common$symbolbox sp$cbox) {
        super(SL$);
        // Parameter assignment to locals
        this.p$declset = sp$declset;
        this.p$t = sp$t;
        this.p$cbox = sp$cbox;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass1$SubBlock32$grammar$new_string STM$() {
        // JavaLine 57 <== SourceLine 1823
        {
            // BEGIN INSPECTION 
            inspect$1823$111=new Common$quant(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_CHAR$1).STM$();
            if(inspect$1823$111!=null) // INSPECT inspect$1823$111
            // JavaLine 62 <== SourceLine 1824
            {
                inspect$1823$111.symb$2=p$cbox;
                ;
                // JavaLine 66 <== SourceLine 1825
                inspect$1823$111.count$3=TXT$.length(p$t);
                ;
                inspect$1823$111.read_only$3=true;
                ;
                // JavaLine 71 <== SourceLine 1826
                inspect$1823$111.global$2=false;
                ;
                // JavaLine 74 <== SourceLine 1829
                inspect$1823$111.initval$3=new Head$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                ;
                new Common$val_const(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_TEXT$1,p$t).STM$().into(inspect$1823$111.initval$3);
                ;
                // JavaLine 79 <== SourceLine 1830
                inspect$1823$111.into(p$declset);
                ;
            }
        }
        ;
        // JavaLine 85 <== SourceLine 1833
        {
            // BEGIN INSPECTION 
            inspect$1833$112=new Common$structured_const(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_C_RECORD$1).STM$();
            if(inspect$1833$112!=null) // INSPECT inspect$1833$112
            // JavaLine 90 <== SourceLine 1834
            {
                RESULT$=((Common$structured_const)inspect$1833$112);
                ;
                // JavaLine 94 <== SourceLine 1835
                inspect$1833$112.str$4=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.string$1;
                ;
                inspect$1833$112.elt_set$4=new Head$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                ;
                // JavaLine 99 <== SourceLine 1837
                v=new Common$idn_const(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_C_GADDR$1,p$cbox).STM$();
                ;
                // JavaLine 102 <== SourceLine 1838
                new Common$elt_notice(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.chradrBox$1,v).STM$().into(inspect$1833$112.elt_set$4);
                ;
                // JavaLine 105 <== SourceLine 1840
                t1=copy(copy(new Common$leftint(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,TXT$.length(p$t)).RESULT$));
                ;
                v=new Common$val_const(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_C_INT$1,t1).STM$();
                ;
                // JavaLine 110 <== SourceLine 1841
                new Common$elt_notice(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.nchrBox$1,v).STM$().into(inspect$1833$112.elt_set$4);
                ;
            }
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure new_string",1,1817,16,1820,19,1821,22,1823,24,1833,57,1823,62,1824,66,1825,71,1826,74,1829,79,1830,85,1833,90,1834,94,1835,99,1837,102,1838,105,1840,110,1841,118,1843);
} // End of Procedure
