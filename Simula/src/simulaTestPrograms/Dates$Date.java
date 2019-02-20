// JavaLine 1 ==> SourceLine 12
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Dates$Date extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=12, lastLine=215, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$D;
    public int p$M;
    public int p$Y;
    // Declare locals as attributes
    // Normal Constructor
    public Dates$Date(RTObject$ staticLink,int sp$D,int sp$M,int sp$Y) {
        super(staticLink);
        // Parameter assignment to locals
        this.p$D = sp$D;
        this.p$M = sp$M;
        this.p$Y = sp$Y;
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("Date",192);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("Date",192,inner);
                // JavaLine 28 ==> SourceLine 198
                while((p$M<(1))) {
                    // JavaLine 30 ==> SourceLine 199
                    {
                        TRACE_BEGIN_STM$("CompoundStatement199",199);
                        p$M=(p$M+(12));
                        p$Y=(p$Y-(1));
                        TRACE_END_STM$("CompoundStatement199",199);
                    }
                }
                // JavaLine 38 ==> SourceLine 201
                while((p$M>(12))) {
                    // JavaLine 40 ==> SourceLine 202
                    {
                        TRACE_BEGIN_STM$("CompoundStatement202",202);
                        p$M=(p$M-(12));
                        p$Y=(p$Y+(1));
                        TRACE_END_STM$("CompoundStatement202",202);
                    }
                }
                // JavaLine 48 ==> SourceLine 205
                while((p$D<(1))) {
                    // JavaLine 50 ==> SourceLine 206
                    {
                        TRACE_BEGIN_STM$("CompoundStatement206",206);
                        p$M=(p$M-(1));
                        // JavaLine 54 ==> SourceLine 207
                        if(VALUE$((p$M==(0)))) {
                            {
                                TRACE_BEGIN_STM$("CompoundStatement207",207);
                                p$M=12;
                                p$Y=(p$Y-(1));
                                TRACE_END_STM$("CompoundStatement207",207);
                            }
                        }
                        // JavaLine 63 ==> SourceLine 208
                        p$D=(p$D+(new Dates$M_leng(((Dates)(CUR$.SL$)),p$M,p$Y).RESULT$));
                        TRACE_END_STM$("CompoundStatement206",208);
                    }
                }
                // JavaLine 68 ==> SourceLine 210
                while((p$D>(new Dates$M_leng(((Dates)(CUR$.SL$)),p$M,p$Y).RESULT$))) {
                    // JavaLine 70 ==> SourceLine 211
                    {
                        TRACE_BEGIN_STM$("CompoundStatement211",211);
                        p$D=(p$D-(new Dates$M_leng(((Dates)(CUR$.SL$)),p$M,p$Y).RESULT$));
                        // JavaLine 74 ==> SourceLine 212
                        p$M=(p$M+(1));
                        // JavaLine 76 ==> SourceLine 213
                        if(VALUE$((p$M==(13)))) {
                            {
                                TRACE_BEGIN_STM$("CompoundStatement213",213);
                                p$M=1;
                                p$Y=(p$Y+(1));
                                TRACE_END_STM$("CompoundStatement213",213);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement211",213);
                    }
                }
                // JavaLine 88 ==> SourceLine 198
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Date",198);
                }
                TRACE_END_STM$("Date",198);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public Dates$Date STM$() { return((Dates$Date)CODE$.EXEC$()); }
    public Dates$Date START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Class Date",1,12,28,198,30,199,38,201,40,202,48,205,50,206,54,207,63,208,68,210,70,211,74,212,76,213,88,198,100,215);
}
