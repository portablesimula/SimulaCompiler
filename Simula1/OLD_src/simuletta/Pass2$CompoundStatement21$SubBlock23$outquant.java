// JavaLine 1 <== SourceLine 1879
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$outquant extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=1879, lastLine=1922, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common$quant p$q;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 1880
    Linkage$ dentry=null;
    // JavaLine 13 <== SourceLine 1881
    Common$TypeNotice inspect$1881$223=null;
    Common$TypeSet inspect$1881$224=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$outquant setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$outquant.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$q=(Common$quant)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$outquant(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$outquant(RTObject$ SL$,Common$quant sp$q) {
        super(SL$);
        // Parameter assignment to locals
        this.p$q = sp$q;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$outquant STM$() {
        {
            // BEGIN INSPECTION 
            inspect$1881$223=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$q.p3$type-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]];
            if(inspect$1881$223!=null) // INSPECT inspect$1881$223
            {
                // BEGIN INSPECTION 
                inspect$1881$224=inspect$1881$223.p2$set;
                if(inspect$1881$224!=null) // INSPECT inspect$1881$224
                // JavaLine 51 <== SourceLine 1882
                {
                    switch(inspect$1881$224.p2$type) { // BEGIN SWITCH STATEMENT
                    case 6: 
                    // JavaLine 55 <== SourceLine 1884
                    new OuptFile$uttag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_GADDR$1);
                    break;
                    case 4: 
                    // JavaLine 59 <== SourceLine 1886
                    new OuptFile$uttag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_AADDR$1);
                    break;
                    case 5: 
                    // JavaLine 63 <== SourceLine 1888
                    new OuptFile$uttag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_OADDR$1);
                    break;
                    case 7: 
                    // JavaLine 67 <== SourceLine 1890
                    new OuptFile$uttag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_RADDR$1);
                    break;
                    case 2: 
                    // JavaLine 71 <== SourceLine 1892
                    {
                        if(VALUE$((inspect$1881$223.p2$qual==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_SHORT$1)))) {
                            // JavaLine 74 <== SourceLine 1894
                            new OuptFile$uttag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_SINT$1);
                        } else
                        {
                            new OuptFile$uttag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_INT$1);
                            ;
                            // JavaLine 80 <== SourceLine 1895
                            if(VALUE$((inspect$1881$223.p2$qual==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_RANGE$1)))) {
                                // JavaLine 82 <== SourceLine 1896
                                {
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_RANGE$1);
                                    ;
                                    // JavaLine 86 <== SourceLine 1897
                                    new OuptFile$outnumber(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$1881$223.p2$info1);
                                    ;
                                    new OuptFile$outnumber(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$1881$223.p2$info2);
                                    ;
                                }
                            }
                            ;
                        }
                        ;
                    }
                    break;
                    case 1: 
                    // JavaLine 99 <== SourceLine 1908
                    new OuptFile$uttag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,(((inspect$1881$223.p2$qual==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_REAL$1)))?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_REAL$1):((((inspect$1881$223.p2$qual==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_LONG$1)))?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_LREAL$1):((((inspect$1881$223.p2$qual==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_SIZE$1)))?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_SIZE$1):((((inspect$1881$223.p2$qual==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_CHAR$1)))?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_CHAR$1):((((inspect$1881$223.p2$qual==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_BOOLEAN$1)))?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_BOOL$1):((((inspect$1881$223.p2$qual==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_LABEL$1)))?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_PADDR$1):(0)))))))))))));
                    break;
                    case 3: 
                    // JavaLine 103 <== SourceLine 1910
                    {
                        dentry=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[inspect$1881$223.p2$qual-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
                        ;
                        // JavaLine 107 <== SourceLine 1911
                        if(VALUE$((!(IS$(dentry,Common$record.class))))) {
                            // JavaLine 109 <== SourceLine 1912
                            dentry=new Pass2$CompoundStatement21$SubBlock23$get_rec(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),inspect$1881$223.p2$qual).RESULT$;
                        }
                        ;
                        // JavaLine 113 <== SourceLine 1913
                        new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$record)(dentry)).tag$2);
                        ;
                        // JavaLine 116 <== SourceLine 1914
                        if(VALUE$((inspect$1881$223.p2$info1>(0)))) {
                            // JavaLine 118 <== SourceLine 1915
                            {
                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_FIXREP$1);
                                ;
                                new OuptFile$outnumber(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,Math.subtractExact(inspect$1881$223.p2$info1,1));
                            }
                        }
                        ;
                    }
                    break;
                    default:
                    // JavaLine 129 <== SourceLine 1917
                    new Common$IERR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141);
                    break;
                } // END SWITCH STATEMENT
                ;
            }
        }
    }
    ;
    // JavaLine 138 <== SourceLine 1920
    if(VALUE$((p$q.count$3!=(1)))) {
        // JavaLine 140 <== SourceLine 1921
        {
            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_REP$1);
            ;
            new OuptFile$outnumber(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,p$q.count$3);
        }
    }
    ;
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure outquant",1,1879,11,1880,13,1881,51,1882,55,1884,59,1886,63,1888,67,1890,71,1892,74,1894,80,1895,82,1896,86,1897,99,1908,103,1910,107,1911,109,1912,113,1913,116,1914,118,1915,129,1917,138,1920,140,1921,150,1922);
} // End of Procedure
