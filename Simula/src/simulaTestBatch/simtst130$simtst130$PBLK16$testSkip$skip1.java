package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testSkip$skip1 extends PROC$ {
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public NAME$<TXT$> p$tt;
    public char p$c;
    final LABQNT$ LABEL$out=new LABQNT$(this,1,"out");
    public TXT$ t=null;
    public simtst130$simtst130$PBLK16$testSkip$skip1 setPar(Object param) {
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
    public simtst130$simtst130$PBLK16$testSkip$skip1(RTObject$ SL$) {
        super(SL$,2);
    }
    public simtst130$simtst130$PBLK16$testSkip$skip1(RTObject$ SL$,NAME$<TXT$> sp$tt,char sp$c) {
        super(SL$);
        this.p$tt = sp$tt;
        this.p$c = sp$c;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testSkip$skip1 STM$() {
        simtst130$simtst130$PBLK16$testSkip$skip1 THIS$=(simtst130$simtst130$PBLK16$testSkip$skip1)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                t=p$tt.get();
                ;
                while(TXT$.more(t)) {
                    if(VALUE$((TXT$.getchar(t)!=(p$c)))) {
                        {
                            TXT$.setpos(t,Math.subtractExact(TXT$.pos(t),1));
                            ;
                            RESULT$=TXT$.sub(t,TXT$.pos(t),Math.addExact(Math.subtractExact(TXT$.length(t),TXT$.pos(t)),1));
                            ;
                            GOTO$(LABEL$out);
                        }
                    }
                }
                ;
                {
                    LABEL$(1,"out");
                    TXT$.setpos(p$tt.get(),TXT$.pos(t));
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure skip1",1,1053,11,1060,13,1054,43,1055,46,1056,50,1057,53,1059,59,1061,77,1061);
}
