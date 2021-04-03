// JavaLine 1 <== SourceLine 132
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:47 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InModule$CompoundStatement23$SubBlock27$inxparspec extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=132, lastLine=150, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public Common$parspec RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 13 <== SourceLine 148
    final LABQNT$ EXPS=new LABQNT$(this,1,"EXPS"); // Local Label #1=EXPS
    // Declare locals as attributes
    // JavaLine 16 <== SourceLine 133
    int c=0;
    // JavaLine 18 <== SourceLine 135
    Common$parspec inspect$135$49=null;
    // Normal Constructor
    public InModule$CompoundStatement23$SubBlock27$inxparspec(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public InModule$CompoundStatement23$SubBlock27$inxparspec STM$() {
        InModule$CompoundStatement23$SubBlock27$inxparspec THIS$=(InModule$CompoundStatement23$SubBlock27$inxparspec)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 34 <== SourceLine 134
                ((InModule)(CUR$.SL$.SL$)).inspect$22$42.rutlev$1=Math.addExact(((InModule)(CUR$.SL$.SL$)).inspect$22$42.rutlev$1,1);
                ;
                // JavaLine 37 <== SourceLine 135
                {
                    // BEGIN INSPECTION 
                    inspect$135$49=new Common$parspec(((InModule)(CUR$.SL$.SL$)).inspect$22$42).STM$();
                    if(inspect$135$49!=null) // INSPECT inspect$135$49
                    // JavaLine 42 <== SourceLine 136
                    {
                        RESULT$=((Common$parspec)inspect$135$49);
                        ;
                        // JavaLine 46 <== SourceLine 137
                        while(true) {
                            // JavaLine 48 <== SourceLine 138
                            {
                                c=new InptFile$inbyt(((InModule)(CUR$.SL$.SL$)).inspect$22$43).RESULT$;
                                ;
                                // JavaLine 52 <== SourceLine 139
                                if(VALUE$((((InModule)(CUR$.SL$.SL$)).inspect$22$43.input_trace$3>(0)))) {
                                    new InptFile$outcode(((InModule)(CUR$.SL$.SL$)).inspect$22$43);
                                }
                                ;
                                // JavaLine 57 <== SourceLine 140
                                if(VALUE$((c==(((InModule)(CUR$.SL$.SL$)).inspect$22$42.M_IMPORT$1)))) {
                                    // JavaLine 59 <== SourceLine 141
                                    {
                                        if(VALUE$((inspect$135$49.import$==(null)))) {
                                            inspect$135$49.import$=new Head$(((InModule)(CUR$.SL$.SL$)).inspect$22$42).STM$();
                                        }
                                        ;
                                        // JavaLine 65 <== SourceLine 142
                                        new InModule$CompoundStatement23$SubBlock27$inquant(((InModule$CompoundStatement23$SubBlock27)(CUR$.SL$))).RESULT$.into(inspect$135$49.import$);
                                        ;
                                    }
                                } else
                                // JavaLine 70 <== SourceLine 143
                                if(VALUE$((c==(((InModule)(CUR$.SL$.SL$)).inspect$22$42.M_EXPORT$1)))) {
                                    inspect$135$49.export=new InModule$CompoundStatement23$SubBlock27$inquant(((InModule$CompoundStatement23$SubBlock27)(CUR$.SL$))).RESULT$;
                                } else
                                // JavaLine 74 <== SourceLine 144
                                if(VALUE$((c==(((InModule)(CUR$.SL$.SL$)).inspect$22$42.M_EXIT$1)))) {
                                    inspect$135$49.exit=new InModule$CompoundStatement23$SubBlock27$inquant(((InModule$CompoundStatement23$SubBlock27)(CUR$.SL$))).RESULT$;
                                } else
                                // JavaLine 78 <== SourceLine 145
                                if(VALUE$((c==(((InModule)(CUR$.SL$.SL$)).inspect$22$42.M_END$1)))) {
                                    // JavaLine 80 <== SourceLine 146
                                    GOTO$(EXPS); // GOTO EVALUATED LABEL
                                } else
                                new InModule$CompoundStatement23$SubBlock27$MERR(((InModule$CompoundStatement23$SubBlock27)(CUR$.SL$)),CONC(new TXT$("InXParspec:"),new Common$leftint(((InModule)(CUR$.SL$.SL$)).inspect$22$42,c).RESULT$));
                                ;
                            }
                            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                        }
                        ;
                        // JavaLine 89 <== SourceLine 148
                        LABEL$(1,"EXPS");
                        ;
                    }
                }
                ;
                // JavaLine 95 <== SourceLine 149
                ((InModule)(CUR$.SL$.SL$)).inspect$22$42.rutlev$1=Math.subtractExact(((InModule)(CUR$.SL$.SL$)).inspect$22$42.rutlev$1,1);
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("inxparspec:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("inxparspec:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("inxparspec:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("INMODULE.sim","Procedure inxparspec",1,132,13,148,16,133,18,135,34,134,37,135,42,136,46,137,48,138,52,139,57,140,59,141,65,142,70,143,74,144,78,145,80,146,89,148,95,149,114,150);
} // End of Procedure
