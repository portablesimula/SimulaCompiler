// JavaLine 1 <== SourceLine 36
package simulaTestBatch;
// Simula-2.0 Compiled at Thu Sep 07 13:06:06 CEST 2023
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst113_B extends simtst113_A {
    // ClassDeclaration: Kind=Class, BlockLevel=2, PrefixLevel=1, firstLine=36, lastLine=44, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 10 <== SourceLine 41
    final RTS_LABEL _LABEL_L=new RTS_LABEL(this,2,"L"); // Local Label #2=L
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 39
    public final RTS_TXT ident_1=(RTS_TXT)(new RTS_TXT("CLASS B"));
public RTS_PRCQNT S_0() { return(new RTS_PRCQNT(this,simtst113_B_S.class)); }
    // Normal Constructor
    public simtst113_B(RTS_RTObject staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
    }
    // Class Statements
    @Override
    public simtst113_B _STM() {
        simtst113_B _THIS=(simtst113_B)_CUR;
        _LOOP:while(_JTX>=0) {
            try {
                _JUMPTABLE(_JTX,2); // For ByteCode Engineering
                // Class A: Code before inner
                RTS_COMMON._LINE("Class simtst113.A",30); // JavaLine 30 <== SourceLine 30
                new simtst113_trace((_CUR._SL),new RTS_TXT("In A before inner"));
                ;
                RTS_COMMON._LINE("Class simtst113.A",31); // JavaLine 33 <== SourceLine 31
            _GOTO(((RTS_LABEL)(((simtst113_A)(_CUR)).S_0().CPF().setPar(new RTS_NAME<Integer>(){ public Integer get() { return(2); } })._ENT()._RESULT()))); // GOTO EVALUATED LABEL
                ;
                // Class B: Code before inner
                RTS_COMMON._LINE("Class simtst113.B",40); // JavaLine 37 <== SourceLine 40
                new simtst113_trace((_CUR._SL),new RTS_TXT("In B before inner"));
                ;
                RTS_COMMON._LINE("Class simtst113.B",41); // JavaLine 40 <== SourceLine 41
                {
                    _SIM_LABEL(2);
                    new simtst113_trace((_CUR._SL),new RTS_TXT("At Label L - OK"));
                }
                ;
                RTS_COMMON._LINE("Class simtst113.B",43); // JavaLine 46 <== SourceLine 43
                // Class B: Code after inner
                RTS_COMMON._LINE("Class simtst113.B",42); // JavaLine 48 <== SourceLine 42
                ;
                RTS_COMMON._LINE("Class simtst113.B",43); // JavaLine 50 <== SourceLine 43
                new simtst113_trace((_CUR._SL),new RTS_TXT("In B after inner"));
                ;
                // Class A: Code after inner
                RTS_COMMON._LINE("Class simtst113.A",32); // JavaLine 54 <== SourceLine 32
                ;
                RTS_COMMON._LINE("Class simtst113.A",33); // JavaLine 56 <== SourceLine 33
                {
                    _SIM_LABEL(1);
                    new simtst113_trace((_CUR._SL),new RTS_TXT("In A after inner"));
                }
                ;
                RTS_COMMON._LINE("Class simtst113.B",43); // JavaLine 62 <== SourceLine 43
                break _LOOP;
            }
            catch(RTS_LABEL q) {
                _CUR=_THIS;
                if(q._SL!=_CUR) {
                    if(RTS_COMMON.Option.GOTO_TRACING) TRACE_GOTO("B:NON-LOCAL",q);
                    _CUR._STATE=OperationalState.terminated;
                    if(RTS_COMMON.Option.GOTO_TRACING) TRACE_GOTO("B:RE-THROW",q);
                    throw(q);
                }
                if(RTS_COMMON.Option.GOTO_TRACING) TRACE_GOTO("B:LOCAL",q);
                _JTX=q.index; continue _LOOP; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Class Statements
    public static RTS_PROGINFO _INFO=new RTS_PROGINFO("simtst113.sim","Class B",1,36,10,41,13,39,30,30,33,31,37,40,40,41,46,43,48,42,50,43,54,32,56,33,62,43,79,44);
} // End of Class
