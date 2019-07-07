// JavaLine 1 <== SourceLine 39
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jul 07 11:14:25 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SudokuPuzzle$SQ$button_update extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=39, lastLine=47, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$color;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public SudokuPuzzle$SQ$button_update setPar(Object param) {
        //Util.BREAK("CALL SudokuPuzzle$SQ$button_update.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$color=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public SudokuPuzzle$SQ$button_update(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public SudokuPuzzle$SQ$button_update(RTObject$ SL$,int sp$color) {
        super(SL$);
        // Parameter assignment to locals
        this.p$color = sp$color;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("button_update",39);
        STM$();
    }
    // Procedure Statements
    public SudokuPuzzle$SQ$button_update STM$() {
        TRACE_BEGIN_STM$("button_update",39);
        // JavaLine 40 <== SourceLine 43
        ((SudokuPuzzle)(CUR$.SL$.SL$)).setFillColor(p$color);
        // JavaLine 42 <== SourceLine 44
        ((SudokuPuzzle)(CUR$.SL$.SL$)).fillRectangle(((double)(Math.addExact(((SudokuPuzzle$SQ)(CUR$.SL$)).xPos$2,1))),((double)(Math.addExact(((SudokuPuzzle$SQ)(CUR$.SL$)).yPos$2,1))),((double)(58)),((double)(58)));
        // JavaLine 44 <== SourceLine 45
        TXT$.putint(((SudokuPuzzle$SQ)(CUR$.SL$)).txVal$2,((SudokuPuzzle$SQ)(CUR$.SL$)).p2$val);
        // JavaLine 46 <== SourceLine 46
        ((SudokuPuzzle)(CUR$.SL$.SL$)).drawText(((SudokuPuzzle$SQ)(CUR$.SL$)).txVal$2,((double)(Math.addExact(((SudokuPuzzle$SQ)(CUR$.SL$)).xPos$2,22))),((double)(Math.addExact(((SudokuPuzzle$SQ)(CUR$.SL$)).yPos$2,36))));
        TRACE_END_STM$("button_update",46);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SudokuPuzzle.sim","Procedure button_update",1,39,40,43,42,44,44,45,46,46,51,47);
} // End of Procedure
