package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testCompress$compress1 extends PROC$ {
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public TXT$ p$tin;
    public char p$ch;
    public int pInp=0;
    public int tinLen=0;
    public int count=0;
    public int pout=0;
    public char tmpCh=0;
    public simtst130$simtst130$PBLK16$testCompress$compress1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 2: p$tin=(TXT$)objectValue(param); break;
                case 1: p$ch=(char)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testCompress$compress1(RTObject$ SL$) {
        super(SL$,2);
    }
    public simtst130$simtst130$PBLK16$testCompress$compress1(RTObject$ SL$,TXT$ sp$tin,char sp$ch) {
        super(SL$);
        this.p$tin = sp$tin;
        this.p$ch = sp$ch;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testCompress$compress1 STM$() {
        if(VALUE$(TRF_EQ(p$tin,null))) {
            RESULT$=null;
        } else
        {
            tinLen=TXT$.length(p$tin);
            ;
            TXT$.setpos(p$tin,1);
            ;
            pout=1;
            ;
            for(pInp=1;pInp<=tinLen;pInp++) {
                {
                    TXT$.setpos(p$tin,pInp);
                    ;
                    tmpCh=TXT$.getchar(p$tin);
                    ;
                    if(VALUE$((tmpCh!=(p$ch)))) {
                        {
                            simtst130$PBLK16.depchar(p$tin,pout,tmpCh);
                            ;
                            pout=Math.addExact(pout,1);
                            ;
                        }
                    }
                }
            }
            ;
            RESULT$=(((pout==(0)))?(null):(TXT$.sub(p$tin,1,Math.subtractExact(pout,1))));
            ;
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure compress1",1,197,11,198,39,199,43,201,47,202,53,204,59,205,61,206,72,209,79,211);
}
