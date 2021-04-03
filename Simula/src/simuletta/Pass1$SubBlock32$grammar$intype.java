// JavaLine 1 <== SourceLine 662
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$grammar$intype extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=662, lastLine=758, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 13 <== SourceLine 758
    final LABQNT$ ITEX=new LABQNT$(this,1,"ITEX"); // Local Label #1=ITEX
    // Declare locals as attributes
    // JavaLine 16 <== SourceLine 664
    int typ=0;
    int rec=0;
    int fixrep=0;
    // JavaLine 20 <== SourceLine 665
    int low=0;
    int up=0;
    // Normal Constructor
    public Pass1$SubBlock32$grammar$intype(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass1$SubBlock32$grammar$intype STM$() {
        Pass1$SubBlock32$grammar$intype THIS$=(Pass1$SubBlock32$grammar$intype)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 37 <== SourceLine 666
                switch(((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol) { // BEGIN SWITCH STATEMENT
                case 160: 
                // JavaLine 40 <== SourceLine 668
                RESULT$=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_INT$1;
                break;
                case 158: 
                // JavaLine 44 <== SourceLine 670
                {
                    RESULT$=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_SINT$1;
                    ;
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 50 <== SourceLine 671
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTEGER$1)))) {
                        // JavaLine 52 <== SourceLine 672
                        {
                            new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),672,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTEGER$1);
                            ;
                            GOTO$(ITEX); // GOTO EVALUATED LABEL
                        }
                    }
                    ;
                }
                break;
                case 49: 
                // JavaLine 63 <== SourceLine 675
                {
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 67 <== SourceLine 676
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                        new Pass1$SubBlock32$grammar$chckWrn(((Pass1$SubBlock32$grammar)(CUR$.SL$)),676,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1);
                    } else
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 73 <== SourceLine 677
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1)))) {
                        new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),677,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1);
                    }
                    ;
                    // JavaLine 78 <== SourceLine 678
                    up=TXT$.getint(((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval);
                    ;
                    // JavaLine 81 <== SourceLine 679
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 84 <== SourceLine 680
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COLON$1)))) {
                        // JavaLine 86 <== SourceLine 681
                        {
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 90 <== SourceLine 682
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),682,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1);
                            }
                            ;
                            // JavaLine 95 <== SourceLine 683
                            low=up;
                            ;
                            up=TXT$.getint(((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval);
                            ;
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                        }
                    }
                    ;
                    // JavaLine 105 <== SourceLine 685
                    RESULT$=new Common$defType(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.integerTypes$1,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RANGE$1,low,up).RESULT$;
                    ;
                    // JavaLine 108 <== SourceLine 686
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                        // JavaLine 110 <== SourceLine 687
                        {
                            new Pass1$SubBlock32$grammar$chckWrn(((Pass1$SubBlock32$grammar)(CUR$.SL$)),687,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                            ;
                            GOTO$(ITEX); // GOTO EVALUATED LABEL
                        }
                    }
                    ;
                }
                break;
                case 162: 
                // JavaLine 121 <== SourceLine 690
                RESULT$=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_REAL$1;
                break;
                case 159: 
                // JavaLine 125 <== SourceLine 692
                {
                    RESULT$=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_LREAL$1;
                    ;
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 131 <== SourceLine 693
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_REAL$1)))) {
                        {
                            new Pass1$SubBlock32$grammar$chckWrn(((Pass1$SubBlock32$grammar)(CUR$.SL$)),693,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_REAL$1);
                            ;
                            GOTO$(ITEX); // GOTO EVALUATED LABEL
                        }
                    }
                    ;
                }
                break;
                case 161: 
                // JavaLine 143 <== SourceLine 696
                RESULT$=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_SIZE$1;
                break;
                case 164: 
                // JavaLine 147 <== SourceLine 698
                RESULT$=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_BOOL$1;
                break;
                case 48: 
                // JavaLine 151 <== SourceLine 700
                RESULT$=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_LABEL$1;
                break;
                case 163: 
                // JavaLine 155 <== SourceLine 702
                RESULT$=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_CHAR$1;
                break;
                case 169: 
                // JavaLine 159 <== SourceLine 704
                {
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 163 <== SourceLine 705
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                        new Pass1$SubBlock32$grammar$chckWrn(((Pass1$SubBlock32$grammar)(CUR$.SL$)),705,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1);
                    } else
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 169 <== SourceLine 706
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                        // JavaLine 171 <== SourceLine 707
                        {
                            RESULT$=new Common$defType(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.entTypes$1,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1,0,0).RESULT$;
                            ;
                            // JavaLine 175 <== SourceLine 708
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                        }
                    } else
                    // JavaLine 180 <== SourceLine 709
                    RESULT$=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_ENT$1;
                    ;
                    // JavaLine 183 <== SourceLine 710
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                        {
                            new Pass1$SubBlock32$grammar$chckWrn(((Pass1$SubBlock32$grammar)(CUR$.SL$)),710,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                            ;
                            GOTO$(ITEX); // GOTO EVALUATED LABEL
                        }
                    }
                    ;
                }
                break;
                case 165: 
                // JavaLine 195 <== SourceLine 713
                {
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 199 <== SourceLine 714
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                        new Pass1$SubBlock32$grammar$chckWrn(((Pass1$SubBlock32$grammar)(CUR$.SL$)),714,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1);
                    } else
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 205 <== SourceLine 715
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                        // JavaLine 207 <== SourceLine 716
                        {
                            RESULT$=new Common$defType(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.refTypes$1,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1,0,0).RESULT$;
                            ;
                            // JavaLine 211 <== SourceLine 717
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                        }
                    } else
                    // JavaLine 216 <== SourceLine 718
                    RESULT$=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_REF$1;
                    ;
                    // JavaLine 219 <== SourceLine 719
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                        {
                            new Pass1$SubBlock32$grammar$chckWrn(((Pass1$SubBlock32$grammar)(CUR$.SL$)),719,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                            ;
                            GOTO$(ITEX); // GOTO EVALUATED LABEL
                        }
                    }
                    ;
                }
                break;
                case 166: 
                // JavaLine 231 <== SourceLine 722
                {
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 235 <== SourceLine 723
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                        new Pass1$SubBlock32$grammar$chckWrn(((Pass1$SubBlock32$grammar)(CUR$.SL$)),723,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1);
                    } else
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 241 <== SourceLine 724
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol<=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.N_KEYW$1)))) {
                        // JavaLine 243 <== SourceLine 725
                        {
                            typ=new Pass1$SubBlock32$grammar$intype(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$;
                            ;
                            // JavaLine 247 <== SourceLine 726
                            RESULT$=new Common$defType(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.nameTypes$1,typ,0,0).RESULT$;
                            ;
                        }
                    } else
                    // JavaLine 252 <== SourceLine 727
                    RESULT$=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_NAME$1;
                    ;
                    // JavaLine 255 <== SourceLine 728
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                        {
                            new Pass1$SubBlock32$grammar$chckWrn(((Pass1$SubBlock32$grammar)(CUR$.SL$)),728,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                            ;
                            GOTO$(ITEX); // GOTO EVALUATED LABEL
                        }
                    }
                    ;
                }
                break;
                case 167: 
                // JavaLine 267 <== SourceLine 731
                {
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 271 <== SourceLine 732
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                        new Pass1$SubBlock32$grammar$chckWrn(((Pass1$SubBlock32$grammar)(CUR$.SL$)),732,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1);
                    } else
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 277 <== SourceLine 733
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol<=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.N_KEYW$1)))) {
                        // JavaLine 279 <== SourceLine 734
                        {
                            typ=new Pass1$SubBlock32$grammar$intype(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$;
                            ;
                            // JavaLine 283 <== SourceLine 735
                            RESULT$=new Common$defType(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.fieldTypes$1,typ,0,0).RESULT$;
                            ;
                        }
                    } else
                    // JavaLine 288 <== SourceLine 736
                    RESULT$=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_FIELD$1;
                    ;
                    // JavaLine 291 <== SourceLine 737
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                        {
                            new Pass1$SubBlock32$grammar$chckWrn(((Pass1$SubBlock32$grammar)(CUR$.SL$)),737,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                            ;
                            GOTO$(ITEX); // GOTO EVALUATED LABEL
                        }
                    }
                    ;
                }
                break;
                case 168: 
                // JavaLine 303 <== SourceLine 740
                {
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 307 <== SourceLine 741
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                        new Pass1$SubBlock32$grammar$chckWrn(((Pass1$SubBlock32$grammar)(CUR$.SL$)),741,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1);
                    } else
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 313 <== SourceLine 742
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                        new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),742,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                    }
                    ;
                    // JavaLine 318 <== SourceLine 743
                    rec=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1;
                    ;
                    // JavaLine 321 <== SourceLine 744
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 324 <== SourceLine 745
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COLON$1)))) {
                        // JavaLine 326 <== SourceLine 746
                        {
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 330 <== SourceLine 747
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),747,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1);
                            }
                            ;
                            // JavaLine 335 <== SourceLine 748
                            fixrep=Math.addExact(TXT$.getint(((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval),1);
                            ;
                            // JavaLine 338 <== SourceLine 749
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                        }
                    } else
                    // JavaLine 343 <== SourceLine 750
                    fixrep=0;
                    ;
                    // JavaLine 346 <== SourceLine 751
                    RESULT$=new Common$defType(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.structTypes$1,rec,fixrep,0).RESULT$;
                    ;
                    // JavaLine 349 <== SourceLine 752
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                        {
                            new Pass1$SubBlock32$grammar$chckWrn(((Pass1$SubBlock32$grammar)(CUR$.SL$)),752,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                            ;
                            GOTO$(ITEX); // GOTO EVALUATED LABEL
                        }
                    }
                    ;
                }
                break;
                default:
                // JavaLine 361 <== SourceLine 755
                GOTO$(ITEX); // GOTO EVALUATED LABEL
                break;
            } // END SWITCH STATEMENT
            ;
            // JavaLine 366 <== SourceLine 757
            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
            ;
            // JavaLine 369 <== SourceLine 758
            LABEL$(1,"ITEX");
            ;
            break LOOP$;
        }
        catch(LABQNT$ q) {
            CUR$=THIS$;
            if(q.SL$!=CUR$) {
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("intype:NON-LOCAL",q);
                CUR$.STATE$=OperationalState.terminated;
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("intype:RE-THROW",q);
                throw(q);
            }
            if(RT.Option.GOTO_TRACING) TRACE_GOTO("intype:LOCAL",q);
            JTX$=q.index; continue LOOP$; // EG. GOTO Lx
        }
    }
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure intype",1,662,13,758,16,664,20,665,37,666,40,668,44,670,50,671,52,672,63,675,67,676,73,677,78,678,81,679,84,680,86,681,90,682,95,683,105,685,108,686,110,687,121,690,125,692,131,693,143,696,147,698,151,700,155,702,159,704,163,705,169,706,171,707,175,708,180,709,183,710,195,713,199,714,205,715,207,716,211,717,216,718,219,719,231,722,235,723,241,724,243,725,247,726,252,727,255,728,267,731,271,732,277,733,279,734,283,735,288,736,291,737,303,740,307,741,313,742,318,743,321,744,324,745,326,746,330,747,335,748,338,749,343,750,346,751,349,752,361,755,366,757,369,758,388,758);
} // End of Procedure
