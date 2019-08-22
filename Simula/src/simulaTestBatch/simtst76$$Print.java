package simulaTestBatch;
// Simula-1.0 Compiled at Thu Aug 22 12:24:09 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst76$$Print extends PROC$ {
    public TXT$ p$t;
    public simtst76$$Print setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$t=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst76$$Print(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst76$$Print(RTObject$ SL$,TXT$ sp$t) {
        super(SL$);
        this.p$t = sp$t;
        BBLK();
        STM$();
    }
    public simtst76$$Print STM$() {
        sysout().outtext(p$t);
        if(VALUE$(((simtst76$)(CUR$.SL$)).verbose)) {
            sysout().outimage();
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst76.sim","Procedure Print",1,15,28,16,35,16);
}
