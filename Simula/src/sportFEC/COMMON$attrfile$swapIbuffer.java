package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:36 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$attrfile$swapIbuffer extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int bufsize=0;
    InbyteFile$ inspect$1337$5=null;
    public COMMON$attrfile$swapIbuffer(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public COMMON$attrfile$swapIbuffer STM$() {
        ((COMMON$attrfile)(CUR$.SL$)).xidentstring=copy(copy(((COMMON$attrfile)(CUR$.SL$)).xidentstring));
        {
            inspect$1337$5=((COMMON$attrfile)(CUR$.SL$)).CURF;
            if(inspect$1337$5!=null)
            {
                if(VALUE$(inspect$1337$5.endfile())) {
                    {
                        ((COMMON)(CUR$.SL$.SL$)).diag.Elt[0-((COMMON)(CUR$.SL$.SL$)).diag.LB[0]]=inspect$1337$5.filename();
                        ((COMMON)(CUR$.SL$.SL$)).COMMONerror$0().CPF().setPar(307).ENT$();
                    }
                }
                bufsize=new COMMON$attrfile$nextNumber(((COMMON$attrfile)(CUR$.SL$))).RESULT$;
                inspect$1337$5.intext(TXT$.sub(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,1,bufsize));
                ((COMMON$attrfile)(CUR$.SL$)).p=0;
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure swapIbuffer",1,1332,8,1333,10,1337,18,1334,20,1337,24,1338,27,1339,33,1340,35,1341,42,1343);
}
