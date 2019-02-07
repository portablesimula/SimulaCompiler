// JavaLine 1 ==> SourceLine 14
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:31:35 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PrimeUnder$PBLK14 extends Simulation$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=1, firstLine=14, lastLine=36, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    int acc=0;
    // Normal Constructor
    public PrimeUnder$PBLK14(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BPRG("PrimeUnder$PBLK14");
        // Declaration Code
        TRACE_BEGIN_DCL$("PrimeUnder$PBLK14",18);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("PrimeUnder$PBLK14",18,inner);
                // JavaLine 25 ==> SourceLine 28
                sysout().outtext(new TXT$("Show all primes less than "));
                sysout().breakoutimage();
                // JavaLine 28 ==> SourceLine 30
                ((PrimeUnder$PBLK14)CUR$).ActivateAt(false,new PrimeUnder$PBLK14$Prime(((PrimeUnder$PBLK14)CUR$)).START(),2,false);
                // JavaLine 30 ==> SourceLine 31
                hold(((double)(sysin().inint())));
                // JavaLine 32 ==> SourceLine 33
                sysout().outimage();
                sysout().outimage();
                // JavaLine 35 ==> SourceLine 34
                sysout().outint(acc,7);
                sysout().outtext(new TXT$(" primes found"));
                TRACE_END_STM$("PrimeUnder$PBLK14",34);
            }
        };
    } // End of Constructor
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new PrimeUnder$PBLK14(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("PrimeUnder.sim","PrefixedBlock PrimeUnder$PBLK14",1,14,25,28,28,30,30,31,32,33,35,34,47,36);
}
