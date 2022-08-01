// JavaLine 1 <== SourceLine 501
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$statement$casestmt$SubBlock501 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=5, firstLine=501, lastLine=550, hasLocalClasses=false, System=false
    // Declare locals as attributes
    int nwhen=0;
    int n=0;
    int x=0;
    TXT$ tempt=null;
    // JavaLine 13 <== SourceLine 502
    int stag=0;
    // JavaLine 15 <== SourceLine 503
    public ARRAY$<boolean[]>defined=null;
    int typ=0;
    // JavaLine 18 <== SourceLine 504
    public ARRAY$<Pass2$CompoundStatement21$SubBlock23$program_point[]>xdest=null;
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$statement$casestmt$SubBlock501(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        // JavaLine 25 <== SourceLine 503
        int[] defined$LB=new int[1]; int[] defined$UB=new int[1];
        defined$LB[0]=((Pass2$CompoundStatement21$SubBlock23$statement$casestmt)(CUR$.SL$)).lb; defined$UB[0]=((Pass2$CompoundStatement21$SubBlock23$statement$casestmt)(CUR$.SL$)).ub;
        BOUND_CHECK$(defined$LB[0],defined$UB[0]);
        defined=new ARRAY$<boolean[]>(new boolean[defined$UB[0]-defined$LB[0]+1],defined$LB,defined$UB);
        // JavaLine 30 <== SourceLine 504
        int[] xdest$LB=new int[1]; int[] xdest$UB=new int[1];
        xdest$LB[0]=1; xdest$UB[0]=Math.addExact(Math.subtractExact(((Pass2$CompoundStatement21$SubBlock23$statement$casestmt)(CUR$.SL$)).ub,((Pass2$CompoundStatement21$SubBlock23$statement$casestmt)(CUR$.SL$)).lb),1);
        BOUND_CHECK$(xdest$LB[0],xdest$UB[0]);
        xdest=new ARRAY$<Pass2$CompoundStatement21$SubBlock23$program_point[]>(new Pass2$CompoundStatement21$SubBlock23$program_point[xdest$UB[0]-xdest$LB[0]+1],xdest$LB,xdest$UB);
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        // JavaLine 38 <== SourceLine 505
        typ=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
        ;
        // JavaLine 41 <== SourceLine 506
        if(VALUE$((typ!=(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$141.T_INT$1)))) {
            new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$.SL$)),typ,((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$141.T_INT$1);
        }
        ;
        // JavaLine 46 <== SourceLine 507
        if(VALUE$((((Pass2$CompoundStatement21$SubBlock23$statement$casestmt)(CUR$.SL$)).lb!=(0)))) {
            // JavaLine 48 <== SourceLine 508
            {
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                ;
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$141.S_C_INT$1);
                ;
                // JavaLine 54 <== SourceLine 509
                tempt=new Common$leftint(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$141,((Pass2$CompoundStatement21$SubBlock23$statement$casestmt)(CUR$.SL$)).lb).RESULT$;
                ;
                new OuptFile$outstring(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143,tempt);
                ;
                // JavaLine 59 <== SourceLine 510
                if(VALUE$((((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143);
                }
                ;
                // JavaLine 64 <== SourceLine 511
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$141.S_SUB$1);
                ;
                // JavaLine 67 <== SourceLine 512
                if(VALUE$((((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143);
                }
                ;
            }
        }
        ;
        // JavaLine 75 <== SourceLine 514
        new Common$newtag(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$141,((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$141.symtab.Elt[((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$141.S_SWITCH$1-((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$141.symtab.LB[0]]);
        ;
        // JavaLine 78 <== SourceLine 515
        stag=((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$141.ntag$1;
        ;
        // JavaLine 81 <== SourceLine 516
        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$141.S_SWITCH$1);
        ;
        new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143,stag);
        ;
        // JavaLine 86 <== SourceLine 517
        new OuptFile$outnumber(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143,Math.addExact(Math.subtractExact(((Pass2$CompoundStatement21$SubBlock23$statement$casestmt)(CUR$.SL$)).ub,((Pass2$CompoundStatement21$SubBlock23$statement$casestmt)(CUR$.SL$)).lb),1));
        ;
        // JavaLine 89 <== SourceLine 518
        if(VALUE$((((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
            new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143);
        }
        ;
        ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$142).RESULT$;
        while((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$.SL$)).byte$==(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$141.S_WHEN$1))) {
            // JavaLine 96 <== SourceLine 520
            {
                for(boolean CB$520:new ForList(
                    new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){n=x$.intValue(); return(x$);};  public Number get(){return((Number)n); }	},new NAME$<Number>() { public Number get(){return(new InptFile$innumber(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$142).RESULT$); }})
                   ,new WhileElt<Number>(new NAME$<Number>(){ public Number put(Number x$){n=x$.intValue(); return(x$);};  public Number get(){return((Number)n); }	},new NAME$<Number>() { public Number get(){return(Math.subtractExact(n,1)); }},new NAME$<Boolean>() { public Boolean get(){return((n>(0))); }})
                   )) { if(!CB$520) continue;
                // JavaLine 102 <== SourceLine 521
                {
                    x=new InptFile$innumber(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$142).RESULT$;
                    ;
                    // JavaLine 106 <== SourceLine 522
                    if(VALUE$(defined.Elt[x-defined.LB[0]])) {
                        // JavaLine 108 <== SourceLine 524
                        new Common$ERROR(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$141,new TXT$("When index already defined"));
                    } else
                    {
                        defined.Elt[x-defined.LB[0]]=true;
                        ;
                        // JavaLine 114 <== SourceLine 525
                        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$141.S_SDEST$1);
                        ;
                        new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143,stag);
                        ;
                        // JavaLine 119 <== SourceLine 526
                        new OuptFile$outnumber(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143,Math.subtractExact(x,((Pass2$CompoundStatement21$SubBlock23$statement$casestmt)(CUR$.SL$)).lb));
                        ;
                        // JavaLine 122 <== SourceLine 527
                        if(VALUE$((((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                            new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143);
                        }
                        ;
                    }
                    ;
                }
            }
            ;
            // JavaLine 132 <== SourceLine 530
            ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$142).RESULT$;
            ;
            // JavaLine 135 <== SourceLine 531
            if(VALUE$(new Pass2$CompoundStatement21$SubBlock23$statement(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$.SL$)),((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$141.S_ENDWHEN$1).RESULT$)) {
                // JavaLine 137 <== SourceLine 532
                {
                    nwhen=Math.addExact(nwhen,1);
                    ;
                    // JavaLine 141 <== SourceLine 533
                    {
                        // BEGIN INSPECTION 
                        ((Pass2$CompoundStatement21$SubBlock23$statement$casestmt)(CUR$.SL$)).inspect$533$175=new Pass2$CompoundStatement21$SubBlock23$program_point(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$.SL$))).STM$();
                        if(((Pass2$CompoundStatement21$SubBlock23$statement$casestmt)(CUR$.SL$)).inspect$533$175!=null) // INSPECT inspect$533$175
                        // JavaLine 146 <== SourceLine 534
                        {
                            xdest.Elt[nwhen-xdest.LB[0]]=((Pass2$CompoundStatement21$SubBlock23$program_point)((Pass2$CompoundStatement21$SubBlock23$statement$casestmt)(CUR$.SL$)).inspect$533$175);
                            ;
                            // JavaLine 150 <== SourceLine 535
                            new Pass2$CompoundStatement21$SubBlock23$program_point$go_to(((Pass2$CompoundStatement21$SubBlock23$statement$casestmt)(CUR$.SL$)).inspect$533$175);
                            ;
                        }
                    }
                    ;
                }
            }
            ;
        }
        ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$142).RESULT$;
    }
    ;
    for(x=((Pass2$CompoundStatement21$SubBlock23$statement$casestmt)(CUR$.SL$)).lb;x<=((Pass2$CompoundStatement21$SubBlock23$statement$casestmt)(CUR$.SL$)).ub;x++) {
        // JavaLine 164 <== SourceLine 540
        if(VALUE$((!(defined.Elt[x-defined.LB[0]])))) {
            // JavaLine 166 <== SourceLine 541
            {
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$141.S_SDEST$1);
                ;
                new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143,stag);
                ;
                // JavaLine 172 <== SourceLine 542
                new OuptFile$outnumber(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143,Math.subtractExact(x,((Pass2$CompoundStatement21$SubBlock23$statement$casestmt)(CUR$.SL$)).lb));
                ;
                // JavaLine 175 <== SourceLine 543
                if(VALUE$((((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$21$143);
                }
                ;
            }
        }
    }
    ;
    // JavaLine 184 <== SourceLine 545
    if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$.SL$)).byte$==(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$141.S_OTHERWISE$1)))) {
        // JavaLine 186 <== SourceLine 546
        {
            ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$142).RESULT$;
            ;
            // JavaLine 190 <== SourceLine 547
            new Pass2$CompoundStatement21$SubBlock23$statement(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$.SL$)),((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$141.S_ENDCASE$1);
        }
    } else
    if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$.SL$)).byte$!=(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$141.S_ENDCASE$1)))) {
        new Common$IERR(((Pass2)(CUR$.SL$.SL$.SL$.SL$)).inspect$20$141);
    }
    ;
    // JavaLine 198 <== SourceLine 548
    while((nwhen!=(0))) {
        // JavaLine 200 <== SourceLine 549
        {
            new Pass2$CompoundStatement21$SubBlock23$program_point$define(xdest.Elt[nwhen-xdest.LB[0]]);
            ;
            nwhen=Math.subtractExact(nwhen,1);
        }
    }
    ;
    EBLK();
    return(this);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","SubBlock SubBlock501",1,501,13,502,15,503,18,504,25,503,30,504,38,505,41,506,46,507,48,508,54,509,59,510,64,511,67,512,75,514,78,515,81,516,86,517,89,518,96,520,102,521,106,522,108,524,114,525,119,526,122,527,132,530,135,531,137,532,141,533,146,534,150,535,164,540,166,541,172,542,175,543,184,545,186,546,190,547,198,548,200,549,210,550);
} // End of SubBlock
