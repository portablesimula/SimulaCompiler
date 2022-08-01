// JavaLine 1 <== SourceLine 1798
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$grammar$make_const extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=1798, lastLine=1815, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public Common$const$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public Common$expr p$e;
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 1799
    Common$idn_const c=null;
    // JavaLine 16 <== SourceLine 1801
    Common$expr inspect$1801$109=null;
    // JavaLine 18 <== SourceLine 1806
    Link$ inspect$1806$110=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass1$SubBlock32$grammar$make_const setPar(Object param) {
        //Util.BREAK("CALL Pass1$SubBlock32$grammar$make_const.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$e=(Common$expr)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass1$SubBlock32$grammar$make_const(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass1$SubBlock32$grammar$make_const(RTObject$ SL$,Common$expr sp$e) {
        super(SL$);
        // Parameter assignment to locals
        this.p$e = sp$e;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass1$SubBlock32$grammar$make_const STM$() {
        // JavaLine 47 <== SourceLine 1801
        {
            // BEGIN INSPECTION 
            inspect$1801$109=p$e;
            //INSPECT inspect$1801$109
            if(inspect$1801$109 instanceof Common$const$) // WHEN Common$const$ DO 
            RESULT$=((Common$const$)inspect$1801$109);
            else if(inspect$1801$109 instanceof Common$designator) // WHEN Common$designator DO 
            // JavaLine 55 <== SourceLine 1803
            {
                RESULT$=c=new Common$idn_const(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_C_PADDR$1,null).STM$();
                ;
                // JavaLine 59 <== SourceLine 1804
                if(VALUE$((((Common$designator)(inspect$1801$109)).p3$varset.cardinal()!=(1)))) {
                    // JavaLine 61 <== SourceLine 1805
                    new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Remote label is not allowed"));
                }
                ;
                // JavaLine 65 <== SourceLine 1806
                {
                    // BEGIN INSPECTION 
                    inspect$1806$110=((Common$designator)(inspect$1801$109)).p3$varset.first();
                    //INSPECT inspect$1806$110
                    if(inspect$1806$110 instanceof Common$variable) // WHEN Common$variable DO 
                    // JavaLine 71 <== SourceLine 1807
                    {
                        if(VALUE$((((Common$variable)(inspect$1806$110)).argset$2!=(null)))) {
                            // JavaLine 74 <== SourceLine 1808
                            new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Indexed label is not allowed"));
                        }
                        ;
                        // JavaLine 78 <== SourceLine 1809
                        c.p4$ibox=((Common$variable)(inspect$1806$110)).varbox$2;
                        ;
                    }
                    else // OTHERWISE 
                    // JavaLine 83 <== SourceLine 1810
                    new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Illegal label"));
                }
                ;
            }
            else // OTHERWISE 
            // JavaLine 89 <== SourceLine 1812
            {
                new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Illegal constant"));
                ;
                // JavaLine 93 <== SourceLine 1813
                RESULT$=new Common$val_const(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_C_INT$1,copy(copy(new TXT$("0")))).STM$();
                ;
            }
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure make_const",1,1798,14,1799,16,1801,18,1806,47,1801,55,1803,59,1804,61,1805,65,1806,71,1807,74,1808,78,1809,83,1810,89,1812,93,1813,101,1815);
} // End of Procedure
