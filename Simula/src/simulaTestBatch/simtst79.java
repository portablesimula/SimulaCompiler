// JavaLine 1 ==> SourceLine 26
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Jan 12 15:27:27 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst79 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=26, lastLine=174, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    boolean found_error=false;
    // JavaLine 11 ==> SourceLine 27
    final boolean verbose=false;
    // JavaLine 13 ==> SourceLine 29
    final TXT$ anyExistingDirectfile=new TXT$("C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/files/anyExistingDirectfile79");
    // JavaLine 15 ==> SourceLine 30
    final TXT$ anyImageFile=new TXT$("C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/files/anyImageFile79");
    // JavaLine 17 ==> SourceLine 32
    final TXT$ anyExistingImageFile=new TXT$("C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/files/anyExistingImageFile79");
    // JavaLine 19 ==> SourceLine 33
    final TXT$ anyExitingByteFile=new TXT$("C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/files/anyExistingByteFile79");
    // JavaLine 21 ==> SourceLine 34
    final TXT$ anyOutFile=new TXT$("C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/files/anyOutFile79");
    // JavaLine 23 ==> SourceLine 35
    final TXT$ anyOutByteFile=new TXT$("C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/files/anyOutByteFile79");
    // JavaLine 25 ==> SourceLine 36
    final TXT$ anyPrintFile=new TXT$("C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/files/anyPrintFile79");
    // JavaLine 27 ==> SourceLine 37
    final TXT$ anyDirectByteFile=new TXT$("C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/files/anyDirectByteFile79");
    // JavaLine 29 ==> SourceLine 39
    FILE$ xf=null;
    // JavaLine 31 ==> SourceLine 40
    int i=0;
    // Normal Constructor
    public simtst79(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst79");
        // Declaration Code
        TRACE_BEGIN_DCL$("simtst79",58);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("simtst79",58);
        // JavaLine 44 ==> SourceLine 62
        if(verbose) {
            // JavaLine 46 ==> SourceLine 63
            {
                TRACE_BEGIN_STM$("CompoundStatement63",63);
                sysout().outtext(new TXT$("--- START Simula a.s. TEST 79"));
                // JavaLine 50 ==> SourceLine 64
                sysout().outimage();
                // JavaLine 52 ==> SourceLine 65
                sysout().outtext(new TXT$("--- Test the attribute 'IsOpen' of class file."));
                // JavaLine 54 ==> SourceLine 66
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement63",66);
            }
        }
        // JavaLine 59 ==> SourceLine 70
        xf=new OutFile$(((BASICIO$)CTX$),anyImageFile).STM$();
        // JavaLine 61 ==> SourceLine 71
        ((OutFile$)(xf)).open(blanks(10));
        // JavaLine 63 ==> SourceLine 72
        for(boolean CB$72:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(0); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(30); }})
           )) { if(!CB$72) continue;
        ((OutFile$)(xf)).outint(i,4);
    }
    // JavaLine 69 ==> SourceLine 73
    ((OutFile$)(xf)).outimage();
    // JavaLine 71 ==> SourceLine 74
    ((OutFile$)(xf)).close();
    // JavaLine 73 ==> SourceLine 76
    xf=new InFile$(((BASICIO$)CTX$),anyImageFile).STM$();
    // JavaLine 75 ==> SourceLine 77
    new simtst79$Test(((simtst79)CUR$),77,xf.isopen(),false,1);
    // JavaLine 77 ==> SourceLine 79
    ((InFile$)(xf)).open(blanks(10));
    // JavaLine 79 ==> SourceLine 80
    new simtst79$Test(((simtst79)CUR$),80,xf.isopen(),true,2);
    // JavaLine 81 ==> SourceLine 82
    xf=new InFile$(((BASICIO$)CTX$),anyExistingImageFile).STM$();
    // JavaLine 83 ==> SourceLine 83
    new simtst79$Test(((simtst79)CUR$),83,xf.isopen(),false,3);
    // JavaLine 85 ==> SourceLine 85
    if((!(((InFile$)(xf)).open(blanks(80))))) {
        // JavaLine 87 ==> SourceLine 87
        new simtst79$Test(((simtst79)CUR$),87,xf.isopen(),false,4);
    } else
    new simtst79$Test(((simtst79)CUR$),87,xf.isopen(),true,5);
    // JavaLine 91 ==> SourceLine 89
    ((InFile$)(xf)).close();
    // JavaLine 93 ==> SourceLine 90
    new simtst79$Test(((simtst79)CUR$),90,xf.isopen(),false,6);
    // JavaLine 95 ==> SourceLine 92
    xf=new InbyteFile$(((BASICIO$)CTX$),new TXT$("sxcvzfb")).STM$();
    // JavaLine 97 ==> SourceLine 93
    new simtst79$Test(((simtst79)CUR$),93,xf.isopen(),false,7);
    // JavaLine 99 ==> SourceLine 95
    ((InbyteFile$)(xf)).open();
    // JavaLine 101 ==> SourceLine 96
    new simtst79$Test(((simtst79)CUR$),96,xf.isopen(),false,8);
    // JavaLine 103 ==> SourceLine 98
    xf=new InbyteFile$(((BASICIO$)CTX$),anyExitingByteFile).STM$();
    // JavaLine 105 ==> SourceLine 99
    new simtst79$Test(((simtst79)CUR$),99,xf.isopen(),false,9);
    // JavaLine 107 ==> SourceLine 101
    if((!(((InbyteFile$)(xf)).open()))) {
        // JavaLine 109 ==> SourceLine 103
        new simtst79$Test(((simtst79)CUR$),103,xf.isopen(),false,10);
    } else
    new simtst79$Test(((simtst79)CUR$),103,xf.isopen(),true,11);
    // JavaLine 113 ==> SourceLine 105
    ((InbyteFile$)(xf)).close();
    // JavaLine 115 ==> SourceLine 106
    new simtst79$Test(((simtst79)CUR$),106,xf.isopen(),false,12);
    // JavaLine 117 ==> SourceLine 109
    xf=new OutFile$(((BASICIO$)CTX$),anyOutFile).STM$();
    // JavaLine 119 ==> SourceLine 110
    new simtst79$Test(((simtst79)CUR$),110,xf.isopen(),false,13);
    // JavaLine 121 ==> SourceLine 112
    if((!(((OutFile$)(xf)).open(blanks(80))))) {
        // JavaLine 123 ==> SourceLine 114
        new simtst79$Test(((simtst79)CUR$),114,xf.isopen(),false,14);
    } else
    new simtst79$Test(((simtst79)CUR$),114,xf.isopen(),true,15);
    // JavaLine 127 ==> SourceLine 116
    ((OutFile$)(xf)).close();
    // JavaLine 129 ==> SourceLine 117
    new simtst79$Test(((simtst79)CUR$),117,xf.isopen(),false,16);
    // JavaLine 131 ==> SourceLine 120
    xf=new OutbyteFile$(((BASICIO$)CTX$),anyOutByteFile).STM$();
    // JavaLine 133 ==> SourceLine 121
    new simtst79$Test(((simtst79)CUR$),121,xf.isopen(),false,17);
    // JavaLine 135 ==> SourceLine 123
    if((!(((OutbyteFile$)(xf)).open()))) {
        // JavaLine 137 ==> SourceLine 125
        new simtst79$Test(((simtst79)CUR$),125,xf.isopen(),false,18);
    } else
    new simtst79$Test(((simtst79)CUR$),125,xf.isopen(),true,19);
    // JavaLine 141 ==> SourceLine 127
    ((OutbyteFile$)(xf)).close();
    // JavaLine 143 ==> SourceLine 128
    new simtst79$Test(((simtst79)CUR$),128,xf.isopen(),false,20);
    // JavaLine 145 ==> SourceLine 130
    xf=new DirectFile$(((BASICIO$)CTX$),anyExistingDirectfile).STM$();
    // JavaLine 147 ==> SourceLine 131
    new simtst79$Test(((simtst79)CUR$),131,xf.isopen(),false,21);
    // JavaLine 149 ==> SourceLine 133
    if((!(((DirectFile$)(xf)).open(blanks(10))))) {
        // JavaLine 151 ==> SourceLine 135
        new simtst79$Test(((simtst79)CUR$),135,xf.isopen(),false,22);
    } else
    new simtst79$Test(((simtst79)CUR$),135,xf.isopen(),true,23);
    // JavaLine 155 ==> SourceLine 137
    ((DirectFile$)(xf)).close();
    // JavaLine 157 ==> SourceLine 138
    new simtst79$Test(((simtst79)CUR$),138,xf.isopen(),false,24);
    // JavaLine 159 ==> SourceLine 141
    xf=new DirectByteFile$(((BASICIO$)CTX$),anyDirectByteFile).STM$();
    // JavaLine 161 ==> SourceLine 142
    xf.setaccess(new TXT$("CREATE"));
    // JavaLine 163 ==> SourceLine 145
    if((!(((DirectByteFile$)(xf)).open()))) {
        // JavaLine 165 ==> SourceLine 147
        new simtst79$Test(((simtst79)CUR$),147,xf.isopen(),false,26);
    } else
    new simtst79$Test(((simtst79)CUR$),147,xf.isopen(),true,27);
    // JavaLine 169 ==> SourceLine 149
    ((DirectByteFile$)(xf)).close();
    // JavaLine 171 ==> SourceLine 150
    new simtst79$Test(((simtst79)CUR$),150,xf.isopen(),false,28);
    // JavaLine 173 ==> SourceLine 152
    xf=new PrintFile$(((BASICIO$)CTX$),anyPrintFile).STM$();
    // JavaLine 175 ==> SourceLine 153
    new simtst79$Test(((simtst79)CUR$),153,xf.isopen(),false,29);
    // JavaLine 177 ==> SourceLine 155
    if((!(((PrintFile$)(xf)).open(blanks(136))))) {
        // JavaLine 179 ==> SourceLine 157
        new simtst79$Test(((simtst79)CUR$),157,xf.isopen(),false,30);
    } else
    new simtst79$Test(((simtst79)CUR$),157,xf.isopen(),true,31);
    // JavaLine 183 ==> SourceLine 159
    ((PrintFile$)(xf)).close();
    // JavaLine 185 ==> SourceLine 160
    new simtst79$Test(((simtst79)CUR$),160,xf.isopen(),false,32);
    // JavaLine 187 ==> SourceLine 162
    if(found_error) {
    } else
    // JavaLine 190 ==> SourceLine 165
    {
        TRACE_BEGIN_STM$("CompoundStatement165",165);
        sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 79"));
        TRACE_END_STM$("CompoundStatement165",165);
    }
    // JavaLine 196 ==> SourceLine 168
    if(verbose) {
        // JavaLine 198 ==> SourceLine 169
        {
            TRACE_BEGIN_STM$("CompoundStatement169",169);
            sysout().outtext(new TXT$("--- END Simula a.s. TEST 79"));
            // JavaLine 202 ==> SourceLine 174
            sysout().outimage();
            TRACE_END_STM$("CompoundStatement169",174);
        }
    }
    TRACE_END_STM$("simtst79",174);
    EBLK();
    return(null);
} // End of SimulaProgram Statements

public static void main(String[] args) {
    RT.setRuntimeOptions(args);
    new simtst79(CTX$).STM$();
}
public static PROGINFO$ INFO$=new PROGINFO$("simtst79.sim","SimulaProgram simtst79",1,26,11,27,13,29,15,30,17,32,19,33,21,34,23,35,25,36,27,37,29,39,31,40,44,62,46,63,50,64,52,65,54,66,59,70,61,71,63,72,69,73,71,74,73,76,75,77,77,79,79,80,81,82,83,83,85,85,87,87,91,89,93,90,95,92,97,93,99,95,101,96,103,98,105,99,107,101,109,103,113,105,115,106,117,109,119,110,121,112,123,114,127,116,129,117,131,120,133,121,135,123,137,125,141,127,143,128,145,130,147,131,149,133,151,135,155,137,157,138,159,141,161,142,163,145,165,147,169,149,171,150,173,152,175,153,177,155,179,157,183,159,185,160,187,162,190,165,196,168,198,169,202,174,215,174);
}
