// JavaLine 1 <== SourceLine 985
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 17:55:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock985 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=985, lastLine=998, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 990
    final LABQNT$ L=new LABQNT$(this,1,"L"); // Local Label #1=L
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 985
    Common$elt_notice e=null;
    // Normal Constructor
    public Common$prt$SubBlock985(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Common$prt$SubBlock985 THIS$=(Common$prt$SubBlock985)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 26 <== SourceLine 986
                sysout().outtext(CONC(CONC(new TXT$("record:"),new Common$edSymbol(((Common)(CUR$.SL$.SL$)),((Common$structured_const)(((Common$prt)(CUR$.SL$)).inspect$800$16)).str$4).RESULT$),new TXT$("(")));
                ;
                // JavaLine 29 <== SourceLine 987
                e=((Common$elt_notice)(((Common$structured_const)(((Common$prt)(CUR$.SL$)).inspect$800$16)).elt_set$4.first()));
                ;
                // JavaLine 32 <== SourceLine 988
                if(VALUE$((e!=(null)))) {
                    // JavaLine 34 <== SourceLine 989
                    {
                        sysout().outtext(CONC(e.p2$ebox.symbol,new TXT$("=")));
                        ;
                        new Common$prt(((Common)(CUR$.SL$.SL$)),e.p2$elt,0);
                        ;
                        // JavaLine 40 <== SourceLine 990
                        LABEL$(1,"L");
                        e=((Common$elt_notice)(e.suc()));
                        ;
                        // JavaLine 44 <== SourceLine 991
                        if(VALUE$((e!=(null)))) {
                            // JavaLine 46 <== SourceLine 992
                            {
                                sysout().outtext(CONC(CONC(new TXT$(","),e.p2$ebox.symbol),new TXT$("=")));
                                ;
                                // JavaLine 50 <== SourceLine 993
                                new Common$prt(((Common)(CUR$.SL$.SL$)),e.p2$elt,0);
                                ;
                                GOTO$(L); // GOTO EVALUATED LABEL
                                ;
                            }
                        }
                        ;
                    }
                }
                ;
                // JavaLine 61 <== SourceLine 996
                sysout().outchar(')');
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock985:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock985:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock985:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock985",1,985,9,990,12,985,26,986,29,987,32,988,34,989,40,990,44,991,46,992,50,993,61,996,80,998);
} // End of SubBlock
