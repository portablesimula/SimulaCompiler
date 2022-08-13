package simulaTestBatch;
// Simula-2.0 Compiled at Fri Aug 12 13:52:55 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst54$simtst54$PBLK6$report extends PROC$ {
    public TXT$ p$message;
    public TXT$ T=null;
    public simtst54$simtst54$PBLK6$report setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$message=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst54$simtst54$PBLK6$report(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst54$simtst54$PBLK6$report(RTObject$ SL$,TXT$ sp$message) {
        super(SL$);
        this.p$message = sp$message;
        BBLK();
        STM$();
    }
    public simtst54$simtst54$PBLK6$report STM$() {
        T=ENVIRONMENT$.blanks(40);
        ;
        sysout().outfix(((simtst54$PBLK6)(CUR$.SL$)).time(),2,0);
        ;
        sysout().outtext(CONC(new TXT$(": "),p$message));
        ;
        ASGTXT$(T,TXT$.strip(sysout().image));
        ;
        ASGTXT$(sysout().image,null);
        ;
        TXT$.setpos(sysout().image,1);
        ;
        if(VALUE$(TXTREL$NE(TXT$.strip(T),((simtst54$PBLK6)(CUR$.SL$)).facit.Elt[((simtst54$PBLK6)(CUR$.SL$)).testCase$2-((simtst54$PBLK6)(CUR$.SL$)).facit.LB[0]]))) {
            new SimulaTest$err((CUR$.SL$.SL$),CONC(CONC(TXT$.strip(T),new TXT$(" <> ")),((simtst54$PBLK6)(CUR$.SL$)).facit.Elt[((simtst54$PBLK6)(CUR$.SL$)).testCase$2-((simtst54$PBLK6)(CUR$.SL$)).facit.LB[0]]));
        }
        ;
        ((simtst54$PBLK6)(CUR$.SL$)).testCase$2=Math.addExact(((simtst54$PBLK6)(CUR$.SL$)).testCase$2,1);
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst54.sim","Procedure report",1,34,8,35,32,36,37,37,44,38,49,39,54,40);
}
