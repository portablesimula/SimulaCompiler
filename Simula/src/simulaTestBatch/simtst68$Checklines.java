// JavaLine 1 ==> SourceLine 24
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Wed Feb 06 20:31:42 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst68$Checklines extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=24, lastLine=63, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$n;
    public int p$e;
    // Declare locals as attributes
    // JavaLine 13 ==> SourceLine 27
    boolean Ok=false;
    // JavaLine 15 ==> SourceLine 28
    int i=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst68$Checklines setPar(Object param) {
        //Util.BREAK("CALL simtst68$Checklines.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$n=intValue(param); break;
                case 1: p$e=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public simtst68$Checklines(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public simtst68$Checklines(RTObject$ SL$,int sp$n,int sp$e) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        this.p$e = sp$e;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Checklines",28);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst68$Checklines STM$() {
        TRACE_BEGIN_STM$("Checklines",28);
        // JavaLine 48 ==> SourceLine 30
        Ok=true;
        // JavaLine 50 ==> SourceLine 32
        if(VALUE$((p$n==(((simtst68)(CUR$.SL$)).lnr)))) {
            // JavaLine 52 ==> SourceLine 34
            {
                TRACE_BEGIN_STM$("CompoundStatement34",34);
                for(boolean CB$34:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(p$n); }})
                   )) { if(!CB$34) continue;
                // JavaLine 58 ==> SourceLine 35
                if(VALUE$(TXTREL$NE(((simtst68)(CUR$.SL$)).lines.Elt[i-((simtst68)(CUR$.SL$)).lines.LB[0]],((simtst68)(CUR$.SL$)).facit.Elt[i-((simtst68)(CUR$.SL$)).facit.LB[0]]))) {
                    // JavaLine 60 ==> SourceLine 36
                    Ok=false;
                }
            }
            TRACE_END_STM$("CompoundStatement34",36);
        }
    } else
    // JavaLine 67 ==> SourceLine 38
    Ok=false;
    // JavaLine 69 ==> SourceLine 40
    if(VALUE$((!(Ok)))) {
        // JavaLine 71 ==> SourceLine 42
        {
            TRACE_BEGIN_STM$("CompoundStatement42",42);
            sysout().outtext(new TXT$("*** error : Coroutines ("));
            // JavaLine 75 ==> SourceLine 43
            sysout().outint(p$e,(((p$e<(10)))?(1):(2)));
            // JavaLine 77 ==> SourceLine 44
            sysout().outtext(new TXT$(")."));
            // JavaLine 79 ==> SourceLine 45
            sysout().outimage();
            // JavaLine 81 ==> SourceLine 46
            sysout().outtext(new TXT$("            Erroneus output : lnr = "));
            // JavaLine 83 ==> SourceLine 47
            sysout().outint(((simtst68)(CUR$.SL$)).lnr,3);
            // JavaLine 85 ==> SourceLine 48
            sysout().outimage();
            // JavaLine 87 ==> SourceLine 49
            for(boolean CB$49:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((simtst68)(CUR$.SL$)).lnr); }})
               )) { if(!CB$49) continue;
            // JavaLine 91 ==> SourceLine 51
            {
                TRACE_BEGIN_STM$("CompoundStatement51",51);
                sysout().outtext(new TXT$("                 "));
                // JavaLine 95 ==> SourceLine 52
                sysout().outtext(((simtst68)(CUR$.SL$)).lines.Elt[i-((simtst68)(CUR$.SL$)).lines.LB[0]]);
                // JavaLine 97 ==> SourceLine 53
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement51",53);
            }
        }
        // JavaLine 102 ==> SourceLine 55
        sysout().outimage();
        // JavaLine 104 ==> SourceLine 56
        ((simtst68)(CUR$.SL$)).found_error=true;
        TRACE_END_STM$("CompoundStatement42",56);
    }
}
// JavaLine 109 ==> SourceLine 59
for(boolean CB$59:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(20); }})
   )) { if(!CB$59) continue;
// JavaLine 113 ==> SourceLine 60
((simtst68)(CUR$.SL$)).lines.Elt[i-((simtst68)(CUR$.SL$)).lines.LB[0]]=((simtst68)(CUR$.SL$)).facit.Elt[i-((simtst68)(CUR$.SL$)).facit.LB[0]]=null;
}
// JavaLine 116 ==> SourceLine 61
((simtst68)(CUR$.SL$)).lnr=0;
TRACE_END_STM$("Checklines",61);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("simtst68.sim","Procedure Checklines",1,24,13,27,15,28,48,30,50,32,52,34,58,35,60,36,67,38,69,40,71,42,75,43,77,44,79,45,81,46,83,47,85,48,87,49,91,51,95,52,97,53,102,55,104,56,109,59,113,60,116,61,121,63);
}
