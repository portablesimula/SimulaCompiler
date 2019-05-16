// JavaLine 1 <== SourceLine 8
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 17:59:16 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class _Queens$SubBlock8 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=2, firstLine=8, lastLine=18, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare local labels
    // JavaLine 10 <== SourceLine 9
    final LABQNT$ e=new LABQNT$(this,1,"e"); // Local Label #1=e
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 8
    int k=0;
    int j=0;
    // Normal Constructor
    public _Queens$SubBlock8(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock8",8);
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock8",8);
        _Queens$SubBlock8 THIS$=(_Queens$SubBlock8)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 30 <== SourceLine 10
                LABEL$(1,"e");
                // JavaLine 32 <== SourceLine 9
                while((j==(8))) {
                    // JavaLine 34 <== SourceLine 10
                    {
                        TRACE_BEGIN_STM$("CompoundStatement10",10);
                        ((_Queens)(CUR$.SL$)).i=Math.subtractExact(((_Queens)(CUR$.SL$)).i,3);
                        j=TXT$.getint(TXT$.sub(sysout().image,((_Queens)(CUR$.SL$)).i,1));
                        TRACE_END_STM$("CompoundStatement10",10);
                    }
                }
                // JavaLine 42 <== SourceLine 11
                j=Math.addExact(j,1);
                sysout().setpos(3);
                // JavaLine 45 <== SourceLine 12
                while((sysout().pos()!=(((_Queens)(CUR$.SL$)).i))) {
                    // JavaLine 47 <== SourceLine 13
                    {
                        TRACE_BEGIN_STM$("CompoundStatement13",13);
                        k=TXT$.getint(TXT$.sub(sysout().image,sysout().pos(),1));
                        // JavaLine 51 <== SourceLine 14
                        if(VALUE$(((j==(k))|(((((double)(3))*(abs(((double)(Math.subtractExact(j,k))))))==(abs(((double)(Math.subtractExact(((_Queens)(CUR$.SL$)).i,sysout().pos())))))))))) {
                            GOTO$(e); // GOTO EVALUATED LABEL
                        }
                        // JavaLine 55 <== SourceLine 15
                        sysout().setpos(Math.addExact(sysout().pos(),3));
                        TRACE_END_STM$("CompoundStatement13",15);
                    }
                }
                // JavaLine 60 <== SourceLine 17
                sysout().outint(j,1);
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock8:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock8:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock8:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("SubBlock8",17);
        EBLK();
        return(null);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("8Queens.sim","SubBlock SubBlock8",1,8,10,9,13,8,30,10,32,9,34,10,42,11,45,12,47,13,51,14,55,15,60,17,79,18);
} // End of SubBlock
