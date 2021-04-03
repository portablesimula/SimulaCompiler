package simulaTestBatch;
// Simula-1.0 Compiled at Sat Apr 11 15:40:47 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst127$$trace extends PROC$ {
    public TXT$ p$msg;
    public simtst127$$trace setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst127$$trace(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst127$$trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public simtst127$$trace STM$() {
        if(VALUE$(((simtst127$)(CUR$.SL$)).verbose)) {
            {
                sysout().outtext(p$msg);
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        if(VALUE$(TXTREL$NE(p$msg,((simtst127$)(CUR$.SL$)).facit.Elt[((simtst127$)(CUR$.SL$)).traceCase-((simtst127$)(CUR$.SL$)).facit.LB[0]]))) {
            {
                ((simtst127$)(CUR$.SL$)).found_error=true;
                ;
                sysout().outtext(new TXT$("ERROR in Case "));
                ;
                sysout().outint(((simtst127$)(CUR$.SL$)).traceCase,0);
                ;
                sysout().outimage();
                ;
                sysout().outtext(CONC(new TXT$("Trace: "),p$msg));
                ;
                sysout().outimage();
                ;
                sysout().outtext(CONC(new TXT$("Facit: "),((simtst127$)(CUR$.SL$)).facit.Elt[((simtst127$)(CUR$.SL$)).traceCase-((simtst127$)(CUR$.SL$)).facit.LB[0]]));
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        ((simtst127$)(CUR$.SL$)).traceCase=Math.addExact(((simtst127$)(CUR$.SL$)).traceCase,1);
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst127.sim","Procedure trace",1,14,28,16,38,17,40,19,44,20,51,21,56,22,64,24,69,25);
}
