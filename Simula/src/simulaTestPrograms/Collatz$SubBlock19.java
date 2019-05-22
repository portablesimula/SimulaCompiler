// JavaLine 1 <== SourceLine 19
package simulaTestPrograms;
// Simula-1.0 Compiled at Wed May 22 10:22:23 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Collatz$SubBlock19 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=2, firstLine=19, lastLine=29, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int j=0;
    int k=0;
    // Normal Constructor
    public Collatz$SubBlock19(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock19",19);
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock19",19);
        // JavaLine 22 <== SourceLine 21
        for(boolean CB$21:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Collatz)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((Collatz)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(2); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(10000000); }})
           )) { if(!CB$21) continue;
        // JavaLine 26 <== SourceLine 22
        {
            TRACE_BEGIN_STM$("CompoundStatement22",22);
            j=new Collatz$Collatz(((Collatz)(CUR$.SL$)),((Collatz)(CUR$.SL$)).i).RESULT$;
            // JavaLine 30 <== SourceLine 23
            if(VALUE$((j>(k)))) {
                // JavaLine 32 <== SourceLine 24
                {
                    TRACE_BEGIN_STM$("CompoundStatement24",24);
                    k=j;
                    // JavaLine 36 <== SourceLine 25
                    sysout().outint(((Collatz)(CUR$.SL$)).i,9);
                    sysout().outtext(new TXT$(" requires "));
                    sysout().outint(k,3);
                    sysout().outtext(new TXT$(" steps"));
                    sysout().outimage();
                    TRACE_END_STM$("CompoundStatement24",25);
                }
            }
            TRACE_END_STM$("CompoundStatement22",25);
        }
    }
    // JavaLine 48 <== SourceLine 28
    sysout().outtext(new TXT$("DONE."));
    sysout().outimage();
    TRACE_END_STM$("SubBlock19",28);
    EBLK();
    return(null);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("Collatz.sim","SubBlock SubBlock19",1,19,22,21,26,22,30,23,32,24,36,25,48,28,54,29);
} // End of SubBlock
