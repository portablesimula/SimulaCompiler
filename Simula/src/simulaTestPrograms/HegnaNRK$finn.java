package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$finn extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    public HegnaNRK$finn(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$finn STM$() {
        new HegnaNRK$lede_tekst(((HegnaNRK)(CUR$.SL$)),new TXT$("Egenskap:"));
        ((HegnaNRK)(CUR$.SL$)).antall_egenskaper$1=(((HegnaNRK)(CUR$.SL$)).antall_egenskaper$1+(1));
        ((HegnaNRK)(CUR$.SL$)).egenskap.Elt[((HegnaNRK)(CUR$.SL$)).antall_egenskaper$1-((HegnaNRK)(CUR$.SL$)).egenskap.LB[0]]=new HegnaNRK$les_navn(((HegnaNRK)(CUR$.SL$))).RESULT$;
        if(VALUE$((((HegnaNRK)(CUR$.SL$)).antall_egenskaper$1==(1)))) {
            ((HegnaNRK)(CUR$.SL$)).rest$1=2030552.0f;
        } else
        ((HegnaNRK)(CUR$.SL$)).rest$1=(((HegnaNRK)(CUR$.SL$)).rest$1/(((float)(((HegnaNRK)(CUR$.SL$)).divisor.Elt[((HegnaNRK)(CUR$.SL$)).antall_egenskaper$1-((HegnaNRK)(CUR$.SL$)).divisor.LB[0]]))));
        sysout().outtext(new TXT$("S�ker etter "));
        sysout().outtext(((HegnaNRK)(CUR$.SL$)).egenskap.Elt[((HegnaNRK)(CUR$.SL$)).antall_egenskaper$1-((HegnaNRK)(CUR$.SL$)).egenskap.LB[0]]);
        if(VALUE$((((HegnaNRK)(CUR$.SL$)).antall_egenskaper$1>(1)))) {
            {
                sysout().outtext(new TXT$(" i kombinasjon med f�lgende egenskaper:"));
                for(boolean CB$633:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return((((HegnaNRK)(CUR$.SL$)).antall_egenskaper$1-(1))); }})
                   )) { if(!CB$633) continue;
                {
                    sysout().outimage();
                    sysout().outtext(((HegnaNRK)(CUR$.SL$)).egenskap.Elt[i-((HegnaNRK)(CUR$.SL$)).egenskap.LB[0]]);
                }
            }
        }
    }
    sysout().outimage();
    if(VALUE$((((HegnaNRK)(CUR$.SL$)).rest$1<=(((float)(10)))))) {
        ((HegnaNRK)(CUR$.SL$)).rest$1=((float)(0));
    }
    sysout().outtext(new TXT$("Antall personer funnet:"));
    sysout().outfix(((HegnaNRK)(CUR$.SL$)).rest$1,0,10);
    sysout().outimage();
    if(VALUE$((((((HegnaNRK)(CUR$.SL$)).antall_egenskaper$1>(1))&((((HegnaNRK)(CUR$.SL$)).divisor.Elt[((HegnaNRK)(CUR$.SL$)).antall_egenskaper$1-((HegnaNRK)(CUR$.SL$)).divisor.LB[0]]==(1))))&((((HegnaNRK)(CUR$.SL$)).rest$1>(((float)(1)))))))) {
        {
            sysout().outtext(new TXT$("Dette er de samme personer som ved forrige s�k."));
            sysout().outimage();
            sysout().outtext(new TXT$("Det er fullt samsvar mellom egenskapene "));
            sysout().outimage();
            sysout().outtext(((HegnaNRK)(CUR$.SL$)).egenskap.Elt[((HegnaNRK)(CUR$.SL$)).antall_egenskaper$1-((HegnaNRK)(CUR$.SL$)).egenskap.LB[0]]);
            sysout().outtext(new TXT$(" og "));
            sysout().outtext(((HegnaNRK)(CUR$.SL$)).egenskap.Elt[(((HegnaNRK)(CUR$.SL$)).antall_egenskaper$1-(1))-((HegnaNRK)(CUR$.SL$)).egenskap.LB[0]]);
            sysout().outimage();
        }
    }
    if(VALUE$((((HegnaNRK)(CUR$.SL$)).rest$1<=(((float)(1)))))) {
        {
            sysout().outtext(new TXT$("Ingen norske personer tilfredstiller alle de oppstilte"));
            sysout().outtext(new TXT$(" krav og egenskaper."));
            sysout().outimage();
            sysout().outtext(new TXT$("Jeg er en datamaskin, jeg kan alt og tilfredstiller alle."));
            sysout().outimage();
            sysout().outtext(new TXT$("Hva kan jeg st� til tjeneste med?"));
            sysout().outimage();
            ((HegnaNRK)(CUR$.SL$)).antall_egenskaper$1=0;
        }
    }
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure finn",1,618,8,621,16,622,18,623,20,624,22,625,24,626,27,628,29,629,32,630,34,632,37,633,41,634,44,635,50,638,52,639,56,640,58,641,60,642,62,643,64,646,67,647,69,648,72,649,75,650,80,652,82,654,85,655,88,656,90,657,92,658,95,659,101,661);
}
