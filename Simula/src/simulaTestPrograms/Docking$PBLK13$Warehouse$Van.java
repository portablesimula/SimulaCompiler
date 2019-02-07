// JavaLine 1 ==> SourceLine 69
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:37:33 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Docking$PBLK13$Warehouse$Van extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=3, firstLine=69, lastLine=149, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public int p3$load;
    // Declare locals as attributes
    // JavaLine 13 ==> SourceLine 70
    public double waitTime=0.0d;
    public Docking$PBLK13$Warehouse$Dock myDock=null;
    // JavaLine 16 ==> SourceLine 71
    public ShapeElement$ vanShape=null;
    // JavaLine 18 ==> SourceLine 72
    public int dLine=0;
    public final int speed=200;
    // Normal Constructor
    public Docking$PBLK13$Warehouse$Van(RTObject$ staticLink,int sp3$load) {
        super(staticLink);
        // Parameter assignment to locals
        this.p3$load = sp3$load;
        // Declaration Code
        TRACE_BEGIN_DCL$("Van",118);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("Van",118,inner);
                // JavaLine 32 ==> SourceLine 124
                new Docking$PBLK13$trace(((Docking$PBLK13)(CUR$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is entering the scene")));
                // JavaLine 34 ==> SourceLine 125
                vanShape=new ShapeElement$(((Docking$PBLK13)(CUR$.SL$.SL$))).STM$();
                // JavaLine 36 ==> SourceLine 127
                if(VALUE$((((Docking$PBLK13$Warehouse)(CUR$.SL$)).platforms.first()==(null)))) {
                    // JavaLine 38 ==> SourceLine 129
                    {
                        TRACE_BEGIN_STM$("CompoundStatement129",129);
                        waitTime=((Docking$PBLK13$Warehouse)(CUR$.SL$)).time();
                        // JavaLine 42 ==> SourceLine 130
                        new Docking$PBLK13$Warehouse$Van$VantoQueue(((Docking$PBLK13$Warehouse$Van)CUR$));
                        // JavaLine 44 ==> SourceLine 131
                        ((Docking$PBLK13$Warehouse)(CUR$.SL$)).wait(((Docking$PBLK13$Warehouse)(CUR$.SL$)).Waiting);
                        out();
                        // JavaLine 47 ==> SourceLine 132
                        ((Docking$PBLK13$Warehouse)(CUR$.SL$)).accWait=((((Docking$PBLK13$Warehouse)(CUR$.SL$)).accWait+(((Docking$PBLK13$Warehouse)(CUR$.SL$)).time()))-(waitTime));
                        TRACE_END_STM$("CompoundStatement129",132);
                    }
                }
                // JavaLine 52 ==> SourceLine 134
                new Docking$PBLK13$Warehouse$UpdateReport(((Docking$PBLK13$Warehouse)(CUR$.SL$)));
                // JavaLine 54 ==> SourceLine 135
                myDock=((Docking$PBLK13$Warehouse$Dock)(((Docking$PBLK13$Warehouse)(CUR$.SL$)).platforms.first()));
                // JavaLine 56 ==> SourceLine 136
                new Docking$PBLK13$Warehouse$Van$VantoPlatform(((Docking$PBLK13$Warehouse$Van)CUR$));
                // JavaLine 58 ==> SourceLine 137
                myDock.out();
                // JavaLine 60 ==> SourceLine 138
                ((Docking$PBLK13$Warehouse)(CUR$.SL$)).hold(((double)(((Docking$PBLK13$Warehouse)(CUR$.SL$)).pTime)));
                // JavaLine 62 ==> SourceLine 139
                new Docking$PBLK13$Warehouse$Van$VantoUnload(((Docking$PBLK13$Warehouse$Van)CUR$));
                // JavaLine 64 ==> SourceLine 140
                waitTime=((1000.0d*(((double)(p3$load))))/(((Docking$PBLK13$Warehouse)(CUR$.SL$)).unloadSpeed));
                // JavaLine 66 ==> SourceLine 141
                ((Docking$PBLK13$Warehouse)(CUR$.SL$)).hold(waitTime);
                // JavaLine 68 ==> SourceLine 142
                new Docking$PBLK13$Warehouse$Van$VantoWash(((Docking$PBLK13$Warehouse$Van)CUR$));
                // JavaLine 70 ==> SourceLine 143
                ((Docking$PBLK13$Warehouse)(CUR$.SL$)).hold(((double)(((Docking$PBLK13$Warehouse)(CUR$.SL$)).washTime)));
                // JavaLine 72 ==> SourceLine 144
                new Docking$PBLK13$Warehouse$Van$VanFinished(((Docking$PBLK13$Warehouse$Van)CUR$));
                // JavaLine 74 ==> SourceLine 145
                myDock.into(((Docking$PBLK13$Warehouse)(CUR$.SL$)).platforms);
                // JavaLine 76 ==> SourceLine 146
                if(VALUE$((((Docking$PBLK13$Warehouse)(CUR$.SL$)).Waiting.first()!=(null)))) {
                    // JavaLine 78 ==> SourceLine 147
                    ((Docking$PBLK13$Warehouse)(CUR$.SL$)).ActivateAfter(false,((Process$)(((Docking$PBLK13$Warehouse)(CUR$.SL$)).Waiting.first())),((Docking$PBLK13$Warehouse$Van)CUR$));
                }
                // JavaLine 81 ==> SourceLine 148
                new Docking$PBLK13$trace(((Docking$PBLK13)(CUR$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is terminating")));
                // JavaLine 83 ==> SourceLine 124
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Van",124);
                }
                TRACE_END_STM$("Van",124);
            }
        };
    } // End of Constructor
    // Class Statements
    public Docking$PBLK13$Warehouse$Van STM$() { return((Docking$PBLK13$Warehouse$Van)CODE$.EXEC$()); }
    public Docking$PBLK13$Warehouse$Van START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Class Van",1,69,13,70,16,71,18,72,32,124,34,125,36,127,38,129,42,130,44,131,47,132,52,134,54,135,56,136,58,137,60,138,62,139,64,140,66,141,68,142,70,143,72,144,74,145,76,146,78,147,81,148,83,124,94,149);
}
