package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:19:29 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr13$new_elt extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public char p$opn;
    simerr13$Coder inspect$14$0=null;
    simerr13$Coder$elt inspect$16$1=null;
    private int $npar=0; // Number of actual parameters transmitted.
    public simerr13$new_elt setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$opn=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simerr13$new_elt(RTObject$ SL$)
    { super(SL$); }
    public simerr13$new_elt(RTObject$ SL$,char sp$opn) {
        super(SL$);
        this.p$opn = sp$opn;
        BBLK();
        STM$();
    }
    public simerr13$new_elt STM$() {
        {
            inspect$14$0=((simerr13)(CUR$.SL$)).forcoder;
            if(inspect$14$0!=null)
            {
                inspect$16$1=new simerr13$Coder$elt(inspect$14$0).STM$();
                if(inspect$16$1!=null)
                {
                    inspect$16$1.x=44;
                }
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr13.sim","Procedure new_elt",1,13,9,14,11,16,33,14,37,16,41,18,49,20);
}
