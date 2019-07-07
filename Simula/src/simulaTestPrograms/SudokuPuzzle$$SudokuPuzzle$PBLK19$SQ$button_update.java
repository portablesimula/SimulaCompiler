// JavaLine 1 <== SourceLine 46
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jul 07 11:47:39 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ$button_update extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=46, lastLine=54, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$color;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ$button_update setPar(Object param) {
        //Util.BREAK("CALL SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ$button_update.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ$button_update(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ$button_update(RTObject$ SL$,int sp$color) {
        super(SL$);
        // Parameter assignment to locals
        this.p$color = sp$color;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("button_update",46);
        STM$();
    }
    // Procedure Statements
    public SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ$button_update STM$() {
        TRACE_BEGIN_STM$("button_update",46);
        // JavaLine 40 <== SourceLine 50
        ((SudokuPuzzle$PBLK19)(CUR$.SL$.SL$)).setFillColor(p$color);
        // JavaLine 42 <== SourceLine 51
        ((SudokuPuzzle$PBLK19)(CUR$.SL$.SL$)).fillRectangle(((double)(Math.addExact(((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$.SL$)).xPos$2,1))),((double)(Math.addExact(((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$.SL$)).yPos$2,1))),((double)(58)),((double)(58)));
        // JavaLine 44 <== SourceLine 52
        TXT$.putint(((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$.SL$)).txVal$2,((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$.SL$)).p2$val);
        // JavaLine 46 <== SourceLine 53
        ((SudokuPuzzle$PBLK19)(CUR$.SL$.SL$)).drawText(((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$.SL$)).txVal$2,((double)(Math.addExact(((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$.SL$)).xPos$2,22))),((double)(Math.addExact(((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$.SL$)).yPos$2,36))));
        TRACE_END_STM$("button_update",53);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SudokuPuzzle.sim","Procedure button_update",1,46,40,50,42,51,44,52,46,53,51,54);
} // End of Procedure
