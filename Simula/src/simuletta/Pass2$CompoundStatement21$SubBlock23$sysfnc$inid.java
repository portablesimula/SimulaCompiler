// JavaLine 1 <== SourceLine 1630
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$sysfnc$inid extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=1630, lastLine=1652, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 10 <== SourceLine 1640
    final LABQNT$ ERR=new LABQNT$(this,1,"ERR"); // Local Label #1=ERR
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 1631
    int b=0;
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$sysfnc$inid(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$sysfnc$inid STM$() {
        Pass2$CompoundStatement21$SubBlock23$sysfnc$inid THIS$=(Pass2$CompoundStatement21$SubBlock23$sysfnc$inid)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 29 <== SourceLine 1632
                ((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$.SL$)).apar=Math.subtractExact(((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$.SL$)).apar,1);
                ;
                ((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$.SL$)).inx=0;
                ;
                // JavaLine 34 <== SourceLine 1633
                if(VALUE$((((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$.SL$)).apar>=(0)))) {
                    // JavaLine 36 <== SourceLine 1634
                    {
                        b=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$142).RESULT$;
                        ;
                        // JavaLine 40 <== SourceLine 1635
                        if(VALUE$((b==(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_VAR$1)))) {
                            // JavaLine 42 <== SourceLine 1636
                            {
                                if(VALUE$((new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$142).RESULT$!=(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_SIMPLE$1)))) {
                                    GOTO$(ERR); // GOTO EVALUATED LABEL
                                }
                                ;
                                // JavaLine 48 <== SourceLine 1637
                                if(VALUE$((new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$142).RESULT$!=(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_VARID$1)))) {
                                    GOTO$(ERR); // GOTO EVALUATED LABEL
                                }
                                ;
                                // JavaLine 53 <== SourceLine 1638
                                ((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$.SL$)).inx=new InptFile$in2byt(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$142).RESULT$;
                                ;
                                // JavaLine 56 <== SourceLine 1639
                                if(VALUE$((new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$142).RESULT$!=(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_ENDVAR$1)))) {
                                    // JavaLine 58 <== SourceLine 1643
                                    LABEL$(1,"ERR");
                                    // JavaLine 60 <== SourceLine 1640
                                    {
                                        // JavaLine 62 <== SourceLine 1641
                                        new Common$ERROR(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,CONC(new TXT$("Wrong kind of parameter to "),((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$.SL$)).p$d.symb$2.symbol));
                                        ;
                                        // JavaLine 65 <== SourceLine 1642
                                        while((new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$142).RESULT$!=(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_ENDVAR$1))) {
                                            ;
                                        }
                                    }
                                }
                                ;
                            }
                        } else
                        // JavaLine 74 <== SourceLine 1645
                        {
                            // JavaLine 76 <== SourceLine 1646
                            new Common$ERROR(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,CONC(new TXT$("Wrong kind of parameter to "),((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$.SL$)).p$d.symb$2.symbol));
                            ;
                            // JavaLine 79 <== SourceLine 1647
                            new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)),b);
                            ;
                            // JavaLine 82 <== SourceLine 1648
                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_POP$1);
                            ;
                            // JavaLine 85 <== SourceLine 1649
                            if(VALUE$((((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143);
                            }
                            ;
                        }
                        ;
                    }
                }
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("inid:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("inid:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("inid:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure inid",1,1630,10,1640,13,1631,29,1632,34,1633,36,1634,40,1635,42,1636,48,1637,53,1638,56,1639,58,1643,60,1640,62,1641,65,1642,74,1645,76,1646,79,1647,82,1648,85,1649,111,1652);
} // End of Procedure
