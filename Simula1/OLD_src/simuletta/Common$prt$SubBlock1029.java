// JavaLine 1 <== SourceLine 1029
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock1029 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=1029, lastLine=1034, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common$descr d=null;
    // Normal Constructor
    public Common$prt$SubBlock1029(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        sysout().outtext(new TXT$("begin"));
        ;
        // JavaLine 20 <== SourceLine 1030
        if(VALUE$(((Head$)((Common$prt)(CUR$.SL$)).inspect$804$16).empty())) {
            // JavaLine 22 <== SourceLine 1031
            sysout().outimage();
        } else
        for(boolean CB$1031:new ForList(
            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){d=(Common$descr)x$; return(x$);};  public Link$ get(){return((Link$)d); }	},new NAME$<Link$>() { public Link$ get(){return(((Head$)((Common$prt)(CUR$.SL$)).inspect$804$16).first()); }})
           ,new WhileElt<Common$descr>(new NAME$<Common$descr>(){ public Common$descr put(Common$descr x$){d=x$; return(x$);};  public Common$descr get(){return((Common$descr)d); }	},new NAME$<Common$descr>() { public Common$descr get(){return(((Common$descr)(d.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((d!=(null))); }})
           )) { if(!CB$1031) continue;
        new Common$prt(((Common)(CUR$.SL$.SL$)),d,Math.addExact(((Common$prt)(CUR$.SL$)).p$pos,6));
    }
    ;
    // JavaLine 32 <== SourceLine 1032
    sysout().setpos(((Common$prt)(CUR$.SL$)).p$pos);
    ;
    sysout().outtext(new TXT$("end;"));
    ;
    sysout().outimage();
    ;
    EBLK();
    return(this);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock1029",1,1029,20,1030,22,1031,32,1032,41,1034);
} // End of SubBlock
