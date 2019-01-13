// JavaLine 1 ==> SourceLine 13
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Jan 12 15:34:19 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst84 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=13, lastLine=128, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    final boolean verbose=false;
    // JavaLine 11 ==> SourceLine 14
    boolean foundError=false;
    // JavaLine 13 ==> SourceLine 15
    final TXT$ print84=new TXT$("C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/files/print84");
    // JavaLine 15 ==> SourceLine 17
    PrintFile$ myfile=null;
    // JavaLine 17 ==> SourceLine 18
    boolean save=false;
    // JavaLine 19 ==> SourceLine 47
    PrintFile$ inspect$46$0=null;
    // Normal Constructor
    public simtst84(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst84");
        // Declaration Code
        TRACE_BEGIN_DCL$("simtst84",47);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("simtst84",47);
        // JavaLine 32 ==> SourceLine 30
        if(verbose) {
            // JavaLine 34 ==> SourceLine 31
            {
                TRACE_BEGIN_STM$("CompoundStatement31",31);
                sysout().outtext(new TXT$("--- START Simula a.s. TEST 84 (test PRINTFILE)"));
                sysout().outimage();
                // JavaLine 39 ==> SourceLine 32
                sysout().outtext(new TXT$("    The program prints on \"new printfile(print84)\","));
                // JavaLine 41 ==> SourceLine 33
                sysout().outimage();
                // JavaLine 43 ==> SourceLine 34
                sysout().outtext(new TXT$("    compare that output to program source after exec."));
                // JavaLine 45 ==> SourceLine 35
                sysout().outimage();
                // JavaLine 47 ==> SourceLine 36
                sysout().outtext(new TXT$("    In addition, \"OK\" is printed 5 times on sysout."));
                // JavaLine 49 ==> SourceLine 37
                sysout().outimage();
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement31",37);
            }
        }
        // JavaLine 55 ==> SourceLine 40
        myfile=new PrintFile$(((BASICIO$)CTX$),print84).STM$();
        // JavaLine 57 ==> SourceLine 41
        save=(myfile.line()==(0));
        // JavaLine 59 ==> SourceLine 42
        new simtst84$Check(((simtst84)CUR$),save,true);
        // JavaLine 61 ==> SourceLine 43
        myfile.open(blanks(132));
        // JavaLine 63 ==> SourceLine 44
        new simtst84$Check(((simtst84)CUR$),(myfile.line()==(1)),true);
        // JavaLine 65 ==> SourceLine 46
        {
            // BEGIN INSPECTION 
            inspect$46$0=myfile;
            if(inspect$46$0!=null) //INSPECT inspect$46$0
            // JavaLine 70 ==> SourceLine 48
            {
                TRACE_BEGIN_STM$("CompoundStatement48",48);
                inspect$46$0.linesperpage(4);
                // JavaLine 74 ==> SourceLine 49
                inspect$46$0.outtext(new TXT$("LINESPERPAGE:=4    LINE 1."));
                inspect$46$0.outimage();
                // JavaLine 77 ==> SourceLine 50
                inspect$46$0.outtext(new TXT$("      LINE 2."));
                inspect$46$0.outimage();
                // JavaLine 80 ==> SourceLine 51
                inspect$46$0.outtext(new TXT$("      LINE 3."));
                inspect$46$0.outimage();
                // JavaLine 83 ==> SourceLine 52
                inspect$46$0.outtext(new TXT$("      LINE 4."));
                inspect$46$0.outimage();
                // JavaLine 86 ==> SourceLine 53
                inspect$46$0.outtext(new TXT$("      LINE 5."));
                inspect$46$0.outimage();
                // JavaLine 89 ==> SourceLine 54
                inspect$46$0.spacing(0);
                // JavaLine 91 ==> SourceLine 55
                inspect$46$0.outtext(new TXT$("SPACING:=0  LINE 1"));
                inspect$46$0.outimage();
                // JavaLine 94 ==> SourceLine 56
                inspect$46$0.outtext(new TXT$("            LINE  2"));
                inspect$46$0.outimage();
                // JavaLine 97 ==> SourceLine 57
                inspect$46$0.outtext(new TXT$("            LINE   3"));
                inspect$46$0.outimage();
                // JavaLine 100 ==> SourceLine 58
                inspect$46$0.spacing(1);
                // JavaLine 102 ==> SourceLine 59
                inspect$46$0.eject(3);
                // JavaLine 104 ==> SourceLine 60
                inspect$46$0.outtext(new TXT$("EJECT (3)"));
                inspect$46$0.outimage();
                // JavaLine 107 ==> SourceLine 61
                inspect$46$0.eject(2);
                // JavaLine 109 ==> SourceLine 62
                inspect$46$0.outtext(new TXT$("EJECT (2)"));
                inspect$46$0.outimage();
                // JavaLine 112 ==> SourceLine 63
                inspect$46$0.linesperpage(60);
                // JavaLine 114 ==> SourceLine 64
                inspect$46$0.spacing(2);
                // JavaLine 116 ==> SourceLine 65
                inspect$46$0.outtext(new TXT$("LINESPERPAGE:=60,  SPACING:=2"));
                inspect$46$0.outimage();
                // JavaLine 119 ==> SourceLine 66
                inspect$46$0.eject(80);
                // JavaLine 121 ==> SourceLine 67
                inspect$46$0.outtext(new TXT$("EJECT (80),  EQUIV TO EJECT (1)"));
                inspect$46$0.outimage();
                // JavaLine 124 ==> SourceLine 68
                new simtst84$Check(((simtst84)CUR$),(inspect$46$0.pos()==(1)),true);
                // JavaLine 126 ==> SourceLine 69
                new simtst84$Check(((simtst84)CUR$),TXTREL$EQ(inspect$46$0.image,blanks(132)),true);
                // JavaLine 128 ==> SourceLine 70
                new simtst84$Check(((simtst84)CUR$),(inspect$46$0.length()==(132)),true);
                // JavaLine 130 ==> SourceLine 72
                inspect$46$0.outint(123,3);
                // JavaLine 132 ==> SourceLine 73
                inspect$46$0.outfix(456.7f,1,6);
                // JavaLine 134 ==> SourceLine 74
                inspect$46$0.outreal(0.089f,2,9);
                // JavaLine 136 ==> SourceLine 75
                inspect$46$0.outfrac(((int)((int)Math.round(1234.5f))),1,9);
                // JavaLine 138 ==> SourceLine 76
                inspect$46$0.outtext(new TXT$("TEXT "));
                // JavaLine 140 ==> SourceLine 77
                inspect$46$0.outimage();
                // JavaLine 142 ==> SourceLine 80
                inspect$46$0.setpos(130);
                // JavaLine 144 ==> SourceLine 81
                inspect$46$0.outint(123,3);
                // JavaLine 146 ==> SourceLine 82
                inspect$46$0.outchar('*');
                // JavaLine 148 ==> SourceLine 83
                inspect$46$0.setpos(127);
                // JavaLine 150 ==> SourceLine 84
                inspect$46$0.outfix(456.7f,1,6);
                // JavaLine 152 ==> SourceLine 85
                inspect$46$0.outchar('*');
                // JavaLine 154 ==> SourceLine 86
                inspect$46$0.setpos(124);
                // JavaLine 156 ==> SourceLine 87
                inspect$46$0.outreal(0.089f,2,9);
                // JavaLine 158 ==> SourceLine 88
                inspect$46$0.outchar('*');
                // JavaLine 160 ==> SourceLine 89
                inspect$46$0.setpos(124);
                // JavaLine 162 ==> SourceLine 90
                inspect$46$0.outfrac(((int)((int)Math.round(1234.5f))),1,9);
                // JavaLine 164 ==> SourceLine 91
                inspect$46$0.outchar('*');
                // JavaLine 166 ==> SourceLine 92
                inspect$46$0.setpos(129);
                // JavaLine 168 ==> SourceLine 93
                inspect$46$0.outtext(new TXT$("TEXT"));
                // JavaLine 170 ==> SourceLine 94
                inspect$46$0.outchar('*');
                // JavaLine 172 ==> SourceLine 97
                inspect$46$0.setpos(131);
                // JavaLine 174 ==> SourceLine 98
                inspect$46$0.outint(123,3);
                // JavaLine 176 ==> SourceLine 99
                inspect$46$0.setpos(129);
                // JavaLine 178 ==> SourceLine 100
                inspect$46$0.outfix(456.7f,1,6);
                // JavaLine 180 ==> SourceLine 101
                inspect$46$0.setpos(127);
                // JavaLine 182 ==> SourceLine 102
                inspect$46$0.outreal(0.089f,2,9);
                // JavaLine 184 ==> SourceLine 103
                inspect$46$0.setpos(127);
                // JavaLine 186 ==> SourceLine 104
                inspect$46$0.outfrac(((int)((int)Math.round(1234.5f))),1,9);
                // JavaLine 188 ==> SourceLine 105
                inspect$46$0.setpos(130);
                // JavaLine 190 ==> SourceLine 106
                inspect$46$0.outtext(new TXT$("TEXT"));
                // JavaLine 192 ==> SourceLine 107
                inspect$46$0.setpos(132);
                // JavaLine 194 ==> SourceLine 108
                inspect$46$0.outchar('X');
                // JavaLine 196 ==> SourceLine 109
                inspect$46$0.outchar('Y');
                // JavaLine 198 ==> SourceLine 110
                inspect$46$0.setpos(199);
                // JavaLine 200 ==> SourceLine 111
                inspect$46$0.outchar('Z');
                // JavaLine 202 ==> SourceLine 112
                inspect$46$0.setpos(120);
                // JavaLine 204 ==> SourceLine 113
                inspect$46$0.outchar('A');
                // JavaLine 206 ==> SourceLine 114
                inspect$46$0.setpos(81);
                // JavaLine 208 ==> SourceLine 115
                inspect$46$0.outchar('B');
                // JavaLine 210 ==> SourceLine 116
                inspect$46$0.outimage();
                // JavaLine 212 ==> SourceLine 117
                inspect$46$0.outtext(new TXT$("LAST LINE OF OUTPUT."));
                // JavaLine 214 ==> SourceLine 118
                inspect$46$0.close();
                TRACE_END_STM$("CompoundStatement48",118);
            }
        }
        // JavaLine 219 ==> SourceLine 121
        if(foundError) {
            // JavaLine 221 ==> SourceLine 122
            {
                TRACE_BEGIN_STM$("CompoundStatement122",122);
                if(verbose) {
                    // JavaLine 225 ==> SourceLine 123
                    {
                        TRACE_BEGIN_STM$("CompoundStatement123",123);
                        sysout().outtext(new TXT$("--- END Simula TEST 84 WITH ERROR(S)"));
                        TRACE_END_STM$("CompoundStatement123",123);
                    }
                }
                TRACE_END_STM$("CompoundStatement122",123);
            }
        } else
        // JavaLine 235 ==> SourceLine 125
        sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 84"));
        TRACE_END_STM$("simtst84",125);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst84(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst84.sim","SimulaProgram simtst84",1,13,11,14,13,15,15,17,17,18,19,47,32,30,34,31,39,32,41,33,43,34,45,35,47,36,49,37,55,40,57,41,59,42,61,43,63,44,65,46,70,48,74,49,77,50,80,51,83,52,86,53,89,54,91,55,94,56,97,57,100,58,102,59,104,60,107,61,109,62,112,63,114,64,116,65,119,66,121,67,124,68,126,69,128,70,130,72,132,73,134,74,136,75,138,76,140,77,142,80,144,81,146,82,148,83,150,84,152,85,154,86,156,87,158,88,160,89,162,90,164,91,166,92,168,93,170,94,172,97,174,98,176,99,178,100,180,101,182,102,184,103,186,104,188,105,190,106,192,107,194,108,196,109,198,110,200,111,202,112,204,113,206,114,208,115,210,116,212,117,214,118,219,121,221,122,225,123,235,125,245,128);
}
