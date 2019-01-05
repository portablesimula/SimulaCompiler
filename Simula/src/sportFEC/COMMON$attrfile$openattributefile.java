// JavaLine 1 ==> SourceLine 1258
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:41:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$attrfile$openattributefile extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=1258, lastLine=1297, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$quantity p$q;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 1261
    TXT$ t=null;
    TXT$ id=null;
    TXT$ xid=null;
    TXT$ simsepmod=null;
    int firstbufsize=0;
    // JavaLine 18 ==> SourceLine 1262
    COMMON$quantity inspect$1262$2=null;
    // JavaLine 20 ==> SourceLine 1277
    InbyteFile$ inspect$1277$3=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public COMMON$attrfile$openattributefile setPar(Object param) {
        //Util.BREAK("CALL COMMON$attrfile$openattributefile.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$q=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public COMMON$attrfile$openattributefile(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public COMMON$attrfile$openattributefile(RTObject$ SL$,COMMON$quantity sp$q) {
        super(SL$);
        // Parameter assignment to locals
        this.p$q = sp$q;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("openattributefile",1277);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public COMMON$attrfile$openattributefile STM$() {
        TRACE_BEGIN_STM$("openattributefile",1277);
        // JavaLine 51 ==> SourceLine 1262
        {
            // BEGIN INSPECTION 
            inspect$1262$2=p$q;
            if(inspect$1262$2!=null) //INSPECT inspect$1262$2
            // JavaLine 56 ==> SourceLine 1263
            {
                TRACE_BEGIN_STM$("CompoundStatement1263",1263);
                id=inspect$1262$2.symb.symbol;
                // JavaLine 60 ==> SourceLine 1264
                xid=new COMMON$getBox(((COMMON)(CUR$.SL$.SL$)),inspect$1262$2.virtno).RESULT$.symbol;
                // JavaLine 62 ==> SourceLine 1265
                if(TXTREL$EQ(id,new TXT$("_predefmodule"))) {
                    t=copy(copy(((COMMON)(CUR$.SL$.SL$)).predefname));
                } else
                // JavaLine 66 ==> SourceLine 1266
                if((TXTREL$EQ(id,new TXT$("simset"))&&((TXTREL$EQ(xid,new TXT$("?"))|(TXTREL$EQ(xid,null)))))) {
                    // JavaLine 68 ==> SourceLine 1267
                    t=copy(copy(((COMMON)(CUR$.SL$.SL$)).simsetname));
                } else
                // JavaLine 71 ==> SourceLine 1268
                if((TXTREL$EQ(id,new TXT$("simulation"))&((TXTREL$EQ(xid,new TXT$("?"))|(TXTREL$EQ(xid,null)))))) {
                    // JavaLine 73 ==> SourceLine 1269
                    t=copy(copy(((COMMON)(CUR$.SL$.SL$)).simulaname));
                } else
                // JavaLine 76 ==> SourceLine 1271
                {
                    TRACE_BEGIN_STM$("CompoundStatement1271",1271);
                    giveTextInfo(2,id);
                    // JavaLine 80 ==> SourceLine 1273
                    giveTextInfo(3,((TXTREL$EQ(xid,new TXT$("?")))?(null):(xid)));
                    // JavaLine 82 ==> SourceLine 1274
                    t=getTextInfo(12);
                    TRACE_END_STM$("CompoundStatement1271",1274);
                }
                TRACE_END_STM$("CompoundStatement1263",1274);
            }
            else // OTHERWISE 
            // JavaLine 89 ==> SourceLine 1276
            t=((COMMON)(CUR$.SL$.SL$)).attrfilename;
        }
        // JavaLine 92 ==> SourceLine 1277
        {
            // BEGIN INSPECTION 
            inspect$1277$3=new InbyteFile$(((BASICIO$)CTX$),t).STM$();
            if(inspect$1277$3!=null) //INSPECT inspect$1277$3
            // JavaLine 97 ==> SourceLine 1278
            {
                TRACE_BEGIN_STM$("CompoundStatement1278",1278);
                inspect$1277$3.setaccess(new TXT$("%nobuffer"));
                // JavaLine 101 ==> SourceLine 1279
                if((!(inspect$1277$3.open()))) {
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1279",1279);
                        ((COMMON)(CUR$.SL$.SL$)).diag.Elt[0-((COMMON)(CUR$.SL$.SL$)).diag.LB[0]]=t;
                        ((COMMON)(CUR$.SL$.SL$)).COMMONerror$0().CPF().setPar(336).ENT$();
                        TRACE_END_STM$("CompoundStatement1279",1279);
                    }
                }
                // JavaLine 110 ==> SourceLine 1280
                ((COMMON$attrfile)(CUR$.SL$)).CURF=((InbyteFile$)inspect$1277$3);
                // JavaLine 112 ==> SourceLine 1283
                if((char$(inspect$1277$3.inbyte())!=(((COMMON$attrfile)(CUR$.SL$)).layoutindex))) {
                    // JavaLine 114 ==> SourceLine 1284
                    new COMMON$attrfile$wrongLayout(((COMMON$attrfile)(CUR$.SL$)));
                }
                // JavaLine 117 ==> SourceLine 1285
                firstbufsize=inspect$1277$3.in2byte();
                // JavaLine 119 ==> SourceLine 1286
                inspect$1277$3.intext(TXT$.sub(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,1,firstbufsize));
                TRACE_END_STM$("CompoundStatement1278",1286);
            }
        }
        // JavaLine 124 ==> SourceLine 1289
        if(TXTREL$NE(TXT$.sub(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,1,7),new TXT$("S-port "))) {
            new COMMON$attrfile$wrongLayout(((COMMON$attrfile)(CUR$.SL$)));
        }
        // JavaLine 128 ==> SourceLine 1290
        ((COMMON$attrfile)(CUR$.SL$)).sysattrfile=(loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,10)==(':'));
        // JavaLine 130 ==> SourceLine 1292
        ((COMMON$attrfile)(CUR$.SL$)).p=12;
        // JavaLine 132 ==> SourceLine 1293
        new COMMON$attrfile$gettext(((COMMON$attrfile)(CUR$.SL$)));
        new COMMON$DEFCONST(((COMMON)(CUR$.SL$.SL$)));
        // JavaLine 135 ==> SourceLine 1294
        ((COMMON$attrfile)(CUR$.SL$)).attrckhi=((COMMON)(CUR$.SL$.SL$)).hashhi;
        ((COMMON$attrfile)(CUR$.SL$)).attrcklo=((COMMON)(CUR$.SL$.SL$)).hashlo;
        // JavaLine 138 ==> SourceLine 1295
        new COMMON$attrfile$gettext(((COMMON$attrfile)(CUR$.SL$)));
        new COMMON$DEFCONST(((COMMON)(CUR$.SL$.SL$)));
        // JavaLine 141 ==> SourceLine 1296
        ((COMMON$attrfile)(CUR$.SL$)).attrmodhi=((COMMON)(CUR$.SL$.SL$)).hashhi;
        ((COMMON$attrfile)(CUR$.SL$)).attrmodlo=((COMMON)(CUR$.SL$.SL$)).hashlo;
        TRACE_END_STM$("openattributefile",1296);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure openattributefile",1,1258,12,1261,18,1262,20,1277,51,1262,56,1263,60,1264,62,1265,66,1266,68,1267,71,1268,73,1269,76,1271,80,1273,82,1274,89,1276,92,1277,97,1278,101,1279,110,1280,112,1283,114,1284,117,1285,119,1286,124,1289,128,1290,130,1292,132,1293,135,1294,138,1295,141,1296,147,1297);
}
