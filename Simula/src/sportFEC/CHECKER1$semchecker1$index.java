// JavaLine 1 ==> SourceLine 2135
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$index extends CHECKER1$semchecker1$argument {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=1, firstLine=2135, lastLine=2166, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    // Declare locals as attributes
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$index$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$index(RTObject$ staticLink,int sp$argno,CHECKER1$semchecker1$exp sp$actual) {
        super(staticLink,sp$argno,sp$actual);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("index",2150);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("index",2150,inner);
                // JavaLine 22 ==> SourceLine 2157
                switch(p$actual.type) { // BEGIN SWITCH STATEMENT
                case 1: 
                case 7: 
                case 9: 
                case 8: 
                case 14: 
                // JavaLine 29 ==> SourceLine 2160
                new CHECKER1$semchecker1$argument$errARG(((CHECKER1$semchecker1$index)CUR$),419);
            } // END SWITCH STATEMENT
            // JavaLine 32 ==> SourceLine 2163
            if((p$actual.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN))) {
                // JavaLine 34 ==> SourceLine 2164
                new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p$actual)));
            }
            // JavaLine 37 ==> SourceLine 2157
            if(inner!=null) {
                inner.STM$();
                TRACE_BEGIN_STM_AFTER_INNER$("index",2157);
            }
            TRACE_END_STM$("index",2157);
        }
    };
} // End of Constructor
// Class Statements
public CHECKER1$semchecker1$index STM$() { return((CHECKER1$semchecker1$index)CODE$.EXEC$()); }
public CHECKER1$semchecker1$index START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class index",1,2135,22,2157,29,2160,32,2163,34,2164,37,2157,48,2166);
}
