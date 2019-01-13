// JavaLine 1 ==> SourceLine 24
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Jan 12 15:31:42 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst100 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=24, lastLine=179, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare local labels
    // JavaLine 10 ==> SourceLine 168
    final LABQNT$ EXIT=new LABQNT$(this,0,1); // Local Label #1=EXIT
    // Declare locals as attributes
    // JavaLine 13 ==> SourceLine 24
    final boolean verbose=false;
    // JavaLine 15 ==> SourceLine 25
    final TXT$ outputFrom100=new TXT$("C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/files/outputFrom100");
    // JavaLine 17 ==> SourceLine 27
    final int signpos=17;
    // JavaLine 19 ==> SourceLine 28
    final int signpos1=18;
    // JavaLine 21 ==> SourceLine 29
    final int iterationcount=1000;
    // JavaLine 23 ==> SourceLine 31
    int min_signif=0;
    int max_signif=0;
    int i=0;
    // JavaLine 27 ==> SourceLine 32
    double r=0.0d;
    // JavaLine 29 ==> SourceLine 33
    double TENPOWER=0.0d;
    // JavaLine 31 ==> SourceLine 34
    double DELTA=0.0d;
    // JavaLine 33 ==> SourceLine 35
    boolean up=false;
    boolean down=false;
    OutFile$ putget=null;
    // JavaLine 37 ==> SourceLine 37
    TXT$ t=null;
    TXT$ prevt=null;
    TXT$ st=null;
    TXT$ putgetput=null;
    TXT$ heading=null;
    // Normal Constructor
    public simtst100(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst100");
        // Declaration Code
        TRACE_BEGIN_DCL$("simtst100",126);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("simtst100",126);
        simtst100 THIS$=(simtst100)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 58 ==> SourceLine 129
                if(verbose) {
                    // JavaLine 60 ==> SourceLine 130
                    {
                        TRACE_BEGIN_STM$("CompoundStatement130",130);
                        sysout().outtext(new TXT$("START Simula a.s test 100"));
                        // JavaLine 64 ==> SourceLine 131
                        sysout().outimage();
                        // JavaLine 66 ==> SourceLine 132
                        sysout().outtext(new TXT$("    Test monotoneity of putreal and getreal."));
                        // JavaLine 68 ==> SourceLine 133
                        sysout().outimage();
                        // JavaLine 70 ==> SourceLine 134
                        sysout().outtext(new TXT$("    Test that put-get-put delivers the identity."));
                        // JavaLine 72 ==> SourceLine 135
                        sysout().outimage();
                        // JavaLine 74 ==> SourceLine 136
                        sysout().outtext(CONC(new TXT$("    - report on outfile "),outputFrom100));
                        // JavaLine 76 ==> SourceLine 137
                        sysout().outimage();
                        sysout().outimage();
                        TRACE_END_STM$("CompoundStatement130",137);
                    }
                }
                // JavaLine 82 ==> SourceLine 140
                min_signif=signpos;
                max_signif=0;
                // JavaLine 85 ==> SourceLine 142
                if(verbose) {
                    putget=sysout();
                } else
                // JavaLine 89 ==> SourceLine 144
                {
                    TRACE_BEGIN_STM$("CompoundStatement144",144);
                    putget=new OutFile$(((BASICIO$)CTX$),outputFrom100).STM$();
                    // JavaLine 93 ==> SourceLine 145
                    if((!(putget.open(blanks(80))))) {
                        // JavaLine 95 ==> SourceLine 146
                        {
                            TRACE_BEGIN_STM$("CompoundStatement146",146);
                            sysout().outtext(CONC(new TXT$("error: CAN'T OPEN FILE "),outputFrom100));
                            sysout().outimage();
                            // JavaLine 100 ==> SourceLine 147
                            GOTO$(EXIT); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement146",147);
                        }
                    }
                    TRACE_END_STM$("CompoundStatement144",147);
                }
                // JavaLine 107 ==> SourceLine 149
                heading=blanks(32);
                // JavaLine 109 ==> SourceLine 150
                t=blanks(25);
                // JavaLine 111 ==> SourceLine 151
                prevt=blanks(25);
                st=blanks(25);
                // JavaLine 114 ==> SourceLine 152
                putgetput=new TXT$("put o get o put");
                // JavaLine 116 ==> SourceLine 153
                up=true;
                down=false;
                // JavaLine 119 ==> SourceLine 154
                TENPOWER=1.0E16d;
                DELTA=(((double)(1))/(TENPOWER));
                // JavaLine 122 ==> SourceLine 155
                new simtst100$testputget(((simtst100)CUR$),((double)(0)),up);
                new simtst100$testputget(((simtst100)CUR$),((ENVIRONMENT$)CTX$).maxlongreal,down);
                // JavaLine 125 ==> SourceLine 156
                r=((double)(345));
                r=(r/(((double)(100))));
                // JavaLine 128 ==> SourceLine 157
                new simtst100$testputget(((simtst100)CUR$),(r-(DELTA)),up);
                new simtst100$testputget(((simtst100)CUR$),(r+(DELTA)),down);
                // JavaLine 131 ==> SourceLine 158
                r=((double)(4499999));
                r=(r/(((double)(1000000))));
                // JavaLine 134 ==> SourceLine 159
                new simtst100$testputget(((simtst100)CUR$),(r-(DELTA)),up);
                new simtst100$testputget(((simtst100)CUR$),(r+(DELTA)),down);
                // JavaLine 137 ==> SourceLine 160
                r=((double)(0));
                i=signpos;
                // JavaLine 140 ==> SourceLine 161
                while((i>=(9))) {
                    {
                        TRACE_BEGIN_STM$("CompoundStatement161",161);
                        r=((r*(((double)(1000000000))))+(((double)(999999999))));
                        i=(i-(9));
                        TRACE_END_STM$("CompoundStatement161",161);
                    }
                }
                // JavaLine 149 ==> SourceLine 162
                r=(((r*(((double)(IPOW$(10,i)))))+(((double)((IPOW$(10,i)-(1))))))/(TENPOWER));
                // JavaLine 151 ==> SourceLine 163
                new simtst100$testputget(((simtst100)CUR$),(r-(DELTA)),up);
                new simtst100$testputget(((simtst100)CUR$),(r+(DELTA)),down);
                // JavaLine 154 ==> SourceLine 165
                r=1.0E31d;
                new simtst100$testputget(((simtst100)CUR$),r,up);
                // JavaLine 157 ==> SourceLine 166
                r=1.0E41d;
                new simtst100$testputget(((simtst100)CUR$),r,up);
                // JavaLine 160 ==> SourceLine 168
                LABEL$(1); // EXIT
                if(verbose) {
                    sysout().outtext(new TXT$("..END Simula a.s test 100"));
                }
                // JavaLine 165 ==> SourceLine 169
                if((min_signif==(signpos))) {
                    // JavaLine 167 ==> SourceLine 171
                    sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 100"));
                } else
                {
                    TRACE_BEGIN_STM$("CompoundStatement171",171);
                    sysout().outimage();
                    putget.outimage();
                    // JavaLine 174 ==> SourceLine 172
                    sysout().outtext(new TXT$(" Number of significant digits varies between"));
                    // JavaLine 176 ==> SourceLine 173
                    sysout().outint(min_signif,3);
                    sysout().outtext(new TXT$(" and"));
                    sysout().outint(max_signif,3);
                    TRACE_END_STM$("CompoundStatement171",173);
                }
                // JavaLine 182 ==> SourceLine 175
                putget.outtext(sysout().image);
                putget.outimage();
                // JavaLine 185 ==> SourceLine 176
                if((!(verbose))) {
                    putget.close();
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
        TRACE_END_STM$("simtst100",176);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst100(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst100.sim","SimulaProgram simtst100",1,24,10,168,13,24,15,25,17,27,19,28,21,29,23,31,27,32,29,33,31,34,33,35,37,37,58,129,60,130,64,131,66,132,68,133,70,134,72,135,74,136,76,137,82,140,85,142,89,144,93,145,95,146,100,147,107,149,109,150,111,151,114,152,116,153,119,154,122,155,125,156,128,157,131,158,134,159,137,160,140,161,149,162,151,163,154,165,157,166,160,168,165,169,167,171,174,172,176,173,182,175,185,176,210,179);
}
