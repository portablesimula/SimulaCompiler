package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testScanto$scanto1 extends PROC$ {
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public NAME$<TXT$> p$tt;
    public char p$c;
    final LABQNT$ LABEL$out=new LABQNT$(this,1,"out");
    public TXT$ t=null;
    public int p=0;
    public simtst130$simtst130$PBLK16$testScanto$scanto1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 2: p$tt=(NAME$<TXT$>)param; break;
                case 1: p$c=(char)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testScanto$scanto1(RTObject$ SL$) {
        super(SL$,2);
    }
    public simtst130$simtst130$PBLK16$testScanto$scanto1(RTObject$ SL$,NAME$<TXT$> sp$tt,char sp$c) {
        super(SL$);
        this.p$tt = sp$tt;
        this.p$c = sp$c;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testScanto$scanto1 STM$() {
        simtst130$simtst130$PBLK16$testScanto$scanto1 THIS$=(simtst130$simtst130$PBLK16$testScanto$scanto1)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                t=simtst130$PBLK16.rest(p$tt.get());
                ;
                p=TXT$.pos(p$tt.get());
                ;
                new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(new TXT$("REST="),t),new TXT$(", p=")),ENVIRONMENT$.edit(p)));
                ;
                while(TXT$.more(t)) {
                    if(VALUE$((TXT$.getchar(t)==(p$c)))) {
                        {
                            RESULT$=TXT$.sub(t,1,Math.subtractExact(TXT$.pos(t),2));
                            ;
                            new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(new TXT$("GOT IT: "),TXT$.sub(t,1,Math.subtractExact(TXT$.pos(t),2))));
                            ;
                            TXT$.setpos(p$tt.get(),Math.subtractExact(Math.addExact(p,TXT$.pos(t)),2));
                            ;
                            GOTO$(LABEL$out);
                            ;
                        }
                    }
                }
                ;
                RESULT$=simtst130$PBLK16.from(t,p);
                ;
                new simtst130$simtst130$PBLK16$trace((CUR$.SL$.SL$),CONC(CONC(CONC(new TXT$("not FOUND: t.pos="),ENVIRONMENT$.edit(TXT$.pos(t))),new TXT$(", t.length=")),ENVIRONMENT$.edit(TXT$.length(t))));
                ;
                TXT$.setpos(p$tt.get(),Math.addExact(TXT$.length(p$tt.get()),1));
                ;
                {
                    LABEL$(1,"out");
                    ;
                }
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure scanto1",1,1002,11,1016,13,1003,42,1004,47,1005,50,1006,53,1007,57,1008,60,1009,63,1010,70,1012,73,1013,76,1014,79,1016,97,1016);
}
