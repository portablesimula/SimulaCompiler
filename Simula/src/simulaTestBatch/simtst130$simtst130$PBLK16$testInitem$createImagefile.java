package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testInitem$createImagefile extends PROC$ {
    public outfile$ p$fil;
    public simtst130$simtst130$PBLK16$testInitem$createImagefile setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$fil=(outfile$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testInitem$createImagefile(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst130$simtst130$PBLK16$testInitem$createImagefile(RTObject$ SL$,outfile$ sp$fil) {
        super(SL$);
        this.p$fil = sp$fil;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testInitem$createImagefile STM$() {
        p$fil.setaccess(new TXT$("anycreate"));
        ;
        p$fil.open(ENVIRONMENT$.blanks(20));
        ;
        for(((simtst130$PBLK16)(CUR$.SL$.SL$)).i$1=1;((simtst130$PBLK16)(CUR$.SL$.SL$)).i$1<=10;((simtst130$PBLK16)(CUR$.SL$.SL$)).i$1++) {
            p$fil.outtext(CONC(CONC(new TXT$("   item"),ENVIRONMENT$.edit(((simtst130$PBLK16)(CUR$.SL$.SL$)).i$1)),new TXT$("   ")));
        }
        ;
        p$fil.outimage();
        ;
        p$fil.close();
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure createImagefile",1,627,28,628,34,629,38,630,45,631);
}
