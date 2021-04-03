// JavaLine 1 <== SourceLine 999
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 17:55:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock999 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=999, lastLine=1007, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 1001
    final LABQNT$ L=new LABQNT$(this,1,"L"); // Local Label #1=L
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 999
    Common$const$ e=null;
    // Normal Constructor
    public Common$prt$SubBlock999(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Common$prt$SubBlock999 THIS$=(Common$prt$SubBlock999)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                e=((Common$const$)(((Common$repeated_const)(((Common$prt)(CUR$.SL$)).inspect$800$16)).elt_set$4.first()));
                ;
                sysout().outchar('(');
                ;
                // JavaLine 30 <== SourceLine 1000
                if(VALUE$((e!=(null)))) {
                    // JavaLine 32 <== SourceLine 1001
                    {
                        new Common$prt(((Common)(CUR$.SL$.SL$)),e,0);
                        ;
                        LABEL$(1,"L");
                        e=((Common$const$)(e.suc()));
                        ;
                        // JavaLine 39 <== SourceLine 1002
                        if(VALUE$((e!=(null)))) {
                            // JavaLine 41 <== SourceLine 1003
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
                // JavaLine 54 <== SourceLine 1005
                sysout().outchar(')');
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock999:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock999:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock999:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock999",1,999,9,1001,12,999,30,1000,32,1001,39,1002,41,1003,54,1005,73,1007);
} // End of SubBlock
