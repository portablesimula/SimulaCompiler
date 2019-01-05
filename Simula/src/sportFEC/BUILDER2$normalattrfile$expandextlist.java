// JavaLine 1 ==> SourceLine 230
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$normalattrfile$expandextlist extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=230, lastLine=303, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$extbrecord p$module;
    public COMMON$brecord p$encl;
    // Declare local labels
    // JavaLine 13 ==> SourceLine 247
    final LABQNT$ GENQ=new LABQNT$(this,0,1); // Local Label #1=GENQ
    // JavaLine 15 ==> SourceLine 255
    final LABQNT$ GENOQ=new LABQNT$(this,0,2); // Local Label #2=GENOQ
    // JavaLine 17 ==> SourceLine 282
    final LABQNT$ ExpDescr=new LABQNT$(this,0,3); // Local Label #3=ExpDescr
    // JavaLine 19 ==> SourceLine 299
    final LABQNT$ EXIT=new LABQNT$(this,0,4); // Local Label #4=EXIT
    // Declare locals as attributes
    // JavaLine 22 ==> SourceLine 232
    COMMON$extquantity cq=null;
    COMMON$extquantity lq=null;
    int overload=0;
    // JavaLine 26 ==> SourceLine 233
    boolean genqnt=false;
    // JavaLine 28 ==> SourceLine 282
    COMMON$brecord inspect$282$0=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER2$normalattrfile$expandextlist setPar(Object param) {
        //Util.BREAK("CALL BUILDER2$normalattrfile$expandextlist.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$module=(COMMON$extbrecord)objectValue(param); break;
                case 1: p$encl=(COMMON$brecord)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER2$normalattrfile$expandextlist(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER2$normalattrfile$expandextlist(RTObject$ SL$,COMMON$extbrecord sp$module,COMMON$brecord sp$encl) {
        super(SL$);
        // Parameter assignment to locals
        this.p$module = sp$module;
        this.p$encl = sp$encl;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("expandextlist",282);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER2$normalattrfile$expandextlist STM$() {
        TRACE_BEGIN_STM$("expandextlist",282);
        BUILDER2$normalattrfile$expandextlist THIS$=(BUILDER2$normalattrfile$expandextlist)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 65 ==> SourceLine 239
                new COMMON$attrfile$nextKey(((BUILDER2$normalattrfile)(CUR$.SL$)));
                // JavaLine 67 ==> SourceLine 240
                overload=0;
                // JavaLine 69 ==> SourceLine 242
                while((((BUILDER2$normalattrfile)(CUR$.SL$)).key<(((BUILDER2$normalattrfile)(CUR$.SL$)).lowKey))) {
                    // JavaLine 71 ==> SourceLine 243
                    {
                        TRACE_BEGIN_STM$("CompoundStatement243",243);
                        genqnt=new COMMON$attrfile$fetchquant(((BUILDER2$normalattrfile)(CUR$.SL$))).RESULT$;
                        // JavaLine 75 ==> SourceLine 244
                        if((overload>(0))) {
                            // JavaLine 77 ==> SourceLine 245
                            {
                                TRACE_BEGIN_STM$("CompoundStatement245",245);
                                overload=(overload-(1));
                                GOTO$(GENOQ); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement245",245);
                            }
                        }
                        // JavaLine 85 ==> SourceLine 246
                        if(genqnt) {
                            // JavaLine 87 ==> SourceLine 247
                            {
                                TRACE_BEGIN_STM$("CompoundStatement247",247);
                                // JavaLine 90 ==> SourceLine 254
                                LABEL$(1); // GENQ
                                // JavaLine 92 ==> SourceLine 247
                                if((((BUILDER2$normalattrfile)(CUR$.SL$)).xlongindic!=(((BUILDER2)(CUR$.SL$.SL$)).NUL))) {
                                    // JavaLine 94 ==> SourceLine 248
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement248",248);
                                        overload=rank(((BUILDER2$normalattrfile)(CUR$.SL$)).xlongindic);
                                        // JavaLine 98 ==> SourceLine 249
                                        if((overload>(10))) {
                                            overload=(overload-((((overload>(20)))?(20):(10))));
                                        }
                                        // JavaLine 102 ==> SourceLine 251
                                        if((((BUILDER2$normalattrfile)(CUR$.SL$)).xclf==(((BUILDER2)(CUR$.SL$.SL$)).Clf005))) {
                                            // JavaLine 104 ==> SourceLine 252
                                            overload=((overload+(overload))+(1));
                                        }
                                        TRACE_END_STM$("CompoundStatement248",252);
                                    }
                                } else
                                // JavaLine 110 ==> SourceLine 254
                                if((((BUILDER2$normalattrfile)(CUR$.SL$)).xclf==(((BUILDER2)(CUR$.SL$.SL$)).Clf005))) {
                                    overload=1;
                                }
                                // JavaLine 114 ==> SourceLine 258
                                LABEL$(2); // GENOQ
                                // JavaLine 116 ==> SourceLine 255
                                cq=((((((BUILDER2$normalattrfile)(CUR$.SL$)).xcateg==(((BUILDER2)(CUR$.SL$.SL$)).C_extnal))&&((((BUILDER2$normalattrfile)(CUR$.SL$)).xclf!=(((BUILDER2)(CUR$.SL$.SL$)).Clf001)))))?(new BUILDER1$newextquantbrec(((BUILDER2)(CUR$.SL$.SL$)),p$encl.blev,p$encl.rtblev,'B',((COMMON$extquantity)(p$module.declquant))).RESULT$):(new COMMON$extquantity(((BUILDER2)(CUR$.SL$.SL$)),p$module).STM$()));
                                // JavaLine 118 ==> SourceLine 259
                                new BUILDER2$normalattrfile$fillextquantity(((BUILDER2$normalattrfile)(CUR$.SL$)),cq);
                                // JavaLine 120 ==> SourceLine 260
                                cq.encl=p$encl;
                                // JavaLine 122 ==> SourceLine 261
                                if((cq.categ!=(((BUILDER2)(CUR$.SL$.SL$)).C_virt))) {
                                    // JavaLine 124 ==> SourceLine 262
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement262",262);
                                        if((p$encl.fpar==(null))) {
                                            p$encl.fpar=lq=cq;
                                        } else
                                        // JavaLine 130 ==> SourceLine 263
                                        if((lq!=(null))) {
                                            lq=((COMMON$extquantity)(lq.next=cq));
                                        }
                                        // JavaLine 134 ==> SourceLine 266
                                        if(((cq.categ!=(((BUILDER2)(CUR$.SL$.SL$)).C_local))&&((cq.categ!=(((BUILDER2)(CUR$.SL$.SL$)).C_extnal))))) {
                                            // JavaLine 136 ==> SourceLine 268
                                            p$encl.npar=(p$encl.npar+(1));
                                        }
                                        // JavaLine 139 ==> SourceLine 269
                                        if((cq.kind==(((BUILDER2)(CUR$.SL$.SL$)).K_class))) {
                                            p$encl.localclasses=true;
                                        }
                                        TRACE_END_STM$("CompoundStatement262",269);
                                    }
                                } else
                                // JavaLine 146 ==> SourceLine 272
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement272",272);
                                    if((p$encl.favirt==(null))) {
                                        p$encl.favirt=lq=cq;
                                    } else
                                    // JavaLine 152 ==> SourceLine 273
                                    lq=((COMMON$extquantity)(lq.next=cq));
                                    // JavaLine 154 ==> SourceLine 275
                                    if((((BUILDER2$normalattrfile)(CUR$.SL$)).key==(((BUILDER2$normalattrfile)(CUR$.SL$)).begList))) {
                                        GOTO$(ExpDescr); // GOTO EVALUATED LABEL
                                    }
                                    TRACE_END_STM$("CompoundStatement272",275);
                                }
                                // JavaLine 160 ==> SourceLine 278
                                if((((cq.categ==(((BUILDER2)(CUR$.SL$.SL$)).C_local))||(((cq.categ==(((BUILDER2)(CUR$.SL$.SL$)).C_extnal))&&((cq.descr==(null))))))&&(((cq.kind==(((BUILDER2)(CUR$.SL$.SL$)).K_proc))||((cq.kind==(((BUILDER2)(CUR$.SL$.SL$)).K_class))))))) {
                                    // JavaLine 162 ==> SourceLine 293
                                    LABEL$(3); // ExpDescr
                                    // JavaLine 164 ==> SourceLine 282
                                    {
                                        // BEGIN INSPECTION 
                                        inspect$282$0=new COMMON$brecord(((BUILDER2)(CUR$.SL$.SL$))).STM$();
                                        if(inspect$282$0!=null) //INSPECT inspect$282$0
                                        // JavaLine 169 ==> SourceLine 283
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement283",283);
                                            inspect$282$0.blev=char$((rank(p$encl.blev)+(1)));
                                            // JavaLine 173 ==> SourceLine 284
                                            inspect$282$0.rtblev=char$((rank(p$encl.rtblev)+(1)));
                                            // JavaLine 175 ==> SourceLine 285
                                            cq.descr=((COMMON$brecord)inspect$282$0);
                                            inspect$282$0.declquant=cq;
                                            inspect$282$0.kind=((BUILDER2$normalattrfile)(CUR$.SL$)).xkind;
                                            // JavaLine 179 ==> SourceLine 286
                                            inspect$282$0.thisused=((BUILDER2$normalattrfile)(CUR$.SL$)).xthisused;
                                            // JavaLine 181 ==> SourceLine 289
                                            inspect$282$0.inrtag=((BUILDER2$normalattrfile)(CUR$.SL$)).xinrtag;
                                            inspect$282$0.hasCode=((BUILDER2$normalattrfile)(CUR$.SL$)).xhascode;
                                            // JavaLine 184 ==> SourceLine 291
                                            if((((BUILDER2$normalattrfile)(CUR$.SL$)).key==(((BUILDER2$normalattrfile)(CUR$.SL$)).begList))) {
                                                // JavaLine 186 ==> SourceLine 292
                                                new BUILDER2$normalattrfile$expandextlist(((BUILDER2$normalattrfile)(CUR$.SL$)),p$module,((COMMON$brecord)inspect$282$0));
                                            }
                                            TRACE_END_STM$("CompoundStatement283",292);
                                        }
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement247",292);
                            }
                        } else
                        // JavaLine 196 ==> SourceLine 296
                        if((((BUILDER2$normalattrfile)(CUR$.SL$)).key==(((BUILDER2$normalattrfile)(CUR$.SL$)).begList))) {
                            new BUILDER2$normalattrfile$skipList(((BUILDER2$normalattrfile)(CUR$.SL$)));
                        }
                        TRACE_END_STM$("CompoundStatement243",296);
                    }
                }
                // JavaLine 203 ==> SourceLine 299
                LABEL$(4); // EXIT
                if((((BUILDER2$normalattrfile)(CUR$.SL$)).key!=(((BUILDER2$normalattrfile)(CUR$.SL$)).endlist))) {
                    new BUILDER2$normalattrfile$expxerr(((BUILDER2$normalattrfile)(CUR$.SL$)),'E');
                }
                // JavaLine 208 ==> SourceLine 300
                new COMMON$attrfile$nextKey(((BUILDER2$normalattrfile)(CUR$.SL$)));
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
        TRACE_END_STM$("expandextlist",300);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Procedure expandextlist",1,230,13,247,15,255,17,282,19,299,22,232,26,233,28,282,65,239,67,240,69,242,71,243,75,244,77,245,85,246,87,247,90,254,92,247,94,248,98,249,102,251,104,252,110,254,114,258,116,255,118,259,120,260,122,261,124,262,130,263,134,266,136,268,139,269,146,272,152,273,154,275,160,278,162,293,164,282,169,283,173,284,175,285,179,286,181,289,184,291,186,292,196,296,203,299,208,300,226,303);
}
