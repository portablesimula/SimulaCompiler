// JavaLine 1 <== SourceLine 951
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$grammar$declarations$CompoundStatement807$SubBlock951 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=5, firstLine=951, lastLine=962, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 954
    final LABQNT$ IDN=new LABQNT$(this,1,"IDN"); // Local Label #1=IDN
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 951
    TXT$ attrfile=null;
    TXT$ modid=null;
    boolean sys=false;
    // Normal Constructor
    public Pass1$SubBlock32$grammar$declarations$CompoundStatement807$SubBlock951(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Pass1$SubBlock32$grammar$declarations$CompoundStatement807$SubBlock951 THIS$=(Pass1$SubBlock32$grammar$declarations$CompoundStatement807$SubBlock951)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 28 <== SourceLine 952
                if(VALUE$(((Pass1$SubBlock32$grammar$declarations)(CUR$.SL$)).p$inrec)) {
                    new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Misplaced insert"));
                }
                ;
                // JavaLine 33 <== SourceLine 953
                sys=(((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_SYSINSERT$1));
                ;
                // JavaLine 36 <== SourceLine 954
                LABEL$(1,"IDN");
                ((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)).detach();
                ;
                // JavaLine 40 <== SourceLine 955
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)),955,((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                }
                ;
                // JavaLine 45 <== SourceLine 956
                modid=new Common$edSymbol(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.hash$1).RESULT$;
                ;
                // JavaLine 48 <== SourceLine 957
                giveTextInfo(2,modid);
                ;
                attrfile=getTextInfo(12);
                ;
                // JavaLine 53 <== SourceLine 958
                new InModule(((BASICIO$)CTX$),((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$63.p3$comn,attrfile,modid);
                ;
                // JavaLine 56 <== SourceLine 959
                ((Common$module)(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.modset$1.last())).system$2=sys;
                ;
                // JavaLine 59 <== SourceLine 960
                ((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)).detach();
                ;
                // JavaLine 62 <== SourceLine 961
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_COMMA$1)))) {
                    GOTO$(IDN); // GOTO EVALUATED LABEL
                }
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock951:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock951:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock951:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","SubBlock SubBlock951",1,951,9,954,12,951,28,952,33,953,36,954,40,955,45,956,48,957,53,958,56,959,59,960,62,961,83,962);
} // End of SubBlock
