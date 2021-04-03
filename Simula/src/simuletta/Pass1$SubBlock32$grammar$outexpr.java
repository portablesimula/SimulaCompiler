// JavaLine 1 <== SourceLine 1606
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$grammar$outexpr extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=1606, lastLine=1721, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common$expr p$e;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 1607
    int i=0;
    // JavaLine 13 <== SourceLine 1608
    Link$ v=null;
    Common$expr x=null;
    Common$expr y=null;
    boolean flg1=false;
    // JavaLine 18 <== SourceLine 1610
    Common$expr inspect$1610$105=null;
    // JavaLine 20 <== SourceLine 1614
    Link$ inspect$1614$106=null;
    // JavaLine 22 <== SourceLine 1644
    Head$ inspect$1644$107=null;
    // JavaLine 24 <== SourceLine 1662
    Head$ inspect$1662$108=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass1$SubBlock32$grammar$outexpr setPar(Object param) {
        //Util.BREAK("CALL Pass1$SubBlock32$grammar$outexpr.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$e=(Common$expr)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass1$SubBlock32$grammar$outexpr(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass1$SubBlock32$grammar$outexpr(RTObject$ SL$,Common$expr sp$e) {
        super(SL$);
        // Parameter assignment to locals
        this.p$e = sp$e;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass1$SubBlock32$grammar$outexpr STM$() {
        // JavaLine 53 <== SourceLine 1610
        {
            // BEGIN INSPECTION 
            inspect$1610$105=p$e;
            //INSPECT inspect$1610$105
            if(inspect$1610$105 instanceof Common$designator) // WHEN Common$designator DO 
            // JavaLine 59 <== SourceLine 1611
            {
                if(VALUE$((!(((Common$designator)(inspect$1610$105)).p3$varset.empty())))) {
                    // JavaLine 62 <== SourceLine 1612
                    {
                        for(boolean CB$1612:new ForList(
                            new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){v=x$; return(x$);};  public Link$ get(){return((Link$)v); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$designator)(inspect$1610$105)).p3$varset.first()); }})
                           ,new WhileElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){v=x$; return(x$);};  public Link$ get(){return((Link$)v); }	},new NAME$<Link$>() { public Link$ get(){return(v.suc()); }},new NAME$<Boolean>() { public Boolean get(){return((v!=(null))); }})
                           )) { if(!CB$1612) continue;
                        // JavaLine 68 <== SourceLine 1614
                        {
                            // BEGIN INSPECTION 
                            inspect$1614$106=v;
                            //INSPECT inspect$1614$106
                            if(inspect$1614$106 instanceof Common$variable) // WHEN Common$variable DO 
                            // JavaLine 74 <== SourceLine 1615
                            {
                                if(VALUE$(flg1)) {
                                    // JavaLine 77 <== SourceLine 1616
                                    {
                                        new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_DOT$1);
                                        ;
                                    }
                                }
                                ;
                                // JavaLine 84 <== SourceLine 1618
                                flg1=true;
                                ;
                                // JavaLine 87 <== SourceLine 1619
                                new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_VAR$1);
                                ;
                                // JavaLine 90 <== SourceLine 1621
                                new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,(((v.suc()==(null)))?(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_SIMPLE$1):(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_DOTVAR$1)));
                                ;
                                // JavaLine 93 <== SourceLine 1622
                                new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_VARID$1);
                                ;
                                // JavaLine 96 <== SourceLine 1623
                                new OuptFile$outident(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Common$variable)(inspect$1614$106)).varbox$2.id);
                                ;
                                // JavaLine 99 <== SourceLine 1624
                                if(VALUE$((((Common$variable)(inspect$1614$106)).argset$2!=(null)))) {
                                    // JavaLine 101 <== SourceLine 1625
                                    {
                                        new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ARGLIST$1);
                                        ;
                                        // JavaLine 105 <== SourceLine 1626
                                        new OuptFile$outbyt(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Common$variable)(inspect$1614$106)).argset$2.cardinal());
                                        ;
                                        // JavaLine 108 <== SourceLine 1627
                                        if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                            new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                                        }
                                        ;
                                        // JavaLine 113 <== SourceLine 1628
                                        y=((Common$expr)(((Common$variable)(inspect$1614$106)).argset$2.first()));
                                        ;
                                        x=y;
                                        while((x!=(null))) {
                                            // JavaLine 118 <== SourceLine 1630
                                            {
                                                y=((Common$expr)(x.suc()));
                                                ;
                                                new Pass1$SubBlock32$grammar$outexpr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),x);
                                            }
                                            x=y;
                                        }
                                        ;
                                    }
                                }
                                ;
                            }
                            else if(inspect$1614$106 instanceof Common$varexpr) // WHEN Common$varexpr DO 
                            // JavaLine 132 <== SourceLine 1634
                            {
                                if(VALUE$(flg1)) {
                                    // JavaLine 135 <== SourceLine 1635
                                    {
                                        new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_DOT$1);
                                        ;
                                    }
                                }
                                ;
                                // JavaLine 142 <== SourceLine 1637
                                flg1=true;
                                ;
                                // JavaLine 145 <== SourceLine 1638
                                new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_VAR$1);
                                ;
                                // JavaLine 148 <== SourceLine 1640
                                new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,(((v.suc()==(null)))?(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_SIMPLE$1):(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_DOTVAR$1)));
                                ;
                                // JavaLine 151 <== SourceLine 1641
                                new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_VAREXPR$1);
                                ;
                                // JavaLine 154 <== SourceLine 1642
                                if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                                }
                                ;
                                // JavaLine 159 <== SourceLine 1643
                                new Pass1$SubBlock32$grammar$outexpr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),((Common$varexpr)(inspect$1614$106)).p2$vx);
                                ;
                                // JavaLine 162 <== SourceLine 1644
                                {
                                    // BEGIN INSPECTION 
                                    inspect$1644$107=((Common$varexpr)(inspect$1614$106)).p2$argset;
                                    if(inspect$1644$107!=null) // INSPECT inspect$1644$107
                                    // JavaLine 167 <== SourceLine 1645
                                    {
                                        new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ARGLIST$1);
                                        ;
                                        new OuptFile$outbyt(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,inspect$1644$107.cardinal());
                                        ;
                                        // JavaLine 173 <== SourceLine 1646
                                        if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                            new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                                        }
                                        ;
                                        // JavaLine 178 <== SourceLine 1647
                                        y=((Common$expr)(inspect$1644$107.first()));
                                        ;
                                        x=y;
                                        while((x!=(null))) {
                                            // JavaLine 183 <== SourceLine 1649
                                            {
                                                y=((Common$expr)(x.suc()));
                                                ;
                                                new Pass1$SubBlock32$grammar$outexpr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),x);
                                            }
                                            x=y;
                                        }
                                        ;
                                    }
                                }
                                ;
                            }
                            else if(inspect$1614$106 instanceof Common$varcall) // WHEN Common$varcall DO 
                            // JavaLine 197 <== SourceLine 1653
                            {
                                if(VALUE$(flg1)) {
                                    // JavaLine 200 <== SourceLine 1654
                                    {
                                        new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_DOT$1);
                                        ;
                                    }
                                }
                                ;
                                // JavaLine 207 <== SourceLine 1656
                                flg1=true;
                                ;
                                // JavaLine 210 <== SourceLine 1657
                                new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_VAR$1);
                                ;
                                // JavaLine 213 <== SourceLine 1659
                                new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,(((v.suc()==(null)))?(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_SIMPLE$1):(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_DOTVAR$1)));
                                ;
                                // JavaLine 216 <== SourceLine 1660
                                new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_VARCALL$1);
                                ;
                                // JavaLine 219 <== SourceLine 1661
                                new OuptFile$outident(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Common$varcall)(inspect$1614$106)).p2$prf);
                                ;
                                // JavaLine 222 <== SourceLine 1662
                                {
                                    // BEGIN INSPECTION 
                                    inspect$1662$108=((Common$varcall)(inspect$1614$106)).p2$argset;
                                    if(inspect$1662$108!=null) // INSPECT inspect$1662$108
                                    // JavaLine 227 <== SourceLine 1663
                                    {
                                        new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ARGLIST$1);
                                        ;
                                        new OuptFile$outbyt(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,inspect$1662$108.cardinal());
                                        ;
                                        // JavaLine 233 <== SourceLine 1664
                                        if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                            new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                                        }
                                        ;
                                        // JavaLine 238 <== SourceLine 1665
                                        y=((Common$expr)(inspect$1662$108.first()));
                                        ;
                                        x=y;
                                        while((x!=(null))) {
                                            // JavaLine 243 <== SourceLine 1667
                                            {
                                                y=((Common$expr)(x.suc()));
                                                ;
                                                new Pass1$SubBlock32$grammar$outexpr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),x);
                                            }
                                            x=y;
                                        }
                                        ;
                                    }
                                }
                                ;
                                // JavaLine 255 <== SourceLine 1669
                                new Pass1$SubBlock32$grammar$outexpr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),((Common$varcall)(inspect$1614$106)).p2$vx);
                                ;
                            }
                            else if(inspect$1614$106 instanceof Common$qualification) // WHEN Common$qualification DO 
                            // JavaLine 260 <== SourceLine 1672
                            {
                                new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_QUA$1);
                                ;
                                new OuptFile$outbyt(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Common$qualification)(inspect$1614$106)).p2$type);
                                ;
                                flg1=false;
                                ;
                            }
                            else // OTHERWISE 
                            // JavaLine 270 <== SourceLine 1674
                            new Common$IERR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62);
                        }
                    }
                    ;
                    // JavaLine 275 <== SourceLine 1675
                    new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ENDVAR$1);
                    ;
                }
            }
            ;
        }
        else if(inspect$1610$105 instanceof Common$repexpr) // WHEN Common$repexpr DO 
        // JavaLine 283 <== SourceLine 1680
        {
            new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_REPEXPR$1);
            ;
            // JavaLine 287 <== SourceLine 1681
            ((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.out2byte(((Common$repexpr)(inspect$1610$105)).p3$exprset.cardinal());
            ;
            y=((Common$expr)(((Common$repexpr)(inspect$1610$105)).p3$exprset.first()));
            ;
            // JavaLine 292 <== SourceLine 1682
            if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
            }
            ;
            x=y;
            while((x!=(null))) {
                // JavaLine 299 <== SourceLine 1684
                {
                    y=((Common$expr)(x.suc()));
                    ;
                    new Pass1$SubBlock32$grammar$outexpr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),x);
                }
                x=y;
            }
            ;
        }
        else if(inspect$1610$105 instanceof Common$quaopr) // WHEN Common$quaopr DO 
        // JavaLine 310 <== SourceLine 1687
        {
            new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_QUA$1);
            ;
            new Pass1$SubBlock32$grammar$outexpr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),((Common$quaopr)(inspect$1610$105)).p3$x);
            ;
            // JavaLine 316 <== SourceLine 1688
            new OuptFile$outbyt(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Common$quaopr)(inspect$1610$105)).p3$type);
        }
        else if(inspect$1610$105 instanceof Common$dsize) // WHEN Common$dsize DO 
        // JavaLine 320 <== SourceLine 1689
        {
            new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_DSIZE$1);
            ;
            new OuptFile$outident(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Common$dsize)(inspect$1610$105)).p3$r);
            ;
            // JavaLine 326 <== SourceLine 1690
            new Pass1$SubBlock32$grammar$outexpr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),((Common$dsize)(inspect$1610$105)).p3$x);
        }
        else if(inspect$1610$105 instanceof Common$binopr) // WHEN Common$binopr DO 
        // JavaLine 330 <== SourceLine 1691
        {
            new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Common$binopr)(inspect$1610$105)).p3$opr);
            ;
            new Pass1$SubBlock32$grammar$outexpr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),((Common$binopr)(inspect$1610$105)).p3$x);
            ;
            // JavaLine 336 <== SourceLine 1692
            new Pass1$SubBlock32$grammar$outexpr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),((Common$binopr)(inspect$1610$105)).p3$y);
        }
        else if(inspect$1610$105 instanceof Common$unopr) // WHEN Common$unopr DO 
        // JavaLine 340 <== SourceLine 1693
        {
            new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Common$unopr)(inspect$1610$105)).p3$opr);
            ;
            // JavaLine 344 <== SourceLine 1694
            new Pass1$SubBlock32$grammar$outexpr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),((Common$unopr)(inspect$1610$105)).p3$x);
        }
        else if(inspect$1610$105 instanceof Common$ifexpr) // WHEN Common$ifexpr DO 
        // JavaLine 348 <== SourceLine 1695
        {
            new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IFEXPR$1);
            ;
            new Pass1$SubBlock32$grammar$outexpr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),((Common$ifexpr)(inspect$1610$105)).cond$3);
            ;
            // JavaLine 354 <== SourceLine 1696
            if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
            }
            ;
            // JavaLine 359 <== SourceLine 1697
            new Pass1$SubBlock32$grammar$outexpr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),((Common$ifexpr)(inspect$1610$105)).x$3);
            ;
            // JavaLine 362 <== SourceLine 1698
            new Pass1$SubBlock32$grammar$outexpr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),((Common$ifexpr)(inspect$1610$105)).y$3);
        }
        else if(inspect$1610$105 instanceof Common$val_const) // WHEN Common$val_const DO 
        // JavaLine 366 <== SourceLine 1699
        {
            new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Common$val_const)(inspect$1610$105)).p3$instr);
            ;
            // JavaLine 370 <== SourceLine 1700
            if(VALUE$((((Common$val_const)(inspect$1610$105)).p3$instr==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_C_CHAR$1)))) {
                // JavaLine 372 <== SourceLine 1701
                new OuptFile$outbyt(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,rank(TXT$.getchar(((Common$val_const)(inspect$1610$105)).p4$v)));
            } else
            if(VALUE$((((Common$val_const)(inspect$1610$105)).p3$instr==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_TEXT$1)))) {
                new OuptFile$outlongstring(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Common$val_const)(inspect$1610$105)).p4$v);
            } else
            new OuptFile$outstring(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Common$val_const)(inspect$1610$105)).p4$v);
            ;
        }
        else if(inspect$1610$105 instanceof Common$offset_const) // WHEN Common$offset_const DO 
        // JavaLine 382 <== SourceLine 1704
        {
            new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Common$offset_const)(inspect$1610$105)).p3$instr);
            ;
            // JavaLine 386 <== SourceLine 1705
            new OuptFile$outident(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Common$offset_const)(inspect$1610$105)).of$4);
            ;
            ((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.out2byte(((Common$offset_const)(inspect$1610$105)).ndot$4);
            ;
            for(i=1;i<=((Common$offset_const)(inspect$1610$105)).ndot$4;i++) {
                // JavaLine 392 <== SourceLine 1706
                new OuptFile$outident(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Common$offset_const)(inspect$1610$105)).q.Elt[i-((Common$offset_const)(inspect$1610$105)).q.LB[0]]);
            }
            ;
        }
        else if(inspect$1610$105 instanceof Common$idn_const) // WHEN Common$idn_const DO 
        // JavaLine 398 <== SourceLine 1709
        {
            new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Common$idn_const)(inspect$1610$105)).p3$instr);
            ;
            // JavaLine 402 <== SourceLine 1710
            new OuptFile$outident(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Common$idn_const)(inspect$1610$105)).p4$ibox.id);
        }
        else if(inspect$1610$105 instanceof Common$structured_const) // WHEN Common$structured_const DO 
        // JavaLine 406 <== SourceLine 1711
        {
            ((Common$const$)inspect$1610$105).into(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.structset$1);
            ;
            // JavaLine 410 <== SourceLine 1712
            new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Common$structured_const)(inspect$1610$105)).p3$instr);
            ;
            // JavaLine 413 <== SourceLine 1713
            new OuptFile$outident(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Common$structured_const)(inspect$1610$105)).str$4);
            ;
        }
        else if(inspect$1610$105 instanceof Common$const$) // WHEN Common$const$ DO 
        // JavaLine 418 <== SourceLine 1716
        {
            new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Common$const$)(inspect$1610$105)).p3$instr);
            ;
        }
        else // OTHERWISE 
        // JavaLine 424 <== SourceLine 1719
        {
            new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_NOEXPR$1);
            ;
        }
    }
    ;
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure outexpr",1,1606,11,1607,13,1608,18,1610,20,1614,22,1644,24,1662,53,1610,59,1611,62,1612,68,1614,74,1615,77,1616,84,1618,87,1619,90,1621,93,1622,96,1623,99,1624,101,1625,105,1626,108,1627,113,1628,118,1630,132,1634,135,1635,142,1637,145,1638,148,1640,151,1641,154,1642,159,1643,162,1644,167,1645,173,1646,178,1647,183,1649,197,1653,200,1654,207,1656,210,1657,213,1659,216,1660,219,1661,222,1662,227,1663,233,1664,238,1665,243,1667,255,1669,260,1672,270,1674,275,1675,283,1680,287,1681,292,1682,299,1684,310,1687,316,1688,320,1689,326,1690,330,1691,336,1692,340,1693,344,1694,348,1695,354,1696,359,1697,362,1698,366,1699,370,1700,372,1701,382,1704,386,1705,392,1706,398,1709,402,1710,406,1711,410,1712,413,1713,418,1716,424,1719,433,1721);
} // End of Procedure
