// JavaLine 1 <== SourceLine 2
package simulaTestBatch;
// Simula-2.0 Compiled at Wed Jul 12 11:20:40 CEST 2023
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SimulaTest extends _SIMULA_BLOCK {
    // ClassDeclaration: Kind=Class, BlockLevel=1, PrefixLevel=0, firstLine=2, lastLine=34, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    public int p_n;
    public _TXT p_title;
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
    public SimulaTest(_RTObject staticLink,int sp_n,_TXT sp_title) {
        super(staticLink);
        // Parameter assignment to locals
        this.p_n = sp_n;
        this.p_title = sp_title;
        BBLK(); // Iff no prefix
        // Declaration Code
    }
    // Class Statements
    public SimulaTest _STM() {
        // Class SimulaTest: Code before inner
        _RT._LINE("Class SimulaTest",16); // JavaLine 32 <== SourceLine 16
        if(_VALUE(false)) {
            {
                _RT._LINE("Class SimulaTest",17); // JavaLine 35 <== SourceLine 17
                sysout().outtext(new _TXT("--- START Simula a.s. TEST"));
                ;
                sysout().outint(p_n,4);
                ;
                sysout().outimage();
                ;
                _RT._LINE("Class SimulaTest",18); // JavaLine 42 <== SourceLine 18
                sysout().outtext(p_title);
                ;
                _RT._LINE("Class SimulaTest",19); // JavaLine 45 <== SourceLine 19
                sysout().outimage();
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        _RT._LINE("Class SimulaTest",30); // JavaLine 53 <== SourceLine 30
        // Class SimulaTest: Code after inner
        _RT._LINE("Class SimulaTest",22); // JavaLine 55 <== SourceLine 22
        ;
        _RT._LINE("Class SimulaTest",24); // JavaLine 57 <== SourceLine 24
        if(_VALUE(noMessage)) {
            ;
        } else {
            {
                _RT._LINE("Class SimulaTest",25); // JavaLine 62 <== SourceLine 25
                if(_VALUE((!(found_error)))) {
                    {
                        _RT._LINE("Class SimulaTest",26); // JavaLine 65 <== SourceLine 26
                        sysout().outtext(new _TXT("--- NO ERRORS FOUND IN TEST"));
                        ;
                        sysout().outint(p_n,4);
                        ;
                        sysout().outtext(new _TXT("  "));
                        ;
                        sysout().outtext(p_title);
                        ;
                    }
                }
                ;
                _RT._LINE("Class SimulaTest",29); // JavaLine 77 <== SourceLine 29
                if(_VALUE(false)) {
                    {
                        _RT._LINE("Class SimulaTest",30); // JavaLine 80 <== SourceLine 30
                        sysout().outtext(new _TXT("--- END Simula a.s. TEST"));
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
    public static _PROGINFO _INFO=new _PROGINFO("SimulaTest.sim","Class SimulaTest",1,2,12,5,14,6,16,7,18,8,32,16,35,17,42,18,45,19,53,30,55,22,57,24,62,25,65,26,77,29,80,30,95,34);
} // End of Class
