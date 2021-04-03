// JavaLine 1 <== SourceLine 112
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:47 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InModule$CompoundStatement23$SubBlock27$inparspec extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=112, lastLine=130, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public Common$parspec RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 13 <== SourceLine 128
    final LABQNT$ EXPS=new LABQNT$(this,1,"EXPS"); // Local Label #1=EXPS
    // Declare locals as attributes
    // JavaLine 16 <== SourceLine 113
    int c=0;
    // JavaLine 18 <== SourceLine 115
    Common$parspec inspect$115$48=null;
    // Normal Constructor
    public InModule$CompoundStatement23$SubBlock27$inparspec(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public InModule$CompoundStatement23$SubBlock27$inparspec STM$() {
        InModule$CompoundStatement23$SubBlock27$inparspec THIS$=(InModule$CompoundStatement23$SubBlock27$inparspec)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 34 <== SourceLine 114
                ((InModule)(CUR$.SL$.SL$)).inspect$22$42.rutlev$1=Math.addExact(((InModule)(CUR$.SL$.SL$)).inspect$22$42.rutlev$1,1);
                ;
                // JavaLine 37 <== SourceLine 115
                {
                    // BEGIN INSPECTION 
                    inspect$115$48=new Common$parspec(((InModule)(CUR$.SL$.SL$)).inspect$22$42).STM$();
                    if(inspect$115$48!=null) // INSPECT inspect$115$48
                    // JavaLine 42 <== SourceLine 116
                    {
                        RESULT$=((Common$parspec)inspect$115$48);
                        ;
                        // JavaLine 46 <== SourceLine 117
                        while(true) {
                            // JavaLine 48 <== SourceLine 118
                            {
                                c=new InptFile$inbyt(((InModule)(CUR$.SL$.SL$)).inspect$22$43).RESULT$;
                                ;
                                // JavaLine 52 <== SourceLine 119
                                if(VALUE$((((InModule)(CUR$.SL$.SL$)).inspect$22$43.input_trace$3>(0)))) {
                                    new InptFile$outcode(((InModule)(CUR$.SL$.SL$)).inspect$22$43);
                                }
                                ;
                                // JavaLine 57 <== SourceLine 120
                                if(VALUE$((c==(((InModule)(CUR$.SL$.SL$)).inspect$22$42.M_IMPORT$1)))) {
                                    // JavaLine 59 <== SourceLine 121
                                    {
                                        if(VALUE$((inspect$115$48.import$==(null)))) {
                                            inspect$115$48.import$=new Head$(((InModule)(CUR$.SL$.SL$)).inspect$22$42).STM$();
                                        }
                                        ;
                                        // JavaLine 65 <== SourceLine 122
                                        new InModule$CompoundStatement23$SubBlock27$inpar(((InModule$CompoundStatement23$SubBlock27)(CUR$.SL$))).RESULT$.into(inspect$115$48.import$);
                                        ;
                                    }
                                } else
                                // JavaLine 70 <== SourceLine 123
                                if(VALUE$((c==(((InModule)(CUR$.SL$.SL$)).inspect$22$42.M_EXPORT$1)))) {
                                    inspect$115$48.export=new InModule$CompoundStatement23$SubBlock27$inpar(((InModule$CompoundStatement23$SubBlock27)(CUR$.SL$))).RESULT$;
                                } else
                                // JavaLine 74 <== SourceLine 124
                                if(VALUE$((c==(((InModule)(CUR$.SL$.SL$)).inspect$22$42.M_EXIT$1)))) {
                                    inspect$115$48.exit=new InModule$CompoundStatement23$SubBlock27$inpar(((InModule$CompoundStatement23$SubBlock27)(CUR$.SL$))).RESULT$;
                                } else
                                // JavaLine 78 <== SourceLine 125
                                if(VALUE$((c==(((InModule)(CUR$.SL$.SL$)).inspect$22$42.M_END$1)))) {
                                    // JavaLine 80 <== SourceLine 126
                                    GOTO$(EXPS); // GOTO EVALUATED LABEL
                                } else
                                new InModule$CompoundStatement23$SubBlock27$MERR(((InModule$CompoundStatement23$SubBlock27)(CUR$.SL$)),CONC(new TXT$("InParspec:"),new Common$leftint(((InModule)(CUR$.SL$.SL$)).inspect$22$42,c).RESULT$));
                                ;
                            }
                            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                        }
                        ;
                        // JavaLine 89 <== SourceLine 128
                        LABEL$(1,"EXPS");
                        ;
                    }
                }
                ;
                // JavaLine 95 <== SourceLine 129
                ((InModule)(CUR$.SL$.SL$)).inspect$22$42.rutlev$1=Math.subtractExact(((InModule)(CUR$.SL$.SL$)).inspect$22$42.rutlev$1,1);
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("inparspec:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("inparspec:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("inparspec:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("INMODULE.sim","Procedure inparspec",1,112,13,128,16,113,18,115,34,114,37,115,42,116,46,117,48,118,52,119,57,120,59,121,65,122,70,123,74,124,78,125,80,126,89,128,95,129,114,130);
} // End of Procedure
