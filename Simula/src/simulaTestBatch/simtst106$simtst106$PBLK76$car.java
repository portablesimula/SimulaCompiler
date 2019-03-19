// JavaLine 1 ==> SourceLine 85
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon Mar 18 11:16:18 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst106$simtst106$PBLK76$car extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=3, firstLine=85, lastLine=112, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public simtst106$simtst106$PBLK76$town p3$start;
    public simtst106$simtst106$PBLK76$town p3$destin;
    public float p3$dist;
    // Declare local labels
    // JavaLine 15 ==> SourceLine 95
    final LABQNT$ active=new LABQNT$(this,3,1); // Local Label #1=active
    // Declare locals as attributes
    // JavaLine 18 ==> SourceLine 89
    public Head$ been=null;
    // Normal Constructor
    public simtst106$simtst106$PBLK76$car(RTObject$ staticLink,simtst106$simtst106$PBLK76$town sp3$start,simtst106$simtst106$PBLK76$town sp3$destin,float sp3$dist) {
        super(staticLink);
        // Parameter assignment to locals
        this.p3$start = sp3$start;
        this.p3$destin = sp3$destin;
        this.p3$dist = sp3$dist;
        // Declaration Code
        TRACE_BEGIN_DCL$("car",92);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("car",92,inner);
                simtst106$simtst106$PBLK76$car THIS$=(simtst106$simtst106$PBLK76$car)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 37 ==> SourceLine 95
                        LABEL$(1,"active");
                        been=new Head$(((simtst106$PBLK76)(CUR$.SL$))).STM$();
                        // JavaLine 40 ==> SourceLine 96
                        ((simtst106$PBLK76)(CUR$.SL$)).wait(p3$start.cars);
                        // JavaLine 42 ==> SourceLine 97
                        new simtst106$simtst106$PBLK76$car$send(((simtst106$simtst106$PBLK76$car)CUR$),suc());
                        // JavaLine 44 ==> SourceLine 98
                        ((simtst106$PBLK76)(CUR$.SL$)).hold(((double)(p3$dist)));
                        // JavaLine 46 ==> SourceLine 99
                        if(VALUE$(((simtst106$PBLK76)(CUR$.SL$)).stop)) {
                            // JavaLine 48 ==> SourceLine 100
                            {
                                TRACE_BEGIN_STM$("CompoundStatement100",100);
                                if(VALUE$((nextev()==(null)))) {
                                    ((simtst106$PBLK76)(CUR$.SL$)).ActivateAfter(false,((simtst106$PBLK76)(CUR$.SL$)).main,((simtst106$simtst106$PBLK76$car)CUR$));
                                }
                                // JavaLine 54 ==> SourceLine 101
                                GOTO$(active); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement100",101);
                            }
                        }
                        // JavaLine 59 ==> SourceLine 103
                        if(VALUE$(p3$destin.gone)) {
                            GOTO$(active); // GOTO EVALUATED LABEL
                        }
                        new simtst106$simtst106$PBLK76$townpoint(((simtst106$PBLK76)(CUR$.SL$)),p3$destin).STM$().into(been);
                        // JavaLine 64 ==> SourceLine 104
                        if(VALUE$((p3$destin==(((simtst106$PBLK76)(CUR$.SL$)).destination)))) {
                            // JavaLine 66 ==> SourceLine 105
                            {
                                TRACE_BEGIN_STM$("CompoundStatement105",105);
                                ((simtst106$PBLK76)(CUR$.SL$)).ActivateAfter(false,((simtst106$PBLK76)(CUR$.SL$)).main,((simtst106$simtst106$PBLK76$car)CUR$));
                                // JavaLine 70 ==> SourceLine 106
                                ((simtst106$PBLK76)(CUR$.SL$)).h=been;
                                // JavaLine 72 ==> SourceLine 107
                                GOTO$(active); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement105",107);
                            }
                        }
                        // JavaLine 77 ==> SourceLine 109
                        new simtst106$simtst106$PBLK76$car$send(((simtst106$simtst106$PBLK76$car)CUR$),p3$destin.cars.first());
                        // JavaLine 79 ==> SourceLine 110
                        p3$destin.gone=true;
                        // JavaLine 81 ==> SourceLine 111
                        GOTO$(active); // GOTO EVALUATED LABEL
                        // JavaLine 83 ==> SourceLine 95
                        if(inner!=null) {
                            inner.STM$();
                            TRACE_BEGIN_STM_AFTER_INNER$("car",95);
                        }
                        break LOOP$;
                    }
                    catch(LABQNT$ q) {
                        CUR$=THIS$;
                        if(q.SL$!=CUR$ || q.prefixLevel!=3) {
                            CUR$.STATE$=OperationalState.terminated;
                            if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                            throw(q);
                        }
                        if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                        JTX$=q.index; continue LOOP$; // EG. GOTO Lx
                    }
                }
                TRACE_END_STM$("car",95);
            }
        };
    } // End of Constructor
    // Class Statements
    public simtst106$simtst106$PBLK76$car STM$() { return((simtst106$simtst106$PBLK76$car)CODE$.EXEC$()); }
    public simtst106$simtst106$PBLK76$car START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst106.sim","Class car",1,85,15,95,18,89,37,95,40,96,42,97,44,98,46,99,48,100,54,101,59,103,64,104,66,105,70,106,72,107,77,109,79,110,81,111,83,95,107,112);
}
