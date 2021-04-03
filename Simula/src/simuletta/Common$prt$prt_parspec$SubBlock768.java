// JavaLine 1 <== SourceLine 768
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:26:02 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$prt_parspec$SubBlock768 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=4, firstLine=768, lastLine=782, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common$quant q=null;
    // Normal Constructor
    public Common$prt$prt_parspec$SubBlock768(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 18 <== SourceLine 769
        if(VALUE$((((Common$prt$prt_parspec)(CUR$.SL$)).inspect$767$14.import$!=(null)))) {
            // JavaLine 20 <== SourceLine 770
            {
                sysout().setpos(((Common$prt$prt_parspec)(CUR$.SL$)).p$pos);
                ;
                sysout().outtext(new TXT$("import"));
                ;
                // JavaLine 26 <== SourceLine 771
                for(boolean CB$771:new ForList(
                    new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){q=(Common$quant)x$; return(x$);};  public Link$ get(){return((Link$)q); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$prt$prt_parspec)(CUR$.SL$)).inspect$767$14.import$.first()); }})
                   ,new WhileElt<Common$quant>(new NAME$<Common$quant>(){ public Common$quant put(Common$quant x$){q=x$; return(x$);};  public Common$quant get(){return((Common$quant)q); }	},new NAME$<Common$quant>() { public Common$quant get(){return(((Common$quant)(q.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((q!=(null))); }})
                   )) { if(!CB$771) continue;
                // JavaLine 31 <== SourceLine 772
                {
                    new Common$prt(((Common)(CUR$.SL$.SL$.SL$)),q,Math.addExact(((Common$prt$prt_parspec)(CUR$.SL$)).p$pos,8));
                    ;
                    sysout().outimage();
                }
            }
            ;
        }
    }
    ;
    // JavaLine 42 <== SourceLine 774
    if(VALUE$((((Common$prt$prt_parspec)(CUR$.SL$)).inspect$767$14.export!=(null)))) {
        // JavaLine 44 <== SourceLine 775
        {
            sysout().setpos(((Common$prt$prt_parspec)(CUR$.SL$)).p$pos);
            ;
            sysout().outtext(new TXT$("export"));
            ;
            // JavaLine 50 <== SourceLine 776
            new Common$prt(((Common)(CUR$.SL$.SL$.SL$)),((Common$prt$prt_parspec)(CUR$.SL$)).inspect$767$14.export,Math.addExact(((Common$prt$prt_parspec)(CUR$.SL$)).p$pos,8));
            ;
            sysout().outimage();
            ;
        }
    } else
    // JavaLine 57 <== SourceLine 778
    if(VALUE$((((Common$prt$prt_parspec)(CUR$.SL$)).inspect$767$14.exit!=(null)))) {
        // JavaLine 59 <== SourceLine 779
        {
            sysout().setpos(((Common$prt$prt_parspec)(CUR$.SL$)).p$pos);
            ;
            sysout().outtext(new TXT$("exit"));
            ;
            // JavaLine 65 <== SourceLine 780
            new Common$prt(((Common)(CUR$.SL$.SL$.SL$)),((Common$prt$prt_parspec)(CUR$.SL$)).inspect$767$14.exit,Math.addExact(((Common$prt$prt_parspec)(CUR$.SL$)).p$pos,8));
            ;
            sysout().outimage();
            ;
        }
    }
    ;
    EBLK();
    return(this);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock768",1,768,18,769,20,770,26,771,31,772,42,774,44,775,50,776,57,778,59,779,65,780,75,782);
} // End of SubBlock
