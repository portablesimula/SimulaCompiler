// JavaLine 1 <== SourceLine 2
package simulaTestPrograms;
// Simula-1.0 Compiled at Tue Oct 01 13:02:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Assignments$ extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=2, lastLine=48, hasLocalClasses=true, System=true
    public boolean isQPSystemBlock() { return(true); }
    // Declare local labels
    // JavaLine 10 <== SourceLine 48
    final LABQNT$ EXIT=new LABQNT$(this,1,"EXIT"); // Local Label #1=EXIT
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 20
    boolean bb=false;
    // JavaLine 15 <== SourceLine 22
    int i=0;
    int j=0;
    int k=0;
    // JavaLine 19 <== SourceLine 23
    float r=0.0f;
    float w=0.0f;
    // JavaLine 22 <== SourceLine 25
    Assignments$$A x=null;
    // JavaLine 24 <== SourceLine 26
    Assignments$$B y=null;
    // Normal Constructor
    public Assignments$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("Assignments$");
        // Declaration Code
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        Assignments$ THIS$=(Assignments$)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 39 <== SourceLine 28
                x=new Assignments$$B(((Assignments$)(CUR$))).STM$();
                // JavaLine 41 <== SourceLine 29
                x.ax=new Assignments$$B(((Assignments$)(CUR$))).STM$();
                // JavaLine 43 <== SourceLine 30
                y=new Assignments$$B(((Assignments$)(CUR$))).STM$();
                // JavaLine 45 <== SourceLine 31
                y.by$1=new Assignments$$B(((Assignments$)(CUR$))).STM$();
                // JavaLine 47 <== SourceLine 33
                r=((float)(k));
                // JavaLine 49 <== SourceLine 34
                j=Math.addExact(i,Math.multiplyExact(j,k));
                // JavaLine 51 <== SourceLine 36
                r=((float)(k=(int)Math.round((w+(((float)(Math.multiplyExact(j,i))))))));
                // JavaLine 53 <== SourceLine 38
                ((bb)?(x):(y)).attr=((float)(67));
                // JavaLine 55 <== SourceLine 40
                x.attr=((float)(y.bttr$1=(int)Math.round((w+(((float)(Math.multiplyExact(j,i))))))));
                // JavaLine 57 <== SourceLine 42
                ((Assignments$$B)(((Assignments$$B)(x)).ax)).by$1=new Assignments$$B(((Assignments$)(CUR$))).STM$();
                // JavaLine 59 <== SourceLine 44
                x=y=((Assignments$$B)(x=new Assignments$$B(((Assignments$)(CUR$))).STM$()));
                // JavaLine 61 <== SourceLine 46
                j=new Assignments$$F(((Assignments$)(CUR$)),3.14f).RESULT$;
                // JavaLine 63 <== SourceLine 48
                LABEL$(1,"EXIT");
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("Assignments$:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("Assignments$:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("Assignments$:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new Assignments$(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("Assignments.sim","SimulaProgram Assignments$",1,2,10,48,13,20,15,22,19,23,22,25,24,26,39,28,41,29,43,30,45,31,47,33,49,34,51,36,53,38,55,40,57,42,59,44,61,46,63,48,87,48);
} // End of SubBlock
