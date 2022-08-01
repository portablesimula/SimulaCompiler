// JavaLine 1 <== SourceLine 1846
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$outtype extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=1846, lastLine=1877, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$t;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 1847
    Linkage$ dentry=null;
    // JavaLine 13 <== SourceLine 1848
    Common$TypeNotice inspect$1848$221=null;
    Common$TypeSet inspect$1848$222=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$outtype setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$outtype.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public Pass2$CompoundStatement21$SubBlock23$outtype(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$outtype(RTObject$ SL$,int sp$t) {
        super(SL$);
        // Parameter assignment to locals
        this.p$t = sp$t;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$outtype STM$() {
        {
            // BEGIN INSPECTION 
            inspect$1848$221=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$t-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]];
            if(inspect$1848$221!=null) // INSPECT inspect$1848$221
            {
                // BEGIN INSPECTION 
                inspect$1848$222=inspect$1848$221.p2$set;
                if(inspect$1848$222!=null) // INSPECT inspect$1848$222
                // JavaLine 51 <== SourceLine 1849
                {
                    switch(inspect$1848$222.p2$type) { // BEGIN SWITCH STATEMENT
                    case 6: 
                    // JavaLine 55 <== SourceLine 1851
                    new OuptFile$uttag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_GADDR$1);
                    break;
                    case 4: 
                    // JavaLine 59 <== SourceLine 1853
                    new OuptFile$uttag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_AADDR$1);
                    break;
                    case 5: 
                    // JavaLine 63 <== SourceLine 1855
                    new OuptFile$uttag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_OADDR$1);
                    break;
                    case 7: 
                    // JavaLine 67 <== SourceLine 1857
                    new OuptFile$uttag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_RADDR$1);
                    break;
                    case 2: 
                    // JavaLine 71 <== SourceLine 1859
                    new OuptFile$uttag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_INT$1);
                    break;
                    case 1: 
                    // JavaLine 75 <== SourceLine 1867
                    new OuptFile$uttag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,(((inspect$1848$221.p2$qual==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_SIZE$1)))?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_SIZE$1):((((inspect$1848$221.p2$qual==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_CHAR$1)))?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_CHAR$1):((((inspect$1848$221.p2$qual==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_BOOLEAN$1)))?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_BOOL$1):((((inspect$1848$221.p2$qual==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_LABEL$1)))?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_PADDR$1):((((inspect$1848$221.p2$qual==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_REAL$1)))?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_REAL$1):((((inspect$1848$221.p2$qual==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_LONG$1)))?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TAG_LREAL$1):(0)))))))))))));
                    break;
                    case 3: 
                    // JavaLine 79 <== SourceLine 1869
                    {
                        dentry=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[inspect$1848$221.p2$qual-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
                        ;
                        // JavaLine 83 <== SourceLine 1870
                        if(VALUE$((!(IS$(dentry,Common$record.class))))) {
                            // JavaLine 85 <== SourceLine 1871
                            dentry=new Pass2$CompoundStatement21$SubBlock23$get_rec(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),inspect$1848$221.p2$qual).RESULT$;
                        }
                        ;
                        // JavaLine 89 <== SourceLine 1872
                        new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$record)(dentry)).tag$2);
                        ;
                    }
                    break;
                    default:
                    // JavaLine 95 <== SourceLine 1874
                    new Common$IERR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141);
                    break;
                } // END SWITCH STATEMENT
                ;
            }
        }
    }
    ;
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure outtype",1,1846,11,1847,13,1848,51,1849,55,1851,59,1853,63,1855,67,1857,71,1859,75,1867,79,1869,83,1870,85,1871,89,1872,95,1874,106,1877);
} // End of Procedure
