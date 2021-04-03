// JavaLine 1 <== SourceLine 989
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock989 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=989, lastLine=1002, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 994
    final LABQNT$ L=new LABQNT$(this,1,"L"); // Local Label #1=L
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 989
    Common$elt_notice e=null;
    // Normal Constructor
    public Common$prt$SubBlock989(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Common$prt$SubBlock989 THIS$=(Common$prt$SubBlock989)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 26 <== SourceLine 990
                sysout().outtext(CONC(CONC(new TXT$("record:"),new Common$edSymbol(((Common)(CUR$.SL$.SL$)),((Common$structured_const)(((Common$prt)(CUR$.SL$)).inspect$804$16)).str$4).RESULT$),new TXT$("(")));
                ;
                // JavaLine 29 <== SourceLine 991
                e=((Common$elt_notice)(((Common$structured_const)(((Common$prt)(CUR$.SL$)).inspect$804$16)).elt_set$4.first()));
                ;
                // JavaLine 32 <== SourceLine 992
                if(VALUE$((e!=(null)))) {
                    // JavaLine 34 <== SourceLine 993
                    {
                        sysout().outtext(CONC(e.p2$ebox.symbol,new TXT$("=")));
                        ;
                        new Common$prt(((Common)(CUR$.SL$.SL$)),e.p2$elt,0);
                        ;
                        // JavaLine 40 <== SourceLine 994
                        LABEL$(1,"L");
                        e=((Common$elt_notice)(e.suc()));
                        ;
                        // JavaLine 44 <== SourceLine 995
                        if(VALUE$((e!=(null)))) {
                            // JavaLine 46 <== SourceLine 996
                            {
                                sysout().outtext(CONC(CONC(new TXT$(","),e.p2$ebox.symbol),new TXT$("=")));
                                ;
                                // JavaLine 50 <== SourceLine 997
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
                // JavaLine 61 <== SourceLine 1000
                sysout().outchar(')');
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock989:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock989:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock989:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock989",1,989,9,994,12,989,26,990,29,991,32,992,34,993,40,994,44,995,46,996,50,997,61,1000,80,1002);
} // End of SubBlock
