// JavaLine 1 <== SourceLine 949
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:22:51 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$grammar$declarations$CompoundStatement807$SubBlock949 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=5, firstLine=949, lastLine=960, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 952
    final LABQNT$ IDN=new LABQNT$(this,1,"IDN"); // Local Label #1=IDN
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 949
    TXT$ attrfile=null;
    TXT$ modid=null;
    boolean sys=false;
    // Normal Constructor
    public Pass1$SubBlock32$grammar$declarations$CompoundStatement807$SubBlock949(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Pass1$SubBlock32$grammar$declarations$CompoundStatement807$SubBlock949 THIS$=(Pass1$SubBlock32$grammar$declarations$CompoundStatement807$SubBlock949)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 28 <== SourceLine 950
                if(VALUE$(((Pass1$SubBlock32$grammar$declarations)(CUR$.SL$)).p$inrec)) {
                    new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Misplaced insert"));
                }
                ;
                // JavaLine 33 <== SourceLine 951
                sys=(((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_SYSINSERT$1));
                ;
                // JavaLine 36 <== SourceLine 952
                LABEL$(1,"IDN");
                ((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)).detach();
                ;
                // JavaLine 40 <== SourceLine 953
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)),953,((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                }
                ;
                // JavaLine 45 <== SourceLine 954
                modid=new Common$edSymbol(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.hash$1).RESULT$;
                ;
                // JavaLine 48 <== SourceLine 955
                giveTextInfo(2,modid);
                ;
                attrfile=getTextInfo(12);
                ;
                // JavaLine 53 <== SourceLine 956
                new InModule(((BASICIO$)CTX$),((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$63.p3$comn,attrfile,modid);
                ;
                // JavaLine 56 <== SourceLine 957
                ((Common$module)(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.modset$1.last())).system$2=sys;
                ;
                // JavaLine 59 <== SourceLine 958
                ((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)).detach();
                ;
                // JavaLine 62 <== SourceLine 959
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_COMMA$1)))) {
                    GOTO$(IDN); // GOTO EVALUATED LABEL
                }
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock949:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock949:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock949:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","SubBlock SubBlock949",1,949,9,952,12,949,28,950,33,951,36,952,40,953,45,954,48,955,53,956,56,957,59,958,62,959,83,960);
} // End of SubBlock
