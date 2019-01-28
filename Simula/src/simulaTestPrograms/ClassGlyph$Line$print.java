// JavaLine 1 ==> SourceLine 26
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Jan 26 17:56:49 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ClassGlyph$Line$print extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=26, lastLine=36, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 28
    int i=0;
    // Normal Constructor
    public ClassGlyph$Line$print(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("print",28);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ClassGlyph$Line$print STM$() {
        TRACE_BEGIN_STM$("print",28);
        // JavaLine 25 ==> SourceLine 29
        sysout().outtext(new TXT$("***************  Line.print  "));
        sysout().outimage();
        // JavaLine 28 ==> SourceLine 30
        i=upperbound(((ClassGlyph$Line)(CUR$.SL$)).p1$elements,1);
        // JavaLine 30 ==> SourceLine 31
        ((ARRAY$<ClassGlyph$Glyph[]>)((ClassGlyph$Line)(CUR$.SL$)).p1$elements).Elt[i-((ClassGlyph$Line)(CUR$.SL$)).p1$elements.LB[0]].print$0().CPF();
        // JavaLine 32 ==> SourceLine 33
        for(boolean CB$33:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(upperbound(((ClassGlyph$Line)(CUR$.SL$)).p1$elements,1)); }})
           )) { if(!CB$33) continue;
        // JavaLine 36 ==> SourceLine 34
        ((ARRAY$<ClassGlyph$Glyph[]>)((ClassGlyph$Line)(CUR$.SL$)).p1$elements).Elt[i-((ClassGlyph$Line)(CUR$.SL$)).p1$elements.LB[0]].print$0().CPF();
    }
    // JavaLine 39 ==> SourceLine 35
    sysout().outimage();
    TRACE_END_STM$("print",35);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("ClassGlyph.sim","Procedure print",1,26,11,28,25,29,28,30,30,31,32,33,36,34,39,35,44,36);
}
