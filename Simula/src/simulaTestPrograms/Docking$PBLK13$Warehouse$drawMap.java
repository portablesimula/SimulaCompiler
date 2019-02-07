// JavaLine 1 ==> SourceLine 44
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:37:33 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK13$Warehouse$drawMap extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=44, lastLine=65, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$nr;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 45
    int psl=0;
    int dLine=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public Docking$PBLK13$Warehouse$drawMap setPar(Object param) {
        //Util.BREAK("CALL Docking$PBLK13$Warehouse$drawMap.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public Docking$PBLK13$Warehouse$drawMap(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public Docking$PBLK13$Warehouse$drawMap(RTObject$ SL$,int sp$nr) {
        super(SL$);
        // Parameter assignment to locals
        this.p$nr = sp$nr;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("drawMap",45);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Docking$PBLK13$Warehouse$drawMap STM$() {
        TRACE_BEGIN_STM$("drawMap",45);
        // JavaLine 44 ==> SourceLine 46
        ((Docking$PBLK13)(CUR$.SL$.SL$)).setFillColor(((Docking$PBLK13)(CUR$.SL$.SL$)).cyan);
        // JavaLine 46 ==> SourceLine 47
        new Docking$PBLK13$Warehouse$FillSquare(((Docking$PBLK13$Warehouse)(CUR$.SL$)),((double)(2)),((double)(22)),((double)(21)),((double)(4)));
        // JavaLine 48 ==> SourceLine 48
        new Docking$PBLK13$Warehouse$FillSquare(((Docking$PBLK13$Warehouse)(CUR$.SL$)),((double)(2)),((double)(26)),((double)(4)),((double)(100)));
        // JavaLine 50 ==> SourceLine 49
        new Docking$PBLK13$Warehouse$FillSquare(((Docking$PBLK13$Warehouse)(CUR$.SL$)),((double)(19)),((double)(26)),((double)(4)),((double)(100)));
        // JavaLine 52 ==> SourceLine 50
        for(boolean CB$50:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){psl=(int)x$; return(x$);};  public Number get(){return((Number)psl); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(p$nr); }})
           )) { if(!CB$50) continue;
        // JavaLine 56 ==> SourceLine 51
        {
            TRACE_BEGIN_STM$("CompoundStatement51",51);
            dLine=(((Docking$PBLK13$Warehouse)(CUR$.SL$)).dLine1+(((psl-(1))*(20))));
            // JavaLine 60 ==> SourceLine 52
            new Docking$PBLK13$Warehouse$FillSquare(((Docking$PBLK13$Warehouse)(CUR$.SL$)),((double)((dLine-(8)))),((double)(32)),((double)(21)),((double)(4)));
            // JavaLine 62 ==> SourceLine 53
            new Docking$PBLK13$Warehouse$FillSquare(((Docking$PBLK13$Warehouse)(CUR$.SL$)),((double)((dLine-(8)))),((double)(36)),((double)(4)),((double)(240)));
            // JavaLine 64 ==> SourceLine 54
            new Docking$PBLK13$Warehouse$FillSquare(((Docking$PBLK13$Warehouse)(CUR$.SL$)),((double)(((dLine+(4))+(((Docking$PBLK13$Warehouse)(CUR$.SL$)).vanWidth)))),((double)(36)),((double)(4)),((double)(240)));
            TRACE_END_STM$("CompoundStatement51",54);
        }
    }
    // JavaLine 69 ==> SourceLine 56
    ((Docking$PBLK13)(CUR$.SL$.SL$)).setDrawColor(((Docking$PBLK13)(CUR$.SL$.SL$)).orange);
    // JavaLine 71 ==> SourceLine 57
    ((Docking$PBLK13)(CUR$.SL$.SL$)).setFontStyleBoldItalic();
    // JavaLine 73 ==> SourceLine 58
    sysout().outtext(new TXT$("dLine1="));
    sysout().outint(((Docking$PBLK13$Warehouse)(CUR$.SL$)).dLine1,0);
    sysout().outimage();
    // JavaLine 77 ==> SourceLine 59
    sysout().outtext(new TXT$("pPos="));
    sysout().outint(((Docking$PBLK13$Warehouse)(CUR$.SL$)).pPos,0);
    sysout().outimage();
    // JavaLine 81 ==> SourceLine 60
    sysout().outtext(new TXT$("uPos="));
    sysout().outint(((Docking$PBLK13$Warehouse)(CUR$.SL$)).uPos,0);
    sysout().outimage();
    // JavaLine 85 ==> SourceLine 61
    sysout().outtext(new TXT$("wPos="));
    sysout().outint(((Docking$PBLK13$Warehouse)(CUR$.SL$)).wPos,0);
    sysout().outimage();
    // JavaLine 89 ==> SourceLine 62
    new Docking$PBLK13$Warehouse$drawText(((Docking$PBLK13$Warehouse)(CUR$.SL$)),new TXT$("Platform:"),((double)(((Docking$PBLK13$Warehouse)(CUR$.SL$)).pPos)),((double)(60)));
    // JavaLine 91 ==> SourceLine 63
    new Docking$PBLK13$Warehouse$drawText(((Docking$PBLK13$Warehouse)(CUR$.SL$)),new TXT$("Unload:"),((double)(((Docking$PBLK13$Warehouse)(CUR$.SL$)).uPos)),((double)(60)));
    // JavaLine 93 ==> SourceLine 64
    new Docking$PBLK13$Warehouse$drawText(((Docking$PBLK13$Warehouse)(CUR$.SL$)),new TXT$("Wash:"),((double)(((Docking$PBLK13$Warehouse)(CUR$.SL$)).wPos)),((double)(60)));
    TRACE_END_STM$("drawMap",64);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure drawMap",1,44,12,45,44,46,46,47,48,48,50,49,52,50,56,51,60,52,62,53,64,54,69,56,71,57,73,58,77,59,81,60,85,61,89,62,91,63,93,64,98,65);
}
