package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$hent_innbase$SubBlock1199 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    int j=0;
    int k=0;
    int pnr=0;
    TXT$ t=null;
    char c=0;
    public HegnaNRK$hent_innbase$SubBlock1199(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
    }
    public RTObject$ STM$() {
        ((HegnaNRK)(CUR$.SL$.SL$)).antall_felt_def$1=((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inint();
        for(boolean CB$1202:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK)(CUR$.SL$.SL$)).antall_felt_def$1); }})
           )) { if(!CB$1202) continue;
        {
            j=((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inint();
            t=blanks(((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inint());
            c=((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inchar();
            while(TXT$.more(t)) {
                TXT$.putchar(t,((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inchar());
            }
            ((HegnaNRK)(CUR$.SL$.SL$)).feltnavn_tabell.Elt[j-((HegnaNRK)(CUR$.SL$.SL$)).feltnavn_tabell.LB[0]]=t;
            ((HegnaNRK)(CUR$.SL$.SL$)).felttype_tabell.Elt[j-((HegnaNRK)(CUR$.SL$.SL$)).felttype_tabell.LB[0]]=((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inint();
        }
    }
    ((HegnaNRK)(CUR$.SL$.SL$)).antall_format_def$1=((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inint();
    for(boolean CB$1213:new ForList(
        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK)(CUR$.SL$.SL$)).antall_format_def$1); }})
       )) { if(!CB$1213) continue;
    {
        j=((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inint();
        t=blanks(((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inint());
        c=((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inchar();
        while(TXT$.more(t)) {
            TXT$.putchar(t,((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inchar());
        }
        ((HegnaNRK)(CUR$.SL$.SL$)).formatnavn_tabell.Elt[j-((HegnaNRK)(CUR$.SL$.SL$)).formatnavn_tabell.LB[0]]=t;
        {
            ((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1220$7=new HegnaNRK$format(((HegnaNRK)(CUR$.SL$.SL$)),((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inint()).STM$();
            if(((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1220$7!=null)
            {
                for(boolean CB$1222:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){k=(int)x$; return(x$);};  public Number get(){return((Number)k); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1220$7.p$antall); }})
                   )) { if(!CB$1222) continue;
                ((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1220$7.fnr.Elt[k-((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1220$7.fnr.LB[0]]=((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inint();
            }
            for(boolean CB$1223:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){k=(int)x$; return(x$);};  public Number get(){return((Number)k); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1220$7.p$antall); }})
               )) { if(!CB$1223) continue;
            ((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1220$7.spos.Elt[k-((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1220$7.spos.LB[0]]=((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inint();
        }
        ((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1220$7.ark_lengde=((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inint();
        ((HegnaNRK)(CUR$.SL$.SL$)).format_peker.Elt[j-((HegnaNRK)(CUR$.SL$.SL$)).format_peker.LB[0]]=((HegnaNRK$format)((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1220$7);
    }
}
}
}
for(boolean CB$1229:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK)(CUR$.SL$.SL$)).max_antall_poster$1); }})
   )) { if(!CB$1229) continue;
((HegnaNRK)(CUR$.SL$.SL$)).post_peker.Elt[i-((HegnaNRK)(CUR$.SL$.SL$)).post_peker.LB[0]]=null;
}
((HegnaNRK)(CUR$.SL$.SL$)).antall_poster$1=((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inint();
for(boolean CB$1232:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK)(CUR$.SL$.SL$)).antall_poster$1); }})
   )) { if(!CB$1232) continue;
{
pnr=((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inint();
{
((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1235$8=new HegnaNRK$post(((HegnaNRK)(CUR$.SL$.SL$)),((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inint()).STM$();
if(((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1235$8!=null)
for(boolean CB$1236:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1235$8.p$antall); }})
   )) { if(!CB$1236) continue;
{
((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1235$8.feltnr.Elt[j-((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1235$8.feltnr.LB[0]]=((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inint();
k=((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inint();
if(VALUE$((k==(1)))) {
    {
        ((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1235$8.felt.Elt[j-((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1235$8.felt.LB[0]]=new HegnaNRK$heltallverdi(((HegnaNRK)(CUR$.SL$.SL$))).STM$();
        ((HegnaNRK$heltallverdi)(((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1235$8.felt.Elt[j-((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1235$8.felt.LB[0]])).tall$1=((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inint();
    }
} else
if(VALUE$((k==(2)))) {
    {
        ((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1235$8.felt.Elt[j-((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1235$8.felt.LB[0]]=new HegnaNRK$tekstverdi(((HegnaNRK)(CUR$.SL$.SL$))).STM$();
        t=blanks(((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inint());
        c=((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inchar();
        while(TXT$.more(t)) {
            TXT$.putchar(t,((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1198$6.inchar());
        }
        ((HegnaNRK$tekstverdi)(((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1235$8.felt.Elt[j-((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1235$8.felt.LB[0]])).tekst$1=t;
    }
}
((HegnaNRK)(CUR$.SL$.SL$)).post_peker.Elt[pnr-((HegnaNRK)(CUR$.SL$.SL$)).post_peker.LB[0]]=((HegnaNRK$post)((HegnaNRK$hent_innbase)(CUR$.SL$)).inspect$1235$8);
}
}
}
}
}
EBLK();
return(null);
}
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","SubBlock SubBlock1199",1,1199,19,1201,21,1202,25,1204,28,1205,30,1206,32,1207,36,1208,38,1209,42,1212,44,1213,48,1215,51,1216,53,1217,55,1218,59,1219,61,1220,65,1222,72,1223,78,1224,80,1225,86,1229,90,1230,93,1231,95,1232,99,1234,102,1235,106,1236,110,1238,113,1239,115,1240,117,1242,120,1243,124,1246,126,1248,129,1249,131,1250,133,1251,137,1252,141,1254,150,1257);
}
