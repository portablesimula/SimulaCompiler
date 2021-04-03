// JavaLine 1 <== SourceLine 802
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:46:15 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock802 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=802, lastLine=822, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common$descr d=null;
    Common$variant v=null;
    // Normal Constructor
    public Common$prt$SubBlock802(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 19 <== SourceLine 803
        new Common$prt$outName(((Common$prt)(CUR$.SL$)),new TXT$("Record "));
        ;
        // JavaLine 22 <== SourceLine 804
        if(VALUE$((((Common$record)(((Common$prt)(CUR$.SL$)).inspect$795$16)).prefbox$3!=(null)))) {
            // JavaLine 24 <== SourceLine 805
            sysout().outtext(CONC(new TXT$(":"),((Common$record)(((Common$prt)(CUR$.SL$)).inspect$795$16)).prefbox$3.symbol));
        }
        ;
        sysout().outchar(';');
        ;
        // JavaLine 30 <== SourceLine 806
        if(VALUE$(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$795$16)).used_as_type$3)) {
            sysout().outtext(new TXT$("   info \"TYPE\";"));
        }
        ;
        // JavaLine 35 <== SourceLine 807
        if(VALUE$(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$795$16)).dynamic$3)) {
            sysout().outtext(new TXT$("   info \"DYNAMIC\";"));
        }
        ;
        // JavaLine 40 <== SourceLine 808
        sysout().outimage();
        ;
        sysout().setpos(((Common$prt)(CUR$.SL$)).p$pos);
        ;
        sysout().outtext(new TXT$("begin "));
        ;
        // JavaLine 47 <== SourceLine 809
        if(VALUE$(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$795$16)).atrset$3.empty())) {
            // JavaLine 49 <== SourceLine 810
            sysout().outimage();
        } else
        for(boolean CB$810:new ForList(
            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){d=(Common$descr)x$; return(x$);};  public Link$ get(){return((Link$)d); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$795$16)).atrset$3.first()); }})
           ,new WhileElt<Common$descr>(new NAME$<Common$descr>(){ public Common$descr put(Common$descr x$){d=x$; return(x$);};  public Common$descr get(){return((Common$descr)d); }	},new NAME$<Common$descr>() { public Common$descr get(){return(((Common$descr)(d.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((d!=(null))); }})
           )) { if(!CB$810) continue;
        new Common$prt(((Common)(CUR$.SL$.SL$)),d,Math.addExact(Math.addExact(((Common$prt)(CUR$.SL$)).p$pos,6),1));
    }
    ;
    // JavaLine 59 <== SourceLine 811
    if(VALUE$((!(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$795$16)).variantset$3.empty())))) {
        // JavaLine 61 <== SourceLine 812
        {
            for(boolean CB$812:new ForList(
                new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){v=(Common$variant)x$; return(x$);};  public Link$ get(){return((Link$)v); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$795$16)).variantset$3.first()); }})
               ,new WhileElt<Common$variant>(new NAME$<Common$variant>(){ public Common$variant put(Common$variant x$){v=x$; return(x$);};  public Common$variant get(){return((Common$variant)v); }	},new NAME$<Common$variant>() { public Common$variant get(){return(((Common$variant)(v.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((v!=(null))); }})
               )) { if(!CB$812) continue;
            // JavaLine 67 <== SourceLine 813
            {
                sysout().setpos(Math.addExact(((Common$prt)(CUR$.SL$)).p$pos,6));
                ;
                sysout().outtext(new TXT$("Variant"));
                ;
                sysout().outimage();
                ;
                // JavaLine 75 <== SourceLine 814
                if(VALUE$((!(v.atrset$2.empty())))) {
                    // JavaLine 77 <== SourceLine 815
                    {
                        for(boolean CB$815:new ForList(
                            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){d=(Common$descr)x$; return(x$);};  public Link$ get(){return((Link$)d); }	},new NAME$<Link$>() { public Link$ get(){return(v.atrset$2.first()); }})
                           ,new WhileElt<Common$descr>(new NAME$<Common$descr>(){ public Common$descr put(Common$descr x$){d=x$; return(x$);};  public Common$descr get(){return((Common$descr)d); }	},new NAME$<Common$descr>() { public Common$descr get(){return(((Common$descr)(d.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((d!=(null))); }})
                           )) { if(!CB$815) continue;
                        // JavaLine 83 <== SourceLine 816
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
// JavaLine 96 <== SourceLine 820
sysout().setpos(((Common$prt)(CUR$.SL$)).p$pos);
;
sysout().outtext(new TXT$("end;"));
;
sysout().outimage();
;
EBLK();
return(this);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock802",1,802,19,803,22,804,24,805,30,806,35,807,40,808,47,809,49,810,59,811,61,812,67,813,75,814,77,815,83,816,96,820,105,822);
} // End of SubBlock
