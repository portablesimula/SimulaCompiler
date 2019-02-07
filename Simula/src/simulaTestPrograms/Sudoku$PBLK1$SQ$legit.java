// JavaLine 1 ==> SourceLine 24
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:41:55 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Sudoku$PBLK1$SQ$legit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=24, lastLine=40, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$val;
    // Declare local labels
    // JavaLine 15 ==> SourceLine 40
    final LABQNT$ exit=new LABQNT$(this,0,1); // Local Label #1=exit
    // Declare locals as attributes
    // JavaLine 18 ==> SourceLine 26
    int i=0;
    int j=0;
    int reg_row=0;
    int reg_col=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public Sudoku$PBLK1$SQ$legit setPar(Object param) {
        //Util.BREAK("CALL Sudoku$PBLK1$SQ$legit.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public Sudoku$PBLK1$SQ$legit(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public Sudoku$PBLK1$SQ$legit(RTObject$ SL$,int sp$val) {
        super(SL$);
        // Parameter assignment to locals
        this.p$val = sp$val;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("legit",26);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Sudoku$PBLK1$SQ$legit STM$() {
        TRACE_BEGIN_STM$("legit",26);
        Sudoku$PBLK1$SQ$legit THIS$=(Sudoku$PBLK1$SQ$legit)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 56 ==> SourceLine 28
                for(boolean CB$28:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                   )) { if(!CB$28) continue;
                // JavaLine 60 ==> SourceLine 29
                if(VALUE$((((Sudoku$PBLK1)(CUR$.SL$.SL$)).SQinst.Elt[((Sudoku$PBLK1$SQ)(CUR$.SL$)).p2$row-((Sudoku$PBLK1)(CUR$.SL$.SL$)).SQinst.LB[0]][i-((Sudoku$PBLK1)(CUR$.SL$.SL$)).SQinst.LB[1]].p2$val==(p$val)))) {
                    GOTO$(exit); // GOTO EVALUATED LABEL
                }
            }
            // JavaLine 65 ==> SourceLine 30
            for(boolean CB$30:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
               )) { if(!CB$30) continue;
            // JavaLine 69 ==> SourceLine 31
            if(VALUE$((((Sudoku$PBLK1)(CUR$.SL$.SL$)).SQinst.Elt[i-((Sudoku$PBLK1)(CUR$.SL$.SL$)).SQinst.LB[0]][((Sudoku$PBLK1$SQ)(CUR$.SL$)).p2$col-((Sudoku$PBLK1)(CUR$.SL$.SL$)).SQinst.LB[1]].p2$val==(p$val)))) {
                GOTO$(exit); // GOTO EVALUATED LABEL
            }
        }
        // JavaLine 74 ==> SourceLine 33
        reg_row=(((Sudoku$PBLK1$SQ)(CUR$.SL$)).p2$row-(mod((((Sudoku$PBLK1$SQ)(CUR$.SL$)).p2$row-(1)),3)));
        // JavaLine 76 ==> SourceLine 34
        reg_col=(((Sudoku$PBLK1$SQ)(CUR$.SL$)).p2$col-(mod((((Sudoku$PBLK1$SQ)(CUR$.SL$)).p2$col-(1)),3)));
        // JavaLine 78 ==> SourceLine 35
        for(boolean CB$35:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(reg_row); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return((reg_row+(2))); }})
           )) { if(!CB$35) continue;
        // JavaLine 82 ==> SourceLine 36
        for(boolean CB$36:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(reg_col); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return((reg_col+(2))); }})
           )) { if(!CB$36) continue;
        // JavaLine 86 ==> SourceLine 37
        if(VALUE$((((Sudoku$PBLK1)(CUR$.SL$.SL$)).SQinst.Elt[i-((Sudoku$PBLK1)(CUR$.SL$.SL$)).SQinst.LB[0]][j-((Sudoku$PBLK1)(CUR$.SL$.SL$)).SQinst.LB[1]].p2$val==(p$val)))) {
            GOTO$(exit); // GOTO EVALUATED LABEL
        }
    }
}
// JavaLine 92 ==> SourceLine 38
RESULT$=true;
// JavaLine 94 ==> SourceLine 40
LABEL$(1,"exit");
break LOOP$;
}
catch(LABQNT$ q) {
CUR$=THIS$;
if(q.SL$!=CUR$ || q.prefixLevel!=0) {
    CUR$.STATE$=OperationalState.terminated;
    if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
    throw(q);
}
if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
JTX$=q.index; continue LOOP$; // EG. GOTO Lx
}
}
TRACE_END_STM$("legit",40);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("Sudoku.sim","Procedure legit",1,24,15,40,18,26,56,28,60,29,65,30,69,31,74,33,76,34,78,35,82,36,86,37,92,38,94,40,112,40);
}
