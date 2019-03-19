// JavaLine 1 ==> SourceLine 76
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon Mar 18 11:16:18 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst106$PBLK76 extends Simulation$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=2, firstLine=76, lastLine=242, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 13 ==> SourceLine 242
    final LABQNT$ EXIT=new LABQNT$(this,2,1); // Local Label #1=EXIT
    // Declare locals as attributes
    // JavaLine 16 ==> SourceLine 76
    public ARRAY$<TXT$[]>answer=null;
    public ARRAY$<TXT$[]>ut=null;
    int utnr=0;
    int i=0;
    // JavaLine 21 ==> SourceLine 161
    Head$ towns=null;
    Head$ h=null;
    // JavaLine 24 ==> SourceLine 162
    simtst106$simtst106$PBLK76$town r=null;
    simtst106$simtst106$PBLK76$town destination=null;
    // JavaLine 27 ==> SourceLine 163
    float starttime=0.0f;
    // JavaLine 29 ==> SourceLine 164
    boolean stop=false;
    // JavaLine 31 ==> SourceLine 165
    TXT$ t=null;
    // JavaLine 33 ==> SourceLine 166
    char ch=0;
    // Normal Constructor
    public simtst106$PBLK76(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("simtst106$PBLK76",166);
        // JavaLine 41 ==> SourceLine 76
        int[] answer$LB=new int[1]; int[] answer$UB=new int[1];
        answer$LB[0]=1; answer$UB[0]=500;
        BOUND_CHECK$(answer$LB[0],answer$UB[0]);
        answer=new ARRAY$<TXT$[]>(new TXT$[answer$UB[0]-answer$LB[0]+1],answer$LB,answer$UB);
        int[] ut$LB=new int[1]; int[] ut$UB=new int[1];
        ut$LB[0]=1; ut$UB[0]=500;
        BOUND_CHECK$(ut$LB[0],ut$UB[0]);
        ut=new ARRAY$<TXT$[]>(new TXT$[ut$UB[0]-ut$LB[0]+1],ut$LB,ut$UB);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("simtst106$PBLK76",76,inner);
                simtst106$PBLK76 THIS$=(simtst106$PBLK76)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 58 ==> SourceLine 168
                        if(VALUE$((!(((simtst106)(CUR$.SL$)).inspect$20$0.open(blanks(80)))))) {
                            {
                                TRACE_BEGIN_STM$("CompoundStatement168",168);
                                ((simtst106)(CUR$.SL$)).found_error=true;
                                // JavaLine 63 ==> SourceLine 169
                                sysout().outtext(new TXT$("error: Cannot open infile \"data96\" "));
                                // JavaLine 65 ==> SourceLine 170
                                sysout().outimage();
                                GOTO$(EXIT); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement168",170);
                            }
                        }
                        // JavaLine 71 ==> SourceLine 173
                        answer.Elt[1-answer.LB[0]]=copy(copy(new TXT$("shortest way from SAND to FJELLHAUG goes through VANG.")));
                        // JavaLine 73 ==> SourceLine 175
                        answer.Elt[2-answer.LB[0]]=copy(copy(new TXT$("the distance is    120.000.")));
                        // JavaLine 75 ==> SourceLine 177
                        answer.Elt[4-answer.LB[0]]=copy(copy(new TXT$("shortest way from VESTBY to DAL goes through BERG, FJELLHAUG.")));
                        // JavaLine 77 ==> SourceLine 180
                        answer.Elt[5-answer.LB[0]]=copy(copy(new TXT$("the distance is    145.000.")));
                        // JavaLine 79 ==> SourceLine 182
                        answer.Elt[7-answer.LB[0]]=copy(copy(new TXT$("shortest way from VANG to BERG goes through VESTBY.")));
                        // JavaLine 81 ==> SourceLine 184
                        answer.Elt[8-answer.LB[0]]=copy(copy(new TXT$("the distance is    110.000.")));
                        // JavaLine 83 ==> SourceLine 186
                        answer.Elt[10-answer.LB[0]]=copy(copy(new TXT$("shortest way from SAND to SUNDHOLM goes through VESTBY.")));
                        // JavaLine 85 ==> SourceLine 188
                        answer.Elt[11-answer.LB[0]]=copy(copy(new TXT$("the distance is    110.000.")));
                        // JavaLine 87 ==> SourceLine 191
                        t=blanks(100);
                        // JavaLine 89 ==> SourceLine 192
                        towns=new Head$(((simtst106$PBLK76)CUR$)).STM$();
                        // JavaLine 91 ==> SourceLine 193
                        for(boolean CB$193:new ForList(
                            new WhileElt<Character>(new NAME$<Character>(){ public Character put(Character x$){ch=(char)x$; return(x$);};  public Character get(){return((Character)ch); }	},new NAME$<Character>() { public Character get(){return(((simtst106)(CUR$.SL$)).inspect$20$0.inchar()); }},new NAME$<Boolean>() { public Boolean get(){return(ch!=('*')); }})
                           )) { if(!CB$193) continue;
                        // JavaLine 95 ==> SourceLine 194
                        {
                            TRACE_BEGIN_STM$("CompoundStatement194",194);
                            ((simtst106)(CUR$.SL$)).inspect$20$0.setpos((((simtst106)(CUR$.SL$)).inspect$20$0.pos()-(1)));
                            new simtst106$simtst106$PBLK76$scan(((simtst106$PBLK76)CUR$));
                            new simtst106$simtst106$PBLK76$load(((simtst106$PBLK76)CUR$));
                            // JavaLine 101 ==> SourceLine 195
                            r=((towns.empty())?(new simtst106$simtst106$PBLK76$town(((simtst106$PBLK76)CUR$),copy(TXT$.strip(t))).STM$()):(new simtst106$simtst106$PBLK76$town$find(((simtst106$simtst106$PBLK76$town)(towns.first())),TXT$.strip(t)).RESULT$));
                            // JavaLine 103 ==> SourceLine 197
                            new simtst106$simtst106$PBLK76$scan(((simtst106$PBLK76)CUR$));
                            // JavaLine 105 ==> SourceLine 198
                            for(boolean CB$198:new ForList(
                                new WhileElt<Character>(new NAME$<Character>(){ public Character put(Character x$){ch=(char)x$; return(x$);};  public Character get(){return((Character)ch); }	},new NAME$<Character>() { public Character get(){return(((simtst106)(CUR$.SL$)).inspect$20$0.inchar()); }},new NAME$<Boolean>() { public Boolean get(){return(ch!=('}')); }})
                               )) { if(!CB$198) continue;
                            // JavaLine 109 ==> SourceLine 199
                            {
                                TRACE_BEGIN_STM$("CompoundStatement199",199);
                                ((simtst106)(CUR$.SL$)).inspect$20$0.setpos((((simtst106)(CUR$.SL$)).inspect$20$0.pos()-(1)));
                                // JavaLine 113 ==> SourceLine 200
                                new simtst106$simtst106$PBLK76$load(((simtst106$PBLK76)CUR$));
                                // JavaLine 115 ==> SourceLine 201
                                ((simtst106$PBLK76)CUR$).ActivateDirect(false,new simtst106$simtst106$PBLK76$car(((simtst106$PBLK76)CUR$),r,new simtst106$simtst106$PBLK76$town$find(((simtst106$simtst106$PBLK76$town)(towns.first())),TXT$.strip(t)).RESULT$,new simtst106$simtst106$PBLK76$readReal(((simtst106$PBLK76)CUR$)).RESULT$).START());
                                // JavaLine 117 ==> SourceLine 202
                                new simtst106$simtst106$PBLK76$scan(((simtst106$PBLK76)CUR$));
                                TRACE_END_STM$("CompoundStatement199",202);
                            }
                        }
                        // JavaLine 122 ==> SourceLine 204
                        new simtst106$simtst106$PBLK76$scan(((simtst106$PBLK76)CUR$));
                        TRACE_END_STM$("CompoundStatement194",204);
                    }
                }
                // JavaLine 127 ==> SourceLine 206
                for(boolean CB$206:new ForList(
                    new WhileElt<Character>(new NAME$<Character>(){ public Character put(Character x$){ch=(char)x$; return(x$);};  public Character get(){return((Character)ch); }	},new NAME$<Character>() { public Character get(){return(ch); }},new NAME$<Boolean>() { public Boolean get(){return((!(((simtst106)(CUR$.SL$)).inspect$20$0.lastitem()))); }})
                   )) { if(!CB$206) continue;
                // JavaLine 131 ==> SourceLine 207
                {
                    TRACE_BEGIN_STM$("CompoundStatement207",207);
                    new simtst106$simtst106$PBLK76$scan(((simtst106$PBLK76)CUR$));
                    new simtst106$simtst106$PBLK76$load(((simtst106$PBLK76)CUR$));
                    // JavaLine 136 ==> SourceLine 208
                    r=new simtst106$simtst106$PBLK76$town$find(((simtst106$simtst106$PBLK76$town)(towns.first())),TXT$.strip(t)).RESULT$;
                    // JavaLine 138 ==> SourceLine 209
                    new simtst106$simtst106$PBLK76$scan(((simtst106$PBLK76)CUR$));
                    new simtst106$simtst106$PBLK76$load(((simtst106$PBLK76)CUR$));
                    // JavaLine 141 ==> SourceLine 210
                    destination=new simtst106$simtst106$PBLK76$town$find(((simtst106$simtst106$PBLK76$town)(towns.first())),TXT$.strip(t)).RESULT$;
                    // JavaLine 143 ==> SourceLine 211
                    new simtst106$simtst106$PBLK76$townpoint(((simtst106$PBLK76)CUR$),r).STM$().into(((simtst106$simtst106$PBLK76$car)(r.cars.first())).been);
                    // JavaLine 145 ==> SourceLine 212
                    ((simtst106$PBLK76)CUR$).ActivateDirect(false,((Process$)(r.cars.first())));
                    // JavaLine 147 ==> SourceLine 213
                    starttime=((float)(time()));
                    passivate();
                    // JavaLine 150 ==> SourceLine 214
                    sysout().outtext(new TXT$("shortest way from "));
                    sysout().outtext(r.p2$nam_);
                    // JavaLine 153 ==> SourceLine 215
                    sysout().outtext(new TXT$(" to "));
                    sysout().outtext(destination.p2$nam_);
                    // JavaLine 156 ==> SourceLine 216
                    if(VALUE$((h.cardinal()==(2)))) {
                        // JavaLine 158 ==> SourceLine 217
                        sysout().outtext(new TXT$(" goes direct  "));
                    } else
                    sysout().outtext(new TXT$(" goes through "));
                    // JavaLine 162 ==> SourceLine 218
                    new simtst106$simtst106$PBLK76$townpoint$write(((simtst106$simtst106$PBLK76$townpoint)(h.first().suc())));
                    sysout().outtext(new TXT$("the distance is "));
                    // JavaLine 165 ==> SourceLine 219
                    sysout().outfix((time()-(((double)(starttime)))),3,10);
                    sysout().outchar('.');
                    // JavaLine 168 ==> SourceLine 220
                    new simtst106$simtst106$PBLK76$Outimage(((simtst106$PBLK76)CUR$));
                    new simtst106$simtst106$PBLK76$Outimage(((simtst106$PBLK76)CUR$));
                    // JavaLine 171 ==> SourceLine 221
                    stop=true;
                    // JavaLine 173 ==> SourceLine 222
                    if(VALUE$((current().nextev()!=(null)))) {
                        passivate();
                    }
                    // JavaLine 177 ==> SourceLine 223
                    stop=false;
                    // JavaLine 179 ==> SourceLine 224
                    r=((simtst106$simtst106$PBLK76$town)(towns.first()));
                    r.gone=false;
                    // JavaLine 182 ==> SourceLine 225
                    for(boolean CB$225:new ForList(
                        new WhileElt<simtst106$simtst106$PBLK76$town>(new NAME$<simtst106$simtst106$PBLK76$town>(){ public simtst106$simtst106$PBLK76$town put(simtst106$simtst106$PBLK76$town x$){r=(simtst106$simtst106$PBLK76$town)x$; return(x$);};  public simtst106$simtst106$PBLK76$town get(){return((simtst106$simtst106$PBLK76$town)r); }	},new NAME$<simtst106$simtst106$PBLK76$town>() { public simtst106$simtst106$PBLK76$town get(){return(((simtst106$simtst106$PBLK76$town)(r.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return(IS$(r,simtst106$simtst106$PBLK76$town.class)); }})
                       )) { if(!CB$225) continue;
                    r.gone=false;
                }
                TRACE_END_STM$("CompoundStatement207",225);
            }
        }
        // JavaLine 191 ==> SourceLine 228
        for(boolean CB$228:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(utnr); }})
           )) { if(!CB$228) continue;
        // JavaLine 195 ==> SourceLine 229
        if(VALUE$(TXTREL$NE(ut.Elt[i-ut.LB[0]],answer.Elt[i-answer.LB[0]]))) {
            ((simtst106)(CUR$.SL$)).found_error=true;
        }
    }
    // JavaLine 200 ==> SourceLine 231
    if(VALUE$(((simtst106)(CUR$.SL$)).found_error)) {
        // JavaLine 202 ==> SourceLine 232
        {
            TRACE_BEGIN_STM$("CompoundStatement232",232);
            // JavaLine 205 ==> SourceLine 233
            sysout().outtext(new TXT$("*** error : Simulation program produces erroneus output:"));
            sysout().outimage();
            // JavaLine 208 ==> SourceLine 234
            for(boolean CB$234:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(utnr); }})
               )) { if(!CB$234) continue;
            // JavaLine 212 ==> SourceLine 235
            {
                TRACE_BEGIN_STM$("CompoundStatement235",235);
                sysout().outtext(ut.Elt[i-ut.LB[0]]);
                sysout().outimage();
                // JavaLine 217 ==> SourceLine 236
                sysout().outtext(new TXT$(" - supposed to be:"));
                sysout().outimage();
                // JavaLine 220 ==> SourceLine 237
                sysout().outtext(answer.Elt[i-answer.LB[0]]);
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement235",237);
            }
        }
        TRACE_END_STM$("CompoundStatement232",237);
    }
}
// JavaLine 229 ==> SourceLine 240
((simtst106)(CUR$.SL$)).inspect$20$0.close();
// JavaLine 231 ==> SourceLine 242
LABEL$(1,"EXIT");
break LOOP$;
}
catch(LABQNT$ q) {
CUR$=THIS$;
if(q.SL$!=CUR$ || q.prefixLevel!=2) {
    CUR$.STATE$=OperationalState.terminated;
    if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
    throw(q);
}
if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
JTX$=q.index; continue LOOP$; // EG. GOTO Lx
}
}
TRACE_END_STM$("simtst106$PBLK76",242);
}
};
} // End of Constructor
public static PROGINFO$ INFO$=new PROGINFO$("simtst106.sim","PrefixedBlock simtst106$PBLK76",1,76,13,242,16,76,21,161,24,162,27,163,29,164,31,165,33,166,41,76,58,168,63,169,65,170,71,173,73,175,75,177,77,180,79,182,81,184,83,186,85,188,87,191,89,192,91,193,95,194,101,195,103,197,105,198,109,199,113,200,115,201,117,202,122,204,127,206,131,207,136,208,138,209,141,210,143,211,145,212,147,213,150,214,153,215,156,216,158,217,162,218,165,219,168,220,171,221,173,222,177,223,179,224,182,225,191,228,195,229,200,231,202,232,205,233,208,234,212,235,217,236,220,237,229,240,231,242,249,242);
}
