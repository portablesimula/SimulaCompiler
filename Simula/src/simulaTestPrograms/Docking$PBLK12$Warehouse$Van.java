// JavaLine 1 ==> SourceLine 87
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 10 12:42:17 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Docking$PBLK12$Warehouse$Van extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=3, firstLine=87, lastLine=167, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public int p3$load;
    // Declare locals as attributes
    // JavaLine 13 ==> SourceLine 88
    public double waitTime=0.0d;
    public Docking$PBLK12$Warehouse$Dock myDock=null;
    // JavaLine 16 ==> SourceLine 89
    public ShapeElement$ vanShape=null;
    // JavaLine 18 ==> SourceLine 90
    public int dLine=0;
    public final int speed=200;
    // Normal Constructor
    public Docking$PBLK12$Warehouse$Van(RTObject$ staticLink,int sp3$load) {
        super(staticLink);
        // Parameter assignment to locals
        this.p3$load = sp3$load;
        // Declaration Code
        TRACE_BEGIN_DCL$("Van",136);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("Van",136,inner);
                // JavaLine 32 ==> SourceLine 142
                new Docking$PBLK12$trace(((Docking$PBLK12)(CUR$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is entering the scene")));
                // JavaLine 34 ==> SourceLine 143
                vanShape=new ShapeElement$(((Docking$PBLK12)(CUR$.SL$.SL$))).STM$();
                // JavaLine 36 ==> SourceLine 145
                if(VALUE$((((Docking$PBLK12$Warehouse)(CUR$.SL$)).platforms.first()==(null)))) {
                    // JavaLine 38 ==> SourceLine 147
                    {
                        TRACE_BEGIN_STM$("CompoundStatement147",147);
                        waitTime=((Docking$PBLK12$Warehouse)(CUR$.SL$)).time();
                        // JavaLine 42 ==> SourceLine 148
                        new Docking$PBLK12$Warehouse$Van$VantoQueue(((Docking$PBLK12$Warehouse$Van)CUR$));
                        // JavaLine 44 ==> SourceLine 149
                        ((Docking$PBLK12$Warehouse)(CUR$.SL$)).wait(((Docking$PBLK12$Warehouse)(CUR$.SL$)).Waiting);
                        out();
                        // JavaLine 47 ==> SourceLine 150
                        ((Docking$PBLK12$Warehouse)(CUR$.SL$)).accWait=((((Docking$PBLK12$Warehouse)(CUR$.SL$)).accWait+(((Docking$PBLK12$Warehouse)(CUR$.SL$)).time()))-(waitTime));
                        TRACE_END_STM$("CompoundStatement147",150);
                    }
                }
                // JavaLine 52 ==> SourceLine 152
                new Docking$PBLK12$Warehouse$UpdateReport(((Docking$PBLK12$Warehouse)(CUR$.SL$)));
                // JavaLine 54 ==> SourceLine 153
                myDock=((Docking$PBLK12$Warehouse$Dock)(((Docking$PBLK12$Warehouse)(CUR$.SL$)).platforms.first()));
                // JavaLine 56 ==> SourceLine 154
                new Docking$PBLK12$Warehouse$Van$VantoPlatform(((Docking$PBLK12$Warehouse$Van)CUR$));
                // JavaLine 58 ==> SourceLine 155
                myDock.out();
                // JavaLine 60 ==> SourceLine 156
                ((Docking$PBLK12$Warehouse)(CUR$.SL$)).hold(((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$)).pTime)));
                // JavaLine 62 ==> SourceLine 157
                new Docking$PBLK12$Warehouse$Van$VantoUnload(((Docking$PBLK12$Warehouse$Van)CUR$));
                // JavaLine 64 ==> SourceLine 158
                waitTime=((1000.0d*(((double)(p3$load))))/(((Docking$PBLK12$Warehouse)(CUR$.SL$)).unloadSpeed));
                // JavaLine 66 ==> SourceLine 159
                ((Docking$PBLK12$Warehouse)(CUR$.SL$)).hold(waitTime);
                // JavaLine 68 ==> SourceLine 160
                new Docking$PBLK12$Warehouse$Van$VantoWash(((Docking$PBLK12$Warehouse$Van)CUR$));
                // JavaLine 70 ==> SourceLine 161
                ((Docking$PBLK12$Warehouse)(CUR$.SL$)).hold(((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$)).washTime)));
                // JavaLine 72 ==> SourceLine 162
                new Docking$PBLK12$Warehouse$Van$VanFinished(((Docking$PBLK12$Warehouse$Van)CUR$));
                // JavaLine 74 ==> SourceLine 163
                myDock.into(((Docking$PBLK12$Warehouse)(CUR$.SL$)).platforms);
                // JavaLine 76 ==> SourceLine 164
                if(VALUE$((((Docking$PBLK12$Warehouse)(CUR$.SL$)).Waiting.first()!=(null)))) {
                    // JavaLine 78 ==> SourceLine 165
                    ((Docking$PBLK12$Warehouse)(CUR$.SL$)).ActivateAfter(false,((Process$)(((Docking$PBLK12$Warehouse)(CUR$.SL$)).Waiting.first())),((Docking$PBLK12$Warehouse$Van)CUR$));
                }
                // JavaLine 81 ==> SourceLine 166
                new Docking$PBLK12$trace(((Docking$PBLK12)(CUR$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is terminating")));
                // JavaLine 83 ==> SourceLine 142
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Van",142);
                }
                TRACE_END_STM$("Van",142);
            }
        };
    } // End of Constructor
    // Class Statements
    public Docking$PBLK12$Warehouse$Van STM$() { return((Docking$PBLK12$Warehouse$Van)CODE$.EXEC$()); }
    public Docking$PBLK12$Warehouse$Van START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Class Van",1,87,13,88,16,89,18,90,32,142,34,143,36,145,38,147,42,148,44,149,47,150,52,152,54,153,56,154,58,155,60,156,62,157,64,158,66,159,68,160,70,161,72,162,74,163,76,164,78,165,81,166,83,142,94,167);
}
