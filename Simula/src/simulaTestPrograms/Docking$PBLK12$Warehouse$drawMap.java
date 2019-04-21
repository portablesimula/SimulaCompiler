package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:32:50 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK12$Warehouse$drawMap extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$nr;
    int psl=0;
    int dLine=0;
    private int $npar=0; // Number of actual parameters transmitted.
    public Docking$PBLK12$Warehouse$drawMap setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$nr=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public Docking$PBLK12$Warehouse$drawMap(RTObject$ SL$)
    { super(SL$); }
    public Docking$PBLK12$Warehouse$drawMap(RTObject$ SL$,int sp$nr) {
        super(SL$);
        this.p$nr = sp$nr;
        BBLK();
        STM$();
    }
    public Docking$PBLK12$Warehouse$drawMap STM$() {
        ((Docking$PBLK12)(CUR$.SL$.SL$)).setFillColor(((Docking$PBLK12)(CUR$.SL$.SL$)).cyan$1);
        new Docking$PBLK12$Warehouse$FillSquare(((Docking$PBLK12$Warehouse)(CUR$.SL$)),((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$)).qLine$2-(8)))),((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$)).qPos$2-(8)))),((double)((16+(((Docking$PBLK12$Warehouse)(CUR$.SL$)).vanWidth$2)))),((double)(4)));
        new Docking$PBLK12$Warehouse$FillSquare(((Docking$PBLK12$Warehouse)(CUR$.SL$)),((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$)).qLine$2-(8)))),((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$)).qPos$2-(4)))),((double)(4)),((double)(100)));
        new Docking$PBLK12$Warehouse$FillSquare(((Docking$PBLK12$Warehouse)(CUR$.SL$)),((double)(((((Docking$PBLK12$Warehouse)(CUR$.SL$)).qLine$2+(4))+(((Docking$PBLK12$Warehouse)(CUR$.SL$)).vanWidth$2)))),((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$)).qPos$2-(4)))),((double)(4)),((double)(100)));
        for(boolean CB$67:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){psl=(int)x$; return(x$);};  public Number get(){return((Number)psl); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(p$nr); }})
           )) { if(!CB$67) continue;
        {
            dLine=(((Docking$PBLK12$Warehouse)(CUR$.SL$)).dLine1$2+(((psl-(1))*(20))));
            new Docking$PBLK12$Warehouse$FillSquare(((Docking$PBLK12$Warehouse)(CUR$.SL$)),((double)((dLine-(8)))),((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$)).pPos$2-(8)))),((double)((16+(((Docking$PBLK12$Warehouse)(CUR$.SL$)).vanWidth$2)))),((double)(4)));
            new Docking$PBLK12$Warehouse$FillSquare(((Docking$PBLK12$Warehouse)(CUR$.SL$)),((double)((dLine-(8)))),((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$)).pPos$2-(4)))),((double)(4)),((double)(240)));
            new Docking$PBLK12$Warehouse$FillSquare(((Docking$PBLK12$Warehouse)(CUR$.SL$)),((double)(((dLine+(4))+(((Docking$PBLK12$Warehouse)(CUR$.SL$)).vanWidth$2)))),((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$)).pPos$2-(4)))),((double)(4)),((double)(240)));
        }
    }
    ((Docking$PBLK12)(CUR$.SL$.SL$)).setDrawColor(((Docking$PBLK12)(CUR$.SL$.SL$)).orange$1);
    ((Docking$PBLK12)(CUR$.SL$.SL$)).setFontStyleBoldItalic();
    if(VALUE$(((Docking$PBLK12)(CUR$.SL$.SL$)).DEBUG$2)) {
        {
            sysout().outtext(new TXT$("dLine1="));
            sysout().outint(((Docking$PBLK12$Warehouse)(CUR$.SL$)).dLine1$2,0);
            sysout().outimage();
            sysout().outtext(new TXT$("pPos="));
            sysout().outint(((Docking$PBLK12$Warehouse)(CUR$.SL$)).pPos$2,0);
            sysout().outimage();
            sysout().outtext(new TXT$("uPos="));
            sysout().outint(((Docking$PBLK12$Warehouse)(CUR$.SL$)).uPos$2,0);
            sysout().outimage();
            sysout().outtext(new TXT$("wPos="));
            sysout().outint(((Docking$PBLK12$Warehouse)(CUR$.SL$)).wPos$2,0);
            sysout().outimage();
        }
    }
    new Docking$PBLK12$Warehouse$drawText(((Docking$PBLK12$Warehouse)(CUR$.SL$)),new TXT$("Platform:"),((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$)).pPos$2)),((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$)).dLine1$2-(15)))));
    new Docking$PBLK12$Warehouse$drawText(((Docking$PBLK12$Warehouse)(CUR$.SL$)),new TXT$("Unload:"),((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$)).uPos$2)),((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$)).dLine1$2-(15)))));
    new Docking$PBLK12$Warehouse$drawText(((Docking$PBLK12$Warehouse)(CUR$.SL$)),new TXT$("Wash:"),((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$)).wPos$2)),((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$)).dLine1$2-(15)))));
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure drawMap",1,61,9,62,32,63,34,64,36,65,38,66,40,67,44,68,47,69,49,70,51,71,55,73,57,74,59,75,61,76,66,77,70,78,74,79,80,81,82,82,84,83,88,84);
}
