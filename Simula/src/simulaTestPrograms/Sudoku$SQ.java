// JavaLine 1 <== SourceLine 20
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jul 07 11:08:48 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Sudoku$SQ extends Link$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=2, firstLine=20, lastLine=56, hasLocalClasses=false, System=false, detachUsed=true
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public int p2$row;
    public int p2$col;
    public int p2$val;
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 22
    public int next_val$2=0;
    // Normal Constructor
    public Sudoku$SQ(RTObject$ staticLink,int sp2$row,int sp2$col,int sp2$val) {
        super(staticLink);
        // Parameter assignment to locals
        this.p2$row = sp2$row;
        this.p2$col = sp2$col;
        this.p2$val = sp2$val;
        // Declaration Code
        TRACE_BEGIN_DCL$("SQ",40);
    }
    // Class Statements
    public Sudoku$SQ STM$() {
        TRACE_BEGIN_STM$("SQ",40);
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // JavaLine 31 <== SourceLine 42
        // Class SQ: Code before inner
        sysout().outint(p2$val,2);
        // JavaLine 34 <== SourceLine 43
        if(VALUE$((p2$val==(0)))) {
            // JavaLine 36 <== SourceLine 44
            into(((Sudoku)(CUR$.SL$)).SQchain$1);
        }
        // JavaLine 39 <== SourceLine 45
        detach();
        // JavaLine 41 <== SourceLine 47
        while(true) {
            // JavaLine 43 <== SourceLine 48
            {
                TRACE_BEGIN_STM$("CompoundStatement48",48);
                for(boolean CB$48:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){next_val$2=(int)x$; return(x$);};  public Number get(){return((Number)next_val$2); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                   )) { if(!CB$48) continue;
                // JavaLine 49 <== SourceLine 49
                if(VALUE$(new Sudoku$SQ$legit(((Sudoku$SQ)(CUR$)),next_val$2).RESULT$)) {
                    // JavaLine 51 <== SourceLine 50
                    {
                        TRACE_BEGIN_STM$("CompoundStatement50",50);
                        p2$val=next_val$2;
                        // JavaLine 55 <== SourceLine 51
                        resume(suc());
                        TRACE_END_STM$("CompoundStatement50",51);
                    }
                }
            }
            // JavaLine 61 <== SourceLine 53
            p2$val=0;
            // JavaLine 63 <== SourceLine 55
            resume(pred());
            TRACE_END_STM$("CompoundStatement48",55);
        }
        if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
    }
    // JavaLine 69 <== SourceLine 42
    // Class SQ: Code after inner
    TRACE_END_STM$("SQ",42);
    EBLK();
    return(this);
} // End of Class Statements
public static PROGINFO$ INFO$=new PROGINFO$("Sudoku.sim","Class SQ",1,20,14,22,31,42,34,43,36,44,39,45,41,47,43,48,49,49,51,50,55,51,61,53,63,55,69,42,74,56);
} // End of Class
