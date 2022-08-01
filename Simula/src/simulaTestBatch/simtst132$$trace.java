package simulaTestBatch;
// Simula-2.0 Compiled at Mon Jul 04 17:55:02 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst132$$trace extends PROC$ {
    public TXT$ p$msg;
    public simtst132$$trace setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$msg=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst132$$trace(RTObject$ SL$) {
        super(SL$,1);
    }
    public simtst132$$trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public simtst132$$trace STM$() {
        if(VALUE$(false)) {
            {
                sysout().outtext(p$msg);
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        if(VALUE$(TXTREL$NE(p$msg,((simtst132$)(CUR$.SL$)).facit.Elt[((simtst132$)(CUR$.SL$)).traceCase-((simtst132$)(CUR$.SL$)).facit.LB[0]]))) {
            {
                ((simtst132$)(CUR$.SL$)).found_error=true;
                ;
                sysout().outtext(new TXT$("ERROR in Case "));
                ;
                sysout().outint(((simtst132$)(CUR$.SL$)).traceCase,0);
                ;
                sysout().outimage();
                ;
                sysout().outtext(CONC(new TXT$("Trace: "),p$msg));
                ;
                sysout().outimage();
                ;
                sysout().outtext(CONC(new TXT$("Facit: "),((simtst132$)(CUR$.SL$)).facit.Elt[((simtst132$)(CUR$.SL$)).traceCase-((simtst132$)(CUR$.SL$)).facit.LB[0]]));
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        ((simtst132$)(CUR$.SL$)).traceCase=Math.addExact(((simtst132$)(CUR$.SL$)).traceCase,1);
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst132.sim","Procedure trace",1,14,28,16,38,17,40,19,44,20,51,21,56,22,64,24,69,25);
}
