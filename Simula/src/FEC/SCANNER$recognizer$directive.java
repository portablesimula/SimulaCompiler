// JavaLine 1 ==> SourceLine 678
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:53 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$recognizer$directive extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=678, lastLine=841, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 721
    final LABQNT$ SELPLUS=new LABQNT$(this,0,1); // Local Label #1=SELPLUS
    // JavaLine 13 ==> SourceLine 732
    final LABQNT$ SELECTED=new LABQNT$(this,0,2); // Local Label #2=SELECTED
    // JavaLine 15 ==> SourceLine 727
    final LABQNT$ SELMINUS=new LABQNT$(this,0,3); // Local Label #3=SELMINUS
    // JavaLine 17 ==> SourceLine 749
    final LABQNT$ PG=new LABQNT$(this,0,4); // Local Label #4=PG
    // JavaLine 19 ==> SourceLine 838
    final LABQNT$ DIRWARN=new LABQNT$(this,0,5); // Local Label #5=DIRWARN
    // JavaLine 21 ==> SourceLine 839
    final LABQNT$ SKIPLINE=new LABQNT$(this,0,6); // Local Label #6=SKIPLINE
    // JavaLine 23 ==> SourceLine 841
    final LABQNT$ EXIT=new LABQNT$(this,0,7); // Local Label #7=EXIT
    // Declare locals as attributes
    // JavaLine 26 ==> SourceLine 679
    char d=0;
    int i=0;
    TXT$ t=null;
    TXT$ u=null;
    // JavaLine 31 ==> SourceLine 680
    int cswa=0;
    int cswb=0;
    int startpos=0;
    // JavaLine 35 ==> SourceLine 749
    PrintFile$ inspect$749$14=null;
    // Normal Constructor
    public SCANNER$recognizer$directive(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("directive",749);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$recognizer$directive STM$() {
        TRACE_BEGIN_STM$("directive",749);
        SCANNER$recognizer$directive THIS$=(SCANNER$recognizer$directive)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 53 ==> SourceLine 715
                startpos=((SCANNER$recognizer)(CUR$.SL$)).linepos;
                // JavaLine 55 ==> SourceLine 716
                new SCANNER$recognizer$directive$nextChar(((SCANNER$recognizer$directive)CUR$));
                // JavaLine 57 ==> SourceLine 717
                if(((((SCANNER$recognizer)(CUR$.SL$)).atom==(((char)32)))||((((SCANNER$recognizer)(CUR$.SL$)).atom==(((SCANNER)(CUR$.SL$.SL$)).EOL))))) {
                    GOTO$(SKIPLINE); // GOTO EVALUATED LABEL
                }
                // JavaLine 61 ==> SourceLine 719
                if((((SCANNER$recognizer)(CUR$.SL$)).atom==('+'))) {
                    // JavaLine 63 ==> SourceLine 721
                    {
                        TRACE_BEGIN_STM$("CompoundStatement721",721);
                        // JavaLine 66 ==> SourceLine 722
                        LABEL$(1); // SELPLUS
                        // JavaLine 68 ==> SourceLine 721
                        while(((((SCANNER$recognizer)(CUR$.SL$)).atom==('+'))||(((SCANNER)(CUR$.SL$.SL$)).selector.Elt[isorank(((SCANNER$recognizer)(CUR$.SL$)).atom)-((SCANNER)(CUR$.SL$.SL$)).selector.LB[0]]))) {
                            // JavaLine 70 ==> SourceLine 722
                            new SCANNER$recognizer$directive$nextChar(((SCANNER$recognizer$directive)CUR$));
                        }
                        // JavaLine 73 ==> SourceLine 723
                        if((((SCANNER$recognizer)(CUR$.SL$)).atom==(((char)32)))) {
                            GOTO$(SELECTED); // GOTO EVALUATED LABEL
                        }
                        // JavaLine 77 ==> SourceLine 724
                        if((((SCANNER$recognizer)(CUR$.SL$)).atom!=('-'))) {
                            GOTO$(SKIPLINE); // GOTO EVALUATED LABEL
                        }
                        TRACE_END_STM$("CompoundStatement721",724);
                    }
                }
                // JavaLine 84 ==> SourceLine 726
                if((((SCANNER$recognizer)(CUR$.SL$)).atom==('-'))) {
                    // JavaLine 86 ==> SourceLine 727
                    {
                        TRACE_BEGIN_STM$("CompoundStatement727",727);
                        // JavaLine 89 ==> SourceLine 735
                        LABEL$(3); // SELMINUS
                        // JavaLine 91 ==> SourceLine 727
                        while(((((SCANNER$recognizer)(CUR$.SL$)).atom==('-'))||((!(((SCANNER)(CUR$.SL$.SL$)).selector.Elt[rank(((SCANNER$recognizer)(CUR$.SL$)).atom)-((SCANNER)(CUR$.SL$.SL$)).selector.LB[0]]))))) {
                            // JavaLine 93 ==> SourceLine 728
                            {
                                TRACE_BEGIN_STM$("CompoundStatement728",728);
                                new SCANNER$recognizer$directive$nextChar(((SCANNER$recognizer$directive)CUR$));
                                // JavaLine 97 ==> SourceLine 729
                                if((((SCANNER$recognizer)(CUR$.SL$)).atom==('+'))) {
                                    GOTO$(SELPLUS); // GOTO EVALUATED LABEL
                                }
                                // JavaLine 101 ==> SourceLine 730
                                if((((SCANNER$recognizer)(CUR$.SL$)).atom==(((char)32)))) {
                                    // JavaLine 103 ==> SourceLine 731
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement731",731);
                                        // JavaLine 106 ==> SourceLine 732
                                        LABEL$(2); // SELECTED
                                        if((((SCANNER$recognizer)(CUR$.SL$)).linepos>=(((SCANNER$recognizer)(CUR$.SL$)).linelength))) {
                                            GOTO$(SKIPLINE); // GOTO EVALUATED LABEL
                                        }
                                        // JavaLine 111 ==> SourceLine 733
                                        new SCANNER$recognizer$directive$nextChar(((SCANNER$recognizer$directive)CUR$));
                                        GOTO$(EXIT); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement731",733);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement728",733);
                            }
                        }
                        // JavaLine 120 ==> SourceLine 736
                        GOTO$(SKIPLINE); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement727",736);
                    }
                }
                // JavaLine 125 ==> SourceLine 739
                ((SCANNER$recognizer)(CUR$.SL$)).linepos=startpos;
                u=new SCANNER$recognizer$directive$linefield(((SCANNER$recognizer$directive)CUR$)).RESULT$;
                lowcase(u);
                // JavaLine 129 ==> SourceLine 741
                if(TXTREL$EQ(u,new TXT$("title"))) {
                    // JavaLine 131 ==> SourceLine 742
                    {
                        TRACE_BEGIN_STM$("CompoundStatement742",742);
                        ((SCANNER$recognizer)(CUR$.SL$)).curtitle=(((((SCANNER$recognizer)(CUR$.SL$)).linelength<=((startpos+(8)))))?(null):(copy(copy(TXT$.sub(((SCANNER$recognizer)(CUR$.SL$)).line,(startpos+(7)),(((SCANNER$recognizer)(CUR$.SL$)).linelength-(8)))))));
                        // JavaLine 135 ==> SourceLine 744
                        ((SCANNER$recognizer)(CUR$.SL$)).curtitle=CONC(CONC(((SCANNER)(CUR$.SL$.SL$)).sportid,new TXT$(" ")),((SCANNER$recognizer)(CUR$.SL$)).curtitle);
                        // JavaLine 137 ==> SourceLine 745
                        GOTO$(PG); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement742",745);
                    }
                }
                // JavaLine 142 ==> SourceLine 748
                if(TXTREL$EQ(u,new TXT$("page"))) {
                    // JavaLine 144 ==> SourceLine 749
                    {
                        TRACE_BEGIN_STM$("CompoundStatement749",749);
                        // JavaLine 147 ==> SourceLine 753
                        LABEL$(4); // PG
                        // JavaLine 149 ==> SourceLine 749
                        if(((SCANNER)(CUR$.SL$.SL$)).listingon) {
                            {
                                // BEGIN INSPECTION 
                                inspect$749$14=((SCANNER)(CUR$.SL$.SL$)).listfile;
                                if(inspect$749$14!=null) //INSPECT inspect$749$14
                                // JavaLine 155 ==> SourceLine 750
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement750",750);
                                    inspect$749$14.eject(1);
                                    inspect$749$14.outtext(((SCANNER$recognizer)(CUR$.SL$)).curtitle);
                                    // JavaLine 160 ==> SourceLine 751
                                    inspect$749$14.setpos((((SCANNER)(CUR$.SL$.SL$)).listlength-(5)));
                                    inspect$749$14.outint(inspect$749$14.page(),5);
                                    // JavaLine 163 ==> SourceLine 752
                                    inspect$749$14.outimage();
                                    inspect$749$14.outimage();
                                    TRACE_END_STM$("CompoundStatement750",752);
                                }
                            }
                        }
                        TRACE_END_STM$("CompoundStatement749",752);
                    }
                } else
                // JavaLine 173 ==> SourceLine 755
                if((TXTREL$EQ(u,new TXT$("copy"))|(TXTREL$EQ(u,new TXT$("insert"))))) {
                    // JavaLine 175 ==> SourceLine 756
                    {
                        TRACE_BEGIN_STM$("CompoundStatement756",756);
                        t=new SCANNER$recognizer$directive$linefield(((SCANNER$recognizer$directive)CUR$)).RESULT$;
                        if(TRF_EQ(t,null)) {
                            GOTO$(DIRWARN); // GOTO EVALUATED LABEL
                        }
                        // JavaLine 182 ==> SourceLine 757
                        new SCANNER$SourceElt(((SCANNER)(CUR$.SL$.SL$)),TXTREL$EQ(u,new TXT$("insert")),t).START();
                        GOTO$(EXIT); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement756",757);
                    }
                } else
                // JavaLine 188 ==> SourceLine 759
                if(TXTREL$EQ(u,new TXT$("eof"))) {
                    // JavaLine 190 ==> SourceLine 760
                    {
                        TRACE_BEGIN_STM$("CompoundStatement760",760);
                        ((SCANNER)(CUR$.SL$.SL$)).cursource.close$0().CPF();
                        if((((SCANNER)(CUR$.SL$.SL$)).cursource==(null))) {
                            ((SCANNER$recognizer)(CUR$.SL$)).detach();
                        }
                        // JavaLine 197 ==> SourceLine 761
                        GOTO$(EXIT); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement760",761);
                    }
                } else
                // JavaLine 202 ==> SourceLine 763
                if(TXTREL$EQ(u,new TXT$("definition"))) {
                    // JavaLine 204 ==> SourceLine 764
                    {
                        TRACE_BEGIN_STM$("CompoundStatement764",764);
                        ((SCANNER)(CUR$.SL$.SL$)).recomp=false;
                        ((SCANNER)(CUR$.SL$.SL$)).definition=true;
                        TRACE_END_STM$("CompoundStatement764",764);
                    }
                } else
                // JavaLine 212 ==> SourceLine 765
                if(TXTREL$EQ(u,new TXT$("implementation"))) {
                    // JavaLine 214 ==> SourceLine 766
                    {
                        TRACE_BEGIN_STM$("CompoundStatement766",766);
                        ((SCANNER)(CUR$.SL$.SL$)).recomp=true;
                        ((SCANNER)(CUR$.SL$.SL$)).definition=false;
                        TRACE_END_STM$("CompoundStatement766",766);
                    }
                } else
                // JavaLine 222 ==> SourceLine 769
                if(TXTREL$EQ(u,new TXT$("list"))) {
                    // JavaLine 224 ==> SourceLine 770
                    {
                        TRACE_BEGIN_STM$("CompoundStatement770",770);
                        if(new SCANNER$recognizer$directive$onoff(((SCANNER$recognizer$directive)CUR$)).RESULT$) {
                            ((SCANNER)(CUR$.SL$.SL$)).listingon=(((SCANNER)(CUR$.SL$.SL$)).listfile!=(null));
                        } else
                        // JavaLine 230 ==> SourceLine 771
                        ((SCANNER)(CUR$.SL$.SL$)).listingon=false;
                        TRACE_END_STM$("CompoundStatement770",771);
                    }
                } else
                // JavaLine 235 ==> SourceLine 773
                if(TXTREL$EQ(u,new TXT$("nodummy"))) {
                    ((SCANNER)(CUR$.SL$.SL$)).dummygen=(!(new SCANNER$recognizer$directive$onoff(((SCANNER$recognizer$directive)CUR$)).RESULT$));
                } else
                // JavaLine 239 ==> SourceLine 774
                if(TXTREL$EQ(u,new TXT$("slength"))) {
                    // JavaLine 241 ==> SourceLine 775
                    {
                        TRACE_BEGIN_STM$("CompoundStatement775",775);
                        i=new SCANNER$recognizer$directive$bytefield(((SCANNER$recognizer$directive)CUR$)).RESULT$;
                        ((SCANNER)(CUR$.SL$.SL$)).signiflength=i;
                        TRACE_END_STM$("CompoundStatement775",775);
                    }
                } else
                // JavaLine 249 ==> SourceLine 777
                if(TXTREL$EQ(u,new TXT$("select"))) {
                    // JavaLine 251 ==> SourceLine 778
                    {
                        TRACE_BEGIN_STM$("CompoundStatement778",778);
                        i=0;
                        t=new SCANNER$recognizer$directive$linefield(((SCANNER$recognizer$directive)CUR$)).RESULT$;
                        // JavaLine 256 ==> SourceLine 779
                        if(TXTREL$EQ(t,new TXT$("+"))) {
                            {
                                TRACE_BEGIN_STM$("CompoundStatement779",779);
                                i=1;
                                t=new SCANNER$recognizer$directive$linefield(((SCANNER$recognizer$directive)CUR$)).RESULT$;
                                TRACE_END_STM$("CompoundStatement779",779);
                            }
                        } else
                        // JavaLine 265 ==> SourceLine 780
                        if(TXTREL$EQ(t,new TXT$("-"))) {
                            {
                                TRACE_BEGIN_STM$("CompoundStatement780",780);
                                i=2;
                                t=new SCANNER$recognizer$directive$linefield(((SCANNER$recognizer$directive)CUR$)).RESULT$;
                                TRACE_END_STM$("CompoundStatement780",780);
                            }
                        }
                        // JavaLine 274 ==> SourceLine 781
                        new SCANNER$SetSelectors(((SCANNER)(CUR$.SL$.SL$)),t,i);
                        TRACE_END_STM$("CompoundStatement778",781);
                    }
                } else
                // JavaLine 279 ==> SourceLine 783
                if(TXTREL$EQ(u,new TXT$("record"))) {
                    ((SCANNER)(CUR$.SL$.SL$)).Simuletta=new SCANNER$recognizer$directive$onoff(((SCANNER$recognizer$directive)CUR$)).RESULT$;
                } else
                // JavaLine 283 ==> SourceLine 812
                {
                    TRACE_BEGIN_STM$("CompoundStatement812",812);
                    if((((((TXTREL$EQ(u,new TXT$("boundcheck"))|(TXTREL$EQ(u,new TXT$("nonecheck"))))|(TXTREL$EQ(u,new TXT$("implnone"))))|(TXTREL$EQ(u,new TXT$("quacheck"))))|(TXTREL$EQ(u,new TXT$("reuse"))))|(TXTREL$EQ(u,new TXT$("sport"))))) {
                        // JavaLine 287 ==> SourceLine 816
                        {
                            TRACE_BEGIN_STM$("CompoundStatement816",816);
                            if(new SCANNER$recognizer$directive$onoff(((SCANNER$recognizer$directive)CUR$)).RESULT$) {
                                cswb=1;
                            } else
                            cswb=0;
                            // JavaLine 294 ==> SourceLine 817
                            if(TXTREL$EQ(u,new TXT$("sport"))) {
                                ((SCANNER)(CUR$.SL$.SL$)).SportOK=(cswb==(1));
                            }
                            // JavaLine 298 ==> SourceLine 818
                            cswa=((TXTREL$EQ(u,new TXT$("boundcheck")))?(256):(((TXTREL$EQ(u,new TXT$("nonecheck")))?(257):(((TXTREL$EQ(u,new TXT$("quacheck")))?(258):(((TXTREL$EQ(u,new TXT$("reuse")))?(259):(((TXTREL$EQ(u,new TXT$("implnone")))?(260):(261))))))))));
                            TRACE_END_STM$("CompoundStatement816",818);
                        }
                    } else
                    // JavaLine 303 ==> SourceLine 825
                    if(TXTREL$EQ(u,new TXT$("setswitch"))) {
                        // JavaLine 305 ==> SourceLine 826
                        {
                            TRACE_BEGIN_STM$("CompoundStatement826",826);
                            cswa=new SCANNER$recognizer$directive$bytefield(((SCANNER$recognizer$directive)CUR$)).RESULT$;
                            cswb=new SCANNER$recognizer$directive$bytefield(((SCANNER$recognizer$directive)CUR$)).RESULT$;
                            TRACE_END_STM$("CompoundStatement826",826);
                        }
                    } else
                    // JavaLine 313 ==> SourceLine 829
                    {
                        TRACE_BEGIN_STM$("CompoundStatement829",829);
                        cswa=987;
                        // JavaLine 317 ==> SourceLine 830
                        ((SCANNER)(CUR$.SL$.SL$)).simsymbol=TXT$.sub(((SCANNER$recognizer)(CUR$.SL$)).line,startpos,((((SCANNER$recognizer)(CUR$.SL$)).linelength-(startpos))+(1)));
                        // JavaLine 319 ==> SourceLine 831
                        new COMMON$DEFCONST(((SCANNER)(CUR$.SL$.SL$)));
                        // JavaLine 321 ==> SourceLine 832
                        cswb=((rank(((SCANNER)(CUR$.SL$.SL$)).hashhi)*(256))+(rank(((SCANNER)(CUR$.SL$.SL$)).hashlo)));
                        TRACE_END_STM$("CompoundStatement829",832);
                    }
                    // JavaLine 325 ==> SourceLine 834
                    ((SCANNER)(CUR$.SL$.SL$)).P1coder.cswa=cswa;
                    // JavaLine 327 ==> SourceLine 835
                    ((SCANNER)(CUR$.SL$.SL$)).P1coder.cswb=cswb;
                    ((SCANNER)(CUR$.SL$.SL$)).opn=((SCANNER)(CUR$.SL$.SL$)).ISSWA;
                    call(((SCANNER)(CUR$.SL$.SL$)).P1coder);
                    TRACE_END_STM$("CompoundStatement812",835);
                }
                // JavaLine 333 ==> SourceLine 837
                if(false) {
                    // JavaLine 335 ==> SourceLine 838
                    {
                        TRACE_BEGIN_STM$("CompoundStatement838",838);
                        LABEL$(5); // DIRWARN
                        if(((SCANNER)(CUR$.SL$.SL$)).GiveNotes) {
                            new SCANNER$P1warn(((SCANNER)(CUR$.SL$.SL$)),278);
                        }
                        TRACE_END_STM$("CompoundStatement838",838);
                    }
                }
                // JavaLine 345 ==> SourceLine 839
                LABEL$(6); // SKIPLINE
                ((SCANNER$recognizer)(CUR$.SL$)).atom=((SCANNER)(CUR$.SL$.SL$)).EOL;
                // JavaLine 348 ==> SourceLine 841
                LABEL$(7); // EXIT
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$ || q.prefixLevel!=0) {
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("directive",841);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure directive",1,678,11,721,13,732,15,727,17,749,19,838,21,839,23,841,26,679,31,680,35,749,53,715,55,716,57,717,61,719,63,721,66,722,68,721,70,722,73,723,77,724,84,726,86,727,89,735,91,727,93,728,97,729,101,730,103,731,106,732,111,733,120,736,125,739,129,741,131,742,135,744,137,745,142,748,144,749,147,753,149,749,155,750,160,751,163,752,173,755,175,756,182,757,188,759,190,760,197,761,202,763,204,764,212,765,214,766,222,769,224,770,230,771,235,773,239,774,241,775,249,777,251,778,256,779,265,780,274,781,279,783,283,812,287,816,294,817,298,818,303,825,305,826,313,829,317,830,319,831,321,832,325,834,327,835,333,837,335,838,345,839,348,841,366,841);
}
