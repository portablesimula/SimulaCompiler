// JavaLine 1 ==> SourceLine 12
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Jan 12 16:53:29 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst89 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=12, lastLine=70, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    TXT$ src=null;
    TXT$ dst=null;
    int b=0;
    int bb=0;
    // JavaLine 14 ==> SourceLine 13
    boolean errorFound=false;
    // JavaLine 16 ==> SourceLine 14
    boolean verbose=false;
    // JavaLine 18 ==> SourceLine 15
    InbyteFile$ inpt=null;
    InbyteFile$ inoupt=null;
    OutbyteFile$ oupt=null;
    // JavaLine 22 ==> SourceLine 16
    final TXT$ inptFileName=new TXT$("C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/files/inputByteFile89");
    // JavaLine 24 ==> SourceLine 17
    final TXT$ ouptFileName=new TXT$("C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/files/outputByteFile89");
    // Normal Constructor
    public simtst89(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst89");
        // Declaration Code
        TRACE_BEGIN_DCL$("simtst89",17);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("simtst89",17);
        // JavaLine 37 ==> SourceLine 20
        if(verbose) {
            // JavaLine 39 ==> SourceLine 21
            {
                TRACE_BEGIN_STM$("CompoundStatement21",21);
                sysout().outtext(new TXT$("--- START Simula a.s. TEST 89"));
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement21",21);
            }
        }
        // JavaLine 47 ==> SourceLine 24
        inpt=new InbyteFile$(((BASICIO$)CTX$),inptFileName).STM$();
        // JavaLine 49 ==> SourceLine 25
        if((!(inpt.open()))) {
            error(CONC(new TXT$("Can't open "),inptFileName));
        }
        // JavaLine 53 ==> SourceLine 26
        oupt=new OutbyteFile$(((BASICIO$)CTX$),ouptFileName).STM$();
        // JavaLine 55 ==> SourceLine 27
        if((!(oupt.open()))) {
            error(CONC(new TXT$("Can't open "),ouptFileName));
        }
        // JavaLine 59 ==> SourceLine 29
        inpt.close();
        inpt.open();
        // JavaLine 62 ==> SourceLine 32
        b=inpt.inbyte();
        // JavaLine 64 ==> SourceLine 33
        while((!(inpt.endfile()))) {
            // JavaLine 66 ==> SourceLine 35
            {
                TRACE_BEGIN_STM$("CompoundStatement35",35);
                oupt.outbyte(b);
                b=inpt.inbyte();
                TRACE_END_STM$("CompoundStatement35",35);
            }
        }
        // JavaLine 74 ==> SourceLine 37
        inpt.close();
        oupt.close();
        // JavaLine 77 ==> SourceLine 39
        inoupt=new InbyteFile$(((BASICIO$)CTX$),oupt.filename()).STM$();
        oupt=null;
        // JavaLine 80 ==> SourceLine 40
        if((!(inpt.open()))) {
            error(CONC(new TXT$("Can't re-open "),inpt.filename()));
        }
        // JavaLine 84 ==> SourceLine 41
        if((!(inoupt.open()))) {
            error(CONC(new TXT$("Can't re-open "),inoupt.filename()));
        }
        // JavaLine 88 ==> SourceLine 42
        b=inpt.inbyte();
        bb=inoupt.inbyte();
        // JavaLine 91 ==> SourceLine 43
        while((!(inpt.endfile()))) {
            // JavaLine 93 ==> SourceLine 44
            {
                TRACE_BEGIN_STM$("CompoundStatement44",44);
                if((!((b==(bb))))) {
                    {
                        TRACE_BEGIN_STM$("CompoundStatement44",44);
                        errorFound=true;
                        // JavaLine 100 ==> SourceLine 45
                        error(new TXT$("The files differ"));
                        TRACE_END_STM$("CompoundStatement44",45);
                    }
                }
                // JavaLine 105 ==> SourceLine 47
                if(inoupt.endfile()) {
                    {
                        TRACE_BEGIN_STM$("CompoundStatement47",47);
                        errorFound=true;
                        // JavaLine 110 ==> SourceLine 48
                        error(new TXT$("Output file is too short"));
                        TRACE_END_STM$("CompoundStatement47",48);
                    }
                }
                // JavaLine 115 ==> SourceLine 50
                b=inpt.inbyte();
                bb=inoupt.inbyte();
                TRACE_END_STM$("CompoundStatement44",50);
            }
        }
        // JavaLine 121 ==> SourceLine 52
        if(inoupt.endfile()) {
        } else
        // JavaLine 124 ==> SourceLine 53
        {
            TRACE_BEGIN_STM$("CompoundStatement53",53);
            errorFound=true;
            // JavaLine 128 ==> SourceLine 54
            error(new TXT$("Output file is too long"));
            TRACE_END_STM$("CompoundStatement53",54);
        }
        // JavaLine 132 ==> SourceLine 57
        inpt.close();
        inoupt.close();
        // JavaLine 135 ==> SourceLine 59
        if(errorFound) {
        } else
        // JavaLine 138 ==> SourceLine 62
        {
            TRACE_BEGIN_STM$("CompoundStatement62",62);
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 89"));
            TRACE_END_STM$("CompoundStatement62",62);
        }
        // JavaLine 144 ==> SourceLine 65
        if(verbose) {
            // JavaLine 146 ==> SourceLine 66
            {
                TRACE_BEGIN_STM$("CompoundStatement66",66);
                sysout().outtext(new TXT$("--- END TEST 89"));
                // JavaLine 150 ==> SourceLine 70
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement66",70);
            }
        }
        TRACE_END_STM$("simtst89",70);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst89(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst89.sim","SimulaProgram simtst89",1,12,14,13,16,14,18,15,22,16,24,17,37,20,39,21,47,24,49,25,53,26,55,27,59,29,62,32,64,33,66,35,74,37,77,39,80,40,84,41,88,42,91,43,93,44,100,45,105,47,110,48,115,50,121,52,124,53,128,54,132,57,135,59,138,62,144,65,146,66,150,70,163,70);
}
