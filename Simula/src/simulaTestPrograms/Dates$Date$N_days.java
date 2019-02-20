// JavaLine 1 ==> SourceLine 16
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$N_days extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=16, lastLine=24, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 18
    int Sum=0;
    int Ix=0;
    // Normal Constructor
    public Dates$Date$N_days(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("N_days",18);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$Date$N_days STM$() {
        TRACE_BEGIN_STM$("N_days",18);
        // JavaLine 29 ==> SourceLine 20
        Sum=(((((((Dates$Date)(CUR$.SL$)).p$Y-(1))*(365))+(((((Dates$Date)(CUR$.SL$)).p$Y-(1))/(4))))-(((((Dates$Date)(CUR$.SL$)).p$Y-(1))/(100))))+(((((Dates$Date)(CUR$.SL$)).p$Y-(1))/(400))));
        // JavaLine 31 ==> SourceLine 21
        for(boolean CB$21:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){Ix=(int)x$; return(x$);};  public Number get(){return((Number)Ix); }	},new NAME$<Number>() { public Number get(){return((((Dates$Date)(CUR$.SL$)).p$M-(1))); }},new NAME$<Number>() { public Number get(){return(-1); }},new NAME$<Number>() { public Number get(){return(1); }})
           )) { if(!CB$21) continue;
        // JavaLine 35 ==> SourceLine 22
        Sum=(Sum+(new Dates$M_leng(((Dates)(CUR$.SL$.SL$)),Ix,((Dates$Date)(CUR$.SL$)).p$Y).RESULT$));
    }
    // JavaLine 38 ==> SourceLine 23
    RESULT$=(Sum+(((Dates$Date)(CUR$.SL$)).p$D));
    TRACE_END_STM$("N_days",23);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure N_days",1,16,14,18,29,20,31,21,35,22,38,23,43,24);
}
