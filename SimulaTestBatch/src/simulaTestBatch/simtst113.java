// JavaLine 1 <== SourceLine 10
package simulaTestBatch;
// Simula-2.0 Compiled at Thu Sep 07 13:06:06 CEST 2023
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst113 extends SimulaTest {
    // PrefixedBlockDeclaration: Kind=PrefixedBlock, BlockLevel=1, firstLine=10, lastLine=59, hasLocalClasses=true, System=true, detachUsed=false
public boolean isQPSystemBlock() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 11
    public int traceCase_1=0;
    // JavaLine 13 <== SourceLine 12
    public RTS_TEXT_ARRAY facit=null;
    // JavaLine 15 <== SourceLine 13
    public simtst113_B x_1=null;
    // Normal Constructor
    public simtst113(RTS_RTObject staticLink,int sp_n,RTS_TXT sp_title) {
        super(staticLink,sp_n,sp_title);
        // Parameter assignment to locals
        BPRG("simtst113");
        // Declaration Code
        // JavaLine 23 <== SourceLine 12
        facit=new RTS_TEXT_ARRAY(new RTS_BOUNDS(0,5));
    }
    // Class Statements
    @Override
    public simtst113 _STM() {
        // Class SimulaTest: Code before inner
        RTS_COMMON._LINE("Class SimulaTest",16); // JavaLine 30 <== SourceLine 16
        if(_VALUE(false)) {
            {
                RTS_COMMON._LINE("Class SimulaTest",17); // JavaLine 33 <== SourceLine 17
                sysout().outtext(new RTS_TXT("--- START Simula a.s. TEST"));
                ;
                sysout().outint(p_n,4);
                ;
                sysout().outimage();
                ;
                RTS_COMMON._LINE("Class SimulaTest",18); // JavaLine 40 <== SourceLine 18
                sysout().outtext(p_title);
                ;
                RTS_COMMON._LINE("Class SimulaTest",19); // JavaLine 43 <== SourceLine 19
                sysout().outimage();
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        // Class simtst113: Code
        RTS_COMMON._LINE("PrefixedBlock simtst113",47); // JavaLine 52 <== SourceLine 47
        facit.putELEMENT(facit.index(0),new RTS_TXT("In A before inner"));
        ;
        RTS_COMMON._LINE("PrefixedBlock simtst113",48); // JavaLine 55 <== SourceLine 48
        facit.putELEMENT(facit.index(1),new RTS_TXT("At Label L - OK"));
        ;
        RTS_COMMON._LINE("PrefixedBlock simtst113",49); // JavaLine 58 <== SourceLine 49
        facit.putELEMENT(facit.index(2),new RTS_TXT("In B after inner"));
        ;
        RTS_COMMON._LINE("PrefixedBlock simtst113",50); // JavaLine 61 <== SourceLine 50
        facit.putELEMENT(facit.index(3),new RTS_TXT("In A after inner"));
        ;
        RTS_COMMON._LINE("PrefixedBlock simtst113",51); // JavaLine 64 <== SourceLine 51
        facit.putELEMENT(facit.index(4),new RTS_TXT("In MAIN after new B"));
        ;
        RTS_COMMON._LINE("PrefixedBlock simtst113",52); // JavaLine 67 <== SourceLine 52
        facit.putELEMENT(facit.index(5),new RTS_TXT("In MAIN after new CLASS B"));
        ;
        RTS_COMMON._LINE("PrefixedBlock simtst113",54); // JavaLine 70 <== SourceLine 54
        x_1=new simtst113_B((_CUR))._STM();
        ;
        RTS_COMMON._LINE("PrefixedBlock simtst113",55); // JavaLine 73 <== SourceLine 55
        new simtst113_trace((_CUR),new RTS_TXT("In MAIN after new B"));
        ;
        RTS_COMMON._LINE("PrefixedBlock simtst113",56); // JavaLine 76 <== SourceLine 56
        new simtst113_trace((_CUR),CONC(new RTS_TXT("In MAIN after new "),new RTS_TXT("CLASS B")));
        ;
        // Class SimulaTest: Code after inner
        RTS_COMMON._LINE("Class SimulaTest",22); // JavaLine 80 <== SourceLine 22
        ;
        RTS_COMMON._LINE("Class SimulaTest",24); // JavaLine 82 <== SourceLine 24
        if(_VALUE(noMessage)) {
            ;
        } else {
            {
                RTS_COMMON._LINE("Class SimulaTest",25); // JavaLine 87 <== SourceLine 25
                if(_VALUE(found_error)) {
                    {
                        RTS_COMMON._LINE("Class SimulaTest",26); // JavaLine 90 <== SourceLine 26
                        sysout().outtext(CONC(CONC(new RTS_TXT("--- "),RTS_ENVIRONMENT.edit(nFailed)),new RTS_TXT(" ERROR(S) FOUND IN TEST")));
                        ;
                        sysout().outint(p_n,4);
                        ;
                        sysout().outtext(new RTS_TXT("  "));
                        ;
                        sysout().outtext(p_title);
                        ;
                        sysout().outimage();
                        ;
                        RTS_COMMON._LINE("Class SimulaTest",27); // JavaLine 101 <== SourceLine 27
                        RTS_ENVIRONMENT.error(CONC(CONC(new RTS_TXT("Test sample has "),RTS_ENVIRONMENT.edit(nFailed)),new RTS_TXT(" error(s)")));
                        ;
                    }
                } else {
                    RTS_COMMON._LINE("Class SimulaTest",28); // JavaLine 106 <== SourceLine 28
                    {
                        RTS_COMMON._LINE("Class SimulaTest",29); // JavaLine 108 <== SourceLine 29
                        sysout().outtext(new RTS_TXT("--- NO ERRORS FOUND IN TEST"));
                        ;
                        sysout().outint(p_n,4);
                        ;
                        sysout().outtext(new RTS_TXT("  "));
                        ;
                        sysout().outtext(p_title);
                        ;
                    }
                }
                ;
                RTS_COMMON._LINE("Class SimulaTest",32); // JavaLine 120 <== SourceLine 32
                if(_VALUE(false)) {
                    {
                        RTS_COMMON._LINE("Class SimulaTest",33); // JavaLine 123 <== SourceLine 33
                        sysout().outtext(new RTS_TXT("--- END Simula a.s. TEST"));
                        ;
                        sysout().outint(p_n,4);
                        ;
                        sysout().outimage();
                        ;
                    }
                }
                ;
            }
        }
        ;
        RTS_COMMON._LINE("PrefixedBlock simtst113",56); // JavaLine 136 <== SourceLine 56
        EBLK();
        return(this);
    } // End of Class Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RTS_COMMON.setRuntimeOptions(args);
        new simtst113(_CTX,113,new RTS_TXT("--- Test Virtual Switch"))._STM();
    } // End of main
    public static RTS_PROGINFO _INFO=new RTS_PROGINFO("simtst113.sim","PrefixedBlock simtst113",1,10,11,11,13,12,15,13,23,12,30,16,33,17,40,18,43,19,52,47,55,48,58,49,61,50,64,51,67,52,70,54,73,55,76,56,80,22,82,24,87,25,90,26,101,27,106,28,108,29,120,32,123,33,136,56,145,59);
} // End of Class
