// JavaLine 1 ==> SourceLine 233
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Today extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=233, lastLine=240, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public Dates$Date RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 235
    TXT$ Tx=null;
    TXT$ Dx=null;
    TXT$ Mx=null;
    TXT$ Yx=null;
    // Normal Constructor
    public Dates$Today(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Today",235);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$Today STM$() {
        TRACE_BEGIN_STM$("Today",235);
        // JavaLine 31 ==> SourceLine 237
        Tx=datetime();
        // JavaLine 33 ==> SourceLine 238
        Dx=TXT$.sub(Tx,9,2);
        Mx=TXT$.sub(Tx,6,2);
        Yx=TXT$.sub(Tx,1,4);
        // JavaLine 37 ==> SourceLine 239
        RESULT$=new Dates$Date(((Dates)(CUR$.SL$)),TXT$.getint(Dx),TXT$.getint(Mx),TXT$.getint(Yx)).STM$();
        TRACE_END_STM$("Today",239);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure Today",1,233,14,235,31,237,33,238,37,239,42,240);
}
