// JavaLine 1 <== SourceLine 765
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:22:27 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$prt_parspec$SubBlock765 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=4, firstLine=765, lastLine=779, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common$quant q=null;
    // Normal Constructor
    public Common$prt$prt_parspec$SubBlock765(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 18 <== SourceLine 766
        if(VALUE$((((Common$prt$prt_parspec)(CUR$.SL$)).inspect$764$14.import$!=(null)))) {
            // JavaLine 20 <== SourceLine 767
            {
                sysout().setpos(((Common$prt$prt_parspec)(CUR$.SL$)).p$pos);
                ;
                sysout().outtext(new TXT$("import"));
                ;
                // JavaLine 26 <== SourceLine 768
                for(boolean CB$768:new ForList(
                    new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){q=(Common$quant)x$; return(x$);};  public Link$ get(){return((Link$)q); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$prt$prt_parspec)(CUR$.SL$)).inspect$764$14.import$.first()); }})
                   ,new WhileElt<Common$quant>(new NAME$<Common$quant>(){ public Common$quant put(Common$quant x$){q=x$; return(x$);};  public Common$quant get(){return((Common$quant)q); }	},new NAME$<Common$quant>() { public Common$quant get(){return(((Common$quant)(q.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((q!=(null))); }})
                   )) { if(!CB$768) continue;
                // JavaLine 31 <== SourceLine 769
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
    // JavaLine 42 <== SourceLine 771
    if(VALUE$((((Common$prt$prt_parspec)(CUR$.SL$)).inspect$764$14.export!=(null)))) {
        // JavaLine 44 <== SourceLine 772
        {
            sysout().setpos(((Common$prt$prt_parspec)(CUR$.SL$)).p$pos);
            ;
            sysout().outtext(new TXT$("export"));
            ;
            // JavaLine 50 <== SourceLine 773
            new Common$prt(((Common)(CUR$.SL$.SL$.SL$)),((Common$prt$prt_parspec)(CUR$.SL$)).inspect$764$14.export,Math.addExact(((Common$prt$prt_parspec)(CUR$.SL$)).p$pos,8));
            ;
            sysout().outimage();
            ;
        }
    } else
    // JavaLine 57 <== SourceLine 775
    if(VALUE$((((Common$prt$prt_parspec)(CUR$.SL$)).inspect$764$14.exit!=(null)))) {
        // JavaLine 59 <== SourceLine 776
        {
            sysout().setpos(((Common$prt$prt_parspec)(CUR$.SL$)).p$pos);
            ;
            sysout().outtext(new TXT$("exit"));
            ;
            // JavaLine 65 <== SourceLine 777
            new Common$prt(((Common)(CUR$.SL$.SL$.SL$)),((Common$prt$prt_parspec)(CUR$.SL$)).inspect$764$14.exit,Math.addExact(((Common$prt$prt_parspec)(CUR$.SL$)).p$pos,8));
            ;
            sysout().outimage();
            ;
        }
    }
    ;
    EBLK();
    return(this);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock765",1,765,18,766,20,767,26,768,31,769,42,771,44,772,50,773,57,775,59,776,65,777,75,779);
} // End of SubBlock
