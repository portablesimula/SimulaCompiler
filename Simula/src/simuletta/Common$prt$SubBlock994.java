// JavaLine 1 <== SourceLine 994
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:26:02 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock994 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=994, lastLine=1002, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 996
    final LABQNT$ L=new LABQNT$(this,1,"L"); // Local Label #1=L
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 994
    Common$const$ e=null;
    // Normal Constructor
    public Common$prt$SubBlock994(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Common$prt$SubBlock994 THIS$=(Common$prt$SubBlock994)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                e=((Common$const$)(((Common$repeated_const)(((Common$prt)(CUR$.SL$)).inspect$793$16)).elt_set$4.first()));
                ;
                sysout().outchar('(');
                ;
                // JavaLine 30 <== SourceLine 995
                if(VALUE$((e!=(null)))) {
                    // JavaLine 32 <== SourceLine 996
                    {
                        new Common$prt(((Common)(CUR$.SL$.SL$)),e,0);
                        ;
                        LABEL$(1,"L");
                        e=((Common$const$)(e.suc()));
                        ;
                        // JavaLine 39 <== SourceLine 997
                        if(VALUE$((e!=(null)))) {
                            // JavaLine 41 <== SourceLine 998
                            {
                                sysout().outchar(',');
                                ;
                                new Common$prt(((Common)(CUR$.SL$.SL$)),e,0);
                                ;
                                GOTO$(L); // GOTO EVALUATED LABEL
                            }
                        }
                        ;
                    }
                }
                ;
                // JavaLine 54 <== SourceLine 1000
                sysout().outchar(')');
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock994:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock994:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock994:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock994",1,994,9,996,12,994,30,995,32,996,39,997,41,998,54,1000,73,1002);
} // End of SubBlock
