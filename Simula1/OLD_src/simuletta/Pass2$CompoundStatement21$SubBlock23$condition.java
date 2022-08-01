// JavaLine 1 <== SourceLine 1581
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$condition extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=1581, lastLine=1606, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$b;
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 1582
    int cond=0;
    int t=0;
    int t2=0;
    boolean notseen=false;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$condition setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$condition.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$b=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$condition(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$condition(RTObject$ SL$,int sp$b) {
        super(SL$);
        // Parameter assignment to locals
        this.p$b = sp$b;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$condition STM$() {
        // JavaLine 46 <== SourceLine 1583
        cond=new Pass2$CompoundStatement21$SubBlock23$relation(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),p$b).RESULT$;
        ;
        // JavaLine 49 <== SourceLine 1584
        if(VALUE$(((p$b==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_EQ$1))||((p$b==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_NE$1)))))) {
            // JavaLine 51 <== SourceLine 1585
            {
                t=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                ;
                t2=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                ;
                // JavaLine 57 <== SourceLine 1586
                if(VALUE$((t2!=(t)))) {
                    // JavaLine 59 <== SourceLine 1587
                    new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),t2,t);
                }
            }
        } else
        if(VALUE$(((cond!=(0))&&((cond!=(10)))))) {
            // JavaLine 65 <== SourceLine 1588
            {
                t=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                ;
                // JavaLine 69 <== SourceLine 1589
                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[t-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.integerTypes$1)))) {
                    // JavaLine 71 <== SourceLine 1590
                    t=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_INT$1;
                } else
                // JavaLine 74 <== SourceLine 1591
                if(VALUE$(((((t==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REAL$1))||((t==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_LREAL$1))))||((t==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_CHAR$1))))||((t==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_SIZE$1)))))) {
                    ;
                } else
                // JavaLine 78 <== SourceLine 1593
                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[t-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.refTypes$1)))) {
                    // JavaLine 80 <== SourceLine 1594
                    new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,CONC(new TXT$("Illegal type in relation: "),new Common$edtype(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,t).RESULT$));
                }
                ;
                // JavaLine 84 <== SourceLine 1595
                t2=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                ;
                // JavaLine 87 <== SourceLine 1596
                if(VALUE$((t2!=(t)))) {
                    new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),t2,t);
                }
                ;
            }
        } else
        // JavaLine 94 <== SourceLine 1599
        {
            if(VALUE$((p$b==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_NOT$1)))) {
                {
                    p$b=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                    ;
                    notseen=true;
                }
            }
            ;
            // JavaLine 104 <== SourceLine 1600
            t2=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),p$b).RESULT$;
            ;
            // JavaLine 107 <== SourceLine 1601
            if(VALUE$((t2!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_BOOL$1)))) {
                new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),t2,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_BOOL$1);
            }
            ;
            cond=((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).K_EQ;
            ;
            // JavaLine 114 <== SourceLine 1602
            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
            ;
            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((notseen)?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_FALSE$1):(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_TRUE$1)));
            ;
        }
        ;
        // JavaLine 121 <== SourceLine 1604
        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
            new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
        }
        ;
        // JavaLine 126 <== SourceLine 1605
        RESULT$=cond;
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure condition",1,1581,14,1582,46,1583,49,1584,51,1585,57,1586,59,1587,65,1588,69,1589,71,1590,74,1591,78,1593,80,1594,84,1595,87,1596,94,1599,104,1600,107,1601,114,1602,121,1604,126,1605,131,1606);
} // End of Procedure
