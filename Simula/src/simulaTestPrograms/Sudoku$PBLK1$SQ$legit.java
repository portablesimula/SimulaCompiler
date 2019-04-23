package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Apr 23 08:20:06 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Sudoku$PBLK1$SQ$legit extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$val;
    final LABQNT$ exit=new LABQNT$(this,1,"exit");
    int i=0;
    int j=0;
    int reg_row=0;
    int reg_col=0;
    private int $npar=0; // Number of actual parameters transmitted.
    public Sudoku$PBLK1$SQ$legit setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$val=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public Sudoku$PBLK1$SQ$legit(RTObject$ SL$)
    { super(SL$); }
    public Sudoku$PBLK1$SQ$legit(RTObject$ SL$,int sp$val) {
        super(SL$);
        this.p$val = sp$val;
        BBLK();
        STM$();
    }
    public Sudoku$PBLK1$SQ$legit STM$() {
        Sudoku$PBLK1$SQ$legit THIS$=(Sudoku$PBLK1$SQ$legit)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                for(boolean CB$28:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                   )) { if(!CB$28) continue;
                if(VALUE$((((Sudoku$PBLK1)(CUR$.SL$.SL$)).SQinst.Elt[((Sudoku$PBLK1$SQ)(CUR$.SL$)).p2$row-((Sudoku$PBLK1)(CUR$.SL$.SL$)).SQinst.LB[0]][i-((Sudoku$PBLK1)(CUR$.SL$.SL$)).SQinst.LB[1]].p2$val==(p$val)))) {
                    GOTO$(exit);
                }
            }
            for(boolean CB$30:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
               )) { if(!CB$30) continue;
            if(VALUE$((((Sudoku$PBLK1)(CUR$.SL$.SL$)).SQinst.Elt[i-((Sudoku$PBLK1)(CUR$.SL$.SL$)).SQinst.LB[0]][((Sudoku$PBLK1$SQ)(CUR$.SL$)).p2$col-((Sudoku$PBLK1)(CUR$.SL$.SL$)).SQinst.LB[1]].p2$val==(p$val)))) {
                GOTO$(exit);
            }
        }
        reg_row=(((Sudoku$PBLK1$SQ)(CUR$.SL$)).p2$row-(mod((((Sudoku$PBLK1$SQ)(CUR$.SL$)).p2$row-(1)),3)));
        reg_col=(((Sudoku$PBLK1$SQ)(CUR$.SL$)).p2$col-(mod((((Sudoku$PBLK1$SQ)(CUR$.SL$)).p2$col-(1)),3)));
        for(boolean CB$35:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(reg_row); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return((reg_row+(2))); }})
           )) { if(!CB$35) continue;
        for(boolean CB$36:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(reg_col); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return((reg_col+(2))); }})
           )) { if(!CB$36) continue;
        if(VALUE$((((Sudoku$PBLK1)(CUR$.SL$.SL$)).SQinst.Elt[i-((Sudoku$PBLK1)(CUR$.SL$.SL$)).SQinst.LB[0]][j-((Sudoku$PBLK1)(CUR$.SL$.SL$)).SQinst.LB[1]].p2$val==(p$val)))) {
            GOTO$(exit);
        }
    }
}
RESULT$=true;
LABEL$(1,"exit");
break LOOP$;
}
catch(LABQNT$ q) {
CUR$=THIS$;
if(q.SL$!=CUR$) {
    CUR$.STATE$=OperationalState.terminated;
    throw(q);
}
JTX$=q.index; continue LOOP$;
}
}
EBLK();
return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("Sudoku.sim","Procedure legit",1,24,11,40,13,26,42,28,46,29,51,30,55,31,60,33,62,34,64,35,68,36,72,37,78,38,80,40,95,40);
}
