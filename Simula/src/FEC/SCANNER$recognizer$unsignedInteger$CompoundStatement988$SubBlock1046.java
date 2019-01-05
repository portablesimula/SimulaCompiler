// JavaLine 1 ==> SourceLine 1046
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:53 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$recognizer$unsignedInteger$CompoundStatement988$SubBlock1046 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=4, firstLine=1046, lastLine=1079, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    public ARRAY$<int[]>Dec=null;
    // JavaLine 11 ==> SourceLine 1048
    int carry=0;
    int j=0;
    char k=0;
    char N=0;
    // Normal Constructor
    public SCANNER$recognizer$unsignedInteger$CompoundStatement988$SubBlock1046(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock1046",1048);
        // JavaLine 22 ==> SourceLine 1046
        int[] Dec$LB=new int[1]; int[] Dec$UB=new int[1];
        Dec$LB[0]=0; Dec$UB[0]=100;
        BOUND_CHECK$(Dec$LB[0],Dec$UB[0]);
        Dec=new ARRAY$<int[]>(new int[Dec$UB[0]-Dec$LB[0]+1],Dec$LB,Dec$UB);
    } // End of Constructor
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock1046",1046);
        // JavaLine 31 ==> SourceLine 1049
        if((loadChar(((SCANNER$recognizer)(CUR$.SL$.SL$)).hashbuf,(((SCANNER$recognizer)(CUR$.SL$.SL$)).hashpos-(1)))==('R'))) {
            // JavaLine 33 ==> SourceLine 1052
            {
                TRACE_BEGIN_STM$("CompoundStatement1052",1052);
                ((SCANNER$recognizer)(CUR$.SL$.SL$)).hashpos=(((SCANNER$recognizer)(CUR$.SL$.SL$)).hashpos-(1));
                ((SCANNER$recognizer$unsignedInteger)(CUR$.SL$)).radix=((SCANNER$recognizer$unsignedInteger)(CUR$.SL$)).decradix;
                GOTO$(((SCANNER$recognizer$unsignedInteger)(CUR$.SL$)).nterm); // GOTO EVALUATED LABEL
                TRACE_END_STM$("CompoundStatement1052",1052);
            }
        }
        // JavaLine 42 ==> SourceLine 1057
        N=char$(((SCANNER$recognizer)(CUR$.SL$.SL$)).hashpos);
        // JavaLine 44 ==> SourceLine 1058
        ((SCANNER$recognizer)(CUR$.SL$.SL$)).hashpos=(((SCANNER$recognizer$unsignedInteger)(CUR$.SL$)).startpos+((((((SCANNER$recognizer$unsignedInteger)(CUR$.SL$)).radix==(((SCANNER$recognizer$unsignedInteger)(CUR$.SL$)).hexradix)))?(3):(2))));
        // JavaLine 46 ==> SourceLine 1059
        N=char$((rank(N)-(((SCANNER$recognizer)(CUR$.SL$.SL$)).hashpos)));
        ((SCANNER$recognizer$unsignedInteger)(CUR$.SL$)).radix=char$((rank(((SCANNER$recognizer$unsignedInteger)(CUR$.SL$)).radix)-(48)));
        // JavaLine 49 ==> SourceLine 1060
        while((N!=(((SCANNER)(CUR$.SL$.SL$.SL$)).NUL))) {
            {
                TRACE_BEGIN_STM$("CompoundStatement1060",1060);
                N=char$((rank(N)-(1)));
                // JavaLine 54 ==> SourceLine 1061
                carry=(rank(loadChar(((SCANNER$recognizer)(CUR$.SL$.SL$)).hashbuf,((SCANNER$recognizer)(CUR$.SL$.SL$)).hashpos))-(48));
                // JavaLine 56 ==> SourceLine 1062
                if((carry>(9))) {
                    carry=(carry-(7));
                }
                // JavaLine 60 ==> SourceLine 1063
                ((SCANNER$recognizer)(CUR$.SL$.SL$)).hashpos=(((SCANNER$recognizer)(CUR$.SL$.SL$)).hashpos+(1));
                // JavaLine 62 ==> SourceLine 1064
                for(boolean CB$1064:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(0); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(rank(k)); }})
                   )) { if(!CB$1064) continue;
                // JavaLine 66 ==> SourceLine 1065
                {
                    TRACE_BEGIN_STM$("CompoundStatement1065",1065);
                    carry=(carry+((Dec.Elt[j-Dec.LB[0]]*(rank(((SCANNER$recognizer$unsignedInteger)(CUR$.SL$)).radix)))));
                    // JavaLine 70 ==> SourceLine 1066
                    Dec.Elt[j-Dec.LB[0]]=rem(carry,10);
                    carry=(carry/(10));
                    TRACE_END_STM$("CompoundStatement1065",1066);
                }
            }
            // JavaLine 76 ==> SourceLine 1068
            while((carry!=(0))) {
                {
                    TRACE_BEGIN_STM$("CompoundStatement1068",1068);
                    k=char$((rank(k)+(1)));
                    // JavaLine 81 ==> SourceLine 1069
                    Dec.Elt[rank(k)-Dec.LB[0]]=rem(carry,10);
                    carry=(carry/(10));
                    TRACE_END_STM$("CompoundStatement1068",1069);
                }
            }
            TRACE_END_STM$("CompoundStatement1060",1069);
        }
    }
    // JavaLine 90 ==> SourceLine 1072
    ((SCANNER$recognizer)(CUR$.SL$.SL$)).hashpos=((SCANNER$recognizer$unsignedInteger)(CUR$.SL$)).startpos;
    k=char$((rank(k)+(1)));
    // JavaLine 93 ==> SourceLine 1073
    while((k!=(((SCANNER)(CUR$.SL$.SL$.SL$)).NUL))) {
        {
            TRACE_BEGIN_STM$("CompoundStatement1073",1073);
            k=char$((rank(k)-(1)));
            // JavaLine 98 ==> SourceLine 1074
            storeChar(char$((Dec.Elt[rank(k)-Dec.LB[0]]+(48))),((SCANNER$recognizer)(CUR$.SL$.SL$)).hashbuf,((SCANNER$recognizer)(CUR$.SL$.SL$)).hashpos);
            // JavaLine 100 ==> SourceLine 1075
            ((SCANNER$recognizer)(CUR$.SL$.SL$)).hashpos=(((SCANNER$recognizer)(CUR$.SL$.SL$)).hashpos+(1));
            TRACE_END_STM$("CompoundStatement1073",1075);
        }
    }
    TRACE_END_STM$("SubBlock1046",1075);
    EBLK();
    return(null);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","SubBlock SubBlock1046",1,1046,11,1048,22,1046,31,1049,33,1052,42,1057,44,1058,46,1059,49,1060,54,1061,56,1062,60,1063,62,1064,66,1065,70,1066,76,1068,81,1069,90,1072,93,1073,98,1074,100,1075,108,1079);
}
