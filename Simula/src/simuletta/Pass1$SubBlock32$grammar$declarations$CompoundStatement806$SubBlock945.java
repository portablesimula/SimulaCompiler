// JavaLine 1 <== SourceLine 945
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 15:02:31 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$grammar$declarations$CompoundStatement806$SubBlock945 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=5, firstLine=945, lastLine=956, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 948
    final LABQNT$ IDN=new LABQNT$(this,1,"IDN"); // Local Label #1=IDN
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 945
    TXT$ attrfile=null;
    TXT$ modid=null;
    boolean sys=false;
    // Normal Constructor
    public Pass1$SubBlock32$grammar$declarations$CompoundStatement806$SubBlock945(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Pass1$SubBlock32$grammar$declarations$CompoundStatement806$SubBlock945 THIS$=(Pass1$SubBlock32$grammar$declarations$CompoundStatement806$SubBlock945)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 28 <== SourceLine 946
                if(VALUE$(((Pass1$SubBlock32$grammar$declarations)(CUR$.SL$)).p$inrec)) {
                    new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Misplaced insert"));
                }
                ;
                // JavaLine 33 <== SourceLine 947
                sys=(((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_SYSINSERT$1));
                ;
                // JavaLine 36 <== SourceLine 948
                LABEL$(1,"IDN");
                ((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)).detach();
                ;
                // JavaLine 40 <== SourceLine 949
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)),949,((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                }
                ;
                // JavaLine 45 <== SourceLine 950
                modid=new Common$edSymbol(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.hash$1).RESULT$;
                ;
                // JavaLine 48 <== SourceLine 951
                giveTextInfo(2,modid);
                ;
                attrfile=getTextInfo(12);
                ;
                // JavaLine 53 <== SourceLine 952
                new InModule(((BASICIO$)CTX$),((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$63.p3$comn,attrfile,modid);
                ;
                // JavaLine 56 <== SourceLine 953
                ((Common$module)(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.modset$1.last())).system$2=sys;
                ;
                // JavaLine 59 <== SourceLine 954
                ((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)).detach();
                ;
                // JavaLine 62 <== SourceLine 955
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_COMMA$1)))) {
                    GOTO$(IDN); // GOTO EVALUATED LABEL
                }
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock945:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock945:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock945:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","SubBlock SubBlock945",1,945,9,948,12,945,28,946,33,947,36,948,40,949,45,950,48,951,53,952,56,953,59,954,62,955,83,956);
} // End of SubBlock
