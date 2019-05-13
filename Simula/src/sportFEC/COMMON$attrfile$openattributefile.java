package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:36 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$attrfile$openattributefile extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public COMMON$quantity p$q;
    TXT$ t=null;
    TXT$ id=null;
    TXT$ xid=null;
    TXT$ simsepmod=null;
    int firstbufsize=0;
    COMMON$quantity inspect$1262$2=null;
    InbyteFile$ inspect$1277$3=null;
    private int $npar=0; // Number of actual parameters transmitted.
    public COMMON$attrfile$openattributefile setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$q=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public COMMON$attrfile$openattributefile(RTObject$ SL$)
    { super(SL$); }
    public COMMON$attrfile$openattributefile(RTObject$ SL$,COMMON$quantity sp$q) {
        super(SL$);
        this.p$q = sp$q;
        BBLK();
        STM$();
    }
    public COMMON$attrfile$openattributefile STM$() {
        {
            inspect$1262$2=p$q;
            if(inspect$1262$2!=null)
            {
                id=inspect$1262$2.symb$1.symbol;
                xid=new COMMON$getBox(((COMMON)(CUR$.SL$.SL$)),inspect$1262$2.virtno$1).RESULT$.symbol;
                if(VALUE$(TXTREL$EQ(id,new TXT$("_predefmodule")))) {
                    t=copy(copy(((COMMON)(CUR$.SL$.SL$)).predefname));
                } else
                if(VALUE$((TXTREL$EQ(id,new TXT$("simset"))&&((TXTREL$EQ(xid,new TXT$("?"))|(TXTREL$EQ(xid,null))))))) {
                    t=copy(copy(((COMMON)(CUR$.SL$.SL$)).simsetname));
                } else
                if(VALUE$((TXTREL$EQ(id,new TXT$("simulation"))&((TXTREL$EQ(xid,new TXT$("?"))|(TXTREL$EQ(xid,null))))))) {
                    t=copy(copy(((COMMON)(CUR$.SL$.SL$)).simulaname));
                } else
                {
                    giveTextInfo(2,id);
                    giveTextInfo(3,((TXTREL$EQ(xid,new TXT$("?")))?(null):(xid)));
                    t=getTextInfo(12);
                }
            }
            else
            t=((COMMON)(CUR$.SL$.SL$)).attrfilename;
        }
        {
            inspect$1277$3=new InbyteFile$(((BASICIO$)CTX$),t).STM$();
            if(inspect$1277$3!=null)
            {
                inspect$1277$3.setaccess(new TXT$("%nobuffer"));
                if(VALUE$((!(inspect$1277$3.open())))) {
                    {
                        ((COMMON)(CUR$.SL$.SL$)).diag.Elt[0-((COMMON)(CUR$.SL$.SL$)).diag.LB[0]]=t;
                        ((COMMON)(CUR$.SL$.SL$)).COMMONerror$0().CPF().setPar(336).ENT$();
                    }
                }
                ((COMMON$attrfile)(CUR$.SL$)).CURF=((InbyteFile$)inspect$1277$3);
                if(VALUE$((char$(inspect$1277$3.inbyte())!=(((COMMON$attrfile)(CUR$.SL$)).layoutindex)))) {
                    new COMMON$attrfile$wrongLayout(((COMMON$attrfile)(CUR$.SL$)));
                }
                firstbufsize=inspect$1277$3.in2byte();
                inspect$1277$3.intext(TXT$.sub(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,1,firstbufsize));
            }
        }
        if(VALUE$(TXTREL$NE(TXT$.sub(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,1,7),new TXT$("S-port ")))) {
            new COMMON$attrfile$wrongLayout(((COMMON$attrfile)(CUR$.SL$)));
        }
        ((COMMON$attrfile)(CUR$.SL$)).sysattrfile=(loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,10)==(':'));
        ((COMMON$attrfile)(CUR$.SL$)).p=12;
        new COMMON$attrfile$gettext(((COMMON$attrfile)(CUR$.SL$)));
        new COMMON$DEFCONST(((COMMON)(CUR$.SL$.SL$)));
        ((COMMON$attrfile)(CUR$.SL$)).attrckhi=((COMMON)(CUR$.SL$.SL$)).hashhi;
        ((COMMON$attrfile)(CUR$.SL$)).attrcklo=((COMMON)(CUR$.SL$.SL$)).hashlo;
        new COMMON$attrfile$gettext(((COMMON$attrfile)(CUR$.SL$)));
        new COMMON$DEFCONST(((COMMON)(CUR$.SL$.SL$)));
        ((COMMON$attrfile)(CUR$.SL$)).attrmodhi=((COMMON)(CUR$.SL$.SL$)).hashhi;
        ((COMMON$attrfile)(CUR$.SL$)).attrmodlo=((COMMON)(CUR$.SL$.SL$)).hashlo;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure openattributefile",1,1258,9,1261,15,1262,17,1277,39,1262,43,1263,46,1264,48,1265,52,1266,54,1267,57,1268,59,1269,62,1271,65,1273,67,1274,72,1276,75,1277,79,1278,82,1279,89,1280,91,1283,93,1284,96,1285,98,1286,102,1289,106,1290,108,1292,110,1293,113,1294,116,1295,119,1296,124,1297);
}
