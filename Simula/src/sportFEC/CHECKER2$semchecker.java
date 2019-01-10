// JavaLine 1 ==> SourceLine 35
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 12:01:21 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER2$semchecker extends CHECKER1$semchecker1 {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=3, firstLine=35, lastLine=1665, hasLocalClasses=true, System=false, detachUsed=true
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 12 ==> SourceLine 926
    final LABQNT$ gennap=new LABQNT$(this,3,1); // Local Label #1=gennap
    // JavaLine 14 ==> SourceLine 958
    final LABQNT$ STACK=new LABQNT$(this,3,2); // Local Label #2=STACK
    // JavaLine 16 ==> SourceLine 960
    final LABQNT$ REPLACE=new LABQNT$(this,3,3); // Local Label #3=REPLACE
    // JavaLine 18 ==> SourceLine 986
    final LABQNT$ OPNOUT=new LABQNT$(this,3,4); // Local Label #4=OPNOUT
    // JavaLine 20 ==> SourceLine 1028
    final LABQNT$ outbb=new LABQNT$(this,3,5); // Local Label #5=outbb
    // JavaLine 22 ==> SourceLine 1097
    final LABQNT$ Acon=new LABQNT$(this,3,6); // Local Label #6=Acon
    // JavaLine 24 ==> SourceLine 1106
    final LABQNT$ SetCon=new LABQNT$(this,3,7); // Local Label #7=SetCon
    // JavaLine 26 ==> SourceLine 1107
    final LABQNT$ SetCo1=new LABQNT$(this,3,8); // Local Label #8=SetCo1
    // JavaLine 28 ==> SourceLine 1108
    final LABQNT$ SetCo2=new LABQNT$(this,3,9); // Local Label #9=SetCo2
    // JavaLine 30 ==> SourceLine 1150
    final LABQNT$ swap=new LABQNT$(this,3,10); // Local Label #10=swap
    // JavaLine 32 ==> SourceLine 1175
    final LABQNT$ POPEXPEXP=new LABQNT$(this,3,11); // Local Label #11=POPEXPEXP
    // JavaLine 34 ==> SourceLine 1211
    final LABQNT$ repu=new LABQNT$(this,3,12); // Local Label #12=repu
    // JavaLine 36 ==> SourceLine 1304
    final LABQNT$ Eass=new LABQNT$(this,3,13); // Local Label #13=Eass
    // JavaLine 38 ==> SourceLine 1324
    final LABQNT$ LIARGE=new LABQNT$(this,3,14); // Local Label #14=LIARGE
    // JavaLine 40 ==> SourceLine 1367
    final LABQNT$ KERR1=new LABQNT$(this,3,15); // Local Label #15=KERR1
    // JavaLine 42 ==> SourceLine 1387
    final LABQNT$ KERR2=new LABQNT$(this,3,16); // Local Label #16=KERR2
    // JavaLine 44 ==> SourceLine 1421
    final LABQNT$ LIWHEN1=new LABQNT$(this,3,17); // Local Label #17=LIWHEN1
    // JavaLine 46 ==> SourceLine 1434
    final LABQNT$ bscp=new LABQNT$(this,3,18); // Local Label #18=bscp
    // JavaLine 48 ==> SourceLine 1463
    final LABQNT$ opqout=new LABQNT$(this,3,19); // Local Label #19=opqout
    // JavaLine 50 ==> SourceLine 1499
    final LABQNT$ LIFORE=new LABQNT$(this,3,20); // Local Label #20=LIFORE
    // JavaLine 52 ==> SourceLine 1571
    final LABQNT$ bnde1=new LABQNT$(this,3,21); // Local Label #21=bnde1
    // JavaLine 54 ==> SourceLine 889
    final LABQNT$ NEXTOPN=new LABQNT$(this,3,22); // Local Label #22=NEXTOPN
    // Declare locals as attributes
    // JavaLine 57 ==> SourceLine 40
    public boolean checkclb=false;
    // JavaLine 59 ==> SourceLine 41
    public char unstop=0;
    // JavaLine 61 ==> SourceLine 42
    public int L2p=0;
    // JavaLine 63 ==> SourceLine 43
    public int opi=0;
    // JavaLine 65 ==> SourceLine 44
    public TXT$ L2buf=null;
    // JavaLine 67 ==> SourceLine 46
    public CHECKER1$semchecker1$switchdef curswitch=null;
    // JavaLine 69 ==> SourceLine 47
    public CHECKER1$semchecker1$switchelement curswitchel=null;
    // JavaLine 71 ==> SourceLine 49
    public CHECKER2$semchecker$unstack ust=null;
    // JavaLine 73 ==> SourceLine 50
    public CHECKER2$semchecker$ConstEltChecker constantelt=null;
    // JavaLine 75 ==> SourceLine 56
    public ARRAY$<CHECKER1$semchecker1$exp[]>expexptop=null;
    // JavaLine 77 ==> SourceLine 62
    public COMMON$quantity visq=null;
    // JavaLine 79 ==> SourceLine 92
    public final int lowpl=0;
    // JavaLine 81 ==> SourceLine 996
    public COMMON$brecord inspect$996$15=null;
    // JavaLine 83 ==> SourceLine 1017
    public COMMON$brecord inspect$1017$16=null;
    // JavaLine 85 ==> SourceLine 1021
    public COMMON$quantity inspect$1020$17=null;
    // JavaLine 87 ==> SourceLine 1050
    public COMMON$quantity inspect$1049$18=null;
    // JavaLine 89 ==> SourceLine 1289
    public COMMON$identsymbol inspect$1288$19=null;
    // JavaLine 91 ==> SourceLine 1374
    public CHECKER1$semchecker1$identifier inspect$1374$20=null;
    // JavaLine 93 ==> SourceLine 1452
    public COMMON$quantity inspect$1452$21=null;
    // JavaLine 95 ==> SourceLine 1471
    public COMMON$quantity inspect$1470$22=null;
    // JavaLine 97 ==> SourceLine 1485
    public COMMON$brecord inspect$1485$23=null;
    // JavaLine 99 ==> SourceLine 1499
    public COMMON$brecord inspect$1499$24=null;
    // JavaLine 101 ==> SourceLine 1519
    public CHECKER1$semchecker1$switchelement inspect$1519$25=null;
    // JavaLine 103 ==> SourceLine 1555
    public COMMON$brecord inspect$1555$26=null;
    // Normal Constructor
    public CHECKER2$semchecker(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("semchecker",1555);
        // JavaLine 111 ==> SourceLine 56
        int[] expexptop$LB=new int[1]; int[] expexptop$UB=new int[1];
        expexptop$LB[0]=0; expexptop$UB[0]=((CHECKER2)(CUR$.SL$)).maxdepth;
        BOUND_CHECK$(expexptop$LB[0],expexptop$UB[0]);
        expexptop=new ARRAY$<CHECKER1$semchecker1$exp[]>(new CHECKER1$semchecker1$exp[expexptop$UB[0]-expexptop$LB[0]+1],expexptop$LB,expexptop$UB);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("semchecker",56,inner);
                CHECKER2$semchecker THIS$=(CHECKER2$semchecker)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 124 ==> SourceLine 867
                        detach();
                        // JavaLine 126 ==> SourceLine 872
                        {
                            TRACE_BEGIN_STM$("CompoundStatement872",872);
                            while(true) {
                                // JavaLine 130 ==> SourceLine 874
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement874",874);
                                    // JavaLine 133 ==> SourceLine 889
                                    LABEL$(22); // NEXTOPN
                                    ((CHECKER2)(CUR$.SL$)).opn=loadChar(L2buf,L2p);
                                    L2p=(L2p+(1));
                                    // JavaLine 137 ==> SourceLine 895
                                    switch(((CHECKER2)(CUR$.SL$)).opn) { // BEGIN SWITCH STATEMENT
                                    case 139: 
                                    case 90: 
                                    // JavaLine 141 ==> SourceLine 900
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement900",900);
                                        new CHECKER2$semchecker$getOpd(((CHECKER2$semchecker)CUR$));
                                        // JavaLine 145 ==> SourceLine 901
                                        if((simpleList==(null))) {
                                            // JavaLine 147 ==> SourceLine 902
                                            new CHECKER1$semchecker1$simpleIdent(((CHECKER2$semchecker)CUR$),exptop,((CHECKER2)(CUR$.SL$)).IIDN).START();
                                        } else
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement902",902);
                                            simpleList.p$ch=((CHECKER2)(CUR$.SL$)).IIDN;
                                            call(simpleList);
                                            TRACE_END_STM$("CompoundStatement902",902);
                                        }
                                        // JavaLine 156 ==> SourceLine 903
                                        GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement900",903);
                                    }
                                    case 76: 
                                    case 115: 
                                    // JavaLine 162 ==> SourceLine 909
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement909",909);
                                        new CHECKER2$semchecker$getOpd(((CHECKER2$semchecker)CUR$));
                                        // JavaLine 166 ==> SourceLine 910
                                        new CHECKER1$semchecker1$dotIdent(((CHECKER2$semchecker)CUR$),exptop.p$pred,((CHECKER2)(CUR$.SL$)).opn,exptop).STM$();
                                        // JavaLine 168 ==> SourceLine 911
                                        if((((CHECKER2)(CUR$.SL$)).opn==(((CHECKER2)(CUR$.SL$)).IDOT))) {
                                            GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                        }
                                        // JavaLine 172 ==> SourceLine 912
                                        GOTO$(gennap); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement909",912);
                                    }
                                    case 134: 
                                    // JavaLine 177 ==> SourceLine 917
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement917",917);
                                        new CHECKER2$semchecker$getOpd(((CHECKER2$semchecker)CUR$));
                                        // JavaLine 181 ==> SourceLine 918
                                        exptop=new CHECKER1$semchecker1$newIdent(((CHECKER2$semchecker)CUR$),exptop,((CHECKER2)(CUR$.SL$)).INEWP).STM$();
                                        // JavaLine 183 ==> SourceLine 919
                                        GOTO$(gennap); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement917",919);
                                    }
                                    case 129: 
                                    // JavaLine 188 ==> SourceLine 923
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement923",923);
                                        new CHECKER2$semchecker$getOpd(((CHECKER2$semchecker)CUR$));
                                        // JavaLine 192 ==> SourceLine 924
                                        if((simpleList==(null))) {
                                            // JavaLine 194 ==> SourceLine 925
                                            new CHECKER1$semchecker1$simpleIdent(((CHECKER2$semchecker)CUR$),exptop,((CHECKER2)(CUR$.SL$)).IIDNP).START();
                                        } else
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement925",925);
                                            simpleList.p$ch=((CHECKER2)(CUR$.SL$)).IIDNP;
                                            call(simpleList);
                                            TRACE_END_STM$("CompoundStatement925",925);
                                        }
                                        // JavaLine 203 ==> SourceLine 937
                                        LABEL$(1); // gennap
                                        // JavaLine 205 ==> SourceLine 926
                                        if(lastnap.inuse) {
                                            // JavaLine 207 ==> SourceLine 927
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement927",927);
                                                if((lastnap.suc==(null))) {
                                                    // JavaLine 211 ==> SourceLine 928
                                                    lastnap.suc=new CHECKER1$semchecker1$nextargumentproducer(((CHECKER2$semchecker)CUR$)).START();
                                                }
                                                // JavaLine 214 ==> SourceLine 929
                                                lastnap=lastnap.suc;
                                                TRACE_END_STM$("CompoundStatement927",929);
                                            }
                                        }
                                        // JavaLine 219 ==> SourceLine 938
                                        call(lastnap);
                                        // JavaLine 221 ==> SourceLine 939
                                        ((CHECKER2)(CUR$.SL$)).opn=((CHECKER2)(CUR$.SL$)).IFRMP;
                                        GOTO$(STACK); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement923",939);
                                    }
                                    case 70: 
                                    case 71: 
                                    case 73: 
                                    case 72: 
                                    case 75: 
                                    case 74: 
                                    case 58: 
                                    case 61: 
                                    case 62: 
                                    case 60: 
                                    case 59: 
                                    case 57: 
                                    case 85: 
                                    case 86: 
                                    case 45: 
                                    case 17: 
                                    case 24: 
                                    case 36: 
                                    case 68: 
                                    case 69: 
                                    case 146: 
                                    case 35: 
                                    case 84: 
                                    // JavaLine 249 ==> SourceLine 948
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement948",948);
                                        call(ust);
                                        GOTO$(STACK); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement948",948);
                                    }
                                    case 11: 
                                    case 87: 
                                    case 23: 
                                    case 80: 
                                    case 82: 
                                    case 83: 
                                    // JavaLine 262 ==> SourceLine 957
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement957",957);
                                        // JavaLine 265 ==> SourceLine 958
                                        LABEL$(2); // STACK
                                        opttop=(opttop+(1));
                                        // JavaLine 268 ==> SourceLine 960
                                        LABEL$(3); // REPLACE
                                        ((ARRAY$<char[]>)ust.optstack).Elt[opttop-ust.optstack.LB[0]]=((CHECKER2)(CUR$.SL$)).opn;
                                        expexptop.Elt[opttop-expexptop.LB[0]]=exptop;
                                        TRACE_END_STM$("CompoundStatement957",960);
                                    }
                                    case 63: 
                                    case 89: 
                                    // JavaLine 276 ==> SourceLine 966
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement966",966);
                                        opi=((rank(loadChar(L2buf,L2p))*(256))+(rank(loadChar(L2buf,(L2p+(1))))));
                                        // JavaLine 280 ==> SourceLine 967
                                        L2p=(L2p+(2));
                                        // JavaLine 282 ==> SourceLine 968
                                        if((((CHECKER2)(CUR$.SL$)).option.Elt[rank('L')-((CHECKER2)(CUR$.SL$)).option.LB[0]]!=(((CHECKER2)(CUR$.SL$)).NUL))) {
                                            // JavaLine 284 ==> SourceLine 970
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement970",970);
                                                sysout().outchar('/');
                                                sysout().outint(opi,4);
                                                TRACE_END_STM$("CompoundStatement970",970);
                                            }
                                        }
                                        // JavaLine 292 ==> SourceLine 971
                                        if((opi>(((CHECKER2)(CUR$.SL$)).linenr))) {
                                            ((CHECKER2)(CUR$.SL$)).linenr=opi;
                                        }
                                        // JavaLine 296 ==> SourceLine 972
                                        GOTO$(OPNOUT); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement966",972);
                                    }
                                    case 119: 
                                    case 131: 
                                    case 66: 
                                    case 67: 
                                    case 28: 
                                    case 125: 
                                    case 52: 
                                    case 135: 
                                    // JavaLine 308 ==> SourceLine 984
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement984",984);
                                        // JavaLine 311 ==> SourceLine 986
                                        LABEL$(4); // OPNOUT
                                        opc=((CHECKER2)(CUR$.SL$)).opn;
                                        call(((CHECKER2)(CUR$.SL$)).coder);
                                        // JavaLine 315 ==> SourceLine 988
                                        GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement984",988);
                                    }
                                    case 42: 
                                    // JavaLine 320 ==> SourceLine 993
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement993",993);
                                        new CHECKER2$semchecker$getlastblno(((CHECKER2$semchecker)CUR$));
                                        // JavaLine 324 ==> SourceLine 996
                                        {
                                            // BEGIN INSPECTION 
                                            inspect$996$15=new COMMON$getBrc(((CHECKER2)(CUR$.SL$)),lastblhi,lastbllo).RESULT$;
                                            if(inspect$996$15!=null) //INSPECT inspect$996$15
                                            // JavaLine 329 ==> SourceLine 997
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement997",997);
                                                visq=inspect$996$15.declquant;
                                                // JavaLine 333 ==> SourceLine 998
                                                while((visq.plev>(((CHECKER2)(CUR$.SL$)).one))) {
                                                    visq=visq.prefqual;
                                                }
                                                // JavaLine 337 ==> SourceLine 999
                                                visq.prefqual=((CHECKER2)(CUR$.SL$)).display.Elt[rank(((CHECKER2)(CUR$.SL$)).cblev)-((CHECKER2)(CUR$.SL$)).display.LB[0]].declquant;
                                                // JavaLine 339 ==> SourceLine 1000
                                                ((CHECKER2)(CUR$.SL$)).display.Elt[rank(((CHECKER2)(CUR$.SL$)).cblev)-((CHECKER2)(CUR$.SL$)).display.LB[0]]=((COMMON$brecord)inspect$996$15);
                                                // JavaLine 341 ==> SourceLine 1001
                                                ((ARRAY$<COMMON$brecord[]>)((CHECKER2)(CUR$.SL$)).brctab.Elt[rank(lastblhi)-((CHECKER2)(CUR$.SL$)).brctab.LB[0]].val).Elt[rank(lastbllo)-((CHECKER2)(CUR$.SL$)).brctab.Elt[rank(lastblhi)-((CHECKER2)(CUR$.SL$)).brctab.LB[0]].val.LB[0]]=null;
                                                // JavaLine 343 ==> SourceLine 1002
                                                new BUILDER1$precheck0$vischain(((CHECKER2$semchecker)CUR$),inspect$996$15.fpar,visq);
                                                TRACE_END_STM$("CompoundStatement997",1002);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement993",1002);
                                    }
                                    case 110: 
                                    // JavaLine 351 ==> SourceLine 1008
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1008",1008);
                                        new CHECKER2$semchecker$getlastblno(((CHECKER2$semchecker)CUR$));
                                        GOTO$(outbb); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1008",1008);
                                    }
                                    case 112: 
                                    case 92: 
                                    case 103: 
                                    // JavaLine 361 ==> SourceLine 1014
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1014",1014);
                                        new CHECKER2$semchecker$getlastblno(((CHECKER2$semchecker)CUR$));
                                        // JavaLine 365 ==> SourceLine 1015
                                        if((((CHECKER2)(CUR$.SL$)).opn==(((CHECKER2)(CUR$.SL$)).IBLKB))) {
                                            // JavaLine 367 ==> SourceLine 1017
                                            {
                                                // BEGIN INSPECTION 
                                                inspect$1017$16=new COMMON$getBrc(((CHECKER2)(CUR$.SL$)),lastblhi,lastbllo).RESULT$;
                                                if(inspect$1017$16!=null) //INSPECT inspect$1017$16
                                                // JavaLine 372 ==> SourceLine 1019
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement1019",1019);
                                                    if((inspect$1017$16.kind==(((CHECKER2)(CUR$.SL$)).K_proc))) {
                                                        // JavaLine 376 ==> SourceLine 1020
                                                        {
                                                            // BEGIN INSPECTION 
                                                            inspect$1020$17=new COMMON$getBrc(((CHECKER2)(CUR$.SL$)),inspect$1017$16.hidlist.idhi,inspect$1017$16.hidlist.idlo).RESULT$.declquant.match;
                                                            if(inspect$1020$17!=null) //INSPECT inspect$1020$17
                                                            // JavaLine 381 ==> SourceLine 1021
                                                            {
                                                                TRACE_BEGIN_STM$("CompoundStatement1021",1021);
                                                                if((inspect$1020$17.descr!=(null))) {
                                                                    // JavaLine 385 ==> SourceLine 1022
                                                                    {
                                                                        TRACE_BEGIN_STM$("CompoundStatement1022",1022);
                                                                        inspect$1017$16.hidlist.idhi=inspect$1020$17.descr.blnohi;
                                                                        inspect$1017$16.hidlist.idlo=inspect$1020$17.descr.blnolo;
                                                                        TRACE_END_STM$("CompoundStatement1022",1022);
                                                                    }
                                                                }
                                                                TRACE_END_STM$("CompoundStatement1021",1022);
                                                            }
                                                        }
                                                    }
                                                    TRACE_END_STM$("CompoundStatement1019",1022);
                                                }
                                            }
                                        }
                                        // JavaLine 401 ==> SourceLine 1027
                                        new BUILDER2$prechecker$allocate(((CHECKER2$semchecker)CUR$));
                                        // JavaLine 403 ==> SourceLine 1028
                                        LABEL$(5); // outbb
                                        opc=(((((CHECKER2)(CUR$.SL$)).opn==(((CHECKER2)(CUR$.SL$)).IBREC)))?(((CHECKER2)(CUR$.SL$)).IBREC):(((CHECKER2)(CUR$.SL$)).IBLKB));
                                        // JavaLine 406 ==> SourceLine 1029
                                        ((CHECKER2)(CUR$.SL$)).coder.opq=new COMMON$getBrc(((CHECKER2)(CUR$.SL$)),lastblhi,lastbllo).RESULT$.declquant;
                                        // JavaLine 408 ==> SourceLine 1030
                                        call(((CHECKER2)(CUR$.SL$)).coder);
                                        // JavaLine 410 ==> SourceLine 1031
                                        new CHECKER1$semchecker1$enterblock(((CHECKER2$semchecker)CUR$));
                                        TRACE_END_STM$("CompoundStatement1014",1031);
                                    }
                                    case 117: 
                                    case 121: 
                                    case 16: 
                                    // JavaLine 417 ==> SourceLine 1038
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1038",1038);
                                        ((CHECKER2)(CUR$.SL$)).coder.opq=((CHECKER2)(CUR$.SL$)).display.Elt[rank(((CHECKER2)(CUR$.SL$)).cblev)-((CHECKER2)(CUR$.SL$)).display.LB[0]].declquant;
                                        // JavaLine 421 ==> SourceLine 1039
                                        opc=((CHECKER2)(CUR$.SL$)).opn;
                                        call(((CHECKER2)(CUR$.SL$)).coder);
                                        // JavaLine 424 ==> SourceLine 1041
                                        new BUILDER1$precheck0$leaveblock(((CHECKER2$semchecker)CUR$));
                                        TRACE_END_STM$("CompoundStatement1038",1041);
                                    }
                                    case 77: 
                                    // JavaLine 429 ==> SourceLine 1046
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1046",1046);
                                        new CHECKER2$semchecker$getOpd(((CHECKER2$semchecker)CUR$));
                                        // JavaLine 433 ==> SourceLine 1047
                                        opc=((CHECKER2)(CUR$.SL$)).ILABE;
                                        // JavaLine 435 ==> SourceLine 1048
                                        ((CHECKER2)(CUR$.SL$)).coder.opq=new BUILDER1$meaningof(((CHECKER2)(CUR$.SL$)),opdSymb).RESULT$;
                                        // JavaLine 437 ==> SourceLine 1049
                                        {
                                            // BEGIN INSPECTION 
                                            inspect$1049$18=((CHECKER2)(CUR$.SL$)).coder.opq;
                                            if(inspect$1049$18!=null) //INSPECT inspect$1049$18
                                            // JavaLine 442 ==> SourceLine 1050
                                            if((inspect$1049$18.categ==(((CHECKER2)(CUR$.SL$)).C_virt))) {
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement1050",1050);
                                                    if((inspect$1049$18.match!=(null))) {
                                                        // JavaLine 447 ==> SourceLine 1051
                                                        ((CHECKER2)(CUR$.SL$)).coder.opq=inspect$1049$18.match;
                                                    }
                                                    TRACE_END_STM$("CompoundStatement1050",1051);
                                                }
                                            }
                                            else // OTHERWISE 
                                            // JavaLine 454 ==> SourceLine 1052
                                            ((CHECKER2)(CUR$.SL$)).coder.opq=new ERRMSG$newnotseen(((CHECKER2)(CUR$.SL$)),opdSymb).RESULT$;
                                        }
                                        // JavaLine 457 ==> SourceLine 1053
                                        call(((CHECKER2)(CUR$.SL$)).coder);
                                        TRACE_END_STM$("CompoundStatement1046",1053);
                                    }
                                    case 51: 
                                    // JavaLine 462 ==> SourceLine 1060
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1060",1060);
                                        new CHECKER2$semchecker$getOpd(((CHECKER2$semchecker)CUR$));
                                        // JavaLine 466 ==> SourceLine 1061
                                        call(constantelt);
                                        GOTO$(STACK); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1060",1061);
                                    }
                                    case 124: 
                                    // JavaLine 472 ==> SourceLine 1065
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1065",1065);
                                        readonly=((CHECKER1$semchecker1$identifier)(exptop)).meaning;
                                        TRACE_END_STM$("CompoundStatement1065",1065);
                                    }
                                    case 34: 
                                    // JavaLine 479 ==> SourceLine 1071
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1071",1071);
                                        new CHECKER2$semchecker$getOpd(((CHECKER2$semchecker)CUR$));
                                        // JavaLine 483 ==> SourceLine 1072
                                        exptop=new CHECKER1$semchecker1$newIdent(((CHECKER2$semchecker)CUR$),exptop,((CHECKER2)(CUR$.SL$)).INEW).STM$();
                                        TRACE_END_STM$("CompoundStatement1071",1072);
                                    }
                                    case 1: 
                                    // JavaLine 488 ==> SourceLine 1080
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1080",1080);
                                        exptop=new CHECKER1$semchecker1$boolconst(((CHECKER2$semchecker)CUR$),exptop,((CHECKER2)(CUR$.SL$)).ICONS).STM$();
                                        // JavaLine 492 ==> SourceLine 1081
                                        GOTO$(SetCo1); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1080",1081);
                                    }
                                    case 2: 
                                    // JavaLine 497 ==> SourceLine 1087
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1087",1087);
                                        exptop=new CHECKER1$semchecker1$charconst(((CHECKER2$semchecker)CUR$),exptop,((CHECKER2)(CUR$.SL$)).ICONS).STM$();
                                        // JavaLine 501 ==> SourceLine 1088
                                        GOTO$(SetCo1); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1087",1088);
                                    }
                                    case 3: 
                                    // JavaLine 506 ==> SourceLine 1092
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1092",1092);
                                        ((CHECKER2)(CUR$.SL$)).opn=((CHECKER2)(CUR$.SL$)).IINTG;
                                        GOTO$(Acon); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1092",1092);
                                    }
                                    case 4: 
                                    case 5: 
                                    case 6: 
                                    // JavaLine 516 ==> SourceLine 1096
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1096",1096);
                                        // JavaLine 519 ==> SourceLine 1100
                                        LABEL$(6); // Acon
                                        // JavaLine 521 ==> SourceLine 1097
                                        if((aconstList!=(null))) {
                                            // JavaLine 523 ==> SourceLine 1098
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1098",1098);
                                                aconstList.p$pred=exptop;
                                                aconstList.p$ch=((CHECKER2)(CUR$.SL$)).ICONS;
                                                // JavaLine 528 ==> SourceLine 1099
                                                exptop=aconstList;
                                                aconstList=null;
                                                TRACE_END_STM$("CompoundStatement1098",1099);
                                            }
                                        } else
                                        // JavaLine 534 ==> SourceLine 1100
                                        exptop=new CHECKER1$semchecker1$arithconst(((CHECKER2$semchecker)CUR$),exptop,((CHECKER2)(CUR$.SL$)).ICONS).STM$();
                                        // JavaLine 536 ==> SourceLine 1106
                                        LABEL$(7); // SetCon
                                        ((CHECKER1$semchecker1$const$)(exptop)).ixhi=loadChar(L2buf,L2p);
                                        L2p=(L2p+(1));
                                        // JavaLine 540 ==> SourceLine 1107
                                        LABEL$(8); // SetCo1
                                        ((CHECKER1$semchecker1$const$)(exptop)).ixlo=loadChar(L2buf,L2p);
                                        L2p=(L2p+(1));
                                        // JavaLine 544 ==> SourceLine 1108
                                        LABEL$(9); // SetCo2
                                        exptop.type=exptop.ctype=((CHECKER2)(CUR$.SL$)).opn;
                                        exptop.cl=IEEXPcl;
                                        TRACE_END_STM$("CompoundStatement1096",1108);
                                    }
                                    case 8: 
                                    // JavaLine 551 ==> SourceLine 1113
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1113",1113);
                                        exptop=new CHECKER1$semchecker1$textconst(((CHECKER2$semchecker)CUR$),exptop,((CHECKER2)(CUR$.SL$)).ICONS).STM$();
                                        // JavaLine 555 ==> SourceLine 1114
                                        exptop.qual=textclass;
                                        GOTO$(SetCon); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1113",1114);
                                    }
                                    case 7: 
                                    // JavaLine 561 ==> SourceLine 1118
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1118",1118);
                                        exptop=new CHECKER1$semchecker1$refconst(((CHECKER2$semchecker)CUR$),exptop,((CHECKER2)(CUR$.SL$)).ICONS).STM$();
                                        // JavaLine 565 ==> SourceLine 1119
                                        ((CHECKER1$semchecker1$const$)(exptop)).ixlo=((CHECKER2)(CUR$.SL$)).INONE;
                                        // JavaLine 567 ==> SourceLine 1120
                                        GOTO$(SetCo2); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1118",1120);
                                    }
                                    case 25: 
                                    case 29: 
                                    // JavaLine 573 ==> SourceLine 1124
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1124",1124);
                                        new CHECKER2$semchecker$getOpd(((CHECKER2$semchecker)CUR$));
                                        // JavaLine 577 ==> SourceLine 1125
                                        exptop=new CHECKER1$semchecker1$classcomparator(((CHECKER2$semchecker)CUR$),exptop.p$pred,((CHECKER2)(CUR$.SL$)).opn,null,exptop).STM$();
                                        TRACE_END_STM$("CompoundStatement1124",1125);
                                    }
                                    case 41: 
                                    // JavaLine 582 ==> SourceLine 1130
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1130",1130);
                                        new CHECKER2$semchecker$getOpd(((CHECKER2$semchecker)CUR$));
                                        // JavaLine 586 ==> SourceLine 1131
                                        exptop=new CHECKER1$semchecker1$instqual(((CHECKER2$semchecker)CUR$),exptop.p$pred,((CHECKER2)(CUR$.SL$)).IQUA,null,exptop).STM$();
                                        TRACE_END_STM$("CompoundStatement1130",1131);
                                    }
                                    case 50: 
                                    // JavaLine 591 ==> SourceLine 1136
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1136",1136);
                                        new CHECKER2$semchecker$getOpd(((CHECKER2$semchecker)CUR$));
                                        // JavaLine 595 ==> SourceLine 1137
                                        exptop=new CHECKER1$semchecker1$localobject(((CHECKER2$semchecker)CUR$),exptop,((CHECKER2)(CUR$.SL$)).ITHIS,null,true_const).STM$();
                                        TRACE_END_STM$("CompoundStatement1136",1137);
                                    }
                                    case 95: 
                                    // JavaLine 600 ==> SourceLine 1143
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1143",1143);
                                        ((CHECKER2)(CUR$.SL$)).opn=((CHECKER2)(CUR$.SL$)).IDCLI;
                                        GOTO$(swap); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1143",1143);
                                    }
                                    case 137: 
                                    case 49: 
                                    case 148: 
                                    case 15: 
                                    // JavaLine 611 ==> SourceLine 1150
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1150",1150);
                                        LABEL$(10); // swap
                                        call(ust);
                                        GOTO$(REPLACE); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1150",1150);
                                    }
                                    case 108: 
                                    // JavaLine 620 ==> SourceLine 1154
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1154",1154);
                                        if((exptop.ctype==(((CHECKER2)(CUR$.SL$)).IIDN))) {
                                            new CHECKER1$semchecker1$checkasexp(((CHECKER2$semchecker)CUR$),((CHECKER1$semchecker1$identifier)(exptop)));
                                        }
                                        // JavaLine 626 ==> SourceLine 1155
                                        exptop.cl=IEEXPcl;
                                        new CHECKER1$semchecker1$exp$emit(exptop);
                                        // JavaLine 629 ==> SourceLine 1156
                                        if((exptop.type==(((CHECKER2)(CUR$.SL$)).ICHAR))) {
                                            // JavaLine 631 ==> SourceLine 1157
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1157",1157);
                                                opc=((CHECKER2)(CUR$.SL$)).IPRHI;
                                                opt=((CHECKER2)(CUR$.SL$)).IINTG;
                                                // JavaLine 636 ==> SourceLine 1158
                                                call(((CHECKER2)(CUR$.SL$)).coder);
                                                TRACE_END_STM$("CompoundStatement1157",1158);
                                            }
                                        } else
                                        if((exptop.type!=(((CHECKER2)(CUR$.SL$)).IINTG))) {
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1158",1158);
                                                if((exptop.type!=(((CHECKER2)(CUR$.SL$)).ISHOR))) {
                                                    // JavaLine 645 ==> SourceLine 1159
                                                    new ERRMSG$error0(((CHECKER2)(CUR$.SL$)),441);
                                                }
                                                TRACE_END_STM$("CompoundStatement1158",1159);
                                            }
                                        }
                                        // JavaLine 651 ==> SourceLine 1160
                                        new CHECKER1$semchecker1$popExpStack(((CHECKER2$semchecker)CUR$));
                                        // JavaLine 653 ==> SourceLine 1161
                                        call(ust);
                                        TRACE_END_STM$("CompoundStatement1154",1161);
                                    }
                                    case 79: 
                                    case 116: 
                                    // JavaLine 659 ==> SourceLine 1167
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1167",1167);
                                        call(ust);
                                        TRACE_END_STM$("CompoundStatement1167",1167);
                                    }
                                    case 81: 
                                    // JavaLine 666 ==> SourceLine 1172
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1172",1172);
                                        call(ust);
                                        // JavaLine 670 ==> SourceLine 1173
                                        exptop=new CHECKER1$semchecker1$expinparantes(((CHECKER2$semchecker)CUR$),exptop.p$pred,((CHECKER2)(CUR$.SL$)).IRGPA,null,exptop).STM$();
                                        // JavaLine 672 ==> SourceLine 1176
                                        LABEL$(11); // POPEXPEXP
                                        // JavaLine 674 ==> SourceLine 1175
                                        if((opttop>(0))) {
                                            // JavaLine 676 ==> SourceLine 1176
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1176",1176);
                                                expexptop.Elt[opttop-expexptop.LB[0]]=null;
                                                opttop=(opttop-(1));
                                                TRACE_END_STM$("CompoundStatement1176",1176);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement1172",1176);
                                    }
                                    case 107: 
                                    // JavaLine 687 ==> SourceLine 1181
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1181",1181);
                                        call(ust);
                                        // JavaLine 691 ==> SourceLine 1182
                                        GOTO$(POPEXPEXP); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1181",1182);
                                    }
                                    case 47: 
                                    // JavaLine 696 ==> SourceLine 1187
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1187",1187);
                                        if((opc!=(((CHECKER2)(CUR$.SL$)).IGOE))) {
                                            // JavaLine 700 ==> SourceLine 1188
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1188",1188);
                                                ((CHECKER2)(CUR$.SL$)).opn=((CHECKER2)(CUR$.SL$)).IPRIO;
                                                GOTO$(OPNOUT); // GOTO EVALUATED LABEL
                                                TRACE_END_STM$("CompoundStatement1188",1188);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement1187",1188);
                                    }
                                    case 64: 
                                    // JavaLine 711 ==> SourceLine 1194
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1194",1194);
                                        new CHECKER2$semchecker$caseexp$othwise(((CHECKER2$semchecker$caseexp)(exptop)));
                                        TRACE_END_STM$("CompoundStatement1194",1194);
                                    }
                                    case 10: 
                                    // JavaLine 718 ==> SourceLine 1199
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1199",1199);
                                        ((CHECKER2)(CUR$.SL$)).opn=((CHECKER2)(CUR$.SL$)).IREAC;
                                        GOTO$(OPNOUT); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1199",1199);
                                    }
                                    case 120: 
                                    // JavaLine 726 ==> SourceLine 1205
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1205",1205);
                                        new CHECKER1$semchecker1$exp$emit(exptop);
                                        // JavaLine 730 ==> SourceLine 1206
                                        new CHECKER1$semchecker1$popExpStack(((CHECKER2$semchecker)CUR$));
                                        TRACE_END_STM$("CompoundStatement1205",1206);
                                    }
                                    case 96: 
                                    // JavaLine 735 ==> SourceLine 1211
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1211",1211);
                                        LABEL$(12); // repu
                                        unstop=((ARRAY$<char[]>)ust.optstack).Elt[opttop-ust.optstack.LB[0]];
                                        exptop=expexptop.Elt[opttop-expexptop.LB[0]];
                                        // JavaLine 741 ==> SourceLine 1212
                                        if((unstop==(((CHECKER2)(CUR$.SL$)).INOTY))) {
                                            GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                        }
                                        // JavaLine 745 ==> SourceLine 1213
                                        if(((((unstop==(((CHECKER2)(CUR$.SL$)).IFRMP))|((unstop==(((CHECKER2)(CUR$.SL$)).IGOTO))))|((unstop==(((CHECKER2)(CUR$.SL$)).IDCLS))))|((unstop==(((CHECKER2)(CUR$.SL$)).IIFSB))))) {
                                            // JavaLine 747 ==> SourceLine 1219
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1219",1219);
                                                exptop=new CHECKER1$semchecker1$exp(((CHECKER2$semchecker)CUR$),exptop,((CHECKER2)(CUR$.SL$)).IELSE).STM$();
                                                exptop.type=((CHECKER2)(CUR$.SL$)).IELSE;
                                                TRACE_END_STM$("CompoundStatement1219",1219);
                                            }
                                        } else
                                        // JavaLine 755 ==> SourceLine 1221
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1221",1221);
                                            expexptop.Elt[opttop-expexptop.LB[0]]=null;
                                            opttop=(opttop-(1));
                                            GOTO$(repu); // GOTO EVALUATED LABEL
                                            TRACE_END_STM$("CompoundStatement1221",1221);
                                        }
                                        TRACE_END_STM$("CompoundStatement1211",1221);
                                    }
                                    case 21: 
                                    // JavaLine 766 ==> SourceLine 1234
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1234",1234);
                                        ((CHECKER2)(CUR$.SL$)).ingotostmt=((CHECKER2)(CUR$.SL$)).notinconditional=true;
                                        // JavaLine 770 ==> SourceLine 1235
                                        opc=((CHECKER2)(CUR$.SL$)).IGOTO;
                                        GOTO$(STACK); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1234",1235);
                                    }
                                    case 130: 
                                    // JavaLine 776 ==> SourceLine 1241
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1241",1241);
                                        opc=((CHECKER2)(CUR$.SL$)).IIFSB;
                                        GOTO$(STACK); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1241",1241);
                                    }
                                    case 145: 
                                    // JavaLine 784 ==> SourceLine 1251
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1251",1251);
                                        call(ust);
                                        // JavaLine 788 ==> SourceLine 1252
                                        if((exptop.type!=(((CHECKER2)(CUR$.SL$)).IBOOL))) {
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1252",1252);
                                                if((exptop.type!=(((CHECKER2)(CUR$.SL$)).IELSE))) {
                                                    // JavaLine 793 ==> SourceLine 1253
                                                    new ERRMSG$error0(((CHECKER2)(CUR$.SL$)),172);
                                                }
                                                TRACE_END_STM$("CompoundStatement1252",1253);
                                            }
                                        }
                                        // JavaLine 799 ==> SourceLine 1254
                                        exptop.cl=IEEXPcl;
                                        // JavaLine 801 ==> SourceLine 1255
                                        if((exptop.ctype==(((CHECKER2)(CUR$.SL$)).IIDN))) {
                                            // JavaLine 803 ==> SourceLine 1256
                                            new CHECKER1$semchecker1$checkasexp(((CHECKER2$semchecker)CUR$),((CHECKER1$semchecker1$identifier)(exptop)));
                                        } else
                                        if((exptop.ctype==(((CHECKER2)(CUR$.SL$)).IEQ))) {
                                            exptop.cl=IIFSBcl;
                                        }
                                        // JavaLine 809 ==> SourceLine 1257
                                        new CHECKER1$semchecker1$exp$emit(exptop);
                                        // JavaLine 811 ==> SourceLine 1258
                                        opc=((CHECKER2)(CUR$.SL$)).opn;
                                        // JavaLine 813 ==> SourceLine 1259
                                        if((exptop.ctype!=(((CHECKER2)(CUR$.SL$)).IEQ))) {
                                            call(((CHECKER2)(CUR$.SL$)).coder);
                                        }
                                        // JavaLine 817 ==> SourceLine 1260
                                        new CHECKER1$semchecker1$popExpStack(((CHECKER2$semchecker)CUR$));
                                        GOTO$(POPEXPEXP); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1251",1260);
                                    }
                                    case 128: 
                                    // JavaLine 823 ==> SourceLine 1265
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1265",1265);
                                        call(ust);
                                        // JavaLine 827 ==> SourceLine 1266
                                        if((exptop.type!=(((CHECKER2)(CUR$.SL$)).ILABE))) {
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1266",1266);
                                                if((exptop.type!=(((CHECKER2)(CUR$.SL$)).IELSE))) {
                                                    // JavaLine 832 ==> SourceLine 1267
                                                    new ERRMSG$error0(((CHECKER2)(CUR$.SL$)),171);
                                                }
                                                TRACE_END_STM$("CompoundStatement1266",1267);
                                            }
                                        }
                                        // JavaLine 838 ==> SourceLine 1268
                                        exptop.cl=IEEXPcl;
                                        // JavaLine 840 ==> SourceLine 1269
                                        if((exptop.ctype==(((CHECKER2)(CUR$.SL$)).IIDN))) {
                                            new CHECKER1$semchecker1$checkasexp(((CHECKER2$semchecker)CUR$),((CHECKER1$semchecker1$identifier)(exptop)));
                                        }
                                        // JavaLine 844 ==> SourceLine 1270
                                        new CHECKER1$semchecker1$exp$emit(exptop);
                                        // JavaLine 846 ==> SourceLine 1271
                                        opc=((CHECKER2)(CUR$.SL$)).IGOE;
                                        call(((CHECKER2)(CUR$.SL$)).coder);
                                        // JavaLine 849 ==> SourceLine 1272
                                        new CHECKER1$semchecker1$popExpStack(((CHECKER2$semchecker)CUR$));
                                        GOTO$(POPEXPEXP); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1265",1272);
                                    }
                                    case 27: 
                                    // JavaLine 855 ==> SourceLine 1279
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1279",1279);
                                        opc=((CHECKER2)(CUR$.SL$)).IINSP;
                                        TRACE_END_STM$("CompoundStatement1279",1279);
                                    }
                                    case 46: 
                                    // JavaLine 862 ==> SourceLine 1284
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1284",1284);
                                        ((CHECKER2)(CUR$.SL$)).opn=((CHECKER2)(CUR$.SL$)).IASGE;
                                        new CHECKER2$semchecker$getOpd(((CHECKER2$semchecker)CUR$));
                                        call(ust);
                                        // JavaLine 868 ==> SourceLine 1286
                                        if((((CHECKER1$semchecker1$valassign)(exptop)).p1$source.type>(((CHECKER2)(CUR$.SL$)).IINTG))) {
                                            // JavaLine 870 ==> SourceLine 1288
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1288",1288);
                                                {
                                                    // BEGIN INSPECTION 
                                                    inspect$1288$19=((COMMON$identsymbol)(opdSymb));
                                                    if(inspect$1288$19!=null) //INSPECT inspect$1288$19
                                                    // JavaLine 877 ==> SourceLine 1289
                                                    if((((COMMON$quantity)(inspect$1288$19.curmeaning)).symb==(((COMMON$identsymbol)inspect$1288$19)))) {
                                                        // JavaLine 879 ==> SourceLine 1291
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement1291",1291);
                                                            inspect$1288$19.curmeaning=inspect$1288$19.curmeaning.next;
                                                            // JavaLine 883 ==> SourceLine 1292
                                                            ((CHECKER1$semchecker1$valassign)(exptop)).p1$target.meaning=((COMMON$quantity)(inspect$1288$19.curmeaning));
                                                            // JavaLine 885 ==> SourceLine 1293
                                                            ((CHECKER1$semchecker1$valassign)(exptop)).p1$target.type=((CHECKER1$semchecker1$valassign)(exptop)).type=((CHECKER2)(CUR$.SL$)).ILONG;
                                                            TRACE_END_STM$("CompoundStatement1291",1293);
                                                        }
                                                    }
                                                }
                                                TRACE_END_STM$("CompoundStatement1288",1293);
                                            }
                                        }
                                        // JavaLine 894 ==> SourceLine 1298
                                        GOTO$(Eass); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1284",1298);
                                    }
                                    case 100: 
                                    // JavaLine 899 ==> SourceLine 1303
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1303",1303);
                                        call(ust);
                                        // JavaLine 903 ==> SourceLine 1304
                                        LABEL$(13); // Eass
                                        new CHECKER1$semchecker1$exp$emit(exptop);
                                        // JavaLine 906 ==> SourceLine 1306
                                        new CHECKER1$semchecker1$popExpStack(((CHECKER2$semchecker)CUR$));
                                        // JavaLine 908 ==> SourceLine 1307
                                        opc=((CHECKER2)(CUR$.SL$)).IASGE;
                                        TRACE_END_STM$("CompoundStatement1303",1307);
                                    }
                                    case 78: 
                                    // JavaLine 913 ==> SourceLine 1313
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1313",1313);
                                        call(ust);
                                        // JavaLine 917 ==> SourceLine 1314
                                        call(lastnap);
                                        TRACE_END_STM$("CompoundStatement1313",1314);
                                    }
                                    case 32: 
                                    // JavaLine 922 ==> SourceLine 1319
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1319",1319);
                                        new CHECKER2$semchecker$getlastblno(((CHECKER2$semchecker)CUR$));
                                        // JavaLine 926 ==> SourceLine 1320
                                        GOTO$(LIARGE); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1319",1320);
                                    }
                                    case 98: 
                                    case 104: 
                                    // JavaLine 932 ==> SourceLine 1324
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1324",1324);
                                        LABEL$(14); // LIARGE
                                        call(ust);
                                        // JavaLine 937 ==> SourceLine 1325
                                        call(lastnap);
                                        // JavaLine 939 ==> SourceLine 1326
                                        lastnap.inuse=false;
                                        // JavaLine 941 ==> SourceLine 1327
                                        call(lastnap);
                                        // JavaLine 943 ==> SourceLine 1329
                                        exptop=new CHECKER1$semchecker1$argumented(((CHECKER2$semchecker)CUR$),exptop.p$pred,(((((CHECKER2)(CUR$.SL$)).opn==(((CHECKER2)(CUR$.SL$)).IBEGI)))?(((CHECKER2)(CUR$.SL$)).IBPRF):(((CHECKER2)(CUR$.SL$)).IARGE)),((CHECKER1$semchecker1$identifier)(exptop)),lastnap.firstarg.nextarg,lastnap.noofexpargs,lastnap.argno).STM$();
                                        // JavaLine 945 ==> SourceLine 1335
                                        lastnap=lastnap.pred;
                                        // JavaLine 947 ==> SourceLine 1336
                                        if((((CHECKER2)(CUR$.SL$)).opn==(((CHECKER2)(CUR$.SL$)).IBEGI))) {
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1336",1336);
                                                new CHECKER1$semchecker1$exp$emit(exptop);
                                                new CHECKER1$semchecker1$popExpStack(((CHECKER2$semchecker)CUR$));
                                                TRACE_END_STM$("CompoundStatement1336",1336);
                                            }
                                        }
                                        // JavaLine 956 ==> SourceLine 1337
                                        GOTO$(POPEXPEXP); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1324",1337);
                                    }
                                    case 93: 
                                    // JavaLine 961 ==> SourceLine 1342
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1342",1342);
                                        new CHECKER2$semchecker$getlastblno(((CHECKER2$semchecker)CUR$));
                                        // JavaLine 965 ==> SourceLine 1343
                                        new CHECKER2$semchecker$getOpd(((CHECKER2$semchecker)CUR$));
                                        // JavaLine 967 ==> SourceLine 1344
                                        new CHECKER1$semchecker1$identifier$emit(new CHECKER1$semchecker1$prefIdent(((CHECKER2$semchecker)CUR$),exptop,((CHECKER2)(CUR$.SL$)).IBPRF).STM$());
                                        TRACE_END_STM$("CompoundStatement1342",1344);
                                    }
                                    case 122: 
                                    // JavaLine 972 ==> SourceLine 1350
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1350",1350);
                                        if((exptop.ctype==(((CHECKER2)(CUR$.SL$)).IIDN))) {
                                            // JavaLine 976 ==> SourceLine 1351
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1351",1351);
                                                switch(exptop.kind) { // BEGIN SWITCH STATEMENT
                                                case 10: 
                                                case 1: 
                                                // JavaLine 982 ==> SourceLine 1354
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement1354",1354);
                                                    new CHECKER1$semchecker1$checkasexp(((CHECKER2$semchecker)CUR$),((CHECKER1$semchecker1$identifier)(exptop)));
                                                    TRACE_END_STM$("CompoundStatement1354",1354);
                                                }
                                                case 5: 
                                                // JavaLine 989 ==> SourceLine 1362
                                                new CHECKER1$semchecker1$checkasexp(((CHECKER2$semchecker)CUR$),((CHECKER1$semchecker1$identifier)(exptop)));
                                                case 2: 
                                                case 6: 
                                                // JavaLine 993 ==> SourceLine 1363
                                                new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$identifier)(exptop)),360);
                                                case 4: 
                                                // JavaLine 996 ==> SourceLine 1364
                                                new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$identifier)(exptop)),361);
                                                case 0: 
                                                // JavaLine 999 ==> SourceLine 1365
                                                new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$identifier)(exptop)),362);
                                                case 3: 
                                                // JavaLine 1002 ==> SourceLine 1366
                                                new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$identifier)(exptop)),363);
                                                default:
                                                // JavaLine 1005 ==> SourceLine 1368
                                                LABEL$(15); // KERR1
                                                new BUILDER1$visiblegenerator$StopScode_1(((BUILDER1$visiblegenerator)(((CHECKER2)(CUR$.SL$)).coder)),((char)9),1368);
                                            } // END SWITCH STATEMENT
                                            TRACE_END_STM$("CompoundStatement1351",1368);
                                        }
                                    } else
                                    // JavaLine 1012 ==> SourceLine 1372
                                    if((exptop.ctype==(((CHECKER2)(CUR$.SL$)).IIDNP))) {
                                        // JavaLine 1014 ==> SourceLine 1374
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1374",1374);
                                            {
                                                // BEGIN INSPECTION 
                                                inspect$1374$20=((CHECKER1$semchecker1$argumented)(exptop)).p1$ident;
                                                if(inspect$1374$20!=null) //INSPECT inspect$1374$20
                                                // JavaLine 1021 ==> SourceLine 1375
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement1375",1375);
                                                    switch(inspect$1374$20.kind) { // BEGIN SWITCH STATEMENT
                                                    case 10: 
                                                    case 1: 
                                                    case 5: 
                                                    // JavaLine 1028 ==> SourceLine 1378
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement1378",1378);
                                                        if((inspect$1374$20.p$ch==(((CHECKER2)(CUR$.SL$)).IIDNP))) {
                                                            new CHECKER1$semchecker1$identifier$identError(inspect$1374$20,334);
                                                        }
                                                        TRACE_END_STM$("CompoundStatement1378",1378);
                                                    }
                                                    case 2: 
                                                    case 6: 
                                                    // JavaLine 1038 ==> SourceLine 1385
                                                    new CHECKER1$semchecker1$identifier$identError(inspect$1374$20,364);
                                                    case 4: 
                                                    // JavaLine 1041 ==> SourceLine 1386
                                                    new CHECKER1$semchecker1$identifier$identError(inspect$1374$20,365);
                                                    default:
                                                    // JavaLine 1044 ==> SourceLine 1388
                                                    LABEL$(16); // KERR2
                                                    new BUILDER1$visiblegenerator$StopScode_1(((BUILDER1$visiblegenerator)(((CHECKER2)(CUR$.SL$)).coder)),((char)9),1388);
                                                } // END SWITCH STATEMENT
                                                TRACE_END_STM$("CompoundStatement1375",1388);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement1374",1388);
                                    }
                                } else
                                // JavaLine 1054 ==> SourceLine 1393
                                new ERRMSG$error0(((CHECKER2)(CUR$.SL$)),173);
                                // JavaLine 1056 ==> SourceLine 1394
                                exptop.cl=IEEXPcl;
                                new CHECKER1$semchecker1$exp$emit(exptop);
                                new CHECKER1$semchecker1$popExpStack(((CHECKER2$semchecker)CUR$));
                                // JavaLine 1060 ==> SourceLine 1395
                                GOTO$(OPNOUT); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1350",1395);
                            }
                            case 105: 
                            case 127: 
                            // JavaLine 1066 ==> SourceLine 1399
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1399",1399);
                                new CHECKER2$semchecker$getlastblno(((CHECKER2$semchecker)CUR$));
                                // JavaLine 1070 ==> SourceLine 1400
                                call(ust);
                                // JavaLine 1072 ==> SourceLine 1401
                                if((exptop.type!=(((CHECKER2)(CUR$.SL$)).IREF))) {
                                    // JavaLine 1074 ==> SourceLine 1402
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1402",1402);
                                        if((exptop.type!=(((CHECKER2)(CUR$.SL$)).IELSE))) {
                                            new ERRMSG$error0(((CHECKER2)(CUR$.SL$)),174);
                                        }
                                        TRACE_END_STM$("CompoundStatement1402",1402);
                                    }
                                }
                                // JavaLine 1083 ==> SourceLine 1403
                                if((exptop.ctype==(((CHECKER2)(CUR$.SL$)).IIDN))) {
                                    new CHECKER1$semchecker1$checkasexp(((CHECKER2$semchecker)CUR$),((CHECKER1$semchecker1$identifier)(exptop)));
                                }
                                // JavaLine 1087 ==> SourceLine 1404
                                exptop.cl=IEEXPcl;
                                new CHECKER1$semchecker1$exp$emit(exptop);
                                // JavaLine 1090 ==> SourceLine 1406
                                simpleList=null;
                                // JavaLine 1092 ==> SourceLine 1409
                                if(IS$(exptop,CHECKER1$semchecker1$newIdent.class)) {
                                    implNone=false;
                                } else
                                // JavaLine 1096 ==> SourceLine 1411
                                if(IS$(exptop,CHECKER1$semchecker1$argumented.class)) {
                                    // JavaLine 1098 ==> SourceLine 1412
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1412",1412);
                                        if(IS$(((CHECKER1$semchecker1$argumented)(exptop)).p1$ident,CHECKER1$semchecker1$newIdent.class)) {
                                            // JavaLine 1102 ==> SourceLine 1413
                                            implNone=false;
                                        }
                                        TRACE_END_STM$("CompoundStatement1412",1413);
                                    }
                                }
                                // JavaLine 1108 ==> SourceLine 1414
                                if((((CHECKER2)(CUR$.SL$)).opn==(((CHECKER2)(CUR$.SL$)).ICONB))) {
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1414",1414);
                                        new CHECKER2$semchecker$enterconn(((CHECKER2$semchecker)CUR$),exptop.qual);
                                        GOTO$(bscp); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1414",1414);
                                    }
                                }
                                // JavaLine 1117 ==> SourceLine 1415
                                GOTO$(LIWHEN1); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1399",1415);
                            }
                            case 55: 
                            // JavaLine 1122 ==> SourceLine 1419
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1419",1419);
                                new CHECKER2$semchecker$getlastblno(((CHECKER2$semchecker)CUR$));
                                // JavaLine 1126 ==> SourceLine 1420
                                new CHECKER2$semchecker$leaveConn(((CHECKER2$semchecker)CUR$));
                                // JavaLine 1128 ==> SourceLine 1421
                                LABEL$(17); // LIWHEN1
                                new CHECKER2$semchecker$getOpd(((CHECKER2$semchecker)CUR$));
                                // JavaLine 1131 ==> SourceLine 1422
                                cquant=new BUILDER1$meaningof(((CHECKER2)(CUR$.SL$)),opdSymb).RESULT$;
                                // JavaLine 1133 ==> SourceLine 1423
                                if((cquant==(null))) {
                                    cquant=new ERRMSG$newnotseen(((CHECKER2)(CUR$.SL$)),opdSymb).RESULT$;
                                }
                                // JavaLine 1137 ==> SourceLine 1424
                                if(((cquant.kind!=(((CHECKER2)(CUR$.SL$)).K_class))&&((cquant.categ!=(((CHECKER2)(CUR$.SL$)).C_unknwn))))) {
                                    // JavaLine 1139 ==> SourceLine 1425
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1425",1425);
                                        new ERRMSG$error1id(((CHECKER2)(CUR$.SL$)),317,cquant.symb);
                                        new CHECKER2$semchecker$enterconn(((CHECKER2$semchecker)CUR$),null);
                                        TRACE_END_STM$("CompoundStatement1425",1425);
                                    }
                                } else
                                // JavaLine 1147 ==> SourceLine 1426
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1426",1426);
                                    if((exptop.qual!=(null))) {
                                        // JavaLine 1151 ==> SourceLine 1427
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1427",1427);
                                            if((!((new BUILDER1$precheck0$subclass(((CHECKER2$semchecker)CUR$),exptop.qual,cquant).RESULT$||(new BUILDER1$precheck0$subclass(((CHECKER2$semchecker)CUR$),cquant,exptop.qual).RESULT$))))) {
                                                // JavaLine 1155 ==> SourceLine 1429
                                                new ERRMSG$note1id(((CHECKER2)(CUR$.SL$)),396,opdSymb);
                                            }
                                            TRACE_END_STM$("CompoundStatement1427",1429);
                                        }
                                    }
                                    // JavaLine 1161 ==> SourceLine 1431
                                    new CHECKER2$semchecker$enterconn(((CHECKER2$semchecker)CUR$),(((cquant.kind==(((CHECKER2)(CUR$.SL$)).K_class)))?(cquant):(null)));
                                    TRACE_END_STM$("CompoundStatement1426",1431);
                                }
                                // JavaLine 1165 ==> SourceLine 1433
                                cquant=null;
                                // JavaLine 1167 ==> SourceLine 1434
                                LABEL$(18); // bscp
                                new CHECKER2$semchecker$enterstmt(((CHECKER2$semchecker)CUR$));
                                // JavaLine 1170 ==> SourceLine 1435
                                ((CHECKER2)(CUR$.SL$)).coder.opq=((CHECKER2)(CUR$.SL$)).display.Elt[rank(((CHECKER2)(CUR$.SL$)).cblev)-((CHECKER2)(CUR$.SL$)).display.LB[0]].declquant.prefqual;
                                // JavaLine 1172 ==> SourceLine 1436
                                opc=((CHECKER2)(CUR$.SL$)).opn;
                                call(((CHECKER2)(CUR$.SL$)).coder);
                                TRACE_END_STM$("CompoundStatement1419",1436);
                            }
                            case 37: 
                            case 106: 
                            // JavaLine 1179 ==> SourceLine 1442
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1442",1442);
                                new CHECKER2$semchecker$leaveConn(((CHECKER2$semchecker)CUR$));
                                // JavaLine 1183 ==> SourceLine 1443
                                new CHECKER1$semchecker1$popExpStack(((CHECKER2$semchecker)CUR$));
                                // JavaLine 1185 ==> SourceLine 1444
                                GOTO$(OPNOUT); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1442",1444);
                            }
                            case 19: 
                            // JavaLine 1190 ==> SourceLine 1448
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1448",1448);
                                new CHECKER2$semchecker$getlastblno(((CHECKER2$semchecker)CUR$));
                                // JavaLine 1194 ==> SourceLine 1449
                                new CHECKER2$semchecker$enterstmt(((CHECKER2$semchecker)CUR$));
                                // JavaLine 1196 ==> SourceLine 1450
                                new CHECKER2$semchecker$getOpd(((CHECKER2$semchecker)CUR$));
                                // JavaLine 1198 ==> SourceLine 1451
                                q=new BUILDER1$meaningof(((CHECKER2)(CUR$.SL$)),opdSymb).RESULT$;
                                // JavaLine 1200 ==> SourceLine 1452
                                {
                                    // BEGIN INSPECTION 
                                    inspect$1452$21=q;
                                    if(inspect$1452$21!=null) //INSPECT inspect$1452$21
                                    // JavaLine 1205 ==> SourceLine 1453
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1453",1453);
                                        if((inspect$1452$21.categ==(((CHECKER2)(CUR$.SL$)).C_name))) {
                                            new ERRMSG$error0(((CHECKER2)(CUR$.SL$)),(-(180)));
                                        }
                                        // JavaLine 1211 ==> SourceLine 1454
                                        if((inspect$1452$21.kind!=(((CHECKER2)(CUR$.SL$)).K_ident))) {
                                            // JavaLine 1213 ==> SourceLine 1455
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1455",1455);
                                                if((inspect$1452$21.kind!=(((CHECKER2)(CUR$.SL$)).K_error))) {
                                                    new ERRMSG$error1id(((CHECKER2)(CUR$.SL$)),306,inspect$1452$21.symb);
                                                }
                                                TRACE_END_STM$("CompoundStatement1455",1455);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement1453",1455);
                                    }
                                }
                                // JavaLine 1225 ==> SourceLine 1457
                                GOTO$(opqout); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1448",1457);
                            }
                            case 26: 
                            // JavaLine 1230 ==> SourceLine 1463
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1463",1463);
                                LABEL$(19); // opqout
                                ((CHECKER2)(CUR$.SL$)).coder.opq=((CHECKER2)(CUR$.SL$)).display.Elt[rank(((CHECKER2)(CUR$.SL$)).cblev)-((CHECKER2)(CUR$.SL$)).display.LB[0]].declquant;
                                // JavaLine 1235 ==> SourceLine 1464
                                GOTO$(OPNOUT); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1463",1464);
                            }
                            case 111: 
                            // JavaLine 1240 ==> SourceLine 1468
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1468",1468);
                                opc=((CHECKER2)(CUR$.SL$)).IDCLE;
                                // JavaLine 1244 ==> SourceLine 1470
                                {
                                    // BEGIN INSPECTION 
                                    inspect$1470$22=((CHECKER2)(CUR$.SL$)).display.Elt[rank(((CHECKER2)(CUR$.SL$)).cblev)-((CHECKER2)(CUR$.SL$)).display.LB[0]].declquant;
                                    if(inspect$1470$22!=null) //INSPECT inspect$1470$22
                                    // JavaLine 1249 ==> SourceLine 1471
                                    if(((inspect$1470$22.kind==(((CHECKER2)(CUR$.SL$)).K_class))||((inspect$1470$22.kind==(((CHECKER2)(CUR$.SL$)).K_prefbl))))) {
                                        // JavaLine 1251 ==> SourceLine 1472
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1472",1472);
                                            ((CHECKER2)(CUR$.SL$)).coder.opq=((COMMON$quantity)inspect$1470$22);
                                            call(((CHECKER2)(CUR$.SL$)).coder);
                                            TRACE_END_STM$("CompoundStatement1472",1472);
                                        }
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement1468",1472);
                            }
                            case 56: 
                            case 118: 
                            // JavaLine 1264 ==> SourceLine 1479
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1479",1479);
                                new CHECKER2$semchecker$getOpd(((CHECKER2$semchecker)CUR$));
                                ((CHECKER2)(CUR$.SL$)).coder.opq=new BUILDER1$meaningof(((CHECKER2)(CUR$.SL$)),opdSymb).RESULT$;
                                // JavaLine 1269 ==> SourceLine 1480
                                GOTO$(OPNOUT); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1479",1480);
                            }
                            case 53: 
                            // JavaLine 1274 ==> SourceLine 1485
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1485",1485);
                                {
                                    // BEGIN INSPECTION 
                                    inspect$1485$23=((CHECKER2)(CUR$.SL$)).display.Elt[rank(((CHECKER2)(CUR$.SL$)).cblev)-((CHECKER2)(CUR$.SL$)).display.LB[0]];
                                    if(inspect$1485$23!=null) //INSPECT inspect$1485$23
                                    // JavaLine 1281 ==> SourceLine 1486
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1486",1486);
                                        ((CHECKER2)(CUR$.SL$)).coder.opq=inspect$1485$23.declquant;
                                        opc=((CHECKER2)(CUR$.SL$)).IEND;
                                        call(((CHECKER2)(CUR$.SL$)).coder);
                                        // JavaLine 1287 ==> SourceLine 1487
                                        visq=inspect$1485$23.fpar;
                                        new BUILDER1$precheck0$invischain(((CHECKER2$semchecker)CUR$),visq);
                                        // JavaLine 1290 ==> SourceLine 1488
                                        visq=inspect$1485$23.declquant;
                                        // JavaLine 1292 ==> SourceLine 1489
                                        while((visq.plev>(((CHECKER2)(CUR$.SL$)).one))) {
                                            visq=visq.prefqual;
                                        }
                                        // JavaLine 1296 ==> SourceLine 1490
                                        ((CHECKER2)(CUR$.SL$)).display.Elt[rank(((CHECKER2)(CUR$.SL$)).cblev)-((CHECKER2)(CUR$.SL$)).display.LB[0]]=visq.prefqual.descr;
                                        // JavaLine 1298 ==> SourceLine 1491
                                        visq.prefqual=null;
                                        TRACE_END_STM$("CompoundStatement1486",1491);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement1485",1491);
                            }
                            case 126: 
                            // JavaLine 1306 ==> SourceLine 1497
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1497",1497);
                                // JavaLine 1309 ==> SourceLine 1502
                                LABEL$(20); // LIFORE
                                // JavaLine 1311 ==> SourceLine 1499
                                {
                                    // BEGIN INSPECTION 
                                    inspect$1499$24=((CHECKER2)(CUR$.SL$)).display.Elt[rank(((CHECKER2)(CUR$.SL$)).cblev)-((CHECKER2)(CUR$.SL$)).display.LB[0]];
                                    if(inspect$1499$24!=null) //INSPECT inspect$1499$24
                                    // JavaLine 1316 ==> SourceLine 1500
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1500",1500);
                                        visq=inspect$1499$24.fpar;
                                        new BUILDER1$precheck0$invischain(((CHECKER2$semchecker)CUR$),visq);
                                        // JavaLine 1321 ==> SourceLine 1501
                                        ((CHECKER2)(CUR$.SL$)).display.Elt[rank(((CHECKER2)(CUR$.SL$)).cblev)-((CHECKER2)(CUR$.SL$)).display.LB[0]]=inspect$1499$24.declquant.prefqual.descr;
                                        TRACE_END_STM$("CompoundStatement1500",1501);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement1497",1501);
                            }
                            case 113: 
                            // JavaLine 1329 ==> SourceLine 1508
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1508",1508);
                                opttop=(opttop+(1));
                                if((opttop>(((CHECKER2)(CUR$.SL$)).maxdepth))) {
                                    new ERRMSG$fatal0(((CHECKER2)(CUR$.SL$)),246);
                                }
                                // JavaLine 1336 ==> SourceLine 1509
                                ((ARRAY$<char[]>)ust.optstack).Elt[opttop-ust.optstack.LB[0]]=((CHECKER2)(CUR$.SL$)).IDCLS;
                                expexptop.Elt[opttop-expexptop.LB[0]]=exptop;
                                // JavaLine 1339 ==> SourceLine 1510
                                new CHECKER2$semchecker$getOpd(((CHECKER2$semchecker)CUR$));
                                // JavaLine 1341 ==> SourceLine 1511
                                exptop=curswitch=new CHECKER1$semchecker1$switchdef(((CHECKER2$semchecker)CUR$),exptop,((CHECKER2)(CUR$.SL$)).INOTY).STM$();
                                // JavaLine 1343 ==> SourceLine 1512
                                curswitch.sw=new BUILDER1$meaningof(((CHECKER2)(CUR$.SL$)),opdSymb).RESULT$;
                                // JavaLine 1345 ==> SourceLine 1513
                                if((curswitch.sw==(null))) {
                                    curswitch.sw=new ERRMSG$newnotseen(((CHECKER2)(CUR$.SL$)),opdSymb).RESULT$;
                                }
                                TRACE_END_STM$("CompoundStatement1508",1513);
                            }
                            case 144: 
                            // JavaLine 1352 ==> SourceLine 1518
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1518",1518);
                                call(ust);
                                // JavaLine 1356 ==> SourceLine 1519
                                {
                                    // BEGIN INSPECTION 
                                    inspect$1519$25=new CHECKER1$semchecker1$switchelement(((CHECKER2$semchecker)CUR$),exptop).STM$();
                                    if(inspect$1519$25!=null) //INSPECT inspect$1519$25
                                    // JavaLine 1361 ==> SourceLine 1520
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1520",1520);
                                        if((curswitchel==(null))) {
                                            // JavaLine 1365 ==> SourceLine 1521
                                            curswitch.elements=curswitchel=((CHECKER1$semchecker1$switchelement)inspect$1519$25);
                                        } else
                                        // JavaLine 1368 ==> SourceLine 1522
                                        curswitchel=curswitchel.next=((CHECKER1$semchecker1$switchelement)inspect$1519$25);
                                        TRACE_END_STM$("CompoundStatement1520",1522);
                                    }
                                }
                                // JavaLine 1373 ==> SourceLine 1524
                                new CHECKER1$semchecker1$popExpStack(((CHECKER2$semchecker)CUR$));
                                TRACE_END_STM$("CompoundStatement1518",1524);
                            }
                            case 143: 
                            // JavaLine 1378 ==> SourceLine 1529
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1529",1529);
                                new CHECKER1$semchecker1$switchdef$checkplainswitch(curswitch);
                                // JavaLine 1382 ==> SourceLine 1530
                                curswitch=null;
                                curswitchel=null;
                                // JavaLine 1385 ==> SourceLine 1531
                                new CHECKER1$semchecker1$exp$emit(exptop);
                                new CHECKER1$semchecker1$popExpStack(((CHECKER2$semchecker)CUR$));
                                GOTO$(POPEXPEXP); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1529",1531);
                            }
                            case 109: 
                            // JavaLine 1392 ==> SourceLine 1536
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1536",1536);
                                inarraybound=true;
                                // JavaLine 1396 ==> SourceLine 1537
                                new CHECKER2$semchecker$getOpd(((CHECKER2$semchecker)CUR$));
                                // JavaLine 1398 ==> SourceLine 1538
                                q=new BUILDER1$meaningof(((CHECKER2)(CUR$.SL$)),opdSymb).RESULT$;
                                // JavaLine 1400 ==> SourceLine 1539
                                if((q==(null))) {
                                    q=new ERRMSG$newnotseen(((CHECKER2)(CUR$.SL$)),opdSymb).RESULT$;
                                }
                                // JavaLine 1404 ==> SourceLine 1540
                                checkclb=(q.dim==(1));
                                // JavaLine 1406 ==> SourceLine 1541
                                if((q.dim>(10))) {
                                    // JavaLine 1408 ==> SourceLine 1543
                                    new ERRMSG$error1qlin(((CHECKER2)(CUR$.SL$)),359,q);
                                }
                                // JavaLine 1411 ==> SourceLine 1544
                                ((CHECKER2)(CUR$.SL$)).coder.opq=q;
                                GOTO$(OPNOUT); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1536",1544);
                            }
                            case 102: 
                            // JavaLine 1417 ==> SourceLine 1548
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1548",1548);
                                call(ust);
                                // JavaLine 1421 ==> SourceLine 1549
                                if(checkclb) {
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1549",1549);
                                        checkclb=false;
                                        // JavaLine 1426 ==> SourceLine 1551
                                        if(IS$(exptop,CHECKER1$semchecker1$arithconst.class)) {
                                            // JavaLine 1428 ==> SourceLine 1552
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1552",1552);
                                                if(inarraybound) {
                                                    // JavaLine 1432 ==> SourceLine 1555
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement1555",1555);
                                                        {
                                                            // BEGIN INSPECTION 
                                                            inspect$1555$26=new COMMON$brecord(((CHECKER2)(CUR$.SL$))).STM$();
                                                            if(inspect$1555$26!=null) //INSPECT inspect$1555$26
                                                            // JavaLine 1439 ==> SourceLine 1556
                                                            {
                                                                TRACE_BEGIN_STM$("CompoundStatement1556",1556);
                                                                inspect$1555$26.blnohi=((CHECKER1$semchecker1$const$)(exptop)).ixhi;
                                                                // JavaLine 1443 ==> SourceLine 1557
                                                                inspect$1555$26.blnolo=((CHECKER1$semchecker1$const$)(exptop)).ixlo;
                                                                // JavaLine 1445 ==> SourceLine 1558
                                                                inspect$1555$26.declquant=q;
                                                                q.descr=((COMMON$brecord)inspect$1555$26);
                                                                TRACE_END_STM$("CompoundStatement1556",1558);
                                                            }
                                                        }
                                                        // JavaLine 1451 ==> SourceLine 1560
                                                        q.special=((char)1);
                                                        TRACE_END_STM$("CompoundStatement1555",1560);
                                                    }
                                                }
                                                TRACE_END_STM$("CompoundStatement1552",1560);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement1549",1560);
                                    }
                                }
                                // JavaLine 1462 ==> SourceLine 1564
                                GOTO$(bnde1); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1548",1564);
                            }
                            case 99: 
                            case 114: 
                            // JavaLine 1468 ==> SourceLine 1569
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1569",1569);
                                call(ust);
                                // JavaLine 1472 ==> SourceLine 1576
                                LABEL$(21); // bnde1
                                // JavaLine 1474 ==> SourceLine 1571
                                switch(exptop.type) { // BEGIN SWITCH STATEMENT
                                case 2: 
                                case 3: 
                                case 4: 
                                case 5: 
                                case 6: 
                                case 15: 
                                default:
                                // JavaLine 1483 ==> SourceLine 1575
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1575",1575);
                                    ((CHECKER2)(CUR$.SL$)).messageLinenr=q.line;
                                    new ERRMSG$error1id(((CHECKER2)(CUR$.SL$)),419,q.symb);
                                    TRACE_END_STM$("CompoundStatement1575",1575);
                                }
                            } // END SWITCH STATEMENT
                            // JavaLine 1491 ==> SourceLine 1577
                            if((exptop.ctype==(((CHECKER2)(CUR$.SL$)).IIDN))) {
                                new CHECKER1$semchecker1$checkasexp(((CHECKER2$semchecker)CUR$),((CHECKER1$semchecker1$identifier)(exptop)));
                            }
                            // JavaLine 1495 ==> SourceLine 1578
                            exptop.cl=IEEXPcl;
                            // JavaLine 1497 ==> SourceLine 1579
                            new CHECKER1$semchecker1$exp$emit(exptop);
                            // JavaLine 1499 ==> SourceLine 1580
                            if((exptop.type!=(((CHECKER2)(CUR$.SL$)).IINTG))) {
                                new CHECKER1$semchecker1$MaybeConvert(((CHECKER2$semchecker)CUR$),((CHECKER2)(CUR$.SL$)).IINTG,exptop.type);
                            }
                            // JavaLine 1503 ==> SourceLine 1581
                            new CHECKER1$semchecker1$popExpStack(((CHECKER2$semchecker)CUR$));
                            // JavaLine 1505 ==> SourceLine 1582
                            if((((CHECKER2)(CUR$.SL$)).opn==(((CHECKER2)(CUR$.SL$)).IARDE))) {
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1582",1582);
                                    inarraybound=false;
                                    q=null;
                                    TRACE_END_STM$("CompoundStatement1582",1582);
                                }
                            }
                            // JavaLine 1514 ==> SourceLine 1583
                            GOTO$(OPNOUT); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1569",1583);
                        }
                        case 65: 
                        // JavaLine 1519 ==> SourceLine 1587
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1587",1587);
                            new CHECKER2$semchecker$getlastblno(((CHECKER2$semchecker)CUR$));
                            TRACE_END_STM$("CompoundStatement1587",1587);
                        }
                        case 133: 
                        // JavaLine 1526 ==> SourceLine 1592
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1592",1592);
                            ((CHECKER2)(CUR$.SL$)).linenr=((rank(loadChar(L2buf,L2p))*(256))+(rank(loadChar(L2buf,(L2p+(1))))));
                            // JavaLine 1530 ==> SourceLine 1594
                            L2p=(L2p+(2));
                            // JavaLine 1532 ==> SourceLine 1595
                            if((((CHECKER2)(CUR$.SL$)).option.Elt[rank('L')-((CHECKER2)(CUR$.SL$)).option.LB[0]]!=(((CHECKER2)(CUR$.SL$)).NUL))) {
                                // JavaLine 1534 ==> SourceLine 1597
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1597",1597);
                                    sysout().outchar('!');
                                    sysout().outint(((CHECKER2)(CUR$.SL$)).linenr,4);
                                    TRACE_END_STM$("CompoundStatement1597",1597);
                                }
                            }
                            TRACE_END_STM$("CompoundStatement1592",1597);
                        }
                        case 141: 
                        // JavaLine 1545 ==> SourceLine 1602
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1602",1602);
                            ((CHECKER2)(CUR$.SL$)).ssnuma=((rank(loadChar(L2buf,L2p))*(256))+(rank(loadChar(L2buf,(L2p+(1))))));
                            // JavaLine 1549 ==> SourceLine 1603
                            L2p=(L2p+(2));
                            // JavaLine 1551 ==> SourceLine 1604
                            ((CHECKER2)(CUR$.SL$)).opdhi=loadChar(L2buf,L2p);
                            ((CHECKER2)(CUR$.SL$)).opdlo=loadChar(L2buf,(L2p+(1)));
                            // JavaLine 1554 ==> SourceLine 1605
                            new CHECKER2$semchecker$getOpd(((CHECKER2$semchecker)CUR$));
                            // JavaLine 1556 ==> SourceLine 1613
                            if((((CHECKER2)(CUR$.SL$)).ssnuma==(256))) {
                                ((CHECKER2)(CUR$.SL$)).BoundCheck=(((CHECKER2)(CUR$.SL$)).opdlo!=(((CHECKER2)(CUR$.SL$)).NUL));
                            } else
                            // JavaLine 1560 ==> SourceLine 1614
                            if((((CHECKER2)(CUR$.SL$)).ssnuma==(257))) {
                                ((CHECKER2)(CUR$.SL$)).NoneCheck=(((CHECKER2)(CUR$.SL$)).opdlo!=(((CHECKER2)(CUR$.SL$)).NUL));
                            } else
                            // JavaLine 1564 ==> SourceLine 1615
                            if((((CHECKER2)(CUR$.SL$)).ssnuma==(258))) {
                                ((CHECKER2)(CUR$.SL$)).QuaCheck=(((CHECKER2)(CUR$.SL$)).opdlo!=(((CHECKER2)(CUR$.SL$)).NUL));
                            } else
                            // JavaLine 1568 ==> SourceLine 1616
                            if((((CHECKER2)(CUR$.SL$)).ssnuma==(259))) {
                                ((CHECKER2)(CUR$.SL$)).ReuseProc=(((CHECKER2)(CUR$.SL$)).opdlo!=(((CHECKER2)(CUR$.SL$)).NUL));
                            } else
                            // JavaLine 1572 ==> SourceLine 1617
                            if((((CHECKER2)(CUR$.SL$)).ssnuma==(260))) {
                                implNone=(((CHECKER2)(CUR$.SL$)).opdlo!=(((CHECKER2)(CUR$.SL$)).NUL));
                            } else
                            // JavaLine 1576 ==> SourceLine 1618
                            if((((CHECKER2)(CUR$.SL$)).ssnuma==(261))) {
                                ((CHECKER2)(CUR$.SL$)).SportOK=(((CHECKER2)(CUR$.SL$)).opdlo!=(((CHECKER2)(CUR$.SL$)).NUL));
                            } else
                            // JavaLine 1580 ==> SourceLine 1619
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1619",1619);
                                opc=((CHECKER2)(CUR$.SL$)).ISSWB;
                                call(((CHECKER2)(CUR$.SL$)).coder);
                                TRACE_END_STM$("CompoundStatement1619",1619);
                            }
                            TRACE_END_STM$("CompoundStatement1602",1619);
                        }
                        case 88: 
                        // JavaLine 1590 ==> SourceLine 1630
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1630",1630);
                            opc=((CHECKER2)(CUR$.SL$)).IEOP;
                            call(((CHECKER2)(CUR$.SL$)).coder);
                            // JavaLine 1595 ==> SourceLine 1632
                            ((CHECKER2)(CUR$.SL$)).ENDCOMP$0().CPF();
                            TRACE_END_STM$("CompoundStatement1630",1632);
                        }
                        case 123: 
                        // JavaLine 1600 ==> SourceLine 1637
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1637",1637);
                            ((CHECKER2)(CUR$.SL$)).L2INPT.intext(L2buf);
                            L2p=0;
                            TRACE_END_STM$("CompoundStatement1637",1637);
                        }
                        default:
                        // JavaLine 1608 ==> SourceLine 1657
                        new ERRMSG$internerr(((CHECKER2)(CUR$.SL$)),((char)9),1657);
                    } // END SWITCH STATEMENT
                    TRACE_END_STM$("CompoundStatement874",1657);
                }
                   if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
            }
            TRACE_END_STM$("CompoundStatement872",1657);
        }
        // JavaLine 1617 ==> SourceLine 867
        if(inner!=null) {
            inner.STM$();
            TRACE_BEGIN_STM_AFTER_INNER$("semchecker",867);
        }
        break LOOP$;
    }
    catch(LABQNT$ q) {
        CUR$=THIS$;
        if(q.SL$!=CUR$ || q.prefixLevel!=3) {
            CUR$.STATE$=OperationalState.terminated;
            if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
            throw(q);
        }
        if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
        JTX$=q.index; continue LOOP$; // EG. GOTO Lx
    }
}
TRACE_END_STM$("semchecker",867);
}
};
} // End of Constructor
// Class Statements
public CHECKER2$semchecker STM$() { return((CHECKER2$semchecker)CODE$.EXEC$()); }
public CHECKER2$semchecker START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("CHECKER2.DEF","Class semchecker",1,35,12,926,14,958,16,960,18,986,20,1028,22,1097,24,1106,26,1107,28,1108,30,1150,32,1175,34,1211,36,1304,38,1324,40,1367,42,1387,44,1421,46,1434,48,1463,50,1499,52,1571,54,889,57,40,59,41,61,42,63,43,65,44,67,46,69,47,71,49,73,50,75,56,77,62,79,92,81,996,83,1017,85,1021,87,1050,89,1289,91,1374,93,1452,95,1471,97,1485,99,1499,101,1519,103,1555,111,56,124,867,126,872,130,874,133,889,137,895,141,900,145,901,147,902,156,903,162,909,166,910,168,911,172,912,177,917,181,918,183,919,188,923,192,924,194,925,203,937,205,926,207,927,211,928,214,929,219,938,221,939,249,948,262,957,265,958,268,960,276,966,280,967,282,968,284,970,292,971,296,972,308,984,311,986,315,988,320,993,324,996,329,997,333,998,337,999,339,1000,341,1001,343,1002,351,1008,361,1014,365,1015,367,1017,372,1019,376,1020,381,1021,385,1022,401,1027,403,1028,406,1029,408,1030,410,1031,417,1038,421,1039,424,1041,429,1046,433,1047,435,1048,437,1049,442,1050,447,1051,454,1052,457,1053,462,1060,466,1061,472,1065,479,1071,483,1072,488,1080,492,1081,497,1087,501,1088,506,1092,516,1096,519,1100,521,1097,523,1098,528,1099,534,1100,536,1106,540,1107,544,1108,551,1113,555,1114,561,1118,565,1119,567,1120,573,1124,577,1125,582,1130,586,1131,591,1136,595,1137,600,1143,611,1150,620,1154,626,1155,629,1156,631,1157,636,1158,645,1159,651,1160,653,1161,659,1167,666,1172,670,1173,672,1176,674,1175,676,1176,687,1181,691,1182,696,1187,700,1188,711,1194,718,1199,726,1205,730,1206,735,1211,741,1212,745,1213,747,1219,755,1221,766,1234,770,1235,776,1241,784,1251,788,1252,793,1253,799,1254,801,1255,803,1256,809,1257,811,1258,813,1259,817,1260,823,1265,827,1266,832,1267,838,1268,840,1269,844,1270,846,1271,849,1272,855,1279,862,1284,868,1286,870,1288,877,1289,879,1291,883,1292,885,1293,894,1298,899,1303,903,1304,906,1306,908,1307,913,1313,917,1314,922,1319,926,1320,932,1324,937,1325,939,1326,941,1327,943,1329,945,1335,947,1336,956,1337,961,1342,965,1343,967,1344,972,1350,976,1351,982,1354,989,1362,993,1363,996,1364,999,1365,1002,1366,1005,1368,1012,1372,1014,1374,1021,1375,1028,1378,1038,1385,1041,1386,1044,1388,1054,1393,1056,1394,1060,1395,1066,1399,1070,1400,1072,1401,1074,1402,1083,1403,1087,1404,1090,1406,1092,1409,1096,1411,1098,1412,1102,1413,1108,1414,1117,1415,1122,1419,1126,1420,1128,1421,1131,1422,1133,1423,1137,1424,1139,1425,1147,1426,1151,1427,1155,1429,1161,1431,1165,1433,1167,1434,1170,1435,1172,1436,1179,1442,1183,1443,1185,1444,1190,1448,1194,1449,1196,1450,1198,1451,1200,1452,1205,1453,1211,1454,1213,1455,1225,1457,1230,1463,1235,1464,1240,1468,1244,1470,1249,1471,1251,1472,1264,1479,1269,1480,1274,1485,1281,1486,1287,1487,1290,1488,1292,1489,1296,1490,1298,1491,1306,1497,1309,1502,1311,1499,1316,1500,1321,1501,1329,1508,1336,1509,1339,1510,1341,1511,1343,1512,1345,1513,1352,1518,1356,1519,1361,1520,1365,1521,1368,1522,1373,1524,1378,1529,1382,1530,1385,1531,1392,1536,1396,1537,1398,1538,1400,1539,1404,1540,1406,1541,1408,1543,1411,1544,1417,1548,1421,1549,1426,1551,1428,1552,1432,1555,1439,1556,1443,1557,1445,1558,1451,1560,1462,1564,1468,1569,1472,1576,1474,1571,1483,1575,1491,1577,1495,1578,1497,1579,1499,1580,1503,1581,1505,1582,1514,1583,1519,1587,1526,1592,1530,1594,1532,1595,1534,1597,1545,1602,1549,1603,1551,1604,1554,1605,1556,1613,1560,1614,1564,1615,1568,1616,1572,1617,1576,1618,1580,1619,1590,1630,1595,1632,1600,1637,1608,1657,1617,867,1641,1665);
}
