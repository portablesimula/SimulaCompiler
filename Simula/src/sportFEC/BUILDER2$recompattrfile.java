// JavaLine 1 ==> SourceLine 774
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:07 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class BUILDER2$recompattrfile extends COMMON$attrfile {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=1, firstLine=774, lastLine=971, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 940
    public COMMON$quantity q=null;
    // Normal Constructor
    public BUILDER2$recompattrfile(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("recompattrfile",940);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("recompattrfile",940,inner);
                // JavaLine 24 ==> SourceLine 942
                detach();
                attrbuffer=((BUILDER2)(CUR$.SL$)).Afile.attrbuffer;
                // JavaLine 27 ==> SourceLine 943
                new COMMON$attrfile$openattributefile(((BUILDER2$recompattrfile)CUR$),null);
                // JavaLine 29 ==> SourceLine 944
                if(VALUE$(TXTREL$NE(((BUILDER2)(CUR$.SL$)).simsymbol,((BUILDER2)(CUR$.SL$)).moduleident))) {
                    // JavaLine 31 ==> SourceLine 945
                    new ERRMSG$error2(((BUILDER2)(CUR$.SL$)),401,((BUILDER2)(CUR$.SL$)).simsymbol,((BUILDER2)(CUR$.SL$)).moduleident);
                }
                // JavaLine 34 ==> SourceLine 948
                if(VALUE$(sysattrfile)) {
                    new COMMON$attrfile$wrongLayout(((BUILDER2$recompattrfile)CUR$));
                }
                // JavaLine 38 ==> SourceLine 950
                new COMMON$attrfile$nextKey(((BUILDER2$recompattrfile)CUR$));
                // JavaLine 40 ==> SourceLine 951
                ((BUILDER2)(CUR$.SL$)).nextexttag=0;
                q=((BUILDER2)(CUR$.SL$)).display.Elt[6-((BUILDER2)(CUR$.SL$)).display.LB[0]].fpar;
                // JavaLine 43 ==> SourceLine 952
                while((q!=(null))) {
                    // JavaLine 45 ==> SourceLine 953
                    {
                        TRACE_BEGIN_STM$("CompoundStatement953",953);
                        if(VALUE$(((q.categ==(((BUILDER2)(CUR$.SL$)).C_extnal))&&((IS$(q.descr,COMMON$brecord.class)||((((COMMON$extbrecord)(q.descr)).status==('S')))))))) {
                            // JavaLine 49 ==> SourceLine 956
                            new BUILDER2$recompattrfile$outquantwlist(((BUILDER2$recompattrfile)CUR$),q);
                        }
                        // JavaLine 52 ==> SourceLine 957
                        q=((COMMON$quantity)(q.next));
                        TRACE_END_STM$("CompoundStatement953",957);
                    }
                }
                // JavaLine 57 ==> SourceLine 961
                if(VALUE$((key!=(mainKey)))) {
                    new COMMON$attrfile$wrongLayout(((BUILDER2$recompattrfile)CUR$));
                }
                // JavaLine 61 ==> SourceLine 962
                new COMMON$attrfile$nextKey(((BUILDER2$recompattrfile)CUR$));
                new BUILDER2$recompattrfile$outquantwlist(((BUILDER2$recompattrfile)CUR$),mainqnt);
                // JavaLine 64 ==> SourceLine 965
                if(VALUE$(((key!=(mainKey))||((new COMMON$attrfile$nextNumber(((BUILDER2$recompattrfile)CUR$)).RESULT$!=(((BUILDER2)(CUR$.SL$)).nextexttag)))))) {
                    // JavaLine 66 ==> SourceLine 966
                    new COMMON$attrfile$wrongLayout(((BUILDER2$recompattrfile)CUR$));
                }
                // JavaLine 69 ==> SourceLine 969
                CURF.close();
                CURF=null;
                // JavaLine 72 ==> SourceLine 942
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("recompattrfile",942);
                }
                TRACE_END_STM$("recompattrfile",942);
            }
        };
    } // End of Constructor
    // Class Statements
    public BUILDER2$recompattrfile STM$() { return((BUILDER2$recompattrfile)CODE$.EXEC$()); }
    public BUILDER2$recompattrfile START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Class recompattrfile",1,774,12,940,24,942,27,943,29,944,31,945,34,948,38,950,40,951,43,952,45,953,49,956,52,957,57,961,61,962,64,965,66,966,69,969,72,942,83,971);
}
