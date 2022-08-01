// JavaLine 1 <== SourceLine 795
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:20:00 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock795 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=795, lastLine=815, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common$descr d=null;
    Common$variant v=null;
    // Normal Constructor
    public Common$prt$SubBlock795(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 19 <== SourceLine 796
        new Common$prt$outName(((Common$prt)(CUR$.SL$)),new TXT$("Record "));
        ;
        // JavaLine 22 <== SourceLine 797
        if(VALUE$((((Common$record)(((Common$prt)(CUR$.SL$)).inspect$788$16)).prefbox$3!=(null)))) {
            // JavaLine 24 <== SourceLine 798
            sysout().outtext(CONC(new TXT$(":"),((Common$record)(((Common$prt)(CUR$.SL$)).inspect$788$16)).prefbox$3.symbol));
        }
        ;
        sysout().outchar(';');
        ;
        // JavaLine 30 <== SourceLine 799
        if(VALUE$(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$788$16)).used_as_type$3)) {
            sysout().outtext(new TXT$("   info \"TYPE\";"));
        }
        ;
        // JavaLine 35 <== SourceLine 800
        if(VALUE$(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$788$16)).dynamic$3)) {
            sysout().outtext(new TXT$("   info \"DYNAMIC\";"));
        }
        ;
        // JavaLine 40 <== SourceLine 801
        sysout().outimage();
        ;
        sysout().setpos(((Common$prt)(CUR$.SL$)).p$pos);
        ;
        sysout().outtext(new TXT$("begin "));
        ;
        // JavaLine 47 <== SourceLine 802
        if(VALUE$(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$788$16)).atrset$3.empty())) {
            // JavaLine 49 <== SourceLine 803
            sysout().outimage();
        } else
        for(boolean CB$803:new ForList(
            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){d=(Common$descr)x$; return(x$);};  public Link$ get(){return((Link$)d); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$788$16)).atrset$3.first()); }})
           ,new WhileElt<Common$descr>(new NAME$<Common$descr>(){ public Common$descr put(Common$descr x$){d=x$; return(x$);};  public Common$descr get(){return((Common$descr)d); }	},new NAME$<Common$descr>() { public Common$descr get(){return(((Common$descr)(d.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((d!=(null))); }})
           )) { if(!CB$803) continue;
        new Common$prt(((Common)(CUR$.SL$.SL$)),d,Math.addExact(Math.addExact(((Common$prt)(CUR$.SL$)).p$pos,6),1));
    }
    ;
    // JavaLine 59 <== SourceLine 804
    if(VALUE$((!(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$788$16)).variantset$3.empty())))) {
        // JavaLine 61 <== SourceLine 805
        {
            for(boolean CB$805:new ForList(
                new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){v=(Common$variant)x$; return(x$);};  public Link$ get(){return((Link$)v); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$788$16)).variantset$3.first()); }})
               ,new WhileElt<Common$variant>(new NAME$<Common$variant>(){ public Common$variant put(Common$variant x$){v=x$; return(x$);};  public Common$variant get(){return((Common$variant)v); }	},new NAME$<Common$variant>() { public Common$variant get(){return(((Common$variant)(v.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((v!=(null))); }})
               )) { if(!CB$805) continue;
            // JavaLine 67 <== SourceLine 806
            {
                sysout().setpos(Math.addExact(((Common$prt)(CUR$.SL$)).p$pos,6));
                ;
                sysout().outtext(new TXT$("Variant"));
                ;
                sysout().outimage();
                ;
                // JavaLine 75 <== SourceLine 807
                if(VALUE$((!(v.atrset$2.empty())))) {
                    // JavaLine 77 <== SourceLine 808
                    {
                        for(boolean CB$808:new ForList(
                            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){d=(Common$descr)x$; return(x$);};  public Link$ get(){return((Link$)d); }	},new NAME$<Link$>() { public Link$ get(){return(v.atrset$2.first()); }})
                           ,new WhileElt<Common$descr>(new NAME$<Common$descr>(){ public Common$descr put(Common$descr x$){d=x$; return(x$);};  public Common$descr get(){return((Common$descr)d); }	},new NAME$<Common$descr>() { public Common$descr get(){return(((Common$descr)(d.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((d!=(null))); }})
                           )) { if(!CB$808) continue;
                        // JavaLine 83 <== SourceLine 809
                        new Common$prt(((Common)(CUR$.SL$.SL$)),d,Math.addExact(Math.addExact(((Common$prt)(CUR$.SL$)).p$pos,6),1));
                    }
                    ;
                }
            }
            ;
        }
    }
    ;
}
}
;
// JavaLine 96 <== SourceLine 813
sysout().setpos(((Common$prt)(CUR$.SL$)).p$pos);
;
sysout().outtext(new TXT$("end;"));
;
sysout().outimage();
;
EBLK();
return(this);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock795",1,795,19,796,22,797,24,798,30,799,35,800,40,801,47,802,49,803,59,804,61,805,67,806,75,807,77,808,83,809,96,813,105,815);
} // End of SubBlock
