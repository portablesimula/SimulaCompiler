// JavaLine 1 <== SourceLine 996
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:46:15 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock996 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=996, lastLine=1004, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 998
    final LABQNT$ L=new LABQNT$(this,1,"L"); // Local Label #1=L
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 996
    Common$const$ e=null;
    // Normal Constructor
    public Common$prt$SubBlock996(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Common$prt$SubBlock996 THIS$=(Common$prt$SubBlock996)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                e=((Common$const$)(((Common$repeated_const)(((Common$prt)(CUR$.SL$)).inspect$795$16)).elt_set$4.first()));
                ;
                sysout().outchar('(');
                ;
                // JavaLine 30 <== SourceLine 997
                if(VALUE$((e!=(null)))) {
                    // JavaLine 32 <== SourceLine 998
                    {
                        new Common$prt(((Common)(CUR$.SL$.SL$)),e,0);
                        ;
                        LABEL$(1,"L");
                        e=((Common$const$)(e.suc()));
                        ;
                        // JavaLine 39 <== SourceLine 999
                        if(VALUE$((e!=(null)))) {
                            // JavaLine 41 <== SourceLine 1000
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
                // JavaLine 54 <== SourceLine 1002
                sysout().outchar(')');
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock996:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock996:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock996:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock996",1,996,9,998,12,996,30,997,32,998,39,999,41,1000,54,1002,73,1004);
} // End of SubBlock
