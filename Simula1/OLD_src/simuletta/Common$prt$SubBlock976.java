// JavaLine 1 <== SourceLine 976
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:22:27 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock976 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=976, lastLine=990, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 982
    final LABQNT$ L=new LABQNT$(this,1,"L"); // Local Label #1=L
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 976
    Common$elt_notice e=null;
    // Normal Constructor
    public Common$prt$SubBlock976(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Common$prt$SubBlock976 THIS$=(Common$prt$SubBlock976)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 26 <== SourceLine 978
                sysout().outtext(CONC(CONC(new TXT$("record:"),((Common)(CUR$.SL$.SL$)).symtab.Elt[((Common$structured_const)(((Common$prt)(CUR$.SL$)).inspect$790$16)).str$4-((Common)(CUR$.SL$.SL$)).symtab.LB[0]].symbol),new TXT$("(")));
                ;
                // JavaLine 29 <== SourceLine 979
                e=((Common$elt_notice)(((Common$structured_const)(((Common$prt)(CUR$.SL$)).inspect$790$16)).elt_set$4.first()));
                ;
                // JavaLine 32 <== SourceLine 980
                if(VALUE$((e!=(null)))) {
                    // JavaLine 34 <== SourceLine 981
                    {
                        sysout().outtext(CONC(e.p2$ebox.symbol,new TXT$("=")));
                        ;
                        new Common$prt(((Common)(CUR$.SL$.SL$)),e.p2$elt,0);
                        ;
                        // JavaLine 40 <== SourceLine 982
                        LABEL$(1,"L");
                        e=((Common$elt_notice)(e.suc()));
                        ;
                        // JavaLine 44 <== SourceLine 983
                        if(VALUE$((e!=(null)))) {
                            // JavaLine 46 <== SourceLine 984
                            {
                                sysout().outtext(CONC(CONC(new TXT$(","),e.p2$ebox.symbol),new TXT$("=")));
                                ;
                                // JavaLine 50 <== SourceLine 985
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
                // JavaLine 61 <== SourceLine 988
                sysout().outchar(')');
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock976:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock976:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock976:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock976",1,976,9,982,12,976,26,978,29,979,32,980,34,981,40,982,44,983,46,984,50,985,61,988,80,990);
} // End of SubBlock
