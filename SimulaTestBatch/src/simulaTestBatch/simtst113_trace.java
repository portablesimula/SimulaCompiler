// JavaLine 1 <== SourceLine 15
package simulaTestBatch;
// Simula-2.0 Compiled at Thu Sep 07 13:06:06 CEST 2023
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst113_trace extends RTS_PROCEDURE {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=15, lastLine=24, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public RTS_TXT p_msg;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    @Override
    public simtst113_trace setPar(Object param) {
        try {
            switch(_nParLeft--) {
                case 1: p_msg=(RTS_TXT)objectValue(param); break;
                default: throw new RTS_SimulaRuntimeError("Too many parameters");
            }
        }
    catch(ClassCastException e) { throw new RTS_SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public simtst113_trace(RTS_RTObject _SL) {
        super(_SL,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public simtst113_trace(RTS_RTObject _SL,RTS_TXT sp_msg) {
        super(_SL);
        // Parameter assignment to locals
        this.p_msg = sp_msg;
        BBLK();
        // Declaration Code
        _STM();
    }
    // Procedure Statements
    @Override
    public simtst113_trace _STM() {
        RTS_COMMON._LINE("Procedure simtst113.trace",17); // JavaLine 39 <== SourceLine 17
        if(_VALUE(false)) {
            {
                sysout().outtext(p_msg);
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        RTS_COMMON._LINE("Procedure simtst113.trace",18); // JavaLine 49 <== SourceLine 18
        if(_VALUE(_TXTREL_NE(p_msg,((simtst113)(_CUR._SL)).facit.getELEMENT(((simtst113)(_CUR._SL)).traceCase_1)))) {
            {
                RTS_COMMON._LINE("Procedure simtst113.trace",19); // JavaLine 52 <== SourceLine 19
                new SimulaTest_err((_CUR._SL),CONC(new RTS_TXT("Case "),RTS_ENVIRONMENT.edit(((simtst113)(_CUR._SL)).traceCase_1)));
                ;
                RTS_COMMON._LINE("Procedure simtst113.trace",20); // JavaLine 55 <== SourceLine 20
                sysout().outtext(CONC(new RTS_TXT("Trace: "),p_msg));
                ;
                sysout().outimage();
                ;
                RTS_COMMON._LINE("Procedure simtst113.trace",21); // JavaLine 60 <== SourceLine 21
                sysout().outtext(CONC(new RTS_TXT("Facit: "),((simtst113)(_CUR._SL)).facit.getELEMENT(((simtst113)(_CUR._SL)).traceCase_1)));
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        RTS_COMMON._LINE("Procedure simtst113.trace",23); // JavaLine 68 <== SourceLine 23
        ((simtst113)(_CUR._SL)).traceCase_1=(((simtst113)(_CUR._SL)).traceCase_1+(1));
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static RTS_PROGINFO _INFO=new RTS_PROGINFO("simtst113.sim","Procedure trace",1,15,39,17,49,18,52,19,55,20,60,21,68,23,73,24);
} // End of Procedure
