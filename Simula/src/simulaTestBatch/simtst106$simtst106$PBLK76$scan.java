// JavaLine 1 ==> SourceLine 142
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon Mar 18 11:16:18 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst106$simtst106$PBLK76$scan extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=142, lastLine=145, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public simtst106$simtst106$PBLK76$scan(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("scan",142);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst106$simtst106$PBLK76$scan STM$() {
        TRACE_BEGIN_STM$("scan",142);
        // JavaLine 23 ==> SourceLine 143
        for(boolean CB$143:new ForList(
            new WhileElt<Character>(new NAME$<Character>(){ public Character put(Character x$){((simtst106$PBLK76)(CUR$.SL$)).ch=(char)x$; return(x$);};  public Character get(){return((Character)((simtst106$PBLK76)(CUR$.SL$)).ch); }	},new NAME$<Character>() { public Character get(){return(((simtst106)(CUR$.SL$.SL$)).inspect$20$0.inchar()); }},new NAME$<Boolean>() { public Boolean get(){return(((simtst106$PBLK76)(CUR$.SL$)).ch==(((char)32))); }})
           )) { if(!CB$143) continue;
    }
    // JavaLine 28 ==> SourceLine 144
    ((simtst106)(CUR$.SL$.SL$)).inspect$20$0.setpos((((simtst106)(CUR$.SL$.SL$)).inspect$20$0.pos()-(1)));
    TRACE_END_STM$("scan",144);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("simtst106.sim","Procedure scan",1,142,23,143,28,144,33,145);
}
