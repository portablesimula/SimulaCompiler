// JavaLine 1 <== SourceLine 77
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$DEFCONST extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=77, lastLine=89, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 10 <== SourceLine 88
    final LABQNT$ E=new LABQNT$(this,1,"E"); // Local Label #1=E
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 78
    Common$constsymbol symb=null;
    // Normal Constructor
    public Common$DEFCONST(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$DEFCONST STM$() {
        Common$DEFCONST THIS$=(Common$DEFCONST)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 29 <== SourceLine 79
                if(VALUE$(TRF_EQ(((Common)(CUR$.SL$)).simsymbol$1,null))) {
                    ((Common)(CUR$.SL$)).hash$1=0;
                } else
                // JavaLine 33 <== SourceLine 81
                {
                    if(VALUE$((((Common)(CUR$.SL$)).nSymb$1>=(((Common)(CUR$.SL$)).MAX_SYMB$1)))) {
                        new Common$FATAL_ERROR(((Common)(CUR$.SL$)),new TXT$("Symbol table overflow (DEFCONST)"));
                    }
                    ;
                    // JavaLine 39 <== SourceLine 82
                    if(VALUE$((((Common)(CUR$.SL$)).nSymb$1>(0)))) {
                        for(((Common)(CUR$.SL$)).hash$1=0;((Common)(CUR$.SL$)).hash$1<=((Common)(CUR$.SL$)).nSymb$1;((Common)(CUR$.SL$)).hash$1++) {
                            // JavaLine 42 <== SourceLine 83
                            {
                                if(VALUE$(TXTREL$EQ(((Common)(CUR$.SL$)).simsymbol$1,((Common)(CUR$.SL$)).symtab.Elt[((Common)(CUR$.SL$)).hash$1-((Common)(CUR$.SL$)).symtab.LB[0]].symbol))) {
                                    GOTO$(E); // GOTO EVALUATED LABEL
                                }
                                ;
                            }
                        }
                    }
                    ;
                    // JavaLine 52 <== SourceLine 84
                    symb=new Common$constsymbol(((Common)(CUR$.SL$))).STM$();
                    ;
                    symb.symbol=copy(copy(((Common)(CUR$.SL$)).simsymbol$1));
                    ;
                    // JavaLine 57 <== SourceLine 85
                    ((Common)(CUR$.SL$)).hash$1=((Common)(CUR$.SL$)).nSymb$1=Math.addExact(((Common)(CUR$.SL$)).nSymb$1,1);
                    ;
                    ((Common)(CUR$.SL$)).symtab.Elt[((Common)(CUR$.SL$)).nSymb$1-((Common)(CUR$.SL$)).symtab.LB[0]]=symb;
                    ;
                }
                ;
                // JavaLine 64 <== SourceLine 88
                LABEL$(1,"E");
                new Common$TRACE(((Common)(CUR$.SL$)),new TXT$("COMMON.DEFCONST"),88,CONC(CONC(CONC(new TXT$("IDENT: "),new Common$edSymbol(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).hash$1).RESULT$),new TXT$(" ==> ")),new Common$leftint(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).hash$1).RESULT$));
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("DEFCONST:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("DEFCONST:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("DEFCONST:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure DEFCONST",1,77,10,88,13,78,29,79,33,81,39,82,42,83,52,84,57,85,64,88,84,89);
} // End of Procedure
