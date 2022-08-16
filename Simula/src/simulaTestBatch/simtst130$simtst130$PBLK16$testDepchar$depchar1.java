package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testDepchar$depchar1 extends PROC$ {
    public TXT$ p$t;
    public int p$p;
    public char p$c;
    public simtst130$simtst130$PBLK16$testDepchar$depchar1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 3: p$t=(TXT$)objectValue(param); break;
                case 2: p$p=intValue(param); break;
                case 1: p$c=(char)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testDepchar$depchar1(RTObject$ SL$) {
        super(SL$,3);
    }
    public simtst130$simtst130$PBLK16$testDepchar$depchar1(RTObject$ SL$,TXT$ sp$t,int sp$p,char sp$c) {
        super(SL$);
        this.p$t = sp$t;
        this.p$p = sp$p;
        this.p$c = sp$c;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testDepchar$depchar1 STM$() {
        if(VALUE$(((p$p>(0))&((p$p<=(TXT$.length(p$t))))))) {
            TXT$.putchar(TXT$.sub(p$t,p$p,1),p$c);
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure depchar1",1,320,34,321,40,321);
}
