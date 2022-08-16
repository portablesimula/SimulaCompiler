package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testInitem$testImagefile extends PROC$ {
    public TXT$ p$fileName;
    public infile$ fil=null;
    public simtst130$simtst130$PBLK16$testInitem$testImagefile setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$fileName=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testInitem$testImagefile(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst130$simtst130$PBLK16$testInitem$testImagefile(RTObject$ SL$,TXT$ sp$fileName) {
        super(SL$);
        this.p$fileName = sp$fileName;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testInitem$testImagefile STM$() {
        fil=new infile$(CTX$,p$fileName).STM$();
        ;
        new simtst130$simtst130$PBLK16$testInitem$doTestImagefile((CUR$.SL$),fil,new NAME$<TXT$>(){ public TXT$ get() { return(new simtst130$simtst130$PBLK16$testInitem$initem1((CUR$.SL$),fil).RESULT$); } });
        ;
        fil=new infile$(CTX$,p$fileName).STM$();
        ;
        new simtst130$simtst130$PBLK16$testInitem$doTestImagefile((CUR$.SL$),fil,new NAME$<TXT$>(){ public TXT$ get() { return(simtst130$PBLK16.initem(fil)); } });
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure testImagefile",1,633,8,634,30,635,35,636,42,637);
}
