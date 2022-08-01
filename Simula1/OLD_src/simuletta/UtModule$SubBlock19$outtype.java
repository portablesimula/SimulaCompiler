// JavaLine 1 <== SourceLine 82
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:52 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class UtModule$SubBlock19$outtype extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=82, lastLine=119, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$t;
    // Declare local labels
    // JavaLine 11 <== SourceLine 84
    final LABQNT$ REP=new LABQNT$(this,1,"REP"); // Local Label #1=REP
    // JavaLine 13 <== SourceLine 108
    final LABQNT$ OUTS=new LABQNT$(this,2,"OUTS"); // Local Label #2=OUTS
    // Declare locals as attributes
    // JavaLine 16 <== SourceLine 84
    Common$TypeNotice inspect$84$120=null;
    Common$TypeSet inspect$84$121=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public UtModule$SubBlock19$outtype setPar(Object param) {
        //Util.BREAK("CALL UtModule$SubBlock19$outtype.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$t=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public UtModule$SubBlock19$outtype(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public UtModule$SubBlock19$outtype(RTObject$ SL$,int sp$t) {
        super(SL$);
        // Parameter assignment to locals
        this.p$t = sp$t;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public UtModule$SubBlock19$outtype STM$() {
        UtModule$SubBlock19$outtype THIS$=(UtModule$SubBlock19$outtype)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 50 <== SourceLine 118
                LABEL$(1,"REP");
                // JavaLine 52 <== SourceLine 84
                {
                    // BEGIN INSPECTION 
                    inspect$84$120=((UtModule)(CUR$.SL$.SL$)).inspect$17$114.typeTable.Elt[p$t-((UtModule)(CUR$.SL$.SL$)).inspect$17$114.typeTable.LB[0]];
                    if(inspect$84$120!=null) // INSPECT inspect$84$120
                    {
                        // BEGIN INSPECTION 
                        inspect$84$121=inspect$84$120.p2$set;
                        if(inspect$84$121!=null) // INSPECT inspect$84$121
                        // JavaLine 61 <== SourceLine 86
                        {
                            switch(inspect$84$121.p2$type) { // BEGIN SWITCH STATEMENT
                            case 2: 
                            // JavaLine 65 <== SourceLine 88
                            if(VALUE$((inspect$84$120.p2$qual==(((UtModule)(CUR$.SL$.SL$)).inspect$17$114.S_RANGE$1)))) {
                                // JavaLine 67 <== SourceLine 89
                                {
                                    new OuptFile$outbyt(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_RANGE$1);
                                    ;
                                    new OuptFile$outnumber(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,inspect$84$120.p2$info1);
                                    ;
                                    new OuptFile$outnumber(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,inspect$84$120.p2$info2);
                                    ;
                                }
                            } else
                            // JavaLine 77 <== SourceLine 91
                            if(VALUE$((inspect$84$120.p2$qual==(((UtModule)(CUR$.SL$.SL$)).inspect$17$114.S_SHORT$1)))) {
                                // JavaLine 79 <== SourceLine 92
                                new OuptFile$outbyt(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_SHORT$1);
                            } else
                            if(VALUE$((inspect$84$120.p2$qual==(((UtModule)(CUR$.SL$.SL$)).inspect$17$114.S_INTEGER$1)))) {
                                // JavaLine 83 <== SourceLine 93
                                new OuptFile$outbyt(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_INTEGER$1);
                            } else
                            new Common$IERR(((UtModule)(CUR$.SL$.SL$)).inspect$17$114);
                            break;
                            case 3: 
                            // JavaLine 89 <== SourceLine 95
                            {
                                new OuptFile$outbyt(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_STRUCT$1);
                                ;
                                // JavaLine 93 <== SourceLine 96
                                new OuptFile$outstring(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$.SL$)).inspect$17$114.symtab.Elt[inspect$84$120.p2$qual-((UtModule)(CUR$.SL$.SL$)).inspect$17$114.symtab.LB[0]].symbol);
                                ;
                                // JavaLine 96 <== SourceLine 97
                                new OuptFile$outnumber(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,inspect$84$120.p2$info1);
                            }
                            break;
                            case 1: 
                            // JavaLine 101 <== SourceLine 99
                            if(VALUE$((inspect$84$120.p2$qual==(((UtModule)(CUR$.SL$.SL$)).inspect$17$114.S_CHAR$1)))) {
                                // JavaLine 103 <== SourceLine 100
                                new OuptFile$outbyt(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_CHAR$1);
                            } else
                            if(VALUE$((inspect$84$120.p2$qual==(((UtModule)(CUR$.SL$.SL$)).inspect$17$114.S_BOOLEAN$1)))) {
                                // JavaLine 107 <== SourceLine 101
                                new OuptFile$outbyt(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_BOOL$1);
                            } else
                            if(VALUE$((inspect$84$120.p2$qual==(((UtModule)(CUR$.SL$.SL$)).inspect$17$114.S_SIZE$1)))) {
                                // JavaLine 111 <== SourceLine 102
                                new OuptFile$outbyt(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_SIZE$1);
                            } else
                            if(VALUE$((inspect$84$120.p2$qual==(((UtModule)(CUR$.SL$.SL$)).inspect$17$114.S_LABEL$1)))) {
                                // JavaLine 115 <== SourceLine 103
                                new OuptFile$outbyt(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_LABEL$1);
                            } else
                            if(VALUE$((inspect$84$120.p2$qual==(((UtModule)(CUR$.SL$.SL$)).inspect$17$114.S_REAL$1)))) {
                                // JavaLine 119 <== SourceLine 104
                                new OuptFile$outbyt(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_REAL$1);
                            } else
                            if(VALUE$((inspect$84$120.p2$qual==(((UtModule)(CUR$.SL$.SL$)).inspect$17$114.S_LONG$1)))) {
                                // JavaLine 123 <== SourceLine 105
                                new OuptFile$outbyt(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_LONG$1);
                            } else
                            new Common$IERR(((UtModule)(CUR$.SL$.SL$)).inspect$17$114);
                            break;
                            case 5: 
                            // JavaLine 129 <== SourceLine 107
                            {
                                new OuptFile$outbyt(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_REF$1);
                                ;
                                // JavaLine 133 <== SourceLine 108
                                LABEL$(2,"OUTS");
                                new OuptFile$outstring(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$.SL$)).inspect$17$114.symtab.Elt[inspect$84$120.p2$qual-((UtModule)(CUR$.SL$.SL$)).inspect$17$114.symtab.LB[0]].symbol);
                            }
                            break;
                            case 7: 
                            // JavaLine 139 <== SourceLine 110
                            {
                                new OuptFile$outbyt(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_ENTRY$1);
                                ;
                                GOTO$(OUTS); // GOTO EVALUATED LABEL
                            }
                            break;
                            case 4: 
                            // JavaLine 147 <== SourceLine 112
                            {
                                new OuptFile$outbyt(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_FIELD$1);
                                ;
                                p$t=inspect$84$120.p2$qual;
                                ;
                                GOTO$(REP); // GOTO EVALUATED LABEL
                            }
                            break;
                            case 6: 
                            // JavaLine 157 <== SourceLine 114
                            {
                                new OuptFile$outbyt(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_NAME$1);
                                ;
                                p$t=inspect$84$120.p2$qual;
                                ;
                                GOTO$(REP); // GOTO EVALUATED LABEL
                            }
                            break;
                            default:
                            // JavaLine 167 <== SourceLine 116
                            {
                                new OuptFile$outbyt(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_NULL$1);
                                ;
                            }
                            break;
                        } // END SWITCH STATEMENT
                        ;
                    }
                    else // OTHERWISE 
                    // JavaLine 177 <== SourceLine 118
                    new OuptFile$outbyt(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_NULL$1);
                }
            }
            ;
            break LOOP$;
        }
        catch(LABQNT$ q) {
            CUR$=THIS$;
            if(q.SL$!=CUR$) {
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("outtype:NON-LOCAL",q);
                CUR$.STATE$=OperationalState.terminated;
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("outtype:RE-THROW",q);
                throw(q);
            }
            if(RT.Option.GOTO_TRACING) TRACE_GOTO("outtype:LOCAL",q);
            JTX$=q.index; continue LOOP$; // EG. GOTO Lx
        }
    }
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("UTMODULE.sim","Procedure outtype",1,82,11,84,13,108,16,84,50,118,52,84,61,86,65,88,67,89,77,91,79,92,83,93,89,95,93,96,96,97,101,99,103,100,107,101,111,102,115,103,119,104,123,105,129,107,133,108,139,110,147,112,157,114,167,116,177,118,198,119);
} // End of Procedure
