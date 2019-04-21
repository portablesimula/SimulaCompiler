package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Apr 14 09:36:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$attrfile extends CLASS$ {
    public int prefixLevel() { return(0); }
    public final char layoutindex=(char)(((char)2));
    public final int bufsize=(int)(2048);
    public final int bufmax=(int)(2023);
    public final char longSwap=(char)(((char)255));
    public final char bufSwap=(char)(((char)254));
    public final char longText=(char)(((char)253));
    public final char mainKey=(char)(((char)252));
    public final char begList=(char)(((char)251));
    public final char endlist=(char)(((char)250));
    public final char protMark=(char)(((char)249));
    public final char hidMark=(char)(((char)248));
    public final char nestMark=(char)(((char)247));
    public final char xMark=(char)(((char)246));
    public final char yMark=(char)(((char)245));
    public final char specMark=(char)(((char)244));
    public final char overMark=(char)(((char)243));
    public final char dimMark=(char)(((char)242));
    public final char forcMark=(char)(((char)241));
    public final char thisMark=(char)(((char)240));
    public final char lowKey=(char)(((char)240));
    public final char hikey=(char)(((char)255));
    public boolean sysattrfile=false;
    public boolean xthisused=false;
    public boolean xhascode=false;
    public char xprotect=0;
    public char xtype=0;
    public char xkind=0;
    public char xcateg=0;
    public char xspecial=0;
    public char xclf=0;
    public char xlongindic=0;
    public char xinrtag=0;
    public char xconnests=0;
    public char xprefqhi=0;
    public char xprefqlo=0;
    public char xarrhi=0;
    public char xarrlo=0;
    public char xcheckhi=0;
    public char xchecklo=0;
    public char attrckhi=0;
    public char attrcklo=0;
    public char xmodulhi=0;
    public char xmodullo=0;
    public char attrmodhi=0;
    public char attrmodlo=0;
    public char key=0;
    public int xdim=0;
    public int xlanguage=0;
    public int xextident=0;
    public int xtagnum=0;
    public int xftag=0;
    public int p=0;
    public InbyteFile$ CURF=null;
    public OutbyteFile$ AOF=null;
    public COMMON$idpack xhidlist=null;
    public COMMON$symbolbox xident=null;
    public COMMON$quantity mainqnt=null;
    public TXT$ xidentstring=null;
    public TXT$ attrbuffer=null;
    public COMMON$attrfile(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("attrfile",1561);
    }
    public COMMON$attrfile STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class attrfile",1,1210,8,1211,10,1213,13,1218,15,1219,17,1220,19,1221,21,1222,23,1223,25,1224,27,1225,29,1226,31,1227,33,1228,35,1229,37,1230,39,1231,41,1232,43,1233,45,1234,48,1236,50,1237,53,1238,61,1239,66,1240,73,1241,78,1242,80,1243,84,1244,86,1245,88,1246,90,1247,92,1248,94,1249,96,1250,98,1251,100,1252,102,1253,110,1563,113,1563);
}
