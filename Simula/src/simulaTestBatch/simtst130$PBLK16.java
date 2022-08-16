package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 15 13:05:50 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst130$PBLK16 extends DEC_Lib$ {
    public boolean b$1=false;
    public boolean doAbort$1=false;
    public int i$1=0;
    public int j$1=0;
    public int p$1=0;
    public float r$1=0.0f;
    public double lr$1=0.0d;
    public char c$1=0;
    public TXT$ m$1=null;
    public TXT$ o$1=null;
    public TXT$ n$1=null;
    public TXT$ fileName$1=null;
    public TXT$ defaultextension$1=null;
    public TXT$ t$1=null;
    public TXT$ t1$1=null;
    public TXT$ t2$1=null;
    public TXT$ t3$1=null;
    public TXT$ t4$1=null;
    public TXT$ t5$1=null;
    public file$ f$1=null;
    public printfile$ pf$1=null;
    public simtst130$PBLK16(RTObject$ staticLink) {
        super(staticLink);
    }
    public simtst130$PBLK16 STM$() {
        if(VALUE$(false)) {
            {
                sysout().outtext(new TXT$("--- START SIMULA TEST 130"));
                ;
                sysout().outimage();
                ;
                sysout().outtext(new TXT$("--- Class SimLib, a set of utility procedures from DEC Handbook."));
                ;
                sysout().outimage();
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        new simtst130$simtst130$PBLK16$fullTest((CUR$));
        ;
        if(VALUE$((((simtst130)(CUR$.SL$)).nFailed==(0)))) {
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 130"));
        } else
        sysout().outtext(CONC(CONC(new TXT$("--- "),ENVIRONMENT$.edit(((simtst130)(CUR$.SL$)).nFailed)),new TXT$(" ERRORS FOUND IN TEST 130")));
        ;
        if(VALUE$(false)) {
            {
                sysout().outimage();
                ;
                sysout().outtext(new TXT$("--- END SIMULA TEST 130"));
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst130.sim","PrefixedBlock simtst130$PBLK16",1,16,9,17,13,18,15,19,17,20,19,21,23,22,26,23,33,24,35,25,41,1289,43,1290,49,1291,52,1292,60,1296,63,1301,65,1302,70,1304,72,1305,76,1306,79,1307,87,1311);
}
