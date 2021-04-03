// JavaLine 1 <== SourceLine 816
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:20:00 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock816 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=816, lastLine=826, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common$quant q=null;
    // Normal Constructor
    public Common$prt$SubBlock816(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 18 <== SourceLine 817
        if(VALUE$((((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$788$16)).p4$kind==(((Common)(CUR$.SL$.SL$)).S_ROUTINE$1)))) {
            // JavaLine 20 <== SourceLine 818
            sysout().outtext(new TXT$("routine \""));
        } else
        if(VALUE$((((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$788$16)).p4$kind==(((Common)(CUR$.SL$.SL$)).S_SYSRUT$1)))) {
            // JavaLine 24 <== SourceLine 819
            sysout().outtext(new TXT$("system(\""));
        } else
        if(VALUE$((((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$788$16)).p4$kind==(((Common)(CUR$.SL$.SL$)).S_KNOWN$1)))) {
            // JavaLine 28 <== SourceLine 820
            sysout().outtext(new TXT$("known(\""));
        } else
        if(VALUE$((((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$788$16)).p4$kind==(((Common)(CUR$.SL$.SL$)).S_EXTERNAL$1)))) {
            // JavaLine 32 <== SourceLine 821
            sysout().outtext(new TXT$("external(\""));
        } else
        new Common$IERR(((Common)(CUR$.SL$.SL$)));
        ;
        sysout().outtext(((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$788$16)).info$4);
        ;
        new Common$prt$outName(((Common$prt)(CUR$.SL$)),new TXT$("\") "));
        ;
        // JavaLine 41 <== SourceLine 822
        sysout().outchar(';');
        ;
        sysout().outimage();
        ;
        // JavaLine 46 <== SourceLine 823
        new Common$prt$prt_parspec(((Common$prt)(CUR$.SL$)),((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$788$16)).spec$3,((Common$prt)(CUR$.SL$)).p$pos);
        ;
        // JavaLine 49 <== SourceLine 824
        if(VALUE$((((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$788$16)).local$4!=(null)))) {
            {
                new Common$prt(((Common)(CUR$.SL$.SL$)),((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$788$16)).local$4,((Common$prt)(CUR$.SL$)).p$pos);
                ;
                sysout().outimage();
            }
        }
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock816",1,816,18,817,20,818,24,819,28,820,32,821,41,822,46,823,49,824,60,826);
} // End of SubBlock
