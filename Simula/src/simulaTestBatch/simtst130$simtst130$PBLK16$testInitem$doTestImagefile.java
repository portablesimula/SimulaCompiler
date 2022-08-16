package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testInitem$doTestImagefile extends PROC$ {
    public infile$ p$fil;
    public NAME$<TXT$> p$nextitem;
    public simtst130$simtst130$PBLK16$testInitem$doTestImagefile setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 2: p$fil=(infile$)objectValue(param); break;
                case 1: p$nextitem=(NAME$<TXT$>)param; break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testInitem$doTestImagefile(RTObject$ SL$) {
        super(SL$,2);
    }
    public simtst130$simtst130$PBLK16$testInitem$doTestImagefile(RTObject$ SL$,infile$ sp$fil,NAME$<TXT$> sp$nextitem) {
        super(SL$);
        this.p$fil = sp$fil;
        this.p$nextitem = sp$nextitem;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testInitem$doTestImagefile STM$() {
        p$fil.open(ENVIRONMENT$.blanks(20));
        ;
        ((simtst130$PBLK16)(CUR$.SL$.SL$)).i$1=0;
        ;
        while((!(p$fil.lastitem()))) {
            new simtst130$simtst130$PBLK16$testInitem$doTestImagefile$SubBlock645((CUR$)).STM$();
        }
        ;
        p$fil.close();
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure doTestImagefile",1,639,31,640,36,641,38,645,42,646,47,647);
}
