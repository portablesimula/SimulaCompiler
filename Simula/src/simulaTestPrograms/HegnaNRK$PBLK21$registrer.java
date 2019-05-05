// JavaLine 1 <== SourceLine 522
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:24:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$registrer extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=522, lastLine=571, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 <== SourceLine 558
    final LABQNT$ loop=new LABQNT$(this,1,"loop"); // Local Label #1=loop
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 524
    int i=0;
    char c=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$registrer(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("registrer",524);
        STM$();
    }
    // Procedure Statements
    public HegnaNRK$PBLK21$registrer STM$() {
        TRACE_BEGIN_STM$("registrer",524);
        HegnaNRK$PBLK21$registrer THIS$=(HegnaNRK$PBLK21$registrer)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 33 <== SourceLine 525
                if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).rest$1>(((float)(80)))))) {
                    // JavaLine 35 <== SourceLine 527
                    {
                        TRACE_BEGIN_STM$("CompoundStatement527",527);
                        sysout().outtext(new TXT$("Antall personer overstiger maskinens utskriftkapasitet."));
                        // JavaLine 39 <== SourceLine 528
                        sysout().outimage();
                        // JavaLine 41 <== SourceLine 529
                        sysout().outtext(new TXT$("Angi flere egenskaper."));
                        sysout().outimage();
                        TRACE_END_STM$("CompoundStatement527",529);
                    }
                } else
                // JavaLine 47 <== SourceLine 532
                if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).rest$1>=(((float)(10)))))) {
                    // JavaLine 49 <== SourceLine 534
                    {
                        TRACE_BEGIN_STM$("CompoundStatement534",534);
                        sysout().outtext(new TXT$("Person-oversikt, geografisk fordeling:"));
                        sysout().outimage();
                        // JavaLine 54 <== SourceLine 535
                        sysout().outint(1,3);
                        sysout().outtext(new TXT$(":  �stlandet  :"));
                        sysout().outint(34,3);
                        sysout().outimage();
                        // JavaLine 59 <== SourceLine 536
                        sysout().outint(2,3);
                        sysout().outtext(new TXT$(":  S�rlandet  :"));
                        sysout().outint(14,3);
                        sysout().outimage();
                        // JavaLine 64 <== SourceLine 537
                        sysout().outint(3,3);
                        sysout().outtext(new TXT$(":  Vestlandet :"));
                        sysout().outint(19,3);
                        sysout().outimage();
                        // JavaLine 69 <== SourceLine 538
                        sysout().outint(4,3);
                        sysout().outtext(new TXT$(":  Nord-Norge :"));
                        sysout().outint(8,3);
                        sysout().outimage();
                        // JavaLine 74 <== SourceLine 539
                        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Hvilken gruppe �nsker De,angi nummer:"));
                        // JavaLine 76 <== SourceLine 540
                        i=sysin().inint();
                        i=3;
                        // JavaLine 79 <== SourceLine 541
                        sysout().outimage();
                        // JavaLine 81 <== SourceLine 542
                        sysout().outtext(new TXT$("Person-oversikt, gruppe 3, Vestlandet:"));
                        sysout().outimage();
                        // JavaLine 84 <== SourceLine 543
                        sysout().outint(1,3);
                        sysout().outtext(new TXT$(":  Rogaland             :"));
                        sysout().outint(5,2);
                        sysout().outimage();
                        // JavaLine 89 <== SourceLine 544
                        sysout().outint(2,3);
                        sysout().outtext(new TXT$(":  Hordaland og Bergen  :"));
                        sysout().outint(8,2);
                        sysout().outimage();
                        // JavaLine 94 <== SourceLine 545
                        sysout().outint(3,3);
                        sysout().outtext(new TXT$(":  M�re og Romsdal      :"));
                        sysout().outint(4,2);
                        sysout().outimage();
                        // JavaLine 99 <== SourceLine 546
                        sysout().outint(4,3);
                        sysout().outtext(new TXT$(":  Sogn og Fjordane     :"));
                        sysout().outint(2,2);
                        sysout().outimage();
                        // JavaLine 104 <== SourceLine 547
                        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Hvilken gruppe �nsker De, angi nummer:"));
                        // JavaLine 106 <== SourceLine 548
                        i=sysin().inint();
                        i=2;
                        ((HegnaNRK$PBLK21)(CUR$.SL$)).rest$1=((float)(8));
                        // JavaLine 110 <== SourceLine 549
                        sysout().outimage();
                        // JavaLine 112 <== SourceLine 550
                        sysout().outtext(new TXT$("Person-oversikt, gruppe 3.2, Hordaland og Bergen"));
                        // JavaLine 114 <== SourceLine 551
                        sysout().outimage();
                        // JavaLine 116 <== SourceLine 552
                        sysout().outtext(new TXT$("Antall personer i gruppen er 8"));
                        sysout().outimage();
                        TRACE_END_STM$("CompoundStatement534",552);
                    }
                }
                // JavaLine 122 <== SourceLine 554
                if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).rest$1<(((float)(10)))))) {
                    // JavaLine 124 <== SourceLine 555
                    {
                        TRACE_BEGIN_STM$("CompoundStatement555",555);
                        sysout().outtext(new TXT$("Det er forbudt � offentliggj�re persondata for "));
                        sysout().outimage();
                        // JavaLine 129 <== SourceLine 556
                        sysout().outtext(new TXT$("grupper med f�rre enn 10 personer"));
                        sysout().outimage();
                        // JavaLine 132 <== SourceLine 557
                        sysout().outtext(new TXT$("uten spesiell tillatelse fra Datatilsynet."));
                        sysout().outimage();
                        // JavaLine 135 <== SourceLine 558
                        LABEL$(1,"loop");
                        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Har De slik tillatelse? J/N:"));
                        // JavaLine 138 <== SourceLine 559
                        c=sysin().inchar();
                        while((c==(((char)32)))) {
                            c=sysin().inchar();
                        }
                        // JavaLine 143 <== SourceLine 560
                        if(VALUE$((c==('J')))) {
                            // JavaLine 145 <== SourceLine 562
                            {
                                TRACE_BEGIN_STM$("CompoundStatement562",562);
                                sysout().outtext(new TXT$("� neida, den g�r ikke, De lurer ikke meg!"));
                                sysout().outimage();
                                // JavaLine 150 <== SourceLine 563
                                sysout().outtext(new TXT$("De st�r ikke i Datatilsynets spesial-register!"));
                                sysout().outimage();
                                // JavaLine 153 <== SourceLine 564
                                sysout().outtext(new TXT$("Svar n� �rlig p� sp�rsm�let!"));
                                sysout().outimage();
                                // JavaLine 156 <== SourceLine 565
                                GOTO$(loop); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement562",565);
                            }
                        }
                        // JavaLine 161 <== SourceLine 567
                        sysout().outtext(new TXT$("Nei da s�, "));
                        // JavaLine 163 <== SourceLine 568
                        sysout().outtext(new TXT$("beklager at jeg ikke kan gi Dem den �nskede utskrift."));
                        // JavaLine 165 <== SourceLine 569
                        sysout().outimage();
                        TRACE_END_STM$("CompoundStatement555",569);
                    }
                }
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("registrer:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("registrer:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("registrer:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("registrer",569);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure registrer",1,522,11,558,14,524,33,525,35,527,39,528,41,529,47,532,49,534,54,535,59,536,64,537,69,538,74,539,76,540,79,541,81,542,84,543,89,544,94,545,99,546,104,547,106,548,110,549,112,550,114,551,116,552,122,554,124,555,129,556,132,557,135,558,138,559,143,560,145,562,150,563,153,564,156,565,161,567,163,568,165,569,187,571);
} // End of Procedure
