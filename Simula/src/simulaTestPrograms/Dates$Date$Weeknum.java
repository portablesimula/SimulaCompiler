// JavaLine 1 ==> SourceLine 97
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Weeknum extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=97, lastLine=106, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 99
    Dates$Date Jan1=null;
    Dates$Date Dx=null;
    // Normal Constructor
    public Dates$Date$Weeknum(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Weeknum",99);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$Date$Weeknum STM$() {
        TRACE_BEGIN_STM$("Weeknum",99);
        // JavaLine 29 ==> SourceLine 101
        Dx=((Dates$Date)(CUR$.SL$));
        // JavaLine 31 ==> SourceLine 102
        while((new Dates$Date$Weekday(Dx).RESULT$!=(((Dates)(CUR$.SL$.SL$)).Sunday))) {
            Dx=new Dates$Date$Suc(Dx).RESULT$;
        }
        // JavaLine 35 ==> SourceLine 104
        Jan1=new Dates$Date(((Dates)(CUR$.SL$.SL$)),1,1,((Dates$Date)(CUR$.SL$)).p$Y).STM$();
        // JavaLine 37 ==> SourceLine 105
        RESULT$=((new Dates$Date$Diff(Jan1,Dx).RESULT$+(4))/(7));
        TRACE_END_STM$("Weeknum",105);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure Weeknum",1,97,14,99,29,101,31,102,35,104,37,105,42,106);
}
