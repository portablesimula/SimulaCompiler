package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testFindtrigger$findtrigger1 extends PROC$ {
    public char RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public NAME$<TXT$> p$master;
    public TXT$ p$triggers;
    final LABQNT$ LABEL$out=new LABQNT$(this,1,"out");
    public char c=0;
    public TXT$ t=null;
    public simtst130$simtst130$PBLK16$testFindtrigger$findtrigger1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 2: p$master=(NAME$<TXT$>)param; break;
                case 1: p$triggers=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testFindtrigger$findtrigger1(RTObject$ SL$) {
        super(SL$,2);
    }
    public simtst130$simtst130$PBLK16$testFindtrigger$findtrigger1(RTObject$ SL$,NAME$<TXT$> sp$master,TXT$ sp$triggers) {
        super(SL$);
        this.p$master = sp$master;
        this.p$triggers = sp$triggers;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testFindtrigger$findtrigger1 STM$() {
        simtst130$simtst130$PBLK16$testFindtrigger$findtrigger1 THIS$=(simtst130$simtst130$PBLK16$testFindtrigger$findtrigger1)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                t=p$master.get();
                ;
                while(TXT$.more(t)) {
                    {
                        c=TXT$.getchar(t);
                        ;
                        TXT$.setpos(p$triggers,1);
                        ;
                        if(VALUE$(TRF_NE(simtst130$PBLK16.scanto(new NAME$<TXT$>(){ public TXT$ get() { return(p$triggers); } public TXT$ put(TXT$ x$) { return(p$triggers=(TXT$)x$); } },c),p$triggers))) {
                            {
                                RESULT$=c;
                                ;
                                GOTO$(LABEL$out);
                                ;
                            }
                        }
                    }
                }
                ;
                {
                    LABEL$(1,"out");
                    TXT$.setpos(p$master.get(),TXT$.pos(t));
                }
                ;
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure findtrigger1",1,385,11,397,13,386,15,387,45,388,47,389,51,390,54,391,56,393,60,394,68,397,87,398);
}
