// JavaLine 1 <== SourceLine 11
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:22:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HexDump extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=11, lastLine=71, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare local labels
    // JavaLine 10 <== SourceLine 51
    final LABQNT$ NEXT=new LABQNT$(this,1,"NEXT"); // Local Label #1=NEXT
    // JavaLine 12 <== SourceLine 67
    final LABQNT$ FERDIG=new LABQNT$(this,2,"FERDIG"); // Local Label #2=FERDIG
    // Declare locals as attributes
    // JavaLine 15 <== SourceLine 11
    InbyteFile$ Inpt=null;
    // JavaLine 17 <== SourceLine 13
    int Sequ=0;
    // JavaLine 19 <== SourceLine 14
    int Code=0;
    // JavaLine 21 <== SourceLine 15
    TXT$ PrtPart=null;
    // Normal Constructor
    public HexDump(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("HexDump");
        // Declaration Code
        TRACE_BEGIN_DCL$("HexDump",40);
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("HexDump",40);
        HexDump THIS$=(HexDump)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 38 <== SourceLine 44
                sysout().outtext(new TXT$("SIMULA (R) Hex Dump   Version 0.00"));
                sysout().outimage();
                // JavaLine 41 <== SourceLine 45
                sysout().outtext(new TXT$("Simula a.s. 1986.  All rights reserved."));
                // JavaLine 43 <== SourceLine 46
                sysout().outimage();
                sysout().outimage();
                // JavaLine 46 <== SourceLine 47
                new HexDump$InputFile(((HexDump)CUR$));
                // JavaLine 48 <== SourceLine 48
                PrtPart=blanks(20);
                // JavaLine 50 <== SourceLine 51
                LABEL$(1,"NEXT");
                sysout().setpos(60);
                sysout().outtext(PrtPart);
                sysout().outimage();
                // JavaLine 55 <== SourceLine 53
                if(VALUE$(Inpt.endfile())) {
                    GOTO$(FERDIG); // GOTO EVALUATED LABEL
                }
                // JavaLine 59 <== SourceLine 54
                Code=new HexDump$InByte(((HexDump)CUR$)).RESULT$;
                if(VALUE$(Inpt.endfile())) {
                    GOTO$(FERDIG); // GOTO EVALUATED LABEL
                }
                // JavaLine 64 <== SourceLine 55
                TXT$.setpos(PrtPart,1);
                ASGTXT$(PrtPart,null);
                // JavaLine 67 <== SourceLine 56
                sysout().outint((Sequ-(1)),6);
                sysout().outtext(new TXT$(": "));
                // JavaLine 70 <== SourceLine 58
                new HexDump$PrtHex(((HexDump)CUR$),Code,2);
                TXT$.putchar(PrtPart,new HexDump$PrtChar(((HexDump)CUR$),Code).RESULT$);
                // JavaLine 73 <== SourceLine 59
                while((sysout().pos()<(56))) {
                    // JavaLine 75 <== SourceLine 60
                    {
                        TRACE_BEGIN_STM$("CompoundStatement60",60);
                        Code=new HexDump$InByte(((HexDump)CUR$)).RESULT$;
                        if(VALUE$(Inpt.endfile())) {
                            GOTO$(NEXT); // GOTO EVALUATED LABEL
                        }
                        // JavaLine 82 <== SourceLine 61
                        sysout().outchar(((char)32));
                        new HexDump$PrtHex(((HexDump)CUR$),Code,2);
                        // JavaLine 85 <== SourceLine 62
                        TXT$.putchar(PrtPart,new HexDump$PrtChar(((HexDump)CUR$),Code).RESULT$);
                        TRACE_END_STM$("CompoundStatement60",62);
                    }
                }
                // JavaLine 90 <== SourceLine 64
                GOTO$(NEXT); // GOTO EVALUATED LABEL
                // JavaLine 92 <== SourceLine 67
                LABEL$(2,"FERDIG");
                Inpt.close();
                // JavaLine 95 <== SourceLine 68
                sysout().outimage();
                sysout().outimage();
                // JavaLine 98 <== SourceLine 69
                sysout().outtext(new TXT$("END  --  Input Bytes"));
                sysout().outint(Sequ,6);
                // JavaLine 101 <== SourceLine 70
                sysout().outimage();
                sysout().outimage();
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("HexDump:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("HexDump:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("HexDump:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("HexDump",70);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new HexDump(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("HexDump.sim","SimulaProgram HexDump",1,11,10,51,12,67,15,11,17,13,19,14,21,15,38,44,41,45,43,46,46,47,48,48,50,51,55,53,59,54,64,55,67,56,70,58,73,59,75,60,82,61,85,62,90,64,92,67,95,68,98,69,101,70,127,71);
} // End of SubBlock
