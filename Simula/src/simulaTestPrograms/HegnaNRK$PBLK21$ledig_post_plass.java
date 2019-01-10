// JavaLine 1 ==> SourceLine 881
package simulaTestPrograms;
// Release-Beta-0.3 Compiled at Sat Jan 05 17:29:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$ledig_post_plass extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=881, lastLine=897, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 14 ==> SourceLine 895
    final LABQNT$ out=new LABQNT$(this,0,1); // Local Label #1=out
    // Declare locals as attributes
    // JavaLine 17 ==> SourceLine 883
    int i=0;
    int nr=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$ledig_post_plass(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("ledig_post_plass",883);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$ledig_post_plass STM$() {
        TRACE_BEGIN_STM$("ledig_post_plass",883);
        HegnaNRK$PBLK21$ledig_post_plass THIS$=(HegnaNRK$PBLK21$ledig_post_plass)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 36 ==> SourceLine 884
                nr=0;
                // JavaLine 38 ==> SourceLine 885
                if(((((HegnaNRK$PBLK21)(CUR$.SL$)).antall_poster<(((HegnaNRK$PBLK21)(CUR$.SL$)).max_antall_poster))&((((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.Elt[(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_poster+(1))-((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.LB[0]]==(null))))) {
                    // JavaLine 40 ==> SourceLine 887
                    nr=(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_poster+(1));
                } else
                // JavaLine 43 ==> SourceLine 889
                for(boolean CB$889:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$)).max_antall_poster); }})
                   )) { if(!CB$889) continue;
                // JavaLine 47 ==> SourceLine 890
                if((((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.LB[0]]==(null))) {
                    // JavaLine 49 ==> SourceLine 892
                    {
                        TRACE_BEGIN_STM$("CompoundStatement892",892);
                        nr=i;
                        // JavaLine 53 ==> SourceLine 893
                        GOTO$(out); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement892",893);
                    }
                }
            }
            // JavaLine 59 ==> SourceLine 895
            LABEL$(1); // out
            if((nr==(0))) {
                new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),4);
            }
            // JavaLine 64 ==> SourceLine 896
            RESULT$=nr;
            break LOOP$;
        }
        catch(LABQNT$ q) {
            CUR$=THIS$;
            if(q.SL$!=CUR$ || q.prefixLevel!=0) {
                CUR$.STATE$=OperationalState.terminated;
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                throw(q);
            }
            if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
            JTX$=q.index; continue LOOP$; // EG. GOTO Lx
        }
    }
    TRACE_END_STM$("ledig_post_plass",896);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure ledig_post_plass",1,881,14,895,17,883,36,884,38,885,40,887,43,889,47,890,49,892,53,893,59,895,64,896,82,897);
}
