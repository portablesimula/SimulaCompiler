// JavaLine 1 <== SourceLine 823
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:46:15 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock823 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=823, lastLine=833, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common$quant q=null;
    // Normal Constructor
    public Common$prt$SubBlock823(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 18 <== SourceLine 824
        if(VALUE$((((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$795$16)).p4$kind==(((Common)(CUR$.SL$.SL$)).S_ROUTINE$1)))) {
            // JavaLine 20 <== SourceLine 825
            sysout().outtext(new TXT$("routine \""));
        } else
        if(VALUE$((((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$795$16)).p4$kind==(((Common)(CUR$.SL$.SL$)).S_SYSRUT$1)))) {
            // JavaLine 24 <== SourceLine 826
            sysout().outtext(new TXT$("system(\""));
        } else
        if(VALUE$((((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$795$16)).p4$kind==(((Common)(CUR$.SL$.SL$)).S_KNOWN$1)))) {
            // JavaLine 28 <== SourceLine 827
            sysout().outtext(new TXT$("known(\""));
        } else
        if(VALUE$((((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$795$16)).p4$kind==(((Common)(CUR$.SL$.SL$)).S_EXTERNAL$1)))) {
            // JavaLine 32 <== SourceLine 828
            sysout().outtext(new TXT$("external(\""));
        } else
        new Common$IERR(((Common)(CUR$.SL$.SL$)));
        ;
        sysout().outtext(((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$795$16)).info$4);
        ;
        new Common$prt$outName(((Common$prt)(CUR$.SL$)),new TXT$("\") "));
        ;
        // JavaLine 41 <== SourceLine 829
        sysout().outchar(';');
        ;
        sysout().outimage();
        ;
        // JavaLine 46 <== SourceLine 830
        new Common$prt$prt_parspec(((Common$prt)(CUR$.SL$)),((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$795$16)).spec$3,((Common$prt)(CUR$.SL$)).p$pos);
        ;
        // JavaLine 49 <== SourceLine 831
        if(VALUE$((((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$795$16)).local$4!=(null)))) {
            {
                new Common$prt(((Common)(CUR$.SL$.SL$)),((Common$peculiar)(((Common$prt)(CUR$.SL$)).inspect$795$16)).local$4,((Common$prt)(CUR$.SL$)).p$pos);
                ;
                sysout().outimage();
            }
        }
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock823",1,823,18,824,20,825,24,826,28,827,32,828,41,829,46,830,49,831,60,833);
} // End of SubBlock
