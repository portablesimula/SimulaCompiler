// JavaLine 1 <== SourceLine 14
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:21:08 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PrimeUnder$PBLK14 extends Simulation$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=1, firstLine=14, lastLine=36, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    int acc$2=0;
    // Normal Constructor
    public PrimeUnder$PBLK14(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BPRG("PrimeUnder$PBLK14");
        // Declaration Code
        TRACE_BEGIN_DCL$("PrimeUnder$PBLK14",18);
    }
    // Class Statements
    public PrimeUnder$PBLK14 STM$() {
        TRACE_BEGIN_STM$("PrimeUnder$PBLK14",18);
        // Class Simset: Code before inner
        // Class Simulation: Code before inner
        // Class PrimeUnder$PBLK14: Code before inner
        // JavaLine 28 <== SourceLine 28
        sysout().outtext(new TXT$("Show all primes less than "));
        sysout().breakoutimage();
        // JavaLine 31 <== SourceLine 30
        ((PrimeUnder$PBLK14)CUR$).ActivateAt(false,((PrimeUnder$PBLK14$Prime)new PrimeUnder$PBLK14$Prime(((PrimeUnder$PBLK14)CUR$)).START$()),2,false);
        // JavaLine 33 <== SourceLine 31
        hold(((double)(sysin().inint())));
        // JavaLine 35 <== SourceLine 33
        sysout().outimage();
        sysout().outimage();
        // JavaLine 38 <== SourceLine 34
        sysout().outint(acc$2,7);
        sysout().outtext(new TXT$(" primes found"));
        TRACE_END_STM$("PrimeUnder$PBLK14",34);
        EBLK();
        return(this);
    } // End of Class Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new PrimeUnder$PBLK14(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("PrimeUnder.sim","PrefixedBlock PrimeUnder$PBLK14",1,14,28,28,31,30,33,31,35,33,38,34,50,36);
} // End of Class
