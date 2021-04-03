// JavaLine 1 <== SourceLine 981
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:46:15 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock981 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=981, lastLine=995, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 987
    final LABQNT$ L=new LABQNT$(this,1,"L"); // Local Label #1=L
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 981
    Common$elt_notice e=null;
    // Normal Constructor
    public Common$prt$SubBlock981(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Common$prt$SubBlock981 THIS$=(Common$prt$SubBlock981)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 26 <== SourceLine 983
                sysout().outtext(CONC(CONC(new TXT$("record:"),((Common)(CUR$.SL$.SL$)).symtab.Elt[((Common$structured_const)(((Common$prt)(CUR$.SL$)).inspect$795$16)).str$4-((Common)(CUR$.SL$.SL$)).symtab.LB[0]].symbol),new TXT$("(")));
                ;
                // JavaLine 29 <== SourceLine 984
                e=((Common$elt_notice)(((Common$structured_const)(((Common$prt)(CUR$.SL$)).inspect$795$16)).elt_set$4.first()));
                ;
                // JavaLine 32 <== SourceLine 985
                if(VALUE$((e!=(null)))) {
                    // JavaLine 34 <== SourceLine 986
                    {
                        sysout().outtext(CONC(e.p2$ebox.symbol,new TXT$("=")));
                        ;
                        new Common$prt(((Common)(CUR$.SL$.SL$)),e.p2$elt,0);
                        ;
                        // JavaLine 40 <== SourceLine 987
                        LABEL$(1,"L");
                        e=((Common$elt_notice)(e.suc()));
                        ;
                        // JavaLine 44 <== SourceLine 988
                        if(VALUE$((e!=(null)))) {
                            // JavaLine 46 <== SourceLine 989
                            {
                                sysout().outtext(CONC(CONC(new TXT$(","),e.p2$ebox.symbol),new TXT$("=")));
                                ;
                                // JavaLine 50 <== SourceLine 990
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
                // JavaLine 61 <== SourceLine 993
                sysout().outchar(')');
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock981:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock981:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock981:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock981",1,981,9,987,12,981,26,983,29,984,32,985,34,986,40,987,44,988,46,989,50,990,61,993,80,995);
} // End of SubBlock
