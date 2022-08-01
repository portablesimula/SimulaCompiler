// JavaLine 1 <== SourceLine 854
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:22:27 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock854 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=854, lastLine=906, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Link$ v=null;
    Common$expr x=null;
    boolean flg1=false;
    boolean flg2=false;
    // Normal Constructor
    public Common$prt$SubBlock854(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 21 <== SourceLine 855
        if(VALUE$((!(((Common$designator)(((Common$prt)(CUR$.SL$)).inspect$790$16)).p3$varset.empty())))) {
            // JavaLine 23 <== SourceLine 856
            {
                for(boolean CB$856:new ForList(
                    new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){v=x$; return(x$);};  public Link$ get(){return((Link$)v); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$designator)(((Common$prt)(CUR$.SL$)).inspect$790$16)).p3$varset.first()); }})
                   ,new WhileElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){v=x$; return(x$);};  public Link$ get(){return((Link$)v); }	},new NAME$<Link$>() { public Link$ get(){return(v.suc()); }},new NAME$<Boolean>() { public Boolean get(){return((v!=(null))); }})
                   )) { if(!CB$856) continue;
                // JavaLine 29 <== SourceLine 857
                {
                    // BEGIN INSPECTION 
                    ((Common$prt)(CUR$.SL$)).inspect$857$17=v;
                    //INSPECT inspect$857$17
                    if(((Common$prt)(CUR$.SL$)).inspect$857$17 instanceof Common$variable) // WHEN Common$variable DO 
                    // JavaLine 35 <== SourceLine 858
                    {
                        if(VALUE$(flg1)) {
                            sysout().outchar('.');
                        }
                        ;
                        // JavaLine 41 <== SourceLine 859
                        flg1=true;
                        ;
                        sysout().outtext(((Common$variable)(((Common$prt)(CUR$.SL$)).inspect$857$17)).varbox$2.symbol);
                        ;
                        // JavaLine 46 <== SourceLine 860
                        if(VALUE$((((Common$variable)(((Common$prt)(CUR$.SL$)).inspect$857$17)).argset$2!=(null)))) {
                            // JavaLine 48 <== SourceLine 861
                            {
                                sysout().outchar('(');
                                ;
                                flg2=false;
                                ;
                                // JavaLine 54 <== SourceLine 862
                                for(boolean CB$862:new ForList(
                                    new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){x=(Common$expr)x$; return(x$);};  public Link$ get(){return((Link$)x); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$variable)(((Common$prt)(CUR$.SL$)).inspect$857$17)).argset$2.first()); }})
                                   ,new WhileElt<Common$expr>(new NAME$<Common$expr>(){ public Common$expr put(Common$expr x$){x=x$; return(x$);};  public Common$expr get(){return((Common$expr)x); }	},new NAME$<Common$expr>() { public Common$expr get(){return(((Common$expr)(x.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((x!=(null))); }})
                                   )) { if(!CB$862) continue;
                                // JavaLine 59 <== SourceLine 864
                                {
                                    if(VALUE$(flg2)) {
                                        sysout().outchar(',');
                                    }
                                    ;
                                    // JavaLine 65 <== SourceLine 865
                                    flg2=true;
                                    ;
                                    new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
                                    ;
                                }
                            }
                            ;
                            // JavaLine 73 <== SourceLine 867
                            sysout().outchar(')');
                            ;
                        }
                    }
                    ;
                }
                else if(((Common$prt)(CUR$.SL$)).inspect$857$17 instanceof Common$varexpr) // WHEN Common$varexpr DO 
                // JavaLine 81 <== SourceLine 871
                {
                    if(VALUE$(flg1)) {
                        sysout().outchar('.');
                    }
                    ;
                    flg1=true;
                    ;
                    // JavaLine 89 <== SourceLine 872
                    sysout().outchar('(');
                    ;
                    new Common$prt(((Common)(CUR$.SL$.SL$)),((Common$varexpr)(((Common$prt)(CUR$.SL$)).inspect$857$17)).p2$vx,0);
                    ;
                    sysout().outchar(')');
                    ;
                    // JavaLine 96 <== SourceLine 873
                    if(VALUE$((((Common$varexpr)(((Common$prt)(CUR$.SL$)).inspect$857$17)).p2$argset!=(null)))) {
                        // JavaLine 98 <== SourceLine 874
                        {
                            sysout().outchar('(');
                            ;
                            flg2=false;
                            ;
                            // JavaLine 104 <== SourceLine 875
                            for(boolean CB$875:new ForList(
                                new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){x=(Common$expr)x$; return(x$);};  public Link$ get(){return((Link$)x); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$varexpr)(((Common$prt)(CUR$.SL$)).inspect$857$17)).p2$argset.first()); }})
                               ,new WhileElt<Common$expr>(new NAME$<Common$expr>(){ public Common$expr put(Common$expr x$){x=x$; return(x$);};  public Common$expr get(){return((Common$expr)x); }	},new NAME$<Common$expr>() { public Common$expr get(){return(((Common$expr)(x.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((x!=(null))); }})
                               )) { if(!CB$875) continue;
                            // JavaLine 109 <== SourceLine 877
                            {
                                if(VALUE$(flg2)) {
                                    sysout().outchar(',');
                                }
                                ;
                                // JavaLine 115 <== SourceLine 878
                                flg2=true;
                                ;
                                new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
                                ;
                            }
                        }
                        ;
                        // JavaLine 123 <== SourceLine 880
                        sysout().outchar(')');
                        ;
                    }
                }
                ;
            }
            else if(((Common$prt)(CUR$.SL$)).inspect$857$17 instanceof Common$varcall) // WHEN Common$varcall DO 
            // JavaLine 131 <== SourceLine 884
            {
                if(VALUE$(flg1)) {
                    sysout().outchar('.');
                }
                ;
                flg1=true;
                ;
                // JavaLine 139 <== SourceLine 886
                sysout().outtext(CONC(CONC(new TXT$("call "),((Common)(CUR$.SL$.SL$)).symtab.Elt[((Common$varcall)(((Common$prt)(CUR$.SL$)).inspect$857$17)).p2$prf-((Common)(CUR$.SL$.SL$)).symtab.LB[0]].symbol),new TXT$("(")));
                ;
                // JavaLine 142 <== SourceLine 887
                new Common$prt(((Common)(CUR$.SL$.SL$)),((Common$varcall)(((Common$prt)(CUR$.SL$)).inspect$857$17)).p2$vx,0);
                ;
                sysout().outchar(')');
                ;
                // JavaLine 147 <== SourceLine 888
                if(VALUE$((((Common$varcall)(((Common$prt)(CUR$.SL$)).inspect$857$17)).p2$argset!=(null)))) {
                    // JavaLine 149 <== SourceLine 889
                    {
                        sysout().outchar('(');
                        ;
                        flg2=false;
                        ;
                        // JavaLine 155 <== SourceLine 890
                        for(boolean CB$890:new ForList(
                            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){x=(Common$expr)x$; return(x$);};  public Link$ get(){return((Link$)x); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$varcall)(((Common$prt)(CUR$.SL$)).inspect$857$17)).p2$argset.first()); }})
                           ,new WhileElt<Common$expr>(new NAME$<Common$expr>(){ public Common$expr put(Common$expr x$){x=x$; return(x$);};  public Common$expr get(){return((Common$expr)x); }	},new NAME$<Common$expr>() { public Common$expr get(){return(((Common$expr)(x.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((x!=(null))); }})
                           )) { if(!CB$890) continue;
                        // JavaLine 160 <== SourceLine 892
                        {
                            if(VALUE$(flg2)) {
                                sysout().outchar(',');
                            }
                            ;
                            // JavaLine 166 <== SourceLine 893
                            flg2=true;
                            ;
                            new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
                            ;
                        }
                    }
                    ;
                    // JavaLine 174 <== SourceLine 895
                    sysout().outchar(')');
                    ;
                }
            }
            ;
        }
        else if(((Common$prt)(CUR$.SL$)).inspect$857$17 instanceof Common$qualification) // WHEN Common$qualification DO 
        // JavaLine 182 <== SourceLine 899
        {
            sysout().outtext(CONC(new TXT$(" qua "),new Common$edtype(((Common)(CUR$.SL$.SL$)),((Common$qualification)(((Common$prt)(CUR$.SL$)).inspect$857$17)).p2$type).RESULT$));
            ;
            // JavaLine 186 <== SourceLine 900
            flg1=true;
            ;
        }
        else // OTHERWISE 
        // JavaLine 191 <== SourceLine 902
        new Common$IERR(((Common)(CUR$.SL$.SL$)));
    }
}
;
}
}
;
EBLK();
return(this);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock854",1,854,21,855,23,856,29,857,35,858,41,859,46,860,48,861,54,862,59,864,65,865,73,867,81,871,89,872,96,873,98,874,104,875,109,877,115,878,123,880,131,884,139,886,142,887,147,888,149,889,155,890,160,892,166,893,174,895,182,899,186,900,191,902,201,906);
} // End of SubBlock
