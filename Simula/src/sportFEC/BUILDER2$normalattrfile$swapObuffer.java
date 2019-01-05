// JavaLine 1 ==> SourceLine 518
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$normalattrfile$swapObuffer extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=518, lastLine=524, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public BUILDER2$normalattrfile$swapObuffer(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("swapObuffer",518);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER2$normalattrfile$swapObuffer STM$() {
        TRACE_BEGIN_STM$("swapObuffer",518);
        // JavaLine 23 ==> SourceLine 519
        new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),((BUILDER2$normalattrfile)(CUR$.SL$)).bufSwap);
        // JavaLine 25 ==> SourceLine 520
        storeChar(char$((((BUILDER2$normalattrfile)(CUR$.SL$)).p/(256))),((BUILDER2$normalattrfile)(CUR$.SL$)).attrbuffer,0);
        // JavaLine 27 ==> SourceLine 521
        storeChar(char$(mod(((BUILDER2$normalattrfile)(CUR$.SL$)).p,256)),((BUILDER2$normalattrfile)(CUR$.SL$)).attrbuffer,1);
        // JavaLine 29 ==> SourceLine 522
        ((BUILDER2$normalattrfile)(CUR$.SL$)).AOF.outtext(TXT$.sub(((BUILDER2$normalattrfile)(CUR$.SL$)).attrbuffer,1,((BUILDER2$normalattrfile)(CUR$.SL$)).p));
        // JavaLine 31 ==> SourceLine 523
        ((BUILDER2$normalattrfile)(CUR$.SL$)).p=2;
        TRACE_END_STM$("swapObuffer",523);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Procedure swapObuffer",1,518,23,519,25,520,27,521,29,522,31,523,36,524);
}
