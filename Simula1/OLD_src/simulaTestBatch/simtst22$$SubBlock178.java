package simulaTestBatch;
// Simula-1.0 Compiled at Thu Oct 03 12:45:10 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst22$$SubBlock178 extends BASICIO$ {
    int i=0;
    public simtst22$$SubBlock178(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
    }
    public RTObject$ STM$() {
        if(VALUE$(((((simtst22$)(CUR$.SL$)).n!=(1))|((i!=(0)))))) {
            {
                sysout().outtext(new TXT$("*** error : Complex For (11)."));
                sysout().outimage();
                sysout().outtext(new TXT$("            Erroneus values :"));
                sysout().outint(i,3);
                sysout().outint(((simtst22$)(CUR$.SL$)).n,3);
                sysout().outimage();
                ((simtst22$)(CUR$.SL$)).found_error=true;
            }
        }
        ((simtst22$)(CUR$.SL$)).n=Math.addExact(((simtst22$)(CUR$.SL$)).n,1);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst22.sim","SubBlock SubBlock178",1,178,13,180,15,182,18,183,20,184,22,185,24,186,26,187,28,188,32,191,36,192);
}
