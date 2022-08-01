// JavaLine 1 <== SourceLine 165
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:53 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$out_descr$prepare_quant extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=165, lastLine=186, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common$quant p$q;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 166
    Linkage$ dentry=null;
    // JavaLine 13 <== SourceLine 167
    int varhi=0;
    int varlo=0;
    // JavaLine 16 <== SourceLine 168
    Common$quant inspect$168$159=null;
    // JavaLine 18 <== SourceLine 169
    PrintFile$ inspect$169$160=null;
    // JavaLine 20 <== SourceLine 173
    Common$TypeNotice inspect$172$161=null;
    // JavaLine 22 <== SourceLine 177
    Common$record inspect$177$162=null;
    // JavaLine 24 <== SourceLine 182
    PrintFile$ inspect$182$163=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$out_descr$prepare_quant setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$out_descr$prepare_quant.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public Pass2$CompoundStatement21$SubBlock23$out_descr$prepare_quant(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$out_descr$prepare_quant(RTObject$ SL$,Common$quant sp$q) {
        super(SL$);
        // Parameter assignment to locals
        this.p$q = sp$q;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$out_descr$prepare_quant STM$() {
        // JavaLine 53 <== SourceLine 168
        {
            // BEGIN INSPECTION 
            inspect$168$159=p$q;
            if(inspect$168$159!=null) // INSPECT inspect$168$159
            // JavaLine 58 <== SourceLine 169
            {
                if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).tracemode>(3)))) {
                    {
                        // BEGIN INSPECTION 
                        inspect$169$160=sysout();
                        if(inspect$169$160!=null) // INSPECT inspect$169$160
                        // JavaLine 65 <== SourceLine 170
                        {
                            inspect$169$160.outtext(CONC(new TXT$("Begin prepare "),inspect$168$159.symb$2.symbol));
                            ;
                            inspect$169$160.outimage();
                            ;
                        }
                    }
                }
                ;
                // JavaLine 75 <== SourceLine 172
                {
                    // BEGIN INSPECTION 
                    inspect$172$161=((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.typeTable.Elt[inspect$168$159.p3$type-((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.typeTable.LB[0]];
                    if(inspect$172$161!=null) // INSPECT inspect$172$161
                    // JavaLine 80 <== SourceLine 173
                    if(VALUE$((inspect$172$161.p2$set==(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.structTypes$1)))) {
                        // JavaLine 82 <== SourceLine 174
                        {
                            dentry=((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.symtab.Elt[inspect$172$161.p2$qual-((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
                            ;
                            // JavaLine 86 <== SourceLine 175
                            if(VALUE$((!(IS$(dentry,Common$record.class))))) {
                                // JavaLine 88 <== SourceLine 176
                                dentry=new Pass2$CompoundStatement21$SubBlock23$get_rec(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)),inspect$172$161.p2$qual).RESULT$;
                            }
                            ;
                            // JavaLine 92 <== SourceLine 177
                            {
                                // BEGIN INSPECTION 
                                inspect$177$162=((Common$record)(dentry));
                                if(inspect$177$162!=null) // INSPECT inspect$177$162
                                // JavaLine 97 <== SourceLine 178
                                {
                                    if(VALUE$((inspect$177$162.tag$2==(0)))) {
                                        new Pass2$CompoundStatement21$SubBlock23$out_descr(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)),((Common$record)inspect$177$162));
                                    }
                                    ;
                                    // JavaLine 103 <== SourceLine 179
                                    if(VALUE$((inspect$177$162.tag$2==(0)))) {
                                        new Common$ERROR(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,new TXT$("Declaration loop"));
                                    }
                                    ;
                                }
                            }
                            ;
                        }
                    }
                }
                ;
                // JavaLine 115 <== SourceLine 181
                inspect$168$159.preped$3=true;
                ;
                // JavaLine 118 <== SourceLine 182
                if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)).tracemode>(3)))) {
                    {
                        // BEGIN INSPECTION 
                        inspect$182$163=sysout();
                        if(inspect$182$163!=null) // INSPECT inspect$182$163
                        // JavaLine 124 <== SourceLine 183
                        {
                            inspect$182$163.outtext(CONC(new TXT$("End prepare "),inspect$168$159.symb$2.symbol));
                            ;
                            inspect$182$163.outimage();
                            ;
                        }
                    }
                }
                ;
            }
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure prepare_quant",1,165,11,166,13,167,16,168,18,169,20,173,22,177,24,182,53,168,58,169,65,170,75,172,80,173,82,174,86,175,88,176,92,177,97,178,103,179,115,181,118,182,124,183,139,186);
} // End of Procedure
