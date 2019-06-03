package simulaTestBatch;
// Simula-1.0 Compiled at Sun Jun 02 12:51:11 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst41$ extends BASICIO$ {
    public int prefixLevel() { return(0); }
    boolean found_error=false;
    final boolean verbose=(boolean)(false);
    int i=0;
    public ARRAY$<int[]>A=null;
    public simtst41$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst41$");
        int[] A$LB=new int[1]; int[] A$UB=new int[1];
        A$LB[0]=0; A$UB[0]=100;
        BOUND_CHECK$(A$LB[0],A$UB[0]);
        A=new ARRAY$<int[]>(new int[A$UB[0]-A$LB[0]+1],A$LB,A$UB);
    }
    public RTObject$ STM$() {
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- START Simula a.s. TEST 41"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- Test use of name paramter in external procedure."));
                sysout().outimage();
                sysout().outimage();
            }
        }
        new simtst41$$P(((simtst41$)CUR$),new NAME$<Integer>(){ public Integer get() { return(new simtst41$$teller(((simtst41$)CUR$)).RESULT$); } });
        for(boolean CB$41:new ForList(
            new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(0); }})
           ,new WhileElt<Number>(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(Math.addExact(i,1)); }},new NAME$<Boolean>() { public Boolean get(){return((!(found_error))&((i<=(100)))); }})
           )) { if(!CB$41) continue;
        if(VALUE$((((mod(i,2)!=(0))&((A.Elt[i-A.LB[0]]!=(Math.addExact(i,1)))))|(((mod(i,2)==(0))&((A.Elt[i-A.LB[0]]!=(0)))))))) {
            {
                sysout().outtext(new TXT$("*** error : Values : i = "));
                sysout().outint(i,4);
                sysout().outtext(new TXT$("  A (i) = "));
                sysout().outint(A.Elt[i-A.LB[0]],4);
                sysout().outimage();
                found_error=true;
            }
        }
    }
    if(VALUE$(found_error)) {
    } else
    {
        sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 41"));
    }
    if(VALUE$(verbose)) {
        {
            sysout().outtext(new TXT$("--- END Simula a.s. TEST 41"));
            sysout().outimage();
        }
    }
    EBLK();
    return(null);
}

public static void main(String[] args) {
    RT.setRuntimeOptions(args);
    new simtst41$(CTX$).STM$();
}
public static PROGINFO$ INFO$=new PROGINFO$("simtst41.sim","SimulaProgram simtst41$",1,12,8,13,10,14,12,16,14,17,20,17,27,30,29,31,32,32,34,33,36,34,41,37,43,41,48,42,50,44,53,45,55,46,57,47,59,48,61,49,66,55,69,58,73,61,75,62,78,66,89,66);
}
