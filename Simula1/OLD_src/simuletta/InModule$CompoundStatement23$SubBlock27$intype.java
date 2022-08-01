// JavaLine 1 <== SourceLine 68
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:47 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InModule$CompoundStatement23$SubBlock27$intype extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=68, lastLine=96, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 69
    int c=0;
    int inf1=0;
    int inf2=0;
    // Normal Constructor
    public InModule$CompoundStatement23$SubBlock27$intype(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public InModule$CompoundStatement23$SubBlock27$intype STM$() {
        // JavaLine 27 <== SourceLine 70
        switch(new InModule$CompoundStatement23$SubBlock27$inAbyte(((InModule$CompoundStatement23$SubBlock27)(CUR$.SL$))).RESULT$) { // BEGIN SWITCH STATEMENT
        case 7: 
        // JavaLine 30 <== SourceLine 71
        RESULT$=((InModule)(CUR$.SL$.SL$)).inspect$22$42.T_INT$1;
        break;
        case 8: 
        // JavaLine 34 <== SourceLine 72
        RESULT$=((InModule)(CUR$.SL$.SL$)).inspect$22$42.T_SINT$1;
        break;
        case 9: 
        // JavaLine 38 <== SourceLine 73
        {
            inf1=new InptFile$innumber(((InModule)(CUR$.SL$.SL$)).inspect$22$43).RESULT$;
            ;
            inf2=new InptFile$innumber(((InModule)(CUR$.SL$.SL$)).inspect$22$43).RESULT$;
            ;
            // JavaLine 44 <== SourceLine 74
            RESULT$=new Common$defType(((InModule)(CUR$.SL$.SL$)).inspect$22$42,((InModule)(CUR$.SL$.SL$)).inspect$22$42.integerTypes$1,((InModule)(CUR$.SL$.SL$)).inspect$22$42.S_RANGE$1,inf1,inf2).RESULT$;
        }
        break;
        case 11: 
        // JavaLine 49 <== SourceLine 76
        RESULT$=((InModule)(CUR$.SL$.SL$)).inspect$22$42.T_REAL$1;
        break;
        case 12: 
        // JavaLine 53 <== SourceLine 77
        RESULT$=((InModule)(CUR$.SL$.SL$)).inspect$22$42.T_LREAL$1;
        break;
        case 13: 
        // JavaLine 57 <== SourceLine 78
        RESULT$=((InModule)(CUR$.SL$.SL$)).inspect$22$42.T_SIZE$1;
        break;
        case 14: 
        // JavaLine 61 <== SourceLine 79
        RESULT$=((InModule)(CUR$.SL$.SL$)).inspect$22$42.T_CHAR$1;
        break;
        case 15: 
        // JavaLine 65 <== SourceLine 80
        RESULT$=((InModule)(CUR$.SL$.SL$)).inspect$22$42.T_BOOL$1;
        break;
        case 16: 
        // JavaLine 69 <== SourceLine 81
        RESULT$=((InModule)(CUR$.SL$.SL$)).inspect$22$42.T_LABEL$1;
        break;
        case 10: 
        // JavaLine 73 <== SourceLine 82
        {
            new InptFile$inident(((InModule)(CUR$.SL$.SL$)).inspect$22$43);
            ;
            // JavaLine 77 <== SourceLine 83
            inf1=new InptFile$innumber(((InModule)(CUR$.SL$.SL$)).inspect$22$43).RESULT$;
            ;
            // JavaLine 80 <== SourceLine 84
            RESULT$=new Common$defType(((InModule)(CUR$.SL$.SL$)).inspect$22$42,((InModule)(CUR$.SL$.SL$)).inspect$22$42.structTypes$1,((InModule)(CUR$.SL$.SL$)).inspect$22$42.hash$1,inf1,0).RESULT$;
            ;
        }
        break;
        case 17: 
        // JavaLine 86 <== SourceLine 86
        {
            new InptFile$inident(((InModule)(CUR$.SL$.SL$)).inspect$22$43);
            ;
            // JavaLine 90 <== SourceLine 87
            RESULT$=new Common$defType(((InModule)(CUR$.SL$.SL$)).inspect$22$42,((InModule)(CUR$.SL$.SL$)).inspect$22$42.refTypes$1,((InModule)(CUR$.SL$.SL$)).inspect$22$42.hash$1,0,0).RESULT$;
            ;
        }
        break;
        case 18: 
        // JavaLine 96 <== SourceLine 88
        {
            new InptFile$inident(((InModule)(CUR$.SL$.SL$)).inspect$22$43);
            ;
            // JavaLine 100 <== SourceLine 89
            RESULT$=new Common$defType(((InModule)(CUR$.SL$.SL$)).inspect$22$42,((InModule)(CUR$.SL$.SL$)).inspect$22$42.entTypes$1,((InModule)(CUR$.SL$.SL$)).inspect$22$42.hash$1,0,0).RESULT$;
            ;
        }
        break;
        case 19: 
        // JavaLine 106 <== SourceLine 90
        {
            c=new InModule$CompoundStatement23$SubBlock27$intype(((InModule$CompoundStatement23$SubBlock27)(CUR$.SL$))).RESULT$;
            ;
            // JavaLine 110 <== SourceLine 91
            RESULT$=new Common$defType(((InModule)(CUR$.SL$.SL$)).inspect$22$42,((InModule)(CUR$.SL$.SL$)).inspect$22$42.fieldTypes$1,c,0,0).RESULT$;
            ;
        }
        break;
        case 20: 
        // JavaLine 116 <== SourceLine 92
        {
            c=new InModule$CompoundStatement23$SubBlock27$intype(((InModule$CompoundStatement23$SubBlock27)(CUR$.SL$))).RESULT$;
            ;
            // JavaLine 120 <== SourceLine 93
            RESULT$=new Common$defType(((InModule)(CUR$.SL$.SL$)).inspect$22$42,((InModule)(CUR$.SL$.SL$)).inspect$22$42.nameTypes$1,c,0,0).RESULT$;
            ;
        }
        break;
        default:
        // JavaLine 126 <== SourceLine 94
        RESULT$=((InModule)(CUR$.SL$.SL$)).inspect$22$42.T_NULL$1;
        break;
    } // END SWITCH STATEMENT
    ;
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("INMODULE.sim","Procedure intype",1,68,13,69,27,70,30,71,34,72,38,73,44,74,49,76,53,77,57,78,61,79,65,80,69,81,73,82,77,83,80,84,86,86,90,87,96,88,100,89,106,90,110,91,116,92,120,93,126,94,133,96);
} // End of Procedure
