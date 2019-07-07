// JavaLine 1 <== SourceLine 19
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jul 07 11:14:25 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SudokuPuzzle$SQ$legit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=19, lastLine=36, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$val;
    // Declare local labels
    // JavaLine 14 <== SourceLine 36
    final LABQNT$ exit=new LABQNT$(this,1,"exit"); // Local Label #1=exit
    // Declare locals as attributes
    // JavaLine 17 <== SourceLine 22
    int i=0;
    int j=0;
    int reg_row=0;
    int reg_col=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public SudokuPuzzle$SQ$legit setPar(Object param) {
        //Util.BREAK("CALL SudokuPuzzle$SQ$legit.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$val=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public SudokuPuzzle$SQ$legit(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public SudokuPuzzle$SQ$legit(RTObject$ SL$,int sp$val) {
        super(SL$);
        // Parameter assignment to locals
        this.p$val = sp$val;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("legit",22);
        STM$();
    }
    // Procedure Statements
    public SudokuPuzzle$SQ$legit STM$() {
        TRACE_BEGIN_STM$("legit",22);
        SudokuPuzzle$SQ$legit THIS$=(SudokuPuzzle$SQ$legit)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 55 <== SourceLine 23
                RESULT$=false;
                // JavaLine 57 <== SourceLine 24
                for(boolean CB$24:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(Math.subtractExact(((SudokuPuzzle$SQ)(CUR$.SL$)).p2$col,1)); }})
                   ,new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(Math.addExact(((SudokuPuzzle$SQ)(CUR$.SL$)).p2$col,1)); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                   )) { if(!CB$24) continue;
                // JavaLine 62 <== SourceLine 25
                if(VALUE$((((SudokuPuzzle)(CUR$.SL$.SL$)).SQinst.Elt[((SudokuPuzzle$SQ)(CUR$.SL$)).p2$row-((SudokuPuzzle)(CUR$.SL$.SL$)).SQinst.LB[0]][j-((SudokuPuzzle)(CUR$.SL$.SL$)).SQinst.LB[1]].p2$val==(p$val)))) {
                    GOTO$(exit); // GOTO EVALUATED LABEL
                }
            }
            // JavaLine 67 <== SourceLine 26
            for(boolean CB$26:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(Math.subtractExact(((SudokuPuzzle$SQ)(CUR$.SL$)).p2$row,1)); }})
               ,new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(Math.addExact(((SudokuPuzzle$SQ)(CUR$.SL$)).p2$row,1)); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
               )) { if(!CB$26) continue;
            // JavaLine 72 <== SourceLine 27
            if(VALUE$((((SudokuPuzzle)(CUR$.SL$.SL$)).SQinst.Elt[i-((SudokuPuzzle)(CUR$.SL$.SL$)).SQinst.LB[0]][((SudokuPuzzle$SQ)(CUR$.SL$)).p2$col-((SudokuPuzzle)(CUR$.SL$.SL$)).SQinst.LB[1]].p2$val==(p$val)))) {
                GOTO$(exit); // GOTO EVALUATED LABEL
            }
        }
        // JavaLine 77 <== SourceLine 29
        reg_row=Math.subtractExact(((SudokuPuzzle$SQ)(CUR$.SL$)).p2$row,mod(Math.subtractExact(((SudokuPuzzle$SQ)(CUR$.SL$)).p2$row,1),3));
        // JavaLine 79 <== SourceLine 30
        reg_col=Math.subtractExact(((SudokuPuzzle$SQ)(CUR$.SL$)).p2$col,mod(Math.subtractExact(((SudokuPuzzle$SQ)(CUR$.SL$)).p2$col,1),3));
        // JavaLine 81 <== SourceLine 31
        for(boolean CB$31:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(reg_row); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(Math.addExact(reg_row,2)); }})
           )) { if(!CB$31) continue;
        // JavaLine 85 <== SourceLine 32
        for(boolean CB$32:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(reg_col); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(Math.addExact(reg_col,2)); }})
           )) { if(!CB$32) continue;
        // JavaLine 89 <== SourceLine 33
        if(VALUE$((((i!=(((SudokuPuzzle$SQ)(CUR$.SL$)).p2$row))&((j!=(((SudokuPuzzle$SQ)(CUR$.SL$)).p2$col))))&((((SudokuPuzzle)(CUR$.SL$.SL$)).SQinst.Elt[i-((SudokuPuzzle)(CUR$.SL$.SL$)).SQinst.LB[0]][j-((SudokuPuzzle)(CUR$.SL$.SL$)).SQinst.LB[1]].p2$val==(p$val)))))) {
            GOTO$(exit); // GOTO EVALUATED LABEL
        }
    }
}
// JavaLine 95 <== SourceLine 34
RESULT$=true;
// JavaLine 97 <== SourceLine 36
LABEL$(1,"exit");
break LOOP$;
}
catch(LABQNT$ q) {
CUR$=THIS$;
if(q.SL$!=CUR$) {
    if(RT.Option.GOTO_TRACING) TRACE_GOTO("legit:NON-LOCAL",q);
    CUR$.STATE$=OperationalState.terminated;
    if(RT.Option.GOTO_TRACING) TRACE_GOTO("legit:RE-THROW",q);
    throw(q);
}
if(RT.Option.GOTO_TRACING) TRACE_GOTO("legit:LOCAL",q);
JTX$=q.index; continue LOOP$; // EG. GOTO Lx
}
}
TRACE_END_STM$("legit",36);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("SudokuPuzzle.sim","Procedure legit",1,19,14,36,17,22,55,23,57,24,62,25,67,26,72,27,77,29,79,30,81,31,85,32,89,33,95,34,97,36,116,36);
} // End of Procedure
