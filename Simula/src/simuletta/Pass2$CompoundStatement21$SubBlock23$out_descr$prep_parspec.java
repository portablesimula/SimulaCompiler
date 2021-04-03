// JavaLine 1 <== SourceLine 189
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:53 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$out_descr$prep_parspec extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=189, lastLine=198, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common$parspec p$s;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 190
    Common$quant q=null;
    // JavaLine 13 <== SourceLine 191
    Common$parspec inspect$191$164=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$out_descr$prep_parspec setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$out_descr$prep_parspec.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$s=(Common$parspec)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$out_descr$prep_parspec(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$out_descr$prep_parspec(RTObject$ SL$,Common$parspec sp$s) {
        super(SL$);
        // Parameter assignment to locals
        this.p$s = sp$s;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$out_descr$prep_parspec STM$() {
        {
            // BEGIN INSPECTION 
            inspect$191$164=p$s;
            if(inspect$191$164!=null) // INSPECT inspect$191$164
            // JavaLine 46 <== SourceLine 192
            {
                if(VALUE$((inspect$191$164.import$!=(null)))) {
                    // JavaLine 49 <== SourceLine 193
                    {
                        for(boolean CB$193:new ForList(
                            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){q=(Common$quant)x$; return(x$);};  public Link$ get(){return((Link$)q); }	},new NAME$<Link$>() { public Link$ get(){return(inspect$191$164.import$.first()); }})
                           ,new WhileElt<Common$quant>(new NAME$<Common$quant>(){ public Common$quant put(Common$quant x$){q=x$; return(x$);};  public Common$quant get(){return((Common$quant)q); }	},new NAME$<Common$quant>() { public Common$quant get(){return(((Common$quant)(q.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((q!=(null))); }})
                           )) { if(!CB$193) continue;
                        // JavaLine 55 <== SourceLine 194
                        new Pass2$CompoundStatement21$SubBlock23$out_descr$prepare_quant(((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$.SL$)),q);
                    }
                    ;
                }
            }
            ;
            // JavaLine 62 <== SourceLine 196
            new Pass2$CompoundStatement21$SubBlock23$out_descr$prepare_quant(((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$.SL$)),inspect$191$164.export);
            ;
            new Pass2$CompoundStatement21$SubBlock23$out_descr$prepare_quant(((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$.SL$)),inspect$191$164.exit);
            ;
        }
    }
    ;
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure prep_parspec",1,189,11,190,13,191,46,192,49,193,55,194,62,196,72,198);
} // End of Procedure
