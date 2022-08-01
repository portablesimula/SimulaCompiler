// JavaLine 1 <== SourceLine 652
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Pass1$SubBlock32$grammar extends FILE$ {
    // ClassDeclaration: Kind=Class, BlockLevel=3, PrefixLevel=1, firstLine=652, lastLine=1896, hasLocalClasses=false, System=false, detachUsed=true
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 <== SourceLine 1873
    final LABQNT$ strl5=new LABQNT$(this,1,"strl5"); // Local Label #1=strl5
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 659
    public int nstring$1=0;
    public int outline$1=0;
    // JavaLine 17 <== SourceLine 1168
    public ARRAY$<Common$designator[]>target=null;
    // Normal Constructor
    public Pass1$SubBlock32$grammar(RTObject$ staticLink,TXT$ sFILENAME$) {
        super(staticLink,sFILENAME$);
        // Parameter assignment to locals
        // Declaration Code
        // JavaLine 24 <== SourceLine 1168
        int[] target$LB=new int[1]; int[] target$UB=new int[1];
        target$LB[0]=0; target$UB[0]=10;
        BOUND_CHECK$(target$LB[0],target$UB[0]);
        target=new ARRAY$<Common$designator[]>(new Common$designator[target$UB[0]-target$LB[0]+1],target$LB,target$UB);
    }
    // Class Statements
    public Pass1$SubBlock32$grammar STM$() {
        Pass1$SubBlock32$grammar THIS$=(Pass1$SubBlock32$grammar)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // Class FILE: Code before inner
                // JavaLine 37 <== SourceLine 1863
                // Class grammar: Code before inner
                detach();
                ;
                // JavaLine 41 <== SourceLine 1864
                ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.taglist$1=((Pass1$SubBlock32)(CUR$.SL$)).taglast=new Common$seqtag(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,null).STM$();
                ;
                // JavaLine 44 <== SourceLine 1865
                if(VALUE$(((((Pass1$SubBlock32)(CUR$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_MODULE$1))|((((Pass1$SubBlock32)(CUR$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_GLOBAL$1)))))) {
                    // JavaLine 46 <== SourceLine 1866
                    {
                        ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.global_module$1=(((Pass1$SubBlock32)(CUR$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_GLOBAL$1));
                        ;
                        // JavaLine 50 <== SourceLine 1867
                        detach();
                        ;
                        // JavaLine 53 <== SourceLine 1868
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                            new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$)),1868,((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                        }
                        ;
                        // JavaLine 58 <== SourceLine 1869
                        ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.module_ident$1=new Common$edSymbol(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$)).inspect$28$62.hash$1).RESULT$;
                        ;
                        // JavaLine 61 <== SourceLine 1870
                        detach();
                        ;
                        // JavaLine 64 <== SourceLine 1871
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                            // JavaLine 66 <== SourceLine 1872
                            {
                                detach();
                                ;
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_STRING$1)))) {
                                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$)),1872,((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_STRING$1);
                                }
                                ;
                                // JavaLine 74 <== SourceLine 1873
                                ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.module_code$1=((Pass1$SubBlock32)(CUR$.SL$)).curval;
                                ;
                                LABEL$(1,"strl5");
                                detach();
                                ;
                                // JavaLine 80 <== SourceLine 1874
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_STRING$1)))) {
                                    // JavaLine 82 <== SourceLine 1875
                                    {
                                        ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.module_code$1=CONC(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.module_code$1,((Pass1$SubBlock32)(CUR$.SL$)).curval);
                                        ;
                                        GOTO$(strl5); // GOTO EVALUATED LABEL
                                    }
                                }
                                ;
                                // JavaLine 90 <== SourceLine 1876
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                                    new Pass1$SubBlock32$grammar$chckWrn(((Pass1$SubBlock32$grammar)(CUR$)),1876,((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                                } else
                                detach();
                                ;
                            }
                        }
                        ;
                        // JavaLine 99 <== SourceLine 1878
                        if(VALUE$(TRF_EQ(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.module_code$1,null))) {
                            ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.module_code$1=datetime();
                        }
                        ;
                    }
                }
                ;
                // JavaLine 107 <== SourceLine 1880
                ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.TRC_init$1=new Head$(((Pass1)(CUR$.SL$.SL$)).inspect$28$62).STM$();
                ;
                // JavaLine 110 <== SourceLine 1881
                if(VALUE$((!(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.TRC_info$1.empty())))) {
                    // JavaLine 112 <== SourceLine 1887
                    new Pass1$SubBlock32$grammar$SubBlock1882((CUR$)).STM$();
                    // JavaLine 114 <== SourceLine 1885
                }
                ;
                // JavaLine 117 <== SourceLine 1888
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_BEGIN$1)))) {
                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$)),1888,((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_BEGIN$1);
                }
                ;
                new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_BEGIN$1);
                ;
                // JavaLine 124 <== SourceLine 1889
                if(VALUE$((((Pass1)(CUR$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                    new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$)).inspect$29$63);
                }
                ;
                // JavaLine 129 <== SourceLine 1890
                ((Pass1$SubBlock32)(CUR$.SL$)).currentset=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.qntset$1;
                ;
                // JavaLine 132 <== SourceLine 1891
                new Pass1$SubBlock32$grammar$declarations(((Pass1$SubBlock32$grammar)(CUR$)),((Pass1)(CUR$.SL$.SL$)).inspect$28$62.qntset$1,false,false);
                ;
                new Pass1$SubBlock32$grammar$statement(((Pass1$SubBlock32$grammar)(CUR$)));
                ;
                // JavaLine 137 <== SourceLine 1892
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_END$1)))) {
                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$)),1892,((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_END$1);
                }
                ;
                new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_ENDPROGRAM$1);
                ;
                // JavaLine 144 <== SourceLine 1893
                if(VALUE$((((Pass1)(CUR$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                    new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$)).inspect$29$63);
                }
                ;
                // JavaLine 149 <== SourceLine 1894
                ((OuptFile)((Pass1)(CUR$.SL$.SL$)).inspect$29$63).close();
                ;
                GOTO$(((Pass1$SubBlock32)(CUR$.SL$)).EXITPASS1); // GOTO EVALUATED LABEL
                ;
                // JavaLine 154 <== SourceLine 1863
                // Class grammar: Code after inner
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("grammar:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("grammar:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("grammar:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Class grammar",1,652,11,1873,14,659,17,1168,24,1168,37,1863,41,1864,44,1865,46,1866,50,1867,53,1868,58,1869,61,1870,64,1871,66,1872,74,1873,80,1874,82,1875,90,1876,99,1878,107,1880,110,1881,112,1887,114,1885,117,1888,124,1889,129,1890,132,1891,137,1892,144,1893,149,1894,154,1863,172,1896);
} // End of Class
