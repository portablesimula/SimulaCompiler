// JavaLine 1 ==> SourceLine 3
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu Jan 24 17:24:18 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PrimeUnder$PBLK3 extends Simulation$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=1, firstLine=3, lastLine=25, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    int acc=0;
    // Normal Constructor
    public PrimeUnder$PBLK3(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BPRG("PrimeUnder$PBLK3");
        // Declaration Code
        TRACE_BEGIN_DCL$("PrimeUnder$PBLK3",7);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("PrimeUnder$PBLK3",7,inner);
                // JavaLine 25 ==> SourceLine 17
                sysout().outtext(new TXT$("Show all primes less than "));
                sysout().breakoutimage();
                // JavaLine 28 ==> SourceLine 19
                ((PrimeUnder$PBLK3)CUR$).ActivateAt(false,new PrimeUnder$PBLK3$Prime(((PrimeUnder$PBLK3)CUR$)).START(),2,false);
                // JavaLine 30 ==> SourceLine 22
                hold(((double)(1000000)));
                sysout().outimage();
                sysout().outimage();
                // JavaLine 34 ==> SourceLine 23
                sysout().outint(acc,7);
                sysout().outtext(new TXT$(" primes found"));
                TRACE_END_STM$("PrimeUnder$PBLK3",23);
            }
        };
    } // End of Constructor
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new PrimeUnder$PBLK3(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("PrimeUnder.sim","PrefixedBlock PrimeUnder$PBLK3",1,3,25,17,28,19,30,22,34,23,46,25);
}
