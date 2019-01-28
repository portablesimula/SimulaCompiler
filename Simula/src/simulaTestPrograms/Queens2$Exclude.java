// JavaLine 1 ==> SourceLine 58
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Jan 23 17:07:34 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Queens2$Exclude extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=58, lastLine=74, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public ARRAY$<?> p$q;
    // Declare local labels
    // JavaLine 15 ==> SourceLine 73
    final LABQNT$ TR=new LABQNT$(this,0,1); // Local Label #1=TR
    // JavaLine 17 ==> SourceLine 74
    final LABQNT$ EXIT=new LABQNT$(this,0,2); // Local Label #2=EXIT
    // Declare locals as attributes
    // JavaLine 20 ==> SourceLine 59
    int thn=0;
    int i=0;
    int j=0;
    int k=0;
    int l=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public Queens2$Exclude setPar(Object param) {
        //Util.BREAK("CALL Queens2$Exclude.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$q=arrayValue(param).COPY(); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Queens2$Exclude(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public Queens2$Exclude(RTObject$ SL$,ARRAY$<?> sp$q) {
        super(SL$);
        // Parameter assignment to locals
        this.p$q = sp$q;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Exclude",59);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Queens2$Exclude STM$() {
        TRACE_BEGIN_STM$("Exclude",59);
        Queens2$Exclude THIS$=(Queens2$Exclude)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 59 ==> SourceLine 60
                i=((ARRAY$<int[]>)p$q).Elt[1-p$q.LB[0]];
                j=((ARRAY$<int[]>)p$q).Elt[2-p$q.LB[0]];
                k=((ARRAY$<int[]>)p$q).Elt[3-p$q.LB[0]];
                l=((ARRAY$<int[]>)p$q).Elt[4-p$q.LB[0]];
                // JavaLine 64 ==> SourceLine 61
                thn=new Queens2$number(((Queens2)(CUR$.SL$)),i,j,k,l).RESULT$;
                // JavaLine 66 ==> SourceLine 62
                if((thn>(new Queens2$number(((Queens2)(CUR$.SL$)),(9-(i)),(9-(j)),(9-(k)),(9-(l))).RESULT$))) {
                    GOTO$(TR); // GOTO EVALUATED LABEL
                }
                // JavaLine 70 ==> SourceLine 63
                i=((ARRAY$<int[]>)p$q).Elt[8-p$q.LB[0]];
                j=((ARRAY$<int[]>)p$q).Elt[7-p$q.LB[0]];
                k=((ARRAY$<int[]>)p$q).Elt[6-p$q.LB[0]];
                l=((ARRAY$<int[]>)p$q).Elt[5-p$q.LB[0]];
                // JavaLine 75 ==> SourceLine 64
                if((thn>(new Queens2$number(((Queens2)(CUR$.SL$)),i,j,k,l).RESULT$))) {
                    GOTO$(TR); // GOTO EVALUATED LABEL
                } else
                // JavaLine 79 ==> SourceLine 65
                if((thn>(new Queens2$number(((Queens2)(CUR$.SL$)),(9-(i)),(9-(j)),(9-(k)),(9-(l))).RESULT$))) {
                    GOTO$(TR); // GOTO EVALUATED LABEL
                }
                // JavaLine 83 ==> SourceLine 66
                i=new Queens2$qinv(((Queens2)(CUR$.SL$)),1).RESULT$;
                j=new Queens2$qinv(((Queens2)(CUR$.SL$)),2).RESULT$;
                k=new Queens2$qinv(((Queens2)(CUR$.SL$)),3).RESULT$;
                l=new Queens2$qinv(((Queens2)(CUR$.SL$)),4).RESULT$;
                // JavaLine 88 ==> SourceLine 67
                if((thn>(new Queens2$number(((Queens2)(CUR$.SL$)),i,j,k,l).RESULT$))) {
                    GOTO$(TR); // GOTO EVALUATED LABEL
                } else
                // JavaLine 92 ==> SourceLine 68
                if((thn>(new Queens2$number(((Queens2)(CUR$.SL$)),(9-(i)),(9-(j)),(9-(k)),(9-(l))).RESULT$))) {
                    GOTO$(TR); // GOTO EVALUATED LABEL
                }
                // JavaLine 96 ==> SourceLine 69
                i=new Queens2$qinv(((Queens2)(CUR$.SL$)),8).RESULT$;
                j=new Queens2$qinv(((Queens2)(CUR$.SL$)),7).RESULT$;
                k=new Queens2$qinv(((Queens2)(CUR$.SL$)),6).RESULT$;
                l=new Queens2$qinv(((Queens2)(CUR$.SL$)),5).RESULT$;
                // JavaLine 101 ==> SourceLine 70
                if((thn>(new Queens2$number(((Queens2)(CUR$.SL$)),i,j,k,l).RESULT$))) {
                    GOTO$(TR); // GOTO EVALUATED LABEL
                } else
                // JavaLine 105 ==> SourceLine 71
                if((thn>(new Queens2$number(((Queens2)(CUR$.SL$)),(9-(i)),(9-(j)),(9-(k)),(9-(l))).RESULT$))) {
                    GOTO$(TR); // GOTO EVALUATED LABEL
                }
                // JavaLine 109 ==> SourceLine 72
                RESULT$=false;
                GOTO$(EXIT); // GOTO EVALUATED LABEL
                // JavaLine 112 ==> SourceLine 73
                LABEL$(1); // TR
                RESULT$=true;
                // JavaLine 115 ==> SourceLine 74
                LABEL$(2); // EXIT
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
        TRACE_END_STM$("Exclude",74);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Queens2.sim","Procedure Exclude",1,58,15,73,17,74,20,59,59,60,64,61,66,62,70,63,75,64,79,65,83,66,88,67,92,68,96,69,101,70,105,71,109,72,112,73,115,74,133,74);
}
