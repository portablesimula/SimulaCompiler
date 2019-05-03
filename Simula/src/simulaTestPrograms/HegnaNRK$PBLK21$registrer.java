package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$registrer extends BASICIO$ {
    public int prefixLevel() { return(0); }
    final LABQNT$ loop=new LABQNT$(this,1,"loop");
    int i=0;
    char c=0;
    public HegnaNRK$PBLK21$registrer(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$registrer STM$() {
        HegnaNRK$PBLK21$registrer THIS$=(HegnaNRK$PBLK21$registrer)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).rest$1>(((float)(80)))))) {
                    {
                        sysout().outtext(new TXT$("Antall personer overstiger maskinens utskriftkapasitet."));
                        sysout().outimage();
                        sysout().outtext(new TXT$("Angi flere egenskaper."));
                        sysout().outimage();
                    }
                } else
                if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).rest$1>=(((float)(10)))))) {
                    {
                        sysout().outtext(new TXT$("Person-oversikt, geografisk fordeling:"));
                        sysout().outimage();
                        sysout().outint(1,3);
                        sysout().outtext(new TXT$(":  �stlandet  :"));
                        sysout().outint(34,3);
                        sysout().outimage();
                        sysout().outint(2,3);
                        sysout().outtext(new TXT$(":  S�rlandet  :"));
                        sysout().outint(14,3);
                        sysout().outimage();
                        sysout().outint(3,3);
                        sysout().outtext(new TXT$(":  Vestlandet :"));
                        sysout().outint(19,3);
                        sysout().outimage();
                        sysout().outint(4,3);
                        sysout().outtext(new TXT$(":  Nord-Norge :"));
                        sysout().outint(8,3);
                        sysout().outimage();
                        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Hvilken gruppe �nsker De,angi nummer:"));
                        i=sysin().inint();
                        i=3;
                        sysout().outimage();
                        sysout().outtext(new TXT$("Person-oversikt, gruppe 3, Vestlandet:"));
                        sysout().outimage();
                        sysout().outint(1,3);
                        sysout().outtext(new TXT$(":  Rogaland             :"));
                        sysout().outint(5,2);
                        sysout().outimage();
                        sysout().outint(2,3);
                        sysout().outtext(new TXT$(":  Hordaland og Bergen  :"));
                        sysout().outint(8,2);
                        sysout().outimage();
                        sysout().outint(3,3);
                        sysout().outtext(new TXT$(":  M�re og Romsdal      :"));
                        sysout().outint(4,2);
                        sysout().outimage();
                        sysout().outint(4,3);
                        sysout().outtext(new TXT$(":  Sogn og Fjordane     :"));
                        sysout().outint(2,2);
                        sysout().outimage();
                        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Hvilken gruppe �nsker De, angi nummer:"));
                        i=sysin().inint();
                        i=2;
                        ((HegnaNRK$PBLK21)(CUR$.SL$)).rest$1=((float)(8));
                        sysout().outimage();
                        sysout().outtext(new TXT$("Person-oversikt, gruppe 3.2, Hordaland og Bergen"));
                        sysout().outimage();
                        sysout().outtext(new TXT$("Antall personer i gruppen er 8"));
                        sysout().outimage();
                    }
                }
                if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).rest$1<(((float)(10)))))) {
                    {
                        sysout().outtext(new TXT$("Det er forbudt � offentliggj�re persondata for "));
                        sysout().outimage();
                        sysout().outtext(new TXT$("grupper med f�rre enn 10 personer"));
                        sysout().outimage();
                        sysout().outtext(new TXT$("uten spesiell tillatelse fra Datatilsynet."));
                        sysout().outimage();
                        LABEL$(1,"loop");
                        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Har De slik tillatelse? J/N:"));
                        c=sysin().inchar();
                        while((c==(((char)32)))) {
                            c=sysin().inchar();
                        }
                        if(VALUE$((c==('J')))) {
                            {
                                sysout().outtext(new TXT$("� neida, den g�r ikke, De lurer ikke meg!"));
                                sysout().outimage();
                                sysout().outtext(new TXT$("De st�r ikke i Datatilsynets spesial-register!"));
                                sysout().outimage();
                                sysout().outtext(new TXT$("Svar n� �rlig p� sp�rsm�let!"));
                                sysout().outimage();
                                GOTO$(loop);
                            }
                        }
                        sysout().outtext(new TXT$("Nei da s�, "));
                        sysout().outtext(new TXT$("beklager at jeg ikke kan gi Dem den �nskede utskrift."));
                        sysout().outimage();
                    }
                }
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
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure registrer",1,522,8,558,10,524,23,525,25,527,28,528,30,529,35,532,37,534,41,535,46,536,51,537,56,538,61,539,63,540,66,541,68,542,71,543,76,544,81,545,86,546,91,547,93,548,97,549,99,550,101,551,103,552,108,554,110,555,114,556,117,557,120,558,123,559,128,560,130,562,134,563,137,564,140,565,144,567,146,568,148,569,165,571);
}
