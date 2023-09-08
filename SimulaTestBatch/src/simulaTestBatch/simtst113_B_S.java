// JavaLine 1 <== SourceLine 38
package simulaTestBatch;
// Simula-2.0 Compiled at Thu Sep 07 13:06:06 CEST 2023
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst113_B_S extends RTS_PROCEDURE {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=38, lastLine=0, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public RTS_LABEL _RESULT;
    @Override
public Object _RESULT() { return(_RESULT); }
    // Declare parameters as attributes
    public int p__SW;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    @Override
    public simtst113_B_S setPar(Object param) {
        try {
            switch(_nParLeft--) {
                case 1: p__SW=intValue(param); break;
                default: throw new RTS_SimulaRuntimeError("Too many parameters");
            }
        }
    catch(ClassCastException e) { throw new RTS_SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public simtst113_B_S(RTS_RTObject _SL) {
        super(_SL,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public simtst113_B_S(RTS_RTObject _SL,int sp__SW) {
        super(_SL);
        // Parameter assignment to locals
        this.p__SW = sp__SW;
        BBLK();
        // Declaration Code
        _STM();
    }
    // Switch Body
    @Override
    public simtst113_B_S _STM() {
        switch(p__SW-1) {
            case 0: _RESULT=((simtst113_B)(_CUR._SL))._LABEL_L2; break;
            case 1: _RESULT=((simtst113_B)(_CUR._SL))._LABEL_L; break;
            default: throw new RTS_SimulaRuntimeError("Illegal switch index: "+p__SW);
        }
        EBLK();
        return(this);
    } // End of Switch BODY
    public static RTS_PROGINFO _INFO=new RTS_PROGINFO("simtst113.sim","Procedure S",1,38,50,0);
} // End of Procedure
