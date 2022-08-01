// JavaLine 1 <== SourceLine 59
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$DEFIDENT extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=59, lastLine=74, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 10 <== SourceLine 73
    final LABQNT$ E=new LABQNT$(this,1,"E"); // Local Label #1=E
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 60
    Common$identsymbol symb=null;
    // JavaLine 15 <== SourceLine 61
    TXT$ ident=null;
    // Normal Constructor
    public Common$DEFIDENT(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$DEFIDENT STM$() {
        Common$DEFIDENT THIS$=(Common$DEFIDENT)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 31 <== SourceLine 62
                if(VALUE$(TRF_EQ(((Common)(CUR$.SL$)).simsymbol$1,null))) {
                    ((Common)(CUR$.SL$)).hash$1=0;
                } else
                // JavaLine 35 <== SourceLine 64
                {
                    if(VALUE$((((Common)(CUR$.SL$)).nSymb$1>=(((Common)(CUR$.SL$)).MAX_SYMB$1)))) {
                        new Common$FATAL_ERROR(((Common)(CUR$.SL$)),new TXT$("Symbol table overflow (DEFIDENT)"));
                    }
                    ;
                    // JavaLine 41 <== SourceLine 65
                    ident=lowcase(copy(copy(((Common)(CUR$.SL$)).simsymbol$1)));
                    ;
                    // JavaLine 44 <== SourceLine 66
                    if(VALUE$((((Common)(CUR$.SL$)).nSymb$1>(0)))) {
                        for(((Common)(CUR$.SL$)).hash$1=0;((Common)(CUR$.SL$)).hash$1<=((Common)(CUR$.SL$)).nSymb$1;((Common)(CUR$.SL$)).hash$1++) {
                            // JavaLine 47 <== SourceLine 68
                            {
                                if(VALUE$(TXTREL$EQ(ident,((Common)(CUR$.SL$)).symtab.Elt[((Common)(CUR$.SL$)).hash$1-((Common)(CUR$.SL$)).symtab.LB[0]].symbol))) {
                                    GOTO$(E); // GOTO EVALUATED LABEL
                                }
                                ;
                            }
                        }
                    }
                    ;
                    // JavaLine 57 <== SourceLine 69
                    symb=new Common$identsymbol(((Common)(CUR$.SL$))).STM$();
                    ;
                    symb.symbol=ident;
                    ;
                    // JavaLine 62 <== SourceLine 70
                    ((Common)(CUR$.SL$)).hash$1=((Common)(CUR$.SL$)).nSymb$1=Math.addExact(((Common)(CUR$.SL$)).nSymb$1,1);
                    ;
                    ((Common)(CUR$.SL$)).symtab.Elt[((Common)(CUR$.SL$)).nSymb$1-((Common)(CUR$.SL$)).symtab.LB[0]]=symb;
                    ;
                }
                ;
                // JavaLine 69 <== SourceLine 73
                LABEL$(1,"E");
                new Common$TRACE(((Common)(CUR$.SL$)),new TXT$("COMMON.DEFIDENT"),73,CONC(CONC(CONC(new TXT$("IDENT: "),new Common$edSymbol(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).hash$1).RESULT$),new TXT$(" ==> ")),new Common$leftint(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).hash$1).RESULT$));
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("DEFIDENT:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("DEFIDENT:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("DEFIDENT:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure DEFIDENT",1,59,10,73,13,60,15,61,31,62,35,64,41,65,44,66,47,68,57,69,62,70,69,73,89,74);
} // End of Procedure
