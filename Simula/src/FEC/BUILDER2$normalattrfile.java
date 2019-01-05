// JavaLine 1 ==> SourceLine 142
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:59:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class BUILDER2$normalattrfile extends COMMON$attrfile {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=1, firstLine=142, lastLine=770, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 149
    public TXT$ t=null;
    public COMMON$quantity q=null;
    // Normal Constructor
    public BUILDER2$normalattrfile(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("normalattrfile",731);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("normalattrfile",731,inner);
                // JavaLine 25 ==> SourceLine 740
                detach();
                // JavaLine 27 ==> SourceLine 741
                AOF=new OutbyteFile$(((BASICIO$)CTX$),((BUILDER2)(CUR$.SL$)).attrfilename).STM$();
                // JavaLine 29 ==> SourceLine 742
                if((!(AOF.open()))) {
                    new ERRMSG$openerror(((BUILDER2)(CUR$.SL$)),((BUILDER2)(CUR$.SL$)).attrfilename);
                }
                // JavaLine 33 ==> SourceLine 743
                AOF.outbyte(rank(layoutindex));
                // JavaLine 35 ==> SourceLine 745
                sysattrfile=(mainqnt.virtno!=(0));
                // JavaLine 37 ==> SourceLine 746
                if(sysattrfile) {
                    // JavaLine 39 ==> SourceLine 747
                    {
                        TRACE_BEGIN_STM$("CompoundStatement747",747);
                        t=copy(copy(((BUILDER2)(CUR$.SL$)).sportid));
                        ASGSTR$(TXT$.sub(t,11,1),":");
                        TRACE_END_STM$("CompoundStatement747",747);
                    }
                } else
                // JavaLine 47 ==> SourceLine 748
                t=((BUILDER2)(CUR$.SL$)).sportid;
                ASGTXT$(TXT$.sub(attrbuffer,3,12),t);
                p=14;
                // JavaLine 51 ==> SourceLine 750
                new BUILDER2$normalattrfile$puttext(((BUILDER2$normalattrfile)CUR$),((BUILDER2)(CUR$.SL$)).checkcode);
                new BUILDER2$normalattrfile$puttext(((BUILDER2$normalattrfile)CUR$),((BUILDER2)(CUR$.SL$)).moduleident);
                // JavaLine 54 ==> SourceLine 753
                ((BUILDER2)(CUR$.SL$)).nextexttag=0;
                q=((BUILDER2)(CUR$.SL$)).display.Elt[6-((BUILDER2)(CUR$.SL$)).display.LB[0]].fpar;
                // JavaLine 57 ==> SourceLine 754
                while((q!=(null))) {
                    // JavaLine 59 ==> SourceLine 755
                    {
                        TRACE_BEGIN_STM$("CompoundStatement755",755);
                        if(((q.categ==(((BUILDER2)(CUR$.SL$)).C_extnal))&&((IS$(q.descr,COMMON$brecord.class)||((((COMMON$extbrecord)(q.descr)).status==('S'))))))) {
                            // JavaLine 63 ==> SourceLine 758
                            new BUILDER2$normalattrfile$outquantwlist(((BUILDER2$normalattrfile)CUR$),q);
                        }
                        // JavaLine 66 ==> SourceLine 759
                        q=((COMMON$quantity)(q.next));
                        TRACE_END_STM$("CompoundStatement755",759);
                    }
                }
                // JavaLine 71 ==> SourceLine 763
                new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)CUR$),mainKey);
                new BUILDER2$normalattrfile$outquantwlist(((BUILDER2$normalattrfile)CUR$),mainqnt);
                // JavaLine 74 ==> SourceLine 764
                new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)CUR$),mainKey);
                new BUILDER2$normalattrfile$putNumber(((BUILDER2$normalattrfile)CUR$),((BUILDER2)(CUR$.SL$)).nextexttag);
                // JavaLine 77 ==> SourceLine 765
                new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)CUR$),mainKey);
                // JavaLine 79 ==> SourceLine 766
                new BUILDER2$normalattrfile$swapObuffer(((BUILDER2$normalattrfile)CUR$));
                // JavaLine 81 ==> SourceLine 769
                AOF.outtext(((BUILDER2)(CUR$.SL$)).timestamp);
                AOF.close();
                AOF=null;
                // JavaLine 85 ==> SourceLine 740
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("normalattrfile",740);
                }
                TRACE_END_STM$("normalattrfile",740);
            }
        };
    } // End of Constructor
    // Class Statements
    public BUILDER2$normalattrfile STM$() { return((BUILDER2$normalattrfile)CODE$.EXEC$()); }
    public BUILDER2$normalattrfile START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Class normalattrfile",1,142,12,149,25,740,27,741,29,742,33,743,35,745,37,746,39,747,47,748,51,750,54,753,57,754,59,755,63,758,66,759,71,763,74,764,77,765,79,766,81,769,85,740,96,770);
}
