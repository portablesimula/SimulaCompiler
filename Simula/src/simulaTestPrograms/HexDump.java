package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri Apr 26 11:57:49 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HexDump extends BASICIO$ {
    public int prefixLevel() { return(0); }
    final LABQNT$ NEXT=new LABQNT$(this,1,"NEXT");
    final LABQNT$ FERDIG=new LABQNT$(this,2,"FERDIG");
    InbyteFile$ Inpt=null;
    int Sequ=0;
    int Code=0;
    TXT$ PrtPart=null;
    public HexDump(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("HexDump");
    }
    public RTObject$ STM$() {
        HexDump THIS$=(HexDump)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                sysout().outtext(new TXT$("SIMULA (R) Hex Dump   Version 0.00"));
                sysout().outimage();
                sysout().outtext(new TXT$("Simula a.s. 1986.  All rights reserved."));
                sysout().outimage();
                sysout().outimage();
                new HexDump$InputFile(((HexDump)CUR$));
                PrtPart=blanks(20);
                LABEL$(1,"NEXT");
                sysout().setpos(60);
                sysout().outtext(PrtPart);
                sysout().outimage();
                if(VALUE$(Inpt.endfile())) {
                    GOTO$(FERDIG);
                }
                Code=new HexDump$InByte(((HexDump)CUR$)).RESULT$;
                if(VALUE$(Inpt.endfile())) {
                    GOTO$(FERDIG);
                }
                TXT$.setpos(PrtPart,1);
                ASGTXT$(PrtPart,null);
                sysout().outint((Sequ-(1)),6);
                sysout().outtext(new TXT$(": "));
                new HexDump$PrtHex(((HexDump)CUR$),Code,2);
                TXT$.putchar(PrtPart,new HexDump$PrtChar(((HexDump)CUR$),Code).RESULT$);
                while((sysout().pos()<(56))) {
                    {
                        Code=new HexDump$InByte(((HexDump)CUR$)).RESULT$;
                        if(VALUE$(Inpt.endfile())) {
                            GOTO$(NEXT);
                        }
                        sysout().outchar(((char)32));
                        new HexDump$PrtHex(((HexDump)CUR$),Code,2);
                        TXT$.putchar(PrtPart,new HexDump$PrtChar(((HexDump)CUR$),Code).RESULT$);
                    }
                }
                GOTO$(NEXT);
                LABEL$(2,"FERDIG");
                Inpt.close();
                sysout().outimage();
                sysout().outimage();
                sysout().outtext(new TXT$("END  --  Input Bytes"));
                sysout().outint((Sequ-(1)),6);
                sysout().outimage();
                sysout().outimage();
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    CUR$.STATE$=OperationalState.terminated;
                    throw(q);
                }
                JTX$=q.index; continue LOOP$;
            }
        }
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new HexDump(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HexDump.sim","SimulaProgram HexDump",1,12,8,57,10,73,12,12,14,14,16,15,18,16,30,50,33,51,35,52,38,53,40,54,42,57,47,59,51,60,56,61,59,62,62,64,65,65,67,66,73,67,76,68,80,70,82,73,85,74,88,75,91,76,112,77);
}
