package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$hent_innbase$SubBlock1199 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    int j=0;
    int k=0;
    int pnr=0;
    TXT$ t=null;
    char c=0;
    public HegnaNRK$PBLK21$hent_innbase$SubBlock1199(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
    }
    public RTObject$ STM$() {
        ((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_felt_def$1=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
        for(boolean CB$1202:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_felt_def$1); }})
           )) { if(!CB$1202) continue;
        {
            j=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
            t=blanks(((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint());
            c=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inchar();
            while(TXT$.more(t)) {
                TXT$.putchar(t,((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inchar());
            }
            ((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnavn_tabell.Elt[j-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnavn_tabell.LB[0]]=t;
            ((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).felttype_tabell.Elt[j-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).felttype_tabell.LB[0]]=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
        }
    }
    ((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_format_def$1=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
    for(boolean CB$1213:new ForList(
        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_format_def$1); }})
       )) { if(!CB$1213) continue;
    {
        j=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
        t=blanks(((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint());
        c=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inchar();
        while(TXT$.more(t)) {
            TXT$.putchar(t,((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inchar());
        }
        ((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).formatnavn_tabell.Elt[j-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).formatnavn_tabell.LB[0]]=t;
        {
            ((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1220$8=new HegnaNRK$PBLK21$format(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)),((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint()).STM$();
            if(((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1220$8!=null)
            {
                for(boolean CB$1222:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){k=(int)x$; return(x$);};  public Number get(){return((Number)k); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1220$8.p$antall); }})
                   )) { if(!CB$1222) continue;
                ((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1220$8.fnr.Elt[k-((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1220$8.fnr.LB[0]]=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
            }
            for(boolean CB$1223:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){k=(int)x$; return(x$);};  public Number get(){return((Number)k); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1220$8.p$antall); }})
               )) { if(!CB$1223) continue;
            ((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1220$8.spos.Elt[k-((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1220$8.spos.LB[0]]=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
        }
        ((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1220$8.ark_lengde=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
        ((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).format_peker.Elt[j-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).format_peker.LB[0]]=((HegnaNRK$PBLK21$format)((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1220$8);
    }
}
}
}
for(boolean CB$1229:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).max_antall_poster$1); }})
   )) { if(!CB$1229) continue;
((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).post_peker.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).post_peker.LB[0]]=null;
}
((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_poster$1=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
for(boolean CB$1232:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_poster$1); }})
   )) { if(!CB$1232) continue;
{
pnr=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
{
((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9=new HegnaNRK$PBLK21$post(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)),((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint()).STM$();
if(((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9!=null)
for(boolean CB$1236:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9.p$antall); }})
   )) { if(!CB$1236) continue;
{
((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9.feltnr.Elt[j-((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9.feltnr.LB[0]]=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
k=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
if(VALUE$((k==(1)))) {
    {
        ((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9.felt.Elt[j-((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9.felt.LB[0]]=new HegnaNRK$PBLK21$heltallverdi(((HegnaNRK$PBLK21)(CUR$.SL$.SL$))).STM$();
        ((HegnaNRK$PBLK21$heltallverdi)(((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9.felt.Elt[j-((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9.felt.LB[0]])).tall$1=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
    }
} else
if(VALUE$((k==(2)))) {
    {
        ((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9.felt.Elt[j-((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9.felt.LB[0]]=new HegnaNRK$PBLK21$tekstverdi(((HegnaNRK$PBLK21)(CUR$.SL$.SL$))).STM$();
        t=blanks(((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint());
        c=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inchar();
        while(TXT$.more(t)) {
            TXT$.putchar(t,((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inchar());
        }
        ((HegnaNRK$PBLK21$tekstverdi)(((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9.felt.Elt[j-((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9.felt.LB[0]])).tekst$1=t;
    }
}
((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).post_peker.Elt[pnr-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).post_peker.LB[0]]=((HegnaNRK$PBLK21$post)((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9);
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
