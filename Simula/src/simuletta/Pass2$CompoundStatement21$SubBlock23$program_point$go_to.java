// JavaLine 1 <== SourceLine 436
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$program_point$go_to extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=436, lastLine=456, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$program_point$go_to(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$program_point$go_to STM$() {
        // JavaLine 20 <== SourceLine 438
        switch(((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).kind) { // BEGIN SWITCH STATEMENT
        case 0: 
        // JavaLine 23 <== SourceLine 440
        {
            ((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).kind=1;
            ;
            // JavaLine 27 <== SourceLine 441
            if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).freeindex==(0)))) {
                new Common$FATAL_ERROR(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,new TXT$("Index oflow"));
            }
            ;
            // JavaLine 32 <== SourceLine 442
            ((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).index=((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).freeindex;
            ;
            // JavaLine 35 <== SourceLine 443
            ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).freeindex=((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).indexUsed.Elt[((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).freeindex-((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).indexUsed.LB[0]];
            ;
            // JavaLine 38 <== SourceLine 444
            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_FJUMP$1);
            ;
            new OuptFile$outbyt(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).index);
            ;
        }
        break;
        case 2: 
        // JavaLine 46 <== SourceLine 447
        {
            ((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).kind=3;
            ;
            // JavaLine 50 <== SourceLine 448
            ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).indexUsed.Elt[((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).index-((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).indexUsed.LB[0]]=((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).freeindex;
            ;
            ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).freeindex=((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).index;
            ;
            // JavaLine 55 <== SourceLine 449
            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_BJUMP$1);
            ;
            new OuptFile$outbyt(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).index);
            ;
        }
        break;
        case 1: 
        case 3: 
        // JavaLine 64 <== SourceLine 452
        {
            new Common$ERROR(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,CONC(new TXT$("More than one goto local label "),new Common$edSymbol(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).p).RESULT$));
            ;
        }
        break;
    } // END SWITCH STATEMENT
    ;
    // JavaLine 72 <== SourceLine 455
    if(VALUE$((((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143);
    }
    ;
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure go_to",1,436,20,438,23,440,27,441,32,442,35,443,38,444,46,447,50,448,55,449,64,452,72,455,79,456);
} // End of Procedure
