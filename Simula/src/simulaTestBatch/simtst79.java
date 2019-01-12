// JavaLine 1 ==> SourceLine 26
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Jan 12 12:23:27 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst79 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=26, lastLine=166, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    boolean found_error=false;
    // JavaLine 11 ==> SourceLine 27
    final boolean verbose=false;
    // JavaLine 13 ==> SourceLine 29
    final TXT$ anyExistingDirectfile=new TXT$("C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/files/anyExistingDirectfile");
    // JavaLine 15 ==> SourceLine 31
    FILE$ xf=null;
    // JavaLine 17 ==> SourceLine 32
    int i=0;
    // Normal Constructor
    public simtst79(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst79");
        // Declaration Code
        TRACE_BEGIN_DCL$("simtst79",50);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("simtst79",50);
        // JavaLine 30 ==> SourceLine 54
        if(verbose) {
            // JavaLine 32 ==> SourceLine 55
            {
                TRACE_BEGIN_STM$("CompoundStatement55",55);
                sysout().outtext(new TXT$("--- START Simula a.s. TEST 79"));
                // JavaLine 36 ==> SourceLine 56
                sysout().outimage();
                // JavaLine 38 ==> SourceLine 57
                sysout().outtext(new TXT$("--- Test the attribute 'IsOpen' of class file."));
                // JavaLine 40 ==> SourceLine 58
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement55",58);
            }
        }
        // JavaLine 45 ==> SourceLine 62
        xf=new OutFile$(((BASICIO$)CTX$),new TXT$("sxcvzf")).STM$();
        // JavaLine 47 ==> SourceLine 63
        ((OutFile$)(xf)).open(blanks(10));
        // JavaLine 49 ==> SourceLine 64
        for(boolean CB$64:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(0); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(30); }})
           )) { if(!CB$64) continue;
        ((OutFile$)(xf)).outint(i,4);
    }
    // JavaLine 55 ==> SourceLine 65
    ((OutFile$)(xf)).outimage();
    // JavaLine 57 ==> SourceLine 66
    ((OutFile$)(xf)).close();
    // JavaLine 59 ==> SourceLine 68
    xf=new InFile$(((BASICIO$)CTX$),new TXT$("sxcvzf")).STM$();
    // JavaLine 61 ==> SourceLine 69
    new simtst79$Test(((simtst79)CUR$),69,xf.isopen(),false,1);
    // JavaLine 63 ==> SourceLine 71
    ((InFile$)(xf)).open(blanks(10));
    // JavaLine 65 ==> SourceLine 72
    new simtst79$Test(((simtst79)CUR$),72,xf.isopen(),true,2);
    // JavaLine 67 ==> SourceLine 74
    xf=new InFile$(((BASICIO$)CTX$),new TXT$("sxcvzg")).STM$();
    // JavaLine 69 ==> SourceLine 75
    new simtst79$Test(((simtst79)CUR$),75,xf.isopen(),false,3);
    // JavaLine 71 ==> SourceLine 77
    if((!(((InFile$)(xf)).open(blanks(80))))) {
        // JavaLine 73 ==> SourceLine 79
        new simtst79$Test(((simtst79)CUR$),79,xf.isopen(),false,4);
    } else
    new simtst79$Test(((simtst79)CUR$),79,xf.isopen(),true,5);
    // JavaLine 77 ==> SourceLine 81
    ((InFile$)(xf)).close();
    // JavaLine 79 ==> SourceLine 82
    new simtst79$Test(((simtst79)CUR$),82,xf.isopen(),false,6);
    // JavaLine 81 ==> SourceLine 84
    xf=new InbyteFile$(((BASICIO$)CTX$),new TXT$("sxcvzfb")).STM$();
    // JavaLine 83 ==> SourceLine 85
    new simtst79$Test(((simtst79)CUR$),85,xf.isopen(),false,7);
    // JavaLine 85 ==> SourceLine 87
    ((InbyteFile$)(xf)).open();
    // JavaLine 87 ==> SourceLine 88
    new simtst79$Test(((simtst79)CUR$),88,xf.isopen(),false,8);
    // JavaLine 89 ==> SourceLine 90
    xf=new InbyteFile$(((BASICIO$)CTX$),new TXT$("sxcvzgb")).STM$();
    // JavaLine 91 ==> SourceLine 91
    new simtst79$Test(((simtst79)CUR$),91,xf.isopen(),false,9);
    // JavaLine 93 ==> SourceLine 93
    if((!(((InbyteFile$)(xf)).open()))) {
        // JavaLine 95 ==> SourceLine 95
        new simtst79$Test(((simtst79)CUR$),95,xf.isopen(),false,10);
    } else
    new simtst79$Test(((simtst79)CUR$),95,xf.isopen(),true,11);
    // JavaLine 99 ==> SourceLine 97
    ((InbyteFile$)(xf)).close();
    // JavaLine 101 ==> SourceLine 98
    new simtst79$Test(((simtst79)CUR$),98,xf.isopen(),false,12);
    // JavaLine 103 ==> SourceLine 101
    xf=new OutFile$(((BASICIO$)CTX$),new TXT$("sxcvz1")).STM$();
    // JavaLine 105 ==> SourceLine 102
    new simtst79$Test(((simtst79)CUR$),102,xf.isopen(),false,13);
    // JavaLine 107 ==> SourceLine 104
    if((!(((OutFile$)(xf)).open(blanks(80))))) {
        // JavaLine 109 ==> SourceLine 106
        new simtst79$Test(((simtst79)CUR$),106,xf.isopen(),false,14);
    } else
    new simtst79$Test(((simtst79)CUR$),106,xf.isopen(),true,15);
    // JavaLine 113 ==> SourceLine 108
    ((OutFile$)(xf)).close();
    // JavaLine 115 ==> SourceLine 109
    new simtst79$Test(((simtst79)CUR$),109,xf.isopen(),false,16);
    // JavaLine 117 ==> SourceLine 112
    xf=new OutbyteFile$(((BASICIO$)CTX$),new TXT$("sxcvz2")).STM$();
    // JavaLine 119 ==> SourceLine 113
    new simtst79$Test(((simtst79)CUR$),113,xf.isopen(),false,17);
    // JavaLine 121 ==> SourceLine 115
    if((!(((OutbyteFile$)(xf)).open()))) {
        // JavaLine 123 ==> SourceLine 117
        new simtst79$Test(((simtst79)CUR$),117,xf.isopen(),false,18);
    } else
    new simtst79$Test(((simtst79)CUR$),117,xf.isopen(),true,19);
    // JavaLine 127 ==> SourceLine 119
    ((OutbyteFile$)(xf)).close();
    // JavaLine 129 ==> SourceLine 120
    new simtst79$Test(((simtst79)CUR$),120,xf.isopen(),false,20);
    // JavaLine 131 ==> SourceLine 122
    xf=new DirectFile$(((BASICIO$)CTX$),anyExistingDirectfile).STM$();
    // JavaLine 133 ==> SourceLine 123
    new simtst79$Test(((simtst79)CUR$),123,xf.isopen(),false,21);
    // JavaLine 135 ==> SourceLine 125
    if((!(((DirectFile$)(xf)).open(blanks(10))))) {
        // JavaLine 137 ==> SourceLine 127
        new simtst79$Test(((simtst79)CUR$),127,xf.isopen(),false,22);
    } else
    new simtst79$Test(((simtst79)CUR$),127,xf.isopen(),true,23);
    // JavaLine 141 ==> SourceLine 129
    ((DirectFile$)(xf)).close();
    // JavaLine 143 ==> SourceLine 130
    new simtst79$Test(((simtst79)CUR$),130,xf.isopen(),false,24);
    // JavaLine 145 ==> SourceLine 133
    xf=new DirectByteFile$(((BASICIO$)CTX$),new TXT$("sxcvz4")).STM$();
    // JavaLine 147 ==> SourceLine 134
    xf.setaccess(new TXT$("CREATE"));
    // JavaLine 149 ==> SourceLine 137
    if((!(((DirectByteFile$)(xf)).open()))) {
        // JavaLine 151 ==> SourceLine 139
        new simtst79$Test(((simtst79)CUR$),139,xf.isopen(),false,26);
    } else
    new simtst79$Test(((simtst79)CUR$),139,xf.isopen(),true,27);
    // JavaLine 155 ==> SourceLine 141
    ((DirectByteFile$)(xf)).close();
    // JavaLine 157 ==> SourceLine 142
    new simtst79$Test(((simtst79)CUR$),142,xf.isopen(),false,28);
    // JavaLine 159 ==> SourceLine 144
    xf=new PrintFile$(((BASICIO$)CTX$),new TXT$("sxcvz5")).STM$();
    // JavaLine 161 ==> SourceLine 145
    new simtst79$Test(((simtst79)CUR$),145,xf.isopen(),false,29);
    // JavaLine 163 ==> SourceLine 147
    if((!(((PrintFile$)(xf)).open(blanks(136))))) {
        // JavaLine 165 ==> SourceLine 149
        new simtst79$Test(((simtst79)CUR$),149,xf.isopen(),false,30);
    } else
    new simtst79$Test(((simtst79)CUR$),149,xf.isopen(),true,31);
    // JavaLine 169 ==> SourceLine 151
    ((PrintFile$)(xf)).close();
    // JavaLine 171 ==> SourceLine 152
    new simtst79$Test(((simtst79)CUR$),152,xf.isopen(),false,32);
    // JavaLine 173 ==> SourceLine 154
    if(found_error) {
    } else
    // JavaLine 176 ==> SourceLine 157
    {
        TRACE_BEGIN_STM$("CompoundStatement157",157);
        sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 79"));
        TRACE_END_STM$("CompoundStatement157",157);
    }
    // JavaLine 182 ==> SourceLine 160
    if(verbose) {
        // JavaLine 184 ==> SourceLine 161
        {
            TRACE_BEGIN_STM$("CompoundStatement161",161);
            sysout().outtext(new TXT$("--- END Simula a.s. TEST 79"));
            // JavaLine 188 ==> SourceLine 166
            sysout().outimage();
            TRACE_END_STM$("CompoundStatement161",166);
        }
    }
    TRACE_END_STM$("simtst79",166);
    EBLK();
    return(null);
} // End of SimulaProgram Statements

public static void main(String[] args) {
    RT.setRuntimeOptions(args);
    new simtst79(CTX$).STM$();
}
public static PROGINFO$ INFO$=new PROGINFO$("simtst79.sim","SimulaProgram simtst79",1,26,11,27,13,29,15,31,17,32,30,54,32,55,36,56,38,57,40,58,45,62,47,63,49,64,55,65,57,66,59,68,61,69,63,71,65,72,67,74,69,75,71,77,73,79,77,81,79,82,81,84,83,85,85,87,87,88,89,90,91,91,93,93,95,95,99,97,101,98,103,101,105,102,107,104,109,106,113,108,115,109,117,112,119,113,121,115,123,117,127,119,129,120,131,122,133,123,135,125,137,127,141,129,143,130,145,133,147,134,149,137,151,139,155,141,157,142,159,144,161,145,163,147,165,149,169,151,171,152,173,154,176,157,182,160,184,161,188,166,201,166);
}
