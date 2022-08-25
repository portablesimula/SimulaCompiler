// JavaLine 1 <== SourceLine 38
package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 22 09:53:21 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst131_simtst131_PBLK12_P_Q_simtst131_PBLK37_onError extends _PROC {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=6, firstLine=38, lastLine=41, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public _TXT p_message;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public simtst131_simtst131_PBLK12_P_Q_simtst131_PBLK37_onError setPar(Object param) {
        //Util.BREAK("CALL simtst131_simtst131_PBLK12_P_Q_simtst131_PBLK37_onError.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+_nParLeft+", staticLink="+_SL);
        try {
            switch(_nParLeft--) {
                case 1: p_message=(_TXT)objectValue(param); break;
                default: throw new _SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new _SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public simtst131_simtst131_PBLK12_P_Q_simtst131_PBLK37_onError(_RTObject _SL) {
        super(_SL,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public simtst131_simtst131_PBLK12_P_Q_simtst131_PBLK37_onError(_RTObject _SL,_TXT sp_message) {
        super(_SL);
        // Parameter assignment to locals
        this.p_message = sp_message;
        BBLK();
        // Declaration Code
        _STM();
    }
    // Procedure Statements
    public simtst131_simtst131_PBLK12_P_Q_simtst131_PBLK37_onError _STM() {
        // JavaLine 38 <== SourceLine 39
        new simtst131_simtst131_PBLK12_trace((_CUR._SL._SL._SL._SL),CONC(new _TXT("DEEP Inside onError: "),p_message));
        ;
        // JavaLine 41 <== SourceLine 40
        _GOTO(((simtst131_PBLK12)(_CUR._SL._SL._SL._SL))._LABELLAB4); // GOTO EVALUATED LABEL
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static _PROGINFO INFO_=new _PROGINFO("simtst131.sim","Procedure onError",1,38,38,39,41,40,46,41);
} // End of Procedure
