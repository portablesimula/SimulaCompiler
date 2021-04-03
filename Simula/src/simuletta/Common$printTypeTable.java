// JavaLine 1 <== SourceLine 448
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$printTypeTable extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=448, lastLine=463, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 449
    int i=0;
    // JavaLine 12 <== SourceLine 450
    Common$TypeNotice typeNot=null;
    // Normal Constructor
    public Common$printTypeTable(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$printTypeTable STM$() {
        for(i=1;i<=((Common)(CUR$.SL$)).nTypes$1;i++) {
            // JavaLine 25 <== SourceLine 452
            {
                sysout().outtext(new Common$edtype(((Common)(CUR$.SL$)),i).RESULT$);
                ;
                // JavaLine 29 <== SourceLine 453
                typeNot=((Common)(CUR$.SL$)).typeTable.Elt[i-((Common)(CUR$.SL$)).typeTable.LB[0]];
                ;
                // JavaLine 32 <== SourceLine 454
                if(VALUE$((typeNot==(null)))) {
                    // JavaLine 34 <== SourceLine 455
                    sysout().outtext(new TXT$(" = TypeNotice==NONE"));
                } else
                // JavaLine 37 <== SourceLine 456
                {
                    sysout().outtext(new TXT$(" = TypeNotice: set="));
                    ;
                    sysout().outtext(new Common$edTypeSet(((Common)(CUR$.SL$)),typeNot.p2$set).RESULT$);
                    ;
                    // JavaLine 43 <== SourceLine 457
                    sysout().outtext(new TXT$(", qual="));
                    ;
                    sysout().outtext(new Common$edSymbol(((Common)(CUR$.SL$)),typeNot.p2$qual).RESULT$);
                    ;
                    // JavaLine 48 <== SourceLine 458
                    sysout().outtext(new TXT$(", info1="));
                    ;
                    sysout().outtext(new Common$leftint(((Common)(CUR$.SL$)),typeNot.p2$info1).RESULT$);
                    ;
                    // JavaLine 53 <== SourceLine 459
                    sysout().outtext(new TXT$(", info2="));
                    ;
                    sysout().outtext(new Common$leftint(((Common)(CUR$.SL$)),typeNot.p2$info2).RESULT$);
                    ;
                }
                ;
                // JavaLine 60 <== SourceLine 461
                sysout().outimage();
                ;
            }
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure printTypeTable",1,448,10,449,12,450,25,452,29,453,32,454,34,455,37,456,43,457,48,458,53,459,60,461,68,463);
} // End of Procedure
