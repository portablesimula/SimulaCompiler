// JavaLine 1 <== SourceLine 811
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock811 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=811, lastLine=831, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Common$descr d=null;
    Common$variant v=null;
    // Normal Constructor
    public Common$prt$SubBlock811(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 19 <== SourceLine 812
        new Common$prt$outName(((Common$prt)(CUR$.SL$)),new TXT$("Record "));
        ;
        // JavaLine 22 <== SourceLine 813
        if(VALUE$((((Common$record)(((Common$prt)(CUR$.SL$)).inspect$804$16)).prefbox$3!=(null)))) {
            // JavaLine 24 <== SourceLine 814
            sysout().outtext(CONC(new TXT$(":"),((Common$record)(((Common$prt)(CUR$.SL$)).inspect$804$16)).prefbox$3.symbol));
        }
        ;
        sysout().outchar(';');
        ;
        // JavaLine 30 <== SourceLine 815
        if(VALUE$(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$804$16)).used_as_type$3)) {
            sysout().outtext(new TXT$("   info \"TYPE\";"));
        }
        ;
        // JavaLine 35 <== SourceLine 816
        if(VALUE$(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$804$16)).dynamic$3)) {
            sysout().outtext(new TXT$("   info \"DYNAMIC\";"));
        }
        ;
        // JavaLine 40 <== SourceLine 817
        sysout().outimage();
        ;
        sysout().setpos(((Common$prt)(CUR$.SL$)).p$pos);
        ;
        sysout().outtext(new TXT$("begin "));
        ;
        // JavaLine 47 <== SourceLine 818
        if(VALUE$(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$804$16)).atrset$3.empty())) {
            // JavaLine 49 <== SourceLine 819
            sysout().outimage();
        } else
        for(boolean CB$819:new ForList(
            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){d=(Common$descr)x$; return(x$);};  public Link$ get(){return((Link$)d); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$804$16)).atrset$3.first()); }})
           ,new WhileElt<Common$descr>(new NAME$<Common$descr>(){ public Common$descr put(Common$descr x$){d=x$; return(x$);};  public Common$descr get(){return((Common$descr)d); }	},new NAME$<Common$descr>() { public Common$descr get(){return(((Common$descr)(d.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((d!=(null))); }})
           )) { if(!CB$819) continue;
        new Common$prt(((Common)(CUR$.SL$.SL$)),d,Math.addExact(Math.addExact(((Common$prt)(CUR$.SL$)).p$pos,6),1));
    }
    ;
    // JavaLine 59 <== SourceLine 820
    if(VALUE$((!(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$804$16)).variantset$3.empty())))) {
        // JavaLine 61 <== SourceLine 821
        {
            for(boolean CB$821:new ForList(
                new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){v=(Common$variant)x$; return(x$);};  public Link$ get(){return((Link$)v); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$record)(((Common$prt)(CUR$.SL$)).inspect$804$16)).variantset$3.first()); }})
               ,new WhileElt<Common$variant>(new NAME$<Common$variant>(){ public Common$variant put(Common$variant x$){v=x$; return(x$);};  public Common$variant get(){return((Common$variant)v); }	},new NAME$<Common$variant>() { public Common$variant get(){return(((Common$variant)(v.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((v!=(null))); }})
               )) { if(!CB$821) continue;
            // JavaLine 67 <== SourceLine 822
            {
                sysout().setpos(Math.addExact(((Common$prt)(CUR$.SL$)).p$pos,6));
                ;
                sysout().outtext(new TXT$("Variant"));
                ;
                sysout().outimage();
                ;
                // JavaLine 75 <== SourceLine 823
                if(VALUE$((!(v.atrset$2.empty())))) {
                    // JavaLine 77 <== SourceLine 824
                    {
                        for(boolean CB$824:new ForList(
                            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){d=(Common$descr)x$; return(x$);};  public Link$ get(){return((Link$)d); }	},new NAME$<Link$>() { public Link$ get(){return(v.atrset$2.first()); }})
                           ,new WhileElt<Common$descr>(new NAME$<Common$descr>(){ public Common$descr put(Common$descr x$){d=x$; return(x$);};  public Common$descr get(){return((Common$descr)d); }	},new NAME$<Common$descr>() { public Common$descr get(){return(((Common$descr)(d.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((d!=(null))); }})
                           )) { if(!CB$824) continue;
                        // JavaLine 83 <== SourceLine 825
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
// JavaLine 96 <== SourceLine 829
sysout().setpos(((Common$prt)(CUR$.SL$)).p$pos);
;
sysout().outtext(new TXT$("end;"));
;
sysout().outimage();
;
EBLK();
return(this);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock811",1,811,19,812,22,813,24,814,30,815,35,816,40,817,47,818,49,819,59,820,61,821,67,822,75,823,77,824,83,825,96,829,105,831);
} // End of SubBlock
