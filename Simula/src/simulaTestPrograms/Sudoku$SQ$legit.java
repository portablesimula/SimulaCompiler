// JavaLine 1 <== SourceLine 24
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jul 07 11:08:48 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Sudoku$SQ$legit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=24, lastLine=40, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$val;
    // Declare local labels
    // JavaLine 14 <== SourceLine 40
    final LABQNT$ exit=new LABQNT$(this,1,"exit"); // Local Label #1=exit
    // Declare locals as attributes
    // JavaLine 17 <== SourceLine 26
    int i=0;
    int j=0;
    int reg_row=0;
    int reg_col=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public Sudoku$SQ$legit setPar(Object param) {
        //Util.BREAK("CALL Sudoku$SQ$legit.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public Sudoku$SQ$legit(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public Sudoku$SQ$legit(RTObject$ SL$,int sp$val) {
        super(SL$);
        // Parameter assignment to locals
        this.p$val = sp$val;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("legit",26);
        STM$();
    }
    // Procedure Statements
    public Sudoku$SQ$legit STM$() {
        TRACE_BEGIN_STM$("legit",26);
        Sudoku$SQ$legit THIS$=(Sudoku$SQ$legit)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 55 <== SourceLine 28
                for(boolean CB$28:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                   )) { if(!CB$28) continue;
                // JavaLine 59 <== SourceLine 29
                if(VALUE$((((Sudoku)(CUR$.SL$.SL$)).SQinst.Elt[((Sudoku$SQ)(CUR$.SL$)).p2$row-((Sudoku)(CUR$.SL$.SL$)).SQinst.LB[0]][i-((Sudoku)(CUR$.SL$.SL$)).SQinst.LB[1]].p2$val==(p$val)))) {
                    GOTO$(exit); // GOTO EVALUATED LABEL
                }
            }
            // JavaLine 64 <== SourceLine 30
            for(boolean CB$30:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
               )) { if(!CB$30) continue;
            // JavaLine 68 <== SourceLine 31
            if(VALUE$((((Sudoku)(CUR$.SL$.SL$)).SQinst.Elt[i-((Sudoku)(CUR$.SL$.SL$)).SQinst.LB[0]][((Sudoku$SQ)(CUR$.SL$)).p2$col-((Sudoku)(CUR$.SL$.SL$)).SQinst.LB[1]].p2$val==(p$val)))) {
                GOTO$(exit); // GOTO EVALUATED LABEL
            }
        }
        // JavaLine 73 <== SourceLine 33
        reg_row=Math.subtractExact(((Sudoku$SQ)(CUR$.SL$)).p2$row,mod(Math.subtractExact(((Sudoku$SQ)(CUR$.SL$)).p2$row,1),3));
        // JavaLine 75 <== SourceLine 34
        reg_col=Math.subtractExact(((Sudoku$SQ)(CUR$.SL$)).p2$col,mod(Math.subtractExact(((Sudoku$SQ)(CUR$.SL$)).p2$col,1),3));
        // JavaLine 77 <== SourceLine 35
        for(boolean CB$35:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(reg_row); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(Math.addExact(reg_row,2)); }})
           )) { if(!CB$35) continue;
        // JavaLine 81 <== SourceLine 36
        for(boolean CB$36:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(reg_col); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(Math.addExact(reg_col,2)); }})
           )) { if(!CB$36) continue;
        // JavaLine 85 <== SourceLine 37
        if(VALUE$((((Sudoku)(CUR$.SL$.SL$)).SQinst.Elt[i-((Sudoku)(CUR$.SL$.SL$)).SQinst.LB[0]][j-((Sudoku)(CUR$.SL$.SL$)).SQinst.LB[1]].p2$val==(p$val)))) {
            GOTO$(exit); // GOTO EVALUATED LABEL
        }
    }
}
// JavaLine 91 <== SourceLine 38
RESULT$=true;
// JavaLine 93 <== SourceLine 40
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
TRACE_END_STM$("legit",40);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("Sudoku.sim","Procedure legit",1,24,14,40,17,26,55,28,59,29,64,30,68,31,73,33,75,34,77,35,81,36,85,37,91,38,93,40,112,40);
} // End of Procedure
