// JavaLine 1 <== SourceLine 779
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$prt_parspec$SubBlock779 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=4, firstLine=779, lastLine=793, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common$quant q=null;
    // Normal Constructor
    public Common$prt$prt_parspec$SubBlock779(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 18 <== SourceLine 780
        if(VALUE$((((Common$prt$prt_parspec)(CUR$.SL$)).inspect$778$14.import$!=(null)))) {
            // JavaLine 20 <== SourceLine 781
            {
                sysout().setpos(((Common$prt$prt_parspec)(CUR$.SL$)).p$pos);
                ;
                sysout().outtext(new TXT$("import"));
                ;
                // JavaLine 26 <== SourceLine 782
                for(boolean CB$782:new ForList(
                    new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){q=(Common$quant)x$; return(x$);};  public Link$ get(){return((Link$)q); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$prt$prt_parspec)(CUR$.SL$)).inspect$778$14.import$.first()); }})
                   ,new WhileElt<Common$quant>(new NAME$<Common$quant>(){ public Common$quant put(Common$quant x$){q=x$; return(x$);};  public Common$quant get(){return((Common$quant)q); }	},new NAME$<Common$quant>() { public Common$quant get(){return(((Common$quant)(q.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((q!=(null))); }})
                   )) { if(!CB$782) continue;
                // JavaLine 31 <== SourceLine 783
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
    // JavaLine 42 <== SourceLine 785
    if(VALUE$((((Common$prt$prt_parspec)(CUR$.SL$)).inspect$778$14.export!=(null)))) {
        // JavaLine 44 <== SourceLine 786
        {
            sysout().setpos(((Common$prt$prt_parspec)(CUR$.SL$)).p$pos);
            ;
            sysout().outtext(new TXT$("export"));
            ;
            // JavaLine 50 <== SourceLine 787
            new Common$prt(((Common)(CUR$.SL$.SL$.SL$)),((Common$prt$prt_parspec)(CUR$.SL$)).inspect$778$14.export,Math.addExact(((Common$prt$prt_parspec)(CUR$.SL$)).p$pos,8));
            ;
            sysout().outimage();
            ;
        }
    } else
    // JavaLine 57 <== SourceLine 789
    if(VALUE$((((Common$prt$prt_parspec)(CUR$.SL$)).inspect$778$14.exit!=(null)))) {
        // JavaLine 59 <== SourceLine 790
        {
            sysout().setpos(((Common$prt$prt_parspec)(CUR$.SL$)).p$pos);
            ;
            sysout().outtext(new TXT$("exit"));
            ;
            // JavaLine 65 <== SourceLine 791
            new Common$prt(((Common)(CUR$.SL$.SL$.SL$)),((Common$prt$prt_parspec)(CUR$.SL$)).inspect$778$14.exit,Math.addExact(((Common$prt$prt_parspec)(CUR$.SL$)).p$pos,8));
            ;
            sysout().outimage();
            ;
        }
    }
    ;
    EBLK();
    return(this);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock779",1,779,18,780,20,781,26,782,31,783,42,785,44,786,50,787,57,789,59,790,65,791,75,793);
} // End of SubBlock
