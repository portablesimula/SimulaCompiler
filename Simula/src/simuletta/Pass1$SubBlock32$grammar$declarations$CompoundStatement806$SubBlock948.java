// JavaLine 1 <== SourceLine 948
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 18:09:18 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$grammar$declarations$CompoundStatement806$SubBlock948 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=5, firstLine=948, lastLine=959, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 951
    final LABQNT$ IDN=new LABQNT$(this,1,"IDN"); // Local Label #1=IDN
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 948
    TXT$ attrfile=null;
    TXT$ modid=null;
    boolean sys=false;
    // Normal Constructor
    public Pass1$SubBlock32$grammar$declarations$CompoundStatement806$SubBlock948(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Pass1$SubBlock32$grammar$declarations$CompoundStatement806$SubBlock948 THIS$=(Pass1$SubBlock32$grammar$declarations$CompoundStatement806$SubBlock948)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 28 <== SourceLine 949
                if(VALUE$(((Pass1$SubBlock32$grammar$declarations)(CUR$.SL$)).p$inrec)) {
                    new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$0,new TXT$("Misplaced insert"));
                }
                ;
                // JavaLine 33 <== SourceLine 950
                sys=(((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$0.S_SYSINSERT$1));
                ;
                // JavaLine 36 <== SourceLine 951
                LABEL$(1,"IDN");
                ((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)).detach();
                ;
                // JavaLine 40 <== SourceLine 952
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$0.S_IDENT$1)))) {
                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)),952,((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$0.S_IDENT$1);
                }
                ;
                // JavaLine 45 <== SourceLine 953
                modid=new Common$edSymbol(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$0,((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$0.hash$1).RESULT$;
                ;
                // JavaLine 48 <== SourceLine 954
                giveTextInfo(2,modid);
                ;
                attrfile=getTextInfo(12);
                ;
                // JavaLine 53 <== SourceLine 955
                new InModule(((ENVIRONMENT$)CTX$),((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$1.p3$comn,attrfile,modid);
                ;
                // JavaLine 56 <== SourceLine 956
                ((Common$module)(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$0.modset$1.last())).system$2=sys;
                ;
                // JavaLine 59 <== SourceLine 957
                ((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)).detach();
                ;
                // JavaLine 62 <== SourceLine 958
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$0.S_COMMA$1)))) {
                    GOTO$(IDN); // GOTO EVALUATED LABEL
                }
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock948:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock948:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock948:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","SubBlock SubBlock948",1,948,9,951,12,948,28,949,33,950,36,951,40,952,45,953,48,954,53,955,56,956,59,957,62,958,83,959);
} // End of SubBlock
