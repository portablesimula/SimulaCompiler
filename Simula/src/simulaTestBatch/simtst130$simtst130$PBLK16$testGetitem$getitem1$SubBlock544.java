package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544 extends BASICIO$ {
    final LABQNT$ LABEL$out=new LABQNT$(this,1,"out");
    public char window=0;
    public int startpos=0;
    public TXT$ t=null;
    public simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
    }
    public RTObject$ STM$() {
        simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544 THIS$=(simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                t=((simtst130$simtst130$PBLK16$testGetitem$getitem1)(CUR$.SL$)).p$tt.get();
                ;
                TXT$.setpos(t,TXT$.pos(((simtst130$simtst130$PBLK16$testGetitem$getitem1)(CUR$.SL$)).p$tt.get()));
                ;
                startpos=Math.addExact(TXT$.length(t),1);
                ;
                new simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544$getCharacter((CUR$));
                ;
                while(((window==(((char)32)))|((window==(ENVIRONMENT$.char$(9)))))) {
                    new simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544$getCharacter((CUR$));
                }
                ;
                startpos=Math.subtractExact(TXT$.pos(t),1);
                ;
                if(VALUE$((!(ENVIRONMENT$.letter(window))))) {
                    {
                        if(VALUE$(ENVIRONMENT$.digit(window))) {
                            while(ENVIRONMENT$.digit(new simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544$getCharacter((CUR$)).RESULT$)) {
                                ;
                            }
                        }
                        if(VALUE$((window==('.')))) {
                            while(ENVIRONMENT$.digit(new simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544$getCharacter((CUR$)).RESULT$)) {
                                ;
                            }
                        }
                    }
                } else
                while(new simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544$idchar((CUR$),new simtst130$simtst130$PBLK16$testGetitem$getitem1$SubBlock544$getCharacter((CUR$)).RESULT$).RESULT$) {
                    ;
                }
                if(VALUE$((TXT$.pos(t)>(Math.addExact(startpos,1))))) {
                    TXT$.setpos(t,Math.subtractExact(TXT$.pos(t),1));
                }
                ;
                {
                    LABEL$(1,"out");
                    ((simtst130$simtst130$PBLK16$testGetitem$getitem1)(CUR$.SL$)).RESULT$=TXT$.sub(t,startpos,Math.subtractExact(TXT$.pos(t),startpos));
                }
                ;
                TXT$.setpos(((simtst130$simtst130$PBLK16$testGetitem$getitem1)(CUR$.SL$)).p$tt.get(),TXT$.pos(t));
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","SubBlock SubBlock544",1,523,7,542,9,523,22,532,27,533,30,534,33,535,38,536,41,537,43,538,50,539,58,540,62,541,67,542,73,544,88,544);
}
