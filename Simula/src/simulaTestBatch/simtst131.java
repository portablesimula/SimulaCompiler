// JavaLine 1 <== SourceLine 10
package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 22 09:53:21 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst131 extends SimulaTest {
    // PrefixedBlockDeclaration: Kind=PrefixedBlock, BlockLevel=1, firstLine=10, lastLine=70, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public simtst131(_RTObject staticLink,int sp_n,_TXT sp_title) {
        super(staticLink,sp_n,sp_title);
        // Parameter assignment to locals
        BPRG("simtst131");
        // Declaration Code
    }
    // Class Statements
    public simtst131 _STM() {
        // Class SimulaTest: Code before inner
        // JavaLine 20 <== SourceLine 16
        if(_VALUE(false)) {
            {
                // JavaLine 23 <== SourceLine 17
                sysout().outtext(new _TXT("--- START Simula a.s. TEST"));
                ;
                sysout().outint(p_n,4);
                ;
                sysout().outimage();
                ;
                // JavaLine 30 <== SourceLine 18
                sysout().outtext(p_title);
                ;
                // JavaLine 33 <== SourceLine 19
                sysout().outimage();
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        // Class simtst131: Code before inner
        // JavaLine 42 <== SourceLine 12
        new simtst131_PBLK12((_CUR))._STM();
        // JavaLine 44 <== SourceLine 68
        ;
        // Class SimulaTest: Code after inner
        // JavaLine 47 <== SourceLine 22
        ;
        // JavaLine 49 <== SourceLine 24
        if(_VALUE(noMessage)) {
            ;
        } else
        {
            // JavaLine 54 <== SourceLine 25
            if(_VALUE((!(found_error)))) {
                {
                    // JavaLine 57 <== SourceLine 26
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
            // JavaLine 69 <== SourceLine 29
            if(_VALUE(false)) {
                {
                    // JavaLine 72 <== SourceLine 30
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
        ;
        // JavaLine 84 <== SourceLine 68
        EBLK();
        return(this);
    } // End of Class Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        _RT.setRuntimeOptions(args);
        new simtst131(CTX_,131,new _TXT("--- Test new standard procedure 'CatchingErrors'"))._STM();
    } // End of main
    public static _PROGINFO INFO_=new _PROGINFO("simtst131.sim","PrefixedBlock simtst131",1,10,20,16,23,17,30,18,33,19,42,12,44,68,47,22,49,24,54,25,57,26,69,29,72,30,84,68,93,70);
} // End of Class
