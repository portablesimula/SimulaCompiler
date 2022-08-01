// JavaLine 1 <== SourceLine 32
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=2, firstLine=32, lastLine=1959, hasLocalClasses=true, System=true
    public boolean isQPSystemBlock() { return(true); }
    // Declare local labels
    // JavaLine 10 <== SourceLine 1957
    final LABQNT$ EXITPASS1=new LABQNT$(this,1,"EXITPASS1"); // Local Label #1=EXITPASS1
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 32
    boolean all_visible=false;
    // JavaLine 15 <== SourceLine 33
    Head$ currentset=null;
    // JavaLine 17 <== SourceLine 34
    TXT$ source_file=null;
    // JavaLine 19 <== SourceLine 35
    int input_trace=0;
    // JavaLine 21 <== SourceLine 36
    int tracemode=0;
    // JavaLine 23 <== SourceLine 38
    FILE$ scanner=null;
    FILE$ parser=null;
    // JavaLine 26 <== SourceLine 40
    int symbol=0;
    // JavaLine 28 <== SourceLine 41
    int inserted=0;
    // JavaLine 30 <== SourceLine 42
    Common$seqtag taglast=null;
    // JavaLine 32 <== SourceLine 43
    Pass1$SubBlock32$sourceElt cursource=null;
    // JavaLine 34 <== SourceLine 44
    TXT$ curval=null;
    // Normal Constructor
    public Pass1$SubBlock32(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Pass1$SubBlock32 THIS$=(Pass1$SubBlock32)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 48 <== SourceLine 1947
                new Pass1$SubBlock32$SubBlock1900((CUR$)).STM$();
                ;
                // JavaLine 51 <== SourceLine 1949
                parser=((Pass1$SubBlock32$grammar)new Pass1$SubBlock32$grammar(((Pass1$SubBlock32)(CUR$)),((Pass1)(CUR$.SL$)).inspect$28$62.L2name$1).START$());
                ;
                // JavaLine 54 <== SourceLine 1950
                {
                    // BEGIN INSPECTION 
                    ((Pass1)(CUR$.SL$)).inspect$1950$113=((Pass1$SubBlock32$getsymb)new Pass1$SubBlock32$getsymb(((Pass1$SubBlock32)(CUR$)),new TXT$("***scanner***")).START$());
                    if(((Pass1)(CUR$.SL$)).inspect$1950$113!=null) // INSPECT inspect$1950$113
                    // JavaLine 59 <== SourceLine 1951
                    {
                        cursource=new Pass1$SubBlock32$sourceElt(((Pass1$SubBlock32)(CUR$))).STM$();
                        ;
                        inserted=0;
                        ;
                        scanner=((FILE$)((Pass1)(CUR$.SL$)).inspect$1950$113);
                        ;
                        // JavaLine 67 <== SourceLine 1952
                        ((Pass1)(CUR$.SL$)).inspect$1950$113.inpt$1=cursource.inptf;
                        ;
                        ((Pass1)(CUR$.SL$)).inspect$1950$113.inim$1=((Pass1)(CUR$.SL$)).inspect$1950$113.inpt$1.image;
                        ;
                        new Pass1$SubBlock32$getsymb$inline(((Pass1)(CUR$.SL$)).inspect$1950$113);
                        ;
                    }
                }
                ;
                // JavaLine 77 <== SourceLine 1954
                call(scanner);
                ;
                // JavaLine 80 <== SourceLine 1957
                LABEL$(1,"EXITPASS1");
                new Pass1$SubBlock32$close(((Pass1$SubBlock32)(CUR$)));
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock32:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock32:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock32:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","SubBlock SubBlock32",1,32,10,1957,13,32,15,33,17,34,19,35,21,36,23,38,26,40,28,41,30,42,32,43,34,44,48,1947,51,1949,54,1950,59,1951,67,1952,77,1954,80,1957,100,1959);
} // End of SubBlock
