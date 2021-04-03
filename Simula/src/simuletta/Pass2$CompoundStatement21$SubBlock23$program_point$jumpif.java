// JavaLine 1 <== SourceLine 411
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$program_point$jumpif extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=411, lastLine=434, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$cond;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$program_point$jumpif setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$program_point$jumpif.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$cond=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$program_point$jumpif(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$program_point$jumpif(RTObject$ SL$,int sp$cond) {
        super(SL$);
        // Parameter assignment to locals
        this.p$cond = sp$cond;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$program_point$jumpif STM$() {
        // JavaLine 38 <== SourceLine 413
        switch(((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).kind) { // BEGIN SWITCH STATEMENT
        case 0: 
        // JavaLine 41 <== SourceLine 415
        {
            ((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).kind=1;
            ;
            // JavaLine 45 <== SourceLine 416
            if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).freeindex==(0)))) {
                new Common$FATAL_ERROR(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,new TXT$("Index oflow"));
            }
            ;
            // JavaLine 50 <== SourceLine 417
            ((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).index=((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).freeindex;
            ;
            // JavaLine 53 <== SourceLine 418
            ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).freeindex=((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).indexUsed.Elt[((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).freeindex-((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).indexUsed.LB[0]];
            ;
            // JavaLine 56 <== SourceLine 419
            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_FJUMPIF$1);
            ;
            // JavaLine 59 <== SourceLine 420
            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).condinstr.Elt[p$cond-((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).condinstr.LB[0]]);
            ;
            new OuptFile$outbyt(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).index);
            ;
        }
        break;
        case 2: 
        // JavaLine 67 <== SourceLine 423
        {
            ((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).kind=3;
            ;
            // JavaLine 71 <== SourceLine 424
            ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).indexUsed.Elt[((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).index-((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).indexUsed.LB[0]]=((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).freeindex;
            ;
            ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).freeindex=((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).index;
            ;
            // JavaLine 76 <== SourceLine 425
            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_BJUMPIF$1);
            ;
            // JavaLine 79 <== SourceLine 426
            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).condinstr.Elt[p$cond-((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).condinstr.LB[0]]);
            ;
            new OuptFile$outbyt(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).index);
            ;
        }
        break;
        case 1: 
        case 3: 
        // JavaLine 88 <== SourceLine 429
        {
            new Common$ERROR(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,CONC(new TXT$("More than one jump to local label "),new Common$edSymbol(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,((Pass2$CompoundStatement21$SubBlock23$program_point)(CUR$.SL$)).p).RESULT$));
            ;
            // JavaLine 92 <== SourceLine 430
            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_POP$1);
            ;
            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_POP$1);
            ;
        }
        break;
    } // END SWITCH STATEMENT
    ;
    // JavaLine 101 <== SourceLine 433
    if(VALUE$((((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143);
    }
    ;
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure jumpif",1,411,38,413,41,415,45,416,50,417,53,418,56,419,59,420,67,423,71,424,76,425,79,426,88,429,92,430,101,433,108,434);
} // End of Procedure
