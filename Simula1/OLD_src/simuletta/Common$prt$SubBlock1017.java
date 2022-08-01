// JavaLine 1 <== SourceLine 1017
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:22:27 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock1017 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=1017, lastLine=1022, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common$descr d=null;
    // Normal Constructor
    public Common$prt$SubBlock1017(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        sysout().outtext(new TXT$("begin"));
        ;
        // JavaLine 20 <== SourceLine 1018
        if(VALUE$(((Head$)((Common$prt)(CUR$.SL$)).inspect$790$16).empty())) {
            // JavaLine 22 <== SourceLine 1019
            sysout().outimage();
        } else
        for(boolean CB$1019:new ForList(
            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){d=(Common$descr)x$; return(x$);};  public Link$ get(){return((Link$)d); }	},new NAME$<Link$>() { public Link$ get(){return(((Head$)((Common$prt)(CUR$.SL$)).inspect$790$16).first()); }})
           ,new WhileElt<Common$descr>(new NAME$<Common$descr>(){ public Common$descr put(Common$descr x$){d=x$; return(x$);};  public Common$descr get(){return((Common$descr)d); }	},new NAME$<Common$descr>() { public Common$descr get(){return(((Common$descr)(d.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((d!=(null))); }})
           )) { if(!CB$1019) continue;
        new Common$prt(((Common)(CUR$.SL$.SL$)),d,Math.addExact(((Common$prt)(CUR$.SL$)).p$pos,6));
    }
    ;
    // JavaLine 32 <== SourceLine 1020
    sysout().setpos(((Common$prt)(CUR$.SL$)).p$pos);
    ;
    sysout().outtext(new TXT$("end;"));
    ;
    sysout().outimage();
    ;
    EBLK();
    return(this);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock1017",1,1017,20,1018,22,1019,32,1020,41,1022);
} // End of SubBlock
