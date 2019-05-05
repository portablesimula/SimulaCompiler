// JavaLine 1 <== SourceLine 21
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:24:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21 extends Simset$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=1, firstLine=21, lastLine=1529, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    char eot$1=0;
    // JavaLine 13 <== SourceLine 22
    int skjerm_image_lengde$1=0;
    // JavaLine 15 <== SourceLine 23
    int navne_lengde$1=0;
    // JavaLine 17 <== SourceLine 24
    int tekst_lengde$1=0;
    // JavaLine 19 <== SourceLine 27
    InFile$ innbase$1=null;
    // JavaLine 21 <== SourceLine 28
    OutFile$ utbase$1=null;
    // JavaLine 23 <== SourceLine 29
    TXT$ fil_image$1=null;
    // JavaLine 25 <== SourceLine 30
    int fil_image_lengde$1=0;
    // JavaLine 27 <== SourceLine 31
    TXT$ innbase_navn$1=null;
    TXT$ utbase_navn$1=null;
    // JavaLine 30 <== SourceLine 32
    TXT$ default_file_type$1=null;
    // JavaLine 32 <== SourceLine 35
    int max_kommando$1=0;
    int quit_kommando$1=0;
    // JavaLine 35 <== SourceLine 36
    public ARRAY$<TXT$[]>kommando_tabell=null;
    // JavaLine 37 <== SourceLine 39
    int max_type$1=0;
    // JavaLine 39 <== SourceLine 40
    public ARRAY$<char[]>type_tabell=null;
    // JavaLine 41 <== SourceLine 43
    int antall_format_def$1=0;
    int max_format_def$1=0;
    // JavaLine 44 <== SourceLine 44
    int max_format_lengde$1=0;
    // JavaLine 46 <== SourceLine 45
    public ARRAY$<TXT$[]>formatnavn_tabell=null;
    // JavaLine 48 <== SourceLine 46
    public ARRAY$<HegnaNRK$PBLK21$format[]>format_peker=null;
    // JavaLine 50 <== SourceLine 47
    TXT$ formatnavn$1=null;
    // JavaLine 52 <== SourceLine 48
    int formatnr$1=0;
    int format_ark_lengde$1=0;
    // JavaLine 55 <== SourceLine 49
    public ARRAY$<int[]>format_fnr=null;
    public ARRAY$<int[]>format_spos=null;
    HegnaNRK$PBLK21$tabell_mengde mengde$1=null;
    // JavaLine 59 <== SourceLine 227
    int felt_antall$1=0;
    int max_intern_felt$1=0;
    // JavaLine 62 <== SourceLine 228
    public ARRAY$<HegnaNRK$PBLK21$verdi[]>intern_felt=null;
    // JavaLine 64 <== SourceLine 229
    public ARRAY$<int[]>intern_feltnr=null;
    // JavaLine 66 <== SourceLine 232
    int max_felt_def$1=0;
    int antall_felt_def$1=0;
    // JavaLine 69 <== SourceLine 233
    int quit_felt$1=0;
    // JavaLine 71 <== SourceLine 234
    public ARRAY$<int[]>felttype_tabell=null;
    // JavaLine 73 <== SourceLine 235
    public ARRAY$<TXT$[]>feltnavn_tabell=null;
    // JavaLine 75 <== SourceLine 236
    public ARRAY$<HegnaNRK$PBLK21$verdi[]>siste_felt_verdi_lest=null;
    // JavaLine 77 <== SourceLine 239
    int finne_regel_antall$1=0;
    int max_finne_regel$1=0;
    // JavaLine 80 <== SourceLine 240
    public ARRAY$<int[]>finnefeltnr=null;
    // JavaLine 82 <== SourceLine 241
    public ARRAY$<HegnaNRK$PBLK21$verdi[]>finnefeltpeker=null;
    // JavaLine 84 <== SourceLine 244
    TXT$ feltnavn$1=null;
    // JavaLine 86 <== SourceLine 245
    int feltnr$1=0;
    int felttype$1=0;
    // JavaLine 89 <== SourceLine 246
    HegnaNRK$PBLK21$verdi feltverdi$1=null;
    // JavaLine 91 <== SourceLine 249
    int aktuell$1=0;
    // JavaLine 93 <== SourceLine 255
    int max_antall_poster$1=0;
    int antall_poster$1=0;
    // JavaLine 96 <== SourceLine 256
    public ARRAY$<HegnaNRK$PBLK21$post[]>post_peker=null;
    // JavaLine 98 <== SourceLine 613
    float rest$1=0.0f;
    // JavaLine 100 <== SourceLine 614
    int antall_egenskaper$1=0;
    // JavaLine 102 <== SourceLine 615
    public ARRAY$<int[]>divisor=null;
    // JavaLine 104 <== SourceLine 616
    public ARRAY$<TXT$[]>egenskap=null;
    // Normal Constructor
    public HegnaNRK$PBLK21(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BPRG("HegnaNRK$PBLK21");
        // Declaration Code
        TRACE_BEGIN_DCL$("HegnaNRK$PBLK21",1447);
        // JavaLine 113 <== SourceLine 36
        int[] kommando_tabell$LB=new int[1]; int[] kommando_tabell$UB=new int[1];
        kommando_tabell$LB[0]=1; kommando_tabell$UB[0]=24;
        BOUND_CHECK$(kommando_tabell$LB[0],kommando_tabell$UB[0]);
        kommando_tabell=new ARRAY$<TXT$[]>(new TXT$[kommando_tabell$UB[0]-kommando_tabell$LB[0]+1],kommando_tabell$LB,kommando_tabell$UB);
        // JavaLine 118 <== SourceLine 40
        int[] type_tabell$LB=new int[1]; int[] type_tabell$UB=new int[1];
        type_tabell$LB[0]=1; type_tabell$UB[0]=8;
        BOUND_CHECK$(type_tabell$LB[0],type_tabell$UB[0]);
        type_tabell=new ARRAY$<char[]>(new char[type_tabell$UB[0]-type_tabell$LB[0]+1],type_tabell$LB,type_tabell$UB);
        // JavaLine 123 <== SourceLine 45
        int[] formatnavn_tabell$LB=new int[1]; int[] formatnavn_tabell$UB=new int[1];
        formatnavn_tabell$LB[0]=1; formatnavn_tabell$UB[0]=8;
        BOUND_CHECK$(formatnavn_tabell$LB[0],formatnavn_tabell$UB[0]);
        formatnavn_tabell=new ARRAY$<TXT$[]>(new TXT$[formatnavn_tabell$UB[0]-formatnavn_tabell$LB[0]+1],formatnavn_tabell$LB,formatnavn_tabell$UB);
        // JavaLine 128 <== SourceLine 46
        int[] format_peker$LB=new int[1]; int[] format_peker$UB=new int[1];
        format_peker$LB[0]=1; format_peker$UB[0]=8;
        BOUND_CHECK$(format_peker$LB[0],format_peker$UB[0]);
        format_peker=new ARRAY$<HegnaNRK$PBLK21$format[]>(new HegnaNRK$PBLK21$format[format_peker$UB[0]-format_peker$LB[0]+1],format_peker$LB,format_peker$UB);
        // JavaLine 133 <== SourceLine 49
        int[] format_fnr$LB=new int[1]; int[] format_fnr$UB=new int[1];
        format_fnr$LB[0]=1; format_fnr$UB[0]=16;
        BOUND_CHECK$(format_fnr$LB[0],format_fnr$UB[0]);
        format_fnr=new ARRAY$<int[]>(new int[format_fnr$UB[0]-format_fnr$LB[0]+1],format_fnr$LB,format_fnr$UB);
        int[] format_spos$LB=new int[1]; int[] format_spos$UB=new int[1];
        format_spos$LB[0]=1; format_spos$UB[0]=16;
        BOUND_CHECK$(format_spos$LB[0],format_spos$UB[0]);
        format_spos=new ARRAY$<int[]>(new int[format_spos$UB[0]-format_spos$LB[0]+1],format_spos$LB,format_spos$UB);
        // JavaLine 142 <== SourceLine 228
        int[] intern_felt$LB=new int[1]; int[] intern_felt$UB=new int[1];
        intern_felt$LB[0]=1; intern_felt$UB[0]=16;
        BOUND_CHECK$(intern_felt$LB[0],intern_felt$UB[0]);
        intern_felt=new ARRAY$<HegnaNRK$PBLK21$verdi[]>(new HegnaNRK$PBLK21$verdi[intern_felt$UB[0]-intern_felt$LB[0]+1],intern_felt$LB,intern_felt$UB);
        // JavaLine 147 <== SourceLine 229
        int[] intern_feltnr$LB=new int[1]; int[] intern_feltnr$UB=new int[1];
        intern_feltnr$LB[0]=1; intern_feltnr$UB[0]=16;
        BOUND_CHECK$(intern_feltnr$LB[0],intern_feltnr$UB[0]);
        intern_feltnr=new ARRAY$<int[]>(new int[intern_feltnr$UB[0]-intern_feltnr$LB[0]+1],intern_feltnr$LB,intern_feltnr$UB);
        // JavaLine 152 <== SourceLine 234
        int[] felttype_tabell$LB=new int[1]; int[] felttype_tabell$UB=new int[1];
        felttype_tabell$LB[0]=1; felttype_tabell$UB[0]=16+(1);
        BOUND_CHECK$(felttype_tabell$LB[0],felttype_tabell$UB[0]);
        felttype_tabell=new ARRAY$<int[]>(new int[felttype_tabell$UB[0]-felttype_tabell$LB[0]+1],felttype_tabell$LB,felttype_tabell$UB);
        // JavaLine 157 <== SourceLine 235
        int[] feltnavn_tabell$LB=new int[1]; int[] feltnavn_tabell$UB=new int[1];
        feltnavn_tabell$LB[0]=1; feltnavn_tabell$UB[0]=16+(1);
        BOUND_CHECK$(feltnavn_tabell$LB[0],feltnavn_tabell$UB[0]);
        feltnavn_tabell=new ARRAY$<TXT$[]>(new TXT$[feltnavn_tabell$UB[0]-feltnavn_tabell$LB[0]+1],feltnavn_tabell$LB,feltnavn_tabell$UB);
        // JavaLine 162 <== SourceLine 236
        int[] siste_felt_verdi_lest$LB=new int[1]; int[] siste_felt_verdi_lest$UB=new int[1];
        siste_felt_verdi_lest$LB[0]=1; siste_felt_verdi_lest$UB[0]=16+(1);
        BOUND_CHECK$(siste_felt_verdi_lest$LB[0],siste_felt_verdi_lest$UB[0]);
        siste_felt_verdi_lest=new ARRAY$<HegnaNRK$PBLK21$verdi[]>(new HegnaNRK$PBLK21$verdi[siste_felt_verdi_lest$UB[0]-siste_felt_verdi_lest$LB[0]+1],siste_felt_verdi_lest$LB,siste_felt_verdi_lest$UB);
        // JavaLine 167 <== SourceLine 240
        int[] finnefeltnr$LB=new int[1]; int[] finnefeltnr$UB=new int[1];
        finnefeltnr$LB[0]=1; finnefeltnr$UB[0]=8;
        BOUND_CHECK$(finnefeltnr$LB[0],finnefeltnr$UB[0]);
        finnefeltnr=new ARRAY$<int[]>(new int[finnefeltnr$UB[0]-finnefeltnr$LB[0]+1],finnefeltnr$LB,finnefeltnr$UB);
        // JavaLine 172 <== SourceLine 241
        int[] finnefeltpeker$LB=new int[1]; int[] finnefeltpeker$UB=new int[1];
        finnefeltpeker$LB[0]=1; finnefeltpeker$UB[0]=8;
        BOUND_CHECK$(finnefeltpeker$LB[0],finnefeltpeker$UB[0]);
        finnefeltpeker=new ARRAY$<HegnaNRK$PBLK21$verdi[]>(new HegnaNRK$PBLK21$verdi[finnefeltpeker$UB[0]-finnefeltpeker$LB[0]+1],finnefeltpeker$LB,finnefeltpeker$UB);
        // JavaLine 177 <== SourceLine 256
        int[] post_peker$LB=new int[1]; int[] post_peker$UB=new int[1];
        post_peker$LB[0]=1; post_peker$UB[0]=256;
        BOUND_CHECK$(post_peker$LB[0],post_peker$UB[0]);
        post_peker=new ARRAY$<HegnaNRK$PBLK21$post[]>(new HegnaNRK$PBLK21$post[post_peker$UB[0]-post_peker$LB[0]+1],post_peker$LB,post_peker$UB);
        // JavaLine 182 <== SourceLine 615
        int[] divisor$LB=new int[1]; int[] divisor$UB=new int[1];
        divisor$LB[0]=1; divisor$UB[0]=20;
        BOUND_CHECK$(divisor$LB[0],divisor$UB[0]);
        divisor=new ARRAY$<int[]>(new int[divisor$UB[0]-divisor$LB[0]+1],divisor$LB,divisor$UB);
        // JavaLine 187 <== SourceLine 616
        int[] egenskap$LB=new int[1]; int[] egenskap$UB=new int[1];
        egenskap$LB[0]=1; egenskap$UB[0]=20;
        BOUND_CHECK$(egenskap$LB[0],egenskap$UB[0]);
        egenskap=new ARRAY$<TXT$[]>(new TXT$[egenskap$UB[0]-egenskap$LB[0]+1],egenskap$LB,egenskap$UB);
    }
    // Class Statements
    public HegnaNRK$PBLK21 STM$() {
        TRACE_BEGIN_STM$("HegnaNRK$PBLK21",616);
        // Class Simset: Code before inner
        // Class HegnaNRK$PBLK21: Code before inner
        // JavaLine 198 <== SourceLine 1454
        kommando_tabell.Elt[1-kommando_tabell.LB[0]]=new TXT$("KONTAKT");
        // JavaLine 200 <== SourceLine 1455
        kommando_tabell.Elt[2-kommando_tabell.LB[0]]=new TXT$("SKRIV");
        // JavaLine 202 <== SourceLine 1456
        kommando_tabell.Elt[3-kommando_tabell.LB[0]]=new TXT$("S�K");
        // JavaLine 204 <== SourceLine 1457
        kommando_tabell.Elt[4-kommando_tabell.LB[0]]=new TXT$("ENDRE");
        // JavaLine 206 <== SourceLine 1458
        kommando_tabell.Elt[5-kommando_tabell.LB[0]]=new TXT$("TRYKK");
        // JavaLine 208 <== SourceLine 1459
        kommando_tabell.Elt[6-kommando_tabell.LB[0]]=new TXT$("FJERN");
        // JavaLine 210 <== SourceLine 1460
        kommando_tabell.Elt[7-kommando_tabell.LB[0]]=new TXT$("HJELP");
        // JavaLine 212 <== SourceLine 1461
        kommando_tabell.Elt[8-kommando_tabell.LB[0]]=new TXT$("LIST");
        // JavaLine 214 <== SourceLine 1462
        kommando_tabell.Elt[9-kommando_tabell.LB[0]]=new TXT$("LISTDEF");
        // JavaLine 216 <== SourceLine 1463
        kommando_tabell.Elt[10-kommando_tabell.LB[0]]=new TXT$("NESTE");
        // JavaLine 218 <== SourceLine 1464
        kommando_tabell.Elt[11-kommando_tabell.LB[0]]=new TXT$("HENT");
        // JavaLine 220 <== SourceLine 1465
        kommando_tabell.Elt[12-kommando_tabell.LB[0]]=new TXT$("DATAREG");
        // JavaLine 222 <== SourceLine 1466
        kommando_tabell.Elt[13-kommando_tabell.LB[0]]=new TXT$("DEFFORMAT");
        // JavaLine 224 <== SourceLine 1467
        kommando_tabell.Elt[14-kommando_tabell.LB[0]]=new TXT$("RAPPORTER");
        // JavaLine 226 <== SourceLine 1468
        kommando_tabell.Elt[15-kommando_tabell.LB[0]]=new TXT$("TAINN");
        // JavaLine 228 <== SourceLine 1469
        kommando_tabell.Elt[16-kommando_tabell.LB[0]]=new TXT$("LEGGUT");
        // JavaLine 230 <== SourceLine 1470
        kommando_tabell.Elt[17-kommando_tabell.LB[0]]=new TXT$("FINNMENGDE");
        // JavaLine 232 <== SourceLine 1471
        kommando_tabell.Elt[18-kommando_tabell.LB[0]]=new TXT$("SORTERMENGDE");
        // JavaLine 234 <== SourceLine 1472
        kommando_tabell.Elt[19-kommando_tabell.LB[0]]=new TXT$("RAPPORTERMENGDE");
        // JavaLine 236 <== SourceLine 1473
        max_kommando$1=20;
        // JavaLine 238 <== SourceLine 1474
        kommando_tabell.Elt[max_kommando$1-kommando_tabell.LB[0]]=new TXT$("SLUTT");
        // JavaLine 240 <== SourceLine 1475
        quit_kommando$1=max_kommando$1;
        // JavaLine 242 <== SourceLine 1478
        type_tabell.Elt[1-type_tabell.LB[0]]='H';
        // JavaLine 244 <== SourceLine 1479
        type_tabell.Elt[2-type_tabell.LB[0]]='T';
        // JavaLine 246 <== SourceLine 1480
        max_type$1=3;
        // JavaLine 248 <== SourceLine 1481
        type_tabell.Elt[max_type$1-type_tabell.LB[0]]='.';
        // JavaLine 250 <== SourceLine 1484
        max_felt_def$1=(16+(1));
        // JavaLine 252 <== SourceLine 1485
        antall_felt_def$1=1;
        // JavaLine 254 <== SourceLine 1486
        feltnavn_tabell.Elt[antall_felt_def$1-feltnavn_tabell.LB[0]]=new TXT$(".");
        // JavaLine 256 <== SourceLine 1487
        felttype_tabell.Elt[antall_felt_def$1-felttype_tabell.LB[0]]=max_type$1;
        // JavaLine 258 <== SourceLine 1488
        quit_felt$1=antall_felt_def$1;
        // JavaLine 260 <== SourceLine 1491
        felt_antall$1=0;
        // JavaLine 262 <== SourceLine 1492
        max_intern_felt$1=16;
        // JavaLine 264 <== SourceLine 1495
        max_finne_regel$1=8;
        // JavaLine 266 <== SourceLine 1496
        finne_regel_antall$1=0;
        // JavaLine 268 <== SourceLine 1499
        antall_poster$1=0;
        // JavaLine 270 <== SourceLine 1500
        max_antall_poster$1=256;
        // JavaLine 272 <== SourceLine 1503
        max_format_def$1=8;
        // JavaLine 274 <== SourceLine 1504
        max_format_lengde$1=16;
        // JavaLine 276 <== SourceLine 1505
        antall_format_def$1=0;
        // JavaLine 278 <== SourceLine 1508
        aktuell$1=0;
        // JavaLine 280 <== SourceLine 1509
        eot$1=((char)39);
        // JavaLine 282 <== SourceLine 1510
        skjerm_image_lengde$1=78;
        // JavaLine 284 <== SourceLine 1511
        navne_lengde$1=30;
        // JavaLine 286 <== SourceLine 1512
        tekst_lengde$1=180;
        // JavaLine 288 <== SourceLine 1513
        fil_image_lengde$1=80;
        // JavaLine 290 <== SourceLine 1514
        default_file_type$1=new TXT$(":SYMB");
        // JavaLine 292 <== SourceLine 1515
        mengde$1=null;
        // JavaLine 294 <== SourceLine 1516
        divisor.Elt[1-divisor.LB[0]]=1;
        // JavaLine 296 <== SourceLine 1517
        divisor.Elt[2-divisor.LB[0]]=17;
        // JavaLine 298 <== SourceLine 1518
        divisor.Elt[3-divisor.LB[0]]=2;
        // JavaLine 300 <== SourceLine 1519
        divisor.Elt[4-divisor.LB[0]]=3;
        // JavaLine 302 <== SourceLine 1520
        divisor.Elt[5-divisor.LB[0]]=11;
        // JavaLine 304 <== SourceLine 1521
        divisor.Elt[6-divisor.LB[0]]=1;
        // JavaLine 306 <== SourceLine 1522
        divisor.Elt[7-divisor.LB[0]]=3;
        // JavaLine 308 <== SourceLine 1523
        divisor.Elt[8-divisor.LB[0]]=4;
        // JavaLine 310 <== SourceLine 1524
        divisor.Elt[9-divisor.LB[0]]=2;
        // JavaLine 312 <== SourceLine 1525
        divisor.Elt[10-divisor.LB[0]]=10;
        // JavaLine 314 <== SourceLine 1526
        divisor.Elt[11-divisor.LB[0]]=1;
        // JavaLine 316 <== SourceLine 1528
        new HegnaNRK$PBLK21$main(((HegnaNRK$PBLK21)CUR$));
        TRACE_END_STM$("HegnaNRK$PBLK21",1528);
        EBLK();
        return(this);
    } // End of Class Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new HegnaNRK$PBLK21(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","PrefixedBlock HegnaNRK$PBLK21",1,21,13,22,15,23,17,24,19,27,21,28,23,29,25,30,27,31,30,32,32,35,35,36,37,39,39,40,41,43,44,44,46,45,48,46,50,47,52,48,55,49,59,227,62,228,64,229,66,232,69,233,71,234,73,235,75,236,77,239,80,240,82,241,84,244,86,245,89,246,91,249,93,255,96,256,98,613,100,614,102,615,104,616,113,36,118,40,123,45,128,46,133,49,142,228,147,229,152,234,157,235,162,236,167,240,172,241,177,256,182,615,187,616,198,1454,200,1455,202,1456,204,1457,206,1458,208,1459,210,1460,212,1461,214,1462,216,1463,218,1464,220,1465,222,1466,224,1467,226,1468,228,1469,230,1470,232,1471,234,1472,236,1473,238,1474,240,1475,242,1478,244,1479,246,1480,248,1481,250,1484,252,1485,254,1486,256,1487,258,1488,260,1491,262,1492,264,1495,266,1496,268,1499,270,1500,272,1503,274,1504,276,1505,278,1508,280,1509,282,1510,284,1511,286,1512,288,1513,290,1514,292,1515,294,1516,296,1517,298,1518,300,1519,302,1520,304,1521,306,1522,308,1523,310,1524,312,1525,314,1526,316,1528,327,1529);
} // End of Class
