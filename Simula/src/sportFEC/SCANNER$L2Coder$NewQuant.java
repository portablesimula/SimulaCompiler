// JavaLine 1 ==> SourceLine 1642
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:44:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$L2Coder$NewQuant extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=1642, lastLine=1655, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public char p$qcateg;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 1643
    COMMON$quantity inspect$1643$10=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public SCANNER$L2Coder$NewQuant setPar(Object param) {
        //Util.BREAK("CALL SCANNER$L2Coder$NewQuant.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$qcateg=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public SCANNER$L2Coder$NewQuant(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public SCANNER$L2Coder$NewQuant(RTObject$ SL$,char sp$qcateg) {
        super(SL$);
        // Parameter assignment to locals
        this.p$qcateg = sp$qcateg;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("NewQuant",1643);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$L2Coder$NewQuant STM$() {
        TRACE_BEGIN_STM$("NewQuant",1643);
        {
            // BEGIN INSPECTION 
            inspect$1643$10=new COMMON$quantity(((SCANNER)(CUR$.SL$.SL$))).STM$();
            if(inspect$1643$10!=null) //INSPECT inspect$1643$10
            // JavaLine 47 ==> SourceLine 1645
            {
                TRACE_BEGIN_STM$("CompoundStatement1645",1645);
                inspect$1643$10.type=((SCANNER$L2Coder)(CUR$.SL$)).ctype;
                inspect$1643$10.kind=((SCANNER$L2Coder)(CUR$.SL$)).ckind;
                // JavaLine 52 ==> SourceLine 1646
                inspect$1643$10.categ=p$qcateg;
                inspect$1643$10.line=((SCANNER)(CUR$.SL$.SL$)).linenr;
                // JavaLine 55 ==> SourceLine 1647
                inspect$1643$10.plev=((SCANNER)(CUR$.SL$.SL$)).one;
                // JavaLine 57 ==> SourceLine 1648
                inspect$1643$10.ftag=(-(((SCANNER$L2Coder)(CUR$.SL$)).cqual));
                // JavaLine 59 ==> SourceLine 1649
                inspect$1643$10.symb=new COMMON$boxof(((SCANNER)(CUR$.SL$.SL$)),((SCANNER)(CUR$.SL$.SL$)).opdhi,((SCANNER)(CUR$.SL$.SL$)).opdlo).RESULT$;
                // JavaLine 61 ==> SourceLine 1650
                if((p$qcateg!=(((SCANNER)(CUR$.SL$.SL$)).C_virt))) {
                    // JavaLine 63 ==> SourceLine 1651
                    ((SCANNER$L2Coder)(CUR$.SL$)).cquant=((COMMON$quantity)(((SCANNER$L2Coder)(CUR$.SL$)).cquant.next=((COMMON$quantity)inspect$1643$10)));
                } else
                // JavaLine 66 ==> SourceLine 1652
                if((((SCANNER$L2Coder)(CUR$.SL$)).cbrec.favirt==(null))) {
                    // JavaLine 68 ==> SourceLine 1653
                    ((SCANNER$L2Coder)(CUR$.SL$)).cbrec.favirt=((SCANNER$L2Coder)(CUR$.SL$)).vquant=((COMMON$quantity)inspect$1643$10);
                } else
                // JavaLine 71 ==> SourceLine 1654
                ((SCANNER$L2Coder)(CUR$.SL$)).vquant=((COMMON$quantity)(((SCANNER$L2Coder)(CUR$.SL$)).vquant.next=((COMMON$quantity)inspect$1643$10)));
                TRACE_END_STM$("CompoundStatement1645",1654);
            }
        }
        TRACE_END_STM$("NewQuant",1654);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure NewQuant",1,1642,12,1643,47,1645,52,1646,55,1647,57,1648,59,1649,61,1650,63,1651,66,1652,68,1653,71,1654,79,1655);
}
