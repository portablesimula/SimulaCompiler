// JavaLine 1 <== SourceLine 23
package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 22 09:22:47 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst103_simtst103_PBLK13_trace extends _PROC {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=23, lastLine=36, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public _TXT p_msg;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 24
    public simtst103_simtst103_PBLK13_Car XXX=null;
    // JavaLine 13 <== SourceLine 25
    public _TXT case1=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public simtst103_simtst103_PBLK13_trace setPar(Object param) {
        //Util.BREAK("CALL simtst103_simtst103_PBLK13_trace.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+_nParLeft+", staticLink="+_SL);
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
    public simtst103_simtst103_PBLK13_trace(_RTObject _SL) {
        super(_SL,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public simtst103_simtst103_PBLK13_trace(_RTObject _SL,_TXT sp_msg) {
        super(_SL);
        // Parameter assignment to locals
        this.p_msg = sp_msg;
        BBLK();
        // Declaration Code
        _STM();
    }
    // Procedure Statements
    public simtst103_simtst103_PBLK13_trace _STM() {
        // JavaLine 42 <== SourceLine 26
        case1=CONC(CONC(new simtst103_simtst103_PBLK13_edfix((_CUR._SL),((float)(((simtst103_PBLK13)(_CUR._SL)).time())))._RESULT,new _TXT(": ")),p_msg);
        ;
        // JavaLine 45 <== SourceLine 27
        if(_VALUE(false)) {
            {
                sysout().outtext(case1);
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        // JavaLine 55 <== SourceLine 28
        if(_VALUE(_TXTREL_NE(case1,((simtst103_PBLK13)(_CUR._SL)).facit.Elt[((simtst103_PBLK13)(_CUR._SL)).traceCase_2-((simtst103_PBLK13)(_CUR._SL)).facit.LB[0]]))) {
            // JavaLine 57 <== SourceLine 29
            {
                // JavaLine 59 <== SourceLine 30
                new SimulaTest_err((_CUR._SL._SL),CONC(new _TXT("Case "),new simtst103_simtst103_PBLK13_edfix((_CUR._SL),((float)(((simtst103_PBLK13)(_CUR._SL)).traceCase_2)))._RESULT));
                ;
                // JavaLine 62 <== SourceLine 31
                sysout().outtext(CONC(new _TXT("Trace: "),case1));
                ;
                sysout().outimage();
                ;
                // JavaLine 67 <== SourceLine 32
                sysout().outtext(CONC(new _TXT("Facit: "),((simtst103_PBLK13)(_CUR._SL)).facit.Elt[((simtst103_PBLK13)(_CUR._SL)).traceCase_2-((simtst103_PBLK13)(_CUR._SL)).facit.LB[0]]));
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        // JavaLine 75 <== SourceLine 34
        ((simtst103_PBLK13)(_CUR._SL)).traceCase_2=Math.addExact(((simtst103_PBLK13)(_CUR._SL)).traceCase_2,1);
        ;
        // JavaLine 78 <== SourceLine 35
        sysout().outtext(XXX.p3_id);
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static _PROGINFO INFO_=new _PROGINFO("simtst103.sim","Procedure trace",1,23,11,24,13,25,42,26,45,27,55,28,57,29,59,30,62,31,67,32,75,34,78,35,83,36);
} // End of Procedure
