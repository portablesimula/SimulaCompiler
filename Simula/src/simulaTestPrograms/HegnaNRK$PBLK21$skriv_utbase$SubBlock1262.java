// JavaLine 1 ==> SourceLine 1262
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:32:37 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$skriv_utbase$SubBlock1262 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=3, firstLine=1262, lastLine=1344, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int i=0;
    int j=0;
    int k=0;
    int pnr=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$skriv_utbase$SubBlock1262(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock1262",1262);
    } // End of Constructor
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock1262",1262);
        // JavaLine 24 ==> SourceLine 1264
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_felt_def,3);
        // JavaLine 26 ==> SourceLine 1265
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outimage();
        // JavaLine 28 ==> SourceLine 1266
        for(boolean CB$1266:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_felt_def); }})
           )) { if(!CB$1266) continue;
        // JavaLine 32 ==> SourceLine 1268
        {
            TRACE_BEGIN_STM$("CompoundStatement1268",1268);
            ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(i,3);
            // JavaLine 36 ==> SourceLine 1269
            ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(TXT$.length(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnavn_tabell.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnavn_tabell.LB[0]]),4);
            ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outchar(((char)32));
            // JavaLine 39 ==> SourceLine 1270
            ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outtext(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnavn_tabell.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnavn_tabell.LB[0]]);
            // JavaLine 41 ==> SourceLine 1271
            ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).felttype_tabell.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).felttype_tabell.LB[0]],3);
            // JavaLine 43 ==> SourceLine 1272
            ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outimage();
            TRACE_END_STM$("CompoundStatement1268",1272);
        }
    }
    // JavaLine 48 ==> SourceLine 1275
    ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_format_def,3);
    // JavaLine 50 ==> SourceLine 1276
    ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outimage();
    // JavaLine 52 ==> SourceLine 1277
    for(boolean CB$1277:new ForList(
        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_format_def); }})
       )) { if(!CB$1277) continue;
    // JavaLine 56 ==> SourceLine 1279
    {
        TRACE_BEGIN_STM$("CompoundStatement1279",1279);
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(i,3);
        // JavaLine 60 ==> SourceLine 1280
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(TXT$.length(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).formatnavn_tabell.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).formatnavn_tabell.LB[0]]),4);
        // JavaLine 62 ==> SourceLine 1281
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outchar(((char)32));
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outtext(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).formatnavn_tabell.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).formatnavn_tabell.LB[0]]);
        // JavaLine 65 ==> SourceLine 1282
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outimage();
        // JavaLine 67 ==> SourceLine 1283
        {
            // BEGIN INSPECTION 
            ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1283$10=((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).format_peker.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).format_peker.LB[0]];
            if(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1283$10!=null) //INSPECT inspect$1283$10
            // JavaLine 72 ==> SourceLine 1285
            {
                TRACE_BEGIN_STM$("CompoundStatement1285",1285);
                ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1283$10.p$antall,4);
                // JavaLine 76 ==> SourceLine 1286
                for(boolean CB$1286:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1283$10.p$antall); }})
                   )) { if(!CB$1286) continue;
                ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1283$10.fnr.Elt[j-((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1283$10.fnr.LB[0]],4);
            }
            // JavaLine 82 ==> SourceLine 1287
            for(boolean CB$1287:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1283$10.p$antall); }})
               )) { if(!CB$1287) continue;
            ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1283$10.spos.Elt[j-((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1283$10.spos.LB[0]],4);
        }
        // JavaLine 88 ==> SourceLine 1288
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1283$10.ark_lengde,4);
        TRACE_END_STM$("CompoundStatement1285",1288);
    }
}
// JavaLine 93 ==> SourceLine 1290
((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outimage();
TRACE_END_STM$("CompoundStatement1279",1290);
}
}
// JavaLine 98 ==> SourceLine 1293
((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_poster,5);
// JavaLine 100 ==> SourceLine 1294
((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outimage();
// JavaLine 102 ==> SourceLine 1295
i=0;
pnr=0;
// JavaLine 105 ==> SourceLine 1296
while((pnr<(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_poster))) {
// JavaLine 107 ==> SourceLine 1298
{
TRACE_BEGIN_STM$("CompoundStatement1298",1298);
i=(i+(1));
// JavaLine 111 ==> SourceLine 1299
{
    // BEGIN INSPECTION 
    ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1299$11=((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).post_peker.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).post_peker.LB[0]];
    if(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1299$11!=null) //INSPECT inspect$1299$11
    // JavaLine 116 ==> SourceLine 1301
    {
        TRACE_BEGIN_STM$("CompoundStatement1301",1301);
        pnr=(pnr+(1));
        // JavaLine 120 ==> SourceLine 1302
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(i,5);
        // JavaLine 122 ==> SourceLine 1303
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1299$11.p$antall,4);
        // JavaLine 124 ==> SourceLine 1304
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outimage();
        // JavaLine 126 ==> SourceLine 1305
        for(boolean CB$1305:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1299$11.p$antall); }})
           )) { if(!CB$1305) continue;
        // JavaLine 130 ==> SourceLine 1307
        {
            TRACE_BEGIN_STM$("CompoundStatement1307",1307);
            ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1299$11.feltnr.Elt[j-((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1299$11.feltnr.LB[0]],4);
            // JavaLine 134 ==> SourceLine 1308
            k=((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).felttype_tabell.Elt[((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1299$11.feltnr.Elt[j-((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1299$11.feltnr.LB[0]]-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).felttype_tabell.LB[0]];
            // JavaLine 136 ==> SourceLine 1309
            ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(k,3);
            // JavaLine 138 ==> SourceLine 1310
            if(VALUE$((k==(1)))) {
                // JavaLine 140 ==> SourceLine 1312
                ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outint(((HegnaNRK$PBLK21$heltallverdi)(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1299$11.felt.Elt[j-((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1299$11.felt.LB[0]])).tall,8);
            } else
            // JavaLine 143 ==> SourceLine 1313
            if(VALUE$((k==(2)))) {
                // JavaLine 145 ==> SourceLine 1339
                new HegnaNRK$PBLK21$skriv_utbase$SubBlock1262$CompoundStatement1298$CompoundStatement1301$CompoundStatement1307$SubBlock1315(CUR$).STM$();
            }
            // JavaLine 148 ==> SourceLine 1340
            ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$)).inspect$1261$9.outimage();
            TRACE_END_STM$("CompoundStatement1307",1340);
        }
    }
    TRACE_END_STM$("CompoundStatement1301",1340);
}
}
TRACE_END_STM$("CompoundStatement1298",1340);
}
}
TRACE_END_STM$("SubBlock1262",1340);
EBLK();
return(null);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","SubBlock SubBlock1262",1,1262,24,1264,26,1265,28,1266,32,1268,36,1269,39,1270,41,1271,43,1272,48,1275,50,1276,52,1277,56,1279,60,1280,62,1281,65,1282,67,1283,72,1285,76,1286,82,1287,88,1288,93,1290,98,1293,100,1294,102,1295,105,1296,107,1298,111,1299,116,1301,120,1302,122,1303,124,1304,126,1305,130,1307,134,1308,136,1309,138,1310,140,1312,143,1313,145,1339,148,1340,162,1344);
}
