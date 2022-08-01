// JavaLine 1 <== SourceLine 2
package simulaTestPrograms;
// Simula-1.0 Compiled at Fri Oct 04 22:35:25 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc00$ extends BASICIO$ {
    // SubBlock: Kind=SimulaProgram, BlockLevel=1, firstLine=2, lastLine=72, hasLocalClasses=false, System=false
    // Declare locals as attributes
    int i=0;
    final int j=(int)(4);
    final int pos=(int)(2);
    final int neg=(int)(-2);
    int q=0;
    // JavaLine 14 <== SourceLine 3
    char c=0;
    // JavaLine 16 <== SourceLine 4
    TXT$ t=null;
    // JavaLine 18 <== SourceLine 5
    float r=0.0f;
    // JavaLine 20 <== SourceLine 6
    final int k=(int)(6);
    // Normal Constructor
    public adHoc00$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("adHoc00$");
        // Declaration Code
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        // JavaLine 31 <== SourceLine 8
        sysout().outtext(new TXT$("TEST CASE 10"));
        sysout().outimage();
        for(i=1;i<=20;i=i+4) {
            // JavaLine 35 <== SourceLine 12
            {
                sysout().outint(i,0);
                sysout().outimage();
            }
        }
        // JavaLine 41 <== SourceLine 16
        sysout().outtext(new TXT$("TEST CASE 9"));
        sysout().outimage();
        i=q;
        while((i<(12))) {
            sysout().outimage();
            i=q;
        }
        // JavaLine 55 <== SourceLine 23
        sysout().outtext(new TXT$("TEST CASE 1"));
        sysout().outimage();
        for(i=1;i<=k;i=i+2) {
            // JavaLine 59 <== SourceLine 26
            {
                sysout().outint(i,0);
                sysout().outimage();
            }
        }
        // JavaLine 65 <== SourceLine 29
        sysout().outtext(new TXT$("TEST CASE 2"));
        sysout().outimage();
        for(i=k;i>=(-(11));i=i-2) {
            // JavaLine 69 <== SourceLine 32
            {
                sysout().outint(i,0);
                sysout().outimage();
            }
        }
        // JavaLine 75 <== SourceLine 35
        sysout().outtext(new TXT$("TEST CASE 3"));
        sysout().outimage();
        for(r=((float)(1));r<=((float)(k));r++) {
            // JavaLine 79 <== SourceLine 38
            {
                sysout().outint((int)Math.round(r),0);
                sysout().outimage();
            }
        }
        // JavaLine 85 <== SourceLine 41
        sysout().outtext(new TXT$("TEST CASE 4"));
        sysout().outimage();
        for(r=((float)(k));r>=((float)(1));r--) {
            // JavaLine 89 <== SourceLine 44
            {
                sysout().outint((int)Math.round(r),0);
                sysout().outimage();
            }
        }
        // JavaLine 95 <== SourceLine 47
        sysout().outtext(new TXT$("TEST CASE 5"));
        sysout().outimage();
        for(i=(int)Math.round(3.14f);i<=6;i++) {
            // JavaLine 99 <== SourceLine 50
            {
                sysout().outint(i,0);
                sysout().outimage();
            }
        }
        // JavaLine 105 <== SourceLine 53
        sysout().outtext(new TXT$("TEST CASE 6"));
        sysout().outimage();
        i=3; {
            i=(int)3.14f; {
                // JavaLine 110 <== SourceLine 57
                {
                    sysout().outint(i,0);
                    sysout().outimage();
                }
            }
        }
        // JavaLine 117 <== SourceLine 60
        sysout().outtext(new TXT$("TEST CASE 7"));
        sysout().outimage();
        c='?'; {
            // JavaLine 121 <== SourceLine 63
            {
                sysout().outchar(c);
                sysout().outimage();
            }
        }
        // JavaLine 127 <== SourceLine 66
        sysout().outtext(new TXT$("TEST CASE 8"));
        sysout().outimage();
        t=new TXT$("Abra"); {
            // JavaLine 131 <== SourceLine 69
            {
                sysout().outtext(t);
                sysout().outimage();
            }
        }
        EBLK();
        return(this);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new adHoc00$(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc00.sim","SimulaProgram adHoc00$",1,2,14,3,16,4,18,5,20,6,31,8,35,12,41,16,46,19,50,20,55,23,59,26,65,29,69,32,75,35,79,38,85,41,89,44,95,47,99,50,105,53,110,57,117,60,121,63,127,66,131,69,145,72);
} // End of SubBlock
