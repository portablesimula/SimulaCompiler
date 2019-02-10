// JavaLine 1 ==> SourceLine 5
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 10 12:24:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InspectionSamples extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=5, lastLine=32, hasLocalClasses=true, System=true
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 10
    InspectionSamples$A x=null;
    InspectionSamples$B y=null;
    // JavaLine 14 ==> SourceLine 11
    int aa=0;
    // JavaLine 16 ==> SourceLine 12
    boolean bb=false;
    // JavaLine 18 ==> SourceLine 15
    InspectionSamples$A inspect$14$0=null;
    // JavaLine 20 ==> SourceLine 18
    InspectionSamples$A inspect$17$1=null;
    // Normal Constructor
    public InspectionSamples(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("InspectionSamples");
        // Declaration Code
        TRACE_BEGIN_DCL$("InspectionSamples",18);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("InspectionSamples",18);
        // JavaLine 33 ==> SourceLine 14
        {
            // BEGIN INSPECTION 
            inspect$14$0=new InspectionSamples$F(((InspectionSamples)CUR$),54).RESULT$;
            if(inspect$14$0!=null) //INSPECT inspect$14$0
            // JavaLine 38 ==> SourceLine 15
            inspect$14$0.i=(y.i+(1));
            else // OTHERWISE 
            aa=4;
        }
        // JavaLine 43 ==> SourceLine 17
        {
            // BEGIN INSPECTION 
            inspect$17$1=new InspectionSamples$F(((InspectionSamples)CUR$),13).RESULT$;
            //INSPECT inspect$17$1
            if(inspect$17$1 instanceof InspectionSamples$B) // WHEN InspectionSamples$B DO 
            // JavaLine 49 ==> SourceLine 23
            new InspectionSamples$SubBlock20(CUR$).STM$();
            else if(inspect$17$1 instanceof InspectionSamples$A) // WHEN InspectionSamples$A DO 
            // JavaLine 52 ==> SourceLine 28
            new InspectionSamples$SubBlock25(CUR$).STM$();
            else // OTHERWISE 
            // JavaLine 55 ==> SourceLine 31
            new InspectionSamples$SubBlock29(CUR$).STM$();
        }
        TRACE_END_STM$("InspectionSamples",30);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new InspectionSamples(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("InspectionSamples.sim","SimulaProgram InspectionSamples",1,5,11,10,14,11,16,12,18,15,20,18,33,14,38,15,43,17,49,23,52,28,55,31,67,32);
}
