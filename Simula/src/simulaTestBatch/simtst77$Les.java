// JavaLine 1 ==> SourceLine 16
package simulaTestBatch;
// Release-Beta-0.3 Compiled at Sat Jan 05 09:02:04 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst77$Les extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=16, lastLine=70, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public int p$n;
    public simtst77$Les p$andre;
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 17
    public ARRAY$<TXT$[]>linjer=null;
    // JavaLine 16 ==> SourceLine 18
    public int lnr=0;
    public int i=0;
    // JavaLine 19 ==> SourceLine 19
    public InFile$ fil=null;
    // Normal Constructor
    public simtst77$Les(RTObject$ staticLink,int sp$n,simtst77$Les sp$andre) {
        super(staticLink);
        // Parameter assignment to locals
        this.p$n = sp$n;
        this.p$andre = sp$andre;
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("Les",44);
        // JavaLine 30 ==> SourceLine 17
        int[] linjer$LB=new int[1]; int[] linjer$UB=new int[1];
        linjer$LB[0]=1; linjer$UB[0]=300;
        BOUND_CHECK$(linjer$LB[0],linjer$UB[0]);
        linjer=new ARRAY$<TXT$[]>(new TXT$[linjer$UB[0]-linjer$LB[0]+1],linjer$LB,linjer$UB);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("Les",17,inner);
                // JavaLine 39 ==> SourceLine 46
                if((p$andre!=(null))) {
                    // JavaLine 41 ==> SourceLine 47
                    p$andre.p$andre=((simtst77$Les)CUR$);
                }
                // JavaLine 44 ==> SourceLine 49
                detach();
                // JavaLine 46 ==> SourceLine 52
                fil=new InFile$(((BASICIO$)CTX$),((simtst77)(CUR$.SL$)).fileName).STM$();
                // JavaLine 48 ==> SourceLine 53
                if((!(fil.open(blanks(30))))) {
                    // JavaLine 50 ==> SourceLine 54
                    error(CONC(new TXT$("Can't open infile: "),((simtst77)(CUR$.SL$)).fileName));
                }
                // JavaLine 53 ==> SourceLine 55
                fil.inrecord();
                // JavaLine 55 ==> SourceLine 57
                while((!(fil.endfile()))) {
                    // JavaLine 57 ==> SourceLine 58
                    {
                        TRACE_BEGIN_STM$("CompoundStatement58",58);
                        i=(p$n+(1));
                        // JavaLine 61 ==> SourceLine 59
                        for(boolean CB$59:new ForList(
                            new WhileElt<Number>(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(i-(1)); }},new NAME$<Boolean>() { public Boolean get(){return(((!(fil.endfile()))&((i>(0))))&((lnr<(301)))); }})
                           )) { if(!CB$59) continue;
                        // JavaLine 65 ==> SourceLine 60
                        {
                            TRACE_BEGIN_STM$("CompoundStatement60",60);
                            lnr=(lnr+(1));
                            linjer.Elt[lnr-linjer.LB[0]]=copy(copy(fil.image));
                            // JavaLine 70 ==> SourceLine 62
                            fil.inrecord();
                            TRACE_END_STM$("CompoundStatement60",62);
                        }
                    }
                    // JavaLine 75 ==> SourceLine 64
                    resume(p$andre);
                    TRACE_END_STM$("CompoundStatement58",64);
                }
            }
            // JavaLine 80 ==> SourceLine 66
            while((!(p$andre.fil.endfile()))) {
                resume(p$andre);
            }
            // JavaLine 84 ==> SourceLine 68
            fil.close();
            p$andre.fil.close();
            // JavaLine 87 ==> SourceLine 69
            new simtst77$Les$Sammenlign(((simtst77$Les)CUR$));
            // JavaLine 89 ==> SourceLine 46
            if(inner!=null) {
                inner.STM$();
                TRACE_BEGIN_STM_AFTER_INNER$("Les",46);
            }
            TRACE_END_STM$("Les",46);
            EBLK(); // Iff no prefix
        }
    };
} // End of Constructor
// Class Statements
public simtst77$Les STM$() { return((simtst77$Les)CODE$.EXEC$()); }
public simtst77$Les START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("simtst77.sim","Class Les",1,16,14,17,16,18,19,19,30,17,39,46,41,47,44,49,46,52,48,53,50,54,53,55,55,57,57,58,61,59,65,60,70,62,75,64,80,66,84,68,87,69,89,46,101,70);
}
