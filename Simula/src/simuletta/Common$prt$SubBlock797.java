// JavaLine 1 <== SourceLine 797
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:22:27 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock797 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=797, lastLine=817, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common$descr d=null;
    Common$variant v=null;
    // Normal Constructor
    public Common$prt$SubBlock797(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 19 <== SourceLine 798
        new Common$prt$outName(((Common$prt)(CUR$.SL$)),new TXT$("Record "));
        ;
        // JavaLine 22 <== SourceLine 799
        if(VALUE$((((Common$record)(((Common$prt)(CUR$.SL$)).inspect$790$16)).prefbox$3!=(null)))) {
            // JavaLine 24 <== SourceLine 800
            sysout().outtext(CONC(new TXT$(":"),((Common$record)(((Common$prt)(CUR$.SL$)).inspect$790$16)).prefbox$3.symbol));
        }
        ;
        sysout().outchar(';');
        ;
        // JavaLine 30 <== SourceLine 801
        if(VALUE$(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$790$16)).used_as_type$3)) {
            sysout().outtext(new TXT$("   info \"TYPE\";"));
        }
        ;
        // JavaLine 35 <== SourceLine 802
        if(VALUE$(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$790$16)).dynamic$3)) {
            sysout().outtext(new TXT$("   info \"DYNAMIC\";"));
        }
        ;
        // JavaLine 40 <== SourceLine 803
        sysout().outimage();
        ;
        sysout().setpos(((Common$prt)(CUR$.SL$)).p$pos);
        ;
        sysout().outtext(new TXT$("begin "));
        ;
        // JavaLine 47 <== SourceLine 804
        if(VALUE$(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$790$16)).atrset$3.empty())) {
            // JavaLine 49 <== SourceLine 805
            sysout().outimage();
        } else
        for(boolean CB$805:new ForList(
            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){d=(Common$descr)x$; return(x$);};  public Link$ get(){return((Link$)d); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$790$16)).atrset$3.first()); }})
           ,new WhileElt<Common$descr>(new NAME$<Common$descr>(){ public Common$descr put(Common$descr x$){d=x$; return(x$);};  public Common$descr get(){return((Common$descr)d); }	},new NAME$<Common$descr>() { public Common$descr get(){return(((Common$descr)(d.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((d!=(null))); }})
           )) { if(!CB$805) continue;
        new Common$prt(((Common)(CUR$.SL$.SL$)),d,Math.addExact(Math.addExact(((Common$prt)(CUR$.SL$)).p$pos,6),1));
    }
    ;
    // JavaLine 59 <== SourceLine 806
    if(VALUE$((!(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$790$16)).variantset$3.empty())))) {
        // JavaLine 61 <== SourceLine 807
        {
            for(boolean CB$807:new ForList(
                new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){v=(Common$variant)x$; return(x$);};  public Link$ get(){return((Link$)v); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$790$16)).variantset$3.first()); }})
               ,new WhileElt<Common$variant>(new NAME$<Common$variant>(){ public Common$variant put(Common$variant x$){v=x$; return(x$);};  public Common$variant get(){return((Common$variant)v); }	},new NAME$<Common$variant>() { public Common$variant get(){return(((Common$variant)(v.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((v!=(null))); }})
               )) { if(!CB$807) continue;
            // JavaLine 67 <== SourceLine 808
            {
                sysout().setpos(Math.addExact(((Common$prt)(CUR$.SL$)).p$pos,6));
                ;
                sysout().outtext(new TXT$("Variant"));
                ;
                sysout().outimage();
                ;
                // JavaLine 75 <== SourceLine 809
                if(VALUE$((!(v.atrset$2.empty())))) {
                    // JavaLine 77 <== SourceLine 810
                    {
                        for(boolean CB$810:new ForList(
                            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){d=(Common$descr)x$; return(x$);};  public Link$ get(){return((Link$)d); }	},new NAME$<Link$>() { public Link$ get(){return(v.atrset$2.first()); }})
                           ,new WhileElt<Common$descr>(new NAME$<Common$descr>(){ public Common$descr put(Common$descr x$){d=x$; return(x$);};  public Common$descr get(){return((Common$descr)d); }	},new NAME$<Common$descr>() { public Common$descr get(){return(((Common$descr)(d.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((d!=(null))); }})
                           )) { if(!CB$810) continue;
                        // JavaLine 83 <== SourceLine 811
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
// JavaLine 96 <== SourceLine 815
sysout().setpos(((Common$prt)(CUR$.SL$)).p$pos);
;
sysout().outtext(new TXT$("end;"));
;
sysout().outimage();
;
EBLK();
return(this);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock797",1,797,19,798,22,799,24,800,30,801,35,802,40,803,47,804,49,805,59,806,61,807,67,808,75,809,77,810,83,811,96,815,105,817);
} // End of SubBlock
