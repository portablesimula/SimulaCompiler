// JavaLine 1 <== SourceLine 26
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jul 07 11:47:39 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ$legit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=26, lastLine=43, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$val;
    // Declare local labels
    // JavaLine 14 <== SourceLine 43
    final LABQNT$ exit=new LABQNT$(this,1,"exit"); // Local Label #1=exit
    // Declare locals as attributes
    // JavaLine 17 <== SourceLine 29
    int i=0;
    int j=0;
    int reg_row=0;
    int reg_col=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ$legit setPar(Object param) {
        //Util.BREAK("CALL SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ$legit.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ$legit(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ$legit(RTObject$ SL$,int sp$val) {
        super(SL$);
        // Parameter assignment to locals
        this.p$val = sp$val;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("legit",29);
        STM$();
    }
    // Procedure Statements
    public SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ$legit STM$() {
        TRACE_BEGIN_STM$("legit",29);
        SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ$legit THIS$=(SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ$legit)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 55 <== SourceLine 30
                RESULT$=false;
                // JavaLine 57 <== SourceLine 31
                for(boolean CB$31:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(Math.subtractExact(((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$.SL$)).p2$col,1)); }})
                   ,new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(Math.addExact(((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$.SL$)).p2$col,1)); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                   )) { if(!CB$31) continue;
                // JavaLine 62 <== SourceLine 32
                if(VALUE$((((SudokuPuzzle$PBLK19)(CUR$.SL$.SL$)).SQinst.Elt[((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$.SL$)).p2$row-((SudokuPuzzle$PBLK19)(CUR$.SL$.SL$)).SQinst.LB[0]][j-((SudokuPuzzle$PBLK19)(CUR$.SL$.SL$)).SQinst.LB[1]].p2$val==(p$val)))) {
                    GOTO$(exit); // GOTO EVALUATED LABEL
                }
            }
            // JavaLine 67 <== SourceLine 33
            for(boolean CB$33:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(Math.subtractExact(((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$.SL$)).p2$row,1)); }})
               ,new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(Math.addExact(((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$.SL$)).p2$row,1)); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
               )) { if(!CB$33) continue;
            // JavaLine 72 <== SourceLine 34
            if(VALUE$((((SudokuPuzzle$PBLK19)(CUR$.SL$.SL$)).SQinst.Elt[i-((SudokuPuzzle$PBLK19)(CUR$.SL$.SL$)).SQinst.LB[0]][((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$.SL$)).p2$col-((SudokuPuzzle$PBLK19)(CUR$.SL$.SL$)).SQinst.LB[1]].p2$val==(p$val)))) {
                GOTO$(exit); // GOTO EVALUATED LABEL
            }
        }
        // JavaLine 77 <== SourceLine 36
        reg_row=Math.subtractExact(((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$.SL$)).p2$row,mod(Math.subtractExact(((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$.SL$)).p2$row,1),3));
        // JavaLine 79 <== SourceLine 37
        reg_col=Math.subtractExact(((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$.SL$)).p2$col,mod(Math.subtractExact(((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$.SL$)).p2$col,1),3));
        // JavaLine 81 <== SourceLine 38
        for(boolean CB$38:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(reg_row); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(Math.addExact(reg_row,2)); }})
           )) { if(!CB$38) continue;
        // JavaLine 85 <== SourceLine 39
        for(boolean CB$39:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(reg_col); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(Math.addExact(reg_col,2)); }})
           )) { if(!CB$39) continue;
        // JavaLine 89 <== SourceLine 40
        if(VALUE$((((i!=(((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$.SL$)).p2$row))&((j!=(((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)(CUR$.SL$)).p2$col))))&((((SudokuPuzzle$PBLK19)(CUR$.SL$.SL$)).SQinst.Elt[i-((SudokuPuzzle$PBLK19)(CUR$.SL$.SL$)).SQinst.LB[0]][j-((SudokuPuzzle$PBLK19)(CUR$.SL$.SL$)).SQinst.LB[1]].p2$val==(p$val)))))) {
            GOTO$(exit); // GOTO EVALUATED LABEL
        }
    }
}
// JavaLine 95 <== SourceLine 41
RESULT$=true;
// JavaLine 97 <== SourceLine 43
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
TRACE_END_STM$("legit",43);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("SudokuPuzzle.sim","Procedure legit",1,26,14,43,17,29,55,30,57,31,62,32,67,33,72,34,77,36,79,37,81,38,85,39,89,40,95,41,97,43,116,43);
} // End of Procedure
