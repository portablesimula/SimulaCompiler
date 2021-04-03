// JavaLine 1 <== SourceLine 868
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock868 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=868, lastLine=920, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Link$ v=null;
    Common$expr x=null;
    boolean flg1=false;
    boolean flg2=false;
    // Normal Constructor
    public Common$prt$SubBlock868(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 21 <== SourceLine 869
        if(VALUE$((!(((Common$designator)(((Common$prt)(CUR$.SL$)).inspect$804$16)).p3$varset.empty())))) {
            // JavaLine 23 <== SourceLine 870
            {
                for(boolean CB$870:new ForList(
                    new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){v=x$; return(x$);};  public Link$ get(){return((Link$)v); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$designator)(((Common$prt)(CUR$.SL$)).inspect$804$16)).p3$varset.first()); }})
                   ,new WhileElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){v=x$; return(x$);};  public Link$ get(){return((Link$)v); }	},new NAME$<Link$>() { public Link$ get(){return(v.suc()); }},new NAME$<Boolean>() { public Boolean get(){return((v!=(null))); }})
                   )) { if(!CB$870) continue;
                // JavaLine 29 <== SourceLine 871
                {
                    // BEGIN INSPECTION 
                    ((Common$prt)(CUR$.SL$)).inspect$871$17=v;
                    //INSPECT inspect$871$17
                    if(((Common$prt)(CUR$.SL$)).inspect$871$17 instanceof Common$variable) // WHEN Common$variable DO 
                    // JavaLine 35 <== SourceLine 872
                    {
                        if(VALUE$(flg1)) {
                            sysout().outchar('.');
                        }
                        ;
                        // JavaLine 41 <== SourceLine 873
                        flg1=true;
                        ;
                        sysout().outtext(((Common$variable)(((Common$prt)(CUR$.SL$)).inspect$871$17)).varbox$2.symbol);
                        ;
                        // JavaLine 46 <== SourceLine 874
                        if(VALUE$((((Common$variable)(((Common$prt)(CUR$.SL$)).inspect$871$17)).argset$2!=(null)))) {
                            // JavaLine 48 <== SourceLine 875
                            {
                                sysout().outchar('(');
                                ;
                                flg2=false;
                                ;
                                // JavaLine 54 <== SourceLine 876
                                for(boolean CB$876:new ForList(
                                    new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){x=(Common$expr)x$; return(x$);};  public Link$ get(){return((Link$)x); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$variable)(((Common$prt)(CUR$.SL$)).inspect$871$17)).argset$2.first()); }})
                                   ,new WhileElt<Common$expr>(new NAME$<Common$expr>(){ public Common$expr put(Common$expr x$){x=x$; return(x$);};  public Common$expr get(){return((Common$expr)x); }	},new NAME$<Common$expr>() { public Common$expr get(){return(((Common$expr)(x.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((x!=(null))); }})
                                   )) { if(!CB$876) continue;
                                // JavaLine 59 <== SourceLine 878
                                {
                                    if(VALUE$(flg2)) {
                                        sysout().outchar(',');
                                    }
                                    ;
                                    // JavaLine 65 <== SourceLine 879
                                    flg2=true;
                                    ;
                                    new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
                                    ;
                                }
                            }
                            ;
                            // JavaLine 73 <== SourceLine 881
                            sysout().outchar(')');
                            ;
                        }
                    }
                    ;
                }
                else if(((Common$prt)(CUR$.SL$)).inspect$871$17 instanceof Common$varexpr) // WHEN Common$varexpr DO 
                // JavaLine 81 <== SourceLine 885
                {
                    if(VALUE$(flg1)) {
                        sysout().outchar('.');
                    }
                    ;
                    flg1=true;
                    ;
                    // JavaLine 89 <== SourceLine 886
                    sysout().outchar('(');
                    ;
                    new Common$prt(((Common)(CUR$.SL$.SL$)),((Common$varexpr)(((Common$prt)(CUR$.SL$)).inspect$871$17)).p2$vx,0);
                    ;
                    sysout().outchar(')');
                    ;
                    // JavaLine 96 <== SourceLine 887
                    if(VALUE$((((Common$varexpr)(((Common$prt)(CUR$.SL$)).inspect$871$17)).p2$argset!=(null)))) {
                        // JavaLine 98 <== SourceLine 888
                        {
                            sysout().outchar('(');
                            ;
                            flg2=false;
                            ;
                            // JavaLine 104 <== SourceLine 889
                            for(boolean CB$889:new ForList(
                                new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){x=(Common$expr)x$; return(x$);};  public Link$ get(){return((Link$)x); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$varexpr)(((Common$prt)(CUR$.SL$)).inspect$871$17)).p2$argset.first()); }})
                               ,new WhileElt<Common$expr>(new NAME$<Common$expr>(){ public Common$expr put(Common$expr x$){x=x$; return(x$);};  public Common$expr get(){return((Common$expr)x); }	},new NAME$<Common$expr>() { public Common$expr get(){return(((Common$expr)(x.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((x!=(null))); }})
                               )) { if(!CB$889) continue;
                            // JavaLine 109 <== SourceLine 891
                            {
                                if(VALUE$(flg2)) {
                                    sysout().outchar(',');
                                }
                                ;
                                // JavaLine 115 <== SourceLine 892
                                flg2=true;
                                ;
                                new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
                                ;
                            }
                        }
                        ;
                        // JavaLine 123 <== SourceLine 894
                        sysout().outchar(')');
                        ;
                    }
                }
                ;
            }
            else if(((Common$prt)(CUR$.SL$)).inspect$871$17 instanceof Common$varcall) // WHEN Common$varcall DO 
            // JavaLine 131 <== SourceLine 898
            {
                if(VALUE$(flg1)) {
                    sysout().outchar('.');
                }
                ;
                flg1=true;
                ;
                // JavaLine 139 <== SourceLine 900
                sysout().outtext(CONC(CONC(new TXT$("call "),new Common$edSymbol(((Common)(CUR$.SL$.SL$)),((Common$varcall)(((Common$prt)(CUR$.SL$)).inspect$871$17)).p2$prf).RESULT$),new TXT$("(")));
                ;
                // JavaLine 142 <== SourceLine 901
                new Common$prt(((Common)(CUR$.SL$.SL$)),((Common$varcall)(((Common$prt)(CUR$.SL$)).inspect$871$17)).p2$vx,0);
                ;
                sysout().outchar(')');
                ;
                // JavaLine 147 <== SourceLine 902
                if(VALUE$((((Common$varcall)(((Common$prt)(CUR$.SL$)).inspect$871$17)).p2$argset!=(null)))) {
                    // JavaLine 149 <== SourceLine 903
                    {
                        sysout().outchar('(');
                        ;
                        flg2=false;
                        ;
                        // JavaLine 155 <== SourceLine 904
                        for(boolean CB$904:new ForList(
                            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){x=(Common$expr)x$; return(x$);};  public Link$ get(){return((Link$)x); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$varcall)(((Common$prt)(CUR$.SL$)).inspect$871$17)).p2$argset.first()); }})
                           ,new WhileElt<Common$expr>(new NAME$<Common$expr>(){ public Common$expr put(Common$expr x$){x=x$; return(x$);};  public Common$expr get(){return((Common$expr)x); }	},new NAME$<Common$expr>() { public Common$expr get(){return(((Common$expr)(x.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((x!=(null))); }})
                           )) { if(!CB$904) continue;
                        // JavaLine 160 <== SourceLine 906
                        {
                            if(VALUE$(flg2)) {
                                sysout().outchar(',');
                            }
                            ;
                            // JavaLine 166 <== SourceLine 907
                            flg2=true;
                            ;
                            new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
                            ;
                        }
                    }
                    ;
                    // JavaLine 174 <== SourceLine 909
                    sysout().outchar(')');
                    ;
                }
            }
            ;
        }
        else if(((Common$prt)(CUR$.SL$)).inspect$871$17 instanceof Common$qualification) // WHEN Common$qualification DO 
        // JavaLine 182 <== SourceLine 913
        {
            sysout().outtext(CONC(new TXT$(" qua "),new Common$edtype(((Common)(CUR$.SL$.SL$)),((Common$qualification)(((Common$prt)(CUR$.SL$)).inspect$871$17)).p2$type).RESULT$));
            ;
            // JavaLine 186 <== SourceLine 914
            flg1=true;
            ;
        }
        else // OTHERWISE 
        // JavaLine 191 <== SourceLine 916
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
public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock868",1,868,21,869,23,870,29,871,35,872,41,873,46,874,48,875,54,876,59,878,65,879,73,881,81,885,89,886,96,887,98,888,104,889,109,891,115,892,123,894,131,898,139,900,142,901,147,902,149,903,155,904,160,906,166,907,174,909,182,913,186,914,191,916,201,920);
} // End of SubBlock
