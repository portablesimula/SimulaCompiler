// JavaLine 1 ==> SourceLine 7
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 05 13:15:10 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ClassGlyph extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=7, lastLine=56, hasLocalClasses=true, System=true
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 42
    ClassGlyph$Glyph rg=null;
    // JavaLine 13 ==> SourceLine 43
    public ARRAY$<ClassGlyph$Glyph[]>rgs=null;
    // Normal Constructor
    public ClassGlyph(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("ClassGlyph");
        // Declaration Code
        TRACE_BEGIN_DCL$("ClassGlyph",43);
        int[] rgs$LB=new int[1]; int[] rgs$UB=new int[1];
        rgs$LB[0]=0; rgs$UB[0]=3;
        BOUND_CHECK$(rgs$LB[0],rgs$UB[0]);
        rgs=new ARRAY$<ClassGlyph$Glyph[]>(new ClassGlyph$Glyph[rgs$UB[0]-rgs$LB[0]+1],rgs$LB,rgs$UB);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("ClassGlyph",43);
        // JavaLine 30 ==> SourceLine 46
        sysout().outtext(new TXT$("***************  MAIN PROGRAM !!!!!!!!!!!!!!!!!!!!!!!!!! "));
        sysout().outimage();
        // JavaLine 33 ==> SourceLine 47
        rgs.Elt[0-rgs.LB[0]]=new ClassGlyph$Char$(((ClassGlyph)CUR$),'A').STM$();
        // JavaLine 35 ==> SourceLine 48
        rgs.Elt[1-rgs.LB[0]]=new ClassGlyph$Char$(((ClassGlyph)CUR$),'b').STM$();
        // JavaLine 37 ==> SourceLine 49
        rgs.Elt[2-rgs.LB[0]]=new ClassGlyph$Char$(((ClassGlyph)CUR$),'b').STM$();
        // JavaLine 39 ==> SourceLine 50
        rgs.Elt[3-rgs.LB[0]]=new ClassGlyph$Char$(((ClassGlyph)CUR$),'a').STM$();
        // JavaLine 41 ==> SourceLine 51
        sysout().outtext(new TXT$("***************  MAIN PROGRAM 22222222222222222222222222 "));
        sysout().outimage();
        // JavaLine 44 ==> SourceLine 52
        rg=new ClassGlyph$Line(((ClassGlyph)CUR$),rgs).STM$();
        // JavaLine 46 ==> SourceLine 53
        sysout().outtext(new TXT$("***************  MAIN PROGRAM 33333333333333333333333333 "));
        sysout().outimage();
        // JavaLine 49 ==> SourceLine 54
        rg.print$0().CPF();
        // JavaLine 51 ==> SourceLine 55
        sysout().outtext(new TXT$("***************  MAIN PROGRAM 44444444444444444444444444 "));
        sysout().outimage();
        TRACE_END_STM$("ClassGlyph",55);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new ClassGlyph(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ClassGlyph.sim","SimulaProgram ClassGlyph",1,7,11,42,13,43,30,46,33,47,35,48,37,49,39,50,41,51,44,52,46,53,49,54,51,55,63,56);
}
