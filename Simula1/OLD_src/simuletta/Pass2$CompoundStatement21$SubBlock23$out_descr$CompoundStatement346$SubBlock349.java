// JavaLine 1 <== SourceLine 349
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:53 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$out_descr$CompoundStatement346$SubBlock349 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=4, firstLine=349, lastLine=360, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common$const$ e=null;
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$out_descr$CompoundStatement346$SubBlock349(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 18 <== SourceLine 350
        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_CONST$1);
        ;
        new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Common$quant)(((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$.SL$)).inspect$203$165)).tag$2);
        ;
        // JavaLine 23 <== SourceLine 351
        new Pass2$CompoundStatement21$SubBlock23$outquant(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)),((Common$quant)((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$.SL$)).inspect$203$165));
        ;
        // JavaLine 26 <== SourceLine 352
        if(VALUE$((((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
            new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143);
        }
        ;
        // JavaLine 31 <== SourceLine 353
        if(VALUE$((((Common$quant)(((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$.SL$)).inspect$203$165)).initval$3==(null)))) {
            // JavaLine 33 <== SourceLine 354
            new Pass2$CompoundStatement21$SubBlock23$outdefault(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)),((Common$quant)(((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$.SL$)).inspect$203$165)).p3$type);
        } else
        for(boolean CB$354:new ForList(
            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){e=(Common$const$)x$; return(x$);};  public Link$ get(){return((Link$)e); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$quant)(((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$.SL$)).inspect$203$165)).initval$3.first()); }})
           ,new WhileElt<Common$const$>(new NAME$<Common$const$>(){ public Common$const$ put(Common$const$ x$){e=x$; return(x$);};  public Common$const$ get(){return((Common$const$)e); }	},new NAME$<Common$const$>() { public Common$const$ get(){return(((Common$const$)(e.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((e!=(null))); }})
           )) { if(!CB$354) continue;
        // JavaLine 40 <== SourceLine 355
        {
            ((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$.SL$)).typ=new Pass2$CompoundStatement21$SubBlock23$outconst(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)),e).RESULT$;
            ;
            // JavaLine 44 <== SourceLine 356
            if(VALUE$((((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$.SL$)).typ!=(((Common$quant)(((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$.SL$)).inspect$203$165)).p3$type)))) {
                new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)),((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$.SL$)).typ,((Common$quant)(((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$.SL$)).inspect$203$165)).p3$type);
            }
            ;
        }
    }
    ;
    // JavaLine 52 <== SourceLine 357
    ((Common$quant)(((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$.SL$)).inspect$203$165)).initval$3=null;
    ;
    // JavaLine 55 <== SourceLine 358
    if(VALUE$((((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143);
    }
    ;
    EBLK();
    return(this);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","SubBlock SubBlock349",1,349,18,350,23,351,26,352,31,353,33,354,40,355,44,356,52,357,55,358,62,360);
} // End of SubBlock
