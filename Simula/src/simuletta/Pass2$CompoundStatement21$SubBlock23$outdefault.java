// JavaLine 1 <== SourceLine 1483
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$outdefault extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=1483, lastLine=1519, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$type;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 1484
    Linkage$ dentry=null;
    int hilo=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$outdefault setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$outdefault.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$type=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$outdefault(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$outdefault(RTObject$ SL$,int sp$type) {
        super(SL$);
        // Parameter assignment to locals
        this.p$type = sp$type;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$outdefault STM$() {
        // JavaLine 41 <== SourceLine 1485
        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$type-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.integerTypes$1)))) {
            // JavaLine 43 <== SourceLine 1486
            {
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_INT$1);
                ;
                // JavaLine 47 <== SourceLine 1487
                ((Pass2)(CUR$.SL$.SL$)).inspect$21$143.outtext(new TXT$("0"));
            }
        } else
        if(VALUE$((p$type==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REAL$1)))) {
            // JavaLine 52 <== SourceLine 1488
            {
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_REAL$1);
                ;
                // JavaLine 56 <== SourceLine 1489
                ((Pass2)(CUR$.SL$.SL$)).inspect$21$143.outtext(new TXT$("0"));
            }
        } else
        if(VALUE$((p$type==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_LREAL$1)))) {
            // JavaLine 61 <== SourceLine 1490
            {
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_LREAL$1);
                ;
                // JavaLine 65 <== SourceLine 1491
                ((Pass2)(CUR$.SL$.SL$)).inspect$21$143.outtext(new TXT$("0"));
            }
        } else
        if(VALUE$((p$type==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_CHAR$1)))) {
            // JavaLine 70 <== SourceLine 1492
            {
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_CHAR$1);
                ;
                new OuptFile$outbyt(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,rank(((char)32)));
                ;
            }
        } else
        // JavaLine 78 <== SourceLine 1493
        if(VALUE$((p$type==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_BOOL$1)))) {
            // JavaLine 80 <== SourceLine 1494
            {
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_FALSE$1);
                ;
            }
        } else
        // JavaLine 86 <== SourceLine 1495
        if(VALUE$((p$type==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_LABEL$1)))) {
            // JavaLine 88 <== SourceLine 1496
            {
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_NOWHERE$1);
                ;
            }
        } else
        // JavaLine 94 <== SourceLine 1497
        if(VALUE$((p$type==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_SIZE$1)))) {
            // JavaLine 96 <== SourceLine 1498
            {
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_NOSIZE$1);
                ;
            }
        } else
        // JavaLine 102 <== SourceLine 1499
        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$type-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.refTypes$1)))) {
            // JavaLine 104 <== SourceLine 1500
            {
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ONONE$1);
                ;
            }
        } else
        // JavaLine 110 <== SourceLine 1501
        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$type-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.fieldTypes$1)))) {
            // JavaLine 112 <== SourceLine 1502
            {
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ANONE$1);
                ;
            }
        } else
        // JavaLine 118 <== SourceLine 1503
        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$type-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.nameTypes$1)))) {
            // JavaLine 120 <== SourceLine 1504
            {
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_GNONE$1);
                ;
            }
        } else
        // JavaLine 126 <== SourceLine 1505
        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$type-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.entTypes$1)))) {
            // JavaLine 128 <== SourceLine 1506
            {
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_NOBODY$1);
                ;
            }
        } else
        // JavaLine 134 <== SourceLine 1507
        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$type-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.structTypes$1)))) {
            // JavaLine 136 <== SourceLine 1508
            {
                hilo=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$type-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$qual;
                ;
                // JavaLine 140 <== SourceLine 1509
                dentry=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[hilo-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
                ;
                // JavaLine 143 <== SourceLine 1510
                if(VALUE$((!(IS$(dentry,Common$record.class))))) {
                    // JavaLine 145 <== SourceLine 1511
                    dentry=new Pass2$CompoundStatement21$SubBlock23$get_rec(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),hilo).RESULT$;
                }
                ;
                // JavaLine 149 <== SourceLine 1512
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_RECORD$1);
                ;
                // JavaLine 152 <== SourceLine 1513
                new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$record)(dentry)).tag$2);
                ;
                // JavaLine 155 <== SourceLine 1514
                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                }
                ;
                // JavaLine 160 <== SourceLine 1515
                new Pass2$CompoundStatement21$SubBlock23$outstruct(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$record)(dentry)),new Head$(((Pass2)(CUR$.SL$.SL$)).inspect$20$141).STM$());
                ;
                // JavaLine 163 <== SourceLine 1516
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ENDRECORD$1);
                ;
            }
        } else
        // JavaLine 168 <== SourceLine 1517
        new Common$IERR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141);
        ;
        // JavaLine 171 <== SourceLine 1518
        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
            new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure outdefault",1,1483,11,1484,41,1485,43,1486,47,1487,52,1488,56,1489,61,1490,65,1491,70,1492,78,1493,80,1494,86,1495,88,1496,94,1497,96,1498,102,1499,104,1500,110,1501,112,1502,118,1503,120,1504,126,1505,128,1506,134,1507,136,1508,140,1509,143,1510,145,1511,149,1512,152,1513,155,1514,160,1515,163,1516,168,1517,171,1518,178,1519);
} // End of Procedure
