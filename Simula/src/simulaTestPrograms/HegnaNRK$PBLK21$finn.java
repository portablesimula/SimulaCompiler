// JavaLine 1 ==> SourceLine 618
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 17 15:04:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$finn extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=618, lastLine=661, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 621
    int i=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$finn(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("finn",621);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$finn STM$() {
        TRACE_BEGIN_STM$("finn",621);
        // JavaLine 25 ==> SourceLine 622
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Egenskap:"));
        // JavaLine 27 ==> SourceLine 623
        ((HegnaNRK$PBLK21)(CUR$.SL$)).antall_egenskaper=(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_egenskaper+(1));
        // JavaLine 29 ==> SourceLine 624
        ((HegnaNRK$PBLK21)(CUR$.SL$)).egenskap.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).antall_egenskaper-((HegnaNRK$PBLK21)(CUR$.SL$)).egenskap.LB[0]]=new HegnaNRK$PBLK21$les_navn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        // JavaLine 31 ==> SourceLine 625
        if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).antall_egenskaper==(1)))) {
            // JavaLine 33 ==> SourceLine 626
            ((HegnaNRK$PBLK21)(CUR$.SL$)).rest=2030552.0f;
        } else
        // JavaLine 36 ==> SourceLine 628
        ((HegnaNRK$PBLK21)(CUR$.SL$)).rest=(((HegnaNRK$PBLK21)(CUR$.SL$)).rest/(((float)(((HegnaNRK$PBLK21)(CUR$.SL$)).divisor.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).antall_egenskaper-((HegnaNRK$PBLK21)(CUR$.SL$)).divisor.LB[0]]))));
        // JavaLine 38 ==> SourceLine 629
        sysout().outtext(new TXT$("S�ker etter "));
        sysout().outtext(((HegnaNRK$PBLK21)(CUR$.SL$)).egenskap.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).antall_egenskaper-((HegnaNRK$PBLK21)(CUR$.SL$)).egenskap.LB[0]]);
        // JavaLine 41 ==> SourceLine 630
        if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).antall_egenskaper>(1)))) {
            // JavaLine 43 ==> SourceLine 632
            {
                TRACE_BEGIN_STM$("CompoundStatement632",632);
                sysout().outtext(new TXT$(" i kombinasjon med f�lgende egenskaper:"));
                // JavaLine 47 ==> SourceLine 633
                for(boolean CB$633:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return((((HegnaNRK$PBLK21)(CUR$.SL$)).antall_egenskaper-(1))); }})
                   )) { if(!CB$633) continue;
                // JavaLine 51 ==> SourceLine 634
                {
                    TRACE_BEGIN_STM$("CompoundStatement634",634);
                    sysout().outimage();
                    // JavaLine 55 ==> SourceLine 635
                    sysout().outtext(((HegnaNRK$PBLK21)(CUR$.SL$)).egenskap.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).egenskap.LB[0]]);
                    TRACE_END_STM$("CompoundStatement634",635);
                }
            }
            TRACE_END_STM$("CompoundStatement632",635);
        }
    }
    // JavaLine 63 ==> SourceLine 638
    sysout().outimage();
    // JavaLine 65 ==> SourceLine 639
    if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).rest<=(((float)(10)))))) {
        ((HegnaNRK$PBLK21)(CUR$.SL$)).rest=((float)(0));
    }
    // JavaLine 69 ==> SourceLine 640
    sysout().outtext(new TXT$("Antall personer funnet:"));
    // JavaLine 71 ==> SourceLine 641
    sysout().outfix(((HegnaNRK$PBLK21)(CUR$.SL$)).rest,0,10);
    // JavaLine 73 ==> SourceLine 642
    sysout().outimage();
    // JavaLine 75 ==> SourceLine 643
    if(VALUE$((((((HegnaNRK$PBLK21)(CUR$.SL$)).antall_egenskaper>(1))&((((HegnaNRK$PBLK21)(CUR$.SL$)).divisor.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).antall_egenskaper-((HegnaNRK$PBLK21)(CUR$.SL$)).divisor.LB[0]]==(1))))&((((HegnaNRK$PBLK21)(CUR$.SL$)).rest>(((float)(1)))))))) {
        // JavaLine 77 ==> SourceLine 646
        {
            TRACE_BEGIN_STM$("CompoundStatement646",646);
            sysout().outtext(new TXT$("Dette er de samme personer som ved forrige s�k."));
            // JavaLine 81 ==> SourceLine 647
            sysout().outimage();
            // JavaLine 83 ==> SourceLine 648
            sysout().outtext(new TXT$("Det er fullt samsvar mellom egenskapene "));
            sysout().outimage();
            // JavaLine 86 ==> SourceLine 649
            sysout().outtext(((HegnaNRK$PBLK21)(CUR$.SL$)).egenskap.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).antall_egenskaper-((HegnaNRK$PBLK21)(CUR$.SL$)).egenskap.LB[0]]);
            sysout().outtext(new TXT$(" og "));
            // JavaLine 89 ==> SourceLine 650
            sysout().outtext(((HegnaNRK$PBLK21)(CUR$.SL$)).egenskap.Elt[(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_egenskaper-(1))-((HegnaNRK$PBLK21)(CUR$.SL$)).egenskap.LB[0]]);
            sysout().outimage();
            TRACE_END_STM$("CompoundStatement646",650);
        }
    }
    // JavaLine 95 ==> SourceLine 652
    if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).rest<=(((float)(1)))))) {
        // JavaLine 97 ==> SourceLine 654
        {
            TRACE_BEGIN_STM$("CompoundStatement654",654);
            sysout().outtext(new TXT$("Ingen norske personer tilfredstiller alle de oppstilte"));
            // JavaLine 101 ==> SourceLine 655
            sysout().outtext(new TXT$(" krav og egenskaper."));
            sysout().outimage();
            // JavaLine 104 ==> SourceLine 656
            sysout().outtext(new TXT$("Jeg er en datamaskin, jeg kan alt og tilfredstiller alle."));
            // JavaLine 106 ==> SourceLine 657
            sysout().outimage();
            // JavaLine 108 ==> SourceLine 658
            sysout().outtext(new TXT$("Hva kan jeg st� til tjeneste med?"));
            sysout().outimage();
            // JavaLine 111 ==> SourceLine 659
            ((HegnaNRK$PBLK21)(CUR$.SL$)).antall_egenskaper=0;
            TRACE_END_STM$("CompoundStatement654",659);
        }
    }
    TRACE_END_STM$("finn",659);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure finn",1,618,11,621,25,622,27,623,29,624,31,625,33,626,36,628,38,629,41,630,43,632,47,633,51,634,55,635,63,638,65,639,69,640,71,641,73,642,75,643,77,646,81,647,83,648,86,649,89,650,95,652,97,654,101,655,104,656,106,657,108,658,111,659,119,661);
}
