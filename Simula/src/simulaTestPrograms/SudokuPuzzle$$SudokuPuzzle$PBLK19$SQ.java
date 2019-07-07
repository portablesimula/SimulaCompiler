package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jul 07 11:47:39 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ extends Link$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=2, firstLine=19, lastLine=85, hasLocalClasses=false, System=false, detachUsed=true
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public int p2$row;
    public int p2$col;
    public int p2$val;
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 22
    public int xPos$2=0;
    public int yPos$2=0;
    public int next_val$2=0;
    // JavaLine 17 <== SourceLine 23
    public boolean Given$2=false;
    // JavaLine 19 <== SourceLine 24
    public TXT$ txVal$2=null;
    // Normal Constructor
    public SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ(RTObject$ staticLink,int sp2$row,int sp2$col,int sp2$val) {
        super(staticLink);
        // Parameter assignment to locals
        this.p2$row = sp2$row;
        this.p2$col = sp2$col;
        this.p2$val = sp2$val;
        // Declaration Code
        TRACE_BEGIN_DCL$("SQ",53);
    }
    // Class Statements
    public SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ STM$() {
        TRACE_BEGIN_STM$("SQ",53);
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // JavaLine 36 <== SourceLine 57
        // Class SQ: Code before inner
        Given$2=(p2$val>(0));
        // JavaLine 39 <== SourceLine 58
        xPos$2=Math.multiplyExact(Math.subtractExact(p2$col,1),60);
        // JavaLine 41 <== SourceLine 59
        yPos$2=Math.multiplyExact(Math.subtractExact(p2$row,1),60);
        // JavaLine 43 <== SourceLine 60
        txVal$2=blanks(1);
        // JavaLine 45 <== SourceLine 61
        ((SudokuPuzzle$PBLK19)(CUR$.SL$)).drawRectangle(((double)(xPos$2)),((double)(yPos$2)),((double)(60)),((double)(60)));
        // JavaLine 47 <== SourceLine 62
        new SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ$button_update(((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$)),((Given$2)?(((SudokuPuzzle$PBLK19)(CUR$.SL$)).red$1):(((SudokuPuzzle$PBLK19)(CUR$.SL$)).white$1)));
        // JavaLine 49 <== SourceLine 63
        if(VALUE$((!(Given$2)))) {
            ((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$)).into(((SudokuPuzzle$PBLK19)(CUR$.SL$)).SQchain$2);
        }
        // JavaLine 53 <== SourceLine 64
        detach();
        // JavaLine 55 <== SourceLine 66
        while(true) {
            // JavaLine 57 <== SourceLine 67
            {
                TRACE_BEGIN_STM$("CompoundStatement67",67);
                for(boolean CB$67:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){next_val$2=(int)x$; return(x$);};  public Number get(){return((Number)next_val$2); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                   )) { if(!CB$67) continue;
                // JavaLine 63 <== SourceLine 68
                if(VALUE$(new SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ$legit(((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$)),next_val$2).RESULT$)) {
                    // JavaLine 65 <== SourceLine 69
                    {
                        TRACE_BEGIN_STM$("CompoundStatement69",69);
                        p2$val=next_val$2;
                        // JavaLine 69 <== SourceLine 70
                        if(VALUE$((((SudokuPuzzle$)(CUR$.SL$.SL$)).flow==(1)))) {
                            new SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ$button_update(((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$)),((SudokuPuzzle$PBLK19)(CUR$.SL$)).green$1);
                        }
                        // JavaLine 73 <== SourceLine 71
                        ((SudokuPuzzle$PBLK19)(CUR$.SL$)).nSteps$2=Math.addExact(((SudokuPuzzle$PBLK19)(CUR$.SL$)).nSteps$2,1);
                        // JavaLine 75 <== SourceLine 72
                        resume(suc());
                        TRACE_END_STM$("CompoundStatement69",72);
                    }
                }
            }
            // JavaLine 81 <== SourceLine 74
            p2$val=0;
            // JavaLine 83 <== SourceLine 75
            if(VALUE$((((SudokuPuzzle$)(CUR$.SL$.SL$)).flow==(1)))) {
                new SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ$button_update(((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$)),((SudokuPuzzle$PBLK19)(CUR$.SL$)).blue$1);
            }
            // JavaLine 87 <== SourceLine 76
            ((SudokuPuzzle$PBLK19)(CUR$.SL$)).nSteps$2=Math.addExact(((SudokuPuzzle$PBLK19)(CUR$.SL$)).nSteps$2,1);
            // JavaLine 89 <== SourceLine 77
            if(VALUE$(((((SudokuPuzzle$)(CUR$.SL$.SL$)).flow==(1))&((((SudokuPuzzle$PBLK19)(CUR$.SL$)).nSteps$2>(((SudokuPuzzle$PBLK19)(CUR$.SL$)).maxSteps$2)))))) {
                // JavaLine 91 <== SourceLine 78
                {
                    TRACE_BEGIN_STM$("CompoundStatement78",78);
                    ((SudokuPuzzle$)(CUR$.SL$.SL$)).flow=0;
                    // JavaLine 95 <== SourceLine 79
                    sysout().outtext(new TXT$("Flow tracking stopped after"));
                    sysout().outint(((SudokuPuzzle$PBLK19)(CUR$.SL$)).maxSteps$2,6);
                    // JavaLine 98 <== SourceLine 80
                    sysout().outtext(new TXT$(" steps"));
                    sysout().outimage();
                    TRACE_END_STM$("CompoundStatement78",80);
                }
            }
            // JavaLine 104 <== SourceLine 82
            resume(prev());
            TRACE_END_STM$("CompoundStatement67",82);
        }
        if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
    }
    // JavaLine 110 <== SourceLine 57
    // Class SQ: Code after inner
    TRACE_END_STM$("SQ",57);
    EBLK();
    return(this);
} // End of Class Statements
public static PROGINFO$ INFO$=new PROGINFO$("SudokuPuzzle.sim","Class SQ",13,22,17,23,19,24,36,57,39,58,41,59,43,60,45,61,47,62,49,63,53,64,55,66,57,67,63,68,65,69,69,70,73,71,75,72,81,74,83,75,87,76,89,77,91,78,95,79,98,80,104,82,110,57,115,85);
} // End of Class
