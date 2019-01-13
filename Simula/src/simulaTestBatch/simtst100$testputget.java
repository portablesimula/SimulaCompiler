// JavaLine 1 ==> SourceLine 38
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Jan 12 15:31:42 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst100$testputget extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=38, lastLine=127, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public double p$prevr;
    public boolean p$up;
    // Declare local labels
    // JavaLine 13 ==> SourceLine 117
    final LABQNT$ LOOP=new LABQNT$(this,0,1); // Local Label #1=LOOP
    // Declare locals as attributes
    // JavaLine 16 ==> SourceLine 39
    double r=0.0d;
    double s=0.0d;
    TXT$ swapt=null;
    int significance=0;
    int stepi=0;
    // JavaLine 22 ==> SourceLine 40
    final int ten=58;
    // JavaLine 24 ==> SourceLine 119
    OutFile$ inspect$119$1=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst100$testputget setPar(Object param) {
        //Util.BREAK("CALL simtst100$testputget.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$prevr=doubleValue(param); break;
                case 1: p$up=(boolean)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public simtst100$testputget(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public simtst100$testputget(RTObject$ SL$,double sp$prevr,boolean sp$up) {
        super(SL$);
        // Parameter assignment to locals
        this.p$prevr = sp$prevr;
        this.p$up = sp$up;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("testputget",119);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst100$testputget STM$() {
        TRACE_BEGIN_STM$("testputget",119);
        simtst100$testputget THIS$=(simtst100$testputget)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 61 ==> SourceLine 86
                if(((simtst100)(CUR$.SL$)).verbose) {
                    // JavaLine 63 ==> SourceLine 87
                    {
                        TRACE_BEGIN_STM$("CompoundStatement87",87);
                        sysout().outtext(new TXT$("Test PutGet: "));
                        sysout().outreal(p$prevr,4,12);
                        // JavaLine 68 ==> SourceLine 88
                        sysout().outimage();
                        TRACE_END_STM$("CompoundStatement87",88);
                    }
                }
                // JavaLine 73 ==> SourceLine 91
                significance=((simtst100)(CUR$.SL$)).signpos;
                // JavaLine 75 ==> SourceLine 92
                TXT$.putreal(((simtst100)(CUR$.SL$)).prevt,p$prevr,((simtst100)(CUR$.SL$)).signpos1);
                // JavaLine 77 ==> SourceLine 93
                ASGTXT$(((simtst100)(CUR$.SL$)).heading,((simtst100)(CUR$.SL$)).prevt);
                // JavaLine 79 ==> SourceLine 94
                ASGTXT$(TXT$.sub(((simtst100)(CUR$.SL$)).heading,27,5),((p$up)?(new TXT$(" up")):(new TXT$(" down"))));
                // JavaLine 81 ==> SourceLine 96
                s=TXT$.getreal(((simtst100)(CUR$.SL$)).prevt);
                TXT$.putreal(((simtst100)(CUR$.SL$)).st,s,((simtst100)(CUR$.SL$)).signpos1);
                // JavaLine 84 ==> SourceLine 97
                if(TXTREL$NE(((simtst100)(CUR$.SL$)).st,((simtst100)(CUR$.SL$)).prevt)) {
                    {
                        TRACE_BEGIN_STM$("CompoundStatement97",97);
                        ASGTXT$(((simtst100)(CUR$.SL$)).t,((simtst100)(CUR$.SL$)).prevt);
                        new simtst100$testputget$err(((simtst100$testputget)CUR$),((simtst100)(CUR$.SL$)).putgetput);
                        TRACE_END_STM$("CompoundStatement97",97);
                    }
                }
                // JavaLine 93 ==> SourceLine 98
                while((stepi<(((simtst100)(CUR$.SL$)).iterationcount))) {
                    {
                        TRACE_BEGIN_STM$("CompoundStatement98",98);
                        stepi=(stepi+(1));
                        // JavaLine 98 ==> SourceLine 99
                        r=((p$up)?(addepsilon(p$prevr)):(subepsilon(p$prevr)));
                        // JavaLine 100 ==> SourceLine 100
                        TXT$.putreal(((simtst100)(CUR$.SL$)).t,r,((simtst100)(CUR$.SL$)).signpos1);
                        // JavaLine 102 ==> SourceLine 101
                        s=TXT$.getreal(((simtst100)(CUR$.SL$)).t);
                        TXT$.putreal(((simtst100)(CUR$.SL$)).st,s,((simtst100)(CUR$.SL$)).signpos1);
                        // JavaLine 105 ==> SourceLine 102
                        if(TXTREL$NE(((simtst100)(CUR$.SL$)).st,((simtst100)(CUR$.SL$)).t)) {
                            // JavaLine 107 ==> SourceLine 103
                            new simtst100$testputget$err(((simtst100$testputget)CUR$),((simtst100)(CUR$.SL$)).putgetput);
                        } else
                        if(p$up) {
                            // JavaLine 111 ==> SourceLine 104
                            {
                                TRACE_BEGIN_STM$("CompoundStatement104",104);
                                if(TXTREL$LT(((simtst100)(CUR$.SL$)).t,((simtst100)(CUR$.SL$)).prevt)) {
                                    // JavaLine 115 ==> SourceLine 105
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement105",105);
                                        if(new simtst100$testputget$expcom(((simtst100$testputget)CUR$)).RESULT$) {
                                            // JavaLine 119 ==> SourceLine 106
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement106",106);
                                                new simtst100$testputget$err(((simtst100$testputget)CUR$),new TXT$("putreal decreases"));
                                                GOTO$(LOOP); // GOTO EVALUATED LABEL
                                                TRACE_END_STM$("CompoundStatement106",106);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement105",106);
                                    }
                                }
                                // JavaLine 130 ==> SourceLine 108
                                if((s<(p$prevr))) {
                                    new simtst100$testputget$err(((simtst100$testputget)CUR$),new TXT$("getreal decreases"));
                                }
                                TRACE_END_STM$("CompoundStatement104",108);
                            }
                        } else
                        // JavaLine 137 ==> SourceLine 111
                        {
                            TRACE_BEGIN_STM$("CompoundStatement111",111);
                            if(TXTREL$GT(((simtst100)(CUR$.SL$)).t,((simtst100)(CUR$.SL$)).prevt)) {
                                // JavaLine 141 ==> SourceLine 112
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement112",112);
                                    if(new simtst100$testputget$expcom(((simtst100$testputget)CUR$)).RESULT$) {
                                        // JavaLine 145 ==> SourceLine 113
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement113",113);
                                            new simtst100$testputget$err(((simtst100$testputget)CUR$),new TXT$("putreal increases"));
                                            GOTO$(LOOP); // GOTO EVALUATED LABEL
                                            TRACE_END_STM$("CompoundStatement113",113);
                                        }
                                    }
                                    TRACE_END_STM$("CompoundStatement112",113);
                                }
                            }
                            // JavaLine 156 ==> SourceLine 115
                            if((s>(p$prevr))) {
                                new simtst100$testputget$err(((simtst100$testputget)CUR$),new TXT$("getreal increases"));
                            }
                            TRACE_END_STM$("CompoundStatement111",115);
                        }
                        // JavaLine 162 ==> SourceLine 117
                        LABEL$(1); // LOOP
                        p$prevr=r;
                        swapt=((simtst100)(CUR$.SL$)).prevt;
                        ((simtst100)(CUR$.SL$)).prevt=((simtst100)(CUR$.SL$)).t;
                        ((simtst100)(CUR$.SL$)).t=swapt;
                        TRACE_END_STM$("CompoundStatement98",117);
                    }
                }
                // JavaLine 171 ==> SourceLine 119
                {
                    // BEGIN INSPECTION 
                    inspect$119$1=((simtst100)(CUR$.SL$)).putget;
                    if(inspect$119$1!=null) //INSPECT inspect$119$1
                    // JavaLine 176 ==> SourceLine 120
                    {
                        TRACE_BEGIN_STM$("CompoundStatement120",120);
                        inspect$119$1.outimage();
                        // JavaLine 180 ==> SourceLine 121
                        inspect$119$1.outtext(new TXT$("*** SIGNIFICANCE from "));
                        inspect$119$1.outtext(((simtst100)(CUR$.SL$)).heading);
                        // JavaLine 183 ==> SourceLine 122
                        inspect$119$1.outtext(new TXT$(" is "));
                        inspect$119$1.outint(significance,2);
                        inspect$119$1.outimage();
                        // JavaLine 187 ==> SourceLine 123
                        if((significance<(((simtst100)(CUR$.SL$)).min_signif))) {
                            // JavaLine 189 ==> SourceLine 124
                            ((simtst100)(CUR$.SL$)).min_signif=significance;
                        }
                        TRACE_END_STM$("CompoundStatement120",124);
                    }
                }
                // JavaLine 195 ==> SourceLine 126
                if((((simtst100)(CUR$.SL$)).max_signif<(significance))) {
                    ((simtst100)(CUR$.SL$)).max_signif=significance;
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
        TRACE_END_STM$("testputget",126);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst100.sim","Procedure testputget",1,38,13,117,16,39,22,40,24,119,61,86,63,87,68,88,73,91,75,92,77,93,79,94,81,96,84,97,93,98,98,99,100,100,102,101,105,102,107,103,111,104,115,105,119,106,130,108,137,111,141,112,145,113,156,115,162,117,171,119,176,120,180,121,183,122,187,123,189,124,195,126,215,127);
}
