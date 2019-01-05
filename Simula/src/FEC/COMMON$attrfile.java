// JavaLine 1 ==> SourceLine 1210
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 15:03:20 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$attrfile extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=1210, lastLine=1563, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 1211
    public final char layoutindex=((char)2);
    // JavaLine 13 ==> SourceLine 1213
    public final int bufsize=2048;
    public final int bufmax=2023;
    // JavaLine 16 ==> SourceLine 1218
    public final char longSwap=((char)255);
    // JavaLine 18 ==> SourceLine 1219
    public final char bufSwap=((char)254);
    // JavaLine 20 ==> SourceLine 1220
    public final char longText=((char)253);
    // JavaLine 22 ==> SourceLine 1221
    public final char mainKey=((char)252);
    // JavaLine 24 ==> SourceLine 1222
    public final char begList=((char)251);
    // JavaLine 26 ==> SourceLine 1223
    public final char endlist=((char)250);
    // JavaLine 28 ==> SourceLine 1224
    public final char protMark=((char)249);
    // JavaLine 30 ==> SourceLine 1225
    public final char hidMark=((char)248);
    // JavaLine 32 ==> SourceLine 1226
    public final char nestMark=((char)247);
    // JavaLine 34 ==> SourceLine 1227
    public final char xMark=((char)246);
    // JavaLine 36 ==> SourceLine 1228
    public final char yMark=((char)245);
    // JavaLine 38 ==> SourceLine 1229
    public final char specMark=((char)244);
    // JavaLine 40 ==> SourceLine 1230
    public final char overMark=((char)243);
    // JavaLine 42 ==> SourceLine 1231
    public final char dimMark=((char)242);
    // JavaLine 44 ==> SourceLine 1232
    public final char forcMark=((char)241);
    // JavaLine 46 ==> SourceLine 1233
    public final char thisMark=((char)240);
    // JavaLine 48 ==> SourceLine 1234
    public final char lowKey=((char)240);
    public final char hikey=((char)255);
    // JavaLine 51 ==> SourceLine 1236
    public boolean sysattrfile=false;
    // JavaLine 53 ==> SourceLine 1237
    public boolean xthisused=false;
    public boolean xhascode=false;
    // JavaLine 56 ==> SourceLine 1238
    public char xprotect=0;
    public char xtype=0;
    public char xkind=0;
    public char xcateg=0;
    public char xspecial=0;
    public char xclf=0;
    public char xlongindic=0;
    // JavaLine 64 ==> SourceLine 1239
    public char xinrtag=0;
    public char xconnests=0;
    public char xprefqhi=0;
    public char xprefqlo=0;
    // JavaLine 69 ==> SourceLine 1240
    public char xarrhi=0;
    public char xarrlo=0;
    public char xcheckhi=0;
    public char xchecklo=0;
    public char attrckhi=0;
    public char attrcklo=0;
    // JavaLine 76 ==> SourceLine 1241
    public char xmodulhi=0;
    public char xmodullo=0;
    public char attrmodhi=0;
    public char attrmodlo=0;
    // JavaLine 81 ==> SourceLine 1242
    public char key=0;
    // JavaLine 83 ==> SourceLine 1243
    public int xdim=0;
    public int xlanguage=0;
    public int xextident=0;
    // JavaLine 87 ==> SourceLine 1244
    public int xtagnum=0;
    // JavaLine 89 ==> SourceLine 1245
    public int xftag=0;
    // JavaLine 91 ==> SourceLine 1246
    public int p=0;
    // JavaLine 93 ==> SourceLine 1247
    public InbyteFile$ CURF=null;
    // JavaLine 95 ==> SourceLine 1248
    public OutbyteFile$ AOF=null;
    // JavaLine 97 ==> SourceLine 1249
    public COMMON$idpack xhidlist=null;
    // JavaLine 99 ==> SourceLine 1250
    public COMMON$symbolbox xident=null;
    // JavaLine 101 ==> SourceLine 1251
    public COMMON$quantity mainqnt=null;
    // JavaLine 103 ==> SourceLine 1252
    public TXT$ xidentstring=null;
    // JavaLine 105 ==> SourceLine 1253
    public TXT$ attrbuffer=null;
    // Normal Constructor
    public COMMON$attrfile(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("attrfile",1561);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("attrfile",1561,inner);
                // JavaLine 118 ==> SourceLine 1563
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("attrfile",1563);
                }
                TRACE_END_STM$("attrfile",1563);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public COMMON$attrfile STM$() { return((COMMON$attrfile)CODE$.EXEC$()); }
    public COMMON$attrfile START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class attrfile",1,1210,11,1211,13,1213,16,1218,18,1219,20,1220,22,1221,24,1222,26,1223,28,1224,30,1225,32,1226,34,1227,36,1228,38,1229,40,1230,42,1231,44,1232,46,1233,48,1234,51,1236,53,1237,56,1238,64,1239,69,1240,76,1241,81,1242,83,1243,87,1244,89,1245,91,1246,93,1247,95,1248,97,1249,99,1250,101,1251,103,1252,105,1253,118,1563,130,1563);
}
