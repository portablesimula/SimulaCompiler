package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testUpcompare$upcompare1$SubBlock1149 extends BASICIO$ {
    final LABQNT$ LABEL$out=new LABQNT$(this,1,"out");
    public char cmaster=0;
    public char ctest=0;
    public int shift=0;
    public simtst130$simtst130$PBLK16$testUpcompare$upcompare1$SubBlock1149(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
    }
    public RTObject$ STM$() {
        simtst130$simtst130$PBLK16$testUpcompare$upcompare1$SubBlock1149 THIS$=(simtst130$simtst130$PBLK16$testUpcompare$upcompare1$SubBlock1149)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                shift=Math.subtractExact(ENVIRONMENT$.rank('a'),ENVIRONMENT$.rank('A'));
                ;
                while(((TXT$.more(((simtst130$simtst130$PBLK16$testUpcompare$upcompare1)(CUR$.SL$)).p$master)&(TXT$.more(((simtst130$simtst130$PBLK16$testUpcompare$upcompare1)(CUR$.SL$)).p$test)))&((cmaster==(ctest))))) {
                    {
                        cmaster=TXT$.getchar(((simtst130$simtst130$PBLK16$testUpcompare$upcompare1)(CUR$.SL$)).p$master);
                        ;
                        ctest=TXT$.getchar(((simtst130$simtst130$PBLK16$testUpcompare$upcompare1)(CUR$.SL$)).p$test);
                        ;
                        if(VALUE$((((cmaster>('Z')))?(ENVIRONMENT$.letter(cmaster)):(false)))) {
                            cmaster=ENVIRONMENT$.char$(Math.subtractExact(ENVIRONMENT$.rank(cmaster),shift));
                        }
                        ;
                    }
                }
                ;
                {
                    LABEL$(1,"out");
                    ((simtst130$simtst130$PBLK16$testUpcompare$upcompare1)(CUR$.SL$)).RESULT$=(cmaster==(ctest));
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","SubBlock SubBlock1149",1,1139,7,1148,9,1139,12,1140,23,1141,26,1142,28,1143,32,1144,35,1145,37,1146,44,1148,63,1149);
}
