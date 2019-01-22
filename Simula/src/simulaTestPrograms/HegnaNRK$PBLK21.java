// JavaLine 1 ==> SourceLine 21
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Jan 22 18:13:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21 extends Simset$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=1, firstLine=21, lastLine=1529, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    char eot=0;
    // JavaLine 13 ==> SourceLine 22
    int skjerm_image_lengde=0;
    // JavaLine 15 ==> SourceLine 23
    int navne_lengde=0;
    // JavaLine 17 ==> SourceLine 24
    int tekst_lengde=0;
    // JavaLine 19 ==> SourceLine 27
    InFile$ innbase=null;
    // JavaLine 21 ==> SourceLine 28
    OutFile$ utbase=null;
    // JavaLine 23 ==> SourceLine 29
    TXT$ fil_image=null;
    // JavaLine 25 ==> SourceLine 30
    int fil_image_lengde=0;
    // JavaLine 27 ==> SourceLine 31
    TXT$ innbase_navn=null;
    TXT$ utbase_navn=null;
    // JavaLine 30 ==> SourceLine 32
    TXT$ default_file_type=null;
    // JavaLine 32 ==> SourceLine 35
    int max_kommando=0;
    int quit_kommando=0;
    // JavaLine 35 ==> SourceLine 36
    public ARRAY$<TXT$[]>kommando_tabell=null;
    // JavaLine 37 ==> SourceLine 39
    int max_type=0;
    // JavaLine 39 ==> SourceLine 40
    public ARRAY$<char[]>type_tabell=null;
    // JavaLine 41 ==> SourceLine 43
    int antall_format_def=0;
    int max_format_def=0;
    // JavaLine 44 ==> SourceLine 44
    int max_format_lengde=0;
    // JavaLine 46 ==> SourceLine 45
    public ARRAY$<TXT$[]>formatnavn_tabell=null;
    // JavaLine 48 ==> SourceLine 46
    public ARRAY$<HegnaNRK$PBLK21$format[]>format_peker=null;
    // JavaLine 50 ==> SourceLine 47
    TXT$ formatnavn=null;
    // JavaLine 52 ==> SourceLine 48
    int formatnr=0;
    int format_ark_lengde=0;
    // JavaLine 55 ==> SourceLine 49
    public ARRAY$<int[]>format_fnr=null;
    public ARRAY$<int[]>format_spos=null;
    HegnaNRK$PBLK21$tabell_mengde mengde=null;
    // JavaLine 59 ==> SourceLine 227
    int felt_antall=0;
    int max_intern_felt=0;
    // JavaLine 62 ==> SourceLine 228
    public ARRAY$<HegnaNRK$PBLK21$verdi[]>intern_felt=null;
    // JavaLine 64 ==> SourceLine 229
    public ARRAY$<int[]>intern_feltnr=null;
    // JavaLine 66 ==> SourceLine 232
    int max_felt_def=0;
    int antall_felt_def=0;
    // JavaLine 69 ==> SourceLine 233
    int quit_felt=0;
    // JavaLine 71 ==> SourceLine 234
    public ARRAY$<int[]>felttype_tabell=null;
    // JavaLine 73 ==> SourceLine 235
    public ARRAY$<TXT$[]>feltnavn_tabell=null;
    // JavaLine 75 ==> SourceLine 236
    public ARRAY$<HegnaNRK$PBLK21$verdi[]>siste_felt_verdi_lest=null;
    // JavaLine 77 ==> SourceLine 239
    int finne_regel_antall=0;
    int max_finne_regel=0;
    // JavaLine 80 ==> SourceLine 240
    public ARRAY$<int[]>finnefeltnr=null;
    // JavaLine 82 ==> SourceLine 241
    public ARRAY$<HegnaNRK$PBLK21$verdi[]>finnefeltpeker=null;
    // JavaLine 84 ==> SourceLine 244
    TXT$ feltnavn=null;
    // JavaLine 86 ==> SourceLine 245
    int feltnr=0;
    int felttype=0;
    // JavaLine 89 ==> SourceLine 246
    HegnaNRK$PBLK21$verdi feltverdi=null;
    // JavaLine 91 ==> SourceLine 249
    int aktuell=0;
    // JavaLine 93 ==> SourceLine 255
    int max_antall_poster=0;
    int antall_poster=0;
    // JavaLine 96 ==> SourceLine 256
    public ARRAY$<HegnaNRK$PBLK21$post[]>post_peker=null;
    // JavaLine 98 ==> SourceLine 613
    float rest=0.0f;
    // JavaLine 100 ==> SourceLine 614
    int antall_egenskaper=0;
    // JavaLine 102 ==> SourceLine 615
    public ARRAY$<int[]>divisor=null;
    // JavaLine 104 ==> SourceLine 616
    public ARRAY$<TXT$[]>egenskap=null;
    // Normal Constructor
    public HegnaNRK$PBLK21(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BPRG("HegnaNRK$PBLK21");
        // Declaration Code
        TRACE_BEGIN_DCL$("HegnaNRK$PBLK21",1447);
        // JavaLine 113 ==> SourceLine 36
        int[] kommando_tabell$LB=new int[1]; int[] kommando_tabell$UB=new int[1];
        kommando_tabell$LB[0]=1; kommando_tabell$UB[0]=24;
        BOUND_CHECK$(kommando_tabell$LB[0],kommando_tabell$UB[0]);
        kommando_tabell=new ARRAY$<TXT$[]>(new TXT$[kommando_tabell$UB[0]-kommando_tabell$LB[0]+1],kommando_tabell$LB,kommando_tabell$UB);
        // JavaLine 118 ==> SourceLine 40
        int[] type_tabell$LB=new int[1]; int[] type_tabell$UB=new int[1];
        type_tabell$LB[0]=1; type_tabell$UB[0]=8;
        BOUND_CHECK$(type_tabell$LB[0],type_tabell$UB[0]);
        type_tabell=new ARRAY$<char[]>(new char[type_tabell$UB[0]-type_tabell$LB[0]+1],type_tabell$LB,type_tabell$UB);
        // JavaLine 123 ==> SourceLine 45
        int[] formatnavn_tabell$LB=new int[1]; int[] formatnavn_tabell$UB=new int[1];
        formatnavn_tabell$LB[0]=1; formatnavn_tabell$UB[0]=8;
        BOUND_CHECK$(formatnavn_tabell$LB[0],formatnavn_tabell$UB[0]);
        formatnavn_tabell=new ARRAY$<TXT$[]>(new TXT$[formatnavn_tabell$UB[0]-formatnavn_tabell$LB[0]+1],formatnavn_tabell$LB,formatnavn_tabell$UB);
        // JavaLine 128 ==> SourceLine 46
        int[] format_peker$LB=new int[1]; int[] format_peker$UB=new int[1];
        format_peker$LB[0]=1; format_peker$UB[0]=8;
        BOUND_CHECK$(format_peker$LB[0],format_peker$UB[0]);
        format_peker=new ARRAY$<HegnaNRK$PBLK21$format[]>(new HegnaNRK$PBLK21$format[format_peker$UB[0]-format_peker$LB[0]+1],format_peker$LB,format_peker$UB);
        // JavaLine 133 ==> SourceLine 49
        int[] format_fnr$LB=new int[1]; int[] format_fnr$UB=new int[1];
        format_fnr$LB[0]=1; format_fnr$UB[0]=16;
        BOUND_CHECK$(format_fnr$LB[0],format_fnr$UB[0]);
        format_fnr=new ARRAY$<int[]>(new int[format_fnr$UB[0]-format_fnr$LB[0]+1],format_fnr$LB,format_fnr$UB);
        int[] format_spos$LB=new int[1]; int[] format_spos$UB=new int[1];
        format_spos$LB[0]=1; format_spos$UB[0]=16;
        BOUND_CHECK$(format_spos$LB[0],format_spos$UB[0]);
        format_spos=new ARRAY$<int[]>(new int[format_spos$UB[0]-format_spos$LB[0]+1],format_spos$LB,format_spos$UB);
        // JavaLine 142 ==> SourceLine 228
        int[] intern_felt$LB=new int[1]; int[] intern_felt$UB=new int[1];
        intern_felt$LB[0]=1; intern_felt$UB[0]=16;
        BOUND_CHECK$(intern_felt$LB[0],intern_felt$UB[0]);
        intern_felt=new ARRAY$<HegnaNRK$PBLK21$verdi[]>(new HegnaNRK$PBLK21$verdi[intern_felt$UB[0]-intern_felt$LB[0]+1],intern_felt$LB,intern_felt$UB);
        // JavaLine 147 ==> SourceLine 229
        int[] intern_feltnr$LB=new int[1]; int[] intern_feltnr$UB=new int[1];
        intern_feltnr$LB[0]=1; intern_feltnr$UB[0]=16;
        BOUND_CHECK$(intern_feltnr$LB[0],intern_feltnr$UB[0]);
        intern_feltnr=new ARRAY$<int[]>(new int[intern_feltnr$UB[0]-intern_feltnr$LB[0]+1],intern_feltnr$LB,intern_feltnr$UB);
        // JavaLine 152 ==> SourceLine 234
        int[] felttype_tabell$LB=new int[1]; int[] felttype_tabell$UB=new int[1];
        felttype_tabell$LB[0]=1; felttype_tabell$UB[0]=17;
        BOUND_CHECK$(felttype_tabell$LB[0],felttype_tabell$UB[0]);
        felttype_tabell=new ARRAY$<int[]>(new int[felttype_tabell$UB[0]-felttype_tabell$LB[0]+1],felttype_tabell$LB,felttype_tabell$UB);
        // JavaLine 157 ==> SourceLine 235
        int[] feltnavn_tabell$LB=new int[1]; int[] feltnavn_tabell$UB=new int[1];
        feltnavn_tabell$LB[0]=1; feltnavn_tabell$UB[0]=17;
        BOUND_CHECK$(feltnavn_tabell$LB[0],feltnavn_tabell$UB[0]);
        feltnavn_tabell=new ARRAY$<TXT$[]>(new TXT$[feltnavn_tabell$UB[0]-feltnavn_tabell$LB[0]+1],feltnavn_tabell$LB,feltnavn_tabell$UB);
        // JavaLine 162 ==> SourceLine 236
        int[] siste_felt_verdi_lest$LB=new int[1]; int[] siste_felt_verdi_lest$UB=new int[1];
        siste_felt_verdi_lest$LB[0]=1; siste_felt_verdi_lest$UB[0]=17;
        BOUND_CHECK$(siste_felt_verdi_lest$LB[0],siste_felt_verdi_lest$UB[0]);
        siste_felt_verdi_lest=new ARRAY$<HegnaNRK$PBLK21$verdi[]>(new HegnaNRK$PBLK21$verdi[siste_felt_verdi_lest$UB[0]-siste_felt_verdi_lest$LB[0]+1],siste_felt_verdi_lest$LB,siste_felt_verdi_lest$UB);
        // JavaLine 167 ==> SourceLine 240
        int[] finnefeltnr$LB=new int[1]; int[] finnefeltnr$UB=new int[1];
        finnefeltnr$LB[0]=1; finnefeltnr$UB[0]=8;
        BOUND_CHECK$(finnefeltnr$LB[0],finnefeltnr$UB[0]);
        finnefeltnr=new ARRAY$<int[]>(new int[finnefeltnr$UB[0]-finnefeltnr$LB[0]+1],finnefeltnr$LB,finnefeltnr$UB);
        // JavaLine 172 ==> SourceLine 241
        int[] finnefeltpeker$LB=new int[1]; int[] finnefeltpeker$UB=new int[1];
        finnefeltpeker$LB[0]=1; finnefeltpeker$UB[0]=8;
        BOUND_CHECK$(finnefeltpeker$LB[0],finnefeltpeker$UB[0]);
        finnefeltpeker=new ARRAY$<HegnaNRK$PBLK21$verdi[]>(new HegnaNRK$PBLK21$verdi[finnefeltpeker$UB[0]-finnefeltpeker$LB[0]+1],finnefeltpeker$LB,finnefeltpeker$UB);
        // JavaLine 177 ==> SourceLine 256
        int[] post_peker$LB=new int[1]; int[] post_peker$UB=new int[1];
        post_peker$LB[0]=1; post_peker$UB[0]=256;
        BOUND_CHECK$(post_peker$LB[0],post_peker$UB[0]);
        post_peker=new ARRAY$<HegnaNRK$PBLK21$post[]>(new HegnaNRK$PBLK21$post[post_peker$UB[0]-post_peker$LB[0]+1],post_peker$LB,post_peker$UB);
        // JavaLine 182 ==> SourceLine 615
        int[] divisor$LB=new int[1]; int[] divisor$UB=new int[1];
        divisor$LB[0]=1; divisor$UB[0]=20;
        BOUND_CHECK$(divisor$LB[0],divisor$UB[0]);
        divisor=new ARRAY$<int[]>(new int[divisor$UB[0]-divisor$LB[0]+1],divisor$LB,divisor$UB);
        // JavaLine 187 ==> SourceLine 616
        int[] egenskap$LB=new int[1]; int[] egenskap$UB=new int[1];
        egenskap$LB[0]=1; egenskap$UB[0]=20;
        BOUND_CHECK$(egenskap$LB[0],egenskap$UB[0]);
        egenskap=new ARRAY$<TXT$[]>(new TXT$[egenskap$UB[0]-egenskap$LB[0]+1],egenskap$LB,egenskap$UB);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("HegnaNRK$PBLK21",616,inner);
                // JavaLine 196 ==> SourceLine 1454
                kommando_tabell.Elt[1-kommando_tabell.LB[0]]=new TXT$("KONTAKT");
                // JavaLine 198 ==> SourceLine 1455
                kommando_tabell.Elt[2-kommando_tabell.LB[0]]=new TXT$("SKRIV");
                // JavaLine 200 ==> SourceLine 1456
                kommando_tabell.Elt[3-kommando_tabell.LB[0]]=new TXT$("S�K");
                // JavaLine 202 ==> SourceLine 1457
                kommando_tabell.Elt[4-kommando_tabell.LB[0]]=new TXT$("ENDRE");
                // JavaLine 204 ==> SourceLine 1458
                kommando_tabell.Elt[5-kommando_tabell.LB[0]]=new TXT$("TRYKK");
                // JavaLine 206 ==> SourceLine 1459
                kommando_tabell.Elt[6-kommando_tabell.LB[0]]=new TXT$("FJERN");
                // JavaLine 208 ==> SourceLine 1460
                kommando_tabell.Elt[7-kommando_tabell.LB[0]]=new TXT$("HJELP");
                // JavaLine 210 ==> SourceLine 1461
                kommando_tabell.Elt[8-kommando_tabell.LB[0]]=new TXT$("LIST");
                // JavaLine 212 ==> SourceLine 1462
                kommando_tabell.Elt[9-kommando_tabell.LB[0]]=new TXT$("LISTDEF");
                // JavaLine 214 ==> SourceLine 1463
                kommando_tabell.Elt[10-kommando_tabell.LB[0]]=new TXT$("NESTE");
                // JavaLine 216 ==> SourceLine 1464
                kommando_tabell.Elt[11-kommando_tabell.LB[0]]=new TXT$("HENT");
                // JavaLine 218 ==> SourceLine 1465
                kommando_tabell.Elt[12-kommando_tabell.LB[0]]=new TXT$("DATAREG");
                // JavaLine 220 ==> SourceLine 1466
                kommando_tabell.Elt[13-kommando_tabell.LB[0]]=new TXT$("DEFFORMAT");
                // JavaLine 222 ==> SourceLine 1467
                kommando_tabell.Elt[14-kommando_tabell.LB[0]]=new TXT$("RAPPORTER");
                // JavaLine 224 ==> SourceLine 1468
                kommando_tabell.Elt[15-kommando_tabell.LB[0]]=new TXT$("TAINN");
                // JavaLine 226 ==> SourceLine 1469
                kommando_tabell.Elt[16-kommando_tabell.LB[0]]=new TXT$("LEGGUT");
                // JavaLine 228 ==> SourceLine 1470
                kommando_tabell.Elt[17-kommando_tabell.LB[0]]=new TXT$("FINNMENGDE");
                // JavaLine 230 ==> SourceLine 1471
                kommando_tabell.Elt[18-kommando_tabell.LB[0]]=new TXT$("SORTERMENGDE");
                // JavaLine 232 ==> SourceLine 1472
                kommando_tabell.Elt[19-kommando_tabell.LB[0]]=new TXT$("RAPPORTERMENGDE");
                // JavaLine 234 ==> SourceLine 1473
                max_kommando=20;
                // JavaLine 236 ==> SourceLine 1474
                kommando_tabell.Elt[max_kommando-kommando_tabell.LB[0]]=new TXT$("SLUTT");
                // JavaLine 238 ==> SourceLine 1475
                quit_kommando=max_kommando;
                // JavaLine 240 ==> SourceLine 1478
                type_tabell.Elt[1-type_tabell.LB[0]]='H';
                // JavaLine 242 ==> SourceLine 1479
                type_tabell.Elt[2-type_tabell.LB[0]]='T';
                // JavaLine 244 ==> SourceLine 1480
                max_type=3;
                // JavaLine 246 ==> SourceLine 1481
                type_tabell.Elt[max_type-type_tabell.LB[0]]='.';
                // JavaLine 248 ==> SourceLine 1484
                max_felt_def=17;
                // JavaLine 250 ==> SourceLine 1485
                antall_felt_def=1;
                // JavaLine 252 ==> SourceLine 1486
                feltnavn_tabell.Elt[antall_felt_def-feltnavn_tabell.LB[0]]=new TXT$(".");
                // JavaLine 254 ==> SourceLine 1487
                felttype_tabell.Elt[antall_felt_def-felttype_tabell.LB[0]]=max_type;
                // JavaLine 256 ==> SourceLine 1488
                quit_felt=antall_felt_def;
                // JavaLine 258 ==> SourceLine 1491
                felt_antall=0;
                // JavaLine 260 ==> SourceLine 1492
                max_intern_felt=16;
                // JavaLine 262 ==> SourceLine 1495
                max_finne_regel=8;
                // JavaLine 264 ==> SourceLine 1496
                finne_regel_antall=0;
                // JavaLine 266 ==> SourceLine 1499
                antall_poster=0;
                // JavaLine 268 ==> SourceLine 1500
                max_antall_poster=256;
                // JavaLine 270 ==> SourceLine 1503
                max_format_def=8;
                // JavaLine 272 ==> SourceLine 1504
                max_format_lengde=16;
                // JavaLine 274 ==> SourceLine 1505
                antall_format_def=0;
                // JavaLine 276 ==> SourceLine 1508
                aktuell=0;
                // JavaLine 278 ==> SourceLine 1509
                eot=((char)39);
                // JavaLine 280 ==> SourceLine 1510
                skjerm_image_lengde=78;
                // JavaLine 282 ==> SourceLine 1511
                navne_lengde=30;
                // JavaLine 284 ==> SourceLine 1512
                tekst_lengde=180;
                // JavaLine 286 ==> SourceLine 1513
                fil_image_lengde=80;
                // JavaLine 288 ==> SourceLine 1514
                default_file_type=new TXT$(":SYMB");
                // JavaLine 290 ==> SourceLine 1515
                mengde=null;
                // JavaLine 292 ==> SourceLine 1516
                divisor.Elt[1-divisor.LB[0]]=1;
                // JavaLine 294 ==> SourceLine 1517
                divisor.Elt[2-divisor.LB[0]]=17;
                // JavaLine 296 ==> SourceLine 1518
                divisor.Elt[3-divisor.LB[0]]=2;
                // JavaLine 298 ==> SourceLine 1519
                divisor.Elt[4-divisor.LB[0]]=3;
                // JavaLine 300 ==> SourceLine 1520
                divisor.Elt[5-divisor.LB[0]]=11;
                // JavaLine 302 ==> SourceLine 1521
                divisor.Elt[6-divisor.LB[0]]=1;
                // JavaLine 304 ==> SourceLine 1522
                divisor.Elt[7-divisor.LB[0]]=3;
                // JavaLine 306 ==> SourceLine 1523
                divisor.Elt[8-divisor.LB[0]]=4;
                // JavaLine 308 ==> SourceLine 1524
                divisor.Elt[9-divisor.LB[0]]=2;
                // JavaLine 310 ==> SourceLine 1525
                divisor.Elt[10-divisor.LB[0]]=10;
                // JavaLine 312 ==> SourceLine 1526
                divisor.Elt[11-divisor.LB[0]]=1;
                // JavaLine 314 ==> SourceLine 1528
                new HegnaNRK$PBLK21$main(((HegnaNRK$PBLK21)CUR$));
                TRACE_END_STM$("HegnaNRK$PBLK21",1528);
            }
        };
    } // End of Constructor
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new HegnaNRK$PBLK21(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","PrefixedBlock HegnaNRK$PBLK21",1,21,13,22,15,23,17,24,19,27,21,28,23,29,25,30,27,31,30,32,32,35,35,36,37,39,39,40,41,43,44,44,46,45,48,46,50,47,52,48,55,49,59,227,62,228,64,229,66,232,69,233,71,234,73,235,75,236,77,239,80,240,82,241,84,244,86,245,89,246,91,249,93,255,96,256,98,613,100,614,102,615,104,616,113,36,118,40,123,45,128,46,133,49,142,228,147,229,152,234,157,235,162,236,167,240,172,241,177,256,182,615,187,616,196,1454,198,1455,200,1456,202,1457,204,1458,206,1459,208,1460,210,1461,212,1462,214,1463,216,1464,218,1465,220,1466,222,1467,224,1468,226,1469,228,1470,230,1471,232,1472,234,1473,236,1474,238,1475,240,1478,242,1479,244,1480,246,1481,248,1484,250,1485,252,1486,254,1487,256,1488,258,1491,260,1492,262,1495,264,1496,266,1499,268,1500,270,1503,272,1504,274,1505,276,1508,278,1509,280,1510,282,1511,284,1512,286,1513,288,1514,290,1515,292,1516,294,1517,296,1518,298,1519,300,1520,302,1521,304,1522,306,1523,308,1524,310,1525,312,1526,314,1528,325,1529);
}
