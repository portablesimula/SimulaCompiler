// JavaLine 1 <== SourceLine 418
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$initTypeTable extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=418, lastLine=446, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Common$initTypeTable(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$initTypeTable STM$() {
        // JavaLine 20 <== SourceLine 419
        ((Common)(CUR$.SL$)).infixTypes$1=new Common$TypeSet(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).TYP_INFIX$1).STM$();
        ;
        // JavaLine 23 <== SourceLine 420
        ((Common)(CUR$.SL$)).integerTypes$1=new Common$TypeSet(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).TYP_INT$1).STM$();
        ;
        // JavaLine 26 <== SourceLine 421
        ((Common)(CUR$.SL$)).structTypes$1=new Common$TypeSet(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).TYP_STRUCT$1).STM$();
        ;
        // JavaLine 29 <== SourceLine 422
        ((Common)(CUR$.SL$)).entTypes$1=new Common$TypeSet(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).TYP_ENT$1).STM$();
        ;
        // JavaLine 32 <== SourceLine 423
        ((Common)(CUR$.SL$)).refTypes$1=new Common$TypeSet(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).TYP_REF$1).STM$();
        ;
        // JavaLine 35 <== SourceLine 424
        ((Common)(CUR$.SL$)).fieldTypes$1=new Common$TypeSet(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).TYP_FIELD$1).STM$();
        ;
        // JavaLine 38 <== SourceLine 425
        ((Common)(CUR$.SL$)).nameTypes$1=new Common$TypeSet(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).TYP_NAME$1).STM$();
        ;
        // JavaLine 41 <== SourceLine 431
        new Common$TypeNotice(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).integerTypes$1,((Common)(CUR$.SL$)).S_INTEGER$1,0,0).STM$();
        ;
        // JavaLine 44 <== SourceLine 432
        new Common$TypeNotice(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).integerTypes$1,((Common)(CUR$.SL$)).S_SHORT$1,0,0).STM$();
        ;
        // JavaLine 47 <== SourceLine 433
        new Common$TypeNotice(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).infixTypes$1,((Common)(CUR$.SL$)).S_REAL$1,0,0).STM$();
        ;
        // JavaLine 50 <== SourceLine 434
        new Common$TypeNotice(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).infixTypes$1,((Common)(CUR$.SL$)).S_LONG$1,0,0).STM$();
        ;
        // JavaLine 53 <== SourceLine 435
        new Common$TypeNotice(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).infixTypes$1,((Common)(CUR$.SL$)).S_SIZE$1,0,0).STM$();
        ;
        // JavaLine 56 <== SourceLine 436
        new Common$TypeNotice(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).infixTypes$1,((Common)(CUR$.SL$)).S_CHAR$1,0,0).STM$();
        ;
        // JavaLine 59 <== SourceLine 437
        new Common$TypeNotice(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).infixTypes$1,((Common)(CUR$.SL$)).S_BOOLEAN$1,0,0).STM$();
        ;
        // JavaLine 62 <== SourceLine 438
        new Common$TypeNotice(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).infixTypes$1,((Common)(CUR$.SL$)).S_LABEL$1,0,0).STM$();
        ;
        // JavaLine 65 <== SourceLine 439
        new Common$TypeNotice(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).entTypes$1,((Common)(CUR$.SL$)).S_ENTRY$1,0,0).STM$();
        ;
        // JavaLine 68 <== SourceLine 440
        new Common$TypeNotice(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).refTypes$1,((Common)(CUR$.SL$)).S_REF$1,0,0).STM$();
        ;
        // JavaLine 71 <== SourceLine 441
        new Common$TypeNotice(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).nameTypes$1,((Common)(CUR$.SL$)).S_NAME$1,0,0).STM$();
        ;
        // JavaLine 74 <== SourceLine 442
        new Common$TypeNotice(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).fieldTypes$1,((Common)(CUR$.SL$)).S_FIELD$1,0,0).STM$();
        ;
        // JavaLine 77 <== SourceLine 445
        new Common$printTypeTable(((Common)(CUR$.SL$)));
        ;
        new Common$TRACE(((Common)(CUR$.SL$)),new TXT$("COMMON.initTypeTable"),445,new TXT$("COMPLETED"));
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure initTypeTable",1,418,20,419,23,420,26,421,29,422,32,423,35,424,38,425,41,431,44,432,47,433,50,434,53,435,56,436,59,437,62,438,65,439,68,440,71,441,74,442,77,445,84,446);
} // End of Procedure
