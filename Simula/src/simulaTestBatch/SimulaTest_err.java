// JavaLine 1 <== SourceLine 10
package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 22 09:53:21 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SimulaTest_err extends _PROC {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=10, lastLine=14, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public _TXT p_t;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public SimulaTest_err setPar(Object param) {
        //Util.BREAK("CALL SimulaTest_err.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+_nParLeft+", staticLink="+_SL);
        try {
            switch(_nParLeft--) {
                case 1: p_t=(_TXT)objectValue(param); break;
                default: throw new _SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new _SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public SimulaTest_err(_RTObject _SL) {
        super(_SL,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public SimulaTest_err(_RTObject _SL,_TXT sp_t) {
        super(_SL);
        // Parameter assignment to locals
        this.p_t = sp_t;
        BBLK();
        // Declaration Code
        _STM();
    }
    // Procedure Statements
    public SimulaTest_err _STM() {
        // JavaLine 38 <== SourceLine 11
        sysout().setpos(1);
        ;
        // JavaLine 41 <== SourceLine 12
        sysout().outtext(new _TXT("*** error: in test "));
        ;
        sysout().outtext(p_t);
        ;
        sysout().outimage();
        ;
        // JavaLine 48 <== SourceLine 13
        ((SimulaTest)(_CUR._SL)).found_error=true;
        ;
        ((SimulaTest)(_CUR._SL)).nFailed=Math.addExact(((SimulaTest)(_CUR._SL)).nFailed,1);
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static _PROGINFO INFO_=new _PROGINFO("SimulaTest.sim","Procedure err",1,10,38,11,41,12,48,13,55,14);
} // End of Procedure
