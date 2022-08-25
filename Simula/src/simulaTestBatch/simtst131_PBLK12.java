package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 22 09:53:21 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst131_PBLK12 extends _CatchingErrors {
    // PrefixedBlockDeclaration: Kind=PrefixedBlock, BlockLevel=2, firstLine=12, lastLine=70, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 9 <== SourceLine 56
    final _LABQNT _LABELSTARTING=new _LABQNT(this,1,"STARTING"); // Local Label #1=STARTING
    // JavaLine 11 <== SourceLine 60
    final _LABQNT _LABELLAB1=new _LABQNT(this,2,"LAB1"); // Local Label #2=LAB1
    // JavaLine 13 <== SourceLine 61
    final _LABQNT _LABELLAB2=new _LABQNT(this,3,"LAB2"); // Local Label #3=LAB2
    // JavaLine 15 <== SourceLine 65
    final _LABQNT _LABELLAB3=new _LABQNT(this,4,"LAB3"); // Local Label #4=LAB3
    // JavaLine 17 <== SourceLine 66
    final _LABQNT _LABELLAB4=new _LABQNT(this,5,"LAB4"); // Local Label #5=LAB4
    // Declare locals as attributes
    // JavaLine 20 <== SourceLine 13
    public int traceCase_1=0;
    // JavaLine 22 <== SourceLine 14
    public _ARRAY<_TXT[]>facit=null;
    // JavaLine 24 <== SourceLine 15
    public _InByteFile bf_1=null;
    public _PRCQNT onError_0() { return(new _PRCQNT(this,simtst131_simtst131_PBLK12_onError.class)); }
    // Normal Constructor
    public simtst131_PBLK12(_RTObject staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        // JavaLine 32 <== SourceLine 14
        int[] facit_LB=new int[1]; int[] facit_UB=new int[1];
        facit_LB[0]=0; facit_UB[0]=9;
        _BOUND_CHECK(facit_LB[0],facit_UB[0]);
        facit=new _ARRAY<_TXT[]>(new _TXT[facit_UB[0]-facit_LB[0]+1],facit_LB,facit_UB);
    }
    // Class Statements
    public simtst131_PBLK12 _STM() {
        simtst131_PBLK12 THIS_=(simtst131_PBLK12)_CUR;
        _LOOP:while(_JTX>=0) {
            try {
                _JUMPTABLE(_JTX); // For ByteCode Engineering
                // Class CatchingErrors: Code before inner
                // JavaLine 45 <== SourceLine 1
                try {
                    // Class simtst131_PBLK12: Code before inner
                    // JavaLine 48 <== SourceLine 49
                    facit.Elt[0-facit.LB[0]]=new _TXT("At START");
                    ;
                    // JavaLine 51 <== SourceLine 50
                    facit.Elt[1-facit.LB[0]]=new _TXT("Inside onError: NullPointerException: NONE-CHECK Failed");
                    ;
                    // JavaLine 54 <== SourceLine 51
                    facit.Elt[2-facit.LB[0]]=new _TXT("At LAB2");
                    ;
                    // JavaLine 57 <== SourceLine 52
                    facit.Elt[3-facit.LB[0]]=new _TXT("DEEP Inside onError: NullPointerException: NONE-CHECK Failed");
                    ;
                    // JavaLine 60 <== SourceLine 53
                    facit.Elt[4-facit.LB[0]]=new _TXT("At LAB4");
                    ;
                    // JavaLine 63 <== SourceLine 54
                    facit.Elt[5-facit.LB[0]]=new _TXT("At END OF TEST");
                    ;
                    // JavaLine 66 <== SourceLine 56
                    {
                        _LABEL(1,"STARTING");
                        new simtst131_simtst131_PBLK12_trace((_CUR),new _TXT("At START"));
                    }
                    ;
                    // JavaLine 72 <== SourceLine 58
                    bf_1.inbyte();
                    ;
                    // JavaLine 75 <== SourceLine 60
                    {
                        _LABEL(2,"LAB1");
                        new simtst131_simtst131_PBLK12_trace((_CUR),new _TXT("At LAB1"));
                    }
                    ;
                    // JavaLine 81 <== SourceLine 61
                    {
                        _LABEL(3,"LAB2");
                        new simtst131_simtst131_PBLK12_trace((_CUR),new _TXT("At LAB2"));
                    }
                    ;
                    // JavaLine 87 <== SourceLine 63
                    new simtst131_simtst131_PBLK12_P((_CUR));
                    ;
                    // JavaLine 90 <== SourceLine 65
                    {
                        _LABEL(4,"LAB3");
                        new simtst131_simtst131_PBLK12_trace((_CUR),new _TXT("At LAB3"));
                    }
                    ;
                    // JavaLine 96 <== SourceLine 66
                    {
                        _LABEL(5,"LAB4");
                        new simtst131_simtst131_PBLK12_trace((_CUR),new _TXT("At LAB4"));
                    }
                    ;
                    // JavaLine 102 <== SourceLine 68
                    new simtst131_simtst131_PBLK12_trace((_CUR),new _TXT("At END OF TEST"));
                    ;
                    // Class CatchingErrors: Code after inner
                    // JavaLine 106 <== SourceLine 1
                } catch(RuntimeException e) { _CUR=this; _onError(e,onError_0()); }
                // JavaLine 108 <== SourceLine 68
                break _LOOP;
            }
            catch(_LABQNT q) {
                _CUR=THIS_;
                if(q._SL!=_CUR) {
                    if(_RT.Option._GOTOTRACING) TRACE_GOTO("simtst131_PBLK12:NON-LOCAL",q);
                    _CUR.STATE_=OperationalState.terminated;
                    if(_RT.Option._GOTOTRACING) TRACE_GOTO("simtst131_PBLK12:RE-THROW",q);
                    throw(q);
                }
                if(_RT.Option._GOTOTRACING) TRACE_GOTO("simtst131_PBLK12:LOCAL",q);
                _JTX=q.index; continue _LOOP; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Class Statements
    public static _PROGINFO INFO_=new _PROGINFO("simtst131.sim","PrefixedBlock simtst131_PBLK12",9,56,11,60,13,61,15,65,17,66,20,13,22,14,24,15,32,14,45,1,48,49,51,50,54,51,57,52,60,53,63,54,66,56,72,58,75,60,81,61,87,63,90,65,96,66,102,68,106,1,108,68,125,70);
} // End of Class
