package simulaTestBatch;
// Simula-2.0 Compiled at Fri Sep 03 09:27:42 CEST 2021
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simerr01$$p$simerr01$PBLK48$Car extends Process$ {
    public boolean isDetachUsed() { return(true); }
    public TXT$ p3$pname;
    public simerr01$$p$simerr01$PBLK48$Car(RTObject$ staticLink,TXT$ sp3$pname) {
        super(staticLink);
        this.p3$pname = sp3$pname;
    }
    public simerr01$$p$simerr01$PBLK48$Car STM$() {
        detach();
        new simerr01$$trace((CUR$.SL$.SL$.SL$),CONC(p3$pname,new TXT$(" is initiating")));
        ;
        while(true) {
            {
                new simerr01$$trace((CUR$.SL$.SL$.SL$),CONC(p3$pname,new TXT$(" is active 1")));
                ;
                ((simerr01$PBLK48)(CUR$.SL$)).hold(4.0d);
                ;
                new simerr01$$trace((CUR$.SL$.SL$.SL$),CONC(p3$pname,new TXT$(" is active 2")));
                ;
                GOTO$(((simerr01$PBLK48)(CUR$.SL$)).EXIT_LABEL);
                ;
            }
            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
        }
        ;
        terminate();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr01.sim","Class Car",1,50,14,1,16,52,19,53,21,55,25,56,28,57,31,58,38,1,40,52,43,60);
}
