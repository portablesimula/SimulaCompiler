// JavaLine 1 ==> SourceLine 20
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Mar 04 18:34:49 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Sudoku$PBLK1$SQ extends Link$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=2, firstLine=20, lastLine=56, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(2); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public int p2$row;
    public int p2$col;
    public int p2$val;
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 22
    public int next_val=0;
    // Normal Constructor
    public Sudoku$PBLK1$SQ(RTObject$ staticLink,int sp2$row,int sp2$col,int sp2$val) {
        super(staticLink);
        // Parameter assignment to locals
        this.p2$row = sp2$row;
        this.p2$col = sp2$col;
        this.p2$val = sp2$val;
        // Declaration Code
        TRACE_BEGIN_DCL$("SQ",40);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("SQ",40,inner);
                // JavaLine 30 ==> SourceLine 42
                sysout().outint(p2$val,2);
                // JavaLine 32 ==> SourceLine 43
                if(VALUE$((p2$val==(0)))) {
                    // JavaLine 34 ==> SourceLine 44
                    into(((Sudoku$PBLK1)(CUR$.SL$)).SQchain);
                }
                // JavaLine 37 ==> SourceLine 45
                detach();
                // JavaLine 39 ==> SourceLine 47
                while(true) {
                    // JavaLine 41 ==> SourceLine 48
                    {
                        TRACE_BEGIN_STM$("CompoundStatement48",48);
                        for(boolean CB$48:new ForList(
                            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){next_val=(int)x$; return(x$);};  public Number get(){return((Number)next_val); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                           )) { if(!CB$48) continue;
                        // JavaLine 47 ==> SourceLine 49
                        if(VALUE$(new Sudoku$PBLK1$SQ$legit(((Sudoku$PBLK1$SQ)CUR$),next_val).RESULT$)) {
                            // JavaLine 49 ==> SourceLine 50
                            {
                                TRACE_BEGIN_STM$("CompoundStatement50",50);
                                p2$val=next_val;
                                // JavaLine 53 ==> SourceLine 51
                                resume(suc());
                                TRACE_END_STM$("CompoundStatement50",51);
                            }
                        }
                    }
                    // JavaLine 59 ==> SourceLine 53
                    p2$val=0;
                    // JavaLine 61 ==> SourceLine 55
                    resume(pred());
                    TRACE_END_STM$("CompoundStatement48",55);
                }
                   if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
            }
            // JavaLine 67 ==> SourceLine 42
            if(inner!=null) {
                inner.STM$();
                TRACE_BEGIN_STM_AFTER_INNER$("SQ",42);
            }
            TRACE_END_STM$("SQ",42);
        }
    };
} // End of Constructor
// Class Statements
public Sudoku$PBLK1$SQ STM$() { return((Sudoku$PBLK1$SQ)CODE$.EXEC$()); }
public Sudoku$PBLK1$SQ START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("Sudoku.sim","Class SQ",1,20,15,22,30,42,32,43,34,44,37,45,39,47,41,48,47,49,49,50,53,51,59,53,61,55,67,42,78,56);
}
