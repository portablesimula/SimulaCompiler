package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:32:51 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK12$Warehouse$UpdateReport extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public Docking$PBLK12$Warehouse$UpdateReport(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Docking$PBLK12$Warehouse$UpdateReport STM$() {
        sysout().outtext(new TXT$("Simulated Time: "));
        sysout().outfix(((Docking$PBLK12$Warehouse)(CUR$.SL$)).time(),2,8);
        sysout().outtext(new TXT$("   Docks: "));
        sysout().outint(((Docking$PBLK12$Warehouse)(CUR$.SL$)).p2$nDocks,3);
        sysout().outtext(new TXT$("   Waiting: "));
        sysout().outfix(((Docking$PBLK12$Warehouse)(CUR$.SL$)).accWait$2,2,8);
        sysout().outtext(new TXT$("   nVans: "));
        sysout().outint(((Docking$PBLK12$Warehouse)(CUR$.SL$)).Totnr$2,3);
        if(VALUE$((((Docking$PBLK12$Warehouse)(CUR$.SL$)).report$2==(null)))) {
            {
                ((Docking$PBLK12)(CUR$.SL$.SL$)).setFontStyleBold();
                ((Docking$PBLK12)(CUR$.SL$.SL$)).setDrawColor(((Docking$PBLK12)(CUR$.SL$.SL$)).black$1);
                ((Docking$PBLK12$Warehouse)(CUR$.SL$)).report$2=new TextElement$(((Docking$PBLK12)(CUR$.SL$.SL$)),TXT$.strip(sysout().image),((double)(50)),((double)((200+((((Docking$PBLK12)(CUR$.SL$.SL$)).cnt$2*(15))))))).STM$();
            }
        } else
        ((Docking$PBLK12$Warehouse)(CUR$.SL$)).report$2.setText(TXT$.strip(sysout().image));
        sysout().outimage();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure UpdateReport",1,186,14,187,17,188,20,189,23,190,26,191,28,193,31,194,33,195,37,196,39,197,43,198);
}
