// JavaLine 1 <== SourceLine 852
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:20:00 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$SubBlock852 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=852, lastLine=904, hasLocalClasses=false, System=false
    // Declare locals as attributes
    Link$ v=null;
    Common$expr x=null;
    boolean flg1=false;
    boolean flg2=false;
    // Normal Constructor
    public Common$prt$SubBlock852(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 21 <== SourceLine 853
        if(VALUE$((!(((Common$designator)(((Common$prt)(CUR$.SL$)).inspect$788$16)).p3$varset.empty())))) {
            // JavaLine 23 <== SourceLine 854
            {
                for(boolean CB$854:new ForList(
                    new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){v=x$; return(x$);};  public Link$ get(){return((Link$)v); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$designator)(((Common$prt)(CUR$.SL$)).inspect$788$16)).p3$varset.first()); }})
                   ,new WhileElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){v=x$; return(x$);};  public Link$ get(){return((Link$)v); }	},new NAME$<Link$>() { public Link$ get(){return(v.suc()); }},new NAME$<Boolean>() { public Boolean get(){return((v!=(null))); }})
                   )) { if(!CB$854) continue;
                // JavaLine 29 <== SourceLine 855
                {
                    // BEGIN INSPECTION 
                    ((Common$prt)(CUR$.SL$)).inspect$855$17=v;
                    //INSPECT inspect$855$17
                    if(((Common$prt)(CUR$.SL$)).inspect$855$17 instanceof Common$variable) // WHEN Common$variable DO 
                    // JavaLine 35 <== SourceLine 856
                    {
                        if(VALUE$(flg1)) {
                            sysout().outchar('.');
                        }
                        ;
                        // JavaLine 41 <== SourceLine 857
                        flg1=true;
                        ;
                        sysout().outtext(((Common$variable)(((Common$prt)(CUR$.SL$)).inspect$855$17)).varbox$2.symbol);
                        ;
                        // JavaLine 46 <== SourceLine 858
                        if(VALUE$((((Common$variable)(((Common$prt)(CUR$.SL$)).inspect$855$17)).argset$2!=(null)))) {
                            // JavaLine 48 <== SourceLine 859
                            {
                                sysout().outchar('(');
                                ;
                                flg2=false;
                                ;
                                // JavaLine 54 <== SourceLine 860
                                for(boolean CB$860:new ForList(
                                    new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){x=(Common$expr)x$; return(x$);};  public Link$ get(){return((Link$)x); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$variable)(((Common$prt)(CUR$.SL$)).inspect$855$17)).argset$2.first()); }})
                                   ,new WhileElt<Common$expr>(new NAME$<Common$expr>(){ public Common$expr put(Common$expr x$){x=x$; return(x$);};  public Common$expr get(){return((Common$expr)x); }	},new NAME$<Common$expr>() { public Common$expr get(){return(((Common$expr)(x.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((x!=(null))); }})
                                   )) { if(!CB$860) continue;
                                // JavaLine 59 <== SourceLine 862
                                {
                                    if(VALUE$(flg2)) {
                                        sysout().outchar(',');
                                    }
                                    ;
                                    // JavaLine 65 <== SourceLine 863
                                    flg2=true;
                                    ;
                                    new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
                                    ;
                                }
                            }
                            ;
                            // JavaLine 73 <== SourceLine 865
                            sysout().outchar(')');
                            ;
                        }
                    }
                    ;
                }
                else if(((Common$prt)(CUR$.SL$)).inspect$855$17 instanceof Common$varexpr) // WHEN Common$varexpr DO 
                // JavaLine 81 <== SourceLine 869
                {
                    if(VALUE$(flg1)) {
                        sysout().outchar('.');
                    }
                    ;
                    flg1=true;
                    ;
                    // JavaLine 89 <== SourceLine 870
                    sysout().outchar('(');
                    ;
                    new Common$prt(((Common)(CUR$.SL$.SL$)),((Common$varexpr)(((Common$prt)(CUR$.SL$)).inspect$855$17)).p2$vx,0);
                    ;
                    sysout().outchar(')');
                    ;
                    // JavaLine 96 <== SourceLine 871
                    if(VALUE$((((Common$varexpr)(((Common$prt)(CUR$.SL$)).inspect$855$17)).p2$argset!=(null)))) {
                        // JavaLine 98 <== SourceLine 872
                        {
                            sysout().outchar('(');
                            ;
                            flg2=false;
                            ;
                            // JavaLine 104 <== SourceLine 873
                            for(boolean CB$873:new ForList(
                                new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){x=(Common$expr)x$; return(x$);};  public Link$ get(){return((Link$)x); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$varexpr)(((Common$prt)(CUR$.SL$)).inspect$855$17)).p2$argset.first()); }})
                               ,new WhileElt<Common$expr>(new NAME$<Common$expr>(){ public Common$expr put(Common$expr x$){x=x$; return(x$);};  public Common$expr get(){return((Common$expr)x); }	},new NAME$<Common$expr>() { public Common$expr get(){return(((Common$expr)(x.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((x!=(null))); }})
                               )) { if(!CB$873) continue;
                            // JavaLine 109 <== SourceLine 875
                            {
                                if(VALUE$(flg2)) {
                                    sysout().outchar(',');
                                }
                                ;
                                // JavaLine 115 <== SourceLine 876
                                flg2=true;
                                ;
                                new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
                                ;
                            }
                        }
                        ;
                        // JavaLine 123 <== SourceLine 878
                        sysout().outchar(')');
                        ;
                    }
                }
                ;
            }
            else if(((Common$prt)(CUR$.SL$)).inspect$855$17 instanceof Common$varcall) // WHEN Common$varcall DO 
            // JavaLine 131 <== SourceLine 882
            {
                if(VALUE$(flg1)) {
                    sysout().outchar('.');
                }
                ;
                flg1=true;
                ;
                // JavaLine 139 <== SourceLine 884
                sysout().outtext(CONC(CONC(new TXT$("call "),((Common)(CUR$.SL$.SL$)).symtab.Elt[((Common$varcall)(((Common$prt)(CUR$.SL$)).inspect$855$17)).p2$prf-((Common)(CUR$.SL$.SL$)).symtab.LB[0]].symbol),new TXT$("(")));
                ;
                // JavaLine 142 <== SourceLine 885
                new Common$prt(((Common)(CUR$.SL$.SL$)),((Common$varcall)(((Common$prt)(CUR$.SL$)).inspect$855$17)).p2$vx,0);
                ;
                sysout().outchar(')');
                ;
                // JavaLine 147 <== SourceLine 886
                if(VALUE$((((Common$varcall)(((Common$prt)(CUR$.SL$)).inspect$855$17)).p2$argset!=(null)))) {
                    // JavaLine 149 <== SourceLine 887
                    {
                        sysout().outchar('(');
                        ;
                        flg2=false;
                        ;
                        // JavaLine 155 <== SourceLine 888
                        for(boolean CB$888:new ForList(
                            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){x=(Common$expr)x$; return(x$);};  public Link$ get(){return((Link$)x); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$varcall)(((Common$prt)(CUR$.SL$)).inspect$855$17)).p2$argset.first()); }})
                           ,new WhileElt<Common$expr>(new NAME$<Common$expr>(){ public Common$expr put(Common$expr x$){x=x$; return(x$);};  public Common$expr get(){return((Common$expr)x); }	},new NAME$<Common$expr>() { public Common$expr get(){return(((Common$expr)(x.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((x!=(null))); }})
                           )) { if(!CB$888) continue;
                        // JavaLine 160 <== SourceLine 890
                        {
                            if(VALUE$(flg2)) {
                                sysout().outchar(',');
                            }
                            ;
                            // JavaLine 166 <== SourceLine 891
                            flg2=true;
                            ;
                            new Common$prt(((Common)(CUR$.SL$.SL$)),x,0);
                            ;
                        }
                    }
                    ;
                    // JavaLine 174 <== SourceLine 893
                    sysout().outchar(')');
                    ;
                }
            }
            ;
        }
        else if(((Common$prt)(CUR$.SL$)).inspect$855$17 instanceof Common$qualification) // WHEN Common$qualification DO 
        // JavaLine 182 <== SourceLine 897
        {
            sysout().outtext(CONC(new TXT$(" qua "),new Common$edtype(((Common)(CUR$.SL$.SL$)),((Common$qualification)(((Common$prt)(CUR$.SL$)).inspect$855$17)).p2$type).RESULT$));
            ;
            // JavaLine 186 <== SourceLine 898
            flg1=true;
            ;
        }
        else // OTHERWISE 
        // JavaLine 191 <== SourceLine 900
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
public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock852",1,852,21,853,23,854,29,855,35,856,41,857,46,858,48,859,54,860,59,862,65,863,73,865,81,869,89,870,96,871,98,872,104,873,109,875,115,876,123,878,131,882,139,884,142,885,147,886,149,887,155,888,160,890,166,891,174,893,182,897,186,898,191,900,201,904);
} // End of SubBlock
