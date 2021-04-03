// JavaLine 1 <== SourceLine 458
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$program_point$define extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=458, lastLine=477, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$program_point$define(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$program_point$define STM$() {
        // JavaLine 20 <== SourceLine 460
        switch(((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).kind) { // BEGIN SWITCH STATEMENT
        case 0: 
        // JavaLine 23 <== SourceLine 462
        {
            ((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).kind=2;
            ;
            // JavaLine 27 <== SourceLine 463
            if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).freeindex==(0)))) {
                new Common$FATAL_ERROR(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,new TXT$("Index oflow"));
            }
            ;
            // JavaLine 32 <== SourceLine 464
            ((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).index=((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).freeindex;
            ;
            // JavaLine 35 <== SourceLine 465
            ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).freeindex=((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).indexUsed.Elt[((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).freeindex-((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).indexUsed.LB[0]];
            ;
            // JavaLine 38 <== SourceLine 466
            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_BDEST$1);
            ;
            new OuptFile$outbyt(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).index);
            ;
        }
        break;
        case 1: 
        // JavaLine 46 <== SourceLine 469
        {
            ((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).kind=3;
            ;
            // JavaLine 50 <== SourceLine 470
            ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).indexUsed.Elt[((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).index-((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).indexUsed.LB[0]]=((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).freeindex;
            ;
            ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).freeindex=((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).index;
            ;
            // JavaLine 55 <== SourceLine 471
            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_FDEST$1);
            ;
            new OuptFile$outbyt(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).index);
            ;
        }
        break;
        case 2: 
        case 3: 
        // JavaLine 64 <== SourceLine 474
        {
            new Common$ERROR(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,CONC(new TXT$("Local label already defined "),new Common$edSymbol(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).p).RESULT$));
            ;
        }
        break;
    } // END SWITCH STATEMENT
    ;
    // JavaLine 72 <== SourceLine 476
    if(VALUE$((((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143);
    }
    ;
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure define",1,458,20,460,23,462,27,463,32,464,35,465,38,466,46,469,50,470,55,471,64,474,72,476,79,477);
} // End of Procedure
