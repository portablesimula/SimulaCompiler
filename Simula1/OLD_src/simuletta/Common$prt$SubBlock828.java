// JavaLine 1 <== SourceLine 828
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 17:55:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock828 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=828, lastLine=838, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common$quant q=null;
    // Normal Constructor
    public Common$prt$SubBlock828(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 18 <== SourceLine 829
        if(VALUE$((((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$800$16)).p4$kind==(((Common)(CUR$.SL$.SL$)).S_ROUTINE$1)))) {
            // JavaLine 20 <== SourceLine 830
            sysout().outtext(new TXT$("routine \""));
        } else
        if(VALUE$((((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$800$16)).p4$kind==(((Common)(CUR$.SL$.SL$)).S_SYSRUT$1)))) {
            // JavaLine 24 <== SourceLine 831
            sysout().outtext(new TXT$("system(\""));
        } else
        if(VALUE$((((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$800$16)).p4$kind==(((Common)(CUR$.SL$.SL$)).S_KNOWN$1)))) {
            // JavaLine 28 <== SourceLine 832
            sysout().outtext(new TXT$("known(\""));
        } else
        if(VALUE$((((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$800$16)).p4$kind==(((Common)(CUR$.SL$.SL$)).S_EXTERNAL$1)))) {
            // JavaLine 32 <== SourceLine 833
            sysout().outtext(new TXT$("external(\""));
        } else
        new Common$IERR(((Common)(CUR$.SL$.SL$)));
        ;
        sysout().outtext(((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$800$16)).info$4);
        ;
        new Common$prt$outName(((Common$prt)(CUR$.SL$)),new TXT$("\") "));
        ;
        // JavaLine 41 <== SourceLine 834
        sysout().outchar(';');
        ;
        sysout().outimage();
        ;
        // JavaLine 46 <== SourceLine 835
        new Common$prt$prt_parspec(((Common$prt)(CUR$.SL$)),((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$800$16)).spec$3,((Common$prt)(CUR$.SL$)).p$pos);
        ;
        // JavaLine 49 <== SourceLine 836
        if(VALUE$((((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$800$16)).local$4!=(null)))) {
            {
                new Common$prt(((Common)(CUR$.SL$.SL$)),((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$800$16)).local$4,((Common$prt)(CUR$.SL$)).p$pos);
                ;
                sysout().outimage();
            }
        }
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock828",1,828,18,829,20,830,24,831,28,832,32,833,41,834,46,835,49,836,60,838);
} // End of SubBlock
