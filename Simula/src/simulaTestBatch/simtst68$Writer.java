// JavaLine 1 ==> SourceLine 116
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Wed Feb 06 20:31:43 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst68$Writer extends simtst68$Coroutine {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=1, firstLine=116, lastLine=138, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 12 ==> SourceLine 137
    final LABQNT$ R=new LABQNT$(this,1,1); // Local Label #1=R
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 118
    public int i=0;
    // Normal Constructor
    public simtst68$Writer(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("Writer",118);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("Writer",118,inner);
                simtst68$Writer THIS$=(simtst68$Writer)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 31 ==> SourceLine 120
                        while(true) {
                            // JavaLine 33 ==> SourceLine 122
                            {
                                TRACE_BEGIN_STM$("CompoundStatement122",122);
                                for(boolean CB$122:new ForList(
                                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(15); }})
                                   )) { if(!CB$122) continue;
                                // JavaLine 39 ==> SourceLine 124
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement124",124);
                                    if(VALUE$((((simtst68)(CUR$.SL$)).c2==('!')))) {
                                        // JavaLine 43 ==> SourceLine 126
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement126",126);
                                            new simtst68$Saveline(((simtst68)(CUR$.SL$)));
                                            // JavaLine 47 ==> SourceLine 127
                                            detach();
                                            // JavaLine 49 ==> SourceLine 129
                                            GOTO$(R); // GOTO EVALUATED LABEL
                                            TRACE_END_STM$("CompoundStatement126",129);
                                        }
                                    } else
                                    // JavaLine 54 ==> SourceLine 131
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement131",131);
                                        sysout().outchar(((simtst68)(CUR$.SL$)).c2);
                                        // JavaLine 58 ==> SourceLine 133
                                        resume(((simtst68)(CUR$.SL$)).c);
                                        TRACE_END_STM$("CompoundStatement131",133);
                                    }
                                    TRACE_END_STM$("CompoundStatement124",133);
                                }
                            }
                            // JavaLine 65 ==> SourceLine 135
                            new simtst68$Saveline(((simtst68)(CUR$.SL$)));
                            // JavaLine 67 ==> SourceLine 137
                            LABEL$(1,"R");
                            TRACE_END_STM$("CompoundStatement122",137);
                        }
                           if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                    }
                    // JavaLine 73 ==> SourceLine 120
                    if(inner!=null) {
                        inner.STM$();
                        TRACE_BEGIN_STM_AFTER_INNER$("Writer",120);
                    }
                    break LOOP$;
                }
                catch(LABQNT$ q) {
                    CUR$=THIS$;
                    if(q.SL$!=CUR$ || q.prefixLevel!=1) {
                        CUR$.STATE$=OperationalState.terminated;
                        if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                        throw(q);
                    }
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                    JTX$=q.index; continue LOOP$; // EG. GOTO Lx
                }
            }
            TRACE_END_STM$("Writer",120);
        }
    };
} // End of Constructor
// Class Statements
public simtst68$Writer STM$() { return((simtst68$Writer)CODE$.EXEC$()); }
public simtst68$Writer START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("simtst68.sim","Class Writer",1,116,12,137,15,118,31,120,33,122,39,124,43,126,47,127,49,129,54,131,58,133,65,135,67,137,73,120,97,138);
}
