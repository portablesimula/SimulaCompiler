package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jul 07 11:14:25 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SudokuPuzzle$SQ extends Link$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=2, firstLine=12, lastLine=78, hasLocalClasses=false, System=false, detachUsed=true
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public int p2$row;
    public int p2$col;
    public int p2$val;
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 15
    public int xPos$2=0;
    public int yPos$2=0;
    public int next_val$2=0;
    // JavaLine 17 <== SourceLine 16
    public boolean Given$2=false;
    // JavaLine 19 <== SourceLine 17
    public TXT$ txVal$2=null;
    // Normal Constructor
    public SudokuPuzzle$SQ(RTObject$ staticLink,int sp2$row,int sp2$col,int sp2$val) {
        super(staticLink);
        // Parameter assignment to locals
        this.p2$row = sp2$row;
        this.p2$col = sp2$col;
        this.p2$val = sp2$val;
        // Declaration Code
        TRACE_BEGIN_DCL$("SQ",46);
    }
    // Class Statements
    public SudokuPuzzle$SQ STM$() {
        TRACE_BEGIN_STM$("SQ",46);
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // JavaLine 36 <== SourceLine 50
        // Class SQ: Code before inner
        Given$2=(p2$val>(0));
        // JavaLine 39 <== SourceLine 51
        xPos$2=Math.multiplyExact(Math.subtractExact(p2$col,1),60);
        // JavaLine 41 <== SourceLine 52
        yPos$2=Math.multiplyExact(Math.subtractExact(p2$row,1),60);
        // JavaLine 43 <== SourceLine 53
        txVal$2=blanks(1);
        // JavaLine 45 <== SourceLine 54
        ((SudokuPuzzle)(CUR$.SL$)).drawRectangle(((double)(xPos$2)),((double)(yPos$2)),((double)(60)),((double)(60)));
        // JavaLine 47 <== SourceLine 55
        new SudokuPuzzle$SQ$button_update(((SudokuPuzzle$SQ)(CUR$)),((Given$2)?(((SudokuPuzzle)(CUR$.SL$)).red$1):(((SudokuPuzzle)(CUR$.SL$)).white$1)));
        // JavaLine 49 <== SourceLine 56
        if(VALUE$((!(Given$2)))) {
            ((SudokuPuzzle$SQ)(CUR$)).into(((SudokuPuzzle)(CUR$.SL$)).SQchain$2);
        }
        // JavaLine 53 <== SourceLine 57
        detach();
        // JavaLine 55 <== SourceLine 59
        while(true) {
            // JavaLine 57 <== SourceLine 60
            {
                TRACE_BEGIN_STM$("CompoundStatement60",60);
                for(boolean CB$60:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){next_val$2=(int)x$; return(x$);};  public Number get(){return((Number)next_val$2); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                   )) { if(!CB$60) continue;
                // JavaLine 63 <== SourceLine 61
                if(VALUE$(new SudokuPuzzle$SQ$legit(((SudokuPuzzle$SQ)(CUR$)),next_val$2).RESULT$)) {
                    // JavaLine 65 <== SourceLine 62
                    {
                        TRACE_BEGIN_STM$("CompoundStatement62",62);
                        p2$val=next_val$2;
                        // JavaLine 69 <== SourceLine 63
                        if(VALUE$((((SudokuPuzzle)(CUR$.SL$)).flow$2==(1)))) {
                            new SudokuPuzzle$SQ$button_update(((SudokuPuzzle$SQ)(CUR$)),((SudokuPuzzle)(CUR$.SL$)).green$1);
                        }
                        // JavaLine 73 <== SourceLine 64
                        ((SudokuPuzzle)(CUR$.SL$)).nSteps$2=Math.addExact(((SudokuPuzzle)(CUR$.SL$)).nSteps$2,1);
                        // JavaLine 75 <== SourceLine 65
                        resume(suc());
                        TRACE_END_STM$("CompoundStatement62",65);
                    }
                }
            }
            // JavaLine 81 <== SourceLine 67
            p2$val=0;
            // JavaLine 83 <== SourceLine 68
            if(VALUE$((((SudokuPuzzle)(CUR$.SL$)).flow$2==(1)))) {
                new SudokuPuzzle$SQ$button_update(((SudokuPuzzle$SQ)(CUR$)),((SudokuPuzzle)(CUR$.SL$)).blue$1);
            }
            // JavaLine 87 <== SourceLine 69
            ((SudokuPuzzle)(CUR$.SL$)).nSteps$2=Math.addExact(((SudokuPuzzle)(CUR$.SL$)).nSteps$2,1);
            // JavaLine 89 <== SourceLine 70
            if(VALUE$(((((SudokuPuzzle)(CUR$.SL$)).flow$2==(1))&((((SudokuPuzzle)(CUR$.SL$)).nSteps$2>(((SudokuPuzzle)(CUR$.SL$)).maxSteps$2)))))) {
                // JavaLine 91 <== SourceLine 71
                {
                    TRACE_BEGIN_STM$("CompoundStatement71",71);
                    ((SudokuPuzzle)(CUR$.SL$)).flow$2=0;
                    // JavaLine 95 <== SourceLine 72
                    sysout().outtext(new TXT$("Flow tracking stopped after"));
                    sysout().outint(((SudokuPuzzle)(CUR$.SL$)).maxSteps$2,6);
                    // JavaLine 98 <== SourceLine 73
                    sysout().outtext(new TXT$(" steps"));
                    sysout().outimage();
                    TRACE_END_STM$("CompoundStatement71",73);
                }
            }
            // JavaLine 104 <== SourceLine 75
            resume(prev());
            TRACE_END_STM$("CompoundStatement60",75);
        }
        if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
    }
    // JavaLine 110 <== SourceLine 50
    // Class SQ: Code after inner
    TRACE_END_STM$("SQ",50);
    EBLK();
    return(this);
} // End of Class Statements
public static PROGINFO$ INFO$=new PROGINFO$("SudokuPuzzle.sim","Class SQ",13,15,17,16,19,17,36,50,39,51,41,52,43,53,45,54,47,55,49,56,53,57,55,59,57,60,63,61,65,62,69,63,73,64,75,65,81,67,83,68,87,69,89,70,91,71,95,72,98,73,104,75,110,50,115,78);
} // End of Class
