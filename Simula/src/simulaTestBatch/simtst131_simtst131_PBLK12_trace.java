// JavaLine 1 <== SourceLine 22
package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 22 09:53:21 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst131_simtst131_PBLK12_trace extends _PROC {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=22, lastLine=31, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public _TXT p_msg;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public simtst131_simtst131_PBLK12_trace setPar(Object param) {
        //Util.BREAK("CALL simtst131_simtst131_PBLK12_trace.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+_nParLeft+", staticLink="+_SL);
        try {
            switch(_nParLeft--) {
                case 1: p_msg=(_TXT)objectValue(param); break;
                default: throw new _SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new _SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public simtst131_simtst131_PBLK12_trace(_RTObject _SL) {
        super(_SL,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public simtst131_simtst131_PBLK12_trace(_RTObject _SL,_TXT sp_msg) {
        super(_SL);
        // Parameter assignment to locals
        this.p_msg = sp_msg;
        BBLK();
        // Declaration Code
        _STM();
    }
    // Procedure Statements
    public simtst131_simtst131_PBLK12_trace _STM() {
        // JavaLine 38 <== SourceLine 24
        if(_VALUE(false)) {
            {
                sysout().outtext(p_msg);
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        // JavaLine 48 <== SourceLine 25
        if(_VALUE(_TXTREL_NE(p_msg,((simtst131_PBLK12)(_CUR._SL)).facit.Elt[((simtst131_PBLK12)(_CUR._SL)).traceCase_1-((simtst131_PBLK12)(_CUR._SL)).facit.LB[0]]))) {
            // JavaLine 50 <== SourceLine 26
            {
                new SimulaTest_err((_CUR._SL._SL),CONC(new _TXT("Case "),_ENVIRONMENT.edit(((simtst131_PBLK12)(_CUR._SL)).traceCase_1)));
                ;
                // JavaLine 54 <== SourceLine 27
                sysout().outtext(CONC(new _TXT("Trace: "),p_msg));
                ;
                sysout().outimage();
                ;
                // JavaLine 59 <== SourceLine 28
                sysout().outtext(CONC(new _TXT("Facit: "),((simtst131_PBLK12)(_CUR._SL)).facit.Elt[((simtst131_PBLK12)(_CUR._SL)).traceCase_1-((simtst131_PBLK12)(_CUR._SL)).facit.LB[0]]));
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        // JavaLine 67 <== SourceLine 30
        ((simtst131_PBLK12)(_CUR._SL)).traceCase_1=Math.addExact(((simtst131_PBLK12)(_CUR._SL)).traceCase_1,1);
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static _PROGINFO INFO_=new _PROGINFO("simtst131.sim","Procedure trace",1,22,38,24,48,25,50,26,54,27,59,28,67,30,72,31);
} // End of Procedure
