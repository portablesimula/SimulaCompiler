// JavaLine 1 <== SourceLine 864
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 17:55:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock864 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=864, lastLine=916, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Link$ v=null;
    Common$expr x=null;
    boolean flg1=false;
    boolean flg2=false;
    // Normal Constructor
    public Common$prt$SubBlock864(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 21 <== SourceLine 865
        if(VALUE$((!(((Common$designator)(((Common$prt)(CUR$.SL$)).inspect$800$16)).p3$varset.empty())))) {
            // JavaLine 23 <== SourceLine 866
            {
                for(boolean CB$866:new ForList(
                    new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){v=x$; return(x$);};  public Link$ get(){return((Link$)v); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$designator)(((Common$prt)(CUR$.SL$)).inspect$800$16)).p3$varset.first()); }})
                   ,new WhileElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){v=x$; return(x$);};  public Link$ get(){return((Link$)v); }	},new NAME$<Link$>() { public Link$ get(){return(v.suc()); }},new NAME$<Boolean>() { public Boolean get(){return((v!=(null))); }})
                   )) { if(!CB$866) continue;
                // JavaLine 29 <== SourceLine 867
                {
                    // BEGIN INSPECTION 
                    ((Common$prt)(CUR$.SL$)).inspect$867$17=v;
                    //INSPECT inspect$867$17
                    if(((Common$prt)(CUR$.SL$)).inspect$867$17 instanceof Common$variable) // WHEN Common$variable DO 
                    // JavaLine 35 <== SourceLine 868
                    {
                        if(VALUE$(flg1)) {
                            sysout().outchar('.');
                        }
                        ;
                        // JavaLine 41 <== SourceLine 869
                        flg1=true;
                        ;
                        sysout().outtext(((Common$variable)(((Common$prt)(CUR$.SL$)).inspect$867$17)).varbox$2.symbol);
                        ;
                        // JavaLine 46 <== SourceLine 870
                        if(VALUE$((((Common$variable)(((Common$prt)(CUR$.SL$)).inspect$867$17)).argset$2!=(null)))) {
                            // JavaLine 48 <== SourceLine 871
                            {
                                sysout().outchar('(');
                                ;
                                flg2=false;
                                ;
                                // JavaLine 54 <== SourceLine 872
                                for(boolean CB$872:new ForList(
                                    new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){x=(Common$expr)x$; return(x$);};  public Link$ get(){return((Link$)x); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$variable)(((Common$prt)(CUR$.SL$)).inspect$867$17)).argset$2.first()); }})
                                   ,new WhileElt<Common$expr>(new NAME$<Common$expr>(){ public Common$expr put(Common$expr x$){x=x$; return(x$);};  public Common$expr get(){return((Common$expr)x); }	},new NAME$<Common$expr>() { public Common$expr get(){return(((Common$expr)(x.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((x!=(null))); }})
                                   )) { if(!CB$872) continue;
                                // JavaLine 59 <== SourceLine 874
                                {
                                    if(VALUE$(flg2)) {
                                        sysout().outchar(',');
                                    }
                                    ;
                                    // JavaLine 65 <== SourceLine 875
                                    flg2=true;
                                    ;
                                    new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
                                    ;
                                }
                            }
                            ;
                            // JavaLine 73 <== SourceLine 877
                            sysout().outchar(')');
                            ;
                        }
                    }
                    ;
                }
                else if(((Common$prt)(CUR$.SL$)).inspect$867$17 instanceof Common$varexpr) // WHEN Common$varexpr DO 
                // JavaLine 81 <== SourceLine 881
                {
                    if(VALUE$(flg1)) {
                        sysout().outchar('.');
                    }
                    ;
                    flg1=true;
                    ;
                    // JavaLine 89 <== SourceLine 882
                    sysout().outchar('(');
                    ;
                    new Common$prt(((Common)(CUR$.SL$.SL$)),((Common$varexpr)(((Common$prt)(CUR$.SL$)).inspect$867$17)).p2$vx,0);
                    ;
                    sysout().outchar(')');
                    ;
                    // JavaLine 96 <== SourceLine 883
                    if(VALUE$((((Common$varexpr)(((Common$prt)(CUR$.SL$)).inspect$867$17)).p2$argset!=(null)))) {
                        // JavaLine 98 <== SourceLine 884
                        {
                            sysout().outchar('(');
                            ;
                            flg2=false;
                            ;
                            // JavaLine 104 <== SourceLine 885
                            for(boolean CB$885:new ForList(
                                new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){x=(Common$expr)x$; return(x$);};  public Link$ get(){return((Link$)x); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$varexpr)(((Common$prt)(CUR$.SL$)).inspect$867$17)).p2$argset.first()); }})
                               ,new WhileElt<Common$expr>(new NAME$<Common$expr>(){ public Common$expr put(Common$expr x$){x=x$; return(x$);};  public Common$expr get(){return((Common$expr)x); }	},new NAME$<Common$expr>() { public Common$expr get(){return(((Common$expr)(x.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((x!=(null))); }})
                               )) { if(!CB$885) continue;
                            // JavaLine 109 <== SourceLine 887
                            {
                                if(VALUE$(flg2)) {
                                    sysout().outchar(',');
                                }
                                ;
                                // JavaLine 115 <== SourceLine 888
                                flg2=true;
                                ;
                                new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
                                ;
                            }
                        }
                        ;
                        // JavaLine 123 <== SourceLine 890
                        sysout().outchar(')');
                        ;
                    }
                }
                ;
            }
            else if(((Common$prt)(CUR$.SL$)).inspect$867$17 instanceof Common$varcall) // WHEN Common$varcall DO 
            // JavaLine 131 <== SourceLine 894
            {
                if(VALUE$(flg1)) {
                    sysout().outchar('.');
                }
                ;
                flg1=true;
                ;
                // JavaLine 139 <== SourceLine 896
                sysout().outtext(CONC(CONC(new TXT$("call "),new Common$edSymbol(((Common)(CUR$.SL$.SL$)),((Common$varcall)(((Common$prt)(CUR$.SL$)).inspect$867$17)).p2$prf).RESULT$),new TXT$("(")));
                ;
                // JavaLine 142 <== SourceLine 897
                new Common$prt(((Common)(CUR$.SL$.SL$)),((Common$varcall)(((Common$prt)(CUR$.SL$)).inspect$867$17)).p2$vx,0);
                ;
                sysout().outchar(')');
                ;
                // JavaLine 147 <== SourceLine 898
                if(VALUE$((((Common$varcall)(((Common$prt)(CUR$.SL$)).inspect$867$17)).p2$argset!=(null)))) {
                    // JavaLine 149 <== SourceLine 899
                    {
                        sysout().outchar('(');
                        ;
                        flg2=false;
                        ;
                        // JavaLine 155 <== SourceLine 900
                        for(boolean CB$900:new ForList(
                            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){x=(Common$expr)x$; return(x$);};  public Link$ get(){return((Link$)x); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$varcall)(((Common$prt)(CUR$.SL$)).inspect$867$17)).p2$argset.first()); }})
                           ,new WhileElt<Common$expr>(new NAME$<Common$expr>(){ public Common$expr put(Common$expr x$){x=x$; return(x$);};  public Common$expr get(){return((Common$expr)x); }	},new NAME$<Common$expr>() { public Common$expr get(){return(((Common$expr)(x.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((x!=(null))); }})
                           )) { if(!CB$900) continue;
                        // JavaLine 160 <== SourceLine 902
                        {
                            if(VALUE$(flg2)) {
                                sysout().outchar(',');
                            }
                            ;
                            // JavaLine 166 <== SourceLine 903
                            flg2=true;
                            ;
                            new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
                            ;
                        }
                    }
                    ;
                    // JavaLine 174 <== SourceLine 905
                    sysout().outchar(')');
                    ;
                }
            }
            ;
        }
        else if(((Common$prt)(CUR$.SL$)).inspect$867$17 instanceof Common$qualification) // WHEN Common$qualification DO 
        // JavaLine 182 <== SourceLine 909
        {
            sysout().outtext(CONC(new TXT$(" qua "),new Common$edtype(((Common)(CUR$.SL$.SL$)),((Common$qualification)(((Common$prt)(CUR$.SL$)).inspect$867$17)).p2$type).RESULT$));
            ;
            // JavaLine 186 <== SourceLine 910
            flg1=true;
            ;
        }
        else // OTHERWISE 
        // JavaLine 191 <== SourceLine 912
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
public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock864",1,864,21,865,23,866,29,867,35,868,41,869,46,870,48,871,54,872,59,874,65,875,73,877,81,881,89,882,96,883,98,884,104,885,109,887,115,888,123,890,131,894,139,896,142,897,147,898,149,899,155,900,160,902,166,903,174,905,182,909,186,910,191,912,201,916);
} // End of SubBlock
