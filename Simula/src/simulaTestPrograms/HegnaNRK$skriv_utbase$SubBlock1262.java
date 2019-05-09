package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$skriv_utbase$SubBlock1262 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    int j=0;
    int k=0;
    int pnr=0;
    public HegnaNRK$skriv_utbase$SubBlock1262(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
    }
    public RTObject$ STM$() {
        ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(((HegnaNRK)(CUR$.SL$.SL$)).antall_felt_def$1,3);
        ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outimage();
        for(boolean CB$1266:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK)(CUR$.SL$.SL$)).antall_felt_def$1); }})
           )) { if(!CB$1266) continue;
        {
            ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(i,3);
            ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(TXT$.length(((HegnaNRK)(CUR$.SL$.SL$)).feltnavn_tabell.Elt[i-((HegnaNRK)(CUR$.SL$.SL$)).feltnavn_tabell.LB[0]]),4);
            ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outchar(((char)32));
            ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outtext(((HegnaNRK)(CUR$.SL$.SL$)).feltnavn_tabell.Elt[i-((HegnaNRK)(CUR$.SL$.SL$)).feltnavn_tabell.LB[0]]);
            ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(((HegnaNRK)(CUR$.SL$.SL$)).felttype_tabell.Elt[i-((HegnaNRK)(CUR$.SL$.SL$)).felttype_tabell.LB[0]],3);
            ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outimage();
        }
    }
    ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(((HegnaNRK)(CUR$.SL$.SL$)).antall_format_def$1,3);
    ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outimage();
    for(boolean CB$1277:new ForList(
        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK)(CUR$.SL$.SL$)).antall_format_def$1); }})
       )) { if(!CB$1277) continue;
    {
        ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(i,3);
        ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(TXT$.length(((HegnaNRK)(CUR$.SL$.SL$)).formatnavn_tabell.Elt[i-((HegnaNRK)(CUR$.SL$.SL$)).formatnavn_tabell.LB[0]]),4);
        ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outchar(((char)32));
        ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outtext(((HegnaNRK)(CUR$.SL$.SL$)).formatnavn_tabell.Elt[i-((HegnaNRK)(CUR$.SL$.SL$)).formatnavn_tabell.LB[0]]);
        ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outimage();
        {
            ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1283$10=((HegnaNRK)(CUR$.SL$.SL$)).format_peker.Elt[i-((HegnaNRK)(CUR$.SL$.SL$)).format_peker.LB[0]];
            if(((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1283$10!=null)
            {
                ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1283$10.p$antall,4);
                for(boolean CB$1286:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1283$10.p$antall); }})
                   )) { if(!CB$1286) continue;
                ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1283$10.fnr.Elt[j-((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1283$10.fnr.LB[0]],4);
            }
            for(boolean CB$1287:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1283$10.p$antall); }})
               )) { if(!CB$1287) continue;
            ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1283$10.spos.Elt[j-((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1283$10.spos.LB[0]],4);
        }
        ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1283$10.ark_lengde,4);
    }
}
((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outimage();
}
}
((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(((HegnaNRK)(CUR$.SL$.SL$)).antall_poster$1,5);
((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outimage();
i=0;
pnr=0;
while((pnr<(((HegnaNRK)(CUR$.SL$.SL$)).antall_poster$1))) {
{
i=(i+(1));
{
    ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1299$11=((HegnaNRK)(CUR$.SL$.SL$)).post_peker.Elt[i-((HegnaNRK)(CUR$.SL$.SL$)).post_peker.LB[0]];
    if(((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1299$11!=null)
    {
        pnr=(pnr+(1));
        ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(i,5);
        ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1299$11.p$antall,4);
        ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outimage();
        for(boolean CB$1305:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1299$11.p$antall); }})
           )) { if(!CB$1305) continue;
        {
            ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1299$11.feltnr.Elt[j-((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1299$11.feltnr.LB[0]],4);
            k=((HegnaNRK)(CUR$.SL$.SL$)).felttype_tabell.Elt[((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1299$11.feltnr.Elt[j-((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1299$11.feltnr.LB[0]]-((HegnaNRK)(CUR$.SL$.SL$)).felttype_tabell.LB[0]];
            ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(k,3);
            if(VALUE$((k==(1)))) {
                ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(((HegnaNRK$heltallverdi)(((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1299$11.felt.Elt[j-((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1299$11.felt.LB[0]])).tall$1,8);
            } else
            if(VALUE$((k==(2)))) {
                new HegnaNRK$skriv_utbase$SubBlock1262$CompoundStatement1298$CompoundStatement1301$CompoundStatement1307$SubBlock1315(CUR$).STM$();
            }
            ((HegnaNRK$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outimage();
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
