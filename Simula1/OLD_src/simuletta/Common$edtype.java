// JavaLine 1 <== SourceLine 489
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$edtype extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=489, lastLine=512, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$t;
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 490
    Common$TypeNotice inspect$490$2=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$edtype setPar(Object param) {
        //Util.BREAK("CALL Common$edtype.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$t=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Common$edtype(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Common$edtype(RTObject$ SL$,int sp$t) {
        super(SL$);
        // Parameter assignment to locals
        this.p$t = sp$t;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$edtype STM$() {
        {
            // BEGIN INSPECTION 
            inspect$490$2=((Common)(CUR$.SL$)).typeTable.Elt[p$t-((Common)(CUR$.SL$)).typeTable.LB[0]];
            if(inspect$490$2!=null) // INSPECT inspect$490$2
            // JavaLine 47 <== SourceLine 491
            {
                RESULT$=(((inspect$490$2.p2$set==(((Common)(CUR$.SL$)).infixTypes$1)))?(copy(copy((((inspect$490$2.p2$qual==(((Common)(CUR$.SL$)).S_REAL$1)))?(new TXT$("real")):((((inspect$490$2.p2$qual==(((Common)(CUR$.SL$)).S_LONG$1)))?(new TXT$("long real")):((((inspect$490$2.p2$qual==(((Common)(CUR$.SL$)).S_SIZE$1)))?(new TXT$("size")):((((inspect$490$2.p2$qual==(((Common)(CUR$.SL$)).S_CHAR$1)))?(new TXT$("character")):((((inspect$490$2.p2$qual==(((Common)(CUR$.SL$)).S_BOOLEAN$1)))?(new TXT$("Boolean")):((((inspect$490$2.p2$qual==(((Common)(CUR$.SL$)).S_LABEL$1)))?(new TXT$("label")):(new TXT$("**Undefined**")))))))))))))))):((((inspect$490$2.p2$set==(((Common)(CUR$.SL$)).integerTypes$1)))?((((inspect$490$2.p2$qual==(((Common)(CUR$.SL$)).S_SHORT$1)))?(copy(copy(new TXT$("short integer")))):((((inspect$490$2.p2$qual==(((Common)(CUR$.SL$)).S_INTEGER$1)))?(copy(copy(new TXT$("integer")))):(CONC(CONC(CONC(CONC(new TXT$("range("),copy(copy(new Common$leftint(((Common)(CUR$.SL$)),inspect$490$2.p2$info1).RESULT$))),new TXT$(":")),new Common$leftint(((Common)(CUR$.SL$)),inspect$490$2.p2$info2).RESULT$),new TXT$(")"))))))):((((inspect$490$2.p2$set==(((Common)(CUR$.SL$)).structTypes$1)))?((((inspect$490$2.p2$info1==(0)))?(CONC(CONC(new TXT$("infix("),new Common$edSymbol(((Common)(CUR$.SL$)),inspect$490$2.p2$qual).RESULT$),new TXT$(")"))):(CONC(CONC(CONC(CONC(new TXT$("infix("),((Common)(CUR$.SL$)).symtab.Elt[inspect$490$2.p2$qual-((Common)(CUR$.SL$)).symtab.LB[0]].symbol),new TXT$(":")),new Common$leftint(((Common)(CUR$.SL$)),Math.subtractExact(inspect$490$2.p2$info1,1)).RESULT$),new TXT$(")"))))):((((inspect$490$2.p2$set==(((Common)(CUR$.SL$)).entTypes$1)))?(CONC(CONC(new TXT$("entry("),new Common$edSymbol(((Common)(CUR$.SL$)),inspect$490$2.p2$qual).RESULT$),new TXT$(")"))):((((inspect$490$2.p2$set==(((Common)(CUR$.SL$)).refTypes$1)))?(CONC(CONC(new TXT$("ref("),new Common$edSymbol(((Common)(CUR$.SL$)),inspect$490$2.p2$qual).RESULT$),new TXT$(")"))):((((inspect$490$2.p2$set==(((Common)(CUR$.SL$)).fieldTypes$1)))?(CONC(CONC(new TXT$("field("),new Common$edtype(((Common)(CUR$.SL$)),inspect$490$2.p2$qual).RESULT$),new TXT$(")"))):((((inspect$490$2.p2$set==(((Common)(CUR$.SL$)).nameTypes$1)))?(CONC(CONC(new TXT$("name("),new Common$edtype(((Common)(CUR$.SL$)),inspect$490$2.p2$qual).RESULT$),new TXT$(")"))):(copy(copy(new TXT$("**Undefined**")))))))))))))))));
            }
            else // OTHERWISE 
            // JavaLine 52 <== SourceLine 512
            RESULT$=copy(copy(new TXT$("**ILLEGAL**")));
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure edtype",1,489,14,490,47,491,52,512,57,512);
} // End of Procedure
