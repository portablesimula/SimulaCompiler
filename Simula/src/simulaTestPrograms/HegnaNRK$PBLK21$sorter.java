// JavaLine 1 ==> SourceLine 1396
package simulaTestPrograms;
// Release-Beta-0.3 Compiled at Sat Jan 05 17:29:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$sorter extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=1396, lastLine=1438, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public ARRAY$<?> p$tabell;
    public ARRAY$<?> p$key;
    public int p$antall;
    // Declare local labels
    // JavaLine 14 ==> SourceLine 1415
    final LABQNT$ overogut=new LABQNT$(this,0,1); // Local Label #1=overogut
    // JavaLine 16 ==> SourceLine 1425
    final LABQNT$ igjen=new LABQNT$(this,0,2); // Local Label #2=igjen
    // Declare locals as attributes
    // JavaLine 19 ==> SourceLine 1402
    public ARRAY$<int[]>hs=null;
    // JavaLine 21 ==> SourceLine 1403
    int t=0;
    int j=0;
    int h=0;
    int i=0;
    int l=0;
    int h1=0;
    int n=0;
    boolean bool=false;
    // JavaLine 30 ==> SourceLine 1404
    HegnaNRK$PBLK21$verdi k=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$sorter setPar(Object param) {
        //Util.BREAK("CALL HegnaNRK$PBLK21$sorter.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$tabell=arrayValue(param); break;
                case 1: p$key=arrayValue(param); break;
                case 2: p$antall=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public HegnaNRK$PBLK21$sorter(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HegnaNRK$PBLK21$sorter(RTObject$ SL$,ARRAY$<?> sp$tabell,ARRAY$<?> sp$key,int sp$antall) {
        super(SL$);
        // Parameter assignment to locals
        this.p$tabell = sp$tabell;
        this.p$key = sp$key;
        this.p$antall = sp$antall;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("sorter",1404);
        // JavaLine 60 ==> SourceLine 1402
        int[] hs$LB=new int[1]; int[] hs$UB=new int[1];
        hs$LB[0]=1; hs$UB[0]=7;
        BOUND_CHECK$(hs$LB[0],hs$UB[0]);
        hs=new ARRAY$<int[]>(new int[hs$UB[0]-hs$LB[0]+1],hs$LB,hs$UB);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$sorter STM$() {
        TRACE_BEGIN_STM$("sorter",1402);
        HegnaNRK$PBLK21$sorter THIS$=(HegnaNRK$PBLK21$sorter)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 74 ==> SourceLine 1405
                i=1;
                // JavaLine 76 ==> SourceLine 1406
                for(boolean CB$1406:new ForList(
                    new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }})
                   ,new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(4); }})
                   ,new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(13); }})
                   ,new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(40); }})
                   ,new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(121); }})
                   ,new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(364); }})
                   ,new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1093); }})
                   )) { if(!CB$1406) continue;
                // JavaLine 86 ==> SourceLine 1408
                {
                    TRACE_BEGIN_STM$("CompoundStatement1408",1408);
                    hs.Elt[i-hs.LB[0]]=j;
                    // JavaLine 90 ==> SourceLine 1409
                    i=(i+(1));
                    TRACE_END_STM$("CompoundStatement1408",1409);
                }
            }
            // JavaLine 95 ==> SourceLine 1411
            for(boolean CB$1411:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(2); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(7); }})
               )) { if(!CB$1411) continue;
            // JavaLine 99 ==> SourceLine 1412
            if((hs.Elt[i-hs.LB[0]]>(p$antall))) {
                GOTO$(overogut); // GOTO EVALUATED LABEL
            }
        }
        // JavaLine 104 ==> SourceLine 1413
        i=8;
        // JavaLine 106 ==> SourceLine 1415
        LABEL$(1); // overogut
        t=(i-(1));
        // JavaLine 109 ==> SourceLine 1416
        for(boolean CB$1416:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){l=(int)x$; return(x$);};  public Number get(){return((Number)l); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(t); }})
           )) { if(!CB$1416) continue;
        // JavaLine 113 ==> SourceLine 1418
        {
            TRACE_BEGIN_STM$("CompoundStatement1418",1418);
            h=hs.Elt[((t+(1))-(l))-hs.LB[0]];
            // JavaLine 117 ==> SourceLine 1419
            h1=(h+(1));
            // JavaLine 119 ==> SourceLine 1420
            for(boolean CB$1420:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(h1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(p$antall); }})
               )) { if(!CB$1420) continue;
            // JavaLine 123 ==> SourceLine 1422
            {
                TRACE_BEGIN_STM$("CompoundStatement1422",1422);
                i=(j-(h));
                // JavaLine 127 ==> SourceLine 1423
                k=((ARRAY$<HegnaNRK$PBLK21$verdi[]>)p$key).Elt[j-p$key.LB[0]];
                // JavaLine 129 ==> SourceLine 1424
                n=((ARRAY$<int[]>)p$tabell).Elt[j-p$tabell.LB[0]];
                // JavaLine 131 ==> SourceLine 1426
                LABEL$(2); // igjen
                // JavaLine 133 ==> SourceLine 1425
                if((k==(null))) {
                    bool=true;
                } else
                // JavaLine 137 ==> SourceLine 1426
                bool=((boolean)(k.test_verdi_mindre$0().CPF().setPar(new NAME$<HegnaNRK$PBLK21$verdi>(){ public HegnaNRK$PBLK21$verdi get() { return(((ARRAY$<HegnaNRK$PBLK21$verdi[]>)p$key).Elt[i-p$key.LB[0]]); } public HegnaNRK$PBLK21$verdi put(HegnaNRK$PBLK21$verdi x$) { return(((ARRAY$<HegnaNRK$PBLK21$verdi[]>)p$key).Elt[i-p$key.LB[0]]=(HegnaNRK$PBLK21$verdi)x$); } }).ENT$().RESULT$()));
                // JavaLine 139 ==> SourceLine 1427
                if(bool) {
                    // JavaLine 141 ==> SourceLine 1429
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1429",1429);
                        ((ARRAY$<HegnaNRK$PBLK21$verdi[]>)p$key).Elt[(i+(h))-p$key.LB[0]]=((ARRAY$<HegnaNRK$PBLK21$verdi[]>)p$key).Elt[i-p$key.LB[0]];
                        // JavaLine 145 ==> SourceLine 1430
                        ((ARRAY$<int[]>)p$tabell).Elt[(i+(h))-p$tabell.LB[0]]=((ARRAY$<int[]>)p$tabell).Elt[i-p$tabell.LB[0]];
                        // JavaLine 147 ==> SourceLine 1431
                        i=(i-(h));
                        // JavaLine 149 ==> SourceLine 1432
                        if((i>(0))) {
                            GOTO$(igjen); // GOTO EVALUATED LABEL
                        }
                        TRACE_END_STM$("CompoundStatement1429",1432);
                    }
                }
                // JavaLine 156 ==> SourceLine 1434
                ((ARRAY$<HegnaNRK$PBLK21$verdi[]>)p$key).Elt[(i+(h))-p$key.LB[0]]=k;
                // JavaLine 158 ==> SourceLine 1435
                ((ARRAY$<int[]>)p$tabell).Elt[(i+(h))-p$tabell.LB[0]]=n;
                TRACE_END_STM$("CompoundStatement1422",1435);
            }
        }
        TRACE_END_STM$("CompoundStatement1418",1435);
    }
}
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
TRACE_END_STM$("sorter",1435);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure sorter",1,1396,14,1415,16,1425,19,1402,21,1403,30,1404,60,1402,74,1405,76,1406,86,1408,90,1409,95,1411,99,1412,104,1413,106,1415,109,1416,113,1418,117,1419,119,1420,123,1422,127,1423,129,1424,131,1426,133,1425,137,1426,139,1427,141,1429,145,1430,147,1431,149,1432,156,1434,158,1435,182,1438);
}
