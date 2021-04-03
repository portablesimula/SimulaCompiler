// JavaLine 1 <== SourceLine 1022
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:46:15 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock1022 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=1022, lastLine=1027, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common$descr d=null;
    // Normal Constructor
    public Common$prt$SubBlock1022(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        sysout().outtext(new TXT$("begin"));
        ;
        // JavaLine 20 <== SourceLine 1023
        if(VALUE$(((Head$)((Common$prt)(CUR$.SL$)).inspect$795$16).empty())) {
            // JavaLine 22 <== SourceLine 1024
            sysout().outimage();
        } else
        for(boolean CB$1024:new ForList(
            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){d=(Common$descr)x$; return(x$);};  public Link$ get(){return((Link$)d); }	},new NAME$<Link$>() { public Link$ get(){return(((Head$)((Common$prt)(CUR$.SL$)).inspect$795$16).first()); }})
           ,new WhileElt<Common$descr>(new NAME$<Common$descr>(){ public Common$descr put(Common$descr x$){d=x$; return(x$);};  public Common$descr get(){return((Common$descr)d); }	},new NAME$<Common$descr>() { public Common$descr get(){return(((Common$descr)(d.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((d!=(null))); }})
           )) { if(!CB$1024) continue;
        new Common$prt(((Common)(CUR$.SL$.SL$)),d,Math.addExact(((Common$prt)(CUR$.SL$)).p$pos,6));
    }
    ;
    // JavaLine 32 <== SourceLine 1025
    sysout().setpos(((Common$prt)(CUR$.SL$)).p$pos);
    ;
    sysout().outtext(new TXT$("end;"));
    ;
    sysout().outimage();
    ;
    EBLK();
    return(this);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock1022",1,1022,20,1023,22,1024,32,1025,41,1027);
} // End of SubBlock
