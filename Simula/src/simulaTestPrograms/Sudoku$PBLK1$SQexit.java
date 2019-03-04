// JavaLine 1 ==> SourceLine 4
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Mar 04 18:34:49 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Sudoku$PBLK1$SQexit extends Link$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=2, firstLine=4, lastLine=18, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(2); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public boolean p2$success;
    // Declare locals as attributes
    // JavaLine 13 ==> SourceLine 5
    public int i=0;
    public int j=0;
    // Normal Constructor
    public Sudoku$PBLK1$SQexit(RTObject$ staticLink,boolean sp2$success) {
        super(staticLink);
        // Parameter assignment to locals
        this.p2$success = sp2$success;
        // Declaration Code
        TRACE_BEGIN_DCL$("SQexit",5);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("SQexit",5,inner);
                // JavaLine 27 ==> SourceLine 6
                detach();
                // JavaLine 29 ==> SourceLine 7
                if(VALUE$(p2$success)) {
                    // JavaLine 31 ==> SourceLine 8
                    {
                        TRACE_BEGIN_STM$("CompoundStatement8",8);
                        sysout().outtext(new TXT$("PUZZLE SOLUTION:"));
                        sysout().outimage();
                        // JavaLine 36 ==> SourceLine 9
                        for(boolean CB$9:new ForList(
                            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                           )) { if(!CB$9) continue;
                        // JavaLine 40 ==> SourceLine 10
                        {
                            TRACE_BEGIN_STM$("CompoundStatement10",10);
                            for(boolean CB$10:new ForList(
                                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                               )) { if(!CB$10) continue;
                            // JavaLine 46 ==> SourceLine 11
                            sysout().outint(((Sudoku$PBLK1)(CUR$.SL$)).SQinst.Elt[i-((Sudoku$PBLK1)(CUR$.SL$)).SQinst.LB[0]][j-((Sudoku$PBLK1)(CUR$.SL$)).SQinst.LB[1]].p2$val,2);
                        }
                        // JavaLine 49 ==> SourceLine 12
                        sysout().outimage();
                        TRACE_END_STM$("CompoundStatement10",12);
                    }
                }
                // JavaLine 54 ==> SourceLine 14
                sysout().outimage();
                // JavaLine 56 ==> SourceLine 15
                sysout().outtext(new TXT$("WE DID IT!"));
                TRACE_END_STM$("CompoundStatement8",15);
            }
        } else
        // JavaLine 61 ==> SourceLine 17
        sysout().outtext(new TXT$("The puzzle has no solution!"));
        // JavaLine 63 ==> SourceLine 6
        if(inner!=null) {
            inner.STM$();
            TRACE_BEGIN_STM_AFTER_INNER$("SQexit",6);
        }
        TRACE_END_STM$("SQexit",6);
    }
};
} // End of Constructor
// Class Statements
public Sudoku$PBLK1$SQexit STM$() { return((Sudoku$PBLK1$SQexit)CODE$.EXEC$()); }
public Sudoku$PBLK1$SQexit START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("Sudoku.sim","Class SQexit",1,4,13,5,27,6,29,7,31,8,36,9,40,10,46,11,49,12,54,14,56,15,61,17,63,6,74,18);
}
