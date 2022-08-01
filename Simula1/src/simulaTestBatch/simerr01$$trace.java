package simulaTestBatch;
// Simula-2.0 Compiled at Fri Sep 03 09:27:42 CEST 2021
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr01$$trace extends PROC$ {
    public TXT$ p$msg;
    public simerr01$$trace setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 1: p$msg=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simerr01$$trace(RTObject$ SL$) {
        super(SL$,1);
    }
    public simerr01$$trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public simerr01$$trace STM$() {
        if(VALUE$(((simerr01$)(CUR$.SL$)).verbose)) {
            {
                sysout().outtext(p$msg);
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        if(VALUE$(TXTREL$NE(p$msg,((simerr01$)(CUR$.SL$)).facit.Elt[((simerr01$)(CUR$.SL$)).traceCase-((simerr01$)(CUR$.SL$)).facit.LB[0]]))) {
            {
                ((simerr01$)(CUR$.SL$)).found_error=true;
                ;
                sysout().outtext(new TXT$("ERROR in Case "));
                ;
                sysout().outint(((simerr01$)(CUR$.SL$)).traceCase,0);
                ;
                sysout().outimage();
                ;
                sysout().outtext(CONC(new TXT$("Trace: "),p$msg));
                ;
                sysout().outimage();
                ;
                sysout().outtext(CONC(new TXT$("Facit: "),((simerr01$)(CUR$.SL$)).facit.Elt[((simerr01$)(CUR$.SL$)).traceCase-((simerr01$)(CUR$.SL$)).facit.LB[0]]));
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        ((simerr01$)(CUR$.SL$)).traceCase=Math.addExact(((simerr01$)(CUR$.SL$)).traceCase,1);
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr01.sim","Procedure trace",1,15,28,17,38,18,40,20,44,21,51,22,56,23,64,25,69,26);
}
