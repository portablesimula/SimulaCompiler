// JavaLine 1 ==> SourceLine 7
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Jan 22 18:14:34 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class TQueens$p extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=7, lastLine=15, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$r;
    public int p$c;
    public ARRAY$<?> p$q;
    public ARRAY$<?> p$u;
    public ARRAY$<?> p$d;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public TQueens$p setPar(Object param) {
        //Util.BREAK("CALL TQueens$p.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$r=intValue(param); break;
                case 1: p$c=intValue(param); break;
                case 2: p$q=arrayValue(param).COPY(); break;
                case 3: p$u=arrayValue(param).COPY(); break;
                case 4: p$d=arrayValue(param).COPY(); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public TQueens$p(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public TQueens$p(RTObject$ SL$,int sp$r,int sp$c,ARRAY$<?> sp$q,ARRAY$<?> sp$u,ARRAY$<?> sp$d) {
        super(SL$);
        // Parameter assignment to locals
        this.p$r = sp$r;
        this.p$c = sp$c;
        this.p$q = sp$q;
        this.p$u = sp$u;
        this.p$d = sp$d;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("p",7);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public TQueens$p STM$() {
        TRACE_BEGIN_STM$("p",7);
        // JavaLine 53 ==> SourceLine 9
        if((((((ARRAY$<int[]>)p$q).Elt[p$c-p$q.LB[0]]+(((ARRAY$<int[]>)p$u).Elt[(p$r-(p$c))-p$u.LB[0]]))+(((ARRAY$<int[]>)p$d).Elt[(p$r+(p$c))-p$d.LB[0]]))==(0))) {
            // JavaLine 55 ==> SourceLine 10
            {
                TRACE_BEGIN_STM$("CompoundStatement10",10);
                ((ARRAY$<int[]>)p$q).Elt[p$c-p$q.LB[0]]=((ARRAY$<int[]>)p$u).Elt[(p$r-(p$c))-p$u.LB[0]]=((ARRAY$<int[]>)p$d).Elt[(p$r+(p$c))-p$d.LB[0]]=p$r;
                // JavaLine 59 ==> SourceLine 11
                for(boolean CB$11:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){p$c=(int)x$; return(x$);};  public Number get(){return((Number)p$c); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(8); }})
                   )) { if(!CB$11) continue;
                if((p$r<(8))) {
                    new TQueens$p(((TQueens)(CUR$.SL$)),(p$r+(1)),p$c,p$q.COPY(),p$u.COPY(),p$d.COPY());
                } else
                // JavaLine 66 ==> SourceLine 12
                {
                    TRACE_BEGIN_STM$("CompoundStatement12",12);
                    sysout().outchar(char$(((((ARRAY$<int[]>)p$q).Elt[p$c-p$q.LB[0]]+(rank('A')))-(1))));
                    sysout().outint(p$c,1);
                    // JavaLine 71 ==> SourceLine 13
                    sysout().outchar(((char)32));
                    if((p$c==(8))) {
                        sysout().outimage();
                    }
                    TRACE_END_STM$("CompoundStatement12",13);
                }
            }
            TRACE_END_STM$("CompoundStatement10",13);
        }
    }
    TRACE_END_STM$("p",13);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("TQueens.sim","Procedure p",1,7,53,9,55,10,59,11,66,12,71,13,85,15);
}
