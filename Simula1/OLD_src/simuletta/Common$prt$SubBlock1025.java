// JavaLine 1 <== SourceLine 1025
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 17:55:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock1025 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=1025, lastLine=1030, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common$descr d=null;
    // Normal Constructor
    public Common$prt$SubBlock1025(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        sysout().outtext(new TXT$("begin"));
        ;
        // JavaLine 20 <== SourceLine 1026
        if(VALUE$(((Head$)((Common$prt)(CUR$.SL$)).inspect$800$16).empty())) {
            // JavaLine 22 <== SourceLine 1027
            sysout().outimage();
        } else
        for(boolean CB$1027:new ForList(
            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){d=(Common$descr)x$; return(x$);};  public Link$ get(){return((Link$)d); }	},new NAME$<Link$>() { public Link$ get(){return(((Head$)((Common$prt)(CUR$.SL$)).inspect$800$16).first()); }})
           ,new WhileElt<Common$descr>(new NAME$<Common$descr>(){ public Common$descr put(Common$descr x$){d=x$; return(x$);};  public Common$descr get(){return((Common$descr)d); }	},new NAME$<Common$descr>() { public Common$descr get(){return(((Common$descr)(d.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((d!=(null))); }})
           )) { if(!CB$1027) continue;
        new Common$prt(((Common)(CUR$.SL$.SL$)),d,Math.addExact(((Common$prt)(CUR$.SL$)).p$pos,6));
    }
    ;
    // JavaLine 32 <== SourceLine 1028
    sysout().setpos(((Common$prt)(CUR$.SL$)).p$pos);
    ;
    sysout().outtext(new TXT$("end;"));
    ;
    sysout().outimage();
    ;
    EBLK();
    return(this);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock1025",1,1025,20,1026,22,1027,32,1028,41,1030);
} // End of SubBlock
