// JavaLine 1 <== SourceLine 2
package simulaTestBatch;
// Simula-2.0 Compiled at Thu Sep 07 13:06:05 CEST 2023
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SimulaTest extends RTS_CLASS {
    // ClassDeclaration: Kind=Class, BlockLevel=1, PrefixLevel=0, firstLine=2, lastLine=37, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    public int p_n;
    public RTS_TXT p_title;
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 5
    public boolean found_error=false;
    // JavaLine 14 <== SourceLine 6
    public int nFailed=0;
    // JavaLine 16 <== SourceLine 7
    public final boolean verbose=(boolean)(false);
    // JavaLine 18 <== SourceLine 8
    public boolean noMessage=false;
    // Normal Constructor
    public SimulaTest(RTS_RTObject staticLink,int sp_n,RTS_TXT sp_title) {
        super(staticLink);
        // Parameter assignment to locals
        this.p_n = sp_n;
        this.p_title = sp_title;
        BBLK(); // Iff no prefix
        // Declaration Code
    }
    // Class Statements
    @Override
    public SimulaTest _STM() {
        // Class SimulaTest: Code before inner
        RTS_COMMON._LINE("Class SimulaTest",16); // JavaLine 33 <== SourceLine 16
        if(_VALUE(false)) {
            {
                RTS_COMMON._LINE("Class SimulaTest",17); // JavaLine 36 <== SourceLine 17
                sysout().outtext(new RTS_TXT("--- START Simula a.s. TEST"));
                ;
                sysout().outint(p_n,4);
                ;
                sysout().outimage();
                ;
                RTS_COMMON._LINE("Class SimulaTest",18); // JavaLine 43 <== SourceLine 18
                sysout().outtext(p_title);
                ;
                RTS_COMMON._LINE("Class SimulaTest",19); // JavaLine 46 <== SourceLine 19
                sysout().outimage();
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        RTS_COMMON._LINE("Class SimulaTest",33); // JavaLine 54 <== SourceLine 33
        // Class SimulaTest: Code after inner
        RTS_COMMON._LINE("Class SimulaTest",22); // JavaLine 56 <== SourceLine 22
        ;
        RTS_COMMON._LINE("Class SimulaTest",24); // JavaLine 58 <== SourceLine 24
        if(_VALUE(noMessage)) {
            ;
        } else {
            {
                RTS_COMMON._LINE("Class SimulaTest",25); // JavaLine 63 <== SourceLine 25
                if(_VALUE(found_error)) {
                    {
                        RTS_COMMON._LINE("Class SimulaTest",26); // JavaLine 66 <== SourceLine 26
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
                        RTS_COMMON._LINE("Class SimulaTest",27); // JavaLine 77 <== SourceLine 27
                        RTS_ENVIRONMENT.error(CONC(CONC(new RTS_TXT("Test sample has "),RTS_ENVIRONMENT.edit(nFailed)),new RTS_TXT(" error(s)")));
                        ;
                    }
                } else {
                    RTS_COMMON._LINE("Class SimulaTest",28); // JavaLine 82 <== SourceLine 28
                    {
                        RTS_COMMON._LINE("Class SimulaTest",29); // JavaLine 84 <== SourceLine 29
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
                RTS_COMMON._LINE("Class SimulaTest",32); // JavaLine 96 <== SourceLine 32
                if(_VALUE(false)) {
                    {
                        RTS_COMMON._LINE("Class SimulaTest",33); // JavaLine 99 <== SourceLine 33
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
        EBLK();
        return(this);
    } // End of Class Statements
    public static RTS_PROGINFO _INFO=new RTS_PROGINFO("SimulaTest.sim","Class SimulaTest",1,2,12,5,14,6,16,7,18,8,33,16,36,17,43,18,46,19,54,33,56,22,58,24,63,25,66,26,77,27,82,28,84,29,96,32,99,33,114,37);
} // End of Class
