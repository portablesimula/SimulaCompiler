// JavaLine 1 ==> SourceLine 279
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$refrel$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=279, lastLine=309, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 282
    CHECKER1$semchecker1$exp inspect$282$0=null;
    // JavaLine 13 ==> SourceLine 300
    CHECKER1$semchecker1$exp inspect$300$1=null;
    // Normal Constructor
    public CHECKER1$semchecker1$refrel$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",300);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$refrel$emit STM$() {
        TRACE_BEGIN_STM$("emit",300);
        // JavaLine 27 ==> SourceLine 281
        ((CHECKER1$semchecker1$refrel)(CUR$.SL$)).p1$right.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
        // JavaLine 29 ==> SourceLine 282
        {
            // BEGIN INSPECTION 
            inspect$282$0=((CHECKER1$semchecker1$refrel)(CUR$.SL$)).p1$left;
            if(inspect$282$0!=null) //INSPECT inspect$282$0
            // JavaLine 34 ==> SourceLine 283
            {
                TRACE_BEGIN_STM$("CompoundStatement283",283);
                inspect$282$0.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
                // JavaLine 38 ==> SourceLine 284
                if(VALUE$((((CHECKER1$semchecker1$refrel)(CUR$.SL$)).opttype==(((CHECKER1)(CUR$.SL$.SL$.SL$)).ITEXT)))) {
                    // JavaLine 40 ==> SourceLine 286
                    {
                        TRACE_BEGIN_STM$("CompoundStatement286",286);
                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1$semchecker1$refrel)(CUR$.SL$)).p$ch;
                        // JavaLine 44 ==> SourceLine 287
                        inspect$282$0.emit$0().CPF();
                        // JavaLine 46 ==> SourceLine 289
                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IVSPC;
                        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                        // JavaLine 49 ==> SourceLine 290
                        ((CHECKER1$semchecker1$refrel)(CUR$.SL$)).p1$right.emit$0().CPF();
                        // JavaLine 51 ==> SourceLine 291
                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IPSPC;
                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opihi=((CHECKER1$semchecker1$refrel)(CUR$.SL$)).p$ch;
                        TRACE_END_STM$("CompoundStatement286",291);
                    }
                } else
                // JavaLine 57 ==> SourceLine 294
                {
                    TRACE_BEGIN_STM$("CompoundStatement294",294);
                    inspect$282$0.emit$0().CPF();
                    // JavaLine 61 ==> SourceLine 295
                    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1$semchecker1$refrel)(CUR$.SL$)).p$ch;
                    // JavaLine 63 ==> SourceLine 296
                    ((CHECKER1$semchecker1$refrel)(CUR$.SL$)).p1$right.emit$0().CPF();
                    // JavaLine 65 ==> SourceLine 297
                    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1$semchecker1$refrel)(CUR$.SL$)).p$ch;
                    TRACE_END_STM$("CompoundStatement294",297);
                }
                TRACE_END_STM$("CompoundStatement283",297);
            }
            else // OTHERWISE 
            // JavaLine 72 ==> SourceLine 300
            {
                // BEGIN INSPECTION 
                inspect$300$1=((CHECKER1$semchecker1$refrel)(CUR$.SL$)).p1$right;
                if(inspect$300$1!=null) //INSPECT inspect$300$1
                // JavaLine 77 ==> SourceLine 301
                {
                    TRACE_BEGIN_STM$("CompoundStatement301",301);
                    if(VALUE$(((inspect$300$1.p$ch==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IIDN))||((inspect$300$1.p$ch==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IIDNP)))))) {
                        // JavaLine 81 ==> SourceLine 302
                        inspect$300$1.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).ITEXTcl;
                    }
                    // JavaLine 84 ==> SourceLine 303
                    inspect$300$1.emit$0().CPF();
                    // JavaLine 86 ==> SourceLine 304
                    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).optx=(((inspect$300$1.cl==(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).ITEXTcl)))?(((char)1)):(((CHECKER1)(CUR$.SL$.SL$.SL$)).NUL));
                    // JavaLine 88 ==> SourceLine 305
                    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IGO;
                    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opihi=((CHECKER1$semchecker1$refrel)(CUR$.SL$)).p$ch;
                    TRACE_END_STM$("CompoundStatement301",305);
                }
            }
        }
        // JavaLine 95 ==> SourceLine 308
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opilo=((CHECKER1$semchecker1$refrel)(CUR$.SL$)).cl;
        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
        TRACE_END_STM$("emit",308);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,279,11,282,13,300,27,281,29,282,34,283,38,284,40,286,44,287,46,289,49,290,51,291,57,294,61,295,63,296,65,297,72,300,77,301,81,302,84,303,86,304,88,305,95,308,101,309);
}
