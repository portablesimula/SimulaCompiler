package simulaTestBatch;
// Simula-2.0 Compiled at Sat Aug 20 06:39:17 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SimulaTest_err extends _PROC {
    public _TXT p_t;
    public SimulaTest_err setPar(Object param) {
        try {
            switch(_nParLeft--) {
                case 1: p_t=(_TXT)objectValue(param); break;
                default: throw new _SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new _SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public SimulaTest_err(_RTObject _SL) {
        super(_SL,1);
    }
    public SimulaTest_err(_RTObject _SL,_TXT sp_t) {
        super(_SL);
        this.p_t = sp_t;
        BBLK();
        _STM();
    }
    public SimulaTest_err _STM() {
        sysout().setpos(1);
        ;
        sysout().outtext(new _TXT("*** error: in test "));
        ;
        sysout().outtext(p_t);
        ;
        sysout().outimage();
        ;
        ((SimulaTest)(_CUR._SL)).found_error=true;
        ;
        ((SimulaTest)(_CUR._SL)).nFailed=Math.addExact(((SimulaTest)(_CUR._SL)).nFailed,1);
        ;
        EBLK();
        return(this);
    }
    public static _PROGINFO INFO_=new _PROGINFO("SimulaTest.sim","Procedure err",1,10,28,11,31,12,38,13,45,14);
}
