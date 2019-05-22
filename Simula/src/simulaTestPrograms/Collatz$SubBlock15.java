// JavaLine 1 <== SourceLine 15
package simulaTestPrograms;
// Simula-1.0 Compiled at Wed May 22 10:10:51 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Collatz$SubBlock15 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=2, firstLine=15, lastLine=25, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int j=0;
    int k=0;
    // Normal Constructor
    public Collatz$SubBlock15(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock15",15);
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock15",15);
        // JavaLine 22 <== SourceLine 17
        for(boolean CB$17:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Collatz)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((Collatz)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(2); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(10000000); }})
           )) { if(!CB$17) continue;
        // JavaLine 26 <== SourceLine 18
        {
            TRACE_BEGIN_STM$("CompoundStatement18",18);
            j=new Collatz$Collatz(((Collatz)(CUR$.SL$)),((Collatz)(CUR$.SL$)).i).RESULT$;
            // JavaLine 30 <== SourceLine 19
            if(VALUE$((j>(k)))) {
                // JavaLine 32 <== SourceLine 20
                {
                    TRACE_BEGIN_STM$("CompoundStatement20",20);
                    k=j;
                    // JavaLine 36 <== SourceLine 21
                    sysout().outint(((Collatz)(CUR$.SL$)).i,9);
                    sysout().outtext(new TXT$(" requires "));
                    sysout().outint(k,3);
                    sysout().outtext(new TXT$(" steps"));
                    sysout().outimage();
                    TRACE_END_STM$("CompoundStatement20",21);
                }
            }
            TRACE_END_STM$("CompoundStatement18",21);
        }
    }
    // JavaLine 48 <== SourceLine 24
    sysout().outtext(new TXT$("DONE."));
    sysout().outimage();
    TRACE_END_STM$("SubBlock15",24);
    EBLK();
    return(null);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("Collatz.sim","SubBlock SubBlock15",1,15,22,17,26,18,30,19,32,20,36,21,48,24,54,25);
} // End of SubBlock
