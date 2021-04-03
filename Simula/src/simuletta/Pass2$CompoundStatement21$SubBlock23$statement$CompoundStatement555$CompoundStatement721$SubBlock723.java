// JavaLine 1 <== SourceLine 723
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$statement$CompoundStatement555$CompoundStatement721$SubBlock723 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=4, firstLine=723, lastLine=743, hasLocalClasses=false, System=false
    // Declare locals as attributes
    int x=0;
    Linkage$ d=null;
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$statement$CompoundStatement555$CompoundStatement721$SubBlock723(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 19 <== SourceLine 724
        x=new InptFile$in2byt(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$142).RESULT$;
        ;
        // JavaLine 22 <== SourceLine 725
        d=((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.symtab.Elt[x-((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
        ;
        // JavaLine 25 <== SourceLine 726
        if(VALUE$(IS$(d,Common$dest_descr.class))) {
            ;
        } else
        // JavaLine 29 <== SourceLine 728
        {
            // JavaLine 31 <== SourceLine 730
            new Common$ERROR(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,(((d==(null)))?(CONC(new TXT$("No declaration of dest: "),new Common$edSymbol(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,x).RESULT$)):(CONC(new Common$edSymbol(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,x).RESULT$,new TXT$(" is not a local label")))));
            ;
            // JavaLine 34 <== SourceLine 731
            d=new Common$dest_descr(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141).STM$();
            ;
            // JavaLine 37 <== SourceLine 732
            ((Common$descr)(d)).symb$2=((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.symtab.Elt[x-((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.symtab.LB[0]];
            ;
        }
        ;
        // JavaLine 42 <== SourceLine 734
        {
            // BEGIN INSPECTION 
            ((Pass2$CompoundStatement21$SubBlock23$statement)(CUR$.SL$)).inspect$734$185=((Common$dest_descr)(d));
            if(((Pass2$CompoundStatement21$SubBlock23$statement)(CUR$.SL$)).inspect$734$185!=null) // INSPECT inspect$734$185
            // JavaLine 47 <== SourceLine 735
            {
                if(VALUE$((((Pass2$CompoundStatement21$SubBlock23$statement)(CUR$.SL$)).inspect$734$185.dx$3==(0)))) {
                    // JavaLine 50 <== SourceLine 736
                    {
                        if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).ndest==(255)))) {
                            new Common$FATAL_ERROR(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,new TXT$("Too many labels"));
                        }
                        ;
                        // JavaLine 56 <== SourceLine 737
                        ((Pass2$CompoundStatement21$SubBlock23$statement)(CUR$.SL$)).inspect$734$185.dx$3=((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).ndest=Math.addExact(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).ndest,1);
                        ;
                        // JavaLine 59 <== SourceLine 738
                        ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).dest_tab.Elt[((Pass2$CompoundStatement21$SubBlock23$statement)(CUR$.SL$)).inspect$734$185.dx$3-((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).dest_tab.LB[0]].p=((Pass2$CompoundStatement21$SubBlock23$statement)(CUR$.SL$)).inspect$734$185.symb$2.id;
                        ;
                    }
                }
                ;
                // JavaLine 65 <== SourceLine 740
                new Pass2$CompoundStatement21$SubBlock23$program_point$define(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).dest_tab.Elt[((Pass2$CompoundStatement21$SubBlock23$statement)(CUR$.SL$)).inspect$734$185.dx$3-((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).dest_tab.LB[0]]);
                ;
            }
        }
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","SubBlock SubBlock723",1,723,19,724,22,725,25,726,29,728,31,730,34,731,37,732,42,734,47,735,50,736,56,737,59,738,65,740,73,743);
} // End of SubBlock
