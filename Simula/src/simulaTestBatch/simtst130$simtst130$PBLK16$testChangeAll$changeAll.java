package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testChangeAll$changeAll extends PROC$ {
    public NAME$<TXT$> p$master;
    public TXT$ p$oldtext;
    public TXT$ p$newtext;
    public TXT$ local=null;
    public simtst130$simtst130$PBLK16$testChangeAll$changeAll setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 3: p$master=(NAME$<TXT$>)param; break;
                case 2: p$oldtext=(TXT$)objectValue(param); break;
                case 1: p$newtext=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testChangeAll$changeAll(RTObject$ SL$) {
        super(SL$,3);
    }
    public simtst130$simtst130$PBLK16$testChangeAll$changeAll(RTObject$ SL$,NAME$<TXT$> sp$master,TXT$ sp$oldtext,TXT$ sp$newtext) {
        super(SL$);
        this.p$master = sp$master;
        this.p$oldtext = sp$oldtext;
        this.p$newtext = sp$newtext;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testChangeAll$changeAll STM$() {
        local=p$master.get();
        ;
        while(TXT$.more(local)) {
            simtst130$PBLK16.change(new NAME$<TXT$>(){ public TXT$ get() { return(local); } public TXT$ put(TXT$ x$) { return(local=(TXT$)x$); } },p$oldtext,p$newtext);
        }
        ;
        p$master.put(local);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure changeAll",1,101,10,102,38,103,43,104,47,105);
}
