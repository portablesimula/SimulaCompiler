// JavaLine 1 <== SourceLine 1772
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$type_check extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=1772, lastLine=1843, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$t1;
    public int p$t2;
    // Declare locals as attributes
    // JavaLine 15 <== SourceLine 1773
    Common$symbolbox q1=null;
    Common$symbolbox q2=null;
    // JavaLine 18 <== SourceLine 1798
    PrintFile$ inspect$1798$220=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$type_check setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$type_check.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 2: p$t1=intValue(param); break;
                case 1: p$t2=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$type_check(RTObject$ SL$) {
        super(SL$,2); // Expecting 2 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$type_check(RTObject$ SL$,int sp$t1,int sp$t2) {
        super(SL$);
        // Parameter assignment to locals
        this.p$t1 = sp$t1;
        this.p$t2 = sp$t2;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$type_check STM$() {
        if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).tracemode>(0)))) {
            {
                // BEGIN INSPECTION 
                inspect$1798$220=sysout();
                if(inspect$1798$220!=null) // INSPECT inspect$1798$220
                // JavaLine 54 <== SourceLine 1799
                {
                    inspect$1798$220.outtext(new Pass2$CompoundStatement21$SubBlock23$type_check$msg(((Pass2$CompoundStatement21$SubBlock23$type_check)(CUR$)),copy(new TXT$("Convert "))).RESULT$);
                    ;
                    inspect$1798$220.outimage();
                }
            }
        }
        ;
        // JavaLine 63 <== SourceLine 1800
        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$t1-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.integerTypes$1)))) {
            // JavaLine 65 <== SourceLine 1801
            {
                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$t2-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.integerTypes$1)))) {
                    // JavaLine 68 <== SourceLine 1802
                    {
                        if(VALUE$((((p$t2!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REAL$1))&&((p$t2!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_LREAL$1))))&&((p$t2!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_CHAR$1)))))) {
                            // JavaLine 71 <== SourceLine 1804
                            new Pass2$CompoundStatement21$SubBlock23$type_check$converr(((Pass2$CompoundStatement21$SubBlock23$type_check)(CUR$)));
                        }
                        ;
                        RESULT$=true;
                        ;
                    }
                }
                ;
            }
        } else
        // JavaLine 82 <== SourceLine 1807
        if(VALUE$(((p$t1==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REAL$1))|((p$t1==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_LREAL$1)))))) {
            // JavaLine 84 <== SourceLine 1808
            {
                if(VALUE$(((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$t2-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.integerTypes$1))&&((!(((p$t2==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REAL$1))|((p$t2==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_LREAL$1)))))))))) {
                    // JavaLine 87 <== SourceLine 1810
                    new Pass2$CompoundStatement21$SubBlock23$type_check$converr(((Pass2$CompoundStatement21$SubBlock23$type_check)(CUR$)));
                }
                ;
                RESULT$=true;
                ;
            }
        } else
        // JavaLine 95 <== SourceLine 1812
        if(VALUE$((p$t1==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_CHAR$1)))) {
            // JavaLine 97 <== SourceLine 1813
            {
                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$t2-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.integerTypes$1)))) {
                    // JavaLine 100 <== SourceLine 1814
                    new Pass2$CompoundStatement21$SubBlock23$type_check$converr(((Pass2$CompoundStatement21$SubBlock23$type_check)(CUR$)));
                }
                ;
                RESULT$=true;
                ;
            }
        } else
        // JavaLine 108 <== SourceLine 1816
        if(VALUE$((((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$t1-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.fieldTypes$1))&&((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$t2-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.fieldTypes$1))))||(((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$t1-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.nameTypes$1))&&((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$t2-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.nameTypes$1)))))))) {
            // JavaLine 110 <== SourceLine 1821
            {
                if(VALUE$((((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$t1-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$qual!=(0))&&((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$t2-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$qual!=(0))))&&(new Pass2$CompoundStatement21$SubBlock23$type_check(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$t1-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$qual,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$t2-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$qual).RESULT$)))) {
                    // JavaLine 113 <== SourceLine 1824
                    new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new Pass2$CompoundStatement21$SubBlock23$type_check$msg(((Pass2$CompoundStatement21$SubBlock23$type_check)(CUR$)),copy(new TXT$("Qualification check fails:  "))).RESULT$);
                }
                ;
            }
        } else
        // JavaLine 119 <== SourceLine 1826
        if(VALUE$(((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$t1-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.refTypes$1))&&((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$t2-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.refTypes$1)))))) {
            // JavaLine 121 <== SourceLine 1829
            {
                q2=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$t2-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$qual-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]];
                ;
                // JavaLine 125 <== SourceLine 1830
                if(VALUE$((q2!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.dummyBox$1)))) {
                    // JavaLine 127 <== SourceLine 1831
                    {
                        q1=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$t1-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$qual-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]];
                        ;
                        // JavaLine 131 <== SourceLine 1832
                        if(VALUE$(((q1!=(q2))&&((!(new Pass2$CompoundStatement21$SubBlock23$type_check$inprefix(((Pass2$CompoundStatement21$SubBlock23$type_check)(CUR$)),q1,q2).RESULT$)))))) {
                            // JavaLine 133 <== SourceLine 1833
                            {
                                if(VALUE$(new Pass2$CompoundStatement21$SubBlock23$type_check$inprefix(((Pass2$CompoundStatement21$SubBlock23$type_check)(CUR$)),q2,q1).RESULT$)) {
                                    ;
                                } else
                                // JavaLine 138 <== SourceLine 1835
                                new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new Pass2$CompoundStatement21$SubBlock23$type_check$msg(((Pass2$CompoundStatement21$SubBlock23$type_check)(CUR$)),copy(new TXT$("qualification check fails:  "))).RESULT$);
                                ;
                            }
                        }
                        ;
                    }
                }
                ;
            }
        } else
        // JavaLine 149 <== SourceLine 1839
        if(VALUE$(((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$t1-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.entTypes$1))&&((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$t2-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.entTypes$1)))))) {
            // JavaLine 151 <== SourceLine 1841
            {
                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$t1-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$qual!=(0)))) {
                    // JavaLine 154 <== SourceLine 1842
                    new Pass2$CompoundStatement21$SubBlock23$type_check$converr(((Pass2$CompoundStatement21$SubBlock23$type_check)(CUR$)));
                }
            }
        } else
        new Pass2$CompoundStatement21$SubBlock23$type_check$converr(((Pass2$CompoundStatement21$SubBlock23$type_check)(CUR$)));
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure type_check",1,1772,15,1773,18,1798,54,1799,63,1800,65,1801,68,1802,71,1804,82,1807,84,1808,87,1810,95,1812,97,1813,100,1814,108,1816,110,1821,113,1824,119,1826,121,1829,125,1830,127,1831,131,1832,133,1833,138,1835,149,1839,151,1841,154,1842,163,1843);
} // End of Procedure
