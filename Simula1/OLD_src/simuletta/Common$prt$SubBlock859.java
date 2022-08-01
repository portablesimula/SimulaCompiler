// JavaLine 1 <== SourceLine 859
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:46:15 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock859 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=859, lastLine=911, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Link$ v=null;
    Common$expr x=null;
    boolean flg1=false;
    boolean flg2=false;
    // Normal Constructor
    public Common$prt$SubBlock859(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 21 <== SourceLine 860
        if(VALUE$((!(((Common$designator)(((Common$prt)(CUR$.SL$)).inspect$795$16)).p3$varset.empty())))) {
            // JavaLine 23 <== SourceLine 861
            {
                for(boolean CB$861:new ForList(
                    new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){v=x$; return(x$);};  public Link$ get(){return((Link$)v); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$designator)(((Common$prt)(CUR$.SL$)).inspect$795$16)).p3$varset.first()); }})
                   ,new WhileElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){v=x$; return(x$);};  public Link$ get(){return((Link$)v); }	},new NAME$<Link$>() { public Link$ get(){return(v.suc()); }},new NAME$<Boolean>() { public Boolean get(){return((v!=(null))); }})
                   )) { if(!CB$861) continue;
                // JavaLine 29 <== SourceLine 862
                {
                    // BEGIN INSPECTION 
                    ((Common$prt)(CUR$.SL$)).inspect$862$17=v;
                    //INSPECT inspect$862$17
                    if(((Common$prt)(CUR$.SL$)).inspect$862$17 instanceof Common$variable) // WHEN Common$variable DO 
                    // JavaLine 35 <== SourceLine 863
                    {
                        if(VALUE$(flg1)) {
                            sysout().outchar('.');
                        }
                        ;
                        // JavaLine 41 <== SourceLine 864
                        flg1=true;
                        ;
                        sysout().outtext(((Common$variable)(((Common$prt)(CUR$.SL$)).inspect$862$17)).varbox$2.symbol);
                        ;
                        // JavaLine 46 <== SourceLine 865
                        if(VALUE$((((Common$variable)(((Common$prt)(CUR$.SL$)).inspect$862$17)).argset$2!=(null)))) {
                            // JavaLine 48 <== SourceLine 866
                            {
                                sysout().outchar('(');
                                ;
                                flg2=false;
                                ;
                                // JavaLine 54 <== SourceLine 867
                                for(boolean CB$867:new ForList(
                                    new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){x=(Common$expr)x$; return(x$);};  public Link$ get(){return((Link$)x); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$variable)(((Common$prt)(CUR$.SL$)).inspect$862$17)).argset$2.first()); }})
                                   ,new WhileElt<Common$expr>(new NAME$<Common$expr>(){ public Common$expr put(Common$expr x$){x=x$; return(x$);};  public Common$expr get(){return((Common$expr)x); }	},new NAME$<Common$expr>() { public Common$expr get(){return(((Common$expr)(x.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((x!=(null))); }})
                                   )) { if(!CB$867) continue;
                                // JavaLine 59 <== SourceLine 869
                                {
                                    if(VALUE$(flg2)) {
                                        sysout().outchar(',');
                                    }
                                    ;
                                    // JavaLine 65 <== SourceLine 870
                                    flg2=true;
                                    ;
                                    new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
                                    ;
                                }
                            }
                            ;
                            // JavaLine 73 <== SourceLine 872
                            sysout().outchar(')');
                            ;
                        }
                    }
                    ;
                }
                else if(((Common$prt)(CUR$.SL$)).inspect$862$17 instanceof Common$varexpr) // WHEN Common$varexpr DO 
                // JavaLine 81 <== SourceLine 876
                {
                    if(VALUE$(flg1)) {
                        sysout().outchar('.');
                    }
                    ;
                    flg1=true;
                    ;
                    // JavaLine 89 <== SourceLine 877
                    sysout().outchar('(');
                    ;
                    new Common$prt(((Common)(CUR$.SL$.SL$)),((Common$varexpr)(((Common$prt)(CUR$.SL$)).inspect$862$17)).p2$vx,0);
                    ;
                    sysout().outchar(')');
                    ;
                    // JavaLine 96 <== SourceLine 878
                    if(VALUE$((((Common$varexpr)(((Common$prt)(CUR$.SL$)).inspect$862$17)).p2$argset!=(null)))) {
                        // JavaLine 98 <== SourceLine 879
                        {
                            sysout().outchar('(');
                            ;
                            flg2=false;
                            ;
                            // JavaLine 104 <== SourceLine 880
                            for(boolean CB$880:new ForList(
                                new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){x=(Common$expr)x$; return(x$);};  public Link$ get(){return((Link$)x); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$varexpr)(((Common$prt)(CUR$.SL$)).inspect$862$17)).p2$argset.first()); }})
                               ,new WhileElt<Common$expr>(new NAME$<Common$expr>(){ public Common$expr put(Common$expr x$){x=x$; return(x$);};  public Common$expr get(){return((Common$expr)x); }	},new NAME$<Common$expr>() { public Common$expr get(){return(((Common$expr)(x.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((x!=(null))); }})
                               )) { if(!CB$880) continue;
                            // JavaLine 109 <== SourceLine 882
                            {
                                if(VALUE$(flg2)) {
                                    sysout().outchar(',');
                                }
                                ;
                                // JavaLine 115 <== SourceLine 883
                                flg2=true;
                                ;
                                new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
                                ;
                            }
                        }
                        ;
                        // JavaLine 123 <== SourceLine 885
                        sysout().outchar(')');
                        ;
                    }
                }
                ;
            }
            else if(((Common$prt)(CUR$.SL$)).inspect$862$17 instanceof Common$varcall) // WHEN Common$varcall DO 
            // JavaLine 131 <== SourceLine 889
            {
                if(VALUE$(flg1)) {
                    sysout().outchar('.');
                }
                ;
                flg1=true;
                ;
                // JavaLine 139 <== SourceLine 891
                sysout().outtext(CONC(CONC(new TXT$("call "),((Common)(CUR$.SL$.SL$)).symtab.Elt[((Common$varcall)(((Common$prt)(CUR$.SL$)).inspect$862$17)).p2$prf-((Common)(CUR$.SL$.SL$)).symtab.LB[0]].symbol),new TXT$("(")));
                ;
                // JavaLine 142 <== SourceLine 892
                new Common$prt(((Common)(CUR$.SL$.SL$)),((Common$varcall)(((Common$prt)(CUR$.SL$)).inspect$862$17)).p2$vx,0);
                ;
                sysout().outchar(')');
                ;
                // JavaLine 147 <== SourceLine 893
                if(VALUE$((((Common$varcall)(((Common$prt)(CUR$.SL$)).inspect$862$17)).p2$argset!=(null)))) {
                    // JavaLine 149 <== SourceLine 894
                    {
                        sysout().outchar('(');
                        ;
                        flg2=false;
                        ;
                        // JavaLine 155 <== SourceLine 895
                        for(boolean CB$895:new ForList(
                            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){x=(Common$expr)x$; return(x$);};  public Link$ get(){return((Link$)x); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$varcall)(((Common$prt)(CUR$.SL$)).inspect$862$17)).p2$argset.first()); }})
                           ,new WhileElt<Common$expr>(new NAME$<Common$expr>(){ public Common$expr put(Common$expr x$){x=x$; return(x$);};  public Common$expr get(){return((Common$expr)x); }	},new NAME$<Common$expr>() { public Common$expr get(){return(((Common$expr)(x.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((x!=(null))); }})
                           )) { if(!CB$895) continue;
                        // JavaLine 160 <== SourceLine 897
                        {
                            if(VALUE$(flg2)) {
                                sysout().outchar(',');
                            }
                            ;
                            // JavaLine 166 <== SourceLine 898
                            flg2=true;
                            ;
                            new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
                            ;
                        }
                    }
                    ;
                    // JavaLine 174 <== SourceLine 900
                    sysout().outchar(')');
                    ;
                }
            }
            ;
        }
        else if(((Common$prt)(CUR$.SL$)).inspect$862$17 instanceof Common$qualification) // WHEN Common$qualification DO 
        // JavaLine 182 <== SourceLine 904
        {
            sysout().outtext(CONC(new TXT$(" qua "),new Common$edtype(((Common)(CUR$.SL$.SL$)),((Common$qualification)(((Common$prt)(CUR$.SL$)).inspect$862$17)).p2$type).RESULT$));
            ;
            // JavaLine 186 <== SourceLine 905
            flg1=true;
            ;
        }
        else // OTHERWISE 
        // JavaLine 191 <== SourceLine 907
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
public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock859",1,859,21,860,23,861,29,862,35,863,41,864,46,865,48,866,54,867,59,869,65,870,73,872,81,876,89,877,96,878,98,879,104,880,109,882,115,883,123,885,131,889,139,891,142,892,147,893,149,894,155,895,160,897,166,898,174,900,182,904,186,905,191,907,201,911);
} // End of SubBlock
