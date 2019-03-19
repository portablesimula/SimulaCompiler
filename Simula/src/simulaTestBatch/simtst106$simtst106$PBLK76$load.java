// JavaLine 1 ==> SourceLine 147
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon Mar 18 11:16:18 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst106$simtst106$PBLK76$load extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=147, lastLine=152, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public simtst106$simtst106$PBLK76$load(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("load",147);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst106$simtst106$PBLK76$load STM$() {
        TRACE_BEGIN_STM$("load",147);
        // JavaLine 23 ==> SourceLine 148
        ((simtst106$PBLK76)(CUR$.SL$)).t=blanks(100);
        // JavaLine 25 ==> SourceLine 149
        for(boolean CB$149:new ForList(
            new WhileElt<Character>(new NAME$<Character>(){ public Character put(Character x$){((simtst106$PBLK76)(CUR$.SL$)).ch=(char)x$; return(x$);};  public Character get(){return((Character)((simtst106$PBLK76)(CUR$.SL$)).ch); }	},new NAME$<Character>() { public Character get(){return(((simtst106)(CUR$.SL$.SL$)).inspect$20$0.inchar()); }},new NAME$<Boolean>() { public Boolean get(){return(((simtst106$PBLK76)(CUR$.SL$)).ch!=(((char)32))); }})
           )) { if(!CB$149) continue;
        TXT$.putchar(((simtst106$PBLK76)(CUR$.SL$)).t,((simtst106$PBLK76)(CUR$.SL$)).ch);
    }
    // JavaLine 31 ==> SourceLine 150
    TXT$.setpos(((simtst106$PBLK76)(CUR$.SL$)).t,1);
    // JavaLine 33 ==> SourceLine 151
    sysout().outtext(CONC(new TXT$("LOAD: "),copy(copy(((simtst106$PBLK76)(CUR$.SL$)).t))));
    new simtst106$simtst106$PBLK76$Outimage(((simtst106$PBLK76)(CUR$.SL$)));
    TRACE_END_STM$("load",151);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("simtst106.sim","Procedure load",1,147,23,148,25,149,31,150,33,151,39,152);
}
