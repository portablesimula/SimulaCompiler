package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:40:57 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HexDump$InputFile extends BASICIO$ {
    public int prefixLevel() { return(0); }
    TXT$ F=null;
    public HexDump$InputFile(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HexDump$InputFile STM$() {
        ((HexDump)(CUR$.SL$)).Inpt=new InbyteFile$(((BASICIO$)CTX$),new TXT$("File")).STM$();
        if(VALUE$((!(((HexDump)(CUR$.SL$)).Inpt.open())))) {
            {
                sysout().outimage();
                sysout().outtext(new TXT$("The File \""));
                sysout().outtext(F);
                sysout().outtext(new TXT$("\" does not exist or is not accessible"));
                sysout().outimage();
                sysout().outimage();
                terminate_program();
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HexDump.sim","Procedure InputFile",1,17,8,18,16,19,18,20,20,21,25,22,27,23,35,25);
}
