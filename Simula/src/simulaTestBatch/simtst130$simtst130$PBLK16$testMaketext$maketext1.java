package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testMaketext$maketext1 extends PROC$ {
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public char p$ch;
    public int p$n;
    public simtst130$simtst130$PBLK16$testMaketext$maketext1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 2: p$ch=(char)objectValue(param); break;
                case 1: p$n=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testMaketext$maketext1(RTObject$ SL$) {
        super(SL$,2);
    }
    public simtst130$simtst130$PBLK16$testMaketext$maketext1(RTObject$ SL$,char sp$ch,int sp$n) {
        super(SL$);
        this.p$ch = sp$ch;
        this.p$n = sp$n;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testMaketext$maketext1 STM$() {
        if(VALUE$((p$n>(0)))) {
            new simtst130$simtst130$PBLK16$testMaketext$maketext1$SubBlock799((CUR$)).STM$();
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure maketext1",1,794,33,795,35,799,40,799);
}
