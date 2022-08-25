// JavaLine 1 <== SourceLine 11
package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 22 09:22:47 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst103 extends SimulaTest {
    // PrefixedBlockDeclaration: Kind=PrefixedBlock, BlockLevel=1, firstLine=11, lastLine=72, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public simtst103(_RTObject staticLink,int sp_n,_TXT sp_title) {
        super(staticLink,sp_n,sp_title);
        // Parameter assignment to locals
        BPRG("simtst103");
        // Declaration Code
    }
    // Class Statements
    public simtst103 _STM() {
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
        // Class simtst103: Code before inner
        // JavaLine 42 <== SourceLine 13
        new simtst103_PBLK13((_CUR))._START();
        // JavaLine 44 <== SourceLine 70
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
        // JavaLine 84 <== SourceLine 70
        EBLK();
        return(this);
    } // End of Class Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        _RT.setRuntimeOptions(args);
        new simtst103(CTX_,103,new _TXT("--- Test all kinds of Activation Statements"))._STM();
    } // End of main
    public static _PROGINFO INFO_=new _PROGINFO("simtst103.sim","PrefixedBlock simtst103",1,11,20,16,23,17,30,18,33,19,42,13,44,70,47,22,49,24,54,25,57,26,69,29,72,30,84,70,93,72);
} // End of Class
