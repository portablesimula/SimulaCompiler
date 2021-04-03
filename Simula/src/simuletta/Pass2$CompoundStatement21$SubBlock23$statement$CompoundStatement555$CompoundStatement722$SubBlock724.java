// JavaLine 1 <== SourceLine 724
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:58:29 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$statement$CompoundStatement555$CompoundStatement722$SubBlock724 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=4, firstLine=724, lastLine=744, hasLocalClasses=false, System=false
    // Declare locals as attributes
    int x=0;
    Linkage$ d=null;
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$statement$CompoundStatement555$CompoundStatement722$SubBlock724(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 19 <== SourceLine 725
        x=new InptFile$in2byt(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$142).RESULT$;
        ;
        // JavaLine 22 <== SourceLine 726
        d=((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.symtab.Elt[x-((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
        ;
        // JavaLine 25 <== SourceLine 727
        if(VALUE$(IS$(d,Common$dest_descr.class))) {
            ;
        } else
        // JavaLine 29 <== SourceLine 729
        {
            // JavaLine 31 <== SourceLine 731
            new Common$ERROR(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,(((d==(null)))?(CONC(new TXT$("No declaration of dest: "),((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.symtab.Elt[x-((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.symtab.LB[0]].symbol)):(CONC(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.symtab.Elt[x-((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.symtab.LB[0]].symbol,new TXT$(" is not a local label")))));
            ;
            // JavaLine 34 <== SourceLine 732
            d=new Common$dest_descr(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141).STM$();
            ;
            // JavaLine 37 <== SourceLine 733
            ((Common$descr)(d)).symb$2=((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.symtab.Elt[x-((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.symtab.LB[0]];
            ;
        }
        ;
        // JavaLine 42 <== SourceLine 735
        {
            // BEGIN INSPECTION 
            ((Pass2$CompoundStatement21$SubBlock23$statement)(CUR$.SL$)).inspect$735$185=((Common$dest_descr)(d));
            if(((Pass2$CompoundStatement21$SubBlock23$statement)(CUR$.SL$)).inspect$735$185!=null) // INSPECT inspect$735$185
            // JavaLine 47 <== SourceLine 736
            {
                if(VALUE$((((Pass2$CompoundStatement21$SubBlock23$statement)(CUR$.SL$)).inspect$735$185.dx$3==(0)))) {
                    // JavaLine 50 <== SourceLine 737
                    {
                        if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).ndest==(255)))) {
                            new Common$FATAL_ERROR(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,new TXT$("Too many labels"));
                        }
                        ;
                        // JavaLine 56 <== SourceLine 738
                        ((Pass2$CompoundStatement21$SubBlock23$statement)(CUR$.SL$)).inspect$735$185.dx$3=((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).ndest=Math.addExact(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).ndest,1);
                        ;
                        // JavaLine 59 <== SourceLine 739
                        ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).dest_tab.Elt[((Pass2$CompoundStatement21$SubBlock23$statement)(CUR$.SL$)).inspect$735$185.dx$3-((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).dest_tab.LB[0]].p=((Pass2$CompoundStatement21$SubBlock23$statement)(CUR$.SL$)).inspect$735$185.symb$2.id;
                        ;
                    }
                }
                ;
                // JavaLine 65 <== SourceLine 741
                new Pass2$CompoundStatement21$SubBlock23$program_point$define(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).dest_tab.Elt[((Pass2$CompoundStatement21$SubBlock23$statement)(CUR$.SL$)).inspect$735$185.dx$3-((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).dest_tab.LB[0]]);
                ;
            }
        }
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","SubBlock SubBlock724",1,724,19,725,22,726,25,727,29,729,31,731,34,732,37,733,42,735,47,736,50,737,56,738,59,739,65,741,73,744);
} // End of SubBlock
