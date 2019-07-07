// JavaLine 1 <== SourceLine 4
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jul 07 11:08:48 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Sudoku$SQexit extends Link$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=2, firstLine=4, lastLine=18, hasLocalClasses=false, System=false, detachUsed=true
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public boolean p2$success;
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 5
    public int i$2=0;
    public int j$2=0;
    // Normal Constructor
    public Sudoku$SQexit(RTObject$ staticLink,boolean sp2$success) {
        super(staticLink);
        // Parameter assignment to locals
        this.p2$success = sp2$success;
        // Declaration Code
        TRACE_BEGIN_DCL$("SQexit",5);
    }
    // Class Statements
    public Sudoku$SQexit STM$() {
        TRACE_BEGIN_STM$("SQexit",5);
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // JavaLine 28 <== SourceLine 6
        // Class SQexit: Code before inner
        detach();
        // JavaLine 31 <== SourceLine 7
        if(VALUE$(p2$success)) {
            // JavaLine 33 <== SourceLine 8
            {
                TRACE_BEGIN_STM$("CompoundStatement8",8);
                sysout().outtext(new TXT$("PUZZLE SOLUTION:"));
                sysout().outimage();
                // JavaLine 38 <== SourceLine 9
                for(boolean CB$9:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i$2=(int)x$; return(x$);};  public Number get(){return((Number)i$2); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                   )) { if(!CB$9) continue;
                // JavaLine 42 <== SourceLine 10
                {
                    TRACE_BEGIN_STM$("CompoundStatement10",10);
                    for(boolean CB$10:new ForList(
                        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j$2=(int)x$; return(x$);};  public Number get(){return((Number)j$2); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                       )) { if(!CB$10) continue;
                    // JavaLine 48 <== SourceLine 11
                    sysout().outint(((Sudoku)(CUR$.SL$)).SQinst.Elt[i$2-((Sudoku)(CUR$.SL$)).SQinst.LB[0]][j$2-((Sudoku)(CUR$.SL$)).SQinst.LB[1]].p2$val,2);
                }
                // JavaLine 51 <== SourceLine 12
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement10",12);
            }
        }
        // JavaLine 56 <== SourceLine 14
        sysout().outimage();
        // JavaLine 58 <== SourceLine 15
        sysout().outtext(new TXT$("WE DID IT!"));
        TRACE_END_STM$("CompoundStatement8",15);
    }
} else
// JavaLine 63 <== SourceLine 17
sysout().outtext(new TXT$("The puzzle has no solution!"));
// JavaLine 65 <== SourceLine 6
// Class SQexit: Code after inner
TRACE_END_STM$("SQexit",6);
EBLK();
return(this);
} // End of Class Statements
public static PROGINFO$ INFO$=new PROGINFO$("Sudoku.sim","Class SQexit",1,4,12,5,28,6,31,7,33,8,38,9,42,10,48,11,51,12,56,14,58,15,63,17,65,6,70,18);
} // End of Class
