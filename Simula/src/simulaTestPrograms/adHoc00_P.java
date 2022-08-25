// JavaLine 1 <== SourceLine 11
package simulaTestPrograms;
// Simula-2.0 Compiled at Sun Aug 21 11:59:30 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc00_P extends _PROC {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=11, lastLine=30, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 10 <== SourceLine 28
    final _LABQNT _LABELEND=new _LABQNT(this,1,"END"); // Local Label #1=END
    // JavaLine 12 <== SourceLine 29
    final _LABQNT _LABELEXIT=new _LABQNT(this,2,"EXIT"); // Local Label #2=EXIT
    // Declare locals as attributes
    // JavaLine 15 <== SourceLine 12
    public int j=0;
    public final int key=(int)(22);
    // JavaLine 18 <== SourceLine 21
    public adHoc00_A inspect_21_0=null;
    // Normal Constructor
    public adHoc00_P(_RTObject _SL) {
        super(_SL);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        _STM();
    }
    // Procedure Statements
    public adHoc00_P _STM() {
        adHoc00_P THIS_=(adHoc00_P)_CUR;
        _LOOP:while(_JTX>=0) {
            try {
                _JUMPTABLE(_JTX); // For ByteCode Engineering
                // JavaLine 34 <== SourceLine 13
                if(22<0 || 22>55) throw new _SimulaRuntimeError("Switch key outside key interval");
                switch(22) { // BEGIN SWITCH STATEMENT
                case 0: 
                // JavaLine 38 <== SourceLine 14
                j=33;
                break;
                default:
                // JavaLine 42 <== SourceLine 16
                j=99;
                break;
            } // END SWITCH STATEMENT
            ;
            // JavaLine 47 <== SourceLine 19
            ((adHoc00)(_CUR._SL)).ActivateDirect(false,(_Process)new adHoc00_A(((adHoc00)(_CUR._SL)),77)._START());
            ;
            // JavaLine 50 <== SourceLine 21
            {
                // BEGIN INSPECTION 
                inspect_21_0=((adHoc00_A)new adHoc00_A(((adHoc00)(_CUR._SL)),55)._START());
                if(inspect_21_0!=null) // INSPECT inspect_21_0
                // JavaLine 55 <== SourceLine 22
                {
                    // JavaLine 57 <== SourceLine 21
                    {
                        // JavaLine 59 <== SourceLine 22
                        inspect_21_0.p3_i=33;
                        ;
                        for(inspect_21_0.p3_i=5;inspect_21_0.p3_i<=22;inspect_21_0.p3_i++) {
                            // JavaLine 63 <== SourceLine 23
                            {
                                // JavaLine 65 <== SourceLine 24
                                if(_VALUE((inspect_21_0.p3_i==(33)))) {
                                    _GOTO(_LABELEXIT); // GOTO EVALUATED LABEL
                                }
                                ;
                            }
                        }
                        ;
                        // JavaLine 73 <== SourceLine 27
                        {
                            _LABEL(1,"END");
                            _LABEL(2,"EXIT");
                            ;
                        }
                    }
                }
            }
            ;
            break _LOOP;
        }
        catch(_LABQNT q) {
            _CUR=THIS_;
            if(q._SL!=_CUR) {
                if(_RT.Option._GOTOTRACING) TRACE_GOTO("P:NON-LOCAL",q);
                _CUR.STATE_=OperationalState.terminated;
                if(_RT.Option._GOTOTRACING) TRACE_GOTO("P:RE-THROW",q);
                throw(q);
            }
            if(_RT.Option._GOTOTRACING) TRACE_GOTO("P:LOCAL",q);
            _JTX=q.index; continue _LOOP; // EG. GOTO Lx
        }
    }
    EBLK();
    return(this);
} // End of Procedure BODY
public static _PROGINFO INFO_=new _PROGINFO("adHoc00.sim","Procedure P",1,11,10,28,12,29,15,12,18,21,34,13,38,14,42,16,47,19,50,21,55,22,57,21,59,22,63,23,65,24,73,27,99,30);
} // End of Procedure
