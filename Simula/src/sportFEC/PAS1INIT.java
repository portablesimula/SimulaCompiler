// JavaLine 1 ==> SourceLine 3
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:32 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class PAS1INIT extends PARSER {
    // ClassDeclaration: BlockKind=Class, BlockLevel=1, PrefixLevel=5, firstLine=3, lastLine=533, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(5); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 12 ==> SourceLine 73
    final LABQNT$ SETem=new LABQNT$(this,5,1); // Local Label #1=SETem
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 31
    public int i=0;
    public char cs=0;
    public TXT$ t=null;
    public TXT$ listname=null;
    public TXT$ feoptions=null;
    // JavaLine 21 ==> SourceLine 57
    public PrintFile$ inspect$57$0=null;
    // JavaLine 23 ==> SourceLine 190
    public COMMON$identsymbol inspect$190$1=null;
    // JavaLine 25 ==> SourceLine 373
    public PARSER$grammer inspect$373$2=null;
    // JavaLine 27 ==> SourceLine 462
    public SCANNER$recognizer inspect$462$3=null;
    // JavaLine 29 ==> SourceLine 504
    public SCANNER$L2Coder inspect$504$4=null;
    // JavaLine 31 ==> SourceLine 511
    public COMMON$brecord inspect$511$5=null;
    // JavaLine 33 ==> SourceLine 513
    public COMMON$quantity inspect$513$6=null;
    // Normal Constructor
    public PAS1INIT(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("PAS1INIT",513);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,5) {
            public void STM$() {
                TRACE_BEGIN_STM$("PAS1INIT",513,inner);
                PAS1INIT THIS$=(PAS1INIT)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 49 ==> SourceLine 36
                        L2NAME=getTextInfo(7);
                        nscodename=getTextInfo(4);
                        // JavaLine 52 ==> SourceLine 40
                        recomp=(getIntInfo(22)==(1));
                        // JavaLine 54 ==> SourceLine 41
                        GenerateScode=(getIntInfo(1)==(1));
                        // JavaLine 56 ==> SourceLine 43
                        timestamp=datetime();
                        // JavaLine 58 ==> SourceLine 44
                        maxerrno=getIntInfo(4);
                        // JavaLine 60 ==> SourceLine 45
                        GiveNotes=(getIntInfo(5)==(0));
                        // JavaLine 62 ==> SourceLine 46
                        simob_level=getIntInfo(30);
                        // JavaLine 64 ==> SourceLine 47
                        simob_descr=(simob_level>(0));
                        // JavaLine 66 ==> SourceLine 48
                        simob_entity=(simob_level>=(2));
                        simob_const=(simob_level>=(3));
                        // JavaLine 69 ==> SourceLine 53
                        listname=getTextInfo(2);
                        listlength=TXT$.length(sysout().image);
                        // JavaLine 72 ==> SourceLine 54
                        if(VALUE$(TRF_NE(listname,null))) {
                            // JavaLine 74 ==> SourceLine 55
                            {
                                TRACE_BEGIN_STM$("CompoundStatement55",55);
                                t=copy(copy(listname));
                                t=lowcase(t);
                                // JavaLine 79 ==> SourceLine 56
                                if(VALUE$(TXTREL$EQ(t,new TXT$("sysout")))) {
                                    listfile=sysout();
                                } else
                                // JavaLine 83 ==> SourceLine 57
                                {
                                    // BEGIN INSPECTION 
                                    inspect$57$0=new PrintFile$(((BASICIO$)CTX$),listname).STM$();
                                    if(inspect$57$0!=null) //INSPECT inspect$57$0
                                    // JavaLine 88 ==> SourceLine 58
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement58",58);
                                        listlength=getIntInfo(7);
                                        t=blanks(listlength);
                                        // JavaLine 93 ==> SourceLine 59
                                        if(VALUE$((!(inspect$57$0.open(t))))) {
                                            // JavaLine 95 ==> SourceLine 60
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement60",60);
                                                listlength=0;
                                                // JavaLine 99 ==> SourceLine 61
                                                new ERRMSG$error1(((PAS1INIT)CUR$),-366,listname);
                                                TRACE_END_STM$("CompoundStatement60",61);
                                            }
                                        } else
                                        listfile=((PrintFile$)inspect$57$0);
                                        TRACE_END_STM$("CompoundStatement58",61);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement55",61);
                            }
                        }
                        // JavaLine 111 ==> SourceLine 64
                        listingon=(listfile!=(null));
                        // JavaLine 113 ==> SourceLine 68
                        t=getTextInfo(16);
                        // JavaLine 115 ==> SourceLine 69
                        while(TXT$.more(t)) {
                            if(VALUE$((TXT$.getchar(t)==(':')))) {
                                // JavaLine 118 ==> SourceLine 70
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement70",70);
                                    if(VALUE$(TXT$.more(t))) {
                                        feoptions=copy(copy(TXT$.sub(t,TXT$.pos(t),((TXT$.length(t)-(TXT$.pos(t)))+(1)))));
                                    }
                                    // JavaLine 124 ==> SourceLine 71
                                    t=TXT$.sub(t,1,(TXT$.pos(t)-(2)));
                                    GOTO$(SETem); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement70",71);
                                }
                            }
                        }
                        // JavaLine 131 ==> SourceLine 73
                        LABEL$(1,"SETem");
                        new SCANNER$SetSelectors(((PAS1INIT)CUR$),t,0);
                        // JavaLine 134 ==> SourceLine 74
                        while(TXT$.more(feoptions)) {
                            new COMMON$setopt(((PAS1INIT)CUR$),TXT$.getchar(feoptions),'1');
                        }
                        // JavaLine 138 ==> SourceLine 76
                        termstatus='3';
                        // JavaLine 140 ==> SourceLine 77
                        currentpass='1';
                        // JavaLine 142 ==> SourceLine 80
                        leftintbuf=blanks(12);
                        // JavaLine 144 ==> SourceLine 81
                        leftsintbuf=blanks(7);
                        // JavaLine 146 ==> SourceLine 90
                        dummyBox=new COMMON$identsymbol(((PAS1INIT)CUR$)).STM$();
                        // JavaLine 148 ==> SourceLine 92
                        dummyGroup=new COMMON$symbolgroup(((PAS1INIT)CUR$)).STM$();
                        // JavaLine 150 ==> SourceLine 93
                        for(boolean CB$93:new ForList(
                            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(0); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(255); }})
                           )) { if(!CB$93) continue;
                        ((ARRAY$<COMMON$symbolbox[]>)dummyGroup.val).Elt[i-dummyGroup.val.LB[0]]=dummyBox;
                    }
                    // JavaLine 156 ==> SourceLine 94
                    for(boolean CB$94:new ForList(
                        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(0); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(127); }})
                       )) { if(!CB$94) continue;
                    symtab.Elt[i-symtab.LB[0]]=dummyGroup;
                }
                // JavaLine 162 ==> SourceLine 97
                symtab.Elt[0-symtab.LB[0]]=new COMMON$symbolgroup(((PAS1INIT)CUR$)).STM$();
                ((ARRAY$<COMMON$symbolbox[]>)symtab.Elt[0-symtab.LB[0]].val).Elt[0-symtab.Elt[0-symtab.LB[0]].val.LB[0]]=dummyBox;
                // JavaLine 165 ==> SourceLine 98
                for(boolean CB$98:new ForList(
                    new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("boolean")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("character")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("short")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("integer")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("real")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("long")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("ref")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("text")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$(" pointer")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("value")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("label")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("procedure")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("array")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("no type")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("else")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("end")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("eqv")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("external")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("for")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("go")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("goto")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("hidden")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("if")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("imp")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("in")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("inner")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("inspect")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("do")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("is")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("class")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("record")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("begin")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("name")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("new")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("not")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("or")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("otherwise")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("prior")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("delay")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("protected")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("qua")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("reactivate")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("at")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("before")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("and")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("step")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("switch")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("activate")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("then")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("this")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("to")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("until")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("after")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("virtual")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("when")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("while")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("lt")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("eq")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("le")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("gt")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("ne")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("ge")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("comment")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("none")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("notext")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("true")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("false")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("detach")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("printfile")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("infile")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("_errid")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("_text")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("_predefmodule")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("match stat")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$(" record")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("c")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("pascal")); }})
                   ,new SingleElt<TXT$>(new NAME$<TXT$>(){ public TXT$ put(TXT$ x$){simsymbol=(TXT$)x$; return(x$);};  public TXT$ get(){return((TXT$)simsymbol); }	},new NAME$<TXT$>() { public TXT$ get(){return(new TXT$("library")); }})
                   )) { if(!CB$98) continue;
                // JavaLine 246 ==> SourceLine 187
                {
                    TRACE_BEGIN_STM$("CompoundStatement187",187);
                    hashlo=char$(hash(simsymbol));
                    // JavaLine 250 ==> SourceLine 190
                    {
                        // BEGIN INSPECTION 
                        inspect$190$1=new COMMON$identsymbol(((PAS1INIT)CUR$)).STM$();
                        if(inspect$190$1!=null) //INSPECT inspect$190$1
                        // JavaLine 255 ==> SourceLine 191
                        {
                            TRACE_BEGIN_STM$("CompoundStatement191",191);
                            inspect$190$1.symbol=simsymbol;
                            // JavaLine 259 ==> SourceLine 192
                            inspect$190$1.idlo=identlo=char$((rank(identlo)+(1)));
                            // JavaLine 261 ==> SourceLine 193
                            inspect$190$1.next=hashtab.Elt[rank(hashlo)-hashtab.LB[0]];
                            // JavaLine 263 ==> SourceLine 194
                            ((ARRAY$<COMMON$symbolbox[]>)symtab.Elt[0-symtab.LB[0]].val).Elt[rank(identlo)-symtab.Elt[0-symtab.LB[0]].val.LB[0]]=hashtab.Elt[rank(hashlo)-hashtab.LB[0]]=((COMMON$symbolbox)inspect$190$1);
                            TRACE_END_STM$("CompoundStatement191",194);
                        }
                    }
                    TRACE_END_STM$("CompoundStatement187",194);
                }
            }
            // JavaLine 271 ==> SourceLine 206
            i=(rank(identlo)+(1));
            // JavaLine 273 ==> SourceLine 207
            while((i<=(255))) {
                // JavaLine 275 ==> SourceLine 208
                {
                    TRACE_BEGIN_STM$("CompoundStatement208",208);
                    ((ARRAY$<COMMON$symbolbox[]>)symtab.Elt[0-symtab.LB[0]].val).Elt[i-symtab.Elt[0-symtab.LB[0]].val.LB[0]]=dummyBox;
                    i=(i+(1));
                    TRACE_END_STM$("CompoundStatement208",208);
                }
            }
            // JavaLine 283 ==> SourceLine 210
            consthi=((char)128);
            // JavaLine 285 ==> SourceLine 212
            simsymbol=new TXT$("0");
            new COMMON$DEFCONST(((PAS1INIT)CUR$));
            // JavaLine 288 ==> SourceLine 366
            predefname=getTextInfo(19);
            // JavaLine 290 ==> SourceLine 368
            dummygen=false;
            // JavaLine 292 ==> SourceLine 373
            {
                // BEGIN INSPECTION 
                inspect$373$2=new PARSER$grammer(((PAS1INIT)CUR$)).START();
                if(inspect$373$2!=null) //INSPECT inspect$373$2
                // JavaLine 297 ==> SourceLine 375
                {
                    TRACE_BEGIN_STM$("CompoundStatement375",375);
                    parser=((COMMON$component)inspect$373$2);
                    // JavaLine 301 ==> SourceLine 377
                    inspect$373$2.symboltype.Elt[rank(IBOOL)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.declsymbol;
                    // JavaLine 303 ==> SourceLine 378
                    inspect$373$2.symboltype.Elt[rank(ICHAR)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.declsymbol;
                    // JavaLine 305 ==> SourceLine 379
                    inspect$373$2.symboltype.Elt[rank(ISHOR)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.declsymbol;
                    // JavaLine 307 ==> SourceLine 380
                    inspect$373$2.symboltype.Elt[rank(IINTG)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.declsymbol;
                    // JavaLine 309 ==> SourceLine 381
                    inspect$373$2.symboltype.Elt[rank(IREAL)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.declsymbol;
                    // JavaLine 311 ==> SourceLine 382
                    inspect$373$2.symboltype.Elt[rank(ILONG)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.declsymbol;
                    // JavaLine 313 ==> SourceLine 383
                    inspect$373$2.symboltype.Elt[rank(IREF)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.declsymbol;
                    // JavaLine 315 ==> SourceLine 384
                    inspect$373$2.symboltype.Elt[rank(ITEXT)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.declsymbol;
                    // JavaLine 317 ==> SourceLine 385
                    inspect$373$2.symboltype.Elt[rank(IPROC)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.declsymbol;
                    // JavaLine 319 ==> SourceLine 386
                    inspect$373$2.symboltype.Elt[rank(IARRA)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.declsymbol;
                    // JavaLine 321 ==> SourceLine 387
                    inspect$373$2.symboltype.Elt[rank(ICLAS)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.declsymbol;
                    // JavaLine 323 ==> SourceLine 388
                    inspect$373$2.symboltype.Elt[rank(IRCRD)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.declsymbol;
                    // JavaLine 325 ==> SourceLine 389
                    inspect$373$2.symboltype.Elt[rank(ISWIT)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.declsymbol;
                    // JavaLine 327 ==> SourceLine 390
                    inspect$373$2.symboltype.Elt[rank(IEXTR)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.declsymbol;
                    // JavaLine 329 ==> SourceLine 395
                    inspect$373$2.symboltype.Elt[rank(IROPD)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.exprtermin;
                    // JavaLine 331 ==> SourceLine 396
                    inspect$373$2.symboltype.Elt[rank(IAFTR)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.exprtermin;
                    // JavaLine 333 ==> SourceLine 397
                    inspect$373$2.symboltype.Elt[rank(ITHEN)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.exprtermin;
                    // JavaLine 335 ==> SourceLine 398
                    inspect$373$2.symboltype.Elt[rank(IAT)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.exprtermin;
                    // JavaLine 337 ==> SourceLine 399
                    inspect$373$2.symboltype.Elt[rank(IUNTI)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.exprtermin;
                    // JavaLine 339 ==> SourceLine 400
                    inspect$373$2.symboltype.Elt[rank(IBEFO)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.exprtermin;
                    // JavaLine 341 ==> SourceLine 401
                    inspect$373$2.symboltype.Elt[rank(IWHEN)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.exprtermin;
                    // JavaLine 343 ==> SourceLine 402
                    inspect$373$2.symboltype.Elt[rank(IDELA)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.exprtermin;
                    // JavaLine 345 ==> SourceLine 403
                    inspect$373$2.symboltype.Elt[rank(ISMCL)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.exprtermin;
                    // JavaLine 347 ==> SourceLine 404
                    inspect$373$2.symboltype.Elt[rank(IDENO)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.exprtermin;
                    // JavaLine 349 ==> SourceLine 405
                    inspect$373$2.symboltype.Elt[rank(IEOP)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.exprtermin;
                    // JavaLine 351 ==> SourceLine 406
                    inspect$373$2.symboltype.Elt[rank(IDO)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.exprtermin;
                    // JavaLine 353 ==> SourceLine 407
                    inspect$373$2.symboltype.Elt[rank(IEND)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.exprtermin;
                    // JavaLine 355 ==> SourceLine 408
                    inspect$373$2.symboltype.Elt[rank(IELSE)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.exprtermin;
                    // JavaLine 357 ==> SourceLine 409
                    inspect$373$2.symboltype.Elt[rank(IRGPA)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.exprtermin;
                    // JavaLine 359 ==> SourceLine 410
                    inspect$373$2.symboltype.Elt[rank(IOTHW)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.exprtermin;
                    // JavaLine 361 ==> SourceLine 411
                    inspect$373$2.symboltype.Elt[rank(ICOMA)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.exprtermin;
                    // JavaLine 363 ==> SourceLine 412
                    inspect$373$2.symboltype.Elt[rank(IPRIO)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.exprtermin;
                    // JavaLine 365 ==> SourceLine 413
                    inspect$373$2.symboltype.Elt[rank(ICL)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.exprtermin;
                    // JavaLine 367 ==> SourceLine 414
                    inspect$373$2.symboltype.Elt[rank(ISTEP)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.exprtermin;
                    // JavaLine 369 ==> SourceLine 415
                    inspect$373$2.symboltype.Elt[rank(IASSG)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.exprtermin;
                    // JavaLine 371 ==> SourceLine 424
                    inspect$373$2.symboltype.Elt[rank(IPLUS)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.arithop;
                    // JavaLine 373 ==> SourceLine 425
                    inspect$373$2.symboltype.Elt[rank(IPOWE)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.arithop;
                    // JavaLine 375 ==> SourceLine 426
                    inspect$373$2.symboltype.Elt[rank(IMINU)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.arithop;
                    // JavaLine 377 ==> SourceLine 427
                    inspect$373$2.symboltype.Elt[rank(IIDIV)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.arithop;
                    // JavaLine 379 ==> SourceLine 428
                    inspect$373$2.symboltype.Elt[rank(IMULT)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.arithop;
                    // JavaLine 381 ==> SourceLine 429
                    inspect$373$2.symboltype.Elt[rank(ICONC)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.arithop;
                    // JavaLine 383 ==> SourceLine 430
                    inspect$373$2.symboltype.Elt[rank(ISLAS)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.arithop;
                    // JavaLine 385 ==> SourceLine 434
                    inspect$373$2.symboltype.Elt[rank(IEQ)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.relop;
                    // JavaLine 387 ==> SourceLine 435
                    inspect$373$2.symboltype.Elt[rank(ILT)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.relop;
                    // JavaLine 389 ==> SourceLine 436
                    inspect$373$2.symboltype.Elt[rank(IGE)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.relop;
                    // JavaLine 391 ==> SourceLine 437
                    inspect$373$2.symboltype.Elt[rank(INE)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.relop;
                    // JavaLine 393 ==> SourceLine 438
                    inspect$373$2.symboltype.Elt[rank(IGT)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.relop;
                    // JavaLine 395 ==> SourceLine 439
                    inspect$373$2.symboltype.Elt[rank(IRFEQ)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.relop;
                    // JavaLine 397 ==> SourceLine 440
                    inspect$373$2.symboltype.Elt[rank(ILE)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.relop;
                    // JavaLine 399 ==> SourceLine 441
                    inspect$373$2.symboltype.Elt[rank(IRFNE)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.relop;
                    // JavaLine 401 ==> SourceLine 445
                    inspect$373$2.symboltype.Elt[rank(IAND)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.logop;
                    // JavaLine 403 ==> SourceLine 446
                    inspect$373$2.symboltype.Elt[rank(IOR)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.logop;
                    // JavaLine 405 ==> SourceLine 447
                    inspect$373$2.symboltype.Elt[rank(IEQV)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.logop;
                    // JavaLine 407 ==> SourceLine 448
                    inspect$373$2.symboltype.Elt[rank(ICAND)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.logop;
                    // JavaLine 409 ==> SourceLine 449
                    inspect$373$2.symboltype.Elt[rank(IIMP)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.logop;
                    // JavaLine 411 ==> SourceLine 450
                    inspect$373$2.symboltype.Elt[rank(ICOR)-inspect$373$2.symboltype.LB[0]]=inspect$373$2.logop;
                    TRACE_END_STM$("CompoundStatement375",450);
                }
            }
            // JavaLine 416 ==> SourceLine 456
            call(parser);
            // JavaLine 418 ==> SourceLine 462
            {
                // BEGIN INSPECTION 
                inspect$462$3=new SCANNER$recognizer(((PAS1INIT)CUR$)).START();
                if(inspect$462$3!=null) //INSPECT inspect$462$3
                // JavaLine 423 ==> SourceLine 463
                {
                    TRACE_BEGIN_STM$("CompoundStatement463",463);
                    lexScanner=((SCANNER$recognizer)(scanner=((COMMON$component)inspect$462$3)));
                    inspect$462$3.hashbuf=blanks(80);
                    // JavaLine 428 ==> SourceLine 465
                    for(boolean CB$465:new ForList(
                        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){inspect$462$3.i=(int)x$; return(x$);};  public Number get(){return((Number)inspect$462$3.i); }	},new NAME$<Number>() { public Number get(){return(35); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(255); }})
                       )) { if(!CB$465) continue;
                    inspect$462$3.InputClass.Elt[inspect$462$3.i-inspect$462$3.InputClass.LB[0]]=Graphic_cl;
                }
                // JavaLine 434 ==> SourceLine 467
                inspect$462$3.InputClass.Elt[0-inspect$462$3.InputClass.LB[0]]=inspect$462$3.InputClass.Elt[127-inspect$462$3.InputClass.LB[0]]=Skip_cl;
                // JavaLine 436 ==> SourceLine 469
                for(boolean CB$469:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){inspect$462$3.i=(int)x$; return(x$);};  public Number get(){return((Number)inspect$462$3.i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(7); }})
                   )) { if(!CB$469) continue;
                inspect$462$3.InputClass.Elt[inspect$462$3.i-inspect$462$3.InputClass.LB[0]]=Illegal_cl;
            }
            // JavaLine 442 ==> SourceLine 470
            for(boolean CB$470:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){inspect$462$3.i=(int)x$; return(x$);};  public Number get(){return((Number)inspect$462$3.i); }	},new NAME$<Number>() { public Number get(){return(14); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(31); }})
               )) { if(!CB$470) continue;
            inspect$462$3.InputClass.Elt[inspect$462$3.i-inspect$462$3.InputClass.LB[0]]=Illegal_cl;
        }
        // JavaLine 448 ==> SourceLine 472
        for(boolean CB$472:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){inspect$462$3.i=(int)x$; return(x$);};  public Number get(){return((Number)inspect$462$3.i); }	},new NAME$<Number>() { public Number get(){return(8); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(13); }})
           )) { if(!CB$472) continue;
        inspect$462$3.InputClass.Elt[inspect$462$3.i-inspect$462$3.InputClass.LB[0]]=Format_cl;
    }
    // JavaLine 454 ==> SourceLine 473
    inspect$462$3.InputClass.Elt[32-inspect$462$3.InputClass.LB[0]]=Format_cl;
    // JavaLine 456 ==> SourceLine 475
    inspect$462$3.InputClass.Elt[33-inspect$462$3.InputClass.LB[0]]=Exclam_cl;
    // JavaLine 458 ==> SourceLine 477
    inspect$462$3.InputClass.Elt[34-inspect$462$3.InputClass.LB[0]]=Basic_cl;
    // JavaLine 460 ==> SourceLine 478
    for(boolean CB$478:new ForList(
        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){inspect$462$3.i=(int)x$; return(x$);};  public Number get(){return((Number)inspect$462$3.i); }	},new NAME$<Number>() { public Number get(){return(38); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(47); }})
       )) { if(!CB$478) continue;
    inspect$462$3.InputClass.Elt[inspect$462$3.i-inspect$462$3.InputClass.LB[0]]=Basic_cl;
}
// JavaLine 466 ==> SourceLine 479
for(boolean CB$479:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){inspect$462$3.i=(int)x$; return(x$);};  public Number get(){return((Number)inspect$462$3.i); }	},new NAME$<Number>() { public Number get(){return(58); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(62); }})
   )) { if(!CB$479) continue;
inspect$462$3.InputClass.Elt[inspect$462$3.i-inspect$462$3.InputClass.LB[0]]=Basic_cl;
}
// JavaLine 472 ==> SourceLine 481
for(boolean CB$481:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){inspect$462$3.i=(int)x$; return(x$);};  public Number get(){return((Number)inspect$462$3.i); }	},new NAME$<Number>() { public Number get(){return(48); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(57); }})
   )) { if(!CB$481) continue;
inspect$462$3.InputClass.Elt[inspect$462$3.i-inspect$462$3.InputClass.LB[0]]=Digit_cl;
}
// JavaLine 478 ==> SourceLine 483
for(boolean CB$483:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){inspect$462$3.i=(int)x$; return(x$);};  public Number get(){return((Number)inspect$462$3.i); }	},new NAME$<Number>() { public Number get(){return(65); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(90); }})
   )) { if(!CB$483) continue;
inspect$462$3.InputClass.Elt[inspect$462$3.i-inspect$462$3.InputClass.LB[0]]=Letter_cl;
}
// JavaLine 484 ==> SourceLine 484
for(boolean CB$484:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){inspect$462$3.i=(int)x$; return(x$);};  public Number get(){return((Number)inspect$462$3.i); }	},new NAME$<Number>() { public Number get(){return(97); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(122); }})
   )) { if(!CB$484) continue;
inspect$462$3.InputClass.Elt[inspect$462$3.i-inspect$462$3.InputClass.LB[0]]=Letter_cl;
}
// JavaLine 490 ==> SourceLine 486
inspect$462$3.InputClass.Elt[67-inspect$462$3.InputClass.LB[0]]=inspect$462$3.InputClass.Elt[99-inspect$462$3.InputClass.LB[0]]=LetterC_cl;
// JavaLine 492 ==> SourceLine 488
inspect$462$3.InputClass.Elt[95-inspect$462$3.InputClass.LB[0]]=Uscore_cl;
// JavaLine 494 ==> SourceLine 490
inspect$462$3.IdScanner=new SCANNER$recognizer$identifierScanner(inspect$462$3).START();
// JavaLine 496 ==> SourceLine 491
inspect$462$3.unsignedInt=new SCANNER$recognizer$unsignedInteger(inspect$462$3).START();
TRACE_END_STM$("CompoundStatement463",491);
}
}
// JavaLine 501 ==> SourceLine 497
signiflength=255;
// JavaLine 503 ==> SourceLine 498
cursource=new SCANNER$SourceElt(((PAS1INIT)CUR$),false,getTextInfo(1)).START();
// JavaLine 505 ==> SourceLine 499
incrlnr=true;
// JavaLine 507 ==> SourceLine 503
if(VALUE$(TRF_EQ(L2NAME,null))) {
new ERRMSG$openerror(((PAS1INIT)CUR$),new TXT$(" *** SCRATCH FILE (L2) ***"));
}
// JavaLine 511 ==> SourceLine 504
{
// BEGIN INSPECTION 
inspect$504$4=new SCANNER$L2Coder(((PAS1INIT)CUR$),L2NAME).STM$();
if(inspect$504$4!=null) //INSPECT inspect$504$4
// JavaLine 516 ==> SourceLine 505
{
TRACE_BEGIN_STM$("CompoundStatement505",505);
P1coder=((SCANNER$L2Coder)inspect$504$4);
coder=P1coder;
// JavaLine 521 ==> SourceLine 509
brctab.Elt[0-brctab.LB[0]]=new COMMON$brctab2(((PAS1INIT)CUR$)).STM$();
// JavaLine 523 ==> SourceLine 510
if(VALUE$((!((option.Elt[rank('F')-option.LB[0]]!=(NUL)))))) {
// JavaLine 525 ==> SourceLine 511
{
TRACE_BEGIN_STM$("CompoundStatement511",511);
{
// BEGIN INSPECTION 
inspect$511$5=new COMMON$brecord(((PAS1INIT)CUR$)).STM$();
if(inspect$511$5!=null) //INSPECT inspect$511$5
// JavaLine 532 ==> SourceLine 512
{
TRACE_BEGIN_STM$("CompoundStatement512",512);
inspect$511$5.kind=K_extnal;
((ARRAY$<COMMON$brecord[]>)brctab.Elt[0-brctab.LB[0]].val).Elt[0-brctab.Elt[0-brctab.LB[0]].val.LB[0]]=((COMMON$brecord)inspect$511$5);
// JavaLine 537 ==> SourceLine 513
{
    // BEGIN INSPECTION 
    inspect$513$6=new COMMON$quantity(((PAS1INIT)CUR$)).STM$();
    if(inspect$513$6!=null) //INSPECT inspect$513$6
    // JavaLine 542 ==> SourceLine 514
    {
        TRACE_BEGIN_STM$("CompoundStatement514",514);
        inspect$511$5.fpar=((COMMON$quantity)inspect$513$6);
        // JavaLine 546 ==> SourceLine 515
        inspect$513$6.plev=one;
        // JavaLine 548 ==> SourceLine 516
        inspect$513$6.type=INOTY;
        inspect$513$6.kind=K_class;
        // JavaLine 551 ==> SourceLine 517
        inspect$513$6.categ=C_extnal;
        // JavaLine 553 ==> SourceLine 521
        inspect$513$6.symb=new COMMON$boxof(((PAS1INIT)CUR$),NUL,predefindex).RESULT$;
        TRACE_END_STM$("CompoundStatement514",521);
    }
}
TRACE_END_STM$("CompoundStatement512",521);
}
}
TRACE_END_STM$("CompoundStatement511",521);
}
}
// JavaLine 564 ==> SourceLine 528
nextbllo=((char)1);
// JavaLine 566 ==> SourceLine 529
new SCANNER$L2Coder$brecinit(inspect$504$4,K_extnal);
TRACE_END_STM$("CompoundStatement505",529);
}
}
// JavaLine 571 ==> SourceLine 36
if(inner!=null) {
inner.STM$();
TRACE_BEGIN_STM_AFTER_INNER$("PAS1INIT",36);
}
break LOOP$;
}
catch(LABQNT$ q) {
CUR$=THIS$;
if(q.SL$!=CUR$ || q.prefixLevel!=5) {
CUR$.STATE$=OperationalState.terminated;
if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
throw(q);
}
if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
JTX$=q.index; continue LOOP$; // EG. GOTO Lx
}
}
TRACE_END_STM$("PAS1INIT",36);
}
};
} // End of Constructor
// Class Statements
public PAS1INIT STM$() { return((PAS1INIT)CODE$.EXEC$()); }
public PAS1INIT START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("PAS1INIT.DEF","Class PAS1INIT",1,3,12,73,15,31,21,57,23,190,25,373,27,462,29,504,31,511,33,513,49,36,52,40,54,41,56,43,58,44,60,45,62,46,64,47,66,48,69,53,72,54,74,55,79,56,83,57,88,58,93,59,95,60,99,61,111,64,113,68,115,69,118,70,124,71,131,73,134,74,138,76,140,77,142,80,144,81,146,90,148,92,150,93,156,94,162,97,165,98,246,187,250,190,255,191,259,192,261,193,263,194,271,206,273,207,275,208,283,210,285,212,288,366,290,368,292,373,297,375,301,377,303,378,305,379,307,380,309,381,311,382,313,383,315,384,317,385,319,386,321,387,323,388,325,389,327,390,329,395,331,396,333,397,335,398,337,399,339,400,341,401,343,402,345,403,347,404,349,405,351,406,353,407,355,408,357,409,359,410,361,411,363,412,365,413,367,414,369,415,371,424,373,425,375,426,377,427,379,428,381,429,383,430,385,434,387,435,389,436,391,437,393,438,395,439,397,440,399,441,401,445,403,446,405,447,407,448,409,449,411,450,416,456,418,462,423,463,428,465,434,467,436,469,442,470,448,472,454,473,456,475,458,477,460,478,466,479,472,481,478,483,484,484,490,486,492,488,494,490,496,491,501,497,503,498,505,499,507,503,511,504,516,505,521,509,523,510,525,511,532,512,537,513,542,514,546,515,548,516,551,517,553,521,564,528,566,529,571,36,595,533);
}
