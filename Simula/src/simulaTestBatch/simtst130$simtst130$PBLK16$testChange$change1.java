package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testChange$change1 extends PROC$ {
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public NAME$<TXT$> p$master;
    public TXT$ p$oldtext;
    public TXT$ p$newtext;
    public TXT$ local=null;
    public int p=0;
    public simtst130$simtst130$PBLK16$testChange$change1 setPar(Object param) {
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
    public simtst130$simtst130$PBLK16$testChange$change1(RTObject$ SL$) {
        super(SL$,3);
    }
    public simtst130$simtst130$PBLK16$testChange$change1(RTObject$ SL$,NAME$<TXT$> sp$master,TXT$ sp$oldtext,TXT$ sp$newtext) {
        super(SL$);
        this.p$master = sp$master;
        this.p$oldtext = sp$oldtext;
        this.p$newtext = sp$newtext;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testChange$change1 STM$() {
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(CONC(CONC(CONC(CONC(new TXT$("TEST change1("),p$master.get()),new TXT$(",")),p$oldtext),new TXT$(",")),p$newtext),new TXT$(")    master.pos=")),ENVIRONMENT$.edit(TXT$.pos(p$master.get()))));
        ;
        local=p$master.get();
        ;
        p=simtst130$PBLK16.search(local,p$oldtext);
        ;
        new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(new TXT$("TEST change1: p="),ENVIRONMENT$.edit(p)),new TXT$(", local.length=")),ENVIRONMENT$.edit(TXT$.length(local))));
        ;
        if(VALUE$((p<=(TXT$.length(local))))) {
            {
                RESULT$=true;
                ;
                new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(new TXT$("TEST change1: oldtext.length="),ENVIRONMENT$.edit(TXT$.length(p$oldtext))),new TXT$(", newtext.length=")),ENVIRONMENT$.edit(TXT$.length(p$newtext))));
                ;
                if(VALUE$((TXT$.length(p$oldtext)>=(TXT$.length(p$newtext))))) {
                    {
                        ASGTXT$(TXT$.sub(local,p,TXT$.length(p$newtext)),p$newtext);
                        ;
                        if(VALUE$((TXT$.length(p$oldtext)>(TXT$.length(p$newtext))))) {
                            {
                                ASGTXT$(simtst130$PBLK16.from(local,Math.addExact(p,TXT$.length(p$newtext))),simtst130$PBLK16.from(local,Math.addExact(p,TXT$.length(p$oldtext))));
                                ;
                                local=TXT$.sub(local,1,Math.addExact(Math.subtractExact(TXT$.length(local),TXT$.length(p$oldtext)),TXT$.length(p$newtext)));
                            }
                        }
                    }
                } else
                local=CONC(CONC(TXT$.sub(local,1,Math.subtractExact(p,1)),p$newtext),simtst130$PBLK16.from(local,Math.addExact(p,TXT$.length(p$oldtext))));
                ;
                TXT$.setpos(local,Math.addExact(p,TXT$.length(p$newtext)));
                ;
                p$master.put(local);
            }
        } else
        TXT$.setpos(p$master.get(),0);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure change1",1,44,12,45,39,46,42,47,45,48,48,49,51,50,53,51,57,52,60,53,62,54,66,55,68,56,72,57,78,59,81,60,84,61,88,63,92,63);
}
