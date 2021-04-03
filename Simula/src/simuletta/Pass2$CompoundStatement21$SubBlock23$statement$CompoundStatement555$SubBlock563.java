// JavaLine 1 <== SourceLine 563
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$statement$CompoundStatement555$SubBlock563 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=4, firstLine=563, lastLine=581, hasLocalClasses=false, System=false
    // Declare locals as attributes
    int s=0;
    int v=0;
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$statement$CompoundStatement555$SubBlock563(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 19 <== SourceLine 564
        s=new InptFile$innumber(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$142).RESULT$;
        ;
        v=new InptFile$innumber(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$142).RESULT$;
        ;
        // JavaLine 24 <== SourceLine 565
        if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).tracemode>(3)))) {
            {
                // BEGIN INSPECTION 
                ((Pass2$CompoundStatement21$SubBlock23$statement)(CUR$.SL$)).inspect$565$176=sysout();
                if(((Pass2$CompoundStatement21$SubBlock23$statement)(CUR$.SL$)).inspect$565$176!=null) // INSPECT inspect$565$176
                // JavaLine 30 <== SourceLine 566
                {
                    ((Pass2$CompoundStatement21$SubBlock23$statement)(CUR$.SL$)).inspect$565$176.outtext(new TXT$("TRACE"));
                    ;
                    ((Pass2$CompoundStatement21$SubBlock23$statement)(CUR$.SL$)).inspect$565$176.outint(s,4);
                    ;
                    // JavaLine 36 <== SourceLine 567
                    ((Pass2$CompoundStatement21$SubBlock23$statement)(CUR$.SL$)).inspect$565$176.outint(v,4);
                    ;
                    ((Pass2$CompoundStatement21$SubBlock23$statement)(CUR$.SL$)).inspect$565$176.outimage();
                    ;
                }
            }
        }
        ;
        // JavaLine 45 <== SourceLine 569
        if(VALUE$((s==(1)))) {
            ((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$142.input_trace$3=v;
        } else
        // JavaLine 49 <== SourceLine 570
        if(VALUE$((s==(2)))) {
            ((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143.output_trace$3=v;
        } else
        // JavaLine 53 <== SourceLine 571
        if(VALUE$((s==(3)))) {
            ((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.module_trace$1=v;
        } else
        // JavaLine 57 <== SourceLine 572
        if(VALUE$((s==(4)))) {
            ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).tracemode=v;
        } else
        // JavaLine 61 <== SourceLine 573
        {
            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_SETSWITCH$1);
            ;
            // JavaLine 65 <== SourceLine 574
            s=(((s==(11)))?(1):((((s==(12)))?(4):((((s==(13)))?(3):((((s==(14)))?(2):((((s==(21)))?(5):((((s==(22)))?(5):((((s==(23)))?(9):((((s==(24)))?(5):(9))))))))))))))));
            ;
            // JavaLine 68 <== SourceLine 578
            new OuptFile$outbyt(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,s);
            ;
            new OuptFile$outbyt(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,v);
            ;
            // JavaLine 73 <== SourceLine 579
            if(VALUE$((((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143);
            }
            ;
        }
        ;
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","SubBlock SubBlock563",1,563,19,564,24,565,30,566,36,567,45,569,49,570,53,571,57,572,61,573,65,574,68,578,73,579,82,581);
} // End of SubBlock
