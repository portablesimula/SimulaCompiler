// JavaLine 1 ==> SourceLine 98
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Mar 17 12:36:45 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst66$SubBlock98 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=2, firstLine=98, lastLine=115, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int i=0;
    // Normal Constructor
    public simtst66$SubBlock98(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock98",98);
    } // End of Constructor
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock98",98);
        // JavaLine 21 ==> SourceLine 99
        sysout().outtext(new TXT$("*** error : Reading from file."));
        // JavaLine 23 ==> SourceLine 100
        sysout().outimage();
        // JavaLine 25 ==> SourceLine 101
        sysout().outtext(new TXT$("            Lines read from file :"));
        // JavaLine 27 ==> SourceLine 102
        sysout().outimage();
        // JavaLine 29 ==> SourceLine 103
        sysout().outimage();
        // JavaLine 31 ==> SourceLine 104
        for(boolean CB$104:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((simtst66)(CUR$.SL$)).fil1.lnr); }})
           ,new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return((i+(1))); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((simtst66)(CUR$.SL$)).fil2.lnr); }})
           )) { if(!CB$104) continue;
        // JavaLine 36 ==> SourceLine 106
        {
            TRACE_BEGIN_STM$("CompoundStatement106",106);
            sysout().outtext(new TXT$(" 1 : "));
            // JavaLine 40 ==> SourceLine 107
            sysout().outtext(((ARRAY$<TXT$[]>)((simtst66)(CUR$.SL$)).fil1.linjer).Elt[i-((simtst66)(CUR$.SL$)).fil1.linjer.LB[0]]);
            // JavaLine 42 ==> SourceLine 108
            sysout().outimage();
            // JavaLine 44 ==> SourceLine 109
            sysout().outtext(new TXT$(" 2 : "));
            // JavaLine 46 ==> SourceLine 110
            sysout().outtext(((ARRAY$<TXT$[]>)((simtst66)(CUR$.SL$)).fil2.linjer).Elt[i-((simtst66)(CUR$.SL$)).fil2.linjer.LB[0]]);
            // JavaLine 48 ==> SourceLine 111
            sysout().outimage();
            // JavaLine 50 ==> SourceLine 112
            sysout().outimage();
            TRACE_END_STM$("CompoundStatement106",112);
        }
    }
    // JavaLine 55 ==> SourceLine 114
    ((simtst66)(CUR$.SL$)).found_error=true;
    TRACE_END_STM$("SubBlock98",114);
    EBLK();
    return(null);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("simtst66.sim","SubBlock SubBlock98",1,98,21,99,23,100,25,101,27,102,29,103,31,104,36,106,40,107,42,108,44,109,46,110,48,111,50,112,55,114,60,115);
}
