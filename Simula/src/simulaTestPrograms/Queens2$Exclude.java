package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:26:23 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Queens2$Exclude extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public ARRAY$<?> p$q;
    final LABQNT$ TR=new LABQNT$(this,1,"TR");
    final LABQNT$ EXIT=new LABQNT$(this,2,"EXIT");
    int thn=0;
    int i=0;
    int j=0;
    int k=0;
    int l=0;
    private int $npar=0; // Number of actual parameters transmitted.
    public Queens2$Exclude setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$q=arrayValue(param).COPY(); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public Queens2$Exclude(RTObject$ SL$)
    { super(SL$); }
    public Queens2$Exclude(RTObject$ SL$,ARRAY$<?> sp$q) {
        super(SL$);
        this.p$q = sp$q;
        BBLK();
        STM$();
    }
    public Queens2$Exclude STM$() {
        Queens2$Exclude THIS$=(Queens2$Exclude)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                i=((ARRAY$<int[]>)p$q).Elt[1-p$q.LB[0]];
                j=((ARRAY$<int[]>)p$q).Elt[2-p$q.LB[0]];
                k=((ARRAY$<int[]>)p$q).Elt[3-p$q.LB[0]];
                l=((ARRAY$<int[]>)p$q).Elt[4-p$q.LB[0]];
                thn=new Queens2$number(((Queens2)(CUR$.SL$)),i,j,k,l).RESULT$;
                if(VALUE$((thn>(new Queens2$number(((Queens2)(CUR$.SL$)),(9-(i)),(9-(j)),(9-(k)),(9-(l))).RESULT$)))) {
                    GOTO$(TR);
                }
                i=((ARRAY$<int[]>)p$q).Elt[8-p$q.LB[0]];
                j=((ARRAY$<int[]>)p$q).Elt[7-p$q.LB[0]];
                k=((ARRAY$<int[]>)p$q).Elt[6-p$q.LB[0]];
                l=((ARRAY$<int[]>)p$q).Elt[5-p$q.LB[0]];
                if(VALUE$((thn>(new Queens2$number(((Queens2)(CUR$.SL$)),i,j,k,l).RESULT$)))) {
                    GOTO$(TR);
                } else
                if(VALUE$((thn>(new Queens2$number(((Queens2)(CUR$.SL$)),(9-(i)),(9-(j)),(9-(k)),(9-(l))).RESULT$)))) {
                    GOTO$(TR);
                }
                i=new Queens2$qinv(((Queens2)(CUR$.SL$)),1).RESULT$;
                j=new Queens2$qinv(((Queens2)(CUR$.SL$)),2).RESULT$;
                k=new Queens2$qinv(((Queens2)(CUR$.SL$)),3).RESULT$;
                l=new Queens2$qinv(((Queens2)(CUR$.SL$)),4).RESULT$;
                if(VALUE$((thn>(new Queens2$number(((Queens2)(CUR$.SL$)),i,j,k,l).RESULT$)))) {
                    GOTO$(TR);
                } else
                if(VALUE$((thn>(new Queens2$number(((Queens2)(CUR$.SL$)),(9-(i)),(9-(j)),(9-(k)),(9-(l))).RESULT$)))) {
                    GOTO$(TR);
                }
                i=new Queens2$qinv(((Queens2)(CUR$.SL$)),8).RESULT$;
                j=new Queens2$qinv(((Queens2)(CUR$.SL$)),7).RESULT$;
                k=new Queens2$qinv(((Queens2)(CUR$.SL$)),6).RESULT$;
                l=new Queens2$qinv(((Queens2)(CUR$.SL$)),5).RESULT$;
                if(VALUE$((thn>(new Queens2$number(((Queens2)(CUR$.SL$)),i,j,k,l).RESULT$)))) {
                    GOTO$(TR);
                } else
                if(VALUE$((thn>(new Queens2$number(((Queens2)(CUR$.SL$)),(9-(i)),(9-(j)),(9-(k)),(9-(l))).RESULT$)))) {
                    GOTO$(TR);
                }
                RESULT$=false;
                GOTO$(EXIT);
                LABEL$(1,"TR");
                RESULT$=true;
                LABEL$(2,"EXIT");
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
    public static PROGINFO$ INFO$=new PROGINFO$("Queens2.sim","Procedure Exclude",1,58,11,73,13,74,15,59,45,60,50,61,52,62,56,63,61,64,65,65,69,66,74,67,78,68,82,69,87,70,91,71,95,72,98,73,101,74,116,74);
}
