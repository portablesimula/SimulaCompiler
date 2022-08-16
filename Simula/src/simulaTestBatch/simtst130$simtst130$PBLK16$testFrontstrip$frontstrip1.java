package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testFrontstrip$frontstrip1 extends PROC$ {
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public TXT$ p$t;
    final LABQNT$ LABEL$exit=new LABQNT$(this,1,"exit");
    public simtst130$simtst130$PBLK16$testFrontstrip$frontstrip1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$t=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testFrontstrip$frontstrip1(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst130$simtst130$PBLK16$testFrontstrip$frontstrip1(RTObject$ SL$,TXT$ sp$t) {
        super(SL$);
        this.p$t = sp$t;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testFrontstrip$frontstrip1 STM$() {
        simtst130$simtst130$PBLK16$testFrontstrip$frontstrip1 THIS$=(simtst130$simtst130$PBLK16$testFrontstrip$frontstrip1)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                if(VALUE$(TRF_NE(p$t,null))) {
                    {
                        TXT$.setpos(p$t,1);
                        ;
                        while(TXT$.more(p$t)) {
                            if(VALUE$((TXT$.getchar(p$t)!=(((char)32))))) {
                                {
                                    RESULT$=TXT$.sub(p$t,Math.subtractExact(TXT$.pos(p$t),1),Math.addExact(Math.subtractExact(TXT$.length(p$t),TXT$.pos(p$t)),2));
                                    ;
                                    TXT$.setpos(p$t,TXT$.length(p$t));
                                    ;
                                    GOTO$(LABEL$exit);
                                    ;
                                }
                            }
                        }
                        ;
                        {
                            LABEL$(1,"exit");
                            ;
                        }
                    }
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure frontstrip1",1,492,10,501,36,493,38,494,42,495,44,496,46,497,50,498,53,499,60,501,80,501);
}
