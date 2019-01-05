// JavaLine 1 ==> SourceLine 18
package simulaTestBatch;
// Release-Beta-0.3 Compiled at Sat Jan 05 09:06:35 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst80 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=18, lastLine=65, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    boolean errorFound=false;
    // JavaLine 11 ==> SourceLine 19
    final boolean verbose=false;
    // JavaLine 13 ==> SourceLine 21
    final TXT$ fileName=new TXT$("C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/files/any8089");
    // JavaLine 15 ==> SourceLine 23
    ImageFile$ f1=null;
    ImageFile$ f2=null;
    // Normal Constructor
    public simtst80(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst80");
        // Declaration Code
        TRACE_BEGIN_DCL$("simtst80",23);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("simtst80",23);
        // JavaLine 29 ==> SourceLine 25
        if(verbose) {
            // JavaLine 31 ==> SourceLine 26
            {
                TRACE_BEGIN_STM$("CompoundStatement26",26);
                sysout().outtext(new TXT$("--- START Simula a.s. TEST 80"));
                // JavaLine 35 ==> SourceLine 27
                sysout().outimage();
                // JavaLine 37 ==> SourceLine 28
                sysout().outtext(new TXT$("--- Test the attribute 'IsOpen' of class file"));
                // JavaLine 39 ==> SourceLine 29
                sysout().outtext(CONC(new TXT$(" uses infile "),fileName));
                // JavaLine 41 ==> SourceLine 30
                sysout().outimage();
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement26",30);
            }
        }
        // JavaLine 47 ==> SourceLine 33
        f1=new InFile$(((BASICIO$)CTX$),fileName).STM$();
        // JavaLine 49 ==> SourceLine 34
        f2=new InFile$(((BASICIO$)CTX$),fileName).STM$();
        // JavaLine 51 ==> SourceLine 36
        if((!(((InFile$)(f1)).open(blanks(100))))) {
            error(CONC(new TXT$("Can't open file: "),fileName));
        }
        // JavaLine 55 ==> SourceLine 37
        if((!(((InFile$)(f2)).open(blanks(100))))) {
            // JavaLine 57 ==> SourceLine 38
            {
                TRACE_BEGIN_STM$("CompoundStatement38",38);
                sysout().outtext(new TXT$("WARNING: cannot open infile (f2)"));
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement38",38);
            }
        }
        // JavaLine 65 ==> SourceLine 40
        ((InFile$)(f1)).inimage();
        // JavaLine 67 ==> SourceLine 41
        while(((InFile$)(f1)).endfile()) {
            ((InFile$)(f1)).inimage();
        }
        // JavaLine 71 ==> SourceLine 43
        if(f2.isopen()) {
            // JavaLine 73 ==> SourceLine 44
            {
                TRACE_BEGIN_STM$("CompoundStatement44",44);
                if((!(((InFile$)(f2)).close()))) {
                    {
                        TRACE_BEGIN_STM$("CompoundStatement44",44);
                        errorFound=true;
                        // JavaLine 80 ==> SourceLine 45
                        sysout().outtext(new TXT$("error: cannot close infile (f2)"));
                        sysout().outimage();
                        TRACE_END_STM$("CompoundStatement44",45);
                    }
                }
                TRACE_END_STM$("CompoundStatement44",45);
            }
        }
        // JavaLine 89 ==> SourceLine 48
        if(f1.isopen()) {
        } else
        // JavaLine 92 ==> SourceLine 49
        {
            TRACE_BEGIN_STM$("CompoundStatement49",49);
            errorFound=true;
            // JavaLine 96 ==> SourceLine 51
            sysout().outtext(new TXT$("error : 'IsOpen' returns false but the file should be open"));
            // JavaLine 98 ==> SourceLine 53
            sysout().outimage();
            TRACE_END_STM$("CompoundStatement49",53);
        }
        // JavaLine 102 ==> SourceLine 55
        if((!(((InFile$)(f1)).close()))) {
            {
                TRACE_BEGIN_STM$("CompoundStatement55",55);
                errorFound=true;
                // JavaLine 107 ==> SourceLine 56
                sysout().outtext(new TXT$("error: cannot close infile"));
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement55",56);
            }
        }
        // JavaLine 113 ==> SourceLine 58
        if((!(errorFound))) {
            // JavaLine 115 ==> SourceLine 59
            {
                TRACE_BEGIN_STM$("CompoundStatement59",59);
                sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 80"));
                TRACE_END_STM$("CompoundStatement59",59);
            }
        }
        // JavaLine 122 ==> SourceLine 60
        if(verbose) {
            // JavaLine 124 ==> SourceLine 61
            {
                TRACE_BEGIN_STM$("CompoundStatement61",61);
                sysout().outtext(new TXT$("--- END Simula a.s. TEST 80"));
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement61",61);
            }
        }
        TRACE_END_STM$("simtst80",61);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst80(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst80.sim","SimulaProgram simtst80",1,18,11,19,13,21,15,23,29,25,31,26,35,27,37,28,39,29,41,30,47,33,49,34,51,36,55,37,57,38,65,40,67,41,71,43,73,44,80,45,89,48,92,49,96,51,98,53,102,55,107,56,113,58,115,59,122,60,124,61,140,65);
}
