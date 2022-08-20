// JavaLine 1 <== SourceLine 3
package simulaTestPrograms;
// Simula-2.0 Compiled at Fri Aug 19 10:53:05 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc00_ extends _BASICIO {
    // SubBlock: Kind=SimulaProgram, BlockLevel=1, firstLine=3, lastLine=5, hasLocalClasses=false, System=false
    // Declare locals as attributes
    // Normal Constructor
    public adHoc00_(_RTObject staticLink) {
        super(staticLink);
        BBLK();
        BPRG("adHoc00_");
        // Declaration Code
    }
    // SimulaProgram Statements
    public _RTObject _STM() {
        sysout().outtext(new _TXT("Hello"));
        ;
        EBLK();
        return(this);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        _RT.setRuntimeOptions(args);
        new adHoc00_(CTX_)._STM();
    } // End of main
    public static _PROGINFO INFO_=new _PROGINFO("adHoc00.sim","SimulaProgram adHoc00_",1,3,28,5);
} // End of SubBlock
