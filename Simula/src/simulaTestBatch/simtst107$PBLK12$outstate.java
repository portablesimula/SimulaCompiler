// JavaLine 1 ==> SourceLine 34
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Mar 17 18:27:05 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst107$PBLK12$outstate extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=34, lastLine=67, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$c;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 35
    int i=0;
    float r=0.0f;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst107$PBLK12$outstate setPar(Object param) {
        //Util.BREAK("CALL simtst107$PBLK12$outstate.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$c=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public simtst107$PBLK12$outstate(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public simtst107$PBLK12$outstate(RTObject$ SL$,int sp$c) {
        super(SL$);
        // Parameter assignment to locals
        this.p$c = sp$c;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("outstate",35);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst107$PBLK12$outstate STM$() {
        TRACE_BEGIN_STM$("outstate",35);
        // JavaLine 44 ==> SourceLine 37
        sysout().outtext(new TXT$("State("));
        sysout().outint(((simtst107$PBLK12)(CUR$.SL$)).testno,1);
        sysout().outchar(',');
        sysout().outint(p$c,2);
        // JavaLine 49 ==> SourceLine 38
        sysout().outtext(new TXT$("): "));
        // JavaLine 51 ==> SourceLine 39
        for(boolean CB$39:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(10); }})
           )) { if(!CB$39) continue;
        // JavaLine 55 ==> SourceLine 40
        {
            TRACE_BEGIN_STM$("CompoundStatement40",40);
            if(VALUE$(((simtst107$PBLK12)(CUR$.SL$)).active.Elt[i-((simtst107$PBLK12)(CUR$.SL$)).active.LB[0]])) {
                // JavaLine 59 ==> SourceLine 41
                sysout().outtext(new TXT$(" a    "));
            } else
            if(VALUE$(((simtst107$PBLK12)(CUR$.SL$)).terminatd.Elt[i-((simtst107$PBLK12)(CUR$.SL$)).terminatd.LB[0]])) {
                // JavaLine 63 ==> SourceLine 42
                sysout().outtext(new TXT$(" t    "));
            } else
            sysout().outtext(new TXT$("p/s   "));
            TRACE_END_STM$("CompoundStatement40",42);
        }
    }
    // JavaLine 70 ==> SourceLine 44
    new simtst107$PBLK12$outimage(((simtst107$PBLK12)(CUR$.SL$)));
    // JavaLine 72 ==> SourceLine 45
    sysout().outtext(new TXT$("SQS:      "));
    // JavaLine 74 ==> SourceLine 46
    for(boolean CB$46:new ForList(
        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(10); }})
       )) { if(!CB$46) continue;
    // JavaLine 78 ==> SourceLine 47
    {
        TRACE_BEGIN_STM$("CompoundStatement47",47);
        if(VALUE$(((simtst107$PBLK12)(CUR$.SL$)).pa.Elt[i-((simtst107$PBLK12)(CUR$.SL$)).pa.LB[0]].idle())) {
            // JavaLine 82 ==> SourceLine 48
            {
                TRACE_BEGIN_STM$("CompoundStatement48",48);
                if(VALUE$(((simtst107$PBLK12)(CUR$.SL$)).pa.Elt[i-((simtst107$PBLK12)(CUR$.SL$)).pa.LB[0]].terminated())) {
                    // JavaLine 86 ==> SourceLine 49
                    sysout().outtext(new TXT$("    t "));
                } else
                sysout().outtext(new TXT$("    p "));
                TRACE_END_STM$("CompoundStatement48",49);
            }
        } else
        // JavaLine 93 ==> SourceLine 51
        if(VALUE$((((simtst107$PBLK12)(CUR$.SL$)).current()==(((simtst107$PBLK12)(CUR$.SL$)).pa.Elt[i-((simtst107$PBLK12)(CUR$.SL$)).pa.LB[0]])))) {
            // JavaLine 95 ==> SourceLine 52
            sysout().outtext(new TXT$("    a "));
        } else
        sysout().outtext(new TXT$("    s "));
        TRACE_END_STM$("CompoundStatement47",52);
    }
}
// JavaLine 102 ==> SourceLine 54
new simtst107$PBLK12$outimage(((simtst107$PBLK12)(CUR$.SL$)));
// JavaLine 104 ==> SourceLine 55
sysout().outfix(((simtst107$PBLK12)(CUR$.SL$)).time(),2,6);
sysout().outtext(new TXT$(" :   "));
// JavaLine 107 ==> SourceLine 56
for(boolean CB$56:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(10); }})
   )) { if(!CB$56) continue;
// JavaLine 111 ==> SourceLine 57
{
    TRACE_BEGIN_STM$("CompoundStatement57",57);
    if(VALUE$(((simtst107$PBLK12)(CUR$.SL$)).pa.Elt[i-((simtst107$PBLK12)(CUR$.SL$)).pa.LB[0]].idle())) {
        // JavaLine 115 ==> SourceLine 58
        sysout().outtext(new TXT$("  idle"));
    } else
    if(VALUE$((((simtst107$PBLK12)(CUR$.SL$)).pa.Elt[i-((simtst107$PBLK12)(CUR$.SL$)).pa.LB[0]]!=(((simtst107$PBLK12)(CUR$.SL$)).current())))) {
        // JavaLine 119 ==> SourceLine 60
        sysout().outfix(((simtst107$PBLK12)(CUR$.SL$)).pa.Elt[i-((simtst107$PBLK12)(CUR$.SL$)).pa.LB[0]].evtime(),2,6);
    } else
    {
        TRACE_BEGIN_STM$("CompoundStatement60",60);
        r=((float)(((simtst107$PBLK12)(CUR$.SL$)).time()));
        // JavaLine 125 ==> SourceLine 61
        if(VALUE$((abs((((simtst107$PBLK12)(CUR$.SL$)).pa.Elt[i-((simtst107$PBLK12)(CUR$.SL$)).pa.LB[0]].evtime()-(((simtst107$PBLK12)(CUR$.SL$)).time())))>(((double)(0.001f)))))) {
            // JavaLine 127 ==> SourceLine 62
            {
                TRACE_BEGIN_STM$("CompoundStatement62",62);
                sysout().outfix(((simtst107$PBLK12)(CUR$.SL$)).pa.Elt[i-((simtst107$PBLK12)(CUR$.SL$)).pa.LB[0]].evtime(),2,5);
                // JavaLine 131 ==> SourceLine 63
                sysout().outchar('*');
                TRACE_END_STM$("CompoundStatement62",63);
            }
        } else
        sysout().outfix(((simtst107$PBLK12)(CUR$.SL$)).pa.Elt[i-((simtst107$PBLK12)(CUR$.SL$)).pa.LB[0]].evtime(),2,6);
        TRACE_END_STM$("CompoundStatement60",63);
    }
    TRACE_END_STM$("CompoundStatement57",63);
}
}
// JavaLine 142 ==> SourceLine 66
new simtst107$PBLK12$outimage(((simtst107$PBLK12)(CUR$.SL$)));
TRACE_END_STM$("outstate",66);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("simtst107.sim","Procedure outstate",1,34,12,35,44,37,49,38,51,39,55,40,59,41,63,42,70,44,72,45,74,46,78,47,82,48,86,49,93,51,95,52,102,54,104,55,107,56,111,57,115,58,119,60,125,61,127,62,131,63,142,66,147,67);
}
