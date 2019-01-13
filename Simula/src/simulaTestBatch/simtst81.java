// JavaLine 1 ==> SourceLine 12
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Jan 12 16:06:24 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst81 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=12, lastLine=212, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    FILE$ xf=null;
    // JavaLine 11 ==> SourceLine 13
    boolean found_error=false;
    // JavaLine 13 ==> SourceLine 14
    final boolean verbose=false;
    // JavaLine 15 ==> SourceLine 16
    final TXT$ anyIntypeFile=new TXT$("C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/files/anyIntypeFile81");
    // JavaLine 17 ==> SourceLine 17
    final TXT$ anyOuttypeFile=new TXT$("C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/files/anyOuttypeFile81");
    // JavaLine 19 ==> SourceLine 18
    final TXT$ anyDirectFile=new TXT$("C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/files/anyDirectFile81");
    // JavaLine 21 ==> SourceLine 19
    final TXT$ anyDirectByteFile=new TXT$("C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/files/anyDirectByteFile81");
    // Normal Constructor
    public simtst81(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst81");
        // Declaration Code
        TRACE_BEGIN_DCL$("simtst81",24);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("simtst81",24);
        // JavaLine 34 ==> SourceLine 27
        if(verbose) {
            // JavaLine 36 ==> SourceLine 28
            {
                TRACE_BEGIN_STM$("CompoundStatement28",28);
                sysout().outtext(new TXT$("--- START Simula a.s. TEST 81 (Test 'open' and 'close')"));
                // JavaLine 40 ==> SourceLine 29
                sysout().outimage();
                // JavaLine 42 ==> SourceLine 30
                sysout().outtext(new TXT$("    file \"anyIntypeFile\" is opened as infile and inbytefile"));
                // JavaLine 44 ==> SourceLine 31
                sysout().outimage();
                // JavaLine 46 ==> SourceLine 33
                sysout().outtext(new TXT$("    file \"anyOuttypeFile\" is opened as outfile, printfile and outbytefile"));
                // JavaLine 48 ==> SourceLine 34
                sysout().outimage();
                // JavaLine 50 ==> SourceLine 35
                sysout().outtext(new TXT$("    file \"anyDirectFile\" is opened as directfile"));
                // JavaLine 52 ==> SourceLine 36
                sysout().outimage();
                // JavaLine 54 ==> SourceLine 37
                sysout().outtext(new TXT$("    file \"anyDirectByteFile\" is opened as directbytefile"));
                // JavaLine 56 ==> SourceLine 38
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement28",38);
            }
        }
        // JavaLine 61 ==> SourceLine 41
        xf=new InFile$(((BASICIO$)CTX$),anyIntypeFile).STM$();
        // JavaLine 63 ==> SourceLine 43
        if(((InFile$)(xf)).close()) {
            // JavaLine 65 ==> SourceLine 45
            new simtst81$report(((simtst81)CUR$),45,new TXT$("'close' returns TRUE (never-opened infile \"anyIntypeFile\")"),false);
        }
        // JavaLine 68 ==> SourceLine 47
        if((!(((InFile$)(xf)).open(blanks(80))))) {
            // JavaLine 70 ==> SourceLine 49
            new simtst81$report(((simtst81)CUR$),49,new TXT$("'open' returns FALSE (never-opened infile \"anyIntypeFile\")"),true);
        }
        // JavaLine 73 ==> SourceLine 51
        if(((InFile$)(xf)).open(blanks(80))) {
            // JavaLine 75 ==> SourceLine 53
            new simtst81$report(((simtst81)CUR$),53,new TXT$("'open' returns TRUE (on open infile \"anyIntypeFile\")"),false);
        }
        // JavaLine 78 ==> SourceLine 55
        if((!(((InFile$)(xf)).close()))) {
            // JavaLine 80 ==> SourceLine 59
            new simtst81$report(((simtst81)CUR$),59,new TXT$("'close' returns FALSE (open infile \"anyIntypeFile\")"),false);
        } else
        if(((InFile$)(xf)).close()) {
            // JavaLine 84 ==> SourceLine 61
            new simtst81$report(((simtst81)CUR$),61,new TXT$("'close' returns TRUE (closed infile \"anyIntypeFile\")"),false);
        }
        // JavaLine 87 ==> SourceLine 64
        xf=new OutFile$(((BASICIO$)CTX$),anyOuttypeFile).STM$();
        // JavaLine 89 ==> SourceLine 66
        if(((OutFile$)(xf)).close()) {
            // JavaLine 91 ==> SourceLine 68
            new simtst81$report(((simtst81)CUR$),68,CONC(CONC(new TXT$("'close' returns TRUE (never-opened outfile "),anyOuttypeFile),new TXT$(")")),false);
        }
        // JavaLine 94 ==> SourceLine 70
        if((!(((OutFile$)(xf)).open(blanks(80))))) {
            // JavaLine 96 ==> SourceLine 72
            new simtst81$report(((simtst81)CUR$),72,CONC(CONC(new TXT$("'open' returns FALSE (never-opened outfile "),anyOuttypeFile),new TXT$(")")),true);
        }
        // JavaLine 99 ==> SourceLine 74
        if(((OutFile$)(xf)).open(blanks(80))) {
            // JavaLine 101 ==> SourceLine 76
            new simtst81$report(((simtst81)CUR$),76,CONC(CONC(new TXT$("'open' returns TRUE (open outfile "),anyOuttypeFile),new TXT$(")")),false);
        }
        // JavaLine 104 ==> SourceLine 78
        if((!(((OutFile$)(xf)).close()))) {
            // JavaLine 106 ==> SourceLine 82
            new simtst81$report(((simtst81)CUR$),82,CONC(CONC(new TXT$("'close' returns FALSE (open outfile "),anyOuttypeFile),new TXT$(")")),false);
        } else
        if(((OutFile$)(xf)).close()) {
            // JavaLine 110 ==> SourceLine 84
            new simtst81$report(((simtst81)CUR$),84,CONC(CONC(new TXT$("'close' returns TRUE (closed outfile "),anyOuttypeFile),new TXT$(")")),false);
        }
        // JavaLine 113 ==> SourceLine 87
        xf=new DirectFile$(((BASICIO$)CTX$),new TXT$("anyDirectFile")).STM$();
        // JavaLine 115 ==> SourceLine 88
        xf.setaccess(new TXT$("CREATE"));
        // JavaLine 117 ==> SourceLine 90
        if(((DirectFile$)(xf)).close()) {
            // JavaLine 119 ==> SourceLine 92
            new simtst81$report(((simtst81)CUR$),92,CONC(CONC(new TXT$("'close' returns TRUE (never-opened directfile "),anyDirectFile),new TXT$(")")),false);
        }
        // JavaLine 122 ==> SourceLine 94
        if((!(((DirectFile$)(xf)).open(blanks(80))))) {
            // JavaLine 124 ==> SourceLine 96
            new simtst81$report(((simtst81)CUR$),96,CONC(CONC(new TXT$("'open' returns FALSE (never-opened directfile "),anyDirectFile),new TXT$(")")),true);
        }
        // JavaLine 127 ==> SourceLine 98
        if(((DirectFile$)(xf)).open(blanks(80))) {
            // JavaLine 129 ==> SourceLine 100
            new simtst81$report(((simtst81)CUR$),100,CONC(CONC(new TXT$("'open' returns TRUE (open directfile "),anyDirectFile),new TXT$(")")),false);
        }
        // JavaLine 132 ==> SourceLine 102
        if((!(((DirectFile$)(xf)).close()))) {
            // JavaLine 134 ==> SourceLine 106
            new simtst81$report(((simtst81)CUR$),106,CONC(CONC(new TXT$("'close' returns FALSE (open directfile "),anyDirectFile),new TXT$(")")),false);
        } else
        if(((DirectFile$)(xf)).close()) {
            // JavaLine 138 ==> SourceLine 108
            new simtst81$report(((simtst81)CUR$),108,CONC(CONC(new TXT$("'close' returns TRUE (closed directfile "),anyDirectFile),new TXT$(")")),false);
        }
        // JavaLine 141 ==> SourceLine 111
        xf=new InbyteFile$(((BASICIO$)CTX$),anyIntypeFile).STM$();
        // JavaLine 143 ==> SourceLine 113
        if(((InbyteFile$)(xf)).close()) {
            // JavaLine 145 ==> SourceLine 115
            new simtst81$report(((simtst81)CUR$),115,new TXT$("'close' returns TRUE (never-opened inbytefile \"anyIntypeFile\")"),false);
        }
        // JavaLine 148 ==> SourceLine 117
        if((!(((InbyteFile$)(xf)).open()))) {
            // JavaLine 150 ==> SourceLine 119
            new simtst81$report(((simtst81)CUR$),119,new TXT$("'open' returns FALSE (never-opened inbytefile \"anyIntypeFile\")"),true);
        }
        // JavaLine 153 ==> SourceLine 121
        if(((InbyteFile$)(xf)).open()) {
            // JavaLine 155 ==> SourceLine 123
            new simtst81$report(((simtst81)CUR$),123,new TXT$("'open' returns TRUE (on open inbytefile \"anyIntypeFile\")"),false);
        }
        // JavaLine 158 ==> SourceLine 125
        if((!(((InbyteFile$)(xf)).close()))) {
            // JavaLine 160 ==> SourceLine 129
            new simtst81$report(((simtst81)CUR$),129,new TXT$("'close' returns FALSE (open inbytefile \"anyIntypeFile\")"),false);
        } else
        if(((InbyteFile$)(xf)).close()) {
            // JavaLine 164 ==> SourceLine 131
            new simtst81$report(((simtst81)CUR$),131,new TXT$("'close' returns TRUE (closed inbytefile \"anyIntypeFile\")"),false);
        }
        // JavaLine 167 ==> SourceLine 134
        xf=new OutbyteFile$(((BASICIO$)CTX$),anyOuttypeFile).STM$();
        // JavaLine 169 ==> SourceLine 136
        if(((OutbyteFile$)(xf)).close()) {
            // JavaLine 171 ==> SourceLine 138
            new simtst81$report(((simtst81)CUR$),138,CONC(CONC(new TXT$("'close' returns TRUE (never-opened outbytefile "),anyOuttypeFile),new TXT$(")")),false);
        }
        // JavaLine 174 ==> SourceLine 140
        if((!(((OutbyteFile$)(xf)).open()))) {
            // JavaLine 176 ==> SourceLine 142
            new simtst81$report(((simtst81)CUR$),142,CONC(CONC(new TXT$("'open' returns FALSE (never-opened outbytefile "),anyOuttypeFile),new TXT$(")")),true);
        }
        // JavaLine 179 ==> SourceLine 144
        if(((OutbyteFile$)(xf)).open()) {
            // JavaLine 181 ==> SourceLine 146
            new simtst81$report(((simtst81)CUR$),146,CONC(CONC(new TXT$("'open' returns TRUE (on open outbytefile "),anyOuttypeFile),new TXT$(")")),false);
        }
        // JavaLine 184 ==> SourceLine 148
        if((!(((OutbyteFile$)(xf)).close()))) {
            // JavaLine 186 ==> SourceLine 152
            new simtst81$report(((simtst81)CUR$),152,CONC(CONC(new TXT$("'close' returns FALSE (open outbytefile "),anyOuttypeFile),new TXT$(")")),false);
        } else
        if(((OutbyteFile$)(xf)).close()) {
            // JavaLine 190 ==> SourceLine 154
            new simtst81$report(((simtst81)CUR$),154,CONC(CONC(new TXT$("'close' returns TRUE (closed outbytefile "),anyOuttypeFile),new TXT$(")")),false);
        }
        // JavaLine 193 ==> SourceLine 157
        xf=new DirectByteFile$(((BASICIO$)CTX$),anyDirectByteFile).STM$();
        // JavaLine 195 ==> SourceLine 158
        xf.setaccess(new TXT$("CREATE"));
        // JavaLine 197 ==> SourceLine 160
        if(((DirectByteFile$)(xf)).close()) {
            // JavaLine 199 ==> SourceLine 162
            new simtst81$report(((simtst81)CUR$),162,CONC(CONC(new TXT$("'close' returns TRUE (never-opened directbytefile "),anyDirectByteFile),new TXT$(")")),false);
        }
        // JavaLine 202 ==> SourceLine 164
        if((!(((DirectByteFile$)(xf)).open()))) {
            // JavaLine 204 ==> SourceLine 166
            new simtst81$report(((simtst81)CUR$),166,CONC(CONC(new TXT$("'open' returns FALSE (never-opened directbytefile "),anyDirectByteFile),new TXT$(")")),true);
        }
        // JavaLine 207 ==> SourceLine 168
        if(((DirectByteFile$)(xf)).open()) {
            // JavaLine 209 ==> SourceLine 170
            new simtst81$report(((simtst81)CUR$),170,CONC(CONC(new TXT$("'open' returns TRUE (on open directbytefile "),anyDirectByteFile),new TXT$(")")),false);
        }
        // JavaLine 212 ==> SourceLine 172
        if((!(((DirectByteFile$)(xf)).close()))) {
            // JavaLine 214 ==> SourceLine 176
            new simtst81$report(((simtst81)CUR$),176,CONC(CONC(new TXT$("'close' returns FALSE (open directbytefile "),anyDirectByteFile),new TXT$(")")),false);
        } else
        if(((DirectByteFile$)(xf)).close()) {
            // JavaLine 218 ==> SourceLine 178
            new simtst81$report(((simtst81)CUR$),178,CONC(CONC(new TXT$("'close' returns TRUE (closed directbytefile "),anyDirectByteFile),new TXT$(")")),false);
        }
        // JavaLine 221 ==> SourceLine 181
        xf=new PrintFile$(((BASICIO$)CTX$),anyOuttypeFile).STM$();
        // JavaLine 223 ==> SourceLine 183
        if(((PrintFile$)(xf)).close()) {
            // JavaLine 225 ==> SourceLine 185
            new simtst81$report(((simtst81)CUR$),185,CONC(CONC(new TXT$("'close' returns TRUE (never-opened printfile "),anyOuttypeFile),new TXT$(")")),false);
        }
        // JavaLine 228 ==> SourceLine 187
        if((!(((PrintFile$)(xf)).open(blanks(80))))) {
            // JavaLine 230 ==> SourceLine 189
            new simtst81$report(((simtst81)CUR$),189,CONC(CONC(new TXT$("'open' returns FALSE (never-opened printfile "),anyOuttypeFile),new TXT$(")")),true);
        }
        // JavaLine 233 ==> SourceLine 191
        if(((PrintFile$)(xf)).open(blanks(80))) {
            // JavaLine 235 ==> SourceLine 193
            new simtst81$report(((simtst81)CUR$),193,CONC(CONC(new TXT$("'open' returns TRUE (on open printfile "),anyOuttypeFile),new TXT$(")")),false);
        }
        // JavaLine 238 ==> SourceLine 195
        if((!(((PrintFile$)(xf)).close()))) {
            // JavaLine 240 ==> SourceLine 199
            new simtst81$report(((simtst81)CUR$),199,CONC(CONC(new TXT$("'close' returns FALSE (open printfile "),anyOuttypeFile),new TXT$(")")),false);
        } else
        if(((PrintFile$)(xf)).close()) {
            // JavaLine 244 ==> SourceLine 201
            new simtst81$report(((simtst81)CUR$),201,CONC(CONC(new TXT$("'close' returns TRUE (closed printfile "),anyOuttypeFile),new TXT$(")")),false);
        }
        // JavaLine 247 ==> SourceLine 205
        if((!(found_error))) {
            // JavaLine 249 ==> SourceLine 206
            {
                TRACE_BEGIN_STM$("CompoundStatement206",206);
                sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 81"));
                TRACE_END_STM$("CompoundStatement206",206);
            }
        }
        // JavaLine 256 ==> SourceLine 207
        if(verbose) {
            // JavaLine 258 ==> SourceLine 208
            {
                TRACE_BEGIN_STM$("CompoundStatement208",208);
                sysout().outtext(new TXT$("--- END Simula a.s. TEST 81"));
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement208",208);
            }
        }
        TRACE_END_STM$("simtst81",208);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst81(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst81.sim","SimulaProgram simtst81",1,12,11,13,13,14,15,16,17,17,19,18,21,19,34,27,36,28,40,29,42,30,44,31,46,33,48,34,50,35,52,36,54,37,56,38,61,41,63,43,65,45,68,47,70,49,73,51,75,53,78,55,80,59,84,61,87,64,89,66,91,68,94,70,96,72,99,74,101,76,104,78,106,82,110,84,113,87,115,88,117,90,119,92,122,94,124,96,127,98,129,100,132,102,134,106,138,108,141,111,143,113,145,115,148,117,150,119,153,121,155,123,158,125,160,129,164,131,167,134,169,136,171,138,174,140,176,142,179,144,181,146,184,148,186,152,190,154,193,157,195,158,197,160,199,162,202,164,204,166,207,168,209,170,212,172,214,176,218,178,221,181,223,183,225,185,228,187,230,189,233,191,235,193,238,195,240,199,244,201,247,205,249,206,256,207,258,208,274,212);
}
