// JavaLine 1 <== SourceLine 2
package simulaTestPrograms;
// Simula-2.0 Compiled at Tue Sep 28 13:18:15 CEST 2021
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc01$ extends BASICIO$ {
    // SubBlock: Kind=SimulaProgram, BlockLevel=1, firstLine=2, lastLine=50, hasLocalClasses=false, System=false
    // Declare locals as attributes
    public outbytefile$ oupt=null;
    // JavaLine 10 <== SourceLine 3
    public inbytefile$ inpt=null;
    // Normal Constructor
    public adHoc01$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("adHoc01$");
        // Declaration Code
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        // JavaLine 21 <== SourceLine 27
        oupt=new outbytefile$(((BASICIO$)CTX$),new TXT$("TestFile")).STM$();
        ;
        // JavaLine 24 <== SourceLine 28
        oupt.open();
        ;
        // JavaLine 27 <== SourceLine 29
        new adHoc01$$doOutbyte(((adHoc01$)(CUR$)),5);
        ;
        // JavaLine 30 <== SourceLine 30
        new adHoc01$$doOut2byte(((adHoc01$)(CUR$)),7);
        ;
        // JavaLine 33 <== SourceLine 31
        new adHoc01$$doOut2byte(((adHoc01$)(CUR$)),Math.addExact(256,13));
        ;
        // JavaLine 36 <== SourceLine 32
        oupt.close();
        ;
        sysout().outimage();
        ;
        // JavaLine 41 <== SourceLine 34
        inpt=new inbytefile$(((BASICIO$)CTX$),new TXT$("TestFile")).STM$();
        ;
        // JavaLine 44 <== SourceLine 35
        inpt.open();
        ;
        // JavaLine 47 <== SourceLine 36
        new adHoc01$$doInbyte(((adHoc01$)(CUR$)));
        ;
        // JavaLine 50 <== SourceLine 37
        new adHoc01$$doInbyte(((adHoc01$)(CUR$)));
        ;
        // JavaLine 53 <== SourceLine 38
        new adHoc01$$doInbyte(((adHoc01$)(CUR$)));
        ;
        // JavaLine 56 <== SourceLine 39
        new adHoc01$$doInbyte(((adHoc01$)(CUR$)));
        ;
        // JavaLine 59 <== SourceLine 40
        new adHoc01$$doInbyte(((adHoc01$)(CUR$)));
        ;
        // JavaLine 62 <== SourceLine 41
        inpt.close();
        ;
        sysout().outimage();
        ;
        // JavaLine 67 <== SourceLine 43
        inpt=new inbytefile$(((BASICIO$)CTX$),new TXT$("TestFile")).STM$();
        ;
        // JavaLine 70 <== SourceLine 44
        inpt.open();
        ;
        // JavaLine 73 <== SourceLine 45
        new adHoc01$$doInbyte(((adHoc01$)(CUR$)));
        ;
        // JavaLine 76 <== SourceLine 46
        new adHoc01$$doIn2byte(((adHoc01$)(CUR$)));
        ;
        // JavaLine 79 <== SourceLine 47
        new adHoc01$$doIn2byte(((adHoc01$)(CUR$)));
        ;
        // JavaLine 82 <== SourceLine 48
        inpt.close();
        ;
        sysout().outimage();
        ;
        EBLK();
        return(this);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new adHoc01$(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc01.sim","SimulaProgram adHoc01$",1,2,10,3,21,27,24,28,27,29,30,30,33,31,36,32,41,34,44,35,47,36,50,37,53,38,56,39,59,40,62,41,67,43,70,44,73,45,76,46,79,47,82,48,95,50);
} // End of SubBlock
