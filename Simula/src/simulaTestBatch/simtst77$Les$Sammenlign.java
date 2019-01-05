// JavaLine 1 ==> SourceLine 21
package simulaTestBatch;
// Release-Beta-0.3 Compiled at Sat Jan 05 09:02:04 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst77$Les$Sammenlign extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=21, lastLine=44, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public simtst77$Les$Sammenlign(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Sammenlign",23);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst77$Les$Sammenlign STM$() {
        TRACE_BEGIN_STM$("Sammenlign",23);
        // JavaLine 23 ==> SourceLine 27
        for(boolean CB$27:new ForList(
            new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){((simtst77$Les)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((simtst77$Les)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }})
           ,new WhileElt<Number>(new NAME$<Number>(){ public Number put(Number x$){((simtst77$Les)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((simtst77$Les)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(((simtst77$Les)(CUR$.SL$)).i+(1)); }},new NAME$<Boolean>() { public Boolean get(){return(((simtst77$Les)(CUR$.SL$)).i<=(((simtst77$Les)(CUR$.SL$)).lnr)); }})
           ,new WhileElt<Number>(new NAME$<Number>(){ public Number put(Number x$){((simtst77$Les)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((simtst77$Les)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(((simtst77$Les)(CUR$.SL$)).i+(1)); }},new NAME$<Boolean>() { public Boolean get(){return(((simtst77$Les)(CUR$.SL$)).i<=(((simtst77$Les)(CUR$.SL$)).p$andre.lnr)); }})
           )) { if(!CB$27) continue;
        // JavaLine 29 ==> SourceLine 28
        if((!(new simtst77$Les$Sammenlign$OK(((simtst77$Les$Sammenlign)CUR$),((simtst77$Les)(CUR$.SL$)).i).RESULT$))) {
            ((simtst77)(CUR$.SL$.SL$)).found_error=true;
        }
    }
    // JavaLine 34 ==> SourceLine 30
    if(((simtst77)(CUR$.SL$.SL$)).found_error) {
        // JavaLine 36 ==> SourceLine 31
        {
            TRACE_BEGIN_STM$("CompoundStatement31",31);
            sysout().outtext(new TXT$("*** NOTE : Did not work."));
            // JavaLine 40 ==> SourceLine 32
            sysout().outimage();
            // JavaLine 42 ==> SourceLine 33
            sysout().outtext(new TXT$("       Records read from file:"));
            // JavaLine 44 ==> SourceLine 34
            sysout().outimage();
            // JavaLine 46 ==> SourceLine 35
            for(boolean CB$35:new ForList(
                new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){((simtst77$Les)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((simtst77$Les)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }})
               ,new WhileElt<Number>(new NAME$<Number>(){ public Number put(Number x$){((simtst77$Les)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((simtst77$Les)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(((simtst77$Les)(CUR$.SL$)).i+(1)); }},new NAME$<Boolean>() { public Boolean get(){return(((simtst77$Les)(CUR$.SL$)).i<=(((simtst77$Les)(CUR$.SL$)).lnr)); }})
               ,new WhileElt<Number>(new NAME$<Number>(){ public Number put(Number x$){((simtst77$Les)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((simtst77$Les)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(((simtst77$Les)(CUR$.SL$)).i+(1)); }},new NAME$<Boolean>() { public Boolean get(){return(((simtst77$Les)(CUR$.SL$)).i<=(((simtst77$Les)(CUR$.SL$)).p$andre.lnr)); }})
               )) { if(!CB$35) continue;
            // JavaLine 52 ==> SourceLine 36
            {
                TRACE_BEGIN_STM$("CompoundStatement36",36);
                sysout().setpos(5);
                // JavaLine 56 ==> SourceLine 37
                if((((simtst77$Les)(CUR$.SL$)).i<=(((simtst77$Les)(CUR$.SL$)).lnr))) {
                    sysout().outtext(((simtst77$Les)(CUR$.SL$)).linjer.Elt[((simtst77$Les)(CUR$.SL$)).i-((simtst77$Les)(CUR$.SL$)).linjer.LB[0]]);
                }
                // JavaLine 60 ==> SourceLine 38
                sysout().setpos(40);
                // JavaLine 62 ==> SourceLine 39
                if((((simtst77$Les)(CUR$.SL$)).i<=(((simtst77$Les)(CUR$.SL$)).p$andre.lnr))) {
                    sysout().outtext(((ARRAY$<TXT$[]>)((simtst77$Les)(CUR$.SL$)).p$andre.linjer).Elt[((simtst77$Les)(CUR$.SL$)).i-((simtst77$Les)(CUR$.SL$)).p$andre.linjer.LB[0]]);
                }
                // JavaLine 66 ==> SourceLine 41
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement36",41);
            }
        }
        // JavaLine 71 ==> SourceLine 44
        sysout().outimage();
        TRACE_END_STM$("CompoundStatement31",44);
    }
}
TRACE_END_STM$("Sammenlign",44);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("simtst77.sim","Procedure Sammenlign",1,21,23,27,29,28,34,30,36,31,40,32,42,33,44,34,46,35,52,36,56,37,60,38,62,39,66,41,71,44,79,44);
}
