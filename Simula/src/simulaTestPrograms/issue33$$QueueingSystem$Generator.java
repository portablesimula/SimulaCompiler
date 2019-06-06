// JavaLine 1 <== SourceLine 11
package simulaTestPrograms;
// Simula-1.0 Compiled at Wed Jun 05 18:05:53 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class issue33$$QueueingSystem$Generator extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=3, firstLine=11, lastLine=21, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    public int nrph$3=0;
    public int si$3=0;
    // Normal Constructor
    public issue33$$QueueingSystem$Generator(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("Generator",11);
    }
    // Class Statements
    public issue33$$QueueingSystem$Generator STM$() {
        TRACE_BEGIN_STM$("Generator",11);
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // Class Process: Code before inner
        // JavaLine 27 <== SourceLine 1
        detach();
        // JavaLine 29 <== SourceLine 12
        // Class Generator: Code before inner
        while(true) {
            // JavaLine 32 <== SourceLine 13
            {
                TRACE_BEGIN_STM$("CompoundStatement13",13);
                nrph$3=Poisson(((double)(3.9f)),((issue33$)(CUR$.SL$.SL$)).U1);
                // JavaLine 36 <== SourceLine 15
                ((issue33$$QueueingSystem)(CUR$.SL$)).hold(((double)(1.0f)));
                // JavaLine 38 <== SourceLine 16
                if(VALUE$((((issue33$$QueueingSystem)(CUR$.SL$)).time()<(((double)(22.0f)))))) {
                    // JavaLine 40 <== SourceLine 17
                    {
                        TRACE_BEGIN_STM$("CompoundStatement17",17);
                        ((issue33$$QueueingSystem)(CUR$.SL$)).acm.Elt[((int)((int)Math.round(((issue33$$QueueingSystem)(CUR$.SL$)).time())))-((issue33$$QueueingSystem)(CUR$.SL$)).acm.LB[0]]=Math.addExact(((issue33$$QueueingSystem)(CUR$.SL$)).acm.Elt[((int)((int)Math.round(((issue33$$QueueingSystem)(CUR$.SL$)).time())))-((issue33$$QueueingSystem)(CUR$.SL$)).acm.LB[0]],nrph$3);
                        ((issue33$$QueueingSystem)(CUR$.SL$)).totnr$2=Math.addExact(((issue33$$QueueingSystem)(CUR$.SL$)).totnr$2,nrph$3);
                        // JavaLine 45 <== SourceLine 18
                        for(boolean CB$18:new ForList(
                            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){si$3=(int)x$; return(x$);};  public Number get(){return((Number)si$3); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(nrph$3); }})
                           )) { if(!CB$18) continue;
                        // JavaLine 49 <== SourceLine 19
                        ((issue33$$QueueingSystem)(CUR$.SL$)).ActivateDelay(false,((issue33$$QueueingSystem$Truck)new issue33$$QueueingSystem$Truck(((issue33$$QueueingSystem)(CUR$.SL$))).START$()),1.0f-((((float)(si$3))/(((float)(nrph$3))))),false);
                    }
                    TRACE_END_STM$("CompoundStatement17",19);
                }
            }
            TRACE_END_STM$("CompoundStatement13",19);
        }
        if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
    }
    // JavaLine 59 <== SourceLine 12
    // Class Generator: Code after inner
    // Class Process: Code after inner
    // JavaLine 62 <== SourceLine 1
    terminate();
    // JavaLine 64 <== SourceLine 12
    TRACE_END_STM$("Generator",12);
    EBLK();
    return(this);
} // End of Class Statements
public static PROGINFO$ INFO$=new PROGINFO$("issue33.sim","Class Generator",1,11,27,1,29,12,32,13,36,15,38,16,40,17,45,18,49,19,59,12,62,1,64,12,68,21);
} // End of Class
