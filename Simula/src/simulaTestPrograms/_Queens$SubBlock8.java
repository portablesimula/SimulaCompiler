package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:25:47 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class _Queens$SubBlock8 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    final LABQNT$ e=new LABQNT$(this,1,"e");
    int k=0;
    int j=0;
    public _Queens$SubBlock8(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
    }
    public RTObject$ STM$() {
        _Queens$SubBlock8 THIS$=(_Queens$SubBlock8)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                LABEL$(1,"e");
                while((j==(8))) {
                    {
                        ((_Queens)(CUR$.SL$)).i=(((_Queens)(CUR$.SL$)).i-(3));
                        j=TXT$.getint(TXT$.sub(sysout().image,((_Queens)(CUR$.SL$)).i,1));
                    }
                }
                j=(j+(1));
                sysout().setpos(3);
                while((sysout().pos()!=(((_Queens)(CUR$.SL$)).i))) {
                    {
                        k=TXT$.getint(TXT$.sub(sysout().image,sysout().pos(),1));
                        if(VALUE$(((j==(k))|(((((double)(3))*(abs(((double)((j-(k)))))))==(abs(((double)((((_Queens)(CUR$.SL$)).i-(sysout().pos()))))))))))) {
                            GOTO$(e);
                        }
                        sysout().setpos((sysout().pos()+(3)));
                    }
                }
                sysout().outint(j,1);
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
        return(null);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("8Queens.sim","SubBlock SubBlock8",1,8,8,9,10,8,22,10,24,9,26,10,32,11,35,12,37,13,40,14,44,15,48,17,63,18);
}
