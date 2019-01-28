// JavaLine 1 ==> SourceLine 2
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Jan 26 19:59:46 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc05 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=2, lastLine=200, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    FILE$ xf=null;
    // JavaLine 11 ==> SourceLine 3
    boolean found_error=false;
    // JavaLine 13 ==> SourceLine 4
    final boolean verbose=false;
    // JavaLine 15 ==> SourceLine 6
    final TXT$ anyIntypeFile=new TXT$("C:/GitHub/SimulaCompiler/Simula/src/testing/batch/files/any8189");
    // Normal Constructor
    public adHoc05(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("adHoc05");
        // Declaration Code
        TRACE_BEGIN_DCL$("adHoc05",11);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("adHoc05",11);
        // JavaLine 28 ==> SourceLine 14
        if(verbose) {
            // JavaLine 30 ==> SourceLine 15
            {
                TRACE_BEGIN_STM$("CompoundStatement15",15);
                sysout().outtext(new TXT$("--- START Simula a.s. TEST 81 (Test 'open' and 'close')"));
                // JavaLine 34 ==> SourceLine 16
                sysout().outimage();
                // JavaLine 36 ==> SourceLine 17
                sysout().outtext(new TXT$("    file \"any8189\" is opened as infile and inbytefile"));
                // JavaLine 38 ==> SourceLine 18
                sysout().outimage();
                // JavaLine 40 ==> SourceLine 20
                sysout().outtext(new TXT$("    file \"sxcvz1\" is opened as outfile, printfile and outbytefile"));
                // JavaLine 42 ==> SourceLine 21
                sysout().outimage();
                // JavaLine 44 ==> SourceLine 22
                sysout().outtext(new TXT$("    file \"sxcvz2\" is opened as directfile"));
                // JavaLine 46 ==> SourceLine 23
                sysout().outimage();
                // JavaLine 48 ==> SourceLine 24
                sysout().outtext(new TXT$("    file \"sxcvz3\" is opened as directbytefile"));
                // JavaLine 50 ==> SourceLine 25
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement15",25);
            }
        }
        // JavaLine 55 ==> SourceLine 28
        xf=new InFile$(((BASICIO$)CTX$),anyIntypeFile).STM$();
        // JavaLine 57 ==> SourceLine 30
        if(((InFile$)(xf)).close()) {
            // JavaLine 59 ==> SourceLine 32
            new adHoc05$report(((adHoc05)CUR$),32,new TXT$("'close' returns TRUE (never-opened infile \"any8189\")"),false);
        }
        // JavaLine 62 ==> SourceLine 34
        if((!(((InFile$)(xf)).open(blanks(80))))) {
            // JavaLine 64 ==> SourceLine 36
            new adHoc05$report(((adHoc05)CUR$),36,new TXT$("'open' returns FALSE (never-opened infile \"any8189\")"),true);
        }
        // JavaLine 67 ==> SourceLine 38
        if(((InFile$)(xf)).open(blanks(80))) {
            // JavaLine 69 ==> SourceLine 40
            new adHoc05$report(((adHoc05)CUR$),40,new TXT$("'open' returns TRUE (on open infile \"any8189\")"),false);
        }
        // JavaLine 72 ==> SourceLine 42
        if((!(((InFile$)(xf)).close()))) {
            // JavaLine 74 ==> SourceLine 46
            new adHoc05$report(((adHoc05)CUR$),46,new TXT$("'close' returns FALSE (open infile \"any8189\")"),false);
        } else
        if(((InFile$)(xf)).close()) {
            // JavaLine 78 ==> SourceLine 48
            new adHoc05$report(((adHoc05)CUR$),48,new TXT$("'close' returns TRUE (closed infile \"any8189\")"),false);
        }
        // JavaLine 81 ==> SourceLine 51
        xf=new OutFile$(((BASICIO$)CTX$),new TXT$("sxcvz1")).STM$();
        // JavaLine 83 ==> SourceLine 53
        if(((OutFile$)(xf)).close()) {
            // JavaLine 85 ==> SourceLine 55
            new adHoc05$report(((adHoc05)CUR$),55,new TXT$("'close' returns TRUE (never-opened outfile \"sxcvz1\")"),false);
        }
        // JavaLine 88 ==> SourceLine 57
        if((!(((OutFile$)(xf)).open(blanks(80))))) {
            // JavaLine 90 ==> SourceLine 59
            new adHoc05$report(((adHoc05)CUR$),59,new TXT$("'open' returns FALSE (never-opened outfile \"sxcvz1\")"),true);
        }
        // JavaLine 93 ==> SourceLine 61
        if(((OutFile$)(xf)).open(blanks(80))) {
            // JavaLine 95 ==> SourceLine 63
            new adHoc05$report(((adHoc05)CUR$),63,new TXT$("'open' returns TRUE (open outfile \"sxcvz11\")"),false);
        }
        // JavaLine 98 ==> SourceLine 65
        if((!(((OutFile$)(xf)).close()))) {
            // JavaLine 100 ==> SourceLine 69
            new adHoc05$report(((adHoc05)CUR$),69,new TXT$("'close' returns FALSE (open outfile \"sxcvz1\")"),false);
        } else
        if(((OutFile$)(xf)).close()) {
            // JavaLine 104 ==> SourceLine 71
            new adHoc05$report(((adHoc05)CUR$),71,new TXT$("'close' returns TRUE (closed outfile \"sxcvz1\")"),false);
        }
        // JavaLine 107 ==> SourceLine 74
        xf=new DirectFile$(((BASICIO$)CTX$),new TXT$("sxcvz2")).STM$();
        // JavaLine 109 ==> SourceLine 75
        xf.setaccess(new TXT$("CREATE"));
        // JavaLine 111 ==> SourceLine 77
        if(((DirectFile$)(xf)).close()) {
            // JavaLine 113 ==> SourceLine 79
            new adHoc05$report(((adHoc05)CUR$),79,new TXT$("'close' returns TRUE (never-opened directfile \"sxcvz2\")"),false);
        }
        // JavaLine 116 ==> SourceLine 81
        if((!(((DirectFile$)(xf)).open(blanks(80))))) {
            // JavaLine 118 ==> SourceLine 83
            new adHoc05$report(((adHoc05)CUR$),83,new TXT$("'open' returns FALSE (never-opened directfile \"sxcvz2\")"),true);
        }
        // JavaLine 121 ==> SourceLine 85
        if(((DirectFile$)(xf)).open(blanks(80))) {
            // JavaLine 123 ==> SourceLine 87
            new adHoc05$report(((adHoc05)CUR$),87,new TXT$("'open' returns TRUE (open directfile \"sxcvz2\")"),false);
        }
        // JavaLine 126 ==> SourceLine 89
        if((!(((DirectFile$)(xf)).close()))) {
            // JavaLine 128 ==> SourceLine 93
            new adHoc05$report(((adHoc05)CUR$),93,new TXT$("'close' returns FALSE (open directfile \"sxcvz2\")"),false);
        } else
        if(((DirectFile$)(xf)).close()) {
            // JavaLine 132 ==> SourceLine 95
            new adHoc05$report(((adHoc05)CUR$),95,new TXT$("'close' returns TRUE (closed directfile \"sxcvz2\")"),false);
        }
        // JavaLine 135 ==> SourceLine 99
        xf=new InbyteFile$(((BASICIO$)CTX$),anyIntypeFile).STM$();
        // JavaLine 137 ==> SourceLine 101
        if(((InbyteFile$)(xf)).close()) {
            // JavaLine 139 ==> SourceLine 103
            new adHoc05$report(((adHoc05)CUR$),103,new TXT$("'close' returns TRUE (never-opened inbytefile \"any8189\")"),false);
        }
        // JavaLine 142 ==> SourceLine 105
        if((!(((InbyteFile$)(xf)).open()))) {
            // JavaLine 144 ==> SourceLine 107
            new adHoc05$report(((adHoc05)CUR$),107,new TXT$("'open' returns FALSE (never-opened inbytefile \"any8189\")"),true);
        }
        // JavaLine 147 ==> SourceLine 109
        if(((InbyteFile$)(xf)).open()) {
            // JavaLine 149 ==> SourceLine 111
            new adHoc05$report(((adHoc05)CUR$),111,new TXT$("'open' returns TRUE (on open inbytefile \"any8189\")"),false);
        }
        // JavaLine 152 ==> SourceLine 113
        if((!(((InbyteFile$)(xf)).close()))) {
            // JavaLine 154 ==> SourceLine 117
            new adHoc05$report(((adHoc05)CUR$),117,new TXT$("'close' returns FALSE (open inbytefile \"any8189\")"),false);
        } else
        if(((InbyteFile$)(xf)).close()) {
            // JavaLine 158 ==> SourceLine 119
            new adHoc05$report(((adHoc05)CUR$),119,new TXT$("'close' returns TRUE (closed inbytefile \"any8189\")"),false);
        }
        // JavaLine 161 ==> SourceLine 122
        xf=new OutbyteFile$(((BASICIO$)CTX$),new TXT$("sxcvz1")).STM$();
        // JavaLine 163 ==> SourceLine 124
        if(((OutbyteFile$)(xf)).close()) {
            // JavaLine 165 ==> SourceLine 126
            new adHoc05$report(((adHoc05)CUR$),126,new TXT$("'close' returns TRUE (never-opened outbytefile \"sxcvz1\")"),false);
        }
        // JavaLine 168 ==> SourceLine 128
        if((!(((OutbyteFile$)(xf)).open()))) {
            // JavaLine 170 ==> SourceLine 130
            new adHoc05$report(((adHoc05)CUR$),130,new TXT$("'open' returns FALSE (never-opened outbytefile \"sxcvz1\")"),true);
        }
        // JavaLine 173 ==> SourceLine 132
        if(((OutbyteFile$)(xf)).open()) {
            // JavaLine 175 ==> SourceLine 134
            new adHoc05$report(((adHoc05)CUR$),134,new TXT$("'open' returns TRUE (on open outbytefile \"sxcvz1\")"),false);
        }
        // JavaLine 178 ==> SourceLine 136
        if((!(((OutbyteFile$)(xf)).close()))) {
            // JavaLine 180 ==> SourceLine 140
            new adHoc05$report(((adHoc05)CUR$),140,new TXT$("'close' returns FALSE (open outbytefile \"sxcvz1\")"),false);
        } else
        if(((OutbyteFile$)(xf)).close()) {
            // JavaLine 184 ==> SourceLine 142
            new adHoc05$report(((adHoc05)CUR$),142,new TXT$("'close' returns TRUE (closed outbytefile \"sxcvz1\")"),false);
        }
        // JavaLine 187 ==> SourceLine 145
        xf=new DirectByteFile$(((BASICIO$)CTX$),new TXT$("sxcvz3")).STM$();
        // JavaLine 189 ==> SourceLine 146
        xf.setaccess(new TXT$("CREATE"));
        // JavaLine 191 ==> SourceLine 148
        if(((DirectByteFile$)(xf)).close()) {
            // JavaLine 193 ==> SourceLine 150
            new adHoc05$report(((adHoc05)CUR$),150,new TXT$("'close' returns TRUE (never-opened directbytefile \"sxcvz3\")"),false);
        }
        // JavaLine 196 ==> SourceLine 152
        if((!(((DirectByteFile$)(xf)).open()))) {
            // JavaLine 198 ==> SourceLine 154
            new adHoc05$report(((adHoc05)CUR$),154,new TXT$("'open' returns FALSE (never-opened directbytefile \"sxcvz3\")"),true);
        }
        // JavaLine 201 ==> SourceLine 156
        if(((DirectByteFile$)(xf)).open()) {
            // JavaLine 203 ==> SourceLine 158
            new adHoc05$report(((adHoc05)CUR$),158,new TXT$("'open' returns TRUE (on open directbytefile \"sxcvz3\")"),false);
        }
        // JavaLine 206 ==> SourceLine 160
        if((!(((DirectByteFile$)(xf)).close()))) {
            // JavaLine 208 ==> SourceLine 164
            new adHoc05$report(((adHoc05)CUR$),164,new TXT$("'close' returns FALSE (open directbytefile \"sxcvz3\")"),false);
        } else
        if(((DirectByteFile$)(xf)).close()) {
            // JavaLine 212 ==> SourceLine 166
            new adHoc05$report(((adHoc05)CUR$),166,new TXT$("'close' returns TRUE (closed directbytefile \"sxcvz2\")"),false);
        }
        // JavaLine 215 ==> SourceLine 169
        xf=new PrintFile$(((BASICIO$)CTX$),new TXT$("sxcvz1")).STM$();
        // JavaLine 217 ==> SourceLine 171
        if(((PrintFile$)(xf)).close()) {
            // JavaLine 219 ==> SourceLine 173
            new adHoc05$report(((adHoc05)CUR$),173,new TXT$("'close' returns TRUE (never-opened printfile \"sxcvz1\")"),false);
        }
        // JavaLine 222 ==> SourceLine 175
        if((!(((PrintFile$)(xf)).open(blanks(80))))) {
            // JavaLine 224 ==> SourceLine 177
            new adHoc05$report(((adHoc05)CUR$),177,new TXT$("'open' returns FALSE (never-opened printfile \"sxcvz1\")"),true);
        }
        // JavaLine 227 ==> SourceLine 179
        if(((PrintFile$)(xf)).open(blanks(80))) {
            // JavaLine 229 ==> SourceLine 181
            new adHoc05$report(((adHoc05)CUR$),181,new TXT$("'open' returns TRUE (on open printfile \"sxcvz1\")"),false);
        }
        // JavaLine 232 ==> SourceLine 183
        if((!(((PrintFile$)(xf)).close()))) {
            // JavaLine 234 ==> SourceLine 187
            new adHoc05$report(((adHoc05)CUR$),187,new TXT$("'close' returns FALSE (open printfile \"sxcvz1\")"),false);
        } else
        if(((PrintFile$)(xf)).close()) {
            // JavaLine 238 ==> SourceLine 189
            new adHoc05$report(((adHoc05)CUR$),189,new TXT$("'close' returns TRUE (closed printfile \"sxcvz1\")"),false);
        }
        // JavaLine 241 ==> SourceLine 193
        if((!(found_error))) {
            // JavaLine 243 ==> SourceLine 194
            {
                TRACE_BEGIN_STM$("CompoundStatement194",194);
                sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 81"));
                TRACE_END_STM$("CompoundStatement194",194);
            }
        }
        // JavaLine 250 ==> SourceLine 195
        if(verbose) {
            // JavaLine 252 ==> SourceLine 196
            {
                TRACE_BEGIN_STM$("CompoundStatement196",196);
                sysout().outtext(new TXT$("--- END Simula a.s. TEST 81"));
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement196",196);
            }
        }
        TRACE_END_STM$("adHoc05",196);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new adHoc05(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc05.sim","SimulaProgram adHoc05",1,2,11,3,13,4,15,6,28,14,30,15,34,16,36,17,38,18,40,20,42,21,44,22,46,23,48,24,50,25,55,28,57,30,59,32,62,34,64,36,67,38,69,40,72,42,74,46,78,48,81,51,83,53,85,55,88,57,90,59,93,61,95,63,98,65,100,69,104,71,107,74,109,75,111,77,113,79,116,81,118,83,121,85,123,87,126,89,128,93,132,95,135,99,137,101,139,103,142,105,144,107,147,109,149,111,152,113,154,117,158,119,161,122,163,124,165,126,168,128,170,130,173,132,175,134,178,136,180,140,184,142,187,145,189,146,191,148,193,150,196,152,198,154,201,156,203,158,206,160,208,164,212,166,215,169,217,171,219,173,222,175,224,177,227,179,229,181,232,183,234,187,238,189,241,193,243,194,250,195,252,196,269,200);
}
