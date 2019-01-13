// JavaLine 1 ==> SourceLine 742
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$valassign$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=742, lastLine=811, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 797
    COMMON$quantity inspect$797$91=null;
    // Normal Constructor
    public CHECKER1$semchecker1$valassign$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",797);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$valassign$emit STM$() {
        TRACE_BEGIN_STM$("emit",797);
        // JavaLine 25 ==> SourceLine 747
        if((((CHECKER1$semchecker1$valassign)(CUR$.SL$)).type==(((CHECKER1)(CUR$.SL$.SL$.SL$)).ITEXT))) {
            // JavaLine 27 ==> SourceLine 748
            {
                TRACE_BEGIN_STM$("CompoundStatement748",748);
                ((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$target.emit$0().CPF();
                // JavaLine 31 ==> SourceLine 750
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IEXTR;
                // JavaLine 33 ==> SourceLine 751
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opt=(((((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$target.cl==(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl)))?(((CHECKER1)(CUR$.SL$.SL$.SL$)).INOTE):(((CHECKER1)(CUR$.SL$.SL$.SL$)).INOTY));
                // JavaLine 35 ==> SourceLine 752
                if((((CHECKER1$semchecker1$valassign)(CUR$.SL$)).cl==(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl))) {
                    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opilo=((char)1);
                }
                // JavaLine 39 ==> SourceLine 753
                call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                // JavaLine 41 ==> SourceLine 755
                ((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$source.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
                // JavaLine 43 ==> SourceLine 756
                ((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$source.emit$0().CPF();
                // JavaLine 45 ==> SourceLine 758
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IVALU;
                // JavaLine 47 ==> SourceLine 759
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opt=(((((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$target.cl==(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl)))?(((CHECKER1)(CUR$.SL$.SL$.SL$)).INOTE):(((CHECKER1)(CUR$.SL$.SL$.SL$)).INOTY));
                TRACE_END_STM$("CompoundStatement748",759);
            }
        } else
        // JavaLine 52 ==> SourceLine 766
        {
            TRACE_BEGIN_STM$("CompoundStatement766",766);
            // JavaLine 55 ==> SourceLine 767
            if((((((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$source.ctype==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IUPLS))&&((((CHECKER1$semchecker1$operation)(((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$source)).p1$left!=(null))))&&(((boolean)(((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$target.sameAs$0().CPF().setPar(((CHECKER1$semchecker1$operation)(((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$source)).p1$left).ENT$().RESULT$()))))) {
                // JavaLine 57 ==> SourceLine 771
                {
                    TRACE_BEGIN_STM$("CompoundStatement771",771);
                    ((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$target.emit$0().CPF();
                    // JavaLine 61 ==> SourceLine 772
                    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IINSP;
                    call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                    // JavaLine 64 ==> SourceLine 773
                    if((((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$source.type!=(((CHECKER1$semchecker1$operation)(((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$source)).p1$left.type))) {
                        // JavaLine 66 ==> SourceLine 775
                        new CHECKER1$semchecker1$MaybeConvert(((CHECKER1$semchecker1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$source.type,((CHECKER1$semchecker1$operation)(((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$source)).p1$left.type);
                    }
                    // JavaLine 69 ==> SourceLine 776
                    ((CHECKER1$semchecker1$operation)(((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$source)).p1$left=null;
                    // JavaLine 71 ==> SourceLine 777
                    ((CHECKER1$semchecker1$valassign)(CUR$.SL$)).issimple=0;
                    TRACE_END_STM$("CompoundStatement771",777);
                }
            } else
            // JavaLine 76 ==> SourceLine 780
            {
                TRACE_BEGIN_STM$("CompoundStatement780",780);
                if((((CHECKER1$semchecker1$valassign)(CUR$.SL$)).issimple==(0))) {
                    // JavaLine 80 ==> SourceLine 781
                    {
                        TRACE_BEGIN_STM$("CompoundStatement781",781);
                        ((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$target.emit$0().CPF();
                        // JavaLine 84 ==> SourceLine 783
                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ITO;
                        TRACE_END_STM$("CompoundStatement781",783);
                    }
                }
                TRACE_END_STM$("CompoundStatement780",783);
            }
            // JavaLine 91 ==> SourceLine 786
            ((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$source.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
            ((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$source.emit$0().CPF();
            // JavaLine 94 ==> SourceLine 787
            if((((CHECKER1$semchecker1$valassign)(CUR$.SL$)).type!=(((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$source.type))) {
                new CHECKER1$semchecker1$MaybeConvert(((CHECKER1$semchecker1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$valassign)(CUR$.SL$)).type,((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$source.type);
            }
            // JavaLine 98 ==> SourceLine 792
            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opt=((CHECKER1$semchecker1$valassign)(CUR$.SL$)).type;
            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IASSG;
            // JavaLine 101 ==> SourceLine 793
            if((((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$target.ctype==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IIDN))) {
                // JavaLine 103 ==> SourceLine 794
                {
                    TRACE_BEGIN_STM$("CompoundStatement794",794);
                    if(((((CHECKER1$semchecker1$valassign)(CUR$.SL$)).issimple!=(0))&&(IS$(((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$target,CHECKER1$semchecker1$dotIdent.class)))) {
                        // JavaLine 107 ==> SourceLine 795
                        {
                            TRACE_BEGIN_STM$("CompoundStatement795",795);
                            ((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$target.emit$0().CPF();
                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ITO;
                            TRACE_END_STM$("CompoundStatement795",795);
                        }
                    } else
                    // JavaLine 115 ==> SourceLine 797
                    {
                        // BEGIN INSPECTION 
                        inspect$797$91=((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$target.meaning;
                        if(inspect$797$91!=null) //INSPECT inspect$797$91
                        // JavaLine 120 ==> SourceLine 798
                        {
                            TRACE_BEGIN_STM$("CompoundStatement798",798);
                            ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((COMMON$quantity)inspect$797$91);
                            // JavaLine 124 ==> SourceLine 799
                            if((inspect$797$91.categ==(((CHECKER1)(CUR$.SL$.SL$.SL$)).C_virt))) {
                                ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=inspect$797$91.match;
                            }
                            // JavaLine 128 ==> SourceLine 800
                            if((((CHECKER1$semchecker1$valassign)(CUR$.SL$)).issimple!=(0))) {
                                // JavaLine 130 ==> SourceLine 801
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement801",801);
                                    if((inspect$797$91.kind==(((CHECKER1)(CUR$.SL$.SL$.SL$)).K_proc))) {
                                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IDCLC;
                                    } else
                                    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ISIMU;
                                    TRACE_END_STM$("CompoundStatement801",801);
                                }
                            } else
                            // JavaLine 140 ==> SourceLine 802
                            if((inspect$797$91.categ==(((CHECKER1)(CUR$.SL$.SL$.SL$)).C_name))) {
                                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).INAME;
                            }
                            TRACE_END_STM$("CompoundStatement798",802);
                        }
                    }
                    TRACE_END_STM$("CompoundStatement794",802);
                }
            }
            TRACE_END_STM$("CompoundStatement766",802);
        }
        // JavaLine 152 ==> SourceLine 806
        if((((CHECKER1$semchecker1$valassign)(CUR$.SL$)).cl==(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl))) {
            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opilo=((char)1);
        }
        // JavaLine 156 ==> SourceLine 807
        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
        // JavaLine 158 ==> SourceLine 808
        ((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$target=((CHECKER1$semchecker1$valassign)(CUR$.SL$)).p1$source=null;
        // JavaLine 160 ==> SourceLine 809
        ((CHECKER1$semchecker1$valassign)(CUR$.SL$)).qual=((CHECKER1$semchecker1$valassign)(CUR$.SL$)).meaning=null;
        // JavaLine 162 ==> SourceLine 810
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).valassList=((CHECKER1$semchecker1$valassign)(CUR$.SL$));
        TRACE_END_STM$("emit",810);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,742,11,797,25,747,27,748,31,750,33,751,35,752,39,753,41,755,43,756,45,758,47,759,52,766,55,767,57,771,61,772,64,773,66,775,69,776,71,777,76,780,80,781,84,783,91,786,94,787,98,792,101,793,103,794,107,795,115,797,120,798,124,799,128,800,130,801,140,802,152,806,156,807,158,808,160,809,162,810,167,811);
}
