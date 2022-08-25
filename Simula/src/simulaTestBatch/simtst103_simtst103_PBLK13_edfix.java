// JavaLine 1 <== SourceLine 20
package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 22 09:22:47 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst103_simtst103_PBLK13_edfix extends _PROC {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=20, lastLine=21, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public _TXT _RESULT;
    public Object _RESULT() { return(_RESULT); }
    // Declare parameters as attributes
    public float p_r;
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 21
    public _TXT t=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public simtst103_simtst103_PBLK13_edfix setPar(Object param) {
        //Util.BREAK("CALL simtst103_simtst103_PBLK13_edfix.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+_nParLeft+", staticLink="+_SL);
        try {
            switch(_nParLeft--) {
                case 1: p_r=floatValue(param); break;
                default: throw new _SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new _SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public simtst103_simtst103_PBLK13_edfix(_RTObject _SL) {
        super(_SL,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public simtst103_simtst103_PBLK13_edfix(_RTObject _SL,float sp_r) {
        super(_SL);
        // Parameter assignment to locals
        this.p_r = sp_r;
        BBLK();
        // Declaration Code
        _STM();
    }
    // Procedure Statements
    public simtst103_simtst103_PBLK13_edfix _STM() {
        t=_ENVIRONMENT.blanks(6);
        ;
        _TXT.putfix(t,p_r,2);
        ;
        _RESULT=t;
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static _PROGINFO INFO_=new _PROGINFO("simtst103.sim","Procedure edfix",1,20,14,21,51,21);
} // End of Procedure
