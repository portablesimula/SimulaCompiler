package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$skriv_utbase$SubBlock1262 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    int j=0;
    int k=0;
    int pnr=0;
    public HegnaNRK$PBLK21$skriv_utbase$SubBlock1262(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
    }
    public RTObject$ STM$() {
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outint(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_felt_def$1,3);
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outimage();
        for(boolean CB$1266:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_felt_def$1); }})
           )) { if(!CB$1266) continue;
        {
            ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outint(i,3);
            ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outint(TXT$.length(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnavn_tabell.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnavn_tabell.LB[0]]),4);
            ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outchar(((char)32));
            ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outtext(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnavn_tabell.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnavn_tabell.LB[0]]);
            ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outint(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).felttype_tabell.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).felttype_tabell.LB[0]],3);
            ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outimage();
        }
    }
    ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outint(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_format_def$1,3);
    ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outimage();
    for(boolean CB$1277:new ForList(
        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_format_def$1); }})
       )) { if(!CB$1277) continue;
    {
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outint(i,3);
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outint(TXT$.length(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).formatnavn_tabell.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).formatnavn_tabell.LB[0]]),4);
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outchar(((char)32));
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outtext(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).formatnavn_tabell.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).formatnavn_tabell.LB[0]]);
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outimage();
        {
            ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1283$11=((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).format_peker.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).format_peker.LB[0]];
            if(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1283$11!=null)
            {
                ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outint(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1283$11.p$antall,4);
                for(boolean CB$1286:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1283$11.p$antall); }})
                   )) { if(!CB$1286) continue;
                ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outint(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1283$11.fnr.Elt[j-((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1283$11.fnr.LB[0]],4);
            }
            for(boolean CB$1287:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1283$11.p$antall); }})
               )) { if(!CB$1287) continue;
            ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outint(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1283$11.spos.Elt[j-((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1283$11.spos.LB[0]],4);
        }
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outint(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1283$11.ark_lengde,4);
    }
}
((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outimage();
}
}
((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outint(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_poster$1,5);
((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outimage();
i=0;
pnr=0;
while((pnr<(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_poster$1))) {
{
i=(i+(1));
{
    ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1299$12=((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).post_peker.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).post_peker.LB[0]];
    if(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1299$12!=null)
    {
        pnr=(pnr+(1));
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outint(i,5);
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outint(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1299$12.p$antall,4);
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outimage();
        for(boolean CB$1305:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1299$12.p$antall); }})
           )) { if(!CB$1305) continue;
        {
            ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outint(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1299$12.feltnr.Elt[j-((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1299$12.feltnr.LB[0]],4);
            k=((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).felttype_tabell.Elt[((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1299$12.feltnr.Elt[j-((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1299$12.feltnr.LB[0]]-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).felttype_tabell.LB[0]];
            ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outint(k,3);
            if(VALUE$((k==(1)))) {
                ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outint(((HegnaNRK$PBLK21$heltallverdi)(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1299$12.felt.Elt[j-((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1299$12.felt.LB[0]])).tall$1,8);
            } else
            if(VALUE$((k==(2)))) {
                new HegnaNRK$PBLK21$skriv_utbase$SubBlock1262$CompoundStatement1298$CompoundStatement1301$CompoundStatement1307$SubBlock1315(CUR$).STM$();
            }
            ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$10.outimage();
        }
    }
}
}
}
}
EBLK();
return(null);
}
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","SubBlock SubBlock1262",1,1262,17,1264,19,1265,21,1266,25,1268,28,1269,31,1270,33,1271,35,1272,39,1275,41,1276,43,1277,47,1279,50,1280,52,1281,55,1282,57,1283,61,1285,64,1286,70,1287,76,1288,80,1290,84,1293,86,1294,88,1295,91,1296,93,1298,96,1299,100,1301,103,1302,105,1303,107,1304,109,1305,113,1307,116,1308,118,1309,120,1310,122,1312,125,1313,127,1339,130,1340,140,1344);
}
