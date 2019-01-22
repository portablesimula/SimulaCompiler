// JavaLine 1 ==> SourceLine 76
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Jan 22 17:05:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Queens2$p extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=76, lastLine=94, hasLocalClasses=false, System=false
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
    public Queens2$p setPar(Object param) {
        //Util.BREAK("CALL Queens2$p.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public Queens2$p(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public Queens2$p(RTObject$ SL$,int sp$r,int sp$c,ARRAY$<?> sp$q,ARRAY$<?> sp$u,ARRAY$<?> sp$d) {
        super(SL$);
        // Parameter assignment to locals
        this.p$r = sp$r;
        this.p$c = sp$c;
        this.p$q = sp$q;
        this.p$u = sp$u;
        this.p$d = sp$d;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("p",76);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Queens2$p STM$() {
        TRACE_BEGIN_STM$("p",76);
        // JavaLine 53 ==> SourceLine 78
        if((((((ARRAY$<int[]>)p$q).Elt[p$c-p$q.LB[0]]+(((ARRAY$<int[]>)p$u).Elt[(p$r-(p$c))-p$u.LB[0]]))+(((ARRAY$<int[]>)p$d).Elt[(p$r+(p$c))-p$d.LB[0]]))==(0))) {
            // JavaLine 55 ==> SourceLine 79
            {
                TRACE_BEGIN_STM$("CompoundStatement79",79);
                ((ARRAY$<int[]>)p$q).Elt[p$c-p$q.LB[0]]=((ARRAY$<int[]>)p$u).Elt[(p$r-(p$c))-p$u.LB[0]]=((ARRAY$<int[]>)p$d).Elt[(p$r+(p$c))-p$d.LB[0]]=p$r;
                // JavaLine 59 ==> SourceLine 80
                for(boolean CB$80:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){p$c=(int)x$; return(x$);};  public Number get(){return((Number)p$c); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(8); }})
                   )) { if(!CB$80) continue;
                if((p$r<(8))) {
                    new Queens2$p(((Queens2)(CUR$.SL$)),(p$r+(1)),p$c,p$q.COPY(),p$u.COPY(),p$d.COPY());
                } else
                // JavaLine 66 ==> SourceLine 81
                {
                    TRACE_BEGIN_STM$("CompoundStatement81",81);
                    if((p$c==(1))) {
                        new Queens2$ClearBoard(((Queens2)(CUR$.SL$)));
                    }
                    // JavaLine 72 ==> SourceLine 82
                    if((((Queens2)(CUR$.SL$)).nochk||((!(new Queens2$Exclude(((Queens2)(CUR$.SL$)),p$q.COPY()).RESULT$))))) {
                    } else
                    // JavaLine 75 ==> SourceLine 83
                    {
                        TRACE_BEGIN_STM$("CompoundStatement83",83);
                        new Queens2$Setpos(((Queens2)(CUR$.SL$)),(4+((2*(p$c)))),(21+((4*(((ARRAY$<int[]>)p$q).Elt[p$c-p$q.LB[0]])))));
                        sysout().outchar('*');
                        sysout().breakoutimage();
                        // JavaLine 81 ==> SourceLine 84
                        if((p$c==(8))) {
                            // JavaLine 83 ==> SourceLine 85
                            {
                                TRACE_BEGIN_STM$("CompoundStatement85",85);
                                ((Queens2)(CUR$.SL$)).nr=(((Queens2)(CUR$.SL$)).nr+(1));
                                // JavaLine 87 ==> SourceLine 86
                                new Queens2$Setpos(((Queens2)(CUR$.SL$)),24,23);
                                sysout().outtext(new TXT$("Number: "));
                                sysout().outint(((Queens2)(CUR$.SL$)).nr,0);
                                // JavaLine 91 ==> SourceLine 87
                                new Queens2$Setpos(((Queens2)(CUR$.SL$)),24,45);
                                sysout().outtext(new TXT$("More? "));
                                // JavaLine 94 ==> SourceLine 88
                                sysout().breakoutimage();
                                // JavaLine 96 ==> SourceLine 89
                                if((!(((Queens2)(CUR$.SL$)).all))) {
                                    // JavaLine 98 ==> SourceLine 90
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement90",90);
                                        sysin().inimage();
                                        ((Queens2)(CUR$.SL$)).ch=sysin().inchar();
                                        // JavaLine 103 ==> SourceLine 91
                                        if((((Queens2)(CUR$.SL$)).ch==('a'))) {
                                            ((Queens2)(CUR$.SL$)).all=true;
                                        } else
                                        // JavaLine 107 ==> SourceLine 92
                                        if((rank(((Queens2)(CUR$.SL$)).ch)>(32))) {
                                            GOTO$(((Queens2)(CUR$.SL$)).EXIT); // GOTO EVALUATED LABEL
                                        }
                                        TRACE_END_STM$("CompoundStatement90",92);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement85",92);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement83",92);
                    }
                    TRACE_END_STM$("CompoundStatement81",92);
                }
            }
            TRACE_END_STM$("CompoundStatement79",92);
        }
    }
    TRACE_END_STM$("p",92);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("Queens2.sim","Procedure p",1,76,53,78,55,79,59,80,66,81,72,82,75,83,81,84,83,85,87,86,91,87,94,88,96,89,98,90,103,91,107,92,128,94);
}
