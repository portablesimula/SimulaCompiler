// JavaLine 1 ==> SourceLine 123
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:43:34 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$errmsg extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=123, lastLine=161, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$i;
    // Declare local labels
    // JavaLine 15 ==> SourceLine 127
    final LABQNT$ SETNUM=new LABQNT$(this,0,1); // Local Label #1=SETNUM
    // Declare locals as attributes
    // JavaLine 18 ==> SourceLine 124
    TXT$ t=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$errmsg setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$errmsg.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$i=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public ERRMSG$errmsg(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$errmsg(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("errmsg",124);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$errmsg STM$() {
        TRACE_BEGIN_STM$("errmsg",124);
        ERRMSG$errmsg THIS$=(ERRMSG$errmsg)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 53 ==> SourceLine 125
                if((p$i==(0))) {
                } else
                // JavaLine 56 ==> SourceLine 126
                if(((ERRMSG)(CUR$.SL$)).ERRnotopen) {
                    // JavaLine 58 ==> SourceLine 127
                    {
                        TRACE_BEGIN_STM$("CompoundStatement127",127);
                        LABEL$(1); // SETNUM
                        RESULT$=t=copy(copy(new TXT$(" ERROR ... ")));
                        TXT$.putint(TXT$.sub(t,8,3),p$i);
                        TRACE_END_STM$("CompoundStatement127",127);
                    }
                } else
                // JavaLine 67 ==> SourceLine 129
                if(((p$i>(0))&&((p$i<=(((ERRMSG)(CUR$.SL$)).uplim))))) {
                    // JavaLine 69 ==> SourceLine 130
                    {
                        TRACE_BEGIN_STM$("CompoundStatement130",130);
                        if((((ERRMSG)(CUR$.SL$)).ERRORFILE==(null))) {
                            // JavaLine 73 ==> SourceLine 131
                            {
                                TRACE_BEGIN_STM$("CompoundStatement131",131);
                                t=getTextInfo(22);
                                // JavaLine 77 ==> SourceLine 132
                                if(TRF_EQ(t,null)) {
                                    t=new TXT$("FECERROR");
                                }
                                // JavaLine 81 ==> SourceLine 136
                                ((ERRMSG)(CUR$.SL$)).ERRORFILE=new DirectFile$(((BASICIO$)CTX$),t).STM$();
                                // JavaLine 83 ==> SourceLine 137
                                ((ERRMSG)(CUR$.SL$)).ERRORFILE.setaccess(new TXT$("READONLY"));
                                TRACE_END_STM$("CompoundStatement131",137);
                            }
                        }
                        // JavaLine 88 ==> SourceLine 139
                        if((!(((ERRMSG)(CUR$.SL$)).ERRnotopen))) {
                            // JavaLine 90 ==> SourceLine 140
                            {
                                TRACE_BEGIN_STM$("CompoundStatement140",140);
                                t=blanks(50);
                                // JavaLine 94 ==> SourceLine 141
                                if((!(((ERRMSG)(CUR$.SL$)).ERRORFILE.open(t)))) {
                                    // JavaLine 96 ==> SourceLine 142
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement142",142);
                                        new ERRMSG$printDiag(((ERRMSG)(CUR$.SL$)),new TXT$("*** CAN'T OPEN DIAGNOSTICS FILE ***"));
                                        // JavaLine 100 ==> SourceLine 143
                                        ((ERRMSG)(CUR$.SL$)).ERRnotopen=true;
                                        GOTO$(SETNUM); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement142",143);
                                    }
                                }
                                // JavaLine 106 ==> SourceLine 150
                                ((ERRMSG)(CUR$.SL$)).ERRORFILE.locate(p$i);
                                ((ERRMSG)(CUR$.SL$)).ERRORFILE.inimage();
                                // JavaLine 109 ==> SourceLine 151
                                if(((ERRMSG)(CUR$.SL$)).ERRORFILE.endfile()) {
                                    // JavaLine 111 ==> SourceLine 152
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement152",152);
                                        new ERRMSG$printDiag(((ERRMSG)(CUR$.SL$)),new TXT$("*** INCOMPATIBLE DIAGNOSTICS FILE ***"));
                                        // JavaLine 115 ==> SourceLine 153
                                        GOTO$(SETNUM); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement152",153);
                                    }
                                }
                                // JavaLine 120 ==> SourceLine 155
                                RESULT$=copy(copy(TXT$.strip(((ERRMSG)(CUR$.SL$)).ERRORFILE.image)));
                                // JavaLine 122 ==> SourceLine 156
                                ((ERRMSG)(CUR$.SL$)).ERRORFILE.close();
                                TRACE_END_STM$("CompoundStatement140",156);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement130",156);
                    }
                } else
                // JavaLine 130 ==> SourceLine 159
                {
                    TRACE_BEGIN_STM$("CompoundStatement159",159);
                    RESULT$=t=copy(copy(new TXT$("*** DIAGNOSTIC ERROR: .....")));
                    // JavaLine 134 ==> SourceLine 160
                    TXT$.putint(TXT$.sub(t,23,5),p$i);
                    TRACE_END_STM$("CompoundStatement159",160);
                }
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$ || q.prefixLevel!=0) {
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("errmsg",160);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure errmsg",1,123,15,127,18,124,53,125,56,126,58,127,67,129,69,130,73,131,77,132,81,136,83,137,88,139,90,140,94,141,96,142,100,143,106,150,109,151,111,152,115,153,120,155,122,156,130,159,134,160,154,161);
}
