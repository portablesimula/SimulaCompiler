package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$simtst130$PBLK16$testPuttext$puttext1 extends PROC$ {
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public NAME$<TXT$> p$oldstring;
    public TXT$ p$newstring;
    public TXT$ s=null;
    public simtst130$simtst130$PBLK16$testPuttext$puttext1 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 2: p$oldstring=(NAME$<TXT$>)param; break;
                case 1: p$newstring=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst130$simtst130$PBLK16$testPuttext$puttext1(RTObject$ SL$) {
        super(SL$,2);
    }
    public simtst130$simtst130$PBLK16$testPuttext$puttext1(RTObject$ SL$,NAME$<TXT$> sp$oldstring,TXT$ sp$newstring) {
        super(SL$);
        this.p$oldstring = sp$oldstring;
        this.p$newstring = sp$newstring;
        BBLK();
        STM$();
    }
    public simtst130$simtst130$PBLK16$testPuttext$puttext1 STM$() {
        s=p$oldstring.get();
        ;
        if(VALUE$(((Math.subtractExact(Math.addExact(TXT$.pos(s),TXT$.length(p$newstring)),1)<=(TXT$.length(s)))&&((!(TXT$.constant(s))))))) {
            {
                RESULT$=true;
                ;
                ASGTXT$(TXT$.sub(s,TXT$.pos(s),TXT$.length(p$newstring)),p$newstring);
                ;
                TXT$.setpos(s,Math.addExact(TXT$.pos(s),TXT$.length(p$newstring)));
                TXT$.setpos(p$oldstring.get(),TXT$.pos(s));
            }
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","Procedure puttext1",1,816,11,817,37,818,39,819,43,820,46,822,48,823,55,824);
}
