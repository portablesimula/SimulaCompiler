// JavaLine 1 ==> SourceLine 1199
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:03:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$hent_innbase$SubBlock1199 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=3, firstLine=1199, lastLine=1257, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int i=0;
    int j=0;
    int k=0;
    int pnr=0;
    TXT$ t=null;
    char c=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$hent_innbase$SubBlock1199(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock1199",1199);
    } // End of Constructor
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock1199",1199);
        // JavaLine 26 ==> SourceLine 1201
        ((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_felt_def=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
        // JavaLine 28 ==> SourceLine 1202
        for(boolean CB$1202:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_felt_def); }})
           )) { if(!CB$1202) continue;
        // JavaLine 32 ==> SourceLine 1204
        {
            TRACE_BEGIN_STM$("CompoundStatement1204",1204);
            j=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
            // JavaLine 36 ==> SourceLine 1205
            t=blanks(((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint());
            // JavaLine 38 ==> SourceLine 1206
            c=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inchar();
            // JavaLine 40 ==> SourceLine 1207
            while(TXT$.more(t)) {
                TXT$.putchar(t,((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inchar());
            }
            // JavaLine 44 ==> SourceLine 1208
            ((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnavn_tabell.Elt[j-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnavn_tabell.LB[0]]=t;
            // JavaLine 46 ==> SourceLine 1209
            ((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).felttype_tabell.Elt[j-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).felttype_tabell.LB[0]]=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
            TRACE_END_STM$("CompoundStatement1204",1209);
        }
    }
    // JavaLine 51 ==> SourceLine 1212
    ((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_format_def=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
    // JavaLine 53 ==> SourceLine 1213
    for(boolean CB$1213:new ForList(
        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_format_def); }})
       )) { if(!CB$1213) continue;
    // JavaLine 57 ==> SourceLine 1215
    {
        TRACE_BEGIN_STM$("CompoundStatement1215",1215);
        j=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
        // JavaLine 61 ==> SourceLine 1216
        t=blanks(((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint());
        // JavaLine 63 ==> SourceLine 1217
        c=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inchar();
        // JavaLine 65 ==> SourceLine 1218
        while(TXT$.more(t)) {
            TXT$.putchar(t,((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inchar());
        }
        // JavaLine 69 ==> SourceLine 1219
        ((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).formatnavn_tabell.Elt[j-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).formatnavn_tabell.LB[0]]=t;
        // JavaLine 71 ==> SourceLine 1220
        {
            // BEGIN INSPECTION 
            ((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1220$8=new HegnaNRK$PBLK21$format(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)),((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint()).STM$();
            if(((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1220$8!=null) //INSPECT inspect$1220$8
            // JavaLine 76 ==> SourceLine 1222
            {
                TRACE_BEGIN_STM$("CompoundStatement1222",1222);
                for(boolean CB$1222:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){k=(int)x$; return(x$);};  public Number get(){return((Number)k); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1220$8.p$antall); }})
                   )) { if(!CB$1222) continue;
                ((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1220$8.fnr.Elt[k-((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1220$8.fnr.LB[0]]=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
            }
            // JavaLine 84 ==> SourceLine 1223
            for(boolean CB$1223:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){k=(int)x$; return(x$);};  public Number get(){return((Number)k); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1220$8.p$antall); }})
               )) { if(!CB$1223) continue;
            ((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1220$8.spos.Elt[k-((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1220$8.spos.LB[0]]=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
        }
        // JavaLine 90 ==> SourceLine 1224
        ((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1220$8.ark_lengde=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
        // JavaLine 92 ==> SourceLine 1225
        ((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).format_peker.Elt[j-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).format_peker.LB[0]]=((HegnaNRK$PBLK21$format)((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1220$8);
        TRACE_END_STM$("CompoundStatement1222",1225);
    }
}
TRACE_END_STM$("CompoundStatement1215",1225);
}
}
// JavaLine 100 ==> SourceLine 1229
for(boolean CB$1229:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).max_antall_poster); }})
   )) { if(!CB$1229) continue;
// JavaLine 104 ==> SourceLine 1230
((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).post_peker.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).post_peker.LB[0]]=null;
}
// JavaLine 107 ==> SourceLine 1231
((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_poster=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
// JavaLine 109 ==> SourceLine 1232
for(boolean CB$1232:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).antall_poster); }})
   )) { if(!CB$1232) continue;
// JavaLine 113 ==> SourceLine 1234
{
TRACE_BEGIN_STM$("CompoundStatement1234",1234);
pnr=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
// JavaLine 117 ==> SourceLine 1235
{
// BEGIN INSPECTION 
((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9=new HegnaNRK$PBLK21$post(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)),((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint()).STM$();
if(((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9!=null) //INSPECT inspect$1235$9
// JavaLine 122 ==> SourceLine 1236
for(boolean CB$1236:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9.p$antall); }})
   )) { if(!CB$1236) continue;
// JavaLine 126 ==> SourceLine 1238
{
TRACE_BEGIN_STM$("CompoundStatement1238",1238);
((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9.feltnr.Elt[j-((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9.feltnr.LB[0]]=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
// JavaLine 130 ==> SourceLine 1239
k=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
// JavaLine 132 ==> SourceLine 1240
if(VALUE$((k==(1)))) {
    // JavaLine 134 ==> SourceLine 1242
    {
        TRACE_BEGIN_STM$("CompoundStatement1242",1242);
        ((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9.felt.Elt[j-((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9.felt.LB[0]]=new HegnaNRK$PBLK21$heltallverdi(((HegnaNRK$PBLK21)(CUR$.SL$.SL$))).STM$();
        // JavaLine 138 ==> SourceLine 1243
        ((HegnaNRK$PBLK21$heltallverdi)(((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9.felt.Elt[j-((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9.felt.LB[0]])).tall=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint();
        TRACE_END_STM$("CompoundStatement1242",1243);
    }
} else
// JavaLine 143 ==> SourceLine 1246
if(VALUE$((k==(2)))) {
    // JavaLine 145 ==> SourceLine 1248
    {
        TRACE_BEGIN_STM$("CompoundStatement1248",1248);
        ((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9.felt.Elt[j-((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9.felt.LB[0]]=new HegnaNRK$PBLK21$tekstverdi(((HegnaNRK$PBLK21)(CUR$.SL$.SL$))).STM$();
        // JavaLine 149 ==> SourceLine 1249
        t=blanks(((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inint());
        // JavaLine 151 ==> SourceLine 1250
        c=((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inchar();
        // JavaLine 153 ==> SourceLine 1251
        while(TXT$.more(t)) {
            TXT$.putchar(t,((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1198$7.inchar());
        }
        // JavaLine 157 ==> SourceLine 1252
        ((HegnaNRK$PBLK21$tekstverdi)(((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9.felt.Elt[j-((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9.felt.LB[0]])).tekst=t;
        TRACE_END_STM$("CompoundStatement1248",1252);
    }
}
// JavaLine 162 ==> SourceLine 1254
((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).post_peker.Elt[pnr-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).post_peker.LB[0]]=((HegnaNRK$PBLK21$post)((HegnaNRK$PBLK21$hent_innbase)(CUR$.SL$)).inspect$1235$9);
TRACE_END_STM$("CompoundStatement1238",1254);
}
}
}
TRACE_END_STM$("CompoundStatement1234",1254);
}
}
TRACE_END_STM$("SubBlock1199",1254);
EBLK();
return(null);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","SubBlock SubBlock1199",1,1199,26,1201,28,1202,32,1204,36,1205,38,1206,40,1207,44,1208,46,1209,51,1212,53,1213,57,1215,61,1216,63,1217,65,1218,69,1219,71,1220,76,1222,84,1223,90,1224,92,1225,100,1229,104,1230,107,1231,109,1232,113,1234,117,1235,122,1236,126,1238,130,1239,132,1240,134,1242,138,1243,143,1246,145,1248,149,1249,151,1250,153,1251,157,1252,162,1254,174,1257);
}
