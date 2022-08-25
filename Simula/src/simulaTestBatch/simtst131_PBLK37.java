package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 22 09:53:21 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst131_PBLK37 extends _CatchingErrors {
    // PrefixedBlockDeclaration: Kind=PrefixedBlock, BlockLevel=5, firstLine=37, lastLine=43, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    // Declare locals as attributes
    public _PRCQNT onError_0() { return(new _PRCQNT(this,simtst131_simtst131_PBLK12_P_Q_simtst131_PBLK37_onError.class)); }
    // Normal Constructor
    public simtst131_PBLK37(_RTObject staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
    }
    // Class Statements
    public simtst131_PBLK37 _STM() {
        // Class CatchingErrors: Code before inner
        // JavaLine 19 <== SourceLine 1
        try {
            // Class simtst131_PBLK37: Code before inner
            ((simtst131_PBLK12)(_CUR._SL._SL._SL)).bf_1.inbyte();
            ;
            // Class CatchingErrors: Code after inner
            // JavaLine 25 <== SourceLine 1
        } catch(RuntimeException e) { _CUR=this; _onError(e,onError_0()); }
        // JavaLine 27 <== SourceLine 42
        EBLK();
        return(this);
    } // End of Class Statements
    public static _PROGINFO INFO_=new _PROGINFO("simtst131.sim","PrefixedBlock simtst131_PBLK37",19,1,25,1,27,42,30,43);
} // End of Class
