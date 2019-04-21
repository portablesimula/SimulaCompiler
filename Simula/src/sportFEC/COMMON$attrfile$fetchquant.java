package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Apr 14 09:36:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$attrfile$fetchquant extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    final LABQNT$ SETID=new LABQNT$(this,1,"SETID");
    final LABQNT$ SETDID=new LABQNT$(this,2,"SETDID");
    final LABQNT$ CHCKMARK=new LABQNT$(this,3,"CHCKMARK");
    final LABQNT$ GETARR=new LABQNT$(this,4,"GETARR");
    final LABQNT$ xyMark=new LABQNT$(this,5,"xyMark");
    final LABQNT$ NOMORE=new LABQNT$(this,6,"NOMORE");
    boolean seen=false;
    char nxtc=0;
    char t0=0;
    char tn=0;
    COMMON$idpack cvis=null;
    TXT$ t=null;
    public COMMON$attrfile$fetchquant(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public COMMON$attrfile$fetchquant STM$() {
        COMMON$attrfile$fetchquant THIS$=(COMMON$attrfile$fetchquant)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                RESULT$=((COMMON$attrfile)(CUR$.SL$)).xthisused=((COMMON$attrfile)(CUR$.SL$)).xhascode=false;
                ((COMMON$attrfile)(CUR$.SL$)).xftag=((COMMON$attrfile)(CUR$.SL$)).xdim=((COMMON$attrfile)(CUR$.SL$)).xlanguage=((COMMON$attrfile)(CUR$.SL$)).xextident=0;
                ((COMMON$attrfile)(CUR$.SL$)).xprotect=((COMMON$attrfile)(CUR$.SL$)).xspecial=((COMMON$attrfile)(CUR$.SL$)).xconnests=((COMMON$attrfile)(CUR$.SL$)).xarrhi=((COMMON$attrfile)(CUR$.SL$)).xarrlo=((COMMON$attrfile)(CUR$.SL$)).xcheckhi=((COMMON$attrfile)(CUR$.SL$)).xchecklo=((COMMON$attrfile)(CUR$.SL$)).xmodulhi=((COMMON$attrfile)(CUR$.SL$)).xmodullo=((COMMON$attrfile)(CUR$.SL$)).xprefqhi=((COMMON$attrfile)(CUR$.SL$)).xprefqlo=((COMMON$attrfile)(CUR$.SL$)).xinrtag=((COMMON$attrfile)(CUR$.SL$)).xlongindic=((COMMON)(CUR$.SL$.SL$)).NUL;
                ((COMMON$attrfile)(CUR$.SL$)).xhidlist=null;
                ((COMMON$attrfile)(CUR$.SL$)).xcateg=((COMMON$attrfile)(CUR$.SL$)).key;
                if(VALUE$((((COMMON$attrfile)(CUR$.SL$)).xcateg>=(((char)8))))) {
                    {
                        ((COMMON$attrfile)(CUR$.SL$)).xkind=char$((rank(((COMMON$attrfile)(CUR$.SL$)).key)/(8)));
                        ((COMMON$attrfile)(CUR$.SL$)).xcateg=char$(mod(rank(((COMMON$attrfile)(CUR$.SL$)).key),8));
                    }
                } else
                ((COMMON$attrfile)(CUR$.SL$)).xkind=((COMMON)(CUR$.SL$.SL$)).NUL;
                ((COMMON$attrfile)(CUR$.SL$)).xtype=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                if(VALUE$((((COMMON$attrfile)(CUR$.SL$)).xtype>=(((char)128))))) {
                    {
                        ((COMMON$attrfile)(CUR$.SL$)).xtype=char$((rank(((COMMON$attrfile)(CUR$.SL$)).xtype)-(128)));
                        ((COMMON$attrfile)(CUR$.SL$)).key=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                        ((COMMON)(CUR$.SL$.SL$)).simsymbol=TXT$.sub(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,(((COMMON$attrfile)(CUR$.SL$)).p+(2)),rank(((COMMON$attrfile)(CUR$.SL$)).key));
                        new COMMON$DEFIDENT(((COMMON)(CUR$.SL$.SL$)));
                        ((COMMON$attrfile)(CUR$.SL$)).p=((((COMMON$attrfile)(CUR$.SL$)).p+(1))+(rank(((COMMON$attrfile)(CUR$.SL$)).key)));
                        ((COMMON$attrfile)(CUR$.SL$)).xprefqhi=((COMMON)(CUR$.SL$.SL$)).hashhi;
                        ((COMMON$attrfile)(CUR$.SL$)).xprefqlo=((COMMON)(CUR$.SL$.SL$)).hashlo;
                    }
                }
                ((COMMON$attrfile)(CUR$.SL$)).xclf=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                if(VALUE$((((COMMON$attrfile)(CUR$.SL$)).xclf>=(((char)128))))) {
                    {
                        RESULT$=true;
                        ((COMMON$attrfile)(CUR$.SL$)).xclf=char$((rank(((COMMON$attrfile)(CUR$.SL$)).xclf)-(128)));
                        if(VALUE$(((COMMON$attrfile)(CUR$.SL$)).sysattrfile)) {
                        } else
                        ((COMMON$attrfile)(CUR$.SL$)).xftag=(new COMMON$attrfile$nextNumber(((COMMON$attrfile)(CUR$.SL$))).RESULT$-(1));
                        GOTO$(SETDID);
                    }
                }
                ((COMMON$attrfile)(CUR$.SL$)).xftag=(new COMMON$attrfile$nextNumber(((COMMON$attrfile)(CUR$.SL$))).RESULT$-(1));
                ((COMMON$attrfile)(CUR$.SL$)).key=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                if(VALUE$((((COMMON$attrfile)(CUR$.SL$)).key!=(((COMMON)(CUR$.SL$.SL$)).NUL)))) {
                    {
                        ((COMMON)(CUR$.SL$.SL$)).simsymbol=((COMMON$attrfile)(CUR$.SL$)).xidentstring=TXT$.sub(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,(((COMMON$attrfile)(CUR$.SL$)).p+(1)),rank(((COMMON$attrfile)(CUR$.SL$)).key));
                        ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(rank(((COMMON$attrfile)(CUR$.SL$)).key)));
                        if(VALUE$((((COMMON$attrfile)(CUR$.SL$)).xkind==(((COMMON)(CUR$.SL$.SL$)).K_class)))) {
                            {
                                if(VALUE$(((((COMMON$attrfile)(CUR$.SL$)).xclf==(((COMMON)(CUR$.SL$.SL$)).Clf004))|((((COMMON$attrfile)(CUR$.SL$)).xclf==(((COMMON)(CUR$.SL$.SL$)).Clf009)))))) {
                                    ((COMMON$attrfile)(CUR$.SL$)).xhascode=true;
                                }
                                new COMMON$DEFIDENT(((COMMON)(CUR$.SL$.SL$)));
                                GOTO$(SETID);
                            }
                        }
                        if(VALUE$(new COMMON$LOOKUPid(((COMMON)(CUR$.SL$.SL$))).RESULT$)) {
                            {
                                LABEL$(1,"SETID");
                                RESULT$=true;
                                ((COMMON$attrfile)(CUR$.SL$)).xident=new COMMON$boxof(((COMMON)(CUR$.SL$.SL$)),((COMMON)(CUR$.SL$.SL$)).hashhi,((COMMON)(CUR$.SL$.SL$)).hashlo).RESULT$;
                            }
                        } else
                        {
                            ((COMMON$attrfile)(CUR$.SL$)).xident=null;
                        }
                    }
                } else
                LABEL$(2,"SETDID");
                ((COMMON$attrfile)(CUR$.SL$)).xident=((COMMON)(CUR$.SL$.SL$)).dummyBox;
                LABEL$(3,"CHCKMARK");
                ((COMMON$attrfile)(CUR$.SL$)).key=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                if(VALUE$((((COMMON$attrfile)(CUR$.SL$)).key>=(((COMMON$attrfile)(CUR$.SL$)).lowKey)))) {
                    {
                        switch(((COMMON$attrfile)(CUR$.SL$)).key) { // BEGIN SWITCH STATEMENT
                        case 241: 
                        {
                            RESULT$=true;
                            GOTO$(CHCKMARK);
                        }
                        case 249: 
                        {
                            ((COMMON$attrfile)(CUR$.SL$)).xprotect=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                            ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                            GOTO$(CHCKMARK);
                        }
                        case 242: 
                        {
                            ((COMMON$attrfile)(CUR$.SL$)).xdim=rank(loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p));
                            ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                            GOTO$(CHCKMARK);
                        }
                        case 243: 
                        {
                            ((COMMON$attrfile)(CUR$.SL$)).xlongindic=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                            ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                            GOTO$(CHCKMARK);
                        }
                        case 244: 
                        {
                            if(VALUE$((((COMMON$attrfile)(CUR$.SL$)).xkind==(((COMMON)(CUR$.SL$.SL$)).K_rep)))) {
                                {
                                    ((COMMON$attrfile)(CUR$.SL$)).xlanguage=new COMMON$attrfile$nextNumber(((COMMON$attrfile)(CUR$.SL$))).RESULT$;
                                    ((COMMON$attrfile)(CUR$.SL$)).xextident=new COMMON$attrfile$nextNumber(((COMMON$attrfile)(CUR$.SL$))).RESULT$;
                                    GOTO$(CHCKMARK);
                                }
                            }
                            ((COMMON$attrfile)(CUR$.SL$)).xspecial=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                            ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                            if(VALUE$((((COMMON$attrfile)(CUR$.SL$)).xspecial>(((char)128))))) {
                                {
                                    ((COMMON$attrfile)(CUR$.SL$)).xspecial=char$((rank(((COMMON$attrfile)(CUR$.SL$)).xspecial)-(128)));
                                    ((COMMON$attrfile)(CUR$.SL$)).xarrlo=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                                    ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                                }
                            } else
                            {
                                LABEL$(4,"GETARR");
                                new COMMON$attrfile$gettext(((COMMON$attrfile)(CUR$.SL$)));
                                new COMMON$DEFCONST(((COMMON)(CUR$.SL$.SL$)));
                                ((COMMON$attrfile)(CUR$.SL$)).xarrhi=((COMMON)(CUR$.SL$.SL$)).hashhi;
                                ((COMMON$attrfile)(CUR$.SL$)).xarrlo=((COMMON)(CUR$.SL$.SL$)).hashlo;
                            }
                            GOTO$(CHCKMARK);
                        }
                        case 246: 
                        {
                            new COMMON$attrfile$gettext(((COMMON$attrfile)(CUR$.SL$)));
                            new COMMON$DEFCONST(((COMMON)(CUR$.SL$.SL$)));
                            ((COMMON$attrfile)(CUR$.SL$)).xmodulhi=((COMMON)(CUR$.SL$.SL$)).hashhi;
                            ((COMMON$attrfile)(CUR$.SL$)).xmodullo=((COMMON)(CUR$.SL$.SL$)).hashlo;
                            new COMMON$attrfile$gettext(((COMMON$attrfile)(CUR$.SL$)));
                            new COMMON$DEFCONST(((COMMON)(CUR$.SL$.SL$)));
                            ((COMMON$attrfile)(CUR$.SL$)).xcheckhi=((COMMON)(CUR$.SL$.SL$)).hashhi;
                            ((COMMON$attrfile)(CUR$.SL$)).xchecklo=((COMMON)(CUR$.SL$.SL$)).hashlo;
                            LABEL$(5,"xyMark");
                            new COMMON$attrfile$gettext(((COMMON$attrfile)(CUR$.SL$)));
                            new COMMON$DEFIDENT(((COMMON)(CUR$.SL$.SL$)));
                            ((COMMON$attrfile)(CUR$.SL$)).xlanguage=((rank(((COMMON)(CUR$.SL$.SL$)).hashhi)*(256))+(rank(((COMMON)(CUR$.SL$.SL$)).hashlo)));
                            new COMMON$attrfile$gettext(((COMMON$attrfile)(CUR$.SL$)));
                            new COMMON$DEFCONST(((COMMON)(CUR$.SL$.SL$)));
                            ((COMMON$attrfile)(CUR$.SL$)).xextident=((rank(((COMMON)(CUR$.SL$.SL$)).hashhi)*(256))+(rank(((COMMON)(CUR$.SL$.SL$)).hashlo)));
                            GOTO$(CHCKMARK);
                        }
                        case 245: 
                        {
                            GOTO$(xyMark);
                        }
                        case 247: 
                        {
                            ((COMMON$attrfile)(CUR$.SL$)).xconnests=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                            ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                            GOTO$(CHCKMARK);
                        }
                        case 240: 
                        {
                            nxtc=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                            ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                            if(VALUE$((nxtc>=('@')))) {
                                {
                                    ((COMMON$attrfile)(CUR$.SL$)).xthisused=true;
                                    nxtc=char$((rank(nxtc)-(64)));
                                }
                            }
                            if(VALUE$((nxtc>=(((char)32))))) {
                                {
                                    ((COMMON$attrfile)(CUR$.SL$)).xhascode=true;
                                    nxtc=char$((rank(nxtc)-(32)));
                                }
                            }
                            ((COMMON$attrfile)(CUR$.SL$)).xinrtag=nxtc;
                            GOTO$(CHCKMARK);
                        }
                        case 254: 
                        {
                            new COMMON$attrfile$swapIbuffer(((COMMON$attrfile)(CUR$.SL$)));
                            GOTO$(CHCKMARK);
                        }
                        case 248: 
                        {
                            cvis=((COMMON$attrfile)(CUR$.SL$)).xhidlist=new COMMON$idpack(((COMMON)(CUR$.SL$.SL$))).STM$();
                            while((((COMMON$attrfile)(CUR$.SL$)).key==(((COMMON$attrfile)(CUR$.SL$)).hidMark))) {
                                {
                                    cvis=cvis.next=new COMMON$idpack(((COMMON)(CUR$.SL$.SL$))).STM$();
                                    new COMMON$attrfile$gettext(((COMMON$attrfile)(CUR$.SL$)));
                                    new COMMON$DEFIDENT(((COMMON)(CUR$.SL$.SL$)));
                                    cvis.idhi=((COMMON)(CUR$.SL$.SL$)).hashhi;
                                    cvis.idlo=((COMMON)(CUR$.SL$.SL$)).hashlo;
                                    cvis.line=1;
                                    new COMMON$attrfile$nextKey(((COMMON$attrfile)(CUR$.SL$)));
                                }
                            }
                            ((COMMON$attrfile)(CUR$.SL$)).xhidlist=((COMMON$attrfile)(CUR$.SL$)).xhidlist.next;
                        }
                        default:
                    } // END SWITCH STATEMENT
                }
            }
            LABEL$(6,"NOMORE");
            break LOOP$;
        }
        catch(LABQNT$ q) {
            CUR$=THIS$;
            if(q.SL$!=CUR$) {
                CUR$.STATE$=OperationalState.terminated;
                throw(q);
            }
            JTX$=q.index; continue LOOP$;
        }
    }
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure fetchquant",1,1378,10,1438,12,1442,14,1444,16,1478,18,1491,20,1561,22,1379,24,1381,26,1382,29,1383,31,1384,43,1388,45,1389,47,1390,49,1395,51,1398,53,1399,55,1400,58,1401,62,1402,64,1404,67,1405,69,1406,72,1407,74,1408,77,1409,79,1410,84,1413,87,1415,89,1417,92,1418,94,1419,97,1420,99,1421,103,1424,105,1426,108,1427,110,1428,113,1429,115,1430,117,1431,122,1434,127,1435,129,1438,136,1440,142,1442,145,1444,149,1445,151,1446,155,1449,158,1450,162,1454,166,1455,170,1459,174,1460,178,1464,182,1465,186,1469,189,1470,193,1471,197,1473,200,1474,202,1475,205,1476,210,1478,215,1479,219,1480,223,1485,227,1486,230,1488,233,1489,236,1491,240,1492,242,1494,245,1495,247,1496,251,1500,256,1504,260,1505,264,1509,268,1510,270,1511,276,1512,278,1513,284,1515,286,1516,290,1520,296,1524,299,1525,301,1526,304,1527,307,1528,310,1529,312,1530,316,1532,323,1561,338,1561);
}
