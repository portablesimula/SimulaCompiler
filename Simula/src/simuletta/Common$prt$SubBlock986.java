// JavaLine 1 <== SourceLine 986
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:50:34 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock986 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=986, lastLine=1000, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 992
    final LABQNT$ L=new LABQNT$(this,1,"L"); // Local Label #1=L
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 986
    Common$elt_notice e=null;
    // Normal Constructor
    public Common$prt$SubBlock986(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Common$prt$SubBlock986 THIS$=(Common$prt$SubBlock986)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 26 <== SourceLine 988
                sysout().outtext(CONC(CONC(new TXT$("record:"),((Common)(CUR$.SL$.SL$)).symtab.Elt[((Common$structured_const)(((Common$prt)(CUR$.SL$)).inspect$800$16)).str$4-((Common)(CUR$.SL$.SL$)).symtab.LB[0]].symbol),new TXT$("(")));
                ;
                // JavaLine 29 <== SourceLine 989
                e=((Common$elt_notice)(((Common$structured_const)(((Common$prt)(CUR$.SL$)).inspect$800$16)).elt_set$4.first()));
                ;
                // JavaLine 32 <== SourceLine 990
                if(VALUE$((e!=(null)))) {
                    // JavaLine 34 <== SourceLine 991
                    {
                        sysout().outtext(CONC(e.p2$ebox.symbol,new TXT$("=")));
                        ;
                        new Common$prt(((Common)(CUR$.SL$.SL$)),e.p2$elt,0);
                        ;
                        // JavaLine 40 <== SourceLine 992
                        LABEL$(1,"L");
                        e=((Common$elt_notice)(e.suc()));
                        ;
                        // JavaLine 44 <== SourceLine 993
                        if(VALUE$((e!=(null)))) {
                            // JavaLine 46 <== SourceLine 994
                            {
                                sysout().outtext(CONC(CONC(new TXT$(","),e.p2$ebox.symbol),new TXT$("=")));
                                ;
                                // JavaLine 50 <== SourceLine 995
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
                // JavaLine 61 <== SourceLine 998
                sysout().outchar(')');
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock986:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock986:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock986:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock986",1,986,9,992,12,986,26,988,29,989,32,990,34,991,40,992,44,993,46,994,50,995,61,998,80,1000);
} // End of SubBlock
