package simulaTestBatch;
// Simula-1.0 Compiled at Wed Oct 02 09:47:31 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst123$$trace extends PROC$ {
    public TXT$ p$msg;
    public simtst123$$trace setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst123$$trace(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst123$$trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public simtst123$$trace STM$() {
        if(VALUE$(((simtst123$)(CUR$.SL$)).verbose)) {
            {
                sysout().outtext(p$msg);
                sysout().outimage();
            }
        }
        if(VALUE$(TXTREL$NE(p$msg,((simtst123$)(CUR$.SL$)).facit.Elt[((simtst123$)(CUR$.SL$)).traceCase-((simtst123$)(CUR$.SL$)).facit.LB[0]]))) {
            {
                ((simtst123$)(CUR$.SL$)).found_error=true;
                sysout().outtext(new TXT$("ERROR in Case "));
                sysout().outint(((simtst123$)(CUR$.SL$)).traceCase,0);
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Trace: "),p$msg));
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Facit: "),((simtst123$)(CUR$.SL$)).facit.Elt[((simtst123$)(CUR$.SL$)).traceCase-((simtst123$)(CUR$.SL$)).facit.LB[0]]));
                sysout().outimage();
            }
        }
        ((simtst123$)(CUR$.SL$)).traceCase=Math.addExact(((simtst123$)(CUR$.SL$)).traceCase,1);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst123.sim","Procedure trace",1,15,28,17,35,18,37,20,40,21,44,22,47,23,52,25,56,26);
}
