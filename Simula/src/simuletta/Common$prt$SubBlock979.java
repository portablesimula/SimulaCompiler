// JavaLine 1 <== SourceLine 979
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:26:02 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock979 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=979, lastLine=993, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 985
    final LABQNT$ L=new LABQNT$(this,1,"L"); // Local Label #1=L
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 979
    Common$elt_notice e=null;
    // Normal Constructor
    public Common$prt$SubBlock979(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Common$prt$SubBlock979 THIS$=(Common$prt$SubBlock979)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 26 <== SourceLine 981
                sysout().outtext(CONC(CONC(new TXT$("record:"),((Common)(CUR$.SL$.SL$)).symtab.Elt[((Common$structured_const)(((Common$prt)(CUR$.SL$)).inspect$793$16)).str$4-((Common)(CUR$.SL$.SL$)).symtab.LB[0]].symbol),new TXT$("(")));
                ;
                // JavaLine 29 <== SourceLine 982
                e=((Common$elt_notice)(((Common$structured_const)(((Common$prt)(CUR$.SL$)).inspect$793$16)).elt_set$4.first()));
                ;
                // JavaLine 32 <== SourceLine 983
                if(VALUE$((e!=(null)))) {
                    // JavaLine 34 <== SourceLine 984
                    {
                        sysout().outtext(CONC(e.p2$ebox.symbol,new TXT$("=")));
                        ;
                        new Common$prt(((Common)(CUR$.SL$.SL$)),e.p2$elt,0);
                        ;
                        // JavaLine 40 <== SourceLine 985
                        LABEL$(1,"L");
                        e=((Common$elt_notice)(e.suc()));
                        ;
                        // JavaLine 44 <== SourceLine 986
                        if(VALUE$((e!=(null)))) {
                            // JavaLine 46 <== SourceLine 987
                            {
                                sysout().outtext(CONC(CONC(new TXT$(","),e.p2$ebox.symbol),new TXT$("=")));
                                ;
                                // JavaLine 50 <== SourceLine 988
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
                // JavaLine 61 <== SourceLine 991
                sysout().outchar(')');
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock979:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock979:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock979:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock979",1,979,9,985,12,979,26,981,29,982,32,983,34,984,40,985,44,986,46,987,50,988,61,991,80,993);
} // End of SubBlock
