// JavaLine 1 <== SourceLine 87
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:36:39 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Docking$PBLK12$Warehouse$Van extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=3, firstLine=87, lastLine=167, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public int p3$load;
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 88
    public double waitTime$3=0.0d;
    public Docking$PBLK12$Warehouse$Dock myDock$3=null;
    // JavaLine 16 <== SourceLine 89
    public ShapeElement$ vanShape$3=null;
    // JavaLine 18 <== SourceLine 90
    public int dLine$3=0;
    public final int speed$3=(int)(200);
    // Normal Constructor
    public Docking$PBLK12$Warehouse$Van(RTObject$ staticLink,int sp3$load) {
        super(staticLink);
        // Parameter assignment to locals
        this.p3$load = sp3$load;
        // Declaration Code
        TRACE_BEGIN_DCL$("Van",136);
    }
    // Class Statements
    public Docking$PBLK12$Warehouse$Van STM$() {
        TRACE_BEGIN_STM$("Van",136);
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // Class Process: Code before inner
        // JavaLine 35 <== SourceLine 1
        detach();
        // JavaLine 37 <== SourceLine 142
        // Class Van: Code before inner
        new Docking$PBLK12$trace(((Docking$PBLK12)(CUR$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is entering the scene")));
        // JavaLine 40 <== SourceLine 143
        vanShape$3=new ShapeElement$(((Docking$PBLK12)(CUR$.SL$.SL$))).STM$();
        // JavaLine 42 <== SourceLine 145
        if(VALUE$((((Docking$PBLK12$Warehouse)(CUR$.SL$)).platforms$2.first()==(null)))) {
            // JavaLine 44 <== SourceLine 147
            {
                TRACE_BEGIN_STM$("CompoundStatement147",147);
                waitTime$3=((Docking$PBLK12$Warehouse)(CUR$.SL$)).time();
                // JavaLine 48 <== SourceLine 148
                new Docking$PBLK12$Warehouse$Van$VantoQueue(((Docking$PBLK12$Warehouse$Van)CUR$));
                // JavaLine 50 <== SourceLine 149
                ((Docking$PBLK12$Warehouse)(CUR$.SL$)).wait(((Docking$PBLK12$Warehouse)(CUR$.SL$)).Waiting$2);
                out();
                // JavaLine 53 <== SourceLine 150
                ((Docking$PBLK12$Warehouse)(CUR$.SL$)).accWait$2=((((Docking$PBLK12$Warehouse)(CUR$.SL$)).accWait$2+(((Docking$PBLK12$Warehouse)(CUR$.SL$)).time()))-(waitTime$3));
                TRACE_END_STM$("CompoundStatement147",150);
            }
        }
        // JavaLine 58 <== SourceLine 152
        new Docking$PBLK12$Warehouse$UpdateReport(((Docking$PBLK12$Warehouse)(CUR$.SL$)));
        // JavaLine 60 <== SourceLine 153
        myDock$3=((Docking$PBLK12$Warehouse$Dock)(((Docking$PBLK12$Warehouse)(CUR$.SL$)).platforms$2.first()));
        // JavaLine 62 <== SourceLine 154
        new Docking$PBLK12$Warehouse$Van$VantoPlatform(((Docking$PBLK12$Warehouse$Van)CUR$));
        // JavaLine 64 <== SourceLine 155
        myDock$3.out();
        // JavaLine 66 <== SourceLine 156
        ((Docking$PBLK12$Warehouse)(CUR$.SL$)).hold(((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$)).pTime$2)));
        // JavaLine 68 <== SourceLine 157
        new Docking$PBLK12$Warehouse$Van$VantoUnload(((Docking$PBLK12$Warehouse$Van)CUR$));
        // JavaLine 70 <== SourceLine 158
        waitTime$3=((1000.0d*(((double)(p3$load))))/(((Docking$PBLK12$Warehouse)(CUR$.SL$)).unloadSpeed$2));
        // JavaLine 72 <== SourceLine 159
        ((Docking$PBLK12$Warehouse)(CUR$.SL$)).hold(waitTime$3);
        // JavaLine 74 <== SourceLine 160
        new Docking$PBLK12$Warehouse$Van$VantoWash(((Docking$PBLK12$Warehouse$Van)CUR$));
        // JavaLine 76 <== SourceLine 161
        ((Docking$PBLK12$Warehouse)(CUR$.SL$)).hold(((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$)).washTime$2)));
        // JavaLine 78 <== SourceLine 162
        new Docking$PBLK12$Warehouse$Van$VanFinished(((Docking$PBLK12$Warehouse$Van)CUR$));
        // JavaLine 80 <== SourceLine 163
        myDock$3.into(((Docking$PBLK12$Warehouse)(CUR$.SL$)).platforms$2);
        // JavaLine 82 <== SourceLine 164
        if(VALUE$((((Docking$PBLK12$Warehouse)(CUR$.SL$)).Waiting$2.first()!=(null)))) {
            // JavaLine 84 <== SourceLine 165
            ((Docking$PBLK12$Warehouse)(CUR$.SL$)).ActivateAfter(false,((Process$)(((Docking$PBLK12$Warehouse)(CUR$.SL$)).Waiting$2.first())),((Docking$PBLK12$Warehouse$Van)CUR$));
        }
        // JavaLine 87 <== SourceLine 166
        new Docking$PBLK12$trace(((Docking$PBLK12)(CUR$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is terminating")));
        // JavaLine 89 <== SourceLine 142
        // Class Van: Code after inner
        // Class Process: Code after inner
        // JavaLine 92 <== SourceLine 1
        terminate();
        // JavaLine 94 <== SourceLine 142
        TRACE_END_STM$("Van",142);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Class Van",1,87,13,88,16,89,18,90,35,1,37,142,40,143,42,145,44,147,48,148,50,149,53,150,58,152,60,153,62,154,64,155,66,156,68,157,70,158,72,159,74,160,76,161,78,162,80,163,82,164,84,165,87,166,89,142,92,1,94,142,98,167);
} // End of Class
