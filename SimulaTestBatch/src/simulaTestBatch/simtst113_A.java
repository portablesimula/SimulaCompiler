// JavaLine 1 <== SourceLine 27
package simulaTestBatch;
// Simula-2.0 Compiled at Thu Sep 07 13:06:06 CEST 2023
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst113_A extends RTS_CLASS {
    // ClassDeclaration: Kind=Class, BlockLevel=2, PrefixLevel=0, firstLine=27, lastLine=34, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 10 <== SourceLine 33
    final RTS_LABEL _LABEL_L2=new RTS_LABEL(this,1,"L2"); // Local Label #1=L2
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 29
    public final RTS_TXT ident=(RTS_TXT)(new RTS_TXT("CLASS A"));
public RTS_PRCQNT S_0(){ throw new RTS_SimulaRuntimeError("No Virtual Match: S"); }
public RTS_PRCQNT P_0(){ throw new RTS_SimulaRuntimeError("No Virtual Match: P"); }
    // Normal Constructor
    public simtst113_A(RTS_RTObject staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
    }
    // Class Statements
    @Override
    public simtst113_A _STM() {
        simtst113_A _THIS=(simtst113_A)_CUR;
        _LOOP:while(_JTX>=0) {
            try {
                _JUMPTABLE(_JTX,1); // For ByteCode Engineering
                // Class A: Code before inner
                RTS_COMMON._LINE("Class simtst113.A",30); // JavaLine 32 <== SourceLine 30
                new simtst113_trace((_CUR._SL),new RTS_TXT("In A before inner"));
                ;
                RTS_COMMON._LINE("Class simtst113.A",31); // JavaLine 35 <== SourceLine 31
            _GOTO(((RTS_LABEL)(((simtst113_A)(_CUR)).S_0().CPF().setPar(new RTS_NAME<Integer>(){ public Integer get() { return(2); } })._ENT()._RESULT()))); // GOTO EVALUATED LABEL
                ;
                RTS_COMMON._LINE("Class simtst113.A",33); // JavaLine 38 <== SourceLine 33
                // Class A: Code after inner
                RTS_COMMON._LINE("Class simtst113.A",32); // JavaLine 40 <== SourceLine 32
                ;
                RTS_COMMON._LINE("Class simtst113.A",33); // JavaLine 42 <== SourceLine 33
                {
                    _SIM_LABEL(1);
                    new simtst113_trace((_CUR._SL),new RTS_TXT("In A after inner"));
                }
                ;
                break _LOOP;
            }
            catch(RTS_LABEL q) {
                _CUR=_THIS;
                if(q._SL!=_CUR) {
                    if(RTS_COMMON.Option.GOTO_TRACING) TRACE_GOTO("A:NON-LOCAL",q);
                    _CUR._STATE=OperationalState.terminated;
                    if(RTS_COMMON.Option.GOTO_TRACING) TRACE_GOTO("A:RE-THROW",q);
                    throw(q);
                }
                if(RTS_COMMON.Option.GOTO_TRACING) TRACE_GOTO("A:LOCAL",q);
                _JTX=q.index; continue _LOOP; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Class Statements
    public static RTS_PROGINFO _INFO=new RTS_PROGINFO("simtst113.sim","Class A",1,27,10,33,13,29,32,30,35,31,38,33,40,32,42,33,64,34);
} // End of Class
