// JavaLine 1 <== SourceLine 23
package simulaTestPrograms;
// Simula-1.0 Compiled at Wed Jun 05 18:05:53 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class issue33$$QueueingSystem$Truck extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=3, firstLine=23, lastLine=33, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    public double wtime$3=0.0d;
    // JavaLine 13 <== SourceLine 26
    public Link$ inspect$26$0$3=null;
    // Normal Constructor
    public issue33$$QueueingSystem$Truck(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("Truck",26);
    }
    // Class Statements
    public issue33$$QueueingSystem$Truck STM$() {
        TRACE_BEGIN_STM$("Truck",26);
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // Class Process: Code before inner
        // JavaLine 28 <== SourceLine 1
        detach();
        // JavaLine 30 <== SourceLine 24
        // Class Truck: Code before inner
        if(VALUE$((((issue33$$QueueingSystem)(CUR$.SL$)).FreeDocks$2.first()==(null)))) {
            // JavaLine 33 <== SourceLine 25
            {
                TRACE_BEGIN_STM$("CompoundStatement25",25);
                wtime$3=((issue33$$QueueingSystem)(CUR$.SL$)).time();
                ((issue33$$QueueingSystem)(CUR$.SL$)).wait(((issue33$$QueueingSystem)(CUR$.SL$)).Waiting$2);
                ((issue33$$QueueingSystem)(CUR$.SL$)).wt$2=((((issue33$$QueueingSystem)(CUR$.SL$)).wt$2+(((issue33$$QueueingSystem)(CUR$.SL$)).time()))-(wtime$3));
                out();
                TRACE_END_STM$("CompoundStatement25",25);
            }
        }
        // JavaLine 43 <== SourceLine 26
        {
            // BEGIN INSPECTION 
            inspect$26$0$3=((issue33$$QueueingSystem)(CUR$.SL$)).FreeDocks$2.first();
            if(inspect$26$0$3!=null) // INSPECT inspect$26$0
            {
                TRACE_BEGIN_STM$("CompoundStatement26",26);
                inspect$26$0$3.out();
                // JavaLine 51 <== SourceLine 27
                wtime$3=(normal(((double)((((24.0f*(((float)(((issue33$$QueueingSystem)(CUR$.SL$)).p2$nDocks))))/(((float)(((issue33$$QueueingSystem)(CUR$.SL$)).p2$nForks))))+(((float)(8)))))),((double)((((float)(Math.multiplyExact(5,((issue33$$QueueingSystem)(CUR$.SL$)).p2$nDocks)))/(((float)(((issue33$$QueueingSystem)(CUR$.SL$)).p2$nForks)))))),((issue33$)(CUR$.SL$.SL$)).U2)/(((double)(60))));
                // JavaLine 53 <== SourceLine 30
                ((issue33$$QueueingSystem)(CUR$.SL$)).hold(wtime$3);
                ((issue33$$QueueingSystem$Truck)(CUR$)).into(((issue33$$QueueingSystem)(CUR$.SL$)).FreeDocks$2);
                TRACE_END_STM$("CompoundStatement26",30);
            }
        }
        // JavaLine 59 <== SourceLine 31
        if(VALUE$((((issue33$$QueueingSystem)(CUR$.SL$)).Waiting$2.first()!=(null)))) {
            // JavaLine 61 <== SourceLine 32
            ((issue33$$QueueingSystem)(CUR$.SL$)).ActivateAfter(false,((Process$)(((issue33$$QueueingSystem)(CUR$.SL$)).Waiting$2.first())),((issue33$$QueueingSystem$Truck)(CUR$)));
        }
        // JavaLine 64 <== SourceLine 24
        // Class Truck: Code after inner
        // Class Process: Code after inner
        // JavaLine 67 <== SourceLine 1
        terminate();
        // JavaLine 69 <== SourceLine 24
        TRACE_END_STM$("Truck",24);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("issue33.sim","Class Truck",1,23,13,26,28,1,30,24,33,25,43,26,51,27,53,30,59,31,61,32,64,24,67,1,69,24,73,33);
} // End of Class
