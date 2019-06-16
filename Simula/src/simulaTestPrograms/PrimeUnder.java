// JavaLine 1 <== SourceLine 14
package simulaTestPrograms;
// Simula-1.0 Compiled at Sat Jun 15 10:30:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PrimeUnder extends Simulation$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=1, firstLine=14, lastLine=36, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    int acc$2=0;
    // Normal Constructor
    public PrimeUnder(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BPRG("PrimeUnder");
        // Declaration Code
        TRACE_BEGIN_DCL$("PrimeUnder",18);
    }
    // Class Statements
    public PrimeUnder STM$() {
        TRACE_BEGIN_STM$("PrimeUnder",18);
        // Class Simset: Code before inner
        // Class Simulation: Code before inner
        // Class PrimeUnder: Code before inner
        // JavaLine 28 <== SourceLine 28
        sysout().outtext(new TXT$("Show all primes less than "));
        sysout().breakoutimage();
        // JavaLine 31 <== SourceLine 30
        ((PrimeUnder)(CUR$)).ActivateAt(false,((PrimeUnder$Prime)new PrimeUnder$Prime(((PrimeUnder)(CUR$))).START$()),2,false);
        // JavaLine 33 <== SourceLine 31
        hold(((double)(sysin().inint())));
        // JavaLine 35 <== SourceLine 33
        sysout().outimage();
        sysout().outimage();
        // JavaLine 38 <== SourceLine 34
        sysout().outint(acc$2,7);
        sysout().outtext(new TXT$(" primes found"));
        TRACE_END_STM$("PrimeUnder",34);
        EBLK();
        return(this);
    } // End of Class Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new PrimeUnder(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("PrimeUnder.sim","PrefixedBlock PrimeUnder",1,14,28,28,31,30,33,31,35,33,38,34,50,36);
} // End of Class
