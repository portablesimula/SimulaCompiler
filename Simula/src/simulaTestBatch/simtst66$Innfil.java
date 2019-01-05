// JavaLine 1 ==> SourceLine 15
package simulaTestBatch;
// Release-Beta-0.3 Compiled at Sat Jan 05 09:00:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst66$Innfil extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=15, lastLine=66, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public simtst66$Innfil p$neste;
    public TXT$ p$navn;
    public int p$a;
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 21
    public InFile$ fil=null;
    // JavaLine 17 ==> SourceLine 22
    public int lnr=0;
    // JavaLine 19 ==> SourceLine 23
    public ARRAY$<TXT$[]>linjer=null;
    // Normal Constructor
    public simtst66$Innfil(RTObject$ staticLink,simtst66$Innfil sp$neste,TXT$ sp$navn,int sp$a) {
        super(staticLink);
        // Parameter assignment to locals
        this.p$neste = sp$neste;
        this.p$navn = sp$navn;
        this.p$a = sp$a;
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("Innfil",32);
        // JavaLine 31 ==> SourceLine 23
        int[] linjer$LB=new int[1]; int[] linjer$UB=new int[1];
        linjer$LB[0]=1; linjer$UB[0]=200;
        BOUND_CHECK$(linjer$LB[0],linjer$UB[0]);
        linjer=new ARRAY$<TXT$[]>(new TXT$[linjer$UB[0]-linjer$LB[0]+1],linjer$LB,linjer$UB);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("Innfil",23,inner);
                // JavaLine 40 ==> SourceLine 37
                fil=new InFile$(((BASICIO$)CTX$),p$navn).STM$();
                // JavaLine 42 ==> SourceLine 38
                if((!(fil.open(blanks(100))))) {
                    // JavaLine 44 ==> SourceLine 39
                    {
                        TRACE_BEGIN_STM$("CompoundStatement39",39);
                        sysout().outtext(new TXT$("The file does not exist,"));
                        // JavaLine 48 ==> SourceLine 40
                        sysout().outtext(new TXT$("or cannot be opened as infile."));
                        sysout().outimage();
                        // JavaLine 51 ==> SourceLine 42
                        error(CONC(new TXT$("Can't open infile: "),p$navn));
                        TRACE_END_STM$("CompoundStatement39",42);
                    }
                }
                // JavaLine 56 ==> SourceLine 45
                new simtst66$Innfil$trace(((simtst66$Innfil)CUR$),new TXT$("RETT FØR FØRSTE DETACH I INFILE: "));
                // JavaLine 58 ==> SourceLine 46
                detach();
                // JavaLine 60 ==> SourceLine 48
                new simtst66$Innfil$trace(((simtst66$Innfil)CUR$),new TXT$("RETT FØR FØRSTE INIMAGE I INFILE: "));
                // JavaLine 62 ==> SourceLine 49
                fil.inimage();
                // JavaLine 64 ==> SourceLine 50
                new simtst66$Innfil$trace(((simtst66$Innfil)CUR$),CONC(CONC(new TXT$("RETT ETTER FØRSTE INIMAGE("),copy(copy(fil.image))),new TXT$(") I INFILE: ")));
                // JavaLine 66 ==> SourceLine 52
                while((!(fil.endfile()))) {
                    // JavaLine 68 ==> SourceLine 54
                    {
                        TRACE_BEGIN_STM$("CompoundStatement54",54);
                        for(boolean CB$54:new ForList(
                            new WhileElt<Number>(new NAME$<Number>(){ public Number put(Number x$){lnr=(int)x$; return(x$);};  public Number get(){return((Number)lnr); }	},new NAME$<Number>() { public Number get(){return(lnr+(1)); }},new NAME$<Boolean>() { public Boolean get(){return((!(fil.endfile()))&((lnr<(201)))); }})
                           )) { if(!CB$54) continue;
                        // JavaLine 74 ==> SourceLine 56
                        {
                            TRACE_BEGIN_STM$("CompoundStatement56",56);
                            linjer.Elt[lnr-linjer.LB[0]]=copy(copy(fil.image));
                            // JavaLine 78 ==> SourceLine 57
                            fil.inimage();
                            // JavaLine 80 ==> SourceLine 58
                            new simtst66$Innfil$trace(((simtst66$Innfil)CUR$),CONC(CONC(new TXT$("RETT ETTER NESTE INIMAGE("),copy(copy(fil.image))),new TXT$(") I INFILE: ")));
                            TRACE_END_STM$("CompoundStatement56",58);
                        }
                    }
                    // JavaLine 85 ==> SourceLine 62
                    resume(p$neste);
                    TRACE_END_STM$("CompoundStatement54",62);
                }
            }
            // JavaLine 90 ==> SourceLine 64
            while((!(p$neste.fil.endfile()))) {
                resume(p$neste);
            }
            // JavaLine 94 ==> SourceLine 37
            if(inner!=null) {
                inner.STM$();
                TRACE_BEGIN_STM_AFTER_INNER$("Innfil",37);
            }
            TRACE_END_STM$("Innfil",37);
            EBLK(); // Iff no prefix
        }
    };
} // End of Constructor
// Class Statements
public simtst66$Innfil STM$() { return((simtst66$Innfil)CODE$.EXEC$()); }
public simtst66$Innfil START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("simtst66.sim","Class Innfil",1,15,15,21,17,22,19,23,31,23,40,37,42,38,44,39,48,40,51,42,56,45,58,46,60,48,62,49,64,50,66,52,68,54,74,56,78,57,80,58,85,62,90,64,94,37,106,66);
}
