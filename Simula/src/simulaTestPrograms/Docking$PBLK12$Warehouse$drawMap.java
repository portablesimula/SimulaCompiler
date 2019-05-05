// JavaLine 1 <== SourceLine 61
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:36:39 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK12$Warehouse$drawMap extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=61, lastLine=84, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$nr;
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 62
    int psl=0;
    int dLine=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public Docking$PBLK12$Warehouse$drawMap setPar(Object param) {
        //Util.BREAK("CALL Docking$PBLK12$Warehouse$drawMap.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$nr=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Docking$PBLK12$Warehouse$drawMap(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public Docking$PBLK12$Warehouse$drawMap(RTObject$ SL$,int sp$nr) {
        super(SL$);
        // Parameter assignment to locals
        this.p$nr = sp$nr;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("drawMap",62);
        STM$();
    }
    // Procedure Statements
    public Docking$PBLK12$Warehouse$drawMap STM$() {
        TRACE_BEGIN_STM$("drawMap",62);
        // JavaLine 44 <== SourceLine 63
        ((Docking$PBLK12)(CUR$.SL$.SL$)).setFillColor(((Docking$PBLK12)(CUR$.SL$.SL$)).cyan$1);
        // JavaLine 46 <== SourceLine 64
        new Docking$PBLK12$Warehouse$FillSquare(((Docking$PBLK12$Warehouse)(CUR$.SL$)),((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$)).qLine$2-(8)))),((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$)).qPos$2-(8)))),((double)((16+(((Docking$PBLK12$Warehouse)(CUR$.SL$)).vanWidth$2)))),((double)(4)));
        // JavaLine 48 <== SourceLine 65
        new Docking$PBLK12$Warehouse$FillSquare(((Docking$PBLK12$Warehouse)(CUR$.SL$)),((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$)).qLine$2-(8)))),((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$)).qPos$2-(4)))),((double)(4)),((double)(100)));
        // JavaLine 50 <== SourceLine 66
        new Docking$PBLK12$Warehouse$FillSquare(((Docking$PBLK12$Warehouse)(CUR$.SL$)),((double)(((((Docking$PBLK12$Warehouse)(CUR$.SL$)).qLine$2+(4))+(((Docking$PBLK12$Warehouse)(CUR$.SL$)).vanWidth$2)))),((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$)).qPos$2-(4)))),((double)(4)),((double)(100)));
        // JavaLine 52 <== SourceLine 67
        for(boolean CB$67:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){psl=(int)x$; return(x$);};  public Number get(){return((Number)psl); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(p$nr); }})
           )) { if(!CB$67) continue;
        // JavaLine 56 <== SourceLine 68
        {
            TRACE_BEGIN_STM$("CompoundStatement68",68);
            dLine=(((Docking$PBLK12$Warehouse)(CUR$.SL$)).dLine1$2+(((psl-(1))*(20))));
            // JavaLine 60 <== SourceLine 69
            new Docking$PBLK12$Warehouse$FillSquare(((Docking$PBLK12$Warehouse)(CUR$.SL$)),((double)((dLine-(8)))),((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$)).pPos$2-(8)))),((double)((16+(((Docking$PBLK12$Warehouse)(CUR$.SL$)).vanWidth$2)))),((double)(4)));
            // JavaLine 62 <== SourceLine 70
            new Docking$PBLK12$Warehouse$FillSquare(((Docking$PBLK12$Warehouse)(CUR$.SL$)),((double)((dLine-(8)))),((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$)).pPos$2-(4)))),((double)(4)),((double)(240)));
            // JavaLine 64 <== SourceLine 71
            new Docking$PBLK12$Warehouse$FillSquare(((Docking$PBLK12$Warehouse)(CUR$.SL$)),((double)(((dLine+(4))+(((Docking$PBLK12$Warehouse)(CUR$.SL$)).vanWidth$2)))),((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$)).pPos$2-(4)))),((double)(4)),((double)(240)));
            TRACE_END_STM$("CompoundStatement68",71);
        }
    }
    // JavaLine 69 <== SourceLine 73
    ((Docking$PBLK12)(CUR$.SL$.SL$)).setDrawColor(((Docking$PBLK12)(CUR$.SL$.SL$)).orange$1);
    // JavaLine 71 <== SourceLine 74
    ((Docking$PBLK12)(CUR$.SL$.SL$)).setFontStyleBoldItalic();
    // JavaLine 73 <== SourceLine 75
    if(VALUE$(((Docking$PBLK12)(CUR$.SL$.SL$)).DEBUG$2)) {
        // JavaLine 75 <== SourceLine 76
        {
            TRACE_BEGIN_STM$("CompoundStatement76",76);
            sysout().outtext(new TXT$("dLine1="));
            sysout().outint(((Docking$PBLK12$Warehouse)(CUR$.SL$)).dLine1$2,0);
            sysout().outimage();
            // JavaLine 81 <== SourceLine 77
            sysout().outtext(new TXT$("pPos="));
            sysout().outint(((Docking$PBLK12$Warehouse)(CUR$.SL$)).pPos$2,0);
            sysout().outimage();
            // JavaLine 85 <== SourceLine 78
            sysout().outtext(new TXT$("uPos="));
            sysout().outint(((Docking$PBLK12$Warehouse)(CUR$.SL$)).uPos$2,0);
            sysout().outimage();
            // JavaLine 89 <== SourceLine 79
            sysout().outtext(new TXT$("wPos="));
            sysout().outint(((Docking$PBLK12$Warehouse)(CUR$.SL$)).wPos$2,0);
            sysout().outimage();
            TRACE_END_STM$("CompoundStatement76",79);
        }
    }
    // JavaLine 96 <== SourceLine 81
    new Docking$PBLK12$Warehouse$drawText(((Docking$PBLK12$Warehouse)(CUR$.SL$)),new TXT$("Platform:"),((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$)).pPos$2)),((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$)).dLine1$2-(15)))));
    // JavaLine 98 <== SourceLine 82
    new Docking$PBLK12$Warehouse$drawText(((Docking$PBLK12$Warehouse)(CUR$.SL$)),new TXT$("Unload:"),((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$)).uPos$2)),((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$)).dLine1$2-(15)))));
    // JavaLine 100 <== SourceLine 83
    new Docking$PBLK12$Warehouse$drawText(((Docking$PBLK12$Warehouse)(CUR$.SL$)),new TXT$("Wash:"),((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$)).wPos$2)),((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$)).dLine1$2-(15)))));
    TRACE_END_STM$("drawMap",83);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure drawMap",1,61,12,62,44,63,46,64,48,65,50,66,52,67,56,68,60,69,62,70,64,71,69,73,71,74,73,75,75,76,81,77,85,78,89,79,96,81,98,82,100,83,105,84);
} // End of Procedure
