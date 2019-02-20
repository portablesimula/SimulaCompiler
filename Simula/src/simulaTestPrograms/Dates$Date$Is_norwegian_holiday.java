// JavaLine 1 ==> SourceLine 169
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Is_norwegian_holiday extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=169, lastLine=187, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 171
    Dates$Date Ex=null;
    // Normal Constructor
    public Dates$Date$Is_norwegian_holiday(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Is_norwegian_holiday",171);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$Date$Is_norwegian_holiday STM$() {
        TRACE_BEGIN_STM$("Is_norwegian_holiday",171);
        // JavaLine 28 ==> SourceLine 173
        Ex=new Dates$Easter(((Dates)(CUR$.SL$.SL$)),((Dates$Date)(CUR$.SL$)).p$Y).RESULT$;
        // JavaLine 30 ==> SourceLine 174
        RESULT$=(((((((((((new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),new Dates$Date(((Dates)(CUR$.SL$.SL$)),1,1,((Dates$Date)(CUR$.SL$)).p$Y).STM$()).RESULT$|(new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),new Dates$Date(((Dates)(CUR$.SL$.SL$)),1,5,((Dates$Date)(CUR$.SL$)).p$Y).STM$()).RESULT$))|(new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),new Dates$Date(((Dates)(CUR$.SL$.SL$)),17,5,((Dates$Date)(CUR$.SL$)).p$Y).STM$()).RESULT$))|(new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),new Dates$Date(((Dates)(CUR$.SL$.SL$)),25,12,((Dates$Date)(CUR$.SL$)).p$Y).STM$()).RESULT$))|(new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),new Dates$Date(((Dates)(CUR$.SL$.SL$)),26,12,((Dates$Date)(CUR$.SL$)).p$Y).STM$()).RESULT$))|(new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),new Dates$Date$Minus(Ex,3).RESULT$).RESULT$))|(new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),new Dates$Date$Minus(Ex,2).RESULT$).RESULT$))|(new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),Ex).RESULT$))|(new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),new Dates$Date$Plus(Ex,1).RESULT$).RESULT$))|(new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),new Dates$Date$Plus(Ex,39).RESULT$).RESULT$))|(new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),new Dates$Date$Plus(Ex,49).RESULT$).RESULT$))|(new Dates$Date$Is_same(((Dates$Date)(CUR$.SL$)),new Dates$Date$Plus(Ex,50).RESULT$).RESULT$));
        TRACE_END_STM$("Is_norwegian_holiday",174);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure Is_norwegian_holiday",1,169,14,171,28,173,30,174,35,187);
}
