// JavaLine 1 ==> SourceLine 5
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Mar 17 11:15:45 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class GotoSample0 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=5, lastLine=35, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare local labels
    // JavaLine 10 ==> SourceLine 11
    final LABQNT$ STARTING=new LABQNT$(this,0,1); // Local Label #1=STARTING
    // JavaLine 12 ==> SourceLine 21
    final LABQNT$ LAB1=new LABQNT$(this,0,2); // Local Label #2=LAB1
    // JavaLine 14 ==> SourceLine 22
    final LABQNT$ LAB2=new LABQNT$(this,0,3); // Local Label #3=LAB2
    // JavaLine 16 ==> SourceLine 23
    final LABQNT$ LAB3=new LABQNT$(this,0,4); // Local Label #4=LAB3
    // JavaLine 18 ==> SourceLine 24
    final LABQNT$ LAB4=new LABQNT$(this,0,5); // Local Label #5=LAB4
    // JavaLine 20 ==> SourceLine 25
    final LABQNT$ LAB5=new LABQNT$(this,0,6); // Local Label #6=LAB5
    // JavaLine 22 ==> SourceLine 27
    final LABQNT$ LAB6=new LABQNT$(this,0,7); // Local Label #7=LAB6
    // JavaLine 24 ==> SourceLine 28
    final LABQNT$ LAB7=new LABQNT$(this,0,8); // Local Label #8=LAB7
    // JavaLine 26 ==> SourceLine 29
    final LABQNT$ LAB8=new LABQNT$(this,0,9); // Local Label #9=LAB8
    // JavaLine 28 ==> SourceLine 30
    final LABQNT$ LAB9=new LABQNT$(this,0,10); // Local Label #10=LAB9
    // Declare locals as attributes
    // JavaLine 31 ==> SourceLine 5
    boolean b=false;
    // JavaLine 33 ==> SourceLine 6
    int i=0;
    // Normal Constructor
    public GotoSample0(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("GotoSample0");
        // Declaration Code
        TRACE_BEGIN_DCL$("GotoSample0",6);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("GotoSample0",6);
        GotoSample0 THIS$=(GotoSample0)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 50 ==> SourceLine 8
                sysout().outtext(new TXT$("--- START VERY LOCAL GOTO SAMPLE"));
                sysout().outimage();
                // JavaLine 53 ==> SourceLine 9
                i=2;
                // JavaLine 55 ==> SourceLine 11
                LABEL$(1,"STARTING");
                sysout().outtext(new TXT$("At START"));
                sysout().outimage();
                // JavaLine 59 ==> SourceLine 13
                b=(!(b));
                // JavaLine 61 ==> SourceLine 15
                if(VALUE$(b)) {
                    GOTO$(STARTING); // GOTO EVALUATED LABEL
                }
                // JavaLine 65 ==> SourceLine 18
                sysout().outtext(new TXT$("Before GOTO LAB2"));
                sysout().outimage();
                // JavaLine 68 ==> SourceLine 19
                GOTO$(LAB2); // GOTO EVALUATED LABEL
                // JavaLine 70 ==> SourceLine 21
                LABEL$(2,"LAB1");
                sysout().outtext(new TXT$("At LAB1"));
                sysout().outimage();
                // JavaLine 74 ==> SourceLine 22
                LABEL$(3,"LAB2");
                sysout().outtext(new TXT$("At LAB2"));
                sysout().outimage();
                // JavaLine 78 ==> SourceLine 23
                LABEL$(4,"LAB3");
                sysout().outtext(new TXT$("At LAB3"));
                sysout().outimage();
                // JavaLine 82 ==> SourceLine 24
                LABEL$(5,"LAB4");
                sysout().outtext(new TXT$("At LAB4"));
                sysout().outimage();
                // JavaLine 86 ==> SourceLine 25
                LABEL$(6,"LAB5");
                sysout().outtext(new TXT$("At LAB5"));
                sysout().outimage();
                // JavaLine 90 ==> SourceLine 26
                GOTO$(LAB8); // GOTO EVALUATED LABEL
                // JavaLine 92 ==> SourceLine 27
                LABEL$(7,"LAB6");
                sysout().outtext(new TXT$("At LAB6"));
                sysout().outimage();
                // JavaLine 96 ==> SourceLine 28
                LABEL$(8,"LAB7");
                sysout().outtext(new TXT$("At LAB7"));
                sysout().outimage();
                // JavaLine 100 ==> SourceLine 29
                LABEL$(9,"LAB8");
                sysout().outtext(new TXT$("At LAB8"));
                sysout().outimage();
                // JavaLine 104 ==> SourceLine 30
                LABEL$(10,"LAB9");
                sysout().outtext(new TXT$("At LAB9"));
                sysout().outimage();
                // JavaLine 108 ==> SourceLine 32
                sysout().outtext(new TXT$("At EXIT"));
                sysout().outimage();
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$ || q.prefixLevel!=0) {
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("GotoSample0",32);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new GotoSample0(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("GotoSample0.sim","SimulaProgram GotoSample0",1,5,10,11,12,21,14,22,16,23,18,24,20,25,22,27,24,28,26,29,28,30,31,5,33,6,50,8,53,9,55,11,59,13,61,15,65,18,68,19,70,21,74,22,78,23,82,24,86,25,90,26,92,27,96,28,100,29,104,30,108,32,133,35);
}
