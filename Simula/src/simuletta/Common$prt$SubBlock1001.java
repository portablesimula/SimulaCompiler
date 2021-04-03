// JavaLine 1 <== SourceLine 1001
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:50:34 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock1001 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=1001, lastLine=1009, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 1003
    final LABQNT$ L=new LABQNT$(this,1,"L"); // Local Label #1=L
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 1001
    Common$const$ e=null;
    // Normal Constructor
    public Common$prt$SubBlock1001(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Common$prt$SubBlock1001 THIS$=(Common$prt$SubBlock1001)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                e=((Common$const$)(((Common$repeated_const)(((Common$prt)(CUR$.SL$)).inspect$800$16)).elt_set$4.first()));
                ;
                sysout().outchar('(');
                ;
                // JavaLine 30 <== SourceLine 1002
                if(VALUE$((e!=(null)))) {
                    // JavaLine 32 <== SourceLine 1003
                    {
                        new Common$prt(((Common)(CUR$.SL$.SL$)),e,0);
                        ;
                        LABEL$(1,"L");
                        e=((Common$const$)(e.suc()));
                        ;
                        // JavaLine 39 <== SourceLine 1004
                        if(VALUE$((e!=(null)))) {
                            // JavaLine 41 <== SourceLine 1005
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
                // JavaLine 54 <== SourceLine 1007
                sysout().outchar(')');
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1001:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1001:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1001:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock1001",1,1001,9,1003,12,1001,30,1002,32,1003,39,1004,41,1005,54,1007,73,1009);
} // End of SubBlock
