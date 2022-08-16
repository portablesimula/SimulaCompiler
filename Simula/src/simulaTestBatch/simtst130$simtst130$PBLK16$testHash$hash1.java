package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testHash$hash1 extends PROC$ {
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public TXT$ p$t;
    public int p$n;
    public TXT$ tstrip=null;
    public int a=0;
    public simtst130$simtst130$PBLK16$testHash$hash1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 2: p$t=(TXT$)objectValue(param); break;
                case 1: p$n=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testHash$hash1(RTObject$ SL$) {
        super(SL$,2);
    }
    public simtst130$simtst130$PBLK16$testHash$hash1(RTObject$ SL$,TXT$ sp$t,int sp$n) {
        super(SL$);
        this.p$t = sp$t;
        this.p$n = sp$n;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testHash$hash1 STM$() {
        tstrip=simtst130$PBLK16.frontstrip(TXT$.strip(p$t));
        ;
        if(VALUE$(TRF_EQ(tstrip,null))) {
            RESULT$=ENVIRONMENT$.mod(TXT$.length(p$t),p$n);
        } else
        {
            a=ENVIRONMENT$.rank(TXT$.getchar(tstrip));
            ;
            if(VALUE$((TXT$.length(tstrip)>(3)))) {
                {
                    a=Math.addExact(a,Math.multiplyExact(8,ENVIRONMENT$.rank(TXT$.getchar(tstrip))));
                    ;
                    a=Math.addExact(a,Math.multiplyExact(64,ENVIRONMENT$.rank(TXT$.getchar(tstrip))));
                }
            }
            ;
            TXT$.setpos(tstrip,TXT$.length(tstrip));
            ;
            a=Math.addExact(Math.addExact(a,Math.multiplyExact(512,ENVIRONMENT$.rank(TXT$.getchar(tstrip)))),TXT$.length(p$t));
            ;
            RESULT$=ENVIRONMENT$.mod(a,p$n);
            ;
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure hash1",1,571,11,572,36,573,39,574,43,575,47,576,49,577,53,578,58,580,61,581,64,582,70,584);
}
